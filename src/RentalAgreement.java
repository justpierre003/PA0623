


import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RentalAgreement {
    private String toolCode;
    private ToolType toolType;
    private String toolBrand;
    private int rentalDays;
    private Date checkOutDate;
    private Date dueDate;
    private double dailyRentalCharges;
    private int chargeDays;
    private double preDiscountCharge;
    private double discountPercent;
    private double discountAmount;
    private double finalCharges;

    public RentalAgreement(String toolCode, ToolType toolType, String toolBrand, int rentalDays, Date checkOutDate, Date dueDate, double dailyRentalCharges, int chargeDays, double preDiscountCharge, double discountPercent, double discountAmount, double finalCharges) {
        this.toolCode = toolCode;
        this.toolType = toolType;
        this.toolBrand = toolBrand;
        this.rentalDays = rentalDays;
        this.checkOutDate = checkOutDate;
        this.dueDate = dueDate;
        this.dailyRentalCharges = dailyRentalCharges;
        this.chargeDays = chargeDays;
        this.preDiscountCharge = preDiscountCharge;
        this.discountPercent = discountPercent;
        this.discountAmount = discountAmount;
        this.finalCharges = finalCharges;
    }

    public void printAgreement() {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
        DecimalFormat decimalFormat = new DecimalFormat("$#,###.00");
        DecimalFormat percentFormat = new DecimalFormat();
        percentFormat.setMaximumFractionDigits(0);
        System.out.println("Tool code: " + toolCode);
        System.out.println("Tool type: " + toolType.getName());
        System.out.println("Tool brand: " + toolBrand);
        System.out.println("Rental days: " + rentalDays);
        System.out.println("Check out date: " + dateFormat.format(checkOutDate));
        System.out.println("Due date: " + dateFormat.format(dueDate));
        System.out.println("Daily rental charge: " + decimalFormat.format(dailyRentalCharges));
        System.out.println("Charge days: " + chargeDays);
        System.out.println("Pre-discount charges: " + decimalFormat.format(preDiscountCharge));
        System.out.println("Discount percent: " + percentFormat.format(discountPercent) + "%");
        System.out.println("Discount amount: " + decimalFormat.format(discountAmount));
        System.out.println("Final charges: " + decimalFormat.format(finalCharges));
    }

    public String getToolCode() {
        return toolCode;
    }

    public ToolType getToolType() {
        return toolType;
    }

    public String getToolBrand() {
        return toolBrand;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public double getDailyRentalCharges() {
        return dailyRentalCharges;
    }

    public int getChargeDays() {
        return chargeDays;
    }

    public double getPreDiscountCharge() {
        return preDiscountCharge;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public double getFinalCharges() {
        return finalCharges;
    }
}
