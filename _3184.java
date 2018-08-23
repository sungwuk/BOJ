import java.util.*;
public class _3184 {
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static boolean [][] check ;
	static 	char[][] map ;
	static int r,c,total_wolf=0,total_sheep=0;
	static class Point{
		int x, y;
		Point(int x,int y){
			this.x=x;this.y=y;
		}
	}
	static void find(int x, int y) {
		LinkedList<Point> list = new LinkedList<>();
		list.add(new Point(x,y));
		check[x][y]=true;
		int wolf =0,sheep=0;
		while(!list.isEmpty()) {
			Point tmp = list.poll();
			int cx = tmp.x;
			int cy = tmp.y;
			if(map[cx][cy]=='v') wolf++;
			if(map[cx][cy]=='o') sheep++;
			
			for(int i=0;i<4;i++) {
				int nx = cx+dx[i];
				int ny = cy+dy[i];
				if(nx<0||ny<0||nx>=r||ny>=c) continue;
				if(!check[nx][ny]&&map[nx][ny]!='#') {
					check[nx][ny]=true;
					list.add(new Point(nx,ny));
				}
			}
		}
		if(wolf<sheep) total_sheep+=sheep;
		else total_wolf+=wolf;

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r=sc.nextInt();c=sc.nextInt();
		map = new char[r][c];
		check = new boolean[r][c];
		LinkedList<Point> list = new LinkedList<>();
		for(int i=0;i<r;i++) {
			String in = sc.next();
			for(int j=0;j<c;j++) {
				map[i][j]=in.charAt(j);
			}
		}
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(map[i][j]=='v'||map[i][j]=='o') {
					if(!check[i][j]) {
						find(i,j);
					}
				}
			}
		}
		System.out.println(total_sheep+" "+total_wolf);
	}

}
