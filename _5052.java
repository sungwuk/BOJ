import java.util.*;
public class _5052 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int t =sc.nextInt();
		for(int i=0;i<t;i++) {
			int n = sc.nextInt();
			String arr[] = new String[n];
			for(int j=0;j<n;j++) {
				arr[j]=sc.next();
			}
			Arrays.sort(arr);
			boolean flag=true;
			for(int j=1;j<n;j++) {
				if(arr[j].length()>=arr[j-1].length()) {
					if(arr[j-1].equals(arr[j].substring(0, arr[j-1].length()))) {
						System.out.println("NO");
						flag=false;
						break;
					}
				}
			}
			if(flag)System.out.println("YES");
		}
	}
}