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
import com.atlassian.jira.rest.client.model.IssueLinkType;
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
 * A list of issue link type beans.
 */
@ApiModel(description = "A list of issue link type beans.")
@JsonPropertyOrder({
  IssueLinkTypes.JSON_PROPERTY_ISSUE_LINK_TYPES
})
@JsonTypeName("IssueLinkTypes")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-12-31T17:44:39.790417-08:00[America/Los_Angeles]")
public class IssueLinkTypes {
  public static final String JSON_PROPERTY_ISSUE_LINK_TYPES = "issueLinkTypes";
  private List<IssueLinkType> issueLinkTypes = null;


   /**
   * The issue link type bean.
   * @return issueLinkTypes
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The issue link type bean.")
  @JsonProperty(JSON_PROPERTY_ISSUE_LINK_TYPES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<IssueLinkType> getIssueLinkTypes() {
    return issueLinkTypes;
  }




  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IssueLinkTypes issueLinkTypes = (IssueLinkTypes) o;
    return Objects.equals(this.issueLinkTypes, issueLinkTypes.issueLinkTypes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(issueLinkTypes);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IssueLinkTypes {\n");
    sb.append("    issueLinkTypes: ").append(toIndentedString(issueLinkTypes)).append("\n");
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

