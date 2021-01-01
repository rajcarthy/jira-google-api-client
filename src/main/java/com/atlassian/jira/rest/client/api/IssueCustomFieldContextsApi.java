package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.CreateCustomFieldContext;
import com.atlassian.jira.rest.client.model.CustomFieldContextUpdateDetails;
import com.atlassian.jira.rest.client.model.IssueTypeIds;
import com.atlassian.jira.rest.client.model.PageBeanContextForProjectAndIssueType;
import com.atlassian.jira.rest.client.model.PageBeanCustomFieldContext;
import com.atlassian.jira.rest.client.model.PageBeanIssueTypeToContextMapping;
import com.atlassian.jira.rest.client.model.ProjectIds;
import com.atlassian.jira.rest.client.model.ProjectIssueTypeMappings;
import java.util.Set;

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
public class IssueCustomFieldContextsApi {
    private ApiClient apiClient;

    public IssueCustomFieldContextsApi() {
        this(new ApiClient());
    }

    public IssueCustomFieldContextsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Add issue types to context
    * Adds issue types to a custom field context, appending the issue types to the issue types list.  A custom field context without any issue types applies to all issue types. Adding issue types to such a custom field context would result in it applying to only the listed issue types.  If any of the issue types exists in the custom field context, the operation fails and no issue types are added.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if operation is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * <p><b>404</b> - Returned if the custom field, context, or issue type is not found.
    * <p><b>409</b> - Returned if the issue type is a sub-task, but sub-tasks are disabled in Jira settings.
    * @param fieldId The ID of the custom field.
    * @param contextId The ID of the context.
    * @param issueTypeIds The issueTypeIds parameter
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object addIssueTypesToContext(String fieldId, Long contextId, IssueTypeIds issueTypeIds) throws IOException {
        HttpResponse response = addIssueTypesToContextForHttpResponse(fieldId, contextId, issueTypeIds);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Add issue types to context
    * Adds issue types to a custom field context, appending the issue types to the issue types list.  A custom field context without any issue types applies to all issue types. Adding issue types to such a custom field context would result in it applying to only the listed issue types.  If any of the issue types exists in the custom field context, the operation fails and no issue types are added.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if operation is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * <p><b>404</b> - Returned if the custom field, context, or issue type is not found.
    * <p><b>409</b> - Returned if the issue type is a sub-task, but sub-tasks are disabled in Jira settings.
    * @param fieldId The ID of the custom field.
    * @param contextId The ID of the context.
    * @param issueTypeIds The issueTypeIds parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object addIssueTypesToContext(String fieldId, Long contextId, IssueTypeIds issueTypeIds, Map<String, Object> params) throws IOException {
        HttpResponse response = addIssueTypesToContextForHttpResponse(fieldId, contextId, issueTypeIds, params);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse addIssueTypesToContextForHttpResponse(String fieldId, Long contextId, IssueTypeIds issueTypeIds) throws IOException {
        // verify the required parameter 'fieldId' is set
        if (fieldId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldId' when calling addIssueTypesToContext");
        }// verify the required parameter 'contextId' is set
        if (contextId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'contextId' when calling addIssueTypesToContext");
        }// verify the required parameter 'issueTypeIds' is set
        if (issueTypeIds == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeIds' when calling addIssueTypesToContext");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldId", fieldId);
        uriVariables.put("contextId", contextId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldId}/context/{contextId}/issuetype");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(issueTypeIds);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse addIssueTypesToContextForHttpResponse(String fieldId, Long contextId, java.io.InputStream issueTypeIds, String mediaType) throws IOException {
          // verify the required parameter 'fieldId' is set
              if (fieldId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'fieldId' when calling addIssueTypesToContext");
              }// verify the required parameter 'contextId' is set
              if (contextId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'contextId' when calling addIssueTypesToContext");
              }// verify the required parameter 'issueTypeIds' is set
              if (issueTypeIds == null) {
              throw new IllegalArgumentException("Missing the required parameter 'issueTypeIds' when calling addIssueTypesToContext");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("fieldId", fieldId);
                      uriVariables.put("contextId", contextId);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldId}/context/{contextId}/issuetype");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = issueTypeIds == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, issueTypeIds);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse addIssueTypesToContextForHttpResponse(String fieldId, Long contextId, IssueTypeIds issueTypeIds, Map<String, Object> params) throws IOException {
        // verify the required parameter 'fieldId' is set
        if (fieldId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldId' when calling addIssueTypesToContext");
        }// verify the required parameter 'contextId' is set
        if (contextId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'contextId' when calling addIssueTypesToContext");
        }// verify the required parameter 'issueTypeIds' is set
        if (issueTypeIds == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeIds' when calling addIssueTypesToContext");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldId", fieldId);
        uriVariables.put("contextId", contextId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldId}/context/{contextId}/issuetype");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(issueTypeIds);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }


  /**
    * Assign custom field context to projects
    * Assigns a custom field context to projects.  If any project in the request is assigned to any context of the custom field, the operation fails.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if operation is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * <p><b>404</b> - Returned if the custom field, context, or project is not found.
    * @param fieldId The ID of the custom field.
    * @param contextId The ID of the context.
    * @param projectIds The projectIds parameter
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object assignProjectsToCustomFieldContext(String fieldId, Long contextId, ProjectIds projectIds) throws IOException {
        HttpResponse response = assignProjectsToCustomFieldContextForHttpResponse(fieldId, contextId, projectIds);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Assign custom field context to projects
    * Assigns a custom field context to projects.  If any project in the request is assigned to any context of the custom field, the operation fails.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if operation is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * <p><b>404</b> - Returned if the custom field, context, or project is not found.
    * @param fieldId The ID of the custom field.
    * @param contextId The ID of the context.
    * @param projectIds The projectIds parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object assignProjectsToCustomFieldContext(String fieldId, Long contextId, ProjectIds projectIds, Map<String, Object> params) throws IOException {
        HttpResponse response = assignProjectsToCustomFieldContextForHttpResponse(fieldId, contextId, projectIds, params);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse assignProjectsToCustomFieldContextForHttpResponse(String fieldId, Long contextId, ProjectIds projectIds) throws IOException {
        // verify the required parameter 'fieldId' is set
        if (fieldId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldId' when calling assignProjectsToCustomFieldContext");
        }// verify the required parameter 'contextId' is set
        if (contextId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'contextId' when calling assignProjectsToCustomFieldContext");
        }// verify the required parameter 'projectIds' is set
        if (projectIds == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectIds' when calling assignProjectsToCustomFieldContext");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldId", fieldId);
        uriVariables.put("contextId", contextId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldId}/context/{contextId}/project");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(projectIds);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse assignProjectsToCustomFieldContextForHttpResponse(String fieldId, Long contextId, java.io.InputStream projectIds, String mediaType) throws IOException {
          // verify the required parameter 'fieldId' is set
              if (fieldId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'fieldId' when calling assignProjectsToCustomFieldContext");
              }// verify the required parameter 'contextId' is set
              if (contextId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'contextId' when calling assignProjectsToCustomFieldContext");
              }// verify the required parameter 'projectIds' is set
              if (projectIds == null) {
              throw new IllegalArgumentException("Missing the required parameter 'projectIds' when calling assignProjectsToCustomFieldContext");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("fieldId", fieldId);
                      uriVariables.put("contextId", contextId);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldId}/context/{contextId}/project");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = projectIds == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, projectIds);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse assignProjectsToCustomFieldContextForHttpResponse(String fieldId, Long contextId, ProjectIds projectIds, Map<String, Object> params) throws IOException {
        // verify the required parameter 'fieldId' is set
        if (fieldId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldId' when calling assignProjectsToCustomFieldContext");
        }// verify the required parameter 'contextId' is set
        if (contextId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'contextId' when calling assignProjectsToCustomFieldContext");
        }// verify the required parameter 'projectIds' is set
        if (projectIds == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectIds' when calling assignProjectsToCustomFieldContext");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldId", fieldId);
        uriVariables.put("contextId", contextId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldId}/context/{contextId}/project");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(projectIds);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }


  /**
    * Create custom field context
    * Creates a custom field context.  If &#x60;projectIds&#x60; is empty, a global context is created. A global context is one that applies to all project. If &#x60;issueTypeIds&#x60; is empty, the context applies to all issue types.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>201</b> - Returned if the custom field context is created.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the field, project, or issue type is not found.
    * <p><b>409</b> - Returned if the issue type is a sub-task, but sub-tasks are disabled in Jira settings.
    * @param fieldId The ID of the custom field.
    * @param createCustomFieldContext The createCustomFieldContext parameter
    * @return CreateCustomFieldContext
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public CreateCustomFieldContext createCustomFieldContext(String fieldId, CreateCustomFieldContext createCustomFieldContext) throws IOException {
        HttpResponse response = createCustomFieldContextForHttpResponse(fieldId, createCustomFieldContext);
        TypeReference<CreateCustomFieldContext> typeRef = new TypeReference<CreateCustomFieldContext>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Create custom field context
    * Creates a custom field context.  If &#x60;projectIds&#x60; is empty, a global context is created. A global context is one that applies to all project. If &#x60;issueTypeIds&#x60; is empty, the context applies to all issue types.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>201</b> - Returned if the custom field context is created.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the field, project, or issue type is not found.
    * <p><b>409</b> - Returned if the issue type is a sub-task, but sub-tasks are disabled in Jira settings.
    * @param fieldId The ID of the custom field.
    * @param createCustomFieldContext The createCustomFieldContext parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return CreateCustomFieldContext
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public CreateCustomFieldContext createCustomFieldContext(String fieldId, CreateCustomFieldContext createCustomFieldContext, Map<String, Object> params) throws IOException {
        HttpResponse response = createCustomFieldContextForHttpResponse(fieldId, createCustomFieldContext, params);
        TypeReference<CreateCustomFieldContext> typeRef = new TypeReference<CreateCustomFieldContext>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse createCustomFieldContextForHttpResponse(String fieldId, CreateCustomFieldContext createCustomFieldContext) throws IOException {
        // verify the required parameter 'fieldId' is set
        if (fieldId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldId' when calling createCustomFieldContext");
        }// verify the required parameter 'createCustomFieldContext' is set
        if (createCustomFieldContext == null) {
            throw new IllegalArgumentException("Missing the required parameter 'createCustomFieldContext' when calling createCustomFieldContext");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldId", fieldId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldId}/context");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(createCustomFieldContext);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse createCustomFieldContextForHttpResponse(String fieldId, java.io.InputStream createCustomFieldContext, String mediaType) throws IOException {
          // verify the required parameter 'fieldId' is set
              if (fieldId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'fieldId' when calling createCustomFieldContext");
              }// verify the required parameter 'createCustomFieldContext' is set
              if (createCustomFieldContext == null) {
              throw new IllegalArgumentException("Missing the required parameter 'createCustomFieldContext' when calling createCustomFieldContext");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("fieldId", fieldId);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldId}/context");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = createCustomFieldContext == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, createCustomFieldContext);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse createCustomFieldContextForHttpResponse(String fieldId, CreateCustomFieldContext createCustomFieldContext, Map<String, Object> params) throws IOException {
        // verify the required parameter 'fieldId' is set
        if (fieldId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldId' when calling createCustomFieldContext");
        }// verify the required parameter 'createCustomFieldContext' is set
        if (createCustomFieldContext == null) {
            throw new IllegalArgumentException("Missing the required parameter 'createCustomFieldContext' when calling createCustomFieldContext");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldId", fieldId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldId}/context");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(createCustomFieldContext);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


  /**
    * Delete custom field context
    * Deletes a [ custom field context](https://confluence.atlassian.com/adminjiracloud/what-are-custom-field-contexts-991923859.html).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the context is deleted.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * <p><b>404</b> - Returned if the custom field or the context is not found.
    * @param fieldId The ID of the custom field.
    * @param contextId The ID of the context.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object deleteCustomFieldContext(String fieldId, Long contextId) throws IOException {
        HttpResponse response = deleteCustomFieldContextForHttpResponse(fieldId, contextId);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Delete custom field context
    * Deletes a [ custom field context](https://confluence.atlassian.com/adminjiracloud/what-are-custom-field-contexts-991923859.html).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the context is deleted.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * <p><b>404</b> - Returned if the custom field or the context is not found.
    * @param fieldId The ID of the custom field.
    * @param contextId The ID of the context.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object deleteCustomFieldContext(String fieldId, Long contextId, Map<String, Object> params) throws IOException {
        HttpResponse response = deleteCustomFieldContextForHttpResponse(fieldId, contextId, params);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse deleteCustomFieldContextForHttpResponse(String fieldId, Long contextId) throws IOException {
        // verify the required parameter 'fieldId' is set
        if (fieldId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldId' when calling deleteCustomFieldContext");
        }// verify the required parameter 'contextId' is set
        if (contextId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'contextId' when calling deleteCustomFieldContext");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldId", fieldId);
        uriVariables.put("contextId", contextId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldId}/context/{contextId}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }

    public HttpResponse deleteCustomFieldContextForHttpResponse(String fieldId, Long contextId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'fieldId' is set
        if (fieldId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldId' when calling deleteCustomFieldContext");
        }// verify the required parameter 'contextId' is set
        if (contextId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'contextId' when calling deleteCustomFieldContext");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldId", fieldId);
        uriVariables.put("contextId", contextId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldId}/context/{contextId}");

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
    * Get custom field contexts
    * Returns a [paginated](#pagination) list of [ contexts](https://confluence.atlassian.com/adminjiracloud/what-are-custom-field-contexts-991923859.html) for a custom field. Contexts can be returned as follows:   *  With no other parameters set, all contexts.  *  By defining &#x60;id&#x60; only, all contexts from the list of IDs.  *  By defining &#x60;isAnyIssueType&#x60;, limit the list of contexts returned to either those that apply to all issue types (true) or those that apply to only a subset of issue types (false)  *  By defining &#x60;isGlobalContext&#x60;, limit the list of contexts return to either those that apply to all projects (global contexts) (true) or those that apply to only a subset of projects (false).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * <p><b>404</b> - Returned if the custom field was not found.
    * @param fieldId The ID of the custom field.
    * @param isAnyIssueType Whether to return contexts that apply to all issue types.
    * @param isGlobalContext Whether to return contexts that apply to all projects.
    * @param contextId The list of context IDs. To include multiple contexts, separate IDs with ampersand: &#x60;contextId&#x3D;10000&amp;contextId&#x3D;10001&#x60;.
    * @param startAt The index of the first item to return in a page of results (page offset).
    * @param maxResults The maximum number of items to return per page.
    * @return PageBeanCustomFieldContext
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanCustomFieldContext getContextsForField(String fieldId, Boolean isAnyIssueType, Boolean isGlobalContext, Set<Long> contextId, Long startAt, Integer maxResults) throws IOException {
        HttpResponse response = getContextsForFieldForHttpResponse(fieldId, isAnyIssueType, isGlobalContext, contextId, startAt, maxResults);
        TypeReference<PageBeanCustomFieldContext> typeRef = new TypeReference<PageBeanCustomFieldContext>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get custom field contexts
    * Returns a [paginated](#pagination) list of [ contexts](https://confluence.atlassian.com/adminjiracloud/what-are-custom-field-contexts-991923859.html) for a custom field. Contexts can be returned as follows:   *  With no other parameters set, all contexts.  *  By defining &#x60;id&#x60; only, all contexts from the list of IDs.  *  By defining &#x60;isAnyIssueType&#x60;, limit the list of contexts returned to either those that apply to all issue types (true) or those that apply to only a subset of issue types (false)  *  By defining &#x60;isGlobalContext&#x60;, limit the list of contexts return to either those that apply to all projects (global contexts) (true) or those that apply to only a subset of projects (false).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * <p><b>404</b> - Returned if the custom field was not found.
    * @param fieldId The ID of the custom field.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PageBeanCustomFieldContext
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanCustomFieldContext getContextsForField(String fieldId, Map<String, Object> params) throws IOException {
        HttpResponse response = getContextsForFieldForHttpResponse(fieldId, params);
        TypeReference<PageBeanCustomFieldContext> typeRef = new TypeReference<PageBeanCustomFieldContext>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getContextsForFieldForHttpResponse(String fieldId, Boolean isAnyIssueType, Boolean isGlobalContext, Set<Long> contextId, Long startAt, Integer maxResults) throws IOException {
        // verify the required parameter 'fieldId' is set
        if (fieldId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldId' when calling getContextsForField");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldId", fieldId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldId}/context");
        if (isAnyIssueType != null) {
            String key = "isAnyIssueType";
            Object value = isAnyIssueType;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (isGlobalContext != null) {
            String key = "isGlobalContext";
            Object value = isGlobalContext;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (contextId != null) {
            String key = "contextId";
            Object value = contextId;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (startAt != null) {
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

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getContextsForFieldForHttpResponse(String fieldId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'fieldId' is set
        if (fieldId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldId' when calling getContextsForField");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldId", fieldId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldId}/context");

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
    * Get custom field contexts for projects and issue types
    * Returns a [paginated](#pagination) list of project and issue type mappings and, for each mapping, the ID of a [custom field context](https://confluence.atlassian.com/x/k44fOw) that applies to the project and issue type.  If there is no custom field context assigned to the project then, if present, the custom field context that applies to all projects is returned if it also applies to the issue type or all issue types. If a custom field context is not found, the returned custom field context ID is &#x60;null&#x60;.  Duplicate project and issue type mappings cannot be provided in the request.  The order of the returned values is the same as provided in the request.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * <p><b>404</b> - Returned if the custom field, project, or issue type is not found.
    * @param fieldId The ID of the custom field.
    * @param projectIssueTypeMappings The list of project and issue type mappings.
    * @param startAt The index of the first item to return in a page of results (page offset).
    * @param maxResults The maximum number of items to return per page.
    * @return PageBeanContextForProjectAndIssueType
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanContextForProjectAndIssueType getCustomFieldContextsForProjectsAndIssueTypes(String fieldId, ProjectIssueTypeMappings projectIssueTypeMappings, Long startAt, Integer maxResults) throws IOException {
        HttpResponse response = getCustomFieldContextsForProjectsAndIssueTypesForHttpResponse(fieldId, projectIssueTypeMappings, startAt, maxResults);
        TypeReference<PageBeanContextForProjectAndIssueType> typeRef = new TypeReference<PageBeanContextForProjectAndIssueType>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get custom field contexts for projects and issue types
    * Returns a [paginated](#pagination) list of project and issue type mappings and, for each mapping, the ID of a [custom field context](https://confluence.atlassian.com/x/k44fOw) that applies to the project and issue type.  If there is no custom field context assigned to the project then, if present, the custom field context that applies to all projects is returned if it also applies to the issue type or all issue types. If a custom field context is not found, the returned custom field context ID is &#x60;null&#x60;.  Duplicate project and issue type mappings cannot be provided in the request.  The order of the returned values is the same as provided in the request.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * <p><b>404</b> - Returned if the custom field, project, or issue type is not found.
    * @param fieldId The ID of the custom field.
    * @param projectIssueTypeMappings The list of project and issue type mappings.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PageBeanContextForProjectAndIssueType
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanContextForProjectAndIssueType getCustomFieldContextsForProjectsAndIssueTypes(String fieldId, ProjectIssueTypeMappings projectIssueTypeMappings, Map<String, Object> params) throws IOException {
        HttpResponse response = getCustomFieldContextsForProjectsAndIssueTypesForHttpResponse(fieldId, projectIssueTypeMappings, params);
        TypeReference<PageBeanContextForProjectAndIssueType> typeRef = new TypeReference<PageBeanContextForProjectAndIssueType>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getCustomFieldContextsForProjectsAndIssueTypesForHttpResponse(String fieldId, ProjectIssueTypeMappings projectIssueTypeMappings, Long startAt, Integer maxResults) throws IOException {
        // verify the required parameter 'fieldId' is set
        if (fieldId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldId' when calling getCustomFieldContextsForProjectsAndIssueTypes");
        }// verify the required parameter 'projectIssueTypeMappings' is set
        if (projectIssueTypeMappings == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectIssueTypeMappings' when calling getCustomFieldContextsForProjectsAndIssueTypes");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldId", fieldId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldId}/context/mapping");
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

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(projectIssueTypeMappings);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse getCustomFieldContextsForProjectsAndIssueTypesForHttpResponse(String fieldId, java.io.InputStream projectIssueTypeMappings, Long startAt, Integer maxResults, String mediaType) throws IOException {
          // verify the required parameter 'fieldId' is set
              if (fieldId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'fieldId' when calling getCustomFieldContextsForProjectsAndIssueTypes");
              }// verify the required parameter 'projectIssueTypeMappings' is set
              if (projectIssueTypeMappings == null) {
              throw new IllegalArgumentException("Missing the required parameter 'projectIssueTypeMappings' when calling getCustomFieldContextsForProjectsAndIssueTypes");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("fieldId", fieldId);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldId}/context/mapping");
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
              }              if (maxResults != null) {
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

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = projectIssueTypeMappings == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, projectIssueTypeMappings);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse getCustomFieldContextsForProjectsAndIssueTypesForHttpResponse(String fieldId, ProjectIssueTypeMappings projectIssueTypeMappings, Map<String, Object> params) throws IOException {
        // verify the required parameter 'fieldId' is set
        if (fieldId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldId' when calling getCustomFieldContextsForProjectsAndIssueTypes");
        }// verify the required parameter 'projectIssueTypeMappings' is set
        if (projectIssueTypeMappings == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectIssueTypeMappings' when calling getCustomFieldContextsForProjectsAndIssueTypes");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldId", fieldId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldId}/context/mapping");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(projectIssueTypeMappings);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


  /**
    * Get issue types for custom field context
    * Returns a [paginated](#pagination) list of context to issue type mappings for a custom field. Mappings are returned for all contexts or a list of contexts. Mappings are ordered first by context ID and then by issue type ID.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if operation is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * @param fieldId The ID of the custom field.
    * @param contextId The ID of the context. To include multiple contexts, provide an ampersand-separated list. For example, &#x60;contextId&#x3D;10001&amp;contextId&#x3D;10002&#x60;.
    * @param startAt The index of the first item to return in a page of results (page offset).
    * @param maxResults The maximum number of items to return per page.
    * @return PageBeanIssueTypeToContextMapping
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanIssueTypeToContextMapping getIssueTypeMappingsForContexts(String fieldId, List<Long> contextId, Long startAt, Integer maxResults) throws IOException {
        HttpResponse response = getIssueTypeMappingsForContextsForHttpResponse(fieldId, contextId, startAt, maxResults);
        TypeReference<PageBeanIssueTypeToContextMapping> typeRef = new TypeReference<PageBeanIssueTypeToContextMapping>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get issue types for custom field context
    * Returns a [paginated](#pagination) list of context to issue type mappings for a custom field. Mappings are returned for all contexts or a list of contexts. Mappings are ordered first by context ID and then by issue type ID.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if operation is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * @param fieldId The ID of the custom field.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PageBeanIssueTypeToContextMapping
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanIssueTypeToContextMapping getIssueTypeMappingsForContexts(String fieldId, Map<String, Object> params) throws IOException {
        HttpResponse response = getIssueTypeMappingsForContextsForHttpResponse(fieldId, params);
        TypeReference<PageBeanIssueTypeToContextMapping> typeRef = new TypeReference<PageBeanIssueTypeToContextMapping>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getIssueTypeMappingsForContextsForHttpResponse(String fieldId, List<Long> contextId, Long startAt, Integer maxResults) throws IOException {
        // verify the required parameter 'fieldId' is set
        if (fieldId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldId' when calling getIssueTypeMappingsForContexts");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldId", fieldId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldId}/context/issueTypeMapping");
        if (contextId != null) {
            String key = "contextId";
            Object value = contextId;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (startAt != null) {
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

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getIssueTypeMappingsForContextsForHttpResponse(String fieldId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'fieldId' is set
        if (fieldId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldId' when calling getIssueTypeMappingsForContexts");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldId", fieldId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldId}/context/issueTypeMapping");

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
    * Remove custom field context from projects
    * Removes a custom field context from projects.  A custom field context without any projects applies to all projects. Removing all projects from a custom field context would result in it applying to all projects.  If any project in the request is not assigned to the context, or the operation would result in two global contexts for the field, the operation fails.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the custom field context is removed from the projects.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * <p><b>404</b> - Returned if the custom field, context, or one or more projects are not found.
    * @param fieldId The ID of the custom field.
    * @param contextId The ID of the context.
    * @param projectIds The projectIds parameter
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object removeCustomFieldContextFromProjects(String fieldId, Long contextId, ProjectIds projectIds) throws IOException {
        HttpResponse response = removeCustomFieldContextFromProjectsForHttpResponse(fieldId, contextId, projectIds);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Remove custom field context from projects
    * Removes a custom field context from projects.  A custom field context without any projects applies to all projects. Removing all projects from a custom field context would result in it applying to all projects.  If any project in the request is not assigned to the context, or the operation would result in two global contexts for the field, the operation fails.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the custom field context is removed from the projects.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * <p><b>404</b> - Returned if the custom field, context, or one or more projects are not found.
    * @param fieldId The ID of the custom field.
    * @param contextId The ID of the context.
    * @param projectIds The projectIds parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object removeCustomFieldContextFromProjects(String fieldId, Long contextId, ProjectIds projectIds, Map<String, Object> params) throws IOException {
        HttpResponse response = removeCustomFieldContextFromProjectsForHttpResponse(fieldId, contextId, projectIds, params);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse removeCustomFieldContextFromProjectsForHttpResponse(String fieldId, Long contextId, ProjectIds projectIds) throws IOException {
        // verify the required parameter 'fieldId' is set
        if (fieldId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldId' when calling removeCustomFieldContextFromProjects");
        }// verify the required parameter 'contextId' is set
        if (contextId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'contextId' when calling removeCustomFieldContextFromProjects");
        }// verify the required parameter 'projectIds' is set
        if (projectIds == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectIds' when calling removeCustomFieldContextFromProjects");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldId", fieldId);
        uriVariables.put("contextId", contextId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldId}/context/{contextId}/project/remove");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(projectIds);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse removeCustomFieldContextFromProjectsForHttpResponse(String fieldId, Long contextId, java.io.InputStream projectIds, String mediaType) throws IOException {
          // verify the required parameter 'fieldId' is set
              if (fieldId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'fieldId' when calling removeCustomFieldContextFromProjects");
              }// verify the required parameter 'contextId' is set
              if (contextId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'contextId' when calling removeCustomFieldContextFromProjects");
              }// verify the required parameter 'projectIds' is set
              if (projectIds == null) {
              throw new IllegalArgumentException("Missing the required parameter 'projectIds' when calling removeCustomFieldContextFromProjects");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("fieldId", fieldId);
                      uriVariables.put("contextId", contextId);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldId}/context/{contextId}/project/remove");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = projectIds == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, projectIds);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse removeCustomFieldContextFromProjectsForHttpResponse(String fieldId, Long contextId, ProjectIds projectIds, Map<String, Object> params) throws IOException {
        // verify the required parameter 'fieldId' is set
        if (fieldId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldId' when calling removeCustomFieldContextFromProjects");
        }// verify the required parameter 'contextId' is set
        if (contextId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'contextId' when calling removeCustomFieldContextFromProjects");
        }// verify the required parameter 'projectIds' is set
        if (projectIds == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectIds' when calling removeCustomFieldContextFromProjects");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldId", fieldId);
        uriVariables.put("contextId", contextId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldId}/context/{contextId}/project/remove");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(projectIds);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


  /**
    * Update custom field context
    * Updates a [ custom field context](https://confluence.atlassian.com/adminjiracloud/what-are-custom-field-contexts-991923859.html).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the context is updated.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * <p><b>404</b> - Returned if the custom field or the context is not found.
    * @param fieldId The ID of the custom field.
    * @param contextId The ID of the context.
    * @param customFieldContextUpdateDetails The customFieldContextUpdateDetails parameter
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object updateCustomFieldContext(String fieldId, Long contextId, CustomFieldContextUpdateDetails customFieldContextUpdateDetails) throws IOException {
        HttpResponse response = updateCustomFieldContextForHttpResponse(fieldId, contextId, customFieldContextUpdateDetails);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Update custom field context
    * Updates a [ custom field context](https://confluence.atlassian.com/adminjiracloud/what-are-custom-field-contexts-991923859.html).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the context is updated.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * <p><b>404</b> - Returned if the custom field or the context is not found.
    * @param fieldId The ID of the custom field.
    * @param contextId The ID of the context.
    * @param customFieldContextUpdateDetails The customFieldContextUpdateDetails parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object updateCustomFieldContext(String fieldId, Long contextId, CustomFieldContextUpdateDetails customFieldContextUpdateDetails, Map<String, Object> params) throws IOException {
        HttpResponse response = updateCustomFieldContextForHttpResponse(fieldId, contextId, customFieldContextUpdateDetails, params);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse updateCustomFieldContextForHttpResponse(String fieldId, Long contextId, CustomFieldContextUpdateDetails customFieldContextUpdateDetails) throws IOException {
        // verify the required parameter 'fieldId' is set
        if (fieldId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldId' when calling updateCustomFieldContext");
        }// verify the required parameter 'contextId' is set
        if (contextId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'contextId' when calling updateCustomFieldContext");
        }// verify the required parameter 'customFieldContextUpdateDetails' is set
        if (customFieldContextUpdateDetails == null) {
            throw new IllegalArgumentException("Missing the required parameter 'customFieldContextUpdateDetails' when calling updateCustomFieldContext");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldId", fieldId);
        uriVariables.put("contextId", contextId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldId}/context/{contextId}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(customFieldContextUpdateDetails);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse updateCustomFieldContextForHttpResponse(String fieldId, Long contextId, java.io.InputStream customFieldContextUpdateDetails, String mediaType) throws IOException {
          // verify the required parameter 'fieldId' is set
              if (fieldId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'fieldId' when calling updateCustomFieldContext");
              }// verify the required parameter 'contextId' is set
              if (contextId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'contextId' when calling updateCustomFieldContext");
              }// verify the required parameter 'customFieldContextUpdateDetails' is set
              if (customFieldContextUpdateDetails == null) {
              throw new IllegalArgumentException("Missing the required parameter 'customFieldContextUpdateDetails' when calling updateCustomFieldContext");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("fieldId", fieldId);
                      uriVariables.put("contextId", contextId);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldId}/context/{contextId}");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = customFieldContextUpdateDetails == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, customFieldContextUpdateDetails);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse updateCustomFieldContextForHttpResponse(String fieldId, Long contextId, CustomFieldContextUpdateDetails customFieldContextUpdateDetails, Map<String, Object> params) throws IOException {
        // verify the required parameter 'fieldId' is set
        if (fieldId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldId' when calling updateCustomFieldContext");
        }// verify the required parameter 'contextId' is set
        if (contextId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'contextId' when calling updateCustomFieldContext");
        }// verify the required parameter 'customFieldContextUpdateDetails' is set
        if (customFieldContextUpdateDetails == null) {
            throw new IllegalArgumentException("Missing the required parameter 'customFieldContextUpdateDetails' when calling updateCustomFieldContext");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldId", fieldId);
        uriVariables.put("contextId", contextId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldId}/context/{contextId}");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(customFieldContextUpdateDetails);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }


}
