package nl.amleshapi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

/**
 * Feign Client listing various consuming API's for covid 19
 */
@FeignClient(value = "covid19api", url = "https://covid-api.mmediagroup.fr/v1")
public interface Covid19APIClient {

    @GetMapping("/vaccines")
    nl.amleshapi.model.vaccines.Root getAllVaccinesByCountry(@RequestParam("country") String country);

    @GetMapping("/cases")
    nl.amleshapi.model.cases.Root getAllCasesByCountry(@RequestParam("country") String country);

}