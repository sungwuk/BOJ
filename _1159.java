import java.util.*;
public class _1159 {
	public static void main(String[] args) {
		int n;
		boolean check=false;
		Scanner scan = new Scanner(System.in);
		n=scan.nextInt();
		int[] asc = new int[26];
		while(n>0) {
			String input = scan.next();
			int x= input.charAt(0)-97;
			asc[x]++;
			n--;
		}
		for(int i=0;i<26;i++) {
			if(asc[i]>=5) {
				System.out.print(Character.toString((char)(i+97)));
				check = true;
			}
		}
		if(!check) System.out.println("PREDAJA");
	}
}
