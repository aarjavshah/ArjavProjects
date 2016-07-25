import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Arrays;


public class BatchDAO implements IBatchDAO{
	
	
	/**
	 *Add 
	 *Batch
	 *Business 
	 *Logic
	 *function
	 **/
	
	
	public boolean addDetails(Bean temp){
		int x=0;
		String wrange=null;
		int shipping_charge=0;
		boolean exit=true;
		Connection dbconnect=null;
		ResultSet res=null;
		java.sql.PreparedStatement stm=null;
		while(exit)
		{
		try{
		Class.forName("com.mysql.jdbc.Driver");
	    dbconnect=DriverManager.getConnection("jdbc:mysql://localhost/pharma","root","root");
		
		shipping_charge=getShippingCharges(temp.getWeight(), Character.toString(temp.getMedicinetype()));
		
		stm=dbconnect.prepareStatement("insert into batch_info values(?,?,?,?,?,?,?)");
		
		stm.setString(1, temp.getBatchcode());
		stm.setString(2, temp.getMedicinecode());
		stm.setInt(3, temp.getWeight());
		stm.setInt(4, temp.getPrice());
		stm.setString(5, Character.toString(temp.getMedicinetype()));
				
		if(temp.getRefregeration().equalsIgnoreCase("yes"))
			stm.setInt(6, (int) (shipping_charge*1.05));
		else if(temp.getRefregeration().equalsIgnoreCase("no"))
			stm.setInt(6, (int) (shipping_charge));
		
		if(temp.getMedicinetype()=='T' || temp.getMedicinetype()=='t')
			stm.setString(7, "High");
		else if(temp.getMedicinetype()=='C' || temp.getMedicinetype()=='c')
			stm.setString(7, "Normal");
		else if(temp.getMedicinetype()=='S' || temp.getMedicinetype()=='s')
			stm.setString(7, "Extr High");
	
		x=stm.executeUpdate();
		stm.close();
		dbconnect.close();
		exit=false;
		}
		
		catch(Exception e){
		//System.out.println(e.getMessage());
		exit=false;
		x=0;
		continue;
		}
		
		finally{
			try
			{
				res.close();
				stm.close();
				dbconnect.close();
			}
			catch(Exception e)
			{
				
			}
		}
		}
		if(x!=0){
			return true;
		}
		else{
			return false;
		}
		
	}
	
	
	/**
	 *Delete 
	 *Batch
	 *Business 
	 *Logic
	 *function
	 **/
	
	
	
	
	public boolean deleteDetails(String deletebatchcode)
	{
		int i=0;
		Connection dbconnect=null;
		ResultSet res=null;
		java.sql.PreparedStatement stm=null;
		 if(checkBatchCode(deletebatchcode)){ 
		try {
        	Class.forName("com.mysql.jdbc.Driver");
		   dbconnect=DriverManager.getConnection("jdbc:mysql://localhost/pharma","root","root");
		    stm=dbconnect.prepareStatement("delete from batch_info where batchcode=?");
			stm.setString(1, deletebatchcode);
			i=stm.executeUpdate();
			}
        catch (Exception e) {   
  			//e.printStackTrace();
        	i=0;
  			}
		finally{
			try
			{
				res.close();
				stm.close();
				dbconnect.close();
			}
			catch(Exception e)
			{
				
			}
		}
          }
          
        if(i!=0)
  			return true;
  		else
  			return false;
		
}
	
	
	/**
	 * Search
	 * Batch
	 * Business
	 * Logic
	 * function
	 **/
	
	
	public Bean searchDetails(String batchcode)
	{
		int i=0;
		String medicincecode="",Refregeration="",level="";
		int weight=0,price=0,shipping_charge=0;
		char medicinetypecode='\0';
		Bean ret_bean=null;
		Connection dbconnect=null;
		ResultSet res=null;
		java.sql.PreparedStatement stm=null;
		try {
      	 
			Class.forName("com.mysql.jdbc.Driver");
		    dbconnect=DriverManager.getConnection("jdbc:mysql://localhost/pharma","root","root");
			stm=dbconnect.prepareStatement("select * from batch_info where batchcode=?");
			stm.setString(1,batchcode);
			ResultSet re=stm.executeQuery();
			if(re.next())
			{
				i=1;
				medicincecode=re.getString(2);
				weight=re.getInt(3);
				price=re.getInt(4);
				medicinetypecode=re.getString(5).charAt(0);
				shipping_charge=re.getInt(6);
			/*
				System.out.println("");
				System.out.format("%-20s%-20s\n","BATCHCODE",batchcode);
				System.out.format("%-20s%-20s\n","MEDICINECODE",medicincecode);
				System.out.format("%-20s%-20s\n","WEIGHT",weight);
				System.out.format("%-20s%-20s\n","PRICE",price);
				System.out.format("%-20s%-20s\n","MEDICINE TYPE CODE",String.valueOf(medicinetypecode));
*/
				stm=dbconnect.prepareStatement("select shipping_charge from shipping_master where shipping_charge=?");
				stm.setInt(1, shipping_charge);
				re=stm.executeQuery();
				if(re.next()){
					//System.out.format("%-20s%-20s\n","REFREGERATION","NO");
					Refregeration="No";
					}
				else{
					//System.out.format("%-20s%-20s\n","REFREGERATION","YES");
					Refregeration="Yes";
					}
				//System.out.println("");
				ret_bean=new BOClass().addDetails(batchcode,medicincecode,weight,price,medicinetypecode,Refregeration);
				}
			} 
        catch (Exception e) {
        	i=0;	
        	}
		
		finally{
			try
			{
				res.close();
				stm.close();
				dbconnect.close();
			}
			catch(Exception e)
			{
				
			}
		}
		return ret_bean;
	}
	
	
	/**
	 * Update
	 * Batch
	 * Business
	 * Logic
	 * function
	 **/
	
	
	public boolean updateDetails(Bean temp){
		int x=0;
		int shipping_charge=0;
		boolean exit=true;
		Connection dbconnect=null;
		ResultSet res=null;
		java.sql.PreparedStatement stm=null;
		while(exit)
		{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			 dbconnect=DriverManager.getConnection("jdbc:mysql://localhost/pharma","root","root");
			

			shipping_charge=getShippingCharges(temp.getWeight(), Character.toString(temp.getMedicinetype()));
			
			
			stm=dbconnect.prepareStatement("update batch_info set medicinecode=?,weight=?,price=?,medicinetypecode=?,shipping_charge=?,level=? where batchcode=?");
			
			
			stm.setString(1, temp.getMedicinecode());
			stm.setInt(2, temp.getWeight());
			stm.setInt(3, temp.getPrice());
			stm.setString(4, Character.toString(temp.getMedicinetype()));
			
			if(temp.getRefregeration().equalsIgnoreCase("yes"))
				stm.setInt(5, (int) (shipping_charge*1.05));
			else if(temp.getRefregeration().equalsIgnoreCase("no"))
				stm.setInt(5, (int) (shipping_charge));
			
			if(temp.getMedicinetype()=='T' || temp.getMedicinetype()=='t')
				stm.setString(6, "High");
			else if(temp.getMedicinetype()=='C' || temp.getMedicinetype()=='c')
				stm.setString(6, "Normal");
			else if(temp.getMedicinetype()=='S' || temp.getMedicinetype()=='s')
				stm.setString(6, "Extr High");
		
			stm.setString(7, temp.getBatchcode());
		
			x=stm.executeUpdate();
			stm.close();
			dbconnect.close();
			exit=false;
		}
		
		
		catch(Exception e){
			//System.out.println(e.getMessage());
			exit=false;
			x=0;
			continue;
			}

		
		finally{
			try
			{
				res.close();
				stm.close();
				dbconnect.close();
			}
			catch(Exception e)
			{
				
			}
		}
	}
		if(x!=0){
			return true;
		}
		else{
			return false;
		}
	}
	
	
	/**
	 * Retrieve
	 * Shipping
	 * Charge
	 * from
	 * database
	 * */
	
	
	public int getShippingCharges(int weight,String medicineType){
		int shipping_charge=0;
		Connection dbconnect=null;
		ResultSet res=null;
		java.sql.PreparedStatement stm=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			dbconnect=DriverManager.getConnection("jdbc:mysql://localhost/pharma","root","root");
			stm=dbconnect.prepareStatement("select shipping_charge from shipping_master a,shipping_weight_master b where a.weight_range=b.weight_range and b.weight_range =(select weight_range from shipping_weight_master where min_weight<=? and max_weight>=?) and a.medicinetypecode=?") ;
			stm.setInt(1, weight);
			stm.setInt(2, weight);
			stm.setString(3, medicineType);
			ResultSet re=stm.executeQuery();
			if(re.next()){
				shipping_charge=re.getInt(1);
				}
		}
		catch(Exception e){
			
		}
		
		finally{
			try
			{
				res.close();
				stm.close();
				dbconnect.close();
			}
			catch(Exception e)
			{
				
			}
		}
		return shipping_charge;
	}
	
	
	/**
	 * Check
	 * if
	 * the
	 * batch
	 * exist
	 * in
	 * database
	 * or
	 * not
	 **/
	
	
	
	public boolean checkBatchCode(String batchcode){
		ResultSet re=null;
		boolean ret=false;
		Connection dbconnect=null;
		ResultSet res=null;
		java.sql.PreparedStatement stm=null;
		try{
		Class.forName("com.mysql.jdbc.Driver");
		dbconnect=DriverManager.getConnection("jdbc:mysql://localhost/pharma","root","root");
		stm=dbconnect.prepareStatement("select * from batch_info where batchcode=?");
		stm.setString(1, batchcode);
		re=stm.executeQuery();
		if(re.next()){
			ret=true;
		}
		else{
			ret=false;
		}}
		catch(Exception e){
			
		}
		
		finally{
			try
			{
				res.close();
				stm.close();
				dbconnect.close();
			}
			catch(Exception e)
			{
				
			}
		}
		return ret;
	}
	
	
	/**
	 *get 
	 *the 
	 *list
	 *of
	 *valid
	 *medicine
	 *codes
	 **/
	
	public String[] getMedicineCodes(){
		int size=0;
		Connection dbconnect=null;
		ResultSet res=null;
		java.sql.PreparedStatement stm=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			dbconnect=DriverManager.getConnection("jdbc:mysql://localhost/pharma","root","root");
			 stm=dbconnect.prepareStatement("select count(*) from medicine_master");
		    res=stm.executeQuery();
			if(res.next()){
			size=res.getInt(1);
			//System.out.println(size);
			}
			else{
				
			}
		}
		catch(Exception e){
			}
		
		String medicinecode[]=new String[size];
		
		try{
			int i=0;
			Class.forName("com.mysql.jdbc.Driver");
			dbconnect=DriverManager.getConnection("jdbc:mysql://localhost/pharma","root","root");
			stm=dbconnect.prepareStatement("select * from medicine_master");
			 res=stm.executeQuery();
			while(res.next()){
			medicinecode[i++]=res.getString("MEDICINECODE");
			//System.out.println(medicinecode[i++]);
			}
		}
		catch(Exception e){
			
		}
		
		finally{
			try
			{
				res.close();
				stm.close();
				dbconnect.close();
			}
			catch(Exception e)
			{
				
			}
		}
		Arrays.sort(medicinecode);
		return medicinecode;
	}
	
	
	/**
	 * Check
	 * if
	 * the
	 * medicine
	 * code
	 * is
	 * valid
	 * or 
	 * not 
	 **/
	
	
	public boolean checkMedicineCodes(String medicineCode){
		ResultSet re=null;
		boolean ret=false;
		Connection dbconnect=null;
		ResultSet res=null;
		java.sql.PreparedStatement stm=null;
		try{
		Class.forName("com.mysql.jdbc.Driver");
		dbconnect=DriverManager.getConnection("jdbc:mysql://localhost/pharma","root","root");
		stm=dbconnect.prepareStatement("select * from medicine_master where medicinecode=?");
		stm.setString(1, medicineCode);
		re=stm.executeQuery();
		if(re.next()){
			ret=true;
		}
		else{
			ret=false;
		}}
		catch(Exception e){
			
		}
		finally{
			try
			{
				res.close();
				stm.close();
				dbconnect.close();
			}
			catch(Exception e)
			{
				
			}
		}
		return ret;
	}
}
