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
				System.out.println("����һ��dota׼��˯��");
				try {
					Thread.sleep(10000);
					System.out.println("˯���˼�����");
				} catch (InterruptedException e) {
					System.out.println("��˯��������ʼ��");
				}
			}
		};
		t.start();
		Thread.sleep(1000);//��ʼ˯��
		if (!t.isInterrupted()) {
			System.out.println("���Ѻ�����������");
			t.interrupt();
		}
	}
}
