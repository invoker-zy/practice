package practice.javaBasic;

interface IMessage {
	//完整定义
//	public static final String INFO = "invoker";
//	public abstract String getInfo();
	//简化定义
	//抽象类不能省略abstract，接口可以1
	String INFO = "invoker";
	String getInfo();
}
interface IChannel{
	public abstract boolean connect();
}
abstract class DatabaseAbstract{
	//抽象类不能省略abstract，接口可以2
	public abstract boolean getDatabaseConnection();
}
class MeassageImpl extends DatabaseAbstract implements IMessage,IChannel {
	public String getInfo() {
		if(this.connect()) {
			if(this.getDatabaseConnection()) {
				return "获取信息";
			}
		}
		return "通道建立失败";
	}
	public boolean connect() {
		System.out.println("通道建立");
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
