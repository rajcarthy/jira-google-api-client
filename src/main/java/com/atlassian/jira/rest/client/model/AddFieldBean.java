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
 * AddFieldBean
 */
@JsonPropertyOrder({
  AddFieldBean.JSON_PROPERTY_FIELD_ID
})
@JsonTypeName("AddFieldBean")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-12-31T17:44:39.790417-08:00[America/Los_Angeles]")
public class AddFieldBean {
  public static final String JSON_PROPERTY_FIELD_ID = "fieldId";
  private String fieldId;


  public AddFieldBean fieldId(String fieldId) {
    
    this.fieldId = fieldId;
    return this;
  }

   /**
   * The ID of the field to add.
   * @return fieldId
  **/
  @ApiModelProperty(required = true, value = "The ID of the field to add.")
  @JsonProperty(JSON_PROPERTY_FIELD_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getFieldId() {
    return fieldId;
  }


  public void setFieldId(String fieldId) {
    this.fieldId = fieldId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddFieldBean addFieldBean = (AddFieldBean) o;
    return Objects.equals(this.fieldId, addFieldBean.fieldId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fieldId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddFieldBean {\n");
    sb.append("    fieldId: ").append(toIndentedString(fieldId)).append("\n");
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
