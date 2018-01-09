import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;


public class Item extends JFrame
{
	final int MAX=16;
	Vector vc=new Vector();
	Vector vctr=new Vector();
	Vector vctr1=new Vector();
	 
	static int sno=0;
	LinkedList <ClsCart> objList=new LinkedList<ClsCart>(); 
		
	 Container c=null;
	Priceitem[] p=new Priceitem[16];
	ImageIcon icn1[]=new ImageIcon[MAX];
	JLabel img[]=new JLabel[16];
	JLabel price[]=new JLabel[16];
	JLabel fdes[]=new JLabel[16];

	String status1="";
	
	JLabel fnm[]=new JLabel[16];
	
	
	ImageIcon icn;
	JLabel lbl;
	JPanel pnl[]=new JPanel[16];

	JPanel pnl1=new JPanel();
	JPanel pnl2=new JPanel();
	ImageIcon icny=new ImageIcon("y.png");
	JLabel y=new JLabel(icny);
	ImageIcon addicn=new ImageIcon("button_addtobag.png");
	JButton addbtn[]=new JButton[16];	
	JButton btn=new JButton("Place order");
	

	JLabel admin=new JLabel("Admin");
	JLabel login=new JLabel("My Account");
	JLabel home=new JLabel("Home");

	
	
	DBHandler db=new DBHandler();
	String imgnames[]=new String[16];
	String price1[]=new String[16];
	String name[]=new String[16];

	
	public Item(String strRestaurantSelected)
	{
		
		imgnames=db.getItemsDetailByrestname(strRestaurantSelected);
        price1=db.getItemsDetailByrestname(strRestaurantSelected);
        name=db.getItemnmaesbyrestname(strRestaurantSelected);
        c=getContentPane();
		c.setLayout(null);
		
		icn=new ImageIcon("a.jpg");
		lbl=new JLabel(icn);
		lbl.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		lbl.setLayout(null);
		c.add(lbl);
		admin.setBounds(1360,180,80,20);
		admin.setFont(new Font("BOLD",Font.BOLD,15));
		lbl.add(admin);
			
		admin.addMouseListener(new MouseAdapter()
		{

			@Override
			public void mouseClicked(MouseEvent arg0) {
				User us=new User();
			
			}});

		login.setBounds(1240,180,100,20);
		login.setFont(new Font("BOLD",Font.BOLD,15));
		lbl.add(login);
		login.addMouseListener(new MouseAdapter()
		{

			@Override
			public void mouseClicked(MouseEvent arg0) {
				Login  lg=new Login();
			
			}});
		home.setBounds(1140,180,80,20);
		home.setFont(new Font("BOLD",Font.BOLD,15));
		lbl.add(home);
		home.addMouseListener(new MouseAdapter()
		{

			@Override
			public void mouseClicked(MouseEvent arg0) {
			LoginFrame  lg=new LoginFrame();
			dispose();
			}});

	pnl1.add(y);
	pnl1.setBounds(1000,300,350,70);
	pnl1.setBackground(Color.red);
	lbl.add(pnl1);
	pnl1.setBorder(BorderFactory.createLineBorder(Color.gray));
	
    JScrollPane scroll = new JScrollPane(pnl2,
    		JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	scroll.setBounds(1000,370,350,450);
	pnl2.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY)); 
	pnl2.setPreferredSize(new Dimension(300, 1000)); 
	lbl.add(scroll);
	
	btn.setBounds(1200,850,150,35);
	lbl.add(btn);
	
