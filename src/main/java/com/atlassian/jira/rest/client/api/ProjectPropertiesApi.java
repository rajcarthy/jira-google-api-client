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
public class ProjectPropertiesApi {
    private ApiClient apiClient;

    public ProjectPropertiesApi() {
        this(new ApiClient());
    }

    public ProjectPropertiesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Delete project property
    * Deletes the [property](https://developer.atlassian.com/cloud/jira/platform/storing-data-without-a-database/#a-id-jira-entity-properties-a-jira-entity-properties) from a project.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) or *Administer Projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project containing the property.
    * <p><b>204</b> - Returned if the project property is deleted.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect.
    * <p><b>403</b> - Returned if the user does not have permission to administer the project.
    * <p><b>404</b> - Returned if the project or property is not found.
    * @param projectIdOrKey The project ID or project key (case sensitive).
    * @param propertyKey The project property key. Use [Get project property keys](#api-rest-api-3-project-projectIdOrKey-properties-get) to get a list of all project property keys.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteProjectProperty(String projectIdOrKey, String propertyKey) throws IOException {
        deleteProjectPropertyForHttpResponse(projectIdOrKey, propertyKey);
    }

  /**
    * Delete project property
    * Deletes the [property](https://developer.atlassian.com/cloud/jira/platform/storing-data-without-a-database/#a-id-jira-entity-properties-a-jira-entity-properties) from a project.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) or *Administer Projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project containing the property.
    * <p><b>204</b> - Returned if the project property is deleted.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect.
    * <p><b>403</b> - Returned if the user does not have permission to administer the project.
    * <p><b>404</b> - Returned if the project or property is not found.
    * @param projectIdOrKey The project ID or project key (case sensitive).
    * @param propertyKey The project property key. Use [Get project property keys](#api-rest-api-3-project-projectIdOrKey-properties-get) to get a list of all project property keys.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteProjectProperty(String projectIdOrKey, String propertyKey, Map<String, Object> params) throws IOException {
        deleteProjectPropertyForHttpResponse(projectIdOrKey, propertyKey, params);
    }

    public HttpResponse deleteProjectPropertyForHttpResponse(String projectIdOrKey, String propertyKey) throws IOException {
        // verify the required parameter 'projectIdOrKey' is set
        if (projectIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectIdOrKey' when calling deleteProjectProperty");
        }// verify the required parameter 'propertyKey' is set
        if (propertyKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'propertyKey' when calling deleteProjectProperty");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectIdOrKey", projectIdOrKey);
        uriVariables.put("propertyKey", propertyKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectIdOrKey}/properties/{propertyKey}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }

    public HttpResponse deleteProjectPropertyForHttpResponse(String projectIdOrKey, String propertyKey, Map<String, Object> params) throws IOException {
        // verify the required parameter 'projectIdOrKey' is set
        if (projectIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectIdOrKey' when calling deleteProjectProperty");
        }// verify the required parameter 'propertyKey' is set
        if (propertyKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'propertyKey' when calling deleteProjectProperty");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectIdOrKey", projectIdOrKey);
        uriVariables.put("propertyKey", propertyKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectIdOrKey}/properties/{propertyKey}");

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
    * Get project property
    * Returns the value of a [project property](https://developer.atlassian.com/cloud/jira/platform/storing-data-without-a-database/#a-id-jira-entity-properties-a-jira-entity-properties).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Browse Projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project containing the property.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect.
    * <p><b>403</b> - Returned if the user does not have permission to view the project.
    * <p><b>404</b> - Returned if the project or property is not found.
    * @param projectIdOrKey The project ID or project key (case sensitive).
    * @param propertyKey The project property key. Use [Get project property keys](#api-rest-api-3-project-projectIdOrKey-properties-get) to get a list of all project property keys.
    * @return EntityProperty
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public EntityProperty getProjectProperty(String projectIdOrKey, String propertyKey) throws IOException {
        HttpResponse response = getProjectPropertyForHttpResponse(projectIdOrKey, propertyKey);
        TypeReference<EntityProperty> typeRef = new TypeReference<EntityProperty>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get project property
    * Returns the value of a [project property](https://developer.atlassian.com/cloud/jira/platform/storing-data-without-a-database/#a-id-jira-entity-properties-a-jira-entity-properties).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Browse Projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project containing the property.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect.
    * <p><b>403</b> - Returned if the user does not have permission to view the project.
    * <p><b>404</b> - Returned if the project or property is not found.
    * @param projectIdOrKey The project ID or project key (case sensitive).
    * @param propertyKey The project property key. Use [Get project property keys](#api-rest-api-3-project-projectIdOrKey-properties-get) to get a list of all project property keys.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return EntityProperty
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public EntityProperty getProjectProperty(String projectIdOrKey, String propertyKey, Map<String, Object> params) throws IOException {
        HttpResponse response = getProjectPropertyForHttpResponse(projectIdOrKey, propertyKey, params);
        TypeReference<EntityProperty> typeRef = new TypeReference<EntityProperty>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getProjectPropertyForHttpResponse(String projectIdOrKey, String propertyKey) throws IOException {
        // verify the required parameter 'projectIdOrKey' is set
        if (projectIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectIdOrKey' when calling getProjectProperty");
        }// verify the required parameter 'propertyKey' is set
        if (propertyKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'propertyKey' when calling getProjectProperty");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectIdOrKey", projectIdOrKey);
        uriVariables.put("propertyKey", propertyKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectIdOrKey}/properties/{propertyKey}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getProjectPropertyForHttpResponse(String projectIdOrKey, String propertyKey, Map<String, Object> params) throws IOException {
        // verify the required parameter 'projectIdOrKey' is set
        if (projectIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectIdOrKey' when calling getProjectProperty");
        }// verify the required parameter 'propertyKey' is set
        if (propertyKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'propertyKey' when calling getProjectProperty");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectIdOrKey", projectIdOrKey);
        uriVariables.put("propertyKey", propertyKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectIdOrKey}/properties/{propertyKey}");

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
    * Get project property keys
    * Returns all [project property](https://developer.atlassian.com/cloud/jira/platform/storing-data-without-a-database/#a-id-jira-entity-properties-a-jira-entity-properties) keys for the project.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Browse Projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect.
    * <p><b>403</b> - Returned if the user does not have permission to view the project.
    * <p><b>404</b> - Returned if the project is not found.
    * @param projectIdOrKey The project ID or project key (case sensitive).
    * @return PropertyKeys
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PropertyKeys getProjectPropertyKeys(String projectIdOrKey) throws IOException {
        HttpResponse response = getProjectPropertyKeysForHttpResponse(projectIdOrKey);
        TypeReference<PropertyKeys> typeRef = new TypeReference<PropertyKeys>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get project property keys
    * Returns all [project property](https://developer.atlassian.com/cloud/jira/platform/storing-data-without-a-database/#a-id-jira-entity-properties-a-jira-entity-properties) keys for the project.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Browse Projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect.
    * <p><b>403</b> - Returned if the user does not have permission to view the project.
    * <p><b>404</b> - Returned if the project is not found.
    * @param projectIdOrKey The project ID or project key (case sensitive).
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PropertyKeys
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PropertyKeys getProjectPropertyKeys(String projectIdOrKey, Map<String, Object> params) throws IOException {
        HttpResponse response = getProjectPropertyKeysForHttpResponse(projectIdOrKey, params);
        TypeReference<PropertyKeys> typeRef = new TypeReference<PropertyKeys>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getProjectPropertyKeysForHttpResponse(String projectIdOrKey) throws IOException {
        // verify the required parameter 'projectIdOrKey' is set
        if (projectIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectIdOrKey' when calling getProjectPropertyKeys");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectIdOrKey", projectIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectIdOrKey}/properties");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getProjectPropertyKeysForHttpResponse(String projectIdOrKey, Map<String, Object> params) throws IOException {
        // verify the required parameter 'projectIdOrKey' is set
        if (projectIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectIdOrKey' when calling getProjectPropertyKeys");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectIdOrKey", projectIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectIdOrKey}/properties");

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
    * Set project property
    * Sets the value of the [project property](https://developer.atlassian.com/cloud/jira/platform/storing-data-without-a-database/#a-id-jira-entity-properties-a-jira-entity-properties). You can use project properties to store custom data against the project.  The value of the request body must be a [valid](http://tools.ietf.org/html/rfc4627), non-empty JSON blob. The maximum length is 32768 characters.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) or *Administer Projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project in which the property is created.
    * <p><b>200</b> - Returned if the project property is updated.
    * <p><b>201</b> - Returned if the project property is created.
    * <p><b>400</b> - Returned if the project key or id is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect.
    * <p><b>403</b> - Returned if the user does not have permission to administer the project.
    * <p><b>404</b> - Returned if the project is not found.
    * @param projectIdOrKey The project ID or project key (case sensitive).
    * @param propertyKey The key of the project property. The maximum length is 255 characters.
    * @param body The body parameter
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object setProjectProperty(String projectIdOrKey, String propertyKey, Object body) throws IOException {
        HttpResponse response = setProjectPropertyForHttpResponse(projectIdOrKey, propertyKey, body);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Set project property
    * Sets the value of the [project property](https://developer.atlassian.com/cloud/jira/platform/storing-data-without-a-database/#a-id-jira-entity-properties-a-jira-entity-properties). You can use project properties to store custom data against the project.  The value of the request body must be a [valid](http://tools.ietf.org/html/rfc4627), non-empty JSON blob. The maximum length is 32768 characters.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) or *Administer Projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project in which the property is created.
    * <p><b>200</b> - Returned if the project property is updated.
    * <p><b>201</b> - Returned if the project property is created.
    * <p><b>400</b> - Returned if the project key or id is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect.
    * <p><b>403</b> - Returned if the user does not have permission to administer the project.
    * <p><b>404</b> - Returned if the project is not found.
    * @param projectIdOrKey The project ID or project key (case sensitive).
    * @param propertyKey The key of the project property. The maximum length is 255 characters.
    * @param body The body parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object setProjectProperty(String projectIdOrKey, String propertyKey, Object body, Map<String, Object> params) throws IOException {
        HttpResponse response = setProjectPropertyForHttpResponse(projectIdOrKey, propertyKey, body, params);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse setProjectPropertyForHttpResponse(String projectIdOrKey, String propertyKey, Object body) throws IOException {
        // verify the required parameter 'projectIdOrKey' is set
        if (projectIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectIdOrKey' when calling setProjectProperty");
        }// verify the required parameter 'propertyKey' is set
        if (propertyKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'propertyKey' when calling setProjectProperty");
        }// verify the required parameter 'body' is set
        if (body == null) {
            throw new IllegalArgumentException("Missing the required parameter 'body' when calling setProjectProperty");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectIdOrKey", projectIdOrKey);
        uriVariables.put("propertyKey", propertyKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectIdOrKey}/properties/{propertyKey}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(body);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse setProjectPropertyForHttpResponse(String projectIdOrKey, String propertyKey, java.io.InputStream body, String mediaType) throws IOException {
          // verify the required parameter 'projectIdOrKey' is set
              if (projectIdOrKey == null) {
              throw new IllegalArgumentException("Missing the required parameter 'projectIdOrKey' when calling setProjectProperty");
              }// verify the required parameter 'propertyKey' is set
              if (propertyKey == null) {
              throw new IllegalArgumentException("Missing the required parameter 'propertyKey' when calling setProjectProperty");
              }// verify the required parameter 'body' is set
              if (body == null) {
              throw new IllegalArgumentException("Missing the required parameter 'body' when calling setProjectProperty");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("projectIdOrKey", projectIdOrKey);
                      uriVariables.put("propertyKey", propertyKey);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectIdOrKey}/properties/{propertyKey}");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = body == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, body);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse setProjectPropertyForHttpResponse(String projectIdOrKey, String propertyKey, Object body, Map<String, Object> params) throws IOException {
        // verify the required parameter 'projectIdOrKey' is set
        if (projectIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectIdOrKey' when calling setProjectProperty");
        }// verify the required parameter 'propertyKey' is set
        if (propertyKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'propertyKey' when calling setProjectProperty");
        }// verify the required parameter 'body' is set
        if (body == null) {
            throw new IllegalArgumentException("Missing the required parameter 'body' when calling setProjectProperty");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectIdOrKey", projectIdOrKey);
        uriVariables.put("propertyKey", propertyKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectIdOrKey}/properties/{propertyKey}");

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
