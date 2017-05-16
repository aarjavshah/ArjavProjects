import java.io.File;
import java.util.Scanner;


public class CreateFolderStructure {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean rootFolder=false;
		boolean subFolder1=false;
		boolean subFolder2=false;
		boolean subFolder3=false;
		boolean subFolder4=false;
		boolean subFolder5=false;
		boolean subFolder6=false;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the root Path to place the configuration and other files\n(example : /users/usr1/folder)");
		String path = sc.nextLine();
		String rootPath = path+"/qmmon"; 
		File file = new File(rootPath);
		rootFolder = file.mkdirs();
		
		String brokerDetails = rootPath + "/connections";
		file = new File(brokerDetails);
		subFolder1 = file.mkdirs();
		
		String brokerStatus =  rootPath + "/bkrstatus";
		file = new File(brokerStatus);
		subFolder2 = file.mkdirs();
		
		String logs = rootPath + "/logs";
		file = new File(logs);
		subFolder3 = file.mkdirs();
		
		String jars = rootPath + "/jars";
		file = new File(jars);
		subFolder4 = file.mkdirs();
		
		String wars = rootPath + "/wars";
		file = new File(wars);
		subFolder5 = file.mkdirs();
		
		String configDir = rootPath + "/config";
		file = new File(configDir);
		subFolder6 = file.mkdirs();
		
		GenerateBatch.createBat(jars);
		brokerDetails = brokerDetails + "/bkrcon.xml";
		brokerStatus = brokerStatus +"/bkrstatus.xml";
		logs = logs + "/accesslogs.log";
		String temp = rootPath + "/connections/temp.xml";
		String qmConfig = rootPath + "/connections/qmconfig.xml";
		String qmCon = rootPath + "/connections/qmcon.xml";
		String users = rootPath + "/connections/users.xml";
		String requests = rootPath +"/logs/requests.xml";
		int waitTime = 60;
		ConfigVO config = new ConfigVO(rootPath,brokerDetails, brokerStatus,qmConfig, qmCon, temp, logs, users, requests, waitTime);
		CreateXMLs.createXML(config);
		int configck = GenerateConfig.CreateXML(config);
		if(rootFolder && subFolder1 && subFolder2 && subFolder3 && subFolder4 && subFolder5 && subFolder6 && configck==0){
			System.out.println("Folder Setup Generated.\nPlease add the queue-manager(Broker) details in which the messageflow is deployed\nConfig File located at\n\t=> /var/qmmonitor/config\n\t=> "+rootPath+"/config");
		}else if(configck==1 || configck==2){
			System.out.println("Configuration path partially failed.\nBut Application can run perfectly fine!");
		}else if(configck==3){
			System.out.println("Unable to access "+rootPath+"/config or /dnbusr1/mqm/qmmonitor/config\nChange the permissions and try again.");
			File delete = new File(rootPath);
			delete.delete();
		}
		else{
			System.out.println("Error Creating Folder Structure.\nTry using another root path or change the permissions for current path.");
			File delete = new File(rootPath);
			delete.delete();
		}
	}

}
