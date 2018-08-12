import java.util.*;
public class _7568 {
	static class Person{
		int wei,hei;
		Person(int w,int h){
			this.wei=w;this.hei=h;
		}
	}
	public static void main(String[] args) {
		int n;
		Scanner sc= new Scanner(System.in);
		n=sc.nextInt();
		Person[] p = new Person[n+1];
		for(int i=0;i<n;i++) {
			int a = sc.nextInt(),b=sc.nextInt();
			p[i]= new Person(a, b);

		}
		for(int i=0;i<n;i++) {
			int k=1;
			for(int j=0;j<n;j++) {
				if(p[i].wei<p[j].wei&&p[i].hei<p[j].hei) k++;
			}
			System.out.print(k+" ");
		}
	}
}
