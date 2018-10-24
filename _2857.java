import java.util.*;
public class _2857 {
	public static void main(String[] args) {
		int count=0;
		Scanner sc= new Scanner(System.in);
		for(int i=0;i<5;i++) {
			String in = sc.next();
			if(in.contains("FBI")) {
				System.out.print(i+1+" ");
				count++;
			}
		}
		if(count==0) System.out.println("HE GOT AWAY!");
	}
}