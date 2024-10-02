package pl.pingwit.pingwitdentalmanager.exceptionhandling;

public class NotFoundException extends RuntimeException{
    public NotFoundException (String message){
        super(message);
    }
}
