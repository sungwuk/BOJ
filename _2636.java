import java.util.*;
public class _2636 {
	static int m,n,map[][],tmpMap[][];
	static int dx[]= {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	static boolean check[][],c[][];
	static class Point{
		int x,y;
		Point(int x, int y){
			this.x=x;this.y=y;
		}
	}
	static void flood(int a,int b, int[][] tm) {
		if(a<0||a>=m||b<0||b>=n) return;
		if(tm[a][b]==0) {
			tm[a][b]=2;
			for(int i=0;i<4;i++) {
				int nx=a+dx[i];
				int ny =b+dy[i];
				if(nx<0||ny<0||nx>=m||ny>=n)continue;
				flood(nx,ny,tm);
			}
		}
	}
	static boolean air(int a,int b,int[][] tm) {
		int c=0;
		for(int i=0;i<4;i++) {
			int q = a+dx[i];
			int r = b+dy[i];
			if(q<0||r<0||q>=m||r>=n)continue;
			if(tm[q][r]==2) c++;
		}
		return c!=0;
	}
	static void copy(int [][] a,int [][] b) {
		for(int i=0;i<a.length;i++) {
			System.arraycopy(a[i], 0, b[i], 0, a[i].length);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m= sc.nextInt();n=sc.nextInt();
		map = new int[m][n];
		tmpMap = new int[m][n];
		LinkedList<Point> list = new LinkedList<>();
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		flood(0,0,map);
		copy(map,tmpMap);
		int hour=0;
		LinkedList<Integer> li = new LinkedList<>();
		while(true) {
			int melting=0;
			for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++) {
					if(map[i][j]==1&&air(i,j,map)) { 
						melting++;
						tmpMap[i][j]=2;
						 for(int k=0;k<4;k++) {
							 flood(i+dx[k],j+dy[k],tmpMap);
						 }
					}
				}
			}
			if(melting==0) {
				System.out.println(hour);
				System.out.println(li.get(hour-1));
				return;
			}
			li.add(melting);
			copy(tmpMap,map);
			hour++;
		}
	}
}