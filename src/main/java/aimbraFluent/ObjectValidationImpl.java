package aimbraFluent;

import aimbraFluent.exceptions.BadRequestException;
import aimbraFluent.interfaces.IObjectValidation;

public class ObjectValidationImpl implements IObjectValidation {

    @Override
    public boolean isNull(Object o) {
        return o == null;
    }

    @Override
    public boolean isNull(Object o, String messageError) {
        if (isNull(o)) throw new BadRequestException(messageError);
        return false;
    }

    @Override
    public boolean isNotNull(Object o) {
        return o != null;
    }

    @Override
    public boolean isNotNull(Object o, String messageError) {
        if (isNotNull(o)) {
            throw new BadRequestException(messageError);
        }
        return false;
    }

}
