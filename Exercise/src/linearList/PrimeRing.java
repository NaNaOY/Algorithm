package linearList;



import linearList.SqList;

public class PrimeRing {

    public boolean isPrime(int num) {
        // 判断是否为素数
        if (num == 1) {
            return false;
        }

        Double n = Math.sqrt(num);// 减小运算量
        for (int i = 2; i <= n.intValue(); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public SqList insertRing(SqList L, LinkQueue Q, int index, int total) throws NumberFormatException, Exception {
        // 在一个顺序表L中插入第index个数，使之与顺序表中第index-1个数的和为素数，
        // 若index等于total，则还需满足第index个数与1的和也为素数，程序返回顺序表
        int count = 0;// 记录遍历队列中数据元素的个数，防止在一次循环中重复遍历
        while (!Q.isEmpty() && count <= total - index) {
            int p = (Integer) Q.poll();// 取队列第一个元素
            int q = L.get(L.length() - 1);// 取顺序表最后一个元素
            if (index == total) {// 如果是最后一个元素
                if (isPrime(p + q) && isPrime(p + 1)) {// 而且与顺序表最后一个元素，1都符合
                    L.insert(L.length(),  p);// 插入到顺序表表尾
                    return L;
                } else {
                    Q.offer(p);
                }
            } else if (isPrime(p + q)) {// 如果未遍历到最后一个元素
                L.insert(L.length(),  p);
                if (insertRing(L, Q, index+1, total) != null) {// 递归
                    return L;
                }
                L.remove(L.length()-1);// 移除顺序表表尾数据元素
                Q.offer(p);
            } else {
                Q.offer(p);
            }
            ++count;
        }
        return null;
    }

    public SqList makePrimeRing(int n)throws Exception{
        //求n个正整数的素数环，并以顺序表返回
        if(n%2!=0){//n为奇数则素数环不存在
            throw new Exception("素数环不存在");
        }
        SqList L=new SqList(n);
        L.insert(0,  1);//初始化顺序表的首结点为1
        LinkQueue Q=new LinkQueue();
        for(int i=2;i<=n;i++){
            Q.offer(i);//初始化队列
        }
        return insertRing(L, Q, 2, n);
    }

    public static void main(String[] args) throws Exception {
        PrimeRing pr=new PrimeRing();
        SqList L=pr.makePrimeRing(8);
        for(int i=0;i<L.length();i++){
            System.out.print(L.get(i)+" ");
        }
    }

}
