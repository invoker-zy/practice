package practice.javaBasic;

class Channel{
	private void connect() {
		System.out.println("��Channel���ࡿ������Դ������");
	}
	public void func() {
		this.connect();
	}
}
class DatabaseChannel extends Channel {
	public void connect() {
		System.out.println("��Channel���ࡿ�������ݿ���Դ������");
	}
}

public class Override {
	public static void main(String[] args) {
		DatabaseChannel ch = new DatabaseChannel();
//		ch.connect();//��Channel���ࡿ�������ݿ���Դ������
//		ch.func();//��Channel���ࡿ�������ݿ���Դ�����ӣ�ʵ�����������࣬ͬʱ��д�ˡ�
		ch.func();//��Channel���ࡿ������Դ������(������connect������Ϊprivate�󣬾Ͳ�������д�ˣ������ǵ��ø����)
	}
}

