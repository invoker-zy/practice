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
					System.out.println(Thread.currentThread().getName() + "ÂôÆ±+tickets=" + tickets--);
				} else {
					System.out.println("*****Æ±ÒÑÂô¹â****");
					break;
				}
			}
		}
	}
}

public class ThreadDemo {
	public static void main(String[] args) throws Exception {
		MyThread my = new MyThread();
		new Thread(my, "Æ±··×ÓA").start();
		new Thread(my, "Æ±··×ÓB").start();
		new Thread(my, "Æ±··×ÓC").start();
	}
}
