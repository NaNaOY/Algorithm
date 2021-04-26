package The_experiment_1;



import java.util.Scanner;

/**
 * @author Dx666
 * @Description
 * @Date 2021/3/27 - 16:36
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("请输入需要计算的式子如(23456789 - -76543211)：");

        while (isTrueAndDivExpression(input.nextLine())) {
            System.out.println("输入的算式有误，请重新输入");
        }
    }

    /**
     * 减法运算
     * @param num1
     * @param num2
     */
    public static  void del(DoubleList num1, DoubleList num2) {
        // 判断当前节点数相减的是否需要向前借1
        boolean flag = false;

        // 让temp1永远指向较大数的最后一个节点
        // temp2指向较小数的最后一个节点
        DoubleNode temp1 = getLast(num1);
        DoubleNode temp2 = getLast(num2);

        // 记录当前节点相减的结果
        int ansTemp;
        while(temp1 != null && temp2 != null) {
            // 当前节点减
            ansTemp = temp1.getNum() - temp2.getNum() - (flag ? 1 : 0);
            if(ansTemp < 0) {
                // 是否需要借1
                temp1.setNum(ansTemp + 10000);
                flag = true;
            } else {
                flag = false;
                temp1.setNum(ansTemp);
            }
            temp1 = temp1.getRight();
            temp2 = temp2.getRight();
        }
        // 当减完之后还需要借1时
        while(flag && temp1 != null) {
            ansTemp = temp1.getNum() - 1;
            if(ansTemp < 0) {
                temp1.setNum(ansTemp + 10000);
                flag = true;
            } else {
                flag = false;
                temp1.setNum(ansTemp);
            }
            temp1 = temp1.getRight();
        }
        System.out.println("运算结果为：" + num1.show());
    }

    /**
     * 加法运算
     * @param num1
     * @param num2
     */
    public static void add(DoubleList num1, DoubleList num2) {
        // 判断当前节点数相加是否需要进位
        boolean flag = false;

        // 让temp1永远指向较大数的最后一个节点
        // temp2指向较小数的最后一个节点
        DoubleNode temp1 = getLast(num1);
        DoubleNode temp2 = getLast(num2);

        // 记录当前节点相减的结果
        int ansTemp;
        while(temp1 != null && temp2 != null) {
            ansTemp = temp1.getNum() + temp2.getNum() + (flag ? 1 : 0);

            if(ansTemp >= 10000) {
                temp1.setNum(ansTemp - 10000);
                flag = true;
            } else {
                flag = false;
                temp1.setNum(ansTemp);
            }
            temp1 = temp1.getRight();
            temp2 = temp2.getRight();
        }

        // 当前链表的长度不足，并且还需要进1时
        if(flag) {
            DoubleNode node = new DoubleNode(1, num1.getHead(), null);
            num1.getHead().setRight(node);
            num1.setHead(node);
        }
        System.out.println("运算结果为：" + num1.show());
    }

    /**
     * 判断输入的算式是否有误，无误则进行切割并计算
     * @param expr 算式
     * @return true 有误 false无误
     */
    public static boolean isTrueAndDivExpression(String expr) {
        if(expr == null || expr.isEmpty()) {
            return true;
        }
        String[] nums = expr.split(" ");
        if(nums.length != 3) {
            return true;
        }

        // 将大数转化成双向链表
        DoubleList num1 = null;
        DoubleList num2 = null;
        try {

            num1 = new DoubleList(nums[0]);
            num2 = new DoubleList(nums[2]);

            // 调用判断方法
            judge(num1, num2, nums[1]);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return false;
    }

    /**
     * 判断输入的两个计算的参数，然后进行化简，最后调用计算方法
     * @param num1
     * @param num2
     * @param op 运算式的运算符
     */
    public static void judge(DoubleList num1, DoubleList num2, String op) {
        // 当为减法时
        int high = isHigh(num1, num2);
        if(op.equals("-")) {
            // 两个大数的符号相同时可以转换成两个正数相减
            if(num1.getOp().equals(num2.getOp())) {

                // 前两个代表最终结果为负数的情况
                if(high == 1 && num1.getOp().equals("-")) {
                    del(num1, num2);
                } else if(high == -1 && num1.getOp().equals("+")) {
                    num2.setOp("-");
                    del(num2, num1);

                    // 后两个判断代表最终结果为正数的情况
                } else if(high == 1) {
                    num1.setOp("+");
                    del(num1, num2);
                } else if (high == -3){
                    num2.setOp("+");
                    del(num2, num1);

                    // 如果数值相等结果为0
                } else {
                    System.out.println("结果为：0");
                }

                // 符号不相同时转换成两个负数相加或者是两个正数相加
            } else {
                num2.setOp(num1.getOp());
                add(num1, num2);
            }

            // 为加法时
        } else {
            // 符号相同时就是两个正数相加或者是两个负数相加
            if(num1.getOp().equals(num2.getOp())) {
                add(num1, num2);
                // 符号不同时可以转换成两个正数相减
            } else {

                // 前两个代表最终结果为负数的情况
                if(high == 1 && num1.getOp().equals("-")) {
                    del(num1, num2);
                } else if(high == -1 && num1.getOp().equals("+")) {
                    del(num2, num1);

                    // 后两个判断代表最终结果为正数的情况
                } else if(high == 1) {
                    del(num1, num2);
                } else if(high == -1) {
                    del(num2, num1);

                    // 如果数值相等结果为
                } else {
                    System.out.println("结果为：0");
                }

            }
        }
    }


    /**
     * 返回两个链表存储的大数之间的大小
     * @param num1
     * @param num2
     * @return 1 num1 大  -1 num2大  0相等
     */
    private static int isHigh(DoubleList num1, DoubleList num2) {
        // 比较链表的长度
        if(num1.length() > num2.length()) {
            return 1;
        } else if(num1.length() < num2.length()) {
            return -1;
        }

        // 比较链表中存储大数的长度
        if(num1.getLength() > num2.getLength()) {
            return 1;
        } else if(num1.getLength() < num2.getLength()) {
            return -1;
        }

        // 获取头结点
        DoubleNode temp1 = num1.getHead();
        DoubleNode temp2 = num2.getHead();

        // 比较每一个节点中的每一个数的大小
        while(temp1 != null) {
            if(temp1.getNum() > temp2.getNum()) {
                return 1;
            } else if(temp1.getNum() < temp2.getNum()) {
                return -1;
            }
            temp1 = temp1.getLeft();
            temp2 = temp2.getLeft();
        }

        return 0;
    }


    /**
     * 返回双向链表的最后一个节点
     * @param linkedList 链表
     * @return
     */
    private static DoubleNode getLast(DoubleList linkedList) {
        DoubleNode temp = linkedList.getHead();
        while(temp.getLeft() != null) {
            temp = temp.getLeft();
        }
        return temp;
    }

}
