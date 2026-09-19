package model;

public abstract class Person {  //Abstract Class
    protected String name;
    protected int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public abstract void display();
    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }
}
