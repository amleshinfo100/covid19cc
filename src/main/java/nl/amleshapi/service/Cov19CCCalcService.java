package nl.amleshapi.service;

import lombok.extern.slf4j.Slf4j;
import nl.amleshapi.client.Covid19APIClient;
import nl.amleshapi.exceptions.InternalException;
import nl.amleshapi.exceptions.NotFoundException;
import nl.amleshapi.model.response.CommonResponse;
import nl.amleshapi.util.CorrCoeffCalculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Objects;

@Service
@Slf4j
public class Cov19CCCalcService {

    @Autowired
    Covid19APIClient covid19APIClient;

    /**
     *  corr coeff % ge of people died and vaccinated , only one value is calculated in below code to fetch x and y params
     *  Question : Can it be checked further to retrieve vaccinated and deaths values date wise to calculate proper corrCoeff?
     */
    public Double calculateCov19CorCoeff(String country) throws InternalException {
        CommonResponse commonResponse = new CommonResponse();
        //fetch all vaccinated counts by country
        nl.amleshapi.model.vaccines.Root rootVaccines = covid19APIClient.getAllVaccinesByCountry(country);
        if(Objects.isNull(rootVaccines.all) || Objects.isNull(rootVaccines.all.people_vaccinated))
            throw new NotFoundException("Not found");
        commonResponse.setPeopleVaccinated(rootVaccines.all.people_vaccinated);

        //fetch all covid19 cases by country
        nl.amleshapi.model.cases.Root rootCases = covid19APIClient.getAllCasesByCountry(country);
        if(Objects.isNull(rootCases.all.deaths) || Objects.isNull(rootCases.all.population))
            throw new NotFoundException("Not found");
        commonResponse.setDeaths(rootCases.all.deaths);
        commonResponse.setPopulation(rootCases.all.population);

        //calculate death and vaccine percentage
        // Question : How to get list of values for both deathPercentage and vaccinePercentage? date wise?
        Double deathPercentage = (double) commonResponse.getDeaths() * 100 / commonResponse.getPopulation();
        Double vaccinePercentage = (double) commonResponse.getPeopleVaccinated()*100/commonResponse.getPopulation();

        //calculate corr coeff
        return CorrCoeffCalculation.correlationCoefficient(Arrays.asList(deathPercentage),Arrays.asList(vaccinePercentage));
        //log.info("VaccinationResponse:::" + commonResponse);
    }

}
