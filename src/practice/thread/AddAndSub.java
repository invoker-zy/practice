package practice.thread;
//����ĸ��̶߳��������߳�ִ�мӲ����������߳�ִ�м�����
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
	private int num = 0;	//�Ӽ�����������
	private boolean flag = true;	//�����Ǽӷ����Ǽ�������
	//flag == true ֻ�ܼӷ�
	//flag == false ֻ�ܼ���
	public synchronized void add() throws Exception{
		if(this.flag == false) {
			super.wait();
		}
		Thread.sleep(100);
		this.num ++ ;
		System.out.println("�ӷ�����  -  "+Thread.currentThread().getName() +" ��num =" +this.num);
		this.flag = false;
		super.notifyAll();
	}
	public synchronized void sub() throws Exception{
		if(this.flag == true) {
			super.wait();
		}
		Thread.sleep(100);
		this.num -- ;
		System.out.println("��������  -  "+Thread.currentThread().getName() +" ��num =" +this.num);
		this.flag = true;
		super.notifyAll();
	}
}
public class AddAndSub {
	public static void main(String[] args) {
		Process p = new Process();
		SubThread st = new SubThread(p);
		AddThread at = new AddThread(p);
		new Thread(at,"�ӷ��߳� - A").start();
		new Thread(at,"�ӷ��߳� - B").start();
		new Thread(st,"�����߳� - X").start();
		new Thread(st,"�����߳� - Y").start();
	}
}
