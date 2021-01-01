package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.CreatedIssue;
import com.atlassian.jira.rest.client.model.CreatedIssues;
import com.atlassian.jira.rest.client.model.ErrorCollection;
import com.atlassian.jira.rest.client.model.IssueBean;
import com.atlassian.jira.rest.client.model.IssueCreateMetadata;
import com.atlassian.jira.rest.client.model.IssueUpdateMetadata;
import com.atlassian.jira.rest.client.model.PageBeanChangelog;
import com.atlassian.jira.rest.client.model.Transitions;
import com.atlassian.jira.rest.client.model.User;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.api.client.http.EmptyContent;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.InputStreamContent;
import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.json.Json;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-12-31T17:44:39.790417-08:00[America/Los_Angeles]")
public class IssuesApi {
    private ApiClient apiClient;

    public IssuesApi() {
        this(new ApiClient());
    }

    public IssuesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Assign issue
    * Assigns an issue to a user. Use this operation when the calling user does not have the *Edit Issues* permission but has the *Assign issue* permission for the project that the issue is in.  If &#x60;name&#x60; or &#x60;accountId&#x60; is set to:   *  &#x60;\&quot;-1\&quot;&#x60;, the issue is assigned to the default assignee for the project.  *  &#x60;null&#x60;, the issue is set to unassigned.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse Projects* and *Assign Issues* [ project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  the user is not found.  *  &#x60;name&#x60;, &#x60;key&#x60;, or &#x60;accountId&#x60; is missing.  *  more than one of &#x60;name&#x60;, &#x60;key&#x60;, and &#x60;accountId&#x60; are provided.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the issue is not found.
    * @param issueIdOrKey The ID or key of the issue to be assigned.
    * @param user The request object with the user that the issue is assigned to.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object assignIssue(String issueIdOrKey, User user) throws IOException {
        HttpResponse response = assignIssueForHttpResponse(issueIdOrKey, user);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Assign issue
    * Assigns an issue to a user. Use this operation when the calling user does not have the *Edit Issues* permission but has the *Assign issue* permission for the project that the issue is in.  If &#x60;name&#x60; or &#x60;accountId&#x60; is set to:   *  &#x60;\&quot;-1\&quot;&#x60;, the issue is assigned to the default assignee for the project.  *  &#x60;null&#x60;, the issue is set to unassigned.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse Projects* and *Assign Issues* [ project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  the user is not found.  *  &#x60;name&#x60;, &#x60;key&#x60;, or &#x60;accountId&#x60; is missing.  *  more than one of &#x60;name&#x60;, &#x60;key&#x60;, and &#x60;accountId&#x60; are provided.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the issue is not found.
    * @param issueIdOrKey The ID or key of the issue to be assigned.
    * @param user The request object with the user that the issue is assigned to.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object assignIssue(String issueIdOrKey, User user, Map<String, Object> params) throws IOException {
        HttpResponse response = assignIssueForHttpResponse(issueIdOrKey, user, params);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse assignIssueForHttpResponse(String issueIdOrKey, User user) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling assignIssue");
        }// verify the required parameter 'user' is set
        if (user == null) {
            throw new IllegalArgumentException("Missing the required parameter 'user' when calling assignIssue");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/assignee");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(user);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse assignIssueForHttpResponse(String issueIdOrKey, java.io.InputStream user, String mediaType) throws IOException {
          // verify the required parameter 'issueIdOrKey' is set
              if (issueIdOrKey == null) {
              throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling assignIssue");
              }// verify the required parameter 'user' is set
              if (user == null) {
              throw new IllegalArgumentException("Missing the required parameter 'user' when calling assignIssue");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("issueIdOrKey", issueIdOrKey);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/assignee");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = user == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, user);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse assignIssueForHttpResponse(String issueIdOrKey, User user, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling assignIssue");
        }// verify the required parameter 'user' is set
        if (user == null) {
            throw new IllegalArgumentException("Missing the required parameter 'user' when calling assignIssue");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/assignee");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);

        for (Map.Entry<String, Object> entry: allParams.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (key != null && value != null) {
                if (value instanceof Collection) {
                    uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
                } else if (value instanceof Object[]) {
                    uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
                } else {
                    uriBuilder = uriBuilder.queryParam(key, value);
                }
            }
        }

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(user);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }


  /**
    * Create issue
    * Creates an issue or, where the option to create subtasks is enabled in Jira, a subtask. A transition may be applied, to move the issue or subtask to a workflow step other than the default start step, and issue properties set.  The content of the issue or subtask is defined using &#x60;update&#x60; and &#x60;fields&#x60;. The fields that can be set in the issue or subtask are determined using the [ Get create issue metadata](#api-rest-api-3-issue-createmeta-get). These are the same fields that appear on the issue&#39;s create screen. Note that the &#x60;description&#x60;, &#x60;environment&#x60;, and any &#x60;textarea&#x60; type custom fields (multi-line text fields) take Atlassian Document Format content. Single line custom fields (&#x60;textfield&#x60;) accept a string and don&#39;t handle Atlassian Document Format content.  Creating a subtask differs from creating an issue as follows:   *  &#x60;issueType&#x60; must be set to a subtask issue type (use [ Get create issue metadata](#api-rest-api-3-issue-createmeta-get) to find subtask issue types).  *  &#x60;parent&#x60; must contain the ID or key of the parent issue.  In a next-gen project any issue may be made a child providing that the parent and child are members of the same project. In a classic project the parent field is only valid for subtasks.  **[Permissions](#permissions) required:** *Browse projects* and *Create issues* [project permissions](https://confluence.atlassian.com/x/yodKLg) for the project in which the issue or subtask is created.
    * <p><b>201</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request:   *  is missing required fields.  *  contains invalid field values.  *  contains fields that cannot be set for the issue type.  *  is by a user who does not have the necessary permission.  *  is to create a subtype in a project different that of the parent issue.  *  is for a subtask when the option to create subtasks is disabled.  *  is invalid for any other reason.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * @param requestBody The requestBody parameter
    * @param updateHistory Whether the project in which the issue is created is added to the user&#39;s **Recently viewed** project list, as shown under **Projects** in Jira.
    * @return CreatedIssue
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public CreatedIssue createIssue(Map<String, Object> requestBody, Boolean updateHistory) throws IOException {
        HttpResponse response = createIssueForHttpResponse(requestBody, updateHistory);
        TypeReference<CreatedIssue> typeRef = new TypeReference<CreatedIssue>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Create issue
    * Creates an issue or, where the option to create subtasks is enabled in Jira, a subtask. A transition may be applied, to move the issue or subtask to a workflow step other than the default start step, and issue properties set.  The content of the issue or subtask is defined using &#x60;update&#x60; and &#x60;fields&#x60;. The fields that can be set in the issue or subtask are determined using the [ Get create issue metadata](#api-rest-api-3-issue-createmeta-get). These are the same fields that appear on the issue&#39;s create screen. Note that the &#x60;description&#x60;, &#x60;environment&#x60;, and any &#x60;textarea&#x60; type custom fields (multi-line text fields) take Atlassian Document Format content. Single line custom fields (&#x60;textfield&#x60;) accept a string and don&#39;t handle Atlassian Document Format content.  Creating a subtask differs from creating an issue as follows:   *  &#x60;issueType&#x60; must be set to a subtask issue type (use [ Get create issue metadata](#api-rest-api-3-issue-createmeta-get) to find subtask issue types).  *  &#x60;parent&#x60; must contain the ID or key of the parent issue.  In a next-gen project any issue may be made a child providing that the parent and child are members of the same project. In a classic project the parent field is only valid for subtasks.  **[Permissions](#permissions) required:** *Browse projects* and *Create issues* [project permissions](https://confluence.atlassian.com/x/yodKLg) for the project in which the issue or subtask is created.
    * <p><b>201</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request:   *  is missing required fields.  *  contains invalid field values.  *  contains fields that cannot be set for the issue type.  *  is by a user who does not have the necessary permission.  *  is to create a subtype in a project different that of the parent issue.  *  is for a subtask when the option to create subtasks is disabled.  *  is invalid for any other reason.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * @param requestBody The requestBody parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return CreatedIssue
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public CreatedIssue createIssue(Map<String, Object> requestBody, Map<String, Object> params) throws IOException {
        HttpResponse response = createIssueForHttpResponse(requestBody, params);
        TypeReference<CreatedIssue> typeRef = new TypeReference<CreatedIssue>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse createIssueForHttpResponse(Map<String, Object> requestBody, Boolean updateHistory) throws IOException {
        // verify the required parameter 'requestBody' is set
        if (requestBody == null) {
            throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling createIssue");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue");
        if (updateHistory != null) {
            String key = "updateHistory";
            Object value = updateHistory;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(requestBody);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse createIssueForHttpResponse(java.io.InputStream requestBody, Boolean updateHistory, String mediaType) throws IOException {
          // verify the required parameter 'requestBody' is set
              if (requestBody == null) {
              throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling createIssue");
              }
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue");
              if (updateHistory != null) {
                  String key = "updateHistory";
                  Object value = updateHistory;
                  if (value instanceof Collection) {
                    uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
                  } else if (value instanceof Object[]) {
                    uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
                  } else {
                    uriBuilder = uriBuilder.queryParam(key, value);
                  }
              }

              String localVarUrl = uriBuilder.build().toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = requestBody == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, requestBody);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse createIssueForHttpResponse(Map<String, Object> requestBody, Map<String, Object> params) throws IOException {
        // verify the required parameter 'requestBody' is set
        if (requestBody == null) {
            throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling createIssue");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);

        for (Map.Entry<String, Object> entry: allParams.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (key != null && value != null) {
                if (value instanceof Collection) {
                    uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
                } else if (value instanceof Object[]) {
                    uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
                } else {
                    uriBuilder = uriBuilder.queryParam(key, value);
                }
            }
        }

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(requestBody);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


  /**
    * Bulk create issue
    * Creates issues and, where the option to create subtasks is enabled in Jira, subtasks. Transitions may be applied, to move the issues or subtasks to a workflow step other than the default start step, and issue properties set.  The content of each issue or subtask is defined using &#x60;update&#x60; and &#x60;fields&#x60;. The fields that can be set in the issue or subtask are determined using the [ Get create issue metadata](#api-rest-api-3-issue-createmeta-get). These are the same fields that appear on the issues&#39; create screens. Note that the &#x60;description&#x60;, &#x60;environment&#x60;, and any &#x60;textarea&#x60; type custom fields (multi-line text fields) take Atlassian Document Format content. Single line custom fields (&#x60;textfield&#x60;) accept a string and don&#39;t handle Atlassian Document Format content.  Creating a subtask differs from creating an issue as follows:   *  &#x60;issueType&#x60; must be set to a subtask issue type (use [ Get create issue metadata](#api-rest-api-3-issue-createmeta-get) to find subtask issue types).  *  &#x60;parent&#x60; the must contain the ID or key of the parent issue.  **[Permissions](#permissions) required:** *Browse projects* and *Create issues* [project permissions](https://confluence.atlassian.com/x/yodKLg) for the project in which each issue or subtask is created.
    * <p><b>201</b> - Returned if any of the issue or subtask creation requests were successful. A request may be unsuccessful when it:   *  is missing required fields.  *  contains invalid field values.  *  contains fields that cannot be set for the issue type.  *  is by a user who does not have the necessary permission.  *  is to create a subtype in a project different that of the parent issue.  *  is for a subtask when the option to create subtasks is disabled.  *  is invalid for any other reason.
    * <p><b>400</b> - Returned if all requests are invalid. Requests may be unsuccessful when they:   *  are missing required fields.  *  contain invalid field values.  *  contain fields that cannot be set for the issue type.  *  are by a user who does not have the necessary permission.  *  are to create a subtype in a project different that of the parent issue.  *  is for a subtask when the option to create subtasks is disabled.  *  are invalid for any other reason.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param requestBody The requestBody parameter
    * @return CreatedIssues
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public CreatedIssues createIssues(Map<String, Object> requestBody) throws IOException {
        HttpResponse response = createIssuesForHttpResponse(requestBody);
        TypeReference<CreatedIssues> typeRef = new TypeReference<CreatedIssues>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Bulk create issue
    * Creates issues and, where the option to create subtasks is enabled in Jira, subtasks. Transitions may be applied, to move the issues or subtasks to a workflow step other than the default start step, and issue properties set.  The content of each issue or subtask is defined using &#x60;update&#x60; and &#x60;fields&#x60;. The fields that can be set in the issue or subtask are determined using the [ Get create issue metadata](#api-rest-api-3-issue-createmeta-get). These are the same fields that appear on the issues&#39; create screens. Note that the &#x60;description&#x60;, &#x60;environment&#x60;, and any &#x60;textarea&#x60; type custom fields (multi-line text fields) take Atlassian Document Format content. Single line custom fields (&#x60;textfield&#x60;) accept a string and don&#39;t handle Atlassian Document Format content.  Creating a subtask differs from creating an issue as follows:   *  &#x60;issueType&#x60; must be set to a subtask issue type (use [ Get create issue metadata](#api-rest-api-3-issue-createmeta-get) to find subtask issue types).  *  &#x60;parent&#x60; the must contain the ID or key of the parent issue.  **[Permissions](#permissions) required:** *Browse projects* and *Create issues* [project permissions](https://confluence.atlassian.com/x/yodKLg) for the project in which each issue or subtask is created.
    * <p><b>201</b> - Returned if any of the issue or subtask creation requests were successful. A request may be unsuccessful when it:   *  is missing required fields.  *  contains invalid field values.  *  contains fields that cannot be set for the issue type.  *  is by a user who does not have the necessary permission.  *  is to create a subtype in a project different that of the parent issue.  *  is for a subtask when the option to create subtasks is disabled.  *  is invalid for any other reason.
    * <p><b>400</b> - Returned if all requests are invalid. Requests may be unsuccessful when they:   *  are missing required fields.  *  contain invalid field values.  *  contain fields that cannot be set for the issue type.  *  are by a user who does not have the necessary permission.  *  are to create a subtype in a project different that of the parent issue.  *  is for a subtask when the option to create subtasks is disabled.  *  are invalid for any other reason.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param requestBody The requestBody parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return CreatedIssues
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public CreatedIssues createIssues(Map<String, Object> requestBody, Map<String, Object> params) throws IOException {
        HttpResponse response = createIssuesForHttpResponse(requestBody, params);
        TypeReference<CreatedIssues> typeRef = new TypeReference<CreatedIssues>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse createIssuesForHttpResponse(Map<String, Object> requestBody) throws IOException {
        // verify the required parameter 'requestBody' is set
        if (requestBody == null) {
            throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling createIssues");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/bulk");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(requestBody);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse createIssuesForHttpResponse(java.io.InputStream requestBody, String mediaType) throws IOException {
          // verify the required parameter 'requestBody' is set
              if (requestBody == null) {
              throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling createIssues");
              }
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/bulk");

              String localVarUrl = uriBuilder.build().toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = requestBody == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, requestBody);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse createIssuesForHttpResponse(Map<String, Object> requestBody, Map<String, Object> params) throws IOException {
        // verify the required parameter 'requestBody' is set
        if (requestBody == null) {
            throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling createIssues");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/bulk");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);

        for (Map.Entry<String, Object> entry: allParams.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (key != null && value != null) {
                if (value instanceof Collection) {
                    uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
                } else if (value instanceof Object[]) {
                    uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
                } else {
                    uriBuilder = uriBuilder.queryParam(key, value);
                }
            }
        }

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(requestBody);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


  /**
    * Delete issue
    * Deletes an issue.  An issue cannot be deleted if it has one or more subtasks. To delete an issue with subtasks, set &#x60;deleteSubtasks&#x60;. This causes the issue&#39;s subtasks to be deleted with the issue.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* and *Delete issues* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project containing the issue.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the issue has subtasks and &#x60;deleteSubtasks&#x60; is not set to *true*.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect.
    * <p><b>403</b> - Returned if the user does not have permission to delete the issue.
    * <p><b>404</b> - Returned if the issue is not found or the user does not have permission to view the issue.
    * @param issueIdOrKey The ID or key of the issue.
    * @param deleteSubtasks Whether the issue&#39;s subtasks are deleted when the issue is deleted.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteIssue(String issueIdOrKey, String deleteSubtasks) throws IOException {
        deleteIssueForHttpResponse(issueIdOrKey, deleteSubtasks);
    }

  /**
    * Delete issue
    * Deletes an issue.  An issue cannot be deleted if it has one or more subtasks. To delete an issue with subtasks, set &#x60;deleteSubtasks&#x60;. This causes the issue&#39;s subtasks to be deleted with the issue.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* and *Delete issues* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project containing the issue.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the issue has subtasks and &#x60;deleteSubtasks&#x60; is not set to *true*.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect.
    * <p><b>403</b> - Returned if the user does not have permission to delete the issue.
    * <p><b>404</b> - Returned if the issue is not found or the user does not have permission to view the issue.
    * @param issueIdOrKey The ID or key of the issue.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteIssue(String issueIdOrKey, Map<String, Object> params) throws IOException {
        deleteIssueForHttpResponse(issueIdOrKey, params);
    }

    public HttpResponse deleteIssueForHttpResponse(String issueIdOrKey, String deleteSubtasks) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling deleteIssue");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}");
        if (deleteSubtasks != null) {
            String key = "deleteSubtasks";
            Object value = deleteSubtasks;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }

    public HttpResponse deleteIssueForHttpResponse(String issueIdOrKey, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling deleteIssue");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);

        for (Map.Entry<String, Object> entry: allParams.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (key != null && value != null) {
                if (value instanceof Collection) {
                    uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
                } else if (value instanceof Object[]) {
                    uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
                } else {
                    uriBuilder = uriBuilder.queryParam(key, value);
                }
            }
        }

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }


  /**
    * Transition issue
    * Performs an issue transition and, if the transition has a screen, updates the fields from the transition screen.  sortByCategory To update the fields on the transition screen, specify the fields in the &#x60;fields&#x60; or &#x60;update&#x60; parameters in the request body. Get details about the fields using [ Get transitions](#api-rest-api-3-issue-issueIdOrKey-transitions-get) with the &#x60;transitions.fields&#x60; expand.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* and *Transition issues* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  no transition is specified.  *  the user does not have permission to transition the issue.  *  a field that isn&#39;t included on the transition screen is defined in &#x60;fields&#x60; or &#x60;update&#x60;.  *  a field is specified in both &#x60;fields&#x60; and &#x60;update&#x60;.  *  the request is invalid for any other reason.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the issue is not found or the user does not have permission to view it.
    * @param issueIdOrKey The ID or key of the issue.
    * @param requestBody The requestBody parameter
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object doTransition(String issueIdOrKey, Map<String, Object> requestBody) throws IOException {
        HttpResponse response = doTransitionForHttpResponse(issueIdOrKey, requestBody);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Transition issue
    * Performs an issue transition and, if the transition has a screen, updates the fields from the transition screen.  sortByCategory To update the fields on the transition screen, specify the fields in the &#x60;fields&#x60; or &#x60;update&#x60; parameters in the request body. Get details about the fields using [ Get transitions](#api-rest-api-3-issue-issueIdOrKey-transitions-get) with the &#x60;transitions.fields&#x60; expand.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* and *Transition issues* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  no transition is specified.  *  the user does not have permission to transition the issue.  *  a field that isn&#39;t included on the transition screen is defined in &#x60;fields&#x60; or &#x60;update&#x60;.  *  a field is specified in both &#x60;fields&#x60; and &#x60;update&#x60;.  *  the request is invalid for any other reason.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the issue is not found or the user does not have permission to view it.
    * @param issueIdOrKey The ID or key of the issue.
    * @param requestBody The requestBody parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object doTransition(String issueIdOrKey, Map<String, Object> requestBody, Map<String, Object> params) throws IOException {
        HttpResponse response = doTransitionForHttpResponse(issueIdOrKey, requestBody, params);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse doTransitionForHttpResponse(String issueIdOrKey, Map<String, Object> requestBody) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling doTransition");
        }// verify the required parameter 'requestBody' is set
        if (requestBody == null) {
            throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling doTransition");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/transitions");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(requestBody);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse doTransitionForHttpResponse(String issueIdOrKey, java.io.InputStream requestBody, String mediaType) throws IOException {
          // verify the required parameter 'issueIdOrKey' is set
              if (issueIdOrKey == null) {
              throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling doTransition");
              }// verify the required parameter 'requestBody' is set
              if (requestBody == null) {
              throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling doTransition");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("issueIdOrKey", issueIdOrKey);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/transitions");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = requestBody == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, requestBody);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse doTransitionForHttpResponse(String issueIdOrKey, Map<String, Object> requestBody, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling doTransition");
        }// verify the required parameter 'requestBody' is set
        if (requestBody == null) {
            throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling doTransition");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/transitions");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);

        for (Map.Entry<String, Object> entry: allParams.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (key != null && value != null) {
                if (value instanceof Collection) {
                    uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
                } else if (value instanceof Object[]) {
                    uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
                } else {
                    uriBuilder = uriBuilder.queryParam(key, value);
                }
            }
        }

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(requestBody);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


  /**
    * Edit issue
    * Edits an issue. A transition may be applied and issue properties updated as part of the edit.  The edits to the issue&#39;s fields are defined using &#x60;update&#x60; and &#x60;fields&#x60;. The fields that can be edited are determined using [ Get edit issue metadata](#api-rest-api-3-issue-issueIdOrKey-editmeta-get).  The parent field may be set by key or ID. For standard issue types, the parent may be removed by setting &#x60;update.parent.set.none&#x60; to *true*. Note that the &#x60;description&#x60;, &#x60;environment&#x60;, and any &#x60;textarea&#x60; type custom fields (multi-line text fields) take Atlassian Document Format content. Single line custom fields (&#x60;textfield&#x60;) accept a string and don&#39;t handle Atlassian Document Format content.  Connect app users with admin permissions (from user permissions and app scopes) can override the screen security configuration using &#x60;overrideScreenSecurity&#x60; and &#x60;overrideEditableFlag&#x60;.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* and *Edit issues* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  the request body is missing.  *  the user does not have the necessary permission to edit one or more fields.  *  the request includes one or more fields that are not found or are not associated with the issue&#39;s edit screen.  *  the request includes an invalid transition.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user uses &#x60;overrideScreenSecurity&#x60; or &#x60;overrideEditableFlag&#x60; but doesn&#39;t have the necessary permission.
    * <p><b>404</b> - Returned if the issue is not found or the user does not have permission to view it.
    * @param issueIdOrKey The ID or key of the issue.
    * @param requestBody The requestBody parameter
    * @param notifyUsers Whether a notification email about the issue update is sent to all watchers. To disable the notification, administer Jira or administer project permissions are required. If the user doesn&#39;t have the necessary permission the request is ignored.
    * @param overrideScreenSecurity Whether screen security should be overridden to enable hidden fields to be edited. Available to Connect app users with admin permissions.
    * @param overrideEditableFlag Whether screen security should be overridden to enable uneditable fields to be edited. Available to Connect app users with admin permissions.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object editIssue(String issueIdOrKey, Map<String, Object> requestBody, Boolean notifyUsers, Boolean overrideScreenSecurity, Boolean overrideEditableFlag) throws IOException {
        HttpResponse response = editIssueForHttpResponse(issueIdOrKey, requestBody, notifyUsers, overrideScreenSecurity, overrideEditableFlag);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Edit issue
    * Edits an issue. A transition may be applied and issue properties updated as part of the edit.  The edits to the issue&#39;s fields are defined using &#x60;update&#x60; and &#x60;fields&#x60;. The fields that can be edited are determined using [ Get edit issue metadata](#api-rest-api-3-issue-issueIdOrKey-editmeta-get).  The parent field may be set by key or ID. For standard issue types, the parent may be removed by setting &#x60;update.parent.set.none&#x60; to *true*. Note that the &#x60;description&#x60;, &#x60;environment&#x60;, and any &#x60;textarea&#x60; type custom fields (multi-line text fields) take Atlassian Document Format content. Single line custom fields (&#x60;textfield&#x60;) accept a string and don&#39;t handle Atlassian Document Format content.  Connect app users with admin permissions (from user permissions and app scopes) can override the screen security configuration using &#x60;overrideScreenSecurity&#x60; and &#x60;overrideEditableFlag&#x60;.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* and *Edit issues* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  the request body is missing.  *  the user does not have the necessary permission to edit one or more fields.  *  the request includes one or more fields that are not found or are not associated with the issue&#39;s edit screen.  *  the request includes an invalid transition.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user uses &#x60;overrideScreenSecurity&#x60; or &#x60;overrideEditableFlag&#x60; but doesn&#39;t have the necessary permission.
    * <p><b>404</b> - Returned if the issue is not found or the user does not have permission to view it.
    * @param issueIdOrKey The ID or key of the issue.
    * @param requestBody The requestBody parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object editIssue(String issueIdOrKey, Map<String, Object> requestBody, Map<String, Object> params) throws IOException {
        HttpResponse response = editIssueForHttpResponse(issueIdOrKey, requestBody, params);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse editIssueForHttpResponse(String issueIdOrKey, Map<String, Object> requestBody, Boolean notifyUsers, Boolean overrideScreenSecurity, Boolean overrideEditableFlag) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling editIssue");
        }// verify the required parameter 'requestBody' is set
        if (requestBody == null) {
            throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling editIssue");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}");
        if (notifyUsers != null) {
            String key = "notifyUsers";
            Object value = notifyUsers;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (overrideScreenSecurity != null) {
            String key = "overrideScreenSecurity";
            Object value = overrideScreenSecurity;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (overrideEditableFlag != null) {
            String key = "overrideEditableFlag";
            Object value = overrideEditableFlag;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(requestBody);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse editIssueForHttpResponse(String issueIdOrKey, java.io.InputStream requestBody, Boolean notifyUsers, Boolean overrideScreenSecurity, Boolean overrideEditableFlag, String mediaType) throws IOException {
          // verify the required parameter 'issueIdOrKey' is set
              if (issueIdOrKey == null) {
              throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling editIssue");
              }// verify the required parameter 'requestBody' is set
              if (requestBody == null) {
              throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling editIssue");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("issueIdOrKey", issueIdOrKey);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}");
              if (notifyUsers != null) {
                  String key = "notifyUsers";
                  Object value = notifyUsers;
                  if (value instanceof Collection) {
                    uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
                  } else if (value instanceof Object[]) {
                    uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
                  } else {
                    uriBuilder = uriBuilder.queryParam(key, value);
                  }
              }              if (overrideScreenSecurity != null) {
                  String key = "overrideScreenSecurity";
                  Object value = overrideScreenSecurity;
                  if (value instanceof Collection) {
                    uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
                  } else if (value instanceof Object[]) {
                    uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
                  } else {
                    uriBuilder = uriBuilder.queryParam(key, value);
                  }
              }              if (overrideEditableFlag != null) {
                  String key = "overrideEditableFlag";
                  Object value = overrideEditableFlag;
                  if (value instanceof Collection) {
                    uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
                  } else if (value instanceof Object[]) {
                    uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
                  } else {
                    uriBuilder = uriBuilder.queryParam(key, value);
                  }
              }

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = requestBody == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, requestBody);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse editIssueForHttpResponse(String issueIdOrKey, Map<String, Object> requestBody, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling editIssue");
        }// verify the required parameter 'requestBody' is set
        if (requestBody == null) {
            throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling editIssue");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);

        for (Map.Entry<String, Object> entry: allParams.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (key != null && value != null) {
                if (value instanceof Collection) {
                    uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
                } else if (value instanceof Object[]) {
                    uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
                } else {
                    uriBuilder = uriBuilder.queryParam(key, value);
                }
            }
        }

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(requestBody);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }


  /**
    * Get change logs
    * Returns a [paginated](#pagination) list of all changelogs for an issue sorted by date, starting from the oldest.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>404</b> - Returned if the issue is not found or the user does not have permission to view it.
    * @param issueIdOrKey The ID or key of the issue.
    * @param startAt The index of the first item to return in a page of results (page offset).
    * @param maxResults The maximum number of items to return per page.
    * @return PageBeanChangelog
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanChangelog getChangeLogs(String issueIdOrKey, Integer startAt, Integer maxResults) throws IOException {
        HttpResponse response = getChangeLogsForHttpResponse(issueIdOrKey, startAt, maxResults);
        TypeReference<PageBeanChangelog> typeRef = new TypeReference<PageBeanChangelog>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get change logs
    * Returns a [paginated](#pagination) list of all changelogs for an issue sorted by date, starting from the oldest.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>404</b> - Returned if the issue is not found or the user does not have permission to view it.
    * @param issueIdOrKey The ID or key of the issue.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PageBeanChangelog
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanChangelog getChangeLogs(String issueIdOrKey, Map<String, Object> params) throws IOException {
        HttpResponse response = getChangeLogsForHttpResponse(issueIdOrKey, params);
        TypeReference<PageBeanChangelog> typeRef = new TypeReference<PageBeanChangelog>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getChangeLogsForHttpResponse(String issueIdOrKey, Integer startAt, Integer maxResults) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling getChangeLogs");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/changelog");
        if (startAt != null) {
            String key = "startAt";
            Object value = startAt;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (maxResults != null) {
            String key = "maxResults";
            Object value = maxResults;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getChangeLogsForHttpResponse(String issueIdOrKey, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling getChangeLogs");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/changelog");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);

        for (Map.Entry<String, Object> entry: allParams.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (key != null && value != null) {
                if (value instanceof Collection) {
                    uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
                } else if (value instanceof Object[]) {
                    uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
                } else {
                    uriBuilder = uriBuilder.queryParam(key, value);
                }
            }
        }

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }


  /**
    * Get create issue metadata
    * Returns details of projects, issue types within projects, and, when requested, the create screen fields for each issue type for the user. Use the information to populate the requests in [ Create issue](#api-rest-api-3-issue-post) and [Create issues](#api-rest-api-3-issue-bulk-post).  The request can be restricted to specific projects or issue types using the query parameters. The response will contain information for the valid projects, issue types, or project and issue type combinations requested. Note that invalid project, issue type, or project and issue type combinations do not generate errors.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Create issues* [project permission](https://confluence.atlassian.com/x/yodKLg) in the requested projects.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param projectIds List of project IDs. This parameter accepts a comma-separated list. Multiple project IDs can also be provided using an ampersand-separated list. For example, &#x60;projectIds&#x3D;10000,10001&amp;projectIds&#x3D;10020,10021&#x60;. This parameter may be provided with &#x60;projectKeys&#x60;.
    * @param projectKeys List of project keys. This parameter accepts a comma-separated list. Multiple project keys can also be provided using an ampersand-separated list. For example, &#x60;projectKeys&#x3D;proj1,proj2&amp;projectKeys&#x3D;proj3&#x60;. This parameter may be provided with &#x60;projectIds&#x60;.
    * @param issuetypeIds List of issue type IDs. This parameter accepts a comma-separated list. Multiple issue type IDs can also be provided using an ampersand-separated list. For example, &#x60;issuetypeIds&#x3D;10000,10001&amp;issuetypeIds&#x3D;10020,10021&#x60;. This parameter may be provided with &#x60;issuetypeNames&#x60;.
    * @param issuetypeNames List of issue type names. This parameter accepts a comma-separated list. Multiple issue type names can also be provided using an ampersand-separated list. For example, &#x60;issuetypeNames&#x3D;name1,name2&amp;issuetypeNames&#x3D;name3&#x60;. This parameter may be provided with &#x60;issuetypeIds&#x60;.
    * @param expand Use [expand](#expansion) to include additional information about issue metadata in the response. This parameter accepts &#x60;projects.issuetypes.fields&#x60;, which returns information about the fields in the issue creation screen for each issue type. Fields hidden from the screen are not returned. Use the information to populate the &#x60;fields&#x60; and &#x60;update&#x60; fields in [Create issue](#api-rest-api-3-issue-post) and [Create issues](#api-rest-api-3-issue-bulk-post).
    * @return IssueCreateMetadata
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public IssueCreateMetadata getCreateIssueMeta(List<String> projectIds, List<String> projectKeys, List<String> issuetypeIds, List<String> issuetypeNames, String expand) throws IOException {
        HttpResponse response = getCreateIssueMetaForHttpResponse(projectIds, projectKeys, issuetypeIds, issuetypeNames, expand);
        TypeReference<IssueCreateMetadata> typeRef = new TypeReference<IssueCreateMetadata>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get create issue metadata
    * Returns details of projects, issue types within projects, and, when requested, the create screen fields for each issue type for the user. Use the information to populate the requests in [ Create issue](#api-rest-api-3-issue-post) and [Create issues](#api-rest-api-3-issue-bulk-post).  The request can be restricted to specific projects or issue types using the query parameters. The response will contain information for the valid projects, issue types, or project and issue type combinations requested. Note that invalid project, issue type, or project and issue type combinations do not generate errors.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Create issues* [project permission](https://confluence.atlassian.com/x/yodKLg) in the requested projects.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return IssueCreateMetadata
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public IssueCreateMetadata getCreateIssueMeta(Map<String, Object> params) throws IOException {
        HttpResponse response = getCreateIssueMetaForHttpResponse(params);
        TypeReference<IssueCreateMetadata> typeRef = new TypeReference<IssueCreateMetadata>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getCreateIssueMetaForHttpResponse(List<String> projectIds, List<String> projectKeys, List<String> issuetypeIds, List<String> issuetypeNames, String expand) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/createmeta");
        if (projectIds != null) {
            String key = "projectIds";
            Object value = projectIds;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (projectKeys != null) {
            String key = "projectKeys";
            Object value = projectKeys;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (issuetypeIds != null) {
            String key = "issuetypeIds";
            Object value = issuetypeIds;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (issuetypeNames != null) {
            String key = "issuetypeNames";
            Object value = issuetypeNames;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (expand != null) {
            String key = "expand";
            Object value = expand;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getCreateIssueMetaForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/createmeta");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);

        for (Map.Entry<String, Object> entry: allParams.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (key != null && value != null) {
                if (value instanceof Collection) {
                    uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
                } else if (value instanceof Object[]) {
                    uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
                } else {
                    uriBuilder = uriBuilder.queryParam(key, value);
                }
            }
        }

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }


  /**
    * Get edit issue metadata
    * Returns the edit screen fields for an issue that are visible to and editable by the user. Use the information to populate the requests in [Edit issue](#api-rest-api-3-issue-issueIdOrKey-put).  Connect app users with admin permissions (from user permissions and app scopes) can return additional details using:   *  &#x60;overrideScreenSecurity&#x60; Returns hidden fields.  *  &#x60;overrideEditableFlag&#x60; Returns uneditable fields. For example, where an issue has a workflow status of closed none of its fields are editable.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  Note: For any fields to be editable the user must have the *Edit issues* [project permission](https://confluence.atlassian.com/x/yodKLg) for the issue.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user uses an override parameter but doesn&#39;t have permission to do so.
    * <p><b>404</b> - Returned if the issue is not found or the user does not have permission to view it.
    * @param issueIdOrKey The ID or key of the issue.
    * @param overrideScreenSecurity Whether hidden fields should be returned. Available to connect app users with admin permissions.
    * @param overrideEditableFlag Whether non-editable fields should be returned. Available to connect app users with admin permissions.
    * @return IssueUpdateMetadata
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public IssueUpdateMetadata getEditIssueMeta(String issueIdOrKey, Boolean overrideScreenSecurity, Boolean overrideEditableFlag) throws IOException {
        HttpResponse response = getEditIssueMetaForHttpResponse(issueIdOrKey, overrideScreenSecurity, overrideEditableFlag);
        TypeReference<IssueUpdateMetadata> typeRef = new TypeReference<IssueUpdateMetadata>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get edit issue metadata
    * Returns the edit screen fields for an issue that are visible to and editable by the user. Use the information to populate the requests in [Edit issue](#api-rest-api-3-issue-issueIdOrKey-put).  Connect app users with admin permissions (from user permissions and app scopes) can return additional details using:   *  &#x60;overrideScreenSecurity&#x60; Returns hidden fields.  *  &#x60;overrideEditableFlag&#x60; Returns uneditable fields. For example, where an issue has a workflow status of closed none of its fields are editable.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  Note: For any fields to be editable the user must have the *Edit issues* [project permission](https://confluence.atlassian.com/x/yodKLg) for the issue.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user uses an override parameter but doesn&#39;t have permission to do so.
    * <p><b>404</b> - Returned if the issue is not found or the user does not have permission to view it.
    * @param issueIdOrKey The ID or key of the issue.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return IssueUpdateMetadata
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public IssueUpdateMetadata getEditIssueMeta(String issueIdOrKey, Map<String, Object> params) throws IOException {
        HttpResponse response = getEditIssueMetaForHttpResponse(issueIdOrKey, params);
        TypeReference<IssueUpdateMetadata> typeRef = new TypeReference<IssueUpdateMetadata>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getEditIssueMetaForHttpResponse(String issueIdOrKey, Boolean overrideScreenSecurity, Boolean overrideEditableFlag) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling getEditIssueMeta");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/editmeta");
        if (overrideScreenSecurity != null) {
            String key = "overrideScreenSecurity";
            Object value = overrideScreenSecurity;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (overrideEditableFlag != null) {
            String key = "overrideEditableFlag";
            Object value = overrideEditableFlag;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getEditIssueMetaForHttpResponse(String issueIdOrKey, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling getEditIssueMeta");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/editmeta");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);

        for (Map.Entry<String, Object> entry: allParams.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (key != null && value != null) {
                if (value instanceof Collection) {
                    uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
                } else if (value instanceof Object[]) {
                    uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
                } else {
                    uriBuilder = uriBuilder.queryParam(key, value);
                }
            }
        }

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }


  /**
    * Get issue
    * Returns the details for an issue.  The issue is identified by its ID or key, however, if the identifier doesn&#39;t match an issue, a case-insensitive search and check for moved issues is performed. If a matching issue is found its details are returned, a 302 or other redirect is **not** returned. The issue key returned in the response is the key of the issue found.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the issue is not found or the user does not have permission to view it.
    * @param issueIdOrKey The ID or key of the issue.
    * @param fields A list of fields to return for the issue. This parameter accepts a comma-separated list. Use it to retrieve a subset of fields. Allowed values:   *  &#x60;*all&#x60; Returns all fields.  *  &#x60;*navigable&#x60; Returns navigable fields.  *  Any issue field, prefixed with a minus to exclude.  Examples:   *  &#x60;summary,comment&#x60; Returns only the summary and comments fields.  *  &#x60;-description&#x60; Returns all (default) fields except description.  *  &#x60;*navigable,-comment&#x60; Returns all navigable fields except comment.  This parameter may be specified multiple times. For example, &#x60;fields&#x3D;field1,field2&amp; fields&#x3D;field3&#x60;.  Note: All fields are returned by default. This differs from [Search for issues using JQL (GET)](#api-rest-api-3-search-get) and [Search for issues using JQL (POST)](#api-rest-api-3-search-post) where the default is all navigable fields.
    * @param fieldsByKeys Whether fields in &#x60;fields&#x60; are referenced by keys rather than IDs. This parameter is useful where fields have been added by a connect app and a field&#39;s key may differ from its ID.
    * @param expand Use [expand](#expansion) to include additional information about the issues in the response. This parameter accepts a comma-separated list. Expand options include:   *  &#x60;renderedFields&#x60; Returns field values rendered in HTML format.  *  &#x60;names&#x60; Returns the display name of each field.  *  &#x60;schema&#x60; Returns the schema describing a field type.  *  &#x60;transitions&#x60; Returns all possible transitions for the issue.  *  &#x60;editmeta&#x60; Returns information about how each field can be edited.  *  &#x60;changelog&#x60; Returns a list of recent updates to an issue, sorted by date, starting from the most recent.  *  &#x60;versionedRepresentations&#x60; Returns a JSON array for each version of a field&#39;s value, with the highest number representing the most recent version. Note: When included in the request, the &#x60;fields&#x60; parameter is ignored.
    * @param properties A list of issue properties to return for the issue. This parameter accepts a comma-separated list. Allowed values:   *  &#x60;*all&#x60; Returns all issue properties.  *  Any issue property key, prefixed with a minus to exclude.  Examples:   *  &#x60;*all&#x60; Returns all properties.  *  &#x60;*all,-prop1&#x60; Returns all properties except &#x60;prop1&#x60;.  *  &#x60;prop1,prop2&#x60; Returns &#x60;prop1&#x60; and &#x60;prop2&#x60; properties.  This parameter may be specified multiple times. For example, &#x60;properties&#x3D;prop1,prop2&amp; properties&#x3D;prop3&#x60;.
    * @param updateHistory Whether the project in which the issue is created is added to the user&#39;s **Recently viewed** project list, as shown under **Projects** in Jira. This also populates the [JQL issues search](#api-rest-api-3-search-get) &#x60;lastViewed&#x60; field.
    * @return IssueBean
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public IssueBean getIssue(String issueIdOrKey, List<String> fields, Boolean fieldsByKeys, String expand, List<String> properties, Boolean updateHistory) throws IOException {
        HttpResponse response = getIssueForHttpResponse(issueIdOrKey, fields, fieldsByKeys, expand, properties, updateHistory);
        TypeReference<IssueBean> typeRef = new TypeReference<IssueBean>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get issue
    * Returns the details for an issue.  The issue is identified by its ID or key, however, if the identifier doesn&#39;t match an issue, a case-insensitive search and check for moved issues is performed. If a matching issue is found its details are returned, a 302 or other redirect is **not** returned. The issue key returned in the response is the key of the issue found.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the issue is not found or the user does not have permission to view it.
    * @param issueIdOrKey The ID or key of the issue.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return IssueBean
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public IssueBean getIssue(String issueIdOrKey, Map<String, Object> params) throws IOException {
        HttpResponse response = getIssueForHttpResponse(issueIdOrKey, params);
        TypeReference<IssueBean> typeRef = new TypeReference<IssueBean>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getIssueForHttpResponse(String issueIdOrKey, List<String> fields, Boolean fieldsByKeys, String expand, List<String> properties, Boolean updateHistory) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling getIssue");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}");
        if (fields != null) {
            String key = "fields";
            Object value = fields;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (fieldsByKeys != null) {
            String key = "fieldsByKeys";
            Object value = fieldsByKeys;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (expand != null) {
            String key = "expand";
            Object value = expand;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (properties != null) {
            String key = "properties";
            Object value = properties;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (updateHistory != null) {
            String key = "updateHistory";
            Object value = updateHistory;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getIssueForHttpResponse(String issueIdOrKey, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling getIssue");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);

        for (Map.Entry<String, Object> entry: allParams.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (key != null && value != null) {
                if (value instanceof Collection) {
                    uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
                } else if (value instanceof Object[]) {
                    uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
                } else {
                    uriBuilder = uriBuilder.queryParam(key, value);
                }
            }
        }

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }


  /**
    * Get transitions
    * Returns either all transitions or a transition that can be performed by the user on an issue, based on the issue&#39;s status.  Note, if a request is made for a transition that does not exist or cannot be performed on the issue, given its status, the response will return any empty transitions list.  This operation can be accessed anonymously.  **[Permissions](#permissions) required: A list or transition is returned only when the user has:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  However, if the user does not have the *Transition issues* [ project permission](https://confluence.atlassian.com/x/yodKLg) the response will not list any transitions.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the issue is not found or the user does not have permission to view it.
    * @param issueIdOrKey The ID or key of the issue.
    * @param expand Use [expand](#expansion) to include additional information about transitions in the response. This parameter accepts &#x60;transitions.fields&#x60;, which returns information about the fields in the transition screen for each transition. Fields hidden from the screen are not returned. Use this information to populate the &#x60;fields&#x60; and &#x60;update&#x60; fields in [Transition issue](#api-rest-api-3-issue-issueIdOrKey-transitions-post).
    * @param transitionId The ID of the transition.
    * @param skipRemoteOnlyCondition Whether transitions with the condition *Hide From User Condition* are included in the response.
    * @param includeUnavailableTransitions Whether details of transitions that fail a condition are included in the response
    * @param sortByOpsBarAndStatus Whether the transitions are sorted by ops-bar sequence value first then category order (Todo, In Progress, Done) or only by ops-bar sequence value.
    * @return Transitions
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Transitions getTransitions(String issueIdOrKey, String expand, String transitionId, Boolean skipRemoteOnlyCondition, Boolean includeUnavailableTransitions, Boolean sortByOpsBarAndStatus) throws IOException {
        HttpResponse response = getTransitionsForHttpResponse(issueIdOrKey, expand, transitionId, skipRemoteOnlyCondition, includeUnavailableTransitions, sortByOpsBarAndStatus);
        TypeReference<Transitions> typeRef = new TypeReference<Transitions>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get transitions
    * Returns either all transitions or a transition that can be performed by the user on an issue, based on the issue&#39;s status.  Note, if a request is made for a transition that does not exist or cannot be performed on the issue, given its status, the response will return any empty transitions list.  This operation can be accessed anonymously.  **[Permissions](#permissions) required: A list or transition is returned only when the user has:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  However, if the user does not have the *Transition issues* [ project permission](https://confluence.atlassian.com/x/yodKLg) the response will not list any transitions.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the issue is not found or the user does not have permission to view it.
    * @param issueIdOrKey The ID or key of the issue.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Transitions
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Transitions getTransitions(String issueIdOrKey, Map<String, Object> params) throws IOException {
        HttpResponse response = getTransitionsForHttpResponse(issueIdOrKey, params);
        TypeReference<Transitions> typeRef = new TypeReference<Transitions>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getTransitionsForHttpResponse(String issueIdOrKey, String expand, String transitionId, Boolean skipRemoteOnlyCondition, Boolean includeUnavailableTransitions, Boolean sortByOpsBarAndStatus) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling getTransitions");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/transitions");
        if (expand != null) {
            String key = "expand";
            Object value = expand;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (transitionId != null) {
            String key = "transitionId";
            Object value = transitionId;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (skipRemoteOnlyCondition != null) {
            String key = "skipRemoteOnlyCondition";
            Object value = skipRemoteOnlyCondition;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (includeUnavailableTransitions != null) {
            String key = "includeUnavailableTransitions";
            Object value = includeUnavailableTransitions;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (sortByOpsBarAndStatus != null) {
            String key = "sortByOpsBarAndStatus";
            Object value = sortByOpsBarAndStatus;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getTransitionsForHttpResponse(String issueIdOrKey, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling getTransitions");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/transitions");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);

        for (Map.Entry<String, Object> entry: allParams.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (key != null && value != null) {
                if (value instanceof Collection) {
                    uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
                } else if (value instanceof Object[]) {
                    uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
                } else {
                    uriBuilder = uriBuilder.queryParam(key, value);
                }
            }
        }

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }


  /**
    * Send notification for issue
    * Creates an email notification for an issue and adds it to the mail queue.  **[Permissions](#permissions) required:**   *  *Browse Projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.
    * <p><b>204</b> - Returned if the email is queued for sending.
    * <p><b>400</b> - Returned if:   *  the recipient is the same as the calling user.  *  the recipient is invalid. For example, the recipient is set to the assignee, but the issue is unassigned.  *  the request is invalid. For example, required fields are missing or have invalid values.
    * <p><b>403</b> - Returned if:   *  outgoing emails are disabled.  *  no SMTP server is configured.
    * <p><b>404</b> - Returned if the issue is not found.
    * @param issueIdOrKey ID or key of the issue that the notification is sent for.
    * @param requestBody The request object for the notification and recipients.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object notify(String issueIdOrKey, Map<String, Object> requestBody) throws IOException {
        HttpResponse response = notifyForHttpResponse(issueIdOrKey, requestBody);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Send notification for issue
    * Creates an email notification for an issue and adds it to the mail queue.  **[Permissions](#permissions) required:**   *  *Browse Projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.
    * <p><b>204</b> - Returned if the email is queued for sending.
    * <p><b>400</b> - Returned if:   *  the recipient is the same as the calling user.  *  the recipient is invalid. For example, the recipient is set to the assignee, but the issue is unassigned.  *  the request is invalid. For example, required fields are missing or have invalid values.
    * <p><b>403</b> - Returned if:   *  outgoing emails are disabled.  *  no SMTP server is configured.
    * <p><b>404</b> - Returned if the issue is not found.
    * @param issueIdOrKey ID or key of the issue that the notification is sent for.
    * @param requestBody The request object for the notification and recipients.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object notify(String issueIdOrKey, Map<String, Object> requestBody, Map<String, Object> params) throws IOException {
        HttpResponse response = notifyForHttpResponse(issueIdOrKey, requestBody, params);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse notifyForHttpResponse(String issueIdOrKey, Map<String, Object> requestBody) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling notify");
        }// verify the required parameter 'requestBody' is set
        if (requestBody == null) {
            throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling notify");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/notify");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(requestBody);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse notifyForHttpResponse(String issueIdOrKey, java.io.InputStream requestBody, String mediaType) throws IOException {
          // verify the required parameter 'issueIdOrKey' is set
              if (issueIdOrKey == null) {
              throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling notify");
              }// verify the required parameter 'requestBody' is set
              if (requestBody == null) {
              throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling notify");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("issueIdOrKey", issueIdOrKey);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/notify");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = requestBody == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, requestBody);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse notifyForHttpResponse(String issueIdOrKey, Map<String, Object> requestBody, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling notify");
        }// verify the required parameter 'requestBody' is set
        if (requestBody == null) {
            throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling notify");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/notify");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);

        for (Map.Entry<String, Object> entry: allParams.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (key != null && value != null) {
                if (value instanceof Collection) {
                    uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
                } else if (value instanceof Object[]) {
                    uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
                } else {
                    uriBuilder = uriBuilder.queryParam(key, value);
                }
            }
        }

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(requestBody);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


}
