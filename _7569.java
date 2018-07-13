import java.util.*;
public class _7569 {
	static class Tomato{
		int x, y, h, dep;
		Tomato(int a,int i,int j,int dep){
			this.x=i;this.y=j;this.h=a;this.dep = dep;
		}
	}
	public static void main(String[] args) {
		int n,m,h,bin=0,ikk=0,dap=-1;
		boolean flag=false;
		int[]dx= {1,-1,0,0,0,0};
		int[]dy = {0,0,-1,1,0,0};
		int[]dh = {0,0,0,0,1,-1};
		Scanner sc = new Scanner(System.in);
		m=sc.nextInt();n=sc.nextInt();h=sc.nextInt();
		Queue<Tomato> q2= new LinkedList<Tomato>();
		int[][][] map = new int[h][n][m];
		boolean[][][] check = new boolean[h][n][m];
		for(int a=0;a<h;a++) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					map[a][i][j]=sc.nextInt();
					if(map[a][i][j]==1) {
						ikk++;
					}
					if(map[a][i][j]==-1) bin++;
				}
			}
		}
		if(bin==n*m*h) {      
			System.out.println(-1);
			return;
		}
		if((bin+ikk)==n*m*h) {
			System.out.println(0);
			return;
		}
		if((bin+ikk)==0) {
			System.out.println(-1);
			return;
		}
		Queue<Tomato> q= new LinkedList<Tomato>();
		int day=0;
		int count=0;
		int com=0;
		for(int a=0;a<h;a++) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(map[a][i][j]==1&&!check[a][i][j]) {
						q.add(new Tomato(a,i,j,0));
						com++;
					}
				}
			}
		}
		while(true) {
			while(!q.isEmpty()) {					//이 반복문이 다 돌면 하루가 지난 후 상태
				Tomato tmp= q.poll();
				int x= tmp.x;
				int y= tmp.y;
				int f= tmp.h;
				check[f][x][y]=true;
				for(int k=0;k<6;k++) {
					int N_x = x+dx[k];
					int N_y = y+dy[k];
					int N_h = f+dh[k];
					if(N_x<0||N_y<0||N_h<0||N_x>=n||N_y>=m||N_h>=h) continue;
					if(map[N_h][N_x][N_y]==0&&!check[N_h][N_x][N_y]) {
						map[N_h][N_x][N_y]=1;
						q2.add(new Tomato(N_h, N_x, N_y, tmp.dep+1));
						com++;
					}
				}
			}
			day++;
//			for(int a=0;a<h;a++) {
//				for(int i=0;i<n;i++) {
//					for(int j=0;j<m;j++) {
//						System.out.print(map[a][i][j]+" ");
//					}
//					System.out.println();
//				}
//			}
//			System.out.println();
			q=new LinkedList<Tomato>(q2);
			q2= new LinkedList<Tomato>();
			if(q.isEmpty()&&q2.isEmpty()) break;
		}
		if((com+bin)!=n*m*h) {
			System.out.println(-1);
			return;
		}
		System.out.println(day-1);
	}
}