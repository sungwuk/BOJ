import java.util.*;
public class _12790 {
	public static void main(String[] args) {
		int HP,MP,AT,DF,T,total=0;
		Scanner scan = new Scanner(System.in);
		T=scan.nextInt();
		while(T>0) {
			HP=scan.nextInt();MP=scan.nextInt();AT=scan.nextInt();DF=scan.nextInt();
			int add;
			add=scan.nextInt();
			HP+=add;
			if(HP<1) HP=1;
			total+=HP;
			add = scan.nextInt();
			MP+=add;
			if(MP<1) MP=1;
			total+=(MP)*5;
			add=scan.nextInt();
			AT+=add;
			if(AT<0) AT=0;
			total+=2*(AT);
			add=scan.nextInt();
			DF+=add;
			total+=2*(DF);
			System.out.println(total);
			total=0;
			T--;
		}
	}
}