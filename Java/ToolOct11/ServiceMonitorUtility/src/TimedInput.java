import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Timer;
import java.util.TimerTask;


public class TimedInput {

	private static String str = "";

	static TimerTask task = new TimerTask(){
		public void run(){
			if( str.equals("") ){
				RetBlank(str);
			}
		}
		public String RetBlank(String ret){
			return ret;
		}
	};

	public static String getInput() throws Exception{
		Timer timer = new Timer();
		timer.schedule( task, 10*1000 );
		BufferedReader in = new BufferedReader(
				new InputStreamReader( System.in ) );
		str = in.readLine();

		timer.cancel();
		return str ; 
	}
}