package com.jolszewski.calculation;


/**
 * Class responsible for representing and calculating value.
 */
public class CalculationData {

    private final int followerCount;
    private final int repositoryCount;
    private final double result;

    /**
     * Constructor which apart from initializing class fields, calculates the result.
     * Before instantiating this class, it validates input data.
     *
     * @param followerCount User's follower count.
     * @param repositoryCount User's repository count.
     *
     * @throws CannotMakeCalculationsException when followerCount is equal 0
     */
    public CalculationData(int followerCount, int repositoryCount) {
        validateInputData(followerCount);
        this.followerCount = followerCount;
        this.repositoryCount = repositoryCount;
        this.result = calculateResult();
    }

    /**
     * @return Result of the equation.
     */
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
