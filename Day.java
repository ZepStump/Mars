import java.util.*;

public class Day
{  
  public Item[] meals = new Item[4];

  public Item[] getMeals()
  {
    return meals;
  }

  public void setMeals(Item[] new_items)
  {
    meals = new_items;
  }

  public void setMeal(int number, Item meal)
  {
    meals[number] = meal;
  }

  public Item getMeal(int number)
  {
    return meals[number];
  }
}  