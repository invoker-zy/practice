package practice.javaBasic;

class MyThread extends Thread{	//线程主体类 继承Thread类
	private String title;
	public MyThread(String title) {
		this.title = title;
	}
	public void run() {	//线程主体方法
		for(int i = 0;i<=10;i++) {
			System.out.println(this.title+"运行i的值："+i);
		}
	}
}
public class ThreadDemo {
	public static void main(String[] args) {
		new MyThread("线程A：").start();
		new MyThread("线程B：").start();
		new MyThread("线程C：").start();
	}
}
