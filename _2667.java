import java.util.*;
public class _2667 {
	static boolean[][]check,map;
	static int c=1,n;
	static void solve(int i, int j) {
		if(i+1<=n&&!check[i+1][j]&&map[i+1][j]) {
			c++;
			check[i+1][j]=true;
			solve(i+1,j);
		}
		if(i-1>=1&&!check[i-1][j]&&map[i-1][j]) {
			c++;
			check[i-1][j]=true;
			solve(i-1,j);
		}
		if(j+1<=n&&!check[i][j+1]&&map[i][j+1]) {
			c++;
			check[i][j+1]=true;
			solve(i,j+1);
		}
		if(j-1>=1&&!check[i][j-1]&&map[i][j-1]) {
			c++;
			check[i][j-1]=true;
			solve(i,j-1);
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n=scan.nextInt();
		List<Integer> list = new LinkedList<Integer>();
		map  = new boolean[n+1][n+1];
		check = new boolean[n+1][n+1];
		for(int i=1;i<=n;i++) {
			String s = scan.next();
			for(int k=1;k<=n;k++) {
				if(s.charAt(k-1)=='1') map[i][k]=true;
				else map[i][k]=false;
			}
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(map[i][j]&&!check[i][j]){
					check[i][j]=true;
					solve(i,j);
					list.add(c);
					c=1;
				}
			}
		}
		System.out.println(list.size());
		Collections.sort(list);
		for(int a: list) {
			System.out.println(a);
		}
	}

}
