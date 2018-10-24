import java.util.*;
public class _10825 {
	static class Student implements Comparable<Student>{
		String name;
		int kor,eng,math;
		Student(String s,int k,int e,int m){
			this.name=s;this.kor=k;this.eng=e;this.math=m;
		}
		@Override
		public int compareTo(Student o) {
			if(this.kor==o.kor) {
				if(this.eng==o.eng) {
					if(o.math==this.math) {
						return this.name.compareTo(o.name);
					}
					return o.math-this.math;
				}
				else {
					return this.eng-o.eng;
				}
			}
			return o.kor-this.kor;
		}
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n =sc.nextInt();
		Student ar[]  = new Student[n];
		for(int i=0;i<n;i++) {
			String s=sc.next();
			int a= sc.nextInt(),b=sc.nextInt(),c=sc.nextInt();
			ar[i]= new Student(s, a, b, c);
		}
		Arrays.sort(ar);
		for(Student s : ar)System.out.println(s.name);
	}

}
