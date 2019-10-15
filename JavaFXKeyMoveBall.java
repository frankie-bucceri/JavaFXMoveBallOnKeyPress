//JavaFXKeyMoveBall.java
//How to use a key pressed event to move a circle to javaFX

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;


public class JavaFXKeyMoveBall extends Application
{
   public static void main(String[] args)
   {
      launch(args);
   }// End main
   
   public void start(Stage pStage)
   {
   // Scene size constants
      final double SWIDTH = 200.0;
      final double SHEIGHT = 200.0;
   // Circle constants
      final double STARTX = 100.0;
      final double STARTY = 40.0;
      final double RADIUS = 40.0;
      final double STEP = 10.0;
   
   // Create the circle
      Circle ball = new Circle(STARTX, STARTY, RADIUS);
      ball.setFill(Color.RED); 
   // Add it to the pane
      Pane pane = new Pane(ball);
   // Create the scene and display it
      Scene scene = new Scene(pane, SWIDTH, SHEIGHT);
   
   // Event handler
      scene.setOnKeyPressed(
         event ->
         {
         // Get circle's coordinates
            double x = ball.getCenterX();
            double y = ball.getCenterY();
         // Check for the down-arrow key
            if (event.getCode() == KeyCode.DOWN && y < (SHEIGHT - RADIUS))
               ball.setCenterY(y + STEP);
         // Check for the up-arrow key
            if (event.getCode() == KeyCode.UP && y > RADIUS)
               ball.setCenterY(y - STEP);
         // Check for the right-arrow key
            if (event.getCode() == KeyCode.RIGHT && x < (SHEIGHT - RADIUS))
               ball.setCenterX(x + STEP);
          // Check for the left-arrow key
            if (event.getCode() == KeyCode.LEFT && x > RADIUS)
               ball.setCenterX(x - STEP);
         }); // End event handler
      pStage.setScene(scene);
      pStage.setTitle("Moving Ball on Key Press");
      pStage.show();
   
   }// End start
} // End class