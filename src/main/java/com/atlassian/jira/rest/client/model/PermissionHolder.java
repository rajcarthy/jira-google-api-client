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
 * Details of a user, group, field, or project role that holds a permission. See [Holder object](#holder-object) in *Get all permission schemes* for more information.
 */
@ApiModel(description = "Details of a user, group, field, or project role that holds a permission. See [Holder object](#holder-object) in *Get all permission schemes* for more information.")
@JsonPropertyOrder({
  PermissionHolder.JSON_PROPERTY_TYPE,
  PermissionHolder.JSON_PROPERTY_PARAMETER,
  PermissionHolder.JSON_PROPERTY_EXPAND
})
@JsonTypeName("PermissionHolder")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-12-31T17:44:39.790417-08:00[America/Los_Angeles]")
public class PermissionHolder {
  public static final String JSON_PROPERTY_TYPE = "type";
  private String type;

  public static final String JSON_PROPERTY_PARAMETER = "parameter";
  private String parameter;

  public static final String JSON_PROPERTY_EXPAND = "expand";
  private String expand;


  public PermissionHolder type(String type) {
    
    this.type = type;
    return this;
  }

   /**
   * The type of permission holder.
   * @return type
  **/
  @ApiModelProperty(required = true, value = "The type of permission holder.")
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getType() {
    return type;
  }


  public void setType(String type) {
    this.type = type;
  }


  public PermissionHolder parameter(String parameter) {
    
    this.parameter = parameter;
    return this;
  }

   /**
   * The identifier of permission holder.
   * @return parameter
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The identifier of permission holder.")
  @JsonProperty(JSON_PROPERTY_PARAMETER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getParameter() {
    return parameter;
  }


  public void setParameter(String parameter) {
    this.parameter = parameter;
  }


   /**
   * Expand options that include additional permission holder details in the response.
   * @return expand
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Expand options that include additional permission holder details in the response.")
  @JsonProperty(JSON_PROPERTY_EXPAND)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getExpand() {
    return expand;
  }




  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PermissionHolder permissionHolder = (PermissionHolder) o;
    return Objects.equals(this.type, permissionHolder.type) &&
        Objects.equals(this.parameter, permissionHolder.parameter) &&
        Objects.equals(this.expand, permissionHolder.expand);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, parameter, expand);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PermissionHolder {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    parameter: ").append(toIndentedString(parameter)).append("\n");
    sb.append("    expand: ").append(toIndentedString(expand)).append("\n");
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

