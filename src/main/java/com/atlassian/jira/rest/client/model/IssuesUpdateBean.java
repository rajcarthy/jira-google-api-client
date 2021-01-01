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
import com.atlassian.jira.rest.client.model.IssueUpdateDetails;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * IssuesUpdateBean
 */
@JsonPropertyOrder({
  IssuesUpdateBean.JSON_PROPERTY_ISSUE_UPDATES
})
@JsonTypeName("IssuesUpdateBean")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-12-31T17:44:39.790417-08:00[America/Los_Angeles]")
public class IssuesUpdateBean extends HashMap<String, Object> {
  public static final String JSON_PROPERTY_ISSUE_UPDATES = "issueUpdates";
  private List<IssueUpdateDetails> issueUpdates = null;


  public IssuesUpdateBean issueUpdates(List<IssueUpdateDetails> issueUpdates) {
    
    this.issueUpdates = issueUpdates;
    return this;
  }

  public IssuesUpdateBean addIssueUpdatesItem(IssueUpdateDetails issueUpdatesItem) {
    if (this.issueUpdates == null) {
      this.issueUpdates = new ArrayList<>();
    }
    this.issueUpdates.add(issueUpdatesItem);
    return this;
  }

   /**
   * Get issueUpdates
   * @return issueUpdates
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ISSUE_UPDATES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<IssueUpdateDetails> getIssueUpdates() {
    return issueUpdates;
  }


  public void setIssueUpdates(List<IssueUpdateDetails> issueUpdates) {
    this.issueUpdates = issueUpdates;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IssuesUpdateBean issuesUpdateBean = (IssuesUpdateBean) o;
    return Objects.equals(this.issueUpdates, issuesUpdateBean.issueUpdates) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(issueUpdates, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IssuesUpdateBean {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    issueUpdates: ").append(toIndentedString(issueUpdates)).append("\n");
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

