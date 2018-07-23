package first;
import java.util.*;
public class _10026 {
	static int n;
	static char[][] map;
	static boolean[][] check;
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,0,1,-1};
	static void solve(int x ,int y) {
		check[x][y]=true;
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0||ny<0||nx>=n||ny>=n) continue;
			if(!check[nx][ny]&&(map[x][y]==map[nx][ny])) {
				solve(nx,ny);
			}
		}
	}
	static void solve_1(int x ,int y) {
		check[x][y]=true;
		System.out.println(x+" | "+y);
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0||ny<0||nx>=n||ny>=n) continue;
			if(!check[nx][ny]&&((map[x][y]=='R'||map[x][y]=='G')&&(map[nx][ny]=='R'||map[nx][ny]=='G'))) {
				map[nx][ny]=map[x][y];
			}
			if(!check[nx][ny]&&(map[x][y]==map[nx][ny])) {
				solve_1(nx,ny);
			}
		}
	}
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		map= new char[n][n];
		check = new boolean[n][n];
		for(int i=0;i<n;i++) {
			String in = sc.next();
			for(int j=0;j<n;j++) {
				map[i][j]=in.charAt(j);
			}
		}
		int count=0,RGcount=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(!check[i][j]) {
					solve(i,j);
					count++;
				}
			}
		}
		check = new boolean[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(!check[i][j]) {
					solve_1(i,j);
					System.out.println("-------------------");
					
					RGcount++;
				}
			}
		}
		System.out.println(count+" "+RGcount);
	}

}
