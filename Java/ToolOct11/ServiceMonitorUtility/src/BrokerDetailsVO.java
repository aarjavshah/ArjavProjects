

public class BrokerDetailsVO {
	
	private String brokerName;
	private String alias;
	
	private String queueManagerName;
	private String host;
	private int port;
	
	public BrokerDetailsVO(){
		
	}
	public BrokerDetailsVO(String brokerName, String alias,
			String queueManagerName, String host, int port) {
		super();
		this.brokerName = brokerName;
		this.alias = alias;
		this.queueManagerName = queueManagerName;
		this.host = host;
		this.port = port;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getBrokerName() {
		return brokerName;
	}
	public void setBrokerName(String brokerName) {
		this.brokerName = brokerName;
	}
	public String getQueueManagerName() {
		return queueManagerName;
	}
	public void setQueueManagerName(String queueManagerName) {
		this.queueManagerName = queueManagerName;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
	
}
