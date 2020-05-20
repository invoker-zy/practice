package practice.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//��������������������ߣ�����ͬʱ��������ָ�����ɹ���ʾ��δ����ɹ�����ʧ����ʾ
class Answer implements Runnable{
	private boolean flag = false;
	@Override
	public void run() {
		synchronized(this) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(flag == false) {
				this.flag = true;
				System.out.println(Thread.currentThread().getName()+" ����ɹ�");
			}else {
				System.out.println(Thread.currentThread().getName()+" ����ʧ��");
			}
		}
	}
	
}
//Callableʵ��
class AnswerCallable implements Callable<String>{
	private boolean flag = false;
	@Override
	public String call() throws Exception {
		synchronized(this) {
			if(flag == false) {
				this.flag = true;
				return Thread.currentThread().getName()+" ����ɹ�";
			}else {
				return Thread.currentThread().getName()+" ����ʧ��";
			}
		}
	}
	
}
public class ThreadDemo3 {
	public static void main(String[] args) throws Exception {
		Answer as = new Answer();
		AnswerCallable cal = new AnswerCallable();
		FutureTask<String> task = new FutureTask<String>(cal);
		new Thread(task,"����һ��").start();
		new Thread(task,"�������").start();
		new Thread(task,"��������").start();
		System.out.println(task.get());
	}
}
