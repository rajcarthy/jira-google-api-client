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
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * An icon. If no icon is defined:   *  for a status icon, no status icon displays in Jira.  *  for the remote object icon, the default link icon displays in Jira.
 */
@ApiModel(description = "An icon. If no icon is defined:   *  for a status icon, no status icon displays in Jira.  *  for the remote object icon, the default link icon displays in Jira.")
@JsonPropertyOrder({
  Icon.JSON_PROPERTY_URL16X16,
  Icon.JSON_PROPERTY_TITLE,
  Icon.JSON_PROPERTY_LINK
})
@JsonTypeName("Icon")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-12-31T17:44:39.790417-08:00[America/Los_Angeles]")
public class Icon extends HashMap<String, Object> {
  public static final String JSON_PROPERTY_URL16X16 = "url16x16";
  private String url16x16;

  public static final String JSON_PROPERTY_TITLE = "title";
  private String title;

  public static final String JSON_PROPERTY_LINK = "link";
  private String link;


  public Icon url16x16(String url16x16) {
    
    this.url16x16 = url16x16;
    return this;
  }

   /**
   * The URL of an icon that displays at 16x16 pixel in Jira.
   * @return url16x16
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The URL of an icon that displays at 16x16 pixel in Jira.")
  @JsonProperty(JSON_PROPERTY_URL16X16)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getUrl16x16() {
    return url16x16;
  }


  public void setUrl16x16(String url16x16) {
    this.url16x16 = url16x16;
  }


  public Icon title(String title) {
    
    this.title = title;
    return this;
  }

   /**
   * The title of the icon. This is used as follows:   *  For a status icon it is used as a tooltip on the icon. If not set, the status icon doesn&#39;t display a tooltip in Jira.  *  For the remote object icon it is used in conjunction with the application name to display a tooltip for the link&#39;s icon. The tooltip takes the format \&quot;\\[application name\\] icon title\&quot;. Blank itemsare excluded from the tooltip title. If both items are blank, the icon tooltop displays as \&quot;Web Link\&quot;.
   * @return title
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The title of the icon. This is used as follows:   *  For a status icon it is used as a tooltip on the icon. If not set, the status icon doesn't display a tooltip in Jira.  *  For the remote object icon it is used in conjunction with the application name to display a tooltip for the link's icon. The tooltip takes the format \"\\[application name\\] icon title\". Blank itemsare excluded from the tooltip title. If both items are blank, the icon tooltop displays as \"Web Link\".")
  @JsonProperty(JSON_PROPERTY_TITLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getTitle() {
    return title;
  }


  public void setTitle(String title) {
    this.title = title;
  }


  public Icon link(String link) {
    
    this.link = link;
    return this;
  }

   /**
   * The URL of the tooltip, used only for a status icon. If not set, the status icon in Jira is not clickable.
   * @return link
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The URL of the tooltip, used only for a status icon. If not set, the status icon in Jira is not clickable.")
  @JsonProperty(JSON_PROPERTY_LINK)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getLink() {
    return link;
  }


  public void setLink(String link) {
    this.link = link;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Icon icon = (Icon) o;
    return Objects.equals(this.url16x16, icon.url16x16) &&
        Objects.equals(this.title, icon.title) &&
        Objects.equals(this.link, icon.link) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(url16x16, title, link, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Icon {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    url16x16: ").append(toIndentedString(url16x16)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    link: ").append(toIndentedString(link)).append("\n");
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

