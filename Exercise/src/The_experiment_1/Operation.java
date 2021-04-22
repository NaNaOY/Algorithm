package The_experiment_1;

/**
 * @author Dx666
 * @Description
 * @Date 2021/3/27 - 15:57
 */
enum Operation {
    /**
     * 加减乘除四个符号
     */
    ADD("+"),
    DEL("-"),
    MUL("*"),
    DIV("/");

    /**
     * 运算符
     */
    private final String operator;


    Operation(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }


}
