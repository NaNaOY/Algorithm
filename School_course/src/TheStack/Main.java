package TheStack;

import java.util.Stack;

/*
 Stack stack=new Stack;
       // 判断是否为空
        stack.empty();
        //取栈顶值（不出栈）
        stack.peek();
        //进栈
        stack.push(Object);
        //出栈
        stack.pop();
 */
public class Main {
    public static void main(String[] args) {
        //创建一个栈
        Stack stack = new Stack();
        //入栈
        for(int i=1;i<=10;i++){
            stack.push(i);
        }
        //出栈
        while(!stack.isEmpty()){
            System.out.println("栈：" + stack.toString() + "\t栈大小为：" + stack.size() + "\t出栈元素为：" + stack.pop());
        }
    }
}

