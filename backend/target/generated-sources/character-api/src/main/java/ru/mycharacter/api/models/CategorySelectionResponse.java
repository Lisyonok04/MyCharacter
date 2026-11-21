package ru.mycharacter.api.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.lang.Nullable;
import ru.mycharacter.api.models.BranchProgressDto;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CategorySelectionResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-11-21T13:37:28.624293319Z[Etc/UTC]", comments = "Generator version: 7.12.0")
public class CategorySelectionResponse {

  private Long playerId;

  @Valid
  private List<@Valid BranchProgressDto> selectedBranches = new ArrayList<>();

  public CategorySelectionResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CategorySelectionResponse(Long playerId, List<@Valid BranchProgressDto> selectedBranches) {
    this.playerId = playerId;
    this.selectedBranches = selectedBranches;
  }

  public CategorySelectionResponse playerId(Long playerId) {
    this.playerId = playerId;
    return this;
  }

  /**
   * Get playerId
   * @return playerId
   */
  @NotNull 
  @Schema(name = "playerId", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("playerId")
  public Long getPlayerId() {
    return playerId;
  }

  public void setPlayerId(Long playerId) {
    this.playerId = playerId;
  }

  public CategorySelectionResponse selectedBranches(List<@Valid BranchProgressDto> selectedBranches) {
    this.selectedBranches = selectedBranches;
    return this;
  }

  public CategorySelectionResponse addSelectedBranchesItem(BranchProgressDto selectedBranchesItem) {
    if (this.selectedBranches == null) {
      this.selectedBranches = new ArrayList<>();
    }
    this.selectedBranches.add(selectedBranchesItem);
    return this;
  }

  /**
   * Get selectedBranches
   * @return selectedBranches
   */
  @NotNull @Valid 
  @Schema(name = "selectedBranches", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("selectedBranches")
  public List<@Valid BranchProgressDto> getSelectedBranches() {
    return selectedBranches;
  }

  public void setSelectedBranches(List<@Valid BranchProgressDto> selectedBranches) {
    this.selectedBranches = selectedBranches;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CategorySelectionResponse categorySelectionResponse = (CategorySelectionResponse) o;
    return Objects.equals(this.playerId, categorySelectionResponse.playerId) &&
        Objects.equals(this.selectedBranches, categorySelectionResponse.selectedBranches);
  }

  @Override
  public int hashCode() {
    return Objects.hash(playerId, selectedBranches);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CategorySelectionResponse {\n");
    sb.append("    playerId: ").append(toIndentedString(playerId)).append("\n");
    sb.append("    selectedBranches: ").append(toIndentedString(selectedBranches)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

