import java.util.*;

public class Item
{  
  public int amount_of_lines = 0;
  public String[] lines = {" "," "," "," "," "," "," "," "};

  public int getAmount()
  {
    return amount_of_lines;
  }
  public void setAmount(int new_lines)
  {
    amount_of_lines = new_lines;
  }

  public String[] getLines()
  {
    return lines;
  }

  public void setLines(String[] new_lines)
  {
    lines = new_lines;
  }

  public void setLine(int number, String line)
  {
    lines[number] = line;
  }
  
  public String getLine(int number)
  {
    return lines[number];
  }

  public boolean hasNext()
  {
    if (lines[amount_of_lines].equals(" "))
    {
      return false;
    }
    else
    {
    amount_of_lines++;
    return true;
    }
  }
}  