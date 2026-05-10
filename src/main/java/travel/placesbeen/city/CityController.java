package travel.placesbeen.city;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/api/v1/cities")
@Tag( name = "City API", description = "API for managing cities")
public class CityController {

    @GetMapping
    public ResponseEntity<List<CityResponse>> getAllCities() {
        return ResponseEntity.ok(List.of(new CityResponse(1L, "New York", 40.7128, -74.0060, "USA", "https://flagcdn.com/w40.png")));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityResponse> getCityById(@PathVariable Long id) {
        return ResponseEntity.ok(new CityResponse(1L, "New York", 40.7128, -74.0060, "USA", "https://flagcdn.com/w40.png"));
    }

    @PostMapping
    public ResponseEntity<CityResponse> addCity(@Valid @RequestBody CityRequest cityRequest) {
        CityResponse newCity = new CityResponse(1L, "New York", 40.7128, -74.0060, "USA", "https://flagcdn.com/w40.png");
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()    // Takes "http://localhost:8080/api/v1/cities"
                .path("/{id}")           // Appends "/{id}"
                .buildAndExpand(newCity.id())
                .toUri();
        return ResponseEntity.created(location).body(newCity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CityResponse> updateCity(@PathVariable Long id, @Valid @RequestBody CityRequest cityRequest) {
        return ResponseEntity.ok(new CityResponse(1L, "New York", 40.7128, -74.0060, "USA", "https://flagcdn.com/w40.png"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }
}
