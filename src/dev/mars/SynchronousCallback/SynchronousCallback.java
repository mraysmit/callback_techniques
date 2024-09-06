package dev.mars.SynchronousCallback;


public class SynchronousCallback {

    //  declares an EventListener interface with an onNewEvent() method with a String return type. This will be our callback.
    public interface EventHandler {
        String onNewEvent(String event);
    }

    // The SynchronousEventListenerImpl class implements the EventListener interface
    static class SynchronousEventListener implements EventHandler {
        @Override
        public String onNewEvent(String event) {
            return ("Synchronously Running Callback function: " + event);
        }
    }


    //  SynchronousEventConsumer class that composes an instance of the EventListener interface and invokes its onTrigger() method
    //  SynchronousEventConsumer class has an EventListener property that it initializes through its constructor.
    //  When the doSynchronousOperation() method is invoked, it returns the value obtained from the onTrigger() method belonging to the EventListener.
    static class SynchronousEventConsumer {

        private EventHandler handler;

        public SynchronousEventConsumer(EventHandler listener) {
            this.handler = listener;
        }

        public String doSynchronousOperation(){
            System.out.println("Performing callback before synchronous Task");
            // any other custom operations
            return handler.onNewEvent("New Event Data");
        }
    }


    public static void main(String[] args) {
        EventHandler listener = new SynchronousEventListener();
        SynchronousEventConsumer synchronousEventConsumer = new SynchronousEventConsumer(listener);
        String result = synchronousEventConsumer.doSynchronousOperation();
        System.out.println("Result: " + result);

        assert result != null;


    }


}
