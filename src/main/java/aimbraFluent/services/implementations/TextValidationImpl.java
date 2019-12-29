package aimbraFluent.services.implementations;


import aimbraFluent.exceptions.BadRequestException;
import aimbraFluent.services.TextValidation;

public class TextValidationImpl implements TextValidation {

    private String value;
    private String messageError;
    private Integer minLength;
    private Integer maxLength;

    private TextValidationImpl() {}

    public static TextValidation init() {
        return new TextValidationImpl();
    }

    private void isLessThenZero(Integer value) {
        if (value < 0)
            throw new BadRequestException("The value is less than zero");
    }

    @Override
    public TextValidation whereValueIs(String value) {
        this.value = value;
        return this;
    }

    @Override
    public TextValidation whereMessageErrorIs(String messageError) {
        this.messageError = messageError;
        return this;
    }

    @Override
    public TextValidation whereRangeLengthIs(Integer minLength, Integer maxLength) {
        this.minLength = minLength;
        this.maxLength = maxLength;
        return this;
    }

    @Override
    public Boolean isValid() {
        return true;
    }

    @Override
    public TextValidation isNull() {
        if (value == null) {
            if (messageError != null && !messageError.isEmpty()) {
                throw new BadRequestException(messageError);
            }
            throw new BadRequestException("This value is null");
        }
        return this;
    }

    @Override
    public TextValidation isEmpty() {
        if (value != null && value.isEmpty()) {
            if (messageError != null && !messageError.isEmpty()) {
                throw new BadRequestException(messageError);
            }
            throw new BadRequestException("This value is Empty");
        }
        return this;
    }


    @Override
    public TextValidation isNotNull() {
        if (value != null) {
            if (messageError != null && !messageError.isEmpty()) {
                throw new BadRequestException(messageError);
            }
            throw new BadRequestException("This value is not null");
        }
        return this;
    }

    @Override
    public TextValidation isNotEmpty() {
        if (!value.isEmpty()) {
            if (messageError != null && !messageError.isEmpty()) {
                throw new BadRequestException(messageError);
            }
            throw new BadRequestException("This value is not Empty");
        }
        return this;
    }

    @Override
    public TextValidation isNotNullAndNotEmpty() {
        if (value != null && !value.isEmpty()) {
            if (messageError != null && !messageError.isEmpty()) {
                throw new BadRequestException(messageError);
            }
            throw new BadRequestException("This value is not null and not Empty");
        }
        return this;
    }

    @Override
    public TextValidation isNullOrEmpty() {
        if (value == null || value.isEmpty()) {
            if (messageError != null && !messageError.isEmpty()) {
                throw new BadRequestException(messageError);
            }
            throw new BadRequestException("This value is null or Empty");
        }
        return this;
    }

    @Override
    public TextValidation hasInvalidLength() {
        if (value == null || minLength == null || maxLength == null) {
            throw new BadRequestException("Check the input parameters, please!");
        }
        isLessThenZero(minLength);
        isLessThenZero(maxLength);
        if (minLength > maxLength) {
            throw new BadRequestException("Range is wrong");
        }
        if (value.length() < minLength || value.length() > maxLength) {
            if (messageError != null) {
                throw new BadRequestException(messageError);
            }
            throw new BadRequestException("The value must be between " + minLength + " and " + maxLength + " characters.");
        }
        return this;
    }



//    @Override
//    public boolean invalidLength(String text, Integer minLength, Integer maxLength, String messageError) {
//        if (invalidLength(text, minLength, maxLength)) throw new BadRequestException(messageError);
//        return false;
//    }
//
//    @Override
//    public boolean invalidLength(String text, String operator, Integer length) {
//
//        switch (operator) {
//            case "==":
//                if (text.length() == length) return true;
//            case "!=":
//                if (text.length() != length) return true;
//            case ">":
//                if (text.length() > length) return true;
//            case ">=":
//                if (text.length() >= length) return true;
//            case "<":
//                if (text.length() < length) return true;
//            case "<=":
//                if (text.length() <= length) return true;
//        }
//
//        return false;
//
//    }
//
//    @Override
//    public boolean invalidLength(String text, String operator, Integer length, String messageError) {
//        switch (operator) {
//            case "==":
//                if (text.length() == length) sendExption(messageError);
//                break;
//            case "!=":
//                if (text.length() != length) sendExption(messageError);
//                break;
//            case ">":
//                if (text.length() > length) sendExption(messageError);
//                break;
//            case ">=":
//                if (text.length() >= length) sendExption(messageError);
//                break;
//            case "<":
//                if (text.length() < length) sendExption(messageError);
//                break;
//            case "<=":
//                if (text.length() <= length) sendExption(messageError);
//                break;
//        }
//
//        return false;
//    }
//
//    private void sendExption(String messageError) {
//        if (isNotNullAndEmpty(messageError)) {
//            throw new BadRequestException(messageError);
//        }
//    }

}
