package validation;

import entities.Edition;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CityValidation implements ConstraintValidator<City, Edition> {
    @Override
    public void initialize(City constraintAnnotation) {}
    @Override
    public boolean isValid(Edition edition, ConstraintValidatorContext constraintValidatorContext) {
        return edition.getCity().length()>1;
    }
}
