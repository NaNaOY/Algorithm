package The_experiment_2;

import java.io.Serializable;

/**
 * @author Dx666
 * @Description
 * @Date 2020/11/18 - 21:04
 */
public class Node implements  Comparable<Node>, Serializable {
	
	// 序列化id
	public static final long serialVersionUID = 41235113552L;
	
	/**
	 * data 存放数据（字符）本身，比如 'a' >= 97 ' ' >= 32
	 * weight 权值，表示字符串出现的次数
	 * right 右子树
	 * left 左子数
	 */
	Byte data;
	int weight;
	
	Node left;
	Node right;
	
	public Node() {
	
	}
	
	public Node(Byte data, int weight) {
		this.data = data;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Node o) {
		// 从小到大排序
		return this.weight - o.weight;
	}
	
	@Override
	public String toString() {
		return "Node [data = " + data + ", weight = " + weight + ", left = " + left + ", right=" + right + "]";
	}
	
	/**
	 * 前序遍历
	 */
	public void preOrder() {
		System.out.println(this);
		
		if (this.left != null) {
			this.left.preOrder();
		}
		if (this.right != null) {
			this.right.preOrder();
		}
	}
}
