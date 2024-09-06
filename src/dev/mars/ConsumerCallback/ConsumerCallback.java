package dev.mars.ConsumerCallback;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ConsumerCallback {
    public static void main(String[] args) {

        ConsumerCallback consumerCallback = new ConsumerCallback();
        int incrementShares = 10;
        AtomicInteger newShares1 = new AtomicInteger();
        int initialNumberofShares = 20;

        consumerCallback.getNumberofShares(initialNumberofShares, (_) -> {
            consumerCallback.increaseNumberofShares(initialNumberofShares, incrementShares, (newCalcShares) -> {
                System.out.printf("New shares ==> %s".formatted(newCalcShares));
                newShares1.set(newCalcShares);
            });
        });


        assertEquals(initialNumberofShares + incrementShares, newShares1.get());

    }

    public void getNumberofShares(int initialShares, Consumer<Integer> callback) {
        callback.accept(initialShares);
    }

    public void increaseNumberofShares(int initialShares, int incrementShares, Consumer<Integer> callback) {
        System.out.println("Initial shares: %s increment Shares: %s".formatted(initialShares, incrementShares));

        int newNumberofShares = initialShares + incrementShares;
        callback.accept(newNumberofShares);
    }





}
