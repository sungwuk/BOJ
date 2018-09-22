import java.util.*;
public class _1600 {
	static boolean[][] map;
	static int k,w,h;
	static int dx[]= {1,-1,0,0,1,1,2,2,-1,-1,-2,-2};
	static int dy[]= {0,0,1,-1,2,-2,1,-1,2,-2,1,-1};
	static class Point{
		int x, y,dep,c;
		Point(int x, int y ,int d,int c){
			this.x=x;this.y=y;this.dep=d;this.c=c;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		k=sc.nextInt();w=sc.nextInt();h=sc.nextInt();
		map= new boolean[h][w];
		int[][][] dist =new int[h][w][k+1];
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				int a=sc.nextInt();
				if(a==0) map[i][j]=true;
			}
		}
		for(int i=0;i<h;i++)for(int j=0;j<w;j++)for(int t=0;t<k+1;t++) dist[i][j][t]=Integer.MAX_VALUE;
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0,0,0,0));
		int dap=Integer.MAX_VALUE; dist[0][0][0]=0;
		while(!q.isEmpty()) {
			Point tmp = q.poll();
			int cx= tmp.x;
			int cy = tmp.y;
			int cd = tmp.dep;
			int cc = tmp.c;				
			if(cx==h-1&&cy==w-1) {
				dap= Math.min(dap, cd);
			}
			for(int i=0;i<4;i++) {
				int nx = cx+dx[i];
				int ny = cy+dy[i];
				if(nx<0||ny<0||nx>=h||ny>=w)continue;
				if(map[nx][ny]) {						
					if(dist[cx][cy][cc]+1<dist[nx][ny][cc]) {
						dist[nx][ny][cc]=dist[cx][cy][cc]+1;
						q.add(new Point(nx,ny,cd+1,cc));
					}
				}
			}
			if(cc!=k) {
				for(int i=4;i<12;i++) {
					int nx = cx+dx[i];
					int ny = cy+dy[i];
					if(nx<0||ny<0||nx>=h||ny>=w)continue;
					if(map[nx][ny]) {
						if(dist[cx][cy][cc]+1<dist[nx][ny][cc+1]) {
							dist[nx][ny][cc+1]=dist[cx][cy][cc]+1;
							q.add(new Point(nx,ny,cd+1,cc+1));
						}
					}
				}
			}
		}
		if(dap==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(dap);
	}
}