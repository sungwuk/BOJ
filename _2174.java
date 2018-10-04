import java.util.*;
public class _2174 {
	static int map[][];
	static int dx[] = {0,0,1,0,-1},A,B,M,N;
	static int dy[] = {0,-1,0,1,0};
	static boolean crash = false;
	static 	LinkedList<Robot> rList = new LinkedList<>();
	static class Robot{
		int x,y,name,dir;
		Robot(int n, int x,int y,int d){
			this.name=n;this.x=x;this.y=y;this.dir=d;
		}
		
	}
	static void solve(int num,int count, int x,int y,int dir) { //로봇 번호, 반복횟수, 로봇 x,y좌표, 바라보는 방향
			int a=x,b=y;
			for(int i=0;i<count;i++) {
				a = a+dx[dir];
				b = b+dy[dir];
				if(a<1||b<1||a>A||b>B) {
					System.out.println("Robot "+num+" crashes into the wall");
					crash = true;
					return;
				}
				if(map[b][a]!=0) {
					System.out.println("Robot "+num+" crashes into robot "+map[b][a]);
					crash= true;
					return;
				}
			}
			map[y][x]=0; map[b][a]=num;
			for(int i=0;i<rList.size();i++) {
				if(rList.get(i).name==num) {
					int num1 = rList.get(i).name,dir1=rList.get(i).dir;
					rList.set(i, new Robot(num1, a, b, dir1) );
				}
			}
		}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A=sc.nextInt();B=sc.nextInt();
		N=sc.nextInt();M=sc.nextInt();
		map = new int[B+1][A+1];
		for(int i=0;i<N;i++) {
			int x=sc.nextInt(),y=sc.nextInt(),dir;
			char tmp = sc.next().charAt(0);
			if(tmp=='N') dir=1;						// 북 1 , 동 2 , 남 3, 서 4
			else if(tmp=='E') dir=2;	
			else if(tmp=='S') dir=3;
			else dir=4;
			rList.add(new Robot(i+1,x, (B-y+1), dir));
			map[B-y+1][x]=i+1;
		}
		for(int i=0;i<M;i++) {
			int num = sc.nextInt();								// 명령을 받을 로봇
			char order = sc.next().charAt(0);					// 오더 ( L, R F )
			int count= sc.nextInt();							// 오더 반복 횟수
			for(int j=0;j<rList.size();j++) {
				if(crash) return;
				if(rList.get(j).name==num) {
					if(order=='L') {					//회전 L,R 을 반복 회수만큼 해주는 부분
						while(count>0) {
							int cur_dir = rList.get(j).dir;
							rList.get(j).dir = ((cur_dir-1)+3)%4+1;
							count--;
						}
					}
					else if(order=='R') {
						while(count>0) {
							int cur_dir = rList.get(j).dir;
							rList.get(j).dir = ((cur_dir-1)+1)%4+1;
							count--;
						}
					}
					else {
						int cx = rList.get(j).x, cy= rList.get(j).y;
						solve(num,count,cx,cy,rList.get(j).dir);
					}
					
				}
			}
		}
		if(!crash) System.out.println("OK");
	}
}