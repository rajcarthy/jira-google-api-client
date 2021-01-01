package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.DefaultWorkflow;
import com.atlassian.jira.rest.client.model.IssueTypeWorkflowMapping;
import com.atlassian.jira.rest.client.model.IssueTypesWorkflowMapping;
import com.atlassian.jira.rest.client.model.PageBeanWorkflowScheme;
import com.atlassian.jira.rest.client.model.WorkflowScheme;

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
public class WorkflowSchemesApi {
    private ApiClient apiClient;

    public WorkflowSchemesApi() {
        this(new ApiClient());
    }

    public WorkflowSchemesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Create workflow scheme
    * Creates a workflow scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>201</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * @param workflowScheme The workflowScheme parameter
    * @return WorkflowScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public WorkflowScheme createWorkflowScheme(WorkflowScheme workflowScheme) throws IOException {
        HttpResponse response = createWorkflowSchemeForHttpResponse(workflowScheme);
        TypeReference<WorkflowScheme> typeRef = new TypeReference<WorkflowScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Create workflow scheme
    * Creates a workflow scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>201</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * @param workflowScheme The workflowScheme parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return WorkflowScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public WorkflowScheme createWorkflowScheme(WorkflowScheme workflowScheme, Map<String, Object> params) throws IOException {
        HttpResponse response = createWorkflowSchemeForHttpResponse(workflowScheme, params);
        TypeReference<WorkflowScheme> typeRef = new TypeReference<WorkflowScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse createWorkflowSchemeForHttpResponse(WorkflowScheme workflowScheme) throws IOException {
        // verify the required parameter 'workflowScheme' is set
        if (workflowScheme == null) {
            throw new IllegalArgumentException("Missing the required parameter 'workflowScheme' when calling createWorkflowScheme");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(workflowScheme);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse createWorkflowSchemeForHttpResponse(java.io.InputStream workflowScheme, String mediaType) throws IOException {
          // verify the required parameter 'workflowScheme' is set
              if (workflowScheme == null) {
              throw new IllegalArgumentException("Missing the required parameter 'workflowScheme' when calling createWorkflowScheme");
              }
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme");

              String localVarUrl = uriBuilder.build().toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = workflowScheme == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, workflowScheme);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse createWorkflowSchemeForHttpResponse(WorkflowScheme workflowScheme, Map<String, Object> params) throws IOException {
        // verify the required parameter 'workflowScheme' is set
        if (workflowScheme == null) {
            throw new IllegalArgumentException("Missing the required parameter 'workflowScheme' when calling createWorkflowScheme");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(workflowScheme);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


  /**
    * Delete default workflow
    * Resets the default workflow for a workflow scheme. That is, the default workflow is set to Jira&#39;s system workflow (the *jira* workflow).  Note that active workflow schemes cannot be edited. If the workflow scheme is active, set &#x60;updateDraftIfNeeded&#x60; to &#x60;true&#x60; and a draft workflow scheme is created or updated with the default workflow reset. The draft workflow scheme can be published in Jira.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the workflow scheme cannot be edited and &#x60;updateDraftIfNeeded&#x60; is not &#x60;true&#x60;.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the workflow scheme is not found.
    * @param id The ID of the workflow scheme.
    * @param updateDraftIfNeeded Set to true to create or update the draft of a workflow scheme and delete the mapping from the draft, when the workflow scheme cannot be edited. Defaults to &#x60;false&#x60;.
    * @return WorkflowScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public WorkflowScheme deleteDefaultWorkflow(Long id, Boolean updateDraftIfNeeded) throws IOException {
        HttpResponse response = deleteDefaultWorkflowForHttpResponse(id, updateDraftIfNeeded);
        TypeReference<WorkflowScheme> typeRef = new TypeReference<WorkflowScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Delete default workflow
    * Resets the default workflow for a workflow scheme. That is, the default workflow is set to Jira&#39;s system workflow (the *jira* workflow).  Note that active workflow schemes cannot be edited. If the workflow scheme is active, set &#x60;updateDraftIfNeeded&#x60; to &#x60;true&#x60; and a draft workflow scheme is created or updated with the default workflow reset. The draft workflow scheme can be published in Jira.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the workflow scheme cannot be edited and &#x60;updateDraftIfNeeded&#x60; is not &#x60;true&#x60;.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the workflow scheme is not found.
    * @param id The ID of the workflow scheme.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return WorkflowScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public WorkflowScheme deleteDefaultWorkflow(Long id, Map<String, Object> params) throws IOException {
        HttpResponse response = deleteDefaultWorkflowForHttpResponse(id, params);
        TypeReference<WorkflowScheme> typeRef = new TypeReference<WorkflowScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse deleteDefaultWorkflowForHttpResponse(Long id, Boolean updateDraftIfNeeded) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling deleteDefaultWorkflow");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/default");
        if (updateDraftIfNeeded != null) {
            String key = "updateDraftIfNeeded";
            Object value = updateDraftIfNeeded;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }

    public HttpResponse deleteDefaultWorkflowForHttpResponse(Long id, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling deleteDefaultWorkflow");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/default");

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
    * Delete issue types for workflow in workflow scheme
    * Deletes the workflow-issue type mapping for a workflow in a workflow scheme.  Note that active workflow schemes cannot be edited. If the workflow scheme is active, set &#x60;updateDraftIfNeeded&#x60; to &#x60;true&#x60; and a draft workflow scheme is created or updated with the workflow-issue type mapping deleted. The draft workflow scheme can be published in Jira.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the workflow cannot be edited and &#x60;updateDraftIfNeeded&#x60; is not true.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if any of the following is true:   *  The workflow scheme is not found.  *  The workflow is not found.  *  The workflow is not specified.
    * @param id The ID of the workflow scheme.
    * @param workflowName The name of the workflow.
    * @param updateDraftIfNeeded Set to true to create or update the draft of a workflow scheme and delete the mapping from the draft, when the workflow scheme cannot be edited. Defaults to &#x60;false&#x60;.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteWorkflowMapping(Long id, String workflowName, Boolean updateDraftIfNeeded) throws IOException {
        deleteWorkflowMappingForHttpResponse(id, workflowName, updateDraftIfNeeded);
    }

  /**
    * Delete issue types for workflow in workflow scheme
    * Deletes the workflow-issue type mapping for a workflow in a workflow scheme.  Note that active workflow schemes cannot be edited. If the workflow scheme is active, set &#x60;updateDraftIfNeeded&#x60; to &#x60;true&#x60; and a draft workflow scheme is created or updated with the workflow-issue type mapping deleted. The draft workflow scheme can be published in Jira.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the workflow cannot be edited and &#x60;updateDraftIfNeeded&#x60; is not true.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if any of the following is true:   *  The workflow scheme is not found.  *  The workflow is not found.  *  The workflow is not specified.
    * @param id The ID of the workflow scheme.
    * @param workflowName The name of the workflow.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteWorkflowMapping(Long id, String workflowName, Map<String, Object> params) throws IOException {
        deleteWorkflowMappingForHttpResponse(id, workflowName, params);
    }

    public HttpResponse deleteWorkflowMappingForHttpResponse(Long id, String workflowName, Boolean updateDraftIfNeeded) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling deleteWorkflowMapping");
        }// verify the required parameter 'workflowName' is set
        if (workflowName == null) {
            throw new IllegalArgumentException("Missing the required parameter 'workflowName' when calling deleteWorkflowMapping");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/workflow");
        if (workflowName != null) {
            String key = "workflowName";
            Object value = workflowName;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (updateDraftIfNeeded != null) {
            String key = "updateDraftIfNeeded";
            Object value = updateDraftIfNeeded;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }

    public HttpResponse deleteWorkflowMappingForHttpResponse(Long id, String workflowName, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling deleteWorkflowMapping");
        }// verify the required parameter 'workflowName' is set
        if (workflowName == null) {
            throw new IllegalArgumentException("Missing the required parameter 'workflowName' when calling deleteWorkflowMapping");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/workflow");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);
        // Add the required query param 'workflowName' to the map of query params
        allParams.put("workflowName", workflowName);

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
    * Delete workflow scheme
    * Deletes a workflow scheme. Note that a workflow scheme cannot be deleted if it is active (that is, being used by at least one project).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the scheme is active.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the workflow scheme is not found.
    * @param id The ID of the workflow scheme. Find this ID by editing the desired workflow scheme in Jira. The ID is shown in the URL as &#x60;schemeId&#x60;. For example, *schemeId&#x3D;10301*.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteWorkflowScheme(Long id) throws IOException {
        deleteWorkflowSchemeForHttpResponse(id);
    }

  /**
    * Delete workflow scheme
    * Deletes a workflow scheme. Note that a workflow scheme cannot be deleted if it is active (that is, being used by at least one project).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the scheme is active.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the workflow scheme is not found.
    * @param id The ID of the workflow scheme. Find this ID by editing the desired workflow scheme in Jira. The ID is shown in the URL as &#x60;schemeId&#x60;. For example, *schemeId&#x3D;10301*.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteWorkflowScheme(Long id, Map<String, Object> params) throws IOException {
        deleteWorkflowSchemeForHttpResponse(id, params);
    }

    public HttpResponse deleteWorkflowSchemeForHttpResponse(Long id) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling deleteWorkflowScheme");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }

    public HttpResponse deleteWorkflowSchemeForHttpResponse(Long id, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling deleteWorkflowScheme");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}");

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
    * Delete workflow for issue type in workflow scheme
    * Deletes the issue type-workflow mapping for an issue type in a workflow scheme.  Note that active workflow schemes cannot be edited. If the workflow scheme is active, set &#x60;updateDraftIfNeeded&#x60; to &#x60;true&#x60; and a draft workflow scheme is created or updated with the issue type-workflow mapping deleted. The draft workflow scheme can be published in Jira.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the workflow cannot be edited and &#x60;updateDraftIfNeeded&#x60; is false.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the workflow scheme or issue type is not found.
    * @param id The ID of the workflow scheme.
    * @param issueType The ID of the issue type.
    * @param updateDraftIfNeeded Set to true to create or update the draft of a workflow scheme and update the mapping in the draft, when the workflow scheme cannot be edited. Defaults to &#x60;false&#x60;.
    * @return WorkflowScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public WorkflowScheme deleteWorkflowSchemeIssueType(Long id, String issueType, Boolean updateDraftIfNeeded) throws IOException {
        HttpResponse response = deleteWorkflowSchemeIssueTypeForHttpResponse(id, issueType, updateDraftIfNeeded);
        TypeReference<WorkflowScheme> typeRef = new TypeReference<WorkflowScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Delete workflow for issue type in workflow scheme
    * Deletes the issue type-workflow mapping for an issue type in a workflow scheme.  Note that active workflow schemes cannot be edited. If the workflow scheme is active, set &#x60;updateDraftIfNeeded&#x60; to &#x60;true&#x60; and a draft workflow scheme is created or updated with the issue type-workflow mapping deleted. The draft workflow scheme can be published in Jira.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the workflow cannot be edited and &#x60;updateDraftIfNeeded&#x60; is false.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the workflow scheme or issue type is not found.
    * @param id The ID of the workflow scheme.
    * @param issueType The ID of the issue type.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return WorkflowScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public WorkflowScheme deleteWorkflowSchemeIssueType(Long id, String issueType, Map<String, Object> params) throws IOException {
        HttpResponse response = deleteWorkflowSchemeIssueTypeForHttpResponse(id, issueType, params);
        TypeReference<WorkflowScheme> typeRef = new TypeReference<WorkflowScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse deleteWorkflowSchemeIssueTypeForHttpResponse(Long id, String issueType, Boolean updateDraftIfNeeded) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling deleteWorkflowSchemeIssueType");
        }// verify the required parameter 'issueType' is set
        if (issueType == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueType' when calling deleteWorkflowSchemeIssueType");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        uriVariables.put("issueType", issueType);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/issuetype/{issueType}");
        if (updateDraftIfNeeded != null) {
            String key = "updateDraftIfNeeded";
            Object value = updateDraftIfNeeded;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }

    public HttpResponse deleteWorkflowSchemeIssueTypeForHttpResponse(Long id, String issueType, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling deleteWorkflowSchemeIssueType");
        }// verify the required parameter 'issueType' is set
        if (issueType == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueType' when calling deleteWorkflowSchemeIssueType");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        uriVariables.put("issueType", issueType);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/issuetype/{issueType}");

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
    * Get all workflow schemes
    * Returns a [paginated](#pagination) list of all workflow schemes, not including draft workflow schemes.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * @param startAt The index of the first item to return in a page of results (page offset).
    * @param maxResults The maximum number of items to return per page.
    * @return PageBeanWorkflowScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanWorkflowScheme getAllWorkflowSchemes(Long startAt, Integer maxResults) throws IOException {
        HttpResponse response = getAllWorkflowSchemesForHttpResponse(startAt, maxResults);
        TypeReference<PageBeanWorkflowScheme> typeRef = new TypeReference<PageBeanWorkflowScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get all workflow schemes
    * Returns a [paginated](#pagination) list of all workflow schemes, not including draft workflow schemes.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PageBeanWorkflowScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanWorkflowScheme getAllWorkflowSchemes(Map<String, Object> params) throws IOException {
        HttpResponse response = getAllWorkflowSchemesForHttpResponse(params);
        TypeReference<PageBeanWorkflowScheme> typeRef = new TypeReference<PageBeanWorkflowScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getAllWorkflowSchemesForHttpResponse(Long startAt, Integer maxResults) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme");
        if (startAt != null) {
            String key = "startAt";
            Object value = startAt;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (maxResults != null) {
            String key = "maxResults";
            Object value = maxResults;
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

    public HttpResponse getAllWorkflowSchemesForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme");

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
    * Get default workflow
    * Returns the default workflow for a workflow scheme. The default workflow is the workflow that is assigned any issue types that have not been mapped to any other workflow. The default workflow has *All Unassigned Issue Types* listed in its issue types for the workflow scheme in Jira.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the workflow scheme is not found.
    * @param id The ID of the workflow scheme.
    * @param returnDraftIfExists Set to &#x60;true&#x60; to return the default workflow for the workflow scheme&#39;s draft rather than scheme itself. If the workflow scheme does not have a draft, then the default workflow for the workflow scheme is returned.
    * @return DefaultWorkflow
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public DefaultWorkflow getDefaultWorkflow(Long id, Boolean returnDraftIfExists) throws IOException {
        HttpResponse response = getDefaultWorkflowForHttpResponse(id, returnDraftIfExists);
        TypeReference<DefaultWorkflow> typeRef = new TypeReference<DefaultWorkflow>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get default workflow
    * Returns the default workflow for a workflow scheme. The default workflow is the workflow that is assigned any issue types that have not been mapped to any other workflow. The default workflow has *All Unassigned Issue Types* listed in its issue types for the workflow scheme in Jira.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the workflow scheme is not found.
    * @param id The ID of the workflow scheme.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return DefaultWorkflow
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public DefaultWorkflow getDefaultWorkflow(Long id, Map<String, Object> params) throws IOException {
        HttpResponse response = getDefaultWorkflowForHttpResponse(id, params);
        TypeReference<DefaultWorkflow> typeRef = new TypeReference<DefaultWorkflow>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getDefaultWorkflowForHttpResponse(Long id, Boolean returnDraftIfExists) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling getDefaultWorkflow");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/default");
        if (returnDraftIfExists != null) {
            String key = "returnDraftIfExists";
            Object value = returnDraftIfExists;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getDefaultWorkflowForHttpResponse(Long id, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling getDefaultWorkflow");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/default");

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
    * Get issue types for workflows in workflow scheme
    * Returns the workflow-issue type mappings for a workflow scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if either the workflow scheme or workflow is not found.
    * @param id The ID of the workflow scheme.
    * @param workflowName The name of a workflow in the scheme. Limits the results to the workflow-issue type mapping for the specified workflow.
    * @param returnDraftIfExists Returns the mapping from the workflow scheme&#39;s draft rather than the workflow scheme, if set to true. If no draft exists, the mapping from the workflow scheme is returned.
    * @return IssueTypesWorkflowMapping
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public IssueTypesWorkflowMapping getWorkflow(Long id, String workflowName, Boolean returnDraftIfExists) throws IOException {
        HttpResponse response = getWorkflowForHttpResponse(id, workflowName, returnDraftIfExists);
        TypeReference<IssueTypesWorkflowMapping> typeRef = new TypeReference<IssueTypesWorkflowMapping>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get issue types for workflows in workflow scheme
    * Returns the workflow-issue type mappings for a workflow scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if either the workflow scheme or workflow is not found.
    * @param id The ID of the workflow scheme.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return IssueTypesWorkflowMapping
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public IssueTypesWorkflowMapping getWorkflow(Long id, Map<String, Object> params) throws IOException {
        HttpResponse response = getWorkflowForHttpResponse(id, params);
        TypeReference<IssueTypesWorkflowMapping> typeRef = new TypeReference<IssueTypesWorkflowMapping>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getWorkflowForHttpResponse(Long id, String workflowName, Boolean returnDraftIfExists) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling getWorkflow");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/workflow");
        if (workflowName != null) {
            String key = "workflowName";
            Object value = workflowName;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (returnDraftIfExists != null) {
            String key = "returnDraftIfExists";
            Object value = returnDraftIfExists;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getWorkflowForHttpResponse(Long id, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling getWorkflow");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/workflow");

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
    * Get workflow scheme
    * Returns a workflow scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the workflow scheme is not found.
    * @param id The ID of the workflow scheme. Find this ID by editing the desired workflow scheme in Jira. The ID is shown in the URL as &#x60;schemeId&#x60;. For example, *schemeId&#x3D;10301*.
    * @param returnDraftIfExists Returns the workflow scheme&#39;s draft rather than scheme itself, if set to true. If the workflow scheme does not have a draft, then the workflow scheme is returned.
    * @return WorkflowScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public WorkflowScheme getWorkflowScheme(Long id, Boolean returnDraftIfExists) throws IOException {
        HttpResponse response = getWorkflowSchemeForHttpResponse(id, returnDraftIfExists);
        TypeReference<WorkflowScheme> typeRef = new TypeReference<WorkflowScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get workflow scheme
    * Returns a workflow scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the workflow scheme is not found.
    * @param id The ID of the workflow scheme. Find this ID by editing the desired workflow scheme in Jira. The ID is shown in the URL as &#x60;schemeId&#x60;. For example, *schemeId&#x3D;10301*.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return WorkflowScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public WorkflowScheme getWorkflowScheme(Long id, Map<String, Object> params) throws IOException {
        HttpResponse response = getWorkflowSchemeForHttpResponse(id, params);
        TypeReference<WorkflowScheme> typeRef = new TypeReference<WorkflowScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getWorkflowSchemeForHttpResponse(Long id, Boolean returnDraftIfExists) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling getWorkflowScheme");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}");
        if (returnDraftIfExists != null) {
            String key = "returnDraftIfExists";
            Object value = returnDraftIfExists;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getWorkflowSchemeForHttpResponse(Long id, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling getWorkflowScheme");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}");

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
    * Get workflow for issue type in workflow scheme
    * Returns the issue type-workflow mapping for an issue type in a workflow scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the workflow scheme or issue type is not found.
    * @param id The ID of the workflow scheme.
    * @param issueType The ID of the issue type.
    * @param returnDraftIfExists Returns the mapping from the workflow scheme&#39;s draft rather than the workflow scheme, if set to true. If no draft exists, the mapping from the workflow scheme is returned.
    * @return IssueTypeWorkflowMapping
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public IssueTypeWorkflowMapping getWorkflowSchemeIssueType(Long id, String issueType, Boolean returnDraftIfExists) throws IOException {
        HttpResponse response = getWorkflowSchemeIssueTypeForHttpResponse(id, issueType, returnDraftIfExists);
        TypeReference<IssueTypeWorkflowMapping> typeRef = new TypeReference<IssueTypeWorkflowMapping>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get workflow for issue type in workflow scheme
    * Returns the issue type-workflow mapping for an issue type in a workflow scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the workflow scheme or issue type is not found.
    * @param id The ID of the workflow scheme.
    * @param issueType The ID of the issue type.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return IssueTypeWorkflowMapping
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public IssueTypeWorkflowMapping getWorkflowSchemeIssueType(Long id, String issueType, Map<String, Object> params) throws IOException {
        HttpResponse response = getWorkflowSchemeIssueTypeForHttpResponse(id, issueType, params);
        TypeReference<IssueTypeWorkflowMapping> typeRef = new TypeReference<IssueTypeWorkflowMapping>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getWorkflowSchemeIssueTypeForHttpResponse(Long id, String issueType, Boolean returnDraftIfExists) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling getWorkflowSchemeIssueType");
        }// verify the required parameter 'issueType' is set
        if (issueType == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueType' when calling getWorkflowSchemeIssueType");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        uriVariables.put("issueType", issueType);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/issuetype/{issueType}");
        if (returnDraftIfExists != null) {
            String key = "returnDraftIfExists";
            Object value = returnDraftIfExists;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getWorkflowSchemeIssueTypeForHttpResponse(Long id, String issueType, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling getWorkflowSchemeIssueType");
        }// verify the required parameter 'issueType' is set
        if (issueType == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueType' when calling getWorkflowSchemeIssueType");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        uriVariables.put("issueType", issueType);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/issuetype/{issueType}");

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
    * Set workflow for issue type in workflow scheme
    * Sets the workflow for an issue type in a workflow scheme.  Note that active workflow schemes cannot be edited. If the workflow scheme is active, set &#x60;updateDraftIfNeeded&#x60; to &#x60;true&#x60; in the request body and a draft workflow scheme is created or updated with the new issue type-workflow mapping. The draft workflow scheme can be published in Jira.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the workflow cannot be edited and &#x60;updateDraftIfNeeded&#x60; is false.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the workflow scheme or issue type is not found.
    * @param id The ID of the workflow scheme.
    * @param issueType The ID of the issue type.
    * @param issueTypeWorkflowMapping The issue type-project mapping.
    * @return WorkflowScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public WorkflowScheme setWorkflowSchemeIssueType(Long id, String issueType, IssueTypeWorkflowMapping issueTypeWorkflowMapping) throws IOException {
        HttpResponse response = setWorkflowSchemeIssueTypeForHttpResponse(id, issueType, issueTypeWorkflowMapping);
        TypeReference<WorkflowScheme> typeRef = new TypeReference<WorkflowScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Set workflow for issue type in workflow scheme
    * Sets the workflow for an issue type in a workflow scheme.  Note that active workflow schemes cannot be edited. If the workflow scheme is active, set &#x60;updateDraftIfNeeded&#x60; to &#x60;true&#x60; in the request body and a draft workflow scheme is created or updated with the new issue type-workflow mapping. The draft workflow scheme can be published in Jira.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the workflow cannot be edited and &#x60;updateDraftIfNeeded&#x60; is false.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the workflow scheme or issue type is not found.
    * @param id The ID of the workflow scheme.
    * @param issueType The ID of the issue type.
    * @param issueTypeWorkflowMapping The issue type-project mapping.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return WorkflowScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public WorkflowScheme setWorkflowSchemeIssueType(Long id, String issueType, IssueTypeWorkflowMapping issueTypeWorkflowMapping, Map<String, Object> params) throws IOException {
        HttpResponse response = setWorkflowSchemeIssueTypeForHttpResponse(id, issueType, issueTypeWorkflowMapping, params);
        TypeReference<WorkflowScheme> typeRef = new TypeReference<WorkflowScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse setWorkflowSchemeIssueTypeForHttpResponse(Long id, String issueType, IssueTypeWorkflowMapping issueTypeWorkflowMapping) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling setWorkflowSchemeIssueType");
        }// verify the required parameter 'issueType' is set
        if (issueType == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueType' when calling setWorkflowSchemeIssueType");
        }// verify the required parameter 'issueTypeWorkflowMapping' is set
        if (issueTypeWorkflowMapping == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeWorkflowMapping' when calling setWorkflowSchemeIssueType");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        uriVariables.put("issueType", issueType);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/issuetype/{issueType}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(issueTypeWorkflowMapping);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse setWorkflowSchemeIssueTypeForHttpResponse(Long id, String issueType, java.io.InputStream issueTypeWorkflowMapping, String mediaType) throws IOException {
          // verify the required parameter 'id' is set
              if (id == null) {
              throw new IllegalArgumentException("Missing the required parameter 'id' when calling setWorkflowSchemeIssueType");
              }// verify the required parameter 'issueType' is set
              if (issueType == null) {
              throw new IllegalArgumentException("Missing the required parameter 'issueType' when calling setWorkflowSchemeIssueType");
              }// verify the required parameter 'issueTypeWorkflowMapping' is set
              if (issueTypeWorkflowMapping == null) {
              throw new IllegalArgumentException("Missing the required parameter 'issueTypeWorkflowMapping' when calling setWorkflowSchemeIssueType");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("id", id);
                      uriVariables.put("issueType", issueType);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/issuetype/{issueType}");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = issueTypeWorkflowMapping == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, issueTypeWorkflowMapping);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse setWorkflowSchemeIssueTypeForHttpResponse(Long id, String issueType, IssueTypeWorkflowMapping issueTypeWorkflowMapping, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling setWorkflowSchemeIssueType");
        }// verify the required parameter 'issueType' is set
        if (issueType == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueType' when calling setWorkflowSchemeIssueType");
        }// verify the required parameter 'issueTypeWorkflowMapping' is set
        if (issueTypeWorkflowMapping == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeWorkflowMapping' when calling setWorkflowSchemeIssueType");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        uriVariables.put("issueType", issueType);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/issuetype/{issueType}");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(issueTypeWorkflowMapping);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }


  /**
    * Update default workflow
    * Sets the default workflow for a workflow scheme.  Note that active workflow schemes cannot be edited. If the workflow scheme is active, set &#x60;updateDraftIfNeeded&#x60; to &#x60;true&#x60; in the request object and a draft workflow scheme is created or updated with the new default workflow. The draft workflow scheme can be published in Jira.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the workflow scheme cannot be edited and &#x60;updateDraftIfNeeded&#x60; is not &#x60;true&#x60;.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the workflow scheme is not found.
    * @param id The ID of the workflow scheme.
    * @param defaultWorkflow The new default workflow.
    * @return WorkflowScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public WorkflowScheme updateDefaultWorkflow(Long id, DefaultWorkflow defaultWorkflow) throws IOException {
        HttpResponse response = updateDefaultWorkflowForHttpResponse(id, defaultWorkflow);
        TypeReference<WorkflowScheme> typeRef = new TypeReference<WorkflowScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Update default workflow
    * Sets the default workflow for a workflow scheme.  Note that active workflow schemes cannot be edited. If the workflow scheme is active, set &#x60;updateDraftIfNeeded&#x60; to &#x60;true&#x60; in the request object and a draft workflow scheme is created or updated with the new default workflow. The draft workflow scheme can be published in Jira.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the workflow scheme cannot be edited and &#x60;updateDraftIfNeeded&#x60; is not &#x60;true&#x60;.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the workflow scheme is not found.
    * @param id The ID of the workflow scheme.
    * @param defaultWorkflow The new default workflow.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return WorkflowScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public WorkflowScheme updateDefaultWorkflow(Long id, DefaultWorkflow defaultWorkflow, Map<String, Object> params) throws IOException {
        HttpResponse response = updateDefaultWorkflowForHttpResponse(id, defaultWorkflow, params);
        TypeReference<WorkflowScheme> typeRef = new TypeReference<WorkflowScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse updateDefaultWorkflowForHttpResponse(Long id, DefaultWorkflow defaultWorkflow) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling updateDefaultWorkflow");
        }// verify the required parameter 'defaultWorkflow' is set
        if (defaultWorkflow == null) {
            throw new IllegalArgumentException("Missing the required parameter 'defaultWorkflow' when calling updateDefaultWorkflow");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/default");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(defaultWorkflow);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse updateDefaultWorkflowForHttpResponse(Long id, java.io.InputStream defaultWorkflow, String mediaType) throws IOException {
          // verify the required parameter 'id' is set
              if (id == null) {
              throw new IllegalArgumentException("Missing the required parameter 'id' when calling updateDefaultWorkflow");
              }// verify the required parameter 'defaultWorkflow' is set
              if (defaultWorkflow == null) {
              throw new IllegalArgumentException("Missing the required parameter 'defaultWorkflow' when calling updateDefaultWorkflow");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("id", id);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/default");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = defaultWorkflow == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, defaultWorkflow);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse updateDefaultWorkflowForHttpResponse(Long id, DefaultWorkflow defaultWorkflow, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling updateDefaultWorkflow");
        }// verify the required parameter 'defaultWorkflow' is set
        if (defaultWorkflow == null) {
            throw new IllegalArgumentException("Missing the required parameter 'defaultWorkflow' when calling updateDefaultWorkflow");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/default");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(defaultWorkflow);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }


  /**
    * Set issue types for workflow in workflow scheme
    * Sets the issue types for a workflow in a workflow scheme. The workflow can also be set as the default workflow for the workflow scheme. Unmapped issues types are mapped to the default workflow.  Note that active workflow schemes cannot be edited. If the workflow scheme is active, set &#x60;updateDraftIfNeeded&#x60; to &#x60;true&#x60; in the request body and a draft workflow scheme is created or updated with the new workflow-issue types mappings. The draft workflow scheme can be published in Jira.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if any of the following is true:   *  The workflow scheme is not found.  *  The workflow is not found.  *  The workflow is not specified.
    * @param id The ID of the workflow scheme.
    * @param workflowName The name of the workflow.
    * @param issueTypesWorkflowMapping The issueTypesWorkflowMapping parameter
    * @return WorkflowScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public WorkflowScheme updateWorkflowMapping(Long id, String workflowName, IssueTypesWorkflowMapping issueTypesWorkflowMapping) throws IOException {
        HttpResponse response = updateWorkflowMappingForHttpResponse(id, workflowName, issueTypesWorkflowMapping);
        TypeReference<WorkflowScheme> typeRef = new TypeReference<WorkflowScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Set issue types for workflow in workflow scheme
    * Sets the issue types for a workflow in a workflow scheme. The workflow can also be set as the default workflow for the workflow scheme. Unmapped issues types are mapped to the default workflow.  Note that active workflow schemes cannot be edited. If the workflow scheme is active, set &#x60;updateDraftIfNeeded&#x60; to &#x60;true&#x60; in the request body and a draft workflow scheme is created or updated with the new workflow-issue types mappings. The draft workflow scheme can be published in Jira.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if any of the following is true:   *  The workflow scheme is not found.  *  The workflow is not found.  *  The workflow is not specified.
    * @param id The ID of the workflow scheme.
    * @param workflowName The name of the workflow.
    * @param issueTypesWorkflowMapping The issueTypesWorkflowMapping parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return WorkflowScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public WorkflowScheme updateWorkflowMapping(Long id, String workflowName, IssueTypesWorkflowMapping issueTypesWorkflowMapping, Map<String, Object> params) throws IOException {
        HttpResponse response = updateWorkflowMappingForHttpResponse(id, workflowName, issueTypesWorkflowMapping, params);
        TypeReference<WorkflowScheme> typeRef = new TypeReference<WorkflowScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse updateWorkflowMappingForHttpResponse(Long id, String workflowName, IssueTypesWorkflowMapping issueTypesWorkflowMapping) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling updateWorkflowMapping");
        }// verify the required parameter 'workflowName' is set
        if (workflowName == null) {
            throw new IllegalArgumentException("Missing the required parameter 'workflowName' when calling updateWorkflowMapping");
        }// verify the required parameter 'issueTypesWorkflowMapping' is set
        if (issueTypesWorkflowMapping == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypesWorkflowMapping' when calling updateWorkflowMapping");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/workflow");
        if (workflowName != null) {
            String key = "workflowName";
            Object value = workflowName;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(issueTypesWorkflowMapping);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse updateWorkflowMappingForHttpResponse(Long id, String workflowName, java.io.InputStream issueTypesWorkflowMapping, String mediaType) throws IOException {
          // verify the required parameter 'id' is set
              if (id == null) {
              throw new IllegalArgumentException("Missing the required parameter 'id' when calling updateWorkflowMapping");
              }// verify the required parameter 'workflowName' is set
              if (workflowName == null) {
              throw new IllegalArgumentException("Missing the required parameter 'workflowName' when calling updateWorkflowMapping");
              }// verify the required parameter 'issueTypesWorkflowMapping' is set
              if (issueTypesWorkflowMapping == null) {
              throw new IllegalArgumentException("Missing the required parameter 'issueTypesWorkflowMapping' when calling updateWorkflowMapping");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("id", id);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/workflow");
              if (workflowName != null) {
                  String key = "workflowName";
                  Object value = workflowName;
                  if (value instanceof Collection) {
                    uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
                  } else if (value instanceof Object[]) {
                    uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
                  } else {
                    uriBuilder = uriBuilder.queryParam(key, value);
                  }
              }

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = issueTypesWorkflowMapping == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, issueTypesWorkflowMapping);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse updateWorkflowMappingForHttpResponse(Long id, String workflowName, IssueTypesWorkflowMapping issueTypesWorkflowMapping, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling updateWorkflowMapping");
        }// verify the required parameter 'workflowName' is set
        if (workflowName == null) {
            throw new IllegalArgumentException("Missing the required parameter 'workflowName' when calling updateWorkflowMapping");
        }// verify the required parameter 'issueTypesWorkflowMapping' is set
        if (issueTypesWorkflowMapping == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypesWorkflowMapping' when calling updateWorkflowMapping");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/workflow");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);
        // Add the required query param 'workflowName' to the map of query params
        allParams.put("workflowName", workflowName);

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(issueTypesWorkflowMapping);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }


  /**
    * Update workflow scheme
    * Updates a workflow scheme, including the name, default workflow, issue type to project mappings, and more. If the workflow scheme is active (that is, being used by at least one project), then a draft workflow scheme is created or updated instead, provided that &#x60;updateDraftIfNeeded&#x60; is set to &#x60;true&#x60;.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the workflow scheme is not found.
    * @param id The ID of the workflow scheme. Find this ID by editing the desired workflow scheme in Jira. The ID is shown in the URL as &#x60;schemeId&#x60;. For example, *schemeId&#x3D;10301*.
    * @param workflowScheme The workflowScheme parameter
    * @return WorkflowScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public WorkflowScheme updateWorkflowScheme(Long id, WorkflowScheme workflowScheme) throws IOException {
        HttpResponse response = updateWorkflowSchemeForHttpResponse(id, workflowScheme);
        TypeReference<WorkflowScheme> typeRef = new TypeReference<WorkflowScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Update workflow scheme
    * Updates a workflow scheme, including the name, default workflow, issue type to project mappings, and more. If the workflow scheme is active (that is, being used by at least one project), then a draft workflow scheme is created or updated instead, provided that &#x60;updateDraftIfNeeded&#x60; is set to &#x60;true&#x60;.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the workflow scheme is not found.
    * @param id The ID of the workflow scheme. Find this ID by editing the desired workflow scheme in Jira. The ID is shown in the URL as &#x60;schemeId&#x60;. For example, *schemeId&#x3D;10301*.
    * @param workflowScheme The workflowScheme parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return WorkflowScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public WorkflowScheme updateWorkflowScheme(Long id, WorkflowScheme workflowScheme, Map<String, Object> params) throws IOException {
        HttpResponse response = updateWorkflowSchemeForHttpResponse(id, workflowScheme, params);
        TypeReference<WorkflowScheme> typeRef = new TypeReference<WorkflowScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse updateWorkflowSchemeForHttpResponse(Long id, WorkflowScheme workflowScheme) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling updateWorkflowScheme");
        }// verify the required parameter 'workflowScheme' is set
        if (workflowScheme == null) {
            throw new IllegalArgumentException("Missing the required parameter 'workflowScheme' when calling updateWorkflowScheme");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(workflowScheme);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse updateWorkflowSchemeForHttpResponse(Long id, java.io.InputStream workflowScheme, String mediaType) throws IOException {
          // verify the required parameter 'id' is set
              if (id == null) {
              throw new IllegalArgumentException("Missing the required parameter 'id' when calling updateWorkflowScheme");
              }// verify the required parameter 'workflowScheme' is set
              if (workflowScheme == null) {
              throw new IllegalArgumentException("Missing the required parameter 'workflowScheme' when calling updateWorkflowScheme");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("id", id);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = workflowScheme == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, workflowScheme);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse updateWorkflowSchemeForHttpResponse(Long id, WorkflowScheme workflowScheme, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling updateWorkflowScheme");
        }// verify the required parameter 'workflowScheme' is set
        if (workflowScheme == null) {
            throw new IllegalArgumentException("Missing the required parameter 'workflowScheme' when calling updateWorkflowScheme");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(workflowScheme);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }


}
