package practice.javaBasic;

class MyThread extends Thread{	//�߳������� �̳�Thread��
	private String title;
	public MyThread(String title) {
		this.title = title;
	}
	public void run() {	//�߳����巽��
		for(int i = 0;i<=10;i++) {
			System.out.println(this.title+"����i��ֵ��"+i);
		}
	}
}
public class ThreadDemo {
	public static void main(String[] args) {
		new MyThread("�߳�A��").start();
		new MyThread("�߳�B��").start();
		new MyThread("�߳�C��").start();
	}
}
