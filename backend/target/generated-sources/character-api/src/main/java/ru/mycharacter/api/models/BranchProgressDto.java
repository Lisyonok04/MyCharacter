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
 * BranchProgressDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-11-21T13:37:28.624293319Z[Etc/UTC]", comments = "Generator version: 7.12.0")
public class BranchProgressDto {

  private Long branchId;

  private String code;

  private String name;

  private Integer branchLevel;

  private Integer branchXp;

  public BranchProgressDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public BranchProgressDto(Long branchId, String code, String name, Integer branchLevel, Integer branchXp) {
    this.branchId = branchId;
    this.code = code;
    this.name = name;
    this.branchLevel = branchLevel;
    this.branchXp = branchXp;
  }

  public BranchProgressDto branchId(Long branchId) {
    this.branchId = branchId;
    return this;
  }

  /**
   * Get branchId
   * @return branchId
   */
  @NotNull 
  @Schema(name = "branchId", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("branchId")
  public Long getBranchId() {
    return branchId;
  }

  public void setBranchId(Long branchId) {
    this.branchId = branchId;
  }

  public BranchProgressDto code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Get code
   * @return code
   */
  @NotNull 
  @Schema(name = "code", example = "FITNESS", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("code")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public BranchProgressDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   */
  @NotNull 
  @Schema(name = "name", example = "Спорт и здоровье", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BranchProgressDto branchLevel(Integer branchLevel) {
    this.branchLevel = branchLevel;
    return this;
  }

  /**
   * Get branchLevel
   * @return branchLevel
   */
  @NotNull 
  @Schema(name = "branchLevel", example = "2", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("branchLevel")
  public Integer getBranchLevel() {
    return branchLevel;
  }

  public void setBranchLevel(Integer branchLevel) {
    this.branchLevel = branchLevel;
  }

  public BranchProgressDto branchXp(Integer branchXp) {
    this.branchXp = branchXp;
    return this;
  }

  /**
   * Get branchXp
   * @return branchXp
   */
  @NotNull 
  @Schema(name = "branchXp", example = "120", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("branchXp")
  public Integer getBranchXp() {
    return branchXp;
  }

  public void setBranchXp(Integer branchXp) {
    this.branchXp = branchXp;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BranchProgressDto branchProgressDto = (BranchProgressDto) o;
    return Objects.equals(this.branchId, branchProgressDto.branchId) &&
        Objects.equals(this.code, branchProgressDto.code) &&
        Objects.equals(this.name, branchProgressDto.name) &&
        Objects.equals(this.branchLevel, branchProgressDto.branchLevel) &&
        Objects.equals(this.branchXp, branchProgressDto.branchXp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(branchId, code, name, branchLevel, branchXp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BranchProgressDto {\n");
    sb.append("    branchId: ").append(toIndentedString(branchId)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    branchLevel: ").append(toIndentedString(branchLevel)).append("\n");
    sb.append("    branchXp: ").append(toIndentedString(branchXp)).append("\n");
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

