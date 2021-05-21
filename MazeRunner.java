import javafx.event.*;
import javafx.scene.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.canvas.*;
import javafx.scene.layout.*;
import javafx.animation.*;
import javafx.application.*;
import javafx.geometry.*;
import javafx.stage.*;
import java.util.*;
import java.io.*;
import javafx.scene.paint.Color;

public class MazeRunner extends Application
{
   public static int[][] mapData;
   FlowPane root = new FlowPane();   
   board gboard= new board();   
   public void start(Stage stage)   
   {       
      GraphicsContext gc = gboard.getGraphicsContext2D();           
      root.getChildren().add(gboard);    
      Scene scene = new Scene(root, 525, 525);      
      stage.setScene(scene);      
      stage.setTitle("The Amazing Maze");      
      stage.show();
      gboard.setOnKeyPressed(new KeyListenerDown());                         
      gboard.requestFocus();
      gboard.readArray();
      AnimationHandler ah = new AnimationHandler();      
      ah.start(); 
   }   

   public static void main(String[] args)  
   {
      launch(args);
   }

   public class AnimationHandler extends AnimationTimer   
   {   
      public void handle(long currentTimeInNanoSeconds)       
      {
            gboard.draw();        
      }     
   }
   
   public class KeyListenerDown implements EventHandler<KeyEvent>     
   {   
      public void handle(KeyEvent event)       
      {
         if (event.getCode() == KeyCode.UP)           
         {
            gboard.movePlayer(1);                     
         }          
         if (event.getCode() == KeyCode.DOWN)           
         {
            gboard.movePlayer(2);                      
         }          
         if (event.getCode() == KeyCode.LEFT)           
         {
            gboard.movePlayer(3);                     
         }          
         if (event.getCode() == KeyCode.RIGHT)           
         {
            gboard.movePlayer(4);            
         }          
      }   
   }   

}