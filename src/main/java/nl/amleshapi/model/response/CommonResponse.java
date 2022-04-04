package nl.amleshapi.model.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CommonResponse {
   Integer peopleVaccinated;
   Integer deaths;
   Integer population;
}
