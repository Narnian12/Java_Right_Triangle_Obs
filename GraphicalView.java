package application;

import java.util.Observable;
import java.util.Observer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;

public class GraphicalView extends Path implements Observer {
  static public Canvas triangle;
  static public GraphicsContext gc;

  public GraphicalView(RightTriangle rt) {
    rt.addObserver(this);
    triangle = new Canvas(100, 100);
    gc = triangle.getGraphicsContext2D();
  }

  public void update(Observable model, Object arg) {
    RightTriangle rt = (RightTriangle) model;
    gc.setFill(Color.FIREBRICK);
    gc.setStroke(Color.FIREBRICK);
    gc.fillPolygon(new double[] {0,  rt.getBase(),  0}, new double[] {0, 0, rt.getHeight()}, 3);
    gc.strokePolygon(new double[] {0,  rt.getBase(),  0}, new double[] {0, 0, rt.getHeight()}, 3);
  }
}
