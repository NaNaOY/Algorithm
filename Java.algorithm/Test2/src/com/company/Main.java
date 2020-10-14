package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        CircularLinkedList circularList=new CircularLinkedList();
        circularList.createLinkedList(20);

        circularList.solve(20,7);
        System.out.println(circularList);
    }
}
