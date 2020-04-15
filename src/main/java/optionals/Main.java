package optionals;

import java.util.Optional;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        // 1
        Object value = Optional.ofNullable(null)
                .orElseGet(() -> "default value");

        // 2
        Object value1 = Optional.ofNullable("Hello")
                .orElseGet(() -> "default value");

        // 3
        Supplier<IllegalStateException> exception = ()
                -> new IllegalStateException("exception");
        Object value2 = Optional.ofNullable("Hello")
                .orElseThrow(exception);

        //4
        final Optional<String> present1 = Optional.ofNullable("dhuta@gmail.com");
        present1.ifPresent(email ->
                //logig or bisnis logic
                System.out.println("Sending Email to" + email));

        //5
        // ini kalo pakek if sama else yaa
        if (present1.equals("")) {

            System.out.println("Status: ");

        }else{

        }
        //4
         

        System.out.println(value);
        System.out.println(value1);
        System.out.println(value2);


    }
};
