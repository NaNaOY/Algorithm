package linearList;

public class SqList implements ILiist{

    private int[] listElem;//线性表存储空间
    private int curLen;//线性表当前长度

    //顺序表构造函数，构造一个存储空间容量位maxSize的线性表
    public SqList(int maxSize){
        curLen=0;//置顺序表的当前长度为0
        listElem=new int[maxSize];//为顺序表分配maxSize个存储单元
    }

    //将一个已经存在的线性表置成空表
    public void clear(){
        curLen=0;//置顺序表当前的长度为0
    }

    //判断线性表中的数据元素个数是否为0
    public boolean isEmpty(){
        return curLen==0;//为0则返回true，否则返回false
    }

    //求线性表中数据元素的个数并返回其值
    public int length(){
        return curLen;//返回顺序表的当前长度
    }

    //读取到线性表中的第i个元素并由函数返回其值，
    //其中i的取值范围为：0<=i<=length()-1
    //若i不在此范围内则抛出异常
    public int get(int i)throws Exception{
        if(i<0||i>curLen-1){//i小于0或者i大于表长减一
            throw new Exception("第"+i+"个元素不存在");//抛出异常
        }
        return listElem[i];//返回第i个数据元素
    }

    // 在第i个数据元素之前插入一个值为x的数据元素
    public void insert(int i, int c) throws Exception{
        if(curLen==listElem.length){//判断顺序表是否已满
            throw new Exception("顺序表已满");//抛出异常
        }
        if(i<0||i>curLen){//如果i不合法
            throw new Exception("插入位置不合法");//抛出异常
        }
        for(int j=curLen;j>i;j--){
            listElem[j]=listElem[j-1];//插入位置及其之后的所有数据元素后移一位
            //注意是j=j-1，因为curLen是表的长度
        }
        listElem[i]=c;//插入x
        curLen++;//表长加1
    }

    //删除并返回第i个元素
    public void remove (int i)throws Exception{
        if(i<0||i>curLen-1){//i不合法
            throw new Exception("删除位置不合法");//抛出异常
        }
        for(int j=i;j<curLen;j++){
            listElem[j]=listElem[j+1];//被删除元素之后的所有数据元素左移一个存储位置
        }
        curLen--;//表长减1
    }

    //返回首次出现指定的数据元素的位序号，若线性表不包含此数据元素，则返回-1
    public int indexOf(int x){
        int j=0;//j指示顺序表中待比较的数据元素，其初始值指示指示顺序表中第0个数据元素
        while(j<curLen&&!(listElem[j]==(x))){//依次比较
            j++;
        }
        if(j<curLen){//判断j的位置是否在顺序表中
            return j;//返回值为x的位置的数据元素在顺序表中的位置
        }
        else
            return -1;//值为x的数据元素在顺序表中不存在
    }

    //输出
    public void display(){
        for(int j=0;j<curLen;j++){
            System.out.print(listElem[j]+" ");
        }
        System.out.println();
    }
}
