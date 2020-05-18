package practice.javaBasic;

public class ThreadDemo {
	public static void main(String[] args) throws Exception {
//		Thread t = new Thread(()-> {//Lambada
//			System.out.println("111111111");
//			try {
//				Thread.sleep(10000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			System.out.println("222222222");
//		});
		Thread t = new Thread() {
			public void run() {
				System.out.println("玩了一天dota准备睡觉");
				try {
					Thread.sleep(10000);
					System.out.println("睡好了继续玩");
				} catch (InterruptedException e) {
					System.out.println("不睡觉继续开始玩");
				}
			}
		};
		t.start();
		Thread.sleep(1000);//开始睡觉
		if (!t.isInterrupted()) {
			System.out.println("队友喊起来继续玩");
			t.interrupt();
		}
	}
}
