package samsung;
import java.util.*;
public class _2382 {
	static int dx[] = {0,-1,1,0,0};
	static int dy[] = {0,0,0,-1,1};
	static class Point{
		int num,dir,top;
		Point(int n,int d,int top){
			this.num=n;this.dir=d;this.top=top;
		}
	}
	static Point[][] map,tmp;
	static int N,M,K;
	static void solve() {
		
		for(int time =0;time<M;time++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j].num>0) {		// 미생물이 있는 곳
						int nx = i+dx[map[i][j].dir];			//다음 이동하게 될 곳
						int ny = j+dy[map[i][j].dir];
						if(nx==0||ny==0||nx==N-1||ny==N-1) {		//약품 칠해진곳에 도착
							tmp[nx][ny].num=map[i][j].num/2;
							// 개체수가 1개보다 많으면 절반으로 줄어든다.
							if(map[i][j].dir%2==1) tmp[nx][ny].dir=map[i][j].dir+1;
							else tmp[nx][ny].dir= map[i][j].dir-1;
							
							
						}
						else if(tmp[nx][ny].top>0) {					//이동할 곳에 미생물이 있는경우
							tmp[nx][ny].num+=map[i][j].num;				//미생물은 모두 합쳐진다.
							if(map[i][j].num>tmp[nx][ny].top) {
								tmp[nx][ny].top = map[i][j].num;
								tmp[nx][ny].dir=map[i][j].dir;  //합쳐진다면 기존에 미생물 집단이 있다는 뜻이고, 그것과 새로온 것을 비교하여 많은 개체수를 가진 것의 방향으로 바꿈
							}
							
						}
						else {		//빈칸인 곳
							tmp[nx][ny].num=map[i][j].num;
							tmp[nx][ny].top=map[i][j].num;
							tmp[nx][ny].dir=map[i][j].dir;
						}
					}
				}
			}
			for(int i=0;i<map.length;i++) {
				System.arraycopy(tmp[i], 0, map[i], 0, tmp[i].length);
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j].num!=map[i][j].top) map[i][j].top=map[i][j].num;
					tmp[i][j]= new Point(0,0,0);
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int p=1;p<=t;p++) {
			N=sc.nextInt();M=sc.nextInt();K=sc.nextInt();
			map =new Point[N][N];
			tmp = new Point[N][N];
			for(int i=0;i<N;i++)for(int j=0;j<N;j++) map[i][j]= new Point(0,0,0);
			for(int i=0;i<N;i++)for(int j=0;j<N;j++) tmp[i][j]= new Point(0,0,0);
			for(int i=0;i<K;i++) {
				int x=sc.nextInt(),y=sc.nextInt(),num=sc.nextInt(),dir=sc.nextInt();
				map[x][y]=new Point(num,dir,num);
			}
			solve();
			int dap=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j].num!=0) dap+=map[i][j].num;
				}
			}
			System.out.println("#"+p+" "+dap);
		}
	}

}
