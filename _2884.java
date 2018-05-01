import java.util.*;
public class _2884 {
	public static void main(String[] args) {
		int H,M;
		Scanner scan = new Scanner(System.in);
		H=scan.nextInt();M=scan.nextInt();
		if(M<45) {
			if(H<1) {
				H=23;
			}
			else {
				H--;
			}
			M=60-(45-M);
		}
		else {
			M-=45;
		}
		System.out.println(H+" "+M);
	}
}