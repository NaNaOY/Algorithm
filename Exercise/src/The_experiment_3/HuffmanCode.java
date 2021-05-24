package The_experiment_3;


import java.io.*;
import java.util.*;

/**
 * 哈夫曼编码

 * @Description
 * @Date 2020/11/10 - 13:45
 */
public class HuffmanCode {
	/**
	 * huffmanCodes 每个数据对应的哈夫曼编码
	 * lengthOfFinalCode 哈夫曼编码的最后一个编码（即按照8位一个数据处理后剩下的几位数字的为正数情况下的最前面的0的个数）
	 */
	static Map<Byte, String> huffmanCodes = new HashMap<>();
	static int lengthOfFinalCodeOfZero = 0;
	public static Node head;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入要编码的字符串:");
		String str = input.nextLine();
		byte[] bytes = str.getBytes();
		System.out.println("哈夫曼编码为：");
		String code = getHuffmanCodes(bytes);
		System.out.println(code);
		System.out.println("解码后为:");
		System.out.println(decode(code));
		System.out.println("--------对哈夫曼树序列化----------");
		SerializableNode(head);
		System.out.println("----------反序列化哈夫曼树------------");
		DeserializeNode();
	}
	
	/**
	 * 序列化方法
	 */
	public static void SerializableNode(Node node) {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("HuffmanTree.dat"));
			oos.writeObject(node);
			// 写完之后要进行流数据更新
			oos.flush();
			System.out.println("序列化成功");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(oos != null) oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 反序列化方法
	 */
	public static void DeserializeNode() {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("HuffmanTree.dat"));
			// 读取对象
			Object o = ois.readObject();
			System.out.println("反序列化成功");
			Node node = (Node)o;
			System.out.println(node.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ois != null) ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 对哈夫曼编码进行解码
	 * @param stringHuffmanCode
	 * @return
	 */
	public static String decode(String stringHuffmanCode) {

		// 把字符串按照指定的哈夫曼编码进行解码
		// 把哈夫曼编码表进行调换, 反向查询 a -> 100 100 -> a
		
		Map<String, Byte> map = new HashMap<>();
		for(Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
			map.put(entry.getValue(), entry.getKey());
		}
		// 将哈夫曼编码转换成char[]数组
		char[] charCode = stringHuffmanCode.toCharArray();
		List<Byte> list = new ArrayList<>();
		// 创建一个StringBuilder方便字符串的拼接
		String code = "";
		for(char c : charCode) {
			code += c;
			if(map.containsKey(code)) {
				list.add(map.get(code));
				code = "";
			}
		}
		// 将byte数组转换成字符串
		byte[] b = new byte[list.size()];
		for(int i = 0; i < b.length; i++) {
			b[i] = list.get(i);
		}
		
		return new String(b);
	}
	
	
	/**
	 * 使用一个方法，将前面的方法封装起来，便于我们的调用
	 * @param bytes 原始的数据对应的byte数组
	 * @return 返回使用哈夫曼树压缩后的编码
	 */
	private static String getHuffmanCodes(byte[] bytes) {
		
		// 1.获取原始bytes数组对应的Node集合
		List<Node> nodes = getNodes(bytes);
		
		// 2.将Node集合转换成哈夫曼树
		head = createHuffmanTree(nodes);
		
		// 3.利用哈夫曼树得到原数据对应的哈夫曼编码
		getCodes(head);
		
		StringBuilder codes = new StringBuilder();
		for(byte b : bytes) {
			codes.append(huffmanCodes.get(b));
		}
		// 将得到的哈夫曼编码返回
		return codes.toString();
		
	}
	

	/**
	 * 方便调用,重载方法(生成哈夫曼编码)
	 * @param root 树的根节点
	 */
	private static void getCodes(Node root) {
		if (root != null) {
			getCodes(root, "", new StringBuilder());
		}
	}
	
	/**
	 * 生成哈夫曼树对应的哈夫曼编码
	 * 思路：
	 * 1.将哈夫曼编码表存放在Map<Byte, String>形式
	 * <p>
	 * 2.生成的哈夫曼编码，需要去拼接，定义一个StringBuilder存储某个叶子节点的路径
	 * 功能：将传入的node节点的所有叶子节点的哈夫曼编码得到，并放入到huffmanCodes集合
	 * @param node           传入节点
	 * @param code           路径 左子节点 0， 右子节点 1
	 * @param stringBuilder1 用于拼接路径
	 */
	private static void getCodes(Node node, String code, StringBuilder stringBuilder1) {
		StringBuilder stringBuilder2 = new StringBuilder(stringBuilder1);
		// 将code加入到StringBuilder2
		stringBuilder2.append(code);
		// 如果node == null 不处理
		if (node != null) {
			// 判断当前节点是叶子节点还是非叶子节点
			if (node.data == null) {
				// 向左递归
				getCodes(node.left, "0", stringBuilder2);
				//向右递归
				getCodes(node.right, "1", stringBuilder2);
			} else {
				// 字符对应的哈夫曼编码的集合
				huffmanCodes.put(node.data, stringBuilder2.toString());
			}
		}
	}
	
	
	/**
	 * 前序遍历
	 * @param root 根节点
	 */
	private static void preOrder(Node root) {
		if (root != null) {
			root.preOrder();
		} else {
			System.out.println("哈夫曼树为空");
		}
	}
	
	
	/**
	 * 通过List创建对应的赫夫曼树
	 *
	 * @param nodes List集合
	 * @return 返回哈夫曼树
	 */
	private static Node createHuffmanTree(List<Node> nodes) {
		// 循环构造
		while (nodes.size() > 1) {
			Collections.sort(nodes);
			
			Node leftNode = nodes.get(0);
			Node rightNode = nodes.get(1);
			
			Node parent = new Node(null, leftNode.weight + rightNode.weight);
			
			parent.left = leftNode;
			parent.right = rightNode;
			
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			nodes.add(parent);
		}
		//返回根节点
		return nodes.get(0);
	}
	
	
	/**
	 * 将字符串每一个字符转换成对应的节点
	 * @param bytes 字符对应的byte数组
	 * @return 返回Node集合
	 */
	private static List<Node> getNodes(byte[] bytes) {
		// 1 创建一个ArrayList
		ArrayList<Node> nodes = new ArrayList<>();
		// 遍历 bytes, 统计每一个byte出现的次数 ->map
		HashMap<Byte, Integer> counts = new HashMap<>();
		for (byte b : bytes) {
			// 获取对应的字符对应的次数
			Integer count = counts.get(b);
			// map集合中没有这个字符,创建这个字符的key-value
			if (count == null) {
				counts.put(b, 1);
			} else {
				counts.put(b, count + 1);
			}
		}
		// 把每个键值对转成一个Node对象，并加入到Nodes集合
		for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
			nodes.add(new Node(entry.getKey(), entry.getValue()));
		}
		return nodes;
	}
}
