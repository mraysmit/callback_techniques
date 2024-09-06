package dev.mars.SimpleSynchronousCallbackGeneric;


public class SimpleSynchronousCallbackGeneric {

    public static void main(String... args) {
        // 1. create an object of the MessageClass
        MessageNotifier messageSource = new MessageNotifier();

        // 2. create an instance of the Event Handler class
        MessageEventHandler handler = new MessageEventHandler();

        // 3. pass the  Event Handler intance for performing the default operation
        messageSource.onNewMessage(handler, "Hello World");

    }
}


//Create an interface to handle message event for the callback method
interface EventHandler<T> {
    void onNewEvent(T event);
}

//Create a class that generates the event
class MessageNotifier {
    public <T> void onNewMessage(EventHandler<T> handler, T message) {
        handler.onNewEvent(message);
    }
}

//Create a class that handle the callback and implements the ClickHandler
class MessageEventHandler implements EventHandler<String> {
    @Override
    public void onNewEvent(String message) {
        System.out.println("New Message Event Generated from Message Class: " + message);
    }
}



