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
 * The details of a custom field context.
 */
@ApiModel(description = "The details of a custom field context.")
@JsonPropertyOrder({
  CustomFieldContext.JSON_PROPERTY_ID,
  CustomFieldContext.JSON_PROPERTY_NAME,
  CustomFieldContext.JSON_PROPERTY_DESCRIPTION,
  CustomFieldContext.JSON_PROPERTY_IS_GLOBAL_CONTEXT,
  CustomFieldContext.JSON_PROPERTY_IS_ANY_ISSUE_TYPE
})
@JsonTypeName("CustomFieldContext")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-12-31T17:44:39.790417-08:00[America/Los_Angeles]")
public class CustomFieldContext {
  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private String description;

  public static final String JSON_PROPERTY_IS_GLOBAL_CONTEXT = "isGlobalContext";
  private Boolean isGlobalContext;

  public static final String JSON_PROPERTY_IS_ANY_ISSUE_TYPE = "isAnyIssueType";
  private Boolean isAnyIssueType;


  public CustomFieldContext id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * The ID of the context.
   * @return id
  **/
  @ApiModelProperty(required = true, value = "The ID of the context.")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getId() {
    return id;
  }


  public void setId(String id) {
    this.id = id;
  }


  public CustomFieldContext name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * The name of the context.
   * @return name
  **/
  @ApiModelProperty(required = true, value = "The name of the context.")
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public CustomFieldContext description(String description) {
    
    this.description = description;
    return this;
  }

   /**
   * The description of the context.
   * @return description
  **/
  @ApiModelProperty(required = true, value = "The description of the context.")
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getDescription() {
    return description;
  }


  public void setDescription(String description) {
    this.description = description;
  }


  public CustomFieldContext isGlobalContext(Boolean isGlobalContext) {
    
    this.isGlobalContext = isGlobalContext;
    return this;
  }

   /**
   * Whether the context is global.
   * @return isGlobalContext
  **/
  @ApiModelProperty(required = true, value = "Whether the context is global.")
  @JsonProperty(JSON_PROPERTY_IS_GLOBAL_CONTEXT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getIsGlobalContext() {
    return isGlobalContext;
  }


  public void setIsGlobalContext(Boolean isGlobalContext) {
    this.isGlobalContext = isGlobalContext;
  }


  public CustomFieldContext isAnyIssueType(Boolean isAnyIssueType) {
    
    this.isAnyIssueType = isAnyIssueType;
    return this;
  }

   /**
   * Whether the context apply to all issue types.
   * @return isAnyIssueType
  **/
  @ApiModelProperty(required = true, value = "Whether the context apply to all issue types.")
  @JsonProperty(JSON_PROPERTY_IS_ANY_ISSUE_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getIsAnyIssueType() {
    return isAnyIssueType;
  }


  public void setIsAnyIssueType(Boolean isAnyIssueType) {
    this.isAnyIssueType = isAnyIssueType;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomFieldContext customFieldContext = (CustomFieldContext) o;
    return Objects.equals(this.id, customFieldContext.id) &&
        Objects.equals(this.name, customFieldContext.name) &&
        Objects.equals(this.description, customFieldContext.description) &&
        Objects.equals(this.isGlobalContext, customFieldContext.isGlobalContext) &&
        Objects.equals(this.isAnyIssueType, customFieldContext.isAnyIssueType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, isGlobalContext, isAnyIssueType);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomFieldContext {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    isGlobalContext: ").append(toIndentedString(isGlobalContext)).append("\n");
    sb.append("    isAnyIssueType: ").append(toIndentedString(isAnyIssueType)).append("\n");
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

