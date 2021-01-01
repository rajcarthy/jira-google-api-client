package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.EntityProperty;
import com.atlassian.jira.rest.client.model.PropertyKeys;

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
public class IssueTypePropertiesApi {
    private ApiClient apiClient;

    public IssueTypePropertiesApi() {
        this(new ApiClient());
    }

    public IssueTypePropertiesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Delete issue type property
    * Deletes the [issue type property](https://developer.atlassian.com/cloud/jira/platform/storing-data-without-a-database/#a-id-jira-entity-properties-a-jira-entity-properties).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the issue type property is deleted.
    * <p><b>400</b> - Returned if the issue type ID is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the issue type or property is not found.
    * @param issueTypeId The ID of the issue type.
    * @param propertyKey The key of the property. Use [Get issue type property keys](#api-rest-api-3-issuetype-issueTypeId-properties-get) to get a list of all issue type property keys.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteIssueTypeProperty(String issueTypeId, String propertyKey) throws IOException {
        deleteIssueTypePropertyForHttpResponse(issueTypeId, propertyKey);
    }

  /**
    * Delete issue type property
    * Deletes the [issue type property](https://developer.atlassian.com/cloud/jira/platform/storing-data-without-a-database/#a-id-jira-entity-properties-a-jira-entity-properties).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the issue type property is deleted.
    * <p><b>400</b> - Returned if the issue type ID is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the issue type or property is not found.
    * @param issueTypeId The ID of the issue type.
    * @param propertyKey The key of the property. Use [Get issue type property keys](#api-rest-api-3-issuetype-issueTypeId-properties-get) to get a list of all issue type property keys.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteIssueTypeProperty(String issueTypeId, String propertyKey, Map<String, Object> params) throws IOException {
        deleteIssueTypePropertyForHttpResponse(issueTypeId, propertyKey, params);
    }

    public HttpResponse deleteIssueTypePropertyForHttpResponse(String issueTypeId, String propertyKey) throws IOException {
        // verify the required parameter 'issueTypeId' is set
        if (issueTypeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeId' when calling deleteIssueTypeProperty");
        }// verify the required parameter 'propertyKey' is set
        if (propertyKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'propertyKey' when calling deleteIssueTypeProperty");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueTypeId", issueTypeId);
        uriVariables.put("propertyKey", propertyKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetype/{issueTypeId}/properties/{propertyKey}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }

    public HttpResponse deleteIssueTypePropertyForHttpResponse(String issueTypeId, String propertyKey, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueTypeId' is set
        if (issueTypeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeId' when calling deleteIssueTypeProperty");
        }// verify the required parameter 'propertyKey' is set
        if (propertyKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'propertyKey' when calling deleteIssueTypeProperty");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueTypeId", issueTypeId);
        uriVariables.put("propertyKey", propertyKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetype/{issueTypeId}/properties/{propertyKey}");

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
    * Get issue type property
    * Returns the key and value of the [issue type property](https://developer.atlassian.com/cloud/jira/platform/storing-data-without-a-database/#a-id-jira-entity-properties-a-jira-entity-properties).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) to get the details of any issue type.  *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) to get the details of any issue types associated with the projects the user has permission to browse.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the issue type ID is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the issue type or property is not found or the user does not have the required permissions.
    * @param issueTypeId The ID of the issue type.
    * @param propertyKey The key of the property. Use [Get issue type property keys](#api-rest-api-3-issuetype-issueTypeId-properties-get) to get a list of all issue type property keys.
    * @return EntityProperty
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public EntityProperty getIssueTypeProperty(String issueTypeId, String propertyKey) throws IOException {
        HttpResponse response = getIssueTypePropertyForHttpResponse(issueTypeId, propertyKey);
        TypeReference<EntityProperty> typeRef = new TypeReference<EntityProperty>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get issue type property
    * Returns the key and value of the [issue type property](https://developer.atlassian.com/cloud/jira/platform/storing-data-without-a-database/#a-id-jira-entity-properties-a-jira-entity-properties).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) to get the details of any issue type.  *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) to get the details of any issue types associated with the projects the user has permission to browse.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the issue type ID is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the issue type or property is not found or the user does not have the required permissions.
    * @param issueTypeId The ID of the issue type.
    * @param propertyKey The key of the property. Use [Get issue type property keys](#api-rest-api-3-issuetype-issueTypeId-properties-get) to get a list of all issue type property keys.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return EntityProperty
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public EntityProperty getIssueTypeProperty(String issueTypeId, String propertyKey, Map<String, Object> params) throws IOException {
        HttpResponse response = getIssueTypePropertyForHttpResponse(issueTypeId, propertyKey, params);
        TypeReference<EntityProperty> typeRef = new TypeReference<EntityProperty>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getIssueTypePropertyForHttpResponse(String issueTypeId, String propertyKey) throws IOException {
        // verify the required parameter 'issueTypeId' is set
        if (issueTypeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeId' when calling getIssueTypeProperty");
        }// verify the required parameter 'propertyKey' is set
        if (propertyKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'propertyKey' when calling getIssueTypeProperty");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueTypeId", issueTypeId);
        uriVariables.put("propertyKey", propertyKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetype/{issueTypeId}/properties/{propertyKey}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getIssueTypePropertyForHttpResponse(String issueTypeId, String propertyKey, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueTypeId' is set
        if (issueTypeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeId' when calling getIssueTypeProperty");
        }// verify the required parameter 'propertyKey' is set
        if (propertyKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'propertyKey' when calling getIssueTypeProperty");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueTypeId", issueTypeId);
        uriVariables.put("propertyKey", propertyKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetype/{issueTypeId}/properties/{propertyKey}");

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
    * Get issue type property keys
    * Returns all the [issue type property](https://developer.atlassian.com/cloud/jira/platform/storing-data-without-a-database/#a-id-jira-entity-properties-a-jira-entity-properties) keys of the issue type.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) to get the property keys of any issue type.  *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) to get the property keys of any issue types associated with the projects the user has permission to browse.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the issue type ID is invalid.
    * <p><b>404</b> - Returned if:   *  the issue type is not found.  *  the user does not have the required permissions.
    * @param issueTypeId The ID of the issue type.
    * @return PropertyKeys
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PropertyKeys getIssueTypePropertyKeys(String issueTypeId) throws IOException {
        HttpResponse response = getIssueTypePropertyKeysForHttpResponse(issueTypeId);
        TypeReference<PropertyKeys> typeRef = new TypeReference<PropertyKeys>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get issue type property keys
    * Returns all the [issue type property](https://developer.atlassian.com/cloud/jira/platform/storing-data-without-a-database/#a-id-jira-entity-properties-a-jira-entity-properties) keys of the issue type.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) to get the property keys of any issue type.  *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) to get the property keys of any issue types associated with the projects the user has permission to browse.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the issue type ID is invalid.
    * <p><b>404</b> - Returned if:   *  the issue type is not found.  *  the user does not have the required permissions.
    * @param issueTypeId The ID of the issue type.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PropertyKeys
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PropertyKeys getIssueTypePropertyKeys(String issueTypeId, Map<String, Object> params) throws IOException {
        HttpResponse response = getIssueTypePropertyKeysForHttpResponse(issueTypeId, params);
        TypeReference<PropertyKeys> typeRef = new TypeReference<PropertyKeys>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getIssueTypePropertyKeysForHttpResponse(String issueTypeId) throws IOException {
        // verify the required parameter 'issueTypeId' is set
        if (issueTypeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeId' when calling getIssueTypePropertyKeys");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueTypeId", issueTypeId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetype/{issueTypeId}/properties");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getIssueTypePropertyKeysForHttpResponse(String issueTypeId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueTypeId' is set
        if (issueTypeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeId' when calling getIssueTypePropertyKeys");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueTypeId", issueTypeId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetype/{issueTypeId}/properties");

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
    * Set issue type property
    * Creates or updates the value of the [issue type property](https://developer.atlassian.com/cloud/jira/platform/storing-data-without-a-database/#a-id-jira-entity-properties-a-jira-entity-properties). Use this resource to store and update data against an issue type.  The value of the request body must be a [valid](http://tools.ietf.org/html/rfc4627), non-empty JSON blob. The maximum length is 32768 characters.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the issue type property is updated.
    * <p><b>201</b> - Returned if the issue type property is created.
    * <p><b>400</b> - Returned if:   *  the issue type ID is invalid.  *  a property value is not provided.  *  the property value JSON content is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have permission to modify the issue type.
    * <p><b>404</b> - Returned if:   *  the issue type is not found.  *  the user does not have the permission view the issue type.
    * @param issueTypeId The ID of the issue type.
    * @param propertyKey The key of the issue type property. The maximum length is 255 characters.
    * @param body The body parameter
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object setIssueTypeProperty(String issueTypeId, String propertyKey, Object body) throws IOException {
        HttpResponse response = setIssueTypePropertyForHttpResponse(issueTypeId, propertyKey, body);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Set issue type property
    * Creates or updates the value of the [issue type property](https://developer.atlassian.com/cloud/jira/platform/storing-data-without-a-database/#a-id-jira-entity-properties-a-jira-entity-properties). Use this resource to store and update data against an issue type.  The value of the request body must be a [valid](http://tools.ietf.org/html/rfc4627), non-empty JSON blob. The maximum length is 32768 characters.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the issue type property is updated.
    * <p><b>201</b> - Returned if the issue type property is created.
    * <p><b>400</b> - Returned if:   *  the issue type ID is invalid.  *  a property value is not provided.  *  the property value JSON content is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have permission to modify the issue type.
    * <p><b>404</b> - Returned if:   *  the issue type is not found.  *  the user does not have the permission view the issue type.
    * @param issueTypeId The ID of the issue type.
    * @param propertyKey The key of the issue type property. The maximum length is 255 characters.
    * @param body The body parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object setIssueTypeProperty(String issueTypeId, String propertyKey, Object body, Map<String, Object> params) throws IOException {
        HttpResponse response = setIssueTypePropertyForHttpResponse(issueTypeId, propertyKey, body, params);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse setIssueTypePropertyForHttpResponse(String issueTypeId, String propertyKey, Object body) throws IOException {
        // verify the required parameter 'issueTypeId' is set
        if (issueTypeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeId' when calling setIssueTypeProperty");
        }// verify the required parameter 'propertyKey' is set
        if (propertyKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'propertyKey' when calling setIssueTypeProperty");
        }// verify the required parameter 'body' is set
        if (body == null) {
            throw new IllegalArgumentException("Missing the required parameter 'body' when calling setIssueTypeProperty");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueTypeId", issueTypeId);
        uriVariables.put("propertyKey", propertyKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetype/{issueTypeId}/properties/{propertyKey}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(body);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse setIssueTypePropertyForHttpResponse(String issueTypeId, String propertyKey, java.io.InputStream body, String mediaType) throws IOException {
          // verify the required parameter 'issueTypeId' is set
              if (issueTypeId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'issueTypeId' when calling setIssueTypeProperty");
              }// verify the required parameter 'propertyKey' is set
              if (propertyKey == null) {
              throw new IllegalArgumentException("Missing the required parameter 'propertyKey' when calling setIssueTypeProperty");
              }// verify the required parameter 'body' is set
              if (body == null) {
              throw new IllegalArgumentException("Missing the required parameter 'body' when calling setIssueTypeProperty");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("issueTypeId", issueTypeId);
                      uriVariables.put("propertyKey", propertyKey);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetype/{issueTypeId}/properties/{propertyKey}");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = body == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, body);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse setIssueTypePropertyForHttpResponse(String issueTypeId, String propertyKey, Object body, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueTypeId' is set
        if (issueTypeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeId' when calling setIssueTypeProperty");
        }// verify the required parameter 'propertyKey' is set
        if (propertyKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'propertyKey' when calling setIssueTypeProperty");
        }// verify the required parameter 'body' is set
        if (body == null) {
            throw new IllegalArgumentException("Missing the required parameter 'body' when calling setIssueTypeProperty");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueTypeId", issueTypeId);
        uriVariables.put("propertyKey", propertyKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetype/{issueTypeId}/properties/{propertyKey}");

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
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }


}
