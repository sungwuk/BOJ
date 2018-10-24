import java.util.*;
public class _3047 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int ar[] = new int[3];
		for(int i=0;i<3;i++)ar[i]=sc.nextInt();
		Arrays.sort(ar);
		String s = sc.next();
		for(int i=0;i<3;i++) {
			if(s.charAt(i)=='A') {
				System.out.print(ar[0]+" ");
			}
			else if(s.charAt(i)=='B') System.out.print(ar[1]+" ");
			else System.out.print(ar[2]+" ");
		}
	}
}