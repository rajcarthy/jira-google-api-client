package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.StatusDetails;

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
public class WorkflowStatusesApi {
    private ApiClient apiClient;

    public WorkflowStatusesApi() {
        this(new ApiClient());
    }

    public WorkflowStatusesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Get status
    * Returns a status. The status must be associated with a workflow to be returned.  If a name is used on more than one status, only the status found first is returned. Therefore, identifying the status by its ID may be preferable.  This operation can be accessed anonymously.  [Permissions](#permissions) required: None.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if:   *  the status is not found.  *  the status is not associated with a workflow.  *  the user does not have the required permissions.
    * @param idOrName The ID or name of the status.
    * @return StatusDetails
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public StatusDetails getStatus(String idOrName) throws IOException {
        HttpResponse response = getStatusForHttpResponse(idOrName);
        TypeReference<StatusDetails> typeRef = new TypeReference<StatusDetails>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get status
    * Returns a status. The status must be associated with a workflow to be returned.  If a name is used on more than one status, only the status found first is returned. Therefore, identifying the status by its ID may be preferable.  This operation can be accessed anonymously.  [Permissions](#permissions) required: None.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if:   *  the status is not found.  *  the status is not associated with a workflow.  *  the user does not have the required permissions.
    * @param idOrName The ID or name of the status.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return StatusDetails
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public StatusDetails getStatus(String idOrName, Map<String, Object> params) throws IOException {
        HttpResponse response = getStatusForHttpResponse(idOrName, params);
        TypeReference<StatusDetails> typeRef = new TypeReference<StatusDetails>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getStatusForHttpResponse(String idOrName) throws IOException {
        // verify the required parameter 'idOrName' is set
        if (idOrName == null) {
            throw new IllegalArgumentException("Missing the required parameter 'idOrName' when calling getStatus");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("idOrName", idOrName);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/status/{idOrName}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getStatusForHttpResponse(String idOrName, Map<String, Object> params) throws IOException {
        // verify the required parameter 'idOrName' is set
        if (idOrName == null) {
            throw new IllegalArgumentException("Missing the required parameter 'idOrName' when calling getStatus");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("idOrName", idOrName);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/status/{idOrName}");

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
    * Get all statuses
    * Returns a list of all statuses associated with workflows.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @return List&lt;StatusDetails&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<StatusDetails> getStatuses() throws IOException {
        HttpResponse response = getStatusesForHttpResponse();
        TypeReference<List<StatusDetails>> typeRef = new TypeReference<List<StatusDetails>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get all statuses
    * Returns a list of all statuses associated with workflows.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return List&lt;StatusDetails&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<StatusDetails> getStatuses(Map<String, Object> params) throws IOException {
        HttpResponse response = getStatusesForHttpResponse(params);
        TypeReference<List<StatusDetails>> typeRef = new TypeReference<List<StatusDetails>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getStatusesForHttpResponse() throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/status");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getStatusesForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/status");

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


}
