import java.util.*;

public class Driver
{
  public Day[] vegetarian_menu = new Day[10]; 
  public Day[] mixed_menu = new Day[10];
  public Nutrition[] table = new Nutrition[20];
  int age, weight, height;
  String sex;
  int [] week = {-1, -1, -1, -1, -1, -1, -1};

  double allCalAverage, allCarbsAverage, allFatAverage;
  double allProteinAverage, allFiberAverage;

  double allCalTotal = 0, allCarbsTotal = 0, allFatTotal = 0;
  double allProteinTotal = 0, allFiberTotal = 0;
  
  public Driver()
  {
    //setting menus
    veggiMenuSetter();
    mixedMenuSetter();
    //setting table
    tableSetter();

    int count = 0;
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Hello, please enter your age : ");
    age = keyboard.nextInt();
    keyboard.nextLine();
    System.out.println("Now enter your weight in kilograms : ");
    weight = keyboard.nextInt();
    keyboard.nextLine();
    System.out.println("Now enter your height in cm : ");
    height = keyboard.nextInt();
    keyboard.nextLine();
    System.out.println("Now enter your sex(M/F): ");
    sex = keyboard.nextLine();

    BEE();

    while (count < 5)
    {
      System.out.println("-------Options--------");
      System.out.println("Please enter 1-5 :");
      System.out.println("1) See Vegetarian Menu");
      System.out.println("2) See Mixed Menu");
      System.out.println("3) Enter meal");
      System.out.println("4) See nutrition tables");
      System.out.println("5) Exit");
      System.out.println("----------------------");

      int choice = keyboard.nextInt();
      keyboard.nextLine();

      switch(choice)
      {
        case 1:
          veggiOut();
          break;
        case 2:
          mixedOut();
          break; 
        case 3:
          while(count < 5)
          {
          System.out.println("Please choose the day: ");
          System.out.println("1 - Monday" + ((week[0]==-1) ? " " : (" : Meal plan picked: " + week[0])));
          System.out.println("2 - Tuesday" + ((week[1]==-1) ? " " : (" : Meal plan picked: " + week[1])));
          System.out.println("3 - Wednesday" + ((week[2]==-1) ? " " : (" : Meal plan picked: " + week[2])));
          System.out.println("4 - Thursday" + ((week[3]==-1) ? " " : (" : Meal plan picked: " + week[3])));
          System.out.println("5 - Friday" + ((week[4]==-1) ? " " : (" : Meal plan picked: " + week[4])));
          System.out.println("6 - Saturday" + ((week[5]==-1) ? " " : (" : Meal plan picked: " + week[5])));
          System.out.println("7 - Sunday" + ((week[6]==-1) ? " " : (" : Meal plan picked: " + week[6])));
          System.out.println("Enter 1-7 or 0 for exit\n");

          int week_day = keyboard.nextInt();
          keyboard.nextLine();

          System.out.println("Now enter meal plan: ");
          System.out.println("1-10 for Mixed Menu, 11-20 for Vegeterain menu");

          int meal_choice = keyboard.nextInt();
          keyboard.nextLine();

          switch (week_day)
          {
            case 0:
               System.exit(1);
               break;
            case 1:
               count++;
               week[0] = meal_choice;
               break; 
            case 2:
               count++;
               week[1] = meal_choice;
               break;
            case 3:
               count++;
               week[2] = meal_choice;
               break;
            case 4:
               count++;
               week[3] = meal_choice;
               break;
            case 5:
               count++;
               week[4] = meal_choice;
               break;
            case 6:
               count++;
               week[5] = meal_choice;
               break;
            case 7:
               count++;
               week[6] = meal_choice;
               break; 
            default:
               System.out.println("Sorry, wrong entry. Try again");
               break;                      
          }
          }

          doMath();
          break;
        case 4:
          tableOut();
          break;   
        case 5:
          System.exit(0);
          break;
        default:
          System.out.println("Sorry, wrong entry try again");
          break;
      }
    }
  }

//setting up the Mixed menu
  public void mixedMenuSetter()
  {
    Item breakfast1 = new Item();
    Item lunch1 = new Item();
    Item dinner1 = new Item();
    Item snacks1 = new Item();

    // Day 1
    String[] breakfast11 = {"Scrambled Eggs Tofu Bakon","Pancakes Maple Syrup","Chocolate Soy Milk"," "};
    String[] lunch11 = {"Blueberry Raspberry Yogurt Peanut","Butter and Jam Sandwich Spicy","Oven Fries Ultimate Lemon Cake"," "};
    String[] dinner11 = {"Spinach and Tomato Crouton Salad","Beef Stew Herb Biscuit"," "};
    String[] snacks11 = {"Flourless PB Cookies"," "};
    breakfast1.setLines(breakfast11);
    lunch1.setLines(lunch11);
    dinner1.setLines(dinner11);
    snacks1.setLines(snacks11);
    Item[] day11 = {breakfast1, lunch1, dinner1, snacks1};
    Day day1 = new Day();
    day1.setMeals(day11);

    Item breakfast2 = new Item();
    Item lunch2 = new Item();
    Item dinner2 = new Item();
    Item snacks2 = new Item();

    // Day 2
    String[] breakfast12 = {"Veggie Egg Scramble Whole","Wheat Bread Hash Browns","Strawberry Jam Vanilla Soy","Milk"," "};
    String[] lunch12 = {"Lettuce Wedges Sweet Potato and","Black Bean Burrito Spanish Rice","Sundried Tomato and Basil","Dressing"," "};
    String[] dinner12 = {"Grilled Pork Chop Scalloped","Potatoes and Carrots Glazed","Carrots and Peas"," "};
    String[] snacks12 = {"Strawberry Shortcake"," "};
    breakfast2.setLines(breakfast12);
    lunch2.setLines(lunch12);
    dinner2.setLines(dinner12);
    snacks2.setLines(snacks12);
    Item[] day12 = {breakfast2, lunch2, dinner2, snacks2};
    Day day2 = new Day();
    day2.setMeals(day12);

    Item breakfast3 = new Item();
    Item lunch3 = new Item();
    Item dinner3 = new Item();
    Item snacks3 = new Item();

    // Day 3
    String[] breakfast13 = {"Vegetarian Sausage Carrot","Bagels Strawberry Jam Soy","Mocha Beverage"," "};
    String[] lunch13 = {"Lentil and Spinach Soup TLT","Sandwiches Spicy Baked","Chips Fresh Tomato Juice with","Basil Spiced Caramel Coffee","Cake"," "};
    String[] dinner13 = {"TLT Sandwiches Spicy Baked","Chips Fresh Tomato Juice with","Basil"," "};
    String[] snacks13 = {"Chocolate Peanut","Butter Milkshake"," "};
    breakfast3.setLines(breakfast13);
    lunch3.setLines(lunch13);
    dinner3.setLines(dinner13);
    snacks3.setLines(snacks13);
    Item[] day13 = {breakfast3, lunch3, dinner3, snacks3};
    Day day3 = new Day();
    day3.setMeals(day13);

    Item breakfast4 = new Item();
    Item lunch4 = new Item();
    Item dinner4 = new Item();
    Item snacks4 = new Item();

    // Day 4
    String[] breakfast14 = {"Tofu Bakon Strawberry","Muffin Sweet Potato Mini","Muffins Rice w Sugar Soy","Mocha Beverage"," "};
    String[] lunch14 = {"Meatless Meatballs Wheat Pasta","Vegetable Tomato Sauce for Pasta","Spinach Bread Chocolate Pudding"," "};
    String[] dinner14 = {"Vichyssoise Beef Steak Roasted","Potatoes Mustard Carrots Southern","Fried Cabbage"," "};
    String[] snacks14 = {"Pinto Bean Pie"," "};
    breakfast4.setLines(breakfast14);
    lunch4.setLines(lunch14);
    dinner4.setLines(dinner14);
    snacks4.setLines(snacks14);
    Item[] day14 = {breakfast4, lunch4, dinner4, snacks4};
    Day day4 = new Day();
    day4.setMeals(day14);

    Item breakfast5 = new Item();
    Item lunch5 = new Item();
    Item dinner5 = new Item();
    Item snacks5 = new Item();

    // Day 5
    String[] breakfast15 = {"Scrambled Eggs Soy Wheat","Crepes with Strawberries","Chocolate Rice Milk"," "};
    String[] lunch15 = {"Crunchy Confetti Salad BBQ Beef","Brisket Mashed Sweet Potatoes","Whole Wheat Tortillas Gingerbread","Cookies"," "};
    String[] dinner15 = {"Marinated Cherry Tomato Salad","Turkey Tetrazzini Saute´ed Spinach","with Garlic Whole Wheat Biscuits","Bread Pudding"," "};
    String[] snacks15 = {"Chocolate Biscotti"," "};
    breakfast5.setLines(breakfast15);
    lunch5.setLines(lunch15);
    dinner5.setLines(dinner15);
    snacks5.setLines(snacks15);
    Item[] day15 = {breakfast5, lunch5, dinner5, snacks5};
    Day day5 = new Day();
    day5.setMeals(day15);

    Item breakfast6 = new Item();
    Item lunch6 = new Item();
    Item dinner6 = new Item();
    Item snacks6 = new Item();

    // Day 6
    String[] breakfast16 = {"Vegetarian Sausage","Scrambled Eggs Cinnamon","Sunrise Bread Baked","Potatoes Tomato Salsa","Chocolate Rice Milk"," "};
    String[] lunch16 = {"Hearty Noodle Soup Mock Chicken","Salad Whole Wheat Tortillas Carrot","Juice Mocha Pudding Cake"," "};
    String[] dinner16 = {"Asian Coleslaw Thai Pizza Chicken","w/ Peanut Sauce Brown Rice"," "};
    String[] snacks16 = {"PB Chocolate Tofu","Pudding Fresh","Strawberries"," "};
    breakfast6.setLines(breakfast16);
    lunch6.setLines(lunch16);
    dinner6.setLines(dinner16);
    snacks6.setLines(snacks16);
    Item[] day16 = {breakfast6, lunch6, dinner6, snacks6};
    Day day6 = new Day();
    day6.setMeals(day16);

    Item breakfast7 = new Item();
    Item lunch7 = new Item();
    Item dinner7 = new Item();
    Item snacks7 = new Item();

    // Day 7
    String[] breakfast17 = {"Tofu Bakon Sweet Potato","Pancake Peanut Butter","Maple Topping Vanilla Soy","Milk"," "};
    String[] lunch17 = {"Black Bean Chili Celery Sticks","Carrot Sticks Herb Biscuit","Strawberry Sorbet"," "};
    String[] dinner17 = {"Lettuce Wedges Silky Salad","Dressing Tomato and Bakon Pasta","Thin Crust Veggie Pizza Chocolate","Rice Milk"," "};
    String[] snacks17 = {"Chess Pie"," "};
    breakfast7.setLines(breakfast17);
    lunch7.setLines(lunch17);
    dinner7.setLines(dinner17);
    snacks7.setLines(snacks17);
    Item[] day17 = {breakfast7, lunch7, dinner7, snacks7};
    Day day7 = new Day();
    day7.setMeals(day17);

    Item breakfast8 = new Item();
    Item lunch8 = new Item();
    Item dinner8 = new Item();
    Item snacks8 = new Item();

    // Day 8
    String[] breakfast18 = {"Scrambled Eggs Vegetarian","Sausage Whole Wheat","Biscuits Carrot Hash Browns","Strawberry Jam Soy Mocha","Beverage"," "};
    String[] lunch18 = {"Chicken Fajitas Beef Fajitas Black","Beans Spanish Rice Whole Wheat","Tortillas Tofu Sour Cream Tomato","Salsa"," "};
    String[] dinner18 = {"African Sweet Potato & Peanut","Soup Spinach Strawberry Salad","Meatloaf Steamed Rice"," "};
    String[] snacks18 = {"Rice Pudding"," "};
    breakfast8.setLines(breakfast18);
    lunch8.setLines(lunch18);
    dinner8.setLines(dinner18);
    snacks8.setLines(snacks18);
    Item[] day18 = {breakfast8, lunch8, dinner8, snacks8};
    Day day8 = new Day();
    day8.setMeals(day18);

    Item breakfast9 = new Item();
    Item lunch9 = new Item();
    Item dinner9 = new Item();
    Item snacks9 = new Item();

    // Day 9
    String[] breakfast19 = {"Pancakes Sweet Potato and","Red Pepper Home Fries","Peanut Butter Maple","ToppingVanilla Soy Milk"," "};
    String[] lunch19 = {"Spinach and Tomato Crouton Salad","Wheat Pasta Arrabbiata Pasta","Sauce Calzone Vegetable Juice"," "};
    String[] dinner19 = {"Cream of Potato and Spinach Soup","Smoked Turkey Herb Stuffing with","Potatoes Glazed Carrots and Peas","Snap Beans Chocolate Ice Cream"," "};
    String[] snacks19 = {"Flourless PB Cookies"," "};
    breakfast9.setLines(breakfast19);
    lunch9.setLines(lunch19);
    dinner9.setLines(dinner19);
    snacks9.setLines(snacks19);
    Item[] day19 = {breakfast9, lunch9, dinner9, snacks9};
    Day day9 = new Day();
    day9.setMeals(day19);

    Item breakfast0 = new Item();
    Item lunch0 = new Item();
    Item dinner0 = new Item();
    Item snacks0 = new Item();

    // Day 10
    String[] breakfast20 = {"Scrambled Eggs Cinnamon","French Toast Maple Syrup","Rice Milk"," "};
    String[] lunch20 = {"Sloppy Joes Sweet Potato Fries"," "};
    String[] dinner20 = {"Fiesta Chicken Garlic Mashed","Potatoes Steamed Peas Spinach","Bread Chocolate Ice Cream","Caramel Topping"," "};
    String[] snacks20 = {"Chocolate Peanut","Butter Milkshake"," "};
    breakfast0.setLines(breakfast20);
    lunch0.setLines(lunch20);
    dinner0.setLines(dinner20);
    snacks0.setLines(snacks20);
    Item[] day20 = {breakfast0, lunch0, dinner0, snacks0};
    Day day10 = new Day();
    day10.setMeals(day20);
    
    //setting the menu
    mixed_menu[0] = day1;
    mixed_menu[1] = day2;
    mixed_menu[2] = day3;
    mixed_menu[3] = day4;
    mixed_menu[4] = day5;
    mixed_menu[5] = day6;
    mixed_menu[6] = day7;
    mixed_menu[7] = day8;
    mixed_menu[8] = day9;
    mixed_menu[9] = day10;
  }
  //setting up the Vegetarian menu
  public void veggiMenuSetter()
  {
    Item breakfast01 = new Item();
    Item lunch01 = new Item();
    Item dinner01 = new Item();
    Item snacks01 = new Item();

    // Day 1
    String[] breakfast011 = {"Scrambled Eggs Whole","Wheat Tortillas Tomato","Salsa Chocolate Soy","Milk"," "};
    String[] lunch011 = {"Peanut Butter and Jam","Sandwich Sweet Potato Fries","Rice Milk Ultimate Lemon Cake"," "};
    String[] dinner011 = {"Spinach and Tomato","Crouton Salad Lentil Stew","Carrot Juice"," "};
    String[] snacks011 = {"Strawberry","Shortcake"," "};
    breakfast01.setLines(breakfast011);
    lunch01.setLines(lunch011);
    dinner01.setLines(dinner011);
    snacks01.setLines(snacks011);
    Item[] day011 = {breakfast01, lunch01, dinner01, snacks01};
    Day day01 = new Day();
    day01.setMeals(day011);

    Item breakfast02 = new Item();
    Item lunch02 = new Item();
    Item dinner02 = new Item();
    Item snacks02 = new Item();

    // Day 2
    String[] breakfast012 = {"Scrambled Eggs Whole","Wheat Bread Hash","Browns Strawberry Jam","Carrot Juice Vanilla Soy","Milk"," "};
    String[] lunch012 = {"Spinach and Tomato Crouton","Salad Vegetable Chowder","Herb Biscuit Rice Pudding"," "};
    String[] dinner012 = {"Lettuce Wedges Sundried","Tomato and Basil","Dressing Sweet Potato","and Black Bean Burrito","Spanish Rice"," "};
    String[] snacks012 = {"Strawberry Sorbet"," "};
    breakfast02.setLines(breakfast012);
    lunch02.setLines(lunch012);
    dinner02.setLines(dinner012);
    snacks02.setLines(snacks012);
    Item[] day012 = {breakfast02, lunch02, dinner02, snacks02};
    Day day02 = new Day();
    day02.setMeals(day012);

    Item breakfast03 = new Item();
    Item lunch03 = new Item();
    Item dinner03 = new Item();
    Item snacks03 = new Item();

    // Day 3
    String[] breakfast013 = {"Scrambled Tofu","Vegetarian Sausage","Carrot Bagels","Strawberry Jam","Chocolate Soy Milk"," "};
    String[] lunch013 = {"Lentil and Spinach Soup TLT","Sandwiches Spicy Baked","Chips Fresh Tomato Juice with","Basil Spiced Caramel Coffee","Cake"," "};
    String[] dinner013 = {"Tofu Mushroom Stroganoff","Glazed Carrots and Peas","Carrot Dill Bread"," "};
    String[] snacks013 = {"Chocolate Peanut","Butter Milkshake"," "};
    breakfast03.setLines(breakfast013);
    lunch03.setLines(lunch013);
    dinner03.setLines(dinner013);
    snacks03.setLines(snacks013);
    Item[] day013 = {breakfast03, lunch03, dinner03, snacks03};
    Day day03 = new Day();
    day03.setMeals(day013);

    Item breakfast04 = new Item();
    Item lunch04 = new Item();
    Item dinner04 = new Item();
    Item snacks04 = new Item();

    // Day 4
    String[] breakfast014 = {"Tofu Bakon Strawberry","Muffin Sweet Potato","Mini Muffins Raggedy","Rice Patties Soy Mocha","Beverage"," "};
    String[] lunch014 = {"Wheat Pasta Vegetable","Tomato Sauce for Pasta","Meatless Meatballs Carrot Dill","Bread Vanilla Soy Milk","Chocolate Pudding"," "};
    String[] dinner014 = {"Vichyssoise Lentil Loaf","Roasted Potatoes Mustard","Carrots Spinach Bread","Rice Milk"," "};
    String[] snacks014 = {"None"," "};
    breakfast04.setLines(breakfast014);
    lunch04.setLines(lunch014);
    dinner04.setLines(dinner014);
    snacks04.setLines(snacks014);
    Item[] day014 = {breakfast04, lunch04, dinner04, snacks04};
    Day day04 = new Day();
    day04.setMeals(day014);

    Item breakfast05 = new Item();
    Item lunch05 = new Item();
    Item dinner05 = new Item();
    Item snacks05 = new Item();

    // Day 5
    String[] breakfast015 = {"Scrambled Eggs Soy","Wheat Crepes with","Strawberries Chocolate","Rice Milk"," "};
    String[] lunch015 = {"Crunchy Confetti Salad Lentil","Loaf Sandwich Garlic Mashed","Potatoes Saute´ed Spinach","with Garlic Soy Vanilla Pudding"," "};
    String[] dinner015 = {"Lettuce Wedges Silky","Salad Dressing Thin Crust","Veggie Pizza Tomato and","Bakon Pasta Rice Milk","Chess Pie"," "};
    String[] snacks015 = {"Chocolate Biscotti"," "};
    breakfast05.setLines(breakfast015);
    lunch05.setLines(lunch015);
    dinner05.setLines(dinner015);
    snacks05.setLines(snacks015);
    Item[] day015 = {breakfast05, lunch05, dinner05, snacks05};
    Day day05 = new Day();
    day05.setMeals(day015);

    Item breakfast06 = new Item();
    Item lunch06 = new Item();
    Item dinner06 = new Item();
    Item snacks06 = new Item();

    // Day 6
    String[] breakfast016 = {"Tofu Bakon Sweet","Potato Pancake Peanut","Butter Maple Topping","Vanilla Soy Milk"," "};
    String[] lunch016 = {"Black Bean Chili Herb Biscuit","Fresh Tomato Juice with Basil","Mocha Pudding Cake"," "};
    String[] dinner016 = {"Seitan Fajitas Sweet","Potato and Red Pepper","Home FriesWhole Wheat","Tortillas Pinto Bean Dip","Carrot Juice"," "};
    String[] snacks016 = {"Flourless PB","Cookies"," "};
    breakfast06.setLines(breakfast016);
    lunch06.setLines(lunch016);
    dinner06.setLines(dinner016);
    snacks06.setLines(snacks016);
    Item[] day016 = {breakfast06, lunch06, dinner06, snacks06};
    Day day06 = new Day();
    day06.setMeals(day016);

    Item breakfast07 = new Item();
    Item lunch07 = new Item();
    Item dinner07 = new Item();
    Item snacks07 = new Item();

    // Day 7
    String[] breakfast017 = {"Tofu Bakon Scrambled","Eggs Cinnamon","Sunrise Bread Baked","Potatoes Chocolate","Rice Milk"," "};
    String[] lunch017 = {"Spinach and Tomato Crouton","Salad Calzone Pasta with","Bolognese Style Seitan Sauce","Carrot Juice Pinto Bean Pie"," "};
    String[] dinner017 = {"Cream of Potato and","Spinach Soup Meatless","Meatballs White Sauce","with Mushrooms Raggedy","Rice Patties Steamed","Peas Bread Pudding"," "};
    String[] snacks017 = {"Sweet Potato","Fries"," "};
    breakfast07.setLines(breakfast017);
    lunch07.setLines(lunch017);
    dinner07.setLines(dinner017);
    snacks07.setLines(snacks017);
    Item[] day017 = {breakfast07, lunch07, dinner07, snacks07};
    Day day07 = new Day();
    day07.setMeals(day017);

    Item breakfast08 = new Item();
    Item lunch08 = new Item();
    Item dinner08 = new Item();
    Item snacks08 = new Item();

    // Day 8
    String[] breakfast018 = {"Scrambled Eggs","Vegetarian Sausage","Carrot Hash Browns","Soy Mocha Beverage"," "};
    String[] lunch018 = {"African Sweet Potato & Peanut","Soup Lasagna Lettuce Wedges","Silky Salad Dressing Rice Milk"," "};
    String[] dinner018 = {"White Bean Sweet Potato","and Pepper Ragout","Vegetarian Loaf with","Carrots and Gravy","Spinach Bread Vanilla Soy","Milk"," "};
    String[] snacks018 = {"Gingerbread","Cookies"," "};
    breakfast08.setLines(breakfast018);
    lunch08.setLines(lunch018);
    dinner08.setLines(dinner018);
    snacks08.setLines(snacks018);
    Item[] day018 = {breakfast08, lunch08, dinner08, snacks08};
    Day day08 = new Day();
    day08.setMeals(day018);

    Item breakfast09 = new Item();
    Item lunch09 = new Item();
    Item dinner09 = new Item();
    Item snacks09 = new Item();

    // Day 9
    String[] breakfast019 = {"Scrambled Tofu","Pancakes Peanut","Butter Maple Topping","Vanilla Soy Milk"," "};
    String[] lunch019 = {"Sloppy Joes Spicy Oven Fries","Fresh Tomato Juice with Basil","Rice Pudding"," "};
    String[] dinner019 = {"Lentil and Spinach Soup","Wheat Pasta Arrabbiata","Pasta Sauce Thin Crus","Veggie Pizza Fresh","Tomato Juice with Basil","PB Chocolate Tofu","Pudding"," "};
    String[] snacks019 = {"Chocolate Peanut","Butter Milkshake"," "};
    breakfast09.setLines(breakfast019);
    lunch09.setLines(lunch019);
    dinner09.setLines(dinner019);
    snacks09.setLines(snacks019);
    Item[] day019 = {breakfast09, lunch09, dinner09, snacks09};
    Day day09 = new Day();
    day09.setMeals(day019);

    Item breakfast00 = new Item();
    Item lunch00 = new Item();
    Item dinner00 = new Item();
    Item snacks00 = new Item();

    // Day 10
    String[] breakfast020 = {"Scrambled Eggs","Cinnamon French Toast","Maple Syrup Rice Milk"," "};
    String[] lunch020 = {"Thai Pizza Asian Coleslaw","Chocolate Ice Cream Caramel","Topping Carrot Juice"," "};
    String[] dinner020 = {"Hearty Noodle Soup","Seitan Stir Fry Brown Rice","Vanilla Soy Milk"," "};
    String[] snacks020 = {"Mock Chicken","Salad Whole","Wheat Tortillas"," "};
    breakfast00.setLines(breakfast020);
    lunch00.setLines(lunch020);
    dinner00.setLines(dinner020);
    snacks00.setLines(snacks020);
    Item[] day020 = {breakfast00, lunch00, dinner00, snacks00};
    Day day010 = new Day();
    day010.setMeals(day020);
    
    //setting the menu
    vegetarian_menu[0] = day01;
    vegetarian_menu[1] = day02;
    vegetarian_menu[2] = day03;
    vegetarian_menu[3] = day04;
    vegetarian_menu[4] = day05;
    vegetarian_menu[5] = day06;
    vegetarian_menu[6] = day07;
    vegetarian_menu[7] = day08;
    vegetarian_menu[8] = day09;
    vegetarian_menu[9] = day010;
  }

