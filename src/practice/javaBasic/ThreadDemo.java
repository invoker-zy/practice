package practice.javaBasic;

class MyThread implements Runnable {
	public int tickets = 1000;
	public void run() {
		while (true) {
			synchronized(this){
				if (tickets > 0) {
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "��Ʊ+tickets=" + tickets--);
				} else {
					System.out.println("*****Ʊ������****");
					break;
				}
			}
		}
	}
}

public class ThreadDemo {
	public static void main(String[] args) throws Exception {
		MyThread my = new MyThread();
		new Thread(my, "Ʊ����A").start();
		new Thread(my, "Ʊ����B").start();
		new Thread(my, "Ʊ����C").start();
	}
}
