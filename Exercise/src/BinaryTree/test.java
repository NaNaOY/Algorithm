package BinaryTree;

public class test {
    public static void main(String[] args) {
        String text="AAAABBBCDDBBAAA";
        int[] weights= {7,5,1,2};
        HuffmanTree huftree = new HuffmanTree(weights);
        System.out.println(huftree.toString());
        String compressed = huftree.encode(text);
        System.out.println("将"+text+"压缩为"+compressed+","+compressed.length()+"位");
        System.out.println("将"+compressed+"解码为"+huftree.decode(compressed));

    }
}
