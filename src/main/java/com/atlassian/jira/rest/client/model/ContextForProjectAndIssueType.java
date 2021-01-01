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
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * The project and issue type mapping with a matching custom field context.
 */
@ApiModel(description = "The project and issue type mapping with a matching custom field context.")
@JsonPropertyOrder({
  ContextForProjectAndIssueType.JSON_PROPERTY_PROJECT_ID,
  ContextForProjectAndIssueType.JSON_PROPERTY_ISSUE_TYPE_ID,
  ContextForProjectAndIssueType.JSON_PROPERTY_CONTEXT_ID
})
@JsonTypeName("ContextForProjectAndIssueType")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-12-31T17:44:39.790417-08:00[America/Los_Angeles]")
public class ContextForProjectAndIssueType {
  public static final String JSON_PROPERTY_PROJECT_ID = "projectId";
  private String projectId;

  public static final String JSON_PROPERTY_ISSUE_TYPE_ID = "issueTypeId";
  private String issueTypeId;

  public static final String JSON_PROPERTY_CONTEXT_ID = "contextId";
  private String contextId;


  public ContextForProjectAndIssueType projectId(String projectId) {
    
    this.projectId = projectId;
    return this;
  }

   /**
   * The ID of the project.
   * @return projectId
  **/
  @ApiModelProperty(required = true, value = "The ID of the project.")
  @JsonProperty(JSON_PROPERTY_PROJECT_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getProjectId() {
    return projectId;
  }


  public void setProjectId(String projectId) {
    this.projectId = projectId;
  }


  public ContextForProjectAndIssueType issueTypeId(String issueTypeId) {
    
    this.issueTypeId = issueTypeId;
    return this;
  }

   /**
   * The ID of the issue type.
   * @return issueTypeId
  **/
  @ApiModelProperty(required = true, value = "The ID of the issue type.")
  @JsonProperty(JSON_PROPERTY_ISSUE_TYPE_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getIssueTypeId() {
    return issueTypeId;
  }


  public void setIssueTypeId(String issueTypeId) {
    this.issueTypeId = issueTypeId;
  }


  public ContextForProjectAndIssueType contextId(String contextId) {
    
    this.contextId = contextId;
    return this;
  }

   /**
   * The ID of the custom field context.
   * @return contextId
  **/
  @ApiModelProperty(required = true, value = "The ID of the custom field context.")
  @JsonProperty(JSON_PROPERTY_CONTEXT_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getContextId() {
    return contextId;
  }


  public void setContextId(String contextId) {
    this.contextId = contextId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContextForProjectAndIssueType contextForProjectAndIssueType = (ContextForProjectAndIssueType) o;
    return Objects.equals(this.projectId, contextForProjectAndIssueType.projectId) &&
        Objects.equals(this.issueTypeId, contextForProjectAndIssueType.issueTypeId) &&
        Objects.equals(this.contextId, contextForProjectAndIssueType.contextId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(projectId, issueTypeId, contextId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContextForProjectAndIssueType {\n");
    sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
    sb.append("    issueTypeId: ").append(toIndentedString(issueTypeId)).append("\n");
    sb.append("    contextId: ").append(toIndentedString(contextId)).append("\n");
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

