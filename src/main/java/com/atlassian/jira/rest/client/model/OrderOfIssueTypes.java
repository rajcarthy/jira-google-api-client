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
 * An ordered list of issue type IDs and information about where to move them.
 */
@ApiModel(description = "An ordered list of issue type IDs and information about where to move them.")
@JsonPropertyOrder({
  OrderOfIssueTypes.JSON_PROPERTY_ISSUE_TYPE_IDS,
  OrderOfIssueTypes.JSON_PROPERTY_AFTER,
  OrderOfIssueTypes.JSON_PROPERTY_POSITION
})
@JsonTypeName("OrderOfIssueTypes")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-12-31T17:44:39.790417-08:00[America/Los_Angeles]")
public class OrderOfIssueTypes {
  public static final String JSON_PROPERTY_ISSUE_TYPE_IDS = "issueTypeIds";
  private List<String> issueTypeIds = new ArrayList<>();

  public static final String JSON_PROPERTY_AFTER = "after";
  private String after;

  /**
   * The position the issue types should be moved to. Required if &#x60;after&#x60; isn&#39;t provided.
   */
  public enum PositionEnum {
    FIRST("First"),
    
    LAST("Last");

    private String value;

    PositionEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static PositionEnum fromValue(String value) {
      for (PositionEnum b : PositionEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_POSITION = "position";
  private PositionEnum position;


  public OrderOfIssueTypes issueTypeIds(List<String> issueTypeIds) {
    
    this.issueTypeIds = issueTypeIds;
    return this;
  }

  public OrderOfIssueTypes addIssueTypeIdsItem(String issueTypeIdsItem) {
    this.issueTypeIds.add(issueTypeIdsItem);
    return this;
  }

   /**
   * A list of the issue type IDs to move. The order of the issue type IDs in the list is the order they are given after the move.
   * @return issueTypeIds
  **/
  @ApiModelProperty(required = true, value = "A list of the issue type IDs to move. The order of the issue type IDs in the list is the order they are given after the move.")
  @JsonProperty(JSON_PROPERTY_ISSUE_TYPE_IDS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<String> getIssueTypeIds() {
    return issueTypeIds;
  }


  public void setIssueTypeIds(List<String> issueTypeIds) {
    this.issueTypeIds = issueTypeIds;
  }


  public OrderOfIssueTypes after(String after) {
    
    this.after = after;
    return this;
  }

   /**
   * The ID of the issue type to place the moved issue types after. Required if &#x60;position&#x60; isn&#39;t provided.
   * @return after
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the issue type to place the moved issue types after. Required if `position` isn't provided.")
  @JsonProperty(JSON_PROPERTY_AFTER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getAfter() {
    return after;
  }


  public void setAfter(String after) {
    this.after = after;
  }


  public OrderOfIssueTypes position(PositionEnum position) {
    
    this.position = position;
    return this;
  }

   /**
   * The position the issue types should be moved to. Required if &#x60;after&#x60; isn&#39;t provided.
   * @return position
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The position the issue types should be moved to. Required if `after` isn't provided.")
  @JsonProperty(JSON_PROPERTY_POSITION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public PositionEnum getPosition() {
    return position;
  }


  public void setPosition(PositionEnum position) {
    this.position = position;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderOfIssueTypes orderOfIssueTypes = (OrderOfIssueTypes) o;
    return Objects.equals(this.issueTypeIds, orderOfIssueTypes.issueTypeIds) &&
        Objects.equals(this.after, orderOfIssueTypes.after) &&
        Objects.equals(this.position, orderOfIssueTypes.position);
  }

  @Override
  public int hashCode() {
    return Objects.hash(issueTypeIds, after, position);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderOfIssueTypes {\n");
    sb.append("    issueTypeIds: ").append(toIndentedString(issueTypeIds)).append("\n");
    sb.append("    after: ").append(toIndentedString(after)).append("\n");
    sb.append("    position: ").append(toIndentedString(position)).append("\n");
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
