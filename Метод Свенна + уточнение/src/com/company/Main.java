package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Svenna svenna = new Svenna(Double.parseDouble(reader.readLine()),Double.parseDouble(reader.readLine()));
        svenna.calculate();
        System.out.println("a = " + svenna.getA());
        System.out.println("b = " + svenna.getB());
        System.out.println("Метод золотого сечения = " + svenna.Gold());
        System.out.println("Половинное деление : " + svenna.Pol());
    }
}
