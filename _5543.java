import java.util.*;
public class _5543 {
	public static void main(String[] args) {
		int s,j,h,coke,cider,min;
		Scanner scan = new Scanner(System.in);
		s=scan.nextInt();min=s;
		j=scan.nextInt();if(min>j) min=j;
		h=scan.nextInt();if(min>h) min=h;
		coke=scan.nextInt();cider=scan.nextInt();
		System.out.println(((cider>coke)? coke:cider) +min-50);
	}

}
