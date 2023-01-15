package main;

import main.tools.Tool;

import java.util.Date;

public interface ToolRental {

    public void setTool( Tool tool );

    public void setCheckoutDate( Date checkout );

    public void setRentalDuration( int duration ) throws Exception;

    public void setDiscountPercentage( int discount ) throws Exception;

    public void generateAgreement();

    public double calculateFinalCharge();

}
