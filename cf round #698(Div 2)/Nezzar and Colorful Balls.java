import java.io.*;
import java.util.*;

public class A {

	public static void main(String[] args) {
		FastScanner fs = new FastScanner();
		FastOutput fo = new FastOutput();
		int testcases = fs.nextInt();
		for (int tt = 0; tt < testcases; tt++) {
			//main code
			int n=fs.nextInt();
			int arr[]=new int[n];
			for(int i=0;i<n;i++)
				arr[i]=fs.nextInt();
			int cnt=0;
			int total_true=0;
			boolean bool[]=new boolean[n]; 
			while(total_true<n) {
				int prev=-1;
				cnt++;
				for(int i=0;i<n;i++) {
					if(bool[i]) {
						continue;
					}
					else {
						if(prev==-1) {
							prev=arr[i];
							bool[i]=true;
							total_true++;
						}
						else {
							if(arr[i]>prev) {
								prev=arr[i];
								bool[i]=true;
								total_true++;
							}
						}
					}
				}
			}
			fo.println(cnt);
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
