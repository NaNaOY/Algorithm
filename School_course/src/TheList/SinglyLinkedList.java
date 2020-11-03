package TheList;

public class SinglyLinkedList<T> {
    public Node<T> head;

    public SinglyLinkedList(){
        this.head=null;
    }
    boolean isEmpty(){
        if(head==null){
            System.out.println("链表为空！");
            return true;
        }
        else{
            System.out.println("链表不为空！");
            return false;
        }
    }
    //增加节点
    public void addNode(Node node) {
        if(head==null){
        head = new Node(3,null);
        }
        else{
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next =node;
        }
    }

    //插入节点
    //index 插入链表的位置，从1开始
    //node  插入的节点
    public void insertNodeByIndex(int index, Node node) {
        if (index < 1 || index > length() + 1) {
            System.out.println("插入位置不合法");
        }
        int length = 1;
        Node temp = head;
        while (head.next != null) {
            if (index == length++) {
                node.next = temp.next;
                temp.next = node;
                return;
            }
            temp = temp.next;
        }
    }
    //删除节点
    public void delNodeByIndex(int index) {
        if ((index < 1) || (index > length())) {
            System.out.println("给定的位置不合理");
            return;
        }
        int length = 1;
        Node temp = head;
        while (head.next != null) {
            if (index == length++) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }
    //获取总长度
    public int length(){
        int length=0;
        Node temp=head;
        while(temp.next!=null){
            length++;
            temp=temp.next;
        }
        return length;
    }
    //打印所有节点
    public void print(){
        Node temp=head.next;
        while(temp!=null){
            System.out.print(temp.data);
            if(temp.next!=null){
                System.out.print(",");
            }
            temp=temp.next;
        }
        System.out.println();
    }
    //查找i位置的元素
    public T get(int i){
        if(head!=null&&i>=0){
            int j=0;
            Node<T> temp=head;
            while(temp!=null&&j<i){
                j++;
                temp=temp.next;
            }
            if(temp!=null){
                return (T)temp.data;
            }
        }
        return null;
    }
    //设置i位置的结点，重置值
    public T set(int i,T x){
        if(head!=null&&i>=0&&x!=null){
            int j=0;
            Node<T> temp=this.head;
            while(temp!=null&&j<i){
                j++;
                temp=temp.next;
            }
            if(temp!=null){
                T old=(T)temp.data;
                temp.data=x;
                return old;
            }
        }
        return null;
    }
    //清空链表
    public void clear(){
        head=null;
        }
    //查找相同元素
    public T search(T key){
        if(head!=null){
            Node<T> temp=head;
            while(temp!=null){
            if(temp.data==key){
                return (T)temp.data;
            }
            else{
                temp=temp.next;
                }
            }
        }
        return null;
    }


}

