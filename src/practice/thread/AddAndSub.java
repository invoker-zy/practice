package practice.thread;
//设计四个线程对象，两个线程执行加操作，两个线程执行减操作
class AddThread implements Runnable {
	private Process process;
	public AddThread(Process process) {
		this.process = process;
	}
	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			try {
				this.process.add();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

class SubThread implements Runnable {
	private Process process;
	public SubThread(Process process) {
		this.process = process;
	}
	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			try {
				this.process.sub();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

class Process{
	private int num = 0;	//加减法操作的数
	private boolean flag = true;	//控制是加法还是减法操作
	//flag == true 只能加法
	//flag == false 只能减法
	public synchronized void add() throws Exception{
		if(this.flag == false) {
			super.wait();
		}
		Thread.sleep(100);
		this.num ++ ;
		System.out.println("加法操作  -  "+Thread.currentThread().getName() +" 、num =" +this.num);
		this.flag = false;
		super.notifyAll();
	}
	public synchronized void sub() throws Exception{
		if(this.flag == true) {
			super.wait();
		}
		Thread.sleep(100);
		this.num -- ;
		System.out.println("减法操作  -  "+Thread.currentThread().getName() +" 、num =" +this.num);
		this.flag = true;
		super.notifyAll();
	}
}
public class AddAndSub {
	public static void main(String[] args) {
		Process p = new Process();
		SubThread st = new SubThread(p);
		AddThread at = new AddThread(p);
		new Thread(at,"加法线程 - A").start();
		new Thread(at,"加法线程 - B").start();
		new Thread(st,"减法线程 - X").start();
		new Thread(st,"减法线程 - Y").start();
	}
}
