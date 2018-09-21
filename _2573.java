import java.util.*;
public class _2573 {
	static int [][][] map;
	static int point_x,point_y,m,n,bing_count=0;	
	static int dx[]= {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	static boolean chk[][],flag=false;
	static class Dot{
		int x,y;
		public Dot(int x,int y) { 
			this.x=x;this.y=y;
		}
	}
	static void solve(int x,int y) {
		int bing =0;
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0||ny<0||nx>=m||ny>=n)continue;
			if(map[nx][ny][0]==0) {
				bing++;
			}
		}
		map[x][y][1]=bing;
}
	static void bfs(int i,int j) {
		LinkedList<Dot> list = new LinkedList<>();
		list.add(new Dot(i,j));
		while(!list.isEmpty()) {
			int cx = list.peek().x;
			int cy = list.peek().y;
			list.poll();
			chk[cx][cy]=true;
			for(int h=0;h<4;h++) {
				int nx = cx+dx[h];
				int ny = cy+dy[h];
				if(nx<0||ny<0||nx>=m||ny>=n)continue;
				if(chk[nx][ny]) continue;
				if(map[nx][ny][0]!=0) {
					chk[nx][ny]=true;
					list.add(new Dot(nx,ny));
				}
			}
		}
	}
	static boolean isConnected() {
		int count=0;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j][0]!=0&&!chk[i][j]) {
					count++;
					if(count>=2) return false;
					bfs(i,j);
				}
			}
		}
		if(count==0) {
			flag=true;
		return false;
			}
		return true;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		m= scan.nextInt();n=scan.nextInt();
		map = new int[m][n][2];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				map[i][j][0]=scan.nextInt();
			}
		}
		int day=0;
		chk = new boolean[m][n];
		while(isConnected()) {
			//주변 호수에 둘러싸인 빙산 구하는 부분
			chk = new boolean[m][n];
			day++;
			for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++) {
					if(map[i][j][0]!=0) {
						solve(i,j);
					}
				}
			}
			// 둘러싸인 만큼 빙산 녹여주는 부분
			for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++) {
					int cha = map[i][j][0]-map[i][j][1];
					if(cha<=0) map[i][j][0]=0;
					else map[i][j][0]=cha;
				}
			}
		}
		if(flag) System.out.println(0);
		else System.out.println(day);
	}
}