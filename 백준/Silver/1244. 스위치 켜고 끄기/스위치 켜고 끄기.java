import java.io.*;

public class Main {
	/*
	 * 1 : on 0 : off
	 * 
	 * 1 : 남 2 : 여
	 */
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("스위치켜고끄기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine()); // 스위치 개수
		boolean[] onoff = new boolean[N];
		String[] oneLine = br.readLine().trim().split(" ");

		for (int n = 0; n < N; n++) { // 초기 스위치 배열 저장
			if (oneLine[n].equals("0"))
				onoff[n] = false;
			else if (oneLine[n].equals("1"))
				onoff[n] = true;
		}

		int S = Integer.parseInt(br.readLine()); // 학생 수

		for (int s = 0; s < S; s++) {
			String[] MF_num = br.readLine().trim().split(" "); // 성별, 숫자
			int num = Integer.parseInt(MF_num[1]); // X번째 스위치 (X-1인덱스 위치)

			if (MF_num[0].equals("1")) { // 남자
				for (int x = 1; x <= N / num; x++) {
					int i = x * num;
					onoff[i - 1] = !onoff[i - 1];
				}
				
			} else if (MF_num[0].equals("2")) { // 여자
				onoff[num - 1] = !onoff[num - 1];
				for (int x = 1; x < Math.min(N - num + 1, num); x++) {
					if (onoff[num - 1 - x] == onoff[num - 1 + x]) {
						onoff[num - 1 - x] = !onoff[num - 1 - x];
						onoff[num - 1 + x] = !onoff[num - 1 + x];
					} else break;
				}
			}
		}

		int cnt=0;
		for (int n = 0; n < N; n++) {
			if (onoff[n] == true) {
				sb.append("1").append(" ");
				cnt++;
			}
				
			else if (onoff[n] == false) {
				sb.append("0").append(" ");
				cnt++;
			}
			
			if (cnt%20==0) sb.append("\n");
				
		}
		bw.write(sb.toString());
		bw.close();
	}

}