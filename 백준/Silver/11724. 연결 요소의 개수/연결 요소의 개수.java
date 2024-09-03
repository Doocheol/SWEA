
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int V, E;
	static int[][] adjMatrix;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		adjMatrix = new int[V + 1][V + 1];
		visited = new boolean[V + 1];
		
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjMatrix[from][to] = adjMatrix[to][from] = 1;
		}
		
		int count = 0;
		for (int i = 1; i <= V; i++) {
			if (!visited[i]) {
				count++;
				dfs(i);
			}
		}
		sb.append(count);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}

	private static void dfs(int v) {

		visited[v] = true;
		
		for (int i = 1; i <= V; i++) {
			if (!visited[i] && adjMatrix[v][i] == 1) {
				dfs(i);
			}
		}
		
		
	}
}
