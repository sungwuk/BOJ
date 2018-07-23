import java.util.*;
public class _2206 {
	static LinkedList<Point> list ;
	static boolean[][] map;	
	static int[][][] check;
	static int[] dx= {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static class Point{
		int x,y;
		int chance;
		Point(int x,int y,int c){
			this.x=x;this.y=y;this.chance=c;
		}
	}
	public static void main(String[] args) {
		int n,m;
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();m=sc.nextInt();
		list = new LinkedList<>();
		map = new boolean[n+1][m+1];
		check = new int[1001][1001][2];
		for(int i=1;i<=n;i++) {
			String in =sc.next();
			for(int j=1;j<=m;j++) {
				if(in.charAt(j-1)=='0') map[i][j]=true;
			}
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				for(int k=0;k<=1;k++) {
					check[i][j][k]=Integer.MAX_VALUE;
				}
			}
		}
		check[1][1][0]=1;
		list.add(new Point(1,1,0));
		while(!list.isEmpty()) {
			Point tmp = list.poll();
			int x = tmp.x;
			int y = tmp.y;
			int use= tmp.chance;
			
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx<1||ny<1||nx>n||ny>m) continue;
				if(map[nx][ny]&&(check[x][y][use]+1<check[nx][ny][use])) {
					check[nx][ny][use]=check[x][y][use]+1;
					list.add(new Point(nx,ny,use));
				}
				if(!map[nx][ny]&&use==0&&(check[x][y][0]+1<check[nx][ny][1])) {
					check[nx][ny][1]=check[x][y][0]+1;
					list.add(new Point(nx,ny,1));
				}
			}
		}
		if(check[n][m][0]==Integer.MAX_VALUE&&check[n][m][1]==Integer.MAX_VALUE)System.out.println(-1);
		else System.out.println(Math.min(check[n][m][1],check[n][m][1]));
	}
}