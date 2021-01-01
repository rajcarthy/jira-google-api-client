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
import com.atlassian.jira.rest.client.model.EventNotification;
import com.atlassian.jira.rest.client.model.NotificationEvent;
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
 * Details about a notification scheme event.
 */
@ApiModel(description = "Details about a notification scheme event.")
@JsonPropertyOrder({
  NotificationSchemeEvent.JSON_PROPERTY_EVENT,
  NotificationSchemeEvent.JSON_PROPERTY_NOTIFICATIONS
})
@JsonTypeName("NotificationSchemeEvent")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-12-31T17:44:39.790417-08:00[America/Los_Angeles]")
public class NotificationSchemeEvent {
  public static final String JSON_PROPERTY_EVENT = "event";
  private NotificationEvent event;

  public static final String JSON_PROPERTY_NOTIFICATIONS = "notifications";
  private List<EventNotification> notifications = null;


  public NotificationSchemeEvent event(NotificationEvent event) {
    
    this.event = event;
    return this;
  }

   /**
   * Get event
   * @return event
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_EVENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public NotificationEvent getEvent() {
    return event;
  }


  public void setEvent(NotificationEvent event) {
    this.event = event;
  }


  public NotificationSchemeEvent notifications(List<EventNotification> notifications) {
    
    this.notifications = notifications;
    return this;
  }

  public NotificationSchemeEvent addNotificationsItem(EventNotification notificationsItem) {
    if (this.notifications == null) {
      this.notifications = new ArrayList<>();
    }
    this.notifications.add(notificationsItem);
    return this;
  }

   /**
   * Get notifications
   * @return notifications
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_NOTIFICATIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<EventNotification> getNotifications() {
    return notifications;
  }


  public void setNotifications(List<EventNotification> notifications) {
    this.notifications = notifications;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NotificationSchemeEvent notificationSchemeEvent = (NotificationSchemeEvent) o;
    return Objects.equals(this.event, notificationSchemeEvent.event) &&
        Objects.equals(this.notifications, notificationSchemeEvent.notifications);
  }

  @Override
  public int hashCode() {
    return Objects.hash(event, notifications);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NotificationSchemeEvent {\n");
    sb.append("    event: ").append(toIndentedString(event)).append("\n");
    sb.append("    notifications: ").append(toIndentedString(notifications)).append("\n");
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

