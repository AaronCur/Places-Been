package travel.placesbeen.city;

public record CityResponse(
        Long id,
        String name,
        Double latitude,
        Double longitude,
        String country,
        String countryFlag
) { }
