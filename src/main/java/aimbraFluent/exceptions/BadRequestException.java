package aimbraFluent.exceptions;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String messageError) {
        super(messageError);
    }
}
