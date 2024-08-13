
import java.util.*;
import java.io.*;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		
//		System.setIn(new FileInputStream("src/김두철/A044.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= T; tc++) {
			
			Set<Integer> set = new HashSet<>();

			int count = 0;
			int N = Integer.parseInt(br.readLine());
			int currentNumber = N;
			
			
			while (set.size() < 10) {
				int temp = currentNumber;
				
				while (temp > 0) {
					set.add(temp % 10);
					temp /= 10;
				}
				
				count++;
				currentNumber = N * (count + 1);
			}
			
			sb.append("#").append(tc).append(" ").append(currentNumber - N).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
		
	}
	

}
