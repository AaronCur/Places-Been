package travel.placesbeen.country;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@Tag( name = "Country API", description = "API for managing countries")
public class CountryController {
}
