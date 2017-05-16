import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;


public class GenerateBatch {
	public static void createBat(String jars){
		String bat = jars+"/Utility.sc";
		File file = new File(bat);
		StringBuffer sb = new StringBuffer();
		sb.append("java -jar Utility.jar parameter\r\nread -n1 -r -p \"Press any key to continue...\" key");
		try {
			FileUtils.writeStringToFile(file, sb.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
