package nl.amleshapi.controller;

import nl.amleshapi.model.response.VaccinationResponse;
import nl.amleshapi.service.Cov19CCCalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *  This class exposes API for calculated value of covid 19 correlation coefficient
 */
@RestController
public class Cov19CCCalcController {

    @Autowired
    Cov19CCCalcService cov19CCCalcService;

    @GetMapping("/cov19cc")
    public Double calculateCov19CorCoeff(@RequestParam("country") String country) throws Exception{
        return cov19CCCalcService.calculateCov19CorCoeff(country);
    }


}
