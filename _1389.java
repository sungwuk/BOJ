import java.util.*;
public class _1389 {
	static class Point{
		int y,dist;
		Point(int y, int d){
			;this.y=y;this.dist=d;
		}
	}
	static LinkedList<Point>[] map;
	public static void main(String[] args) {
		int n,m;
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();m=sc.nextInt();
		map = new LinkedList[n+1];
		int sol[] = new int[n+1];int dap[] = new int[n+1];
		boolean check[];
		for(int i=1;i<=n;i++) {				//map 배열 초기화
			map[i]=new LinkedList<Point>();
			sol[i]=Integer.MAX_VALUE;
		}
		for(int i=0;i<m;i++) {
			int a=sc.nextInt(),b=sc.nextInt();
			map[a].add(new Point(b,0));
			map[b].add(new Point(a,0));
		}
		for(int i=1;i<=n;i++) {
			LinkedList<Point> list = new LinkedList<>();
			check = new boolean[n+1];
			check[i]=true;
			for(int j=0;j<map[i].size();j++) {
				list.add(new Point(map[i].get(j).y,(map[i].get(j).dist+1)));
			}
			for(int j=1;j<=n;j++) {				//map 배열 초기화
				sol[j]=Integer.MAX_VALUE;
			}
			int total=0;
			sol[i]=0;
			while(!list.isEmpty()) {
				Point tmp = list.poll();
				int cy = tmp.y;
				int cd = tmp.dist;
				sol[cy]=Math.min(cd, sol[cy]);
				check[cy]=true;
				for(int j=0;j<map[cy].size();j++) {
					int ny = map[cy].get(j).y;
					int nd = cd+1;
					if(!check[ny]) {
						check[ny]=true;
						list.add(new Point(ny,nd));
					}	
				}
			}

			for(int j=1;j<=n;j++) {
				total+=sol[j];
			}
			dap[i]=total;
		}
		int min=Integer.MAX_VALUE;
		for(int j=1;j<=n;j++) {
			if(min>dap[j]) min=dap[j];
		}
		for(int j=1;j<=n;j++) {
			if(dap[j]==min) {
				System.out.println(j);
				return;
			}
		}
	}
}