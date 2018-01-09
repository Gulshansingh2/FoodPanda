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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class User extends JFrame
{
	ImageIcon icn=new ImageIcon("a.jpg");
	JLabel lbl=new JLabel(icn);
	JLabel admin=new JLabel("Admin Id");
	JLabel pass=new JLabel("Password");
	JLabel home=new JLabel("Home");
	
	
	JTextField ad=new JTextField();
	JPasswordField password=new JPasswordField();
	
	DBHandler objdh=new DBHandler();
	JButton btn=new JButton("Login");
	Container c=null;
	JPanel pnl=new JPanel();
	
	public User()
	{
		c=getContentPane();
		c.setLayout(null);
		lbl.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		c.add(lbl);
		
	
		
		home.setBounds(1040,180,40,20);
		home.setFont(new Font("BOLD",Font.BOLD,12));
		lbl.add(home);
		home.addMouseListener(new MouseAdapter()
		{

			@Override
			public void mouseClicked(MouseEvent arg0) {
			LoginFrame  lg=new LoginFrame();
			dispose();
			}});


		pnl.setBounds(453,250,350,250);
		pnl.setBackground(Color.gray);
		pnl.setBorder(BorderFactory.createLineBorder(Color.gray));
		pnl.setLayout(null);
		lbl.add(pnl);
		
		
		admin.setBounds(50,50,100,20);
		pnl.add(admin);
		
		pass.setBounds(50,80,100,20);
		pnl.add(pass);
		
		ad.setBounds(160,50,100,20);
		pnl.add(ad);
		
		password.setBounds(160,80,100,20);
		pnl.add(password);
		
		btn.setBounds(160,110,100,20);
		pnl.add(btn);
		
		btn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				String strunm,strpwd;
				strunm=ad.getText();
				strpwd=String.valueOf(password.getText());
				boolean res=objdh.isvaliduser(strunm, strpwd);
				if(res==true)
				{
					
				Welcomeframe frm=	new Welcomeframe();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "invalid user");
				}
			}});

		setTitle("user");
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
