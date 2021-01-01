package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.PageBeanScreenScheme;
import com.atlassian.jira.rest.client.model.ScreenSchemeDetails;
import com.atlassian.jira.rest.client.model.ScreenSchemeId;
import java.util.Set;
import com.atlassian.jira.rest.client.model.UpdateScreenSchemeDetails;

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
public class ScreenSchemesApi {
    private ApiClient apiClient;

    public ScreenSchemesApi() {
        this(new ApiClient());
    }

    public ScreenSchemesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Create screen scheme
    * Creates a screen scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>201</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * <p><b>404</b> - Returned if a screen used as one of the screen types in the screen scheme is not found.
    * @param screenSchemeDetails The screenSchemeDetails parameter
    * @return ScreenSchemeId
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ScreenSchemeId createScreenScheme(ScreenSchemeDetails screenSchemeDetails) throws IOException {
        HttpResponse response = createScreenSchemeForHttpResponse(screenSchemeDetails);
        TypeReference<ScreenSchemeId> typeRef = new TypeReference<ScreenSchemeId>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Create screen scheme
    * Creates a screen scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>201</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * <p><b>404</b> - Returned if a screen used as one of the screen types in the screen scheme is not found.
    * @param screenSchemeDetails The screenSchemeDetails parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return ScreenSchemeId
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ScreenSchemeId createScreenScheme(ScreenSchemeDetails screenSchemeDetails, Map<String, Object> params) throws IOException {
        HttpResponse response = createScreenSchemeForHttpResponse(screenSchemeDetails, params);
        TypeReference<ScreenSchemeId> typeRef = new TypeReference<ScreenSchemeId>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse createScreenSchemeForHttpResponse(ScreenSchemeDetails screenSchemeDetails) throws IOException {
        // verify the required parameter 'screenSchemeDetails' is set
        if (screenSchemeDetails == null) {
            throw new IllegalArgumentException("Missing the required parameter 'screenSchemeDetails' when calling createScreenScheme");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/screenscheme");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(screenSchemeDetails);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse createScreenSchemeForHttpResponse(java.io.InputStream screenSchemeDetails, String mediaType) throws IOException {
          // verify the required parameter 'screenSchemeDetails' is set
              if (screenSchemeDetails == null) {
              throw new IllegalArgumentException("Missing the required parameter 'screenSchemeDetails' when calling createScreenScheme");
              }
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/screenscheme");

              String localVarUrl = uriBuilder.build().toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = screenSchemeDetails == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, screenSchemeDetails);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse createScreenSchemeForHttpResponse(ScreenSchemeDetails screenSchemeDetails, Map<String, Object> params) throws IOException {
        // verify the required parameter 'screenSchemeDetails' is set
        if (screenSchemeDetails == null) {
            throw new IllegalArgumentException("Missing the required parameter 'screenSchemeDetails' when calling createScreenScheme");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/screenscheme");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(screenSchemeDetails);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


  /**
    * Delete screen scheme
    * Deletes a screen scheme. A screen scheme cannot be deleted if it is used in an issue type screen scheme.  Only screens schemes used in classic projects can be deleted.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the screen scheme is deleted.
    * <p><b>400</b> - Returned if the screen scheme is used in an issue type screen scheme.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the screen scheme is not found.
    * @param screenSchemeId The ID of the screen scheme.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteScreenScheme(String screenSchemeId) throws IOException {
        deleteScreenSchemeForHttpResponse(screenSchemeId);
    }

  /**
    * Delete screen scheme
    * Deletes a screen scheme. A screen scheme cannot be deleted if it is used in an issue type screen scheme.  Only screens schemes used in classic projects can be deleted.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the screen scheme is deleted.
    * <p><b>400</b> - Returned if the screen scheme is used in an issue type screen scheme.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the screen scheme is not found.
    * @param screenSchemeId The ID of the screen scheme.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteScreenScheme(String screenSchemeId, Map<String, Object> params) throws IOException {
        deleteScreenSchemeForHttpResponse(screenSchemeId, params);
    }

    public HttpResponse deleteScreenSchemeForHttpResponse(String screenSchemeId) throws IOException {
        // verify the required parameter 'screenSchemeId' is set
        if (screenSchemeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'screenSchemeId' when calling deleteScreenScheme");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("screenSchemeId", screenSchemeId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/screenscheme/{screenSchemeId}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }

    public HttpResponse deleteScreenSchemeForHttpResponse(String screenSchemeId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'screenSchemeId' is set
        if (screenSchemeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'screenSchemeId' when calling deleteScreenScheme");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("screenSchemeId", screenSchemeId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/screenscheme/{screenSchemeId}");

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
    * Get screen schemes
    * Returns a [paginated](#pagination) list of screen schemes.  Only screen schemes used in classic projects are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * @param startAt The index of the first item to return in a page of results (page offset).
    * @param maxResults The maximum number of items to return per page.
    * @param id The list of screen scheme IDs. To include multiple IDs, provide an ampersand-separated list. For example, &#x60;id&#x3D;10000&amp;id&#x3D;10001&#x60;.
    * @return PageBeanScreenScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanScreenScheme getScreenSchemes(Long startAt, Integer maxResults, Set<Long> id) throws IOException {
        HttpResponse response = getScreenSchemesForHttpResponse(startAt, maxResults, id);
        TypeReference<PageBeanScreenScheme> typeRef = new TypeReference<PageBeanScreenScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get screen schemes
    * Returns a [paginated](#pagination) list of screen schemes.  Only screen schemes used in classic projects are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PageBeanScreenScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanScreenScheme getScreenSchemes(Map<String, Object> params) throws IOException {
        HttpResponse response = getScreenSchemesForHttpResponse(params);
        TypeReference<PageBeanScreenScheme> typeRef = new TypeReference<PageBeanScreenScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getScreenSchemesForHttpResponse(Long startAt, Integer maxResults, Set<Long> id) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/screenscheme");
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

    public HttpResponse getScreenSchemesForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/screenscheme");

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
    * Update screen scheme
    * Updates a screen scheme. Only screen schemes used in classic projects can be updated.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * <p><b>404</b> - Returned if the screen scheme or a screen used as one of the screen types is not found.
    * @param screenSchemeId The ID of the screen scheme.
    * @param updateScreenSchemeDetails The screen scheme update details.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object updateScreenScheme(String screenSchemeId, UpdateScreenSchemeDetails updateScreenSchemeDetails) throws IOException {
        HttpResponse response = updateScreenSchemeForHttpResponse(screenSchemeId, updateScreenSchemeDetails);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Update screen scheme
    * Updates a screen scheme. Only screen schemes used in classic projects can be updated.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * <p><b>404</b> - Returned if the screen scheme or a screen used as one of the screen types is not found.
    * @param screenSchemeId The ID of the screen scheme.
    * @param updateScreenSchemeDetails The screen scheme update details.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object updateScreenScheme(String screenSchemeId, UpdateScreenSchemeDetails updateScreenSchemeDetails, Map<String, Object> params) throws IOException {
        HttpResponse response = updateScreenSchemeForHttpResponse(screenSchemeId, updateScreenSchemeDetails, params);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse updateScreenSchemeForHttpResponse(String screenSchemeId, UpdateScreenSchemeDetails updateScreenSchemeDetails) throws IOException {
        // verify the required parameter 'screenSchemeId' is set
        if (screenSchemeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'screenSchemeId' when calling updateScreenScheme");
        }// verify the required parameter 'updateScreenSchemeDetails' is set
        if (updateScreenSchemeDetails == null) {
            throw new IllegalArgumentException("Missing the required parameter 'updateScreenSchemeDetails' when calling updateScreenScheme");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("screenSchemeId", screenSchemeId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/screenscheme/{screenSchemeId}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(updateScreenSchemeDetails);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse updateScreenSchemeForHttpResponse(String screenSchemeId, java.io.InputStream updateScreenSchemeDetails, String mediaType) throws IOException {
          // verify the required parameter 'screenSchemeId' is set
              if (screenSchemeId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'screenSchemeId' when calling updateScreenScheme");
              }// verify the required parameter 'updateScreenSchemeDetails' is set
              if (updateScreenSchemeDetails == null) {
              throw new IllegalArgumentException("Missing the required parameter 'updateScreenSchemeDetails' when calling updateScreenScheme");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("screenSchemeId", screenSchemeId);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/screenscheme/{screenSchemeId}");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = updateScreenSchemeDetails == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, updateScreenSchemeDetails);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse updateScreenSchemeForHttpResponse(String screenSchemeId, UpdateScreenSchemeDetails updateScreenSchemeDetails, Map<String, Object> params) throws IOException {
        // verify the required parameter 'screenSchemeId' is set
        if (screenSchemeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'screenSchemeId' when calling updateScreenScheme");
        }// verify the required parameter 'updateScreenSchemeDetails' is set
        if (updateScreenSchemeDetails == null) {
            throw new IllegalArgumentException("Missing the required parameter 'updateScreenSchemeDetails' when calling updateScreenScheme");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("screenSchemeId", screenSchemeId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/screenscheme/{screenSchemeId}");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(updateScreenSchemeDetails);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }


}
