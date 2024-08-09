
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		
	//	System.setIn(new FileInputStream("src/김두철/A028.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine().trim());
		
		
		for (int tc = 1; tc<=T; tc++) {
			
			int N = Integer.parseInt(br.readLine().trim());
			
			int[][] board  = new int[N][N];
			
			for (int r = 0; r < N; r++) {
				String[] line = br.readLine().split("");
				for (int c = 0; c < N; c++) {
					board[r][c] = Integer.parseInt(line[c]);
				}
			}
			
			int sum = 0;
			int start = N / 2;
			int end = N / 2;
			
			for (int r = 0; r < N; r++) {
				for (int c = start; c <= end; c++) {
					
					sum += board[r][c];
					
				}
				
				if (r < N / 2) {
					start--;
					end++;
				} else {
					start++;
					end--;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(sum).append("\n");
			
			
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
		
	}
	
}
