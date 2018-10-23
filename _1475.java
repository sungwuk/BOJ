import java.util.*;
public class _1475 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String in = sc.next();
		int arr[] = new int[11];
		for(int i=0;i<in.length();i++) {
			int a = in.charAt(i)-'0';
			if(a==9||a==6) {
				arr[9]++;						//9와 6은 하나로
			}
			else arr[a]++;
		}
		int max=1;
		for(int i=0;i<11;i++) {
			if(arr[i]>max) {
				if(i==9) {
					double a= (double)arr[i]/2;
					max=(int)Math.ceil(a);
				}
				else max = arr[i];
			}
		}
		System.out.println(max);

	}
}
