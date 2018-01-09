//create table food(sno number(4) primary key,city varchar(20),area varchar(20),restaurants varchar(50),imgname varchar(20),restdesc varchar(200));
//select * from food;
public class Food
{

	String strSno,strCity,strArea,strRestourant,strImgnm,strRestDesc;
	public Food()
	{
		
	}
	public Food(String strSno,String strCity,String strArea,String strRestourant,String strImgnm,String strRestDesc )
	{
		this.strSno=strSno;
		this.strCity=strCity;
		this.strArea=strArea;
		this.strRestourant=strRestourant;
		this.strImgnm=strImgnm;
		this.strRestDesc=strRestDesc;
	}
	public void disp()
	{
		System.out.println(strSno + " "+strCity + " " + strArea + " "+strImgnm+" "+strRestDesc);
	}
	public String getStrSno() {
		return strSno;
	}

	public void setStrSno(String strSno) {
		this.strSno = strSno;
	}

	public String getStrCity() {
		return strCity;
	}

	public void setStrCity(String strCity) {
		this.strCity = strCity;
	}

	public String getStrArea() {
		return strArea;
	}

	public void setStrArea(String strArea) {
		this.strArea = strArea;
	}

	public String getStrRestourant() {
		return strRestourant;
	}

	public void setStrRestourant(String strRestourant) {
		this.strRestourant = strRestourant;
	}

	public String getStrImgnm() {
		return strImgnm;
	}

	public void setStrImgnm(String strImgnm) {
		this.strImgnm = strImgnm;
	}

	public String getStrRestDesc() {
		return strRestDesc;
	}

	public void setStrRestDesc(String strRestDesc) {
		this.strRestDesc = strRestDesc;
	}
}
