package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.DefaultWorkflow;
import com.atlassian.jira.rest.client.model.IssueTypeWorkflowMapping;
import com.atlassian.jira.rest.client.model.IssueTypesWorkflowMapping;
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
public class WorkflowSchemeDraftsApi {
    private ApiClient apiClient;

    public WorkflowSchemeDraftsApi() {
        this(new ApiClient());
    }

    public WorkflowSchemeDraftsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Create draft workflow scheme
    * Create a draft workflow scheme from an active workflow scheme, by copying the active workflow scheme. Note that an active workflow scheme can only have one draft workflow scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>201</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * @param id The ID of the active workflow scheme that the draft is created from.
    * @return WorkflowScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public WorkflowScheme createWorkflowSchemeDraftFromParent(Long id) throws IOException {
        HttpResponse response = createWorkflowSchemeDraftFromParentForHttpResponse(id);
        TypeReference<WorkflowScheme> typeRef = new TypeReference<WorkflowScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Create draft workflow scheme
    * Create a draft workflow scheme from an active workflow scheme, by copying the active workflow scheme. Note that an active workflow scheme can only have one draft workflow scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>201</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * @param id The ID of the active workflow scheme that the draft is created from.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return WorkflowScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public WorkflowScheme createWorkflowSchemeDraftFromParent(Long id, Map<String, Object> params) throws IOException {
        HttpResponse response = createWorkflowSchemeDraftFromParentForHttpResponse(id, params);
        TypeReference<WorkflowScheme> typeRef = new TypeReference<WorkflowScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse createWorkflowSchemeDraftFromParentForHttpResponse(Long id) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling createWorkflowSchemeDraftFromParent");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/createdraft");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = new EmptyContent();
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

    public HttpResponse createWorkflowSchemeDraftFromParentForHttpResponse(Long id, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling createWorkflowSchemeDraftFromParent");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/createdraft");

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
    * Delete draft default workflow
    * Resets the default workflow for a workflow scheme&#39;s draft. That is, the default workflow is set to Jira&#39;s system workflow (the *jira* workflow).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if any of the following is true:   *  The workflow scheme is not found.  *  The workflow scheme does not have a draft.
    * @param id The ID of the workflow scheme that the draft belongs to.
    * @return WorkflowScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public WorkflowScheme deleteDraftDefaultWorkflow(Long id) throws IOException {
        HttpResponse response = deleteDraftDefaultWorkflowForHttpResponse(id);
        TypeReference<WorkflowScheme> typeRef = new TypeReference<WorkflowScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Delete draft default workflow
    * Resets the default workflow for a workflow scheme&#39;s draft. That is, the default workflow is set to Jira&#39;s system workflow (the *jira* workflow).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if any of the following is true:   *  The workflow scheme is not found.  *  The workflow scheme does not have a draft.
    * @param id The ID of the workflow scheme that the draft belongs to.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return WorkflowScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public WorkflowScheme deleteDraftDefaultWorkflow(Long id, Map<String, Object> params) throws IOException {
        HttpResponse response = deleteDraftDefaultWorkflowForHttpResponse(id, params);
        TypeReference<WorkflowScheme> typeRef = new TypeReference<WorkflowScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse deleteDraftDefaultWorkflowForHttpResponse(Long id) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling deleteDraftDefaultWorkflow");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/draft/default");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }

    public HttpResponse deleteDraftDefaultWorkflowForHttpResponse(Long id, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling deleteDraftDefaultWorkflow");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/draft/default");

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
    * Delete issue types for workflow in draft workflow scheme
    * Deletes the workflow-issue type mapping for a workflow in a workflow scheme&#39;s draft.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if any of the following is true:   *  The workflow scheme is not found.  *  The workflow scheme does not have a draft.  *  The workflow is not found.  *  The workflow is not specified.
    * @param id The ID of the workflow scheme that the draft belongs to.
    * @param workflowName The name of the workflow.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteDraftWorkflowMapping(Long id, String workflowName) throws IOException {
        deleteDraftWorkflowMappingForHttpResponse(id, workflowName);
    }

  /**
    * Delete issue types for workflow in draft workflow scheme
    * Deletes the workflow-issue type mapping for a workflow in a workflow scheme&#39;s draft.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if any of the following is true:   *  The workflow scheme is not found.  *  The workflow scheme does not have a draft.  *  The workflow is not found.  *  The workflow is not specified.
    * @param id The ID of the workflow scheme that the draft belongs to.
    * @param workflowName The name of the workflow.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteDraftWorkflowMapping(Long id, String workflowName, Map<String, Object> params) throws IOException {
        deleteDraftWorkflowMappingForHttpResponse(id, workflowName, params);
    }

    public HttpResponse deleteDraftWorkflowMappingForHttpResponse(Long id, String workflowName) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling deleteDraftWorkflowMapping");
        }// verify the required parameter 'workflowName' is set
        if (workflowName == null) {
            throw new IllegalArgumentException("Missing the required parameter 'workflowName' when calling deleteDraftWorkflowMapping");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/draft/workflow");
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

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }

    public HttpResponse deleteDraftWorkflowMappingForHttpResponse(Long id, String workflowName, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling deleteDraftWorkflowMapping");
        }// verify the required parameter 'workflowName' is set
        if (workflowName == null) {
            throw new IllegalArgumentException("Missing the required parameter 'workflowName' when calling deleteDraftWorkflowMapping");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/draft/workflow");

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
    * Delete draft workflow scheme
    * Deletes a draft workflow scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission..
    * <p><b>404</b> - Returned if:   *  the original active workflow scheme is not found.  *  the original active workflow scheme does not have a draft.
    * @param id The ID of the active workflow scheme that the draft was created from.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteWorkflowSchemeDraft(Long id) throws IOException {
        deleteWorkflowSchemeDraftForHttpResponse(id);
    }

  /**
    * Delete draft workflow scheme
    * Deletes a draft workflow scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission..
    * <p><b>404</b> - Returned if:   *  the original active workflow scheme is not found.  *  the original active workflow scheme does not have a draft.
    * @param id The ID of the active workflow scheme that the draft was created from.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteWorkflowSchemeDraft(Long id, Map<String, Object> params) throws IOException {
        deleteWorkflowSchemeDraftForHttpResponse(id, params);
    }

    public HttpResponse deleteWorkflowSchemeDraftForHttpResponse(Long id) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling deleteWorkflowSchemeDraft");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/draft");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }

    public HttpResponse deleteWorkflowSchemeDraftForHttpResponse(Long id, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling deleteWorkflowSchemeDraft");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/draft");

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
    * Delete workflow for issue type in draft workflow scheme
    * Deletes the issue type-workflow mapping for an issue type in a workflow scheme&#39;s draft.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the workflow scheme or issue type is not found.
    * @param id The ID of the workflow scheme that the draft belongs to.
    * @param issueType The ID of the issue type.
    * @return WorkflowScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public WorkflowScheme deleteWorkflowSchemeDraftIssueType(Long id, String issueType) throws IOException {
        HttpResponse response = deleteWorkflowSchemeDraftIssueTypeForHttpResponse(id, issueType);
        TypeReference<WorkflowScheme> typeRef = new TypeReference<WorkflowScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Delete workflow for issue type in draft workflow scheme
    * Deletes the issue type-workflow mapping for an issue type in a workflow scheme&#39;s draft.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the workflow scheme or issue type is not found.
    * @param id The ID of the workflow scheme that the draft belongs to.
    * @param issueType The ID of the issue type.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return WorkflowScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public WorkflowScheme deleteWorkflowSchemeDraftIssueType(Long id, String issueType, Map<String, Object> params) throws IOException {
        HttpResponse response = deleteWorkflowSchemeDraftIssueTypeForHttpResponse(id, issueType, params);
        TypeReference<WorkflowScheme> typeRef = new TypeReference<WorkflowScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse deleteWorkflowSchemeDraftIssueTypeForHttpResponse(Long id, String issueType) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling deleteWorkflowSchemeDraftIssueType");
        }// verify the required parameter 'issueType' is set
        if (issueType == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueType' when calling deleteWorkflowSchemeDraftIssueType");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        uriVariables.put("issueType", issueType);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/draft/issuetype/{issueType}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }

    public HttpResponse deleteWorkflowSchemeDraftIssueTypeForHttpResponse(Long id, String issueType, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling deleteWorkflowSchemeDraftIssueType");
        }// verify the required parameter 'issueType' is set
        if (issueType == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueType' when calling deleteWorkflowSchemeDraftIssueType");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        uriVariables.put("issueType", issueType);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/draft/issuetype/{issueType}");

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
    * Get draft default workflow
    * Returns the default workflow for a workflow scheme&#39;s draft. The default workflow is the workflow that is assigned any issue types that have not been mapped to any other workflow. The default workflow has *All Unassigned Issue Types* listed in its issue types for the workflow scheme in Jira.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission..
    * <p><b>404</b> - Returned if any of the following is true:   *  The workflow scheme is not found.  *  The workflow scheme does not have a draft.
    * @param id The ID of the workflow scheme that the draft belongs to.
    * @return DefaultWorkflow
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public DefaultWorkflow getDraftDefaultWorkflow(Long id) throws IOException {
        HttpResponse response = getDraftDefaultWorkflowForHttpResponse(id);
        TypeReference<DefaultWorkflow> typeRef = new TypeReference<DefaultWorkflow>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get draft default workflow
    * Returns the default workflow for a workflow scheme&#39;s draft. The default workflow is the workflow that is assigned any issue types that have not been mapped to any other workflow. The default workflow has *All Unassigned Issue Types* listed in its issue types for the workflow scheme in Jira.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission..
    * <p><b>404</b> - Returned if any of the following is true:   *  The workflow scheme is not found.  *  The workflow scheme does not have a draft.
    * @param id The ID of the workflow scheme that the draft belongs to.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return DefaultWorkflow
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public DefaultWorkflow getDraftDefaultWorkflow(Long id, Map<String, Object> params) throws IOException {
        HttpResponse response = getDraftDefaultWorkflowForHttpResponse(id, params);
        TypeReference<DefaultWorkflow> typeRef = new TypeReference<DefaultWorkflow>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getDraftDefaultWorkflowForHttpResponse(Long id) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling getDraftDefaultWorkflow");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/draft/default");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getDraftDefaultWorkflowForHttpResponse(Long id, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling getDraftDefaultWorkflow");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/draft/default");

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
    * Get issue types for workflows in draft workflow scheme
    * Returns the workflow-issue type mappings for a workflow scheme&#39;s draft.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if either the workflow scheme or workflow (if specified) is not found. session.
    * @param id The ID of the workflow scheme that the draft belongs to.
    * @param workflowName The name of a workflow in the scheme. Limits the results to the workflow-issue type mapping for the specified workflow.
    * @return IssueTypesWorkflowMapping
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public IssueTypesWorkflowMapping getDraftWorkflow(Long id, String workflowName) throws IOException {
        HttpResponse response = getDraftWorkflowForHttpResponse(id, workflowName);
        TypeReference<IssueTypesWorkflowMapping> typeRef = new TypeReference<IssueTypesWorkflowMapping>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get issue types for workflows in draft workflow scheme
    * Returns the workflow-issue type mappings for a workflow scheme&#39;s draft.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if either the workflow scheme or workflow (if specified) is not found. session.
    * @param id The ID of the workflow scheme that the draft belongs to.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return IssueTypesWorkflowMapping
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public IssueTypesWorkflowMapping getDraftWorkflow(Long id, Map<String, Object> params) throws IOException {
        HttpResponse response = getDraftWorkflowForHttpResponse(id, params);
        TypeReference<IssueTypesWorkflowMapping> typeRef = new TypeReference<IssueTypesWorkflowMapping>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getDraftWorkflowForHttpResponse(Long id, String workflowName) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling getDraftWorkflow");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/draft/workflow");
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

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getDraftWorkflowForHttpResponse(Long id, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling getDraftWorkflow");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/draft/workflow");

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
    * Get draft workflow scheme
    * Returns the draft workflow scheme for an active workflow scheme. Draft workflow schemes allow changes to be made to the active workflow schemes: When an active workflow scheme is updated, a draft copy is created. The draft is modified, then the changes in the draft are copied back to the active workflow scheme. See [Configuring workflow schemes](https://confluence.atlassian.com/x/tohKLg) for more information.   Note that:   *  Only active workflow schemes can have draft workflow schemes.  *  An active workflow scheme can only have one draft workflow scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if:   *  the original active workflow scheme is not found.  *  the original active workflow scheme does not have a draft.
    * @param id The ID of the active workflow scheme that the draft was created from.
    * @return WorkflowScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public WorkflowScheme getWorkflowSchemeDraft(Long id) throws IOException {
        HttpResponse response = getWorkflowSchemeDraftForHttpResponse(id);
        TypeReference<WorkflowScheme> typeRef = new TypeReference<WorkflowScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get draft workflow scheme
    * Returns the draft workflow scheme for an active workflow scheme. Draft workflow schemes allow changes to be made to the active workflow schemes: When an active workflow scheme is updated, a draft copy is created. The draft is modified, then the changes in the draft are copied back to the active workflow scheme. See [Configuring workflow schemes](https://confluence.atlassian.com/x/tohKLg) for more information.   Note that:   *  Only active workflow schemes can have draft workflow schemes.  *  An active workflow scheme can only have one draft workflow scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if:   *  the original active workflow scheme is not found.  *  the original active workflow scheme does not have a draft.
    * @param id The ID of the active workflow scheme that the draft was created from.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return WorkflowScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public WorkflowScheme getWorkflowSchemeDraft(Long id, Map<String, Object> params) throws IOException {
        HttpResponse response = getWorkflowSchemeDraftForHttpResponse(id, params);
        TypeReference<WorkflowScheme> typeRef = new TypeReference<WorkflowScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getWorkflowSchemeDraftForHttpResponse(Long id) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling getWorkflowSchemeDraft");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/draft");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getWorkflowSchemeDraftForHttpResponse(Long id, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling getWorkflowSchemeDraft");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/draft");

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
    * Get workflow for issue type in draft workflow scheme
    * Returns the issue type-workflow mapping for an issue type in a workflow scheme&#39;s draft.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the workflow scheme or issue type is not found.
    * @param id The ID of the workflow scheme that the draft belongs to.
    * @param issueType The ID of the issue type.
    * @return IssueTypeWorkflowMapping
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public IssueTypeWorkflowMapping getWorkflowSchemeDraftIssueType(Long id, String issueType) throws IOException {
        HttpResponse response = getWorkflowSchemeDraftIssueTypeForHttpResponse(id, issueType);
        TypeReference<IssueTypeWorkflowMapping> typeRef = new TypeReference<IssueTypeWorkflowMapping>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get workflow for issue type in draft workflow scheme
    * Returns the issue type-workflow mapping for an issue type in a workflow scheme&#39;s draft.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the workflow scheme or issue type is not found.
    * @param id The ID of the workflow scheme that the draft belongs to.
    * @param issueType The ID of the issue type.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return IssueTypeWorkflowMapping
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public IssueTypeWorkflowMapping getWorkflowSchemeDraftIssueType(Long id, String issueType, Map<String, Object> params) throws IOException {
        HttpResponse response = getWorkflowSchemeDraftIssueTypeForHttpResponse(id, issueType, params);
        TypeReference<IssueTypeWorkflowMapping> typeRef = new TypeReference<IssueTypeWorkflowMapping>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getWorkflowSchemeDraftIssueTypeForHttpResponse(Long id, String issueType) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling getWorkflowSchemeDraftIssueType");
        }// verify the required parameter 'issueType' is set
        if (issueType == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueType' when calling getWorkflowSchemeDraftIssueType");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        uriVariables.put("issueType", issueType);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/draft/issuetype/{issueType}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getWorkflowSchemeDraftIssueTypeForHttpResponse(Long id, String issueType, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling getWorkflowSchemeDraftIssueType");
        }// verify the required parameter 'issueType' is set
        if (issueType == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueType' when calling getWorkflowSchemeDraftIssueType");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        uriVariables.put("issueType", issueType);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/draft/issuetype/{issueType}");

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
    * Set workflow for issue type in draft workflow scheme
    * Sets the workflow for an issue type in a workflow scheme&#39;s draft.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the workflow scheme or issue type is not found.
    * @param id The ID of the workflow scheme that the draft belongs to.
    * @param issueType The ID of the issue type.
    * @param issueTypeWorkflowMapping The issue type-project mapping.
    * @return WorkflowScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public WorkflowScheme setWorkflowSchemeDraftIssueType(Long id, String issueType, IssueTypeWorkflowMapping issueTypeWorkflowMapping) throws IOException {
        HttpResponse response = setWorkflowSchemeDraftIssueTypeForHttpResponse(id, issueType, issueTypeWorkflowMapping);
        TypeReference<WorkflowScheme> typeRef = new TypeReference<WorkflowScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Set workflow for issue type in draft workflow scheme
    * Sets the workflow for an issue type in a workflow scheme&#39;s draft.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the workflow scheme or issue type is not found.
    * @param id The ID of the workflow scheme that the draft belongs to.
    * @param issueType The ID of the issue type.
    * @param issueTypeWorkflowMapping The issue type-project mapping.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return WorkflowScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public WorkflowScheme setWorkflowSchemeDraftIssueType(Long id, String issueType, IssueTypeWorkflowMapping issueTypeWorkflowMapping, Map<String, Object> params) throws IOException {
        HttpResponse response = setWorkflowSchemeDraftIssueTypeForHttpResponse(id, issueType, issueTypeWorkflowMapping, params);
        TypeReference<WorkflowScheme> typeRef = new TypeReference<WorkflowScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse setWorkflowSchemeDraftIssueTypeForHttpResponse(Long id, String issueType, IssueTypeWorkflowMapping issueTypeWorkflowMapping) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling setWorkflowSchemeDraftIssueType");
        }// verify the required parameter 'issueType' is set
        if (issueType == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueType' when calling setWorkflowSchemeDraftIssueType");
        }// verify the required parameter 'issueTypeWorkflowMapping' is set
        if (issueTypeWorkflowMapping == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeWorkflowMapping' when calling setWorkflowSchemeDraftIssueType");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        uriVariables.put("issueType", issueType);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/draft/issuetype/{issueType}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(issueTypeWorkflowMapping);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse setWorkflowSchemeDraftIssueTypeForHttpResponse(Long id, String issueType, java.io.InputStream issueTypeWorkflowMapping, String mediaType) throws IOException {
          // verify the required parameter 'id' is set
              if (id == null) {
              throw new IllegalArgumentException("Missing the required parameter 'id' when calling setWorkflowSchemeDraftIssueType");
              }// verify the required parameter 'issueType' is set
              if (issueType == null) {
              throw new IllegalArgumentException("Missing the required parameter 'issueType' when calling setWorkflowSchemeDraftIssueType");
              }// verify the required parameter 'issueTypeWorkflowMapping' is set
              if (issueTypeWorkflowMapping == null) {
              throw new IllegalArgumentException("Missing the required parameter 'issueTypeWorkflowMapping' when calling setWorkflowSchemeDraftIssueType");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("id", id);
                      uriVariables.put("issueType", issueType);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/draft/issuetype/{issueType}");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = issueTypeWorkflowMapping == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, issueTypeWorkflowMapping);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse setWorkflowSchemeDraftIssueTypeForHttpResponse(Long id, String issueType, IssueTypeWorkflowMapping issueTypeWorkflowMapping, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling setWorkflowSchemeDraftIssueType");
        }// verify the required parameter 'issueType' is set
        if (issueType == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueType' when calling setWorkflowSchemeDraftIssueType");
        }// verify the required parameter 'issueTypeWorkflowMapping' is set
        if (issueTypeWorkflowMapping == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeWorkflowMapping' when calling setWorkflowSchemeDraftIssueType");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        uriVariables.put("issueType", issueType);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/draft/issuetype/{issueType}");

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
    * Update draft default workflow
    * Sets the default workflow for a workflow scheme&#39;s draft.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if any of the following is true:   *  The workflow scheme is not found.  *  The workflow scheme does not have a draft.
    * @param id The ID of the workflow scheme that the draft belongs to.
    * @param defaultWorkflow The object for the new default workflow.
    * @return WorkflowScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public WorkflowScheme updateDraftDefaultWorkflow(Long id, DefaultWorkflow defaultWorkflow) throws IOException {
        HttpResponse response = updateDraftDefaultWorkflowForHttpResponse(id, defaultWorkflow);
        TypeReference<WorkflowScheme> typeRef = new TypeReference<WorkflowScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Update draft default workflow
    * Sets the default workflow for a workflow scheme&#39;s draft.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if any of the following is true:   *  The workflow scheme is not found.  *  The workflow scheme does not have a draft.
    * @param id The ID of the workflow scheme that the draft belongs to.
    * @param defaultWorkflow The object for the new default workflow.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return WorkflowScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public WorkflowScheme updateDraftDefaultWorkflow(Long id, DefaultWorkflow defaultWorkflow, Map<String, Object> params) throws IOException {
        HttpResponse response = updateDraftDefaultWorkflowForHttpResponse(id, defaultWorkflow, params);
        TypeReference<WorkflowScheme> typeRef = new TypeReference<WorkflowScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse updateDraftDefaultWorkflowForHttpResponse(Long id, DefaultWorkflow defaultWorkflow) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling updateDraftDefaultWorkflow");
        }// verify the required parameter 'defaultWorkflow' is set
        if (defaultWorkflow == null) {
            throw new IllegalArgumentException("Missing the required parameter 'defaultWorkflow' when calling updateDraftDefaultWorkflow");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/draft/default");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(defaultWorkflow);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse updateDraftDefaultWorkflowForHttpResponse(Long id, java.io.InputStream defaultWorkflow, String mediaType) throws IOException {
          // verify the required parameter 'id' is set
              if (id == null) {
              throw new IllegalArgumentException("Missing the required parameter 'id' when calling updateDraftDefaultWorkflow");
              }// verify the required parameter 'defaultWorkflow' is set
              if (defaultWorkflow == null) {
              throw new IllegalArgumentException("Missing the required parameter 'defaultWorkflow' when calling updateDraftDefaultWorkflow");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("id", id);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/draft/default");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = defaultWorkflow == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, defaultWorkflow);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse updateDraftDefaultWorkflowForHttpResponse(Long id, DefaultWorkflow defaultWorkflow, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling updateDraftDefaultWorkflow");
        }// verify the required parameter 'defaultWorkflow' is set
        if (defaultWorkflow == null) {
            throw new IllegalArgumentException("Missing the required parameter 'defaultWorkflow' when calling updateDraftDefaultWorkflow");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/draft/default");

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
    * Sets the issue types for a workflow in a workflow scheme&#39;s draft. The workflow can also be set as the default workflow for the draft workflow scheme. Unmapped issues types are mapped to the default workflow.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if any of the following is true:   *  The workflow scheme is not found.  *  The workflow scheme does not have a draft.  *  The workflow is not found.  *  The workflow is not specified.
    * @param id The ID of the workflow scheme that the draft belongs to.
    * @param workflowName The name of the workflow.
    * @param issueTypesWorkflowMapping The issueTypesWorkflowMapping parameter
    * @return WorkflowScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public WorkflowScheme updateDraftWorkflowMapping(Long id, String workflowName, IssueTypesWorkflowMapping issueTypesWorkflowMapping) throws IOException {
        HttpResponse response = updateDraftWorkflowMappingForHttpResponse(id, workflowName, issueTypesWorkflowMapping);
        TypeReference<WorkflowScheme> typeRef = new TypeReference<WorkflowScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Set issue types for workflow in workflow scheme
    * Sets the issue types for a workflow in a workflow scheme&#39;s draft. The workflow can also be set as the default workflow for the draft workflow scheme. Unmapped issues types are mapped to the default workflow.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if any of the following is true:   *  The workflow scheme is not found.  *  The workflow scheme does not have a draft.  *  The workflow is not found.  *  The workflow is not specified.
    * @param id The ID of the workflow scheme that the draft belongs to.
    * @param workflowName The name of the workflow.
    * @param issueTypesWorkflowMapping The issueTypesWorkflowMapping parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return WorkflowScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public WorkflowScheme updateDraftWorkflowMapping(Long id, String workflowName, IssueTypesWorkflowMapping issueTypesWorkflowMapping, Map<String, Object> params) throws IOException {
        HttpResponse response = updateDraftWorkflowMappingForHttpResponse(id, workflowName, issueTypesWorkflowMapping, params);
        TypeReference<WorkflowScheme> typeRef = new TypeReference<WorkflowScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse updateDraftWorkflowMappingForHttpResponse(Long id, String workflowName, IssueTypesWorkflowMapping issueTypesWorkflowMapping) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling updateDraftWorkflowMapping");
        }// verify the required parameter 'workflowName' is set
        if (workflowName == null) {
            throw new IllegalArgumentException("Missing the required parameter 'workflowName' when calling updateDraftWorkflowMapping");
        }// verify the required parameter 'issueTypesWorkflowMapping' is set
        if (issueTypesWorkflowMapping == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypesWorkflowMapping' when calling updateDraftWorkflowMapping");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/draft/workflow");
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

      public HttpResponse updateDraftWorkflowMappingForHttpResponse(Long id, String workflowName, java.io.InputStream issueTypesWorkflowMapping, String mediaType) throws IOException {
          // verify the required parameter 'id' is set
              if (id == null) {
              throw new IllegalArgumentException("Missing the required parameter 'id' when calling updateDraftWorkflowMapping");
              }// verify the required parameter 'workflowName' is set
              if (workflowName == null) {
              throw new IllegalArgumentException("Missing the required parameter 'workflowName' when calling updateDraftWorkflowMapping");
              }// verify the required parameter 'issueTypesWorkflowMapping' is set
              if (issueTypesWorkflowMapping == null) {
              throw new IllegalArgumentException("Missing the required parameter 'issueTypesWorkflowMapping' when calling updateDraftWorkflowMapping");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("id", id);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/draft/workflow");
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

    public HttpResponse updateDraftWorkflowMappingForHttpResponse(Long id, String workflowName, IssueTypesWorkflowMapping issueTypesWorkflowMapping, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling updateDraftWorkflowMapping");
        }// verify the required parameter 'workflowName' is set
        if (workflowName == null) {
            throw new IllegalArgumentException("Missing the required parameter 'workflowName' when calling updateDraftWorkflowMapping");
        }// verify the required parameter 'issueTypesWorkflowMapping' is set
        if (issueTypesWorkflowMapping == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypesWorkflowMapping' when calling updateDraftWorkflowMapping");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/draft/workflow");

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
    * Update draft workflow scheme
    * Updates a draft workflow scheme. If a draft workflow scheme does not exist for the active workflow scheme, then a draft is created. Note that an active workflow scheme can only have one draft workflow scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if:   *  the original active workflow scheme is not found.  *  the original active workflow scheme does not have a draft.
    * @param id The ID of the active workflow scheme that the draft was created from.
    * @param workflowScheme The workflowScheme parameter
    * @return WorkflowScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public WorkflowScheme updateWorkflowSchemeDraft(Long id, WorkflowScheme workflowScheme) throws IOException {
        HttpResponse response = updateWorkflowSchemeDraftForHttpResponse(id, workflowScheme);
        TypeReference<WorkflowScheme> typeRef = new TypeReference<WorkflowScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Update draft workflow scheme
    * Updates a draft workflow scheme. If a draft workflow scheme does not exist for the active workflow scheme, then a draft is created. Note that an active workflow scheme can only have one draft workflow scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if:   *  the original active workflow scheme is not found.  *  the original active workflow scheme does not have a draft.
    * @param id The ID of the active workflow scheme that the draft was created from.
    * @param workflowScheme The workflowScheme parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return WorkflowScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public WorkflowScheme updateWorkflowSchemeDraft(Long id, WorkflowScheme workflowScheme, Map<String, Object> params) throws IOException {
        HttpResponse response = updateWorkflowSchemeDraftForHttpResponse(id, workflowScheme, params);
        TypeReference<WorkflowScheme> typeRef = new TypeReference<WorkflowScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse updateWorkflowSchemeDraftForHttpResponse(Long id, WorkflowScheme workflowScheme) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling updateWorkflowSchemeDraft");
        }// verify the required parameter 'workflowScheme' is set
        if (workflowScheme == null) {
            throw new IllegalArgumentException("Missing the required parameter 'workflowScheme' when calling updateWorkflowSchemeDraft");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/draft");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(workflowScheme);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse updateWorkflowSchemeDraftForHttpResponse(Long id, java.io.InputStream workflowScheme, String mediaType) throws IOException {
          // verify the required parameter 'id' is set
              if (id == null) {
              throw new IllegalArgumentException("Missing the required parameter 'id' when calling updateWorkflowSchemeDraft");
              }// verify the required parameter 'workflowScheme' is set
              if (workflowScheme == null) {
              throw new IllegalArgumentException("Missing the required parameter 'workflowScheme' when calling updateWorkflowSchemeDraft");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("id", id);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/draft");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = workflowScheme == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, workflowScheme);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse updateWorkflowSchemeDraftForHttpResponse(Long id, WorkflowScheme workflowScheme, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling updateWorkflowSchemeDraft");
        }// verify the required parameter 'workflowScheme' is set
        if (workflowScheme == null) {
            throw new IllegalArgumentException("Missing the required parameter 'workflowScheme' when calling updateWorkflowSchemeDraft");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflowscheme/{id}/draft");

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
