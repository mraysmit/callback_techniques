package dev.mars.SimpleLambdaConsumer;

import java.util.function.*;

public class SimpleLambdaConsumer {

    public static void main (String args[]) {

        /* Java Consumer example using a class */
        SimpleConsumerExample sce = new SimpleConsumerExample();
        sce.accept(Long.valueOf(2));

        /* Functional Consumer example using inner class */
        Consumer<Long> innerConsumer = new Consumer<Long>() {
            @Override
            public void accept(Long t) {
                System.out.println(t*t);
            }
        };
        innerConsumer.accept(Long.valueOf(4));

        /* Implemented Consumer function with verbose lambda expression */
        Consumer<Long> lambdaConsumer = (Long t) -> System.out.println(t*t);
        lambdaConsumer.accept(Long.valueOf(5));

        /* Concise lambda and Consumer function example */
        Consumer<Long> conciseLambda = t -> System.out.println(t*t);
        conciseLambda.accept(Long.valueOf(5));

    }
}

/* Class implementing functional Consumer example */
class SimpleConsumerExample implements Consumer<Long> {
    public void accept(Long t) {
        System.out.println(t*t);
    }
}