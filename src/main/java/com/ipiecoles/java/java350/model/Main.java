package com.ipiecoles.java.java350.model;

public class Main {
    public void main(){
        Employe jeremy = new Employe();
        jeremy.setSalaire(1000.0);
         System.out.println(jeremy.getSalaire());
        jeremy.augmenterSalaire(5.0);
        System.out.println(jeremy.getSalaire());
    }
}
