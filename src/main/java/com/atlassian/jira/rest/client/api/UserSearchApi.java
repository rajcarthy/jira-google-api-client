package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.FoundUsers;
import com.atlassian.jira.rest.client.model.PageBeanUser;
import com.atlassian.jira.rest.client.model.PageBeanUserKey;
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
public class UserSearchApi {
    private ApiClient apiClient;

    public UserSearchApi() {
        this(new ApiClient());
    }

    public UserSearchApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Find users assignable to issues
    * Returns a list of users that can be assigned to an issue. Use this operation to find the list of users who can be assigned to:   *  a new issue, by providing the &#x60;projectKeyOrId&#x60;.  *  an updated issue, by providing the &#x60;issueKey&#x60;.  *  to an issue during a transition (workflow action), by providing the &#x60;issueKey&#x60; and the transition id in &#x60;actionDescriptorId&#x60;. You can obtain the IDs of an issue&#39;s valid transitions using the &#x60;transitions&#x60; option in the &#x60;expand&#x60; parameter of [ Get issue](#api-rest-api-3-issue-issueIdOrKey-get).  In all these cases, you can pass an account ID to determine if a user can be assigned to an issue. The user is returned in the response if they can be assigned to the issue or issue transition.  This operation takes the users in the range defined by &#x60;startAt&#x60; and &#x60;maxResults&#x60;, up to the thousandth user, and then returns only the users from that range that can be assigned the issue. This means the operation usually returns fewer users than specified in &#x60;maxResults&#x60;. To get all the users who can be assigned the issue, use [Get all users](#api-rest-api-3-users-search-get) and filter the records in your code.  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  &#x60;issueKey&#x60; or &#x60;project&#x60; is missing.  *  &#x60;query&#x60; or &#x60;accountId&#x60; is missing.  *  &#x60;query&#x60; and &#x60;accountId&#x60; are provided.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the project, issue, or transition is not found.
    * @param query A query string that is matched against user attributes, such as &#x60;displayName&#x60;, and &#x60;emailAddress&#x60;, to find relevant users. The string can match the prefix of the attribute&#39;s value. For example, *query&#x3D;john* matches a user with a &#x60;displayName&#x60; of *John Smith* and a user with an &#x60;emailAddress&#x60; of *johnson@example.com*. Required, unless &#x60;username&#x60; or &#x60;accountId&#x60; is specified.
    * @param sessionId The sessionId of this request. SessionId is the same until the assignee is set.
    * @param username This parameter is no longer available and will be removed from the documentation soon. See the [deprecation notice](https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/) for details.
    * @param accountId A query string that is matched exactly against user &#x60;accountId&#x60;. Required, unless &#x60;query&#x60; is specified.
    * @param project The project ID or project key (case sensitive). Required, unless &#x60;issueKey&#x60; is specified.
    * @param issueKey The key of the issue. Required, unless &#x60;project&#x60; is specified.
    * @param startAt The index of the first item to return in a page of results (page offset).
    * @param maxResults The maximum number of items to return. This operation may return less than the maximum number of items even if more are available. The operation fetches users up to the maximum and then, from the fetched users, returns only the users that can be assigned to the issue.
    * @param actionDescriptorId The ID of the transition.
    * @param recommend The recommend parameter
    * @return List&lt;User&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<User> findAssignableUsers(String query, String sessionId, String username, String accountId, String project, String issueKey, Integer startAt, Integer maxResults, Integer actionDescriptorId, Boolean recommend) throws IOException {
        HttpResponse response = findAssignableUsersForHttpResponse(query, sessionId, username, accountId, project, issueKey, startAt, maxResults, actionDescriptorId, recommend);
        TypeReference<List<User>> typeRef = new TypeReference<List<User>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Find users assignable to issues
    * Returns a list of users that can be assigned to an issue. Use this operation to find the list of users who can be assigned to:   *  a new issue, by providing the &#x60;projectKeyOrId&#x60;.  *  an updated issue, by providing the &#x60;issueKey&#x60;.  *  to an issue during a transition (workflow action), by providing the &#x60;issueKey&#x60; and the transition id in &#x60;actionDescriptorId&#x60;. You can obtain the IDs of an issue&#39;s valid transitions using the &#x60;transitions&#x60; option in the &#x60;expand&#x60; parameter of [ Get issue](#api-rest-api-3-issue-issueIdOrKey-get).  In all these cases, you can pass an account ID to determine if a user can be assigned to an issue. The user is returned in the response if they can be assigned to the issue or issue transition.  This operation takes the users in the range defined by &#x60;startAt&#x60; and &#x60;maxResults&#x60;, up to the thousandth user, and then returns only the users from that range that can be assigned the issue. This means the operation usually returns fewer users than specified in &#x60;maxResults&#x60;. To get all the users who can be assigned the issue, use [Get all users](#api-rest-api-3-users-search-get) and filter the records in your code.  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  &#x60;issueKey&#x60; or &#x60;project&#x60; is missing.  *  &#x60;query&#x60; or &#x60;accountId&#x60; is missing.  *  &#x60;query&#x60; and &#x60;accountId&#x60; are provided.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the project, issue, or transition is not found.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return List&lt;User&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<User> findAssignableUsers(Map<String, Object> params) throws IOException {
        HttpResponse response = findAssignableUsersForHttpResponse(params);
        TypeReference<List<User>> typeRef = new TypeReference<List<User>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse findAssignableUsersForHttpResponse(String query, String sessionId, String username, String accountId, String project, String issueKey, Integer startAt, Integer maxResults, Integer actionDescriptorId, Boolean recommend) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/user/assignable/search");
        if (query != null) {
            String key = "query";
            Object value = query;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (sessionId != null) {
            String key = "sessionId";
            Object value = sessionId;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (username != null) {
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
        }        if (project != null) {
            String key = "project";
            Object value = project;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (issueKey != null) {
            String key = "issueKey";
            Object value = issueKey;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (startAt != null) {
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
        }        if (actionDescriptorId != null) {
            String key = "actionDescriptorId";
            Object value = actionDescriptorId;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (recommend != null) {
            String key = "recommend";
            Object value = recommend;
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

    public HttpResponse findAssignableUsersForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/user/assignable/search");

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
    * Find users assignable to projects
    * Returns a list of users who can be assigned issues in one or more projects. The list may be restricted to users whose attributes match a string.  This operation takes the users in the range defined by &#x60;startAt&#x60; and &#x60;maxResults&#x60;, up to the thousandth user, and then returns only the users from that range that can be assigned issues in the projects. This means the operation usually returns fewer users than specified in &#x60;maxResults&#x60;. To get all the users who can be assigned issues in the projects, use [Get all users](#api-rest-api-3-users-search-get) and filter the records in your code.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  &#x60;projectKeys&#x60; is missing.  *  &#x60;query&#x60; or &#x60;accountId&#x60; is missing.  *  &#x60;query&#x60; and &#x60;accountId&#x60; are provided.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if one or more of the projects is not found.
    * @param projectKeys A list of project keys (case sensitive). This parameter accepts a comma-separated list.
    * @param query A query string that is matched against user attributes, such as &#x60;displayName&#x60; and &#x60;emailAddress&#x60;, to find relevant users. The string can match the prefix of the attribute&#39;s value. For example, *query&#x3D;john* matches a user with a &#x60;displayName&#x60; of *John Smith* and a user with an &#x60;emailAddress&#x60; of *johnson@example.com*. Required, unless &#x60;accountId&#x60; is specified.
    * @param username This parameter is no longer available and will be removed from the documentation soon. See the [deprecation notice](https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/) for details.
    * @param accountId A query string that is matched exactly against user &#x60;accountId&#x60;. Required, unless &#x60;query&#x60; is specified.
    * @param startAt The index of the first item to return in a page of results (page offset).
    * @param maxResults The maximum number of items to return per page.
    * @return List&lt;User&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<User> findBulkAssignableUsers(String projectKeys, String query, String username, String accountId, Integer startAt, Integer maxResults) throws IOException {
        HttpResponse response = findBulkAssignableUsersForHttpResponse(projectKeys, query, username, accountId, startAt, maxResults);
        TypeReference<List<User>> typeRef = new TypeReference<List<User>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Find users assignable to projects
    * Returns a list of users who can be assigned issues in one or more projects. The list may be restricted to users whose attributes match a string.  This operation takes the users in the range defined by &#x60;startAt&#x60; and &#x60;maxResults&#x60;, up to the thousandth user, and then returns only the users from that range that can be assigned issues in the projects. This means the operation usually returns fewer users than specified in &#x60;maxResults&#x60;. To get all the users who can be assigned issues in the projects, use [Get all users](#api-rest-api-3-users-search-get) and filter the records in your code.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  &#x60;projectKeys&#x60; is missing.  *  &#x60;query&#x60; or &#x60;accountId&#x60; is missing.  *  &#x60;query&#x60; and &#x60;accountId&#x60; are provided.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if one or more of the projects is not found.
    * @param projectKeys A list of project keys (case sensitive). This parameter accepts a comma-separated list.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return List&lt;User&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<User> findBulkAssignableUsers(String projectKeys, Map<String, Object> params) throws IOException {
        HttpResponse response = findBulkAssignableUsersForHttpResponse(projectKeys, params);
        TypeReference<List<User>> typeRef = new TypeReference<List<User>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse findBulkAssignableUsersForHttpResponse(String projectKeys, String query, String username, String accountId, Integer startAt, Integer maxResults) throws IOException {
        // verify the required parameter 'projectKeys' is set
        if (projectKeys == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectKeys' when calling findBulkAssignableUsers");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/user/assignable/multiProjectSearch");
        if (query != null) {
            String key = "query";
            Object value = query;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (username != null) {
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
        }        if (startAt != null) {
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

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse findBulkAssignableUsersForHttpResponse(String projectKeys, Map<String, Object> params) throws IOException {
        // verify the required parameter 'projectKeys' is set
        if (projectKeys == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectKeys' when calling findBulkAssignableUsers");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/user/assignable/multiProjectSearch");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);
        // Add the required query param 'projectKeys' to the map of query params
        allParams.put("projectKeys", projectKeys);

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
    * Find user keys by query
    * Finds users with a structured query and returns a [paginated](#pagination) list of user keys.  This operation takes the users in the range defined by &#x60;startAt&#x60; and &#x60;maxResults&#x60;, up to the thousandth user, and then returns only the users from that range that match the structured query. This means the operation usually returns fewer users than specified in &#x60;maxResults&#x60;. To get all the users who match the structured query, use [Get all users](#api-rest-api-3-users-search-get) and filter the records in your code.  **[Permissions](#permissions) required:** *Browse users and groups* [global permission](https://confluence.atlassian.com/x/x4dKLg).  The query statements are:   *  &#x60;is assignee of PROJ&#x60; Returns the users that are assignees of at least one issue in project *PROJ*.  *  &#x60;is assignee of (PROJ-1, PROJ-2)&#x60; Returns users that are assignees on the issues *PROJ-1* or *PROJ-2*.  *  &#x60;is reporter of (PROJ-1, PROJ-2)&#x60; Returns users that are reporters on the issues *PROJ-1* or *PROJ-2*.  *  &#x60;is watcher of (PROJ-1, PROJ-2)&#x60; Returns users that are watchers on the issues *PROJ-1* or *PROJ-2*.  *  &#x60;is voter of (PROJ-1, PROJ-2)&#x60; Returns users that are voters on the issues *PROJ-1* or *PROJ-2*.  *  &#x60;is commenter of (PROJ-1, PROJ-2)&#x60; Returns users that have posted a comment on the issues *PROJ-1* or *PROJ-2*.  *  &#x60;is transitioner of (PROJ-1, PROJ-2)&#x60; Returns users that have performed a transition on issues *PROJ-1* or *PROJ-2*.  *  &#x60;[propertyKey].entity.property.path is \&quot;property value\&quot;&#x60; Returns users with the entity property value.  The list of issues can be extended as needed, as in *(PROJ-1, PROJ-2, ... PROJ-n)*. Statements can be combined using the &#x60;AND&#x60; and &#x60;OR&#x60; operators to form more complex queries. For example:  &#x60;is assignee of PROJ AND [propertyKey].entity.property.path is \&quot;property value\&quot;&#x60;
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the query is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>408</b> - Returned if the search is timed out.
    * @param query The search query.
    * @param startAt The index of the first item to return in a page of results (page offset).
    * @param maxResults The maximum number of items to return per page.
    * @return PageBeanUserKey
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanUserKey findUserKeysByQuery(String query, Long startAt, Integer maxResults) throws IOException {
        HttpResponse response = findUserKeysByQueryForHttpResponse(query, startAt, maxResults);
        TypeReference<PageBeanUserKey> typeRef = new TypeReference<PageBeanUserKey>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Find user keys by query
    * Finds users with a structured query and returns a [paginated](#pagination) list of user keys.  This operation takes the users in the range defined by &#x60;startAt&#x60; and &#x60;maxResults&#x60;, up to the thousandth user, and then returns only the users from that range that match the structured query. This means the operation usually returns fewer users than specified in &#x60;maxResults&#x60;. To get all the users who match the structured query, use [Get all users](#api-rest-api-3-users-search-get) and filter the records in your code.  **[Permissions](#permissions) required:** *Browse users and groups* [global permission](https://confluence.atlassian.com/x/x4dKLg).  The query statements are:   *  &#x60;is assignee of PROJ&#x60; Returns the users that are assignees of at least one issue in project *PROJ*.  *  &#x60;is assignee of (PROJ-1, PROJ-2)&#x60; Returns users that are assignees on the issues *PROJ-1* or *PROJ-2*.  *  &#x60;is reporter of (PROJ-1, PROJ-2)&#x60; Returns users that are reporters on the issues *PROJ-1* or *PROJ-2*.  *  &#x60;is watcher of (PROJ-1, PROJ-2)&#x60; Returns users that are watchers on the issues *PROJ-1* or *PROJ-2*.  *  &#x60;is voter of (PROJ-1, PROJ-2)&#x60; Returns users that are voters on the issues *PROJ-1* or *PROJ-2*.  *  &#x60;is commenter of (PROJ-1, PROJ-2)&#x60; Returns users that have posted a comment on the issues *PROJ-1* or *PROJ-2*.  *  &#x60;is transitioner of (PROJ-1, PROJ-2)&#x60; Returns users that have performed a transition on issues *PROJ-1* or *PROJ-2*.  *  &#x60;[propertyKey].entity.property.path is \&quot;property value\&quot;&#x60; Returns users with the entity property value.  The list of issues can be extended as needed, as in *(PROJ-1, PROJ-2, ... PROJ-n)*. Statements can be combined using the &#x60;AND&#x60; and &#x60;OR&#x60; operators to form more complex queries. For example:  &#x60;is assignee of PROJ AND [propertyKey].entity.property.path is \&quot;property value\&quot;&#x60;
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the query is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>408</b> - Returned if the search is timed out.
    * @param query The search query.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PageBeanUserKey
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanUserKey findUserKeysByQuery(String query, Map<String, Object> params) throws IOException {
        HttpResponse response = findUserKeysByQueryForHttpResponse(query, params);
        TypeReference<PageBeanUserKey> typeRef = new TypeReference<PageBeanUserKey>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse findUserKeysByQueryForHttpResponse(String query, Long startAt, Integer maxResults) throws IOException {
        // verify the required parameter 'query' is set
        if (query == null) {
            throw new IllegalArgumentException("Missing the required parameter 'query' when calling findUserKeysByQuery");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/user/search/query/key");
        if (query != null) {
            String key = "query";
            Object value = query;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (startAt != null) {
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

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse findUserKeysByQueryForHttpResponse(String query, Map<String, Object> params) throws IOException {
        // verify the required parameter 'query' is set
        if (query == null) {
            throw new IllegalArgumentException("Missing the required parameter 'query' when calling findUserKeysByQuery");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/user/search/query/key");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);
        // Add the required query param 'query' to the map of query params
        allParams.put("query", query);

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
    * Find users
    * Returns a list of users that match the search string and property.  This operation takes the users in the range defined by &#x60;startAt&#x60; and &#x60;maxResults&#x60;, up to the thousandth user, and then returns only the users from that range that match the search string and property. This means the operation usually returns fewer users than specified in &#x60;maxResults&#x60;. To get all the users who match the search string and property, use [Get all users](#api-rest-api-3-users-search-get) and filter the records in your code.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Browse users and groups* [global permission](https://confluence.atlassian.com/x/x4dKLg). Anonymous calls or calls by users without the required permission return empty search results.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  &#x60;accountId&#x60;, &#x60;query&#x60; or &#x60;property&#x60; is missing.  *  &#x60;query&#x60; and &#x60;accountId&#x60; are provided.  *  &#x60;property&#x60; parameter is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param query A query string that is matched against user attributes ( &#x60;displayName&#x60;, and &#x60;emailAddress&#x60;) to find relevant users. The string can match the prefix of the attribute&#39;s value. For example, *query&#x3D;john* matches a user with a &#x60;displayName&#x60; of *John Smith* and a user with an &#x60;emailAddress&#x60; of *johnson@example.com*. Required, unless &#x60;accountId&#x60; or &#x60;property&#x60; is specified.
    * @param username The username parameter
    * @param accountId A query string that is matched exactly against a user &#x60;accountId&#x60;. Required, unless &#x60;query&#x60; or &#x60;property&#x60; is specified.
    * @param startAt The index of the first item to return in a page of results (page offset).
    * @param maxResults The maximum number of items to return per page.
    * @param property A query string used to search properties. Property keys are specified by path, so property keys containing dot (.) or equals (&#x3D;) characters cannot be used. The query string cannot be specified using a JSON object. Example: To search for the value of &#x60;nested&#x60; from &#x60;{\&quot;something\&quot;:{\&quot;nested\&quot;:1,\&quot;other\&quot;:2}}&#x60; use &#x60;thepropertykey.something.nested&#x3D;1&#x60;. Required, unless &#x60;accountId&#x60; or &#x60;query&#x60; is specified.
    * @return List&lt;User&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<User> findUsers(String query, String username, String accountId, Integer startAt, Integer maxResults, String property) throws IOException {
        HttpResponse response = findUsersForHttpResponse(query, username, accountId, startAt, maxResults, property);
        TypeReference<List<User>> typeRef = new TypeReference<List<User>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Find users
    * Returns a list of users that match the search string and property.  This operation takes the users in the range defined by &#x60;startAt&#x60; and &#x60;maxResults&#x60;, up to the thousandth user, and then returns only the users from that range that match the search string and property. This means the operation usually returns fewer users than specified in &#x60;maxResults&#x60;. To get all the users who match the search string and property, use [Get all users](#api-rest-api-3-users-search-get) and filter the records in your code.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Browse users and groups* [global permission](https://confluence.atlassian.com/x/x4dKLg). Anonymous calls or calls by users without the required permission return empty search results.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  &#x60;accountId&#x60;, &#x60;query&#x60; or &#x60;property&#x60; is missing.  *  &#x60;query&#x60; and &#x60;accountId&#x60; are provided.  *  &#x60;property&#x60; parameter is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return List&lt;User&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<User> findUsers(Map<String, Object> params) throws IOException {
        HttpResponse response = findUsersForHttpResponse(params);
        TypeReference<List<User>> typeRef = new TypeReference<List<User>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse findUsersForHttpResponse(String query, String username, String accountId, Integer startAt, Integer maxResults, String property) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/user/search");
        if (query != null) {
            String key = "query";
            Object value = query;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (username != null) {
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
        }        if (startAt != null) {
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
        }        if (property != null) {
            String key = "property";
            Object value = property;
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

    public HttpResponse findUsersForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/user/search");

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
    * Find users by query
    * Finds users with a structured query and returns a [paginated](#pagination) list of user details.  This operation takes the users in the range defined by &#x60;startAt&#x60; and &#x60;maxResults&#x60;, up to the thousandth user, and then returns only the users from that range that match the structured query. This means the operation usually returns fewer users than specified in &#x60;maxResults&#x60;. To get all the users who match the structured query, use [Get all users](#api-rest-api-3-users-search-get) and filter the records in your code.  **[Permissions](#permissions) required:** *Browse users and groups* [global permission](https://confluence.atlassian.com/x/x4dKLg).  The query statements are:   *  &#x60;is assignee of PROJ&#x60; Returns the users that are assignees of at least one issue in project *PROJ*.  *  &#x60;is assignee of (PROJ-1, PROJ-2)&#x60; Returns users that are assignees on the issues *PROJ-1* or *PROJ-2*.  *  &#x60;is reporter of (PROJ-1, PROJ-2)&#x60; Returns users that are reporters on the issues *PROJ-1* or *PROJ-2*.  *  &#x60;is watcher of (PROJ-1, PROJ-2)&#x60; Returns users that are watchers on the issues *PROJ-1* or *PROJ-2*.  *  &#x60;is voter of (PROJ-1, PROJ-2)&#x60; Returns users that are voters on the issues *PROJ-1* or *PROJ-2*.  *  &#x60;is commenter of (PROJ-1, PROJ-2)&#x60; Returns users that have posted a comment on the issues *PROJ-1* or *PROJ-2*.  *  &#x60;is transitioner of (PROJ-1, PROJ-2)&#x60; Returns users that have performed a transition on issues *PROJ-1* or *PROJ-2*.  *  &#x60;[propertyKey].entity.property.path is \&quot;property value\&quot;&#x60; Returns users with the entity property value.  The list of issues can be extended as needed, as in *(PROJ-1, PROJ-2, ... PROJ-n)*. Statements can be combined using the &#x60;AND&#x60; and &#x60;OR&#x60; operators to form more complex queries. For example:  &#x60;is assignee of PROJ AND [propertyKey].entity.property.path is \&quot;property value\&quot;&#x60;
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the query is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>408</b> - Returned if the search is timed out.
    * @param query The search query.
    * @param startAt The index of the first item to return in a page of results (page offset).
    * @param maxResults The maximum number of items to return per page.
    * @return PageBeanUser
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanUser findUsersByQuery(String query, Long startAt, Integer maxResults) throws IOException {
        HttpResponse response = findUsersByQueryForHttpResponse(query, startAt, maxResults);
        TypeReference<PageBeanUser> typeRef = new TypeReference<PageBeanUser>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Find users by query
    * Finds users with a structured query and returns a [paginated](#pagination) list of user details.  This operation takes the users in the range defined by &#x60;startAt&#x60; and &#x60;maxResults&#x60;, up to the thousandth user, and then returns only the users from that range that match the structured query. This means the operation usually returns fewer users than specified in &#x60;maxResults&#x60;. To get all the users who match the structured query, use [Get all users](#api-rest-api-3-users-search-get) and filter the records in your code.  **[Permissions](#permissions) required:** *Browse users and groups* [global permission](https://confluence.atlassian.com/x/x4dKLg).  The query statements are:   *  &#x60;is assignee of PROJ&#x60; Returns the users that are assignees of at least one issue in project *PROJ*.  *  &#x60;is assignee of (PROJ-1, PROJ-2)&#x60; Returns users that are assignees on the issues *PROJ-1* or *PROJ-2*.  *  &#x60;is reporter of (PROJ-1, PROJ-2)&#x60; Returns users that are reporters on the issues *PROJ-1* or *PROJ-2*.  *  &#x60;is watcher of (PROJ-1, PROJ-2)&#x60; Returns users that are watchers on the issues *PROJ-1* or *PROJ-2*.  *  &#x60;is voter of (PROJ-1, PROJ-2)&#x60; Returns users that are voters on the issues *PROJ-1* or *PROJ-2*.  *  &#x60;is commenter of (PROJ-1, PROJ-2)&#x60; Returns users that have posted a comment on the issues *PROJ-1* or *PROJ-2*.  *  &#x60;is transitioner of (PROJ-1, PROJ-2)&#x60; Returns users that have performed a transition on issues *PROJ-1* or *PROJ-2*.  *  &#x60;[propertyKey].entity.property.path is \&quot;property value\&quot;&#x60; Returns users with the entity property value.  The list of issues can be extended as needed, as in *(PROJ-1, PROJ-2, ... PROJ-n)*. Statements can be combined using the &#x60;AND&#x60; and &#x60;OR&#x60; operators to form more complex queries. For example:  &#x60;is assignee of PROJ AND [propertyKey].entity.property.path is \&quot;property value\&quot;&#x60;
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the query is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>408</b> - Returned if the search is timed out.
    * @param query The search query.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PageBeanUser
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanUser findUsersByQuery(String query, Map<String, Object> params) throws IOException {
        HttpResponse response = findUsersByQueryForHttpResponse(query, params);
        TypeReference<PageBeanUser> typeRef = new TypeReference<PageBeanUser>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse findUsersByQueryForHttpResponse(String query, Long startAt, Integer maxResults) throws IOException {
        // verify the required parameter 'query' is set
        if (query == null) {
            throw new IllegalArgumentException("Missing the required parameter 'query' when calling findUsersByQuery");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/user/search/query");
        if (query != null) {
            String key = "query";
            Object value = query;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (startAt != null) {
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

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse findUsersByQueryForHttpResponse(String query, Map<String, Object> params) throws IOException {
        // verify the required parameter 'query' is set
        if (query == null) {
            throw new IllegalArgumentException("Missing the required parameter 'query' when calling findUsersByQuery");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/user/search/query");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);
        // Add the required query param 'query' to the map of query params
        allParams.put("query", query);

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
    * Find users for picker
    * Returns a list of users whose attributes match the query term. The returned object includes the &#x60;html&#x60; field where the matched query term is highlighted with the HTML strong tag. A list of account IDs can be provided to exclude users from the results.  This operation takes the users in the range defined by &#x60;maxResults&#x60;, up to the thousandth user, and then returns only the users from that range that match the query term. This means the operation usually returns fewer users than specified in &#x60;maxResults&#x60;. To get all the users who match the query term, use [Get all users](#api-rest-api-3-users-search-get) and filter the records in your code.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Browse users and groups* [global permission](https://confluence.atlassian.com/x/x4dKLg). Anonymous calls and calls by users without the required permission return search results for an exact name match only.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if &#x60;exclude&#x60; and &#x60;excludeAccountIds&#x60; are provided.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param query A query string that is matched against user attributes, such as &#x60;displayName&#x60;, and &#x60;emailAddress&#x60;, to find relevant users. The string can match the prefix of the attribute&#39;s value. For example, *query&#x3D;john* matches a user with a &#x60;displayName&#x60; of *John Smith* and a user with an &#x60;emailAddress&#x60; of *johnson@example.com*.
    * @param maxResults The maximum number of items to return. The total number of matched users is returned in &#x60;total&#x60;.
    * @param showAvatar Include the URI to the user&#39;s avatar.
    * @param exclude This parameter is no longer available and will be removed from the documentation soon. See the [deprecation notice](https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/) for details.
    * @param excludeAccountIds A list of account IDs to exclude from the search results. This parameter accepts a comma-separated list. Multiple account IDs can also be provided using an ampersand-separated list. For example, &#x60;excludeAccountIds&#x3D;5b10a2844c20165700ede21g,5b10a0effa615349cb016cd8&amp;excludeAccountIds&#x3D;5b10ac8d82e05b22cc7d4ef5&#x60;. Cannot be provided with &#x60;exclude&#x60;.
    * @param avatarSize The avatarSize parameter
    * @param excludeConnectUsers The excludeConnectUsers parameter
    * @return FoundUsers
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public FoundUsers findUsersForPicker(String query, Integer maxResults, Boolean showAvatar, List<String> exclude, List<String> excludeAccountIds, String avatarSize, Boolean excludeConnectUsers) throws IOException {
        HttpResponse response = findUsersForPickerForHttpResponse(query, maxResults, showAvatar, exclude, excludeAccountIds, avatarSize, excludeConnectUsers);
        TypeReference<FoundUsers> typeRef = new TypeReference<FoundUsers>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Find users for picker
    * Returns a list of users whose attributes match the query term. The returned object includes the &#x60;html&#x60; field where the matched query term is highlighted with the HTML strong tag. A list of account IDs can be provided to exclude users from the results.  This operation takes the users in the range defined by &#x60;maxResults&#x60;, up to the thousandth user, and then returns only the users from that range that match the query term. This means the operation usually returns fewer users than specified in &#x60;maxResults&#x60;. To get all the users who match the query term, use [Get all users](#api-rest-api-3-users-search-get) and filter the records in your code.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Browse users and groups* [global permission](https://confluence.atlassian.com/x/x4dKLg). Anonymous calls and calls by users without the required permission return search results for an exact name match only.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if &#x60;exclude&#x60; and &#x60;excludeAccountIds&#x60; are provided.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param query A query string that is matched against user attributes, such as &#x60;displayName&#x60;, and &#x60;emailAddress&#x60;, to find relevant users. The string can match the prefix of the attribute&#39;s value. For example, *query&#x3D;john* matches a user with a &#x60;displayName&#x60; of *John Smith* and a user with an &#x60;emailAddress&#x60; of *johnson@example.com*.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return FoundUsers
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public FoundUsers findUsersForPicker(String query, Map<String, Object> params) throws IOException {
        HttpResponse response = findUsersForPickerForHttpResponse(query, params);
        TypeReference<FoundUsers> typeRef = new TypeReference<FoundUsers>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse findUsersForPickerForHttpResponse(String query, Integer maxResults, Boolean showAvatar, List<String> exclude, List<String> excludeAccountIds, String avatarSize, Boolean excludeConnectUsers) throws IOException {
        // verify the required parameter 'query' is set
        if (query == null) {
            throw new IllegalArgumentException("Missing the required parameter 'query' when calling findUsersForPicker");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/user/picker");
        if (query != null) {
            String key = "query";
            Object value = query;
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
        }        if (showAvatar != null) {
            String key = "showAvatar";
            Object value = showAvatar;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (exclude != null) {
            String key = "exclude";
            Object value = exclude;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (excludeAccountIds != null) {
            String key = "excludeAccountIds";
            Object value = excludeAccountIds;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (avatarSize != null) {
            String key = "avatarSize";
            Object value = avatarSize;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (excludeConnectUsers != null) {
            String key = "excludeConnectUsers";
            Object value = excludeConnectUsers;
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

    public HttpResponse findUsersForPickerForHttpResponse(String query, Map<String, Object> params) throws IOException {
        // verify the required parameter 'query' is set
        if (query == null) {
            throw new IllegalArgumentException("Missing the required parameter 'query' when calling findUsersForPicker");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/user/picker");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);
        // Add the required query param 'query' to the map of query params
        allParams.put("query", query);

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
    * Find users with permissions
    * Returns a list of users who fulfill these criteria:   *  their user attributes match a search string.  *  they have a set of permissions for a project or issue.  If no search string is provided, a list of all users with the permissions is returned.  This operation takes the users in the range defined by &#x60;startAt&#x60; and &#x60;maxResults&#x60;, up to the thousandth user, and then returns only the users from that range that match the search string and have permission for the project or issue. This means the operation usually returns fewer users than specified in &#x60;maxResults&#x60;. To get all the users who match the search string and have permission for the project or issue, use [Get all users](#api-rest-api-3-users-search-get) and filter the records in your code.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg), to get users for any project.  *  *Administer Projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for a project, to get users for that project.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  &#x60;issueKey&#x60; or &#x60;projectKey&#x60; is missing.  *  &#x60;query&#x60; or &#x60;accountId&#x60; is missing.  *  &#x60;query&#x60; and &#x60;accountId&#x60; are provided.  *  &#x60;permissions&#x60; is empty or contains an invalid entry.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the issue or project is not found.
    * @param permissions A comma separated list of permissions. Permissions can be specified as any:   *  permission returned by [Get all permissions](#api-rest-api-3-permissions-get).  *  custom project permission added by Connect apps.  *  (deprecated) one of the following:           *  ASSIGNABLE\\_USER      *  ASSIGN\\_ISSUE      *  ATTACHMENT\\_DELETE\\_ALL      *  ATTACHMENT\\_DELETE\\_OWN      *  BROWSE      *  CLOSE\\_ISSUE      *  COMMENT\\_DELETE\\_ALL      *  COMMENT\\_DELETE\\_OWN      *  COMMENT\\_EDIT\\_ALL      *  COMMENT\\_EDIT\\_OWN      *  COMMENT\\_ISSUE      *  CREATE\\_ATTACHMENT      *  CREATE\\_ISSUE      *  DELETE\\_ISSUE      *  EDIT\\_ISSUE      *  LINK\\_ISSUE      *  MANAGE\\_WATCHER\\_LIST      *  MODIFY\\_REPORTER      *  MOVE\\_ISSUE      *  PROJECT\\_ADMIN      *  RESOLVE\\_ISSUE      *  SCHEDULE\\_ISSUE      *  SET\\_ISSUE\\_SECURITY      *  TRANSITION\\_ISSUE      *  VIEW\\_VERSION\\_CONTROL      *  VIEW\\_VOTERS\\_AND\\_WATCHERS      *  VIEW\\_WORKFLOW\\_READONLY      *  WORKLOG\\_DELETE\\_ALL      *  WORKLOG\\_DELETE\\_OWN      *  WORKLOG\\_EDIT\\_ALL      *  WORKLOG\\_EDIT\\_OWN      *  WORK\\_ISSUE
    * @param query A query string that is matched against user attributes, such as &#x60;displayName&#x60; and &#x60;emailAddress&#x60;, to find relevant users. The string can match the prefix of the attribute&#39;s value. For example, *query&#x3D;john* matches a user with a &#x60;displayName&#x60; of *John Smith* and a user with an &#x60;emailAddress&#x60; of *johnson@example.com*. Required, unless &#x60;accountId&#x60; is specified.
    * @param username This parameter is no longer available and will be removed from the documentation soon. See the [deprecation notice](https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/) for details.
    * @param accountId A query string that is matched exactly against user &#x60;accountId&#x60;. Required, unless &#x60;query&#x60; is specified.
    * @param issueKey The issue key for the issue.
    * @param projectKey The project key for the project (case sensitive).
    * @param startAt The index of the first item to return in a page of results (page offset).
    * @param maxResults The maximum number of items to return per page.
    * @return List&lt;User&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<User> findUsersWithAllPermissions(String permissions, String query, String username, String accountId, String issueKey, String projectKey, Integer startAt, Integer maxResults) throws IOException {
        HttpResponse response = findUsersWithAllPermissionsForHttpResponse(permissions, query, username, accountId, issueKey, projectKey, startAt, maxResults);
        TypeReference<List<User>> typeRef = new TypeReference<List<User>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Find users with permissions
    * Returns a list of users who fulfill these criteria:   *  their user attributes match a search string.  *  they have a set of permissions for a project or issue.  If no search string is provided, a list of all users with the permissions is returned.  This operation takes the users in the range defined by &#x60;startAt&#x60; and &#x60;maxResults&#x60;, up to the thousandth user, and then returns only the users from that range that match the search string and have permission for the project or issue. This means the operation usually returns fewer users than specified in &#x60;maxResults&#x60;. To get all the users who match the search string and have permission for the project or issue, use [Get all users](#api-rest-api-3-users-search-get) and filter the records in your code.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg), to get users for any project.  *  *Administer Projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for a project, to get users for that project.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  &#x60;issueKey&#x60; or &#x60;projectKey&#x60; is missing.  *  &#x60;query&#x60; or &#x60;accountId&#x60; is missing.  *  &#x60;query&#x60; and &#x60;accountId&#x60; are provided.  *  &#x60;permissions&#x60; is empty or contains an invalid entry.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the issue or project is not found.
    * @param permissions A comma separated list of permissions. Permissions can be specified as any:   *  permission returned by [Get all permissions](#api-rest-api-3-permissions-get).  *  custom project permission added by Connect apps.  *  (deprecated) one of the following:           *  ASSIGNABLE\\_USER      *  ASSIGN\\_ISSUE      *  ATTACHMENT\\_DELETE\\_ALL      *  ATTACHMENT\\_DELETE\\_OWN      *  BROWSE      *  CLOSE\\_ISSUE      *  COMMENT\\_DELETE\\_ALL      *  COMMENT\\_DELETE\\_OWN      *  COMMENT\\_EDIT\\_ALL      *  COMMENT\\_EDIT\\_OWN      *  COMMENT\\_ISSUE      *  CREATE\\_ATTACHMENT      *  CREATE\\_ISSUE      *  DELETE\\_ISSUE      *  EDIT\\_ISSUE      *  LINK\\_ISSUE      *  MANAGE\\_WATCHER\\_LIST      *  MODIFY\\_REPORTER      *  MOVE\\_ISSUE      *  PROJECT\\_ADMIN      *  RESOLVE\\_ISSUE      *  SCHEDULE\\_ISSUE      *  SET\\_ISSUE\\_SECURITY      *  TRANSITION\\_ISSUE      *  VIEW\\_VERSION\\_CONTROL      *  VIEW\\_VOTERS\\_AND\\_WATCHERS      *  VIEW\\_WORKFLOW\\_READONLY      *  WORKLOG\\_DELETE\\_ALL      *  WORKLOG\\_DELETE\\_OWN      *  WORKLOG\\_EDIT\\_ALL      *  WORKLOG\\_EDIT\\_OWN      *  WORK\\_ISSUE
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return List&lt;User&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<User> findUsersWithAllPermissions(String permissions, Map<String, Object> params) throws IOException {
        HttpResponse response = findUsersWithAllPermissionsForHttpResponse(permissions, params);
        TypeReference<List<User>> typeRef = new TypeReference<List<User>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse findUsersWithAllPermissionsForHttpResponse(String permissions, String query, String username, String accountId, String issueKey, String projectKey, Integer startAt, Integer maxResults) throws IOException {
        // verify the required parameter 'permissions' is set
        if (permissions == null) {
            throw new IllegalArgumentException("Missing the required parameter 'permissions' when calling findUsersWithAllPermissions");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/user/permission/search");
        if (query != null) {
            String key = "query";
            Object value = query;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (username != null) {
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
        }        if (permissions != null) {
            String key = "permissions";
            Object value = permissions;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (issueKey != null) {
            String key = "issueKey";
            Object value = issueKey;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (projectKey != null) {
            String key = "projectKey";
            Object value = projectKey;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (startAt != null) {
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

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse findUsersWithAllPermissionsForHttpResponse(String permissions, Map<String, Object> params) throws IOException {
        // verify the required parameter 'permissions' is set
        if (permissions == null) {
            throw new IllegalArgumentException("Missing the required parameter 'permissions' when calling findUsersWithAllPermissions");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/user/permission/search");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);
        // Add the required query param 'permissions' to the map of query params
        allParams.put("permissions", permissions);

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
    * Find users with browse permission
    * Returns a list of users who fulfill these criteria:   *  their user attributes match a search string.  *  they have permission to browse issues.  Use this resource to find users who can browse:   *  an issue, by providing the &#x60;issueKey&#x60;.  *  any issue in a project, by providing the &#x60;projectKey&#x60;.  This operation takes the users in the range defined by &#x60;startAt&#x60; and &#x60;maxResults&#x60;, up to the thousandth user, and then returns only the users from that range that match the search string and have permission to browse issues. This means the operation usually returns fewer users than specified in &#x60;maxResults&#x60;. To get all the users who match the search string and have permission to browse issues, use [Get all users](#api-rest-api-3-users-search-get) and filter the records in your code.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Browse users and groups* [global permission](https://confluence.atlassian.com/x/x4dKLg). Anonymous calls and calls by users without the required permission return empty search results.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  &#x60;issueKey&#x60; or &#x60;projectKey&#x60; is missing.  *  &#x60;query&#x60; or &#x60;accountId&#x60; is missing.  *  &#x60;query&#x60; and &#x60;accountId&#x60; are provided.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the issue or project is not found.
    * @param query A query string that is matched against user attributes, such as &#x60;displayName&#x60; and &#x60;emailAddress&#x60;, to find relevant users. The string can match the prefix of the attribute&#39;s value. For example, *query&#x3D;john* matches a user with a &#x60;displayName&#x60; of *John Smith* and a user with an &#x60;emailAddress&#x60; of *johnson@example.com*. Required, unless &#x60;accountId&#x60; is specified.
    * @param username This parameter is no longer available and will be removed from the documentation soon. See the [deprecation notice](https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/) for details.
    * @param accountId A query string that is matched exactly against user &#x60;accountId&#x60;. Required, unless &#x60;query&#x60; is specified.
    * @param issueKey The issue key for the issue. Required, unless &#x60;projectKey&#x60; is specified.
    * @param projectKey The project key for the project (case sensitive). Required, unless &#x60;issueKey&#x60; is specified.
    * @param startAt The index of the first item to return in a page of results (page offset).
    * @param maxResults The maximum number of items to return per page.
    * @return List&lt;User&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<User> findUsersWithBrowsePermission(String query, String username, String accountId, String issueKey, String projectKey, Integer startAt, Integer maxResults) throws IOException {
        HttpResponse response = findUsersWithBrowsePermissionForHttpResponse(query, username, accountId, issueKey, projectKey, startAt, maxResults);
        TypeReference<List<User>> typeRef = new TypeReference<List<User>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Find users with browse permission
    * Returns a list of users who fulfill these criteria:   *  their user attributes match a search string.  *  they have permission to browse issues.  Use this resource to find users who can browse:   *  an issue, by providing the &#x60;issueKey&#x60;.  *  any issue in a project, by providing the &#x60;projectKey&#x60;.  This operation takes the users in the range defined by &#x60;startAt&#x60; and &#x60;maxResults&#x60;, up to the thousandth user, and then returns only the users from that range that match the search string and have permission to browse issues. This means the operation usually returns fewer users than specified in &#x60;maxResults&#x60;. To get all the users who match the search string and have permission to browse issues, use [Get all users](#api-rest-api-3-users-search-get) and filter the records in your code.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Browse users and groups* [global permission](https://confluence.atlassian.com/x/x4dKLg). Anonymous calls and calls by users without the required permission return empty search results.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  &#x60;issueKey&#x60; or &#x60;projectKey&#x60; is missing.  *  &#x60;query&#x60; or &#x60;accountId&#x60; is missing.  *  &#x60;query&#x60; and &#x60;accountId&#x60; are provided.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the issue or project is not found.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return List&lt;User&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<User> findUsersWithBrowsePermission(Map<String, Object> params) throws IOException {
        HttpResponse response = findUsersWithBrowsePermissionForHttpResponse(params);
        TypeReference<List<User>> typeRef = new TypeReference<List<User>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse findUsersWithBrowsePermissionForHttpResponse(String query, String username, String accountId, String issueKey, String projectKey, Integer startAt, Integer maxResults) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/user/viewissue/search");
        if (query != null) {
            String key = "query";
            Object value = query;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (username != null) {
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
        }        if (issueKey != null) {
            String key = "issueKey";
            Object value = issueKey;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (projectKey != null) {
            String key = "projectKey";
            Object value = projectKey;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (startAt != null) {
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

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse findUsersWithBrowsePermissionForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/user/viewissue/search");

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


}
