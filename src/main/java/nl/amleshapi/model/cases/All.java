package nl.amleshapi.model.cases;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class All{
    public int confirmed;
    public int recovered;
    public int deaths;
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

