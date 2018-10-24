import java.util.*;
public class _9933 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Hashtable<String, String> ht = new Hashtable<>();
		LinkedList<String> li = new  LinkedList<>();
		for(int i=0;i<n;i++) {
			String tmp = sc.next();
			li.add(tmp);
			ht.put(tmp, tmp);
		}
		for(String t : li) {
			int size = t.length();
			char[] arr = new char[size];
			arr=t.toCharArray();
			for(int i=0;i<size/2;i++) {
				char tmp = arr[i];
				arr[i]=arr[size-1-i];
				arr[size-i-1] =tmp;
			}
			String k = new String(arr);
			if(ht.containsKey(k)) {
				System.out.println(k.length()+" "+k.charAt(k.length()/2));
				return;
			}
		}
	}
}
