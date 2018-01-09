import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import oracle.jdbc.pool.OracleDataSource;


public class DBHandler 
{
	public Food[] getRestrouantDetailByCitynamAndArea(String strCity,String strArea)
	{
		Food f[]=new Food[10];
		//image,deliverdesc, desc,name
		//select * from food where city='Panipat' and AREA='Ansal';
		Connection con=getDBConWithOracle();
		try {
			PreparedStatement stmt=con.prepareStatement("select * from food where city=? and AREA=?");
			stmt.setString(1, strCity);
			stmt.setString(2, strArea);
			ResultSet rset=stmt.executeQuery();
			int i=1;
			while(rset.next())
			{
				String strSno,strRestourant,strImgnm,strRestDesc;
				strSno=rset.getString("sno");
				strRestourant=rset.getString("restaurants");
				strImgnm=rset.getString("imgname");
				strRestDesc=rset.getString("restdesc");
				f[i]=new Food(strSno, strCity, strArea, strRestourant, strImgnm, strRestDesc);
				i++;
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}
	
	public String[] getItemsDetailByrestname(String strRestaurantSelected)
	{		Priceitem p[] = null;
	    String img[]=new String[16];
	    String p1[]=new String[9];

	Connection con=getDBConWithOracle();
	try {
		PreparedStatement stmt=con.prepareStatement("select * from fooditem f,pricee p where f.foodno =p.pno and RESTAURNET=?");
		stmt.setString(1, strRestaurantSelected);
		
		ResultSet rset=stmt.executeQuery();
		
		int i=0;
		if(rset.next())
		{
			String pop1,pop2,sn1,sn2,d1,d2,sw1,sw2,pop1price,
			pop2price,snack1proce,snack2price,drink1price,drink2price,sweet1price,sweet2price
			;
			System.out.println(i+" i ");
			pop1=rset.getString("popular1");
			img[i++]=pop1;
			pop2=rset.getString("popular2");
			img[i++]=pop2;
			sn1=rset.getString("snack1");
			img[i++]=sn1;
			sn2=rset.getString("snack2");
			img[i++]=sn2;
			d1=rset.getString("drink1");
			img[i++]=d1;
			d2=rset.getString("drink2");
			img[i++]=d2;
			sw1=rset.getString("sweet1");
			img[i++]=sw1;
			sw2=rset.getString("sweet2");
			img[i++]=sw2;
			pop1price=rset.getString("p1price");
			img[i++]=pop1price;
			pop2price=rset.getString("p2price");
			img[i++]=pop2price;
			snack1proce=rset.getString("s1proce");
			img[i++]=snack1proce;
			snack2price=rset.getString("s2price");
			img[i++]=snack2price;
			drink1price=rset.getString("d1price");
			img[i++]=drink1price;
			drink2price=rset.getString("d2price");
			img[i++]=drink2price;
			sweet1price=rset.getString("sw1price");
			img[i++]=sweet1price;	
			sweet2price=rset.getString("sw2price");
			img[i++]=sweet2price;
			
			System.out.println(pop1+" "+pop2+" "+sn1+" "+sn2+" "+d1+" "+d2+" "+sw1+" "+sw2+" "+pop1price+" "+pop2price
			+" "+snack1proce+" "+snack2price+" "+drink1price+" "+drink2price+" "+sweet1price+" "+sweet2price+" "+pop1price);
			

			//p[i]=new Priceitem(pop1,pop2,sn1,sn2,d1,d2,sw1,sw2,pop1price,
				//	pop2price,snack1proce,snack2price,drink1price,drink2price,sweet1price,sweet2price);
			i++;
		
		}
		System.out.println("Price is"+p1[3]);
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return img;

	}
	
	public String[] getItemnmaesbyrestname(String strRestaurantSelected) {
		
	    String nm[]=new String[16];
	    System.out.println(strRestaurantSelected+"  selected rest");
	Connection con=getDBConWithOracle();
	try {
		PreparedStatement stmt=con.prepareStatement("select * from foodname fi,fooditems f where f.fno=fi.kno and restaurant =? ");
		stmt.setString(1, strRestaurantSelected);
		
		ResultSet rset=stmt.executeQuery();
		
		int i=0;
		if(rset.next())
		{
			String p1name,p2name,sn1name,sn2name,d1name,d2name,sw1name,sw2name;
			
			p1name=rset.getString("P1NAME");
			nm[i++]=p1name;
			p2name=rset.getString("P2NAME");
			nm[i++]=p2name;
			sn1name=rset.getString("F1NAME");
			nm[i++]=sn1name;
			sn2name=rset.getString("F2NAME");
			nm[i++]=sn2name;
			d1name=rset.getString("D1NAME");
			nm[i++]=d1name;
			d2name=rset.getString("D2NAME");
			nm[i++]=d2name;
			sw1name=rset.getString("SW1NAME");
			nm[i++]=sw1name;
			sw2name=rset.getString("SW2NAME");
			nm[i++]=sw2name;
		
			System.out.println(p1name+" "+p2name);

			i++;
		
		}
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return nm;

	}


	
	public Connection getDBConWithOracle()
	{
		Connection con=null;
		try {
			OracleDataSource ods=new OracleDataSource();
			ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
			con=ods.getConnection("gulshan", "icsd");
			System.out.println("connection establish with database");
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		return con;
	}

	public boolean isvaliduser(String strunm,String strupwd)
    {
    	boolean res=false;
    	Connection con=getDBConWithOracle();
    	try {
    		PreparedStatement stmt=con.prepareStatement("select * from login where unm=? and pwd=?");
    		stmt.setString(1,strunm);
    		stmt.setString(2,strupwd);
    		ResultSet rset=stmt.executeQuery();
    		if(rset.next())
    		{
    			res=true;
    			
    		}
    		else
    		{
    			res=false;
    		}
    		con.close();
    		
    		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
    		
    		
    	
		return res;
    	
    }

	public void Insertintotblfooditem(String strfoodno, String strrestaurnet,
			String strpopular1, String strpopular2, String strsnack1,
			String strsnack2, String strdrink1, String strdrink2,
			String strsweet1, String strsweet2)
	{
		// TODO Auto-generated method stub
		//1- establish the connection with database
		Connection con=getDBConWithOracle();
		//2- specify your objective
		//statement ,,, preparedstatment--
		try {
			PreparedStatement stmt=con.prepareStatement("insert into fooditem values (?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, strfoodno);
			stmt.setString(2, strrestaurnet);
			stmt.setString(3, strpopular1);
			stmt.setString(4, strpopular2);
			stmt.setString(5, strsnack1);
			stmt.setString(6, strsnack2);
			stmt.setString(7, strdrink1);
			stmt.setString(8, strdrink2);
			stmt.setString(9, strsweet1);
			stmt.setString(10, strsweet2);
			
			//3- pass the paramter if any
			//4- execute your query
			stmt.executeUpdate();//i d u
			con.close();
			System.out.println("data inserted");
			//5 close your connection
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public  JTable getfooditemtable() 
	{
		
		JTable JTable1 = null;
		String[] columnNames={"Foodno","Restaurnet","Popular1","Popular2","Snack1","Snack2","Drink1","Drink2","Sweet1","Sweet2"};
		try
		{
			Connection con=getDBConWithOracle();
			PreparedStatement stmt=con.prepareStatement("select * from fooditem");
			
			//Statement stmt=con.createStatement();
			ResultSet rset=stmt.executeQuery();
			
		DefaultTableModel model=new DefaultTableModel(columnNames,0);
		 JTable1=new JTable(model);
		while(rset.next())
		{
			Vector row=new Vector();
			String foodno=rset.getString("foodno");
			String restaurnet=rset.getString("restaurnet");
			String popular1=rset.getString("popular1");
			String popular2=rset.getString("popular2");
			String snack1=rset.getString("snack1");
			String snack2=rset.getString("snack2");
			String drink1=rset.getString("drink1");
			String drink2=rset.getString("drink2");
			String sweet1=rset.getString("sweet1");
			String sweet2=rset.getString("sweet2");
//			System.out.println(foodno+restaurnet+popular1+popular2+"Output");
			
		row.add(foodno);
		row.add(restaurnet);
		row.add(popular1);
		row.add(popular2);
		row.add(snack1);
		row.add(snack2);
		row.add(drink1);
		row.add(drink2);
		row.add(sweet1);
		row.add(sweet2);
		model.addRow(row);
		}

	}
	
	catch(SQLException e)
	{
		e.printStackTrace();
	}
		//System.out.println(JTable1.getSelectedRow()+"Row");
		
		return JTable1;
			
}

	public void deletetablebyfoodno(String strfoodno) {
		{
			//1- establish the connection
			Connection con=getDBConWithOracle();
			//2- specify your objective
			try {
				PreparedStatement stmt=con.prepareStatement("delete from fooditem where foodno=?");
				//3- pass the parametr if any
				stmt.setString(1, strfoodno);
				//4- execute your query
				stmt.executeUpdate();//I D U -- executeUpdate
				//5 close your connectrion
				con.close();
				System.out.println("data delted");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
}
	
	public Vector<String> getAllcityfromTblfood()
    {
    	Vector<String>vctr=new Vector<String>();
    	vctr.add("Select");
    	Connection con=getDBConWithOracle();
    	try {
    		PreparedStatement stmt=con.prepareStatement("select distinct city from food");
    		ResultSet rset=stmt.executeQuery();
    		
    		while(rset.next())
    		{
    			String strcity=rset.getString("city");
    			vctr.add(strcity);
    		}
    		con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
    		
    	return vctr;
    }
    

	public void updatetablefoodno(String strfoodno, String strrestaurent,
			String strpopular1, String strpopular2, String strsnack1,
			String strsnack2, String strdrink1, String strdrink2,
			String strsweet1, String strsweet2) {
		// TODO Auto-generated method stub

		Connection con=getDBConWithOracle();
	try
	{
		PreparedStatement stmt=con.prepareStatement("update fooditem set restaurnet=?,popular1=?,popular2=?,"
				+ "snack1=?,snack2=?,drink1=?,drink2=?,sweet1=?,sweet2=? where foodno=?");
		//3 pass the parameter if any
		stmt.setString(1, strrestaurent);
		stmt.setString(2, strpopular1);
		stmt.setString(3, strpopular2);
		stmt.setString(4, strsnack1);
		stmt.setString(5, strsnack2);
		stmt.setString(6, strdrink1);
		stmt.setString(7, strdrink2);
		stmt.setString(8, strsweet1);
		stmt.setString(9, strsweet2);
		stmt.setString(10, strfoodno);
		//4 execute your query
		stmt.executeUpdate();
		//5- close the connection
		con.close();
		System.out.println("data updated");
	}
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		}


	public String[] getareafromyblfood(String city) {
		// TODO Auto-generated method stub
		String[] stra=new String[5];   	
		Connection con=getDBConWithOracle();
	try
	{
		PreparedStatement stmt=con.prepareStatement("select distinct area from food where city=?");
		//3 pass the parameter if any
		//stmt.setString(1,city);
		stmt.setString(1, city);
		//4 execute your query
		ResultSet rset=stmt.executeQuery();
	
		int i=0;
		while(rset.next())
		{
			stra[i]=rset.getString(1);
		i++;
		}
		//5- close the connection
		con.close();
	}
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(stra.length+"size of ");
	return stra;
	}

	public boolean isvalidperson(String strunm, String strpwd) {
		boolean res=false;
    	Connection con=getDBConWithOracle();
    	try {
    		PreparedStatement stmt=con.prepareStatement("select * from users where unm=? and pwd=?");
    		stmt.setString(1,strunm);
    		stmt.setString(2,strpwd);
    		ResultSet rset=stmt.executeQuery();
    		if(rset.next())
    		{
    			res=true;
    			
    		}
    		else
    		{
    			res=false;
    		}
    		con.close();
    		
    		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
    		
    		
    	
		return res;
    	
	}
	public void isenterperson(String strpi,String strunm, String strpwd) {
		// TODO Auto-generated method stub
	
		{
			Connection con=getDBConWithOracle();
			
			try {
				PreparedStatement stmt=con.prepareStatement("insert into users values (?,?,?)");
				stmt.setString(1, strpi);
				stmt.setString(2, strunm);
				stmt.setString(3, strpwd);
				
				stmt.executeUpdate();//i d u
				con.close();
				System.out.println("data inserted");
				//5 close your connection
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
}
	}

	public int getMAXID(String strcolNm,String strTblNm)
    {
    	int id=0;
    	Connection con=getDBConWithOracle();
    	try{
    		PreparedStatement stmt=con.prepareStatement("select max("+strcolNm+")as id from "+strTblNm);
    		ResultSet rset=stmt.executeQuery();
    		if(rset.next())
    		{
    			id=rset.getInt("id");
    		}
    		else
    		{
    			id=0;
    		}
    		con.close();
    	}
    	catch(Exception e)
    	{
    		
    	}
    	return id;
    }
}