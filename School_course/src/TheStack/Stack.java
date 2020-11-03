
package TheStack;

import java.util.ArrayList;
/*
public class Stack {
    ArrayList<Object> list = new ArrayList<>();
    //入栈
    public void push(Object o){
        list.add(o);
    }
    //出栈
    public Object pop(){
        Object o = list.get(list.size() - 1);
        list.remove(o);
        return o;
    }
    //栈是否为空
    public boolean isEmpty(){
        return list.isEmpty();
    }
    //栈大小
    public int size(){
        return list.size();
    }
    //打印栈元素
    @Override
    public String toString(){
        return String.valueOf(list);
    }
    }
    */
public class Stack<E> {
    Node<E> top=null;

    public boolean isEmpty(){
        return top==null;
    }

    /*
     * 入栈
     */
    public void push(E data){
        Node<E> nextNode=new Node<E>(data);
        nextNode.next=top;
        top=nextNode;
    }
    /*
     * 出栈
     */
    public E pop(){
        if(this.isEmpty()){
            return null;
        }
        E data =top.datas;
        top=top.next;
        return data;
    }
}
