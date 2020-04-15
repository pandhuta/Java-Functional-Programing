package finalsection;

import java.util.function.Consumer;

public class Main {

    static void hello(String firstName, String lastName
            , Consumer<String> callback
                      //,
                      //Runnable callbackV2
    ) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.accept(firstName);
            //callbackV2.run();
        }


    }

    public static void main(String[] args) {
        hello("John", "Farid", value -> {
            System.out.println("no lastName provided" + value);
        });
    }
}
