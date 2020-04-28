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

	// ����Ҫ���������
	public int[] getValue() {
		Scanner sc = new Scanner(System.in);
		System.out.println("���������ݸ�����");
		int sum = sc.nextInt();
		System.out.println("������Ҫ��������ݣ�");
		int arr[] = new int[sum];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		return arr;
	}

	/**
	 * Ͱ����
	 * 
	 * @param arr
	 */
	public void bucketSort(int arr[]) {
		// ��ʼ��Ͱ
		int bucket[] = new int[101];
		// �����������ݵ���Ͱ���±���+1
		for (int i = 0; i < arr.length; i++) {
			int sub = arr[i];
			bucket[sub]++;
		}
		// �������
		System.out.println("��������Ϊ��");
		for (int i = 0; i < bucket.length; i++) {
			for (int j = 1; j <= bucket[i]; j++) {// ���ּ��ξʹ�ӡ����
				System.out.print(i + ",");
			}
		}
	}

	/**
	 * ð������
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
	 * ��������
	 * 
	 * @param arr
	 */
	public void fastSort(int arr[], int left, int right) {
		// ��¼����������ʼ�±��ĩβ�±�
		int i = left;
		int j = right;
		if (left > right) {
			return;
		}
		// ����
		int temp = arr[i];
		while (i != j) {
			// �ȴӺ���ǰ��ѯ����С�ڻ����ģ���ֹͣ������¼
			while (arr[j] >= temp && i < j) {
				j--;
			}
			// �ٴ�ǰ�����ѯ���д��ڻ����ģ���ֹͣ������¼
			while (arr[i] <= temp && i < j) {
				i++;
			}
			// ����������¼����
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
	 * �������
	 * 
	 * @param arr
	 */
	public void print(int arr[]) {
		System.out.println("��������Ϊ��");
		System.out.println(Arrays.toString(arr));
	}
}
