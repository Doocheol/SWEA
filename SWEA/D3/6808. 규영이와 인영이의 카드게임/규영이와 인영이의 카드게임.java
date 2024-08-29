
import java.io.*;
import java.util.*;

public class Solution {
	
	static int N;
	static int[] input;
	static int[] battle;
	static boolean[] isSelected;
	static int win, lose;
	
	public static void main(String[] args) throws Exception {
		
//		System.setIn(new FileInputStream("src/김두철/A059.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine().trim());
		
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			boolean[] cardlist = new boolean[19];
			
			N = 9;
			
			input = new int[N];
			for (int i = 0; i < N; i++) {
				input[i] = Integer.parseInt(st.nextToken());
				cardlist[input[i]] = true;
			}
			
			int idx = 0;
			battle = new int[N];
			for (int i = 1; i <= cardlist.length - 1; i++) {
				if (cardlist[i] == false) {
					battle[idx++] = i;
				}
			}
			
			isSelected = new boolean[N];

			win = 0;
			lose = 0;
			permutation(0, 0, 0);
			
			sb.append("#").append(tc).append(" ").append(win).append(" ").append(lose).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	
	private static void permutation(int depth, int score_A, int score_B) {

		if (depth == N) {
			if (score_A < score_B) {
				win++;
			} else if ( score_B < score_A) {
				lose++;
			}
			return;
		}
		
		
		for (int i = 0; i < N; i++) {
			if (isSelected[i]) continue;
			isSelected[i] = true;
			if (input[depth] < battle[i]) {
				permutation(depth + 1, score_A + input[depth] + battle[i], score_B);
			} else if (input[depth] > battle[i]){
				permutation(depth + 1, score_A, score_B + input[depth] + battle[i]);
			} else {
				permutation(depth + 1, score_A, score_B);
			}
			isSelected[i] = false;
			
			
		}
		
	}

}