  public void veggiOut()
  {
    System.out.println("---------------------------------------Vegetarian Menu-------------------------------------");
          System.out.println("Breakfast               Lunch                           Dinner                      Snacks");
          for (int i=0; i<10; i++)
          {
            Day day = vegetarian_menu[i];
            int k=0;
            int check1=0, check2=0, check3=0, check4=0;
            System.out.println("--------------------------------------------Day " + (i+1) + "------------------------------------------");
            for (int j=0; j<7; j++)
            {
            //breakfast
              Item item1 = day.getMeal(0);
              if(check1==0 && !item1.getLine(k).equals(" "))
              {
                int a = item1.getLine(k).length();
                String str = " ";
                String repeated = str.repeat(24-a);
                System.out.print(item1.getLine(k) + repeated);
              }
              else
              {
                String str = " ";
                String repeated = str.repeat(24);
                System.out.print(repeated);
                check1=1;
              }
            //lunch
              Item item2 = day.getMeal(1);
              if(check2==0 && !item2.getLine(k).equals(" "))
              {
                int a = item2.getLine(k).length();
                String str = " ";
                String repeated = str.repeat(32-a);
                System.out.print(item2.getLine(k) + repeated);
              }
              else
              {
                String str = " ";
                String repeated = str.repeat(32);
                System.out.print(repeated);
                check2=1;
              }
            // dinner
              Item item3 = day.getMeal(2);
              if(check3==0 && !item3.getLine(k).equals(" "))
              {
                int a = item3.getLine(k).length();
                String str = " ";
                String repeated = str.repeat(28-a);
                System.out.print(item3.getLine(k) + repeated);
              }
              else
              {
                String str = " ";
                String repeated = str.repeat(28);
                System.out.print(repeated);
                check3=1;
              }
            //snacks
              Item item4 = day.getMeal(3);
              if(check4==0 && !item4.getLine(k).equals(" "))
              {
                int a = item4.getLine(k).length();
                String str = " ";
                String repeated = str.repeat(19-a);
                System.out.print(item4.getLine(k) + repeated);
              }
              else
              {
                String str = " ";
                String repeated = str.repeat(19);
                System.out.print(repeated);
                check4=1;
              }

            k++;
            System.out.println("");
            }
          }
  }

