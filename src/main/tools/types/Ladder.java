package main.tools.types;

public class Ladder implements ToolType {
    @Override
    public String getType() {
        return "Ladder";
    }

    @Override
    public double getDailyCharge() {
        return 1.99;
    }

    @Override
    public boolean getWeekdayCharge() {
        return true;
    }

    @Override
    public boolean getWeekendCharge() {
        return true;
    }

    @Override
    public boolean getHolidayCharge() {
        return false;
    }
}
