import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Rectangle2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.Calendar;
import java.util.Vector;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.MediaPrintableArea;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

public class Invoice extends JFrame{
	 private InvoiceComponent invoiceComponent;
	 private PrintRequestAttributeSet attributes;
	 private Invoice inv;
	   
//	 private static final int DEFAULT_WIDTH = 300;
//	 private static final int DEFAULT_HEIGHT = 300;
	 
	public Invoice(Vector vctr,Vector vctr1) {
		super("Invoice");  
		inv = this;
		invoiceComponent = new InvoiceComponent(vctr, vctr1);
	    JScrollPane scroll = new JScrollPane(invoiceComponent,
	    		JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
	            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//	    scroll.setMinimumSize(new Dimension(1700,1000));
//	    scroll.setPreferredSize(new Dimension(1700,1000));
	    add(scroll, BorderLayout.CENTER);
	    
	    attributes = new HashPrintRequestAttributeSet();
	    //System.out.println("------------------------------------------------------" + getWidth());
	    attributes.add(new MediaPrintableArea(0f, 0f, 1600/72f, 1000/72f, MediaPrintableArea.INCH));  
	    JButton printButton = new JButton("Print Invoice");
	    printButton.addActionListener(new ActionListener()
	    {
            public void actionPerformed(ActionEvent event)
            {
               try
               {
                  PrinterJob job = PrinterJob.getPrinterJob();
                  job.setPrintable(invoiceComponent);
                  if (job.printDialog(attributes)) job.print(attributes);
                  
              
               }
               catch (PrinterException e)
               {
                  JOptionPane.showMessageDialog(Invoice.this, e);
               }
            }
         });


	    add(printButton, BorderLayout.NORTH);
	    
	    setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setVisible(true);
		addWindowListener(new WindowAdapter(){  
            public void windowClosing(WindowEvent e) {  
                System.exit(0);  
            }  
        });
	}
	
	
}

class InvoiceComponent extends JComponent implements ActionListener, Printable{
	
	String resName = "resName", address = "address", invDate = "invDate";
	String[] foodName, foodPrice;
	int total;
	int yPos = 500;
	private Timer timer;
	private int delay = 0;
	
	 int[] pageBreaks;  // array of page break line positions.
	
	public InvoiceComponent(Vector vctr,Vector vctr1) {
        setBorder(new LineBorder(Color.BLACK));
		resName = Restaurant.strRestaurantSelected;
		
		String strArea=String.valueOf(LoginFrame.area.getSelectedItem());
		String strCity=String.valueOf(LoginFrame.city.getSelectedItem());
		address = strArea + ", " + strCity; 
		
		Calendar c = Calendar.getInstance();
		invDate = (c.getTime().toString());
		
		foodName = (String[]) vctr.toArray(new String[vctr.size()]);
        foodPrice =(String[]) vctr1.toArray(new String[vctr1.size()]);
        
        for (int i = 0; i < foodName.length ; i++)
        {
	    	total=total+Integer.parseInt(foodPrice[i]);
	    }
        timer = new Timer(delay, this);
		timer.start();
	}
	
	public void paint (Graphics g) {
		Graphics2D g2 = (Graphics2D)g;    
	    drawInvoice(g2);
	    setPreferredSize(new Dimension(100, yPos + 100));
	}
	
	private void drawInvoice(Graphics2D g2) {
		Color color = new Color(0,0,70);
	    Font font1 = new Font("Courier", Font.BOLD, 60);
	    Font font2 = new Font("Courier", Font.BOLD, 40);
	    Font font3 = new Font("Courier", Font.PLAIN, 25);
	    Font font4 = new Font("Courier", Font.BOLD, 25);
	    int i;
	    
	    g2.setFont(font1);
	    g2.setColor(color);
	    g2.drawString("INVOICE", 100, 150);
	    
	    g2.setFont(font2);
	    g2.drawString(resName, 100, 220);
	    
	    g2.setFont(font3);
	    g2.drawString(address, 100, 260);
	    g2.drawString(invDate, 300, 330);
	    yPos = 500;
	    for (i = 0; i < foodName.length ; i++)
	    {
	    	g2.drawString(foodName[i], 150, yPos);
	    	g2.drawString(foodPrice[i], 1550, yPos);
	    	yPos += 50;
	    }
	    String totalToString = ""+  total;
	    g2.drawString(totalToString, 1550, yPos + 20);
	    
	    g2.setFont(font4);
	    g2.drawString("INVOICE DATE", 100, 330);
	    g2.drawString("DESCRIPTION", 150, 420);
	    g2.drawString("AMOUNT", 1550, 420);
	    g2.drawString("TOTAL", 1300, yPos + 20);
	 
	    color = new Color(247,58,44);
	    g2.setColor(color);
	    g2.setStroke(new BasicStroke(10));
	    g2.drawLine(100, 380, 1700, 380);
	    g2.drawLine(100, 450, 1700, 450);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}
	
	@Override
	public int print(Graphics g, PageFormat pf, int page) throws PrinterException {

		if (page >= 1) return Printable.NO_SUCH_PAGE;
	      
	   // bounds of the component
        Dimension dim = getSize();
        double cHeight = dim.getHeight();
        double cWidth = dim.getWidth();

        // bounds of the printable area
        double pHeight = pf.getImageableHeight();
        double pWidth = pf.getImageableWidth();

        double pXStart = pf.getImageableX();
        double pYStart = pf.getImageableY();

        double xRatio = pWidth / cWidth;
        double yRatio = pHeight / cHeight;

        Graphics2D g2 = (Graphics2D) g;    
        g2.translate(pXStart, pYStart);
        g2.scale(xRatio, yRatio);
	    drawInvoice(g2);
	    
	    return Printable.PAGE_EXISTS;
	}
}
