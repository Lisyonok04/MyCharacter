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
 * StatChangeDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-11-21T13:37:28.624293319Z[Etc/UTC]", comments = "Generator version: 7.12.0")
public class StatChangeDto {

  private String statCode;

  private String statName;

  private Integer addedValue;

  private Integer newValue;

  private Integer addedXp;

  private Integer newXp;

  public StatChangeDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public StatChangeDto(String statCode, String statName, Integer addedValue, Integer newValue, Integer addedXp, Integer newXp) {
    this.statCode = statCode;
    this.statName = statName;
    this.addedValue = addedValue;
    this.newValue = newValue;
    this.addedXp = addedXp;
    this.newXp = newXp;
  }

  public StatChangeDto statCode(String statCode) {
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

  public StatChangeDto statName(String statName) {
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

  public StatChangeDto addedValue(Integer addedValue) {
    this.addedValue = addedValue;
    return this;
  }

  /**
   * Get addedValue
   * @return addedValue
   */
  @NotNull 
  @Schema(name = "addedValue", example = "2", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("addedValue")
  public Integer getAddedValue() {
    return addedValue;
  }

  public void setAddedValue(Integer addedValue) {
    this.addedValue = addedValue;
  }

  public StatChangeDto newValue(Integer newValue) {
    this.newValue = newValue;
    return this;
  }

  /**
   * Get newValue
   * @return newValue
   */
  @NotNull 
  @Schema(name = "newValue", example = "6", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("newValue")
  public Integer getNewValue() {
    return newValue;
  }

  public void setNewValue(Integer newValue) {
    this.newValue = newValue;
  }

  public StatChangeDto addedXp(Integer addedXp) {
    this.addedXp = addedXp;
    return this;
  }

  /**
   * Get addedXp
   * @return addedXp
   */
  @NotNull 
  @Schema(name = "addedXp", example = "48", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("addedXp")
  public Integer getAddedXp() {
    return addedXp;
  }

  public void setAddedXp(Integer addedXp) {
    this.addedXp = addedXp;
  }

  public StatChangeDto newXp(Integer newXp) {
    this.newXp = newXp;
    return this;
  }

  /**
   * Get newXp
   * @return newXp
   */
  @NotNull 
  @Schema(name = "newXp", example = "168", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("newXp")
  public Integer getNewXp() {
    return newXp;
  }

  public void setNewXp(Integer newXp) {
    this.newXp = newXp;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StatChangeDto statChangeDto = (StatChangeDto) o;
    return Objects.equals(this.statCode, statChangeDto.statCode) &&
        Objects.equals(this.statName, statChangeDto.statName) &&
        Objects.equals(this.addedValue, statChangeDto.addedValue) &&
        Objects.equals(this.newValue, statChangeDto.newValue) &&
        Objects.equals(this.addedXp, statChangeDto.addedXp) &&
        Objects.equals(this.newXp, statChangeDto.newXp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(statCode, statName, addedValue, newValue, addedXp, newXp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StatChangeDto {\n");
    sb.append("    statCode: ").append(toIndentedString(statCode)).append("\n");
    sb.append("    statName: ").append(toIndentedString(statName)).append("\n");
    sb.append("    addedValue: ").append(toIndentedString(addedValue)).append("\n");
    sb.append("    newValue: ").append(toIndentedString(newValue)).append("\n");
    sb.append("    addedXp: ").append(toIndentedString(addedXp)).append("\n");
    sb.append("    newXp: ").append(toIndentedString(newXp)).append("\n");
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

