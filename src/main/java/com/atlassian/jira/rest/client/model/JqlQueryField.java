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
import com.atlassian.jira.rest.client.model.JqlQueryFieldEntityProperty;
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
 * A field used in a JQL query. See [Advanced searching - fields reference](https://confluence.atlassian.com/x/dAiiLQ) for more information about fields in JQL queries.
 */
@ApiModel(description = "A field used in a JQL query. See [Advanced searching - fields reference](https://confluence.atlassian.com/x/dAiiLQ) for more information about fields in JQL queries.")
@JsonPropertyOrder({
  JqlQueryField.JSON_PROPERTY_NAME,
  JqlQueryField.JSON_PROPERTY_PROPERTY
})
@JsonTypeName("JqlQueryField")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-12-31T17:44:39.790417-08:00[America/Los_Angeles]")
public class JqlQueryField {
  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_PROPERTY = "property";
  private List<JqlQueryFieldEntityProperty> property = null;


  public JqlQueryField name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * The name of the field.
   * @return name
  **/
  @ApiModelProperty(required = true, value = "The name of the field.")
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public JqlQueryField property(List<JqlQueryFieldEntityProperty> property) {
    
    this.property = property;
    return this;
  }

  public JqlQueryField addPropertyItem(JqlQueryFieldEntityProperty propertyItem) {
    if (this.property == null) {
      this.property = new ArrayList<>();
    }
    this.property.add(propertyItem);
    return this;
  }

   /**
   * When the field refers to a value in an entity property, details of the entity property value.
   * @return property
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "When the field refers to a value in an entity property, details of the entity property value.")
  @JsonProperty(JSON_PROPERTY_PROPERTY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<JqlQueryFieldEntityProperty> getProperty() {
    return property;
  }


  public void setProperty(List<JqlQueryFieldEntityProperty> property) {
    this.property = property;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JqlQueryField jqlQueryField = (JqlQueryField) o;
    return Objects.equals(this.name, jqlQueryField.name) &&
        Objects.equals(this.property, jqlQueryField.property);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, property);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JqlQueryField {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    property: ").append(toIndentedString(property)).append("\n");
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

