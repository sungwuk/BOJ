import java.util.*;
public class _5567 {
	public static void main(String[] args) {
		int n,m,a,b;
		Scanner scan = new Scanner(System.in);
		n=scan.nextInt();
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[][] check = new boolean[502][502];
		boolean[] c = new boolean[502];
		m=scan.nextInt();
		c[1] = true;
		while(m>0) {
			a=scan.nextInt();b=scan.nextInt();
			check[a][b]=check[b][a]=true;
			m--;
		}
		for(int i=2;i<=n;i++) {
			if(check[1][i]) { q.add(i);
			c[i]=true;
			}
		}
		while(!q.isEmpty()) {
			int k=q.poll();
			for(int i=2;i<=n;i++) {
				if(check[k][i]&&!c[i]) {
					c[i]=true;
				}
			}
		}
		int v=0;
		for(int i=2;i<=n;i++) {
			if(c[i]) v++;
		}
		System.out.println(v);
	}
}