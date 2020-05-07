package practice.algorithm.queue;

import java.util.Arrays;
import java.util.Scanner;

public class Queue {
	public static void main(String[] args) {
		//6 3 1 7 5 8 9 2 4 ԭ
		//6 1 5 9 4 7 2 8 3 ���
		//���Ƚ��� 1 ����ɾ���������Ž��� 2 �����ŵ��⴮����ĩβ��
		//�ٽ��� 3����ɾ�������� 4 �����ٷŵ��⴮����ĩβ��
		//�ٽ��� 5 ����ɾ������ֱ��ʣ�����һ�����������һ����Ҳɾ����
		//���ող�ɾ����˳�򣬰���Щɾ����������һ��
		Queue queue = new Queue();
		int arr[] = queue.getPrint();
		queue.queue(arr);
	}
	
	// ����Ҫ���������
	public int[] getPrint() {
		Scanner sc = new Scanner(System.in);
		System.out.println("���������ݸ�����");
		int sum = sc.nextInt();
		System.out.println("������Ҫ��������ݣ�");
		int arr[] = new int[sum*2];//���鳤�ȶ����һ�㣬��ΪҪ��ǰ���ֵ����ƶ�
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
			
			arrNew[i] = arr[head];//�������һ������ֵ��������
			head++;
			
			arr[tail] = arr[head];//�������һ������ƶ�
			tail++;
			head++;
			i++;
		}
		print(arrNew);
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
