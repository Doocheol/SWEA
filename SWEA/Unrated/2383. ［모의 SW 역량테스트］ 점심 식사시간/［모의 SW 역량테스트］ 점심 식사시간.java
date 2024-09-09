import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

    // 사람 정보를 담는 클래스
    static class Person implements Comparable<Person> {
        int r, c, d, t;  // 행, 열, 계단까지의 거리(d), 선택한 계단 번호(t)

        // 생성자: 사람의 위치(행, 열)를 저장
        public Person(int r, int c) {
            this.r = r;
            this.c = c;
        }

        // 계단까지의 거리(d)를 기준으로 오름차순 정렬하기 위한 compareTo 메소드
        @Override
        public int compareTo(Person o) {
            return this.d - o.d;  // 거리(d)가 작은 순서대로 정렬
        }
    }

    // 전역 변수 선언
    static int T, N, perIdx, min;  // 테스트 케이스 수, 맵 크기, 사람 수, 최소 시간
    static int[][] map, stair;     // 맵 정보와 계단 정보
    static Person[] per;           // 사람들의 정보 배열
    
    public static void main(String[] args) throws Exception {
    	
        // 입력을 파일에서 받아오기 위한 설정
 //       System.setIn(new FileInputStream("src/김두철/A062.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
    	
        // 테스트 케이스 수 입력
        int T = Integer.parseInt(br.readLine().trim());

        // 각 테스트 케이스 처리
        for (int tc = 1; tc <= T; tc++) {
        	
            // 맵의 크기(N) 입력
            int N = Integer.parseInt(br.readLine().trim());
            
            // 사람 배열과 맵, 계단 배열 초기화
            per = new Person[N * N];  // 최대 크기로 사람 배열 생성
            int idx = 0;              // 계단의 인덱스
            perIdx = 0;               // 사람 수 인덱스
            stair = new int[2][3];     // 계단 정보: [계단 번호][0:세로, 1:가로, 2:계단 길이]
            map = new int[N][N];       // 맵 정보
            
            // 맵 정보 입력
            for (int row = 0; row < N; row++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int column = 0; column < N; column++) {
                    map[row][column] = Integer.parseInt(st.nextToken());

                    // 맵에서 사람(1)이면 Person 객체로 저장
                    if (map[row][column] == 1) {
                        per[perIdx++] = new Person(row, column);
                    }

                    // 맵에서 계단(2 이상)이면 계단 정보 저장
                    if (map[row][column] >= 2) {
                        stair[idx][0] = row;        // 계단의 세로 위치
                        stair[idx][1] = column;     // 계단의 가로 위치
                        stair[idx][2] = map[row][column];  // 계단의 길이
                        idx++;  // 두 번째 계단을 위해 인덱스 증가
                    }
                }
            }

            // 최소 시간 초기화
            min = Integer.MAX_VALUE;

            // 사람들의 계단 선택 경우의 수를 처리하는 powerset 함수 호출
            powerset(0);

            // 결과 저장
            sb.append("#").append(tc).append(" ").append(min).append("\n");
        }

        // 결과 출력
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // 사람들의 계단 선택을 결정하는 부분집합 생성 함수
    private static void powerset(int idx) {

        // 모든 사람이 계단을 선택한 경우 (기저 조건)
        if (idx == perIdx) {
            int max = 0;  // 현재 선택된 계단 사용 중 가장 긴 시간을 저장할 변수

            // 두 개의 계단에 대해 각각 시뮬레이션
            for (int i = 0; i < 2; i++) {
                PriorityQueue<Person> pq = new PriorityQueue<>();  // 계단까지 도착하는 순서대로 처리하기 위한 우선순위 큐
                int[] time = new int[200];  // 각 시간대별로 계단에 있는 사람 수를 기록할 배열 (최대 시간 범위를 고려하여 충분히 큰 값 설정)

                // 선택된 계단(i)을 사용할 사람들을 우선순위 큐에 추가
                for (int j = 0; j < perIdx; j++) {
                    if (per[j].t == i) {  // 해당 사람이 i번째 계단을 선택했는지 확인
                        pq.add(per[j]);   // 계단까지의 거리에 따라 큐에 추가
                    }
                }

                int end = 0;  // 계단을 완전히 내려가는 마지막 시간을 기록하는 변수

                // 큐가 빌 때까지 반복 (모든 사람이 계단을 내려갈 때까지)
                while(!pq.isEmpty()) {
                    Person cur = pq.poll();  // 가장 먼저 계단에 도착한 사람부터 처리
                    int start = cur.d;  // 계단에 도착하는 시간
                    end = start + stair[cur.t][2];  // 계단을 내려가는데 걸리는 시간 (도착 시간 + 계단의 길이)

                    // 계단을 내려가는 동안 시간대별로 사람 수를 체크
                    for (int j = start; j < end; j++) {
                        if (time[j] == 3) {  // 해당 시간대에 이미 3명이 계단을 사용 중이면
                            end++;  // 대기해야 하므로 계단을 내려가는 시간이 늦어짐
                            continue;
                        }
                        time[j]++;  // 해당 시간대에 계단을 사용하는 사람 수 증가
                    }

                    // 현재 사람의 계단 내려가는 마지막 시간이 max보다 크면 갱신
                    if (max < end) {
                        max = end;
                    }
                }
            }

            // 두 계단 중 가장 늦게 내려간 시간이 최소 시간보다 작으면 갱신
            if (min > max) {
                min = max;
            }

            return;  // 모든 경우의 수를 탐색했으므로 재귀 종료
        }

        // 첫 번째 계단에 대해 현재 사람의 이동 시간을 계산 (맨해튼 거리)
        per[idx].d = Math.abs(per[idx].r - stair[0][0]) + Math.abs(per[idx].c - stair[0][1]) + 1;
        per[idx].t = 0;  // 첫 번째 계단 선택
        powerset(idx + 1);  // 다음 사람에 대해 재귀 호출

        // 두 번째 계단에 대해 현재 사람의 이동 시간을 계산 (맨해튼 거리)
        per[idx].d = Math.abs(per[idx].r - stair[1][0]) + Math.abs(per[idx].c - stair[1][1]) + 1;
        per[idx].t = 1;  // 두 번째 계단 선택
        powerset(idx + 1);  // 다음 사람에 대해 재귀 호출
    }
}
