package androidsamples.java.whatday;

import androidx.annotation.NonNull;

import java.util.Calendar;

/**
 * Represents the date to be set, whether it is a valid date, and the message with error status or the day of the week.
 */
public class DateModel {

  /**
   * Initializes the {@link DateModel} with the given year, month, and date.
   * If the date is not valid, it sets the appropriate error message.
   * If it is valid, it sets the appropriate day of the week message.
   *
   * @param yearStr  a {@code String} representing the year, e.g., "1947"
   * @param monthStr a {@code String} representing the month, e.g., "8"
   * @param dateStr  a {@code String} representing the date, e.g., "15"
   */

  static String dateStr;
  static String monthStr;
  static String yearStr;

  public DateModel(String yearStr, String monthStr, String dateStr)
  {
    initialize(yearStr,monthStr,dateStr);
  }

  public static void initialize(String yearStr, String monthStr, String dateStr) {
    // TODO implement the method to match the description

    DateModel.yearStr=yearStr;
    DateModel.dateStr=dateStr;
    DateModel.monthStr=monthStr;
  }

  private static boolean checkLeap(String yearStr)
  {
    int yr=Integer.parseInt(yearStr);

    if(yr%400==0)
      return true;

    if(yr%100==0)
      return false;

    return (yr % 4 == 0);
  }

  private static boolean checkNum(String input)
  {
    if(input.isEmpty())
      return false;
    try
    {
      int flag=Integer.parseInt(input);
    }
    catch(NumberFormatException nfe)
    {
      return false;
    }
    return true;
  }

  /**
   * Retrieves the message from the {@link DateModel}.
   * It can be an error message like "February of 2019 does not have 29 days"
   * or a success message like "Friday".
   *
   * @return the message from the model
   */
  @NonNull
  public static String getMessage() {
    // TODO implement the method to match the description
    String message;

    if(!(checkNum(dateStr) && checkNum(yearStr) && checkNum(monthStr)))
    {
      message="Enter values in a proper numeric format";
      return message;
    }

    int date=Integer.parseInt(dateStr);
    int month=Integer.parseInt(monthStr);
    int year=Integer.parseInt(yearStr);

    if(year<=0)
    {
      message="Invalid year";
    }
    else if(month<1 || month>12)
    {
      message="Invalid month";
    }
    else if(date<1 || date>31)
    {
      message="Invalid date";
    }
    else if(dateStr.equals("31") && (monthStr.equals("2") || monthStr.equals("4") ||
            monthStr.equals("6")|| monthStr.equals("9") || monthStr.equals("11")))
    {
      message="This month does not have 31 days";
    }
    else if(dateStr.equals("30") && monthStr.equals("2"))
    {
      message="This month does not have 30 days";
    }
    else if(dateStr.equals("29") && monthStr.equals("2") && !checkLeap(yearStr))
    {
      message="February of " + yearStr + " does not have 29 days";
    }
    else
    {
      String []days = new String[]{"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};

      Calendar c = Calendar.getInstance();
      c.set(year,month-1, date);
      int dayOfWeek=c.get(Calendar.DAY_OF_WEEK);

      message = days[dayOfWeek-1];
    }

    return message;
  }

}
