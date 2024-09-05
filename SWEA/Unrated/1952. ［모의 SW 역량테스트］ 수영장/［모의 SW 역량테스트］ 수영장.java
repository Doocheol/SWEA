
import java.io.*;
import java.util.*;

public class Solution {
	
	static final int TOTAL_MONTHS = 12;
	static int[] count;
	static int daily, monthly, threeMonthly, yearly, minCost;
	
	public static void main(String[] args) throws Exception {
		
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			daily = Integer.parseInt(st.nextToken());
			monthly = Integer.parseInt(st.nextToken());
			threeMonthly = Integer.parseInt(st.nextToken());
			yearly = Integer.parseInt(st.nextToken());
			
			count = new int[TOTAL_MONTHS + 1];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= TOTAL_MONTHS; i++) {
				count[i] = Integer.parseInt(st.nextToken());
			}
			
			minCost = yearly;
			dfs(1, 0);
			sb.append("#").append(tc).append(" ").append(minCost).append("\n");
			
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}

	private static void dfs(int month, int currentCost) {
		if (currentCost >= minCost) {
			return;
		}
		
		if (month > TOTAL_MONTHS) {
			minCost = Math.min(minCost, currentCost);
			return;
		}
		
		if (count[month] == 0) {
			dfs(month + 1, currentCost);
		} else {
			dfs(month + 1, currentCost + daily * count[month]);
			dfs(month + 1, currentCost + monthly);
			dfs(month + 3, currentCost + threeMonthly);
		}
		
	}

}
