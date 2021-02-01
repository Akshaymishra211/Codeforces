import java.io.*;
import java.util.*;

public class B {
	
	public static void main(String[] args) {
		FastScanner fs = new FastScanner();
		FastOutput fo = new FastOutput();
		int testcases = fs.nextInt();
		for (int tt = 0; tt < testcases; tt++) {
			int q=fs.nextInt(),d=fs.nextInt();
			int arr[]=new int[q];
			for(int i=0;i<q;i++)
				arr[i]=fs.nextInt();
			int pahada[]=new int[10];
			for(int i=0;i<10;i++) {
				pahada[i]=d*(i+1); 
			}
			for(int i=0;i<q;i++) {
				if(arr[i]>=10*d) {
					fo.println("YES");
					continue;
				}
				int r=arr[i]%10;
				boolean res=false;
				for(int j=0;j<10;j++) {
					if(r==pahada[j]%10 && arr[i]>=pahada[j]) {
						res=true;
						break;
					}
				}
				if(res) {
					fo.println("YES");
				}
				else {
					fo.println("NO");
				}
			}
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
