import java.util.*;
public class _2810 {
	public static void main(String[] args) {
		int N,count=0;String seats;boolean flag=true;
		Scanner scan = new Scanner(System.in);
		N=scan.nextInt();
		seats=scan.next();
		for(int i=0;i<seats.length();i++) {
			if(seats.charAt(i)=='L') { 
				i++;flag=false;
			}
			count++;
		}
		if(flag) {
			System.out.println(seats.length());
		}
		else System.out.println(count+1);
	}
}