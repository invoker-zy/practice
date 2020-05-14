package practice.javaBasic;
//链表实现
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
		nodeDO<String> node = new nodeDO<String>("火车头");
		nodeDO<String> node1 = new nodeDO<String>("车厢一");
		nodeDO<String> node2 = new nodeDO<String>("车厢二");
		nodeDO<String> node3 = new nodeDO<String>("车厢三");
		nodeDO<String> node4 = new nodeDO<String>("车厢四");
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
