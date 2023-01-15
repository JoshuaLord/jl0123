package main.tools.types;

public class Chainsaw implements ToolType {

    @Override
    public String getType() {
        return "Chainsaw";
    }

    @Override
    public double getDailyCharge() {
        return 1.49;
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
        return true;
    }
}
