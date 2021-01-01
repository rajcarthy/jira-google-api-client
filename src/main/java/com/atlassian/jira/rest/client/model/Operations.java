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
import com.atlassian.jira.rest.client.model.LinkGroup;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Details of the operations that can be performed on the issue.
 */
@ApiModel(description = "Details of the operations that can be performed on the issue.")
@JsonPropertyOrder({
  Operations.JSON_PROPERTY_LINK_GROUPS
})
@JsonTypeName("Operations")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-12-31T17:44:39.790417-08:00[America/Los_Angeles]")
public class Operations extends HashMap<String, Object> {
  public static final String JSON_PROPERTY_LINK_GROUPS = "linkGroups";
  private List<LinkGroup> linkGroups = null;


   /**
   * Details of the link groups defining issue operations.
   * @return linkGroups
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Details of the link groups defining issue operations.")
  @JsonProperty(JSON_PROPERTY_LINK_GROUPS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<LinkGroup> getLinkGroups() {
    return linkGroups;
  }




  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Operations operations = (Operations) o;
    return Objects.equals(this.linkGroups, operations.linkGroups) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(linkGroups, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Operations {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    linkGroups: ").append(toIndentedString(linkGroups)).append("\n");
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
