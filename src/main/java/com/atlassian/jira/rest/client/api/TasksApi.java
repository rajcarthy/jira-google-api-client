package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.TaskProgressBeanObject;

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
public class TasksApi {
    private ApiClient apiClient;

    public TasksApi() {
        this(new ApiClient());
    }

    public TasksApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Cancel task
    * Cancels a task.  **[Permissions](#permissions) required:** either of:   *  *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).  *  Creator of the task.
    * <p><b>202</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if cancellation of the task is not possible.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the task is not found.
    * @param taskId The ID of the task.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object cancelTask(String taskId) throws IOException {
        HttpResponse response = cancelTaskForHttpResponse(taskId);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Cancel task
    * Cancels a task.  **[Permissions](#permissions) required:** either of:   *  *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).  *  Creator of the task.
    * <p><b>202</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if cancellation of the task is not possible.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the task is not found.
    * @param taskId The ID of the task.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object cancelTask(String taskId, Map<String, Object> params) throws IOException {
        HttpResponse response = cancelTaskForHttpResponse(taskId, params);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse cancelTaskForHttpResponse(String taskId) throws IOException {
        // verify the required parameter 'taskId' is set
        if (taskId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'taskId' when calling cancelTask");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("taskId", taskId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/task/{taskId}/cancel");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = new EmptyContent();
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

    public HttpResponse cancelTaskForHttpResponse(String taskId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'taskId' is set
        if (taskId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'taskId' when calling cancelTask");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("taskId", taskId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/task/{taskId}/cancel");

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

        HttpContent content = new EmptyContent();
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


  /**
    * Get task
    * Returns the status of a [long-running asynchronous task](#async).  When a task has finished, this operation returns the JSON blob applicable to the task. See the documentation of the operation that created the task for details. Task details are not permanently retained. As of September 2019, details are retained for 14 days although this period may change without notice.  **[Permissions](#permissions) required:** either of:   *  *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).  *  Creator of the task.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the task is not found.
    * @param taskId The ID of the task.
    * @return TaskProgressBeanObject
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public TaskProgressBeanObject getTask(String taskId) throws IOException {
        HttpResponse response = getTaskForHttpResponse(taskId);
        TypeReference<TaskProgressBeanObject> typeRef = new TypeReference<TaskProgressBeanObject>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get task
    * Returns the status of a [long-running asynchronous task](#async).  When a task has finished, this operation returns the JSON blob applicable to the task. See the documentation of the operation that created the task for details. Task details are not permanently retained. As of September 2019, details are retained for 14 days although this period may change without notice.  **[Permissions](#permissions) required:** either of:   *  *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).  *  Creator of the task.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the task is not found.
    * @param taskId The ID of the task.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return TaskProgressBeanObject
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public TaskProgressBeanObject getTask(String taskId, Map<String, Object> params) throws IOException {
        HttpResponse response = getTaskForHttpResponse(taskId, params);
        TypeReference<TaskProgressBeanObject> typeRef = new TypeReference<TaskProgressBeanObject>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getTaskForHttpResponse(String taskId) throws IOException {
        // verify the required parameter 'taskId' is set
        if (taskId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'taskId' when calling getTask");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("taskId", taskId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/task/{taskId}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getTaskForHttpResponse(String taskId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'taskId' is set
        if (taskId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'taskId' when calling getTask");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("taskId", taskId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/task/{taskId}");

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
