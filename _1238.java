import java.util.*;
class Edge implements Comparable<Edge>{
	int dest;
	int weight;
	Edge(int d,int w){
		this.dest=d;this.weight=w;
	}
	@Override
	public int compareTo(Edge o) {
		return this.weight-o.weight;
	}

}
public class _1238 {
	static boolean[] check;
	static LinkedList<Edge>[] list,list_reverse;
	static int dist[],dist_re[],n,m,x,dap=Integer.MIN_VALUE;
	static PriorityQueue<Edge> q;
	static void dijstra(int start,int[] d,LinkedList<Edge>[] li) {
		q.add(new Edge(start,0));   
		while(!q.isEmpty()) {
			Edge k = q.poll();
			if(check[k.dest]) continue;
				check[k.dest]=true;
				for(Edge e : li[k.dest]) {
					if(!check[e.dest]) {
						d[e.dest]=Math.min(d[k.dest]+e.weight, d[e.dest]);
						q.add(new Edge(e.dest,d[e.dest]));
					}
				}
		}
	}
	static void init() {
		dist = new int[n+1];
		dist_re = new int[n+1];
		list = new LinkedList[n+1];
		list_reverse = new LinkedList[n+1];
		check = new boolean[n+1];
		q = new PriorityQueue<>();
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		n=sc.nextInt();m=sc.nextInt();x=sc.nextInt();
		init();
		for(int i=1;i<=n;i++) {
			list[i] = new LinkedList<>();
			list_reverse[i] = new LinkedList<>();
			dist[i]= Integer.MAX_VALUE;
			dist_re[i]=Integer.MAX_VALUE;
		}
		for(int i=0;i<m;i++) {
			int a=sc.nextInt(),b=sc.nextInt(),c=sc.nextInt();
			list[a].add(new Edge(b,c));
			list_reverse[b].add(new Edge(a,c));
		}
		dist[x]=0;
		dijstra(x,dist,list);
		dist_re[x]=0;
		check = new boolean[n+1];
		dijstra(x,dist_re,list_reverse);
		for(int i=1;i<=n;i++) {
			dist[i]+=dist_re[i];
		}
		Arrays.sort(dist);
		System.out.println(dist[n]);
	}
}