package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {
  static RightTriangle rightTriangle = new RightTriangle(0, 0);
  static TVController controller = new TVController(rightTriangle);
  static TextField baseTextField = TextView.base;
  static TextField heightTextField = TextView.height;
  static TextField hypotenuseTextField = TextView.hypotenuse;

  @Override
  public void start(Stage primaryStage) {
    try {
      // Set id's for text fields
      baseTextField.setId("Base");
      heightTextField.setId("Height");

      hypotenuseTextField.setEditable(false);

      Label baseLabel = new Label("Base: ");
      HBox baseHb = new HBox();
      baseHb.getChildren().addAll(baseLabel, baseTextField);
      baseHb.setSpacing(10);

      Label heightLabel = new Label("Height: ");
      HBox heightHb = new HBox();
      heightHb.getChildren().addAll(heightLabel, heightTextField);
      heightHb.setSpacing(10);

      Label hypotenuseLabel = new Label("Hypotenuse: ");
      HBox hypotenuseHb = new HBox();
      hypotenuseHb.getChildren().addAll(hypotenuseLabel, hypotenuseTextField);
      hypotenuseHb.setSpacing(10);

      GridPane grid = new GridPane();
      grid.setPadding(new Insets(10, 10, 10, 10));
      grid.setVgap(5);
      grid.setHgap(5);
      grid.add(baseHb, 0, 0);
      grid.add(heightHb, 1, 0);
      grid.add(hypotenuseHb, 2, 0);
      grid.add(GraphicalView.triangle, 0, 1);

      primaryStage.setTitle("Right Triangle Generator");

      Scene scene = new Scene(grid, 500, 500);
      primaryStage.setScene(scene);
      primaryStage.show();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    baseTextField.setPrefSize(50, 20);
    heightTextField.setPrefSize(50, 20);
    hypotenuseTextField.setPrefSize(50, 20);
    launch(args);
  }
}