  public void mixedOut()
  {
    System.out.println("--------------------------------------------------------Mixed Menu--------------------------------------------------");
          System.out.println("Breakfast                  Lunch                              Dinner                            Snacks");
          for (int i=0; i<10; i++)
          {
            Day day = mixed_menu[i];
            int k=0;
            int check1=0, check2=0, check3=0, check4=0;
            System.out.println("---------------------------------------------------------Day " + (i+1) + "------------------------------------------------------");
            for (int j=0; j<7; j++)
            {
            //breakfast
              Item item1 = day.getMeal(0);
              if(check1==0 && !item1.getLine(k).equals(" "))
              {
                int a = item1.getLine(k).length();
                String str = " ";
                String repeated = str.repeat(28-a);
                System.out.print(item1.getLine(k) + repeated);
              }
              else
              {
                String str = " ";
                String repeated = str.repeat(28);
                System.out.print(repeated);
                check1=1;
              }
            //lunch
              Item item2 = day.getMeal(1);
              if(check2==0 && !item2.getLine(k).equals(" "))
              {
                int a = item2.getLine(k).length();
                String str = " ";
                String repeated = str.repeat(34-a);
                System.out.print(item2.getLine(k) + repeated);
              }
              else
              {
                String str = " ";
                String repeated = str.repeat(34);
                System.out.print(repeated);
                check2=1;
              }
            // dinner
              Item item3 = day.getMeal(2);
              if(check3==0 && !item3.getLine(k).equals(" "))
              {
                int a = item3.getLine(k).length();
                String str = " ";
                String repeated = str.repeat(34-a);
                System.out.print(item3.getLine(k) + repeated);
              }
              else
              {
                String str = " ";
                String repeated = str.repeat(34);
                System.out.print(repeated);
                check3=1;
              }
            //snacks
              Item item4 = day.getMeal(3);
              if(check4==0 && !item4.getLine(k).equals(" "))
              {
                int a = item4.getLine(k).length();
                String str = " ";
                String repeated = str.repeat(21-a);
                System.out.print(item4.getLine(k) + repeated);
              }
              else
              {
                String str = " ";
                String repeated = str.repeat(21);
                System.out.print(repeated);
                check4=1;
              }

            k++;
            System.out.println("");
            }
          }
  }

