package main.tools.types;

public class Jackhammer implements ToolType {
    @Override
    public String getType() {
        return "Jackhammer";
    }

    @Override
    public double getDailyCharge() {
        return 2.99;
    }

    @Override
    public boolean getWeekdayCharge() {
        return true;
    }

    @Override
    public boolean getWeekendCharge() {
        return false;
    }

    @Override
    public boolean getHolidayCharge() {
        return false;
    }
}
