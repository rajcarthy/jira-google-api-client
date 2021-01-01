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
import com.atlassian.jira.rest.client.model.Icon;
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
 * The status of the item.
 */
@ApiModel(description = "The status of the item.")
@JsonPropertyOrder({
  Status.JSON_PROPERTY_RESOLVED,
  Status.JSON_PROPERTY_ICON
})
@JsonTypeName("Status")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-12-31T17:44:39.790417-08:00[America/Los_Angeles]")
public class Status extends HashMap<String, Object> {
  public static final String JSON_PROPERTY_RESOLVED = "resolved";
  private Boolean resolved;

  public static final String JSON_PROPERTY_ICON = "icon";
  private Icon icon = null;


  public Status resolved(Boolean resolved) {
    
    this.resolved = resolved;
    return this;
  }

   /**
   * Whether the item is resolved. If set to \&quot;true\&quot;, the link to the issue is displayed in a strikethrough font, otherwise the link displays in normal font.
   * @return resolved
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Whether the item is resolved. If set to \"true\", the link to the issue is displayed in a strikethrough font, otherwise the link displays in normal font.")
  @JsonProperty(JSON_PROPERTY_RESOLVED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getResolved() {
    return resolved;
  }


  public void setResolved(Boolean resolved) {
    this.resolved = resolved;
  }


  public Status icon(Icon icon) {
    
    this.icon = icon;
    return this;
  }

   /**
   * Details of the icon representing the status. If not provided, no status icon displays in Jira.
   * @return icon
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Details of the icon representing the status. If not provided, no status icon displays in Jira.")
  @JsonProperty(JSON_PROPERTY_ICON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Icon getIcon() {
    return icon;
  }


  public void setIcon(Icon icon) {
    this.icon = icon;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Status status = (Status) o;
    return Objects.equals(this.resolved, status.resolved) &&
        Objects.equals(this.icon, status.icon) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resolved, icon, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Status {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    resolved: ").append(toIndentedString(resolved)).append("\n");
    sb.append("    icon: ").append(toIndentedString(icon)).append("\n");
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

