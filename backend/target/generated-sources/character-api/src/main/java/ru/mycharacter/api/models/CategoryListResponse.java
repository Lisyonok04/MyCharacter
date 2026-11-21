package ru.mycharacter.api.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.lang.Nullable;
import ru.mycharacter.api.models.CategoryDto;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CategoryListResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-11-21T13:37:28.624293319Z[Etc/UTC]", comments = "Generator version: 7.12.0")
public class CategoryListResponse {

  @Valid
  private List<@Valid CategoryDto> categories = new ArrayList<>();

  public CategoryListResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CategoryListResponse(List<@Valid CategoryDto> categories) {
    this.categories = categories;
  }

  public CategoryListResponse categories(List<@Valid CategoryDto> categories) {
    this.categories = categories;
    return this;
  }

  public CategoryListResponse addCategoriesItem(CategoryDto categoriesItem) {
    if (this.categories == null) {
      this.categories = new ArrayList<>();
    }
    this.categories.add(categoriesItem);
    return this;
  }

  /**
   * Get categories
   * @return categories
   */
  @NotNull @Valid 
  @Schema(name = "categories", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("categories")
  public List<@Valid CategoryDto> getCategories() {
    return categories;
  }

  public void setCategories(List<@Valid CategoryDto> categories) {
    this.categories = categories;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CategoryListResponse categoryListResponse = (CategoryListResponse) o;
    return Objects.equals(this.categories, categoryListResponse.categories);
  }

  @Override
  public int hashCode() {
    return Objects.hash(categories);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CategoryListResponse {\n");
    sb.append("    categories: ").append(toIndentedString(categories)).append("\n");
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

