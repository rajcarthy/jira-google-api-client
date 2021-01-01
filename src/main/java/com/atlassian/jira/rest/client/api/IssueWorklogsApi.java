package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.ChangedWorklogs;
import com.atlassian.jira.rest.client.model.PageOfWorklogs;
import com.atlassian.jira.rest.client.model.Worklog;
import com.atlassian.jira.rest.client.model.WorklogIdsRequestBean;

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
public class IssueWorklogsApi {
    private ApiClient apiClient;

    public IssueWorklogsApi() {
        this(new ApiClient());
    }

    public IssueWorklogsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Add worklog
    * Adds a worklog to an issue.  Time tracking must be enabled in Jira, otherwise this operation returns an error. For more information, see [Configuring time tracking](https://confluence.atlassian.com/x/qoXKM).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* and *Work on issues* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.
    * <p><b>201</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  &#x60;adjustEstimate&#x60; is set to &#x60;new&#x60; but &#x60;newEstimate&#x60; is not provided or is invalid.  *  &#x60;adjustEstimate&#x60; is set to &#x60;manual&#x60; but &#x60;reduceBy&#x60; is not provided or is invalid.  *  the user does not have permission to add the worklog.  *  the request JSON is malformed.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect.
    * <p><b>404</b> - Returned if the issue is not found or the user does not have permission to view it.
    * @param issueIdOrKey The ID or key the issue.
    * @param requestBody The requestBody parameter
    * @param notifyUsers Whether users watching the issue are notified by email.
    * @param adjustEstimate Defines how to update the issue&#39;s time estimate, the options are:   *  &#x60;new&#x60; Sets the estimate to a specific value, defined in &#x60;newEstimate&#x60;.  *  &#x60;leave&#x60; Leaves the estimate unchanged.  *  &#x60;manual&#x60; Reduces the estimate by amount specified in &#x60;reduceBy&#x60;.  *  &#x60;auto&#x60; Reduces the estimate by the value of &#x60;timeSpent&#x60; in the worklog.
    * @param newEstimate The value to set as the issue&#39;s remaining time estimate, as days (\\#d), hours (\\#h), or minutes (\\#m or \\#). For example, *2d*. Required when &#x60;adjustEstimate&#x60; is &#x60;new&#x60;.
    * @param reduceBy The amount to reduce the issue&#39;s remaining estimate by, as days (\\#d), hours (\\#h), or minutes (\\#m). For example, *2d*. Required when &#x60;adjustEstimate&#x60; is &#x60;manual&#x60;.
    * @param expand Use [expand](#expansion) to include additional information about work logs in the response. This parameter accepts &#x60;properties&#x60;, which returns worklog properties.
    * @param overrideEditableFlag Whether the worklog entry should be added to the issue even if the issue is not editable, because jira.issue.editable set to false or missing. For example, the issue is closed. Only connect app users with admin scope permission can use this flag.
    * @return Worklog
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Worklog addWorklog(String issueIdOrKey, Map<String, Object> requestBody, Boolean notifyUsers, String adjustEstimate, String newEstimate, String reduceBy, String expand, Boolean overrideEditableFlag) throws IOException {
        HttpResponse response = addWorklogForHttpResponse(issueIdOrKey, requestBody, notifyUsers, adjustEstimate, newEstimate, reduceBy, expand, overrideEditableFlag);
        TypeReference<Worklog> typeRef = new TypeReference<Worklog>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Add worklog
    * Adds a worklog to an issue.  Time tracking must be enabled in Jira, otherwise this operation returns an error. For more information, see [Configuring time tracking](https://confluence.atlassian.com/x/qoXKM).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* and *Work on issues* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.
    * <p><b>201</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  &#x60;adjustEstimate&#x60; is set to &#x60;new&#x60; but &#x60;newEstimate&#x60; is not provided or is invalid.  *  &#x60;adjustEstimate&#x60; is set to &#x60;manual&#x60; but &#x60;reduceBy&#x60; is not provided or is invalid.  *  the user does not have permission to add the worklog.  *  the request JSON is malformed.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect.
    * <p><b>404</b> - Returned if the issue is not found or the user does not have permission to view it.
    * @param issueIdOrKey The ID or key the issue.
    * @param requestBody The requestBody parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Worklog
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Worklog addWorklog(String issueIdOrKey, Map<String, Object> requestBody, Map<String, Object> params) throws IOException {
        HttpResponse response = addWorklogForHttpResponse(issueIdOrKey, requestBody, params);
        TypeReference<Worklog> typeRef = new TypeReference<Worklog>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse addWorklogForHttpResponse(String issueIdOrKey, Map<String, Object> requestBody, Boolean notifyUsers, String adjustEstimate, String newEstimate, String reduceBy, String expand, Boolean overrideEditableFlag) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling addWorklog");
        }// verify the required parameter 'requestBody' is set
        if (requestBody == null) {
            throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling addWorklog");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/worklog");
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
        }        if (adjustEstimate != null) {
            String key = "adjustEstimate";
            Object value = adjustEstimate;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (newEstimate != null) {
            String key = "newEstimate";
            Object value = newEstimate;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (reduceBy != null) {
            String key = "reduceBy";
            Object value = reduceBy;
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
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse addWorklogForHttpResponse(String issueIdOrKey, java.io.InputStream requestBody, Boolean notifyUsers, String adjustEstimate, String newEstimate, String reduceBy, String expand, Boolean overrideEditableFlag, String mediaType) throws IOException {
          // verify the required parameter 'issueIdOrKey' is set
              if (issueIdOrKey == null) {
              throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling addWorklog");
              }// verify the required parameter 'requestBody' is set
              if (requestBody == null) {
              throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling addWorklog");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("issueIdOrKey", issueIdOrKey);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/worklog");
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
              }              if (adjustEstimate != null) {
                  String key = "adjustEstimate";
                  Object value = adjustEstimate;
                  if (value instanceof Collection) {
                    uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
                  } else if (value instanceof Object[]) {
                    uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
                  } else {
                    uriBuilder = uriBuilder.queryParam(key, value);
                  }
              }              if (newEstimate != null) {
                  String key = "newEstimate";
                  Object value = newEstimate;
                  if (value instanceof Collection) {
                    uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
                  } else if (value instanceof Object[]) {
                    uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
                  } else {
                    uriBuilder = uriBuilder.queryParam(key, value);
                  }
              }              if (reduceBy != null) {
                  String key = "reduceBy";
                  Object value = reduceBy;
                  if (value instanceof Collection) {
                    uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
                  } else if (value instanceof Object[]) {
                    uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
                  } else {
                    uriBuilder = uriBuilder.queryParam(key, value);
                  }
              }              if (expand != null) {
                  String key = "expand";
                  Object value = expand;
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
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse addWorklogForHttpResponse(String issueIdOrKey, Map<String, Object> requestBody, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling addWorklog");
        }// verify the required parameter 'requestBody' is set
        if (requestBody == null) {
            throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling addWorklog");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/worklog");

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
    * Delete worklog
    * Deletes a worklog from an issue.  Time tracking must be enabled in Jira, otherwise this operation returns an error. For more information, see [Configuring time tracking](https://confluence.atlassian.com/x/qoXKM).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  *Delete all worklogs*[ project permission](https://confluence.atlassian.com/x/yodKLg) to delete any worklog or *Delete own worklogs* to delete worklogs created by the user,  *  If the worklog has visibility restrictions, belongs to the group or has the role visibility is restricted to.
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  &#x60;adjustEstimate&#x60; is set to &#x60;new&#x60; but &#x60;newEstimate&#x60; is not provided or is invalid.  *  &#x60;adjustEstimate&#x60; is set to &#x60;manual&#x60; but &#x60;reduceBy&#x60; is not provided or is invalid.  *  the user does not have permission to delete the worklog.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect.
    * <p><b>404</b> - Returned if:   *  the issue is not found or user does not have permission to view the issue.  *  the worklog is not found or the user does not have permission to view it.  *  time tracking is disabled.
    * @param issueIdOrKey The ID or key of the issue.
    * @param id The ID of the worklog.
    * @param notifyUsers Whether users watching the issue are notified by email.
    * @param adjustEstimate Defines how to update the issue&#39;s time estimate, the options are:   *  &#x60;new&#x60; Sets the estimate to a specific value, defined in &#x60;newEstimate&#x60;.  *  &#x60;leave&#x60; Leaves the estimate unchanged.  *  &#x60;manual&#x60; Increases the estimate by amount specified in &#x60;increaseBy&#x60;.  *  &#x60;auto&#x60; Reduces the estimate by the value of &#x60;timeSpent&#x60; in the worklog.
    * @param newEstimate The value to set as the issue&#39;s remaining time estimate, as days (\\#d), hours (\\#h), or minutes (\\#m or \\#). For example, *2d*. Required when &#x60;adjustEstimate&#x60; is &#x60;new&#x60;.
    * @param increaseBy The amount to increase the issue&#39;s remaining estimate by, as days (\\#d), hours (\\#h), or minutes (\\#m or \\#). For example, *2d*. Required when &#x60;adjustEstimate&#x60; is &#x60;manual&#x60;.
    * @param overrideEditableFlag Whether the work log entry should be added to the issue even if the issue is not editable, because jira.issue.editable set to false or missing. For example, the issue is closed. Only connect app users with admin permissions can use this flag.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteWorklog(String issueIdOrKey, String id, Boolean notifyUsers, String adjustEstimate, String newEstimate, String increaseBy, Boolean overrideEditableFlag) throws IOException {
        deleteWorklogForHttpResponse(issueIdOrKey, id, notifyUsers, adjustEstimate, newEstimate, increaseBy, overrideEditableFlag);
    }

  /**
    * Delete worklog
    * Deletes a worklog from an issue.  Time tracking must be enabled in Jira, otherwise this operation returns an error. For more information, see [Configuring time tracking](https://confluence.atlassian.com/x/qoXKM).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  *Delete all worklogs*[ project permission](https://confluence.atlassian.com/x/yodKLg) to delete any worklog or *Delete own worklogs* to delete worklogs created by the user,  *  If the worklog has visibility restrictions, belongs to the group or has the role visibility is restricted to.
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  &#x60;adjustEstimate&#x60; is set to &#x60;new&#x60; but &#x60;newEstimate&#x60; is not provided or is invalid.  *  &#x60;adjustEstimate&#x60; is set to &#x60;manual&#x60; but &#x60;reduceBy&#x60; is not provided or is invalid.  *  the user does not have permission to delete the worklog.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect.
    * <p><b>404</b> - Returned if:   *  the issue is not found or user does not have permission to view the issue.  *  the worklog is not found or the user does not have permission to view it.  *  time tracking is disabled.
    * @param issueIdOrKey The ID or key of the issue.
    * @param id The ID of the worklog.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteWorklog(String issueIdOrKey, String id, Map<String, Object> params) throws IOException {
        deleteWorklogForHttpResponse(issueIdOrKey, id, params);
    }

    public HttpResponse deleteWorklogForHttpResponse(String issueIdOrKey, String id, Boolean notifyUsers, String adjustEstimate, String newEstimate, String increaseBy, Boolean overrideEditableFlag) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling deleteWorklog");
        }// verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling deleteWorklog");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/worklog/{id}");
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
        }        if (adjustEstimate != null) {
            String key = "adjustEstimate";
            Object value = adjustEstimate;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (newEstimate != null) {
            String key = "newEstimate";
            Object value = newEstimate;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (increaseBy != null) {
            String key = "increaseBy";
            Object value = increaseBy;
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
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }

    public HttpResponse deleteWorklogForHttpResponse(String issueIdOrKey, String id, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling deleteWorklog");
        }// verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling deleteWorklog");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/worklog/{id}");

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
    * Get IDs of deleted worklogs
    * Returns a list of IDs and delete timestamps for worklogs deleted after a date and time.  This resource is paginated, with a limit of 1000 worklogs per page. Each page lists worklogs from oldest to youngest. If the number of items in the date range exceeds 1000, &#x60;until&#x60; indicates the timestamp of the youngest item on the page. Also, &#x60;nextPage&#x60; provides the URL for the next page of worklogs. The &#x60;lastPage&#x60; parameter is set to true on the last page of worklogs.  This resource does not return worklogs deleted during the minute preceding the request.  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param since The date and time, as a UNIX timestamp in milliseconds, after which deleted worklogs are returned.
    * @return ChangedWorklogs
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ChangedWorklogs getIdsOfWorklogsDeletedSince(Long since) throws IOException {
        HttpResponse response = getIdsOfWorklogsDeletedSinceForHttpResponse(since);
        TypeReference<ChangedWorklogs> typeRef = new TypeReference<ChangedWorklogs>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get IDs of deleted worklogs
    * Returns a list of IDs and delete timestamps for worklogs deleted after a date and time.  This resource is paginated, with a limit of 1000 worklogs per page. Each page lists worklogs from oldest to youngest. If the number of items in the date range exceeds 1000, &#x60;until&#x60; indicates the timestamp of the youngest item on the page. Also, &#x60;nextPage&#x60; provides the URL for the next page of worklogs. The &#x60;lastPage&#x60; parameter is set to true on the last page of worklogs.  This resource does not return worklogs deleted during the minute preceding the request.  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return ChangedWorklogs
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ChangedWorklogs getIdsOfWorklogsDeletedSince(Map<String, Object> params) throws IOException {
        HttpResponse response = getIdsOfWorklogsDeletedSinceForHttpResponse(params);
        TypeReference<ChangedWorklogs> typeRef = new TypeReference<ChangedWorklogs>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getIdsOfWorklogsDeletedSinceForHttpResponse(Long since) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/worklog/deleted");
        if (since != null) {
            String key = "since";
            Object value = since;
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

    public HttpResponse getIdsOfWorklogsDeletedSinceForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/worklog/deleted");

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
    * Get IDs of updated worklogs
    * Returns a list of IDs and update timestamps for worklogs updated after a date and time.  This resource is paginated, with a limit of 1000 worklogs per page. Each page lists worklogs from oldest to youngest. If the number of items in the date range exceeds 1000, &#x60;until&#x60; indicates the timestamp of the youngest item on the page. Also, &#x60;nextPage&#x60; provides the URL for the next page of worklogs. The &#x60;lastPage&#x60; parameter is set to true on the last page of worklogs.  This resource does not return worklogs updated during the minute preceding the request.  **[Permissions](#permissions) required:** Permission to access Jira, however, worklogs are only returned where either of the following is true:   *  the worklog is set as *Viewable by All Users*.  *  the user is a member of a project role or group with permission to view the worklog.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param since The date and time, as a UNIX timestamp in milliseconds, after which updated worklogs are returned.
    * @param expand Use [expand](#expansion) to include additional information about worklogs in the response. This parameter accepts &#x60;properties&#x60; that returns the properties of each worklog.
    * @return ChangedWorklogs
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ChangedWorklogs getIdsOfWorklogsModifiedSince(Long since, String expand) throws IOException {
        HttpResponse response = getIdsOfWorklogsModifiedSinceForHttpResponse(since, expand);
        TypeReference<ChangedWorklogs> typeRef = new TypeReference<ChangedWorklogs>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get IDs of updated worklogs
    * Returns a list of IDs and update timestamps for worklogs updated after a date and time.  This resource is paginated, with a limit of 1000 worklogs per page. Each page lists worklogs from oldest to youngest. If the number of items in the date range exceeds 1000, &#x60;until&#x60; indicates the timestamp of the youngest item on the page. Also, &#x60;nextPage&#x60; provides the URL for the next page of worklogs. The &#x60;lastPage&#x60; parameter is set to true on the last page of worklogs.  This resource does not return worklogs updated during the minute preceding the request.  **[Permissions](#permissions) required:** Permission to access Jira, however, worklogs are only returned where either of the following is true:   *  the worklog is set as *Viewable by All Users*.  *  the user is a member of a project role or group with permission to view the worklog.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return ChangedWorklogs
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ChangedWorklogs getIdsOfWorklogsModifiedSince(Map<String, Object> params) throws IOException {
        HttpResponse response = getIdsOfWorklogsModifiedSinceForHttpResponse(params);
        TypeReference<ChangedWorklogs> typeRef = new TypeReference<ChangedWorklogs>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getIdsOfWorklogsModifiedSinceForHttpResponse(Long since, String expand) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/worklog/updated");
        if (since != null) {
            String key = "since";
            Object value = since;
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

    public HttpResponse getIdsOfWorklogsModifiedSinceForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/worklog/updated");

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
    * Get issue worklogs
    * Returns worklogs for an issue, starting from the oldest worklog or from the worklog started on or after a date and time.  Time tracking must be enabled in Jira, otherwise this operation returns an error. For more information, see [Configuring time tracking](https://confluence.atlassian.com/x/qoXKM).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** Workloads are only returned where the user has:   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  If the worklog has visibility restrictions, belongs to the group or has the role visibility is restricted to.
    * <p><b>200</b> - Returned if the request is successful
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if:   *  the issue is not found or the user does not have permission to view the issue.  *  &#x60;startAt&#x60; or &#x60;maxResults&#x60; has non-numeric values.  *  time tracking is disabled.
    * @param issueIdOrKey The ID or key of the issue.
    * @param startAt The index of the first item to return in a page of results (page offset).
    * @param maxResults The maximum number of items to return per page.
    * @param startedAfter The worklog start date and time, as a UNIX timestamp in milliseconds, after which worklogs are returned.
    * @param expand Use [expand](#expansion) to include additional information about worklogs in the response. This parameter accepts&#x60;properties&#x60;, which returns worklog properties.
    * @return PageOfWorklogs
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageOfWorklogs getIssueWorklog(String issueIdOrKey, Long startAt, Integer maxResults, Long startedAfter, String expand) throws IOException {
        HttpResponse response = getIssueWorklogForHttpResponse(issueIdOrKey, startAt, maxResults, startedAfter, expand);
        TypeReference<PageOfWorklogs> typeRef = new TypeReference<PageOfWorklogs>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get issue worklogs
    * Returns worklogs for an issue, starting from the oldest worklog or from the worklog started on or after a date and time.  Time tracking must be enabled in Jira, otherwise this operation returns an error. For more information, see [Configuring time tracking](https://confluence.atlassian.com/x/qoXKM).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** Workloads are only returned where the user has:   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  If the worklog has visibility restrictions, belongs to the group or has the role visibility is restricted to.
    * <p><b>200</b> - Returned if the request is successful
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if:   *  the issue is not found or the user does not have permission to view the issue.  *  &#x60;startAt&#x60; or &#x60;maxResults&#x60; has non-numeric values.  *  time tracking is disabled.
    * @param issueIdOrKey The ID or key of the issue.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PageOfWorklogs
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageOfWorklogs getIssueWorklog(String issueIdOrKey, Map<String, Object> params) throws IOException {
        HttpResponse response = getIssueWorklogForHttpResponse(issueIdOrKey, params);
        TypeReference<PageOfWorklogs> typeRef = new TypeReference<PageOfWorklogs>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getIssueWorklogForHttpResponse(String issueIdOrKey, Long startAt, Integer maxResults, Long startedAfter, String expand) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling getIssueWorklog");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/worklog");
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
        }        if (startedAfter != null) {
            String key = "startedAfter";
            Object value = startedAfter;
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

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getIssueWorklogForHttpResponse(String issueIdOrKey, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling getIssueWorklog");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/worklog");

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
    * Get worklog
    * Returns a worklog.  Time tracking must be enabled in Jira, otherwise this operation returns an error. For more information, see [Configuring time tracking](https://confluence.atlassian.com/x/qoXKM).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  If the worklog has visibility restrictions, belongs to the group or has the role visibility is restricted to.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect.
    * <p><b>404</b> - Returned if:   *  the issue is not found or the user does not have permission to view it.  *  the worklog is not found or the user does not have permission to view it.  *  time tracking is disabled.  .
    * @param issueIdOrKey The ID or key of the issue.
    * @param id The ID of the worklog.
    * @param expand Use [expand](#expansion) to include additional information about work logs in the response. This parameter accepts  &#x60;properties&#x60;, which returns worklog properties.
    * @return Worklog
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Worklog getWorklog(String issueIdOrKey, String id, String expand) throws IOException {
        HttpResponse response = getWorklogForHttpResponse(issueIdOrKey, id, expand);
        TypeReference<Worklog> typeRef = new TypeReference<Worklog>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get worklog
    * Returns a worklog.  Time tracking must be enabled in Jira, otherwise this operation returns an error. For more information, see [Configuring time tracking](https://confluence.atlassian.com/x/qoXKM).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  If the worklog has visibility restrictions, belongs to the group or has the role visibility is restricted to.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect.
    * <p><b>404</b> - Returned if:   *  the issue is not found or the user does not have permission to view it.  *  the worklog is not found or the user does not have permission to view it.  *  time tracking is disabled.  .
    * @param issueIdOrKey The ID or key of the issue.
    * @param id The ID of the worklog.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Worklog
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Worklog getWorklog(String issueIdOrKey, String id, Map<String, Object> params) throws IOException {
        HttpResponse response = getWorklogForHttpResponse(issueIdOrKey, id, params);
        TypeReference<Worklog> typeRef = new TypeReference<Worklog>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getWorklogForHttpResponse(String issueIdOrKey, String id, String expand) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling getWorklog");
        }// verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling getWorklog");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/worklog/{id}");
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
        }

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getWorklogForHttpResponse(String issueIdOrKey, String id, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling getWorklog");
        }// verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling getWorklog");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/worklog/{id}");

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
    * Get worklogs
    * Returns worklog details for a list of worklog IDs.  The returned list of worklogs is limited to 1000 items.  **[Permissions](#permissions) required:** Permission to access Jira, however, worklogs are only returned where either of the following is true:   *  the worklog is set as *Viewable by All Users*.  *  the user is a member of a project role or group with permission to view the worklog.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request contains more than 1000 worklog IDs or is empty.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param worklogIdsRequestBean A JSON object containing a list of worklog IDs.
    * @param expand Use [expand](#expansion) to include additional information about worklogs in the response. This parameter accepts &#x60;properties&#x60; that returns the properties of each worklog.
    * @return List&lt;Worklog&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<Worklog> getWorklogsForIds(WorklogIdsRequestBean worklogIdsRequestBean, String expand) throws IOException {
        HttpResponse response = getWorklogsForIdsForHttpResponse(worklogIdsRequestBean, expand);
        TypeReference<List<Worklog>> typeRef = new TypeReference<List<Worklog>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get worklogs
    * Returns worklog details for a list of worklog IDs.  The returned list of worklogs is limited to 1000 items.  **[Permissions](#permissions) required:** Permission to access Jira, however, worklogs are only returned where either of the following is true:   *  the worklog is set as *Viewable by All Users*.  *  the user is a member of a project role or group with permission to view the worklog.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request contains more than 1000 worklog IDs or is empty.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param worklogIdsRequestBean A JSON object containing a list of worklog IDs.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return List&lt;Worklog&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<Worklog> getWorklogsForIds(WorklogIdsRequestBean worklogIdsRequestBean, Map<String, Object> params) throws IOException {
        HttpResponse response = getWorklogsForIdsForHttpResponse(worklogIdsRequestBean, params);
        TypeReference<List<Worklog>> typeRef = new TypeReference<List<Worklog>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getWorklogsForIdsForHttpResponse(WorklogIdsRequestBean worklogIdsRequestBean, String expand) throws IOException {
        // verify the required parameter 'worklogIdsRequestBean' is set
        if (worklogIdsRequestBean == null) {
            throw new IllegalArgumentException("Missing the required parameter 'worklogIdsRequestBean' when calling getWorklogsForIds");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/worklog/list");
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
        }

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(worklogIdsRequestBean);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse getWorklogsForIdsForHttpResponse(java.io.InputStream worklogIdsRequestBean, String expand, String mediaType) throws IOException {
          // verify the required parameter 'worklogIdsRequestBean' is set
              if (worklogIdsRequestBean == null) {
              throw new IllegalArgumentException("Missing the required parameter 'worklogIdsRequestBean' when calling getWorklogsForIds");
              }
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/worklog/list");
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
              }

              String localVarUrl = uriBuilder.build().toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = worklogIdsRequestBean == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, worklogIdsRequestBean);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse getWorklogsForIdsForHttpResponse(WorklogIdsRequestBean worklogIdsRequestBean, Map<String, Object> params) throws IOException {
        // verify the required parameter 'worklogIdsRequestBean' is set
        if (worklogIdsRequestBean == null) {
            throw new IllegalArgumentException("Missing the required parameter 'worklogIdsRequestBean' when calling getWorklogsForIds");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/worklog/list");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(worklogIdsRequestBean);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


  /**
    * Update worklog
    * Updates a worklog.  Time tracking must be enabled in Jira, otherwise this operation returns an error. For more information, see [Configuring time tracking](https://confluence.atlassian.com/x/qoXKM).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  *Edit all worklogs*[ project permission](https://confluence.atlassian.com/x/yodKLg) to update any worklog or *Edit own worklogs* to update worklogs created by the user.  *  If the worklog has visibility restrictions, belongs to the group or has the role visibility is restricted to.
    * <p><b>200</b> - Returned if the request is successful
    * <p><b>400</b> - Returned if:   *  &#x60;adjustEstimate&#x60; is set to &#x60;new&#x60; but &#x60;newEstimate&#x60; is not provided or is invalid.  *  the user does not have permission to update the worklog.  *  the request JSON is malformed.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect.
    * <p><b>404</b> - Returned if:   *  the issue is not found or user does not have permission to view the issue.  *  the worklog is not found or the user does not have permission to view it.  *  time tracking is disabled.
    * @param issueIdOrKey The ID or key the issue.
    * @param id The ID of the worklog.
    * @param requestBody The requestBody parameter
    * @param notifyUsers Whether users watching the issue are notified by email.
    * @param adjustEstimate Defines how to update the issue&#39;s time estimate, the options are:   *  &#x60;new&#x60; Sets the estimate to a specific value, defined in &#x60;newEstimate&#x60;.  *  &#x60;leave&#x60; Leaves the estimate unchanged.  *  &#x60;auto&#x60; Updates the estimate by the difference between the original and updated value of &#x60;timeSpent&#x60; or &#x60;timeSpentSeconds&#x60;.
    * @param newEstimate The value to set as the issue&#39;s remaining time estimate, as days (\\#d), hours (\\#h), or minutes (\\#m or \\#). For example, *2d*. Required when &#x60;adjustEstimate&#x60; is &#x60;new&#x60;.
    * @param expand Use [expand](#expansion) to include additional information about worklogs in the response. This parameter accepts &#x60;properties&#x60;, which returns worklog properties.
    * @param overrideEditableFlag Whether the worklog should be added to the issue even if the issue is not editable. For example, because the issue is closed. Only connect app users with admin permissions can use this flag.
    * @return Worklog
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Worklog updateWorklog(String issueIdOrKey, String id, Map<String, Object> requestBody, Boolean notifyUsers, String adjustEstimate, String newEstimate, String expand, Boolean overrideEditableFlag) throws IOException {
        HttpResponse response = updateWorklogForHttpResponse(issueIdOrKey, id, requestBody, notifyUsers, adjustEstimate, newEstimate, expand, overrideEditableFlag);
        TypeReference<Worklog> typeRef = new TypeReference<Worklog>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Update worklog
    * Updates a worklog.  Time tracking must be enabled in Jira, otherwise this operation returns an error. For more information, see [Configuring time tracking](https://confluence.atlassian.com/x/qoXKM).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  *Edit all worklogs*[ project permission](https://confluence.atlassian.com/x/yodKLg) to update any worklog or *Edit own worklogs* to update worklogs created by the user.  *  If the worklog has visibility restrictions, belongs to the group or has the role visibility is restricted to.
    * <p><b>200</b> - Returned if the request is successful
    * <p><b>400</b> - Returned if:   *  &#x60;adjustEstimate&#x60; is set to &#x60;new&#x60; but &#x60;newEstimate&#x60; is not provided or is invalid.  *  the user does not have permission to update the worklog.  *  the request JSON is malformed.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect.
    * <p><b>404</b> - Returned if:   *  the issue is not found or user does not have permission to view the issue.  *  the worklog is not found or the user does not have permission to view it.  *  time tracking is disabled.
    * @param issueIdOrKey The ID or key the issue.
    * @param id The ID of the worklog.
    * @param requestBody The requestBody parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Worklog
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Worklog updateWorklog(String issueIdOrKey, String id, Map<String, Object> requestBody, Map<String, Object> params) throws IOException {
        HttpResponse response = updateWorklogForHttpResponse(issueIdOrKey, id, requestBody, params);
        TypeReference<Worklog> typeRef = new TypeReference<Worklog>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse updateWorklogForHttpResponse(String issueIdOrKey, String id, Map<String, Object> requestBody, Boolean notifyUsers, String adjustEstimate, String newEstimate, String expand, Boolean overrideEditableFlag) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling updateWorklog");
        }// verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling updateWorklog");
        }// verify the required parameter 'requestBody' is set
        if (requestBody == null) {
            throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling updateWorklog");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/worklog/{id}");
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
        }        if (adjustEstimate != null) {
            String key = "adjustEstimate";
            Object value = adjustEstimate;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (newEstimate != null) {
            String key = "newEstimate";
            Object value = newEstimate;
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

      public HttpResponse updateWorklogForHttpResponse(String issueIdOrKey, String id, java.io.InputStream requestBody, Boolean notifyUsers, String adjustEstimate, String newEstimate, String expand, Boolean overrideEditableFlag, String mediaType) throws IOException {
          // verify the required parameter 'issueIdOrKey' is set
              if (issueIdOrKey == null) {
              throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling updateWorklog");
              }// verify the required parameter 'id' is set
              if (id == null) {
              throw new IllegalArgumentException("Missing the required parameter 'id' when calling updateWorklog");
              }// verify the required parameter 'requestBody' is set
              if (requestBody == null) {
              throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling updateWorklog");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("issueIdOrKey", issueIdOrKey);
                      uriVariables.put("id", id);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/worklog/{id}");
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
              }              if (adjustEstimate != null) {
                  String key = "adjustEstimate";
                  Object value = adjustEstimate;
                  if (value instanceof Collection) {
                    uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
                  } else if (value instanceof Object[]) {
                    uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
                  } else {
                    uriBuilder = uriBuilder.queryParam(key, value);
                  }
              }              if (newEstimate != null) {
                  String key = "newEstimate";
                  Object value = newEstimate;
                  if (value instanceof Collection) {
                    uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
                  } else if (value instanceof Object[]) {
                    uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
                  } else {
                    uriBuilder = uriBuilder.queryParam(key, value);
                  }
              }              if (expand != null) {
                  String key = "expand";
                  Object value = expand;
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

    public HttpResponse updateWorklogForHttpResponse(String issueIdOrKey, String id, Map<String, Object> requestBody, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling updateWorklog");
        }// verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling updateWorklog");
        }// verify the required parameter 'requestBody' is set
        if (requestBody == null) {
            throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling updateWorklog");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/worklog/{id}");

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


}
