package test;

import main.DefaultToolRental;
import main.ToolRental;
import main.tools.Tool;
import main.tools.ToolFactory;
import main.tools.DefaultToolFactory;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class DefaultToolRentalTest {

    private static final double DELTA = 1e-15;
    ToolFactory toolFactory = new DefaultToolFactory();

    @Test
    public void one() {

        Tool tool = toolFactory.generateTool( "JAKR" );
        Date checkout = new Date( "09/03/15" );
        int duration = 5;
        int discount = 101;

        try {

            ToolRental rental = new DefaultToolRental();
            rental.setTool(tool);
            rental.setCheckoutDate(checkout);
            rental.setRentalDuration(duration);
            rental.setDiscountPercentage(discount);

            rental.generateAgreement();

            fail();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() );
        }

    }

    @Test
    public void two() {

        Tool tool = toolFactory.generateTool( "LADW" );
        Date checkout = new Date( "07/02/20" );
        int duration = 3;
        int discount = 10;

        try {

            ToolRental rental = new DefaultToolRental();
            rental.setTool(tool);
            rental.setCheckoutDate(checkout);
            rental.setRentalDuration(duration);
            rental.setDiscountPercentage(discount);

            rental.generateAgreement();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() );
            fail();
        }

    }

    @Test
    public void three() {

        Tool tool = toolFactory.generateTool( "CHNS" );
        Date checkout = new Date( "07/02/15" );
        int duration = 5;
        int discount = 25;

        try {

            ToolRental rental = new DefaultToolRental();
            rental.setTool(tool);
            rental.setCheckoutDate(checkout);
            rental.setRentalDuration(duration);
            rental.setDiscountPercentage(discount);

            rental.generateAgreement();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() );
            fail();
        }

    }

    @Test
    public void four() {

        Tool tool = toolFactory.generateTool( "JAKD" );
        Date checkout = new Date( "09/03/15" );
        int duration = 6;
        int discount = 0;

        try {

            ToolRental rental = new DefaultToolRental();
            rental.setTool(tool);
            rental.setCheckoutDate(checkout);
            rental.setRentalDuration(duration);
            rental.setDiscountPercentage(discount);

            rental.generateAgreement();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() );
            fail();
        }

    }

    @Test
    public void five() {

        Tool tool = toolFactory.generateTool( "JAKR" );
        Date checkout = new Date( "07/02/15" );
        int duration = 9;
        int discount = 0;

        try {

            ToolRental rental = new DefaultToolRental();
            rental.setTool(tool);
            rental.setCheckoutDate(checkout);
            rental.setRentalDuration(duration);
            rental.setDiscountPercentage(discount);

            rental.generateAgreement();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() );
            fail();
        }

    }

    @Test
    public void six() {

        Tool tool = toolFactory.generateTool( "JAKR" );
        Date checkout = new Date( "07/02/20" );
        int duration = 4;
        int discount = 20;

        try {

            ToolRental rental = new DefaultToolRental();
            rental.setTool(tool);
            rental.setCheckoutDate(checkout);
            rental.setRentalDuration(duration);
            rental.setDiscountPercentage(discount);

            rental.generateAgreement();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() );
            fail();
        }

    }

    @Test
    public void testLaborDay() {
        Tool tool = toolFactory.generateTool( "JAKR" );
        Date checkout = new Date( "09/04/23" );
        int duration = 1;
        int discount = 0;

        try {

            ToolRental rental = new DefaultToolRental();
            rental.setTool(tool);
            rental.setCheckoutDate(checkout);
            rental.setRentalDuration(duration);
            rental.setDiscountPercentage(discount);

            double charge = rental.calculateFinalCharge();

            assertEquals( 2.99, charge, DELTA );

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() );
            fail();
        }
    }

    @Test
    public void testIndependenceDay() {

        Tool tool = toolFactory.generateTool( "LADW" );
        // independence day falls on a tuesday
        Date checkout = new Date( "07/03/2023" );
        int duration = 1;
        int discount = 0;

        try {

            ToolRental rental = new DefaultToolRental();
            rental.setTool(tool);
            rental.setCheckoutDate(checkout);
            rental.setRentalDuration(duration);
            rental.setDiscountPercentage(discount);

            double charge = rental.calculateFinalCharge();

            assertEquals( 1.99, charge, DELTA );

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() );
            fail();
        }

        tool = toolFactory.generateTool( "CHNS" );

        try {

            ToolRental rental = new DefaultToolRental();
            rental.setTool(tool);
            rental.setCheckoutDate(checkout);
            rental.setRentalDuration(duration);
            rental.setDiscountPercentage(discount);

            // Chainsaw charges on holidays
            double charge = rental.calculateFinalCharge();

            assertEquals( 2.98, charge, DELTA );

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() );
            fail();
        }

        tool = toolFactory.generateTool( "LADW" );
        // independence day falls on a saturday, so the discount is applied on friday
        checkout = new Date( "07/02/2020" ); // thursday, friday

        try {

            ToolRental rental = new DefaultToolRental();
            rental.setTool(tool);
            rental.setCheckoutDate(checkout);
            rental.setRentalDuration(duration);
            rental.setDiscountPercentage(discount);

            double charge = rental.calculateFinalCharge();

            assertEquals( 1.99, charge, DELTA );

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() );
            fail();
        }
    }
}
