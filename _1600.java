import java.util.*;//10:40
public class _1600 {
	static boolean[][] map;
	static int k,w,h;
	static int dx[]= {1,-1,0,0,1,1,2,2,-1,-1,-2,-2};
	static int dy[]= {0,0,1,-1,2,-1,1,-1,2,-2,1,-1};
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
		boolean [][][] check = new boolean[h][w][32];
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				int a=sc.nextInt();
				if(a==0) map[i][j]=true;
			}
		}
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0,0,0,k));
		int dap=Integer.MAX_VALUE;
		check[0][0][k]=true;
		boolean flag=false;
		while(!q.isEmpty()) {
			Point tmp = q.poll();
			int cx= tmp.x;
			int cy = tmp.y;
			int cd = tmp.dep;
			int cc = tmp.c;				//말과 같은 이동
			if(cx==h-1&&cy==w-1) {
				System.out.println(dap);
				return;
			}
			for(int i=0;i<4;i++) {				
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				if(nx<0||ny<0||nx>=h||ny>=w) continue;
				if(!check[nx][ny][cc]&&map[nx][ny]) {
					q.add(new Point(nx,ny,cd+1,cc));
				}
			}
			if(cc>0) {					//말 움직임 사용 가능;
				for(int i=4;i<12;i++) {			//말 움직임 사용
					int nx = cx + dx[i];
					int ny = cy + dy[i];
					if(nx<0||ny<0||nx>=h||ny>=w) continue;
					if(!check[nx][ny][cc]&&map[nx][ny]) {
						q.add(new Point(nx,ny,cd+1,cc-1));
					}
				}
			}
		}
		if(flag)System.out.println(dap);
		else System.out.println(-1);
	}
}