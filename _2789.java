import java.util.*;
public class _2789 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		LinkedList<Character> list = new LinkedList<>();
		for(int i=0;i<s.length();i++) list.add(s.charAt(i));
		
		for(int i=0;i<s.length();i++) {
			char tmp = list.pollFirst();
			if(tmp=='C'||tmp==65||tmp=='M'||
					tmp=='B'||tmp=='R'||tmp=='I'||
					tmp=='D'||tmp=='G'||tmp=='E') continue;
			else list.add(tmp);
		}
		for(char a : list) System.out.print(a);
	}
}
