import java.util.*;
public class _2960 {
	public static void main(String[] args) {
		int N,K,count=0;
		boolean flag=false;
		Scanner scan = new Scanner(System.in);
		N=scan.nextInt();K=scan.nextInt();
		boolean[] check = new boolean[N+1];
		for(int i=2;i<=N;i++) {
			for(int j=i;j<=N;j+=i) {
				if(!check[j]) {
					count++;
					check[j]=true;
				}
				if(count==K) {
					System.out.println(j);
					flag=true;
					break;
				}
			}
			if(flag)break;
		}
	}
}