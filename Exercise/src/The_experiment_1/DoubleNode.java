package The_experiment_1;
/**
 * @author Dx666
 * @Description
 * @Date 2021/3/27 - 15:45
 */
class DoubleNode {
    private Integer num;
    private DoubleNode left;
    private DoubleNode right;

    public DoubleNode(Integer num, DoubleNode left, DoubleNode right) {
        this.num = num;
        this.left = left;
        this.right = right;
    }

    public DoubleNode() {
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public DoubleNode getLeft() {
        return left;
    }

    public void setLeft(DoubleNode left) {
        this.left = left;
    }

    public DoubleNode getRight() {
        return right;
    }

    public void setRight(DoubleNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node [ num=" + num + " ]";
    }
}
