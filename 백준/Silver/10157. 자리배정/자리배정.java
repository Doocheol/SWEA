import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("자리배정.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String [] oneLine = br.readLine().trim().split(" ");
		int C = Integer.parseInt(oneLine[0]);
		int R = Integer.parseInt(oneLine[1]);
		int K = Integer.parseInt(br.readLine());
		
		// 공연장 만들기
		int[][]arr = new int[R][C];
		boolean[][]visited = new boolean[R][C];
		int val = 1;
		
		// 델티 배열
		int[] dr = {-1, 0, 1, 0};
		int[] dc = { 0, 1, 0,-1};
		
		int d=0;
		int r=R-1; 
		int c=0; 
		
		// 순회
		for(int i=0; i<C*R; i++) {
			arr[r][c] = val++;
			visited[r][c] = true;
			
			// 새로 갈 곳
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			// 결계를 넘지 않거나, 방문하지 않았을 때 실행
			if(nr>=0 && nr<R && nc>=0 && nc<C && !visited[nr][nc]) {
				r = nr;
				c = nc;
			} else {
				d= (d+1)%4;
				r= r+dr[d];
				c= c+dc[d];
			}
		}
		
		
		//출력
		if (C*R<K) System.out.print("0");
		else {
			out : for(int rr=0; rr<R; rr++) {
				for(int cc=0; cc<C; cc++) {
					if (arr[rr][cc]==K) {
						System.out.print(cc+1+" "+(R-rr));
						break out;
					}
				}
			}
		}
	}

}
