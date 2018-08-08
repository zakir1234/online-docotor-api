/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softapple.online.doctor.common.utils;

import java.io.InputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 *
 * @author Md. Zakir Hossain
 */
public class ApplicationUtils {
    public static final String MALE = "Male";
    public static final String FEMALE = "Female";
    public static final String ISLAM = "Islam";
    public static final String HINDU = "Hindu";
    public static final String BOUDDHA = "Bouddha";
    public static final String CHRISTIAN = "Christian";
    public static final String OTHERS = "Others";

    public static final String ENABLED_MESSAGE = "Enabled";
    public static final String DISABLED_MESSAGE = "Disabled";
    public static final String WEEK_DAYS[] = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    public static final String[] customerSupportRole={"ROLE_ACCOUNTANT","ROLE_ADMIN","ROLE_OPERATOR","ROLE_TEACHER","ROLE_NETIZENSUPPORT"};
    public static final String[] instituteRoles={"ROLE_ACCOUNTANT","ROLE_ADMIN","ROLE_OPERATOR","ROLE_TEACHER"};
    
    private static final Logger logger = Logger.getLogger(ApplicationUtils.class);

    public static Date parseStringToDate(String stringDate) {
        Date date = null;
        try {
            date = new SimpleDateFormat("dd-MM-yyyy").parse(stringDate);
        } catch (ParseException e) {
            logger.error(e);
        }
        return date;
    }

    public static Date parseStringToTime(String stringTime) {
        Date date = null;
        try {
            date = new SimpleDateFormat("hh:mm:ss").parse(stringTime);
        } catch (ParseException e) {
            logger.error(e);
        }
        return date;
    }

    public static Date currentDate() {
        return new Date();
    }

    public static String getMonthNumberByMonthName(String monthName) {
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(new SimpleDateFormat("MMMM", Locale.ENGLISH).parse(monthName));
        } catch (ParseException ex) {
        }

        String monthNo = String.valueOf((cal.get(Calendar.MONTH) + 1));

        if (String.valueOf(monthNo).length() < 2) {
            monthNo = "0" + monthNo;
        }

        return monthNo;
    }

    public static String getCoreSettingTypeName(int typeId) {
        String typeName = "";

        switch (typeId) {
            case 2101:
                typeName = "Academic Year";
                break;
            case 2102:
                typeName = "Class";
                break;
            case 2103:
                typeName = "Shift";
                break;
            case 2104:
                typeName = "Section";
                break;
            case 2105:
                typeName = "Group";
                break;
            case 2106:
                typeName = "Student Category";
                break;
            case 2107:
                typeName = "Academic Session";
                break;
            case 2108:
                typeName = "Designation";
                break;
            case 2201:
                typeName = "Exam";
                break;
            case 2202:
                typeName = "Subject";
                break;
            case 2301:
                typeName = "Period";
                break;
            case 2302:
                typeName = "Staff Category";
                break;
            default:
                break;
        }

        return typeName;
    }

    public static List<Date> getDateListByMonthAndYear(String monthName, String year) {

        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.MONTH, (Month.valueOf(monthName.toUpperCase()).getValue() - 1));

        cal.set(Calendar.YEAR, Integer.parseInt(year));

        int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        List<Date> dateList = new ArrayList<>();

        for (int i = 0; i < maxDay; i++) {

            cal.set(Calendar.DAY_OF_MONTH, i + 1);

            Date date = cal.getTime();

            dateList.add(date);
        }

        return dateList;

    }

    public static List<Date> getDateListByYear(String year) {

        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.YEAR, Integer.parseInt(year));

        int maxDay = cal.getActualMaximum(Calendar.DAY_OF_YEAR);

        List<Date> dateList = new ArrayList<>();

        for (int i = 0; i < maxDay; i++) {

            cal.set(Calendar.DAY_OF_YEAR, i + 1);

            Date date = cal.getTime();

            dateList.add(date);
        }
        return dateList;
    }

    public static int getDayOfMonth(Date aDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(aDate);
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    public static double providePercentWithTwoDecimalDigits(int partNumber, int fullNumber) {
        if (fullNumber == 0) {
            return 0;
        }
        return Double.parseDouble(new BigDecimal((Double.parseDouble(String.valueOf(partNumber)) / Double.parseDouble(String.valueOf(fullNumber))) * 100).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
    }

    public static String convertDateToStringTimeWithAmPm(Date date) {
        return new SimpleDateFormat("hh:mm:ss a").format(date);
    }

    public static String provideDayNameByDate(Date date) {
        return new SimpleDateFormat("EEEE").format(date);
    }

    public static String getImagePath(String imageFolder) {
        Properties prop = new Properties();
        InputStream inputStream = ApplicationUtils.class.getClassLoader().getResourceAsStream("imagepath/image-path.properties");
        try {
            prop.load(inputStream);
            return  prop.getProperty(imageFolder);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

    }

}
