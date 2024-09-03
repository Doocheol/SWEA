
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
    
    static int N = 12;
    static int daily;
    static int monthly;
    static int quarterly;
    static int yearly;
    static int[] count;
    static int minCost;
    
    public static void main(String[] args) throws Exception {
        
  //      System.setIn(new FileInputStream("src/김두철/A064.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine().trim());
        
        for (int tc = 1; tc <= T; tc++) {
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            daily = Integer.parseInt(st.nextToken());
            monthly = Integer.parseInt(st.nextToken());
            quarterly = Integer.parseInt(st.nextToken());
            yearly = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            count = new int[N];
            for (int i = 0; i < count.length; i++) {
                count[i] = Integer.parseInt(st.nextToken());
            }
            
            minCost = yearly;  // 최대 비용은 연간 이용권의 가격이 될 수 있음
            dfs(0, 0);  // 0번째 달부터, 초기 비용은 0으로 시작
            
            sb.append("#").append(tc).append(" ").append(minCost).append("\n");
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int month, int currentCost) {
        if (currentCost >= minCost) {
            return;  // 이미 최소 비용을 초과한 경우 더 탐색할 필요 없음
        }

        if (month >= N) {
            minCost = Math.min(minCost, currentCost);
            return;
        }
        
        if (count[month] == 0) {
            dfs(month + 1, currentCost);  // 해당 월에 이용하지 않으면 다음 달로 이동
        } else {
            // 일일 이용권 사용
            dfs(month + 1, currentCost + daily * count[month]);
            
            // 월간 이용권 사용
            dfs(month + 1, currentCost + monthly);
            
            // 분기 이용권 사용 (3개월) - 12월을 넘지 않도록 제한
            dfs(month + 3, currentCost + quarterly);
        }
    }
}
