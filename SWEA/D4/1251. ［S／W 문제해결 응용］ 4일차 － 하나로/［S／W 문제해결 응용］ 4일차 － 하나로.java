
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	static class Edge implements Comparable<Edge>{
		int A;
		int B;
		double W; // 해저 터널의 길이
		
		public Edge(int a, int b, double dist) {
			super();
			this.A = a;
			this.B = b;
			this.W = dist;
		}
		
		@Override
		public String toString() {
			return "Edge [A=" + A + ", b=" + B + ", w=" + W + "]";
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Double.compare(this.W, o.W); // 거리 기준으로 오름차순 정렬
		}
		
	}
	
	static int N;
	static int[] parent;
	
	public static void main(String[] args) throws Exception {
		
//		System.setIn(new FileInputStream("src/김두철/A066.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			int[] x = new int[N];
			int[] y = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				y[i] = Integer.parseInt(st.nextToken());
			}
			
			double E = Double.parseDouble(br.readLine()); // 환경 부담 세율
			
			// Edge 리스트를 우선순위 큐로 관리 (최소 힙)
            PriorityQueue<Edge> pq = new PriorityQueue<>();
            
            for (int i = 0; i < N; i++) {
            	for (int j = i + 1; j < N; j++) {
            		double dist = Math.pow(x[i] - x[j], 2) + Math.pow(y[i] - y[j], 2);
            		pq.offer(new Edge(i, j, dist));
            	}
            }
            
            parent = new int[N];
            for (int i = 0; i < N; i++) {
            	parent[i] = i;
            }
            
            int edgeCount = 0;
            double totalCost = 0;
            
            while (!pq.isEmpty()) {
            	Edge edge = pq.poll();
            	if (union(edge.A, edge.B)) {
            		totalCost += edge.W;
            		edgeCount++;
            		if (edgeCount == N - 1) break;
            	}
            }
            
            totalCost *= E;
            sb.append("#").append(tc).append(" ").append(Math.round(totalCost)).append("\n");

		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}

	private static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a != b) {
			parent[b] = a;
			return true;
		}
		
		return false;
	}

	private static int find(int x) {
		if (parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	
}
