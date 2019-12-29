package aimbraFluent.services;

public interface NumberValidation {

    boolean isNull(Number value);
    void isNull(Number value, String messageError);
    boolean isNotNull(Number value);
    void isNotNull(Number value, String messageError);

}
