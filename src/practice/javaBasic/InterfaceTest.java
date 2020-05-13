package practice.javaBasic;

interface IClassName {
	public abstract String getClassName();
}
class Company implements IClassName{
	public String getClassName() {
		return "类名称为：Company";
	}
}
public class InterfaceTest {
	//定义一个ClassName接口，接口中只有一个抽象方法getClassName()；设计一个类Company，该
	//类实现接口ClassName中的方法getClassName()，功能是获取该类的类名称；编写应用程序Company类
	public static void main(String[] args) {
		Company company = new Company();
		System.out.println(company.getClassName());
	}

}
