package ru.mycharacter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class CharacterControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnSeededCharacterProfile() throws Exception {
        mockMvc.perform(get("/api/v1/character/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nickname").value("HelpMe"))
                .andExpect(jsonPath("$.characterName").value("Авантюрист"))
                .andExpect(jsonPath("$.level").value(3))
                .andExpect(jsonPath("$.stats.length()").value(3))
                .andExpect(jsonPath("$.selectedBranches.length()").value(3));
    }
}