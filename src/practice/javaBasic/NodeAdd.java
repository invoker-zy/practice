package practice.javaBasic;
//��������
interface Link<E>{
	public void add(E e);
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
	}
	//Link���ж���ĳ�Ա
	private Node root;	//������ڵ�
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
