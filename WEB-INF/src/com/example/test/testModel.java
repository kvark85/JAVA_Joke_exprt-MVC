package com.example.test;

import com.example.model.JokeExpert;

public class testModel {
    public static void main(String[] args) {

        String firstArgument;
        try {
            firstArgument = args[0];
        } catch (Throwable e) {
            System.out.println("You forgot argument");
            System.out.println("Exeption = " + e);
            firstArgument = "1";
        }

        String brandList = JokeExpert.getJoke(firstArgument);

        System.out.println(brandList);
    }
}