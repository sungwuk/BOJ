import java.util.*;
public class _13913 {
	static class Point{
		int x,d;
		Point(int x, int d){
			this.x=x;this.d=d;
		}
	}
	public static void main(String[] args) {
		int n,k;
		int[] d= {1,-1};
		Scanner sc= new Scanner(System.in);
		n=sc.nextInt();k=sc.nextInt();
		Queue<Point> q = new LinkedList<Point>();
		LinkedList<Integer> list = new LinkedList<>();
		q.add(new Point(n,0));
		boolean[] check = new boolean[200003];
		int[] prev = new int[200000];
		while(!q.isEmpty()) {
			Point tmp =q.poll();
			int cur = tmp.x;
			int dep = tmp.d;
			if(cur==k) {
				System.out.println(dep);
				int v = cur;
				for(;v!=n;v=prev[v]) {
					list.add(v);
				}
				list.add(n);
				while(!list.isEmpty()) {
					int t=list.pollLast();
					System.out.print(t+" ");
				}
				return;
			}
			for(int i=0;i<2;i++) {				//+-1
				int a = cur+d[i];
				if(a<0||a>100000) continue;
				if(!check[a]) {
					check[a]=true;
					prev[a]=cur;
					q.add(new Point(a,dep+1));
				}
			}
			int a= cur*2;						//2*x
			if(a<0||a>100000) continue;
			if(!check[a]) {
				check[a]=true;
				prev[a]=cur;
				q.add(new Point(a,dep+1));
			}
		}
	}
}