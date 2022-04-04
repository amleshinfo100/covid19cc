package nl.amleshapi.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import javax.validation.constraints.AssertTrue;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CorrCoeffCalculationTest {

    @Test
    void correlationCoefficientWithSampleValues() {
        Double X[] = {15.0d, 18.0d, 21.2d, 24.3d, 27.9d};
        Double Y[] = {25.6d, 25.6d, 27.7d, 31.3d, 32.8d};
        Double corr = CorrCoeffCalculation.correlationCoefficient(Arrays.asList(X),Arrays.asList(Y));
        Assertions.assertEquals(0.9633888257671261,corr);
    }

    //0.21443670245290103 , 80.71423796299722

    @Test
    void correlationCoefficientWithRealValues() {
        Double X[] = {0.21443670245290103,0.31443670245290103};
        Double Y[] = {80.71423796299722,81.71423796299723};
        Double corr = CorrCoeffCalculation.correlationCoefficient(Arrays.asList(X),Arrays.asList(Y));
        Assertions.assertEquals(1.0000000000017617,corr);
    }
}