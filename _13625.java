import java.util.*;
public class _13625 {
	public static void main(String[] args) {
		int t,m,n;
		Scanner sc =new Scanner(System.in);
		t=sc.nextInt();
		for(int a=0;a<t;a++) {
			n=sc.nextInt();m=sc.nextInt();
			LinkedList<Integer>[] list = new LinkedList[n+1];
			boolean[] color = new boolean[n+1];
			boolean[] chk = new boolean[n+1];
			for(int i=1;i<=n;i++) {
				list[i]=new LinkedList<>();
			}
			for(int i=0;i<m;i++) {
				int p=sc.nextInt();
				int q=sc.nextInt();
				list[p].add(q);
				list[q].add(p);
			}
			LinkedList<Integer> li = new LinkedList<>();
			boolean f = true;
			for(int i=1;i<=n;i++) {
				if(!chk[i]) {
					color[i]=true;
					li.add(i);
					while(!li.isEmpty()) {
						int tmp  = li.poll();
						chk[tmp] =true;
						for(int next : list[tmp]) {
							if(chk[next]&&color[next]==color[tmp]) {
								li.clear();
								f=false;
								break;
							}
							if(!chk[next]) {
								color[next]=!color[tmp];
								li.add(next);
							}
						}
					}
				}
			}
			if(!f)System.out.println("impossible");
			else System.out.println("possible");
		}
		
	}
}