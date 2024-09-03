import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int [][] arr;
	static boolean [][] visit;
	static int dr [] = {-1,1,0,0};
	static int dc [] = {0,0,-1,1};
	static int cnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str [] = br.readLine().trim().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		
		cnt = 0;
		arr = new int[n+2][m+2];
		visit = new boolean[n+2][m+2]; 
		for(int i = 1;i<n+1;i++) {
			String strarr = br.readLine();
			for(int j = 1;j<m+1;j++) {
				arr[i][j] = strarr.charAt(j-1) - '0';
			}
		}
		
		bfs(1,1);
		
		System.out.println(arr[n][m]);
//		for(int arr1[] : arr) {
//			for(int x : arr1) {
//				System.out.print(x + " ");
//			}
//			System.out.println();
//		}
//	}
	}
	private static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {i,j});
		visit[i][j] = true;
		while(!q.isEmpty()) {
			int [] now = q.poll();
			int r = now[0];
			int c = now[1];
			for(int k = 0;k<4;k++) {
				int nr = r+ dr[k];
				int nc = c+ dc[k];
				
				if(arr[nr][nc] == 0 || visit[nr][nc] ) {
					continue;
				}
				arr[nr][nc] = arr[r][c]+1;
				visit[nr][nc] = true;
				q.add(new int[] {nr,nc});
			}
			
		}
		}
	}
