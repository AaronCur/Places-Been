package travel.placesbeen.city;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import travel.placesbeen.country.Country;
import travel.placesbeen.country.CountryRepository;

import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;

    public CityService(CityRepository cityRepository, CountryRepository countryRepository) {
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
    }

    @Transactional
    public CityResponse addCity(CityRequest cityrequest) {

        Country country = countryRepository.findByName(cityrequest.country())
                .orElseGet(() -> new Country(cityrequest.country()));

        City city = new City(cityrequest.name(), cityrequest.latitude(), cityrequest.longitude(), country);

        City savedCity = cityRepository.save(city);
        return mapToResponse(savedCity);
    }


    public List<CityResponse> getAllCities() {
        return cityRepository.findAllByOrderByIdAsc().stream().map(this::mapToResponse).toList();

    }

    public CityResponse updateCity(CityRequest cityRequest, Long id) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("City not found with id: " + id));

        city.setName(cityRequest.name());
        city.setLatitude(cityRequest.latitude());
        city.setLongitude(cityRequest.longitude());

        City updatedCity = cityRepository.save(city);
        return mapToResponse(updatedCity);
    }

    // Private helper to keep code DRY (Don't Repeat Yourself)
    private CityResponse mapToResponse(City city) {
        return new CityResponse(
                city.getId(),
                city.getName(),
                city.getLatitude(),
                city.getLongitude(),
                city.getCountry().getName(),
                city.getCountry().getFlag()
        );
    }

}
