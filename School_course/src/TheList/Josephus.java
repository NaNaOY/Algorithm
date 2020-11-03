package TheList;

public class Josephus {
    //n个人，n>0;从start开始计数，0<=start<n;每次数到distant的人出环，0<distance<n;
    public Josephus(int n,int start,int distance){
        if(n<=0||start<0||start>=n||distance<=0||distance>=n){
            throw new IllegalArgumentException("n="+n+",start="+start+",distance="+distance);
        }
        SinglyLinkedList<String> list=new SinglyLinkedList<String>();

        for(int i=0;i<=n;i++){
            Node<String> node =new Node<String>((char)('A'+i-1)+"");
            list.addNode(node);
        }
        System.out.println("Josephus("+n+","+start+"，"+distance+")");
        Node<String> front=list.head;

        list.print();
        while(n>1){
            for(int i=0;i<distance;i++){
                front=front.next;
                if(front==null){
                    front=list.head.next;
                }
            }
            if(front.next==null) {
                front = list.head;
            }
                System.out.println("删除"+front.next.data.toString()+",");
                front.next=front.next.next;
                n--;
                list.print();
        }
        System.out.print("被赦免者是");
        list.print();
    }
}
