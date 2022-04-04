package nl.amleshapi.util;

import java.util.List;

/**
 * Here, Utility method for calculating Correlation coefficient is implemented
 */
public class CorrCoeffCalculation {

    // function that returns correlation coefficient.
    //ToDo Exception handling checks
    public static Double correlationCoefficient(List<Double> X, List<Double> Y)
    {
        int n = X.size();
        Double sum_X = 0d;
        Double sum_Y = 0d;
        Double sum_XY = 0d;
        Double squareSum_X = 0d;
        Double squareSum_Y = 0d;

        for (int i = 0; i < n; i++)
        {
            // sum of elements of array X.
            sum_X = sum_X + X.get(i);

            // sum of elements of array Y.
            sum_Y = sum_Y + Y.get(i);

            // sum of X[i] * Y[i].
            sum_XY = sum_XY + X.get(i) * Y.get(i);

            // sum of square of array elements.
            squareSum_X = squareSum_X + X.get(i) * X.get(i);
            squareSum_Y = squareSum_Y + Y.get(i) * Y.get(i);
        }

        // use formula for calculating correlation
        // coefficient.
        Double corr = (double)(n * sum_XY - sum_X * sum_Y)/
                (double)(Math.sqrt((n * squareSum_X - sum_X * sum_X) * (n * squareSum_Y - sum_Y * sum_Y)));

        return corr;
    }
}
