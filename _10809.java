import java.util.*;
public class _10809 {
	public static void main(String[] args) {
		int[] ar = new int[26];
		Scanner sc= new Scanner(System.in);
		String s = sc.next();
		for(int i=0;i<26;i++)ar[i]=-1;
		for(int i=0;i<s.length();i++) {
			int a=s.charAt(i)-97;
			if(ar[a]==-1) ar[a]=i;
		}
		for(int i : ar) {
			System.out.println(i);
		}
	}
}