package codeforce.codeforce_3_24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//3.21 Queue
public class codeforce490B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n; // the number of students
		int[] f_order;
		int[] s_order;
		int[] result;

		try {
			n = s.nextInt();
			if (n < 2 || n > 200000) {
				new Exception();
			} else {
				f_order = new int[n]; //ù��° ��
				s_order = new int[n]; //�ι�° ��
				result = new int[n];

				//�Է�
				for (int i = 0; i < n; i++) {
					f_order[i] = s.nextInt();
					s_order[i] = s.nextInt();
				}

				//ī��, Sorting �ҷ���
				int[] f_order_temp = Arrays.copyOf(f_order, f_order.length);
				int[] s_order_temp = Arrays.copyOf(s_order, s_order.length);

				Arrays.sort(f_order_temp);
				Arrays.sort(s_order_temp);

				//rank�ű��(�����ű��)
				int[] rank = new int[n];
				for (int i = 0; i < rank.length; i++) {
					rank[i] = Arrays.binarySearch(f_order_temp, f_order[i]);
				}
				
				// System.out.println(Arrays.toString(rank));

				// ù��° �� �������� �����ϱ� ���� �ʿ�.
				int[] s2_order_temp = new int[n]; //ù��° �� �����Ѱſ� �°� �ι�° �� ����
				int id = 0;
				for (int i : rank) {
					// System.out.println(i);
					s2_order_temp[i] = s_order[id];
					id++;
				}

				// System.out.println(Arrays.toString(s2_order_temp));
				int head = 0; //ù��° ��ġ��
				
				int index_1 = 0; //ù��° ��ġ�� �ε���
				int index_2 = 0; //�ι�° ��ġ�� �ε���
				
				
				for (int i = 0; i < n; i++) { // ù��° �ε��� �� ã��. index_1=0 �� ��.
					int index = Arrays.binarySearch(s_order_temp, f_order_temp[i]);
					if (index < 0) {
						head = f_order_temp[i];
						break;
					}
				}
				
				index_1 = Arrays.binarySearch(f_order_temp, head); //92�� �ִ� ��ġ = head
				index_2 = Arrays.binarySearch(f_order_temp, 0);  //0�� �մ� ��ġ

				// System.out.println(index_1+","+index_2);
//				result[0] = head;
//				System.out.println(head);
				result[0] = f_order_temp[index_1]; //ù��° �� ���� (�ι�°���̶� ù��°�� ���ؼ� ù��°���� �ִ¼�)
				result[1] = s2_order_temp[index_2]; //�ι�°�� ����(ù��° ���� 0�ΰ�)

				//head ���� ��ĭ �� �ٸ鼭 insert
				for (int i = 2; i < n; i = i + 2) {
					result[i] = s2_order_temp[index_1];
					index_1 = Arrays.binarySearch(f_order_temp, result[i]);
				}
				
				//head+1���� ��ĭ �� �ٸ鼭 insert
				for (int i = 3; i < n; i = i + 2) {
					index_2 = Arrays.binarySearch(f_order_temp, result[i - 2]);
					result[i] = s2_order_temp[index_2];
				}

				print(result);

			}

		} catch (Exception e) {
			System.out.println("error");
			// TODO: handle exception
		}

	}

	public static void print(int[] result) {
		for (int i = 0; i < result.length; i++) {
			if (i != result.length - 1)
				System.out.print(result[i] + " ");
			else
				System.out.println(result[i]);
		}
	}

}
