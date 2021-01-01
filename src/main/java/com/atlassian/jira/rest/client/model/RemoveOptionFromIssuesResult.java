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
import com.atlassian.jira.rest.client.model.SimpleErrorCollection;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * RemoveOptionFromIssuesResult
 */
@JsonPropertyOrder({
  RemoveOptionFromIssuesResult.JSON_PROPERTY_MODIFIED_ISSUES,
  RemoveOptionFromIssuesResult.JSON_PROPERTY_UNMODIFIED_ISSUES,
  RemoveOptionFromIssuesResult.JSON_PROPERTY_ERRORS
})
@JsonTypeName("RemoveOptionFromIssuesResult")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-12-31T17:44:39.790417-08:00[America/Los_Angeles]")
public class RemoveOptionFromIssuesResult {
  public static final String JSON_PROPERTY_MODIFIED_ISSUES = "modifiedIssues";
  private List<Long> modifiedIssues = null;

  public static final String JSON_PROPERTY_UNMODIFIED_ISSUES = "unmodifiedIssues";
  private List<Long> unmodifiedIssues = null;

  public static final String JSON_PROPERTY_ERRORS = "errors";
  private SimpleErrorCollection errors = null;


  public RemoveOptionFromIssuesResult modifiedIssues(List<Long> modifiedIssues) {
    
    this.modifiedIssues = modifiedIssues;
    return this;
  }

  public RemoveOptionFromIssuesResult addModifiedIssuesItem(Long modifiedIssuesItem) {
    if (this.modifiedIssues == null) {
      this.modifiedIssues = new ArrayList<>();
    }
    this.modifiedIssues.add(modifiedIssuesItem);
    return this;
  }

   /**
   * The IDs of the modified issues.
   * @return modifiedIssues
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The IDs of the modified issues.")
  @JsonProperty(JSON_PROPERTY_MODIFIED_ISSUES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Long> getModifiedIssues() {
    return modifiedIssues;
  }


  public void setModifiedIssues(List<Long> modifiedIssues) {
    this.modifiedIssues = modifiedIssues;
  }


  public RemoveOptionFromIssuesResult unmodifiedIssues(List<Long> unmodifiedIssues) {
    
    this.unmodifiedIssues = unmodifiedIssues;
    return this;
  }

  public RemoveOptionFromIssuesResult addUnmodifiedIssuesItem(Long unmodifiedIssuesItem) {
    if (this.unmodifiedIssues == null) {
      this.unmodifiedIssues = new ArrayList<>();
    }
    this.unmodifiedIssues.add(unmodifiedIssuesItem);
    return this;
  }

   /**
   * The IDs of the unchanged issues, those issues where errors prevent modification.
   * @return unmodifiedIssues
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The IDs of the unchanged issues, those issues where errors prevent modification.")
  @JsonProperty(JSON_PROPERTY_UNMODIFIED_ISSUES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Long> getUnmodifiedIssues() {
    return unmodifiedIssues;
  }


  public void setUnmodifiedIssues(List<Long> unmodifiedIssues) {
    this.unmodifiedIssues = unmodifiedIssues;
  }


  public RemoveOptionFromIssuesResult errors(SimpleErrorCollection errors) {
    
    this.errors = errors;
    return this;
  }

   /**
   * A collection of errors related to unchanged issues. The collection size is limited, which means not all errors may be returned.
   * @return errors
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A collection of errors related to unchanged issues. The collection size is limited, which means not all errors may be returned.")
  @JsonProperty(JSON_PROPERTY_ERRORS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public SimpleErrorCollection getErrors() {
    return errors;
  }


  public void setErrors(SimpleErrorCollection errors) {
    this.errors = errors;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RemoveOptionFromIssuesResult removeOptionFromIssuesResult = (RemoveOptionFromIssuesResult) o;
    return Objects.equals(this.modifiedIssues, removeOptionFromIssuesResult.modifiedIssues) &&
        Objects.equals(this.unmodifiedIssues, removeOptionFromIssuesResult.unmodifiedIssues) &&
        Objects.equals(this.errors, removeOptionFromIssuesResult.errors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(modifiedIssues, unmodifiedIssues, errors);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RemoveOptionFromIssuesResult {\n");
    sb.append("    modifiedIssues: ").append(toIndentedString(modifiedIssues)).append("\n");
    sb.append("    unmodifiedIssues: ").append(toIndentedString(unmodifiedIssues)).append("\n");
    sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
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
