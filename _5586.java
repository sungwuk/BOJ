import java.util.*;
public class _5586 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		String s = sc.next();
		Hashtable<String, Integer> ht = new Hashtable<>();
		for(int i=0;i<s.length()-2;i++) {
			String tmp = s.substring(i, i+3);
			if(ht.containsKey(tmp)) {
				ht.put(tmp, ht.get(tmp)+1); 
			}
			else ht.put(tmp, 1);
		}
		System.out.println(ht.get("JOI")==null? 0: ht.get("JOI"));
		System.out.println(ht.get("IOI")==null? 0: ht.get("IOI"));
	}

}
