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
        System.out.println("1-100随机数，请输入心中的数字");
        do {
            guess = input.nextInt();
            if (number < guess) {
                System.out.println("大了点，再猜！");
                count++;
            } else if (number > guess) {
                System.out.println("小了点，再猜！");
                count++;
            } else {
                count++;
                break;
            }
        } while (true);
        System.out.println("这个数字是"+number);
        System.out.println("您猜的次数是"+count);
        // 根据猜测次数给出评价
        if (count == 1) {
            System.out.println("你太聪明了！");
        } else if (count >= 2 && count <= 5) {
            System.out.println("不错，再接再厉！");
        } else {
            System.out.println("要努力啊！");
        }
    }

}

