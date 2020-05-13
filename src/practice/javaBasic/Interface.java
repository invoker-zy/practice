package practice.javaBasic;

interface IMessage {
	//��������
//	public static final String INFO = "invoker";
//	public abstract String getInfo();
	//�򻯶���
	//�����಻��ʡ��abstract���ӿڿ���1
	String INFO = "invoker";
	String getInfo();
}
interface IChannel{
	public abstract boolean connect();
}
abstract class DatabaseAbstract{
	//�����಻��ʡ��abstract���ӿڿ���2
	public abstract boolean getDatabaseConnection();
}
class MeassageImpl extends DatabaseAbstract implements IMessage,IChannel {
	public String getInfo() {
		if(this.connect()) {
			if(this.getDatabaseConnection()) {
				return "��ȡ��Ϣ";
			}
		}
		return "ͨ������ʧ��";
	}
	public boolean connect() {
		System.out.println("ͨ������");
		return true;
	}
	public boolean getDatabaseConnection() {
		return true;
	}
}
public class Interface {
	public static void main(String args[]) {
		IMessage ms = new MeassageImpl();
		System.out.println(ms.getInfo());
		System.out.println(IMessage.INFO);
	}
}
