package combinatorpattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import static combinatorpattern.CostumerRegistrationValidator.ValidationResult.*;


public interface CostumerRegistrationValidator extends
        Function<CostumerCombinator,
                CostumerRegistrationValidator.ValidationResult> {

    static CostumerRegistrationValidator isEmailValid() {
        return costumerCombinator -> costumerCombinator
                .getEmail().contains("@") ?
                SUCCEES :
                EMAIL_NO_VOLID;
    }

    static CostumerRegistrationValidator isPHoneNumberValid() {
        return costumerCombinator -> costumerCombinator
                .getEmail().startsWith("+0") ?
                SUCCEES :
                PHONE_NUMR_NOT_VALID;
    }

    static CostumerRegistrationValidator isAnAdult() {
        //LocalDate dobs;
        return costumerCombinator ->
                Period.between(costumerCombinator.getDob(), LocalDate.now()).getYears() > 16 ?
                        SUCCEES : IS_NOT_AND_AD;
        //Period.between(cus, LocalDate.now()).getYears() > 16 ?
        //SUCCEES : IS_NOT_AND_AD;
    }

    // INI MASIH ERROR
    default CostumerRegistrationValidator and(CustomerValidatorService other) {
        return costumerCombinator -> {
            ValidationResult result = this.apply(costumerCombinator);
            ValidationResult enumCostum = this.apply(costumerCombinator);
            //boolean ValidationResult apply = other.apply(costumerCombinator);
            return result.equals(SUCCEES) ? apply : result;
        };
    }


    enum ValidationResult {
        SUCCEES,
        PHONE_NUMR_NOT_VALID,
        EMAIL_NO_VOLID,
        apply, IS_NOT_AND_AD

    }
}
