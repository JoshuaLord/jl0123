package main.tools.types;

public interface ToolType {

    public String getType();
    public double getDailyCharge();
    public boolean getWeekdayCharge();
    public boolean getWeekendCharge();
    public boolean getHolidayCharge();
}
