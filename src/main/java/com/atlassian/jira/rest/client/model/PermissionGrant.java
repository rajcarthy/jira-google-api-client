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
import com.atlassian.jira.rest.client.model.PermissionHolder;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.net.URI;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Details about a permission granted to a user or group.
 */
@ApiModel(description = "Details about a permission granted to a user or group.")
@JsonPropertyOrder({
  PermissionGrant.JSON_PROPERTY_ID,
  PermissionGrant.JSON_PROPERTY_SELF,
  PermissionGrant.JSON_PROPERTY_HOLDER,
  PermissionGrant.JSON_PROPERTY_PERMISSION
})
@JsonTypeName("PermissionGrant")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-12-31T17:44:39.790417-08:00[America/Los_Angeles]")
public class PermissionGrant {
  public static final String JSON_PROPERTY_ID = "id";
  private Long id;

  public static final String JSON_PROPERTY_SELF = "self";
  private URI self;

  public static final String JSON_PROPERTY_HOLDER = "holder";
  private PermissionHolder holder = null;

  public static final String JSON_PROPERTY_PERMISSION = "permission";
  private String permission;


   /**
   * The ID of the permission granted details.
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the permission granted details.")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getId() {
    return id;
  }




   /**
   * The URL of the permission granted details.
   * @return self
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The URL of the permission granted details.")
  @JsonProperty(JSON_PROPERTY_SELF)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public URI getSelf() {
    return self;
  }




  public PermissionGrant holder(PermissionHolder holder) {
    
    this.holder = holder;
    return this;
  }

   /**
   * The user or group being granted the permission. It consists of a &#x60;type&#x60; and a type-dependent &#x60;parameter&#x60;. See [Holder object](#holder-object) in *Get all permission schemes* for more information.
   * @return holder
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The user or group being granted the permission. It consists of a `type` and a type-dependent `parameter`. See [Holder object](#holder-object) in *Get all permission schemes* for more information.")
  @JsonProperty(JSON_PROPERTY_HOLDER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public PermissionHolder getHolder() {
    return holder;
  }


  public void setHolder(PermissionHolder holder) {
    this.holder = holder;
  }


  public PermissionGrant permission(String permission) {
    
    this.permission = permission;
    return this;
  }

   /**
   * The permission to grant. This permission can be one of the built-in permissions or a custom permission added by an app. See [Built-in permissions](#built-in-permissions) in *Get all permission schemes* for more information about the built-in permissions. See the [project permission](https://developer.atlassian.com/cloud/jira/platform/modules/project-permission/) and [global permission](https://developer.atlassian.com/cloud/jira/platform/modules/global-permission/) module documentation for more information about custom permissions.
   * @return permission
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The permission to grant. This permission can be one of the built-in permissions or a custom permission added by an app. See [Built-in permissions](#built-in-permissions) in *Get all permission schemes* for more information about the built-in permissions. See the [project permission](https://developer.atlassian.com/cloud/jira/platform/modules/project-permission/) and [global permission](https://developer.atlassian.com/cloud/jira/platform/modules/global-permission/) module documentation for more information about custom permissions.")
  @JsonProperty(JSON_PROPERTY_PERMISSION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPermission() {
    return permission;
  }


  public void setPermission(String permission) {
    this.permission = permission;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PermissionGrant permissionGrant = (PermissionGrant) o;
    return Objects.equals(this.id, permissionGrant.id) &&
        Objects.equals(this.self, permissionGrant.self) &&
        Objects.equals(this.holder, permissionGrant.holder) &&
        Objects.equals(this.permission, permissionGrant.permission);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, self, holder, permission);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PermissionGrant {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
    sb.append("    holder: ").append(toIndentedString(holder)).append("\n");
    sb.append("    permission: ").append(toIndentedString(permission)).append("\n");
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

