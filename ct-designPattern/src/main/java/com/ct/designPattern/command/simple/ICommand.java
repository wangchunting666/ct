package com.ct.designPattern.command.simple;

/**
 * Created by dell on 2018/5/6.
 */
interface ICommand {
    public void sweep();
}

class Student{
    public void sweeping(){
        System.out.println("we are sweeping the floor");
    }
}

class Teacher implements ICommand{
    private Student receiver = null;
    public Teacher(Student receiver){
        this.receiver = receiver;
    }
    @Override
    public void sweep() {
        receiver.sweeping();
    }
}

class Invoke{
    private ICommand commond;
    public Invoke(ICommand commond){
        this.commond = commond;
    }
    public void execute(){
        commond.sweep();
    }

    public static void main(String[] args) {
        Student student = new Student();
        Teacher teacher = new Teacher(student);
        Invoke invoke = new Invoke(teacher);
        invoke.execute();
    }
}