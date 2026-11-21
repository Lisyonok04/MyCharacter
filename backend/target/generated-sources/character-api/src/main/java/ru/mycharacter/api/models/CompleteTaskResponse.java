package ru.mycharacter.api.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.lang.Nullable;
import ru.mycharacter.api.models.StatChangeDto;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CompleteTaskResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-11-21T13:37:28.624293319Z[Etc/UTC]", comments = "Generator version: 7.12.0")
public class CompleteTaskResponse {

  private Long taskId;

  private String taskTitle;

  private Integer xpAwarded;

  private Integer totalXp;

  private Integer level;

  private Integer oldLevel;

  private Integer newLevel;

  private Boolean levelUp;

  private Integer currentStreak;

  private Integer nextLevelXp;

  private Integer xpIntoLevel;

  private Integer xpForNextLevel;

  private Integer progressPercent;

  @Valid
  private List<@Valid StatChangeDto> statChanges = new ArrayList<>();

  public CompleteTaskResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CompleteTaskResponse(Long taskId, String taskTitle, Integer xpAwarded, Integer totalXp, Integer level, Integer oldLevel, Integer newLevel, Boolean levelUp, Integer currentStreak, Integer nextLevelXp, Integer xpIntoLevel, Integer xpForNextLevel, Integer progressPercent, List<@Valid StatChangeDto> statChanges) {
    this.taskId = taskId;
    this.taskTitle = taskTitle;
    this.xpAwarded = xpAwarded;
    this.totalXp = totalXp;
    this.level = level;
    this.oldLevel = oldLevel;
    this.newLevel = newLevel;
    this.levelUp = levelUp;
    this.currentStreak = currentStreak;
    this.nextLevelXp = nextLevelXp;
    this.xpIntoLevel = xpIntoLevel;
    this.xpForNextLevel = xpForNextLevel;
    this.progressPercent = progressPercent;
    this.statChanges = statChanges;
  }

  public CompleteTaskResponse taskId(Long taskId) {
    this.taskId = taskId;
    return this;
  }

