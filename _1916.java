import java.util.*;
public class _1916 {
	static class Edge implements Comparable<Edge>{
		int v,dist;
		Edge(int v,int d){
			this.v=v;this.dist=d;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.dist-o.dist;
		}
		
	}
	public static void main(String[] args) {
		int n,m,start,end;
		Scanner sc= new Scanner(System.in);
		n=sc.nextInt();m=sc.nextInt();
		boolean[] check = new boolean[n+1];
		int[] dist = new int[n+1];
		LinkedList<Edge>[] list = new LinkedList [n+1];
		for(int i=1;i<=n;i++) {
			dist[i]=Integer.MAX_VALUE;
			list[i] = new LinkedList<>();  
		}
		for(int i=0;i<m;i++) {
			int a=sc.nextInt(),b=sc.nextInt(),c=sc.nextInt();
			list[a].add(new Edge(b,c));
		}
		start=sc.nextInt();end=sc.nextInt();
		PriorityQueue<Edge> q = new PriorityQueue<>();
		q.add(new Edge(start, 0));
		dist[start]=0;
		while(!q.isEmpty()) {
			Edge cur = q.poll();
			if(check[cur.v]) continue;
			check[cur.v]=true;
			for(Edge e : list[cur.v]) {
				if(!check[e.v]) {
					dist[e.v] = Math.min(dist[cur.v]+e.dist, dist[e.v]);
					q.add(new Edge(e.v,dist[e.v]));
				}
			}
		}
			System.out.println(dist[end]);
	}

}
