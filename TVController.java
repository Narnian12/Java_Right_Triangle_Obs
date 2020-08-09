package application;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

@SuppressWarnings("rawtypes")
public class TVController extends TextView implements EventHandler {
  public RightTriangle model;
  public TextView textView;
  public GraphicalView graphicalView;

  public TVController(RightTriangle model) {
    super(model);
    this.model = model;
    this.textView = new TextView(model);
    TextView.base.setOnAction(this);
    TextView.height.setOnAction(this);
    graphicalView = new GraphicalView(model);
  }

  public void handle(Event event) {
    TextField tf = (TextField) event.getSource();
    try {
      double number = Double.parseDouble(tf.getText());

      if (number < 0)
        throw new NumberFormatException();
      String id = tf.getId();
      if (id.equals("Base")) {
        model.setBase(number);
      } else {
        model.setHeight(number);
      }
      graphicalView.update(model, null);
    } catch (NumberFormatException e) {
      textView.update(model, null);
    }
  }
}
