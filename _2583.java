import java.util.*;
public class _2583 {
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static class Point{
		int x,y;
		Point(int x,int y){
			this.x=x;this.y=y;
		}
	}
	public static void main(String[] args) {
		int m,n,k;
		Scanner sc = new Scanner(System.in);
		m=sc.nextInt();n=sc.nextInt();k=sc.nextInt();
		int[][] map = new int[m][n];
		boolean[][] check = new boolean[m][n];
		for(int i=0;i<k;i++) {
			int y1=sc.nextInt(),x1=sc.nextInt();  // 0 2
			int y2=sc.nextInt(),x2=sc.nextInt();  // 4 4
			for(int j=x1;j<x2;j++) {
				for(int t=y1;t<y2;t++) {
					map[j][t]= 1;
				}
			}
		}
		int count=0;						//분리된 영역 개수
		LinkedList<Integer> area = new LinkedList<>();
		for(int j=0;j<m;j++) {
			for(int t=0;t<n;t++){
				if(map[j][t]==0&&!check[j][t]) {
					int b=1;
					LinkedList<Point> list = new LinkedList<>();
					list.add(new Point(j,t));
					count++;
					while(!list.isEmpty()) {
						Point tmp = list.poll();
						int x = tmp.x;
						int y = tmp.y;
						check[x][y]=true;
						for(int a=0;a<4;a++) {
							int nx = x+dx[a];
							int ny = y+dy[a];
							if(nx<0||ny<0||nx>=m||ny>=n) continue;
							if(map[nx][ny]==0&&!check[nx][ny]) {
								check[nx][ny]=true;
								b++;
								list.add(new Point(nx,ny));
							}
						}
					}
					 area.add(b);
				}
			}
		}
		Collections.sort(area);
		System.out.println(count);
		for(int o=0;o<area.size();o++) System.out.print(area.get(o)+" ");
	}
}