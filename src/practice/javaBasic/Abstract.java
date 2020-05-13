package practice.javaBasic;

abstract class Message {//������
	private String type;
	public abstract String getInfo();//���󷽷�(û�д����ŷ�����)
	public void setType(String type) {//��ͨ����
		this.type = type;
	}
	public String getType() {//��ͨ����
		return this.type;
	}
	public static Message getInstance() {
		return new DatabaseMessage();
	}
}
class DatabaseMessage extends Message{	//����
	public String getInfo() {	//��д����
		return "��ȡ������Ϣ��";
	}
}
public class Abstract {
	public static void main(String[] args) {
//		Message msg = new DatabaseMessage();	//newһ������
		Message msg = Message.getInstance();
		msg.setType("��ȡtype����");
		System.out.println(msg.getType());
		System.out.println(msg.getInfo());

		
		
	}
}
