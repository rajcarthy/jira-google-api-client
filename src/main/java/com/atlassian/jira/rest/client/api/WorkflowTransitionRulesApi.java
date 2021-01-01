package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.ErrorCollection;
import com.atlassian.jira.rest.client.model.PageBeanWorkflowTransitionRules;
import java.util.Set;
import com.atlassian.jira.rest.client.model.WorkflowTransitionRulesUpdate;
import com.atlassian.jira.rest.client.model.WorkflowTransitionRulesUpdateErrors;

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
public class WorkflowTransitionRulesApi {
    private ApiClient apiClient;

    public WorkflowTransitionRulesApi() {
        this(new ApiClient());
    }

    public WorkflowTransitionRulesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Get workflow transition rule configurations
    * Returns a [paginated](#pagination) list of workflows with transition rules. The workflows can be filtered to return only those containing workflow transition rules:   *  of one or more transition rule types, such as [workflow post functions](https://developer.atlassian.com/cloud/jira/platform/modules/workflow-post-function/).  *  matching one or more transition rule keys.  Only workflows containing transition rules created by the calling Connect app are returned. However, if a workflow is returned all transition rules that match the filters are returned for that workflow.  Due to server-side optimizations, workflows with an empty list of rules may be returned; these workflows can be ignored.  **[Permissions](#permissions) required:** Only Connect apps can use this operation.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>403</b> - Returned if the caller is not a Connect app.
    * <p><b>404</b> - Returned if the any transition rule type is not supported.
    * @param types The types of the transition rules to return.
    * @param startAt The index of the first item to return in a page of results (page offset).
    * @param maxResults The maximum number of items to return per page.
    * @param keys The transition rule class keys, as defined in the Connect app descriptor, of the transition rules to return.
    * @param expand Use [expand](#expansion) to include additional information in the response. This parameter accepts &#x60;transition&#x60;, which, for each rule, returns information about the transition the rule is assigned to.
    * @return PageBeanWorkflowTransitionRules
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanWorkflowTransitionRules getWorkflowTransitionRuleConfigurations(Set<String> types, Long startAt, Integer maxResults, Set<String> keys, String expand) throws IOException {
        HttpResponse response = getWorkflowTransitionRuleConfigurationsForHttpResponse(types, startAt, maxResults, keys, expand);
        TypeReference<PageBeanWorkflowTransitionRules> typeRef = new TypeReference<PageBeanWorkflowTransitionRules>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get workflow transition rule configurations
    * Returns a [paginated](#pagination) list of workflows with transition rules. The workflows can be filtered to return only those containing workflow transition rules:   *  of one or more transition rule types, such as [workflow post functions](https://developer.atlassian.com/cloud/jira/platform/modules/workflow-post-function/).  *  matching one or more transition rule keys.  Only workflows containing transition rules created by the calling Connect app are returned. However, if a workflow is returned all transition rules that match the filters are returned for that workflow.  Due to server-side optimizations, workflows with an empty list of rules may be returned; these workflows can be ignored.  **[Permissions](#permissions) required:** Only Connect apps can use this operation.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>403</b> - Returned if the caller is not a Connect app.
    * <p><b>404</b> - Returned if the any transition rule type is not supported.
    * @param types The types of the transition rules to return.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PageBeanWorkflowTransitionRules
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanWorkflowTransitionRules getWorkflowTransitionRuleConfigurations(Set<String> types, Map<String, Object> params) throws IOException {
        HttpResponse response = getWorkflowTransitionRuleConfigurationsForHttpResponse(types, params);
        TypeReference<PageBeanWorkflowTransitionRules> typeRef = new TypeReference<PageBeanWorkflowTransitionRules>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getWorkflowTransitionRuleConfigurationsForHttpResponse(Set<String> types, Long startAt, Integer maxResults, Set<String> keys, String expand) throws IOException {
        // verify the required parameter 'types' is set
        if (types == null) {
            throw new IllegalArgumentException("Missing the required parameter 'types' when calling getWorkflowTransitionRuleConfigurations");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflow/rule/config");
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
        }        if (types != null) {
            String key = "types";
            Object value = types;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (keys != null) {
            String key = "keys";
            Object value = keys;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (expand != null) {
            String key = "expand";
            Object value = expand;
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

    public HttpResponse getWorkflowTransitionRuleConfigurationsForHttpResponse(Set<String> types, Map<String, Object> params) throws IOException {
        // verify the required parameter 'types' is set
        if (types == null) {
            throw new IllegalArgumentException("Missing the required parameter 'types' when calling getWorkflowTransitionRuleConfigurations");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflow/rule/config");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);
        // Add the required query param 'types' to the map of query params
        allParams.put("types", types);

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
    * Update workflow transition rule configurations
    * Updates configuration of workflow transition rules. The following rule types are supported:   *  [post functions](https://developer.atlassian.com/cloud/jira/platform/modules/workflow-post-function/)  *  [conditions](https://developer.atlassian.com/cloud/jira/platform/modules/workflow-condition/)  *  [validators](https://developer.atlassian.com/cloud/jira/platform/modules/workflow-validator/)  Only rules created by the calling Connect app can be updated.  **[Permissions](#permissions) required:** Only Connect apps can use this operation.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>403</b> - Returned if the caller is not a Connect app.
    * @param workflowTransitionRulesUpdate The workflowTransitionRulesUpdate parameter
    * @return WorkflowTransitionRulesUpdateErrors
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public WorkflowTransitionRulesUpdateErrors updateWorkflowTransitionRuleConfigurations(WorkflowTransitionRulesUpdate workflowTransitionRulesUpdate) throws IOException {
        HttpResponse response = updateWorkflowTransitionRuleConfigurationsForHttpResponse(workflowTransitionRulesUpdate);
        TypeReference<WorkflowTransitionRulesUpdateErrors> typeRef = new TypeReference<WorkflowTransitionRulesUpdateErrors>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Update workflow transition rule configurations
    * Updates configuration of workflow transition rules. The following rule types are supported:   *  [post functions](https://developer.atlassian.com/cloud/jira/platform/modules/workflow-post-function/)  *  [conditions](https://developer.atlassian.com/cloud/jira/platform/modules/workflow-condition/)  *  [validators](https://developer.atlassian.com/cloud/jira/platform/modules/workflow-validator/)  Only rules created by the calling Connect app can be updated.  **[Permissions](#permissions) required:** Only Connect apps can use this operation.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>403</b> - Returned if the caller is not a Connect app.
    * @param workflowTransitionRulesUpdate The workflowTransitionRulesUpdate parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return WorkflowTransitionRulesUpdateErrors
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public WorkflowTransitionRulesUpdateErrors updateWorkflowTransitionRuleConfigurations(WorkflowTransitionRulesUpdate workflowTransitionRulesUpdate, Map<String, Object> params) throws IOException {
        HttpResponse response = updateWorkflowTransitionRuleConfigurationsForHttpResponse(workflowTransitionRulesUpdate, params);
        TypeReference<WorkflowTransitionRulesUpdateErrors> typeRef = new TypeReference<WorkflowTransitionRulesUpdateErrors>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse updateWorkflowTransitionRuleConfigurationsForHttpResponse(WorkflowTransitionRulesUpdate workflowTransitionRulesUpdate) throws IOException {
        // verify the required parameter 'workflowTransitionRulesUpdate' is set
        if (workflowTransitionRulesUpdate == null) {
            throw new IllegalArgumentException("Missing the required parameter 'workflowTransitionRulesUpdate' when calling updateWorkflowTransitionRuleConfigurations");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflow/rule/config");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(workflowTransitionRulesUpdate);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse updateWorkflowTransitionRuleConfigurationsForHttpResponse(java.io.InputStream workflowTransitionRulesUpdate, String mediaType) throws IOException {
          // verify the required parameter 'workflowTransitionRulesUpdate' is set
              if (workflowTransitionRulesUpdate == null) {
              throw new IllegalArgumentException("Missing the required parameter 'workflowTransitionRulesUpdate' when calling updateWorkflowTransitionRuleConfigurations");
              }
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflow/rule/config");

              String localVarUrl = uriBuilder.build().toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = workflowTransitionRulesUpdate == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, workflowTransitionRulesUpdate);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse updateWorkflowTransitionRuleConfigurationsForHttpResponse(WorkflowTransitionRulesUpdate workflowTransitionRulesUpdate, Map<String, Object> params) throws IOException {
        // verify the required parameter 'workflowTransitionRulesUpdate' is set
        if (workflowTransitionRulesUpdate == null) {
            throw new IllegalArgumentException("Missing the required parameter 'workflowTransitionRulesUpdate' when calling updateWorkflowTransitionRuleConfigurations");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflow/rule/config");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(workflowTransitionRulesUpdate);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }


}
