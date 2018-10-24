import java.util.*;
public class _1032 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		String arr[] =  new String[n];
		for(int i=0;i<n;i++) {
			arr[i]  =sc.next();
		}
		for(int i=0;i<arr[0].length();i++) {
			char tmp = arr[0].charAt(i);
			boolean flag = true;
			for(int j=1;j<n;j++) {
				if(arr[j].charAt(i)!=tmp) {
					System.out.print("?");
					flag = false;
					break;
				}
			}
			if(flag)System.out.print(tmp);
		}
	}
}