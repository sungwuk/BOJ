import java.util.*;
public class _1236 {
	static class Point{
		int x,y;
		Point(int x, int y){
			this.x=x;this.y=y;
		}
	}
	public static void main(String[] args) {
		int n,m;
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();m=sc.nextInt();
		int[] a,b;
		boolean[][] check = new boolean[n][m];
		char[][] map = new char[n][m];
		a= new int[n];b=new int[m];
		for(int i=0;i<n;i++) {
			String input = sc.next();
			for(int j=0;j<m;j++) {
				map[i][j]=input.charAt(j);
				if(map[i][j]=='X') {
					a[i]++;
					b[j]++;
				}
			}
		}
		int dap_1=0,dap_2=0;
		for(int i=0;i<n;i++) {
			if(a[i]==0)dap_1++;
		}
		for(int i=0;i<m;i++) {
			if(b[i]==0)dap_2++;
		}
		System.out.println(dap_1<dap_2 ? dap_2:dap_1);
	}
}