package aimbraFluent.services;

public interface CPFService {
    boolean isValid();
    boolean isBlacklist();
    boolean isInvalidLength();
    void calculateFirstDigitOfTheVerifier();
    void calculateSecondDigitOfTheVerifier();
    int convertIthCharacterToNumberByPosition(int position);
    void convertCharToNumber();
    boolean checkCalculatedDigits();
}
