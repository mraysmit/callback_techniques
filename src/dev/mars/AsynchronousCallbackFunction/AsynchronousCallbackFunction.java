package dev.mars.AsynchronousCallbackFunction;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class AsynchronousCallbackFunction {

    // EventListener interface to illustrate an asynchronous callback function in Java
    public interface EventListener {
        String onNewEvent();
        void respondToNewEvent();
    }

    // implements the EventListener interface we declared in the previous section and returns a String literal in its overridden onTrigger() method.
    class AsynchronousEventListener implements EventListener {
        @Override
        public String onNewEvent(){
            respondToNewEvent();
            return "Asynchronously executed callback function";
        }
        @Override
        public void respondToNewEvent(){
            System.out.println("This is a side effect of the asynchronous trigger.");
        }
    }


    // we declare the class that asynchronously runs the onTrigger() method as a callback function
    // creating a new Thread for each method call is an anti-pattern  used here for demo purposes.
    // Prod code should use properly sized and tuned thread pools
    class AsynchronousEventConsumer{
        private EventListener listener;

        public AsynchronousEventConsumer(EventListener listener) {
            this.listener = listener;
        }

        public String doAsynchronousOperation() throws ExecutionException, InterruptedException {
            System.out.println("Performing operation in Asynchronous Task");

            Callable<String> task = listener::onNewEvent;
            FutureTask<String> futureTask = new FutureTask<>(task);
            new Thread(futureTask).start();
            return futureTask.get();
        }
    }

    public static void main(String[] args) {
        AsynchronousCallbackFunction asynchronousCallbackFunction = new AsynchronousCallbackFunction();
        EventListener listener = asynchronousCallbackFunction.new AsynchronousEventListener();
        AsynchronousEventConsumer asynchronousEventConsumer = asynchronousCallbackFunction.new AsynchronousEventConsumer(listener);

        try {
            String result = asynchronousEventConsumer.doAsynchronousOperation();
            System.out.println("Result: " + result);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }





}
