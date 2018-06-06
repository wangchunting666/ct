package com.ct.supervene.simulation;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Herdsric-M-003 on 2018/6/4.
 */
public class CustomerLine extends ArrayBlockingQueue<Customer>{
    public CustomerLine(int capacity) {
        super(capacity);
    }
    @Override
    public String toString() {
        if(this.size() == 0) return "[Empty]";
        StringBuilder builder = new StringBuilder();
        for(Customer ct:this){
            builder.append(ct);
        }
        return builder.toString();
    }
}

class CustomerGenerator implements Runnable{
    private CustomerLine customers;
    private Random random = new Random();
    public CustomerGenerator(CustomerLine customers){
        this.customers = customers;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(random.nextInt(300));
                customers.put(new Customer(random.nextInt(1000)));
            }
        }catch (InterruptedException e){
            System.out.println("CustomerGenerator Interrupted");
        }
        System.out.println("CustomerGenerator Terminating");
    }
}

class Teller implements Runnable,Comparable<Teller>{
    private static int counter = 0;
    private final int id = counter++;
    private int customersServed = 0;
    private CustomerLine customers;
    private boolean servingCustomerLine = true;
    public Teller(CustomerLine customers){
        this.customers = customers;
    }
    @Override
    public synchronized int compareTo(Teller o) {
        return customersServed < o.customersServed ? -1:(customersServed == o.customersServed ? 0:1);
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                Customer customer = customers.take();
                TimeUnit.MILLISECONDS.sleep(customer.getServiceTime());
                synchronized (this){
                    customersServed++;
                    while (!servingCustomerLine){
                        wait();
                    }
                }
            }
        }catch (InterruptedException e){
            System.out.println(this+" interrupted");
        }
        System.out.println(this+" terminating");
    }
    public synchronized void doSomethingElse(){
        customersServed = 0;
        servingCustomerLine = false;
    }
    public synchronized void serveCustmerLine(){
        assert !servingCustomerLine:"already serving:"+this;
        servingCustomerLine = true;
        notifyAll();
    }

    @Override
    public String toString() {
        return "Teller "+id+" ";
    }

    public String shortString(){
        return "T "+id;
    }
}

class TellerManager implements Runnable{
    private ExecutorService exec;
    private CustomerLine customers;
    private PriorityQueue<Teller> workingTellers = new PriorityQueue<>();
    private Queue<Teller> tellersDoingOtherThings = new LinkedList<>();
    private int adjustmentPeriod;
    private Random random = new Random();
    public TellerManager(ExecutorService exec,CustomerLine customers,int adjustmentPeriod){
        this.exec = exec;
        this.customers = customers;
        this.adjustmentPeriod = adjustmentPeriod;
        Teller teller = new Teller(customers);
        exec.execute(teller);
        workingTellers.add(teller);
    }
    public void reassignOneTeller(){
        Teller teller = workingTellers.poll();
        teller.doSomethingElse();
        tellersDoingOtherThings.add(teller);
    }
    public void adjustTellerNumber(){
        if(customers.size()/workingTellers.size() > 2){
            if(tellersDoingOtherThings.size() > 0){
                Teller teller = tellersDoingOtherThings.remove();
                teller.serveCustmerLine();
                workingTellers.offer(teller);
                return;
            }
            Teller teller = new Teller(customers);
            exec.execute(teller);
            workingTellers.add(teller);
            return;
        }
        if(workingTellers.size() > 1 && customers.size()/workingTellers.size() < 2){
            reassignOneTeller();
        }
        if(customers.size() == 0){
            while (workingTellers.size() > 0) reassignOneTeller();
        }
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(adjustmentPeriod);
                adjustTellerNumber();
                System.out.println(customers + " { ");
                for (Teller teller:workingTellers){
                    System.out.print(teller.shortString() + " ");
                }
                System.out.println(" } ");
            }
        }catch (InterruptedException e){
            System.out.println(this+" interrupted");
        }
        System.out.println(this+" terminating");
    }

    @Override
    public String toString() {
        return "TellerManager";
    }
}

