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
import ru.mycharacter.api.models.PlayerStatDto;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CharacterProfileResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-11-21T13:37:28.624293319Z[Etc/UTC]", comments = "Generator version: 7.12.0")
public class CharacterProfileResponse {

  private Long id;

  private String nickname;

  private String characterName;

  private Integer level;

  private Integer totalXp;

  private Integer nextLevelXp;

  private Integer xpIntoLevel;

  private Integer xpForNextLevel;

  private Integer progressPercent;

  private Integer currentStreak;

  @Valid
  private List<@Valid PlayerStatDto> stats = new ArrayList<>();

  @Valid
  private List<@Valid BranchProgressDto> selectedBranches = new ArrayList<>();

  public CharacterProfileResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CharacterProfileResponse(Long id, String nickname, String characterName, Integer level, Integer totalXp, Integer nextLevelXp, Integer xpIntoLevel, Integer xpForNextLevel, Integer progressPercent, Integer currentStreak, List<@Valid PlayerStatDto> stats, List<@Valid BranchProgressDto> selectedBranches) {
    this.id = id;
    this.nickname = nickname;
    this.characterName = characterName;
    this.level = level;
    this.totalXp = totalXp;
    this.nextLevelXp = nextLevelXp;
    this.xpIntoLevel = xpIntoLevel;
    this.xpForNextLevel = xpForNextLevel;
    this.progressPercent = progressPercent;
    this.currentStreak = currentStreak;
    this.stats = stats;
    this.selectedBranches = selectedBranches;
  }

