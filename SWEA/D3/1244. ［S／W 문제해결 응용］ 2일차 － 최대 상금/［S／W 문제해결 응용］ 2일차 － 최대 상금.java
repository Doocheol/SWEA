import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

    static int changeCount, max;
    static String initialNumber;
    static Set<String> visited; // 중복 상태 방지를 위한 set

    public static void main(String[] args) throws Exception {
    	
 //   	System.setIn(new FileInputStream("src/김두철/A준비/SWEA1244_최대상금.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            initialNumber = st.nextToken();
            changeCount = Integer.parseInt(st.nextToken());

            max = Integer.MIN_VALUE;
            visited = new HashSet<>();

            dfs(initialNumber, 0);

            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void dfs(String number, int count) {
        // 종료 조건: 교환 횟수 다 사용하면 최대값 갱신 후 종료
        if (count == changeCount) {
            max = Math.max(max, Integer.parseInt(number));
            return;
        }

        // 이미 방문한 상태는 더 이상 탐색하지 않음 (중복 방지)
        if (visited.contains(number + count)) {
            return;
        }
        visited.add(number + count);

        int length = number.length();

        // 두 자리 숫자를 선택하여 교환
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                // 숫자 교환
                String swapped = swap(number, i, j);
                // 다음 단계 탐색
                dfs(swapped, count + 1);
            }
        }
    }

    private static String swap(String number, int i, int j) {
        char[] chars = number.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
}