  public void tableSetter()
  {
    //Day 1 (Start with Mixed)
    Nutrition value0 = new Nutrition(3472.4, 469.0, 127.8, 136.7, 37.3);
    table[0] = value0;

    //Day 2
    Nutrition value1 = new Nutrition(2731.1, 395.8, 82.4, 111.6, 48.8);
    table[1] = value1;

    //Day 3
    Nutrition value2 = new Nutrition(2792.0, 496.5, 48.2, 106.8, 60.4);
    table[2] = value2;

    //Day 4
    Nutrition value3 = new Nutrition(3031.7, 508.1, 76.7, 98.6, 42.8);
    table[3] = value3;

    //Day 5
    Nutrition value4 = new Nutrition(2880.3, 366.8, 108.8, 124.4, 42.6);
    table[4] = value4;

    //Day 6
    Nutrition value5 = new Nutrition(3138.0, 411.5, 125.7, 97.5, 41.6);
    table[5] = value5;

    //Day 7
    Nutrition value6 = new Nutrition(2928.6, 444.5, 96.0, 83.2, 42.6);
    table[6] = value6;

    //Day 8
    Nutrition value7 = new Nutrition(3207.9, 449.8, 100.5, 137.1, 48.3);
    table[7] = value7;

    //Day 9
    Nutrition value8 = new Nutrition(3077.5, 446.8, 101.2, 115.8, 56.0);
    table[8] = value8;

    //Day 10
    Nutrition value9 = new Nutrition(3172.8, 474.8, 93.2, 120.9, 46.5);
    table[9] = value9;

    //Day 11
    Nutrition value10 = new Nutrition(3145.1, 501.0, 101.6, 83.1, 49.8);
    table[10] = value10;

    //Day 12
    Nutrition value11 = new Nutrition(2808.7, 461.6, 75.2, 82.8, 57.9);
    table[11] = value11;

    //Day 13
    Nutrition value12 = new Nutrition(2861.9, 434.4, 81.3, 119.2, 64.2);
    table[12] = value12;

    //Day 14
    Nutrition value13 = new Nutrition(3078.1, 559.6, 65.3, 88.3, 59.6);
    table[13] = value13;

    //Day 15
    Nutrition value14 = new Nutrition(2967.9, 427.1, 99.6, 100.0, 46.2);
    table[14] = value14;

    //Day 16
    Nutrition value15 = new Nutrition(3303.4, 490.1, 109.3, 129.5, 70.3);
    table[15] = value15;

    //Day 17
    Nutrition value16 = new Nutrition(3363.0, 542.0, 78.7, 137.3, 60.1);
    table[16] = value16;

    //Day 18
    Nutrition value17 = new Nutrition(2752.2, 406.5, 88.0, 100.9, 59.4);
    table[17] = value17;

    //Day 19
    Nutrition value18 = new Nutrition(2884.7, 443.5, 77.6, 118.5, 67.7);
    table[18] = value18;

    //Day 20
    Nutrition value19 = new Nutrition(3060.7, 371.1, 132.0, 102.8, 32.1);
    table[19] = value19;
  }

