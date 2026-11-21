package ru.mycharacter.api.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.lang.Nullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CategorySelectionRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-11-21T13:37:28.624293319Z[Etc/UTC]", comments = "Generator version: 7.12.0")
public class CategorySelectionRequest {

  private Long playerId;

  @Valid
  private List<Long> branchIds = new ArrayList<>();

  public CategorySelectionRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CategorySelectionRequest(Long playerId, List<Long> branchIds) {
    this.playerId = playerId;
    this.branchIds = branchIds;
  }

  public CategorySelectionRequest playerId(Long playerId) {
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

  public CategorySelectionRequest branchIds(List<Long> branchIds) {
    this.branchIds = branchIds;
    return this;
  }

  public CategorySelectionRequest addBranchIdsItem(Long branchIdsItem) {
    if (this.branchIds == null) {
      this.branchIds = new ArrayList<>();
    }
    this.branchIds.add(branchIdsItem);
    return this;
  }

  /**
   * Get branchIds
   * @return branchIds
   */
  @NotNull @Size(min = 1, max = 3) 
  @Schema(name = "branchIds", example = "[1,2,3]", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("branchIds")
  public List<Long> getBranchIds() {
    return branchIds;
  }

  public void setBranchIds(List<Long> branchIds) {
    this.branchIds = branchIds;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CategorySelectionRequest categorySelectionRequest = (CategorySelectionRequest) o;
    return Objects.equals(this.playerId, categorySelectionRequest.playerId) &&
        Objects.equals(this.branchIds, categorySelectionRequest.branchIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(playerId, branchIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CategorySelectionRequest {\n");
    sb.append("    playerId: ").append(toIndentedString(playerId)).append("\n");
    sb.append("    branchIds: ").append(toIndentedString(branchIds)).append("\n");
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

