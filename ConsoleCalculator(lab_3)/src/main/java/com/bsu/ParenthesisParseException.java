package com.bsu;

/**
 * Created by eugene on 11/7/17.
 */
public class ParenthesisParseException extends Exception{
    public ParenthesisParseException() {
    }

    public ParenthesisParseException(String message) {
        super(message);
    }

    public ParenthesisParseException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParenthesisParseException(Throwable cause) {
        super(cause);
    }
}
