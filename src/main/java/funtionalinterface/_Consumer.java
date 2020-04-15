package funtionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {


    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;

        public Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }

    // Model 1
    static void greetCustomer(Customer customer) {
        System.out.println("Hello" + customer.customerName +
                "thanks register, your number"
                + customer.customerPhoneNumber);
    }

    // Model 2
    static Consumer<Customer> greetCustomerConsumer = customer1 ->
            System.out.println("Hello" + customer1.customerName +
                    "thanks register, your number" + customer1.customerPhoneNumber);

    // Model 3
    // BiFunction String
    // Model 3.1
    static BiConsumer<Customer,Boolean> greetCustomerConsumerV2 = (customer1, showPhoneNumber) ->
            System.out.println("Hello" + customer1.customerName +
                    "thanks register, your number"
                  //  before + customer1.customerPhoneNumber);
                    + ( showPhoneNumber ? customer1.customerPhoneNumber : "*******"));

    // Model 3.2
    static void greetCustomerV2(Customer customer, boolean showPhoneNumber) {
        System.out.println("Hello" + customer.customerName +
                "thanks register, your number"
                //  before + customer1.customerPhoneNumber);
                + ( showPhoneNumber ? customer.customerPhoneNumber : "*******"));
    }

    public static void main(String[] args) {
        //Model 1 Run
        greetCustomer(new Customer("Dhuta", "8080"));

        // Model 2 Run
        Customer maria = new Customer("Maria","9090");
        greetCustomerConsumer.accept(maria);

        // Model 3 Run
        // BiFunction, Functional Interface
        greetCustomerConsumerV2.accept(maria,true);
        greetCustomerConsumerV2.accept(maria,false);
        greetCustomerV2(maria,true);
    }
}
