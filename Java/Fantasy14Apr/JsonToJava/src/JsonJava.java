import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonJava {
	
	private static String path = "D:\\SampleData.txt";
	
	private static String queueManager;
	private static String hostname;
	private static String queue;
	private static int port;
	private static String channel;
	
	public void readConstants(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter queue manager:"); queueManager = sc.nextLine();
		System.out.println("Enter host:");hostname = sc.nextLine();
		System.out.println("Enter queue:"); queue = sc.nextLine();
		System.out.println("Enter port:");port = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter channel:");channel = sc.nextLine();
		
		
	}
	
	public void readFile(QMConnectionParmsVO parmsVO, File fin) throws IOException, JSONException, InterruptedException {
		FileInputStream fis = new FileInputStream(fin);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		String line = null;
		while ((line = br.readLine()) != null) {
			JSONObject object = new JSONObject(line);
			Date d = new Date(System.currentTimeMillis());
			SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyhhmmssSSS");
			String newFormat = sdf.format(d);
			//System.out.println(object.put("TIME", newFormat));
			object.put("TIME", newFormat);
			JSONObject object2 = new JSONObject();
			object2.put("Record", object);
			System.out.println(object2.toString());
			//PutMessage.PutMessageToQueue(parmsVO, object2.toString());
			Thread.sleep(5000);
		}
		br.close();
	}
	
	public static void main(String[] args) throws IOException, JSONException, InterruptedException{
		
		JsonJava jsonJava = new JsonJava();
		//jsonJava.readConstants();
		QMConnectionParmsVO parmsVO = new QMConnectionParmsVO(hostname, port, channel, queueManager, queue);
		jsonJava.readFile(parmsVO,new File(path));
		
	}
		
}
