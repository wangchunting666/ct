package com.ct.designPattern.visitor.bank;

import java.util.Vector;

/**
 * Created by dell on 2018/5/6.
 */
interface IVisitor<T> {
    void visit(T s);
}
abstract class Sheet{
    String account;
    String name;
    float money;
    String startDate;
    int range;
    public Sheet(String account,String name,float money,String startDate,int range){
        this.account = account;
        this.name = name;
        this.money = money;
        this.startDate = startDate;
        this.range = range;
    }
    public void accept(IVisitor<Sheet> v){
        v.visit(this);
    }
}

class ABCSheet extends Sheet{
    public ABCSheet(String account, String name, float money, String startDate, int range) {
        super(account, name, money, startDate, range);
    }
}

class ICBCSheet extends Sheet{
    public ICBCSheet(String account, String name, float money, String startDate, int range) {
        super(account, name, money, startDate, range);
    }
}

abstract class Bank{
    public void accept(IVisitor<Bank> v){
        v.visit(this);
    }
    public abstract void process(IVisitor<Sheet> t);
}

class ABCBank extends Bank{
    Vector<ABCSheet> vector = new Vector<>();
    void add(ABCSheet abcSheet){
        vector.add(abcSheet);
    }
    @Override
    public void process(IVisitor<Sheet> t) {
        for (int i=0; i<vector.size(); i++){
            vector.get(i).accept(t);
        }
    }
}

class ICBCBank extends Bank{
    Vector<ICBCSheet> vector = new Vector<>();
    void add(ICBCSheet icbcBank){
        vector.add(icbcBank);
    }
    @Override
    public void process(IVisitor<Sheet> t) {
        for (int i=0; i<vector.size(); i++){
            vector.get(i).accept(t);
        }
    }
}

class BankGroup{
    Vector<Bank> v = new Vector<>();
    void add(Bank bank){
        v.add(bank);
    }
    public void accept(IVisitor<BankGroup> v){
        v.visit(this);
    }
    public void process(IVisitor<Bank> b){
        for (int i=0; i<v.size(); i++){
            v.get(i).accept(b);
        }
    }
}

class SheetVisitor implements IVisitor<Sheet>{
    private void ABCProc(ABCSheet sheet){
        System.out.println("ABCSheet process");
    }
    private void ICBCProc(ICBCSheet sheet){
        System.out.println("ICBCSheet process");
    }
    @Override
    public void visit(Sheet s) {
        if(s instanceof ABCSheet) {
            ABCProc((ABCSheet)s);
        }
        if(s instanceof ICBCSheet) {
            ICBCProc((ICBCSheet)s);
        }
    }
}

class BankVistor implements IVisitor<Bank>{
    private void ABCProc(ABCBank bank){
        System.out.println("ABCBank process");
    }
    private void ICBCProc(ICBCBank bank){
        System.out.println("ICBCBank processs");
    }
    @Override
    public void visit(Bank s) {
        if(s instanceof ABCBank) ABCProc((ABCBank) s);
        if(s instanceof ICBCBank) ICBCProc((ICBCBank) s);
    }
}