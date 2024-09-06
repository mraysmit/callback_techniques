package dev.mars.SimpleSynchronousCallback;


public class SimpleSynchronousCallback {

    public static void main(String... args) {
        // 1. create an object of the MessageClass
        MessageClass messageSource = new MessageClass();

        // 2. create an instance of the Event Handler class
        MessageEventHandler handler = new MessageEventHandler();

        // 3. pass the  Event Handler intance for performing the default operation
        messageSource.onNewMessage(handler, "Hello World");

    }



}


//Create a class that generates the event
class MessageClass {
    public void onNewMessage(EventHandler handler, String message)
    {
        handler.onNewEvent(message);
    }
}


//Create an interface to handle message event for the callback method
interface EventHandler {
    //create abstract method, i.e., newMessageEventHandler() that will act as callback
    public void onNewEvent(String message);
}



//Create a class that handle the callback and implements the ClickHandler
class MessageEventHandler implements EventHandler {

    @Override
    public void onNewEvent(String message) {
        System.out.println("New Message Event Generated from Message Class: " + message);
    }
}



