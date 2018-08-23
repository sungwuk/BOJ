import java.util.*;
public class _3184 {
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static class Point{
		int x, y;
		Point(int x,int y){
			this.x=x;this.y=y;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r,c;
		r=sc.nextInt();c=sc.nextInt();
		char[][] map = new char[r][c];
		boolean [][] check = new boolean[r][c];
		LinkedList<Point> list = new LinkedList<>();
		for(int i=0;i<r;i++) {
			String in = sc.next();
			for(int j=0;j<c;j++) {
				map[i][j]=in.charAt(j);
				if(map[i][j]=='v') list.add(new Point(i,j));
			}
		}
		LinkedList<Point> tlist = new LinkedList<>();
		int total_lamb=0;
		int total_wolf=0;
		while(!list.isEmpty()) {
			Point t = list.peek();
			while(true) {
				if(t==null) break;
				if(check[t.x][t.y]==false) {
					list.poll();
					break;
				}
				t=list.poll();
			}
			if(t==null) break;
			tlist.add(t);
			int lamb=0;
			int wolf =1;
			while(!tlist.isEmpty()) {
				Point tmp = tlist.poll();
				int cx = tmp.x;
				int cy = tmp.y;
				check[cx][cy]=true;
				for(int i=0;i<4;i++) {
					int nx = cx+dx[i];
					int ny = cy+dy[i];
					if(nx<0||ny<0||nx>=r||ny>=c) continue;
					if(map[nx][ny]=='v'&&!check[nx][ny]) {
						wolf++;
						check[nx][ny]=true;
						tlist.add(new Point(nx,ny));
						continue;
					}
					if(map[nx][ny]!='#'&&!check[nx][ny]) {
						if(map[nx][ny]=='o') {
							lamb++;
						}
						check[nx][ny]=true;
						tlist.add(new Point(nx,ny));
					}
				}
			}
			if(lamb>wolf) { 
				total_lamb+=lamb;
			}
			else {
				total_wolf+=wolf;
			}
		}
		System.out.println(total_lamb+" "+total_wolf);
	}

}
