package funtionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

//kelas ini hanya untuk membedakan bahwa digunakan di interfaces saja
//jadi hanya tinggal dipanggil saja dan tidak bentrok di controller
//dan kelas lain dan main kelas, hal ini lebih simple.

//penggunaan _ "underscore" hanya untuk penandaan

public class _Function {

    private static int number;

    //Model 1
    static int increment(int number) {
        return number + 1;
    }

    // Model 1.1
    // ini digunaan untuk multiple penghitungan scr jelas
    static int incrementByOneAndMultiply(int number, int numToMultiplyBy) {
        return (number + 1) * numToMultiplyBy;
    }

    //BiFunction
    // Integer
    BiFunction<Integer, Integer, Integer> IncrementByOneAndMultiplyBiFuntion =
            (incrementByOneFunction, incrementByOneFunctionMath)
                    -> (incrementByOneFunction + 1) *
                    incrementByOneFunctionMath;

    //Model 2
    static Function<Integer, Integer> incrementByOneFunction = number -> number++;

    // Model 3
    // Model Mathematic
    static Function<Integer, Integer> incrementByOneFunctionMath = number -> number * 12;

    //MATERI TAMBAHAN
    //https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html

    public static void main(String[] args) {
        //** Function takes 1 argument and produces 1 result

        // Model 1
        int difIncrementA = increment(3);
        System.out.println("Model 1 " + difIncrementA);

        // Model 2
        int difIncrementB = incrementByOneFunction.apply(2);
        System.out.println("Model 2 " + difIncrementB);

        //Model 3
        // Math
        int multiply = incrementByOneFunctionMath.apply(increment(difIncrementB));
        System.out.println("Model 3 Math " + multiply);

        // Masih error BROOOO !
       /* Function<Integer, Integer> incrementByOneFunctionMath = incrementByOneFunction.andThen(multiply);
        System.out.println(incrementByOneFunctionMath.apply(2));*/

        //***** BiFunction 2 argument and produces 1 result

        int a =  incrementByOneAndMultiply(3,100);
        System.out.println(a);
    }
}
