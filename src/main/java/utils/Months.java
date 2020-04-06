package utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yakimfb
 * @since 18.03.20
 **/
public class Months
{
    private final Map<String, String> months;
    private static Months monthsInstance;

    private Months()
    {
        months = new HashMap<>();
        months.put( "january",
                    "1" );
        months.put( "february",
                    "2" );
        months.put( "march",
                    "3" );
        months.put( "april",
                    "4" );
        months.put( "may",
                    "5" );
        months.put( "june",
                    "6" );
        months.put( "july",
                    "7" );
        months.put( "august",
                    "8" );
        months.put( "september",
                    "9" );
        months.put( "october",
                    "10" );
        months.put( "november",
                    "11" );
        months.put( "december",
                    "12" );
    }

    public static Months getMonths()
    {
        if ( monthsInstance == null )
        {
            monthsInstance = new Months();
        }

        return monthsInstance;
    }

    public String valueOf(String month )
    {
        return this.months.get( month.toLowerCase() );
    }

}
