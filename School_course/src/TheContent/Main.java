package TheContent;

/*
public class Main {
    public static void main(String[] args) {
        MyQueue<Integer> q=new MyQueue<Integer>();
        q.put(1);q.put(3);q.put(2);
        System.out.println(q.pop());
        System.out.println(q.size());
        System.out.println(q.pop());
    }
}

 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    static StreamTokenizer in=new StreamTokenizer (new BufferedReader(new InputStreamReader(System.in)));
    static boolean isPrime[];
    static int isP_Len=100;
    public static void main(String[] args) throws Exception {
        int arr[]=getPrimeRing(10);
        for(int i=0;i<10;i++) {
            System.out.print(arr[i]);
            if(i!=9){
                System.out.print(",");
            }
        }
    }
    ///==========================================得到素数环主函数

    static int[] getPrimeRing(int n) {
        int arr[]=new int[n];
        getPrimeArrays();
        Link<Integer> list=new Link<Integer>();
        arr[0]=1;
        int len=1;
        for(int i=2;i<=n;i++) {
            list.insert(i);
        }
        while(!list.isEmpty()) {
            int t=list.pop();
            if(isP(t+arr[len-1])) {
                arr[len++]=t;
            }
            else {
                list.insert(t);
            }
        }
        return arr;
    }
    //=============================================
    static boolean isP(int x) {
        return isPrime[x];
    }
    //筛法求素数，复杂度会低很多。n^3/2到几乎线性的辅助度。
    static void getPrimeArrays() {
        isPrime=new boolean[isP_Len];
        for(int i=2;i<isP_Len;i++) {
            isPrime[i]=true;
        }
        for(int i=2;i<isP_Len;i++) {
            if(isPrime[i]) {
                for(int j=i*2;j<isP_Len;j+=i) {
                    isPrime[j]=false;
                }
            }
        }
    }
    static int getInt() throws Exception{
        in.nextToken();
        return (int)in.nval;

    }
}



