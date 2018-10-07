import java.util.*;
public class _15683 {
	static int map[][],arr[][],size,dir[],dx[],dy[],count=0,n,m,dap=Integer.MAX_VALUE;
	static boolean[][] chk;
	static LinkedList<Point> list= new LinkedList<>();
	static class Point{
		int x,y,cam,cd=0;
		Point(int x, int y,int cnum){
			this.x=x;this.y=y;this.cam=cnum;
		}
	}
	static void dfs(int x,int y, int dit) {
		if(x<0||y<0||x>=n||y>=m) return;
		if(arr[x][y]==6) return;
		if(arr[x][y]==0) arr[x][y]=-1;
		if(dit==0) dfs(x-1,y,dit);				
		if(dit==1) dfs(x,y+1,dit); 
		if(dit==2) dfs(x+1,y,dit);
		if(dit==3) dfs(x,y-1,dit); 
	}

	static void search(int x,int y, int direct,int cam) {		//현재 카메라 위치(x,y) 지시 방향 (4개) ,카메라 번호
		if(cam==1) {
			dfs(x,y,direct);
		}
		if(cam==2) {
			dfs(x,y,direct);
			dfs(x,y,(direct+2)%4);
		}
		if(cam==3) {
			dfs(x,y,direct);
			dfs(x,y,(direct+1)%4);
		}
		if(cam==4) {
			dfs(x,y,direct);
			dfs(x,y,(direct+1)%4);
			dfs(x,y,(direct+3)%4);
		}
		if(cam==5) {
			dfs(x,y,direct);
			dfs(x,y,(direct+1)%4);
			dfs(x,y,(direct+2)%4);
			dfs(x,y,(direct+3)%4);
		}
	}
	static void init() {
		for(int i=0;i<map.length;i++) {
			System.arraycopy(map[i], 0, arr[i], 0, map[i].length);
		}
		count=0;
		chk = new boolean[n][m];
	}
	static void solve(int c,int dep) {
		if(c==size) {				//모든 카메라의 방향이 결정되고 check해야 함.
			init();
			for(int i=0;i<size;i++) {
				int cx = list.get(i).x,cy=list.get(i).y;
				search(cx,cy,dir[i],list.get(i).cam);
			}

			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(arr[i][j]==0) count++;
				}
			}
			dap = Math.min(dap, count);
		}
		else {
			for(int i=0;i<4;i++) {
				dir[c]=i;
				solve(c+1,i+1);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		n=sc.nextInt();m=sc.nextInt();
		map = new int[n][m];
		arr = new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j]=sc.nextInt();
				if(map[i][j]!=0&&map[i][j]!=6) {
					list.add(new Point(i,j,map[i][j])); 			//카메라 기록 위치
				}
			}
		}
		size = list.size();
		dir = new int[size];
		solve(0,0);
		System.out.println(dap);
	}
}