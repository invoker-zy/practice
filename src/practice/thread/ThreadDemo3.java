package practice.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//抢答程序：设置三个抢答者，而后同时发出抢答指令，抢答成功提示，未抢答成功给出失败提示
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
				System.out.println(Thread.currentThread().getName()+" 抢答成功");
			}else {
				System.out.println(Thread.currentThread().getName()+" 抢答失败");
			}
		}
	}
	
}
//Callable实现
class AnswerCallable implements Callable<String>{
	private boolean flag = false;
	@Override
	public String call() throws Exception {
		synchronized(this) {
			if(flag == false) {
				this.flag = true;
				return Thread.currentThread().getName()+" 抢答成功";
			}else {
				return Thread.currentThread().getName()+" 抢答失败";
			}
		}
	}
	
}
public class ThreadDemo3 {
	public static void main(String[] args) throws Exception {
		Answer as = new Answer();
		AnswerCallable cal = new AnswerCallable();
		FutureTask<String> task = new FutureTask<String>(cal);
		new Thread(task,"抢答一号").start();
		new Thread(task,"抢答二号").start();
		new Thread(task,"抢答三号").start();
		System.out.println(task.get());
	}
}
