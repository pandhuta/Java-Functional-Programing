package combinatorpattern;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        CostumerCombinator costumerCombinator = new CostumerCombinator(
                "Dhuta",
                "papan@gmail.com",
                "+891",
                LocalDate.of(2000,1,1)
        );

        // ini bisa di lakukan melalui DB
         CustomerValidatorService customerValidatorService = new CustomerValidatorService();
         boolean validOrNot = customerValidatorService.isValid(costumerCombinator);
         System.out.println(validOrNot);


    }
}
