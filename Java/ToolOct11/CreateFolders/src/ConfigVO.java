
public class ConfigVO {
	String root;
	String brokerDetails;
	String brokerStatus;
	String qmConfig;
	String qmCon;
	String tempFile;
	String logFile;
	String userFile;
	String requestFile;
	int waitTime;
	
	public ConfigVO(){
		
	}

	

	public ConfigVO(String root, String brokerDetails, String brokerStatus,
			String qmConfig, String qmCon, String tempFile, String logFile,
			String userFile, String requestFile, int waitTime) {
		super();
		this.root = root;
		this.brokerDetails = brokerDetails;
		this.brokerStatus = brokerStatus;
		this.qmConfig = qmConfig;
		this.qmCon = qmCon;
		this.tempFile = tempFile;
		this.logFile = logFile;
		this.userFile = userFile;
		this.requestFile = requestFile;
		this.waitTime = waitTime;
	}



	public String getRoot() {
		return root;
	}
	public void setRoot(String root) {
		this.root = root;
	}
	public String getBrokerDetails() {
		return brokerDetails;
	}
	public void setBrokerDetails(String brokerDetails) {
		this.brokerDetails = brokerDetails;
	}
	public String getBrokerStatus() {
		return brokerStatus;
	}
	public void setBrokerStatus(String brokerStatus) {
		this.brokerStatus = brokerStatus;
	}	
	public String getQmConfig() {
		return qmConfig;
	}
	public void setQmConfig(String qmConfig) {
		this.qmConfig = qmConfig;
	}
	public String getQmCon() {
		return qmCon;
	}
	public void setQmCon(String qmCon) {
		this.qmCon = qmCon;
	}
	public String getTempFile() {
		return tempFile;
	}
	public void setTempFile(String tempFile) {
		this.tempFile = tempFile;
	}
	public String getLogFile() {
		return logFile;
	}
	public void setLogFile(String logFile) {
		this.logFile = logFile;
	}
	public int getWaitTime() {
		return waitTime;
	}
	public void setWaitTime(int waitTime) {
		this.waitTime = waitTime;
	}
	public String getUserFile() {
		return userFile;
	}

	public void setUserFile(String userFile) {
		this.userFile = userFile;
	}

	public String getRequestFile() {
		return requestFile;
	}

	public void setRequestFile(String requestFile) {
		this.requestFile = requestFile;
	}
	
}
