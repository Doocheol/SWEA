import java.io.*;
import java.util.*;

public class Main {
	static final int INF = Integer.MAX_VALUE;
	
	//우선순위큐 사용
	static class edge implements Comparable<edge>{
		int v;
		int w;
		
		edge(int v, int w) {
			this.v = v;
			this.w = w;
		}
		
		@Override
		public int compareTo(edge n) {
			return this.w - n.w;
		};
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int V = Integer.parseInt(s[0]);
		int E = Integer.parseInt(s[1]);
		
		int start = Integer.parseInt(br.readLine());
		
		ArrayList<edge>[] list = new ArrayList[V+1];
		
		for (int i = 1; i <= V; i++) list[i] = new ArrayList<>();
		
		for (int i = 0; i < E; i++) {
			s = br.readLine().split(" ");
			edge tmp = new edge(Integer.parseInt(s[1]), Integer.parseInt(s[2]));
			list[Integer.parseInt(s[0])].add(tmp);
		}
		
		int[] min = new int[V+1];
		Arrays.fill(min, INF);
		min[start] = 0;
		
		PriorityQueue<edge> find = new PriorityQueue();
		int len = list[start].size();
		edge t = new edge(start, 0);
		find.offer(t);
		
		while (!find.isEmpty()) {
			edge tmp = find.poll();
			len = list[tmp.v].size();
			
			for (int i = 0; i < len; i++) {
				edge next = list[tmp.v].get(i);
				
				if (min[next.v]>min[tmp.v]+next.w) {
					min[next.v] = min[tmp.v]+next.w;
					find.offer(new edge(next.v, min[next.v]));
				}
			}
		}
		
		for (int i = 1; i <= V; i++) {
			System.out.println(min[i]==INF ? "INF" : min[i]);
		}
	}
}