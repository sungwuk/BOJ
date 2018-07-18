import java.util.*;
public class _1748 {

	public static void main(String[] args) {
		int n,r=0;
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
			for(int i=1;i<=n;i*=10) {
				r+=n-i+1;
			}
			System.out.println(r);
	}

}
