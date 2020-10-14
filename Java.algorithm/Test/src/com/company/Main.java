package com.company;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args){
//实验一
/*
    System.out.println("Hello World!");

    SinglyLinkedList<Integer> linkedList=new SinglyLinkedList<Integer>();

    linkedList.isEmpty();

    for(int i=0;i<=5;i++){
    Node<Integer> node =new Node<Integer>(i);
    linkedList.addNode(node);
    }

    linkedList.isEmpty();

    linkedList.print();

    Node<Integer> node1 =new Node<Integer>(8);

    linkedList.insertNodeByIndex(3,node1);
    linkedList.print();

    linkedList.delNodeByIndex(4);
    linkedList.print();

    linkedList.set(2,3);
    linkedList.print();
    System.out.println(linkedList.get(2));
    System.out.println(linkedList.length());
    linkedList.clear();
    linkedList.isEmpty();
    System.out.println(linkedList.search(2));
    */

    //实验二
    new Josephus(20,0,7);

    }

}
