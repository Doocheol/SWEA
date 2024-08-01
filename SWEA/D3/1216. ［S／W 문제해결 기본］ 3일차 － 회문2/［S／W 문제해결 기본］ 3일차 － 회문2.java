import java.io.*;
import java.util.*;

/* 아이디어 노트
 * 1. 100 * 100 배열 사이즈 받기
 * 2. 'A', 'B', 'C' 3가지 데이터
 * 3. 가로, 세로 = 직선만 회문 파악
 * 4. 테스트케이스 : 총 10개
 * 5. 문제번호 N 입력받기
 * 6. 전체 데이터 받기
 * 7. 행/열로 데이터 구조 전환하는데 A그룹(행으로 읽기), B그룹(열로 읽기)
 * 8. 메서드 사용 필요. 1행을 살피는데, 1칸씩 당기면서 계속 살펴야함. (while true)
 * 9. 가장 긴 회문값 max에 계속 담기(Math.max)
 */

public class Solution {
	public static void main(String[] args) throws Exception {
	//	System.setIn(new FileInputStream("src/김두철/A018.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		// 100*100 배열 생성
		int N = 100;
		char[][] map = new char[N][N];
		
		// START testcase 10개
		for (int tc = 1; tc <= 10; tc++) {
			int number = Integer.parseInt(br.readLine().trim());
			
			// 데이터 받기
			for (int r = 0; r < N; r++) {
			    String str = br.readLine().trim();
			    for (int c = 0; c < N; c++) {
			        map[r][c] = str.charAt(c);
			    }
			}
			// 가장 긴 회문의 길이(기본값 1)
			int max = 1;
			
			// 행 1줄당 가장 긴 길이 확인
            for (int r = 0; r < N; r++) {
                for (int start = 0; start < N; start++) {
                    for (int end = N - 1; end > start; end--) {
                        if (checkRow(map, start, end, r)) {
                            max = Math.max(max, end - start + 1);
                        }
                    }
                }
            }
			// 열 1줄당 가장 긴 길이 확인
            for (int c = 0; c < N; c++) {
                for (int start = 0; start < N; start++) {
                    for (int end = N - 1; end > start; end--) {
                        if (checkColumn(map, start, end, c)) {
                            max = Math.max(max, end - start + 1);
                        }
                    }
                }
            }
            // 데이터 append
            sb.append("#").append(number).append(" ").append(max).append("\n");
		}
		// 데이터 출력
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
    // 행에서 1줄당 가장 긴 회문을 확인하는 메서드
    static boolean checkRow(char[][] arr, int start, int end, int row) {
        while (start < end) {
            if (arr[row][start] != arr[row][end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    // 열에서 1줄당 가장 긴 회문을 확인하는 메서드
    static boolean checkColumn(char[][] arr, int start, int end, int column) {
        while (start < end) {
            if (arr[start][column] != arr[end][column]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
