import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, limit, max;
	static int[][] ing;

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/윤다은/A054_SWEA_5215_햄버거다이어트.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(100);
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			limit = Integer.parseInt(st.nextToken());
			
			ing = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				ing[i][0] = Integer.parseInt(st.nextToken());
				ing[i][1] = Integer.parseInt(st.nextToken());
			}
			
			max = 0;
			burger(0, 0, 0);
			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void burger(int depth, int like, int calories) {
		if (calories > limit) return;
		if (depth == N) {
			max = Math.max(max, like);
			return;
		}
		
		burger(depth+1, like+ing[depth][0], calories+ing[depth][1]);
		burger(depth+1, like, calories);
	}
}