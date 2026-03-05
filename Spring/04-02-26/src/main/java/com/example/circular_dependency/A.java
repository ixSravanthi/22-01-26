package com.example.circular_dependency;

import org.springframework.beans.factory.annotation.Autowired;

public class A {
    public B b;
//    public A(B b){
//        this.b=b;
//    }
    @Autowired
    public void B_setter(B b){
        this.b=b;
        System.out.println("B initialised in class A");
    }
}
