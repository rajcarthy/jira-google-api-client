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
import com.atlassian.jira.rest.client.model.SharePermission;
import com.atlassian.jira.rest.client.model.UserBean;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Details of a dashboard.
 */
@ApiModel(description = "Details of a dashboard.")
@JsonPropertyOrder({
  Dashboard.JSON_PROPERTY_DESCRIPTION,
  Dashboard.JSON_PROPERTY_ID,
  Dashboard.JSON_PROPERTY_IS_FAVOURITE,
  Dashboard.JSON_PROPERTY_NAME,
  Dashboard.JSON_PROPERTY_OWNER,
  Dashboard.JSON_PROPERTY_POPULARITY,
  Dashboard.JSON_PROPERTY_RANK,
  Dashboard.JSON_PROPERTY_SELF,
  Dashboard.JSON_PROPERTY_SHARE_PERMISSIONS,
  Dashboard.JSON_PROPERTY_VIEW
})
@JsonTypeName("Dashboard")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-12-31T17:44:39.790417-08:00[America/Los_Angeles]")
public class Dashboard {
  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private String description;

  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_IS_FAVOURITE = "isFavourite";
  private Boolean isFavourite;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_OWNER = "owner";
  private UserBean owner = null;

  public static final String JSON_PROPERTY_POPULARITY = "popularity";
  private Long popularity;

  public static final String JSON_PROPERTY_RANK = "rank";
  private Integer rank;

  public static final String JSON_PROPERTY_SELF = "self";
  private URI self;

  public static final String JSON_PROPERTY_SHARE_PERMISSIONS = "sharePermissions";
  private List<SharePermission> sharePermissions = null;

  public static final String JSON_PROPERTY_VIEW = "view";
  private String view;


  public Dashboard description(String description) {
    
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDescription() {
    return description;
  }


  public void setDescription(String description) {
    this.description = description;
  }


   /**
   * The ID of the dashboard.
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the dashboard.")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getId() {
    return id;
  }




   /**
   * Whether the dashboard is selected as a favorite by the user.
   * @return isFavourite
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Whether the dashboard is selected as a favorite by the user.")
  @JsonProperty(JSON_PROPERTY_IS_FAVOURITE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getIsFavourite() {
    return isFavourite;
  }




   /**
   * The name of the dashboard.
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The name of the dashboard.")
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getName() {
    return name;
  }




   /**
   * The owner of the dashboard.
   * @return owner
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The owner of the dashboard.")
  @JsonProperty(JSON_PROPERTY_OWNER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public UserBean getOwner() {
    return owner;
  }




   /**
   * The number of users who have this dashboard as a favorite.
   * @return popularity
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The number of users who have this dashboard as a favorite.")
  @JsonProperty(JSON_PROPERTY_POPULARITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getPopularity() {
    return popularity;
  }




   /**
   * The rank of this dashboard.
   * @return rank
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The rank of this dashboard.")
  @JsonProperty(JSON_PROPERTY_RANK)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getRank() {
    return rank;
  }




   /**
   * The URL of these dashboard details.
   * @return self
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The URL of these dashboard details.")
  @JsonProperty(JSON_PROPERTY_SELF)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public URI getSelf() {
    return self;
  }




   /**
   * The details of any share permissions for the dashboard.
   * @return sharePermissions
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The details of any share permissions for the dashboard.")
  @JsonProperty(JSON_PROPERTY_SHARE_PERMISSIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<SharePermission> getSharePermissions() {
    return sharePermissions;
  }




   /**
   * The URL of the dashboard.
   * @return view
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The URL of the dashboard.")
  @JsonProperty(JSON_PROPERTY_VIEW)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getView() {
    return view;
  }




  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Dashboard dashboard = (Dashboard) o;
    return Objects.equals(this.description, dashboard.description) &&
        Objects.equals(this.id, dashboard.id) &&
        Objects.equals(this.isFavourite, dashboard.isFavourite) &&
        Objects.equals(this.name, dashboard.name) &&
        Objects.equals(this.owner, dashboard.owner) &&
        Objects.equals(this.popularity, dashboard.popularity) &&
        Objects.equals(this.rank, dashboard.rank) &&
        Objects.equals(this.self, dashboard.self) &&
        Objects.equals(this.sharePermissions, dashboard.sharePermissions) &&
        Objects.equals(this.view, dashboard.view);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, id, isFavourite, name, owner, popularity, rank, self, sharePermissions, view);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Dashboard {\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    isFavourite: ").append(toIndentedString(isFavourite)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
    sb.append("    popularity: ").append(toIndentedString(popularity)).append("\n");
    sb.append("    rank: ").append(toIndentedString(rank)).append("\n");
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
    sb.append("    sharePermissions: ").append(toIndentedString(sharePermissions)).append("\n");
    sb.append("    view: ").append(toIndentedString(view)).append("\n");
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
