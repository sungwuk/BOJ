import java.util.*;
public class _2589 {
	static int n,m,result=Integer.MIN_VALUE;
	static LinkedList<Point> list = new LinkedList<Point>();
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static boolean[][] check,map;
	static class Point{
		int x , y,dist;
		Point(int x, int y, int dist){
			this.x=x;this.y=y;this.dist=dist;
		}
	}
	static int solve(int x,int y,int dst) {
		check[x][y]=true;
		boolean flag= true;
		Point k=null;
		while(!list.isEmpty()) {
				k=list.remove(0);
				if(flag) {
					flag=false;
				}
				for(int i=0;i<4;i++) {
					int a= k.x+dx[i];
					int b= k.y+dy[i];
					if(a<0||b<0||a>=n||b>=m) {
						continue;
					}
					if(map[a][b]&&!check[a][b]) {
						check[a][b]=true;
						list.add(new Point(a,b,k.dist+1));
					}
				}	
		}
		list.clear();
		return k.dist;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();m=sc.nextInt();
		map = new boolean[n][m];
		check = new boolean[n][m];
		for(int i=0;i<n;i++) {
			String input = sc.next();
			for(int j=0;j<m;j++) {
				if(input.charAt(j)=='L') map[i][j]=true;
			}
		}

		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]) {					//À°ÁöÀÎ°æ¿ì
					list.add(new Point(i,j,0));
					int a=solve(i,j,0);
					result=Integer.max(a,result);
					check=new boolean[n][m];
				}
			}
		}
		System.out.println(result);
	}
}