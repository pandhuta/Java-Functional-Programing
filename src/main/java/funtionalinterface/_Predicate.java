package funtionalinterface;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class _Predicate {

    // Model 1
    public static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }

    static Predicate<String> isPhoneNumberPredicateLambda = phoneNumber ->
        phoneNumber.startsWith("07") && phoneNumber.length() == 11;

    public static void main(String[] args) {
        System.out.println("Without Predicate");
        System.out.println(isPhoneNumberValid("07800000000"));
        System.out.println(isPhoneNumberValid("0700000000"));

        System.out.println("With Predicate And Lambda");
        System.out.println(isPhoneNumberValid("07800000000"));
        System.out.println(isPhoneNumberValid("0700000000"));
        System.out.println(isPhoneNumberValid("0700000000"));


    }
}
