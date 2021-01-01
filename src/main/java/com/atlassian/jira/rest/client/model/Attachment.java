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
import com.atlassian.jira.rest.client.model.UserDetails;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.HashMap;
import java.util.Map;
import org.threeten.bp.OffsetDateTime;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Details about an attachment.
 */
@ApiModel(description = "Details about an attachment.")
@JsonPropertyOrder({
  Attachment.JSON_PROPERTY_SELF,
  Attachment.JSON_PROPERTY_ID,
  Attachment.JSON_PROPERTY_FILENAME,
  Attachment.JSON_PROPERTY_AUTHOR,
  Attachment.JSON_PROPERTY_CREATED,
  Attachment.JSON_PROPERTY_SIZE,
  Attachment.JSON_PROPERTY_MIME_TYPE,
  Attachment.JSON_PROPERTY_CONTENT,
  Attachment.JSON_PROPERTY_THUMBNAIL
})
@JsonTypeName("Attachment")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-12-31T17:44:39.790417-08:00[America/Los_Angeles]")
public class Attachment extends HashMap<String, Object> {
  public static final String JSON_PROPERTY_SELF = "self";
  private String self;

  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_FILENAME = "filename";
  private String filename;

  public static final String JSON_PROPERTY_AUTHOR = "author";
  private UserDetails author = null;

  public static final String JSON_PROPERTY_CREATED = "created";
  private OffsetDateTime created;

  public static final String JSON_PROPERTY_SIZE = "size";
  private Long size;

  public static final String JSON_PROPERTY_MIME_TYPE = "mimeType";
  private String mimeType;

  public static final String JSON_PROPERTY_CONTENT = "content";
  private String content;

  public static final String JSON_PROPERTY_THUMBNAIL = "thumbnail";
  private String thumbnail;


   /**
   * The URL of the attachment details response.
   * @return self
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The URL of the attachment details response.")
  @JsonProperty(JSON_PROPERTY_SELF)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getSelf() {
    return self;
  }




   /**
   * The ID of the attachment.
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of the attachment.")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getId() {
    return id;
  }




   /**
   * The file name of the attachment.
   * @return filename
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The file name of the attachment.")
  @JsonProperty(JSON_PROPERTY_FILENAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getFilename() {
    return filename;
  }




   /**
   * Details of the user who added the attachment.
   * @return author
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Details of the user who added the attachment.")
  @JsonProperty(JSON_PROPERTY_AUTHOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public UserDetails getAuthor() {
    return author;
  }




   /**
   * The datetime the attachment was created.
   * @return created
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The datetime the attachment was created.")
  @JsonProperty(JSON_PROPERTY_CREATED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getCreated() {
    return created;
  }




   /**
   * The size of the attachment.
   * @return size
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The size of the attachment.")
  @JsonProperty(JSON_PROPERTY_SIZE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getSize() {
    return size;
  }




   /**
   * The MIME type of the attachment.
   * @return mimeType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The MIME type of the attachment.")
  @JsonProperty(JSON_PROPERTY_MIME_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getMimeType() {
    return mimeType;
  }




   /**
   * The content of the attachment.
   * @return content
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The content of the attachment.")
  @JsonProperty(JSON_PROPERTY_CONTENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getContent() {
    return content;
  }




   /**
   * The URL of a thumbnail representing the attachment.
   * @return thumbnail
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The URL of a thumbnail representing the attachment.")
  @JsonProperty(JSON_PROPERTY_THUMBNAIL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getThumbnail() {
    return thumbnail;
  }




  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Attachment attachment = (Attachment) o;
    return Objects.equals(this.self, attachment.self) &&
        Objects.equals(this.id, attachment.id) &&
        Objects.equals(this.filename, attachment.filename) &&
        Objects.equals(this.author, attachment.author) &&
        Objects.equals(this.created, attachment.created) &&
        Objects.equals(this.size, attachment.size) &&
        Objects.equals(this.mimeType, attachment.mimeType) &&
        Objects.equals(this.content, attachment.content) &&
        Objects.equals(this.thumbnail, attachment.thumbnail) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(self, id, filename, author, created, size, mimeType, content, thumbnail, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Attachment {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    filename: ").append(toIndentedString(filename)).append("\n");
    sb.append("    author: ").append(toIndentedString(author)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    mimeType: ").append(toIndentedString(mimeType)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    thumbnail: ").append(toIndentedString(thumbnail)).append("\n");
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

