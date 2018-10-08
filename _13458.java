import java.util.*;
public class _13458 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		int b=sc.nextInt(),c=sc.nextInt();
		long dap=n;
		for(int i=0;i<n;i++) {
		arr[i]= arr[i]-b >0 ? arr[i]-b : 0;
		}
		int tmp;
		for(int i=0;i<n;i++) {
			tmp = arr[i]%c;
			if(tmp == 0)
				dap += arr[i]/c;
			else
				dap += (arr[i]/c)+1;
			
		}
		
		System.out.println(dap);
	}
}
