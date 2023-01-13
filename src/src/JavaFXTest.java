package src;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Shear;
import javafx.stage.Stage;



public class JavaFXTest extends Application {

	double orgSceneX, orgSceneY;
	double orgTranslateX, orgTranslateY;
	double newTranslateX, newTranslateY;


	@Override // Override the start method in the Application class

	public void start(Stage primaryStage) {
		// Create the Pane
		Pane root = new Pane();        	

		//create triangles
		Polygon[] triangleArray = new Polygon[6];
		ArrayList<Polygon> triangles = new ArrayList<Polygon>(); 
		Polygon triangle1 = new Polygon(350.0, 25.0, 475.0, 25.0, 412.5, 125.0);
		Polygon triangle2 = new Polygon(475.0, 25.0, 525.0, 125.0, 412.5, 125.0); 
		Polygon triangle3 = new Polygon(525.0, 125.0, 475.0, 225.0, 412.5, 125.0);
		Polygon triangle4 = new Polygon(475.0, 225.0, 350.0, 225.0, 412.5, 125.0);
		Polygon triangle5 = new Polygon(350.0, 225.0, 300.0, 125.0, 412.5, 125.0);
		Polygon triangle6 = new Polygon(350.0, 25.0, 300.0, 125.0, 412.5, 125.0);


		triangle1.setFill(Color.WHITE);
		triangle1.setStroke(Color.BLACK);
		triangle1.setStrokeWidth(2);
		triangleArray[0] = triangle1;
		triangles.add(triangle1);
		root.getChildren().add(triangle1);

		triangle2.setFill(Color.BLACK);
		triangle2.setStroke(Color.BLACK);
		triangle2.setStrokeWidth(2);
		triangleArray[1] = triangle2;
		triangles.add(triangle2);
		root.getChildren().add(triangle2);

		triangle3.setFill(Color.BLACK);
		triangle3.setStroke(Color.BLACK);
		triangle3.setStrokeWidth(2);
		triangleArray[2] = triangle3;
		triangles.add(triangle3);
		root.getChildren().add(triangle3);

		triangle4.setFill(Color.BLACK);
		triangle4.setStroke(Color.BLACK);
		triangle4.setStrokeWidth(2);
		triangleArray[3] = triangle4;
		triangles.add(triangle4);
		root.getChildren().add(triangle4);

		triangle5.setFill(Color.BLACK);
		triangle5.setStroke(Color.BLACK);
		triangle5.setStrokeWidth(2);
		triangleArray[4] = triangle5;
		triangles.add(triangle5);
		root.getChildren().add(triangle5);

		triangle6.setFill(Color.BLACK);
		triangle6.setStroke(Color.BLACK);
		triangle6.setStrokeWidth(2);
		triangleArray[5] = triangle6;
		triangles.add(triangle6);
		root.getChildren().add(triangle6);

		///////////////////////////////////////////////////////////			

		//rotate polygons			
		Paint temp = triangles.get(5).getFill();

		for (int i = triangles.size() - 1; i > 0; i--) {
			//make t6 into t0
			Shape shape = triangles.get(i - 1);
			triangles.get(i).setFill(shape.getFill());
		}

		triangles.get(0).setFill(temp);

		//locking animation

		////////////////////////////////////////////////////////////////		
		triangles.get(0).setOnMousePressed(event -> pressed(event, triangles.get(0)));
		triangles.get(0).setOnMouseDragged(event -> dragged(event, triangles.get(0)));
		triangles.get(0).setOnMouseReleased(event -> released(event, triangles.get(0), root));	
		/////////////////////////////////////////////////////////////////////////

		Scene scene = new Scene(root, 850, 650);

		primaryStage.setTitle("MyJavaFX"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage


	}

	public void pressed(MouseEvent t, Polygon triangle) {
		triangle.setFill(Color.BURLYWOOD);
		orgSceneX = t.getSceneX();
		orgSceneY = t.getSceneY();
		System.out.println("orgSceneX: " + orgSceneX);
		System.out.println("orgSceneY: " + orgSceneY);
		
		
		orgTranslateX = ((Polygon)(t.getSource())).getTranslateX();
		orgTranslateY = ((Polygon)(t.getSource())).getTranslateY();
		System.out.println("orgTransX: " + orgTranslateX);
		System.out.println("orgTransY: " + orgTranslateY);
	}
	
	public void dragged(MouseEvent t, Polygon triangle) {
//		System.out.println(triangle.getTranslateX());
//		System.out.println(triangle.getTranslateY());
		
		double offsetX = t.getSceneX() - orgSceneX;
		double offsetY = t.getSceneY() - orgSceneY;
		
		System.out.println("offsetX: " + offsetX);
		System.out.println("offsetY: " + offsetY);
		
		newTranslateX = orgTranslateX + offsetX;
		newTranslateY = orgTranslateY + offsetY;
		
		System.out.println("newTransX: " + newTranslateX);
		System.out.println("newTransY: " + newTranslateY);
		
		((Polygon)(t.getSource())).setTranslateX(newTranslateX);
		((Polygon)(t.getSource())).setTranslateY(newTranslateY);
		
	}
	
	public void released(MouseEvent t, Polygon triangle, Pane root) {
		if (t.getSceneX() > 412 && t.getSceneX() < 525) {
			if (t.getSceneY() > 25 && t.getSceneY() < 225) {	

//		    	((Polygon)(t.getSource())).setTranslateX(112.5);
//				((Polygon)(t.getSource())).setTranslateY(15.0);
//				((Polygon)(t.getSource())).setRotate(60.0);
				
				
				triangle.getPoints().setAll(475.0, 25.0, 525.0, 125.0, 412.5, 125.0);
//				triangle.toFront();										        	
				//check order of to front
				
				
			}
		}
	}



	/**

	 * The main method is only needed for the IDE with limited

	 * JavaFX support. Not needed for running from the command line.

	 */

	public static void main(String[] args) { 

		Application.launch(args);

	}
	
//	EventHandler<MouseEvent> circleOnMousePressedEventHandler = new EventHandler<MouseEvent>() {
//
//		@Override
//		public void handle(MouseEvent t) {
//			orgSceneX = t.getSceneX();
//			orgSceneY = t.getSceneY();
//			orgTranslateX = ((Polygon)(t.getSource())).getTranslateX();
//			orgTranslateY = ((Polygon)(t.getSource())).getTranslateY();
//		}
//	};
//
//	EventHandler<MouseEvent> circleOnMouseDraggedEventHandler = new EventHandler<MouseEvent>() {
//
//		@Override
//		public void handle(MouseEvent t) {
//			double offsetX = t.getSceneX() - orgSceneX;
//			double offsetY = t.getSceneY() - orgSceneY;
//			double newTranslateX = orgTranslateX + offsetX;
//			double newTranslateY = orgTranslateY + offsetY;
//
//			((Polygon)(t.getSource())).setTranslateX(newTranslateX);
//			((Polygon)(t.getSource())).setTranslateY(newTranslateY);
//		}
//	};


	///////////////////////////////////////////////////////////////////////////////////////////

}