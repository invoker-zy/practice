package practice.thread;
//生产一台电脑就搬走一台电脑，如果没有新的电脑生成则需要生产，如果生产出的电脑
//没有搬走则需要等待搬走之后再生产
class ProductComputer implements Runnable{//生产电脑
	private	Control ctrl;
	public ProductComputer(Control ctrl) {
		this.ctrl = ctrl;
	}
	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			try {
				this.ctrl.product();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
class MoveComputer implements Runnable{//搬走电脑
	private	Control ctrl;
	public MoveComputer(Control ctrl) {
		this.ctrl = ctrl;
	}
	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			try {
				this.ctrl.move();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
class Control{
	private int count = 0;
	private boolean flag = true;
	//flag == true 可以生产电脑
	//flag == false 不可以生产电脑
	public synchronized void product() throws Exception{
		if(this.flag == false) {
			super.wait();
		}
		Thread.sleep(100);
		this.count++;
		System.out.println("生产一台电脑	- "+"电脑总数："+this.count );
		this.flag = false;
		super.notify();
	}
	public synchronized void move() throws Exception{
		if(this.flag == true) {
			super.wait();
		}
		Thread.sleep(100);
		System.out.println("搬走一台电脑");
		this.flag = true;
		super.notify();
	}
}
public class ThreadDemo2 {
	public static void main(String[] args) {
		Control ctrl = new Control();
		MoveComputer mv = new MoveComputer(ctrl);
		ProductComputer pc = new ProductComputer(ctrl);
		new Thread(pc).start();
		new Thread(mv).start();
	}
}
