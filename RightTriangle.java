package application;

import java.util.Observable;

public class RightTriangle extends Observable {
  private double base;
  private double height;
  private double hypotenuse;

  // Constructor
  public RightTriangle(double base, double height) {
    this.base = base;
    this.height = height;
    setHypotenuse();
  }

  // Getters
  public double getBase() {
    return base;
  }

  public double getHeight() {
    return height;
  }

  public double getHypotenuse() {
    return hypotenuse;
  }

  // Setters
  public void setHypotenuse() {
    this.hypotenuse = Math.sqrt((base * base) + (height * height));
  }

  public void setBase(double newBase) {
    this.base = newBase;
    setHypotenuse();
    setChanged();
    notifyObservers();
  }

  public void setHeight(double newHeight) {
    this.height = newHeight;
    setHypotenuse();
    setChanged();
    notifyObservers();
  }
}
