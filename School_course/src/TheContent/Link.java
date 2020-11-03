package TheContent;

public class Link <T>{

        Node<T> head;                                    //队列头节点
        Node<T> tail;                                    //队列尾节点

        public void insert(T x) {                        //插入函数
            Node<T> t = new Node<T>(x);
            if (head == null) {            //如果队列为空
                head = t;
                tail = t;
            } else if (head == tail) {        //如果队列只有一个元素
                tail = t;
                tail.last = head;
                head.next = tail;
            } else {                        //其他情况
                tail.next = t;
                t.last = tail;
                tail = t;
            }
        }

        public T getFront() {                            //得到头节点
            return head.v;
        }

        public T pop() {                                //删除头节点，三种情况，分类处理
            T t = head.v;
            if (head == null) {
                return null;
            }
            if (head == tail) {
                head = tail = null;
                return t;
            }
            head = head.next;
            head.last = null;
            return t;
        }

        public boolean isEmpty() {                        //判断是否为空
            return head == null;
        }

        private class Node<T> {
            Node<T> next;            //上一个节点
            Node<T> last;            //下一个节点
            T v;                    //权值

            public Node(T x) {
                this.v = x;
            }

            public Node() {
            }
        }
    }

