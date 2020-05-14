package practice.javaBasic;
//链表增加
interface Link<E>{
	public void add(E e);
}
class LinkImpl<E> implements Link<E>{
	public class Node {	//保存节点数据关系
		private E data;	//保存的数据
		private Node next;	//保存下一个引用
		public Node(E data) {	//构造方法
			this.data = data;
		}
		public void addNode(Node newNode) {	//保存新的node
			if (this.next == null) {	//当前节点的下一个节点为空
				this.next = newNode;
			}else {
				this.next.addNode(newNode);
			}
		}
	}
	//Link类中定义的成员
	private Node root;	//保存根节点
	//Link类中定义的方法
	public void add(E e) {
		if(e == null) {	//保存的数据为空
			return ;	//直接返回
		}
		Node newNode = new Node(e);	//创建一个新的节点
		if(this.root == null) {	//没有根节点
			this.root = newNode;	//第一个节点作为根节点
		}else {	//根节点存在
			this.root.addNode(newNode);
		}
	}
}
public class NodeAdd {
	public static void main(String args[]) {
		LinkImpl<String> all = new LinkImpl<String>();
		all.add("hello");
		all.add("1");
		all.add("2");
	}
}
