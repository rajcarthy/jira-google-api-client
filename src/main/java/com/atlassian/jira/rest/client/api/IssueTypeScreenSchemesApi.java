package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.IssueTypeIds;
import com.atlassian.jira.rest.client.model.IssueTypeScreenSchemeDetails;
import com.atlassian.jira.rest.client.model.IssueTypeScreenSchemeId;
import com.atlassian.jira.rest.client.model.IssueTypeScreenSchemeMappingDetails;
import com.atlassian.jira.rest.client.model.IssueTypeScreenSchemeProjectAssociation;
import com.atlassian.jira.rest.client.model.IssueTypeScreenSchemeUpdateDetails;
import com.atlassian.jira.rest.client.model.PageBeanIssueTypeScreenScheme;
import com.atlassian.jira.rest.client.model.PageBeanIssueTypeScreenSchemeItem;
import com.atlassian.jira.rest.client.model.PageBeanIssueTypeScreenSchemesProjects;
import java.util.Set;
import com.atlassian.jira.rest.client.model.UpdateDefaultScreenScheme;

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
public class IssueTypeScreenSchemesApi {
    private ApiClient apiClient;

    public IssueTypeScreenSchemesApi() {
        this(new ApiClient());
    }

    public IssueTypeScreenSchemesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Append mappings to issue type screen scheme
    * Appends issue type to screen scheme mappings to an issue type screen scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * <p><b>404</b> - Returned if the issue type screen scheme, issue type, or screen scheme is not found.
    * <p><b>409</b> - Returned if the issue type is a sub-task, but sub-tasks are disabled in Jira settings.
    * @param issueTypeScreenSchemeId The ID of the issue type screen scheme.
    * @param issueTypeScreenSchemeMappingDetails The issueTypeScreenSchemeMappingDetails parameter
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object appendMappingsForIssueTypeScreenScheme(String issueTypeScreenSchemeId, IssueTypeScreenSchemeMappingDetails issueTypeScreenSchemeMappingDetails) throws IOException {
        HttpResponse response = appendMappingsForIssueTypeScreenSchemeForHttpResponse(issueTypeScreenSchemeId, issueTypeScreenSchemeMappingDetails);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Append mappings to issue type screen scheme
    * Appends issue type to screen scheme mappings to an issue type screen scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * <p><b>404</b> - Returned if the issue type screen scheme, issue type, or screen scheme is not found.
    * <p><b>409</b> - Returned if the issue type is a sub-task, but sub-tasks are disabled in Jira settings.
    * @param issueTypeScreenSchemeId The ID of the issue type screen scheme.
    * @param issueTypeScreenSchemeMappingDetails The issueTypeScreenSchemeMappingDetails parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object appendMappingsForIssueTypeScreenScheme(String issueTypeScreenSchemeId, IssueTypeScreenSchemeMappingDetails issueTypeScreenSchemeMappingDetails, Map<String, Object> params) throws IOException {
        HttpResponse response = appendMappingsForIssueTypeScreenSchemeForHttpResponse(issueTypeScreenSchemeId, issueTypeScreenSchemeMappingDetails, params);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse appendMappingsForIssueTypeScreenSchemeForHttpResponse(String issueTypeScreenSchemeId, IssueTypeScreenSchemeMappingDetails issueTypeScreenSchemeMappingDetails) throws IOException {
        // verify the required parameter 'issueTypeScreenSchemeId' is set
        if (issueTypeScreenSchemeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeScreenSchemeId' when calling appendMappingsForIssueTypeScreenScheme");
        }// verify the required parameter 'issueTypeScreenSchemeMappingDetails' is set
        if (issueTypeScreenSchemeMappingDetails == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeScreenSchemeMappingDetails' when calling appendMappingsForIssueTypeScreenScheme");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueTypeScreenSchemeId", issueTypeScreenSchemeId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescreenscheme/{issueTypeScreenSchemeId}/mapping");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(issueTypeScreenSchemeMappingDetails);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse appendMappingsForIssueTypeScreenSchemeForHttpResponse(String issueTypeScreenSchemeId, java.io.InputStream issueTypeScreenSchemeMappingDetails, String mediaType) throws IOException {
          // verify the required parameter 'issueTypeScreenSchemeId' is set
              if (issueTypeScreenSchemeId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'issueTypeScreenSchemeId' when calling appendMappingsForIssueTypeScreenScheme");
              }// verify the required parameter 'issueTypeScreenSchemeMappingDetails' is set
              if (issueTypeScreenSchemeMappingDetails == null) {
              throw new IllegalArgumentException("Missing the required parameter 'issueTypeScreenSchemeMappingDetails' when calling appendMappingsForIssueTypeScreenScheme");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("issueTypeScreenSchemeId", issueTypeScreenSchemeId);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescreenscheme/{issueTypeScreenSchemeId}/mapping");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = issueTypeScreenSchemeMappingDetails == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, issueTypeScreenSchemeMappingDetails);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse appendMappingsForIssueTypeScreenSchemeForHttpResponse(String issueTypeScreenSchemeId, IssueTypeScreenSchemeMappingDetails issueTypeScreenSchemeMappingDetails, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueTypeScreenSchemeId' is set
        if (issueTypeScreenSchemeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeScreenSchemeId' when calling appendMappingsForIssueTypeScreenScheme");
        }// verify the required parameter 'issueTypeScreenSchemeMappingDetails' is set
        if (issueTypeScreenSchemeMappingDetails == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeScreenSchemeMappingDetails' when calling appendMappingsForIssueTypeScreenScheme");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueTypeScreenSchemeId", issueTypeScreenSchemeId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescreenscheme/{issueTypeScreenSchemeId}/mapping");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(issueTypeScreenSchemeMappingDetails);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }


  /**
    * Assign issue type screen scheme to project
    * Assigns an issue type screen scheme to a project.  Issue type screen schemes can only be assigned to classic projects.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  project is not found.  *  issue type screen scheme is not found.  *  the project is not a classic project.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * <p><b>404</b> - Returned if the issue type screen scheme or the project are missing.
    * @param issueTypeScreenSchemeProjectAssociation The issueTypeScreenSchemeProjectAssociation parameter
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object assignIssueTypeScreenSchemeToProject(IssueTypeScreenSchemeProjectAssociation issueTypeScreenSchemeProjectAssociation) throws IOException {
        HttpResponse response = assignIssueTypeScreenSchemeToProjectForHttpResponse(issueTypeScreenSchemeProjectAssociation);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Assign issue type screen scheme to project
    * Assigns an issue type screen scheme to a project.  Issue type screen schemes can only be assigned to classic projects.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  project is not found.  *  issue type screen scheme is not found.  *  the project is not a classic project.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * <p><b>404</b> - Returned if the issue type screen scheme or the project are missing.
    * @param issueTypeScreenSchemeProjectAssociation The issueTypeScreenSchemeProjectAssociation parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object assignIssueTypeScreenSchemeToProject(IssueTypeScreenSchemeProjectAssociation issueTypeScreenSchemeProjectAssociation, Map<String, Object> params) throws IOException {
        HttpResponse response = assignIssueTypeScreenSchemeToProjectForHttpResponse(issueTypeScreenSchemeProjectAssociation, params);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse assignIssueTypeScreenSchemeToProjectForHttpResponse(IssueTypeScreenSchemeProjectAssociation issueTypeScreenSchemeProjectAssociation) throws IOException {
        // verify the required parameter 'issueTypeScreenSchemeProjectAssociation' is set
        if (issueTypeScreenSchemeProjectAssociation == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeScreenSchemeProjectAssociation' when calling assignIssueTypeScreenSchemeToProject");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescreenscheme/project");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(issueTypeScreenSchemeProjectAssociation);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse assignIssueTypeScreenSchemeToProjectForHttpResponse(java.io.InputStream issueTypeScreenSchemeProjectAssociation, String mediaType) throws IOException {
          // verify the required parameter 'issueTypeScreenSchemeProjectAssociation' is set
              if (issueTypeScreenSchemeProjectAssociation == null) {
              throw new IllegalArgumentException("Missing the required parameter 'issueTypeScreenSchemeProjectAssociation' when calling assignIssueTypeScreenSchemeToProject");
              }
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescreenscheme/project");

              String localVarUrl = uriBuilder.build().toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = issueTypeScreenSchemeProjectAssociation == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, issueTypeScreenSchemeProjectAssociation);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse assignIssueTypeScreenSchemeToProjectForHttpResponse(IssueTypeScreenSchemeProjectAssociation issueTypeScreenSchemeProjectAssociation, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueTypeScreenSchemeProjectAssociation' is set
        if (issueTypeScreenSchemeProjectAssociation == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeScreenSchemeProjectAssociation' when calling assignIssueTypeScreenSchemeToProject");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescreenscheme/project");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(issueTypeScreenSchemeProjectAssociation);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }


  /**
    * Create issue type screen scheme
    * Creates an issue type screen scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>201</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * <p><b>404</b> - Returned if the issue type or screen scheme is not found.
    * <p><b>409</b> - Returned if the issue type is a sub-task, but sub-tasks are disabled in Jira settings.
    * @param issueTypeScreenSchemeDetails An issue type screen scheme bean.
    * @return IssueTypeScreenSchemeId
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public IssueTypeScreenSchemeId createIssueTypeScreenScheme(IssueTypeScreenSchemeDetails issueTypeScreenSchemeDetails) throws IOException {
        HttpResponse response = createIssueTypeScreenSchemeForHttpResponse(issueTypeScreenSchemeDetails);
        TypeReference<IssueTypeScreenSchemeId> typeRef = new TypeReference<IssueTypeScreenSchemeId>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Create issue type screen scheme
    * Creates an issue type screen scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>201</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * <p><b>404</b> - Returned if the issue type or screen scheme is not found.
    * <p><b>409</b> - Returned if the issue type is a sub-task, but sub-tasks are disabled in Jira settings.
    * @param issueTypeScreenSchemeDetails An issue type screen scheme bean.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return IssueTypeScreenSchemeId
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public IssueTypeScreenSchemeId createIssueTypeScreenScheme(IssueTypeScreenSchemeDetails issueTypeScreenSchemeDetails, Map<String, Object> params) throws IOException {
        HttpResponse response = createIssueTypeScreenSchemeForHttpResponse(issueTypeScreenSchemeDetails, params);
        TypeReference<IssueTypeScreenSchemeId> typeRef = new TypeReference<IssueTypeScreenSchemeId>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse createIssueTypeScreenSchemeForHttpResponse(IssueTypeScreenSchemeDetails issueTypeScreenSchemeDetails) throws IOException {
        // verify the required parameter 'issueTypeScreenSchemeDetails' is set
        if (issueTypeScreenSchemeDetails == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeScreenSchemeDetails' when calling createIssueTypeScreenScheme");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescreenscheme");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(issueTypeScreenSchemeDetails);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse createIssueTypeScreenSchemeForHttpResponse(java.io.InputStream issueTypeScreenSchemeDetails, String mediaType) throws IOException {
          // verify the required parameter 'issueTypeScreenSchemeDetails' is set
              if (issueTypeScreenSchemeDetails == null) {
              throw new IllegalArgumentException("Missing the required parameter 'issueTypeScreenSchemeDetails' when calling createIssueTypeScreenScheme");
              }
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescreenscheme");

              String localVarUrl = uriBuilder.build().toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = issueTypeScreenSchemeDetails == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, issueTypeScreenSchemeDetails);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse createIssueTypeScreenSchemeForHttpResponse(IssueTypeScreenSchemeDetails issueTypeScreenSchemeDetails, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueTypeScreenSchemeDetails' is set
        if (issueTypeScreenSchemeDetails == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeScreenSchemeDetails' when calling createIssueTypeScreenScheme");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescreenscheme");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(issueTypeScreenSchemeDetails);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


  /**
    * Delete issue type screen scheme
    * Deletes an issue type screen scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the issue type screen scheme is deleted.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * <p><b>404</b> - Returned if the issue type screen scheme is not found.
    * @param issueTypeScreenSchemeId The ID of the issue type screen scheme.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object deleteIssueTypeScreenScheme(String issueTypeScreenSchemeId) throws IOException {
        HttpResponse response = deleteIssueTypeScreenSchemeForHttpResponse(issueTypeScreenSchemeId);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Delete issue type screen scheme
    * Deletes an issue type screen scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the issue type screen scheme is deleted.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * <p><b>404</b> - Returned if the issue type screen scheme is not found.
    * @param issueTypeScreenSchemeId The ID of the issue type screen scheme.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object deleteIssueTypeScreenScheme(String issueTypeScreenSchemeId, Map<String, Object> params) throws IOException {
        HttpResponse response = deleteIssueTypeScreenSchemeForHttpResponse(issueTypeScreenSchemeId, params);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse deleteIssueTypeScreenSchemeForHttpResponse(String issueTypeScreenSchemeId) throws IOException {
        // verify the required parameter 'issueTypeScreenSchemeId' is set
        if (issueTypeScreenSchemeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeScreenSchemeId' when calling deleteIssueTypeScreenScheme");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueTypeScreenSchemeId", issueTypeScreenSchemeId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescreenscheme/{issueTypeScreenSchemeId}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }

    public HttpResponse deleteIssueTypeScreenSchemeForHttpResponse(String issueTypeScreenSchemeId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueTypeScreenSchemeId' is set
        if (issueTypeScreenSchemeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeScreenSchemeId' when calling deleteIssueTypeScreenScheme");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueTypeScreenSchemeId", issueTypeScreenSchemeId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescreenscheme/{issueTypeScreenSchemeId}");

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
    * Get issue type screen scheme items
    * Returns a [paginated](#pagination) list of issue type screen scheme items.  Only issue type screen schemes used in classic projects are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * @param startAt The index of the first item to return in a page of results (page offset).
    * @param maxResults The maximum number of items to return per page.
    * @param issueTypeScreenSchemeId The list of issue type screen scheme IDs. To include multiple issue type screen schemes, separate IDs with ampersand: &#x60;issueTypeScreenSchemeId&#x3D;10000&amp;issueTypeScreenSchemeId&#x3D;10001&#x60;.
    * @return PageBeanIssueTypeScreenSchemeItem
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanIssueTypeScreenSchemeItem getIssueTypeScreenSchemeMappings(Long startAt, Integer maxResults, Set<Long> issueTypeScreenSchemeId) throws IOException {
        HttpResponse response = getIssueTypeScreenSchemeMappingsForHttpResponse(startAt, maxResults, issueTypeScreenSchemeId);
        TypeReference<PageBeanIssueTypeScreenSchemeItem> typeRef = new TypeReference<PageBeanIssueTypeScreenSchemeItem>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get issue type screen scheme items
    * Returns a [paginated](#pagination) list of issue type screen scheme items.  Only issue type screen schemes used in classic projects are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PageBeanIssueTypeScreenSchemeItem
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanIssueTypeScreenSchemeItem getIssueTypeScreenSchemeMappings(Map<String, Object> params) throws IOException {
        HttpResponse response = getIssueTypeScreenSchemeMappingsForHttpResponse(params);
        TypeReference<PageBeanIssueTypeScreenSchemeItem> typeRef = new TypeReference<PageBeanIssueTypeScreenSchemeItem>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getIssueTypeScreenSchemeMappingsForHttpResponse(Long startAt, Integer maxResults, Set<Long> issueTypeScreenSchemeId) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescreenscheme/mapping");
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
        }        if (issueTypeScreenSchemeId != null) {
            String key = "issueTypeScreenSchemeId";
            Object value = issueTypeScreenSchemeId;
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

    public HttpResponse getIssueTypeScreenSchemeMappingsForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescreenscheme/mapping");

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
    * Get issue type screen schemes for projects
    * Returns a [paginated](#pagination) list of issue type screen schemes and, for each issue type screen scheme, a list of the projects that use it.  Only issue type screen schemes used in classic projects are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * @param projectId The list of project IDs. To include multiple projects, separate IDs with ampersand: &#x60;projectId&#x3D;10000&amp;projectId&#x3D;10001&#x60;.
    * @param startAt The index of the first item to return in a page of results (page offset).
    * @param maxResults The maximum number of items to return per page.
    * @return PageBeanIssueTypeScreenSchemesProjects
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanIssueTypeScreenSchemesProjects getIssueTypeScreenSchemeProjectAssociations(Set<Long> projectId, Long startAt, Integer maxResults) throws IOException {
        HttpResponse response = getIssueTypeScreenSchemeProjectAssociationsForHttpResponse(projectId, startAt, maxResults);
        TypeReference<PageBeanIssueTypeScreenSchemesProjects> typeRef = new TypeReference<PageBeanIssueTypeScreenSchemesProjects>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get issue type screen schemes for projects
    * Returns a [paginated](#pagination) list of issue type screen schemes and, for each issue type screen scheme, a list of the projects that use it.  Only issue type screen schemes used in classic projects are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * @param projectId The list of project IDs. To include multiple projects, separate IDs with ampersand: &#x60;projectId&#x3D;10000&amp;projectId&#x3D;10001&#x60;.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PageBeanIssueTypeScreenSchemesProjects
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanIssueTypeScreenSchemesProjects getIssueTypeScreenSchemeProjectAssociations(Set<Long> projectId, Map<String, Object> params) throws IOException {
        HttpResponse response = getIssueTypeScreenSchemeProjectAssociationsForHttpResponse(projectId, params);
        TypeReference<PageBeanIssueTypeScreenSchemesProjects> typeRef = new TypeReference<PageBeanIssueTypeScreenSchemesProjects>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getIssueTypeScreenSchemeProjectAssociationsForHttpResponse(Set<Long> projectId, Long startAt, Integer maxResults) throws IOException {
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectId' when calling getIssueTypeScreenSchemeProjectAssociations");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescreenscheme/project");
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
        }        if (projectId != null) {
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

    public HttpResponse getIssueTypeScreenSchemeProjectAssociationsForHttpResponse(Set<Long> projectId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectId' when calling getIssueTypeScreenSchemeProjectAssociations");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescreenscheme/project");

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


  /**
    * Get issue type screen schemes
    * Returns a [paginated](#pagination) list of issue type screen schemes.  Only issue type screen schemes used in classic projects are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * @param startAt The index of the first item to return in a page of results (page offset).
    * @param maxResults The maximum number of items to return per page.
    * @param id The list of issue type screen scheme IDs. To include multiple IDs, provide an ampersand-separated list. For example, &#x60;id&#x3D;10000&amp;id&#x3D;10001&#x60;.
    * @return PageBeanIssueTypeScreenScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanIssueTypeScreenScheme getIssueTypeScreenSchemes(Long startAt, Integer maxResults, Set<Long> id) throws IOException {
        HttpResponse response = getIssueTypeScreenSchemesForHttpResponse(startAt, maxResults, id);
        TypeReference<PageBeanIssueTypeScreenScheme> typeRef = new TypeReference<PageBeanIssueTypeScreenScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get issue type screen schemes
    * Returns a [paginated](#pagination) list of issue type screen schemes.  Only issue type screen schemes used in classic projects are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PageBeanIssueTypeScreenScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanIssueTypeScreenScheme getIssueTypeScreenSchemes(Map<String, Object> params) throws IOException {
        HttpResponse response = getIssueTypeScreenSchemesForHttpResponse(params);
        TypeReference<PageBeanIssueTypeScreenScheme> typeRef = new TypeReference<PageBeanIssueTypeScreenScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getIssueTypeScreenSchemesForHttpResponse(Long startAt, Integer maxResults, Set<Long> id) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescreenscheme");
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
        }        if (id != null) {
            String key = "id";
            Object value = id;
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

    public HttpResponse getIssueTypeScreenSchemesForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescreenscheme");

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
    * Remove mappings from issue type screen scheme
    * Removes issue type to screen scheme mappings from an issue type screen scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the screen scheme mappings are removed from the issue type screen scheme.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * <p><b>404</b> - Returned if the issue type screen scheme or one or more issue type mappings are not found.
    * @param issueTypeScreenSchemeId The ID of the issue type screen scheme.
    * @param issueTypeIds The issueTypeIds parameter
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object removeMappingsFromIssueTypeScreenScheme(String issueTypeScreenSchemeId, IssueTypeIds issueTypeIds) throws IOException {
        HttpResponse response = removeMappingsFromIssueTypeScreenSchemeForHttpResponse(issueTypeScreenSchemeId, issueTypeIds);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Remove mappings from issue type screen scheme
    * Removes issue type to screen scheme mappings from an issue type screen scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the screen scheme mappings are removed from the issue type screen scheme.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * <p><b>404</b> - Returned if the issue type screen scheme or one or more issue type mappings are not found.
    * @param issueTypeScreenSchemeId The ID of the issue type screen scheme.
    * @param issueTypeIds The issueTypeIds parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object removeMappingsFromIssueTypeScreenScheme(String issueTypeScreenSchemeId, IssueTypeIds issueTypeIds, Map<String, Object> params) throws IOException {
        HttpResponse response = removeMappingsFromIssueTypeScreenSchemeForHttpResponse(issueTypeScreenSchemeId, issueTypeIds, params);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse removeMappingsFromIssueTypeScreenSchemeForHttpResponse(String issueTypeScreenSchemeId, IssueTypeIds issueTypeIds) throws IOException {
        // verify the required parameter 'issueTypeScreenSchemeId' is set
        if (issueTypeScreenSchemeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeScreenSchemeId' when calling removeMappingsFromIssueTypeScreenScheme");
        }// verify the required parameter 'issueTypeIds' is set
        if (issueTypeIds == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeIds' when calling removeMappingsFromIssueTypeScreenScheme");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueTypeScreenSchemeId", issueTypeScreenSchemeId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescreenscheme/{issueTypeScreenSchemeId}/mapping/remove");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(issueTypeIds);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse removeMappingsFromIssueTypeScreenSchemeForHttpResponse(String issueTypeScreenSchemeId, java.io.InputStream issueTypeIds, String mediaType) throws IOException {
          // verify the required parameter 'issueTypeScreenSchemeId' is set
              if (issueTypeScreenSchemeId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'issueTypeScreenSchemeId' when calling removeMappingsFromIssueTypeScreenScheme");
              }// verify the required parameter 'issueTypeIds' is set
              if (issueTypeIds == null) {
              throw new IllegalArgumentException("Missing the required parameter 'issueTypeIds' when calling removeMappingsFromIssueTypeScreenScheme");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("issueTypeScreenSchemeId", issueTypeScreenSchemeId);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescreenscheme/{issueTypeScreenSchemeId}/mapping/remove");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = issueTypeIds == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, issueTypeIds);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse removeMappingsFromIssueTypeScreenSchemeForHttpResponse(String issueTypeScreenSchemeId, IssueTypeIds issueTypeIds, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueTypeScreenSchemeId' is set
        if (issueTypeScreenSchemeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeScreenSchemeId' when calling removeMappingsFromIssueTypeScreenScheme");
        }// verify the required parameter 'issueTypeIds' is set
        if (issueTypeIds == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeIds' when calling removeMappingsFromIssueTypeScreenScheme");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueTypeScreenSchemeId", issueTypeScreenSchemeId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescreenscheme/{issueTypeScreenSchemeId}/mapping/remove");

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
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


  /**
    * Update issue type screen scheme default screen scheme
    * Updates the default screen scheme of an issue type screen scheme. The default screen scheme is used for all unmapped issue types.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * <p><b>404</b> - Returned if the issue type screen scheme or the screen screen is not found, or the screen scheme isn&#39;t used in classic projects.
    * @param issueTypeScreenSchemeId The ID of the issue type screen scheme.
    * @param updateDefaultScreenScheme The updateDefaultScreenScheme parameter
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object updateDefaultScreenScheme(String issueTypeScreenSchemeId, UpdateDefaultScreenScheme updateDefaultScreenScheme) throws IOException {
        HttpResponse response = updateDefaultScreenSchemeForHttpResponse(issueTypeScreenSchemeId, updateDefaultScreenScheme);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Update issue type screen scheme default screen scheme
    * Updates the default screen scheme of an issue type screen scheme. The default screen scheme is used for all unmapped issue types.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * <p><b>404</b> - Returned if the issue type screen scheme or the screen screen is not found, or the screen scheme isn&#39;t used in classic projects.
    * @param issueTypeScreenSchemeId The ID of the issue type screen scheme.
    * @param updateDefaultScreenScheme The updateDefaultScreenScheme parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object updateDefaultScreenScheme(String issueTypeScreenSchemeId, UpdateDefaultScreenScheme updateDefaultScreenScheme, Map<String, Object> params) throws IOException {
        HttpResponse response = updateDefaultScreenSchemeForHttpResponse(issueTypeScreenSchemeId, updateDefaultScreenScheme, params);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse updateDefaultScreenSchemeForHttpResponse(String issueTypeScreenSchemeId, UpdateDefaultScreenScheme updateDefaultScreenScheme) throws IOException {
        // verify the required parameter 'issueTypeScreenSchemeId' is set
        if (issueTypeScreenSchemeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeScreenSchemeId' when calling updateDefaultScreenScheme");
        }// verify the required parameter 'updateDefaultScreenScheme' is set
        if (updateDefaultScreenScheme == null) {
            throw new IllegalArgumentException("Missing the required parameter 'updateDefaultScreenScheme' when calling updateDefaultScreenScheme");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueTypeScreenSchemeId", issueTypeScreenSchemeId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescreenscheme/{issueTypeScreenSchemeId}/mapping/default");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(updateDefaultScreenScheme);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse updateDefaultScreenSchemeForHttpResponse(String issueTypeScreenSchemeId, java.io.InputStream updateDefaultScreenScheme, String mediaType) throws IOException {
          // verify the required parameter 'issueTypeScreenSchemeId' is set
              if (issueTypeScreenSchemeId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'issueTypeScreenSchemeId' when calling updateDefaultScreenScheme");
              }// verify the required parameter 'updateDefaultScreenScheme' is set
              if (updateDefaultScreenScheme == null) {
              throw new IllegalArgumentException("Missing the required parameter 'updateDefaultScreenScheme' when calling updateDefaultScreenScheme");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("issueTypeScreenSchemeId", issueTypeScreenSchemeId);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescreenscheme/{issueTypeScreenSchemeId}/mapping/default");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = updateDefaultScreenScheme == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, updateDefaultScreenScheme);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse updateDefaultScreenSchemeForHttpResponse(String issueTypeScreenSchemeId, UpdateDefaultScreenScheme updateDefaultScreenScheme, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueTypeScreenSchemeId' is set
        if (issueTypeScreenSchemeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeScreenSchemeId' when calling updateDefaultScreenScheme");
        }// verify the required parameter 'updateDefaultScreenScheme' is set
        if (updateDefaultScreenScheme == null) {
            throw new IllegalArgumentException("Missing the required parameter 'updateDefaultScreenScheme' when calling updateDefaultScreenScheme");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueTypeScreenSchemeId", issueTypeScreenSchemeId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescreenscheme/{issueTypeScreenSchemeId}/mapping/default");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(updateDefaultScreenScheme);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }


  /**
    * Update issue type screen scheme
    * Updates an issue type screen scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * <p><b>404</b> - Returned if the issue type screen scheme is not found.
    * @param issueTypeScreenSchemeId The ID of the issue type screen scheme.
    * @param issueTypeScreenSchemeUpdateDetails The issue type screen scheme update details.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object updateIssueTypeScreenScheme(String issueTypeScreenSchemeId, IssueTypeScreenSchemeUpdateDetails issueTypeScreenSchemeUpdateDetails) throws IOException {
        HttpResponse response = updateIssueTypeScreenSchemeForHttpResponse(issueTypeScreenSchemeId, issueTypeScreenSchemeUpdateDetails);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Update issue type screen scheme
    * Updates an issue type screen scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * <p><b>404</b> - Returned if the issue type screen scheme is not found.
    * @param issueTypeScreenSchemeId The ID of the issue type screen scheme.
    * @param issueTypeScreenSchemeUpdateDetails The issue type screen scheme update details.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object updateIssueTypeScreenScheme(String issueTypeScreenSchemeId, IssueTypeScreenSchemeUpdateDetails issueTypeScreenSchemeUpdateDetails, Map<String, Object> params) throws IOException {
        HttpResponse response = updateIssueTypeScreenSchemeForHttpResponse(issueTypeScreenSchemeId, issueTypeScreenSchemeUpdateDetails, params);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse updateIssueTypeScreenSchemeForHttpResponse(String issueTypeScreenSchemeId, IssueTypeScreenSchemeUpdateDetails issueTypeScreenSchemeUpdateDetails) throws IOException {
        // verify the required parameter 'issueTypeScreenSchemeId' is set
        if (issueTypeScreenSchemeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeScreenSchemeId' when calling updateIssueTypeScreenScheme");
        }// verify the required parameter 'issueTypeScreenSchemeUpdateDetails' is set
        if (issueTypeScreenSchemeUpdateDetails == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeScreenSchemeUpdateDetails' when calling updateIssueTypeScreenScheme");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueTypeScreenSchemeId", issueTypeScreenSchemeId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescreenscheme/{issueTypeScreenSchemeId}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(issueTypeScreenSchemeUpdateDetails);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse updateIssueTypeScreenSchemeForHttpResponse(String issueTypeScreenSchemeId, java.io.InputStream issueTypeScreenSchemeUpdateDetails, String mediaType) throws IOException {
          // verify the required parameter 'issueTypeScreenSchemeId' is set
              if (issueTypeScreenSchemeId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'issueTypeScreenSchemeId' when calling updateIssueTypeScreenScheme");
              }// verify the required parameter 'issueTypeScreenSchemeUpdateDetails' is set
              if (issueTypeScreenSchemeUpdateDetails == null) {
              throw new IllegalArgumentException("Missing the required parameter 'issueTypeScreenSchemeUpdateDetails' when calling updateIssueTypeScreenScheme");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("issueTypeScreenSchemeId", issueTypeScreenSchemeId);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescreenscheme/{issueTypeScreenSchemeId}");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = issueTypeScreenSchemeUpdateDetails == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, issueTypeScreenSchemeUpdateDetails);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse updateIssueTypeScreenSchemeForHttpResponse(String issueTypeScreenSchemeId, IssueTypeScreenSchemeUpdateDetails issueTypeScreenSchemeUpdateDetails, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueTypeScreenSchemeId' is set
        if (issueTypeScreenSchemeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeScreenSchemeId' when calling updateIssueTypeScreenScheme");
        }// verify the required parameter 'issueTypeScreenSchemeUpdateDetails' is set
        if (issueTypeScreenSchemeUpdateDetails == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeScreenSchemeUpdateDetails' when calling updateIssueTypeScreenScheme");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueTypeScreenSchemeId", issueTypeScreenSchemeId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescreenscheme/{issueTypeScreenSchemeId}");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(issueTypeScreenSchemeUpdateDetails);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }


}
