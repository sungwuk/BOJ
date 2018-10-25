import java.util.*;
public class _1075 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(),f=sc.nextInt();
		n= (n/100)*100;
		int tmp = n/f;
		if(tmp*f!=n) {
			
			tmp = tmp*f+f;
		}
		else {
			tmp = tmp*f;
		}
		tmp = tmp-n;
		if(tmp<10) {
			System.out.println("0"+tmp);
		}
		else System.out.println(tmp);
	}
}