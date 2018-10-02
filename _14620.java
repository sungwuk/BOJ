import java.util.*;
public class _14620 {
	static int dx[]= {1,-1,0,0};
	static int dy[]= {0,0,1,-1};
	static boolean check[][],tmp[][],flag=true;
	static int map[][],n,dap=Integer.MAX_VALUE;
	static LinkedList<Point> list = new LinkedList<>();
	static class Point{
		int x, y;
		Point(int x,int y){
			this.x=x;this.y=y;
		}
	}
	static void flower(int k,int j) {
		for(int i=0;i<4;i++) {
			int nx = k+dx[i];
			int ny = j+dy[i];
		
			if(nx<0||ny<0||nx>=n||ny>=n) {
				flag=false;
				return;
			}
			if(check[nx][ny]) { 
				flag=false;
				return;
			
			}
			if(tmp[nx][ny]) { 
				flag=false;
				return;
			
			}
			tmp[nx][ny]=true;
		}
		flag=true;
	}
	static void calc() {
		flag=true;
			for(int k=0;k<n;k++) {
				for(int j=0;j<n;j++) {
					if(check[k][j]&&flag) {
						tmp[k][j]=true;
						flower(k,j);
					}
				}
			}
			if(flag) {
				int result=0;
				for(int k=0;k<n;k++) {
					for(int j=0;j<n;j++) {
						if(tmp[k][j]) {
							result+=map[k][j];
						}
					}
				}
				dap = Math.min(dap, result);
			}
	}
	static void solve(int c,int dep) {
		if(c==3) {
			calc();
			tmp = new boolean[n][n];
		}
		else {
			for(int i=dep+1;i<list.size();i++) {
				Point tmp = list.get(i);
				int x =tmp.x,y=tmp.y;
				check[x][y]=true;
				solve(c+1,i);
				check[x][y]=false;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		check = new boolean[n][n];
		tmp = new boolean[n][n];
		map = new int[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j]=sc.nextInt();
				list.add(new Point(i,j));
			}
		}
		solve(0,-1);
		System.out.println(dap);
	}

}
