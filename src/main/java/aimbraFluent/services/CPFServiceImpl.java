package aimbraFluent.services;


import aimbraFluent.apis.implementations.TextValidationImpl;
import aimbraFluent.exceptions.BadRequestException;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.stream.Stream;

public class CPFServiceImpl implements CPFService {

    private final List<String> BLACKLIST = Arrays.asList(
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
    private final int LENGTH = 11;
    private char dig10;
    private char dig11;
    private int sm;
    private int i;
    private int r;
    private int num;
    private int peso;
    private String cpf;

    public CPFServiceImpl() {
    }

    public CPFServiceImpl(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public boolean isValid() {
        isBlacklist();
        isInvalidLength();

        try {
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                num = convertIthCharacterToNumberByPosition(i);
                sm += num * peso;
                peso -= 1;
            }
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = convertIntToChar(r);
            }
        } catch (InputMismatchException error) {
            throw new InputMismatchException(error.getMessage());
        }




        return false;
    }

    @Override
    public boolean isBlacklist() {
        for (String b : BLACKLIST) {
            if (cpf.equals(b))
                throw new BadRequestException("CPF is on Backlist");
        }
        return false;
    }

    @Override
    public boolean isInvalidLength() {
        TextValidationImpl.init()
                .whereValueIs("1233214565")
                .whereFixedLentghIs(LENGTH)
                .whereMessageErrorIs("CPF is not equals to " + LENGTH)
                .sizeIsNotIqualsTo()
                .isValid();
        return false;
    }

    @Override
    public void calculateFirstDigitOfTheVerifier() {

    }

    @Override
    public void calculateSecondDigitOfTheVerifier() {

    }

    @Override
    public int convertIthCharacterToNumberByPosition(int position) {
        return (int) (cpf.charAt(position) - 48);
    }

    public char convertIntToChar(int num) {
        return (char) (num + 48);
    }

    @Override
    public void convertCharToNumber() {

    }

    @Override
    public boolean checkCalculatedDigits() {
        return false;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
