import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.math.BigInteger;
import java.security.SecureRandom;

import com.ibm.broker.javacompute.MbJavaComputeNode;
import com.ibm.broker.plugin.MbElement;
import com.ibm.broker.plugin.MbException;
import com.ibm.broker.plugin.MbMessage;
import com.ibm.broker.plugin.MbMessageAssembly;
import com.ibm.broker.plugin.MbOutputTerminal;
import com.ibm.broker.plugin.MbUserException;

public class AutoTest_MF_SetRoutingIndicator extends MbJavaComputeNode {

	public void evaluate(MbMessageAssembly inAssembly) throws MbException {
		MbOutputTerminal out = getOutputTerminal("out");
		MbOutputTerminal alt = getOutputTerminal("alternate");

		MbMessage inMessage = inAssembly.getMessage();
		// MbMessage env = inAssembly.getGlobalEnvironment();
		MbMessageAssembly outAssembly = null;
		try {
			// create new message as a copy of the input
			MbMessage outMessage = new MbMessage(inMessage);
			outAssembly = new MbMessageAssembly(inAssembly, outMessage);
			// byte [] inBytes =
			// (byte[])inMessage.getRootElement().getLastChild().getLastChild().getValue();
			// String inputParams = new String(inBytes);
			// String flows[] = inputParams.split("~");
			MbElement env = inAssembly.getGlobalEnvironment().getRootElement();
			MbElement envVar = env.getFirstElementByPath("/Variables");
			SecureRandom random = new SecureRandom();
			
			MbElement uuid = envVar.createElementAsLastChild(MbElement.TYPE_NAME_VALUE,"CorrId",new BigInteger(130,random).toString(32).substring(1, 25));
			MbElement Msgs = envVar.createElementAsLastChild(
					MbElement.TYPE_NAME, "Msgs", null);
			// for(String flow:flows){
			// String params[]=flow.split("\\^");
			// String typeSpecifier = params[0];
			// String entryPoint = params[1];
			// String exitPoint = params[2];
			// String msgLocation = params[3];
			// int waitTime = Integer.parseInt(params[4]);
			String msgFile = (String) getUserDefinedAttribute("FileLocation");
			msgFile = msgFile
					+ "\\"
					+ env.getFirstElementByPath("/Variables/FlowName")
							.getValueAsString() + "\\In";
			File testMessages = new File(msgFile);

			for (File tmp : testMessages.listFiles()) {
				FileInputStream fis = new FileInputStream(tmp);
				byte[] data = new byte[(int) tmp.length()];
				fis.read(data);
				fis.close();
				String str = new String(data, "UTF-8");
				MbElement Msg = Msgs.createElementAsLastChild(
						MbElement.TYPE_NAME, "Msg", null);
				MbElement Content = Msg.createElementAsLastChild(
						MbElement.TYPE_NAME_VALUE, "Text", str);
				MbElement FlowName = Msg.createElementAsLastChild(
						MbElement.TYPE_NAME_VALUE, "FileName", tmp.getName());
				// if(typeSpecifier.equals("Q")){
				// contents.append(entryPoint+"^"+exitPoint);
				// }else if(typeSpecifier.equals("F")){
				// contents.append(entryPoint+"^"+exitPoint);
				// }else if(typeSpecifier.equals("H")){
				// contents.append(entryPoint+"^"+exitPoint);
				// }
				// outMessage.getRootElement().getLastChild().getLastChild().setValue(contents.toString().getBytes());	
			}
			out.propagate(outAssembly);
		} catch (MbException e) {
			// Re-throw to allow Broker handling of MbException
			throw e;
		} catch (RuntimeException e) {
			// Re-throw to allow Broker handling of RuntimeException
			throw e;
		} catch (Exception e) {
			// Consider replacing Exception with type(s) thrown by user code
			// Example handling ensures all exceptions are re-thrown to be
			// handled in the flow
			throw new MbUserException(this, "evaluate()", "", "", e.toString(),
					null);
		}

	}

}
