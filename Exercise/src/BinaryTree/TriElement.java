package BinaryTree;

public class TriElement {
    int data;
    int parent,left,right;
    public TriElement(int data, int parent, int left, int right) {
        this.data = data;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }
    public TriElement(int data) {
        this(data, -1, -1, -1);
    }
    public String toString() {
        String str = new String();
        str = "data : " + this.data + "parent :" + this.parent + "left :" + this.left+ "right :" + this.right;
        return str;
    }
    public boolean isLeaf() {
        return left == -1 && right == -1;
    }
}
