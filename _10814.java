import java.util.*;
public class _10814 {
	static class People implements Comparable<People>{
		int age,num;
		String name;
		People(int n,String s,int num){
			this.age=n;this.name=s;this.num=num;
		}
		@Override
		public int compareTo(People o) {
			if(this.age==o.age) {
				return this.num-o.num;
			}
			else {
				return this.age-o.age;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc=  new Scanner(System.in);
		int n = sc.nextInt();
		People ar[] = new People[n];
		for(int i=0;i<n;i++) {
			int a = sc.nextInt();
			String s = sc.next();
			ar[i] = new People(a, s,i);
		}
		Arrays.sort(ar);
		for(People p : ar) System.out.println(p.age+" "+p.name);
	}

}
