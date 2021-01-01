package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.Locale;
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
public class MyselfApi {
    private ApiClient apiClient;

    public MyselfApi() {
        this(new ApiClient());
    }

    public MyselfApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Delete locale
    * Deprecated, use [ Update a user profile](https://developer.atlassian.com/cloud/admin/user-management/rest/#api-users-account-id-manage-profile-patch) from the user management REST API instead.  Deletes the locale of the user, which restores the default setting.  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object deleteLocale() throws IOException {
        HttpResponse response = deleteLocaleForHttpResponse();
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Delete locale
    * Deprecated, use [ Update a user profile](https://developer.atlassian.com/cloud/admin/user-management/rest/#api-users-account-id-manage-profile-patch) from the user management REST API instead.  Deletes the locale of the user, which restores the default setting.  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object deleteLocale(Map<String, Object> params) throws IOException {
        HttpResponse response = deleteLocaleForHttpResponse(params);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse deleteLocaleForHttpResponse() throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/mypreferences/locale");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }

    public HttpResponse deleteLocaleForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/mypreferences/locale");

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
    * Get current user
    * Returns details for the current user.  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param expand Use [expand](#expansion) to include additional information about user in the response. This parameter accepts a comma-separated list. Expand options include:   *  &#x60;groups&#x60; Returns all groups, including nested groups, the user belongs to.  *  &#x60;applicationRoles&#x60; Returns the application roles the user is assigned to.
    * @return User
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public User getCurrentUser(String expand) throws IOException {
        HttpResponse response = getCurrentUserForHttpResponse(expand);
        TypeReference<User> typeRef = new TypeReference<User>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get current user
    * Returns details for the current user.  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return User
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public User getCurrentUser(Map<String, Object> params) throws IOException {
        HttpResponse response = getCurrentUserForHttpResponse(params);
        TypeReference<User> typeRef = new TypeReference<User>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getCurrentUserForHttpResponse(String expand) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/myself");
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

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getCurrentUserForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/myself");

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
    * Get locale
    * Returns the locale for the user.  If the user has no language preference set (which is the default setting) or this resource is accessed anonymous, the browser locale detected by Jira is returned. Jira detects the browser locale using the *Accept-Language* header in the request. However, if this doesn&#39;t match a locale available Jira, the site default locale is returned.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @return Locale
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Locale getLocale() throws IOException {
        HttpResponse response = getLocaleForHttpResponse();
        TypeReference<Locale> typeRef = new TypeReference<Locale>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get locale
    * Returns the locale for the user.  If the user has no language preference set (which is the default setting) or this resource is accessed anonymous, the browser locale detected by Jira is returned. Jira detects the browser locale using the *Accept-Language* header in the request. However, if this doesn&#39;t match a locale available Jira, the site default locale is returned.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Locale
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Locale getLocale(Map<String, Object> params) throws IOException {
        HttpResponse response = getLocaleForHttpResponse(params);
        TypeReference<Locale> typeRef = new TypeReference<Locale>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getLocaleForHttpResponse() throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/mypreferences/locale");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getLocaleForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/mypreferences/locale");

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
    * Get preference
    * Returns the value of a preference of the current user.  Note that these keys are deprecated:   *  *jira.user.locale* The locale of the user. By default this is not set and the user takes the locale of the instance.  *  *jira.user.timezone* The time zone of the user. By default this is not set and the user takes the timezone of the instance.  Use [ Update a user profile](https://developer.atlassian.com/cloud/admin/user-management/rest/#api-users-account-id-manage-profile-patch) from the user management REST API to manage timezone and locale instead.  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the key is not provided or not found.
    * @param key The key of the preference.
    * @return String
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public String getPreference(String key) throws IOException {
        HttpResponse response = getPreferenceForHttpResponse(key);
        TypeReference<String> typeRef = new TypeReference<String>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get preference
    * Returns the value of a preference of the current user.  Note that these keys are deprecated:   *  *jira.user.locale* The locale of the user. By default this is not set and the user takes the locale of the instance.  *  *jira.user.timezone* The time zone of the user. By default this is not set and the user takes the timezone of the instance.  Use [ Update a user profile](https://developer.atlassian.com/cloud/admin/user-management/rest/#api-users-account-id-manage-profile-patch) from the user management REST API to manage timezone and locale instead.  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the key is not provided or not found.
    * @param key The key of the preference.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return String
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public String getPreference(String key, Map<String, Object> params) throws IOException {
        HttpResponse response = getPreferenceForHttpResponse(key, params);
        TypeReference<String> typeRef = new TypeReference<String>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getPreferenceForHttpResponse(String key) throws IOException {
        // verify the required parameter 'key' is set
        if (key == null) {
            throw new IllegalArgumentException("Missing the required parameter 'key' when calling getPreference");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/mypreferences");
        if (key != null) {
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

    public HttpResponse getPreferenceForHttpResponse(String key, Map<String, Object> params) throws IOException {
        // verify the required parameter 'key' is set
        if (key == null) {
            throw new IllegalArgumentException("Missing the required parameter 'key' when calling getPreference");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/mypreferences");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);
        // Add the required query param 'key' to the map of query params
        allParams.put("key", key);

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
    * Delete preference
    * Deletes a preference of the user, which restores the default value of system defined settings.  Note that these keys are deprecated:   *  *jira.user.locale* The locale of the user. By default, not set. The user takes the instance locale.  *  *jira.user.timezone* The time zone of the user. By default, not set. The user takes the instance timezone.  Use [ Update a user profile](https://developer.atlassian.com/cloud/admin/user-management/rest/#api-users-account-id-manage-profile-patch) from the user management REST API to manage timezone and locale instead.  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the key is not provided or not found.
    * @param key The key of the preference.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void removePreference(String key) throws IOException {
        removePreferenceForHttpResponse(key);
    }

  /**
    * Delete preference
    * Deletes a preference of the user, which restores the default value of system defined settings.  Note that these keys are deprecated:   *  *jira.user.locale* The locale of the user. By default, not set. The user takes the instance locale.  *  *jira.user.timezone* The time zone of the user. By default, not set. The user takes the instance timezone.  Use [ Update a user profile](https://developer.atlassian.com/cloud/admin/user-management/rest/#api-users-account-id-manage-profile-patch) from the user management REST API to manage timezone and locale instead.  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the key is not provided or not found.
    * @param key The key of the preference.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void removePreference(String key, Map<String, Object> params) throws IOException {
        removePreferenceForHttpResponse(key, params);
    }

    public HttpResponse removePreferenceForHttpResponse(String key) throws IOException {
        // verify the required parameter 'key' is set
        if (key == null) {
            throw new IllegalArgumentException("Missing the required parameter 'key' when calling removePreference");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/mypreferences");
        if (key != null) {
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

    public HttpResponse removePreferenceForHttpResponse(String key, Map<String, Object> params) throws IOException {
        // verify the required parameter 'key' is set
        if (key == null) {
            throw new IllegalArgumentException("Missing the required parameter 'key' when calling removePreference");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/mypreferences");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);
        // Add the required query param 'key' to the map of query params
        allParams.put("key", key);

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
    * Set locale
    * Deprecated, use [ Update a user profile](https://developer.atlassian.com/cloud/admin/user-management/rest/#api-users-account-id-manage-profile-patch) from the user management REST API instead.  Sets the locale of the user. The locale must be one supported by the instance of Jira.  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param locale The locale defined in a LocaleBean.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object setLocale(Locale locale) throws IOException {
        HttpResponse response = setLocaleForHttpResponse(locale);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Set locale
    * Deprecated, use [ Update a user profile](https://developer.atlassian.com/cloud/admin/user-management/rest/#api-users-account-id-manage-profile-patch) from the user management REST API instead.  Sets the locale of the user. The locale must be one supported by the instance of Jira.  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param locale The locale defined in a LocaleBean.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object setLocale(Locale locale, Map<String, Object> params) throws IOException {
        HttpResponse response = setLocaleForHttpResponse(locale, params);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse setLocaleForHttpResponse(Locale locale) throws IOException {
        // verify the required parameter 'locale' is set
        if (locale == null) {
            throw new IllegalArgumentException("Missing the required parameter 'locale' when calling setLocale");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/mypreferences/locale");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(locale);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse setLocaleForHttpResponse(java.io.InputStream locale, String mediaType) throws IOException {
          // verify the required parameter 'locale' is set
              if (locale == null) {
              throw new IllegalArgumentException("Missing the required parameter 'locale' when calling setLocale");
              }
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/mypreferences/locale");

              String localVarUrl = uriBuilder.build().toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = locale == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, locale);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse setLocaleForHttpResponse(Locale locale, Map<String, Object> params) throws IOException {
        // verify the required parameter 'locale' is set
        if (locale == null) {
            throw new IllegalArgumentException("Missing the required parameter 'locale' when calling setLocale");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/mypreferences/locale");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(locale);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }


  /**
    * Set preference
    * Creates a preference for the user or updates a preference&#39;s value by sending a plain text string. For example, &#x60;false&#x60;. An arbitrary preference can be created with the value containing up to 255 characters. In addition, the following keys define system preferences that can be set or created:   *  *user.notifications.mimetype* The mime type used in notifications sent to the user. Defaults to &#x60;html&#x60;.  *  *user.notify.own.changes* Whether the user gets notified of their own changes. Defaults to &#x60;false&#x60;.  *  *user.default.share.private* Whether new [ filters](https://confluence.atlassian.com/x/eQiiLQ) are set to private. Defaults to &#x60;true&#x60;.  *  *user.keyboard.shortcuts.disabled* Whether keyboard shortcuts are disabled. Defaults to &#x60;false&#x60;.  *  *user.autowatch.disabled* Whether the user automatically watches issues they create or add a comment to. By default, not set: the user takes the instance autowatch setting.  Note that these keys are deprecated:   *  *jira.user.locale* The locale of the user. By default, not set. The user takes the instance locale.  *  *jira.user.timezone* The time zone of the user. By default, not set. The user takes the instance timezone.  Use [ Update a user profile](https://developer.atlassian.com/cloud/admin/user-management/rest/#api-users-account-id-manage-profile-patch) from the user management REST API to manage timezone and locale instead.  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the key or value is not provided or invalid.
    * @param key The key of the preference. The maximum length is 255 characters.
    * @param body The value of the preference as a plain text string. The maximum length is 255 characters.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object setPreference(String key, String body) throws IOException {
        HttpResponse response = setPreferenceForHttpResponse(key, body);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Set preference
    * Creates a preference for the user or updates a preference&#39;s value by sending a plain text string. For example, &#x60;false&#x60;. An arbitrary preference can be created with the value containing up to 255 characters. In addition, the following keys define system preferences that can be set or created:   *  *user.notifications.mimetype* The mime type used in notifications sent to the user. Defaults to &#x60;html&#x60;.  *  *user.notify.own.changes* Whether the user gets notified of their own changes. Defaults to &#x60;false&#x60;.  *  *user.default.share.private* Whether new [ filters](https://confluence.atlassian.com/x/eQiiLQ) are set to private. Defaults to &#x60;true&#x60;.  *  *user.keyboard.shortcuts.disabled* Whether keyboard shortcuts are disabled. Defaults to &#x60;false&#x60;.  *  *user.autowatch.disabled* Whether the user automatically watches issues they create or add a comment to. By default, not set: the user takes the instance autowatch setting.  Note that these keys are deprecated:   *  *jira.user.locale* The locale of the user. By default, not set. The user takes the instance locale.  *  *jira.user.timezone* The time zone of the user. By default, not set. The user takes the instance timezone.  Use [ Update a user profile](https://developer.atlassian.com/cloud/admin/user-management/rest/#api-users-account-id-manage-profile-patch) from the user management REST API to manage timezone and locale instead.  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the key or value is not provided or invalid.
    * @param key The key of the preference. The maximum length is 255 characters.
    * @param body The value of the preference as a plain text string. The maximum length is 255 characters.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object setPreference(String key, String body, Map<String, Object> params) throws IOException {
        HttpResponse response = setPreferenceForHttpResponse(key, body, params);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse setPreferenceForHttpResponse(String key, String body) throws IOException {
        // verify the required parameter 'key' is set
        if (key == null) {
            throw new IllegalArgumentException("Missing the required parameter 'key' when calling setPreference");
        }// verify the required parameter 'body' is set
        if (body == null) {
            throw new IllegalArgumentException("Missing the required parameter 'body' when calling setPreference");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/mypreferences");
        if (key != null) {
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

        HttpContent content = apiClient.new JacksonJsonHttpContent(body);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse setPreferenceForHttpResponse(String key, java.io.InputStream body, String mediaType) throws IOException {
          // verify the required parameter 'key' is set
              if (key == null) {
              throw new IllegalArgumentException("Missing the required parameter 'key' when calling setPreference");
              }// verify the required parameter 'body' is set
              if (body == null) {
              throw new IllegalArgumentException("Missing the required parameter 'body' when calling setPreference");
              }
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/mypreferences");
              if (key != null) {
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

              HttpContent content = body == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, body);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse setPreferenceForHttpResponse(String key, String body, Map<String, Object> params) throws IOException {
        // verify the required parameter 'key' is set
        if (key == null) {
            throw new IllegalArgumentException("Missing the required parameter 'key' when calling setPreference");
        }// verify the required parameter 'body' is set
        if (body == null) {
            throw new IllegalArgumentException("Missing the required parameter 'body' when calling setPreference");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/mypreferences");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);
        // Add the required query param 'key' to the map of query params
        allParams.put("key", key);

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(body);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }


}
