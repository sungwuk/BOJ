package samsung;
import java.util.*;
public class _2105 {
	static int t,n,map[][],sx,sy,dap;
	static boolean dessert[],chk[][];
	static int[] dx= {1,-1,-1,1};
	static int[] dy= {1,1,-1,-1};
 	static void find(int x,int y,int c,int dir) {
		for(int i=dir;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0||ny<0||nx>=n||ny>=n) continue;	// 맵 벗어난 경우
			if(sx==nx&&sy==ny&&c>=4) {
				dap= Math.max(dap, c);
				return;
			}
			if(dessert[map[nx][ny]]||chk[nx][ny]||(Math.abs(dir-i)>1)) continue;
			dessert[map[nx][ny]]=true;
			chk[nx][ny]=true;
			find(nx,ny,c+1,i);
			dessert[map[nx][ny]]=false;
			chk[nx][ny]=false;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		t=sc.nextInt();
		for(int q=1;q<=t;q++) {
			n=sc.nextInt();
			map= new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					map[i][j]=sc.nextInt();
				}
			}
			dessert= new boolean[101];
			dap = Integer.MIN_VALUE;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					chk = new boolean[n][n];
					dessert[map[i][j]]=true;
					chk[i][j]=true;
					sx=i;sy=j;
					find(i,j,1,0);
					dessert[map[i][j]]=false;
				}
			}
			System.out.println("#"+q+" "+(dap==Integer.MIN_VALUE ? -1:dap));
		}
	}

}
