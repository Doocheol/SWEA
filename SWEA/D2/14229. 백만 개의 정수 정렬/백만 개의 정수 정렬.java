
import java.io.*;
import java.util.*;

public class Solution {

	static int[] arr;
	static int N;
	static int[] temp;
	
	public static void main(String[] args) throws Exception {

//		System.setIn(new FileInputStream("src/김두철/A055.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = st.countTokens();

		arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		temp = new int[N];

		mergeSort(0, N-1);
		System.out.println(arr[500000]);
	}

	private static void mergeSort(int left, int right) {
		
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(left, mid);
			mergeSort(mid + 1, right);
			merge(left, mid, right);
		}
		
	}

	private static void merge(int left, int mid, int right) {
		int L = left;
		int R = mid + 1;
		
		int idx = left;
		
		while (L <= mid && R <= right) {
			if (arr[L] <= arr[R]) {
				temp[idx++] = arr[L++];
			} else {
				temp[idx++] = arr[R++];
			}
		}
		
		if (L <= mid) {
			for (int i = L; i <= mid; i++) {
				temp[idx++] = arr[i];
			}
		} else {
			for (int i = R; i <= right; i++) {
				temp[idx++] = arr[i];
			}
		}
		
		
		for (int i = left; i <= right; i++) {
			arr[i] = temp[i];
		}
		
		
	}

}
