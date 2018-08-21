import java.util.*;
public class _1981 {
	static int map[][],n;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static class Point{
		int x,y,val;
		Point(int x, int y ,int v){
			this.x=x;this.y=y;this.val=v;
		}
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		n=sc.nextInt();
		LinkedList<Point> list = new LinkedList<>();
		LinkedList<Point> calc = new LinkedList<>();
		map = new int[n+1][n+1];
		boolean[][] check = new boolean[102][102];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		list.add(new Point(1,1,map[1][1]));

	}

}
