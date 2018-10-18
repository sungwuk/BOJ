package samsung;
import java.util.*;
public class _2117 {
	static boolean map[][],chk[][];
	static int dx[]= {-1,0,1,0};
	static int dy[]= {0,1,0,-1};
	static int n,m,dap,dap_sum,zip;
	static class Point{
		int x,y;
		Point(int x,int y){
			this.x=x;this.y=y;
		}
	}
	static void bfs(int x,int y) {
		LinkedList<Point> list = new LinkedList<>();
		list.add(new Point(x,y));
		chk[x][y]=true;
		int count = map[x][y]==true ? 1:0;
		int k=1;
		while(!list.isEmpty()) {
			int size = list.size();
			if(m*count-(k*k+(k-1)*(k-1))>=0) {
				dap = Math.max(count, dap);
			}
			if(k==n+1) return;
			while(size>0){
				int cx = list.peek().x;
				int cy = list.peek().y;
				list.poll();
				for(int i=0;i<4;i++) {
					int nx = cx+dx[i];
					int ny = cy+dy[i];
					
					if(nx<0||ny<0||nx>=n||ny>=n)continue;
					if(chk[nx][ny])continue;
					chk[nx][ny]=true;
					if(map[nx][ny]) count++;
					list.add(new Point(nx,ny));
				}
				size--;
			}
			k++;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int p=1;p<=t;p++) {
			n=sc.nextInt();m=sc.nextInt();
			map = new boolean[n][n];
			zip=0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					int a = sc.nextInt();
					if(a==1) { map[i][j]=true;
					zip++;
					}
				}
			}
			dap= Integer.MIN_VALUE;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					chk= new boolean[n][n];
					
					bfs(i,j);
					
				}
			}
			System.out.println("#"+p+" "+dap);
		}
	}

}
