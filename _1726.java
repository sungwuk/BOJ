package first;

import java.util.*;
public class _1726 {
	static class Robot{
		int x, y,dir,count=0;
		boolean flag=true;
		Robot(int x, int y ,int dir, int count){
			this.x=x;this.y=y;this.dir=dir;this.count=count;
		}
	}
	static int opp(int x) {
		if(x==1)return 2;
		if(x==2) return 1;
		if(x==3) return 4;
		return 3;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M,N,k=0;
		int[] dx = {0,0,0,1,-1};
		int[] dy = {0,1,-1,0,0};
		LinkedList<Robot> list = new LinkedList<Robot>();

		M=sc.nextInt();N=sc.nextInt();
		boolean[][][] check = new boolean[M+1][N+1][5];
		boolean[][] map = new boolean[M+1][N+1];

		for(int i=1;i<=M;i++) {
			for(int j=1;j<=N;j++) {
				int a= sc.nextInt();
				if(a==1) map[i][j]=false;
				else map[i][j]=true;
			}
		}
		int start_x = sc.nextInt();
		int start_y = sc.nextInt();
		int start_dir = sc.nextInt();
		list.add(new Robot(start_x,start_y,start_dir,0));  //½ÃÀÛ

		int dst_x= sc.nextInt();
		int dst_y= sc.nextInt();
		int dst_dir = sc.nextInt();
		check[list.peek().x][list.peek().y][list.peek().dir]=true;
		while(!list.isEmpty()) {
			Robot robot = list.remove(0);
			int cur_x=robot.x;
			int cur_y=robot.y;
			int cur_dir=robot.dir;
			int cur_count=robot.count;
			
			if(cur_x==dst_x&&cur_y==dst_y&&cur_dir==dst_dir) {
				System.out.println(cur_count);
				list.clear();
				return;
			}
			for(int i=1;i<=3;i++) {
				int a = cur_x+dx[cur_dir]*i;
				int b = cur_y+dy[cur_dir]*i;
				if(a<1||b<1||a>M||b>N) break;
				if(!map[a][b])break;
				if(check[a][b][cur_dir]) continue;
				check[a][b][cur_dir]=true;
				list.add(new Robot(a,b,cur_dir,(cur_count+1)));
			}
			for(int i=1;i<=4;i++) {
				if(i==cur_dir||i==opp(cur_dir)) continue;
				if(check[cur_x][cur_y][i])continue;
				check[cur_x][cur_y][i]=true;
				list.add(new Robot(cur_x,cur_y,i,(cur_count+1)));
			}
		}

	}
}