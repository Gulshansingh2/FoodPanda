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


public class DUpdate extends JFrame
{
	DBHandler db =new DBHandler();
	ImageIcon icn=new ImageIcon("a.jpg");
	JLabel lble=new JLabel(icn);
	
	JLabel home=new JLabel("Home");
	JButton delete=new JButton("Delete");
	JButton update=new JButton(" Update");
	

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

	int i=0;
	Container c=null;
	public DUpdate()
	{
		c=getContentPane();
		c.setLayout(null);
				
		lble.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		c.add(lble);
		
		home.setBounds(1040,30,40,20);
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
		lbl1.setBounds(100,100,100,20);
		lble.add(lbl1);
		
		txt1.setBounds(210,100,100,20);
		lble.add(txt1);
		
		
		lbl2.setBounds(100,130,100,20);
		lble.add(lbl2);
		
		txt2.setBounds(210,130,100,20);
		lble.add(txt2);
		
		lbl3.setBounds(100,160,100,20);
		lble.add(lbl3);
		
		txt3.setBounds(210,160,100,20);
		lble.add(txt3);
		
		lbl4.setBounds(100,190,100,20);
		lble.add(lbl4);
		txt4.setBounds(210,190,100,20);
		lble.add(txt4);
		
		lbl5.setBounds(100,220,100,20);
		lble.add(lbl5);
		txt5.setBounds(210,220,100,20);
		lble.add(txt5);
		
		lbl6.setBounds(100,250,100,20);
		lble.add(lbl6);
		txt6.setBounds(210,250,100,20);
		lble.add(txt6);
		
		lbl7.setBounds(100,280,100,20);
		lble.add(lbl7);
		
		txt7.setBounds(210,280,100,20);
		lble.add(txt7);
		
		lbl8.setBounds(100,310,100,20);
		lble.add(lbl8);
		txt8.setBounds(210,310,100,20);
		lble.add(txt8);
		
		lbl9.setBounds(100,340,100,20);
		lble.add(lbl9);
		txt9.setBounds(210,340,100,20);
		lble.add(txt9);
		
		lbl10.setBounds(100,370,100,20);
		lble.add(lbl10);
		txt10.setBounds(210,370,100,20);
		lble.add(txt10);
		
		delete.setBounds(400,100,100,20);
		lble.add(delete);
		
		update.setBounds(510,100,100,20);
		lble.add(update);
		
		
		delete.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
			
		
				String strfoodno=txt1.getText();
				db.deletetablebyfoodno(strfoodno);
				JOptionPane.showMessageDialog(null,"data deleted");
				
			}
			
		});
		
		update.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
			
		
				String strfoodno=txt1.getText();
				String strrestaurent=txt2.getText();
				String strpopular1=txt3.getText();
				String strpopular2=txt4.getText();
				String strsnack1=txt5.getText();
				String strsnack2=txt6.getText();
				String strdrink1=txt7.getText();
				String strdrink2=txt8.getText();
				String strsweet1=txt9.getText();
				String strsweet2=txt10.getText();
				
				db.updatetablefoodno(strfoodno,strrestaurent,strpopular1,strpopular2,strsnack1,
						strsnack2,strdrink1,strdrink2,strsweet1,strsweet2);
				JOptionPane.showMessageDialog(null,"data updated");
				
			}
			
		});
		
		setTitle("data update");
		setVisible(true);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
			

}
