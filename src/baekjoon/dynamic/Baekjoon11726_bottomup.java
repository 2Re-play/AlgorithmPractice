package baekjoon.dynamic;

import java.util.*;

//2��n Ÿ�ϸ� D[n]=2xN ���簢���� ä��� ����� �� 
public class Baekjoon11726_bottomup {
	static int[] d=new int[1001];
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		try {
			int n=s.nextInt();
			
			if(n<1 || n>1000){
				new Exception();
			}else{
				int result=dp(n);
				System.out.println(result%10007);
			}
		} catch (Exception e) {
			System.out.println("error");
			// TODO: handle exception
		}
	}
	public static int dp(int n){
		d[0]=1;
		d[1]=1;
		
		for(int i=2;i<=n;i++){
			d[i]=(d[i-1]+d[i-2])%10007;
		}
		
		return d[n];
	}
}
