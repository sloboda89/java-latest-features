package com.psv;

import java.text.NumberFormat;
import java.util.Locale;

public class CompactNumberFormatting {
    public static void main(String[] args) {
        NumberFormat numberFormat = NumberFormat.getCompactNumberInstance(new Locale("en", "US"), NumberFormat.Style.SHORT);
        numberFormat.setMaximumFractionDigits(1);

        System.out.println(numberFormat.format(2_592)); // 2.6K

        numberFormat = NumberFormat.getCompactNumberInstance(new Locale("uk", "UA"), NumberFormat.Style.SHORT);
        numberFormat.setMaximumFractionDigits(1);

        System.out.println(numberFormat.format(2_592)); // 2,6 тис.

        numberFormat = NumberFormat.getCompactNumberInstance(new Locale("en", "US"), NumberFormat.Style.LONG);
        numberFormat.setMaximumFractionDigits(2);

        System.out.println(numberFormat.format(2_019_000)); // 2.02 million

        numberFormat = NumberFormat.getCompactNumberInstance(new Locale("uk", "UA"), NumberFormat.Style.LONG);
        numberFormat.setMaximumFractionDigits(2);

        System.out.println(numberFormat.format(2_019_000)); // 2,02 мільйони

        // Old number format
        numberFormat = NumberFormat.getNumberInstance(new Locale("en", "US"));

        System.out.println(numberFormat.format(2_019_000)); // 2,019,000

        numberFormat = NumberFormat.getNumberInstance(new Locale("uk", "UA"));

        System.out.println(numberFormat.format(2_019_000)); // 2 019 000
    }
}
