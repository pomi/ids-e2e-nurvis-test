package com.thomascook.ids.e2e.tests;

public class LackOfAvailableRoomsException extends Exception {
    public LackOfAvailableRoomsException() {
    }

    public LackOfAvailableRoomsException(String message) {
        super(message);
    }

    public LackOfAvailableRoomsException(String message, Throwable cause) {
        super(message, cause);
    }
}
