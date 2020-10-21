package java_school;

import java.util.Calendar;
import java.util.Scanner;
import java.util.Date;

public class TestDate {
private int year,day,month;

public int getYear(){
    return year;
}

public int getMonth(){
    return month;
}

public int getDay(){
    return day;
}

public void setMonth(){
    Scanner scanner = new Scanner(System.in);
    System.out.println("请输入月");
    month = scanner.nextInt();
}

public void setYear(){
    Scanner scanner = new Scanner(System.in);
    System.out.println("请输入年");
    year = scanner.nextInt();
}

    public void setDay(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入天");
        day = scanner.nextInt();
    }

    public String toString() {
        return year+"-"+month+"-"+day;
    }
    public void showDate() {
        System.out.println(toString());
    }

    public void moveForward(){
        Date date = new Date();//取时间
        Calendar calendar  =   Calendar.getInstance();

        calendar.setTime(date); //需要将date数据转移到Calender对象中操作
        calendar.add(calendar.DATE, -1);//把日期往前增加1天.正数往后推,负数往前移动
        date=calendar.getTime();   //这个时间就是日期往后推一天的结果
    }
    public void moveForward(int n){
        Date date = new Date();//取时间
        Calendar calendar  =   Calendar.getInstance();

        calendar.setTime(date); //需要将date数据转移到Calender对象中操作
        calendar.add(calendar.DATE, -n);//把日期往前增加1天.正数往后推,负数往前移动
        date=calendar.getTime();   //这个时间就是日期往后推一天的结果
    }
    public void moveNext(){
        Date date = new Date();//取时间
        Calendar calendar  =   Calendar.getInstance();

        calendar.setTime(date); //需要将date数据转移到Calender对象中操作
        calendar.add(calendar.DATE, 1);//把日期往后增加1天.正数往后推,负数往前移动
        date=calendar.getTime();   //这个时间就是日期往后推一天的结果
    }
    public void moveNext(int n){
        Date date = new Date();//取时间
        Calendar calendar  =   Calendar.getInstance();

        calendar.setTime(date); //需要将date数据转移到Calender对象中操作
        calendar.add(calendar.DATE, n);//把日期往后增加1天.正数往后推,负数往前移动
        date=calendar.getTime();   //这个时间就是日期往后推一天的结果
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



    public static void main(String[] args){
    TestDate date=new TestDate();
    date.setDay();
    date.setMonth();
    date.setYear();
    date.showDate();
    date.moveForward();
    date.showDate();

    }
}

