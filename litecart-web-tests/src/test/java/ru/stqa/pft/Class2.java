package ru.stqa.pft;

class A{
    public void doIt(){
        System.out.println("A");
    }
}

class B {
    public void doIt(){
        System.out.println("B");
    }
}

class Runner{
    public static void main(String[] args) {
        A a = new A();
        a.doIt();
    }
}
