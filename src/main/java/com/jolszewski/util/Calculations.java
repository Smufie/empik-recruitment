package com.jolszewski.util;


public class Calculations {
    public static double calculate(int repositoryCount, int followerCount) {
        if (followerCount != 0.0) {
            return  (double) 6 / followerCount * (2 + repositoryCount);
        } else {
            throw new CannotMakeCalculationsException("Can't calculate if repository count is 0.");
        }
    }
}
