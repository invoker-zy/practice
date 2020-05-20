package practice.thread;
//����һ̨���ԾͰ���һ̨���ԣ����û���µĵ�����������Ҫ����������������ĵ���
//û�а�������Ҫ�ȴ�����֮��������
class ProductComputer implements Runnable{//��������
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
class MoveComputer implements Runnable{//���ߵ���
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
	//flag == true ������������
	//flag == false ��������������
	public synchronized void product() throws Exception{
		if(this.flag == false) {
			super.wait();
		}
		Thread.sleep(100);
		this.count++;
		System.out.println("����һ̨����	- "+"����������"+this.count );
		this.flag = false;
		super.notify();
	}
	public synchronized void move() throws Exception{
		if(this.flag == true) {
			super.wait();
		}
		Thread.sleep(100);
		System.out.println("����һ̨����");
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
