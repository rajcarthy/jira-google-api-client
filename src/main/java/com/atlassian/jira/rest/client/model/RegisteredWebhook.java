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
 * ID of a registered webhook or error messages explaining why a webhook wasn&#39;t registered.
 */
@ApiModel(description = "ID of a registered webhook or error messages explaining why a webhook wasn't registered.")
@JsonPropertyOrder({
  RegisteredWebhook.JSON_PROPERTY_CREATED_WEBHOOK_ID,
  RegisteredWebhook.JSON_PROPERTY_ERRORS
})
@JsonTypeName("RegisteredWebhook")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-12-31T17:44:39.790417-08:00[America/Los_Angeles]")
public class RegisteredWebhook {
  public static final String JSON_PROPERTY_CREATED_WEBHOOK_ID = "createdWebhookId";
  private Long createdWebhookId;

  public static final String JSON_PROPERTY_ERRORS = "errors";
  private List<String> errors = null;


  public RegisteredWebhook createdWebhookId(Long createdWebhookId) {
    
    this.createdWebhookId = createdWebhookId;
    return this;
  }

   /**
   * The ID of the webhook. Returned if the webhook is created.
   * @return createdWebhookId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the webhook. Returned if the webhook is created.")
  @JsonProperty(JSON_PROPERTY_CREATED_WEBHOOK_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getCreatedWebhookId() {
    return createdWebhookId;
  }


  public void setCreatedWebhookId(Long createdWebhookId) {
    this.createdWebhookId = createdWebhookId;
  }


  public RegisteredWebhook errors(List<String> errors) {
    
    this.errors = errors;
    return this;
  }

  public RegisteredWebhook addErrorsItem(String errorsItem) {
    if (this.errors == null) {
      this.errors = new ArrayList<>();
    }
    this.errors.add(errorsItem);
    return this;
  }

   /**
   * Error messages specifying why the webhook creation failed.
   * @return errors
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Error messages specifying why the webhook creation failed.")
  @JsonProperty(JSON_PROPERTY_ERRORS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getErrors() {
    return errors;
  }


  public void setErrors(List<String> errors) {
    this.errors = errors;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegisteredWebhook registeredWebhook = (RegisteredWebhook) o;
    return Objects.equals(this.createdWebhookId, registeredWebhook.createdWebhookId) &&
        Objects.equals(this.errors, registeredWebhook.errors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(createdWebhookId, errors);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RegisteredWebhook {\n");
    sb.append("    createdWebhookId: ").append(toIndentedString(createdWebhookId)).append("\n");
    sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
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
