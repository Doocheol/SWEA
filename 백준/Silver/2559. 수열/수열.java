import java.io.*;
import java.util.*;


public class Main {
	
	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int SIZE = Integer.parseInt(st.nextToken());
		int consecutive = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[SIZE];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < SIZE; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < SIZE-(consecutive-1); i++) {
			
			int sum = 0;
			
			for (int j = i; j < i + consecutive; j++) {
				sum += arr[j];
			}
			
			max = Math.max(max, sum);
		}
		
		
		sb.append(max);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
