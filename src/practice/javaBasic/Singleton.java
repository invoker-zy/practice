package practice.javaBasic;
//单例设计模式
public class Singleton {

	public static void main(String[] args) {
		LanSingleton instance = null;
		instance = LanSingleton.getInstance();
		instance.print();
	}
}
//饿汉式
class ESingleton {
	private static final ESingleton INSTRANCE = new ESingleton();//先new
	private ESingleton(){};//私有化构造方法
	public static ESingleton getInstance() {
		return INSTRANCE;
	}
	public void print() {
		System.out.println("aaa");
	}
}
//懒汉式
class LanSingleton {
	private static LanSingleton INSTRANCE;
	private LanSingleton(){};//私有化构造方法
	public static LanSingleton getInstance() {
		if(INSTRANCE == null) {//第一次使用时才new
			INSTRANCE = new LanSingleton();
		}
		return INSTRANCE;
	}
	public void print() {
		System.out.println("aaa");
	}
}