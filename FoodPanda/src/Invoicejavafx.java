
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Vector;

import com.sun.prism.paint.Color;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.*;
import javafx.scene.text.Font;

public class Invoicejavafx extends Application
      {
	    String[] nm;
        String[] prc;
     
         public void start (Stage primaryStage)
               {
        	  primaryStage.setTitle ("GridPane example");
        	  BorderPane bPane = new BorderPane();
              GridPane gridPane1 = new GridPane ();
              GridPane gridPane2 = new GridPane ();
              
              bPane.setCenter(gridPane1);
              bPane.setBottom(gridPane2);
              bPane.setLeft(null);
              bPane.setRight(null);
              
              gridPane1.setAlignment (Pos.TOP_LEFT);
              gridPane1.setPadding (new Insets (20, 20,20, 20));
              gridPane1.setHgap (700);
              gridPane1.setVgap (50);
              
              gridPane2.setAlignment (Pos.TOP_LEFT);
              gridPane2.setPadding (new Insets (20, 100, 20, 20));
              gridPane2.setPrefSize(1000, 500);
              gridPane2.setGridLinesVisible(true);
              ColumnConstraints col1 = new ColumnConstraints();
              col1.setPercentWidth(70);
              ColumnConstraints col2 = new ColumnConstraints();
              col2.setPercentWidth(25);
              gridPane2.getColumnConstraints().addAll(col1,col2);
          
              
             
              Label[] lbl = new Label[10];
              for (int i = 0; i < 10; i++) {
            		lbl[i] = new Label("null");
            		
              }
              Font f = Font.font ("Times New Roman", 40);
              lbl[0] = new Label("Company Name");
              lbl[0].setFont (f); 
              lbl[1] = new Label("Invoice");
              lbl[1].setFont (f); 
              
              Font f1 = Font.font ("Times New Roman", 25);
              lbl[2] = new Label("Bill to: ");
              lbl[2].setFont (f1);
              lbl[3] = new Label("Date:");
              lbl[3].setFont (f1);
              lbl[4] = new Label("Description");
              lbl[4].setFont (f1); 
              lbl[5] = new Label("Amount");
              lbl[5].setFont (f1);
              lbl[8] = new Label("Thankyou for ordering");
              lbl[8].setFont (f1);
            	  
              FileInputStream imageStream;
			try {
				imageStream = new FileInputStream("F:\\Gulshan Singh\\Courses\\Core Java\\FoodPanda\\top.jpg");
				Image image = new Image(imageStream);
	             bPane.setTop(new ImageView(image));
	             gridPane1.add(lbl[0],0 , 0);
	             gridPane1.add(lbl[1],1 , 0);
	             gridPane1.add(lbl[2],0 , 1);
	             gridPane1.add(lbl[3],1 , 1);
	             
	             gridPane2.add(lbl[4],0 , 0);
	             gridPane2.add(lbl[5],1 , 0);
	             gridPane2.add(lbl[6],0 , 1);
	             gridPane2.add(lbl[7],1 , 1);
	             gridPane2.add(lbl[8],0 , 2);
	             gridPane2.add(lbl[9],1 , 2);
	             
	             
	            

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
              
              Scene scene = new Scene (bPane, 1200, 800);
              primaryStage.setResizable(false);
              primaryStage.setScene (scene);
              primaryStage.show ();
               }
         
         public void main(Vector vctr,Vector  vctr1) {
             nm = ((String[]) vctr.toArray(new String[vctr.size()]));
             prc = ((String[]) vctr1.toArray(new String[vctr1.size()]));
        	 launch(null);
         }

		
         
      }