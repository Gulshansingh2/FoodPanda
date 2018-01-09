import java.awt.Color;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class Table extends JFrame
{
	
	JPanel pnl;
	JTable table;
	Container c=null;
	ImageIcon icn=new ImageIcon("a.jpg");
	JLabel lbl=new JLabel(icn);
	JButton delete=new JButton("Delete");
	JButton update=new JButton("Update");
	
	JLabel home=new JLabel("Home");
	
	DBHandler db=new DBHandler();
	JLabel lbl1;
	int ypos=30;
	int yposs=30;
	 JTextField txt[]=new JTextField[10];
	JLabel Lbl[]=new JLabel[10];
	String strlblnms[]={"FoodNo","Restaurnet","Popular1","Popular2","Snack1","Snack2","Drink1","Drink2","Sweet1","Sweet2"};
	 public Table()
	{
		
		c=getContentPane();
		c.setLayout(null);
		
		lbl.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		c.add(lbl);
	
		
		delete.setBounds(800,100,100,20);
		lbl.add(delete);
	
		update.setBounds(910,100,100,20);
		lbl.add(update);
		
		home.setBounds(1040,30,40,20);
		home.setFont(new Font("BOLD",Font.BOLD,12));
		lbl.add(home);
		home.addMouseListener(new MouseAdapter()
		{

			@Override
			public void mouseClicked(MouseEvent arg0) {
			LoginFrame  lg=new LoginFrame();
			dispose();
			}});

		pnl=new JPanel();
		pnl.setBounds(50, 350, 500, 330);
		pnl.setBackground(Color.gray);
		lbl.add(pnl);
		
//		String coloumns[]={"FoodNo","Restaurant","Popular1","Popular2","Snack1","Snack2","Drink1","Drink2","Sweet1","Sweet2"};
//		DefaultTableModel dtm=new DefaultTableModel(coloumns,0);
//		final JTable table=new JTable(dtm);
//		

		table=db.getfooditemtable();
		
		JScrollPane jsp=new JScrollPane(table);
		jsp.setBounds(30, 80, 700, 100);
		lbl.add(jsp);
		
		
		table.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				System.out.println("mocuse clicked");
				int row=table.getSelectedRow();
				System.out.println("get selected text"+row);
				int col=table.getSelectedColumn();
				int size=table.getColumnCount();
				ypos=30;yposs=30;
				pnl.removeAll();
				for(int i=0;i<size;i++)
				{
					System.out.println("value is"+table.getValueAt(row, i));
					txt[i]=new JTextField();
					txt[i].setBounds(300, ypos, 100, 20);
					txt[i].setText((String) table.getValueAt(row, i));
					txt[i].setEnabled(false);
					ypos+=30;
					pnl.add(txt[i]);
				}
				
				for(int i=0;i<size;i++)
				{
					System.out.println("value is"+table.getValueAt(row, i));
					Lbl[i]=new JLabel(strlblnms[i]);
					Lbl[i].setBounds(100, yposs, 100, 20);
					yposs+=30;
					pnl.add(Lbl[i]);
				}

				pnl.repaint();
			}
		});
		
	
		

	update.addActionListener(new ActionListener()
	{

	
		public void actionPerformed(ActionEvent arg0) {
			
			DUpdate du=new DUpdate();
			
			
				
		}
		
	});
	
	delete.addActionListener(new ActionListener()
	{

	
		public void actionPerformed(ActionEvent arg0) {
			
			DUpdate du=new DUpdate();
			
			
				
		}
		
	});

		
		


		
		
		setTitle("Disp Food");
		setVisible(true);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	
	}
}
