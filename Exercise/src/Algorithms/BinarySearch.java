package Algorithms;

import java.util.Arrays;
import java.util.Queue;

public class BinarySearch {
    public static int rank(int key,int[] a){
        int lo=0;
        int hi=a.length-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(key<a[mid]) {hi=mid-1;}
            else if(key>a[mid]){lo=mid+1;}
            else
                return mid;
        }
        return -1;
    }


    public static void main(String[] args){
        int[] whitelist=In.readInts(args[0]);
        Arrays.sort(whitelist);
        while(!StdIn.isEmpty()){
            int key=StdIn.readInt();
            if(rank(key,whitelist)==-1)
                StdOut.println(key);
        }
    }

    public static int[] readInts(String name){
        IN in=new IN(name);
        Queue<Integer> q=new Queue<Integer>() ;
        while(!in.isEmpty()){
            q.enqueue(in.readInt());
        }
        int N=q.size();
        int[] a=new int[N];
        for(int i=0;i<N;i++){
            a[i]=q.dequeue();
        }
        return a;
    }
}
