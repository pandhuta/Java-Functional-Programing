package finalsection;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Lambdas {
    public static void main(String[] args) {
        //lambdas
        // Method 1, Function Biasa
        Function<String,String>upperCaseName = name ->{
            //logic
            if (name.isEmpty()) throw new IllegalArgumentException("");
            return name.toUpperCase();
        };

        //lambdas
        // Method 1, BiFunction Biasa
        BiFunction<String,Integer,String> upperCaseNameBiFunction = (name,age) ->{
            //logic
            if (name.isEmpty()) throw new IllegalArgumentException("");
            System.out.println(age);
            return name.toUpperCase();
        };

        String upperCaseNames = upperCaseNameBiFunction.apply("Dhuta", 27);
        System.out.println(upperCaseNames);

    }
};
