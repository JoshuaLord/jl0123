package main;

import main.tools.Tool;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DefaultToolRental implements ToolRental {

    private Tool tool;
    private Date checkout;
    private int duration;
    private int discount;
    private SimpleDateFormat dateFormatter;
    Calendar calendar;
    private Date dueDate;

    private HolidayManager holidayManager;
    private NumberFormat currencyFormatter;

    public DefaultToolRental() {
        dateFormatter = new SimpleDateFormat( "MM-dd-yy" );
        calendar = Calendar.getInstance();
        holidayManager = new HolidayManager();
        currencyFormatter = NumberFormat.getCurrencyInstance();
    }

    @Override
    public void setTool( Tool tool ) {
        this.tool = tool;
    }

    @Override
    public void setCheckoutDate(Date checkout) {
        this.checkout = checkout;

        calendar.setTime( checkout );
        calendar.add(Calendar.DATE, duration);

        this.dueDate = calendar.getTime();
    }

    @Override
    public void setRentalDuration(int duration) throws Exception {
        if ( duration < 1 )
            throw new Exception( "Rental day count is not 1 or greater" );

        this.duration = duration;

        setCheckoutDate( checkout );
    }

    @Override
    public void setDiscountPercentage(int discount) throws Exception {
        if ( discount < 0 || discount > 100)
            throw new Exception( "Discount percent is not in the range 0 - 100" );

        this.discount = discount;
    }

    @Override
    public void generateAgreement() {
        System.out.println("---------------------------------");
        System.out.println( "Tool code: " + tool.getCode() );
        System.out.println( "Tool type: " + tool.getToolType().getType() );
        System.out.println( "Tool brand: " + tool.getBrand().getName() );
        System.out.println( "Rental days: " + duration );
        System.out.println( "Checkout date: " + formatDate( checkout ) );
        System.out.println( "Due date: " + formatDate(dueDate) );
        System.out.println( "Daily rental charge: " + formatCurrency( tool.getToolType().getDailyCharge() ) );
        System.out.println( "Charge days: " + getChargeDays() );
        System.out.println( "Pre-discount charge: " + formatCurrency( getPreDiscountCharge() ) );
        System.out.println( "Discount percent: " + formatDiscount() );
        System.out.println( "Discount amount: " + formatCurrency( calculateDiscountAmount() ) );
        System.out.println( "Final amount: " + formatCurrency( calculateFinalCharge() ) );
    }

    private String formatDate( Date date ) {
        return dateFormatter.format( date );
    }

    private int getChargeDays() {
        int chargeDays = 0;
        boolean chargeWeekdays = tool.getToolType().getWeekdayCharge();
        boolean chargeWeekend = tool.getToolType().getWeekendCharge();
        boolean chargeHolidays = tool.getToolType().getHolidayCharge();

        calendar.setTime( checkout );

        while ( !(calendar.getTime()).after(dueDate) ) {
            int dayOfWeek = calendar.get( Calendar.DAY_OF_WEEK );

            if ( holidayManager.isHoliday( calendar.getTime() ) ) {
                if (chargeHolidays) {
                    chargeDays++;
                }
            } else if ( (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY) ) {
                if (chargeWeekend) {
                    chargeDays++;
                }
            } else {
                if (chargeWeekdays) {
                    chargeDays++;
                }
            }

            calendar.add(Calendar.DATE, 1);
        }

        return chargeDays;
    }

    private String formatCurrency( double amount ) {
        return currencyFormatter.format( amount );
    }

    private String formatDiscount() {
        return String.format( "%02d", discount ) + "%";
    }

    private double getPreDiscountCharge() {
        return tool.getToolType().getDailyCharge() * getChargeDays();
    }

    private double calculateDiscountAmount() {
        double preDiscountCharge = getPreDiscountCharge();
        return preDiscountCharge * ( discount / 100.0 );
    }

    public double calculateFinalCharge() {
        double preDiscountCharge = getPreDiscountCharge();
        double discountAmount = calculateDiscountAmount();
        return preDiscountCharge - discountAmount;
    }


}
