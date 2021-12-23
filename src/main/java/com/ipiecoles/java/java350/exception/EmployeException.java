package com.ipiecoles.java.java350.exception;

public class EmployeException extends Exception {
    public EmployeException(String s) {
        super(s);
        System.out.println("karam" + s);

    }
}