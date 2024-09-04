import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, M;
	static int[][] adjMatrix;
	static boolean[] isVisited;
	
	public static void main(String[] args) throws Exception {
		
//		System.setIn(new FileInputStream("src/김두철/A067.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			adjMatrix = new int[N+1][N+1];
			isVisited = new boolean[N+1];
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adjMatrix[from][to] = adjMatrix[to][from] = 1;
			}
			
			int groupCount = 0;
			for (int i = 1; i <= N; i++) {
				if (!isVisited[i]) {
					dfs(i);
					groupCount++;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(groupCount).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}

	private static void dfs(int v) {
		isVisited[v] = true;
		
		for (int i = 1; i <= N; i++) {
			if (!isVisited[i] && adjMatrix[v][i] == 1) {
				dfs(i);
			}
		}
		
		
	}

}
