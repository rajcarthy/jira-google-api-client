package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.ProjectEmailAddress;

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
public class ProjectEmailApi {
    private ApiClient apiClient;

    public ProjectEmailApi() {
        this(new ApiClient());
    }

    public ProjectEmailApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Get project&#39;s sender email
    * Returns the [project&#39;s sender email address](https://confluence.atlassian.com/x/dolKLg).  **[Permissions](#permissions) required:** *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have permission to read project.
    * <p><b>404</b> - Returned if the project or project&#39;s sender email address is not found.
    * @param projectId The project ID.
    * @return ProjectEmailAddress
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ProjectEmailAddress getProjectEmail(Long projectId) throws IOException {
        HttpResponse response = getProjectEmailForHttpResponse(projectId);
        TypeReference<ProjectEmailAddress> typeRef = new TypeReference<ProjectEmailAddress>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get project&#39;s sender email
    * Returns the [project&#39;s sender email address](https://confluence.atlassian.com/x/dolKLg).  **[Permissions](#permissions) required:** *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have permission to read project.
    * <p><b>404</b> - Returned if the project or project&#39;s sender email address is not found.
    * @param projectId The project ID.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return ProjectEmailAddress
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ProjectEmailAddress getProjectEmail(Long projectId, Map<String, Object> params) throws IOException {
        HttpResponse response = getProjectEmailForHttpResponse(projectId, params);
        TypeReference<ProjectEmailAddress> typeRef = new TypeReference<ProjectEmailAddress>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getProjectEmailForHttpResponse(Long projectId) throws IOException {
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectId' when calling getProjectEmail");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectId", projectId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectId}/email");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getProjectEmailForHttpResponse(Long projectId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectId' when calling getProjectEmail");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectId", projectId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectId}/email");

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
    * Set project&#39;s sender email
    * Sets the [project&#39;s sender email address](https://confluence.atlassian.com/x/dolKLg).  If &#x60;emailAddress&#x60; is an empty string, the default email address is restored.  **[Permissions](#permissions) required:** *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project.
    * <p><b>204</b> - Returned if the project&#39;s sender email address is successfully set.
    * <p><b>400</b> - Returned if the request is not valid, if the email address is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have permission to read project.
    * <p><b>404</b> - Returned if the project is not found.
    * @param projectId The project ID.
    * @param projectEmailAddress The project&#39;s sender email address to be set.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object updateProjectEmail(Long projectId, ProjectEmailAddress projectEmailAddress) throws IOException {
        HttpResponse response = updateProjectEmailForHttpResponse(projectId, projectEmailAddress);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Set project&#39;s sender email
    * Sets the [project&#39;s sender email address](https://confluence.atlassian.com/x/dolKLg).  If &#x60;emailAddress&#x60; is an empty string, the default email address is restored.  **[Permissions](#permissions) required:** *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project.
    * <p><b>204</b> - Returned if the project&#39;s sender email address is successfully set.
    * <p><b>400</b> - Returned if the request is not valid, if the email address is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have permission to read project.
    * <p><b>404</b> - Returned if the project is not found.
    * @param projectId The project ID.
    * @param projectEmailAddress The project&#39;s sender email address to be set.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object updateProjectEmail(Long projectId, ProjectEmailAddress projectEmailAddress, Map<String, Object> params) throws IOException {
        HttpResponse response = updateProjectEmailForHttpResponse(projectId, projectEmailAddress, params);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse updateProjectEmailForHttpResponse(Long projectId, ProjectEmailAddress projectEmailAddress) throws IOException {
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectId' when calling updateProjectEmail");
        }// verify the required parameter 'projectEmailAddress' is set
        if (projectEmailAddress == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectEmailAddress' when calling updateProjectEmail");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectId", projectId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectId}/email");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(projectEmailAddress);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse updateProjectEmailForHttpResponse(Long projectId, java.io.InputStream projectEmailAddress, String mediaType) throws IOException {
          // verify the required parameter 'projectId' is set
              if (projectId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'projectId' when calling updateProjectEmail");
              }// verify the required parameter 'projectEmailAddress' is set
              if (projectEmailAddress == null) {
              throw new IllegalArgumentException("Missing the required parameter 'projectEmailAddress' when calling updateProjectEmail");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("projectId", projectId);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectId}/email");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = projectEmailAddress == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, projectEmailAddress);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse updateProjectEmailForHttpResponse(Long projectId, ProjectEmailAddress projectEmailAddress, Map<String, Object> params) throws IOException {
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectId' when calling updateProjectEmail");
        }// verify the required parameter 'projectEmailAddress' is set
        if (projectEmailAddress == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectEmailAddress' when calling updateProjectEmail");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectId", projectId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectId}/email");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(projectEmailAddress);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }


}
