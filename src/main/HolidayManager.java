package main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class HolidayManager {

    public boolean isHoliday( Date date ) {
        Calendar current = Calendar.getInstance();
        current.setTime( date );

        // check independence day
        if ( isDateOnIndependenceDay( current ) ) {
            return true;
        }

        // check labor day
        if ( isDateOnLaborDay( current ) )
            return true;

        return false;
    }

    private boolean isDateOnIndependenceDay( Calendar current ) {
        Calendar independenceDay = getIndependenceDayOnYear( current.get( Calendar.YEAR ) );
        return areDatesEqual( current , independenceDay );
    }

    private boolean isDateOnLaborDay( Calendar current ) {
        Calendar laborDay = getLaborDayOnYear( current.get( Calendar.YEAR ) );
        return areDatesEqual( current , laborDay );
    }

    private Calendar getLaborDayOnYear( int year ) {
        Calendar cal = Calendar.getInstance();
        cal.set( Calendar.DAY_OF_WEEK, Calendar.MONDAY );
        cal.set( Calendar.DAY_OF_WEEK_IN_MONTH, 1 );
        cal.set( Calendar.MONTH, Calendar.SEPTEMBER );
        cal.set( Calendar.YEAR, year );
        return cal;
    }

    private Calendar getIndependenceDayOnYear( int year ) {
        Calendar cal = Calendar.getInstance();
        cal.set( Calendar.DATE, 4 );
        cal.set( Calendar.MONTH, Calendar.JULY );
        cal.set( Calendar.YEAR, year );

        final int DAY_OF_WEEK = cal.get( Calendar.DAY_OF_WEEK );

        if ( DAY_OF_WEEK == Calendar.SATURDAY ) {
            cal.add( Calendar.DATE, -1 );
        } else if ( DAY_OF_WEEK == Calendar.SUNDAY ) {
            cal.add( Calendar.DATE, 1 );
        }

        return cal;
    }

    private boolean areDatesEqual( Calendar one, Calendar two) {
        if ( one.get(Calendar.YEAR) == two.get(Calendar.YEAR) &&
             one.get(Calendar.MONTH) == two.get(Calendar.MONTH) &&
             one.get(Calendar.DATE) == two.get(Calendar.DATE) ) {
            return true;
        }
        return false;
    }


}
