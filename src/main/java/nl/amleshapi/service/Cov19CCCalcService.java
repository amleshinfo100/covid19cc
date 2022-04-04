package nl.amleshapi.service;

import lombok.extern.slf4j.Slf4j;
import nl.amleshapi.client.Covid19APIClient;
import nl.amleshapi.model.response.VaccinationResponse;
import nl.amleshapi.util.CorrCoeffCalculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@Slf4j
public class Cov19CCCalcService {

    @Autowired
    Covid19APIClient covid19APIClient;

    /**
     * corr coeff % ge of people died and vaccinated , only one value is calculated in below code to fetch x and y params
     *  for corrCoeff , can covid19 api be checked further to retrieve values date wise to calculate proper corrCoeff?
     *  Exception handling can also be implemented further
     */
    public Double calculateCov19CorCoeff(String country) throws Exception{
        VaccinationResponse vaccinationResponse = new VaccinationResponse();
        //fetch all vaccinated counts by country
        vaccinationResponse.setPeopleVaccinated(covid19APIClient.getAllVaccinesByCountry(country).all.people_vaccinated);

        //fetch all covid19 cases by country
        nl.amleshapi.model.cases.Root root = covid19APIClient.getAllCasesByCountry(country);
        vaccinationResponse.setDeaths(root.all.deaths);
        vaccinationResponse.setPopulation(root.all.population);

        //calculate death and vaccine percentage
        Double deathPercentage = (double) vaccinationResponse.getDeaths() * 100 / vaccinationResponse.getPopulation();
        Double vaccinePercentage = (double) vaccinationResponse.getPeopleVaccinated()*100/vaccinationResponse.getPopulation();

        //calculate corr coeff
        Double corCoeff = CorrCoeffCalculation.correlationCoefficient(Arrays.asList(deathPercentage),Arrays.asList(vaccinePercentage));
        //log.info("VaccinationResponse:::" + vaccinationResponse);
        return corCoeff;
    }

}
