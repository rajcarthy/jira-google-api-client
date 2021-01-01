package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.ScreenableTab;

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
public class ScreenTabsApi {
    private ApiClient apiClient;

    public ScreenTabsApi() {
        this(new ApiClient());
    }

    public ScreenTabsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Create screen tab
    * Creates a tab for a screen.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the screen is not found.
    * @param screenId The ID of the screen.
    * @param screenableTab The screenableTab parameter
    * @return ScreenableTab
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ScreenableTab addScreenTab(Long screenId, ScreenableTab screenableTab) throws IOException {
        HttpResponse response = addScreenTabForHttpResponse(screenId, screenableTab);
        TypeReference<ScreenableTab> typeRef = new TypeReference<ScreenableTab>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Create screen tab
    * Creates a tab for a screen.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the screen is not found.
    * @param screenId The ID of the screen.
    * @param screenableTab The screenableTab parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return ScreenableTab
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ScreenableTab addScreenTab(Long screenId, ScreenableTab screenableTab, Map<String, Object> params) throws IOException {
        HttpResponse response = addScreenTabForHttpResponse(screenId, screenableTab, params);
        TypeReference<ScreenableTab> typeRef = new TypeReference<ScreenableTab>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse addScreenTabForHttpResponse(Long screenId, ScreenableTab screenableTab) throws IOException {
        // verify the required parameter 'screenId' is set
        if (screenId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'screenId' when calling addScreenTab");
        }// verify the required parameter 'screenableTab' is set
        if (screenableTab == null) {
            throw new IllegalArgumentException("Missing the required parameter 'screenableTab' when calling addScreenTab");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("screenId", screenId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/screens/{screenId}/tabs");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(screenableTab);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse addScreenTabForHttpResponse(Long screenId, java.io.InputStream screenableTab, String mediaType) throws IOException {
          // verify the required parameter 'screenId' is set
              if (screenId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'screenId' when calling addScreenTab");
              }// verify the required parameter 'screenableTab' is set
              if (screenableTab == null) {
              throw new IllegalArgumentException("Missing the required parameter 'screenableTab' when calling addScreenTab");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("screenId", screenId);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/screens/{screenId}/tabs");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = screenableTab == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, screenableTab);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse addScreenTabForHttpResponse(Long screenId, ScreenableTab screenableTab, Map<String, Object> params) throws IOException {
        // verify the required parameter 'screenId' is set
        if (screenId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'screenId' when calling addScreenTab");
        }// verify the required parameter 'screenableTab' is set
        if (screenableTab == null) {
            throw new IllegalArgumentException("Missing the required parameter 'screenableTab' when calling addScreenTab");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("screenId", screenId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/screens/{screenId}/tabs");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(screenableTab);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


  /**
    * Delete screen tab
    * Deletes a screen tab.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the screen or screen tab is not found.
    * @param screenId The ID of the screen.
    * @param tabId The ID of the screen tab.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteScreenTab(Long screenId, Long tabId) throws IOException {
        deleteScreenTabForHttpResponse(screenId, tabId);
    }

  /**
    * Delete screen tab
    * Deletes a screen tab.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the screen or screen tab is not found.
    * @param screenId The ID of the screen.
    * @param tabId The ID of the screen tab.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteScreenTab(Long screenId, Long tabId, Map<String, Object> params) throws IOException {
        deleteScreenTabForHttpResponse(screenId, tabId, params);
    }

    public HttpResponse deleteScreenTabForHttpResponse(Long screenId, Long tabId) throws IOException {
        // verify the required parameter 'screenId' is set
        if (screenId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'screenId' when calling deleteScreenTab");
        }// verify the required parameter 'tabId' is set
        if (tabId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'tabId' when calling deleteScreenTab");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("screenId", screenId);
        uriVariables.put("tabId", tabId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/screens/{screenId}/tabs/{tabId}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }

    public HttpResponse deleteScreenTabForHttpResponse(Long screenId, Long tabId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'screenId' is set
        if (screenId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'screenId' when calling deleteScreenTab");
        }// verify the required parameter 'tabId' is set
        if (tabId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'tabId' when calling deleteScreenTab");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("screenId", screenId);
        uriVariables.put("tabId", tabId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/screens/{screenId}/tabs/{tabId}");

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
    * Get all screen tabs
    * Returns the list of tabs for a screen.  **[Permissions](#permissions) required:**   *  *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).  *  *Administer projects* [project permission](https://confluence.atlassian.com/x/yodKLg) when the project key is specified, providing that the screen is associated with the project through a Screen Scheme and Issue Type Screen Scheme.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the screen ID is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the screen is not found.
    * @param screenId The ID of the screen.
    * @param projectKey The key of the project.
    * @return List&lt;ScreenableTab&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<ScreenableTab> getAllScreenTabs(Long screenId, String projectKey) throws IOException {
        HttpResponse response = getAllScreenTabsForHttpResponse(screenId, projectKey);
        TypeReference<List<ScreenableTab>> typeRef = new TypeReference<List<ScreenableTab>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get all screen tabs
    * Returns the list of tabs for a screen.  **[Permissions](#permissions) required:**   *  *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).  *  *Administer projects* [project permission](https://confluence.atlassian.com/x/yodKLg) when the project key is specified, providing that the screen is associated with the project through a Screen Scheme and Issue Type Screen Scheme.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the screen ID is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the screen is not found.
    * @param screenId The ID of the screen.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return List&lt;ScreenableTab&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<ScreenableTab> getAllScreenTabs(Long screenId, Map<String, Object> params) throws IOException {
        HttpResponse response = getAllScreenTabsForHttpResponse(screenId, params);
        TypeReference<List<ScreenableTab>> typeRef = new TypeReference<List<ScreenableTab>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getAllScreenTabsForHttpResponse(Long screenId, String projectKey) throws IOException {
        // verify the required parameter 'screenId' is set
        if (screenId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'screenId' when calling getAllScreenTabs");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("screenId", screenId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/screens/{screenId}/tabs");
        if (projectKey != null) {
            String key = "projectKey";
            Object value = projectKey;
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

    public HttpResponse getAllScreenTabsForHttpResponse(Long screenId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'screenId' is set
        if (screenId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'screenId' when calling getAllScreenTabs");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("screenId", screenId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/screens/{screenId}/tabs");

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
    * Move screen tab
    * Moves a screen tab.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the screen or screen tab is not found or the position is invalid.
    * @param screenId The ID of the screen.
    * @param tabId The ID of the screen tab.
    * @param pos The position of tab. The base index is 0.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object moveScreenTab(Long screenId, Long tabId, Integer pos) throws IOException {
        HttpResponse response = moveScreenTabForHttpResponse(screenId, tabId, pos);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Move screen tab
    * Moves a screen tab.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the screen or screen tab is not found or the position is invalid.
    * @param screenId The ID of the screen.
    * @param tabId The ID of the screen tab.
    * @param pos The position of tab. The base index is 0.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object moveScreenTab(Long screenId, Long tabId, Integer pos, Map<String, Object> params) throws IOException {
        HttpResponse response = moveScreenTabForHttpResponse(screenId, tabId, pos, params);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse moveScreenTabForHttpResponse(Long screenId, Long tabId, Integer pos) throws IOException {
        // verify the required parameter 'screenId' is set
        if (screenId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'screenId' when calling moveScreenTab");
        }// verify the required parameter 'tabId' is set
        if (tabId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'tabId' when calling moveScreenTab");
        }// verify the required parameter 'pos' is set
        if (pos == null) {
            throw new IllegalArgumentException("Missing the required parameter 'pos' when calling moveScreenTab");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("screenId", screenId);
        uriVariables.put("tabId", tabId);
        uriVariables.put("pos", pos);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/screens/{screenId}/tabs/{tabId}/move/{pos}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = new EmptyContent();
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

    public HttpResponse moveScreenTabForHttpResponse(Long screenId, Long tabId, Integer pos, Map<String, Object> params) throws IOException {
        // verify the required parameter 'screenId' is set
        if (screenId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'screenId' when calling moveScreenTab");
        }// verify the required parameter 'tabId' is set
        if (tabId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'tabId' when calling moveScreenTab");
        }// verify the required parameter 'pos' is set
        if (pos == null) {
            throw new IllegalArgumentException("Missing the required parameter 'pos' when calling moveScreenTab");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("screenId", screenId);
        uriVariables.put("tabId", tabId);
        uriVariables.put("pos", pos);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/screens/{screenId}/tabs/{tabId}/move/{pos}");

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

        HttpContent content = new EmptyContent();
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


  /**
    * Update screen tab
    * Updates the name of a screen tab.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the screen or screen tab is not found.
    * @param screenId The ID of the screen.
    * @param tabId The ID of the screen tab.
    * @param screenableTab The screenableTab parameter
    * @return ScreenableTab
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ScreenableTab renameScreenTab(Long screenId, Long tabId, ScreenableTab screenableTab) throws IOException {
        HttpResponse response = renameScreenTabForHttpResponse(screenId, tabId, screenableTab);
        TypeReference<ScreenableTab> typeRef = new TypeReference<ScreenableTab>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Update screen tab
    * Updates the name of a screen tab.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the screen or screen tab is not found.
    * @param screenId The ID of the screen.
    * @param tabId The ID of the screen tab.
    * @param screenableTab The screenableTab parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return ScreenableTab
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ScreenableTab renameScreenTab(Long screenId, Long tabId, ScreenableTab screenableTab, Map<String, Object> params) throws IOException {
        HttpResponse response = renameScreenTabForHttpResponse(screenId, tabId, screenableTab, params);
        TypeReference<ScreenableTab> typeRef = new TypeReference<ScreenableTab>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse renameScreenTabForHttpResponse(Long screenId, Long tabId, ScreenableTab screenableTab) throws IOException {
        // verify the required parameter 'screenId' is set
        if (screenId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'screenId' when calling renameScreenTab");
        }// verify the required parameter 'tabId' is set
        if (tabId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'tabId' when calling renameScreenTab");
        }// verify the required parameter 'screenableTab' is set
        if (screenableTab == null) {
            throw new IllegalArgumentException("Missing the required parameter 'screenableTab' when calling renameScreenTab");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("screenId", screenId);
        uriVariables.put("tabId", tabId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/screens/{screenId}/tabs/{tabId}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(screenableTab);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse renameScreenTabForHttpResponse(Long screenId, Long tabId, java.io.InputStream screenableTab, String mediaType) throws IOException {
          // verify the required parameter 'screenId' is set
              if (screenId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'screenId' when calling renameScreenTab");
              }// verify the required parameter 'tabId' is set
              if (tabId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'tabId' when calling renameScreenTab");
              }// verify the required parameter 'screenableTab' is set
              if (screenableTab == null) {
              throw new IllegalArgumentException("Missing the required parameter 'screenableTab' when calling renameScreenTab");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("screenId", screenId);
                      uriVariables.put("tabId", tabId);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/screens/{screenId}/tabs/{tabId}");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = screenableTab == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, screenableTab);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse renameScreenTabForHttpResponse(Long screenId, Long tabId, ScreenableTab screenableTab, Map<String, Object> params) throws IOException {
        // verify the required parameter 'screenId' is set
        if (screenId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'screenId' when calling renameScreenTab");
        }// verify the required parameter 'tabId' is set
        if (tabId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'tabId' when calling renameScreenTab");
        }// verify the required parameter 'screenableTab' is set
        if (screenableTab == null) {
            throw new IllegalArgumentException("Missing the required parameter 'screenableTab' when calling renameScreenTab");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("screenId", screenId);
        uriVariables.put("tabId", tabId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/screens/{screenId}/tabs/{tabId}");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(screenableTab);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }


}
