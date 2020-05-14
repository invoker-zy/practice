package practice.javaBasic;
//�������ģʽ
public class Singleton {

	public static void main(String[] args) {
		LanSingleton instance = null;
		instance = LanSingleton.getInstance();
		instance.print();
	}
}
//����ʽ
class ESingleton {
	private static final ESingleton INSTRANCE = new ESingleton();//��new
	private ESingleton(){};//˽�л����췽��
	public static ESingleton getInstance() {
		return INSTRANCE;
	}
	public void print() {
		System.out.println("aaa");
	}
}
//����ʽ
class LanSingleton {
	private static LanSingleton INSTRANCE;
	private LanSingleton(){};//˽�л����췽��
	public static LanSingleton getInstance() {
		if(INSTRANCE == null) {//��һ��ʹ��ʱ��new
			INSTRANCE = new LanSingleton();
		}
		return INSTRANCE;
	}
	public void print() {
		System.out.println("aaa");
	}
}