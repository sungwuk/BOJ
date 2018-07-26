import java.util.*;
public class _1547 {

	public static void main(String[] args) {
		int m;
		int[] cups = new int[4];
		Scanner sc = new Scanner(System.in);
		m=sc.nextInt();
		
		for(int i=1;i<4;i++) cups[i]=i;
		
		for(int i=1;i<=m;i++) {
			int a = sc.nextInt(),b=sc.nextInt();
			int ca = cups[a],cb=cups[b];
			cups[a]=cb;cups[b]=ca;
		}
		for(int i=1;i<=3;i++) {
			if(cups[i]==1)System.out.println(i);
		}
		
	}

}