  public void tableOut()
  {
    System.out.println("---------------------------------------------Nutrition table--------------------------------------------");
    System.out.println("------------------------------------------------Mixed Menu----------------------------------------------");
    for (int i=0; i<10; i++)
    {
      System.out.print("Day " + (i+1));
      System.out.print(" Calories(kcal): " + table[i].getCal());
      System.out.print(" Carbohydrates(g): " + table[i].getCarbs());
      System.out.print(" Fat(g): " + table[i].getFat());
      System.out.print(" Protein(g): " + table[i].getProtein());
      System.out.print(" Dietary fiber(g): " + table[i].getFiber()+ "\n");
    }
    System.out.println("----------------------------------------------Vegetarian Menu-------------------------------------------");
    for (int i=10; i<20; i++)
    {
      System.out.print("Day " + (i+1));
      System.out.print(" Calories(kcal): " + table[i].getCal());
      System.out.print(" Carbohydrates(g): " + table[i].getCarbs());
      System.out.print(" Fat(g): " + table[i].getFat());
      System.out.print(" Protein(g): " + table[i].getProtein());
      System.out.print(" Dietary fiber(g): " + table[i].getFiber()+ "\n");
    }
  }

  public void BEE()
  {
    /*Formulas: For men, B.E.E. = 66.5 + (13.75 x kg) 
    + (5.003 x cm) - (6.775 x age).
    For women, B.E.E. = 655.1 + (9.563 x kg) 
    + (1.850 x cm) - (4.676 x age)*/
    if (sex == "M")
    {
      double bee = 6.5 + (13.75 * weight) + (5.003 * height) - (6.775 * age);
      System.out.println("Your B.E.E = " + bee + "\n");
    }
    else
    {
      double bee = 655.1 + (9.563 * weight) + (1.850 * height) - (4.676 * age);
      System.out.println("Your B.E.E = " + bee + "\n");
    }

  }

