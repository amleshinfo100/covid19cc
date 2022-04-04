package nl.amleshapi.util;

import lombok.extern.slf4j.Slf4j;
import nl.amleshapi.exceptions.InternalException;

import java.util.List;

/**
 * Here, Utility method for calculating Correlation coefficient is implemented
 */
@Slf4j
public class CorrCoeffCalculation {

    // function that returns correlation coefficient.
    //ToDo Exception handling checks
    public static Double correlationCoefficient(List<Double> X, List<Double> Y) throws InternalException {
        int n = X.size();
        double sum_X = 0d;
        double sum_Y = 0d;
        double sum_XY = 0d;
        double squareSum_X = 0d;
        double squareSum_Y = 0d;

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

        // use formula for calculating correlation coefficient
        double numerator = n * sum_XY - sum_X * sum_Y;
        double denominator = Math.sqrt((n * squareSum_X - sum_X * sum_X) * (n * squareSum_Y - sum_Y * sum_Y));
        if(denominator==0.0){
            log.error("denominotor value is : "+ denominator);
            throw new InternalException("Internal server error occurred");
        }
        return numerator/denominator;
    }
}
