package samsung;
import java.util.*;
public class _5650 {
	static int[] dx= {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static boolean flag=true;
	static int stx,sty,count;
	static class Point{
		int x,y,num,dir,point;
		Point(int x,int y,int num){
			this.x=x;this.y=y;this.num=num;
		}
	}
	static int map[][],n,dap;
	static LinkedList<Point> hole;
	static void go(int x,int y,int dir,int c) {			//방향이 임의로 정해지고 출발한 이후.
		while(true) {
			if(x<0||y<0||x>=n||y>=n) {						//벽에 부딪힌 경우
				if(x<0) {
					x++;
					dir=2;
				}
				else if(y<0) {
					y++;
					dir=1;
				}
				else if(x>=n) {
					x--;
					dir=0;
				}
				else if(y>=n) {
					y--;
					dir=3;
				}
				c++;
				continue;
			}
			else if(x==stx&&y==sty) {	//시작 위치로 돌아오면
				count=c;
				return;
			}
			else if(map[x][y]==-1) {	//블랙홀에 빠지면 종료
				count=c;
				return;
			}
			else if(map[x][y]>=1&&map[x][y]<=5) {		//블럭 만난경우
				int block = map[x][y];
				if(block==1) {
					if(dir==0) {
						dir=2;
						x++;
					}
					else if(dir==1) {
						dir=3;
						y--;
					}
					else if(dir==2) {
						dir=1;
						y++;
					}
					else if(dir==3) {
						dir=0;
						x--;
					}
				}
				else if(block==2) {
					if(dir==0) {
						dir=1;
						y++;
					}
					else if(dir==1) {
						dir=3;
						y--;
					}
					else if(dir==2) {
						dir=0;
						x--;
					}
					else if(dir==3) {
						dir=2;
						x++;
					}
				}
				else if(block==3) {
					if(dir==0) {
						dir=3;
						y--;
					}
					else if(dir==1) {
						dir=2;
						x++;
					}
					else if(dir==2) {
						dir=0;
						x--;
					}
					else if(dir==3) {
						dir=1;
						y++;
					}
				}
				else if(block==4) {
					if(dir==0) {
						dir=2;
						x++;
					}
					else if(dir==1) {
						dir=0;
						x--;
					}
					else if(dir==2) {
						dir=3;
						y--;
					}
					else if(dir==3) {
						dir=1;
						y++;
					}
				}
				else if(block==5) {
					if(dir==0) {
						dir=2;
						x++;
					}
					else if(dir==1) {
						dir=3;
						y--;
					}
					else if(dir==2) {
						dir=0;
						x--;
					}
					else if(dir==3) {
						dir=1;
						y++;
					}
				}
				c++;
				continue;
			}
			else if(map[x][y]>=6) {
				int hole_num = map[x][y];
				for(int i=0;i<hole.size();i++) {
					if(hole.get(i).num==hole_num) {
						if(x!=hole.get(i).x&&y!=hole.get(i).y) {
							x=hole.get(i).x;y=hole.get(i).y;
							break;
						}
					}
				}
			}
			if(dir==0) x--;
			if(dir==1) y++;
			if(dir==2) x++;
			if(dir==3) y--;
		}
	}
	static void start(int x,int y) {				//시작 지점에서 임의의 방향으로 출발 시키는 부분
		int sum=Integer.MIN_VALUE;
		for(int i=0;i<4;i++) {
			count=0;
			int nx = x+dx[i];
			int ny = y+dy[i];
			go(nx,ny,i,count);
			dap = Math.max(dap, count);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int p=1;p<=t;p++) {
			n=sc.nextInt();
			map = new int[n][n];
			hole = new LinkedList<>();
			dap = Integer.MIN_VALUE;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					map[i][j]=sc.nextInt();
					if(map[i][j]>5) {
						hole.add(new Point(i,j,map[i][j]));
					}
				}
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(map[i][j]==0) {
						stx=i;sty=j;
						start(i,j);
					}
				}
			}
			System.out.println("#"+p+" "+(dap==Integer.MIN_VALUE? 0:dap));
		}
	}
}