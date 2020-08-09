package application;

import javafx.scene.control.TextField;
import java.util.Observer;
import java.util.Observable;

public class TextView implements Observer {
  static public TextField base = new TextField();
  static public TextField height = new TextField();
  static public TextField hypotenuse = new TextField();
  public RightTriangle target;

  public TextView(RightTriangle rt) {
    rt.addObserver(this);
  }

  public void update(Observable model, Object arg) {
    RightTriangle rt = (RightTriangle) model;
    TextView.base.setText(String.valueOf(rt.getBase()));
    TextView.height.setText(String.valueOf(rt.getHeight()));
    TextView.hypotenuse.setText(String.valueOf(rt.getHypotenuse()));
  }
}