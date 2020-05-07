package practice.test;

public class Test extends Child {
	public static void main(String[] args) {
		Test t = new Test();
        Test testObject=new Test();
        System.out.println(t.getNext());
        System.out.println(testObject.getNext());
	}
    private static int i=1;
    public int getNext(){
         return i++;
    }
}
class Child{
	public String name = "Person";
}
