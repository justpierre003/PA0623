import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.*;

class CheckoutTest {

    DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
    Checkout checkout = new Checkout();
    String res ="";

    @org.junit.jupiter.api.Test
    void test1() throws ParseException {

        String res = checkout.doCheckOut("JAKR",5, 101,formatter.parse("9/3/15"));
        assertEquals(res, "Discount percent must be between 0 and 100!");
    }

    @org.junit.jupiter.api.Test
    void test2() throws ParseException {

        res = checkout.doCheckOut("LADW",3, 10,formatter.parse("7/2/20"));
        assertEquals(res,"success");

    }

    @org.junit.jupiter.api.Test
    void test3() throws ParseException {

        res = checkout.doCheckOut("CHNS",5, 25,formatter.parse("7/2/15"));
        assertEquals(res,"success");

    }

    @org.junit.jupiter.api.Test
    void test4() throws ParseException {

        res = checkout.doCheckOut("JAKD",6, 0,formatter.parse("9/3/15"));
        assertEquals(res,"success");

    }

    @org.junit.jupiter.api.Test
    void test5() throws ParseException {
        res = checkout.doCheckOut("JAKR",9, 0,formatter.parse("7/2/15"));
        assertEquals(res,"success");

    }

    @org.junit.jupiter.api.Test
    void test6() throws ParseException {

        res = checkout.doCheckOut("JAKR",4, 50,formatter.parse("7/2/20"));
        assertEquals(res,"success");

    }




}