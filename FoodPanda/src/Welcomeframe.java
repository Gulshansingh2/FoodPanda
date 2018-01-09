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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class Welcomeframe  extends JFrame
{
	Welcomeframe frm;
	JMenuBar menufood=new JMenuBar();
	JMenu insert=new JMenu(" Food");
	JMenuItem itm=new JMenuItem("Insert");
	Container c=null;
	public Welcomeframe()
	{
		c=getContentPane();
		c.setLayout(null);
	
		ImageIcon icn=new ImageIcon("tomatoe.jpg");
	JLabel lbla=new JLabel(icn);
	


		lbla.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		c.add(lbla);
		setJMenuBar(menufood);
		lbla.add(menufood);
		menufood.add(insert);
		insert.add(itm);
		
		itm.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				System.out.println("jkjkjkkjjk");
				Form frm=new Form();
			}
			
		});
		setTitle("Welcomeframe");
		setVisible(true);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}

