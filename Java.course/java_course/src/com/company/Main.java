package com.company;
import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
	// write your code here
        Scanner input=new Scanner(System.in);
        int number = (int) (Math.random() * 100);
        int guess;// 用户猜的数字
        int count = 0;
        System.out.println(number);
    }
}
