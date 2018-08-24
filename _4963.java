import java.util.*;
public class _4963 {
	static int w,h;
	static int dx[]= {1,-1,0,0,1,-1,1,-1};
	static int dy[]= {0,0,1,-1,1,1,-1,-1};
	static class Point{
		int x,y;
		Point(int x, int y){
			this.x=x;this.y=y;
		}
	}
	static void solve(int x,int y,boolean [][]m,boolean[][] c) {
		Queue<Point> q = new LinkedList();
		q.add(new Point(x,y));
		while(!q.isEmpty()) {
			Point tmp = q.poll();
			int cx = tmp.x;
			int cy = tmp.y;
			
			for(int i=0;i<8;i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				if(nx<0||ny<0||nx>=h||ny>=w)continue;
				if(!c[nx][ny]&&m[nx][ny]) {
					c[nx][ny]=true;
					q.add(new Point(nx,ny));
				}
			}
		}
	}
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		w=sc.nextInt();h=sc.nextInt();
		boolean[][] map,check;
		while(w!=0&&h!=0) {
			int land=0;
			map = new boolean[h][w];
			check = new boolean[h][w];
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					int a = sc.nextInt();
					if(a==1)map[i][j]=true;
				}
			}
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if(map[i][j]&&!check[i][j]) {
						land++;
						check[i][j]=true;
						solve(i,j,map,check);
					}
				}
			}
			System.out.println(land);
			w=sc.nextInt();h=sc.nextInt();
		}
	}
}