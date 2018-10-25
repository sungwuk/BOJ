import java.util.*;
public class _11404 {
	static int MAX = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(),m=sc.nextInt();
		int[][] dist = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				dist[i][j] = (i == j) ? 0 : MAX; 
			}
		}
		for (int i = 1; i <= m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			dist[a][b] = Math.min(c,dist[a][b]);
		}
		
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if(dist[i][k]==MAX||dist[k][j]==MAX) continue;
					if (dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(dist[i][j]==MAX) System.out.print(0+" ");
				else System.out.print(dist[i][j]+" ");
			}
			System.out.println();
		}
	}
}