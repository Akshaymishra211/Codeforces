import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class C {
	/*
	 * public static void bruteforce(){
	 * 	for(int i=0;i<n;i++) {
				int cnt=0;
				for(int j=0;j<n;j++) {
					cnt+=Math.abs(arr[i]-arr[j]);
				}
				fo.print(cnt+" ");
			}
	 * }
	 */
	public static void shuffleArray(long[] array) {
		int index;
		long temp;
		Random random = new Random();
		for (int i = array.length - 1; i > 0; i--) {
			index = random.nextInt(i + 1);
			temp = array[index];
			array[index] = array[i];
			array[i] = temp;
		}
	}
	public static void main(String[] args) {
		FastScanner fs = new FastScanner();
		FastOutput fo = new FastOutput();
		int testcases = fs.nextInt();
	    for (int tt = 0; tt < testcases; tt++) {
			//main code
			int n=fs.nextInt();
			long arr[]=new long[2*n];
			for(int i=0;i<2*n;i++)
				arr[i]=fs.nextLong();
			shuffleArray(arr);
			Arrays.sort(arr);
			Map<Long,Integer> count=new HashMap<>();
			boolean leaveit=false;
			for(int i=0;i<2*n;i++) {
				if(arr[i]%2!=0) {
					fo.println("NO");
					leaveit=true;
					break;
				}
				else if(count.get(arr[i])==null) {
					count.put(arr[i],1);
				}
				else {
					count.put(arr[i],count.get(arr[i])+1);
				}
			}
			if(leaveit)
				continue;
			for(int i:count.values()) {
				if(i!=2) {
					fo.println("NO");
					leaveit=true;
					break;
				}
			}
			if(leaveit)
				continue;
			long cnt=0L;
			long x=2*n;
			Map<Long,Boolean> used=new HashMap<>();
			for(int i=2*n-2;i>-1;i-=2) {
				long q=(arr[i]-cnt)/x,r=(arr[i]-cnt)%x;
				if(r!=0) {
					fo.println("NO");
					leaveit=true;
					break;
				}
				else {
					if(q<=0 || used.get(q)!=null) {
						fo.println("NO");
						leaveit=true;
						break;
					}
					else {
						cnt+=2*q;
						x-=2;
						used.put(q,true);
					}
				}
			}
			if(leaveit)
				continue;
			fo.println("YES");
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
