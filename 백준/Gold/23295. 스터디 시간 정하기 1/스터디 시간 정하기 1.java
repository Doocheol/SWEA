import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		int[] times = new int[100002];
		int maxFinish = 0;
		
		for (int i = 0; i < N; i++) {
			int K = Integer.parseInt(br.readLine());
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int finish = Integer.parseInt(st.nextToken());
				maxFinish = Math.max(maxFinish, finish);
				for (int k = start; k < finish; k++) {
					times[k]++;
				}
			}
		}
		
		for (int i = 1; i < maxFinish; i++) {
			times[i] += times[i-1];
		}
		
		int resTime = T-1, maxLike = times[T-1];
		for (int i = T; i < maxFinish; i++) {
			if (times[i]-times[i-T] > maxLike) {
				resTime = i;
				maxLike = times[i]-times[i-T];
			}
		}
		
		System.out.println((resTime-T+1) + " " + (resTime+1));
	}
}