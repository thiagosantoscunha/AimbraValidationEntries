package aimbraFluent.interfaces;

import java.time.DayOfWeek;
import java.time.LocalDate;

public interface IDataValidation {
    void isInvalidDateFormatFromString(String dataString);
    void isInvalidDateFormatFromString(String dataString, String messageError);
    void isInvalidHourFormatFromString(String hourString);
    void isInvalidHourFormatFromString(String hourString, String messageError);
    boolean isInvalidRange(LocalDate startDate, LocalDate finishDate);
    void isInvalidRange(LocalDate startDate, LocalDate finishDate, String messageError);
    boolean isWeekend(LocalDate date);
    boolean isWeekday(LocalDate date);
    boolean isWeekend(DayOfWeek dayOfWeek);
    boolean isWeekday(DayOfWeek dayOfWeek);
    boolean isNotWeekDay(DayOfWeek dayOfWeek);
}
