import java.util.*;
public class _13549 {
	static class Point{
		int x,d;
		Point(int x, int d){
			this.x=x;this.d=d;
		}
	}
	public static void main(String[] args) {
		int n,k,sol=0;
		int[] d= {1,-1};
		Scanner sc= new Scanner(System.in);
		n=sc.nextInt();k=sc.nextInt();
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(n,0));
		int dap=Integer.MAX_VALUE;
		boolean[] check = new boolean[200003];
		while(!q.isEmpty()) {
			Point tmp =q.poll();
			int cur = tmp.x;
			int dep = tmp.d;
            if(cur== k) {
				System.out.println(0);
				return;
			}
			check[cur]=true;
			for(int i=0;i<2;i++) {
				int a = cur+d[i];
				if(a==k) {
					dap = Math.min(dap, dep+1);
				}
				if(a<0||a>100000) continue;
				if(k!=a&&!check[a]) {
					q.add(new Point(a,dep+1));
				}
			}
			int a= cur*2;
			if(a==k) {
				dap = Math.min(dap, dep);
			}
			if(a<0||a>100000) continue;
			if(k!=a&&!check[a]) {
				q.add(new Point(a,dep));
			}
		}
		System.out.println(dap);
	}
}