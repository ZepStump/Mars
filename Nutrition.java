public class Nutrition
{  
  public double cal=0, carbs=0, fat=0, protein=0, fiber=0;

  public Nutrition(double newCal,double newCarbs,double newFat,double newProtein,double newFiber)
  {
    cal = newCal;
    carbs = newCarbs;
    fat = newFat;
    protein = newProtein;
    fiber = newFiber;
  }
  public void setCal(double newCal)
  {
    cal = newCal;
  }
  public void setCarbs(double newCarbs)
  {
    carbs = newCarbs;
  }
  public void setFat(double newFat)
  {
    fat = newFat;
  }
  public void setProtein(double newProtein)
  {
    protein = newProtein;
  }
  public void setFiber(double newFiber)
  {
    fiber = newFiber;
  }
  public void setAll(double newCal,double newCarbs,double newFat,double newProtein,double newFiber)
  {
    cal= newCal;
    carbs = newCarbs;
    fat = newFat;
    protein = newProtein;
    fiber = newFiber;
  }

  public double getCal()
  {
    return cal;
  }

  public double getCarbs()
  {
    return carbs;
  }

  public double getFat()
  {
    return fat;
  }

  public double getProtein()
  {
    return protein;
  }

  public double getFiber()
  {
    return fiber;
  }
}