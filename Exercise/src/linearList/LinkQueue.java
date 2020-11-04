package linearList;

public class LinkQueue implements IQueue {

    private Node front;
    private Node rear;

    public LinkQueue() {
        front = rear = null;
    }

    @Override
    public void clear() {
        front = rear = null;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public int length() {
        Node p = front;
        int length = 0;
        while (p != null) {
            p = p.next;
            length++;
        }
        return length;
    }

    @Override
    public Object peek() {
        if (front != null) {
            return front.data;
        } else
            return null;
    }

    @Override
    public void offer(Object x) throws Exception {
        Node p=new Node(x);
        if(front!=null){
            rear.next=p;
            rear=p;
        }
        else{
            front=rear=p;
        }
    }

    @Override
    public Object poll() {
        if (front != null) {
            Node p = front;
            front = front.next;
            if (p == rear) {
                rear = null;
            }
            return p.data;
        } else
            return null;
    }

    @Override
    public void display() {
        Node p=front;
        while(p!=null){
            System.out.printf(p.data+" ");
            p=p.next;
        }
    }

}
