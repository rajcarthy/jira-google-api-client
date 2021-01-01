package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.ColumnItem;
import com.atlassian.jira.rest.client.model.GroupName;
import com.atlassian.jira.rest.client.model.PageBeanUser;
import com.atlassian.jira.rest.client.model.UnrestrictedUserEmail;
import com.atlassian.jira.rest.client.model.User;
import com.atlassian.jira.rest.client.model.UserMigrationBean;

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
public class UsersApi {
    private ApiClient apiClient;

    public UsersApi() {
        this(new ApiClient());
    }

    public UsersApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Bulk get users
    * Returns a [paginated](#pagination) list of the users specified by one or more account IDs.  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if &#x60;accountID&#x60; is missing.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param accountId The account ID of a user. To specify multiple users, pass multiple &#x60;accountId&#x60; parameters. For example, &#x60;accountId&#x3D;5b10a2844c20165700ede21g&amp;accountId&#x3D;5b10ac8d82e05b22cc7d4ef5&#x60;.
    * @param startAt The index of the first item to return in a page of results (page offset).
    * @param maxResults The maximum number of items to return per page.
    * @param username This parameter is no longer available and will be removed from the documentation soon. See the [deprecation notice](https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/) for details.
    * @param key This parameter is no longer available and will be removed from the documentation soon. See the [deprecation notice](https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/) for details.
    * @return PageBeanUser
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanUser bulkGetUsers(List<String> accountId, Long startAt, Integer maxResults, List<String> username, List<String> key) throws IOException {
        HttpResponse response = bulkGetUsersForHttpResponse(accountId, startAt, maxResults, username, key);
        TypeReference<PageBeanUser> typeRef = new TypeReference<PageBeanUser>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Bulk get users
    * Returns a [paginated](#pagination) list of the users specified by one or more account IDs.  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if &#x60;accountID&#x60; is missing.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param accountId The account ID of a user. To specify multiple users, pass multiple &#x60;accountId&#x60; parameters. For example, &#x60;accountId&#x3D;5b10a2844c20165700ede21g&amp;accountId&#x3D;5b10ac8d82e05b22cc7d4ef5&#x60;.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PageBeanUser
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanUser bulkGetUsers(List<String> accountId, Map<String, Object> params) throws IOException {
        HttpResponse response = bulkGetUsersForHttpResponse(accountId, params);
        TypeReference<PageBeanUser> typeRef = new TypeReference<PageBeanUser>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse bulkGetUsersForHttpResponse(List<String> accountId, Long startAt, Integer maxResults, List<String> username, List<String> key) throws IOException {
        // verify the required parameter 'accountId' is set
        if (accountId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'accountId' when calling bulkGetUsers");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/user/bulk");
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
        }        if (key != null) {
            String key = "key";
            Object value = key;
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
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse bulkGetUsersForHttpResponse(List<String> accountId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'accountId' is set
        if (accountId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'accountId' when calling bulkGetUsers");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/user/bulk");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);
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
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }


  /**
    * Get account IDs for users
    * Returns the account IDs for the users specified in the &#x60;key&#x60; or &#x60;username&#x60; parameters. Note that multiple &#x60;key&#x60; or &#x60;username&#x60; parameters can be specified.  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if &#x60;key&#x60; or &#x60;username&#x60;
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param startAt The index of the first item to return in a page of results (page offset).
    * @param maxResults The maximum number of items to return per page.
    * @param username Username of a user. To specify multiple users, pass multiple copies of this parameter. For example, &#x60;username&#x3D;fred&amp;username&#x3D;barney&#x60;. Required if &#x60;key&#x60; isn&#39;t provided. Cannot be provided if &#x60;key&#x60; is present.
    * @param key Key of a user. To specify multiple users, pass multiple copies of this parameter. For example, &#x60;key&#x3D;fred&amp;key&#x3D;barney&#x60;. Required if &#x60;username&#x60; isn&#39;t provided. Cannot be provided if &#x60;username&#x60; is present.
    * @return List&lt;UserMigrationBean&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<UserMigrationBean> bulkGetUsersMigration(Long startAt, Integer maxResults, List<String> username, List<String> key) throws IOException {
        HttpResponse response = bulkGetUsersMigrationForHttpResponse(startAt, maxResults, username, key);
        TypeReference<List<UserMigrationBean>> typeRef = new TypeReference<List<UserMigrationBean>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get account IDs for users
    * Returns the account IDs for the users specified in the &#x60;key&#x60; or &#x60;username&#x60; parameters. Note that multiple &#x60;key&#x60; or &#x60;username&#x60; parameters can be specified.  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if &#x60;key&#x60; or &#x60;username&#x60;
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return List&lt;UserMigrationBean&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<UserMigrationBean> bulkGetUsersMigration(Map<String, Object> params) throws IOException {
        HttpResponse response = bulkGetUsersMigrationForHttpResponse(params);
        TypeReference<List<UserMigrationBean>> typeRef = new TypeReference<List<UserMigrationBean>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse bulkGetUsersMigrationForHttpResponse(Long startAt, Integer maxResults, List<String> username, List<String> key) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/user/bulk/migration");
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
        }        if (key != null) {
            String key = "key";
            Object value = key;
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

    public HttpResponse bulkGetUsersMigrationForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/user/bulk/migration");

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
    * Create user
    * Creates a user. This resource is retained for legacy compatibility. As soon as a more suitable alternative is available this resource will be deprecated.  The option is provided to set or generate a password for the user. When using the option to generate a password, by omitting &#x60;password&#x60; from the request, include &#x60;\&quot;notification\&quot;: \&quot;true\&quot;&#x60; to ensure the user is sent an email advising them that their account is created. This email includes a link for the user to set their password. If the notification isn&#39;t sent for a generated password, the user will need to be sent a reset password request from Jira.  If the user exists and has access to Jira, the operation returns a 201 status. If the user exists but does not have access to Jira, the operation returns a 400 status.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>201</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid or the number of licensed users is exceeded.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * @param requestBody Details about the user to be created.
    * @return User
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public User createUser(Map<String, Object> requestBody) throws IOException {
        HttpResponse response = createUserForHttpResponse(requestBody);
        TypeReference<User> typeRef = new TypeReference<User>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Create user
    * Creates a user. This resource is retained for legacy compatibility. As soon as a more suitable alternative is available this resource will be deprecated.  The option is provided to set or generate a password for the user. When using the option to generate a password, by omitting &#x60;password&#x60; from the request, include &#x60;\&quot;notification\&quot;: \&quot;true\&quot;&#x60; to ensure the user is sent an email advising them that their account is created. This email includes a link for the user to set their password. If the notification isn&#39;t sent for a generated password, the user will need to be sent a reset password request from Jira.  If the user exists and has access to Jira, the operation returns a 201 status. If the user exists but does not have access to Jira, the operation returns a 400 status.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>201</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid or the number of licensed users is exceeded.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * @param requestBody Details about the user to be created.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return User
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public User createUser(Map<String, Object> requestBody, Map<String, Object> params) throws IOException {
        HttpResponse response = createUserForHttpResponse(requestBody, params);
        TypeReference<User> typeRef = new TypeReference<User>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse createUserForHttpResponse(Map<String, Object> requestBody) throws IOException {
        // verify the required parameter 'requestBody' is set
        if (requestBody == null) {
            throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling createUser");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/user");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(requestBody);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse createUserForHttpResponse(java.io.InputStream requestBody, String mediaType) throws IOException {
          // verify the required parameter 'requestBody' is set
              if (requestBody == null) {
              throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling createUser");
              }
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/user");

              String localVarUrl = uriBuilder.build().toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = requestBody == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, requestBody);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse createUserForHttpResponse(Map<String, Object> requestBody, Map<String, Object> params) throws IOException {
        // verify the required parameter 'requestBody' is set
        if (requestBody == null) {
            throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling createUser");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/user");

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
    * Get all users
    * Returns a list of all (active and inactive) users.  **[Permissions](#permissions) required:** *Browse users and groups* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>403</b> - Returned if the user doesn&#39;t have the necessary permission.
    * <p><b>409</b> - Returned if the request takes longer than 10 seconds or is interrupted.
    * @param startAt The index of the first item to return.
    * @param maxResults The maximum number of items to return.
    * @return List&lt;User&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<User> getAllUsers(Integer startAt, Integer maxResults) throws IOException {
        HttpResponse response = getAllUsersForHttpResponse(startAt, maxResults);
        TypeReference<List<User>> typeRef = new TypeReference<List<User>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get all users
    * Returns a list of all (active and inactive) users.  **[Permissions](#permissions) required:** *Browse users and groups* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>403</b> - Returned if the user doesn&#39;t have the necessary permission.
    * <p><b>409</b> - Returned if the request takes longer than 10 seconds or is interrupted.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return List&lt;User&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<User> getAllUsers(Map<String, Object> params) throws IOException {
        HttpResponse response = getAllUsersForHttpResponse(params);
        TypeReference<List<User>> typeRef = new TypeReference<List<User>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getAllUsersForHttpResponse(Integer startAt, Integer maxResults) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/users/search");
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

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getAllUsersForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/users/search");

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
    * Get all users default
    * Returns a list of all (active and inactive) users.  **[Permissions](#permissions) required:** *Browse users and groups* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>403</b> - Returned if the user doesn&#39;t have the necessary permission.
    * <p><b>409</b> - Returned if the request takes longer than 10 seconds or is interrupted.
    * @param startAt The index of the first item to return.
    * @param maxResults The maximum number of items to return.
    * @return List&lt;User&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<User> getAllUsersDefault(Integer startAt, Integer maxResults) throws IOException {
        HttpResponse response = getAllUsersDefaultForHttpResponse(startAt, maxResults);
        TypeReference<List<User>> typeRef = new TypeReference<List<User>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get all users default
    * Returns a list of all (active and inactive) users.  **[Permissions](#permissions) required:** *Browse users and groups* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>403</b> - Returned if the user doesn&#39;t have the necessary permission.
    * <p><b>409</b> - Returned if the request takes longer than 10 seconds or is interrupted.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return List&lt;User&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<User> getAllUsersDefault(Map<String, Object> params) throws IOException {
        HttpResponse response = getAllUsersDefaultForHttpResponse(params);
        TypeReference<List<User>> typeRef = new TypeReference<List<User>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getAllUsersDefaultForHttpResponse(Integer startAt, Integer maxResults) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/users");
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

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getAllUsersDefaultForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/users");

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
    * Get user
    * Returns a user.  **[Permissions](#permissions) required:** *Browse users and groups* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the calling user does not have the *Browse users and groups* global permission.
    * <p><b>404</b> - Returned if:   *  &#x60;accountId&#x60; is missing.  *  the user is not found.
    * @param accountId The account ID of the user, which uniquely identifies the user across all Atlassian products. For example, *5b10ac8d82e05b22cc7d4ef5*. Required.
    * @param username This parameter is no longer available and will be removed from the documentation soon. See the [deprecation notice](https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide) for details.
    * @param key This parameter is no longer available and will be removed from the documentation soon. See the [deprecation notice](https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide) for details.
    * @param expand Use [expand](#expansion) to include additional information about users in the response. This parameter accepts a comma-separated list. Expand options include:   *  &#x60;groups&#x60; includes all groups and nested groups to which the user belongs.  *  &#x60;applicationRoles&#x60; includes details of all the applications to which the user has access.
    * @return User
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public User getUser(String accountId, String username, String key, String expand) throws IOException {
        HttpResponse response = getUserForHttpResponse(accountId, username, key, expand);
        TypeReference<User> typeRef = new TypeReference<User>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get user
    * Returns a user.  **[Permissions](#permissions) required:** *Browse users and groups* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the calling user does not have the *Browse users and groups* global permission.
    * <p><b>404</b> - Returned if:   *  &#x60;accountId&#x60; is missing.  *  the user is not found.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return User
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public User getUser(Map<String, Object> params) throws IOException {
        HttpResponse response = getUserForHttpResponse(params);
        TypeReference<User> typeRef = new TypeReference<User>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getUserForHttpResponse(String accountId, String username, String key, String expand) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/user");
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
        }        if (key != null) {
            String key = "key";
            Object value = key;
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

    public HttpResponse getUserForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/user");

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
    * Get user default columns
    * Returns the default [issue table columns](https://confluence.atlassian.com/x/XYdKLg) for the user. If &#x60;accountId&#x60; is not passed in the request, the calling user&#39;s details are returned.  **[Permissions](#permissions) required:**   *  *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLgl), to get the column details for any user.  *  Permission to access Jira, to get the calling user&#39;s column details.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission or is not accessing their user record.
    * <p><b>404</b> - Returned if the requested user is not found.
    * @param accountId The account ID of the user, which uniquely identifies the user across all Atlassian products. For example, *5b10ac8d82e05b22cc7d4ef5*.
    * @param username This parameter is no longer available and will be removed from the documentation soon. See the [deprecation notice](https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/) for details.
    * @return List&lt;ColumnItem&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<ColumnItem> getUserDefaultColumns(String accountId, String username) throws IOException {
        HttpResponse response = getUserDefaultColumnsForHttpResponse(accountId, username);
        TypeReference<List<ColumnItem>> typeRef = new TypeReference<List<ColumnItem>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get user default columns
    * Returns the default [issue table columns](https://confluence.atlassian.com/x/XYdKLg) for the user. If &#x60;accountId&#x60; is not passed in the request, the calling user&#39;s details are returned.  **[Permissions](#permissions) required:**   *  *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLgl), to get the column details for any user.  *  Permission to access Jira, to get the calling user&#39;s column details.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission or is not accessing their user record.
    * <p><b>404</b> - Returned if the requested user is not found.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return List&lt;ColumnItem&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<ColumnItem> getUserDefaultColumns(Map<String, Object> params) throws IOException {
        HttpResponse response = getUserDefaultColumnsForHttpResponse(params);
        TypeReference<List<ColumnItem>> typeRef = new TypeReference<List<ColumnItem>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getUserDefaultColumnsForHttpResponse(String accountId, String username) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/user/columns");
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
        }

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getUserDefaultColumnsForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/user/columns");

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
    * Get user email
    * Returns a user&#39;s email address. This API is only available to apps approved by Atlassian, according to these [guidelines](https://community.developer.atlassian.com/t/guidelines-for-requesting-access-to-email-address/27603).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the calling app is not approved to use this API.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing from the request (for example if a user is trying to access this API).
    * <p><b>404</b> - Returned if a user with the given &#x60;accountId&#x60; doesn&#39;t exist
    * <p><b>503</b> - Indicates the API is not currently enabled
    * @param accountId The account ID of the user, which uniquely identifies the user across all Atlassian products. For example, &#x60;5b10ac8d82e05b22cc7d4ef5&#x60;.
    * @return UnrestrictedUserEmail
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public UnrestrictedUserEmail getUserEmail(String accountId) throws IOException {
        HttpResponse response = getUserEmailForHttpResponse(accountId);
        TypeReference<UnrestrictedUserEmail> typeRef = new TypeReference<UnrestrictedUserEmail>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get user email
    * Returns a user&#39;s email address. This API is only available to apps approved by Atlassian, according to these [guidelines](https://community.developer.atlassian.com/t/guidelines-for-requesting-access-to-email-address/27603).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the calling app is not approved to use this API.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing from the request (for example if a user is trying to access this API).
    * <p><b>404</b> - Returned if a user with the given &#x60;accountId&#x60; doesn&#39;t exist
    * <p><b>503</b> - Indicates the API is not currently enabled
    * @param accountId The account ID of the user, which uniquely identifies the user across all Atlassian products. For example, &#x60;5b10ac8d82e05b22cc7d4ef5&#x60;.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return UnrestrictedUserEmail
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public UnrestrictedUserEmail getUserEmail(String accountId, Map<String, Object> params) throws IOException {
        HttpResponse response = getUserEmailForHttpResponse(accountId, params);
        TypeReference<UnrestrictedUserEmail> typeRef = new TypeReference<UnrestrictedUserEmail>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getUserEmailForHttpResponse(String accountId) throws IOException {
        // verify the required parameter 'accountId' is set
        if (accountId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'accountId' when calling getUserEmail");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/user/email");
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
        }

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getUserEmailForHttpResponse(String accountId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'accountId' is set
        if (accountId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'accountId' when calling getUserEmail");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/user/email");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);
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
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }


  /**
    * Get user email bulk
    * Returns a user&#39;s email address. This API is only available to apps approved by Atlassian, according to these [guidelines](https://community.developer.atlassian.com/t/guidelines-for-requesting-access-to-email-address/27603).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the calling app is not approved to use this API.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect, or missing from the request (for example if a user is trying to access this API).
    * <p><b>503</b> - Indicates the API is not currently enabled.
    * @param accountId The account IDs of the users for which emails are required. An &#x60;accountId&#x60; is an identifier that uniquely identifies the user across all Atlassian products. For example, &#x60;5b10ac8d82e05b22cc7d4ef5&#x60;. Note, this should be treated as an opaque identifier (that is, do not assume any structure in the value).
    * @return UnrestrictedUserEmail
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public UnrestrictedUserEmail getUserEmailBulk(List<String> accountId) throws IOException {
        HttpResponse response = getUserEmailBulkForHttpResponse(accountId);
        TypeReference<UnrestrictedUserEmail> typeRef = new TypeReference<UnrestrictedUserEmail>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get user email bulk
    * Returns a user&#39;s email address. This API is only available to apps approved by Atlassian, according to these [guidelines](https://community.developer.atlassian.com/t/guidelines-for-requesting-access-to-email-address/27603).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the calling app is not approved to use this API.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect, or missing from the request (for example if a user is trying to access this API).
    * <p><b>503</b> - Indicates the API is not currently enabled.
    * @param accountId The account IDs of the users for which emails are required. An &#x60;accountId&#x60; is an identifier that uniquely identifies the user across all Atlassian products. For example, &#x60;5b10ac8d82e05b22cc7d4ef5&#x60;. Note, this should be treated as an opaque identifier (that is, do not assume any structure in the value).
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return UnrestrictedUserEmail
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public UnrestrictedUserEmail getUserEmailBulk(List<String> accountId, Map<String, Object> params) throws IOException {
        HttpResponse response = getUserEmailBulkForHttpResponse(accountId, params);
        TypeReference<UnrestrictedUserEmail> typeRef = new TypeReference<UnrestrictedUserEmail>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getUserEmailBulkForHttpResponse(List<String> accountId) throws IOException {
        // verify the required parameter 'accountId' is set
        if (accountId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'accountId' when calling getUserEmailBulk");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/user/email/bulk");
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
        }

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getUserEmailBulkForHttpResponse(List<String> accountId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'accountId' is set
        if (accountId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'accountId' when calling getUserEmailBulk");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/user/email/bulk");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);
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
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }


  /**
    * Get user groups
    * Returns the groups to which a user belongs.  **[Permissions](#permissions) required:** *Browse users and groups* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the calling user does not have the *Browse users and groups* global permission.
    * <p><b>404</b> - Returned if:   *  &#x60;accountId&#x60; is missing.  *  the user is not found.
    * @param accountId The account ID of the user, which uniquely identifies the user across all Atlassian products. For example, *5b10ac8d82e05b22cc7d4ef5*.
    * @param username This parameter is no longer available and will be removed from the documentation soon. See the [deprecation notice](https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/) for details.
    * @param key This parameter is no longer available and will be removed from the documentation soon. See the [deprecation notice](https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/) for details.
    * @return List&lt;GroupName&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<GroupName> getUserGroups(String accountId, String username, String key) throws IOException {
        HttpResponse response = getUserGroupsForHttpResponse(accountId, username, key);
        TypeReference<List<GroupName>> typeRef = new TypeReference<List<GroupName>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get user groups
    * Returns the groups to which a user belongs.  **[Permissions](#permissions) required:** *Browse users and groups* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the calling user does not have the *Browse users and groups* global permission.
    * <p><b>404</b> - Returned if:   *  &#x60;accountId&#x60; is missing.  *  the user is not found.
    * @param accountId The account ID of the user, which uniquely identifies the user across all Atlassian products. For example, *5b10ac8d82e05b22cc7d4ef5*.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return List&lt;GroupName&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<GroupName> getUserGroups(String accountId, Map<String, Object> params) throws IOException {
        HttpResponse response = getUserGroupsForHttpResponse(accountId, params);
        TypeReference<List<GroupName>> typeRef = new TypeReference<List<GroupName>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getUserGroupsForHttpResponse(String accountId, String username, String key) throws IOException {
        // verify the required parameter 'accountId' is set
        if (accountId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'accountId' when calling getUserGroups");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/user/groups");
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
        }        if (key != null) {
            String key = "key";
            Object value = key;
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

    public HttpResponse getUserGroupsForHttpResponse(String accountId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'accountId' is set
        if (accountId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'accountId' when calling getUserGroups");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/user/groups");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);
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
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }


  /**
    * Delete user
    * Deletes a user.  **[Permissions](#permissions) required:** Site administration (that is, membership of the *site-admin* [group](https://confluence.atlassian.com/x/24xjL)).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the user cannot be removed.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if:   *  &#x60;accountId&#x60; is missing.  *  the user is not found.
    * @param accountId The account ID of the user, which uniquely identifies the user across all Atlassian products. For example, *5b10ac8d82e05b22cc7d4ef5*.
    * @param username This parameter is no longer available and will be removed from the documentation soon. See the [deprecation notice](https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/) for details.
    * @param key This parameter is no longer available and will be removed from the documentation soon. See the [deprecation notice](https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/) for details.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void removeUser(String accountId, String username, String key) throws IOException {
        removeUserForHttpResponse(accountId, username, key);
    }

  /**
    * Delete user
    * Deletes a user.  **[Permissions](#permissions) required:** Site administration (that is, membership of the *site-admin* [group](https://confluence.atlassian.com/x/24xjL)).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the user cannot be removed.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if:   *  &#x60;accountId&#x60; is missing.  *  the user is not found.
    * @param accountId The account ID of the user, which uniquely identifies the user across all Atlassian products. For example, *5b10ac8d82e05b22cc7d4ef5*.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void removeUser(String accountId, Map<String, Object> params) throws IOException {
        removeUserForHttpResponse(accountId, params);
    }

    public HttpResponse removeUserForHttpResponse(String accountId, String username, String key) throws IOException {
        // verify the required parameter 'accountId' is set
        if (accountId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'accountId' when calling removeUser");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/user");
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
        }        if (key != null) {
            String key = "key";
            Object value = key;
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

    public HttpResponse removeUserForHttpResponse(String accountId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'accountId' is set
        if (accountId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'accountId' when calling removeUser");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/user");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);
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


  /**
    * Reset user default columns
    * Resets the default [ issue table columns](https://confluence.atlassian.com/x/XYdKLg) for the user to the system default. If &#x60;accountId&#x60; is not passed, the calling user&#39;s default columns are reset.  **[Permissions](#permissions) required:**   *  *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg), to set the columns on any user.  *  Permission to access Jira, to set the calling user&#39;s columns.
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission or is not accessing their user record.
    * @param accountId The account ID of the user, which uniquely identifies the user across all Atlassian products. For example, *5b10ac8d82e05b22cc7d4ef5*.
    * @param username This parameter is no longer available and will be removed from the documentation soon. See the [deprecation notice](https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/) for details.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void resetUserColumns(String accountId, String username) throws IOException {
        resetUserColumnsForHttpResponse(accountId, username);
    }

  /**
    * Reset user default columns
    * Resets the default [ issue table columns](https://confluence.atlassian.com/x/XYdKLg) for the user to the system default. If &#x60;accountId&#x60; is not passed, the calling user&#39;s default columns are reset.  **[Permissions](#permissions) required:**   *  *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg), to set the columns on any user.  *  Permission to access Jira, to set the calling user&#39;s columns.
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission or is not accessing their user record.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void resetUserColumns(Map<String, Object> params) throws IOException {
        resetUserColumnsForHttpResponse(params);
    }

    public HttpResponse resetUserColumnsForHttpResponse(String accountId, String username) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/user/columns");
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
        }

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }

    public HttpResponse resetUserColumnsForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/user/columns");

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
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }


  /**
    * Set user default columns
    * Sets the default [ issue table columns](https://confluence.atlassian.com/x/XYdKLg) for the user. If an account ID is not passed, the calling user&#39;s default columns are set. If no column details are sent, then all default columns are removed.  The parameters for this resource are expressed as HTML form data. For example, in curl:  &#x60;curl -X PUT -d columns&#x3D;summary -d columns&#x3D;description https://your-domain.atlassian.net/rest/api/3/user/columns?accountId&#x3D;5b10ac8d82e05b22cc7d4ef5&#39;&#x60;  **[Permissions](#permissions) required:**   *  *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg), to set the columns on any user.  *  Permission to access Jira, to set the calling user&#39;s columns.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission or is not accessing their user record.
    * <p><b>404</b> - Returned if the requested user is not found.
    * <p><b>500</b> - Returned if an invalid issue table column ID is sent.
    * @param accountId The account ID of the user, which uniquely identifies the user across all Atlassian products. For example, *5b10ac8d82e05b22cc7d4ef5*.
    * @param requestBody The ID of a column to set. To set multiple columns, send multiple &#x60;columns&#x60; parameters.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object setUserColumns(String accountId, List<String> requestBody) throws IOException {
        HttpResponse response = setUserColumnsForHttpResponse(accountId, requestBody);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Set user default columns
    * Sets the default [ issue table columns](https://confluence.atlassian.com/x/XYdKLg) for the user. If an account ID is not passed, the calling user&#39;s default columns are set. If no column details are sent, then all default columns are removed.  The parameters for this resource are expressed as HTML form data. For example, in curl:  &#x60;curl -X PUT -d columns&#x3D;summary -d columns&#x3D;description https://your-domain.atlassian.net/rest/api/3/user/columns?accountId&#x3D;5b10ac8d82e05b22cc7d4ef5&#39;&#x60;  **[Permissions](#permissions) required:**   *  *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg), to set the columns on any user.  *  Permission to access Jira, to set the calling user&#39;s columns.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission or is not accessing their user record.
    * <p><b>404</b> - Returned if the requested user is not found.
    * <p><b>500</b> - Returned if an invalid issue table column ID is sent.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object setUserColumns(List<String> requestBody, Map<String, Object> params) throws IOException {
        HttpResponse response = setUserColumnsForHttpResponse(requestBody, params);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse setUserColumnsForHttpResponse(String accountId, List<String> requestBody) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/user/columns");
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
        }

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(requestBody);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse setUserColumnsForHttpResponse(String accountId, java.io.InputStream requestBody, String mediaType) throws IOException {
          
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/user/columns");
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
              }

              String localVarUrl = uriBuilder.build().toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = requestBody == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, requestBody);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse setUserColumnsForHttpResponse(List<String> requestBody, Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/user/columns");

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
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }


}
