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
import com.atlassian.jira.rest.client.model.CustomFieldOptionUpdate;
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
 * Details of the options to update for a custom field.
 */
@ApiModel(description = "Details of the options to update for a custom field.")
@JsonPropertyOrder({
  BulkCustomFieldOptionUpdateRequest.JSON_PROPERTY_OPTIONS
})
@JsonTypeName("BulkCustomFieldOptionUpdateRequest")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-12-31T17:44:39.790417-08:00[America/Los_Angeles]")
public class BulkCustomFieldOptionUpdateRequest {
  public static final String JSON_PROPERTY_OPTIONS = "options";
  private List<CustomFieldOptionUpdate> options = null;


  public BulkCustomFieldOptionUpdateRequest options(List<CustomFieldOptionUpdate> options) {
    
    this.options = options;
    return this;
  }

  public BulkCustomFieldOptionUpdateRequest addOptionsItem(CustomFieldOptionUpdate optionsItem) {
    if (this.options == null) {
      this.options = new ArrayList<>();
    }
    this.options.add(optionsItem);
    return this;
  }

   /**
   * Details of the options to update.
   * @return options
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Details of the options to update.")
  @JsonProperty(JSON_PROPERTY_OPTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<CustomFieldOptionUpdate> getOptions() {
    return options;
  }


  public void setOptions(List<CustomFieldOptionUpdate> options) {
    this.options = options;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BulkCustomFieldOptionUpdateRequest bulkCustomFieldOptionUpdateRequest = (BulkCustomFieldOptionUpdateRequest) o;
    return Objects.equals(this.options, bulkCustomFieldOptionUpdateRequest.options);
  }

  @Override
  public int hashCode() {
    return Objects.hash(options);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BulkCustomFieldOptionUpdateRequest {\n");
    sb.append("    options: ").append(toIndentedString(options)).append("\n");
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

