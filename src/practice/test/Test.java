package practice.test;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List num = new ArrayList<String>();
		num.add(5);
		num.add(3);
		num.add(1);
		num.add(6);
		num.add(0,4);
		System.out.println(num.toString());
	}
}
