package dates;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DateTime {
    public static void main(String[] args) {
        BigDecimal num1 = new BigDecimal("7");
        BigDecimal num2 = new BigDecimal("3");
        System.out.println(num1.divide(num2, 2, RoundingMode.HALF_UP));
    }
}
