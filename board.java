import javafx.event.*;
import javafx.scene.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.animation.*;
import javafx.application.*;
import javafx.geometry.*;
import javafx.stage.*;
import java.util.*;
import java.io.*;
import javafx.scene.paint.Color;
import javafx.scene.canvas.*;

public class board extends Canvas
{
   private String fileName;
   private int iy; 
   private int jx; 
   public static int xcord = 0;
   public static int ycord = 0;  
   public static int mapData[][];
   public int xloc = 9;
   public int yloc = 0;
   int check, direction;
   GraphicsContext gc = getGraphicsContext2D();   
   public board()
   {      
      super(525,525);

   }   
   public void draw()   
   {
      //redraw game map every time
      gc.clearRect(0,0,525,525);
      for(int i=0; i<21; i++)
      {
         for (int j=0; j<21; j++)
         {
            check = mapData[i][j];
            xcord = j*25;
            ycord = i*25;
            if (check == 1)
            {
               gc.setFill(new Color(0,0,0,1));
               gc.fillRect(xcord, ycord, xcord + 25,ycord + 25);
            }
            else if (check == 0)
            {
               gc.setFill(new Color(1,1,1,1));
               gc.fillRect(xcord, ycord, xcord + 25,ycord + 25);
            }
         }
      }
      gc.setFill(new Color(0,1,0,1));
      gc.fillRect(xloc*25, yloc*25, 25, 25); 
   }
   //send gamepiece with updated coordinates
   public void movePlayer(int direction)
   {
      switch (direction)
      {
         case 1:
            if ((yloc > 0)&&(mapData[yloc - 1][xloc] == 0))
            {
               yloc--;
            }
            break;
         case 2:
            if ((yloc < 21)&&(mapData[yloc + 1][xloc] == 0))
            {
               yloc++;
               if (yloc == 20)
               {
                  System.out.println("u win");  
               }
            }
            break;
         case 3:  
            if ((xloc > 0)&&(mapData[yloc][xloc - 1] == 0))
            {
               xloc--;
            }
            break;
        case 4:
            if ((xloc < 21)&&(mapData[yloc][xloc + 1] == 0))
            {
               xloc++;
            }
            break;
      }                 
   }
   
   public void readArray()
   {
      try
      {
         Scanner scan = new Scanner(new File("mazeMap1.txt")); 
         do
         {  
            int y = 21;
            int x = 21;
            mapData = new int[y][x];
            for(int i=0; i<y; i++)
            {
               for (int j=0; j<x; j++)
               {
                  String val = scan.next();
                  mapData[i][j] = Integer.parseInt(val);
               }
            }    
         }while (scan.hasNext());
         scan.close();
      }
      catch (IOException ex)
      {
         System.out.println("Could not find file ");
      }
   }
       
}