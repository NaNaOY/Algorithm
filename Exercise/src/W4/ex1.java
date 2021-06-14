package W4;

public class ex1 {
    public static void main(String[] args){
        int [] a={1,2,3,4,5,6,7,8,9};
        int pos=bSearch(a,0,a.length-1,1);
        System.out.println(pos);
    }

    public static int bSearch(int [] data,int left,int right,int key){
        //获取中间位置
        int middle=(left+right)/2;
        //比较key值如相等，返回当前位置，否则确认新的查找空间
        if(data[middle]==key){
            return middle;
        } else if(data[middle]>key){
            return bSearch(data,left,middle-1,key);
        }else {
            return bSearch(data, middle + 1, right, key);
        }
    }

}
