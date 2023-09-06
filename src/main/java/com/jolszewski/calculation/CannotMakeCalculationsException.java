package com.jolszewski.calculation;

public class CannotMakeCalculationsException extends RuntimeException {

    private CannotMakeCalculationsException(String message) {
        super(message);
    }

    public static CannotMakeCalculationsException followerCountCannotBeZero() {
        return new CannotMakeCalculationsException("Can't calculate if follower count is 0.");
    }
}
