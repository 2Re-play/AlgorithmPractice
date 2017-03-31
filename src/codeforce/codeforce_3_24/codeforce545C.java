package codeforce.codeforce_3_24;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

//3.21 C. Woodcutters
public class codeforce545C {
	static int[] cut_dir;// ���� 0,1,2 / 0�Ⱦ�����,1����,2������
	static int count = 0;// �ڸ� ��

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);

		int n; // Ʈ�� ��
		int x, h; // ��ǥ, ����
		ArrayList<int[]> tree = new ArrayList<int[]>(); // Ʈ��
		
		
		tree.add(new int[] { -Integer.MAX_VALUE, 1 });// Ʈ�� 0��°�� �߰�.
		try {
			n = s.nextInt();

			if (n < 1 || n > 100000) {
				new Exception();
			} else {
				for (int i = 0; i < n; i++) {
					x = s.nextInt();
					h = s.nextInt();

					tree.add(new int[] { x, h });
				}
				cut_dir = new int[n + 1];

				cut_dir[0] = 0; // 0��° Ʈ���� ������.
				cut_dir[1] = 1; // 1��° Ʈ���� �������� ����Ʈ��.				
				count++; //1��° Ʈ�� �������� ����Ʈ��
				//����ó��
				if(n!=1){
					cut_dir[n]=2; //n��° Ʈ�� ���������� ����Ʈ��
					count++;
				}
				
				for (int i = 2; i < tree.size()-1; i++) { // tree.size() == n+1
					check(i, tree);
				}
				System.out.println(count);
			}
		} catch (Exception e) {
			System.out.println("error");
		}
	}

	public static void check(int i, ArrayList<int[]> tree) {
		if (cut_dir[i - 1] == 2) {
			if (tree.get(i)[0] - tree.get(i - 1)[0] > tree.get(i)[1] + tree.get(i - 1)[1]) {
//				System.out.println(tree.get(i)[0]);
				cut_dir[i] = 1;
				count++;
			} else {
//				System.out.println(tree.get(i)[0]);
				if (tree.get(i + 1)[0] - tree.get(i)[0] > tree.get(i)[1] && (tree.get(i)[0] + tree.get(i)[1] <= 1000000000)) {
					cut_dir[i] = 2;
					count++;
				} else {
					cut_dir[i] = 0;
				}
			}
		} else {
//			System.out.println(tree.get(i)[0]);
			if (tree.get(i)[0] - tree.get(i - 1)[0] > tree.get(i)[1]) {
				cut_dir[i] = 1;
				count++;
			} else {
				if (tree.get(i + 1)[0] - tree.get(i)[0] > tree.get(i)[1] && (tree.get(i)[0] + tree.get(i)[1] <= 1000000000)) {
					cut_dir[i] = 2;
					count++;
				} else {
					cut_dir[i] = 0;
				}
			}
		}
	}

}
