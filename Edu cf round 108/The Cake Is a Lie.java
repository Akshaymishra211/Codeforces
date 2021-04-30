import java.io.*;
import java.util.*;

public class B {
	//lexographically best moves...
	public static int dx[] = { 1, 0, 0, -1 };
	public static int dy[] = { 0, -1, 1, 0 };
	public static long dp[][]=new long[101][101];
	public static void main(String[] args) throws FileNotFoundException {
		FastScanner fs = new FastScanner();
		FastOutput fo = new FastOutput(System.out);
		long initial_time = System.currentTimeMillis();
		int cnt=0;
		for(int i=0;i<101;i++) {
			dp[0][i]=cnt;
			cnt++;
		}
		for(int i=1;i<101;i++) {
			int val=1;
			for(int j=0;j<101;j++) {
				dp[i][j]=val+dp[i-1][j];
				val++;
			}
		}
		int testcases = fs.nextInt();
		for (int tt = 0; tt < testcases; tt++) {
			//main code
			int n=fs.nextInt(),m=fs.nextInt(),k=fs.nextInt();
			if(dp[n-1][m-1]==k) {
				fo.println("YES");
			}
			else {
				fo.println("NO");
			}
		}
		fo.time(initial_time);
		fo.close();
	}

	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner() throws FileNotFoundException {
			if (System.getProperty("ONLINE_JUDGE") == null) {
				//Read from the File...
				File file = new File("src\\input");
				br = new BufferedReader(new FileReader(file));
			} else {
				//Read from the System...
				br = new BufferedReader(new InputStreamReader(System.in));
			}
			st = new StringTokenizer("");
		}

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

	static class FastOutput extends PrintWriter {

		public FastOutput(PrintStream out) {
			super(out);
		}

		void time(long init) {
			if (System.getProperty("ONLINE_JUDGE") == null) {
				this.println(System.currentTimeMillis() - init + "ms");
			}
		}
	}
}
