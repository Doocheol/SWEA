
import java.io.*;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		
	//	System.setIn(new FileInputStream("src/김두철/A030.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine().trim());
			
			int[] price = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			
			long answer = 0;
			int[] max = new int[N];
			max[N - 1] = price[N - 1];
			for (int i = N - 2; i >= 0; i--) {
					max[i] = Math.max(price[i], max[i + 1]);
			}
			
			for (int i = 0; i < N; i++) {
				answer += max[i] - price[i];
			}
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
			
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}

}
