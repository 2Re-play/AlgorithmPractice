
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class backjoon1260 {

	static int n, m, start; // n�� ���� m�� ���� start�� ���� ����

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		boolean exception = false;

		try {

			do {

				n = sc.nextInt(); // ������ ������ �Է¹���

				m = sc.nextInt(); // ������ ������ �Է¹���

				start = sc.nextInt(); // ���� ������ �Է¹���

				// ������ ���� ���� ó��

				if (n < 1 || m < 1 || start < 1) {

					System.out.println("1���� ū ���� �ٽ� �Է����ּ���");

					exception = true;

				} else if (n > 1000 || m > 10000 || start > n) {

					System.out.println("������ ������ 1000���� ������ ������ 10000���� �Դϴ�. �ٽ� �Է����ּ���.");

					exception = true;

				} else {

					exception = false;

				}

			} while (exception == true);

			ArrayList<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList[n + 1];

			// �Ϲ� �迭�� ���������� ArrayList�� ������ �����͸�ŭ�� �޸𸮸� ����ϱ� ������ �޸��� �ս��� ����.

			// ������ �������� �Ѱ� �� �߰� -> �迭�� 0���� n-1�����ε� ���ǻ� 1�� ���ؼ� n���� �̿��ϱ� ����

			// �Է¹��� �� ���ϰ�

			for (int i = 1; i <= n; i++) {

				graph[i] = new ArrayList<Integer>();

			} // 2���� �迭�� ����

			for (int i = 0; i < m; i++) {

				int u = sc.nextInt();

				int v = sc.nextInt();

				graph[u].add(v); // u�� ����� ������ v �߰�

				graph[v].add(u); // v�� ����� ������ u �߰�

			}

			for (int i = 1; i <= n; i++) {

				Collections.sort(graph[i]);

				// �� �������� ���� �� ������ ũ�� ������ ������� ������

				// sort�� �⺻ ��������

			}

			// �� ������ �湮�ߴ��� Ȯ���ϱ� ���� �迭

			boolean[] c = new boolean[n + 1];

			System.out.print("DFS : ");

			dfs(graph, c, start);

			System.out.println();

			// c �迭�� false�� �ʱ�ȭ

			Arrays.fill(c, false);

			System.out.print("BFS : ");

			bfs(graph, c, start);

			System.out.println();

		} catch (Exception e) {

			System.out.println("�ڿ����� �ƴ� ���� �Է��߽��ϴ�. �ٽ� �������ּ���.");

		}

	}

	// DFS�� ������ �Լ�

	// DFS�� ���̿켱Ž��, ��� �Լ� ���

	public static void dfs(ArrayList<Integer>[] a, boolean[] c, int x) {

		if (c[x]) {
			return;
		}
		// �켱 x���� �湮���θ� true�� ����
		c[x] = true;
		// x ���
		System.out.print(x + " ");

		// �ݺ������� �� x�� ����Ǿ� �ִ� ��� ���� Ȯ��

		for (int y : a[x]) {

			// �湮���ΰ� false�̸�

			if (c[y] == false) {

				// ��� �Լ��� �ٽ� dfs ȣ��

				dfs(a, c, y);

			}

		}

	}

	// BFS�� ������ �Լ�

	// BFS�� �ʺ� �켱 Ž������ Queue�� �����

	// Queue�� FIFO ����

	public static void bfs(ArrayList<Integer>[] a, boolean[] c, int start) {

		// �ڹٿ��� �⺻������ �����ϴ� Queue�� ���

		Queue<Integer> q = new LinkedList<Integer>();

		// q�� �������� �Է�

		q.add(start);

		// �������� �湮 ���θ� true�� ����

		c[start] = true;

		while (!q.isEmpty()) { // queue�� ������� ������ ��� �ݺ�

			int x = q.remove(); // queue���� �ϳ��� ���� x�� ����

			System.out.print(x + " "); // x ���

			for (int y : a[x]) { // �ݺ������� x�� ����� ���� ��� Ȯ��

				if (c[y] == false) { // �湮���ΰ� false ���

					c[y] = true; // �湮���θ� true�� �ٲٰ�

					q.add(y); // q�� �Է�

				}

			}

		}

	}

}
