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
import com.atlassian.jira.rest.client.model.SecurityLevel;
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
 * Details about a security scheme.
 */
@ApiModel(description = "Details about a security scheme.")
@JsonPropertyOrder({
  SecurityScheme.JSON_PROPERTY_SELF,
  SecurityScheme.JSON_PROPERTY_ID,
  SecurityScheme.JSON_PROPERTY_NAME,
  SecurityScheme.JSON_PROPERTY_DESCRIPTION,
  SecurityScheme.JSON_PROPERTY_DEFAULT_SECURITY_LEVEL_ID,
  SecurityScheme.JSON_PROPERTY_LEVELS
})
@JsonTypeName("SecurityScheme")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-12-31T17:44:39.790417-08:00[America/Los_Angeles]")
public class SecurityScheme {
  public static final String JSON_PROPERTY_SELF = "self";
  private String self;

  public static final String JSON_PROPERTY_ID = "id";
  private Long id;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private String description;

  public static final String JSON_PROPERTY_DEFAULT_SECURITY_LEVEL_ID = "defaultSecurityLevelId";
  private Long defaultSecurityLevelId;

  public static final String JSON_PROPERTY_LEVELS = "levels";
  private List<SecurityLevel> levels = null;


   /**
   * The URL of the issue security scheme.
   * @return self
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The URL of the issue security scheme.")
  @JsonProperty(JSON_PROPERTY_SELF)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getSelf() {
    return self;
  }




   /**
   * The ID of the issue security scheme.
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the issue security scheme.")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getId() {
    return id;
  }




   /**
   * The name of the issue security scheme.
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The name of the issue security scheme.")
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getName() {
    return name;
  }




   /**
   * The description of the issue security scheme.
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The description of the issue security scheme.")
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDescription() {
    return description;
  }




   /**
   * The ID of the default security level.
   * @return defaultSecurityLevelId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the default security level.")
  @JsonProperty(JSON_PROPERTY_DEFAULT_SECURITY_LEVEL_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getDefaultSecurityLevelId() {
    return defaultSecurityLevelId;
  }




  public SecurityScheme levels(List<SecurityLevel> levels) {
    
    this.levels = levels;
    return this;
  }

  public SecurityScheme addLevelsItem(SecurityLevel levelsItem) {
    if (this.levels == null) {
      this.levels = new ArrayList<>();
    }
    this.levels.add(levelsItem);
    return this;
  }

   /**
   * Get levels
   * @return levels
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_LEVELS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<SecurityLevel> getLevels() {
    return levels;
  }


  public void setLevels(List<SecurityLevel> levels) {
    this.levels = levels;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SecurityScheme securityScheme = (SecurityScheme) o;
    return Objects.equals(this.self, securityScheme.self) &&
        Objects.equals(this.id, securityScheme.id) &&
        Objects.equals(this.name, securityScheme.name) &&
        Objects.equals(this.description, securityScheme.description) &&
        Objects.equals(this.defaultSecurityLevelId, securityScheme.defaultSecurityLevelId) &&
        Objects.equals(this.levels, securityScheme.levels);
  }

  @Override
  public int hashCode() {
    return Objects.hash(self, id, name, description, defaultSecurityLevelId, levels);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SecurityScheme {\n");
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    defaultSecurityLevelId: ").append(toIndentedString(defaultSecurityLevelId)).append("\n");
    sb.append("    levels: ").append(toIndentedString(levels)).append("\n");
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

