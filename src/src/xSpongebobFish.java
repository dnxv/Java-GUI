package src;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.QuadCurve;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;


public class xSpongebobFish extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {

		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		pane.setHgap(10);
		pane.setVgap(10);			

		//Base 
		int x = 100;
		int y = 200;
		Ellipse e1 = new Ellipse(100, 50, x, y);
		e1.setFill(Color.AQUAMARINE);
		e1.setStroke(Color.BLACK);
		e1.setStrokeWidth(3);
		pane.getChildren().add(e1);

		//Eyes
		Ellipse leftEye = createLeftEye();
		pane.getChildren().add(leftEye); 

		Ellipse rightEye = createRightEye();
		pane.getChildren().add(rightEye); 

		Rectangle rightWhiteEye = new Rectangle(127.5, -65, 70, 21);
		rightWhiteEye.setStrokeWidth(3);
		rightWhiteEye.setStroke(Color.BLACK);
		rightWhiteEye.setFill(Color.WHITE);
		rightWhiteEye.setTranslateX(101.5);
		rightWhiteEye.setTranslateY(-115);
		pane.getChildren().add(rightWhiteEye);

		Rectangle leftWhiteEye = new Rectangle(127.5, -65, 70, 21);
		leftWhiteEye.setStrokeWidth(3);
		leftWhiteEye.setStroke(Color.BLACK);
		leftWhiteEye.setFill(Color.WHITE);
		leftWhiteEye.setTranslateX(27.5);
		leftWhiteEye.setTranslateY(-115);
		pane.getChildren().add(leftWhiteEye);	    

		Rectangle rightPupil = new Rectangle(1,  1, 40, 23);
		rightPupil.setFill(Color.BLACK);
		rightPupil.setTranslateX(117.5);
		rightPupil.setTranslateY(-115);
		pane.getChildren().add(rightPupil);

		Circle rightShine = new Circle(150, -115, 5, Color.WHITE);
		rightShine.setTranslateX(141.5);
		rightShine.setTranslateY(-120);
		pane.getChildren().add(rightShine);

		Rectangle leftPupil = new Rectangle(1,  1, 40, 23);
		leftPupil.setFill(Color.BLACK);
		leftPupil.setTranslateX(45.5);
		leftPupil.setTranslateY(-115);
		pane.getChildren().add(leftPupil);

		Circle leftShine = new Circle(150, -115, 5, Color.WHITE);
		leftShine.setTranslateX(67.5);
		leftShine.setTranslateY(-120);
		pane.getChildren().add(leftShine);

//Mouth
		Ellipse lips = createLips();
		pane.getChildren().add(lips); 

		QuadCurve smile = createSmile();
		pane.getChildren().add(smile);

		QuadCurve cover2 = cover();
		pane.getChildren().add(cover2);

//Body
		Polygon body = createBody();
		pane.getChildren().add(body);

		QuadCurve cover = fixBody();
		pane.getChildren().add(cover);

		Polygon shirt = createShirt();
		pane.getChildren().add(shirt);

		Ellipse armSleeve = createArmSleeve();
		pane.getChildren().add(armSleeve);
		
		QuadCurve collar = createCollar();
		pane.getChildren().add(collar);
		

		QuadCurve arm = createArm();
		pane.getChildren().add(arm);
		
		Line armLine = createArmLine();
		pane.getChildren().add(armLine);

//Signature
		Text sign = createSign();
		pane.getChildren().add(sign);	

		//Create a scene and place it in the stage
		Scene scene = new Scene(pane, 600, 500, new LinearGradient(0, 0, 600, 500, false, CycleMethod.REFLECT, new Stop(0.0, Color.LIGHTGREEN), new Stop(1.0, Color.STEELBLUE)  ));

