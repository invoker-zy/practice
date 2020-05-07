package practice.algorithm.queue;

import java.util.Arrays;
import java.util.Scanner;

public class Queue {
	public static void main(String[] args) {
		//6 3 1 7 5 8 9 2 4 原
		//6 1 5 9 4 7 2 8 3 结果
		//首先将第 1 个数删除，紧接着将第 2 个数放到这串数的末尾，
		//再将第 3个数删除并将第 4 个数再放到这串数的末尾，
		//再将第 5 个数删除……直到剩下最后一个数，将最后一个数也删除。
		//按照刚才删除的顺序，把这些删除的数连在一起
		Queue queue = new Queue();
		int arr[] = queue.getPrint();
		queue.queue(arr);
	}
	
	// 接收要排序的数组
	public int[] getPrint() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入数据个数：");
		int sum = sc.nextInt();
		System.out.println("请输入要排序的数据：");
		int arr[] = new int[sum*2];//数组长度定义大一点，因为要将前面的值向后移动
		for (int i = 0; i < arr.length/2; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		return arr;
	}
	
	public void queue(int arr[]) {
		int head = 0;
		int i = 0;
		int tail = arr.length/2;
		int arrNew[] = new int[arr.length/2];
		while(head<tail) {
			
			arrNew[i] = arr[head];//将数组第一个数赋值给新数组
			head++;
			
			arr[tail] = arr[head];//将数组第一个向后移动
			tail++;
			head++;
			i++;
		}
		print(arrNew);
	}
	
	/**
	 * 输出数组
	 * 
	 * @param arr
	 */
	public void print(int arr[]) {
		System.out.println("排序后的数为：");
		System.out.println(Arrays.toString(arr));
	}
}
