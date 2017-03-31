package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class backjoon1260my2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N, M, V;// N:�����ǰ���, M:�����ǰ���, V:������
		boolean[] v_node;
		int a,b; // ������ �����ϴ� �� ����;
		try {
			N = s.nextInt();
			M = s.nextInt();
			V = s.nextInt();

			if (N < 1 || N > 1000 || M < 1 || M > 10000){
				new Exception();
			} else {
				v_node = new boolean[N + 1];
				ArrayList<Integer>[] graph =new ArrayList[N+1];
				
				for (int i = 1; i <= graph.length-1; i++) {
					graph[i]=new ArrayList<Integer>();
				}

				for (int i = 0; i < M; i++) {
					a = s.nextInt();
					b = s.nextInt();
					graph[a].add(b);
					graph[b].add(a);
				}
				
				for (int i = 1; i <= graph.length-1; i++) {
					Collections.sort(graph[i]);
				}
				
				// System.out.print("DFS:");
				dfs(v_node, graph, V);
				System.out.println();

				Arrays.fill(v_node, false); // �ʱ�ȭ

				// System.out.printf("BFS:");
				bfs(v_node, graph, V);
			}
		} catch (Exception e) {
			System.out.println("error");
			// TODO: handle exception
		}

	}
	// DFS�� ������ �Լ�

	// DFS�� ���̿켱Ž��, ��� �Լ� ���
	public static void dfs(boolean[] v_node, ArrayList<Integer>[] group, int x) {
		// �켱 start���� �湮���θ� true�� ����
		v_node[x] = true;
		System.out.print(x + " ");
		
		// �ݺ������� start���� ����Ǿ� �ִ� ��� ���� Ȯ��
		for(int i : group[x]){
			if(v_node[i]==false){
				// ��� �Լ��� �ٽ� dfs ȣ��
				dfs(v_node,group,i);
			}
		}
	}
	
	// BFS�� ������ �Լ�
	// BFS�� �ʺ� �켱 Ž������ Queue�� �����
	// Queue�� FIFO ����
	public static void bfs(boolean[] v_node, ArrayList<Integer>[] group, int start) {
		Queue<Integer> q = new LinkedList();
		
		// �������� �湮 ���θ� true�� ����
		v_node[start] = true;
		// q�� �������� �Է�
		q.add(start);

		while (!q.isEmpty()) { // queue�� ������� ������ ��� �ݺ�

			int x = q.remove();// ť���� �ϳ� ���� x�� ����
			System.out.print(x + " ");
			
			// �ݺ������� start�� ����� ���� ��� Ȯ��
			for(int i : group[x]){
				if(v_node[i]==false){
					v_node[i]=true;
					q.add(i);
				}
			}
		}
	}
}
