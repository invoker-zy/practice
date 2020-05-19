package practice.javaBasic;

class Producer implements Runnable{
	private Messager msg;
	public Producer(Messager msg) {
		this.msg = msg;
	}
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			if(i % 2 == 0) {
				this.msg.set("�ȵ�","����lele");
			}else {
				this.msg.set("�Ե�","����");
			}
		}
	}
}
class Consumer implements Runnable{
	private Messager msg;
	public Consumer(Messager msg) {
		this.msg = msg;
	}
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(this.msg.get());
		}
	}
}
class Messager{
	private String title;
	private	String content;
	private boolean flag = false;
	//���flagΪfalse���ʾֻ�ܽ���������������
	//���flagΪtrue���ʾֻ�����Ѳ�������
	public synchronized void set(String title,String content) {
		if(this.flag==true) {	//�������õģ���Ҫ�������������
			try {
				super.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.title = title;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.content = content;
		this.flag = true;//�Ѿ��������˿�������
		super.notify();//���ѵȴ����߳�
	}
	public synchronized String get() {
		if(this.flag == false) {	//��δ����������������Ҫ�ȴ�
			try {
				super.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			return this.title + " - " + this.content;
		}finally {
			this.flag = false;//��������û�������õ��ˣ���������
			super.notify();
		}
	}
}
public class ProducerAndConsumer {
	public static void main(String[] args) throws Exception{
		Messager msg = new Messager();
		new Thread(new Producer(msg)).start();
		new Thread(new Consumer(msg)).start();
	}
}
