package BinaryTree;


public class HuffmanTree {
    private String charset; //字符集合
    private TriElement[] element;//静态三叉链表结点数组
    //构造Huffman树，weights指定权值集合，数组长度为叶子结点数
    public HuffmanTree(int[] weights) {
        this.charset = "";
        int n = weights.length;
        for(int i=0; i<weights.length; i++)
            this.charset += (char)('A'+i);
        this.element = new TriElement[2*n-1];// n个叶子的Huffman树有2n-1个结点
        for(int i=0; i<n; i++)//初始化n个结点
            this.element[i] = new TriElement(weights[i]);//构造无父母的叶子结点

        for(int i=n; i<2*n-1; i++) {  //构造n-1个2度结点
            int min1 = Integer.MAX_VALUE, min2 = min1;//最小和次小权值，初值为最大整数
            int x1 = -1, x2= -1;//最小和次小权值结点下标
            for(int j=0; j<i; j++)//寻找两个无父母的最小权值下标结点
                if(this.element[j].parent==-1) {//第j个结点无父母
                    if(this.element[j].data<min1) {//第j个结点权值最小
                        min2 = min1; //min2记得次小权值
                        x2 = x1;//x2记得次小权值结点下标
                        min1 = this.element[j].data;//min1记得最小权值
                        x1 = j;//x1记得最小权值下标
                    }
                    else if(this.element[j].data<min2) {//第j个结点权值次小
                        min2 = element[j].data;
                        x2 = j;
                    }
                }
            this.element[x1].parent = i;//合并两颗权值最小的子树，左孩子最小
            this.element[x2].parent = i;
            this.element[i] = new TriElement(min1 +min2, -1, x1, x2);//构造结点

        }
    }
    private String huffmanCode(int i) {//返回第i个字符的Huffman编码字符串
        int n =8;
        char code[] = new char[n];//声明字符数组暂存Huffman编码
        int child = i, parent = this.element[child].parent;


        for(i = n-1; parent!= -1; i--) {//由叶结点向上直到根结点，反序存储编码
            code[i]=(element[parent].left==child) ? '0' : '1';//左，右孩子编码为0，1
            child = parent;
            parent = element[child].parent;
        }
        return new String(code, i+1, n-1-i);//由code数组从i+1开始的n-1-i个字符构造串
    }
    public String toString() {
        String str = "Huffman树的结点数组：";
        for(int i=0; i<this.element.length;i++)
            str += this.element[i].toString()+",";
        str += "\nHuffman编码：  ";
        for(int i=0; i<this.charset.length(); i++)//输出所有叶子结点的huffman编码
            str+=this.charset.charAt(i)+":"+huffmanCode(i)+", ";
        return str;
    }
    public String encode(String text) {//数据压缩，将text各字符转换成huffman编码存储，返回压缩字符串
        String compressed="";//被压缩的数据以字符串显示
        for(int i=0; i<text.length(); i++) {
            int j= text.charAt(i)-'A';//获得当前字符在默认字符集中的序号
            compressed += this.huffmanCode(j);//在Huffman树中获得第j个字符的编码
        }
        return compressed;
    }
    public String decode(String compressed) {
        String text ="";
        int node=this.element.length-1;//node搜索一条从根到达叶子的路径
        for(int i=0; i<compressed.length(); i++) {
            if(compressed.charAt(i)== '0')//根据0.1分别向左或右孩子走
                node = element[node].left;
            else
                node = element[node].right;
            if(element[node].isLeaf()) {//到达叶子结点
                text += this.charset.charAt(node);//获得一个字符
                node = this.element.length-1;//node再从跟结点开始
            }
        }
        return text;
    }
}