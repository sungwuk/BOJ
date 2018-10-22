import java.util.*;
public class _1157 {
	public static void main(String[] args) {
		int arr[] = new int[26];
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)-65>=26) {
				arr[s.charAt(i)-65-32]++;
			}
			else {
				
				arr[s.charAt(i)-65]++;
			}
		}
		int idx=0;
		for(int i=0;i<26;i++) {
			if(arr[i]>arr[idx])idx=i;
		}
		int count=0;
		for(int i=0;i<26;i++) {
			if(arr[idx]==arr[i])count++;
			if(count==2) {
				System.out.println("?");
				return;
			}
		}
		System.out.println((char)(idx+65));
	}

}
