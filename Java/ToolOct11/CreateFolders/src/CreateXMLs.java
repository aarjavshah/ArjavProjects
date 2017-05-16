import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;


public class CreateXMLs {
	
	public static void createXML(ConfigVO conf){
		String brokerxmlFile = conf.getBrokerDetails();
		File file = new File(brokerxmlFile);
		StringBuffer contents = new StringBuffer();
		contents.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\r\n");
		contents.append("<broker-details>\r\n</broker-details>");
		try {
			FileUtils.writeStringToFile(file, contents.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String qmcon = conf.getQmCon();
		file = new File(qmcon);
		contents = new StringBuffer();
		contents.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\r\n");
		contents.append("<QMS>\r\n</QMS>");
		try{
			FileUtils.writeStringToFile(file, contents.toString());
		}catch(IOException e){
			e.printStackTrace();
		}
		
		String users = conf.getUserFile();
		file = new File(users);
		contents = new StringBuffer();
		contents.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\r\n");
		contents.append("<Users xmlns=\"http://www.example.org/Users\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.example.org/Users Users.xsd \">\r\n<User>\r\n<UserName>admin</UserName>\r\n<UserType>admin</UserType>\r\n<Password>start123</Password>\r\n</User>\r\n</Users>");
		try {
			FileUtils.writeStringToFile(file, contents.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String requests = conf.getRequestFile();
		file = new File(requests);
		contents = new StringBuffer();
		contents.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\r\n");
		contents.append("<Requests xmlns=\"http://www.example.org/Requests\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.example.org/Requests Requests.xsd \">\r\n</Requests>");
		try {
			FileUtils.writeStringToFile(file, contents.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
