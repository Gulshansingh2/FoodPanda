import java.awt.Container;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Form extends JFrame implements ActionListener
{
	String strfoodno;
	String strrestaurnet;
	String strpopular1;
	String strpopular2;
	String strsnack1;
	String strsnack2;
	String strdrink1;
	String strdrink2;
	String strsweet1;
	String strsweet2;
	
	
	JLabel lbl1=new JLabel("FoodNo");
	JLabel lbl2=new JLabel("Restaurant");
	JLabel lbl3=new JLabel("Popular1");
	JLabel lbl4=new JLabel("popular2");
	JLabel lbl5=new JLabel("Snack1");
	JLabel lbl6=new JLabel("Snack2");
	JLabel lbl7=new JLabel("Drink1");
	JLabel lbl8=new JLabel("Drink2");
	JLabel lbl9=new JLabel("Sweet1");
	JLabel lbl10=new JLabel("sweet2");
	
	JLabel home=new JLabel("Home");
	JTextField txt1=new JTextField();
	JTextField txt2=new JTextField();
	JTextField txt3=new JTextField();
	JTextField txt4=new JTextField();
	JTextField txt5=new JTextField();
	JTextField txt6=new JTextField();
	JTextField txt7=new JTextField();
	JTextField txt8=new JTextField();
	JTextField txt9=new JTextField();
	JTextField txt10=new JTextField();
	
	ImageIcon icn=new ImageIcon("a.jpg");
	JLabel lble=new JLabel(icn);
	
	DBHandler db=new DBHandler();
	Container c=null;
	public Form()
	{
		c=getContentPane();
		c.setLayout(null);
		lble.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		c.add(lble);
	
	

		home.setBounds(1360,180,40,20);
		home.setFont(new Font("BOLD",Font.BOLD,12));
		lble.add(home);
		home.addMouseListener(new MouseAdapter()
		{

			@Override
			public void mouseClicked(MouseEvent arg0) {
			LoginFrame  lg=new LoginFrame();
			dispose();
			}});

		/////////////label///////
		lbl1.setBounds(300,250,100,20);
		lble.add(lbl1);
		
		txt1.setBounds(410,250,100,20);
		lble.add(txt1);
		
		
		lbl2.setBounds(300,280,100,20);
		lble.add(lbl2);
		
		txt2.setBounds(410,280,100,20);
		lble.add(txt2);
		
		lbl3.setBounds(300,310,100,20);
		lble.add(lbl3);
		
		txt3.setBounds(410,310,100,20);
		lble.add(txt3);
		
		lbl4.setBounds(300,340,100,20);
		lble.add(lbl4);
		txt4.setBounds(410,340,100,20);
		lble.add(txt4);
		
		lbl5.setBounds(300,370,100,20);
		lble.add(lbl5);
		txt5.setBounds(410,370,100,20);
		lble.add(txt5);
		
		lbl6.setBounds(300,400,100,20);
		lble.add(lbl6);
		txt6.setBounds(410,400,100,20);
		lble.add(txt6);
		
		lbl7.setBounds(300,430,100,20);
		lble.add(lbl7);
		
		txt7.setBounds(410,430,100,20);
		lble.add(txt7);
		
		lbl8.setBounds(300,460,100,20);
		lble.add(lbl8);
		txt8.setBounds(410,460,100,20);
		lble.add(txt8);
		
		lbl9.setBounds(300,490,100,20);
		lble.add(lbl9);
		txt9.setBounds(410,490,100,20);
		lble.add(txt9);
		
		lbl10.setBounds(300,520,100,20);
		lble.add(lbl10);
		txt10.setBounds(410,520,100,20);
		lble.add(txt10);
		
		JButton insert=new JButton("Insert");
		insert.setBounds(300, 550, 100, 20);
		lble.add(insert);
		
		JButton show=new JButton("Show Table");
		show.setBounds(410, 550, 100, 20);
		lble.add(show);
		
		insert.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				strfoodno=txt1.getText();
				strrestaurnet=txt2.getText();
				strpopular1=txt3.getText();
				strpopular2=txt4.getText();
				strsnack1=txt5.getText();
				strsnack2=txt6.getText();
				strdrink1=txt7.getText();
				strdrink2=txt8.getText();
				strsweet1=txt9.getText();
				strsweet2=txt10.getText();
				
				db.Insertintotblfooditem(strfoodno,strrestaurnet,strpopular1,strpopular2,strsnack1,strsnack2,strdrink1,strdrink2,strsweet1,strsweet2);				
				JOptionPane.showMessageDialog(null,"data inserted");
				
			}
			
		});
		
		show.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				Table tbl=new Table();
			}
			
		});

		
		setTitle("Form......");
		setVisible(true);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}	}

