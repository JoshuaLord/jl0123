package test;

import main.HolidayManager;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HolidayManagerTest {

    HolidayManager holidayManager = new HolidayManager();

    @Test
    public void testIsHoliday() {

        Calendar calendar = Calendar.getInstance();

        calendar.set(2023, Calendar.SEPTEMBER, 4);
        assertTrue( holidayManager.isHoliday( calendar.getTime() ) );

        calendar.set( 2023, Calendar.JULY, 4);
        assertTrue( holidayManager.isHoliday( calendar.getTime() ) );

        calendar.set( 2023, Calendar.SEPTEMBER, 3);
        assertFalse( holidayManager.isHoliday( calendar.getTime() ) );

        calendar.set( 2023, Calendar.JULY, 3);
        assertFalse( holidayManager.isHoliday( calendar.getTime() ) );

    }

}
