package com.saibo.it.rpn;

import java.util.Scanner;

public class RpnInput {
    public static void main(String[] args) {
        RPNCalculator rpnCalculator = new RPNCalculator();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            StringBuilder input = new StringBuilder();
            input.append(in.nextLine());
            try {
                rpnCalculator.calculate(input.toString());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
