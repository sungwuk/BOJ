import java.util.*;
public class _1074 {
	static int n,c,r,z=-1;
	static void solve(int x, int y, int size) {
		if(size==1) {
			z++;
			if(x==r&&y==c) {
				System.out.println(z);
			}
			return;
		}
		// 4분면으로 나누기
		solve(x,y+size/2,size/2);
		solve(x,y,size/2);
		solve(x+size/2,y,size/2);
		solve(x+size/2,y+size/2,size/2);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();r=sc.nextInt();c=sc.nextInt();
		solve(0,0,(int)Math.pow(2, n));
	}

}
