package fg;
import java.util.*;
public class _1949 {
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int[][] map;
	static boolean[][] chk;
	static boolean flag=false;
	static LinkedList<Point> start_list= new LinkedList<>();
	static int n,k,len=Integer.MIN_VALUE;
	static class Point{
		int x,y,dep=0;
		Point(int x,int y,int d){
			this.x=x;this.y=y;this.dep=d;
		}
	}
	static void dfs(int x,int y,int dep) {
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0||ny<0||nx>=n||ny>=n) continue;
			if(chk[nx][ny]) continue;
			int cha = map[x][y]-map[nx][ny];
			if((-cha)>=k) continue;					//차이가 최대 K여도 높이가 같아지므로 필요 없다.
			if(cha>0) {
				chk[nx][ny]=true;
				dfs(nx,ny,dep+1);
				chk[nx][ny]=false;
			}
			else {										//깎아야하는상황( 최대 k만큼)
				if(flag)continue;
				chk[nx][ny]=true;
				int tmp = map[nx][ny];
				flag=true;								//공사는 한번할 수 있다.
				map[nx][ny]=map[x][y]-1;
				dfs(nx,ny,dep+1);
				chk[nx][ny]=false;
				flag = false;
				map[nx][ny]=tmp;
			}
		}
		len = Math.max(dep, len);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		for(int q = 1;q<=t;q++) {
			n=sc.nextInt();k=sc.nextInt();
			map = new int[n][n];
			chk = new boolean[n][n];
			int max = Integer.MIN_VALUE;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					map[i][j]=sc.nextInt();
					max = Math.max(max, map[i][j]);
				}
			}
			int dap = Integer.MIN_VALUE;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(map[i][j]==max) {

						chk[i][j]=true;
						dfs(i,j,1);
						chk[i][j]=false;
						dap= Math.max(dap, len);
						len = Integer.MIN_VALUE;
						chk = new boolean[n][n];
					}
				}
			}
			System.out.println("#"+q+" "+dap);
		}
	}

}
