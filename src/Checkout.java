import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Checkout {

    public String doCheckOut( String toolCode, int rentalDays, double discountPercent, Date checkoutDate ){

        ToolType ladder = new ToolType("Ladder", 1.99, true, true, false);
        ToolType chainsaw = new ToolType("Chainsaw", 1.49, true, false, true);
        ToolType jackhammer = new ToolType("Jackhammer", 2.99, true, false, false);

        Map<String, Tool> tools = new HashMap<>(4);
        tools.put("CHNS", new Tool("CHNS", chainsaw, "Stihl"));
        tools.put("LADW", new Tool("LADW", ladder, "Werner"));
        tools.put("JAKD", new Tool("JAKD", jackhammer, "DeWalt"));
        tools.put("JAKR", new Tool("JAKR", jackhammer, "Ridgid"));

        DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);


        Tool tool = tools.getOrDefault(toolCode, null);
        if (tool == null) {
            System.out.println("Tool with code " + toolCode + " does not exist");
            return "Tool with code " + toolCode + " does not exist";
        }

        if (discountPercent < 0 || discountPercent > 100) {
            return "Discount percent must be between 0 and 100!";
        }
        if (rentalDays < 1) {
            return "Rental days must be 1 or greater!";
        }

        calendar.setTime(checkoutDate);
        calendar.add(Calendar.DAY_OF_MONTH, rentalDays);
        Date dueDate = calendar.getTime();

        ToolType toolType = tool.getType();
        calendar.setTime(checkoutDate);
        int chargeDays = 0;
        for (int i = 0; i < rentalDays; i++) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            int date_of_week = calendar.get(Calendar.DAY_OF_WEEK);
            if (calendar.get(Calendar.DAY_OF_MONTH) == 5 && calendar.get(Calendar.MONTH) == Calendar.JULY || date_of_week == 3 && calendar.get(Calendar.DAY_OF_MONTH) <= 7 && calendar.get(Calendar.MONTH) == Calendar.SEPTEMBER) {
                if (toolType.isHolidayCharge())
                    chargeDays++;
            } else if (date_of_week >= Calendar.MONDAY && date_of_week <= Calendar.FRIDAY) {
                if (toolType.isWeekdayCharge())
                    chargeDays++;
            } else if (date_of_week == Calendar.SUNDAY || date_of_week == Calendar.SATURDAY) {
                if (toolType.isWeekendCharge())
                    chargeDays++;
            }
        }

        double preDiscountCharge = chargeDays * toolType.getDailyCharges();
        double discountAmount = discountPercent * preDiscountCharge / 100;
        double finalCharge = preDiscountCharge - discountAmount;

        RentalAgreement agreement = new RentalAgreement(
                toolCode,
                toolType,
                tool.getBrand(),
                rentalDays,
                checkoutDate,
                dueDate,
                tool.getType().getDailyCharges(),
                chargeDays,
                preDiscountCharge,
                discountPercent,
                discountAmount,
                finalCharge
        );
        agreement.printAgreement();
        return "success";

    }
}
