package com.psv;

import java.time.Month;
import java.util.Arrays;

public class SwitchExpressions {

    public static void main(String[] args) {
        Arrays.stream(Month.values())
                .forEach(SwitchExpressions::newSwitch);
        Arrays.stream(Month.values())
                .forEach(SwitchExpressions::oldSwitch);
    }

    private static void newSwitch(Month month) {
        String season = switch (month) {
            case DECEMBER, JANUARY, FEBRUARY -> "WINTER";
            case MARCH, APRIL, MAY -> "SPRING";
            case JUNE, JULY, AUGUST -> "SUMMER";
            default -> {
                if (month == null) {
                    yield "SOMETHING STRANGE";
                } else {
                    yield  "FALL";
                }
            }
        };

        System.out.println("Outside %s".formatted(season));
    }

    private static void oldSwitch(Month month) {
        String season;
        switch (month) {
            case DECEMBER:
            case JANUARY:
            case FEBRUARY:
                season = "WINTER";
                break;
            case MARCH:
            case APRIL:
            case MAY:
                season = "SPRING";
                break;
            case JUNE:
            case JULY:
            case AUGUST:
                season = "SUMMER";
                break;
            default:
                if (month == null) {
                    season = "SOMETHING STRANGE";
                } else {
                    season = "FALL";
                }
        }

        System.out.println("Outside %s".formatted(season));
    }
}
