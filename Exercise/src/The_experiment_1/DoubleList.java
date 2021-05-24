package The_experiment_1;
import java.util.ArrayList;
import java.util.List;
/**
 * 大数双向链表

 * @Description
 * @Date 2021/3/27 - 15:47
 */
class DoubleList {
    private DoubleNode head;
    private String op;       //符号
    private Integer length; // 链表中存储的数的长度


    public DoubleList(String num) {
        largeNumberToDoubleLinkedList(num);
    }


    /**
     * 返回存储大数的长度
     * @return
     */
    public Integer getLength() {
        return length;
    }

    public void setHead(DoubleNode head) {
        this.head = head;
    }
    /**
     * 返回头结点
     * @return
     */
    public DoubleNode getHead() {
        return head;
    }

    /**
     * 返回大数的符号
     * @return
     */
    public String getOp() {
        return op;
    }

    /**
     * 设置大数的符号
     */
    public void setOp(String op) {
        this.op = op;
    }

    /**
     * 将数字转化成四个为一组的List<>数据类型</>
     * 并且调用createLinkedList方法创建双链表
     * @param num 大数
     * @return 返回链表头
     */
    public void largeNumberToDoubleLinkedList(String num) {
        // 判断传过来的字符串是否为空
        if(!isEmpty(num)) {
            if(isNumber(num)) {
                head = new DoubleNode();
                // 判断大数是不是负数的标志
                boolean flag = num.contains("-");
                // 调用方法生成对应的大数链表
                op = flag ? "-" : "+";
                createLinkedList(divNum(num));
            } else {
                throw new RuntimeException("大数有误");
            }
        } else {
            throw new RuntimeException("数字为空");
        }
    }


    /**
     * 创建双向链表方法
     * @param nums 传入list类型的数据
     */
    private void  createLinkedList(List<Integer> nums) {
        head = new DoubleNode(0, null, null);
        DoubleNode temp = head;
        for(int i = nums.size() - 1; i >= 0; i--) {
            if(i == nums.size() - 1) {
                head.setNum(nums.get(i));
            } else {
                DoubleNode node = new DoubleNode();
                node.setNum(nums.get(i));
                temp.setLeft(node);
                node.setRight(temp);
                temp = temp.getLeft();
            }
        }

    }

    /**
     * 判断大数是否有误
     * @param num 大数
     * @return  true 无误 false 有误
     */
    private boolean isNumber(String num) {
        char[] nums = num.toCharArray();
        int i = 1;
        // 判断是否有','
        if(num.contains(",")) {
            for(int j = num.length() - 5; j > 1; j -= 5) {
                // 该有‘,’的位置没有就是错的
                if(num.charAt(j) != ',') {
                    return false;
                }
            }
        } else {
            while(i < num.length()) {
                if(!('0' <= nums[i] && nums[i] <= '9')) {
                    return false;
                }
                i++;
            }
        }
        return nums[0] == '-' || nums[0] == '+' || ('0' <= nums[0] && nums[0] <= '9');
    }

    /**
     * 判断字符串是否为空
     * @param num
     * @return
     */
    private boolean isEmpty(String num) {
        return num == null || "".equals(num);
    }

    /**
     * 将大数切割
     * @param num 大数
     * @return
     */
    private List<Integer> divNum(String num) {
        int i = num.length();
        List<Integer> nums = new ArrayList<>();

        // 判断字符串首位是不是符号
        if(!('0' <= num.charAt(0) && num.charAt(0) <= '9')) {
            num = num.substring(1, i);
            i--;

        }
        // 去除大数前面的0
        int len;
        if((len = delZero(num)) != i) {
            num = num.substring(delZero(num), i);
            i -= len;
        }
        // 初始化存储大数的长度
        length = num.length();

        // 两种切割方式
        if(num.contains(",")) {
            String[] temp = num.split(",");
            for (int j = temp.length - 1; j >= 0; j--) {
                nums.add(Integer.parseInt(temp[j]));
            }
        } else {
            while(i > 0) {
                nums.add(Integer.parseInt(num.substring(Math.max(i - 4, 0), i)));
                i -= 4;
            }
        }
        return nums;
    }

    /**
     * 展示大数链表
     */
    public String show() {
        // 以字符串记录大数取出来
        StringBuilder num1 = new StringBuilder();
        // 将链表中的大数前面的0去掉后的大数字符串
        StringBuilder num2 = new StringBuilder();

        DoubleNode temp = head;
        while (temp != null) {
            // 当节点中存储的数不足四位时，凑足四位数
            if(temp.getNum() < 1000) {
                for(int i = 0; i < 4 - ("" + temp.getNum()).length(); i++){
                    num1.append(0);
                }
            }
            num1.append(temp.getNum());
            temp = temp.getLeft();
        }
        char[] nums = num1.toString().toCharArray();

        // 大数从第一位开始的不是0的数的标值
        boolean flag = true;
        int index = 1;

        for (char num : nums) {
            if (num != '0' || !flag) {
                num2.append(num);
                // 按中国对于长整数的表示习惯，每四位一组，组间用逗号隔开。
                if((nums.length - index) % 4 == 0 && index != nums.length) {
                    num2.append(",");
                }
                flag = false;
            }
            index++;
        }
        return  op.equals("-") ? op + num2.toString() : num2.toString();
    }

    /**
     * 返回链表的长度
     * @return
     */
    public Integer length() {
        int i = 1;
        DoubleNode temp = head;
        while(temp != null) {
            i++;
            temp = temp.getLeft();
        }
        return i;
    }

    /**
     * 返回大数前面0的个数
     * @param num
     * @return 返回结果
     */
    private int  delZero(String num) {
        // 大数前面是0的标志
        int i = 0;
        for(; i < num.length(); i++) {
            if(num.charAt(i) != '0') {
                break;
            }
        }
        return i;
    }


}
