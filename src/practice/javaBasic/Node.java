package practice.javaBasic;
//����ʵ��
class nodeDO<E> {
	private E data;
	private nodeDO<?> next;
	public nodeDO(E data) {
		this.data = data;
	}
	public void setNextNode(nodeDO<?> next) {
		this.next = next;
	}
	public nodeDO<?> getNextNode() {
		return this.next;
	}
	public void setData(E data) {
		this.data = data;
	}
	public E getData() {
		return this.data;
	}
}
public class Node {
	public static void main(String args[]) {
		nodeDO<String> node = new nodeDO<String>("��ͷ");
		nodeDO<String> node1 = new nodeDO<String>("����һ");
		nodeDO<String> node2 = new nodeDO<String>("�����");
		nodeDO<String> node3 = new nodeDO<String>("������");
		nodeDO<String> node4 = new nodeDO<String>("������");
		node.setNextNode(node1);
		node1.setNextNode(node2);
		node2.setNextNode(node3);
		node3.setNextNode(node4);
		print(node);
	}
	public static void print(nodeDO<?> node) {
		if(node != null) {
			System.out.println(node.getData());
			print(node.getNextNode());
		}
	}
}
