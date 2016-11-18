package net.unesc.exceptions;

public class LoginException extends Exception {

    public LoginException(String message) {
        super(message);
    }
    
    public LoginException() {
        super("Usuário deslogado");
    }
}
