package com.ibm.fp.interfaces.lambda;

interface Greeter {
    //only one abstract
    void sayGreet();
}
public class LambdaMain {
    public static void main(String[] args) {
        Greeter greeter = null;
        
        //inner class way of creating greeter
        greeter = new Greeter() {
            @Override
            public void sayGreet() {
                System.out.println("inner class version");
            }
        };
        greeter.sayGreet();
        
        //lambda way of creating greeter
        greeter = () -> {
            System.out.println("Lambda  class version");
        };
        greeter.sayGreet();



    }
}
