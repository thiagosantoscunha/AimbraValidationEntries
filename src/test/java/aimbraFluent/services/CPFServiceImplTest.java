package aimbraFluent.services;

import aimbraFluent.exceptions.BadRequestException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CPFServiceImplTest {

    private final String VALID_CPF = "88228952740";
    private final List<String> BACKLIST_CPF = Arrays.asList(
            "00000000000",
            "11111111111",
            "22222222222",
            "33333333333",
            "44444444444",
            "55555555555",
            "66666666666",
            "77777777777",
            "88888888888",
            "99999999999"
    );
    private static final String INVALID_CPF = "00112255669";

    private CPFService service;

    @Test
    void testIsBlacklist_0() {
        service = new CPFServiceImpl(BACKLIST_CPF.get(0));
        String expectedMessage = "CPF is on Backlist";
        String responseMessage = assertThrows(BadRequestException.class, () -> {
            boolean isBlacklist = service.isBlacklist();
        }).getMessage();
        assertThat(responseMessage, is(expectedMessage));
    }

    @Test
    void testIsBlacklist_1() {
        service = new CPFServiceImpl(BACKLIST_CPF.get(1));
        String expectedMessage = "CPF is on Backlist";
        String responseMessage = assertThrows(BadRequestException.class, () -> {
            boolean isBlacklist = service.isBlacklist();
        }).getMessage();
        assertThat(responseMessage, is(expectedMessage));
    }

    @Test
    void testIsBlacklist_2() {
        service = new CPFServiceImpl(BACKLIST_CPF.get(2));
        String expectedMessage = "CPF is on Backlist";
        String responseMessage = assertThrows(BadRequestException.class, () -> {
            boolean isBlacklist = service.isBlacklist();
        }).getMessage();
        assertThat(responseMessage, is(expectedMessage));
    }

    @Test
    void testIsBlacklist_3() {
        service = new CPFServiceImpl(BACKLIST_CPF.get(3));
        String expectedMessage = "CPF is on Backlist";
        String responseMessage = assertThrows(BadRequestException.class, () -> {
            boolean isBlacklist = service.isBlacklist();
        }).getMessage();
        assertThat(responseMessage, is(expectedMessage));
    }

    @Test
    void testIsBlacklist_4() {
        service = new CPFServiceImpl(BACKLIST_CPF.get(4));
        String expectedMessage = "CPF is on Backlist";
        String responseMessage = assertThrows(BadRequestException.class, () -> {
            boolean isBlacklist = service.isBlacklist();
        }).getMessage();
        assertThat(responseMessage, is(expectedMessage));
    }

    @Test
    void testIsBlacklist_5() {
        service = new CPFServiceImpl(BACKLIST_CPF.get(5));
        String expectedMessage = "CPF is on Backlist";
        String responseMessage = assertThrows(BadRequestException.class, () -> {
            boolean isBlacklist = service.isBlacklist();
        }).getMessage();
        assertThat(responseMessage, is(expectedMessage));
    }

    @Test
    void testIsBlacklist_6() {
        service = new CPFServiceImpl(BACKLIST_CPF.get(6));
        String expectedMessage = "CPF is on Backlist";
        String responseMessage = assertThrows(BadRequestException.class, () -> {
            boolean isBlacklist = service.isBlacklist();
        }).getMessage();
        assertThat(responseMessage, is(expectedMessage));
    }

    @Test
    void testIsBlacklist_7() {
        service = new CPFServiceImpl(BACKLIST_CPF.get(7));
        String expectedMessage = "CPF is on Backlist";
        String responseMessage = assertThrows(BadRequestException.class, () -> {
            boolean isBlacklist = service.isBlacklist();
        }).getMessage();
        assertThat(responseMessage, is(expectedMessage));
    }

    @Test
    void testIsBlacklist_8() {
        service = new CPFServiceImpl(BACKLIST_CPF.get(8));
        String expectedMessage = "CPF is on Backlist";
        String responseMessage = assertThrows(BadRequestException.class, () -> {
            boolean isBlacklist = service.isBlacklist();
        }).getMessage();
        assertThat(responseMessage, is(expectedMessage));
    }

    @Test
    void testIsBlacklist_9() {
        service = new CPFServiceImpl(BACKLIST_CPF.get(9));
        String expectedMessage = "CPF is on Backlist";
        String responseMessage = assertThrows(BadRequestException.class, () -> {
            boolean isBlacklist = service.isBlacklist();
        }).getMessage();
        assertThat(responseMessage, is(expectedMessage));
    }

    @Test
    void testIsNotBlacklist() {
        service = new CPFServiceImpl(VALID_CPF);
        boolean isBlacklist = service.isBlacklist();
        assertThat(isBlacklist, is(false));
    }

    @Test
    void calculateFirstDigitOfTheVerifier() {
        fail();
    }

    @Test
    void calculateSecondDigitOfTheVerifier() {
        fail();
    }

    @Test
    void convertIthCharacterToNumber() {
        fail();
    }

    @Test
    void convertCharToNumber() {
        fail();
    }

    @Test
    void checkCalculatedDigits() {
        fail();
    }

    @Test
    void testIsValid_WithSuccess() {
        fail();
    }
}