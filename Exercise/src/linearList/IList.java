package linearList;

public interface IList {
    public void clear();// 置空表

    public boolean isEmpty();// 是否为空

    public int length();// 数据元素个数

    public int get(int i) throws Exception;// 返回第i个数据元素的值

    public void insert(int i, int x) throws Exception;// 在第i个数据元素之前插入一个值为x的数据元素

    public void remove(int i) throws Exception;//删除并返回第i个元素

    public int indexOf(int x);//返回首次出现指定的数据元素的位序号，
    //若线性表不包含此数据元素，则返回-1

    public void display();//输出
}
