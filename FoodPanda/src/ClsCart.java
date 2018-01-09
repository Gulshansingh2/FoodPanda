
public class ClsCart
{
	
	String strnm;
	String strprice;
	
	int Sno;
	public int getSno() {
		return Sno;
	}

	public void setSno(int sno) {
		Sno = sno;
	}
	
	public String getStrnm() {
		return strnm;
	}

	public void setStrnm(String strnm) {
		this.strnm = strnm;
	}

	public String getStrprice() {
		return strprice;
	}

	public void setStrprice(String strprice) {
		this.strprice = strprice;
	}

	public ClsCart()
	{
	}
	
public ClsCart(String strnm,String strprice,int Sno)
{
	this.strnm=strnm;
	this.strprice=strprice;
	this.Sno=Sno;
}
public void dispcncl()
{
	System.out.println(strnm+" "+strprice+" "+Sno);
}
}
