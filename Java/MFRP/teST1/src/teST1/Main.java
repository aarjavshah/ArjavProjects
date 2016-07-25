package teST1;
import java.lang.Object;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*String a="newspaper";
		a=a.substring(5, 7);
		char b=a.charAt(1);
		a=a+b;
		System.out.println(a);*/
		//int x= Integer.parseInt("123$");
			String x="abcd";
		x.replace('a', 'd');
			x.replace('b', 'c');
			System.out.println(x);
	
	}
		
}
	class sex1{
		public void start(){
		long [] a1={3,4,5};
		long [] a2=fix(a1);
		System.out.println(a1[0]+a1[1]+a1[2]+" ");
		System.out.println(a2[0]+a2[1]+a2[2]+" ");
		}
		
		public long[] fix(long []a3) {
			a3[1]=7;
			return a3;
		}
		
	}
