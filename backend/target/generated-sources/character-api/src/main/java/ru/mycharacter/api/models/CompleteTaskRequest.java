package ru.mycharacter.api.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.lang.Nullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CompleteTaskRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-11-21T13:37:28.624293319Z[Etc/UTC]", comments = "Generator version: 7.12.0")
public class CompleteTaskRequest {

  private Long playerId;

  public CompleteTaskRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CompleteTaskRequest(Long playerId) {
    this.playerId = playerId;
  }

  public CompleteTaskRequest playerId(Long playerId) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CompleteTaskRequest completeTaskRequest = (CompleteTaskRequest) o;
    return Objects.equals(this.playerId, completeTaskRequest.playerId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(playerId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CompleteTaskRequest {\n");
    sb.append("    playerId: ").append(toIndentedString(playerId)).append("\n");
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

