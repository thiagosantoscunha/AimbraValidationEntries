package aimbraFluent;

import aimbraFluent.exceptions.BadRequestException;
import aimbraFluent.interfaces.IDataValidation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class DataValidationImplTest {

    IDataValidation dataValidation;

    @BeforeEach
    void setUp() {
        dataValidation = new DataValidationImpl();
    }

    @Test
    void isInvalidDateFormat_WithValidDate() {
        String dataString = "1989-07-18";
        assertDoesNotThrow(() -> dataValidation.isInvalidDateFormatFromString(dataString));
    }

    @Test
    void isInvalidDateFormat_WithInvalidValidDate() {
        String invalidDataString = "18-07-1989";
        assertThrows(BadRequestException.class, () -> dataValidation.isInvalidDateFormatFromString(invalidDataString));
    }

    @Test
    void isInvalidDateFormat_WithMessageError_WithValidDate() {
        String dataString = "1989-07-18";
        String messageError = "Format date is invalid";
        assertDoesNotThrow(() -> dataValidation.isInvalidDateFormatFromString(dataString, messageError));
    }

    @Test
    void testIsInvalidDateFormat_WithMessageError_WithInvalidDate() {
        String invalidDataString = "18-07-1989";
        String messageError = "Format date is invalid";
        String responseMessage = assertThrows(
                BadRequestException.class,
                () -> dataValidation.isInvalidDateFormatFromString(invalidDataString, messageError)
        ).getMessage();

        assertThat(responseMessage, is(messageError));
    }

    @Test
    void isInvalidHourFormat_WithValidHour() {
        String validFormatHourString = "09:02:03";
        assertDoesNotThrow(() -> dataValidation.isInvalidHourFormatFromString(validFormatHourString));
    }

    @Test
    void isInvalidHourFormat_WithInvalidHour() {
        String invalidFormatHourString = "35:02:03";
        assertThrows(BadRequestException.class, () -> dataValidation.isInvalidHourFormatFromString(invalidFormatHourString));
    }

    @Test
    void isInvalidHourFormat_WithMessageError_WithValidHour() {
        String validFormatHourString = "09:02:03";
        String messageError = "The hour is invalid";
        assertDoesNotThrow(() -> dataValidation.isInvalidHourFormatFromString(validFormatHourString, messageError));
    }

    @Test
    void isInvalidHourFormat_WithMessageError_WithInvalidHour() {
        String invalidFormatHourString = "35:02:03";
        String messageError = "The hour is invalid";
        String responseMessage = assertThrows(
                BadRequestException.class,
                () -> dataValidation.isInvalidHourFormatFromString(invalidFormatHourString, messageError)
        ).getMessage();
        assertThat(responseMessage, is(messageError));
    }

    @Test
    void isInvalidRange_WithEqualValues() {
        LocalDate now = LocalDate.now();
        LocalDate startDate = now;
        LocalDate endDate = now;
        boolean response = dataValidation.isInvalidRange(startDate, endDate);
        assertFalse(response);
    }

    @Test
    void isInvalidRange_WithStartDateGreaterThanEndDate() {
        LocalDate now = LocalDate.now();
        LocalDate startDate = now.plusDays(5);
        LocalDate endDate = now;
        boolean response = dataValidation.isInvalidRange(startDate, endDate);
        assertTrue(response);
    }


    @Test
    void isInvalidRange_WithEndDateGreaterThanStartDate() {
        LocalDate now = LocalDate.now();
        LocalDate startDate = now;
        LocalDate endDate = now.plusDays(5);
        boolean response = dataValidation.isInvalidRange(startDate, endDate);
        assertFalse(response);
    }

    @Test
    void testIsInvalidRange_WithMessageError_WithEqualValues() {
        LocalDate now = LocalDate.now();
        LocalDate startDate = now;
        LocalDate endDate = now;
        String messageError = "End Date is not before start date";

        assertDoesNotThrow(() -> dataValidation.isInvalidRange(startDate, endDate, messageError));
    }

    @Test
    void testIsInvalidRange_WithMessageError_WithStartDateGreaterThanEndDate() {
        LocalDate now = LocalDate.now();
        LocalDate startDate = now.plusDays(5);
        LocalDate endDate = now;
        String messageError = "End Date is not before start date";

        String responseMessage = assertThrows(
                BadRequestException.class,
                () -> dataValidation.isInvalidRange(startDate, endDate, messageError)
        ).getMessage();

        assertThat(responseMessage, is(messageError));
    }

    @Test
    void testIsInvalidRange_WithMessageError_WithEndDateGreaterThanStartDate() {
        LocalDate now = LocalDate.now();
        LocalDate startDate = now;
        LocalDate endDate = now.plusDays(5);
        String messageError = "End Date is not before start date";

        assertDoesNotThrow(() -> dataValidation.isInvalidRange(startDate, endDate, messageError));

    }

    @Test
    void testIsNotWeekDay() {
        boolean response = dataValidation.isNotWeekDay(DayOfWeek.SATURDAY);
        assertThat(response, is(true));
    }

    @Test
    void testIsWeekend() {
        boolean response = dataValidation.isWeekend(DayOfWeek.SATURDAY);
        assertThat(response, is(true));
    }

    @Test
    void testIsWeekday_WithWeekendParam() {
        boolean response = dataValidation.isWeekday(DayOfWeek.SATURDAY);
        assertThat(response, is(false));
    }

    @Test
    void testIsWeekday_WithWeedayParam() {
        boolean response = dataValidation.isWeekday(DayOfWeek.MONDAY);
        assertThat(response, is(true));
    }

    @Test
    void testIsWeekend_WithLocalDateParam_WithWeekday() {
        LocalDate weekday = LocalDate.of(2019, 12, 27);
        boolean response = dataValidation.isWeekday(weekday);
        assertThat(response, is(true));
    }

    @Test
    void testIsWeekend_WithLocalDateParam_WithWeekend() {
        LocalDate weekday = LocalDate.of(2019, 12, 28);
        boolean response = dataValidation.isWeekday(weekday);
        assertThat(response, is(false));
    }

}