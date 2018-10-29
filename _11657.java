import java.util.*;
import java.io.*;
public class _11657 {
	static class Edge{
		int v,wei;
		Edge(int v,int w){
			this.v=v;this.wei=w;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Scanner sc= new Scanner(System.in);
		//		int n=sc.nextInt(),m=sc.nextInt();
		int dist[]  = new int[n+1];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		LinkedList<Edge> list [] = new LinkedList[n+1];
		for(int i=1;i<=n;i++)list[i] = new LinkedList<>();
		for(int a=0;a<m;a++) {
			st = new StringTokenizer(br.readLine());
			int i =Integer.parseInt(st.nextToken()), j =Integer.parseInt(st.nextToken()), c=Integer.parseInt(st.nextToken());
			list[i].add(new Edge(j, c));
		}
		dist[1]=0;
		boolean flag = false;
		for(int i=1;i<=n+1;i++) {
			for(int j=1;j<=n;j++) {
				for(Edge e : list[j])
				if(dist[j]!=Integer.MAX_VALUE&&dist[e.v]>dist[j]+e.wei) {
					dist[e.v]=dist[j]+e.wei;
					if(i==n+1) flag=true;
				}
			}
		}
		if(flag) {
			bw.write("-1");
		}
		else {
			for(int i=2;i<=n;i++) {
				bw.write((dist[i]==Integer.MAX_VALUE ? -1:dist[i])+"\n");

			}
		}
		bw.close();
	}
}