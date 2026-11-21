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
 * CategoryDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-11-21T13:37:28.624293319Z[Etc/UTC]", comments = "Generator version: 7.12.0")
public class CategoryDto {

  private Long branchId;

  private String code;

  private String name;

  private @Nullable String description;

  private Boolean selected;

  public CategoryDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CategoryDto(Long branchId, String code, String name, Boolean selected) {
    this.branchId = branchId;
    this.code = code;
    this.name = name;
    this.selected = selected;
  }

  public CategoryDto branchId(Long branchId) {
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

  public CategoryDto code(String code) {
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

  public CategoryDto name(String name) {
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

  public CategoryDto description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
   */
  
  @Schema(name = "description", example = "Физические тренировки, бег, режим и выносливость", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public CategoryDto selected(Boolean selected) {
    this.selected = selected;
    return this;
  }

  /**
   * Get selected
   * @return selected
   */
  @NotNull 
  @Schema(name = "selected", example = "true", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("selected")
  public Boolean getSelected() {
    return selected;
  }

  public void setSelected(Boolean selected) {
    this.selected = selected;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CategoryDto categoryDto = (CategoryDto) o;
    return Objects.equals(this.branchId, categoryDto.branchId) &&
        Objects.equals(this.code, categoryDto.code) &&
        Objects.equals(this.name, categoryDto.name) &&
        Objects.equals(this.description, categoryDto.description) &&
        Objects.equals(this.selected, categoryDto.selected);
  }

  @Override
  public int hashCode() {
    return Objects.hash(branchId, code, name, description, selected);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CategoryDto {\n");
    sb.append("    branchId: ").append(toIndentedString(branchId)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    selected: ").append(toIndentedString(selected)).append("\n");
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

