package aimbraFluent.apis.implementations;


import aimbraFluent.apis.DataValidation;
import aimbraFluent.exceptions.BadRequestException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;

public class DataValidationImpl implements DataValidation {

    SimpleDateFormat patternDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat patternHourFormat = new SimpleDateFormat("HH:mm:s");

    @Override
    public void isInvalidDateFormatFromString(String dataString) {
        try {
            patternDateFormat.setLenient(false);
            Date data = patternDateFormat.parse(dataString);
        } catch (ParseException e) {
            e.getStackTrace();
            throw new BadRequestException("Format Date is invalid");
        }
    }

    @Override
    public void isInvalidDateFormatFromString(String dataString, String messageError) {
        try {
            patternDateFormat.setLenient(false);
            Date data = patternDateFormat.parse(dataString);
        } catch (ParseException e) {
            throw new BadRequestException(messageError);
        }
    }

    @Override
    public void isInvalidHourFormatFromString(String hourString) {
        try {
            patternHourFormat.setLenient(false);
            Date data = patternHourFormat.parse(hourString);
        } catch (ParseException e) {
            throw new BadRequestException("The hour is invalid hour");
        }
    }

    @Override
    public void isInvalidHourFormatFromString(String dataString, String messageError) {
        try {
            patternHourFormat.setLenient(false);
            Date data = patternHourFormat.parse(dataString);
        } catch (ParseException e) {
            throw new BadRequestException(messageError);
        }
    }

    @Override
    public boolean isInvalidRange(LocalDate startDate, LocalDate finishDate) {
        return finishDate.isBefore(startDate);
    }

    @Override
    public void isInvalidRange(LocalDate startDate, LocalDate finishDate, String messageError) {
        if (isInvalidRange(startDate, finishDate)) {
            throw new BadRequestException(messageError);
        }
    }

    @Override
    public boolean isWeekday(DayOfWeek dayOfWeek) {
        return !isWeekend(dayOfWeek);
    }

    @Override
    public boolean isNotWeekDay(DayOfWeek dayOfWeek) {
        return isWeekend(dayOfWeek);
    }

    @Override
    public boolean isWeekend(DayOfWeek dayOfWeek) {
        return DayOfWeek.SATURDAY.equals(dayOfWeek) || DayOfWeek.SUNDAY.equals(dayOfWeek);
    }

    @Override
    public boolean isWeekday(LocalDate date) {
        return !isWeekend(date);
    }

    @Override
    public boolean isWeekend(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY;
    }

}
