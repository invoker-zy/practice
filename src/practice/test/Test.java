package practice.test;
interface IMessage {
	public void send(String str);
}
public class Test{
	public static void main(String[] args) {
		IMessage msg = new IMessage() {
			public void send(String str) {
				System.out.println("��Ϣ����:"+str);
			}
		};
		msg.send("haha");
	}
}
