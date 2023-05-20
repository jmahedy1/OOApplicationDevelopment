/*
Jack Mahedy

This is the Message class. It holds the message, which is private. So getters and
setters were created to access it.
*/

public class Message {
    private String message;
    
    public void setMessage(String message){
        this.message = message;
    }
    
    public String getMessage(){
        return message;
    }
}