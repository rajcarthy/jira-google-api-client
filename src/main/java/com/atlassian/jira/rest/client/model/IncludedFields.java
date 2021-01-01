/*
 * The Jira Cloud platform REST API
 * Jira Cloud platform REST API documentation
 *
 * The version of the OpenAPI document: 1001.0.0-SNAPSHOT
 * Contact: ecosystem@atlassian.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.atlassian.jira.rest.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * IncludedFields
 */
@JsonPropertyOrder({
  IncludedFields.JSON_PROPERTY_INCLUDED,
  IncludedFields.JSON_PROPERTY_EXCLUDED,
  IncludedFields.JSON_PROPERTY_ACTUALLY_INCLUDED
})
@JsonTypeName("IncludedFields")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-12-31T17:44:39.790417-08:00[America/Los_Angeles]")
public class IncludedFields {
  public static final String JSON_PROPERTY_INCLUDED = "included";
  private Set<String> included = null;

  public static final String JSON_PROPERTY_EXCLUDED = "excluded";
  private Set<String> excluded = null;

  public static final String JSON_PROPERTY_ACTUALLY_INCLUDED = "actuallyIncluded";
  private Set<String> actuallyIncluded = null;


  public IncludedFields included(Set<String> included) {
    
    this.included = included;
    return this;
  }

  public IncludedFields addIncludedItem(String includedItem) {
    if (this.included == null) {
      this.included = new LinkedHashSet<>();
    }
    this.included.add(includedItem);
    return this;
  }

   /**
   * Get included
   * @return included
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_INCLUDED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Set<String> getIncluded() {
    return included;
  }


  public void setIncluded(Set<String> included) {
    this.included = included;
  }


  public IncludedFields excluded(Set<String> excluded) {
    
    this.excluded = excluded;
    return this;
  }

  public IncludedFields addExcludedItem(String excludedItem) {
    if (this.excluded == null) {
      this.excluded = new LinkedHashSet<>();
    }
    this.excluded.add(excludedItem);
    return this;
  }

   /**
   * Get excluded
   * @return excluded
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_EXCLUDED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Set<String> getExcluded() {
    return excluded;
  }


  public void setExcluded(Set<String> excluded) {
    this.excluded = excluded;
  }


  public IncludedFields actuallyIncluded(Set<String> actuallyIncluded) {
    
    this.actuallyIncluded = actuallyIncluded;
    return this;
  }

  public IncludedFields addActuallyIncludedItem(String actuallyIncludedItem) {
    if (this.actuallyIncluded == null) {
      this.actuallyIncluded = new LinkedHashSet<>();
    }
    this.actuallyIncluded.add(actuallyIncludedItem);
    return this;
  }

   /**
   * Get actuallyIncluded
   * @return actuallyIncluded
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ACTUALLY_INCLUDED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Set<String> getActuallyIncluded() {
    return actuallyIncluded;
  }


  public void setActuallyIncluded(Set<String> actuallyIncluded) {
    this.actuallyIncluded = actuallyIncluded;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IncludedFields includedFields = (IncludedFields) o;
    return Objects.equals(this.included, includedFields.included) &&
        Objects.equals(this.excluded, includedFields.excluded) &&
        Objects.equals(this.actuallyIncluded, includedFields.actuallyIncluded);
  }

  @Override
  public int hashCode() {
    return Objects.hash(included, excluded, actuallyIncluded);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IncludedFields {\n");
    sb.append("    included: ").append(toIndentedString(included)).append("\n");
    sb.append("    excluded: ").append(toIndentedString(excluded)).append("\n");
    sb.append("    actuallyIncluded: ").append(toIndentedString(actuallyIncluded)).append("\n");
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
