package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.FoundGroups;
import com.atlassian.jira.rest.client.model.Group;
import com.atlassian.jira.rest.client.model.PageBeanGroupDetails;
import com.atlassian.jira.rest.client.model.PageBeanUserDetails;
import java.util.Set;

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
public class GroupsApi {
    private ApiClient apiClient;

    public GroupsApi() {
        this(new ApiClient());
    }

    public GroupsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Add user to group
    * Adds a user to a group.  **[Permissions](#permissions) required:** Site administration (that is, member of the *site-admin* [group](https://confluence.atlassian.com/x/24xjL)).
    * <p><b>201</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  &#x60;groupname&#x60; is not provided.  *  &#x60;accountId&#x60; is missing.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing from the request.
    * <p><b>403</b> - Returned if the calling user does not have the necessary permission.
    * <p><b>404</b> - Returned if the group or user are not found.
    * @param groupname The name of the group (case sensitive).
    * @param requestBody The user to add to the group.
    * @return Group
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Group addUserToGroup(String groupname, Map<String, Object> requestBody) throws IOException {
        HttpResponse response = addUserToGroupForHttpResponse(groupname, requestBody);
        TypeReference<Group> typeRef = new TypeReference<Group>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Add user to group
    * Adds a user to a group.  **[Permissions](#permissions) required:** Site administration (that is, member of the *site-admin* [group](https://confluence.atlassian.com/x/24xjL)).
    * <p><b>201</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  &#x60;groupname&#x60; is not provided.  *  &#x60;accountId&#x60; is missing.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing from the request.
    * <p><b>403</b> - Returned if the calling user does not have the necessary permission.
    * <p><b>404</b> - Returned if the group or user are not found.
    * @param groupname The name of the group (case sensitive).
    * @param requestBody The user to add to the group.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Group
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Group addUserToGroup(String groupname, Map<String, Object> requestBody, Map<String, Object> params) throws IOException {
        HttpResponse response = addUserToGroupForHttpResponse(groupname, requestBody, params);
        TypeReference<Group> typeRef = new TypeReference<Group>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse addUserToGroupForHttpResponse(String groupname, Map<String, Object> requestBody) throws IOException {
        // verify the required parameter 'groupname' is set
        if (groupname == null) {
            throw new IllegalArgumentException("Missing the required parameter 'groupname' when calling addUserToGroup");
        }// verify the required parameter 'requestBody' is set
        if (requestBody == null) {
            throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling addUserToGroup");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/group/user");
        if (groupname != null) {
            String key = "groupname";
            Object value = groupname;
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

      public HttpResponse addUserToGroupForHttpResponse(String groupname, java.io.InputStream requestBody, String mediaType) throws IOException {
          // verify the required parameter 'groupname' is set
              if (groupname == null) {
              throw new IllegalArgumentException("Missing the required parameter 'groupname' when calling addUserToGroup");
              }// verify the required parameter 'requestBody' is set
              if (requestBody == null) {
              throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling addUserToGroup");
              }
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/group/user");
              if (groupname != null) {
                  String key = "groupname";
                  Object value = groupname;
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

    public HttpResponse addUserToGroupForHttpResponse(String groupname, Map<String, Object> requestBody, Map<String, Object> params) throws IOException {
        // verify the required parameter 'groupname' is set
        if (groupname == null) {
            throw new IllegalArgumentException("Missing the required parameter 'groupname' when calling addUserToGroup");
        }// verify the required parameter 'requestBody' is set
        if (requestBody == null) {
            throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling addUserToGroup");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/group/user");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);
        // Add the required query param 'groupname' to the map of query params
        allParams.put("groupname", groupname);

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
    * Bulk get groups
    * Returns a [paginated](#pagination) list of groups.  **[Permissions](#permissions) required:** *Browse users and groups* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * @param startAt The index of the first item to return in a page of results (page offset).
    * @param maxResults The maximum number of items to return per page.
    * @param groupId The ID of a group. To specify multiple IDs, pass multiple &#x60;groupId&#x60; parameters. For example, &#x60;groupId&#x3D;5b10a2844c20165700ede21g&amp;groupId&#x3D;5b10ac8d82e05b22cc7d4ef5&#x60;.
    * @param groupName The name of a group. To specify multiple names, pass multiple &#x60;groupName&#x60; parameters. For example, &#x60;groupName&#x3D;administrators&amp;groupName&#x3D;jira-software-users&#x60;.
    * @return PageBeanGroupDetails
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanGroupDetails bulkGetGroups(Long startAt, Integer maxResults, Set<String> groupId, Set<String> groupName) throws IOException {
        HttpResponse response = bulkGetGroupsForHttpResponse(startAt, maxResults, groupId, groupName);
        TypeReference<PageBeanGroupDetails> typeRef = new TypeReference<PageBeanGroupDetails>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Bulk get groups
    * Returns a [paginated](#pagination) list of groups.  **[Permissions](#permissions) required:** *Browse users and groups* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PageBeanGroupDetails
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanGroupDetails bulkGetGroups(Map<String, Object> params) throws IOException {
        HttpResponse response = bulkGetGroupsForHttpResponse(params);
        TypeReference<PageBeanGroupDetails> typeRef = new TypeReference<PageBeanGroupDetails>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse bulkGetGroupsForHttpResponse(Long startAt, Integer maxResults, Set<String> groupId, Set<String> groupName) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/group/bulk");
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
        }        if (groupId != null) {
            String key = "groupId";
            Object value = groupId;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (groupName != null) {
            String key = "groupName";
            Object value = groupName;
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

    public HttpResponse bulkGetGroupsForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/group/bulk");

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
    * Create group
    * Creates a group.  **[Permissions](#permissions) required:** Site administration (that is, member of the *site-admin* [group](https://confluence.atlassian.com/x/24xjL)).
    * <p><b>201</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if group name is not specified or the group name is in use.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * @param requestBody The name of the group.
    * @return Group
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Group createGroup(Map<String, Object> requestBody) throws IOException {
        HttpResponse response = createGroupForHttpResponse(requestBody);
        TypeReference<Group> typeRef = new TypeReference<Group>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Create group
    * Creates a group.  **[Permissions](#permissions) required:** Site administration (that is, member of the *site-admin* [group](https://confluence.atlassian.com/x/24xjL)).
    * <p><b>201</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if group name is not specified or the group name is in use.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * @param requestBody The name of the group.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Group
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Group createGroup(Map<String, Object> requestBody, Map<String, Object> params) throws IOException {
        HttpResponse response = createGroupForHttpResponse(requestBody, params);
        TypeReference<Group> typeRef = new TypeReference<Group>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse createGroupForHttpResponse(Map<String, Object> requestBody) throws IOException {
        // verify the required parameter 'requestBody' is set
        if (requestBody == null) {
            throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling createGroup");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/group");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(requestBody);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse createGroupForHttpResponse(java.io.InputStream requestBody, String mediaType) throws IOException {
          // verify the required parameter 'requestBody' is set
              if (requestBody == null) {
              throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling createGroup");
              }
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/group");

              String localVarUrl = uriBuilder.build().toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = requestBody == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, requestBody);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse createGroupForHttpResponse(Map<String, Object> requestBody, Map<String, Object> params) throws IOException {
        // verify the required parameter 'requestBody' is set
        if (requestBody == null) {
            throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling createGroup");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/group");

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
    * Find groups
    * Returns a list of groups whose names contain a query string. A list of group names can be provided to exclude groups from the results.  The primary use case for this resource is to populate a group picker suggestions list. To this end, the returned object includes the &#x60;html&#x60; field where the matched query term is highlighted in the group name with the HTML strong tag. Also, the groups list is wrapped in a response object that contains a header for use in the picker, specifically *Showing X of Y matching groups*.  The list returns with the groups sorted. If no groups match the list criteria, an empty list is returned.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg). Anonymous calls and calls by users without the required permission return an empty list.
    * <p><b>200</b> - Returned if the request is successful.
    * @param accountId This parameter is deprecated, setting it does not affect the results. To find groups containing a particular user, use [Get user groups](#api-rest-api-3-user-groups-get).
    * @param query The string to find in group names.
    * @param exclude A group to exclude from the result. To exclude multiple groups, provide an ampersand-separated list. For example, &#x60;exclude&#x3D;group1&amp;exclude&#x3D;group2&#x60;.
    * @param maxResults The maximum number of groups to return. The maximum number of groups that can be returned is limited by the system property &#x60;jira.ajax.autocomplete.limit&#x60;.
    * @param userName This parameter is no longer available and will be removed from the documentation soon. See the [deprecation notice](https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/) for details.
    * @return FoundGroups
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public FoundGroups findGroups(String accountId, String query, List<String> exclude, Integer maxResults, String userName) throws IOException {
        HttpResponse response = findGroupsForHttpResponse(accountId, query, exclude, maxResults, userName);
        TypeReference<FoundGroups> typeRef = new TypeReference<FoundGroups>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Find groups
    * Returns a list of groups whose names contain a query string. A list of group names can be provided to exclude groups from the results.  The primary use case for this resource is to populate a group picker suggestions list. To this end, the returned object includes the &#x60;html&#x60; field where the matched query term is highlighted in the group name with the HTML strong tag. Also, the groups list is wrapped in a response object that contains a header for use in the picker, specifically *Showing X of Y matching groups*.  The list returns with the groups sorted. If no groups match the list criteria, an empty list is returned.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg). Anonymous calls and calls by users without the required permission return an empty list.
    * <p><b>200</b> - Returned if the request is successful.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return FoundGroups
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public FoundGroups findGroups(Map<String, Object> params) throws IOException {
        HttpResponse response = findGroupsForHttpResponse(params);
        TypeReference<FoundGroups> typeRef = new TypeReference<FoundGroups>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse findGroupsForHttpResponse(String accountId, String query, List<String> exclude, Integer maxResults, String userName) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/groups/picker");
        if (accountId != null) {
            String key = "accountId";
            Object value = accountId;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (query != null) {
            String key = "query";
            Object value = query;
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
        }        if (userName != null) {
            String key = "userName";
            Object value = userName;
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

    public HttpResponse findGroupsForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/groups/picker");

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
    * Get group
    * This operation is deprecated, use [&#x60;group/member&#x60;](#api-rest-api-3-group-member-get).  Returns all users in a group.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the group name is not specified.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the calling user does not have the Administer Jira global permission.
    * <p><b>404</b> - Returned if the group is not found.
    * @param groupname The name of the group.
    * @param expand List of fields to expand.
    * @return Group
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Group getGroup(String groupname, String expand) throws IOException {
        HttpResponse response = getGroupForHttpResponse(groupname, expand);
        TypeReference<Group> typeRef = new TypeReference<Group>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get group
    * This operation is deprecated, use [&#x60;group/member&#x60;](#api-rest-api-3-group-member-get).  Returns all users in a group.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the group name is not specified.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the calling user does not have the Administer Jira global permission.
    * <p><b>404</b> - Returned if the group is not found.
    * @param groupname The name of the group.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Group
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Group getGroup(String groupname, Map<String, Object> params) throws IOException {
        HttpResponse response = getGroupForHttpResponse(groupname, params);
        TypeReference<Group> typeRef = new TypeReference<Group>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getGroupForHttpResponse(String groupname, String expand) throws IOException {
        // verify the required parameter 'groupname' is set
        if (groupname == null) {
            throw new IllegalArgumentException("Missing the required parameter 'groupname' when calling getGroup");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/group");
        if (groupname != null) {
            String key = "groupname";
            Object value = groupname;
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

    public HttpResponse getGroupForHttpResponse(String groupname, Map<String, Object> params) throws IOException {
        // verify the required parameter 'groupname' is set
        if (groupname == null) {
            throw new IllegalArgumentException("Missing the required parameter 'groupname' when calling getGroup");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/group");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);
        // Add the required query param 'groupname' to the map of query params
        allParams.put("groupname", groupname);

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
    * Get users from group
    * Returns a [paginated](#pagination) list of all users in a group.  Note that users are ordered by username, however the username is not returned in the results due to privacy reasons.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the group name is not specified.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the calling user does not have the Administer Jira global permission.
    * <p><b>404</b> - Returned if the group is not found.
    * @param groupname The name of the group.
    * @param includeInactiveUsers Include inactive users.
    * @param startAt The index of the first item to return in a page of results (page offset).
    * @param maxResults The maximum number of items to return per page.
    * @return PageBeanUserDetails
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanUserDetails getUsersFromGroup(String groupname, Boolean includeInactiveUsers, Long startAt, Integer maxResults) throws IOException {
        HttpResponse response = getUsersFromGroupForHttpResponse(groupname, includeInactiveUsers, startAt, maxResults);
        TypeReference<PageBeanUserDetails> typeRef = new TypeReference<PageBeanUserDetails>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get users from group
    * Returns a [paginated](#pagination) list of all users in a group.  Note that users are ordered by username, however the username is not returned in the results due to privacy reasons.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the group name is not specified.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the calling user does not have the Administer Jira global permission.
    * <p><b>404</b> - Returned if the group is not found.
    * @param groupname The name of the group.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PageBeanUserDetails
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanUserDetails getUsersFromGroup(String groupname, Map<String, Object> params) throws IOException {
        HttpResponse response = getUsersFromGroupForHttpResponse(groupname, params);
        TypeReference<PageBeanUserDetails> typeRef = new TypeReference<PageBeanUserDetails>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getUsersFromGroupForHttpResponse(String groupname, Boolean includeInactiveUsers, Long startAt, Integer maxResults) throws IOException {
        // verify the required parameter 'groupname' is set
        if (groupname == null) {
            throw new IllegalArgumentException("Missing the required parameter 'groupname' when calling getUsersFromGroup");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/group/member");
        if (groupname != null) {
            String key = "groupname";
            Object value = groupname;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (includeInactiveUsers != null) {
            String key = "includeInactiveUsers";
            Object value = includeInactiveUsers;
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

    public HttpResponse getUsersFromGroupForHttpResponse(String groupname, Map<String, Object> params) throws IOException {
        // verify the required parameter 'groupname' is set
        if (groupname == null) {
            throw new IllegalArgumentException("Missing the required parameter 'groupname' when calling getUsersFromGroup");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/group/member");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);
        // Add the required query param 'groupname' to the map of query params
        allParams.put("groupname", groupname);

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
    * Remove group
    * Deletes a group.  **[Permissions](#permissions) required:** Site administration (that is, member of the *site-admin* strategic [group](https://confluence.atlassian.com/x/24xjL)).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the group name is not specified.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing from the request.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the group is not found.
    * @param groupname The name of the group.
    * @param swapGroup The group to transfer restrictions to. Only comments and worklogs are transferred. If restrictions are not transferred, comments and worklogs are inaccessible after the deletion.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void removeGroup(String groupname, String swapGroup) throws IOException {
        removeGroupForHttpResponse(groupname, swapGroup);
    }

  /**
    * Remove group
    * Deletes a group.  **[Permissions](#permissions) required:** Site administration (that is, member of the *site-admin* strategic [group](https://confluence.atlassian.com/x/24xjL)).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the group name is not specified.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing from the request.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the group is not found.
    * @param groupname The name of the group.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void removeGroup(String groupname, Map<String, Object> params) throws IOException {
        removeGroupForHttpResponse(groupname, params);
    }

    public HttpResponse removeGroupForHttpResponse(String groupname, String swapGroup) throws IOException {
        // verify the required parameter 'groupname' is set
        if (groupname == null) {
            throw new IllegalArgumentException("Missing the required parameter 'groupname' when calling removeGroup");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/group");
        if (groupname != null) {
            String key = "groupname";
            Object value = groupname;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (swapGroup != null) {
            String key = "swapGroup";
            Object value = swapGroup;
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
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }

    public HttpResponse removeGroupForHttpResponse(String groupname, Map<String, Object> params) throws IOException {
        // verify the required parameter 'groupname' is set
        if (groupname == null) {
            throw new IllegalArgumentException("Missing the required parameter 'groupname' when calling removeGroup");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/group");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);
        // Add the required query param 'groupname' to the map of query params
        allParams.put("groupname", groupname);

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
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }


  /**
    * Remove user from group
    * Removes a user from a group.  **[Permissions](#permissions) required:** Site administration (that is, member of the *site-admin* [group](https://confluence.atlassian.com/x/24xjL)).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  &#x60;groupName&#x60; is missing.  *  &#x60;accountId&#x60; is missing.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing from the request.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the group or user are not found.
    * @param groupname The name of the group.
    * @param accountId The account ID of the user, which uniquely identifies the user across all Atlassian products. For example, *5b10ac8d82e05b22cc7d4ef5*.
    * @param username This parameter is no longer available and will be removed from the documentation soon. See the [deprecation notice](https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/) for details.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void removeUserFromGroup(String groupname, String accountId, String username) throws IOException {
        removeUserFromGroupForHttpResponse(groupname, accountId, username);
    }

  /**
    * Remove user from group
    * Removes a user from a group.  **[Permissions](#permissions) required:** Site administration (that is, member of the *site-admin* [group](https://confluence.atlassian.com/x/24xjL)).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  &#x60;groupName&#x60; is missing.  *  &#x60;accountId&#x60; is missing.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing from the request.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the group or user are not found.
    * @param groupname The name of the group.
    * @param accountId The account ID of the user, which uniquely identifies the user across all Atlassian products. For example, *5b10ac8d82e05b22cc7d4ef5*.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void removeUserFromGroup(String groupname, String accountId, Map<String, Object> params) throws IOException {
        removeUserFromGroupForHttpResponse(groupname, accountId, params);
    }

    public HttpResponse removeUserFromGroupForHttpResponse(String groupname, String accountId, String username) throws IOException {
        // verify the required parameter 'groupname' is set
        if (groupname == null) {
            throw new IllegalArgumentException("Missing the required parameter 'groupname' when calling removeUserFromGroup");
        }// verify the required parameter 'accountId' is set
        if (accountId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'accountId' when calling removeUserFromGroup");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/group/user");
        if (groupname != null) {
            String key = "groupname";
            Object value = groupname;
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
        }

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }

    public HttpResponse removeUserFromGroupForHttpResponse(String groupname, String accountId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'groupname' is set
        if (groupname == null) {
            throw new IllegalArgumentException("Missing the required parameter 'groupname' when calling removeUserFromGroup");
        }// verify the required parameter 'accountId' is set
        if (accountId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'accountId' when calling removeUserFromGroup");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/group/user");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);
        // Add the required query param 'groupname' to the map of query params
        allParams.put("groupname", groupname);
        // Add the required query param 'accountId' to the map of query params
        allParams.put("accountId", accountId);

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
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }


}
