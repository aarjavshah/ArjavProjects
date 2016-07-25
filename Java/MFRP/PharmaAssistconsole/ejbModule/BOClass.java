import java.sql.DriverManager;

/**
* BO Class to retrieve the data from bean and set data to bean
* 
**/ 
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
		public void RetrieveDetails(Bean out){
			System.out.println("===============================================");
			System.out.format("|  %-20s|  %-20s|\n","BATCHCODE",out.getBatchcode());
			System.out.format("|  %-20s|  %-20s|\n","MEDICINECODE",out.getMedicinecode());
			System.out.format("|  %-20s|  %-20s|\n","WEIGHT",out.getWeight());
			System.out.format("|  %-20s|  %-20s|\n","PRICE",out.getPrice());
			System.out.format("|  %-20s|  %-20s|\n","MEDICINE TYPE CODE",String.valueOf(out.getMedicinetype()));
			System.out.format("|  %-20s|  %-20s|\n","REFREGERATION",out.getRefregeration());
			System.out.println("===============================================");
		}

	}