  /**
   * Get taskId
   * @return taskId
   */
  @NotNull 
  @Schema(name = "taskId", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("taskId")
  public Long getTaskId() {
    return taskId;
  }

  public void setTaskId(Long taskId) {
    this.taskId = taskId;
  }

  public CompleteTaskResponse taskTitle(String taskTitle) {
    this.taskTitle = taskTitle;
    return this;
  }

  /**
   * Get taskTitle
   * @return taskTitle
   */
  @NotNull 
  @Schema(name = "taskTitle", example = "Утренняя пробежка 3 км", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("taskTitle")
  public String getTaskTitle() {
    return taskTitle;
  }

  public void setTaskTitle(String taskTitle) {
    this.taskTitle = taskTitle;
  }

  public CompleteTaskResponse xpAwarded(Integer xpAwarded) {
    this.xpAwarded = xpAwarded;
    return this;
  }

  /**
   * Get xpAwarded
   * @return xpAwarded
   */
  @NotNull 
  @Schema(name = "xpAwarded", example = "48", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("xpAwarded")
  public Integer getXpAwarded() {
    return xpAwarded;
  }

  public void setXpAwarded(Integer xpAwarded) {
    this.xpAwarded = xpAwarded;
  }

  public CompleteTaskResponse totalXp(Integer totalXp) {
    this.totalXp = totalXp;
    return this;
  }

  /**
   * Get totalXp
   * @return totalXp
   */
  @NotNull 
  @Schema(name = "totalXp", example = "348", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("totalXp")
  public Integer getTotalXp() {
    return totalXp;
  }

  public void setTotalXp(Integer totalXp) {
    this.totalXp = totalXp;
  }

  public CompleteTaskResponse level(Integer level) {
    this.level = level;
    return this;
  }

  /**
   * Get level
   * @return level
   */
  @NotNull 
  @Schema(name = "level", example = "3", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("level")
  public Integer getLevel() {
    return level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }

  public CompleteTaskResponse oldLevel(Integer oldLevel) {
    this.oldLevel = oldLevel;
    return this;
  }

  /**
   * Get oldLevel
   * @return oldLevel
   */
  @NotNull 
  @Schema(name = "oldLevel", example = "3", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("oldLevel")
  public Integer getOldLevel() {
    return oldLevel;
  }

  public void setOldLevel(Integer oldLevel) {
    this.oldLevel = oldLevel;
  }

  public CompleteTaskResponse newLevel(Integer newLevel) {
    this.newLevel = newLevel;
    return this;
  }

  /**
   * Get newLevel
   * @return newLevel
   */
  @NotNull 
  @Schema(name = "newLevel", example = "3", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("newLevel")
  public Integer getNewLevel() {
    return newLevel;
  }

  public void setNewLevel(Integer newLevel) {
    this.newLevel = newLevel;
  }

  public CompleteTaskResponse levelUp(Boolean levelUp) {
    this.levelUp = levelUp;
    return this;
  }

  /**
   * Get levelUp
   * @return levelUp
   */
  @NotNull 
  @Schema(name = "levelUp", example = "false", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("levelUp")
  public Boolean getLevelUp() {
    return levelUp;
  }

  public void setLevelUp(Boolean levelUp) {
    this.levelUp = levelUp;
  }

  public CompleteTaskResponse currentStreak(Integer currentStreak) {
    this.currentStreak = currentStreak;
    return this;
  }

  /**
   * Get currentStreak
   * @return currentStreak
   */
  @NotNull 
  @Schema(name = "currentStreak", example = "6", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("currentStreak")
  public Integer getCurrentStreak() {
    return currentStreak;
  }

  public void setCurrentStreak(Integer currentStreak) {
    this.currentStreak = currentStreak;
  }

  public CompleteTaskResponse nextLevelXp(Integer nextLevelXp) {
    this.nextLevelXp = nextLevelXp;
    return this;
  }

  /**
   * Get nextLevelXp
   * @return nextLevelXp
   */
  @NotNull 
  @Schema(name = "nextLevelXp", example = "520", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("nextLevelXp")
  public Integer getNextLevelXp() {
    return nextLevelXp;
  }

  public void setNextLevelXp(Integer nextLevelXp) {
    this.nextLevelXp = nextLevelXp;
  }

  public CompleteTaskResponse xpIntoLevel(Integer xpIntoLevel) {
    this.xpIntoLevel = xpIntoLevel;
    return this;
  }

  /**
   * Get xpIntoLevel
   * @return xpIntoLevel
   */
  @NotNull 
  @Schema(name = "xpIntoLevel", example = "65", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("xpIntoLevel")
  public Integer getXpIntoLevel() {
    return xpIntoLevel;
  }

  public void setXpIntoLevel(Integer xpIntoLevel) {
    this.xpIntoLevel = xpIntoLevel;
  }

  public CompleteTaskResponse xpForNextLevel(Integer xpForNextLevel) {
    this.xpForNextLevel = xpForNextLevel;
    return this;
  }

  /**
   * Get xpForNextLevel
   * @return xpForNextLevel
   */
  @NotNull 
  @Schema(name = "xpForNextLevel", example = "237", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("xpForNextLevel")
  public Integer getXpForNextLevel() {
    return xpForNextLevel;
  }

  public void setXpForNextLevel(Integer xpForNextLevel) {
    this.xpForNextLevel = xpForNextLevel;
  }

  public CompleteTaskResponse progressPercent(Integer progressPercent) {
    this.progressPercent = progressPercent;
    return this;
  }

  /**
   * Get progressPercent
   * @return progressPercent
   */
  @NotNull 
  @Schema(name = "progressPercent", example = "27", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("progressPercent")
  public Integer getProgressPercent() {
    return progressPercent;
  }

  public void setProgressPercent(Integer progressPercent) {
    this.progressPercent = progressPercent;
  }

  public CompleteTaskResponse statChanges(List<@Valid StatChangeDto> statChanges) {
    this.statChanges = statChanges;
    return this;
  }

  public CompleteTaskResponse addStatChangesItem(StatChangeDto statChangesItem) {
    if (this.statChanges == null) {
      this.statChanges = new ArrayList<>();
    }
    this.statChanges.add(statChangesItem);
    return this;
  }

  /**
   * Get statChanges
   * @return statChanges
   */
  @NotNull @Valid 
  @Schema(name = "statChanges", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("statChanges")
  public List<@Valid StatChangeDto> getStatChanges() {
    return statChanges;
  }

  public void setStatChanges(List<@Valid StatChangeDto> statChanges) {
    this.statChanges = statChanges;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CompleteTaskResponse completeTaskResponse = (CompleteTaskResponse) o;
    return Objects.equals(this.taskId, completeTaskResponse.taskId) &&
        Objects.equals(this.taskTitle, completeTaskResponse.taskTitle) &&
        Objects.equals(this.xpAwarded, completeTaskResponse.xpAwarded) &&
        Objects.equals(this.totalXp, completeTaskResponse.totalXp) &&
        Objects.equals(this.level, completeTaskResponse.level) &&
        Objects.equals(this.oldLevel, completeTaskResponse.oldLevel) &&
        Objects.equals(this.newLevel, completeTaskResponse.newLevel) &&
        Objects.equals(this.levelUp, completeTaskResponse.levelUp) &&
        Objects.equals(this.currentStreak, completeTaskResponse.currentStreak) &&
        Objects.equals(this.nextLevelXp, completeTaskResponse.nextLevelXp) &&
        Objects.equals(this.xpIntoLevel, completeTaskResponse.xpIntoLevel) &&
        Objects.equals(this.xpForNextLevel, completeTaskResponse.xpForNextLevel) &&
        Objects.equals(this.progressPercent, completeTaskResponse.progressPercent) &&
        Objects.equals(this.statChanges, completeTaskResponse.statChanges);
  }

  @Override
  public int hashCode() {
    return Objects.hash(taskId, taskTitle, xpAwarded, totalXp, level, oldLevel, newLevel, levelUp, currentStreak, nextLevelXp, xpIntoLevel, xpForNextLevel, progressPercent, statChanges);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CompleteTaskResponse {\n");
    sb.append("    taskId: ").append(toIndentedString(taskId)).append("\n");
    sb.append("    taskTitle: ").append(toIndentedString(taskTitle)).append("\n");
    sb.append("    xpAwarded: ").append(toIndentedString(xpAwarded)).append("\n");
    sb.append("    totalXp: ").append(toIndentedString(totalXp)).append("\n");
    sb.append("    level: ").append(toIndentedString(level)).append("\n");
    sb.append("    oldLevel: ").append(toIndentedString(oldLevel)).append("\n");
    sb.append("    newLevel: ").append(toIndentedString(newLevel)).append("\n");
    sb.append("    levelUp: ").append(toIndentedString(levelUp)).append("\n");
    sb.append("    currentStreak: ").append(toIndentedString(currentStreak)).append("\n");
    sb.append("    nextLevelXp: ").append(toIndentedString(nextLevelXp)).append("\n");
    sb.append("    xpIntoLevel: ").append(toIndentedString(xpIntoLevel)).append("\n");
    sb.append("    xpForNextLevel: ").append(toIndentedString(xpForNextLevel)).append("\n");
    sb.append("    progressPercent: ").append(toIndentedString(progressPercent)).append("\n");
    sb.append("    statChanges: ").append(toIndentedString(statChanges)).append("\n");
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

