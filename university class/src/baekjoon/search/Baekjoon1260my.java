package baekjoon.search;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//DFS�� BFS
public class Baekjoon1260my {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int N, M, V;// N:�����ǰ���, M:�����ǰ���, V:������
		boolean[] v_node;
		boolean[][] edge_map;
		int a, b; // ������ �����ϴ� �� ����;
		try {
			N = s.nextInt();
			M = s.nextInt();
			V = s.nextInt();

			if (N < 1 || N > 1000 || M < 1 || M > 10000) {
				new Exception();
			} else {
				v_node = new boolean[N + 1];
				edge_map = new boolean[N + 1][N + 1];

				for (int i = 0; i < M; i++) {
					a = s.nextInt();
					b = s.nextInt();
					edge_map[a][b] = true;
					edge_map[b][a] = true;
				}
				
				// System.out.print("DFS:");
				dfs(v_node, edge_map, V); 
				System.out.println();

				Arrays.fill(v_node, false); // �ʱ�ȭ

				// System.out.printf("BFS:");
				bfs(v_node, edge_map, V);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void dfs(boolean[] v_node, boolean[][] edge_map, int start) {

		v_node[start] = true;
		System.out.print(start + " ");
		
		for (int i = 1; i <= v_node.length - 1; i++) { // v_node.length�� N+1
			if (v_node[i] == false && edge_map[start][i] == true) {
				dfs(v_node, edge_map, i);
			}
		}
	}

	public static void bfs(boolean[] v_node, boolean[][] edge_map, int start) {
		Queue<Integer> q = new LinkedList();

		v_node[start] = true;
		q.add(start);
		
		while (!q.isEmpty()) {
			int x = q.remove();// ť���� �ϳ� ���� x�� ����
			System.out.print(x + " ");
			for (int i = 1; i <= v_node.length - 1; i++) {
				if (v_node[i] == false && edge_map[x][i] == true) {
					v_node[i] = true;
					q.add(i);
				}
			}

		}
	}
}
