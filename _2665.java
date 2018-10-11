import java.util.*;
public class _2665 {
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static class Room{
		int x,y,w;
		Room(int x, int y,int wall){
			this.x=x;this.y=y;this.w=wall;
		}
	}
	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		boolean map[][] = new boolean[n][n];
		int dist[][] = new int[n][n];
		for(int i=0;i<n;i++) {
			String in = sc.next();
			for(int j=0;j<n;j++) {
				if(in.charAt(j)=='1') map[i][j]=true;
			}
		}
		for(int i=0;i<n;i++)for(int j=0;j<n;j++) dist[i][j]=Integer.MAX_VALUE;
		LinkedList<Room> list = new LinkedList<>();
		dist[0][0]=0;
		list.add(new Room(0,0,0));
		int count=0;
		while(!list.isEmpty()) {
			int cx = list.peek().x;
			int cy = list.peek().y;
			int cw = list.peek().w;
			list.poll();
			for(int i=0;i<4;i++) {
				int nx = cx+dx[i];
				int ny = cy+dy[i];
				if(nx<0||ny<0||nx>=n||ny>=n) continue;
				
				if(!map[nx][ny]) {						//벽이면
					if(dist[nx][ny]>dist[cx][cy]+1) {	//현재 오면서 만난 벽개수 +1보다 다음 맵 값이 크면 거기에 현재 값 저장
						list.add(new Room(nx,ny,cw+1));
						dist[nx][ny]=dist[cx][cy]+1;
					}
				}
				else {									//갈수 있는 곳이면
					if(dist[nx][ny]>dist[cx][cy]) {		
						list.add(new Room(nx,ny,cw));
						dist[nx][ny]=dist[cx][cy];
					}
				}
			}
		}
		System.out.println(dist[n-1][n-1]);
	}
}