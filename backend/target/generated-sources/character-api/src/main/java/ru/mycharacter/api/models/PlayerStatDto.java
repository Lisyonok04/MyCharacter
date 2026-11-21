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
 * PlayerStatDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-11-21T13:37:28.624293319Z[Etc/UTC]", comments = "Generator version: 7.12.0")
public class PlayerStatDto {

  private String statCode;

  private String statName;

  private Integer currentValue;

  private Integer currentXp;

  public PlayerStatDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public PlayerStatDto(String statCode, String statName, Integer currentValue, Integer currentXp) {
    this.statCode = statCode;
    this.statName = statName;
    this.currentValue = currentValue;
    this.currentXp = currentXp;
  }

  public PlayerStatDto statCode(String statCode) {
    this.statCode = statCode;
    return this;
  }

  /**
   * Get statCode
   * @return statCode
   */
  @NotNull 
  @Schema(name = "statCode", example = "STR", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("statCode")
  public String getStatCode() {
    return statCode;
  }

  public void setStatCode(String statCode) {
    this.statCode = statCode;
  }

  public PlayerStatDto statName(String statName) {
    this.statName = statName;
    return this;
  }

  /**
   * Get statName
   * @return statName
   */
  @NotNull 
  @Schema(name = "statName", example = "Сила и выносливость", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("statName")
  public String getStatName() {
    return statName;
  }

  public void setStatName(String statName) {
    this.statName = statName;
  }

  public PlayerStatDto currentValue(Integer currentValue) {
    this.currentValue = currentValue;
    return this;
  }

  /**
   * Get currentValue
   * @return currentValue
   */
  @NotNull 
  @Schema(name = "currentValue", example = "4", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("currentValue")
  public Integer getCurrentValue() {
    return currentValue;
  }

  public void setCurrentValue(Integer currentValue) {
    this.currentValue = currentValue;
  }

  public PlayerStatDto currentXp(Integer currentXp) {
    this.currentXp = currentXp;
    return this;
  }

  /**
   * Get currentXp
   * @return currentXp
   */
  @NotNull 
  @Schema(name = "currentXp", example = "120", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("currentXp")
  public Integer getCurrentXp() {
    return currentXp;
  }

  public void setCurrentXp(Integer currentXp) {
    this.currentXp = currentXp;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlayerStatDto playerStatDto = (PlayerStatDto) o;
    return Objects.equals(this.statCode, playerStatDto.statCode) &&
        Objects.equals(this.statName, playerStatDto.statName) &&
        Objects.equals(this.currentValue, playerStatDto.currentValue) &&
        Objects.equals(this.currentXp, playerStatDto.currentXp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(statCode, statName, currentValue, currentXp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlayerStatDto {\n");
    sb.append("    statCode: ").append(toIndentedString(statCode)).append("\n");
    sb.append("    statName: ").append(toIndentedString(statName)).append("\n");
    sb.append("    currentValue: ").append(toIndentedString(currentValue)).append("\n");
    sb.append("    currentXp: ").append(toIndentedString(currentXp)).append("\n");
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

