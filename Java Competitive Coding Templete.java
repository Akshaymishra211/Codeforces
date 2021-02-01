import java.io.*;
import java.util.*;

public class ClassName {

	public static void main(String[] args) {
		FastScanner fs = new FastScanner();
		FastOutput fo = new FastOutput();
		int testcases = fs.nextInt();
		for (int tt = 0; tt < testcases; tt++) {
			//main code
		}
	}

	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");

		String next() {
			while (!st.hasMoreTokens())
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		long nextLong() {
			return Long.parseLong(next());
		}
	}

	static class FastOutput {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		void print(String str) {
			try {
				bw.write(str);
				bw.flush();
			} catch (IOException e) {
			}
		}

		void print(int num) {
			try {
				bw.write((num + ""));
				bw.flush();
			} catch (IOException e) {
			}
		}

		void println(String str) {
			try {
				bw.write(str + '\n');
				bw.flush();
			} catch (IOException e) {
			}
		}

		void println(int num) {
			try {
				bw.write(num + "" + '\n');
				bw.flush();
			} catch (IOException e) {
			}
		}
	}
}
