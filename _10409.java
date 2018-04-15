import java.util.*;
public class _10409 {
	public static void main(String[] args) {
		int n,T,result=0,sum=0;
		Scanner scan = new Scanner(System.in);
		n=scan.nextInt();T=scan.nextInt();
		for(int i=0;i<n;i++) {
			sum+=scan.nextInt();
			if(sum<=T) result++;
		}
		System.out.println(result);
	}
}