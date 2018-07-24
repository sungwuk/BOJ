package first;
import java.util.*;
public class _14502 {
	static boolean[][] use;
	static int[][] map,test;
	static LinkedList<Point> list,virus;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int n,m,dap=Integer.MIN_VALUE,wall=0;
	static class Point{
		int x, y,dist=0;
		Point(int x, int y ){
			this.x=x;this.y=y;
		}
	}
	static void check() {
	
		LinkedList<Point> v_list = new LinkedList<>();
		int count=0;
		for(int i=0;i<virus.size();i++) {
			Point tmp = virus.get(i);
			v_list.add(new Point(tmp.x,tmp.y));
			while(!v_list.isEmpty()) {
				Point v_tmp = v_list.poll();
				count++;
				int x = v_tmp.x;
				int y = v_tmp.y;
				use[x][y]=true;
				for(int j=0;j<4;j++) {
					int a = x+dx[j];
					int b = y + dy[j]; 
					if(a<0||b<0||a>=n||b>=m)continue;
					if(!use[a][b]&&test[a][b]==0) {
						test[a][b]=2;
						use[a][b]=true;
						v_list.add(new Point(a,b));
					}
				}
			}
			
		}
		int a=count+3+wall;   //바이러스 퍼진개수 + 새로 세운 벽 + 원래 있던 벽
		dap = Math.max(dap, (n*m)-a);
	}
	static void solve(int choice,int dep) {
		if(choice==3) {
			copy();
			check();
		}
		else {
				for(int i=dep+1;i<list.size();i++) {
					Point tmp = list.get(i);
					map[tmp.x][tmp.y]=1;
					solve(choice+1,i);
					map[tmp.x][tmp.y]=0;
				}
		}
	}
	static void copy() {
		use= new boolean[n][m];
		for(int i=0;i<map.length;i++) {
			System.arraycopy(map[i], 0, test[i], 0, map[i].length);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();m=sc.nextInt();
		list = new LinkedList<>();
		virus= new LinkedList<>();
		map = new int[n][m];
		test = new int[n][m];
		use = new boolean[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j]=sc.nextInt();
				if(map[i][j]==0)list.add(new Point(i,j));
				if(map[i][j]==2)virus.add(new Point(i,j));
			}
		}
		wall = (n*m)-list.size()-virus.size();
		solve(0,-1);
		System.out.println(dap);
	}
}