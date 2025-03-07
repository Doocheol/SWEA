import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		Set<Integer> repeat = new HashSet<>();
		int max = 0, sum;
		int n;
		
		String[] s = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			n = Integer.parseInt(s[i]);
			if (list.contains(n)) {
				repeat.add(n);
			} else {
				list.add(n);
			}
		}
		
		int size = list.size();
		for (int i = 0; i < size-1; i++) {
			if (repeat.contains(list.get(i))) {
				sum = getSum(list.get(i), list.get(i));
				max = Math.max(max, sum);
			}
			for (int j = i+1; j < size; j++	) {
				sum = getSum(list.get(i), list.get(j));
				max = Math.max(max, sum);
			}
		}
		
		if (repeat.contains(list.get(size-1))) {
			sum = getSum(list.get(size-1), list.get(size-1));
			max = Math.max(max, sum);
		}
		
		System.out.println(max);
	}
	
	static int getSum(int a, int b) {
		String number = a*b + "";
		int sum = 0;
		for (int k = 0; k < number.length(); k++) {
			sum += number.charAt(k) - '0';
		}
		return sum;
	}
}