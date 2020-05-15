package practice.javaBasic;
//链表增加
interface Link<E>{
	public void add(E e);	//增加数据
	public int size();	//获取数据个数
	public boolean isEmpty();	//判断是否空集合
	public Object[] toArray();	//将集合元素以数组形式返回
	public E get(int index);	//根据索引获取数据
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
		public void toArrayNode() {
			LinkImpl.this.returnData [LinkImpl.this.foot++] = this.data;
			if(this.next != null) {
				this.next.toArrayNode();
			}
		}
		public E getNode(int index) {
			if(LinkImpl.this.foot ++ == index) {	//索引相同
				return this.data;
			}else {
				return this.next.getNode(index);
			}
		}
	}
	//Link类中定义的成员
	private Node root;	//保存根节点
	private int count;	//保存数据个数
	private int foot;	//操作数组的角标
	private Object[] returnData;	//返回的数据保存
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
		this.count++;
	}
	public int size() {	//获取集合个数
		return this.count;
	}
	public boolean isEmpty() {
		return this.count == 0;
	}
	public Object[] toArray() {
		if(this.isEmpty()) {
			return null;
		}
		this.foot = 0;	//角标清零
		this.returnData = new Object[this.count];	
		//利用Node类进行递归获取
		this.root.toArrayNode();
		return this.returnData;
	}
	public E get(int index) {
		if(index >= this.count) {	//索引应该在指定范围之内
			return null;
		}
		this.foot = 0;
		return this.root.getNode(index);
	}
}
public class NodeAdd {
	public static void main(String args[]) {
		LinkImpl<String> all = new LinkImpl<String>();
		System.out.println("增加之前："+all.size()+"、是否为空"+all.isEmpty());
		all.add("hello");
		all.add("1");
		all.add("2");
		all.add("3");
		System.out.println("增加之后："+all.size()+"、是否为空"+all.isEmpty());
		Object result [] = all.toArray();
		for(Object obj : result) {
			System.out.println(obj);
		}
		System.out.println("--------------------------");
		System.out.println(all.get(0));
		System.out.println(all.get(1));
		System.out.println(all.get(4));
	}
}
