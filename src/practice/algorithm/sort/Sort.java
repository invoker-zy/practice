package practice.algorithm.sort;

import java.util.Arrays;
import java.util.Scanner;

public class Sort {
	public static void main(String[] args) {
		// 3,8,55,1,46,33,27,7,53,2
		// 3 8 55 1 46 33 27 3 53 2
		Sort sort = new Sort();
		int arr[] = sort.getValue();
		sort.fastSort(arr, 0, arr.length - 1);
		sort.print(arr);
	}

	// 接收要排序的数组
	public int[] getValue() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入数据个数：");
		int sum = sc.nextInt();
		System.out.println("请输入要排序的数据：");
		int arr[] = new int[sum];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		return arr;
	}

	/**
	 * 桶排序
	 * 
	 * @param arr
	 */
	public void bucketSort(int arr[]) {
		// 初始化桶
		int bucket[] = new int[101];
		// 如果输入的数据等于桶的下标则+1
		for (int i = 0; i < arr.length; i++) {
			int sub = arr[i];
			bucket[sub]++;
		}
		// 输出数组
		System.out.println("排序后的数为：");
		for (int i = 0; i < bucket.length; i++) {
			for (int j = 1; j <= bucket[i]; j++) {// 出现几次就打印几次
				System.out.print(i + ",");
			}
		}
	}

	/**
	 * 冒泡排序
	 * 
	 * @param arr
	 */
	public void bubbleSort(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		print(arr);
	}

	/**
	 * 快速排序
	 * 
	 * @param arr
	 */
	public void fastSort(int arr[], int left, int right) {
		// 记录数组排序起始下标和末尾下标
		int i = left;
		int j = right;
		if (left > right) {
			return;
		}
		// 基数
		int temp = arr[i];
		while (i != j) {
			// 先从后往前查询，有小于基数的，则停止，并记录
			while (arr[j] >= temp && i < j) {
				j--;
			}
			// 再从前往后查询，有大于基数的，则停止，并记录
			while (arr[i] <= temp && i < j) {
				i++;
			}
			// 交换两个记录的数
			if (i < j) {
				int swap = arr[i];
				arr[i] = arr[j];
				arr[j] = swap;
			}
		}
		arr[left] = arr[i];
		arr[i] = temp;

		fastSort(arr, left, i - 1);
		fastSort(arr, i + 1, right);

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
