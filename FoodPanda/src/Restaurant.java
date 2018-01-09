import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class Restaurant extends JFrame
{
	
	final int MAX=10;
	static String strRestaurantSelected;
	JPanel pnl1[]=new JPanel[MAX];
	ImageIcon icn;
	JLabel lbl;
	static	JLabel restname[]=new JLabel[10];
	JLabel restd[]=new JLabel[10];
	JLabel img[]=new JLabel[10];
	JLabel del[]=new JLabel[10];
	ImageIcon icn1[]=new ImageIcon[MAX];
	 

	JLabel admin=new JLabel("Admin");
	JLabel login=new JLabel("My Account");
	JLabel home=new JLabel("Home");

	
	Container c=null;
	Food f[]=new Food[10];
	DBHandler db=new DBHandler();
	public Restaurant()
	{
		String strArea=String.valueOf(LoginFrame.area.getSelectedItem());
		String strCity=String.valueOf(LoginFrame.city.getSelectedItem());
		f=db.getRestrouantDetailByCitynamAndArea(strCity, strArea);

		c=getContentPane();
		c.setLayout(null);
		icn=new ImageIcon("a.jpg");
		lbl=new JLabel(icn);
		lbl.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		lbl.setLayout(null);
		c.add(lbl);
		
		
		admin.setBounds(1180,180,80,20);
		admin.setFont(new Font("BOLD",Font.BOLD,15));
		lbl.add(admin);
			
		admin.addMouseListener(new MouseAdapter()
		{

			@Override
			public void mouseClicked(MouseEvent arg0) {
				User us=new User();
		
			}});

		login.setBounds(1280,180,100,20);
		login.setFont(new Font("BOLD",Font.BOLD,15));
		lbl.add(login);
		login.addMouseListener(new MouseAdapter()
		{

			@Override
			public void mouseClicked(MouseEvent arg0) {
				Login  lg=new Login();
			
			}});
		home.setBounds(1080,180,80,20);
		home.setFont(new Font("BOLD",Font.BOLD,15));
		lbl.add(home);
		home.addMouseListener(new MouseAdapter()
		{

			@Override
			public void mouseClicked(MouseEvent arg0) {
			LoginFrame  lg=new LoginFrame();
			dispose();
			}});


		
		String 	strdelnms[]={"Delivers in 10 min","Delivers in 25 min","Delivers in 15 min","Delivers in 30 min","Delivers in 40 min"};
		int ypos=250;
		for(int i=1;i<=5;i++)
		{
			

			//System.out.println(f[i].getStrRestourant()+".......");
			
			pnl1[i]=new JPanel();
			pnl1[i].setLayout(null);
			pnl1[i].setBounds(283, ypos, 800, 100);
			pnl1[i].setBackground(Color.white);
			
			
			pnl1[i].setBorder(BorderFactory.createLineBorder(Color.gray));

			restname[i]=new JLabel(f[i].getStrRestourant());
			restname[i].setFont(new Font("BOLD", Font.BOLD, 14));
			restname[i].setBounds(250, 15,150 ,20);
			pnl1[i].add(restname[i]);
		
			restname[i].addMouseListener(new MouseAdapter()
			{

				@Override
				public void mouseClicked(MouseEvent arg0) {
					JLabel lblRestSelected=(JLabel) arg0.getSource();
					 strRestaurantSelected=lblRestSelected.getText();
					//JOptionPane.showMessageDialog(null, strRestaurantSelected);
					
				Item me=new Item(strRestaurantSelected);	
				dispose();
				}
			});
			
			restd[i]=new JLabel(f[i].getStrRestDesc());
			restd[i].setBounds(250,25,180,70);
			pnl1[i].add(restd[i]);
		
			icn1[i]=new ImageIcon(f[i].getStrImgnm());
			img[i]=new JLabel(icn1[i]);
			img[i].setBounds(10,15,180,80);
			pnl1[i].add(img[i]);
			
			del[i]=new JLabel(strdelnms[i-1]);
			del[i].setBounds(600,25,180,80);
			pnl1[i].add(del[i]);
			
			ypos+=100;
			lbl.add(pnl1[i]);
		}

		
		
		setVisible(true);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}

}
