package nl.amleshapi.util;

import nl.amleshapi.exceptions.InternalException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class CorrCoeffCalculationTest {

    @Test
    void correlationCoefficientPositiveCase() throws InternalException {
        // Sample Data set
        Double X[] = {15.0d, 18.0d, 21.2d, 24.3d, 27.9d};
        Double Y[] = {25.6d, 25.6d, 27.7d, 31.3d, 32.8d};
        Double corr = CorrCoeffCalculation.correlationCoefficient(Arrays.asList(X),Arrays.asList(Y));
        Assertions.assertEquals(0.9633888257671261,corr);

        // Realistic data set
        Double X1[] = {0.21443670245290103,0.22443670245290103};
        Double Y2[] = {80.71423796299722,81.71423796299722};
        Double corr1 = CorrCoeffCalculation.correlationCoefficient(Arrays.asList(X1),Arrays.asList(Y2));
        Assertions.assertEquals(1.0000000000023856,corr1);

    }

    @Test
    void correlationCoefficientThrowsInternalServerError() throws InternalException {
        Double X[] = {0.21443670245290103};
        Double Y[] = {80.71423796299722};
        Assertions.assertThrows(InternalException.class, () ->
                CorrCoeffCalculation.correlationCoefficient(Arrays.asList(X),Arrays.asList(Y)), "Internal server Error occurred");
    }
}