package practice.javaBasic;

class Channel{
	private void connect() {
		System.out.println("【Channel父类】进行资源的链接");
	}
	public void func() {
		this.connect();
	}
}
class DatabaseChannel extends Channel {
	public void connect() {
		System.out.println("【Channel子类】进行数据库资源的链接");
	}
}

public class Override {
	public static void main(String[] args) {
		DatabaseChannel ch = new DatabaseChannel();
//		ch.connect();//【Channel子类】进行数据库资源的链接
//		ch.func();//【Channel子类】进行数据库资源的链接，实例化的是子类，同时重写了。
		ch.func();//【Channel父类】进行资源的链接(将父类connect方法改为private后，就不属于重写了，所以是调用父类的)
	}
}

