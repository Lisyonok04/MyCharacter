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
 * TaskDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-11-21T13:37:28.624293319Z[Etc/UTC]", comments = "Generator version: 7.12.0")
public class TaskDto {

  private Long id;

  private Long branchId;

  private String branchCode;

  private String branchName;

  private String title;

  private @Nullable String description;

  private Integer difficulty;

  private Integer baseXp;

  private Boolean completedToday;

  public TaskDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public TaskDto(Long id, Long branchId, String branchCode, String branchName, String title, Integer difficulty, Integer baseXp, Boolean completedToday) {
    this.id = id;
    this.branchId = branchId;
    this.branchCode = branchCode;
    this.branchName = branchName;
    this.title = title;
    this.difficulty = difficulty;
    this.baseXp = baseXp;
    this.completedToday = completedToday;
  }

  public TaskDto id(Long id) {
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

  public TaskDto branchId(Long branchId) {
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

  public TaskDto branchCode(String branchCode) {
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

  public TaskDto branchName(String branchName) {
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

  public TaskDto title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
   */
  @NotNull 
  @Schema(name = "title", example = "Утренняя пробежка 3 км", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public TaskDto description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
   */
  
  @Schema(name = "description", example = "Пробежать дистанцию 3 км в комфортном темпе", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public TaskDto difficulty(Integer difficulty) {
    this.difficulty = difficulty;
    return this;
  }

  /**
   * Get difficulty
   * @return difficulty
   */
  @NotNull 
  @Schema(name = "difficulty", example = "2", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("difficulty")
  public Integer getDifficulty() {
    return difficulty;
  }

  public void setDifficulty(Integer difficulty) {
    this.difficulty = difficulty;
  }

  public TaskDto baseXp(Integer baseXp) {
    this.baseXp = baseXp;
    return this;
  }

  /**
   * Get baseXp
   * @return baseXp
   */
  @NotNull 
  @Schema(name = "baseXp", example = "40", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("baseXp")
  public Integer getBaseXp() {
    return baseXp;
  }

  public void setBaseXp(Integer baseXp) {
    this.baseXp = baseXp;
  }

  public TaskDto completedToday(Boolean completedToday) {
    this.completedToday = completedToday;
    return this;
  }

  /**
   * Get completedToday
   * @return completedToday
   */
  @NotNull 
  @Schema(name = "completedToday", example = "false", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("completedToday")
  public Boolean getCompletedToday() {
    return completedToday;
  }

  public void setCompletedToday(Boolean completedToday) {
    this.completedToday = completedToday;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaskDto taskDto = (TaskDto) o;
    return Objects.equals(this.id, taskDto.id) &&
        Objects.equals(this.branchId, taskDto.branchId) &&
        Objects.equals(this.branchCode, taskDto.branchCode) &&
        Objects.equals(this.branchName, taskDto.branchName) &&
        Objects.equals(this.title, taskDto.title) &&
        Objects.equals(this.description, taskDto.description) &&
        Objects.equals(this.difficulty, taskDto.difficulty) &&
        Objects.equals(this.baseXp, taskDto.baseXp) &&
        Objects.equals(this.completedToday, taskDto.completedToday);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, branchId, branchCode, branchName, title, description, difficulty, baseXp, completedToday);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaskDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    branchId: ").append(toIndentedString(branchId)).append("\n");
    sb.append("    branchCode: ").append(toIndentedString(branchCode)).append("\n");
    sb.append("    branchName: ").append(toIndentedString(branchName)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    difficulty: ").append(toIndentedString(difficulty)).append("\n");
    sb.append("    baseXp: ").append(toIndentedString(baseXp)).append("\n");
    sb.append("    completedToday: ").append(toIndentedString(completedToday)).append("\n");
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

