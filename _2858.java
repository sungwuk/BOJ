import java.util.*;
public class _2858 {

	public static void main(String[] args) {
		int r,b;
		Scanner sc= new Scanner(System.in);
		r=sc.nextInt();b=sc.nextInt();
		for(int w=3;w<=5000;w++) {
			for(int l=3;l<=5000;l++) {
				int calc_brown = (w-2)*(l-2);
				int clac_red = (w*l)-calc_brown;
				if(clac_red==r&&calc_brown==b) {
					System.out.println(Math.max(l, w)+" "+Math.min(l,w));
					return;
				}
			}
		}
	}
}
