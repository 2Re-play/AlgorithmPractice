package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Math1902 {
	static int[] num = new int[100001];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		
		Scanner s = new Scanner(System.in);

		n = Integer.parseInt(s.nextLine().trim());

		for (int i = 1; i <= n; i++) {
			if (!(i == n))
				num[i] = s.nextInt();
			else
				num[i] = Integer.parseInt(s.nextLine().trim());
		}

		int maxSum = 0;
		int nextSum = 0;
		for (int i = 1; i <= n; i++) {

			if (num[i] >= 0) { // num�� ����϶�
				nextSum += num[i];
				if (i == n) {
					if (nextSum > maxSum)
						maxSum = nextSum;
				}
			} else { // num�� �����̸� �� ������ ���� ��� ���ѰŸ� ���ݱ��� ����ū�հ� ��
				if (nextSum > maxSum)
					maxSum = nextSum;
				nextSum = 0;
				continue;
			}

		}
		boolean flag = false; // ��簪�� �����϶��� �����߿� ���� ū���� ����.
		for (int i = 1; i <= n; i++) {
			if (num[i] >= 0) {
				flag = true;
				break;
			}
		}
		int max = num[1];
		if (!flag) {
			for (int i = 2; i <= n; i++) {
				if (max < num[i])
					max = num[i];
			}
			maxSum = max;
		}

		System.out.println(maxSum);

	}

}
