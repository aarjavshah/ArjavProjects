package teST1;

public class M1 {
	public static void main(String [] args){
		int x=0;
		int y=0;
		for(int z=0;z<5;z++){
			if((++x>2)||(++y>2)){
				x++;
			}
		}
		System.out.println(x+" "+y);
}
	
}
class sex{
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