		primaryStage.setTitle("Drawing");
		primaryStage.setScene(scene);
		primaryStage.show();		
	}
	
	public Text createSign() {
		Text sign = new Text(200, 450, "David Camacho");
		Font font = Font.font("Freestyle Script", FontWeight.EXTRA_LIGHT, 
				FontPosture.ITALIC, 25);

		sign.setFont(font);
		sign.setTranslateX(220);
		sign.setTranslateY(300);
		return sign;
	}

	public Line createArmLine() {
		Line armLine = new Line(100, 100, 95, 203);
		armLine.setTranslateX(153);
		armLine.setTranslateY(232);
		armLine.setRotate(5);
		armLine.setStroke(new Color(Math.random(), Math.random(), Math.random(), 1));
		armLine.setStrokeWidth(5);
		return armLine;
	}

	public QuadCurve createArm() {
		QuadCurve arm = new QuadCurve(100, 100, -120, 150, 105, 150);
		Color armColor = Color.BURLYWOOD;
		arm.setFill(armColor);
		arm.setStroke(Color.BLACK);
		arm.setStrokeWidth(3);
		arm.setRotate(-75);
		arm.setTranslateX(95);
		arm.setTranslateY(231);
		return arm;
	}
	
	public QuadCurve createCollar() {
		QuadCurve collar = new QuadCurve(100, 100, 150, 270, 200, 100);
		collar.setFill(Color.AQUAMARINE);
		collar.setStroke(Color.BLACK);
		collar.setStrokeWidth(3);
		collar.setTranslateX(25);
		collar.setTranslateY(131);
		return collar;
	}
	
	public Ellipse createArmSleeve() {
		Ellipse armSleeve = new Ellipse(150, 150, 35, 60);
		armSleeve.setFill(Color.AQUAMARINE);
		armSleeve.setStroke(Color.BLACK);
		armSleeve.setStrokeWidth(3);
		armSleeve.setTranslateX(125);
		armSleeve.setTranslateY(190);
		return armSleeve;
	}

	public Polygon createShirt() {
		Polygon shirt = new Polygon(
				new double[] {
						183, 330, 408, 330,
						395, 120, 210, 120}
				);
		shirt.setTranslateY(195);
		shirt.setTranslateX(-22);
		shirt.setStroke(Color.BLACK);
		shirt.setFill(Color.WHITE);
		return shirt;
	}
	
	public Polygon createBody() {
		Polygon poly = new Polygon(
				new double[] {
						180, 330, 410, 330,
						395, 100, 210, 100}
				);
		poly.setTranslateY(190);
		poly.setTranslateX(-25);
		poly.setStroke(Color.BLACK);
		poly.setFill(Color.AQUAMARINE);
		poly.setStrokeWidth(3);
		return poly;
	}
	
	public QuadCurve fixBody() {
		QuadCurve cover = new QuadCurve();
		cover.setStartX(210);
		cover.setStartY(90);
		cover.setControlX(300);
		cover.setControlY(335);
		cover.setEndX(420);
		cover.setEndY(90);

		cover.setStroke(Color.AQUAMARINE);
		cover.setFill(Color.AQUAMARINE);
		cover.setTranslateX(-5);
		cover.setTranslateY(115.5);
		cover.setStrokeWidth(3);
		return cover;
	}
	
	public QuadCurve cover() {
		QuadCurve cover2 = new QuadCurve();
		cover2.setStartX(185);
		cover2.setStartY(90);
		cover2.setControlX(300);
		cover2.setControlY(-70);
		cover2.setEndX(400);
		cover2.setEndY(90);
		cover2.setStroke(Color.BLACK);
		cover2.setFill(Color.AQUAMARINE);
		cover2.setTranslateX(-9.5);
		cover2.setTranslateY(15);
		cover2.setStrokeWidth(3);
		return cover2;
	}
	
	public QuadCurve createSmile() {
		QuadCurve smile = new QuadCurve(190, 30, 300, -100, 380, 30);
		smile.setStroke(Color.BLACK);
		smile.setFill(Color.MEDIUMPURPLE);
		smile.setStrokeWidth(3);
		smile.setTranslateY(-10);
		return smile;
	}
	
	public Ellipse createLips() {
		Ellipse lips = new Ellipse(190, 50, 110.5, 95);
		lips.setFill(Color.MEDIUMPURPLE);
		lips.setStroke(Color.BLACK);
		lips.setStrokeWidth(3);
		lips.setTranslateX(-10.5);
		lips.setTranslateY(35);
		return lips;
	}
	
	public Ellipse createLeftEye() {
		Ellipse leftEye = new Ellipse(100, 50, 35.5, 55);
		leftEye.setFill(Color.color(.5, .5, .5));
		leftEye.setStroke(Color.BLACK);
		leftEye.setStrokeWidth(3);
		leftEye.setTranslateX(27.5);
		leftEye.setTranslateY(-115);
		return leftEye;
	}
	
	public Ellipse createRightEye() {
		Ellipse rightEye = new Ellipse (100, 50, 35.5, 55);
		rightEye.setFill(Color.color(.5, .5, .5));
		rightEye.setStroke(Color.BLACK);
		rightEye.setStrokeWidth(3);
		rightEye.setTranslateX(100.5);
		rightEye.setTranslateY(-115);
		return rightEye;
	}
	
	public static void main(String[] args) {
		Application.launch(args);

	}

}


