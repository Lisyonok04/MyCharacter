package ru.mycharacter.api.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
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
 * SkillNodeDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-11-21T13:37:28.624293319Z[Etc/UTC]", comments = "Generator version: 7.12.0")
public class SkillNodeDto {

  private Long id;

  private Long branchId;

  private String branchCode;

  private String branchName;

  private String code;

  private String name;

  private @Nullable String description;

  private Integer requiredBranchLevel;

  private Integer requiredPlayerLevel;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    UNLOCKED("UNLOCKED"),
    
    AVAILABLE("AVAILABLE"),
    
    LOCKED("LOCKED");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private StatusEnum status;

  @Valid
  private List<Long> dependencies = new ArrayList<>();

  private @Nullable Integer sortOrder;

  public SkillNodeDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public SkillNodeDto(Long id, Long branchId, String branchCode, String branchName, String code, String name, Integer requiredBranchLevel, Integer requiredPlayerLevel, StatusEnum status, List<Long> dependencies) {
    this.id = id;
    this.branchId = branchId;
    this.branchCode = branchCode;
    this.branchName = branchName;
    this.code = code;
    this.name = name;
    this.requiredBranchLevel = requiredBranchLevel;
    this.requiredPlayerLevel = requiredPlayerLevel;
    this.status = status;
    this.dependencies = dependencies;
  }

  public SkillNodeDto id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  @NotNull 
  @Schema(name = "id", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public SkillNodeDto branchId(Long branchId) {
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

  public SkillNodeDto branchCode(String branchCode) {
    this.branchCode = branchCode;
    return this;
  }

  /**
   * Get branchCode
   * @return branchCode
   */
  @NotNull 
  @Schema(name = "branchCode", example = "FITNESS", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("branchCode")
  public String getBranchCode() {
    return branchCode;
  }

  public void setBranchCode(String branchCode) {
    this.branchCode = branchCode;
  }

  public SkillNodeDto branchName(String branchName) {
    this.branchName = branchName;
    return this;
  }

  /**
   * Get branchName
   * @return branchName
   */
  @NotNull 
  @Schema(name = "branchName", example = "Спорт и здоровье", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("branchName")
  public String getBranchName() {
    return branchName;
  }

  public void setBranchName(String branchName) {
    this.branchName = branchName;
  }

  public SkillNodeDto code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Get code
   * @return code
   */
  @NotNull 
  @Schema(name = "code", example = "FIT_START", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("code")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public SkillNodeDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   */
  @NotNull 
  @Schema(name = "name", example = "Первый шаг", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public SkillNodeDto description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
   */
  
  @Schema(name = "description", example = "Базовые тренировки и режим", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public SkillNodeDto requiredBranchLevel(Integer requiredBranchLevel) {
    this.requiredBranchLevel = requiredBranchLevel;
    return this;
  }

  /**
   * Get requiredBranchLevel
   * @return requiredBranchLevel
   */
  @NotNull 
  @Schema(name = "requiredBranchLevel", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("requiredBranchLevel")
  public Integer getRequiredBranchLevel() {
    return requiredBranchLevel;
  }

  public void setRequiredBranchLevel(Integer requiredBranchLevel) {
    this.requiredBranchLevel = requiredBranchLevel;
  }

  public SkillNodeDto requiredPlayerLevel(Integer requiredPlayerLevel) {
    this.requiredPlayerLevel = requiredPlayerLevel;
    return this;
  }

  /**
   * Get requiredPlayerLevel
   * @return requiredPlayerLevel
   */
  @NotNull 
  @Schema(name = "requiredPlayerLevel", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("requiredPlayerLevel")
  public Integer getRequiredPlayerLevel() {
    return requiredPlayerLevel;
  }

  public void setRequiredPlayerLevel(Integer requiredPlayerLevel) {
    this.requiredPlayerLevel = requiredPlayerLevel;
  }

  public SkillNodeDto status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
   */
  @NotNull 
  @Schema(name = "status", example = "UNLOCKED", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("status")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public SkillNodeDto dependencies(List<Long> dependencies) {
    this.dependencies = dependencies;
    return this;
  }

  public SkillNodeDto addDependenciesItem(Long dependenciesItem) {
    if (this.dependencies == null) {
      this.dependencies = new ArrayList<>();
    }
    this.dependencies.add(dependenciesItem);
    return this;
  }

  /**
   * Get dependencies
   * @return dependencies
   */
  @NotNull 
  @Schema(name = "dependencies", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("dependencies")
  public List<Long> getDependencies() {
    return dependencies;
  }

  public void setDependencies(List<Long> dependencies) {
    this.dependencies = dependencies;
  }

  public SkillNodeDto sortOrder(Integer sortOrder) {
    this.sortOrder = sortOrder;
    return this;
  }

  /**
   * Get sortOrder
   * @return sortOrder
   */
  
  @Schema(name = "sortOrder", example = "1", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("sortOrder")
  public Integer getSortOrder() {
    return sortOrder;
  }

  public void setSortOrder(Integer sortOrder) {
    this.sortOrder = sortOrder;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SkillNodeDto skillNodeDto = (SkillNodeDto) o;
    return Objects.equals(this.id, skillNodeDto.id) &&
        Objects.equals(this.branchId, skillNodeDto.branchId) &&
        Objects.equals(this.branchCode, skillNodeDto.branchCode) &&
        Objects.equals(this.branchName, skillNodeDto.branchName) &&
        Objects.equals(this.code, skillNodeDto.code) &&
        Objects.equals(this.name, skillNodeDto.name) &&
        Objects.equals(this.description, skillNodeDto.description) &&
        Objects.equals(this.requiredBranchLevel, skillNodeDto.requiredBranchLevel) &&
        Objects.equals(this.requiredPlayerLevel, skillNodeDto.requiredPlayerLevel) &&
        Objects.equals(this.status, skillNodeDto.status) &&
        Objects.equals(this.dependencies, skillNodeDto.dependencies) &&
        Objects.equals(this.sortOrder, skillNodeDto.sortOrder);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, branchId, branchCode, branchName, code, name, description, requiredBranchLevel, requiredPlayerLevel, status, dependencies, sortOrder);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SkillNodeDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    branchId: ").append(toIndentedString(branchId)).append("\n");
    sb.append("    branchCode: ").append(toIndentedString(branchCode)).append("\n");
    sb.append("    branchName: ").append(toIndentedString(branchName)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    requiredBranchLevel: ").append(toIndentedString(requiredBranchLevel)).append("\n");
    sb.append("    requiredPlayerLevel: ").append(toIndentedString(requiredPlayerLevel)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    dependencies: ").append(toIndentedString(dependencies)).append("\n");
    sb.append("    sortOrder: ").append(toIndentedString(sortOrder)).append("\n");
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

