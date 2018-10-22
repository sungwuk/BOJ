import java.util.*;
public class _2908 {
	public static void main(String[] args) {
		LinkedList<Character> list1 =new LinkedList<>();
		LinkedList<Character> list2 =new LinkedList<>();
		Scanner sc =new Scanner(System.in);
		int a = sc.nextInt(),b=sc.nextInt();
		String s=String.valueOf(a);
		String t = String.valueOf(b);
		int ssize = s.length(),tsize=t.length();
		for(int i=s.length()-1;i>=0;i--) list1.add(s.charAt(i));
		for(int i=t.length()-1;i>=0;i--) list2.add(t.charAt(i));
		s="";t="";
		for(int i=0;i<ssize;i++) s=s.concat(String.valueOf(list1.poll()));
		for(int i=0;i<tsize;i++) t=t.concat(String.valueOf(list2.poll()));
		a=Integer.parseInt(s);b=Integer.parseInt(t);
		System.out.println(a>b?a:b );
	}

}
