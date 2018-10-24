import java.util.*;
public class _10808 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println((int)'z'-97);
		String s = sc.next();
		int arr[] = new int[26];
		for(int i=0;i<s.length();i++) {
			arr[s.charAt(i)-97]++;
		}
		for(int a : arr)System.out.print(a+" ");
	}
}