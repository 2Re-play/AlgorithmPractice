package baekjoon;

import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

//���˹���
public class backjoon3020_version2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);

		int N, H;
		int[] odd_bar_length; // Ȧ����° ��ֹ� ����
		int[] even_bar_length; // ¦����° ��ֹ� ����

		int[] odd_hit_count;// Ȧ����° ��ֹ� �浹 ��
		int[] even_hit_count;
		try {
			N = s.nextInt(); // �׻� ¦��
			H = s.nextInt();

			if (N % 2 != 0 || N < 2 || N > 200000 || H < 2 || H > 500000) {
				new Exception();
			} else {
				odd_bar_length = new int[H + 1];
				even_bar_length = new int[H + 1];
				odd_hit_count = new int[H + 1];
				even_hit_count = new int[H + 1];
				for (int i = 1; i <= N; i++) {
					if (i % 2 != 0) {
						odd_bar_length[s.nextInt()]++;
					} else {
						even_bar_length[s.nextInt()]++;
					}
				}

				for (int i = H; i >= 1; i--) {
					if (i == H) {
						odd_hit_count[i] = odd_bar_length[i];
					} else {
						odd_hit_count[i] = odd_bar_length[i] + odd_hit_count[i + 1];
					}
				}
				for (int i = 1; i <= H; i++) {
					if (i == 1) {
						even_hit_count[i] = even_bar_length[H - i + 1];
					} else {
						even_hit_count[i] = even_bar_length[H - i + 1] + even_hit_count[i - 1];
					}
				}
				int[] result = new int[H + 1];
				for (int i = 1; i <= result.length-1; i++) {
					result[i] = odd_hit_count[i] + even_hit_count[i];
				}

//				System.out.println(Arrays.toString(result));
				
				//�ּҰ� ���ϱ�.
//				int min=result[1];
//				for(int i=2;i<=H;i++){
//					if(min>result[i]){
//						min=result[i];
//					}
//				}
				
				Arrays.sort(result);
				int min=result[1];
				int count=0;
				for(int i=1;i<=H;i++){
					if(result[i]==min){
						count++;
					}
				}
				
				System.out.printf("%d %d",min,count);
			}
		} catch (Exception e) {
			System.out.println("error");
			// TODO: handle exception
		}

	}

}
