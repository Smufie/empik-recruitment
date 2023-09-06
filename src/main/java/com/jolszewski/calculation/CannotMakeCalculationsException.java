package com.jolszewski.calculation;

/**
 * Exception thrown when we cannot complete calculations.
 */
public class CannotMakeCalculationsException extends RuntimeException {

    private CannotMakeCalculationsException(String message) {
        super(message);
    }

    /**
     * Use when follower count equals 0.
     * @return instance of new exception
     */
    public static CannotMakeCalculationsException followerCountCannotBeZero() {
        return new CannotMakeCalculationsException("Can't calculate if follower count is 0.");
    }
}