  public void doMath()
  {
    for (int i=0; i<20; i++)
    {
      allCalTotal += table[i].getCal();
      allCarbsTotal += table[i].getCarbs();
      allFatTotal += table[i].getFat();
      allProteinTotal += table[i].getProtein();
      allFiberTotal += table[i].getFiber();
    }
    allCalAverage = allCalTotal/20;
    allCarbsAverage = allCarbsTotal/20;
    allFatAverage = allFatTotal/20;
    allProteinAverage = allProteinTotal/20;
    allFiberAverage = allFiberTotal/20; 

    double bestError = 100;
    int bestMeal1 = -1;
    int bestMeal2 = -1;

    for (int u=0; u<20; u++)
    {
      double temp = errorCalculator(u, -1);
      if (bestError >= temp)
      {
        bestError = temp;
        bestMeal1 = u;
      }
    }

    for (int p=0; p<20; p++)
    {
      if (bestError >= errorCalculator(bestMeal1, p))
      {
        bestError = errorCalculator(bestMeal1, p);
        bestMeal2 = p;
      }
    }

    System.out.println("\nBest suitable meals are number " + bestMeal1 +
    " and number " + bestMeal2);
    System.out.println("With the total nutrition error " + bestError*100);

    for (int z=0; z<7; z++)
    {
      if (week[z]==-1)
      {
        week[z] = bestMeal1;
        break;
      }
    }
    for (int y=0; y<7; y++)
    {
      if (week[y]==-1)
      {
        week[y] = bestMeal2;
      }
    }

    System.out.println("\nYour Optimal Meal Week Plan: ");
    System.out.println("1 - Monday" + ((week[0]==-1) ? " " : (" : Meal plan picked: " + week[0])));
    System.out.println("2 - Tuesday" + ((week[1]==-1) ? " " : (" : Meal plan picked: " + week[1])));
    System.out.println("3 - Wednesday" + ((week[2]==-1) ? " " : (" : Meal plan picked: " + week[2])));
    System.out.println("4 - Thursday" + ((week[3]==-1) ? " " : (" : Meal plan picked: " + week[3])));
    System.out.println("5 - Friday" + ((week[4]==-1) ? " " : (" : Meal plan picked: " + week[4])));
    System.out.println("6 - Saturday" + ((week[5]==-1) ? " " : (" : Meal plan picked: " + week[5])));
    System.out.println("7 - Sunday" + ((week[6]==-1) ? " " : (" : Meal plan picked: " + week[6])));

    double CalAverage, CarbsAverage, FatAverage;
    double ProteinAverage, FiberAverage;

    double CalTotal = 0, CarbsTotal = 0, FatTotal = 0;
    double ProteinTotal = 0, FiberTotal = 0;

    int number = 0;
    for (int j=0; j<7; j++)
    {
      if (week[j] > 0)
      {
      CalTotal += table[week[j]].getCal();
      CarbsTotal += table[week[j]].getCarbs();
      FatTotal += table[week[j]].getFat();
      ProteinTotal += table[week[j]].getProtein();
      FiberTotal += table[week[j]].getFiber();
      number ++;
      }
    }

    CalAverage = CalTotal/number;
    CarbsAverage = CarbsTotal/number;
    FatAverage = FatTotal/number;
    ProteinAverage = ProteinTotal/number;
    FiberAverage = FiberTotal/number;

    System.out.println("\nAverage Calories(kcal): " + String.format("%.2f", CalAverage)
    + " \nAverage Carbohydrates(g): " + String.format("%.2f", CarbsAverage)
    + " \nAverage Fat(g): " + String.format("%.2f", FatAverage)
    + " \nAverage Protein(g): " + String.format("%.2f", ProteinAverage)
    + " \nAverage Dietary fiber(g): " + String.format("%.2f", FiberAverage));
  }

