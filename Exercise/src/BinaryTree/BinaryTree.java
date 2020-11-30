package BinaryTree;


import java.util.Stack;

public class BinaryTree<T> {
    public BinaryNode<T> root;
    public BinaryTree() {
        this.root = null;
    }
    public boolean isEmpty() {
        return this.root == null;
    }
    public void insert(T x) {
        if(x != null)
            this.root = new BinaryNode<T>(x, this.root, null);
    }
    public BinaryNode<T> insert(BinaryNode<T> p, boolean left, T x){
        if(x==null || p==null)
            return null;
        if(left)
            return p.left = new BinaryNode<T>(x, p.left, null);
        return p.right = new BinaryNode<T>(x, null, p.right);
    }
    public void remove(BinaryNode<T> p, boolean left) {
        if(p!=null) {
            if(left)
                p.left = null;
            else
                p.right = null;
        }
    }
    public void clear() {
        this.root = null;
    }
    //先根遍历二叉树
    public void preorder() {
        preorder(this.root);
        System.out.println();
    }
    public void preorder(BinaryNode<T> p) {
        if(p!=null) {
            System.out.print(p.data.toString()+" ");
            preorder(p.left);
            preorder(p.right);
        }
    }
    //中根遍历二叉树
    public void inorder() {
        inorder(this.root);
        System.out.println();
    }
    public void inorder(BinaryNode<T> p) {
        if(p!= null) {
            inorder(p.left);
            System.out.print(p.data.toString()+" ");
            inorder(p.right);
        }
    }
    //后根遍历
    public void postorder() {
        postorder(this.root);
        System.out.println();
    }
    public void postorder(BinaryNode<T> p) {
        if(p!=null) {
            postorder(p.left);
            postorder(p.right);
            System.out.print(p.data.toString()+" ");
        }
    }
    //先根构造二叉树
    public BinaryTree(T[] prelist) {
        this.root = create(prelist);
    }
    private int i = 0;
    private BinaryNode<T> create(T[] prelist){
        BinaryNode<T> p = null;
        if(i<prelist.length) {
            T elem = prelist[i++];
            if(elem!=null) {
                p = new BinaryNode<T>(elem);
                p.left = create(prelist);
                p.right = create(prelist);
            }
        }
        return p;
    }
    public void preorderTraverse() {
        Stack<BinaryNode<T>> stack = new LinkedStack<BinaryNode<T>>();
        BinaryNode<T> p = this.root;
        while(p!=null || !stack.isEmpty()) {
            if(p!=null) {
                System.out.print(p.data+" ");
                stack.push(p);
                p=p.left;
            }
            else {
                System.out.print("^ ");
                p=stack.pop();
                p=p.right;
            }
        }
        System.out.print("^ ");
    }
    public void inorderTraverse() {
        Stack<BinaryNode<T>> stack = new LinkedStack<BinaryNode<T>>();
        BinaryNode<T> p = this.root;
        while(p!=null || !stack.isEmpty()) {
            while(p!=null) {
                stack.push(p);
                p=p.left;
            }
            if(!stack.isEmpty()) {
                p=stack.pop();
                System.out.print(p.data+" ");
                p=p.right;
            }
        }
    }
}
