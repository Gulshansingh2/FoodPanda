
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Login extends JFrame
{
	static String status="";
	ImageIcon icn=new ImageIcon("a.jpg");
	
	JLabel lbl=new JLabel(icn);
	JLabel admin=new JLabel("User Id");
	JLabel pass=new JLabel("Password");
	JLabel nw=new JLabel("New User");
	JLabel ct=new JLabel("Username");
	JLabel pw=new JLabel("Password");
	
	JLabel home=new JLabel("Home");
	
	JLabel pi=new JLabel("Unique ID");
	JTextField txtpi=new JTextField();
	
	JTextField ad=new JTextField();
	JPasswordField password=new JPasswordField();
	
	JTextField txtct=new JTextField();
	JPasswordField txtpw=new JPasswordField();
	JPasswordField txtcpw=new JPasswordField();
	
	DBHandler objdh=new DBHandler();
	JButton btn=new JButton("Login");
	JButton btn1=new JButton("Submit");
	
	Container c=null;
	JPanel pnl=new JPanel();
	
	
	public Login()
	{
		c=getContentPane();
		c.setLayout(null);
		lbl.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		c.add(lbl);
		
		home.setBounds(1360,180,100,30);
		home.setFont(new Font("BOLD",Font.BOLD,15));
		lbl.add(home);
		home.addMouseListener(new MouseAdapter()
		{

			@Override
			public void mouseClicked(MouseEvent arg0) {
			LoginFrame  lg=new LoginFrame();
			dispose();
			}});

		
		pnl.setBounds(453,250,500,500);
		pnl.setBorder(BorderFactory.createLineBorder(Color.gray));
		pnl.setBackground(Color.pink);
		pnl.setLayout(null);
		lbl.add(pnl);
		
		
		admin.setBounds(100,80,100,20);
		pnl.add(admin);	
		pass.setBounds(100,110,100,20);
		pnl.add(pass);
		
		ad.setBounds(210,80,100,20);
		pnl.add(ad);
		
		password.setBounds(210,110,100,20);
		pnl.add(password);
		
		btn.setBounds(210,140,100,20);
		pnl.add(btn);
		
		btn.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String strunm,strpwd;
				strunm=ad.getText();
				strpwd=String.valueOf(password.getText());
				boolean res=objdh.isvalidperson(strunm, strpwd);
				if(res==true)
					{
						status="t";
					JOptionPane.showMessageDialog(null, "Successfully login");
				
					dispose();
					}
				else
				{
					status="f";
					JOptionPane.showMessageDialog(null, "invalid User or Password");
				}
	
			}
			
		});
		
		
		pi.setBounds(100,260,100,20);
		pnl.add(pi);
		
		
		txtpi.setBounds(260,260,100,20);
		pnl.add(txtpi);
		
		int id=objdh.getMAXID("personalid","users");
		id=id+1;
		txtpi.setText(String.valueOf(id));
		txtpi.setEnabled(false);
		
		
		
		nw.setBounds(180,200,100,20);
		pnl.add(nw);
		
		ct.setBounds(100,290,100,20);
		pnl.add(ct);
		
		pw.setBounds(100,320,100,20);
		pnl.add(pw);
		
		txtct.setBounds(260,290,100,20);
		pnl.add(txtct);
		
		txtpw.setBounds(260,320,100,20);
		pnl.add(txtpw);
		
		btn1.setBounds(260,350,100,20);
		pnl.add(btn1);

		btn1.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent arg0)
				{
					//JOptionPane.showMessageDialog(null, "data dldsfkjsdfjl sadf");
					String strpi,strunm,strpwd,strcpw;
//					txtpi.setText("pi");
//					txtct.setText("ct");
//					txtpw.setText("pw");
					strpi=txtpi.getText();
					strunm=txtct.getText();
					strpwd=String.valueOf(txtpw.getPassword());
				
					
					//if (strpwd.equals(strcpw))  
				if(strunm.equals("") || strpwd.equals(""))
					{
					
					JOptionPane.showMessageDialog(null, " PLEASE ENTER VALID USERNAME AND PASSWORD");

			

				}
				
				else 
				{
					objdh.isenterperson(strpi,strunm,strpwd);
					JOptionPane.showMessageDialog(null, "Id Created");		
					int id=objdh.getMAXID("personalid", "users");
					id=id+1;
					JOptionPane.showMessageDialog(null, "ACCOUNT CREATED PLEASE SIGN IN !!!!!");		
					dispose();
				Login lg=new Login();
			

					}
				
					}});
					
	
	
	
			setTitle("user login");
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}