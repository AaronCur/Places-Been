package travel.placesbeen.city;

public record CityRequest (
        String  name,
        String country,
        Double latitude,
        Double longitude
){}

