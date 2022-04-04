package nl.amleshapi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Feign Client listing various consuming API's for covid 19
 * ToDo : Feign can be passed with configuration parameter for various http exceptions
 */
@FeignClient(value = "covid19api", url = "https://covid-api.mmediagroup.fr/v1")
public interface Covid19APIClient {

    @RequestMapping(method = RequestMethod.GET, value = "/vaccines")
    nl.amleshapi.model.vaccines.Root getAllVaccinesByCountry(@RequestParam("country") String country);

    @RequestMapping(method = RequestMethod.GET, value = "/cases")
    nl.amleshapi.model.cases.Root getAllCasesByCountry(@RequestParam("country") String country);

}