package fg;
import java.util.*;
public class _1953 {
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	static class Point {
		int x,y,dir;
		Point(int x,int y,int dir){
			this.x=x;this.y=y;this.dir=dir;
		}
	}
	static int map[][],t,n,m,r,c,L,dap;
	static boolean chk[][];
	static LinkedList<Point>list = new LinkedList<>();
	static void solve(int x,int y,int l) {
		list.add(new Point(x,y,1));
		chk[x][y]=true;
		while(!list.isEmpty()) {
			Point tmp = list.peek();
			list.poll();
			int cx = tmp.x;
			int cy =tmp.y;
			int cd = tmp.dir;
			if(cd>=l) return;
			for(int i=0;i<4;i++) {
				int nx = cx+dx[i];
				int ny = cy+dy[i];
				if(nx<0||ny<0||nx>=n||ny>=m||chk[nx][ny]||map[nx][ny]==0) continue;
				int cur = map[cx][cy];		//현재 구조물 타입
				int ne = map[nx][ny];		//다음 갈곳의 구조물 타입
				if(i==0) {
					if(cur==3||cur==5||cur==6||ne==3||ne==4||ne==7) continue;
				}
				else if(i==1) {
					if(cur==3||cur==4||cur==7||ne==3||ne==5||ne==6) continue;
				
				}
				else if(i==2) {
					if(cur==2||cur==4||cur==5||ne==2||ne==6||ne==7)continue;
				}
				else {
					if(cur==2||cur==6||cur==7||ne==2||ne==4||ne==5)continue;
				}
				list.add(new Point(nx,ny,cd+1));
				chk[nx][ny]=true;
				dap++;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		t=sc.nextInt();
		for(int q =1;q<=t;q++) {
			n=sc.nextInt();m=sc.nextInt();
			r=sc.nextInt();c=sc.nextInt();L=sc.nextInt();
			dap=1;
			map = new int[n][m];
			chk = new boolean[n][m];		
			list = new LinkedList<>();
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					map[i][j]=sc.nextInt();
				}
			}
			solve(r,c,L);
			System.out.println("#"+q+" "+(dap));
			list.clear();
		}
	}
}