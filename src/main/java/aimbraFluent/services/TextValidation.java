package aimbraFluent.services;

public interface TextValidation {
    Boolean isValid();
    TextValidation whereValueIs(String value);
    TextValidation whereMessageErrorIs(String messageError);
    TextValidation whereRangeLengthIs(Integer minLength, Integer maxLength);
    TextValidation whereFixedLentghIs(Integer fixedLength);
    TextValidation isNull();
    TextValidation isEmpty();
    TextValidation isNotNull();
    TextValidation isNotEmpty();
    TextValidation isNotNullAndNotEmpty();
    TextValidation isNullOrEmpty();
    TextValidation hasInvalidLength();
    TextValidation sizeIsNotIqualsTo();
    TextValidation sizeIsIqualsTo();
//    boolean invalidLength(String text, Integer minLength, Integer maxLength, String messageError);
//    boolean invalidLength(String text, String operator, Integer length);
//    boolean invalidLength(String text, String operator, Integer length, String messageError);

}
