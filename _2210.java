import java.util.*;
public class _2210 {
	static class Point{
		int x,y,dep;
		String s;
		Point(int x, int y , int d,String s){
			this.x=x;this.y=y;this.dep=d;this.s=s;
		}
	}
	static boolean check[],c[][];
	static int map[][],dap=0;
	static int[] dx= {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static void find(int a, int b) {
		LinkedList<Point> list = new LinkedList<>();
		list.add(new Point(a,b,1,String.valueOf(map[a][b])));
		c = new boolean[5][5];
		while(!list.isEmpty()) {
			Point cur = list.poll();
			int cx = cur.x;
			int cy = cur.y;
			int cd = cur.dep;
			String cs = cur.s;
			if(cd==6) {
				if(!check[Integer.parseInt(cs)]) {
					check[Integer.parseInt(cs)]=true;
					dap++;
				}
			}
			for(int i=0;i<4;i++) {
				if(cd>6) break;
				int nx = cx+dx[i];
				int ny = cy+dy[i];
				if(nx<0||ny<0||nx>=5||ny>=5)continue;
					String ns=cs+String.valueOf(map[nx][ny]);
					list.add(new Point(nx,ny,cd+1,ns));
					
			}
		}
	}
	public static void main(String[] args) {
		map= new int[5][5];
		check =  new boolean[999999];
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				find(i,j);
			}
		}
		System.out.println(dap);
	}

}
