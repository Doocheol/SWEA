
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[][] adjMatrix, visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static Deque<int[]> queue = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adjMatrix = new int[N][M];
		visited = new int[N][M];
		
		for (int row = 0; row < N; row++) {
			String[] line = br.readLine().split("");
			for (int column = 0; column < M; column++) {
				adjMatrix[row][column] = Integer.parseInt(line[column]);
				visited[row][column] = -1;
			}
		}
		
		bfs(0, 0);
		sb.append(visited[N-1][M-1]);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}

	private static void bfs(int x, int y) {
		queue.offer(new int[] {x, y});
		visited[x][y] = 1; // true 표시
		
		while(!queue.isEmpty()) {
			int[] currentXY = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nr = currentXY[0] + dr[d];
				int nc = currentXY[1] + dc[d];
				
				if (!(nr < 0 || nr >= N || nc < 0 || nc >= M)) {
					if (adjMatrix[nr][nc] == 1 && visited[nr][nc] == -1) {
						queue.offer(new int[] {nr, nc});
						visited[nr][nc] = visited[currentXY[0]][currentXY[1]] + 1;
					}
				}
			}
		}
		
		
	}

}
