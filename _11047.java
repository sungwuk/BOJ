import java.util.*;
public class _11047 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(),k=sc.nextInt();
		int arr[] = new int[n];
		int count=0;
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		for(int i=n-1;i>=0;) {
			if(k-arr[i]<0) i--;
			else {
				k-=arr[i];
				count++;
			}
		}
		System.out.println(count);
	}

}
