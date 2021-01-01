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
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * PermissionsKeysBean
 */
@JsonPropertyOrder({
  PermissionsKeysBean.JSON_PROPERTY_PERMISSIONS
})
@JsonTypeName("PermissionsKeysBean")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-12-31T17:44:39.790417-08:00[America/Los_Angeles]")
public class PermissionsKeysBean {
  public static final String JSON_PROPERTY_PERMISSIONS = "permissions";
  private List<String> permissions = new ArrayList<>();


  public PermissionsKeysBean permissions(List<String> permissions) {
    
    this.permissions = permissions;
    return this;
  }

  public PermissionsKeysBean addPermissionsItem(String permissionsItem) {
    this.permissions.add(permissionsItem);
    return this;
  }

   /**
   * A list of permission keys.
   * @return permissions
  **/
  @ApiModelProperty(required = true, value = "A list of permission keys.")
  @JsonProperty(JSON_PROPERTY_PERMISSIONS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<String> getPermissions() {
    return permissions;
  }


  public void setPermissions(List<String> permissions) {
    this.permissions = permissions;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PermissionsKeysBean permissionsKeysBean = (PermissionsKeysBean) o;
    return Objects.equals(this.permissions, permissionsKeysBean.permissions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(permissions);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PermissionsKeysBean {\n");
    sb.append("    permissions: ").append(toIndentedString(permissions)).append("\n");
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

