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
import com.atlassian.jira.rest.client.model.User;
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
 * A paginated list of users sharing the filter. This includes users that are members of the groups or can browse the projects that the filter is shared with.
 */
@ApiModel(description = "A paginated list of users sharing the filter. This includes users that are members of the groups or can browse the projects that the filter is shared with.")
@JsonPropertyOrder({
  UserList.JSON_PROPERTY_SIZE,
  UserList.JSON_PROPERTY_ITEMS,
  UserList.JSON_PROPERTY_MAX_RESULTS,
  UserList.JSON_PROPERTY_START_INDEX,
  UserList.JSON_PROPERTY_END_INDEX
})
@JsonTypeName("UserList")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-12-31T17:44:39.790417-08:00[America/Los_Angeles]")
public class UserList {
  public static final String JSON_PROPERTY_SIZE = "size";
  private Integer size;

  public static final String JSON_PROPERTY_ITEMS = "items";
  private List<User> items = null;

  public static final String JSON_PROPERTY_MAX_RESULTS = "max-results";
  private Integer maxResults;

  public static final String JSON_PROPERTY_START_INDEX = "start-index";
  private Integer startIndex;

  public static final String JSON_PROPERTY_END_INDEX = "end-index";
  private Integer endIndex;


   /**
   * The number of items on the page.
   * @return size
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The number of items on the page.")
  @JsonProperty(JSON_PROPERTY_SIZE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getSize() {
    return size;
  }




   /**
   * The list of items.
   * @return items
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The list of items.")
  @JsonProperty(JSON_PROPERTY_ITEMS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<User> getItems() {
    return items;
  }




   /**
   * The maximum number of results that could be on the page.
   * @return maxResults
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The maximum number of results that could be on the page.")
  @JsonProperty(JSON_PROPERTY_MAX_RESULTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getMaxResults() {
    return maxResults;
  }




   /**
   * The index of the first item returned on the page.
   * @return startIndex
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The index of the first item returned on the page.")
  @JsonProperty(JSON_PROPERTY_START_INDEX)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getStartIndex() {
    return startIndex;
  }




   /**
   * The index of the last item returned on the page.
   * @return endIndex
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The index of the last item returned on the page.")
  @JsonProperty(JSON_PROPERTY_END_INDEX)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getEndIndex() {
    return endIndex;
  }




  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserList userList = (UserList) o;
    return Objects.equals(this.size, userList.size) &&
        Objects.equals(this.items, userList.items) &&
        Objects.equals(this.maxResults, userList.maxResults) &&
        Objects.equals(this.startIndex, userList.startIndex) &&
        Objects.equals(this.endIndex, userList.endIndex);
  }

  @Override
  public int hashCode() {
    return Objects.hash(size, items, maxResults, startIndex, endIndex);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserList {\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
    sb.append("    maxResults: ").append(toIndentedString(maxResults)).append("\n");
    sb.append("    startIndex: ").append(toIndentedString(startIndex)).append("\n");
    sb.append("    endIndex: ").append(toIndentedString(endIndex)).append("\n");
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

