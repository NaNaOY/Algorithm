package TheContent;

public class MyQueue<E> {
    public Node<E> head=null;
    public Node<E> tail=null;
    public boolean isEmpty(){
        return head==null;
    }
    public void put(E data){
        Node<E> newNode=new Node<E>(data);
        if(head==null&&tail==null)
            head=tail=newNode;
        else
            tail.next=newNode;
        tail=newNode;
    }
    public E pop(){
        if(this.isEmpty())
            return null;
        E data=head.data;
        head=head.next;
        return data;
    }
    public int size(){
        int n=0;
        Node<E> t=head;
        while(t!=null){
            n++;
            t=t.next;
        }
        return n;
    }



}
