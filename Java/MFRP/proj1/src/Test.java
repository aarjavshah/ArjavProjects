import org.example.brokers.ApplicationTYP;
import org.example.brokers.BrokerTYP;
import org.example.brokers.BrokersTYP;
import org.example.brokers.ExecutionGroupTYP;
import org.example.brokers.MessageFlowTYP;



public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BrokersTYP brokers = jaxB.getjaxbObject();
		int i=0;
		for(BrokerTYP broker:brokers.getBroker()){
			System.out.println("Broker ::"+(++i)+" "+broker.getBrokerName()+" "+broker.isIsBrokerRunning());
			int j=0;
			for(ExecutionGroupTYP eg : broker.getExecutionGroups().getExecutionGroup()){
				System.out.println("\tEg::"+(++j)+" "+eg.getExecutionGroupName()+" "+eg.isIsExecutionGroupRunning());
				int k=0;
				for(ApplicationTYP app : eg.getApplications().getApplication()){
					System.out.println("\t\tApplication::"+(++k)+" "+app.getApplicationName()+" "+app.getApplicationDeployedOn()+" "+app.isIsApplicationRunning());
					int l=0;
					for(MessageFlowTYP msgFlow:app.getMessageFlows().getMessageFlow()){
						System.out.println("\t\t\tMessageFlow::"+(++l)+" "+msgFlow.getMessageFlowName()+" "+msgFlow.getMessageFlowVersion());
					}
				}
			}
		}
	}

}
