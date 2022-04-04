package nl.amleshapi.model.vaccines;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class All{
    public int administered;
    public int people_vaccinated;
    public int people_partially_vaccinated;
    public String country;
    public int population;
    public int sq_km_area;
    public String life_expectancy;
    public int elevation_in_meters;
    public String continent;
    public String abbreviation;
    public String location;
    public int iso;
    public String capital_city;
    public String lat;
    @JsonProperty("long") 
    public String mylong;
    public String updated;
}

