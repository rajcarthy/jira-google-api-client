package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.IssueLinkType;
import com.atlassian.jira.rest.client.model.IssueLinkTypes;

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
public class IssueLinkTypesApi {
    private ApiClient apiClient;

    public IssueLinkTypesApi() {
        this(new ApiClient());
    }

    public IssueLinkTypesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Create issue link type
    * Creates an issue link type. Use this operation to create descriptions of the reasons why issues are linked. The issue link type consists of a name and descriptions for a link&#39;s inward and outward relationships.  To use this operation, the site must have [issue linking](https://confluence.atlassian.com/x/yoXKM) enabled.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>201</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if:   *  issue linking is disabled.  *  the issue link type name is in use.  *  the user does not have the required permissions.
    * @param issueLinkType The issueLinkType parameter
    * @return IssueLinkType
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public IssueLinkType createIssueLinkType(IssueLinkType issueLinkType) throws IOException {
        HttpResponse response = createIssueLinkTypeForHttpResponse(issueLinkType);
        TypeReference<IssueLinkType> typeRef = new TypeReference<IssueLinkType>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Create issue link type
    * Creates an issue link type. Use this operation to create descriptions of the reasons why issues are linked. The issue link type consists of a name and descriptions for a link&#39;s inward and outward relationships.  To use this operation, the site must have [issue linking](https://confluence.atlassian.com/x/yoXKM) enabled.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>201</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if:   *  issue linking is disabled.  *  the issue link type name is in use.  *  the user does not have the required permissions.
    * @param issueLinkType The issueLinkType parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return IssueLinkType
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public IssueLinkType createIssueLinkType(IssueLinkType issueLinkType, Map<String, Object> params) throws IOException {
        HttpResponse response = createIssueLinkTypeForHttpResponse(issueLinkType, params);
        TypeReference<IssueLinkType> typeRef = new TypeReference<IssueLinkType>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse createIssueLinkTypeForHttpResponse(IssueLinkType issueLinkType) throws IOException {
        // verify the required parameter 'issueLinkType' is set
        if (issueLinkType == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueLinkType' when calling createIssueLinkType");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issueLinkType");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(issueLinkType);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse createIssueLinkTypeForHttpResponse(java.io.InputStream issueLinkType, String mediaType) throws IOException {
          // verify the required parameter 'issueLinkType' is set
              if (issueLinkType == null) {
              throw new IllegalArgumentException("Missing the required parameter 'issueLinkType' when calling createIssueLinkType");
              }
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issueLinkType");

              String localVarUrl = uriBuilder.build().toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = issueLinkType == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, issueLinkType);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse createIssueLinkTypeForHttpResponse(IssueLinkType issueLinkType, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueLinkType' is set
        if (issueLinkType == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueLinkType' when calling createIssueLinkType");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issueLinkType");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(issueLinkType);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


  /**
    * Delete issue link type
    * Deletes an issue link type.  To use this operation, the site must have [issue linking](https://confluence.atlassian.com/x/yoXKM) enabled.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the issue link type ID is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if:   *  issue linking is disabled.  *  the issue link type is not found.  *  the user does not have the required permissions.
    * @param issueLinkTypeId The ID of the issue link type.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteIssueLinkType(String issueLinkTypeId) throws IOException {
        deleteIssueLinkTypeForHttpResponse(issueLinkTypeId);
    }

  /**
    * Delete issue link type
    * Deletes an issue link type.  To use this operation, the site must have [issue linking](https://confluence.atlassian.com/x/yoXKM) enabled.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the issue link type ID is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if:   *  issue linking is disabled.  *  the issue link type is not found.  *  the user does not have the required permissions.
    * @param issueLinkTypeId The ID of the issue link type.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteIssueLinkType(String issueLinkTypeId, Map<String, Object> params) throws IOException {
        deleteIssueLinkTypeForHttpResponse(issueLinkTypeId, params);
    }

    public HttpResponse deleteIssueLinkTypeForHttpResponse(String issueLinkTypeId) throws IOException {
        // verify the required parameter 'issueLinkTypeId' is set
        if (issueLinkTypeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueLinkTypeId' when calling deleteIssueLinkType");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueLinkTypeId", issueLinkTypeId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issueLinkType/{issueLinkTypeId}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }

    public HttpResponse deleteIssueLinkTypeForHttpResponse(String issueLinkTypeId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueLinkTypeId' is set
        if (issueLinkTypeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueLinkTypeId' when calling deleteIssueLinkType");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueLinkTypeId", issueLinkTypeId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issueLinkType/{issueLinkTypeId}");

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
    * Get issue link type
    * Returns an issue link type.  To use this operation, the site must have [issue linking](https://confluence.atlassian.com/x/yoXKM) enabled.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for a project in the site.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the issue link type ID is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if:   *  issue linking is disabled.  *  the issue link type is not found.  *  the user does not have the required permissions.
    * @param issueLinkTypeId The ID of the issue link type.
    * @return IssueLinkType
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public IssueLinkType getIssueLinkType(String issueLinkTypeId) throws IOException {
        HttpResponse response = getIssueLinkTypeForHttpResponse(issueLinkTypeId);
        TypeReference<IssueLinkType> typeRef = new TypeReference<IssueLinkType>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get issue link type
    * Returns an issue link type.  To use this operation, the site must have [issue linking](https://confluence.atlassian.com/x/yoXKM) enabled.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for a project in the site.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the issue link type ID is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if:   *  issue linking is disabled.  *  the issue link type is not found.  *  the user does not have the required permissions.
    * @param issueLinkTypeId The ID of the issue link type.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return IssueLinkType
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public IssueLinkType getIssueLinkType(String issueLinkTypeId, Map<String, Object> params) throws IOException {
        HttpResponse response = getIssueLinkTypeForHttpResponse(issueLinkTypeId, params);
        TypeReference<IssueLinkType> typeRef = new TypeReference<IssueLinkType>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getIssueLinkTypeForHttpResponse(String issueLinkTypeId) throws IOException {
        // verify the required parameter 'issueLinkTypeId' is set
        if (issueLinkTypeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueLinkTypeId' when calling getIssueLinkType");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueLinkTypeId", issueLinkTypeId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issueLinkType/{issueLinkTypeId}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getIssueLinkTypeForHttpResponse(String issueLinkTypeId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueLinkTypeId' is set
        if (issueLinkTypeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueLinkTypeId' when calling getIssueLinkType");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueLinkTypeId", issueLinkTypeId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issueLinkType/{issueLinkTypeId}");

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
    * Get issue link types
    * Returns a list of all issue link types.  To use this operation, the site must have [issue linking](https://confluence.atlassian.com/x/yoXKM) enabled.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for a project in the site.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if issue linking is disabled.
    * @return IssueLinkTypes
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public IssueLinkTypes getIssueLinkTypes() throws IOException {
        HttpResponse response = getIssueLinkTypesForHttpResponse();
        TypeReference<IssueLinkTypes> typeRef = new TypeReference<IssueLinkTypes>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get issue link types
    * Returns a list of all issue link types.  To use this operation, the site must have [issue linking](https://confluence.atlassian.com/x/yoXKM) enabled.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for a project in the site.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if issue linking is disabled.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return IssueLinkTypes
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public IssueLinkTypes getIssueLinkTypes(Map<String, Object> params) throws IOException {
        HttpResponse response = getIssueLinkTypesForHttpResponse(params);
        TypeReference<IssueLinkTypes> typeRef = new TypeReference<IssueLinkTypes>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getIssueLinkTypesForHttpResponse() throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issueLinkType");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getIssueLinkTypesForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issueLinkType");

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
    * Update issue link type
    * Updates an issue link type.  To use this operation, the site must have [issue linking](https://confluence.atlassian.com/x/yoXKM) enabled.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the issue link type ID or the request body are invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if:   *  issue linking is disabled.  *  the issue link type is not found.  *  the user does not have the required permissions.
    * @param issueLinkTypeId The ID of the issue link type.
    * @param issueLinkType The issueLinkType parameter
    * @return IssueLinkType
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public IssueLinkType updateIssueLinkType(String issueLinkTypeId, IssueLinkType issueLinkType) throws IOException {
        HttpResponse response = updateIssueLinkTypeForHttpResponse(issueLinkTypeId, issueLinkType);
        TypeReference<IssueLinkType> typeRef = new TypeReference<IssueLinkType>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Update issue link type
    * Updates an issue link type.  To use this operation, the site must have [issue linking](https://confluence.atlassian.com/x/yoXKM) enabled.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the issue link type ID or the request body are invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if:   *  issue linking is disabled.  *  the issue link type is not found.  *  the user does not have the required permissions.
    * @param issueLinkTypeId The ID of the issue link type.
    * @param issueLinkType The issueLinkType parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return IssueLinkType
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public IssueLinkType updateIssueLinkType(String issueLinkTypeId, IssueLinkType issueLinkType, Map<String, Object> params) throws IOException {
        HttpResponse response = updateIssueLinkTypeForHttpResponse(issueLinkTypeId, issueLinkType, params);
        TypeReference<IssueLinkType> typeRef = new TypeReference<IssueLinkType>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse updateIssueLinkTypeForHttpResponse(String issueLinkTypeId, IssueLinkType issueLinkType) throws IOException {
        // verify the required parameter 'issueLinkTypeId' is set
        if (issueLinkTypeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueLinkTypeId' when calling updateIssueLinkType");
        }// verify the required parameter 'issueLinkType' is set
        if (issueLinkType == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueLinkType' when calling updateIssueLinkType");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueLinkTypeId", issueLinkTypeId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issueLinkType/{issueLinkTypeId}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(issueLinkType);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse updateIssueLinkTypeForHttpResponse(String issueLinkTypeId, java.io.InputStream issueLinkType, String mediaType) throws IOException {
          // verify the required parameter 'issueLinkTypeId' is set
              if (issueLinkTypeId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'issueLinkTypeId' when calling updateIssueLinkType");
              }// verify the required parameter 'issueLinkType' is set
              if (issueLinkType == null) {
              throw new IllegalArgumentException("Missing the required parameter 'issueLinkType' when calling updateIssueLinkType");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("issueLinkTypeId", issueLinkTypeId);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issueLinkType/{issueLinkTypeId}");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = issueLinkType == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, issueLinkType);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse updateIssueLinkTypeForHttpResponse(String issueLinkTypeId, IssueLinkType issueLinkType, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueLinkTypeId' is set
        if (issueLinkTypeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueLinkTypeId' when calling updateIssueLinkType");
        }// verify the required parameter 'issueLinkType' is set
        if (issueLinkType == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueLinkType' when calling updateIssueLinkType");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueLinkTypeId", issueLinkTypeId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issueLinkType/{issueLinkTypeId}");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(issueLinkType);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }


}
