
import java.sql.DriverManager;

	
	public class BOClass {

		public Bean addDetails(String batchcode,String medicinecode,int weight,int price,char medicinetype,String refregeration)
		{
			Bean x=new Bean();
			//boolean 
			x.setBatchcode(batchcode);
			x.setMedicinecode(medicinecode);
			x.setMedicinetype(medicinetype);
			x.setPrice(price);
			x.setRefregeration(refregeration);
			x.setWeight(weight);
			return x;
		}
		

	}




