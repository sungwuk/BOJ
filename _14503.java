import java.util.*;
public class _14503{
	static boolean[][] map,check;
	static int count=0;
	static int[] make_x = {-1,0,1,0};
	static int[] make_y = {0,1,0,-1};
	public static void main(String[] args) {
		int n,m,x,y,d;
		Scanner scan = new Scanner(System.in);
		n=scan.nextInt();m=scan.nextInt();
		x=scan.nextInt();y=scan.nextInt();d=scan.nextInt();
		map= new boolean[n][m];
		check=new boolean[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				int in = scan.nextInt();
				if(in==1) map[i][j]=false;
				else map[i][j]=true;
			}
		}
		while(true) {
			if(!check[x][y]) {				//그 장소 청소.
				count++;
				check[x][y]=true;
			}
			boolean clean = false;			//청소될 곳 찾았는지 아닌지 확인
			for(int i=0;i<4;i++) {
				int next=(d+3)%4;
				int nextX = x+make_x[next];
				int nextY = y+make_y[next];

				if(!check[nextX][nextY]&&map[nextX][nextY]) {	//청소할 곳 찾음
					x=nextX;
					y=nextY;
					d=next;
					clean=true;
					break;
				}
				else{		//왼쪽 청소할 곳 없으면 걍회전. 
					d=next;
				}
			}
			if(!clean) {				//네방향 모두 보고나왓는데 청소할 곳이없는
				int _x = x-make_x[d];
				int _y = y-make_y[d];
				if(!map[_x][_y]) {
					System.out.println(count);
					break;
				}
				else {
					x=_x;
					y=_y;
				}
			}
		}
	}
}