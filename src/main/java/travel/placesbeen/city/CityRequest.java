package travel.placesbeen.city;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CityRequest (
       @NotBlank String  name,
       @NotBlank String country,
       @NotNull Double latitude,
       @NotNull Double longitude
){}

