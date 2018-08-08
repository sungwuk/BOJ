import java.util.*;
public class _5214 {
	public static void main(String[] args) {
		int n,k,m;
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();k=sc.nextInt();m=sc.nextInt();
		LinkedList<Integer>[] map = new LinkedList[101001];
		int[] check = new int[101001];
		for(int i=1;i<=101000;i++) {
			map[i] = new LinkedList<>();
		}
		for(int i=n+1;i<=n+m;i++) {
			for(int j=0;j<k;j++) {
				int a = sc.nextInt();
				map[i].add(a);
				map[a].add(i);
			}
		}
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		check[1]=1;
		while(!q.isEmpty()) {
			int cur = q.poll();
			if(cur==n) {
				System.out.println((check[cur]/2)+1);
				return;
			}
			for(int i=0;i<map[cur].size();i++) {
				int j = map[cur].get(i);
				if(check[j]==0) {
					check[j]= check[cur]+1;
					q.add(j);
				}
			}
		}
		System.out.println(-1);
		
	}
}