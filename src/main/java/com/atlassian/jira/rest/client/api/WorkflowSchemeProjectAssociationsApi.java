package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.ContainerOfWorkflowSchemeAssociations;
import java.util.Set;
import com.atlassian.jira.rest.client.model.WorkflowSchemeProjectAssociation;

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
public class WorkflowSchemeProjectAssociationsApi {
    private ApiClient apiClient;

    public WorkflowSchemeProjectAssociationsApi() {
        this(new ApiClient());
    }

    public WorkflowSchemeProjectAssociationsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Assign workflow scheme to project
    * Assigns a workflow scheme to a project. This operation is performed only when there are no issues in the project.  Workflow schemes can only be assigned to classic projects.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * <p><b>404</b> - Returned if the workflow scheme or the project are not found.
    * @param workflowSchemeProjectAssociation The workflowSchemeProjectAssociation parameter
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object associateSchemeWithProject(WorkflowSchemeProjectAssociation workflowSchemeProjectAssociation) throws IOException {
        HttpResponse response = associateSchemeWithProjectForHttpResponse(workflowSchemeProjectAssociation);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Assign workflow scheme to project
    * Assigns a workflow scheme to a project. This operation is performed only when there are no issues in the project.  Workflow schemes can only be assigned to classic projects.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * <p><b>404</b> - Returned if the workflow scheme or the project are not found.
    * @param workflowSchemeProjectAssociation The workflowSchemeProjectAssociation parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object associateSchemeWithProject(WorkflowSchemeProjectAssociation workflowSchemeProjectAssociation, Map<String, Object> params) throws IOException {
        HttpResponse response = associateSchemeWithProjectForHttpResponse(workflowSchemeProjectAssociation, params);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse associateSchemeWithProjectForHttpResponse(WorkflowSchemeProjectAssociation workflowSchemeProjectAssociation) throws IOException {
        // verify the required parameter 'workflowSchemeProjectAssociation' is set
        if (workflowSchemeProjectAssociation == null) {
            throw new IllegalArgumentException("Missing the required parameter 'workflowSchemeProjectAssociation' when calling associateSchemeWithProject");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/project");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(workflowSchemeProjectAssociation);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse associateSchemeWithProjectForHttpResponse(java.io.InputStream workflowSchemeProjectAssociation, String mediaType) throws IOException {
          // verify the required parameter 'workflowSchemeProjectAssociation' is set
              if (workflowSchemeProjectAssociation == null) {
              throw new IllegalArgumentException("Missing the required parameter 'workflowSchemeProjectAssociation' when calling associateSchemeWithProject");
              }
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/project");

              String localVarUrl = uriBuilder.build().toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = workflowSchemeProjectAssociation == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, workflowSchemeProjectAssociation);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse associateSchemeWithProjectForHttpResponse(WorkflowSchemeProjectAssociation workflowSchemeProjectAssociation, Map<String, Object> params) throws IOException {
        // verify the required parameter 'workflowSchemeProjectAssociation' is set
        if (workflowSchemeProjectAssociation == null) {
            throw new IllegalArgumentException("Missing the required parameter 'workflowSchemeProjectAssociation' when calling associateSchemeWithProject");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/project");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(workflowSchemeProjectAssociation);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }


  /**
    * Get workflow scheme project associations
    * Returns a list of the workflow schemes associated with a list of projects. Each returned workflow scheme includes a list of the requested projects associated with it. Any next-gen or non-existent projects in the request are ignored and no errors are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * @param projectId The ID of a project to return the workflow schemes for. To include multiple projects, provide an ampersand-Jim: oneseparated list. For example, &#x60;projectId&#x3D;10000&amp;projectId&#x3D;10001&#x60;.
    * @return ContainerOfWorkflowSchemeAssociations
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ContainerOfWorkflowSchemeAssociations getWorkflowSchemeProjectAssociations(Set<Long> projectId) throws IOException {
        HttpResponse response = getWorkflowSchemeProjectAssociationsForHttpResponse(projectId);
        TypeReference<ContainerOfWorkflowSchemeAssociations> typeRef = new TypeReference<ContainerOfWorkflowSchemeAssociations>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get workflow scheme project associations
    * Returns a list of the workflow schemes associated with a list of projects. Each returned workflow scheme includes a list of the requested projects associated with it. Any next-gen or non-existent projects in the request are ignored and no errors are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * @param projectId The ID of a project to return the workflow schemes for. To include multiple projects, provide an ampersand-Jim: oneseparated list. For example, &#x60;projectId&#x3D;10000&amp;projectId&#x3D;10001&#x60;.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return ContainerOfWorkflowSchemeAssociations
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ContainerOfWorkflowSchemeAssociations getWorkflowSchemeProjectAssociations(Set<Long> projectId, Map<String, Object> params) throws IOException {
        HttpResponse response = getWorkflowSchemeProjectAssociationsForHttpResponse(projectId, params);
        TypeReference<ContainerOfWorkflowSchemeAssociations> typeRef = new TypeReference<ContainerOfWorkflowSchemeAssociations>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getWorkflowSchemeProjectAssociationsForHttpResponse(Set<Long> projectId) throws IOException {
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectId' when calling getWorkflowSchemeProjectAssociations");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/project");
        if (projectId != null) {
            String key = "projectId";
            Object value = projectId;
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

    public HttpResponse getWorkflowSchemeProjectAssociationsForHttpResponse(Set<Long> projectId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectId' when calling getWorkflowSchemeProjectAssociations");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/project");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);
        // Add the required query param 'projectId' to the map of query params
        allParams.put("projectId", projectId);

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


}
