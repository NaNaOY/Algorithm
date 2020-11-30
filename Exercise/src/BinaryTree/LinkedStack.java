package BinaryTree;


import java.util.Stack;

public final class LinkedStack<T> extends Stack<T> {
    private SinglyList<T> list;
    public LinkedStack() {
        this.list = new SinglyList<T>();
    }
    public boolean isEmpty() {
        return this.list.isEmpty();
    }
    public T push(T x) {
        this.list.insert(0, x);
        return x;
    }
    public T peek() {
        return this.list.get(0);
    }
    public T pop() {
        return this.list.remove(0);
    }
    public String toString() {
        String str = this.getClass().getName() +"(";
        for(Node<T> p = this.list.head.next;p!=null;p=p.next)
            str += p.data.toString()+(p.next!=null?",":"");
        return str+")";
    }
}
