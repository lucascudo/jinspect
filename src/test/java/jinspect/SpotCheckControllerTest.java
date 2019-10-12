package jinspect;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post; 
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers = SpotCheckController.class)
public class SpotCheckControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @Test
  public void whenValidInputs_thenReturns200() throws Exception {
    mockMvc.perform(post("/spot_check", 42L)
      .contentType("application/json")
      .content("[[0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0]]"))
      .andExpect(status().isOk())
      .andExpect(content().json("{\"total_area\":0,\"biggest_spot_area\":0,\"spots_average_area\":0.0,\"number_of_spots\":0}"));
    
    mockMvc.perform(post("/spot_check", 42L)
      .contentType("application/json")
      .content("[[1, 1, 0, 0], [1, 1, 0, 0], [0, 0, 1, 1], [0, 0, 1, 1]]"))
      .andExpect(status().isOk())
      .andExpect(content().json("{\"total_area\":8,\"spots_average_area\":4.0,\"biggest_spot_area\":4,\"number_of_spots\":2}"));

    mockMvc.perform(post("/spot_check", 42L)
      .contentType("application/json")
      .content("[[1, 0, 0, 0], [0, 0, 1, 0], [0, 0, 0, 1], [0, 0, 1, 1]]"))
      .andExpect(status().isOk())
      .andExpect(content().json("{\"total_area\":5,\"spots_average_area\":1.6666666666666667,\"biggest_spot_area\":3,\"number_of_spots\":3}"));
    
    mockMvc.perform(get("/spot_check", 42L)
      .contentType("application/json")
      .content("[[1, 0, 0, 0], [0, 0, 1, 0], [0, 0, 0, 1], [0, 0, 1, 1]]"))
      .andExpect(status().isOk())
      .andExpect(content().string("Invalid Method"));
    
    mockMvc.perform(post("/spot_check", 42L)
      .contentType("application/json")
      .content("[[1, 0, 0, 0], [0, 0, 1, 0], [0, 0, 0, 1], [0, 0, 1, 1, 1, 0, 1, 1, 0]]"))
      .andExpect(status().isOk())
      .andExpect(content().string("Invalid Matrix Format"));
  }

}