import java.util.*;
public class _2638{
	static class Point{
		int x,y;
		Point(int x, int y){
			this.x=x;this.y=y;
		}
	}
	static int dx[] = {1,-1,0,0},m,n;
	static int dy[] = {0,0,1,-1};
	static boolean isPossible(int x, int y, int [][]m) {
		int c=0;
		for(int i=0;i<4;i++) {
			if(m[x+dx[i]][y+dy[i]]==2) c++;
		}
		return c>=2;				//2변 이상이 실내공기와 접촉
	}
	static void fill(int[][] ma,int x, int y) {
		if(ma[x][y]==0) {
			ma[x][y]=2;
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx<0||ny<0||nx>=m||ny>=n) continue; 
				fill(ma,nx,ny);
			}
		}
	}
	static void copy(int[][] a,int [][] b) {
		for(int i=0;i<a.length;i++) {
			System.arraycopy(a[i], 0, b[i], 0, a[0].length);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m=sc.nextInt();n=sc.nextInt();
		int[][] map = new int[m][n];
		int[][] tmp = new int[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		fill(map,0,0);
		copy(map,tmp);
		int hour=0,melting=0;
		while(true) {
			for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++) {
					if(map[i][j]==1&&isPossible(i,j,map)) {
						tmp[i][j]=2;
						melting++;
						for(int z=0;z<4;z++) {
							fill(tmp,i+dx[z],j+dy[z]);
						}
					}
				}
			}
			if(melting==0) {
				System.out.println(hour);
				return;
			}
			copy(tmp,map);
			hour++;
			melting=0;
		}
	}
}