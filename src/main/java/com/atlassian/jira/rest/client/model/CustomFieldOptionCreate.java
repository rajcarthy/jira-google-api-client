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
 * Details of a custom field option to create.
 */
@ApiModel(description = "Details of a custom field option to create.")
@JsonPropertyOrder({
  CustomFieldOptionCreate.JSON_PROPERTY_VALUE,
  CustomFieldOptionCreate.JSON_PROPERTY_OPTION_ID,
  CustomFieldOptionCreate.JSON_PROPERTY_DISABLED
})
@JsonTypeName("CustomFieldOptionCreate")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-12-31T17:44:39.790417-08:00[America/Los_Angeles]")
public class CustomFieldOptionCreate {
  public static final String JSON_PROPERTY_VALUE = "value";
  private String value;

  public static final String JSON_PROPERTY_OPTION_ID = "optionId";
  private String optionId;

  public static final String JSON_PROPERTY_DISABLED = "disabled";
  private Boolean disabled;


  public CustomFieldOptionCreate value(String value) {
    
    this.value = value;
    return this;
  }

   /**
   * The value of the custom field option.
   * @return value
  **/
  @ApiModelProperty(required = true, value = "The value of the custom field option.")
  @JsonProperty(JSON_PROPERTY_VALUE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getValue() {
    return value;
  }


  public void setValue(String value) {
    this.value = value;
  }


  public CustomFieldOptionCreate optionId(String optionId) {
    
    this.optionId = optionId;
    return this;
  }

   /**
   * For cascading options, the ID of the custom field object containing the cascading option.
   * @return optionId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "For cascading options, the ID of the custom field object containing the cascading option.")
  @JsonProperty(JSON_PROPERTY_OPTION_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getOptionId() {
    return optionId;
  }


  public void setOptionId(String optionId) {
    this.optionId = optionId;
  }


  public CustomFieldOptionCreate disabled(Boolean disabled) {
    
    this.disabled = disabled;
    return this;
  }

   /**
   * Whether the option is disabled.
   * @return disabled
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Whether the option is disabled.")
  @JsonProperty(JSON_PROPERTY_DISABLED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getDisabled() {
    return disabled;
  }


  public void setDisabled(Boolean disabled) {
    this.disabled = disabled;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomFieldOptionCreate customFieldOptionCreate = (CustomFieldOptionCreate) o;
    return Objects.equals(this.value, customFieldOptionCreate.value) &&
        Objects.equals(this.optionId, customFieldOptionCreate.optionId) &&
        Objects.equals(this.disabled, customFieldOptionCreate.disabled);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, optionId, disabled);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomFieldOptionCreate {\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    optionId: ").append(toIndentedString(optionId)).append("\n");
    sb.append("    disabled: ").append(toIndentedString(disabled)).append("\n");
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

