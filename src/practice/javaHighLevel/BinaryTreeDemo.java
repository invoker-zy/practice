package practice.javaHighLevel;

import java.util.Arrays;

public class BinaryTreeDemo {
	public static void main(String[] args) {
		BinaryTree<Integer>	tree = new BinaryTree<Integer>();
		tree.add(10);
		tree.add(90);
		tree.add(45);
		tree.add(27);
		tree.add(196);
		tree.add(5);
		System.out.println(Arrays.toString(tree.toArray()));
	}
}
class BinaryTree<T extends Comparable<T>>{
	public class Node{
		private Comparable<T> data; //存放Comparable，可以比较大小
		private	Node parent;	//保存父节点
		private Node left;	//保存左子树
		private Node right;	//保存右子树
		public Node(Comparable<T> data) {	//构造方法直接负责数据的存储
			this.data = data;
		}
		public void addNode(Node newNode) {
			if(newNode.data.compareTo((T) this.data) <= 0) {	//比当前节点数据小
				if(this.left == null) {	//现在没有左子树
					this.left = newNode;	//保存左子树
					newNode.parent = this;	//保存父节点
				}else {	//需要继续向左边判断
					this.left.addNode(newNode);	//继续向下判断
				}
			} else {
				if(this.right == null) {	//现在没有右子树
					this.right = newNode;	//保存右子树
					newNode.parent = this;	//保存父节点
				} else {	//需要继续向右边判断
					this.right.addNode(newNode);	//继续向下判断
				}
			}
		}
		public void toArrayNode() {
			if(this.left != null) {	//有左子树
				this.left.toArrayNode();	//递归调用
			}
			BinaryTree.this.returnData[BinaryTree.this.foot ++] = this.data;
			if(this.right != null) {	
				this.right.toArrayNode();	
			}
		}
	}
	// -----------------以下为二叉树的具体实现--------------------
	private Node root;	//保存的是根节点
	private int count;	//保存数据个数
	private Object[] returnData;	//返回的数据
	private int foot = 0;	//角标控制
	public void add(Comparable<T> data) {
		if(data == null) {
			throw new NullPointerException("保存的数据不允许为空");
		}
		Node newNode = new Node(data);	//保存节点
		if(this.root == null) {	//现在没有根节点，则第一个节点作为根节点
			this.root = newNode;
		}else {	//需要为其保存到一个合适的节点
			this.root.addNode(newNode);
		}
		this.count ++;
	}
	
	public Object[] toArray() {
		if(this.count == 0) {
			return null;
		}
		this.returnData = new Object[this.count];	//保存长度为数组长度
		this.foot = 0;	//角标清零
		this.root.toArrayNode();	//直接通过Node类负责
		return returnData;	//返回全部的数据
	}
}
