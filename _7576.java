import java.util.*;
public class _7576 {
	static class Tomato{
		int y, x;
		Tomato(int i,int j){
			this.x=i;this.y=j;
		}
	}
	public static void main(String[] args) {
		int n,m,bin=0,ikk=0,dap=-1;
		boolean flag=false;
		int[]dx= {1,-1,0,0};
		int[]dy = {0,0,-1,1};
		Scanner sc = new Scanner(System.in);
		m=sc.nextInt();n=sc.nextInt();
		Queue<Tomato> q2= new LinkedList<Tomato>();
		int[][] map = new int[n][m];
		boolean[][] check = new boolean[n][m];
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					map[i][j]=sc.nextInt();
					if(map[i][j]==1) {
						ikk++;
					}
					if(map[i][j]==-1) bin++;
				}
			}
		if(bin==n*m) {      
			System.out.println(-1);
			return;
		}
		if((bin+ikk)==n*m) {
			System.out.println(0);
			return;
		}
		if((bin+ikk)==0) {
			System.out.println(-1);
			return;
		}
		Queue<Tomato> q= new LinkedList<Tomato>();
		int day=0;
		int com=0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(map[i][j]==1&&!check[i][j]) {
						q.add(new Tomato(i,j));
						com++;
					}
				}
			}
		while(true) {
			while(!q.isEmpty()) {					//이 반복문이 다 돌면 하루가 지난 후 상태
				Tomato tmp= q.poll();
				int x= tmp.x;
				int y= tmp.y;
				check[x][y]=true;
				for(int k=0;k<4;k++) {
					int N_x = x+dx[k];
					int N_y = y+dy[k];
					if(N_x<0||N_y<0||N_x>=n||N_y>=m) continue;
					if(map[N_x][N_y]==0&&!check[N_x][N_y]) {
						map[N_x][N_y]=1;
						q2.add(new Tomato(N_x, N_y));
						com++;
					}
				}
			}
			day++;
			q=new LinkedList<Tomato>(q2);
			q2= new LinkedList<Tomato>();
			if(q.isEmpty()&&q2.isEmpty()) break;
		}
		if((com+bin)!=n*m) {
			System.out.println(-1);
			return;
		}
		System.out.println(day-1);
	}
}