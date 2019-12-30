package aimbraFluent.services;

import aimbraFluent.entities.UserEntity;
import aimbraFluent.exceptions.BadRequestException;
import aimbraFluent.services.implementations.TextValidationImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static aimbraFluent.builders.UserBuilder.oneUser;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TextValidationTest {

    private final String MESSAGE_ERROR = "One errror is running";

    @BeforeEach
    void setUp() {
    }

    @Test
    void isNull_HasError_WithoutMessageError() {
        UserEntity entity = oneUser().usernameIsNull().now();

        String response = assertThrows(BadRequestException.class, () -> {
            TextValidationImpl
                    .init()
                    .whereValueIs(entity.getUsername())
                    .whereMessageErrorIs(MESSAGE_ERROR)
                    .isNull()
                    .isValid();
        }).getMessage();

        assertThat(MESSAGE_ERROR, is(response));
    }

    @Test
    void testIsNull_hasErrorWithMessageError() {
        String messageExpected = "This value is null";
        UserEntity entity = oneUser().usernameIsNull().now();

        String response = assertThrows(BadRequestException.class, () -> {
            TextValidationImpl
                    .init()
                    .whereValueIs(entity.getUsername())
                    .whereMessageErrorIs(null)
                    .isNull()
                    .isValid();
        }).getMessage();

        assertThat(messageExpected, is(response));
    }

    @Test
    void testIsNull_WithoutError() {
        UserEntity entity = oneUser().now();
        Boolean response = TextValidationImpl
                .init()
                .whereValueIs(entity.getUsername())
                .whereMessageErrorIs(null)
                .isNull()
                .isValid();
        assertThat(response, is(true));
    }

    @Test
    void testIsEmpty_WithError_WithoutMessageError() {
        UserEntity entity = oneUser().usernameIsEmpty().now();
        String messageExpected = "This value is Empty";
        String responseMessage = assertThrows(
                BadRequestException.class,
                () ->
                        TextValidationImpl
                                .init()
                                .whereValueIs(entity.getUsername())
                                .whereMessageErrorIs("")
                                .isEmpty()
                                .isValid()
        ).getMessage();
        assertThat(responseMessage, is(messageExpected));
    }

    @Test
    void testIsEmpty_WithError_WithMessageError() {
        UserEntity entity = oneUser().usernameIsEmpty().now();
        String responseMessage = assertThrows(
                BadRequestException.class,
                () ->
                        TextValidationImpl
                                .init()
                                .whereValueIs(entity.getUsername())
                                .whereMessageErrorIs(MESSAGE_ERROR)
                                .isEmpty()
                                .isValid()
        ).getMessage();
        assertThat(responseMessage, is(MESSAGE_ERROR));
    }

    @Test
    void testIsEmpty_WithoutError() {
        UserEntity entity = oneUser().now();
        Boolean response = TextValidationImpl
                .init()
                .whereValueIs(entity.getUsername())
                .whereMessageErrorIs(MESSAGE_ERROR)
                .isEmpty()
                .isValid();
        assertThat(response, is(true));
    }

    @Test
    void testIsNotNull_WithError_WithoutMessageError() {
        UserEntity entity = oneUser().now();
        String messageExpected = "This value is not null";
        String responseMessage = assertThrows(BadRequestException.class, () -> {
            TextValidationImpl.init()
                    .whereValueIs(entity.getUsername())
                    .whereMessageErrorIs("")
                    .isNotNull()
                    .isValid();
        }).getMessage();
        assertThat(responseMessage, is(messageExpected));
    }

    @Test
    void testIsNotNull_WithError_WithMessageError() {
        UserEntity entity = oneUser().now();
        String responseMessage = assertThrows(BadRequestException.class, () -> {
            TextValidationImpl.init()
                    .whereValueIs(entity.getUsername())
                    .whereMessageErrorIs(MESSAGE_ERROR)
                    .isNotNull();
        }).getMessage();
        assertThat(responseMessage, is(MESSAGE_ERROR));
    }

    @Test
    void testIsNotNull_WithoutError() {
        UserEntity entity = oneUser().usernameIsNull().now();
        Boolean response = TextValidationImpl.init()
                .whereValueIs(entity.getUsername())
                .whereMessageErrorIs(MESSAGE_ERROR)
                .isNotNull()
                .isValid();
        assertThat(response, is(true));
    }

    @Test
    void testIsNotEmpty_WithError_WithoutMessageError() {
        UserEntity entity = oneUser().now();
        String expectedMessage = "This value is not Empty";
        String messageResponse = assertThrows(
                BadRequestException.class,
                () ->
                        TextValidationImpl
                                .init()
                                .whereValueIs(entity.getUsername())
                                .whereMessageErrorIs("")
                                .isNotEmpty()
                                .isValid()
        ).getMessage();
        assertThat(messageResponse, is(expectedMessage));
    }

    @Test
    void testIsNotEmpty_WithError_WithMessageError() {
        UserEntity entity = oneUser().now();
        String messageResponse = assertThrows(
                BadRequestException.class,
                () ->
                        TextValidationImpl
                                .init()
                                .whereValueIs(entity.getUsername())
                                .whereMessageErrorIs(MESSAGE_ERROR)
                                .isNotEmpty()
                                .isValid()
        ).getMessage();
        assertThat(messageResponse, is(MESSAGE_ERROR));
    }

    @Test
    void testIsNotEmpty_WithoutError() {
        UserEntity entity = oneUser().usernameIsEmpty().now();
        Boolean response = TextValidationImpl
                .init()
                .whereValueIs(entity.getUsername())
                .whereMessageErrorIs(MESSAGE_ERROR)
                .isNotEmpty()
                .isValid();
        assertThat(response, is(true));
    }

    @Test
    void isNotNullAndEmpty_WithError_WithoutMessageError() {
        UserEntity entity = oneUser().now();
        final String expectedMessage = "This value is not null and not Empty";
        String responseMessage = assertThrows(BadRequestException.class, () -> {
            TextValidationImpl
                    .init()
                    .whereValueIs(entity.getUsername())
                    .whereMessageErrorIs("")
                    .isNotNullAndNotEmpty()
                    .isValid();
        }).getMessage();
        assertThat(responseMessage, is(expectedMessage));
    }

    @Test
    void testIsNotNullAndEmpty_WithError_WithMessageError() {
        UserEntity entity = oneUser().now();
        String responseMessage = assertThrows(BadRequestException.class, () -> {
            TextValidationImpl
                    .init()
                    .whereValueIs(entity.getUsername())
                    .whereMessageErrorIs(MESSAGE_ERROR)
                    .isNotNullAndNotEmpty()
                    .isValid();
        }).getMessage();
        assertThat(responseMessage, is(MESSAGE_ERROR));
    }

    @Test
    void testIsNotNullAndEmpty_WithoutError_WithUsernameNull() {
        UserEntity entity = oneUser().usernameIsNull().now();
        Boolean response = TextValidationImpl
                .init()
                .whereValueIs(entity.getUsername())
                .whereMessageErrorIs(MESSAGE_ERROR)
                .isNotNullAndNotEmpty()
                .isValid();

        assertThat(response, is(true));
    }

    @Test
    void testIsNotNullAndEmpty_WithoutError_WithUsernameEmpty() {
        UserEntity entity = oneUser().usernameIsEmpty().now();
        Boolean response = TextValidationImpl
                .init()
                .whereValueIs(entity.getUsername())
                .whereMessageErrorIs(MESSAGE_ERROR)
                .isNotNullAndNotEmpty()
                .isValid();

        assertThat(response, is(true));
    }

    @Test
    void isNullOrEmpty_WithError_UsernameNull_WithoutMessageError() {
        UserEntity entity = oneUser().usernameIsNull().now();
        String responseMessage = assertThrows(BadRequestException.class, () -> {
            Boolean response = TextValidationImpl
                    .init()
                    .whereValueIs(entity.getUsername())
                    .whereMessageErrorIs("")
                    .isNullOrEmpty()
                    .isValid();
        }).getMessage();

        assertThat(responseMessage, is("This value is null or Empty"));
    }

    @Test
    void isNullOrEmpty_WithError_UsernameNull_WithMessageError() {
        UserEntity entity = oneUser().usernameIsNull().now();
        String responseMessage = assertThrows(BadRequestException.class, () -> {
            Boolean response = TextValidationImpl
                    .init()
                    .whereValueIs(entity.getUsername())
                    .whereMessageErrorIs(MESSAGE_ERROR)
                    .isNullOrEmpty()
                    .isValid();
        }).getMessage();

        assertThat(responseMessage, is(MESSAGE_ERROR));
    }

    @Test
    void isNullOrEmpty_WithError_UsernameEmpty_WithoutMessageError() {
        UserEntity entity = oneUser().usernameIsEmpty().now();
        String responseMessage = assertThrows(BadRequestException.class, () -> {
            Boolean response = TextValidationImpl
                    .init()
                    .whereValueIs(entity.getUsername())
                    .whereMessageErrorIs("")
                    .isNullOrEmpty()
                    .isValid();
        }).getMessage();

        assertThat(responseMessage, is("This value is null or Empty"));
    }

    @Test
    void isNullOrEmpty_WithError_UsernameEmpty_WithMessageError() {
        UserEntity entity = oneUser().usernameIsEmpty().now();
        String responseMessage = assertThrows(BadRequestException.class, () -> {
            Boolean response = TextValidationImpl
                    .init()
                    .whereValueIs(entity.getUsername())
                    .whereMessageErrorIs(MESSAGE_ERROR)
                    .isNullOrEmpty()
                    .isValid();
        }).getMessage();

        assertThat(responseMessage, is(MESSAGE_ERROR));
    }

    @Test
    void testIsNullOrEmpty_WithoutError() {
        UserEntity entity = oneUser().now();
        Boolean response = TextValidationImpl
                .init()
                .whereValueIs(entity.getUsername())
                .whereMessageErrorIs(MESSAGE_ERROR)
                .isNullOrEmpty()
                .isValid();

        assertThat(response, is(true));
    }

    @Test
    void testInvalidLength_WithValueNull() {
        UserEntity entity = oneUser().usernameIsNull().now();
        Integer minLength = 2;
        Integer maxLength = 8;
        String expectedMessage = "Check the input parameters, please!";
        String messageError = assertThrows(BadRequestException.class, () -> {
            TextValidationImpl.init()
                    .whereValueIs(entity.getUsername())
                    .whereMessageErrorIs(null)
                    .whereRangeLengthIs(minLength, maxLength)
                    .hasInvalidLength()
                    .isValid();
        }).getMessage();
        assertThat(messageError, is(expectedMessage));
    }

    @Test
    void testInvalidLength_WithMinLengthNull() {
        UserEntity entity = oneUser().now();
        Integer minLength = null;
        Integer maxLength = 8;
        String expectedMessage = "Check the input parameters, please!";
        String messageError = assertThrows(BadRequestException.class, () -> {
            TextValidationImpl.init()
                    .whereValueIs(entity.getUsername())
                    .whereMessageErrorIs(null)
                    .whereRangeLengthIs(minLength, maxLength)
                    .hasInvalidLength()
                    .isValid();
        }).getMessage();
        assertThat(messageError, is(expectedMessage));
    }

    @Test
    void testInvalidLength_WithMaxLengthNull() {
        UserEntity entity = oneUser().now();
        Integer minLength = 1;
        Integer maxLength = null;
        String expectedMessage = "Check the input parameters, please!";
        String messageError = assertThrows(BadRequestException.class, () -> {
            TextValidationImpl.init()
                    .whereValueIs(entity.getUsername())
                    .whereMessageErrorIs(null)
                    .whereRangeLengthIs(minLength, maxLength)
                    .hasInvalidLength()
                    .isValid();
        }).getMessage();
        assertThat(messageError, is(expectedMessage));
    }

    @Test
    void testInvalidLength_WithMinLenthLessThanZero() {
        UserEntity entity = oneUser().now();
        Integer minLength = -1;
        Integer maxLength = 1;
        String expectedMessage = "The value is less than zero";
        String messageError = assertThrows(BadRequestException.class, () -> {
            TextValidationImpl.init()
                    .whereValueIs(entity.getUsername())
                    .whereMessageErrorIs(null)
                    .whereRangeLengthIs(minLength, maxLength)
                    .hasInvalidLength()
                    .isValid();
        }).getMessage();
        assertThat(messageError, is(expectedMessage));
    }

    @Test
    void testInvalidLength_WithMaxLenthLessThanZero() {
        UserEntity entity = oneUser().now();
        Integer minLength = 1;
        Integer maxLength = -1;
        String expectedMessage = "The value is less than zero";
        String messageError = assertThrows(BadRequestException.class, () -> {
            TextValidationImpl.init()
                    .whereValueIs(entity.getUsername())
                    .whereMessageErrorIs(null)
                    .whereRangeLengthIs(minLength, maxLength)
                    .hasInvalidLength()
                    .isValid();
        }).getMessage();
        assertThat(messageError, is(expectedMessage));
    }

    @Test
    void testInvalidLength_WithMaxLenthLessThanMinLength() {
        UserEntity entity = oneUser().now();
        Integer minLength = 5;
        Integer maxLength = 1;
        String expectedMessage = "Range is wrong";
        String messageError = assertThrows(BadRequestException.class, () -> {
            TextValidationImpl.init()
                    .whereValueIs(entity.getUsername())
                    .whereMessageErrorIs(null)
                    .whereRangeLengthIs(minLength, maxLength)
                    .hasInvalidLength()
                    .isValid();
        }).getMessage();
        assertThat(messageError, is(expectedMessage));
    }

    @Test
    void testInvalidLength_WithErrorRange_withoutMessageError() {
        UserEntity entity = oneUser().now();
        Integer minLength = 20;
        Integer maxLength = 35;
        String expectedMessage = "The value must be between " + minLength + " and " + maxLength + " characters.";
        String messageError = assertThrows(BadRequestException.class, () -> {
            TextValidationImpl.init()
                    .whereValueIs(entity.getUsername())
                    .whereMessageErrorIs(null)
                    .whereRangeLengthIs(minLength, maxLength)
                    .hasInvalidLength()
                    .isValid();
        }).getMessage();
        assertThat(messageError, is(expectedMessage));
    }

    @Test
    void testInvalidLength_WithErrorRange_WithMessageError() {
        UserEntity entity = oneUser().now();
        Integer minLength = 20;
        Integer maxLength = 35;
        String messageError = assertThrows(BadRequestException.class, () -> {
            TextValidationImpl.init()
                    .whereValueIs(entity.getUsername())
                    .whereMessageErrorIs(MESSAGE_ERROR)
                    .whereRangeLengthIs(minLength, maxLength)
                    .hasInvalidLength()
                    .isValid();
        }).getMessage();
        assertThat(messageError, is(MESSAGE_ERROR));
    }

    @Test
    void testInvalidLength_WithoutError() {
        UserEntity entity = oneUser().now();
        Integer minLength = 3;
        Integer maxLength = 35;
        Boolean response = TextValidationImpl.init()
                .whereValueIs(entity.getUsername())
                .whereMessageErrorIs(MESSAGE_ERROR)
                .whereRangeLengthIs(minLength, maxLength)
                .hasInvalidLength()
                .isValid();
        assertThat(response, is(true));
    }

    @Test
    void testSizeIsNotIqualsTo_WithError_withoutMessageError_fixedLengthIsNull() {
        UserEntity entity = oneUser().now();
        Integer fixedLength = null;
        String expectedMessageError = "Fixed length is null!";
        String responseMessageError = assertThrows(BadRequestException.class, () -> {
            Boolean response = TextValidationImpl.init()
                    .whereValueIs(entity.getUsername())
                    .whereMessageErrorIs(null)
                    .whereFixedLentghIs(fixedLength)
                    .sizeIsNotIqualsTo()
                    .isValid();
        }).getMessage();
        assertThat(responseMessageError, is(expectedMessageError));
    }

    @Test
    void testSizeIsNotIqualsTo_WithError_withoutMessageError_fixedLengthLessThenZero() {
        UserEntity entity = oneUser().now();
        Integer fixedLength = -1;
        String expectedMessageError = "The value is less than zero";
        String responseMessageError = assertThrows(BadRequestException.class, () -> {
            Boolean response = TextValidationImpl.init()
                    .whereValueIs(entity.getUsername())
                    .whereMessageErrorIs(null)
                    .whereFixedLentghIs(fixedLength)
                    .sizeIsNotIqualsTo()
                    .isValid();
        }).getMessage();
        assertThat(responseMessageError, is(expectedMessageError));
    }

    @Test
    void testSizeIsNotIqualsTo_WithError_withoutMessageError_fixedLengthNotEquals() {
        UserEntity entity = oneUser().now();
        Integer fixedLength = 6;
        String expectedMessageError = "The size is equals";
        String responseMessageError = assertThrows(BadRequestException.class, () -> {
            Boolean response = TextValidationImpl.init()
                    .whereValueIs(entity.getUsername())
                    .whereMessageErrorIs(null)
                    .whereFixedLentghIs(fixedLength)
                    .sizeIsNotIqualsTo()
                    .isValid();
        }).getMessage();
        assertThat(responseMessageError, is(expectedMessageError));
    }

    @Test
    void testSizeIsNotIqualsTo_WithError_withoutMessageError_fixedLengthEquals() {
        UserEntity entity = oneUser().now();
        Integer fixedLength = 11;
        Boolean response = TextValidationImpl.init()
                .whereValueIs(entity.getUsername())
                .whereMessageErrorIs(null)
                .whereFixedLentghIs(fixedLength)
                .sizeIsNotIqualsTo()
                .isValid();
        assertThat(response, is(true));
    }

    @Test
    void testSizeIsNotIqualsTo_WithError_withMessageError_fixedLengthEquals() {
        UserEntity entity = oneUser().now();
        Integer fixedLength = 6;
        String responseMessageError = assertThrows(BadRequestException.class, () -> {
            Boolean response = TextValidationImpl.init()
                    .whereValueIs(entity.getUsername())
                    .whereMessageErrorIs(MESSAGE_ERROR)
                    .whereFixedLentghIs(fixedLength)
                    .sizeIsNotIqualsTo()
                    .isValid();
        }).getMessage();

        assertThat(responseMessageError, is(MESSAGE_ERROR));
    }




    @Test
    void testSizeIsIqualsTo_WithError_withoutMessageError_fixedLengthIsNull() {
        UserEntity entity = oneUser().now();
        Integer fixedLength = null;
        String expectedMessageError = "Fixed length is null!";
        String responseMessageError = assertThrows(BadRequestException.class, () -> {
            Boolean response = TextValidationImpl.init()
                    .whereValueIs(entity.getUsername())
                    .whereMessageErrorIs(null)
                    .whereFixedLentghIs(fixedLength)
                    .sizeIsIqualsTo()
                    .isValid();
        }).getMessage();
        assertThat(responseMessageError, is(expectedMessageError));
    }

    @Test
    void testSizeIsIqualsTo_WithError_withoutMessageError_fixedLengthLessThenZero() {
        UserEntity entity = oneUser().now();
        Integer fixedLength = -1;
        String expectedMessageError = "The value is less than zero";
        String responseMessageError = assertThrows(BadRequestException.class, () -> {
            Boolean response = TextValidationImpl.init()
                    .whereValueIs(entity.getUsername())
                    .whereMessageErrorIs(null)
                    .whereFixedLentghIs(fixedLength)
                    .sizeIsIqualsTo()
                    .isValid();
        }).getMessage();
        assertThat(responseMessageError, is(expectedMessageError));
    }

    @Test
    void testSizeIsIqualsTo_WithError_withoutMessageError_fixedLengthEquals() {
        UserEntity entity = oneUser().now();
        Integer fixedLength = 11;
        String expectedMessageError = "The size is equals";
        String responseMessageError = assertThrows(BadRequestException.class, () -> {
            Boolean response = TextValidationImpl.init()
                    .whereValueIs(entity.getUsername())
                    .whereMessageErrorIs(null)
                    .whereFixedLentghIs(fixedLength)
                    .sizeIsIqualsTo()
                    .isValid();
        }).getMessage();
        assertThat(responseMessageError, is(expectedMessageError));
    }

    @Test
    void testSizeIsIqualsTo_WithError_withMessageError_fixedLengthEquals() {
        UserEntity entity = oneUser().now();
        Integer fixedLength = 11;
        String responseMessageError = assertThrows(BadRequestException.class, () -> {
            Boolean response = TextValidationImpl.init()
                    .whereValueIs(entity.getUsername())
                    .whereMessageErrorIs(MESSAGE_ERROR)
                    .whereFixedLentghIs(fixedLength)
                    .sizeIsIqualsTo()
                    .isValid();
        }).getMessage();

        assertThat(responseMessageError, is(MESSAGE_ERROR));
    }
}