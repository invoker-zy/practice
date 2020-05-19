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
				this.msg.set("喝的","可乐lele");
			}else {
				this.msg.set("吃的","橘子");
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
	//如果flag为false则表示只能进行生产不能消费
	//如果flag为true则表示只能消费不能生产
	public synchronized void set(String title,String content) {
		if(this.flag==true) {	//有生产好的，需要消费完毕再生产
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
		this.flag = true;//已经生产好了可以消费
		super.notify();//唤醒等待的线程
	}
	public synchronized String get() {
		if(this.flag == false) {	//还未生产，不能消费需要等待
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
			this.flag = false;//消费完了没有生产好的了，不能消费
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
