package aimbraFluent.services.implementations;

import aimbraFluent.services.NumberValidation;
import aimbraFluent.exceptions.BadRequestException;

public class NumberValidationImpl implements NumberValidation {
    @Override
    public boolean isNull(Number value) {
        return value == null;
    }

    @Override
    public void isNull(Number value, String messageError) {
        if (isNull(value)) {
            if (messageError != null) {
                throw new BadRequestException(messageError);
            }
        }
    }

    @Override
    public boolean isNotNull(Number value) {
        return !isNull(value);
    }

    @Override
    public void isNotNull(Number value, String messageError) {
        if (isNotNull(value)) {
            if (messageError != null) {
                throw new BadRequestException(messageError);
            }
        }
    }
}
