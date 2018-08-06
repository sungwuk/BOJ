import java.util.*;
public class _15686 {
	static int n,m,dap = Integer.MAX_VALUE,dist=0;
	static    LinkedList<Point> list,home;
	static int[][] map;
	static boolean[][] check;
	static class Point{
		int x, y,dist;
		Point(int x, int y){
			this.x=x;this.y=y;
		}
	}
	static void check() {  
		int count=0;
		int a = Integer.MAX_VALUE;
		for(int i=0;i<home.size();i++) {
			Point tmp = home.get(i);
			for(int j=1;j<=n;j++) {
				for(int k=1;k<=n;k++) {
					if(check[j][k]) {								//골라진 치킨집
						int cha = Math.abs((tmp.x-j))+Math.abs(tmp.y-k);
						a = Math.min(a,cha);	//한 집에서 골라진 치킨집 중 작은값
						count++;
					}
				}
				if(count==m) break;
			}
			dist+=a;
			a=Integer.MAX_VALUE;
			count=0;
		}
	}
	static void solve(int c,int dep) {
		if(c==m) {
			check();
			dap = Math.min(dap, dist);
			dist=0;
		}
		else {
			for(int i=dep+1;i<list.size();i++) {
				Point tmp=list.get(i);
				int x = tmp.x;
				int y = tmp.y;
				check[x][y]=true;
				solve(c+1,i);
				check[x][y]=false;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		n=sc.nextInt();m=sc.nextInt();
		map = new int[n+1][n+1];
		list= new LinkedList<>();
		check = new boolean[n+1][n+1];
		home= new LinkedList<>();
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				int a=sc.nextInt();
				if(a==2) list.add(new Point(i,j));
				if(a==1) home.add(new Point(i,j));
				map[i][j]=a;
			}
		}
		solve(0,-1);
		System.out.println(dap);
	}
}