  public CharacterProfileResponse id(Long id) {
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

  public CharacterProfileResponse nickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

  /**
   * Get nickname
   * @return nickname
   */
  @NotNull 
  @Schema(name = "nickname", example = "Hero", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("nickname")
  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public CharacterProfileResponse characterName(String characterName) {
    this.characterName = characterName;
    return this;
  }

  /**
   * Get characterName
   * @return characterName
   */
  @NotNull 
  @Schema(name = "characterName", example = "Авантюрист", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("characterName")
  public String getCharacterName() {
    return characterName;
  }

  public void setCharacterName(String characterName) {
    this.characterName = characterName;
  }

  public CharacterProfileResponse level(Integer level) {
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

  public CharacterProfileResponse totalXp(Integer totalXp) {
    this.totalXp = totalXp;
    return this;
  }

  /**
   * Get totalXp
   * @return totalXp
   */
  @NotNull 
  @Schema(name = "totalXp", example = "300", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("totalXp")
  public Integer getTotalXp() {
    return totalXp;
  }

  public void setTotalXp(Integer totalXp) {
    this.totalXp = totalXp;
  }

  public CharacterProfileResponse nextLevelXp(Integer nextLevelXp) {
    this.nextLevelXp = nextLevelXp;
    return this;
  }

  /**
   * Суммарный XP, необходимый для следующего уровня
   * @return nextLevelXp
   */
  @NotNull 
  @Schema(name = "nextLevelXp", example = "520", description = "Суммарный XP, необходимый для следующего уровня", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("nextLevelXp")
  public Integer getNextLevelXp() {
    return nextLevelXp;
  }

  public void setNextLevelXp(Integer nextLevelXp) {
    this.nextLevelXp = nextLevelXp;
  }

  public CharacterProfileResponse xpIntoLevel(Integer xpIntoLevel) {
    this.xpIntoLevel = xpIntoLevel;
    return this;
  }

  /**
   * Сколько XP набрано внутри текущего уровня
   * @return xpIntoLevel
   */
  @NotNull 
  @Schema(name = "xpIntoLevel", example = "17", description = "Сколько XP набрано внутри текущего уровня", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("xpIntoLevel")
  public Integer getXpIntoLevel() {
    return xpIntoLevel;
  }

  public void setXpIntoLevel(Integer xpIntoLevel) {
    this.xpIntoLevel = xpIntoLevel;
  }

  public CharacterProfileResponse xpForNextLevel(Integer xpForNextLevel) {
    this.xpForNextLevel = xpForNextLevel;
    return this;
  }

  /**
   * Сколько XP нужно набрать внутри текущего уровня до следующего
   * @return xpForNextLevel
   */
  @NotNull 
  @Schema(name = "xpForNextLevel", example = "237", description = "Сколько XP нужно набрать внутри текущего уровня до следующего", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("xpForNextLevel")
  public Integer getXpForNextLevel() {
    return xpForNextLevel;
  }

  public void setXpForNextLevel(Integer xpForNextLevel) {
    this.xpForNextLevel = xpForNextLevel;
  }

  public CharacterProfileResponse progressPercent(Integer progressPercent) {
    this.progressPercent = progressPercent;
    return this;
  }

  /**
   * Прогресс до следующего уровня в процентах (0-100)
   * @return progressPercent
   */
  @NotNull 
  @Schema(name = "progressPercent", example = "7", description = "Прогресс до следующего уровня в процентах (0-100)", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("progressPercent")
  public Integer getProgressPercent() {
    return progressPercent;
  }

  public void setProgressPercent(Integer progressPercent) {
    this.progressPercent = progressPercent;
  }

  public CharacterProfileResponse currentStreak(Integer currentStreak) {
    this.currentStreak = currentStreak;
    return this;
  }

  /**
   * Get currentStreak
   * @return currentStreak
   */
  @NotNull 
  @Schema(name = "currentStreak", example = "5", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("currentStreak")
  public Integer getCurrentStreak() {
    return currentStreak;
  }

  public void setCurrentStreak(Integer currentStreak) {
    this.currentStreak = currentStreak;
  }

  public CharacterProfileResponse stats(List<@Valid PlayerStatDto> stats) {
    this.stats = stats;
    return this;
  }

  public CharacterProfileResponse addStatsItem(PlayerStatDto statsItem) {
    if (this.stats == null) {
      this.stats = new ArrayList<>();
    }
    this.stats.add(statsItem);
    return this;
  }

  /**
   * Get stats
   * @return stats
   */
  @NotNull @Valid 
  @Schema(name = "stats", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("stats")
  public List<@Valid PlayerStatDto> getStats() {
    return stats;
  }

  public void setStats(List<@Valid PlayerStatDto> stats) {
    this.stats = stats;
  }

  public CharacterProfileResponse selectedBranches(List<@Valid BranchProgressDto> selectedBranches) {
    this.selectedBranches = selectedBranches;
    return this;
  }

  public CharacterProfileResponse addSelectedBranchesItem(BranchProgressDto selectedBranchesItem) {
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
    CharacterProfileResponse characterProfileResponse = (CharacterProfileResponse) o;
    return Objects.equals(this.id, characterProfileResponse.id) &&
        Objects.equals(this.nickname, characterProfileResponse.nickname) &&
        Objects.equals(this.characterName, characterProfileResponse.characterName) &&
        Objects.equals(this.level, characterProfileResponse.level) &&
        Objects.equals(this.totalXp, characterProfileResponse.totalXp) &&
        Objects.equals(this.nextLevelXp, characterProfileResponse.nextLevelXp) &&
        Objects.equals(this.xpIntoLevel, characterProfileResponse.xpIntoLevel) &&
        Objects.equals(this.xpForNextLevel, characterProfileResponse.xpForNextLevel) &&
        Objects.equals(this.progressPercent, characterProfileResponse.progressPercent) &&
        Objects.equals(this.currentStreak, characterProfileResponse.currentStreak) &&
        Objects.equals(this.stats, characterProfileResponse.stats) &&
        Objects.equals(this.selectedBranches, characterProfileResponse.selectedBranches);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nickname, characterName, level, totalXp, nextLevelXp, xpIntoLevel, xpForNextLevel, progressPercent, currentStreak, stats, selectedBranches);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CharacterProfileResponse {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nickname: ").append(toIndentedString(nickname)).append("\n");
    sb.append("    characterName: ").append(toIndentedString(characterName)).append("\n");
    sb.append("    level: ").append(toIndentedString(level)).append("\n");
    sb.append("    totalXp: ").append(toIndentedString(totalXp)).append("\n");
    sb.append("    nextLevelXp: ").append(toIndentedString(nextLevelXp)).append("\n");
    sb.append("    xpIntoLevel: ").append(toIndentedString(xpIntoLevel)).append("\n");
    sb.append("    xpForNextLevel: ").append(toIndentedString(xpForNextLevel)).append("\n");
    sb.append("    progressPercent: ").append(toIndentedString(progressPercent)).append("\n");
    sb.append("    currentStreak: ").append(toIndentedString(currentStreak)).append("\n");
    sb.append("    stats: ").append(toIndentedString(stats)).append("\n");
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

