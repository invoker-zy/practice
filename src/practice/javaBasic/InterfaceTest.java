package practice.javaBasic;

interface IClassName {
	public abstract String getClassName();
}
class Company implements IClassName{
	public String getClassName() {
		return "������Ϊ��Company";
	}
}
public class InterfaceTest {
	//����һ��ClassName�ӿڣ��ӿ���ֻ��һ�����󷽷�getClassName()�����һ����Company����
	//��ʵ�ֽӿ�ClassName�еķ���getClassName()�������ǻ�ȡ����������ƣ���дӦ�ó���Company��
	public static void main(String[] args) {
		Company company = new Company();
		System.out.println(company.getClassName());
	}

}
