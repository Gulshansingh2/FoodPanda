
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class LoginFrame extends JFrame implements ItemListener
{
	Container c=null;
	
	static JComboBox city;
	static JComboBox area;
	String[] stra=new String[5];
	JButton showRes=new JButton("SHOW RESTAURENTS");
	JLabel lblunm=new JLabel("Admin");
	JLabel lblpwd=new JLabel("Password");
	
	JTextField txtunm=new JTextField();
	JPasswordField txtpwd=new JPasswordField();
	
	ImageIcon bg=new ImageIcon("a.jpg");
	JLabel admin=new JLabel("Admin");
	JLabel login=new JLabel("My Account");
	DBHandler objdh=new DBHandler();
	public LoginFrame()
	{
		c=getContentPane();
		c.setLayout(null);
	
		JLabel lblBG=new JLabel(bg);
		
		lblBG.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		c.add(lblBG);	
	
		city=new JComboBox();
		Vector<String> vctr = objdh.getAllcityfromTblfood();
		city=new JComboBox(vctr);	
		city.addItemListener(this);
		city.setBounds(400,400,200,30);
		lblBG.add(city);
		
		area=new JComboBox();
	
		city.addItemListener(new ItemListener()
		{
			
			@Override
			public void itemStateChanged(ItemEvent e)
			{
				area.removeAllItems();
				String cityname=(String) e.getItem();
				System.out.println(cityname);
				stra=objdh.getareafromyblfood(cityname);
				System.out.println("Total items");
				for(int i=0;i<stra.length;i++)
				{
					area.addItem(stra[i]);
				
				}
				
				
				// TODO Auto-generated method stub
				
			}
		});
		city.setBorder(new EmptyBorder(3,0,3,3));
		
		
	
	
		area.setBounds(620,400,200,30);
		lblBG.add(area);
		area.setBorder(new EmptyBorder(3,0,3,3));
	
		//for(i=0;i<6;i++)
	//{
	//	area.addItem(vctr.get(i));
	//}
		showRes.setBounds(840, 400, 200, 30);
		lblBG.add(showRes);
		showRes.setBorder(new EmptyBorder(3,0,3,3));
		showRes.setBackground(Color.decode("#54C571"));
		
		showRes.addActionListener(new ActionListener()
		{
	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Restaurant res=new Restaurant();			
				System.out.println("Show Restaurant Pressed");
				dispose();
			}
			
		});
		
	admin.setBounds(1350,180,100,20);
	admin.setFont(new Font("BOLD",Font.BOLD,15));
	lblBG.add(admin);
		
	admin.addMouseListener(new MouseAdapter()
	{
	
		@Override
		public void mouseClicked(MouseEvent arg0) {
			User us=new User();
			dispose();
		}});
	
	login.setBounds(1500,180,100,20);
	login.setFont(new Font("BOLD",Font.BOLD,15));
	lblBG.add(login);
	login.addMouseListener(new MouseAdapter()
	{
	
		@Override
		public void mouseClicked(MouseEvent arg0) {
			Login  lg=new Login();
			
		}});
	
	
		setTitle("loginFrame");
		setVisible(true);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		@Override
		public void itemStateChanged(ItemEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	
}
