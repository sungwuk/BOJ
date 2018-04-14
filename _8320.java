import java.util.*;
public class _8320 {
	public static void main(String[] args) {
		int n,count=0;
		Scanner scan = new Scanner(System.in);
		n= scan.nextInt();
		boolean [][] check = new boolean[n+1][n+1];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				if(check[i][j]||check[j][i]) {
					continue;
				}
				else {
					if(i*j<=n) {
						check[i][j]=check[j][i]=true;
						count++;
					}
				}
			}
		}
		System.out.println(count);
	}
}