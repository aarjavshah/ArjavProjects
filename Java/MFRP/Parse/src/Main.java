import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inputXML=sc.nextLine();
		String regexStart="<(\"[^\"]*\"|'[^']*'|[^'\">])*>";
		String regexEnd="</(\"[^\"]*\"|'[^']*'|[^'\">])*>";
		String fullReg="<(\"[^\"]*\"|'[^']*'|[^'\">])*>[^\'\"]*</(\"[^\"]*\"|'[^']*'|[^'\">])*>";
		if(inputXML.matches(fullReg)){
			inputXML = inputXML.substring(1);
			
			String x[]=inputXML.split(">", 2);
			inputXML = x[1];
			if(inputXML.contains("<"+x[0]+">")==true){
				String array[]=inputXML.split("<"+x[0]+">");
				System.out.println(array[0]+" "+array[1]);	
			}
			inputXML = inputXML.replace(inputXML.substring(inputXML.length()-3-x[0].length()),"");
			System.out.println(x[0]+" "+inputXML);
			
		}

	}

}