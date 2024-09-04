
import java.io.*;
import java.util.*;

public class Main {
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String[] str2 = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str2[j]);
			}
		}
		int[] start = { 0, 0 };
		int ans = bfs(map, new boolean[N][M], start);

		bw.write(Integer.toString(ans));
		bw.flush();
		bw.close();
		br.close();
	}

	static ArrayDeque<int[]> q = new ArrayDeque<>();

	static int bfs(int[][] map, boolean[][] qIn, int[] cur) {
		int[][] distance = new int[N][M];
		distance[0][0] = 1;
		q.offer(cur);
		qIn[cur[0]][cur[1]] = true;
		while (!q.isEmpty()) {
			int[] current = q.poll();
			int x = current[0];
			int y = current[1];
			int[] dx = { 0, 0, -1, 1 };
			int[] dy = { -1, 1, 0, 0 };
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] != 0 && qIn[nx][ny] != true) {
					int[] neew = { nx, ny };
					q.offer(neew);
					qIn[nx][ny] = true;
					distance[nx][ny] = distance[x][y] + 1;
					if (nx == N-1 && ny == M-1) {
						return distance[nx][ny];
					}
				}
			}

		}
		return -1;
	}
}
