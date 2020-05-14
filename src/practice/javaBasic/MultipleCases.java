package practice.javaBasic;
//多例设计模式
public class MultipleCases {

	public static void main (String args[]) {
		Color color = Color.getInstance("red");
		System.out.println(color.toString());
	}
}
class Color{
	private static final Color red = new Color("红色");
	private static final Color green = new Color("绿色");
	private static final Color blue = new Color("蓝色");
	private String title;
	private Color(String title) {
		this.title = title;
	};
	public static Color getInstance(String color) {
		switch(color) {
		case "red": return red;
		case "green": return green;
		case "blue": return blue;
		default : return null;
		}
	}
	public String toString() {
		return this.title;
	}
}

