import java.util.*;
public class _2206_2 {
	static int []dx = {1,-1,0,0};
	static int []dy = {0,0,1,-1};
	static class Point{
		int x, y,dep;
		int ch;
		Point(int x,int y,int d,int chance){
			this.dep=d;this.x=x;this.y=y;this.ch=chance;
		}
	}
	public static void main(String[] args) {
		int n,m;
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();m=sc.nextInt();
		boolean map[][] = new boolean[n+1][m+1];
		int path[][][] = new int[n+1][m+1][2];
		for(int i=1;i<=n;i++) {
			String in = sc.next();
			for(int j=1;j<=m;j++) {
				if(in.charAt(j-1)=='0')map[i][j]=true;
			}
		}
		for(int i=1;i<=n;i++)for(int j=1;j<=m;j++)for(int k=0;k<2;k++)path[i][j][k]=Integer.MAX_VALUE;
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(1,1,1,0));
		path[1][1][0]=1;
		while(!q.isEmpty()) {
			Point tmp = q.poll();
			int cx=tmp.x;
			int cy=tmp.y;
			int cd = tmp.dep;
			int cc = tmp.ch;				//벽 부시는 기회 사용 여부 0,1
			if(cx==n&&cy==m) {
				System.out.println(cd);
				return;
			}
			for(int i=0;i<4;i++) {
				int nx=cx+dx[i];
				int ny=cy+dy[i];
				if(nx<1||ny<1||nx>n||ny>m)continue;
				if(!map[nx][ny]&&cc==0&&(path[cx][cy][0]+1<path[nx][ny][1])) {	//벽을  부셔서 감
					path[nx][ny][1]=cd+1;
					q.add(new Point(nx,ny,cd+1,1));
				}
				if(map[nx][ny]&&(path[cx][cy][cc]+1<path[nx][ny][cc])) {	   
					path[nx][ny][cc]=cd+1;
					q.add(new Point(nx,ny,cd+1,cc));
				}
			}
		}
		System.out.println(-1);
	}

}
