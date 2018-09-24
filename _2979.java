import java.util.*;
public class _2979 {
	public static void main(String[] args) {
		int a,b,c,dap=0;
		Scanner sc = new Scanner(System.in);
		a=sc.nextInt();b=sc.nextInt();c=sc.nextInt();
		int arr[]= new int[101];
		int max=Integer.MIN_VALUE;
		for(int i=0;i<3;i++) {
			int p=sc.nextInt(),q=sc.nextInt();
			if(max<q) max=q;
			for(;p<q;p++) arr[p]++;
		}
		System.out.println(); 
		for(int i=1;i<max;i++) {
			if(arr[i]==1) dap+=(arr[i]*a);
			else if(arr[i]==2) dap+=(arr[i]*b);
			else dap+=(arr[i]*c);
		}
		System.out.println(dap);
	}
}