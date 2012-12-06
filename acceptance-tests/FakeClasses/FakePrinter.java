package FakeClasses;

import com.acmetelecom.Printer;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FakePrinter implements Printer
{

    private StringBuilder output = new StringBuilder();

    @Override
    public void printHeading(String name, String phoneNumber, String pricePlan)
    {
        output.append("Customer: " + phoneNumber + "\n");
    }

    @Override
    public void printItem(String time, String callee, String duration,
                          String cost)
    {
        Date date;
        DateFormat dateFormat = SimpleDateFormat.getInstance();

        try
        {
            date = dateFormat.parse(time);
        }
        catch (ParseException ex)
        {
            throw new IllegalArgumentException("Date string \"" + time + "\" was not in default date format");
        }

        SimpleDateFormat dateFormat24H = new SimpleDateFormat("HH:mm");

        output.append("Call to " + callee + " at " + dateFormat24H.format(date) + " for " + duration + " = " + cost + "\n");
    }

    @Override
    public void printTotal(String total)
    {
        output.append("Total Charge = " + total + "\n");
    }

    public String output()
    {
        return output.toString();
    }

    public void clearOutput()
    {
        output = new StringBuilder();
    }

}
