package ru.mycharacter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class SkillControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnSkillTreeWithUnlockStatuses() throws Exception {
        mockMvc.perform(get("/api/v1/skills").param("playerId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nodes.length()").value(10))
                .andExpect(jsonPath("$.nodes[0].code").value("FIT_START"))
                .andExpect(jsonPath("$.nodes[0].status").value("UNLOCKED"))
                .andExpect(jsonPath("$.nodes[1].code").value("FIT_RUN_5K"))
                .andExpect(jsonPath("$.nodes[1].status").value("UNLOCKED"))
                .andExpect(jsonPath("$.nodes[2].code").value("FIT_HALF_MARATHON"))
                .andExpect(jsonPath("$.nodes[2].status").value("AVAILABLE"))
                .andExpect(jsonPath("$.nodes[3].status").value("UNLOCKED"));
    }
}
