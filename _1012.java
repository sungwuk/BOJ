import java.util.*;
public class _1012 {
	static int t,m,n,k,worm;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static boolean[][] map,check; 
	static void solve(int x, int y) {
		check[x][y]=true;
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0||ny<0||nx>=m||ny>n)continue;
			if(!check[nx][ny]&&map[nx][ny]) {
				solve(nx,ny);
			}
		}
	}
	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		t=sc.nextInt();
		for(int a=0;a<t;a++) {
			m=sc.nextInt();n=sc.nextInt();k=sc.nextInt();
			 map = new boolean[51][51];
			 check = new boolean[51][51];
			 worm=0;
			for(int i=0;i<k;i++) {
				int x = sc.nextInt();int y=sc.nextInt();
				map[x][y]=true;
			}
			for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++) {
					if(map[i][j]&&!check[i][j]) {
						solve(i,j);
						worm++;
					}
				}
			}
			System.out.println(worm);
		}
	}

}
