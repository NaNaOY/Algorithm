package java_school;

import java.util.Scanner;

public class TestDate {


    public static void main(String[] args) {
// 定义年份
        int year = -1;
// 定义月份du
        int month = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入年");
        year = scanner.nextInt();
        System.out.println("请输入月");
        month = scanner.nextInt();
        System.out.println(year + "年" + month + "月有" + days(year, month) + "天");

    }

    public static int days(int year, int month) {
        int days = 0;
        if (month != 2) {
            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    System.out.println("31天");
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    days = 30;

            }
        } else {
// 闰年
            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
                days = 29;
            else {
                days = 28;
            }

        }
        return days;
    }
}

