import java.util.*;
public class _2966 {
	static    String dap ;
	static int test_a(char[] a) {
		int corr=0;
		int j=0;
		for(int i=0;i<dap.length();i++) {
			j=i%3;

			if(a[j]==dap.charAt(i)) corr++; 
		}
		return corr;
	}
	static int test_b(char[] a) {
		int corr=0;
		int j=0;
		for(int i=0;i<dap.length();i++) {
			j=i%4;
			if(a[j]==dap.charAt(i)) corr++; 
		}
		return corr;
	}
	static int test_g(char[] a) {
		int corr=0;
		int j=0;
		for(int i=0;i<dap.length();i++) {
			j=i%6;
			if(a[j]==dap.charAt(i)) corr++; 
		}
		return corr;
	}
	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt(); dap =sc.next();
		char[] adrian = {'A','B','C'};
		char[] bruno =  {'B','A','B','C'};
		char[] goran = {'C','C','A','A','B','B'};
		int adri = test_a(adrian);
		int bru = test_b(bruno);
		int gor = test_g(goran);
		int max = adri>bru ?(adri>gor? adri: gor):(bru>gor? bru:gor);
		LinkedList<Integer>list = new LinkedList<>();
		LinkedList<String>li = new LinkedList<>();
		list.add(adri);list.add(bru);list.add(gor);
		li.add("Adrian");li.add("Bruno");li.add("Goran");
		if(max!=0) {
			System.out.println(max);
			for(int i=0;i<list.size();i++) {
				if(list.get(i)==max) System.out.println(li.get(i));
			}
		}       
	}
}