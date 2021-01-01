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
 * A webhook.
 */
@ApiModel(description = "A webhook.")
@JsonPropertyOrder({
  Webhook.JSON_PROPERTY_ID,
  Webhook.JSON_PROPERTY_JQL_FILTER,
  Webhook.JSON_PROPERTY_EVENTS,
  Webhook.JSON_PROPERTY_EXPIRATION_DATE
})
@JsonTypeName("Webhook")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-12-31T17:44:39.790417-08:00[America/Los_Angeles]")
public class Webhook {
  public static final String JSON_PROPERTY_ID = "id";
  private Long id;

  public static final String JSON_PROPERTY_JQL_FILTER = "jqlFilter";
  private String jqlFilter;

  /**
   * Gets or Sets events
   */
  public enum EventsEnum {
    JIRA_ISSUE_CREATED("jira:issue_created"),
    
    JIRA_ISSUE_UPDATED("jira:issue_updated"),
    
    JIRA_ISSUE_DELETED("jira:issue_deleted"),
    
    COMMENT_CREATED("comment_created"),
    
    COMMENT_UPDATED("comment_updated"),
    
    COMMENT_DELETED("comment_deleted"),
    
    ISSUE_PROPERTY_SET("issue_property_set"),
    
    ISSUE_PROPERTY_DELETED("issue_property_deleted");

    private String value;

    EventsEnum(String value) {
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
    public static EventsEnum fromValue(String value) {
      for (EventsEnum b : EventsEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_EVENTS = "events";
  private List<EventsEnum> events = new ArrayList<>();

  public static final String JSON_PROPERTY_EXPIRATION_DATE = "expirationDate";
  private Long expirationDate;


  public Webhook id(Long id) {
    
    this.id = id;
    return this;
  }

   /**
   * The ID of the webhook.
   * @return id
  **/
  @ApiModelProperty(required = true, value = "The ID of the webhook.")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getId() {
    return id;
  }


  public void setId(Long id) {
    this.id = id;
  }


  public Webhook jqlFilter(String jqlFilter) {
    
    this.jqlFilter = jqlFilter;
    return this;
  }

   /**
   * The JQL filter that specifies which issues the webhook is sent for.
   * @return jqlFilter
  **/
  @ApiModelProperty(required = true, value = "The JQL filter that specifies which issues the webhook is sent for.")
  @JsonProperty(JSON_PROPERTY_JQL_FILTER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getJqlFilter() {
    return jqlFilter;
  }


  public void setJqlFilter(String jqlFilter) {
    this.jqlFilter = jqlFilter;
  }


  public Webhook events(List<EventsEnum> events) {
    
    this.events = events;
    return this;
  }

  public Webhook addEventsItem(EventsEnum eventsItem) {
    this.events.add(eventsItem);
    return this;
  }

   /**
   * The Jira events that trigger the webhook.
   * @return events
  **/
  @ApiModelProperty(required = true, value = "The Jira events that trigger the webhook.")
  @JsonProperty(JSON_PROPERTY_EVENTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<EventsEnum> getEvents() {
    return events;
  }


  public void setEvents(List<EventsEnum> events) {
    this.events = events;
  }


   /**
   * Get expirationDate
   * @return expirationDate
  **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_EXPIRATION_DATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getExpirationDate() {
    return expirationDate;
  }




  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Webhook webhook = (Webhook) o;
    return Objects.equals(this.id, webhook.id) &&
        Objects.equals(this.jqlFilter, webhook.jqlFilter) &&
        Objects.equals(this.events, webhook.events) &&
        Objects.equals(this.expirationDate, webhook.expirationDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, jqlFilter, events, expirationDate);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Webhook {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    jqlFilter: ").append(toIndentedString(jqlFilter)).append("\n");
    sb.append("    events: ").append(toIndentedString(events)).append("\n");
    sb.append("    expirationDate: ").append(toIndentedString(expirationDate)).append("\n");
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

