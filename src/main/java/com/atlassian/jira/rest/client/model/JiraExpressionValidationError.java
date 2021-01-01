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
 * Details about syntax and type errors. The error details apply to the entire expression, unless the object includes:   *  &#x60;line&#x60; and &#x60;column&#x60;  *  &#x60;expression&#x60;
 */
@ApiModel(description = "Details about syntax and type errors. The error details apply to the entire expression, unless the object includes:   *  `line` and `column`  *  `expression`")
@JsonPropertyOrder({
  JiraExpressionValidationError.JSON_PROPERTY_LINE,
  JiraExpressionValidationError.JSON_PROPERTY_COLUMN,
  JiraExpressionValidationError.JSON_PROPERTY_EXPRESSION,
  JiraExpressionValidationError.JSON_PROPERTY_MESSAGE,
  JiraExpressionValidationError.JSON_PROPERTY_TYPE
})
@JsonTypeName("JiraExpressionValidationError")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-12-31T17:44:39.790417-08:00[America/Los_Angeles]")
public class JiraExpressionValidationError {
  public static final String JSON_PROPERTY_LINE = "line";
  private Integer line;

  public static final String JSON_PROPERTY_COLUMN = "column";
  private Integer column;

  public static final String JSON_PROPERTY_EXPRESSION = "expression";
  private String expression;

  public static final String JSON_PROPERTY_MESSAGE = "message";
  private String message;

  /**
   * The error type.
   */
  public enum TypeEnum {
    SYNTAX("syntax"),
    
    TYPE("type"),
    
    OTHER("other");

    private String value;

    TypeEnum(String value) {
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
    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_TYPE = "type";
  private TypeEnum type;


  public JiraExpressionValidationError line(Integer line) {
    
    this.line = line;
    return this;
  }

   /**
   * The text line in which the error occurred.
   * @return line
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The text line in which the error occurred.")
  @JsonProperty(JSON_PROPERTY_LINE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getLine() {
    return line;
  }


  public void setLine(Integer line) {
    this.line = line;
  }


  public JiraExpressionValidationError column(Integer column) {
    
    this.column = column;
    return this;
  }

   /**
   * The text column in which the error occurred.
   * @return column
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The text column in which the error occurred.")
  @JsonProperty(JSON_PROPERTY_COLUMN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getColumn() {
    return column;
  }


  public void setColumn(Integer column) {
    this.column = column;
  }


  public JiraExpressionValidationError expression(String expression) {
    
    this.expression = expression;
    return this;
  }

   /**
   * The part of the expression in which the error occurred.
   * @return expression
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The part of the expression in which the error occurred.")
  @JsonProperty(JSON_PROPERTY_EXPRESSION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getExpression() {
    return expression;
  }


  public void setExpression(String expression) {
    this.expression = expression;
  }


  public JiraExpressionValidationError message(String message) {
    
    this.message = message;
    return this;
  }

   /**
   * Details about the error.
   * @return message
  **/
  @ApiModelProperty(example = "!, -, typeof, (, IDENTIFIER, null, true, false, NUMBER, STRING, new, [ or { expected, > encountered.", required = true, value = "Details about the error.")
  @JsonProperty(JSON_PROPERTY_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getMessage() {
    return message;
  }


  public void setMessage(String message) {
    this.message = message;
  }


  public JiraExpressionValidationError type(TypeEnum type) {
    
    this.type = type;
    return this;
  }

   /**
   * The error type.
   * @return type
  **/
  @ApiModelProperty(required = true, value = "The error type.")
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public TypeEnum getType() {
    return type;
  }


  public void setType(TypeEnum type) {
    this.type = type;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JiraExpressionValidationError jiraExpressionValidationError = (JiraExpressionValidationError) o;
    return Objects.equals(this.line, jiraExpressionValidationError.line) &&
        Objects.equals(this.column, jiraExpressionValidationError.column) &&
        Objects.equals(this.expression, jiraExpressionValidationError.expression) &&
        Objects.equals(this.message, jiraExpressionValidationError.message) &&
        Objects.equals(this.type, jiraExpressionValidationError.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(line, column, expression, message, type);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JiraExpressionValidationError {\n");
    sb.append("    line: ").append(toIndentedString(line)).append("\n");
    sb.append("    column: ").append(toIndentedString(column)).append("\n");
    sb.append("    expression: ").append(toIndentedString(expression)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
