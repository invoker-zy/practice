package practice.javaBasic;

abstract class Message {//抽象类
	private String type;
	public abstract String getInfo();//抽象方法(没有大括号方法体)
	public void setType(String type) {//普通方法
		this.type = type;
	}
	public String getType() {//普通方法
		return this.type;
	}
	public static Message getInstance() {
		return new DatabaseMessage();
	}
}
class DatabaseMessage extends Message{	//子类
	public String getInfo() {	//重写方法
		return "获取基本信息。";
	}
}
public class Abstract {
	public static void main(String[] args) {
//		Message msg = new DatabaseMessage();	//new一个子类
		Message msg = Message.getInstance();
		msg.setType("获取type属性");
		System.out.println(msg.getType());
		System.out.println(msg.getInfo());

		
		
	}
}
