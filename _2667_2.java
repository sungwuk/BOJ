import java.util.*;
public class _2667 {
static boolean [][] map,chk;
static int dx[]= {1,-1,0,0},n;
static int dy[] = {0,0,1,-1};
static class Point{
	int x,y;
	Point(int x, int y){
		this.x=x;this.y=y;
	}
}
static int solve(int i,int j) {
	Queue<Point> q = new LinkedList<>();
	q.add(new Point(i,j));
	int result=0;
	while(!q.isEmpty()) {
		int cx = q.peek().x;
		int cy = q.peek().y;
		result++;
		q.poll();
		chk[cx][cy]=true;
		for(int k=0;k<4;k++) { 
			int nx = cx+dx[k];
			int ny = cy+dy[k];
			if(nx<0||ny<0||nx>=n||ny>=n)continue;
			if(!chk[nx][ny]&&map[nx][ny]) {
				q.add(new Point(nx,ny));
				chk[nx][ny]=true;
			}
		}
	}
	return result;
}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 n=sc.nextInt();
		map = new boolean[n][n];
		chk = new boolean[n][n];
		for(int i=0;i<n;i++) {
			String in = sc.next();
			for(int j=0;j<in.length();j++) {
				if(in.charAt(j)=='1') map[i][j]=true;
			}
		}
		int danji=0;
		LinkedList<Integer> l = new LinkedList<>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j]&&!chk[i][j]) {
					danji++;
					l.add(solve(i,j));
				}
			}
		}
		Collections.sort(l);
		System.out.println(danji);
		for(int a:l) System.out.println(a);
	}
}