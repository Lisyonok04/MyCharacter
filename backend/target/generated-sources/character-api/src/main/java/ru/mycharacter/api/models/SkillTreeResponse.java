package ru.mycharacter.api.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.lang.Nullable;
import ru.mycharacter.api.models.SkillNodeDto;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * SkillTreeResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-11-21T13:37:28.624293319Z[Etc/UTC]", comments = "Generator version: 7.12.0")
public class SkillTreeResponse {

  @Valid
  private List<@Valid SkillNodeDto> nodes = new ArrayList<>();

  public SkillTreeResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public SkillTreeResponse(List<@Valid SkillNodeDto> nodes) {
    this.nodes = nodes;
  }

  public SkillTreeResponse nodes(List<@Valid SkillNodeDto> nodes) {
    this.nodes = nodes;
    return this;
  }

  public SkillTreeResponse addNodesItem(SkillNodeDto nodesItem) {
    if (this.nodes == null) {
      this.nodes = new ArrayList<>();
    }
    this.nodes.add(nodesItem);
    return this;
  }

  /**
   * Get nodes
   * @return nodes
   */
  @NotNull @Valid 
  @Schema(name = "nodes", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("nodes")
  public List<@Valid SkillNodeDto> getNodes() {
    return nodes;
  }

  public void setNodes(List<@Valid SkillNodeDto> nodes) {
    this.nodes = nodes;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SkillTreeResponse skillTreeResponse = (SkillTreeResponse) o;
    return Objects.equals(this.nodes, skillTreeResponse.nodes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nodes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SkillTreeResponse {\n");
    sb.append("    nodes: ").append(toIndentedString(nodes)).append("\n");
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

