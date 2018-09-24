import java.util.*;
public class _11559 {
	static int dx[]= {0,0,1,-1},count;
	static int dy[]= {1,-1,0,0};
	static boolean chk[][],flag=true;
	static class Point {
		int x,y;
		Point(int x,int y){
			this.x=x;this.y=y;
		}
	}
	static char map[][] = new char[12][6];
	static void puyo(int x,int y ,char t) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x,y));
		boolean chk[][]= new boolean[12][6];
		while(!q.isEmpty()) {
			int cx = q.peek().x;int cy = q.peek().y;
			map[cx][cy]='.';
			q.poll();
			chk[cx][cy]=true;
			
			for(int i=0;i<4;i++) {
				int nx = cx+dx[i];
				int ny = cy+dy[i];
				if(nx<0||ny<0||nx>=12||ny>=6) continue;
				if(chk[nx][ny]) continue;
				if(map[nx][ny]==t) {
					chk[nx][ny]=true;
					map[nx][ny]='.';
					q.add(new Point(nx,ny));
				}
			}
		}
	}
	static void solve(int x,int y) {
		char target= map[x][y];count=0;
		Queue<Point> q = new LinkedList<>();
		boolean chk[][]= new boolean[12][6];
		q.add(new Point(x,y));
		while(!q.isEmpty()) {
			int cx = q.peek().x;
			int cy = q.peek().y;
			q.poll();count++;
			if(count>=4) break;
			chk[cx][cy]=true;
			for(int i=0;i<4;i++) {
				int nx = cx+dx[i];
				int ny = cy+dy[i];
				if(nx<0||ny<0||nx>=12||ny>=6) continue;
				if(chk[nx][ny]) continue;
				if(map[nx][ny]==target) {
					chk[nx][ny]=true;
					q.add(new Point(nx,ny));
				}
			}
		}
		if(count>=4) puyo(x,y,target);
		
	}
	static void down() {
		for(int j=0;j<6;j++) {
			char []arr = new char[12];int index=0;
			for(int i=11;i>=0;i--) {
				if(map[i][j]!='.') arr[index++]=map[i][j];
			}
			for(int i=11;i>11-index;i--) map[i][j]=arr[11-i];
			for(int i=11-index;i>=0;i--) map[i][j]='.';
		}
	}
	static boolean check() {
		int max = Integer.MIN_VALUE;
		for(int i=0;i<12;i++) {
			for(int j=0;j<6;j++) {
				if(map[i][j]!='.') {
					count=0;
					Queue<Point> q = new LinkedList<>();
					boolean chk[][]= new boolean[12][6];
					q.add(new Point(i,j));
					while(!q.isEmpty()) {
						int cx = q.peek().x;
						int cy = q.peek().y;
						q.poll();
						count++;
						if(count>=4) return true;
						chk[cx][cy]=true;
						for(int k=0;k<4;k++) {
							int nx = cx+dx[k];
							int ny = cy+dy[k];
							if(nx<0||ny<0||nx>=12||ny>=6) continue;
							if(chk[nx][ny]) continue;
							if(map[nx][ny]==map[i][j]) {
								chk[nx][ny]=true;
								q.add(new Point(nx,ny));
							}
						}
					}
					max = Math.max(max, count);
				}
			}
		}
		if(max<4) return false;
		else return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<12;i++) {
			String s = sc.next();
			for(int j=0;j<6;j++) {
				map[i][j]=s.charAt(j);
			}
		}
		int dap=0;
		while(check()) {					//check 는 4 이상의 터트릴 것이 있나 확인하는 부분
			for(int i=0;i<12;i++) {
				for(int j=0;j<6;j++) {
					if(map[i][j]!='.') {
						solve(i,j);	
					}
				}
			}
			down();							//맵 전체를 보고 4개 이상인 것을 .로 바꾸고 중력에 의해 내리는 부분
			dap++;
		}
		System.out.println(dap);
	}
}