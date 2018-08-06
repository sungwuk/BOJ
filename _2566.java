import java.util.*;
public class _2566 {

	public static void main(String[] args) {
		int a[][] = new int[9][9],max=0,x=0,y=0;
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				a[i][j]= sc.nextInt();
				if(max<a[i][j]) {
					max=a[i][j];
					x=i+1;y=j+1;
				}
			}
		}
		System.out.println(max);
		System.out.println(x+" "+y);
	}

}
