package ru.protei.demo;


import ru.protei.demo.controller.MainController;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@WebMvcTest(MainController.class)
public class UserServiceApplicationTests {

    /*@Autowired
    private WebApplicationContext context;

    @MockBean
    private UserService userService;

    protected MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(this.context)
                .build();
    }

    @Test
    public void shouldSaveValidUser() throws Exception {
        this.mockMvc
                .perform(
                        post("/api/v1/users")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{\"name\": \"duke\", \"e_mail\":\"duke@mail.com\"}")
                )
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldNotSaveInvalidUser() throws Exception {
        this.mockMvc
                .perform(
                        post("/api/v1/users")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{\"name\": \"duke\", \"e_mail\":\"duke.mail.com\"}")
                )
                .andExpect(status().isBadRequest());
    }

    @Test
    public void should() throws Exception {
        this.mockMvc
                .perform(
                        put("/api/v1/users/6")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{\"status\": \"Online\"}")
                )
                .andExpect(status().isNotFound());
    }*/



}