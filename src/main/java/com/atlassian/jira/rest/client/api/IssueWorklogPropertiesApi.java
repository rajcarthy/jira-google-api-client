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
public class IssueWorklogPropertiesApi {
    private ApiClient apiClient;

    public IssueWorklogPropertiesApi() {
        this(new ApiClient());
    }

    public IssueWorklogPropertiesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Delete worklog property
    * Deletes a worklog property.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  If the worklog has visibility restrictions, belongs to the group or has the role visibility is restricted to.
    * <p><b>204</b> - Returned if the worklog property is removed.
    * <p><b>400</b> - Returned if the worklog key or id is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have permission to edit the worklog.
    * <p><b>404</b> - Returned if:   *  the issue, worklog, or property is not found.  *  the user does not have permission to view the issue or worklog.
    * @param issueIdOrKey The ID or key of the issue.
    * @param worklogId The ID of the worklog.
    * @param propertyKey The key of the property.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteWorklogProperty(String issueIdOrKey, String worklogId, String propertyKey) throws IOException {
        deleteWorklogPropertyForHttpResponse(issueIdOrKey, worklogId, propertyKey);
    }

  /**
    * Delete worklog property
    * Deletes a worklog property.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  If the worklog has visibility restrictions, belongs to the group or has the role visibility is restricted to.
    * <p><b>204</b> - Returned if the worklog property is removed.
    * <p><b>400</b> - Returned if the worklog key or id is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have permission to edit the worklog.
    * <p><b>404</b> - Returned if:   *  the issue, worklog, or property is not found.  *  the user does not have permission to view the issue or worklog.
    * @param issueIdOrKey The ID or key of the issue.
    * @param worklogId The ID of the worklog.
    * @param propertyKey The key of the property.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteWorklogProperty(String issueIdOrKey, String worklogId, String propertyKey, Map<String, Object> params) throws IOException {
        deleteWorklogPropertyForHttpResponse(issueIdOrKey, worklogId, propertyKey, params);
    }

    public HttpResponse deleteWorklogPropertyForHttpResponse(String issueIdOrKey, String worklogId, String propertyKey) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling deleteWorklogProperty");
        }// verify the required parameter 'worklogId' is set
        if (worklogId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'worklogId' when calling deleteWorklogProperty");
        }// verify the required parameter 'propertyKey' is set
        if (propertyKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'propertyKey' when calling deleteWorklogProperty");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        uriVariables.put("worklogId", worklogId);
        uriVariables.put("propertyKey", propertyKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/worklog/{worklogId}/properties/{propertyKey}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }

    public HttpResponse deleteWorklogPropertyForHttpResponse(String issueIdOrKey, String worklogId, String propertyKey, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling deleteWorklogProperty");
        }// verify the required parameter 'worklogId' is set
        if (worklogId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'worklogId' when calling deleteWorklogProperty");
        }// verify the required parameter 'propertyKey' is set
        if (propertyKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'propertyKey' when calling deleteWorklogProperty");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        uriVariables.put("worklogId", worklogId);
        uriVariables.put("propertyKey", propertyKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/worklog/{worklogId}/properties/{propertyKey}");

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
    * Get worklog property
    * Returns the value of a worklog property.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  If the worklog has visibility restrictions, belongs to the group or has the role visibility is restricted to.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the worklog ID is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if:   *  the issue, worklog, or property is not found.  *  the user does not have permission to view the issue or worklog.
    * @param issueIdOrKey The ID or key of the issue.
    * @param worklogId The ID of the worklog.
    * @param propertyKey The key of the property.
    * @return EntityProperty
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public EntityProperty getWorklogProperty(String issueIdOrKey, String worklogId, String propertyKey) throws IOException {
        HttpResponse response = getWorklogPropertyForHttpResponse(issueIdOrKey, worklogId, propertyKey);
        TypeReference<EntityProperty> typeRef = new TypeReference<EntityProperty>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get worklog property
    * Returns the value of a worklog property.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  If the worklog has visibility restrictions, belongs to the group or has the role visibility is restricted to.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the worklog ID is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if:   *  the issue, worklog, or property is not found.  *  the user does not have permission to view the issue or worklog.
    * @param issueIdOrKey The ID or key of the issue.
    * @param worklogId The ID of the worklog.
    * @param propertyKey The key of the property.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return EntityProperty
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public EntityProperty getWorklogProperty(String issueIdOrKey, String worklogId, String propertyKey, Map<String, Object> params) throws IOException {
        HttpResponse response = getWorklogPropertyForHttpResponse(issueIdOrKey, worklogId, propertyKey, params);
        TypeReference<EntityProperty> typeRef = new TypeReference<EntityProperty>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getWorklogPropertyForHttpResponse(String issueIdOrKey, String worklogId, String propertyKey) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling getWorklogProperty");
        }// verify the required parameter 'worklogId' is set
        if (worklogId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'worklogId' when calling getWorklogProperty");
        }// verify the required parameter 'propertyKey' is set
        if (propertyKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'propertyKey' when calling getWorklogProperty");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        uriVariables.put("worklogId", worklogId);
        uriVariables.put("propertyKey", propertyKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/worklog/{worklogId}/properties/{propertyKey}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getWorklogPropertyForHttpResponse(String issueIdOrKey, String worklogId, String propertyKey, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling getWorklogProperty");
        }// verify the required parameter 'worklogId' is set
        if (worklogId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'worklogId' when calling getWorklogProperty");
        }// verify the required parameter 'propertyKey' is set
        if (propertyKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'propertyKey' when calling getWorklogProperty");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        uriVariables.put("worklogId", worklogId);
        uriVariables.put("propertyKey", propertyKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/worklog/{worklogId}/properties/{propertyKey}");

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
    * Get worklog property keys
    * Returns the keys of all properties for a worklog.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  If the worklog has visibility restrictions, belongs to the group or has the role visibility is restricted to.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the worklog ID is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if:   *  the issue or worklog is not found.  *  the user does not have permission to view the issue or worklog.
    * @param issueIdOrKey The ID or key of the issue.
    * @param worklogId The ID of the worklog.
    * @return PropertyKeys
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PropertyKeys getWorklogPropertyKeys(String issueIdOrKey, String worklogId) throws IOException {
        HttpResponse response = getWorklogPropertyKeysForHttpResponse(issueIdOrKey, worklogId);
        TypeReference<PropertyKeys> typeRef = new TypeReference<PropertyKeys>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get worklog property keys
    * Returns the keys of all properties for a worklog.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  If the worklog has visibility restrictions, belongs to the group or has the role visibility is restricted to.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the worklog ID is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if:   *  the issue or worklog is not found.  *  the user does not have permission to view the issue or worklog.
    * @param issueIdOrKey The ID or key of the issue.
    * @param worklogId The ID of the worklog.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PropertyKeys
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PropertyKeys getWorklogPropertyKeys(String issueIdOrKey, String worklogId, Map<String, Object> params) throws IOException {
        HttpResponse response = getWorklogPropertyKeysForHttpResponse(issueIdOrKey, worklogId, params);
        TypeReference<PropertyKeys> typeRef = new TypeReference<PropertyKeys>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getWorklogPropertyKeysForHttpResponse(String issueIdOrKey, String worklogId) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling getWorklogPropertyKeys");
        }// verify the required parameter 'worklogId' is set
        if (worklogId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'worklogId' when calling getWorklogPropertyKeys");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        uriVariables.put("worklogId", worklogId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/worklog/{worklogId}/properties");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getWorklogPropertyKeysForHttpResponse(String issueIdOrKey, String worklogId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling getWorklogPropertyKeys");
        }// verify the required parameter 'worklogId' is set
        if (worklogId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'worklogId' when calling getWorklogPropertyKeys");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        uriVariables.put("worklogId", worklogId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/worklog/{worklogId}/properties");

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
    * Set worklog property
    * Sets the value of a worklog property. Use this operation to store custom data against the worklog.  The value of the request body must be a [valid](http://tools.ietf.org/html/rfc4627), non-empty JSON blob. The maximum length is 32768 characters.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  *Edit all worklogs*[ project permission](https://confluence.atlassian.com/x/yodKLg) to update any worklog or *Edit own worklogs* to update worklogs created by the user.  *  If the worklog has visibility restrictions, belongs to the group or has the role visibility is restricted to.
    * <p><b>200</b> - Returned if the worklog property is updated.
    * <p><b>201</b> - Returned if the worklog property is created.
    * <p><b>400</b> - Returned if the worklog ID is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have permission to edit the worklog.
    * <p><b>404</b> - Returned if:   *  the issue or worklog is not found.  *  the user does not have permission to view the issue or worklog.
    * @param issueIdOrKey The ID or key of the issue.
    * @param worklogId The ID of the worklog.
    * @param propertyKey The key of the issue property. The maximum length is 255 characters.
    * @param body The body parameter
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object setWorklogProperty(String issueIdOrKey, String worklogId, String propertyKey, Object body) throws IOException {
        HttpResponse response = setWorklogPropertyForHttpResponse(issueIdOrKey, worklogId, propertyKey, body);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Set worklog property
    * Sets the value of a worklog property. Use this operation to store custom data against the worklog.  The value of the request body must be a [valid](http://tools.ietf.org/html/rfc4627), non-empty JSON blob. The maximum length is 32768 characters.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  *Edit all worklogs*[ project permission](https://confluence.atlassian.com/x/yodKLg) to update any worklog or *Edit own worklogs* to update worklogs created by the user.  *  If the worklog has visibility restrictions, belongs to the group or has the role visibility is restricted to.
    * <p><b>200</b> - Returned if the worklog property is updated.
    * <p><b>201</b> - Returned if the worklog property is created.
    * <p><b>400</b> - Returned if the worklog ID is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have permission to edit the worklog.
    * <p><b>404</b> - Returned if:   *  the issue or worklog is not found.  *  the user does not have permission to view the issue or worklog.
    * @param issueIdOrKey The ID or key of the issue.
    * @param worklogId The ID of the worklog.
    * @param propertyKey The key of the issue property. The maximum length is 255 characters.
    * @param body The body parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object setWorklogProperty(String issueIdOrKey, String worklogId, String propertyKey, Object body, Map<String, Object> params) throws IOException {
        HttpResponse response = setWorklogPropertyForHttpResponse(issueIdOrKey, worklogId, propertyKey, body, params);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse setWorklogPropertyForHttpResponse(String issueIdOrKey, String worklogId, String propertyKey, Object body) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling setWorklogProperty");
        }// verify the required parameter 'worklogId' is set
        if (worklogId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'worklogId' when calling setWorklogProperty");
        }// verify the required parameter 'propertyKey' is set
        if (propertyKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'propertyKey' when calling setWorklogProperty");
        }// verify the required parameter 'body' is set
        if (body == null) {
            throw new IllegalArgumentException("Missing the required parameter 'body' when calling setWorklogProperty");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        uriVariables.put("worklogId", worklogId);
        uriVariables.put("propertyKey", propertyKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/worklog/{worklogId}/properties/{propertyKey}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(body);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse setWorklogPropertyForHttpResponse(String issueIdOrKey, String worklogId, String propertyKey, java.io.InputStream body, String mediaType) throws IOException {
          // verify the required parameter 'issueIdOrKey' is set
              if (issueIdOrKey == null) {
              throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling setWorklogProperty");
              }// verify the required parameter 'worklogId' is set
              if (worklogId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'worklogId' when calling setWorklogProperty");
              }// verify the required parameter 'propertyKey' is set
              if (propertyKey == null) {
              throw new IllegalArgumentException("Missing the required parameter 'propertyKey' when calling setWorklogProperty");
              }// verify the required parameter 'body' is set
              if (body == null) {
              throw new IllegalArgumentException("Missing the required parameter 'body' when calling setWorklogProperty");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("issueIdOrKey", issueIdOrKey);
                      uriVariables.put("worklogId", worklogId);
                      uriVariables.put("propertyKey", propertyKey);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/worklog/{worklogId}/properties/{propertyKey}");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = body == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, body);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse setWorklogPropertyForHttpResponse(String issueIdOrKey, String worklogId, String propertyKey, Object body, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling setWorklogProperty");
        }// verify the required parameter 'worklogId' is set
        if (worklogId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'worklogId' when calling setWorklogProperty");
        }// verify the required parameter 'propertyKey' is set
        if (propertyKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'propertyKey' when calling setWorklogProperty");
        }// verify the required parameter 'body' is set
        if (body == null) {
            throw new IllegalArgumentException("Missing the required parameter 'body' when calling setWorklogProperty");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        uriVariables.put("worklogId", worklogId);
        uriVariables.put("propertyKey", propertyKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/worklog/{worklogId}/properties/{propertyKey}");

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
