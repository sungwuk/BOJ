import java.util.*;
public class _1026 {
	public static void main(String[] args) {
		int n,result=0;
		Scanner sc = new Scanner(System.in);
		 n=sc.nextInt();
		int[]a=new int[n],b=new int[n];
		
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
		for(int i=0;i<n;i++) {
			b[i]=sc.nextInt();
		}
		Arrays.sort(a);
		Arrays.sort(b);
		for(int i=0;i<n;i++) {
			result+= a[i]*b[n-i-1];
		}
		System.out.println(result);
	}

}
