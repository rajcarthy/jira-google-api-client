package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.StatusCategory;

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
public class WorkflowStatusCategoriesApi {
    private ApiClient apiClient;

    public WorkflowStatusCategoriesApi() {
        this(new ApiClient());
    }

    public WorkflowStatusCategoriesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Get all status categories
    * Returns a list of all status categories.  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @return List&lt;StatusCategory&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<StatusCategory> getStatusCategories() throws IOException {
        HttpResponse response = getStatusCategoriesForHttpResponse();
        TypeReference<List<StatusCategory>> typeRef = new TypeReference<List<StatusCategory>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get all status categories
    * Returns a list of all status categories.  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return List&lt;StatusCategory&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<StatusCategory> getStatusCategories(Map<String, Object> params) throws IOException {
        HttpResponse response = getStatusCategoriesForHttpResponse(params);
        TypeReference<List<StatusCategory>> typeRef = new TypeReference<List<StatusCategory>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getStatusCategoriesForHttpResponse() throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/statuscategory");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getStatusCategoriesForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/statuscategory");

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
    * Get status category
    * Returns a status category. Status categories provided a mechanism for categorizing [statuses](#api-rest-api-3-status-idOrName-get).  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the status category is not found.
    * @param idOrKey The ID or key of the status category.
    * @return StatusCategory
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public StatusCategory getStatusCategory(String idOrKey) throws IOException {
        HttpResponse response = getStatusCategoryForHttpResponse(idOrKey);
        TypeReference<StatusCategory> typeRef = new TypeReference<StatusCategory>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get status category
    * Returns a status category. Status categories provided a mechanism for categorizing [statuses](#api-rest-api-3-status-idOrName-get).  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the status category is not found.
    * @param idOrKey The ID or key of the status category.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return StatusCategory
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public StatusCategory getStatusCategory(String idOrKey, Map<String, Object> params) throws IOException {
        HttpResponse response = getStatusCategoryForHttpResponse(idOrKey, params);
        TypeReference<StatusCategory> typeRef = new TypeReference<StatusCategory>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getStatusCategoryForHttpResponse(String idOrKey) throws IOException {
        // verify the required parameter 'idOrKey' is set
        if (idOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'idOrKey' when calling getStatusCategory");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("idOrKey", idOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/statuscategory/{idOrKey}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getStatusCategoryForHttpResponse(String idOrKey, Map<String, Object> params) throws IOException {
        // verify the required parameter 'idOrKey' is set
        if (idOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'idOrKey' when calling getStatusCategory");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("idOrKey", idOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/statuscategory/{idOrKey}");

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
