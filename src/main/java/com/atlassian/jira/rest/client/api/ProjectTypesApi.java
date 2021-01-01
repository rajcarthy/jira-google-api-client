package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.ProjectType;

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
public class ProjectTypesApi {
    private ApiClient apiClient;

    public ProjectTypesApi() {
        this(new ApiClient());
    }

    public ProjectTypesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Get accessible project type by key
    * Returns a [project type](https://confluence.atlassian.com/x/Var1Nw) if it is accessible to the user.  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the project type is not accessible to the user.
    * @param projectTypeKey The key of the project type.
    * @return ProjectType
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ProjectType getAccessibleProjectTypeByKey(String projectTypeKey) throws IOException {
        HttpResponse response = getAccessibleProjectTypeByKeyForHttpResponse(projectTypeKey);
        TypeReference<ProjectType> typeRef = new TypeReference<ProjectType>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get accessible project type by key
    * Returns a [project type](https://confluence.atlassian.com/x/Var1Nw) if it is accessible to the user.  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the project type is not accessible to the user.
    * @param projectTypeKey The key of the project type.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return ProjectType
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ProjectType getAccessibleProjectTypeByKey(String projectTypeKey, Map<String, Object> params) throws IOException {
        HttpResponse response = getAccessibleProjectTypeByKeyForHttpResponse(projectTypeKey, params);
        TypeReference<ProjectType> typeRef = new TypeReference<ProjectType>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getAccessibleProjectTypeByKeyForHttpResponse(String projectTypeKey) throws IOException {
        // verify the required parameter 'projectTypeKey' is set
        if (projectTypeKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectTypeKey' when calling getAccessibleProjectTypeByKey");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectTypeKey", projectTypeKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/type/{projectTypeKey}/accessible");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getAccessibleProjectTypeByKeyForHttpResponse(String projectTypeKey, Map<String, Object> params) throws IOException {
        // verify the required parameter 'projectTypeKey' is set
        if (projectTypeKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectTypeKey' when calling getAccessibleProjectTypeByKey");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectTypeKey", projectTypeKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/type/{projectTypeKey}/accessible");

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
    * Get licensed project types
    * Returns all [project types](https://confluence.atlassian.com/x/Var1Nw) with a valid license.
    * <p><b>200</b> - Returned if the request is successful.
    * @return List&lt;ProjectType&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<ProjectType> getAllAccessibleProjectTypes() throws IOException {
        HttpResponse response = getAllAccessibleProjectTypesForHttpResponse();
        TypeReference<List<ProjectType>> typeRef = new TypeReference<List<ProjectType>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get licensed project types
    * Returns all [project types](https://confluence.atlassian.com/x/Var1Nw) with a valid license.
    * <p><b>200</b> - Returned if the request is successful.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return List&lt;ProjectType&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<ProjectType> getAllAccessibleProjectTypes(Map<String, Object> params) throws IOException {
        HttpResponse response = getAllAccessibleProjectTypesForHttpResponse(params);
        TypeReference<List<ProjectType>> typeRef = new TypeReference<List<ProjectType>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getAllAccessibleProjectTypesForHttpResponse() throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/type/accessible");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getAllAccessibleProjectTypesForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/type/accessible");

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
    * Get all project types
    * Returns all [project types](https://confluence.atlassian.com/x/Var1Nw), whether or not the instance has a valid license for each type.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect.
    * @return List&lt;ProjectType&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<ProjectType> getAllProjectTypes() throws IOException {
        HttpResponse response = getAllProjectTypesForHttpResponse();
        TypeReference<List<ProjectType>> typeRef = new TypeReference<List<ProjectType>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get all project types
    * Returns all [project types](https://confluence.atlassian.com/x/Var1Nw), whether or not the instance has a valid license for each type.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return List&lt;ProjectType&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<ProjectType> getAllProjectTypes(Map<String, Object> params) throws IOException {
        HttpResponse response = getAllProjectTypesForHttpResponse(params);
        TypeReference<List<ProjectType>> typeRef = new TypeReference<List<ProjectType>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getAllProjectTypesForHttpResponse() throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/type");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getAllProjectTypesForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/type");

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
    * Get project type by key
    * Returns a [project type](https://confluence.atlassian.com/x/Var1Nw).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect.
    * <p><b>404</b> - Returned if the project type is not found.
    * @param projectTypeKey The key of the project type.
    * @return ProjectType
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ProjectType getProjectTypeByKey(String projectTypeKey) throws IOException {
        HttpResponse response = getProjectTypeByKeyForHttpResponse(projectTypeKey);
        TypeReference<ProjectType> typeRef = new TypeReference<ProjectType>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get project type by key
    * Returns a [project type](https://confluence.atlassian.com/x/Var1Nw).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect.
    * <p><b>404</b> - Returned if the project type is not found.
    * @param projectTypeKey The key of the project type.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return ProjectType
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ProjectType getProjectTypeByKey(String projectTypeKey, Map<String, Object> params) throws IOException {
        HttpResponse response = getProjectTypeByKeyForHttpResponse(projectTypeKey, params);
        TypeReference<ProjectType> typeRef = new TypeReference<ProjectType>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getProjectTypeByKeyForHttpResponse(String projectTypeKey) throws IOException {
        // verify the required parameter 'projectTypeKey' is set
        if (projectTypeKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectTypeKey' when calling getProjectTypeByKey");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectTypeKey", projectTypeKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/type/{projectTypeKey}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getProjectTypeByKeyForHttpResponse(String projectTypeKey, Map<String, Object> params) throws IOException {
        // verify the required parameter 'projectTypeKey' is set
        if (projectTypeKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectTypeKey' when calling getProjectTypeByKey");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectTypeKey", projectTypeKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/type/{projectTypeKey}");

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


}
