/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softapple.online.doctor.common.enums;

/**
 *
 * @author Md. Zakir Hossain
 */
public enum YearMonth {
    JANUARY("January"),
    FEBRUARY("February"),
    MARCH("March"),
    APRIL("April"),
    MAY("May"),
    JUNE("June"),
    JULY("July"),
    AUGUST("August"),
    SEPTEMBER("September"),
    OCTOBER("October"),
    NOVEMBER("November"),
    DECEMBER("December");

    private final String monthName;

    private YearMonth(String monthName) {
        this.monthName = monthName;
    }

    public String getMonthName() {
        return monthName;
    }    
}
