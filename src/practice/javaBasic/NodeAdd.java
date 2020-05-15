package practice.javaBasic;
//��������
interface Link<E>{
	public void add(E e);	//��������
	public int size();	//��ȡ���ݸ���
	public boolean isEmpty();	//�ж��Ƿ�ռ���
	public Object[] toArray();	//������Ԫ����������ʽ����
	public E get(int index);	//����������ȡ����
}
class LinkImpl<E> implements Link<E>{
	public class Node {	//����ڵ����ݹ�ϵ
		private E data;	//���������
		private Node next;	//������һ������
		public Node(E data) {	//���췽��
			this.data = data;
		}
		public void addNode(Node newNode) {	//�����µ�node
			if (this.next == null) {	//��ǰ�ڵ����һ���ڵ�Ϊ��
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
			if(LinkImpl.this.foot ++ == index) {	//������ͬ
				return this.data;
			}else {
				return this.next.getNode(index);
			}
		}
	}
	//Link���ж���ĳ�Ա
	private Node root;	//������ڵ�
	private int count;	//�������ݸ���
	private int foot;	//��������ĽǱ�
	private Object[] returnData;	//���ص����ݱ���
	//Link���ж���ķ���
	public void add(E e) {
		if(e == null) {	//���������Ϊ��
			return ;	//ֱ�ӷ���
		}
		Node newNode = new Node(e);	//����һ���µĽڵ�
		if(this.root == null) {	//û�и��ڵ�
			this.root = newNode;	//��һ���ڵ���Ϊ���ڵ�
		}else {	//���ڵ����
			this.root.addNode(newNode);
		}
		this.count++;
	}
	public int size() {	//��ȡ���ϸ���
		return this.count;
	}
	public boolean isEmpty() {
		return this.count == 0;
	}
	public Object[] toArray() {
		if(this.isEmpty()) {
			return null;
		}
		this.foot = 0;	//�Ǳ�����
		this.returnData = new Object[this.count];	
		//����Node����еݹ��ȡ
		this.root.toArrayNode();
		return this.returnData;
	}
	public E get(int index) {
		if(index >= this.count) {	//����Ӧ����ָ����Χ֮��
			return null;
		}
		this.foot = 0;
		return this.root.getNode(index);
	}
}
public class NodeAdd {
	public static void main(String args[]) {
		LinkImpl<String> all = new LinkImpl<String>();
		System.out.println("����֮ǰ��"+all.size()+"���Ƿ�Ϊ��"+all.isEmpty());
		all.add("hello");
		all.add("1");
		all.add("2");
		all.add("3");
		System.out.println("����֮��"+all.size()+"���Ƿ�Ϊ��"+all.isEmpty());
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
