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
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Details about the server Jira is running on.
 */
@ApiModel(description = "Details about the server Jira is running on.")
@JsonPropertyOrder({
  WorkflowTransitionProperty.JSON_PROPERTY_KEY,
  WorkflowTransitionProperty.JSON_PROPERTY_VALUE,
  WorkflowTransitionProperty.JSON_PROPERTY_ID
})
@JsonTypeName("WorkflowTransitionProperty")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-12-31T17:44:39.790417-08:00[America/Los_Angeles]")
public class WorkflowTransitionProperty extends HashMap<String, Object> {
  public static final String JSON_PROPERTY_KEY = "key";
  private String key;

  public static final String JSON_PROPERTY_VALUE = "value";
  private String value;

  public static final String JSON_PROPERTY_ID = "id";
  private String id;


   /**
   * The key of the transition property. Also known as the name of the transition property.
   * @return key
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The key of the transition property. Also known as the name of the transition property.")
  @JsonProperty(JSON_PROPERTY_KEY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getKey() {
    return key;
  }




  public WorkflowTransitionProperty value(String value) {
    
    this.value = value;
    return this;
  }

   /**
   * The value of the transition property.
   * @return value
  **/
  @ApiModelProperty(required = true, value = "The value of the transition property.")
  @JsonProperty(JSON_PROPERTY_VALUE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getValue() {
    return value;
  }


  public void setValue(String value) {
    this.value = value;
  }


   /**
   * The ID of the transition property.
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the transition property.")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getId() {
    return id;
  }




  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WorkflowTransitionProperty workflowTransitionProperty = (WorkflowTransitionProperty) o;
    return Objects.equals(this.key, workflowTransitionProperty.key) &&
        Objects.equals(this.value, workflowTransitionProperty.value) &&
        Objects.equals(this.id, workflowTransitionProperty.id) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, value, id, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WorkflowTransitionProperty {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

