package travel.placesbeen.city;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CityController.class)
public class CityControllerTest {

    @Autowired
    private MockMvc mockMvc; // Tool to perform HTTP requests

    @Test
    void shouldReturn200WhenFetchingCities() throws Exception {
        mockMvc.perform(get("/api/v1/cities"))
                .andExpect(status().isOk()); // This is your "200" check
    }
}
