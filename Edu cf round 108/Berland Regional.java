import java.io.*;
import java.util.*;

public class C {
	//lexographically best moves...
	public static int dx[] = { 1, 0, 0, -1 };
	public static int dy[] = { 0, -1, 1, 0 };

	public static void main(String[] args) throws FileNotFoundException {
		FastScanner fs = new FastScanner();
		FastOutput fo = new FastOutput(System.out);
		long initial_time = System.currentTimeMillis();
		int testcases = fs.nextInt();
		for (int tt = 0; tt < testcases; tt++) {
			//main code
			int n=fs.nextInt();
			ArrayList<Long> arr[]=new ArrayList[n];
			long dp[]=new long[n+1];
			int u[]=new int[n];
			long s[]=new long[n];
			for(int i=0;i<n;i++) {
				u[i]=fs.nextInt();
				arr[i]=new ArrayList<>();
			}
			for(int i=0;i<n;i++) {
				s[i]=fs.nextInt();
			}
			for(int i=0;i<n;i++) {
				arr[u[i]-1].add(s[i]);
			}
			for(int i=0;i<n;i++) {
				Collections.sort(arr[i],Collections.reverseOrder());
			}
			long temp;
			for(int i=0;i<n;i++) {
				for(int j=1;j<arr[i].size();j++) {
					temp=arr[i].get(j-1)+arr[i].get(j);
					arr[i].set(j, temp);
				}
			}
			//arr[0].add(1,arr[0].get(1)+arr[0].get(0));
			for(int i=0;i<n;i++) {
				//boolean vis[]=new boolean[n+1];
				for(int j=0;j<arr[i].size();j++) {
					int k=arr[i].size()%(j+1);
					//if(!vis[j+1]) {
						dp[j+1]+=(arr[i].get(arr[i].size()-k-1));
					//	vis[j+1]=true;
					//}
				}
			}
			for(int i=1;i<n+1;i++) {
				fo.print(dp[i]+" ");
			}
			fo.println();
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