  public double errorCalculator(int a, int b)
  {
    double CalAverage, CarbsAverage, FatAverage;
    double ProteinAverage, FiberAverage;

    double CalTotal = 0, CarbsTotal = 0, FatTotal = 0;
    double ProteinTotal = 0, FiberTotal = 0;

    int[] sampleWeek = new int[7];

    for (int g=0; g<7; g++)
    {
      sampleWeek[g] = week[g];
    }

    for (int z=0; z<7; z++)
    {
      if (sampleWeek[z]==-1)
      {
        sampleWeek[z] = a;
        break;
      }
    }
    for (int y=0; y<7; y++)
    {
      if (sampleWeek[y]==-1)
      {
        sampleWeek[y] = b;
        break;
      }
    }
    int number = 0;
    for (int j=0; j<7; j++)
    {
      if (sampleWeek[j] > 0)
      {
      CalTotal += table[sampleWeek[j]].getCal();
      CarbsTotal += table[sampleWeek[j]].getCarbs();
      FatTotal += table[sampleWeek[j]].getFat();
      ProteinTotal += table[sampleWeek[j]].getProtein();
      FiberTotal += table[sampleWeek[j]].getFiber();
      number ++;
      }
    }

    CalAverage = CalTotal/number;
    CarbsAverage = CarbsTotal/number;
    FatAverage = FatTotal/number;
    ProteinAverage = ProteinTotal/number;
    FiberAverage = FiberTotal/number;

    double totalError =
    (Math.abs(CalAverage - allCalAverage))/allCalAverage
    + (Math.abs(CarbsAverage - allCarbsAverage))/allCarbsAverage
    + (Math.abs(FatAverage - allFatAverage))/allFatAverage
    + (Math.abs(FatAverage - allFatAverage))/allFatAverage
    + (Math.abs(FatAverage - allFatAverage))/allFatAverage;

    return totalError;
  }
} 