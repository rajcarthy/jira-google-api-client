package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.PageBeanScreen;
import com.atlassian.jira.rest.client.model.Screen;
import com.atlassian.jira.rest.client.model.ScreenDetails;
import com.atlassian.jira.rest.client.model.ScreenableField;
import java.util.Set;
import com.atlassian.jira.rest.client.model.UpdateScreenDetails;

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
public class ScreensApi {
    private ApiClient apiClient;

    public ScreensApi() {
        this(new ApiClient());
    }

    public ScreensApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Add field to default screen
    * Adds a field to the default tab of the default screen.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the field it not found or the field is already present.
    * @param fieldId The ID of the field.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object addFieldToDefaultScreen(String fieldId) throws IOException {
        HttpResponse response = addFieldToDefaultScreenForHttpResponse(fieldId);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Add field to default screen
    * Adds a field to the default tab of the default screen.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the field it not found or the field is already present.
    * @param fieldId The ID of the field.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object addFieldToDefaultScreen(String fieldId, Map<String, Object> params) throws IOException {
        HttpResponse response = addFieldToDefaultScreenForHttpResponse(fieldId, params);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse addFieldToDefaultScreenForHttpResponse(String fieldId) throws IOException {
        // verify the required parameter 'fieldId' is set
        if (fieldId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldId' when calling addFieldToDefaultScreen");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldId", fieldId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/screens/addToDefault/{fieldId}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = new EmptyContent();
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

    public HttpResponse addFieldToDefaultScreenForHttpResponse(String fieldId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'fieldId' is set
        if (fieldId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldId' when calling addFieldToDefaultScreen");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldId", fieldId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/screens/addToDefault/{fieldId}");

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
    * Create screen
    * Creates a screen with a default field tab.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>201</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * @param screenDetails The screenDetails parameter
    * @return Screen
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Screen createScreen(ScreenDetails screenDetails) throws IOException {
        HttpResponse response = createScreenForHttpResponse(screenDetails);
        TypeReference<Screen> typeRef = new TypeReference<Screen>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Create screen
    * Creates a screen with a default field tab.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>201</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * @param screenDetails The screenDetails parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Screen
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Screen createScreen(ScreenDetails screenDetails, Map<String, Object> params) throws IOException {
        HttpResponse response = createScreenForHttpResponse(screenDetails, params);
        TypeReference<Screen> typeRef = new TypeReference<Screen>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse createScreenForHttpResponse(ScreenDetails screenDetails) throws IOException {
        // verify the required parameter 'screenDetails' is set
        if (screenDetails == null) {
            throw new IllegalArgumentException("Missing the required parameter 'screenDetails' when calling createScreen");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/screens");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(screenDetails);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse createScreenForHttpResponse(java.io.InputStream screenDetails, String mediaType) throws IOException {
          // verify the required parameter 'screenDetails' is set
              if (screenDetails == null) {
              throw new IllegalArgumentException("Missing the required parameter 'screenDetails' when calling createScreen");
              }
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/screens");

              String localVarUrl = uriBuilder.build().toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = screenDetails == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, screenDetails);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse createScreenForHttpResponse(ScreenDetails screenDetails, Map<String, Object> params) throws IOException {
        // verify the required parameter 'screenDetails' is set
        if (screenDetails == null) {
            throw new IllegalArgumentException("Missing the required parameter 'screenDetails' when calling createScreen");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/screens");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(screenDetails);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


  /**
    * Delete screen
    * Deletes a screen. A screen cannot be deleted if it is used in a screen scheme, workflow, or workflow draft.  Only screens used in classic projects can be deleted.
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the screen is not found.
    * @param screenId The ID of the screen.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteScreen(Long screenId) throws IOException {
        deleteScreenForHttpResponse(screenId);
    }

  /**
    * Delete screen
    * Deletes a screen. A screen cannot be deleted if it is used in a screen scheme, workflow, or workflow draft.  Only screens used in classic projects can be deleted.
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the screen is not found.
    * @param screenId The ID of the screen.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteScreen(Long screenId, Map<String, Object> params) throws IOException {
        deleteScreenForHttpResponse(screenId, params);
    }

    public HttpResponse deleteScreenForHttpResponse(Long screenId) throws IOException {
        // verify the required parameter 'screenId' is set
        if (screenId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'screenId' when calling deleteScreen");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("screenId", screenId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/screens/{screenId}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }

    public HttpResponse deleteScreenForHttpResponse(Long screenId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'screenId' is set
        if (screenId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'screenId' when calling deleteScreen");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("screenId", screenId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/screens/{screenId}");

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
    * Get available screen fields
    * Returns the fields that can be added to a tab on a screen.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the screen is not found.
    * @param screenId The ID of the screen.
    * @return List&lt;ScreenableField&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<ScreenableField> getAvailableScreenFields(Long screenId) throws IOException {
        HttpResponse response = getAvailableScreenFieldsForHttpResponse(screenId);
        TypeReference<List<ScreenableField>> typeRef = new TypeReference<List<ScreenableField>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get available screen fields
    * Returns the fields that can be added to a tab on a screen.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the screen is not found.
    * @param screenId The ID of the screen.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return List&lt;ScreenableField&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<ScreenableField> getAvailableScreenFields(Long screenId, Map<String, Object> params) throws IOException {
        HttpResponse response = getAvailableScreenFieldsForHttpResponse(screenId, params);
        TypeReference<List<ScreenableField>> typeRef = new TypeReference<List<ScreenableField>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getAvailableScreenFieldsForHttpResponse(Long screenId) throws IOException {
        // verify the required parameter 'screenId' is set
        if (screenId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'screenId' when calling getAvailableScreenFields");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("screenId", screenId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/screens/{screenId}/availableFields");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getAvailableScreenFieldsForHttpResponse(Long screenId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'screenId' is set
        if (screenId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'screenId' when calling getAvailableScreenFields");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("screenId", screenId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/screens/{screenId}/availableFields");

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
    * Get screens
    * Returns a [paginated](#pagination) list of all screens or those specified by one or more screen IDs.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * @param startAt The index of the first item to return in a page of results (page offset).
    * @param maxResults The maximum number of items to return per page.
    * @param id The list of screen IDs. To include multiple IDs, provide an ampersand-separated list. For example, &#x60;id&#x3D;10000&amp;id&#x3D;10001&#x60;.
    * @return PageBeanScreen
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanScreen getScreens(Long startAt, Integer maxResults, Set<Long> id) throws IOException {
        HttpResponse response = getScreensForHttpResponse(startAt, maxResults, id);
        TypeReference<PageBeanScreen> typeRef = new TypeReference<PageBeanScreen>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get screens
    * Returns a [paginated](#pagination) list of all screens or those specified by one or more screen IDs.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PageBeanScreen
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanScreen getScreens(Map<String, Object> params) throws IOException {
        HttpResponse response = getScreensForHttpResponse(params);
        TypeReference<PageBeanScreen> typeRef = new TypeReference<PageBeanScreen>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getScreensForHttpResponse(Long startAt, Integer maxResults, Set<Long> id) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/screens");
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
        }        if (id != null) {
            String key = "id";
            Object value = id;
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

    public HttpResponse getScreensForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/screens");

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
    * Get screens for a field
    * Returns a [paginated](#pagination) list of the screens a field is used in.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * @param fieldId The ID of the field to return screens for.
    * @param startAt The index of the first item to return in a page of results (page offset).
    * @param maxResults The maximum number of items to return per page.
    * @return PageBeanScreen
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanScreen getScreensForField(String fieldId, Long startAt, Integer maxResults) throws IOException {
        HttpResponse response = getScreensForFieldForHttpResponse(fieldId, startAt, maxResults);
        TypeReference<PageBeanScreen> typeRef = new TypeReference<PageBeanScreen>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get screens for a field
    * Returns a [paginated](#pagination) list of the screens a field is used in.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * @param fieldId The ID of the field to return screens for.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PageBeanScreen
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanScreen getScreensForField(String fieldId, Map<String, Object> params) throws IOException {
        HttpResponse response = getScreensForFieldForHttpResponse(fieldId, params);
        TypeReference<PageBeanScreen> typeRef = new TypeReference<PageBeanScreen>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getScreensForFieldForHttpResponse(String fieldId, Long startAt, Integer maxResults) throws IOException {
        // verify the required parameter 'fieldId' is set
        if (fieldId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldId' when calling getScreensForField");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldId", fieldId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldId}/screens");
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

    public HttpResponse getScreensForFieldForHttpResponse(String fieldId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'fieldId' is set
        if (fieldId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldId' when calling getScreensForField");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldId", fieldId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldId}/screens");

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
    * Update screen
    * Updates a screen. Only screens used in classic projects can be updated.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the screen is not found.
    * @param screenId The ID of the screen.
    * @param updateScreenDetails The updateScreenDetails parameter
    * @return Screen
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Screen updateScreen(Long screenId, UpdateScreenDetails updateScreenDetails) throws IOException {
        HttpResponse response = updateScreenForHttpResponse(screenId, updateScreenDetails);
        TypeReference<Screen> typeRef = new TypeReference<Screen>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Update screen
    * Updates a screen. Only screens used in classic projects can be updated.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the screen is not found.
    * @param screenId The ID of the screen.
    * @param updateScreenDetails The updateScreenDetails parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Screen
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Screen updateScreen(Long screenId, UpdateScreenDetails updateScreenDetails, Map<String, Object> params) throws IOException {
        HttpResponse response = updateScreenForHttpResponse(screenId, updateScreenDetails, params);
        TypeReference<Screen> typeRef = new TypeReference<Screen>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse updateScreenForHttpResponse(Long screenId, UpdateScreenDetails updateScreenDetails) throws IOException {
        // verify the required parameter 'screenId' is set
        if (screenId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'screenId' when calling updateScreen");
        }// verify the required parameter 'updateScreenDetails' is set
        if (updateScreenDetails == null) {
            throw new IllegalArgumentException("Missing the required parameter 'updateScreenDetails' when calling updateScreen");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("screenId", screenId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/screens/{screenId}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(updateScreenDetails);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse updateScreenForHttpResponse(Long screenId, java.io.InputStream updateScreenDetails, String mediaType) throws IOException {
          // verify the required parameter 'screenId' is set
              if (screenId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'screenId' when calling updateScreen");
              }// verify the required parameter 'updateScreenDetails' is set
              if (updateScreenDetails == null) {
              throw new IllegalArgumentException("Missing the required parameter 'updateScreenDetails' when calling updateScreen");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("screenId", screenId);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/screens/{screenId}");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = updateScreenDetails == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, updateScreenDetails);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse updateScreenForHttpResponse(Long screenId, UpdateScreenDetails updateScreenDetails, Map<String, Object> params) throws IOException {
        // verify the required parameter 'screenId' is set
        if (screenId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'screenId' when calling updateScreen");
        }// verify the required parameter 'updateScreenDetails' is set
        if (updateScreenDetails == null) {
            throw new IllegalArgumentException("Missing the required parameter 'updateScreenDetails' when calling updateScreen");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("screenId", screenId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/screens/{screenId}");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(updateScreenDetails);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }


}
