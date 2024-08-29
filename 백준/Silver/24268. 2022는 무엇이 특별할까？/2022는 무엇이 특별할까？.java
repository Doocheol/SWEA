import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0])+1;
		int d = Integer.parseInt(s[1]);
		

		N = Math.max(N, (int)Math.pow(d, d-1));
		
		int[] jinbub = new int[d];
		
		int tmp = N;
		for (int i = d-1; i >= 0; i--) {
			jinbub[i] = tmp%d;
			tmp /= d;
		}
		
		if (tmp != 0) {
			System.out.println(-1);
			return;
		}
		
		int[] check = new int[d];
		int brk=-1;
		for (int i = 0; i < d; i++) {
			check[jinbub[i]]++;
			
			if (check[jinbub[i]] == 2) {
				brk = i;
				break;
			}
		}
		
		if (brk == -1) {
			System.out.println(N);
			return;
		}
		
		int i;
		for (i = brk; i >= 0; i--) {
			int exist = 0;
			for (int j = jinbub[i]+1; j < d; j++) {
				if (check[j] == 0) {
					exist = j;
					break;
				}
			}
			
			check[jinbub[i]]--;
			
			if (exist != 0) {
				jinbub[i] = exist;
				check[exist] = 1;
				break;
			}
		}
		
		if (i < 0) {
			System.out.println(-1);
			return;
		} else {
			int cur = i+1;
			for (int j = 0; j < d; j++) {
				if (check[j] == 0)
					jinbub[cur++] = j;
			}
			int res = 0;
			for (int j = 0; j < d; j++) {
				res += Math.pow(d, d-1-j)*jinbub[j];
			}
			System.out.println(res);
		}
	}
}