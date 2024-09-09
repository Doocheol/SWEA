import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {

//		System.setIn(new FileInputStream("src/김두철/SWEA_1267_작업순서.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		
		for (int tc = 1; tc<=10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			List<Integer>[] adj = new ArrayList[V+1];
			int[] degree = new int[V+1];
			
			for (int i = 0; i <= V; i++) {
				adj[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < E; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adj[from].add(to);
				degree[to]++;
			}
			
			Deque<Integer> queue = new ArrayDeque<>();
			for (int i = 1; i <= V; i++) {
				if (degree[i] == 0) {
					queue.offer(i);
				}
			}
			
			sb.append("#").append(tc).append(" ");
			while(!queue.isEmpty()) {
				int current = queue.poll();
				sb.append(current).append(" ");
				for (int next : adj[current]) {
					degree[next]--;
					if (degree[next] == 0) {
						queue.offer(next);
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

}
