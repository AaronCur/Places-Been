package travel.placesbeen.city;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/api/v1/cities")
public class CityController {

    @GetMapping
    public ResponseEntity<List<CityResponse>> getAllCities() {
        return ResponseEntity.ok(List.of(new CityResponse(1L, "New York", 40.7128, -74.0060, "USA", "https://flagcdn.com/w40.png")));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityResponse> getCityById(Long id) {
        return ResponseEntity.ok(new CityResponse(1L, "New York", 40.7128, -74.0060, "USA", "https://flagcdn.com/w40.png"));
    }

    @PostMapping
    public ResponseEntity<CityResponse> addCity(CityRequest cityRequest) {
        CityResponse newCity = new CityResponse(cityRequest.getId(), cityRequest.getName(), cityRequest.getLatitude(), cityRequest.getLongitude(), cityRequest.getCountry(), cityRequest.getFlagUrl());
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()    // Takes "http://localhost:8080/api/v1/cities"
                .path("/{id}")           // Appends "/{id}"
                .buildAndExpand(newCity.id())
                .toUri();
        return ResponseEntity.created(location).body(new CityResponse(cityRequest.getId(), cityRequest.getName(), cityRequest.getLatitude(), cityRequest.getLongitude(), cityRequest.getCountry(), cityRequest.getFlagUrl()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(Long id) {
        return ResponseEntity.noContent().build();
    }
}
