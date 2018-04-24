import java.util.*;
public class _5565 {

	public static void main(String[] args) {
		int total,i=10,input;
		Scanner scan = new Scanner(System.in);
		total=scan.nextInt();
		while(i>1) {
			input=scan.nextInt();
			total-=input;
			i--;
		}
		System.out.println(total);
	}

}
