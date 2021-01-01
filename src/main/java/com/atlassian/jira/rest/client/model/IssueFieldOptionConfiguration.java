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
import com.atlassian.jira.rest.client.model.IssueFieldOptionScopeBean;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Details of the projects the option is available in.
 */
@ApiModel(description = "Details of the projects the option is available in.")
@JsonPropertyOrder({
  IssueFieldOptionConfiguration.JSON_PROPERTY_SCOPE,
  IssueFieldOptionConfiguration.JSON_PROPERTY_ATTRIBUTES
})
@JsonTypeName("IssueFieldOptionConfiguration")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-12-31T17:44:39.790417-08:00[America/Los_Angeles]")
public class IssueFieldOptionConfiguration {
  public static final String JSON_PROPERTY_SCOPE = "scope";
  private IssueFieldOptionScopeBean scope = null;

  /**
   * Gets or Sets attributes
   */
  public enum AttributesEnum {
    NOTSELECTABLE("notSelectable"),
    
    DEFAULTVALUE("defaultValue");

    private String value;

    AttributesEnum(String value) {
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
    public static AttributesEnum fromValue(String value) {
      for (AttributesEnum b : AttributesEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_ATTRIBUTES = "attributes";
  private Set<AttributesEnum> attributes = null;


  public IssueFieldOptionConfiguration scope(IssueFieldOptionScopeBean scope) {
    
    this.scope = scope;
    return this;
  }

   /**
   * Defines the projects that the option is available in. If the scope is not defined, then the option is available in all projects.
   * @return scope
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Defines the projects that the option is available in. If the scope is not defined, then the option is available in all projects.")
  @JsonProperty(JSON_PROPERTY_SCOPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public IssueFieldOptionScopeBean getScope() {
    return scope;
  }


  public void setScope(IssueFieldOptionScopeBean scope) {
    this.scope = scope;
  }


  public IssueFieldOptionConfiguration attributes(Set<AttributesEnum> attributes) {
    
    this.attributes = attributes;
    return this;
  }

  public IssueFieldOptionConfiguration addAttributesItem(AttributesEnum attributesItem) {
    if (this.attributes == null) {
      this.attributes = new LinkedHashSet<>();
    }
    this.attributes.add(attributesItem);
    return this;
  }

   /**
   * DEPRECATED
   * @return attributes
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "DEPRECATED")
  @JsonProperty(JSON_PROPERTY_ATTRIBUTES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Set<AttributesEnum> getAttributes() {
    return attributes;
  }


  public void setAttributes(Set<AttributesEnum> attributes) {
    this.attributes = attributes;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IssueFieldOptionConfiguration issueFieldOptionConfiguration = (IssueFieldOptionConfiguration) o;
    return Objects.equals(this.scope, issueFieldOptionConfiguration.scope) &&
        Objects.equals(this.attributes, issueFieldOptionConfiguration.attributes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(scope, attributes);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IssueFieldOptionConfiguration {\n");
    sb.append("    scope: ").append(toIndentedString(scope)).append("\n");
    sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
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

