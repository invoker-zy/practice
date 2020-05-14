package practice.javaBasic;
//�������ģʽ
public class MultipleCases {

	public static void main (String args[]) {
		Color color = Color.getInstance("red");
		System.out.println(color.toString());
	}
}
class Color{
	private static final Color red = new Color("��ɫ");
	private static final Color green = new Color("��ɫ");
	private static final Color blue = new Color("��ɫ");
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

