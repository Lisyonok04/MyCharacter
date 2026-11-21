package ru.mycharacter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class TaskControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldCompleteTaskAndAwardXp() throws Exception {
        mockMvc.perform(post("/api/v1/tasks/2/complete")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"playerId": 1}
                                """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.taskId").value(2))
                .andExpect(jsonPath("$.xpAwarded").value(150))
                .andExpect(jsonPath("$.totalXp").value(450))
                .andExpect(jsonPath("$.level").value(3))
                .andExpect(jsonPath("$.levelUp").value(false))
                .andExpect(jsonPath("$.currentStreak").value(6))
                .andExpect(jsonPath("$.statChanges.length()").value(1));
    }

    @Test
    void shouldRejectSecondCompletionSameDay() throws Exception {
        mockMvc.perform(post("/api/v1/tasks/2/complete")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"playerId": 1}
                                """))
                .andExpect(status().isOk());

        mockMvc.perform(post("/api/v1/tasks/2/complete")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"playerId": 1}
                                """))
                .andExpect(status().isConflict());
    }

    @Test
    void shouldRejectTaskFromUnselectedCategory() throws Exception {
        mockMvc.perform(post("/api/v1/character/categories")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"playerId": 1, "branchIds": [1]}
                                """))
                .andExpect(status().isOk());

        mockMvc.perform(post("/api/v1/tasks/3/complete")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"playerId": 1}
                                """))
                .andExpect(status().isBadRequest());
    }
}
