package combinatorpattern;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidatorService {
    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.contains("+0");
    }

    private boolean isAdult(LocalDate dob) {
        return Period.between(dob, LocalDate.now()).getYears() > 16;
    }

    // ini untuk validasi dari kelas2 private diatas
    public boolean isValid (CostumerCombinator costumerCombinator){
      return isEmailValid(costumerCombinator.getEmail())&&
            isPhoneNumberValid(costumerCombinator.getPhoneNumber())&&
            isAdult(costumerCombinator.getDob());

    };


}
