package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.Watchers;

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
public class IssueWatchersApi {
    private ApiClient apiClient;

    public IssueWatchersApi() {
        this(new ApiClient());
    }

    public IssueWatchersApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Add watcher
    * Adds a user as a watcher of an issue by passing the account ID of the user. For example, &#x60;\&quot;5b10ac8d82e05b22cc7d4ef5\&quot;&#x60;. If no user is specified the calling user is added.  This operation requires the **Allow users to watch issues** option to be *ON*. This option is set in General configuration for Jira. See [Configuring Jira application options](https://confluence.atlassian.com/x/uYXKM) for details.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  To add users other than themselves to the watchlist, *Manage watcher list* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the permission to manage the watcher list.
    * <p><b>404</b> - Returned if the issue or the user is not found or the user does not have permission to view the issue.
    * @param issueIdOrKey The ID or key of the issue.
    * @param body The account ID of the user. Note that username cannot be used due to privacy changes.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object addWatcher(String issueIdOrKey, String body) throws IOException {
        HttpResponse response = addWatcherForHttpResponse(issueIdOrKey, body);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Add watcher
    * Adds a user as a watcher of an issue by passing the account ID of the user. For example, &#x60;\&quot;5b10ac8d82e05b22cc7d4ef5\&quot;&#x60;. If no user is specified the calling user is added.  This operation requires the **Allow users to watch issues** option to be *ON*. This option is set in General configuration for Jira. See [Configuring Jira application options](https://confluence.atlassian.com/x/uYXKM) for details.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  To add users other than themselves to the watchlist, *Manage watcher list* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the permission to manage the watcher list.
    * <p><b>404</b> - Returned if the issue or the user is not found or the user does not have permission to view the issue.
    * @param issueIdOrKey The ID or key of the issue.
    * @param body The account ID of the user. Note that username cannot be used due to privacy changes.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object addWatcher(String issueIdOrKey, String body, Map<String, Object> params) throws IOException {
        HttpResponse response = addWatcherForHttpResponse(issueIdOrKey, body, params);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse addWatcherForHttpResponse(String issueIdOrKey, String body) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling addWatcher");
        }// verify the required parameter 'body' is set
        if (body == null) {
            throw new IllegalArgumentException("Missing the required parameter 'body' when calling addWatcher");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/watchers");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(body);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse addWatcherForHttpResponse(String issueIdOrKey, java.io.InputStream body, String mediaType) throws IOException {
          // verify the required parameter 'issueIdOrKey' is set
              if (issueIdOrKey == null) {
              throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling addWatcher");
              }// verify the required parameter 'body' is set
              if (body == null) {
              throw new IllegalArgumentException("Missing the required parameter 'body' when calling addWatcher");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("issueIdOrKey", issueIdOrKey);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/watchers");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = body == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, body);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse addWatcherForHttpResponse(String issueIdOrKey, String body, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling addWatcher");
        }// verify the required parameter 'body' is set
        if (body == null) {
            throw new IllegalArgumentException("Missing the required parameter 'body' when calling addWatcher");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/watchers");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(body);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


  /**
    * Get issue watchers
    * Returns the watchers for an issue.  This operation requires the **Allow users to watch issues** option to be *ON*. This option is set in General configuration for Jira. See [Configuring Jira application options](https://confluence.atlassian.com/x/uYXKM) for details.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is ini  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  To see details of users on the watchlist other than themselves, *View voters and watchers* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.
    * <p><b>200</b> - Returned if the request is successful
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the issue is not found or the user does not have permission to view it.
    * @param issueIdOrKey The ID or key of the issue.
    * @return Watchers
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Watchers getIssueWatchers(String issueIdOrKey) throws IOException {
        HttpResponse response = getIssueWatchersForHttpResponse(issueIdOrKey);
        TypeReference<Watchers> typeRef = new TypeReference<Watchers>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get issue watchers
    * Returns the watchers for an issue.  This operation requires the **Allow users to watch issues** option to be *ON*. This option is set in General configuration for Jira. See [Configuring Jira application options](https://confluence.atlassian.com/x/uYXKM) for details.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is ini  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  To see details of users on the watchlist other than themselves, *View voters and watchers* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.
    * <p><b>200</b> - Returned if the request is successful
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the issue is not found or the user does not have permission to view it.
    * @param issueIdOrKey The ID or key of the issue.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Watchers
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Watchers getIssueWatchers(String issueIdOrKey, Map<String, Object> params) throws IOException {
        HttpResponse response = getIssueWatchersForHttpResponse(issueIdOrKey, params);
        TypeReference<Watchers> typeRef = new TypeReference<Watchers>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getIssueWatchersForHttpResponse(String issueIdOrKey) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling getIssueWatchers");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/watchers");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getIssueWatchersForHttpResponse(String issueIdOrKey, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling getIssueWatchers");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/watchers");

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
    * Delete watcher
    * Deletes a user as a watcher of an issue.  This operation requires the **Allow users to watch issues** option to be *ON*. This option is set in General configuration for Jira. See [Configuring Jira application options](https://confluence.atlassian.com/x/uYXKM) for details.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  To remove users other than themselves from the watchlist, *Manage watcher list* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if &#x60;accountId&#x60; is not supplied.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the permission to manage the watcher list.
    * <p><b>404</b> - Returned if the issue or the user is not found or the user does not have permission to view the issue.
    * @param issueIdOrKey The ID or key of the issue.
    * @param username This parameter is no longer available and will be removed from the documentation soon. See the [deprecation notice](https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/) for details.
    * @param accountId The account ID of the user, which uniquely identifies the user across all Atlassian products. For example, *5b10ac8d82e05b22cc7d4ef5*. Required.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void removeWatcher(String issueIdOrKey, String username, String accountId) throws IOException {
        removeWatcherForHttpResponse(issueIdOrKey, username, accountId);
    }

  /**
    * Delete watcher
    * Deletes a user as a watcher of an issue.  This operation requires the **Allow users to watch issues** option to be *ON*. This option is set in General configuration for Jira. See [Configuring Jira application options](https://confluence.atlassian.com/x/uYXKM) for details.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  To remove users other than themselves from the watchlist, *Manage watcher list* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if &#x60;accountId&#x60; is not supplied.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the permission to manage the watcher list.
    * <p><b>404</b> - Returned if the issue or the user is not found or the user does not have permission to view the issue.
    * @param issueIdOrKey The ID or key of the issue.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void removeWatcher(String issueIdOrKey, Map<String, Object> params) throws IOException {
        removeWatcherForHttpResponse(issueIdOrKey, params);
    }

    public HttpResponse removeWatcherForHttpResponse(String issueIdOrKey, String username, String accountId) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling removeWatcher");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/watchers");
        if (username != null) {
            String key = "username";
            Object value = username;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (accountId != null) {
            String key = "accountId";
            Object value = accountId;
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

    public HttpResponse removeWatcherForHttpResponse(String issueIdOrKey, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling removeWatcher");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/watchers");

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


}