	int ypos=300;
	for( int i=0;i<8;i++)
	{
		
	pnl[i]=new JPanel();
	pnl[i].setLayout(null);
	pnl[i].setBounds(293,ypos,650,70);
	lbl.add(pnl[i]);
	pnl[i].setBorder(BorderFactory.createLineBorder(Color.gray));
	
	System.out.println(imgnames[i]);
	icn1[i]=new ImageIcon(imgnames[i]);
	img[i]=new JLabel(icn1[i]);
	img[i].setBounds(10,15,130,50);
	pnl[i].add(img[i]);
	
	fdes[i]=new JLabel(name[i]);
	fdes[i].setFont(new Font("BOLD", Font.BOLD, 14));
	fdes[i].setBounds(250,15,100,20);
	pnl[i].add(fdes[i]);

	price[i]=new JLabel(price1[i+8]);
	price[i].setFont(new Font("BOLD", Font.BOLD, 14));
	price[i].setBounds(380,15,70,20);
	pnl[i].add(price[i]);
	
	addbtn[i]=new JButton(addicn);
	addbtn[i].setBounds(470,15,140,35);
	pnl[i].add(addbtn[i]);
	addbtn[i].addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent arg0)
		{
			JButton btnadd=(JButton) arg0.getSource();
			Component c[]=btnadd.getParent().getComponents();
			String nm=c[1].toString();
			String nm1=c[2].toString();
			int strt=nm.indexOf("text");
			int end=nm.indexOf("verticalAlignment");
			//System.out.println(strt+"ghgh"+end);
			//System.out.println(nm);
			String nmf=nm.substring(strt+5,end-1);
			System.out.println(nmf);
			
			String prc=c[2].toString();
			int strt1=nm1.indexOf("text");
			int end1=nm1.indexOf("verticalAlignment");
			//System.out.println(strt1+"ghgh"+end1);
			//System.out.println(nm);
			String nmf1=nm1.substring(strt1+5,end1-1);
			System.out.println(nmf1);
			
			
			
			String strProdNm,strProdPrice;
			strProdNm=nmf;
			strProdPrice=nmf1;
			sno=sno+1;
			ClsCart objCart=new ClsCart(strProdNm, strProdPrice, sno);
			objList.add(objCart);
			//vctr.add(nmf);
			//vctr1.add(nmf1);		
			
		//	vc.add(objCart);
			funCartPanel(objList);
	
	

	//System.out.println(c[0].toString());
			//System.out.println(c[2].toString());
			//System.out.println(btnadd);
		

			
		}});
			//}

	ypos+=70;
	}
	

	btn.setBackground(Color.decode("#90EE90"));
	btn.addActionListener(new ActionListener()
	{

		
			public void actionPerformed(ActionEvent arg0)
			{
				
				
			
				
			
				 
				  if(Login.status.equals("t") )
					{
							
						vctr.removeAllElements();
						vctr1.removeAllElements();
						funCartPanel(objList);
						for(int i=0;i<objList.size();i++)
						{
							
							vctr.add(objList.get(i).getStrnm());
							vctr1.add(objList.get(i).getStrprice());
							
						}
						
						//Billing bill=new Billing(vctr,vctr1);
						Invoice inv = new Invoice(vctr,vctr1);
					dispose();
					}
	else
	{
		JOptionPane.showMessageDialog(null, "PLEASE LOGIN FIRST FROM MY Account OR ADD SOME FOOD!!!");
		
	}
				
		
			}}	);
	
		setTitle("ITEM");
	setVisible(true);
	setSize(Toolkit.getDefaultToolkit().getScreenSize());
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
public void funCartPanel(final LinkedList<ClsCart>objList)
{
	
	int ypos =50;

	for( int i=0;i<objList.size();i++)
	{
	

		
	JLabel fnm=new JLabel(); //(vctr.get(i).toString());
	fnm.setText(objList.get(i).getStrnm());
	fnm.setFont(new Font("BOLD", Font.BOLD, 14));
	fnm.setBounds(50,ypos,100,30);
	pnl2.setLayout(null);
	pnl2.add(fnm);
	pnl2.repaint();
	
	JLabel price=new JLabel();//(vctr1.get(i).toString());
	price.setText(objList.get(i).getStrprice());
	price.setFont(new Font("BOLD", Font.BOLD, 14));
	price.setBounds(160,ypos,100,30);
	pnl2.setLayout(null);
	pnl2.add(price);
	pnl2.repaint();
	
	ImageIcon icn3=new ImageIcon("close.png");
	JButton close[]=new JButton[100]; 
	 close[i]=new JButton(icn3);
	 close[i].setBounds(270,ypos,30,30);
	 close[i].setBorder(BorderFactory.createEmptyBorder());
	 close[i].setActionCommand(String.valueOf(i));
	pnl2.add(close[i]);

	close[i].addActionListener(new ActionListener()
	{

		public void actionPerformed(ActionEvent arg0) {
		String stractionCmd=arg0.getActionCommand();
		Item.this.objList.remove(Integer.parseInt(stractionCmd));
		pnl2.removeAll();
		funCartPanel(objList);
		pnl2.repaint();
		System.out.println("btn Clicked");
		}
	
	
	});
	ypos += 40;
//ypos+=70;
	}
	
}

}



