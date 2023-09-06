package com.jolszewski.calculation;


public class CalculationData {

    private final int followerCount;
    private final int repositoryCount;
    private final double result;

    public CalculationData(int followerCount, int repositoryCount) {
        validateInputData(followerCount);
        this.followerCount = followerCount;
        this.repositoryCount = repositoryCount;
        this.result = calculateResult();
    }

    public double getResult() {
        return result;
    }

    private void validateInputData(int followerCount) {
        if (followerCount == 0.0) {
            throw CannotMakeCalculationsException.followerCountCannotBeZero();
        }
    }

    private double calculateResult() {
        return (double) 6 / followerCount * (2 + repositoryCount);
    }
}
