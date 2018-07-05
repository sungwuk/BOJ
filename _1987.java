import java.util.Scanner;
public class _1987 {
	static boolean[] check;
	static 	int r,c,count=0;
	static char[][] map;
	static int[] dx= {0,-1,1,0};
	static int[] dy= {1,0,0,-1};
	static void dfs(int x, int y,int dep) {
		if(x<0||y<0||x>=r||y>=c) return;// 맵 벗어나면 리턴
		if(check[map[x][y]-65]) return; //밟았던 곳이면 리턴
		check[map[x][y]-65]=true;
		for(int i=0;i<4;i++) {
			int a=x+dx[i];
			int b=y+dy[i];
			dfs(a,b,dep+1);
		}
		check[map[x][y]-65]=false;
		count=Math.max(dep,count);
	}
	public static void main(String[] args) {//65~90
		Scanner scan = new Scanner(System.in);
		r=scan.nextInt();c=scan.nextInt();
		map=new char[r][c];
		check = new boolean[26];
		for(int i=0;i<r;i++) {
			String a=scan.next();
			for(int j=0;j<a.length();j++) {
				map[i][j]=a.charAt(j);
			}
		}
		dfs(0,0,1);
		System.out.println(count);
	}
}
