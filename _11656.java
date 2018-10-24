import java.util.*;
public class _11656 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		String s = sc.next();
		LinkedList<String> list = new LinkedList<>();
		while(s.length()!=0) {
			list.add(s);
			s= s.substring(1, s.length());
		}
		Collections.sort(list);
		for(String a : list)System.out.println(a);
	}

}
