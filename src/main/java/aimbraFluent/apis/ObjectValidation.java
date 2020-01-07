package aimbraFluent.apis;

public interface ObjectValidation {
    boolean isNull(Object o);
    boolean isNull(Object o, String messageError);
    boolean isNotNull(Object o);
    boolean isNotNull(Object o, String messageError);
}
