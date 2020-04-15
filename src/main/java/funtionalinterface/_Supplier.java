package funtionalinterface;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;

public class _Supplier {

    static String getConnectionUrl(){
        return"jdbc";
    }

    static Supplier<Collection<String>>getDBConnectionUrlsSupplier = () -> Arrays.asList(
      "jdbc",
      "jdbc"
    );

    public static void main(String[] args) {

    }

}
