package Graph;

public final class SeqQueue<T> implements Queue<T>{
    private Object element[];
    private int front, rear;
    private static final int MIN_CAPACITY=16;
    public SeqQueue(int length) {
        if(length < MIN_CAPACITY)
            length = MIN_CAPACITY;
        this.element = new Object[length];
        this.front = this.rear = 0;
    }
    public SeqQueue() {
        this(MIN_CAPACITY);
    }
    public boolean isEmpty() {
        return this.front == this.rear;
    }
    public boolean add(T x) {
        if(x==null)
            return false;
        if(this.front==(this.rear+1)%this.element.length) {
            Object[] temp = this.element;
            this.element = new Object[temp.length*2];
            int j=0;
            for(int i=this.front; i!=this.rear; i=(i+1) % temp.length)
                this.element[j++] = temp[i];
            this.front = 0;
            this.rear = j;
        }
        this.element[this.rear] = x;
        this.rear = (this.rear+1) % this.element.length;
        return true;
    }
    public T peek() {
        return this.isEmpty() ? null : (T)this.element[this.front];
    }
    public T poll() {
        if(this.isEmpty())
            return null;
        T temp = (T)this.element[this.front];
        this.front = (this.front+1) % this.element.length;
        return temp;
    }
    public String toString() {
        String str = "(";
        for(int i=this.front; i!=this.rear; i++)
            str += this.element[i]+", ";
        return str;
    }
}
