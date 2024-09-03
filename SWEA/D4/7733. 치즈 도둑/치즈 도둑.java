import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {

	static int N, maxCount;
	static int[][] board;
	static boolean[][] visited;
	static int maxCheese, minCheese;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		
//		System.setIn(new FileInputStream("src/김두철/A063.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			minCheese = Integer.MAX_VALUE;
			maxCheese = Integer.MIN_VALUE;
			for (int row = 0; row < N; row++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int column = 0; column < N; column++) {
					board[row][column] = Integer.parseInt(st.nextToken());
					maxCheese = Math.max(maxCheese, board[row][column]);
					minCheese = Math.min(minCheese, board[row][column]);
				}
			}
			
			maxCount = 1;
			for (int day = minCheese; day <= maxCheese; day++) {
				visited = new boolean[N][N];
				int areaCount = 0;
				
				for (int row = 0; row < N; row++) {
					for (int column = 0; column < N; column++) {
						if (board[row][column] > day && !visited[row][column]) {
							bfs(row, column, day);
							areaCount++;
						}
					}
				}
				maxCount = Math.max(maxCount, areaCount);
			}
			sb.append("#").append(tc).append(" ").append(maxCount).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static void bfs(int x, int y, int day) {
		Deque<Integer> queueX = new ArrayDeque<>();
		Deque<Integer> queueY = new ArrayDeque<>();
		
		queueX.offer(x);
		queueY.offer(y);
		visited[x][y] = true;
		
		while (!queueX.isEmpty() && !queueY.isEmpty()) {
			int currentX = queueX.poll();
			int currentY = queueY.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = currentX + dr[d];
				int nc = currentY + dc[d];
				
				if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
					if (!visited[nr][nc] && board[nr][nc] > day) {
						queueX.offer(nr);
						queueY.offer(nc);
						visited[nr][nc] = true;
					}
				}
			}
		}
		

		
	}

	
}
