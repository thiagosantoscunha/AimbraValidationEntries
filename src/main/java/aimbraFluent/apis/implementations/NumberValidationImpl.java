package aimbraFluent.apis.implementations;

import aimbraFluent.exceptions.BadRequestException;
import aimbraFluent.apis.NumberValidation;

public class NumberValidationImpl implements NumberValidation {
    @Override
    public boolean isNull(final Number value) {
        return value == null;
    }

    @Override
    public void isNull(final Number value, final String messageError) {
        if (isNull(value)) {
            if (messageError != null) {
                throw new BadRequestException(messageError);
            }
        }
    }

    @Override
    public boolean isNotNull(final Number value) {
        return !isNull(value);
    }

    @Override
    public void isNotNull(final Number value, final String messageError) {
        if (isNotNull(value)) {
            if (messageError != null) {
                throw new BadRequestException(messageError);
            }
        }
    }
}
