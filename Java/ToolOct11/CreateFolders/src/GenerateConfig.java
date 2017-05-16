import java.io.File;
import java.io.IOException;

import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

import org.apache.commons.io.FileUtils;


public class GenerateConfig {
	public static int CreateXML(ConfigVO config){
		//String path = "C:\\Users\\Public\\ServiceMonitor\\Config\\Config.xml";                      //PATH TO BE DECIDED
		//String pathPrimary = "C:\\Users\\Administrator\\ServiceMonitor\\Config\\Config.xml";		//PATH TO BE DECIDED
		
		String path = config.getRoot()+"/config/mqmonconfig.xml";
		String pathPrimary = "/dnbusr1/mqm/qmmonitor/config/mqmonconfig.xml";                //secure path to be confirmed  
		File file = new File(path);
		File filePrimary = new File(pathPrimary);
		boolean flag=false;
		int ret =0;
		//boolean primPath=false;
		//boolean secPath=false;
		//primPath = filePrimary.canWrite();
		//secPath = file.canWrite();
//		if(!primPath){
//			System.out.println("Warning : Unable to create file \""+pathPrimary+"\"");
//			System.out.println("          Creating file on secondary path (\""+path+"\")");
//		}
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\r\n");
		sb.append("<config>\r\n");
		sb.append("<BrokerDetails>"+config.getBrokerDetails()+"</BrokerDetails>\r\n");
		sb.append("<BrokerStatus>"+config.getBrokerStatus()+"</BrokerStatus>\r\n");
		sb.append("<TempFile>"+config.getTempFile()+"</TempFile>\r\n");
		sb.append("<LogFile>"+config.getLogFile()+"</LogFile>\r\n");
		sb.append("<MsgFlowQIn>DNB.CHANNEL.STATUS.INPUT</MsgFlowQIn>\r\n");
		sb.append("<MsgFlowQOut>DNB.CHANNEL.STATUS.OUTPUT</MsgFlowQOut>\r\n");
		sb.append("<MsgFlowQMIP>158.151.157.129</MsgFlowQMIP>\r\n");
		sb.append("<MsgFlowQMPort>1414</MsgFlowQMPort>\r\n");
		sb.append("<MsgFlowQMName>CL01</MsgFlowQMName>\r\n");
		sb.append("<MsgFlowQMChl>ESB.QMMON.SVRCONN</MsgFlowQMChl>\r\n");
		sb.append("<QMConfigFile>"+config.getQmConfig()+"</QMConfigFile>\r\n");
		sb.append("<UserList>"+config.getUserFile()+"</UserList>\r\n");
		sb.append("<QMConList>"+config.getQmCon()+"</QMConList>\r\n");
		sb.append("<UpdateRequestFile>"+config.getRequestFile()+"</UpdateRequestFile>\r\n");
		sb.append("<WaitTime>"+config.getWaitTime()+"</WaitTime>\r\n");
		sb.append("</config>");
		try {
			FileUtils.writeStringToFile(file, sb.toString());
			flag=true;
			FileUtils.writeStringToFile(filePrimary, sb.toString());
			ret=0;
		} catch (Exception e) {
			if(flag){
				ret = 1;
			}
			else{
				try {
					FileUtils.writeStringToFile(filePrimary, sb.toString());
					ret=2;
				} catch (IOException e1) {
					ret=3;
				}
			}
		}
		return ret;
	}
	
	//Use the function in case of setup on windows platform
	public static String FormatString(String x) {
		String[]a = x.split("\\\\");
		String new1="";
		for(String tmp:a){
			new1=new1.concat(tmp+"\\\\");
		}
		new1=new1.substring(0, new1.length()-2);
		return new1;
	}
}




/*
<?xml version="1.0" encoding="UTF-8" ?> 
<config>
<BrokerDetails>\\\\PC310366\\Users\\Public\\DnBSharing\\DnBTool\\BrokerDetails\\BrokerDetails.xml</BrokerDetails>
<BrokerStatus>\\\\PC310366\\Users\\Public\\DnBSharing\\DnBTool\\BrokerStatus\\BrokerStatusXML.xml</BrokerStatus>
<TempFile>\\\\PC310366\\Users\\Public\\DnBSharing\\DnBTool\\BrokerDetails\\BrokerDetailsTemp.xml</TempFile>
<LogFile>\\\\PC310366\\Users\\Public\\DnBSharing\\DnBTool\\ServiceMonitorLogs\\LogFile.log</LogFile>
<ChInput>DNB.CHANNEL.STATUS.INPUT</ChInput>
<ChOutput>DNB.CHANNEL.STATUS.OUTPUT</ChOutput>
<QMConfigFile>\\\\PC310366\\Users\\Public\\DnBSharing\\DnBTool\\BrokerDetails\\QMConfig.xml</QMConfigFile>
<UserList>\\\\PC310366\\Users\\Public\\DnBSharing\\DnBTool\\BrokerDetails\\Users.xml</UserList>
<QMConList>\\\\PC310366\\Users\\Public\\DnBSharing\\DnBTool\\BrokerDetails\\QMConn.xml</QMConList>
<UpdateRequestFile>\\\\PC310366\\Users\\Public\\DnBSharing\\DnBTool\\ServiceMonitorLogs\\Requests.xml</UpdateRequestFile>
<WaitTime>60</WaitTime>
</config>
*/