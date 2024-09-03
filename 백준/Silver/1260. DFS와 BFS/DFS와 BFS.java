
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static boolean[] visited, qIn;
	static ArrayDeque<Integer> q = new ArrayDeque<>();
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder(100);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		
		int[][] adjMatrix = new int[N+1][N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjMatrix[from][to] = adjMatrix[to][from] = 1;
		}
		
		visited = new boolean[N+1];
		dfs(adjMatrix, start);
		
		sb.append("\n");
		
		qIn = new boolean[N+1];
		bfs(adjMatrix, start);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}

	private static void dfs(int[][] adjMatrix, int cur) {
		visited[cur] = true;
		sb.append(cur).append(" ");
		
		for (int i = 1; i <= N; i++) {
			if (!visited[i] && adjMatrix[cur][i] != 0) {
				dfs(adjMatrix, i);
			}
		}

		
	}

	private static void bfs(int[][] adjMatrix, int cur) {
		q.offer(cur);
		qIn[cur] = true;
		while(!q.isEmpty()) {
			int current = q.poll();
			sb.append(current).append(" ");
			for (int i = 1; i <= N; i++) {
				if (!qIn[i] && adjMatrix[current][i] != 0) {
					q.offer(i);
					qIn[i] = true;
				}
			}
		}
		
	}
	
}
