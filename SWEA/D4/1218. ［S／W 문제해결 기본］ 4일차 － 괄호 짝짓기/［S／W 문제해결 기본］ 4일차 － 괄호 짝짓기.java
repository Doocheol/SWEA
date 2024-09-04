import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		
//		System.setIn(new FileInputStream("src/김두철/A준비/P012_SWEA1218_괄호짝짓기1_Stack.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			
			int LENGTH = Integer.parseInt(br.readLine().trim());
			
			String line = br.readLine();
			
			Deque<Character> stack = new ArrayDeque<>();
			
			int answer = 0;
			for (int i = 0; i < LENGTH; i++) {
				char ch = line.charAt(i);
				if (ch == '(' || ch == '{' || ch == '<' || ch == '[') {
					stack.push(ch);
				} else {
					if (stack.isEmpty()) {
						answer = 0;
						break;
					}
					
					if ((ch == ')' && stack.pop() != '(') ||
						(ch == '}' && stack.pop() != '{') ||
						(ch == ']' && stack.pop() != '[') ||
						(ch == '>' && stack.pop() != '<')) {
						answer = 0;
						break;
						
					} else {
						answer = 1;
					}
						
				}
				
			}
			
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");;
			
			
			
		} // End testcase
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	} // End main

} // End class
