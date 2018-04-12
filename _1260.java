import java.util.*;
public class _1260 {
	static boolean[][] adj;
	static boolean[] visit;
	public static void dfs(int n) {
		System.out.print(n+" ");
		visit[n]=true;
		for(int i=1;i<adj.length;i++) {
			if(adj[n][i]&&!visit[i]) dfs(i);
		}
		
	}
	public static void main(String[] args) {
		int N,M,start,v1,v2;
		
		Stack<Integer> S = new Stack<Integer>();
		Queue<Integer> Q = new LinkedList<Integer>();
		Scanner scan = new Scanner(System.in);
		N=scan.nextInt();M=scan.nextInt();start=scan.nextInt();
		adj= new boolean[N+1][N+1];visit =  new boolean[N+1];
		S.push(start);Q.add(start);
		while(M>0) {
			v1=scan.nextInt();
			v2=scan.nextInt();
			adj[v1][v2]=adj[v2][v1]=true;
			M--;
		}
		dfs(start);
		System.out.println();
		visit = new boolean[N+1];
		visit[start]=true;
		while(!Q.isEmpty()) {	//BFS
			int b = Q.poll();
			System.out.print(b+" ");
			for(int i=1;i<adj.length;i++) {
				if(adj[b][i]&&!visit[i]) {
					visit[i]=true;
					Q.add(i);
				}
			}
		}
	}
}