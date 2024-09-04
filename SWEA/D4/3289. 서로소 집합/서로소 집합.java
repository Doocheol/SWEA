
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	static int N, M;
	static int[] parent;
	
	public static void main(String[] args) throws Exception {
		
//		System.setIn(new FileInputStream("src/김두철/A065.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 집합의 개수
			M = Integer.parseInt(st.nextToken()); // 연산의 개수
			parent = new int[N+1];
			
			for (int i = 0; i < N+1; i++) {
				parent[i] = i;
			}
			
			sb.append("#").append(tc).append(" ");
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int INPUT = Integer.parseInt(st.nextToken());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				
				if (INPUT == 0) {
					union(A, B);
				} else {
					if (find(A) != find(B)) {
						sb.append(0);
					} else {
						sb.append(1);
					}
				}
				
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a != b) {
			parent[b] = a;
		}
	}

	private static int find(int x) {
		if (x == parent[x]) return x;
		else return parent[x] = find(parent[x]);
	}
}
