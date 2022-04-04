package nl.amleshapi.model.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class VaccinationResponse {
   Integer peopleVaccinated;
   Integer deaths;
   Integer population;
}
