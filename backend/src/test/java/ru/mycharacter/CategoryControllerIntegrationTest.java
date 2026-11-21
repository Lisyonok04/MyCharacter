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
class CategoryControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldRejectMoreThanThreeCategories() throws Exception {
        mockMvc.perform(post("/api/v1/character/categories")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"playerId": 1, "branchIds": [1, 2, 3, 4]}
                                """))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldRejectDuplicateCategories() throws Exception {
        mockMvc.perform(post("/api/v1/character/categories")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"playerId": 1, "branchIds": [1, 1, 2]}
                                """))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldSelectThreeCategories() throws Exception {
        mockMvc.perform(post("/api/v1/character/categories")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"playerId": 1, "branchIds": [1, 2, 3]}
                                """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.playerId").value(1))
                .andExpect(jsonPath("$.selectedBranches.length()").value(3));
    }
}
