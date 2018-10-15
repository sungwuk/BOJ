package samsung;
import java.util.*;
public class _5656 {
	static int n,w,h,chk[],map[][],tmp[][];
	static int dx[]= {-1,0,1,0},dy[]= {0,1,0,-1},dap=Integer.MAX_VALUE;
	static void print(int arr[][]) {
		for(int i=0;i<h;i++){
			for(int j=0;j<w;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	static void dfs(int x,int y,int dir,int cur,int max) {
		if(x<0||y<0||x>=h||y>=w) return;
		if(tmp[x][y]!=0) {
			int bound = tmp[x][y]-1;
			tmp[x][y]=0;
			for(int i=0;i<4;i++) {
				if(bound<=0) break;
				dfs(x+dx[i],y+dy[i],i,1,bound);
			}
		}
		tmp[x][y]=0;
		if(cur==max) return;
		if(dir==0) dfs(x-1,y,dir,cur+1,max);
		if(dir==1) dfs(x,y+1,dir,cur+1,max);
		if(dir==2) dfs(x+1,y,dir,cur+1,max);
		if(dir==3) dfs(x,y-1,dir,cur+1,max);	
	}
	static void shoot() {
		for(int i=0;i<n;i++) {
			if(chk[i]!=-1) {
				int cx=0;
				int cy = chk[i];
				while(cx<h&&tmp[cx][cy]==0) cx++;
				if(cx>=h) continue;
				//구슬이 부딪히는 위치에 도착.
				int boundary=tmp[cx][cy]-1;
				tmp[cx][cy]=0;
				for(int j=0;j<4;j++) {
					int nx = cx+dx[j];
					int ny = cy+dy[j];
					if(boundary<=0)break;				//0인경우는 자기자신만 터지므로.
					dfs(nx,ny,j,1,boundary);
				}
				tmp[cx][cy]=0;
				// 벽돌 아래로 미는 부분
				for(int p=0;p<w;p++) {
					LinkedList<Integer> list = new LinkedList<>();
					for(int j=h-1;j>=0;j--) {
						if(tmp[j][p]!=0) {
							list.add(tmp[j][p]);
						}
					}
					int j=0;
					for(;j<list.size();j++) {
						tmp[h-1-j][p] = list.get(j);
					}
					for(int k=h-j-1;k>=0;k--) {
						tmp[k][p]=0;
					}
				}	
				int count=0;								//맵 전제의 벽돌이 깨진경우 바로 리턴
					for(int j=0;j<w;j++) {
						if(tmp[h-1][j]==0) count++;
					}
				if(count==w) {
					dap=0;
					return;
				}
			}
		}
		int count=0;
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				if(tmp[i][j]!=0) count++;
			}
		}
		dap = Math.min(dap, count);
	}
	static void copy() {
		for(int i=0;i<map.length;i++) {
			System.arraycopy(map[i], 0, tmp[i], 0, map[i].length);
		}
	}
	static void solve(int c) {
		if(c==n) {						//구슬을 쏠 곳을 n군데 고른다
			copy();
			shoot();
		}
		else {
			if(dap==0) return;//맵 전제의 벽돌이 깨진경우 바로 리턴
			for(int i=0;i<w;i++) {
				chk[c]=i;
				solve(c+1);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0;i<t;i++) {
			n=sc.nextInt();w=sc.nextInt();h=sc.nextInt();
			map = new int[h][w];
			chk = new int[n];
			tmp = new int[h][w];
			for(int j=0;j<h;j++) {
				for(int k=0;k<w;k++) {
					map[j][k]=sc.nextInt();
				}
			}
			for(int j=0;j<n;j++) chk[j]=-1;
			solve(0);
			System.out.println("#"+(i+1)+" "+dap);
			dap=Integer.MAX_VALUE;
		}
	}
}