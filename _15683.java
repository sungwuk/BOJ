import java.util.*;
public class _15683 {
	static int dx[]= {0,0,1,-1};
	static int dy[]= {1,-1,0,0};
	static int n,m;
	static boolean[][] check;
	static boolean check(int x, int y) {
		if(x<0||y<0||x>=n||y>=m) return false;
		return true;
	}
	static void east(int [][]ma, int x, int y) {
		if(check(x,y)) return;
		else {
			int nx  = x+dx[0];
			int ny =  y+dy[0];
			if(ma[nx][ny]==6) return;
			if(ma[nx][ny]!=6||ma[nx][ny]!=0) {
				east(ma,nx,ny+dy[0]);
			}
			else {
				east(ma,nx,ny);
			}
		}
	}
	static void west(int [][]ma, int x, int y) {
		
	}
	static void south(int [][]ma, int x, int y) {
		
	}
	static void north(int [][]ma, int x, int y) {
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m =sc.nextInt();
		int map[][] = new int[n][m];
		check = new boolean[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j]= sc.nextInt();
			}
		}
		// camera : 1~5, wall : 6 space : 0 
		// 각 카메라 마다 최대 감시 영역 구하기
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]!=0||map[i][j]!=6) {				//감시카메라
				}
			}
		}
		
		
		
		
	}

}
