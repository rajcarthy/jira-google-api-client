package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.IssueTypeIDs;
import com.atlassian.jira.rest.client.model.IssueTypeSchemeDetails;
import com.atlassian.jira.rest.client.model.IssueTypeSchemeID;
import com.atlassian.jira.rest.client.model.IssueTypeSchemeProjectAssociation;
import com.atlassian.jira.rest.client.model.IssueTypeSchemeUpdateDetails;
import com.atlassian.jira.rest.client.model.OrderOfIssueTypes;
import com.atlassian.jira.rest.client.model.PageBeanIssueTypeScheme;
import com.atlassian.jira.rest.client.model.PageBeanIssueTypeSchemeMapping;
import com.atlassian.jira.rest.client.model.PageBeanIssueTypeSchemeProjects;
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
public class IssueTypeSchemesApi {
    private ApiClient apiClient;

    public IssueTypeSchemesApi() {
        this(new ApiClient());
    }

    public IssueTypeSchemesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Add issue types to issue type scheme
    * Adds issue types to an issue type scheme.  The added issue types are appended to the issue types list.  If any of the issue types exist in the issue type scheme, the operation fails and no issue types are added.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * <p><b>404</b> - Returned if the issue type or the issue type scheme is not found.
    * @param issueTypeSchemeId The ID of the issue type scheme.
    * @param issueTypeIDs The issueTypeIDs parameter
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object addIssueTypesToIssueTypeScheme(Long issueTypeSchemeId, IssueTypeIDs issueTypeIDs) throws IOException {
        HttpResponse response = addIssueTypesToIssueTypeSchemeForHttpResponse(issueTypeSchemeId, issueTypeIDs);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Add issue types to issue type scheme
    * Adds issue types to an issue type scheme.  The added issue types are appended to the issue types list.  If any of the issue types exist in the issue type scheme, the operation fails and no issue types are added.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * <p><b>404</b> - Returned if the issue type or the issue type scheme is not found.
    * @param issueTypeSchemeId The ID of the issue type scheme.
    * @param issueTypeIDs The issueTypeIDs parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object addIssueTypesToIssueTypeScheme(Long issueTypeSchemeId, IssueTypeIDs issueTypeIDs, Map<String, Object> params) throws IOException {
        HttpResponse response = addIssueTypesToIssueTypeSchemeForHttpResponse(issueTypeSchemeId, issueTypeIDs, params);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse addIssueTypesToIssueTypeSchemeForHttpResponse(Long issueTypeSchemeId, IssueTypeIDs issueTypeIDs) throws IOException {
        // verify the required parameter 'issueTypeSchemeId' is set
        if (issueTypeSchemeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeSchemeId' when calling addIssueTypesToIssueTypeScheme");
        }// verify the required parameter 'issueTypeIDs' is set
        if (issueTypeIDs == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeIDs' when calling addIssueTypesToIssueTypeScheme");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueTypeSchemeId", issueTypeSchemeId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescheme/{issueTypeSchemeId}/issuetype");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(issueTypeIDs);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse addIssueTypesToIssueTypeSchemeForHttpResponse(Long issueTypeSchemeId, java.io.InputStream issueTypeIDs, String mediaType) throws IOException {
          // verify the required parameter 'issueTypeSchemeId' is set
              if (issueTypeSchemeId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'issueTypeSchemeId' when calling addIssueTypesToIssueTypeScheme");
              }// verify the required parameter 'issueTypeIDs' is set
              if (issueTypeIDs == null) {
              throw new IllegalArgumentException("Missing the required parameter 'issueTypeIDs' when calling addIssueTypesToIssueTypeScheme");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("issueTypeSchemeId", issueTypeSchemeId);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescheme/{issueTypeSchemeId}/issuetype");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = issueTypeIDs == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, issueTypeIDs);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse addIssueTypesToIssueTypeSchemeForHttpResponse(Long issueTypeSchemeId, IssueTypeIDs issueTypeIDs, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueTypeSchemeId' is set
        if (issueTypeSchemeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeSchemeId' when calling addIssueTypesToIssueTypeScheme");
        }// verify the required parameter 'issueTypeIDs' is set
        if (issueTypeIDs == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeIDs' when calling addIssueTypesToIssueTypeScheme");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueTypeSchemeId", issueTypeSchemeId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescheme/{issueTypeSchemeId}/issuetype");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(issueTypeIDs);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }


  /**
    * Assign issue type scheme to project
    * Assigns an issue type scheme to a project.  If any issues in the project are assigned issue types not present in the new scheme, the operation will fail. To complete the assignment those issues must be updated to use issue types in the new scheme.  Issue type schemes can only be assigned to classic projects.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * <p><b>404</b> - Returned if the issue type scheme or the project is not found.
    * @param issueTypeSchemeProjectAssociation The issueTypeSchemeProjectAssociation parameter
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object assignIssueTypeSchemeToProject(IssueTypeSchemeProjectAssociation issueTypeSchemeProjectAssociation) throws IOException {
        HttpResponse response = assignIssueTypeSchemeToProjectForHttpResponse(issueTypeSchemeProjectAssociation);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Assign issue type scheme to project
    * Assigns an issue type scheme to a project.  If any issues in the project are assigned issue types not present in the new scheme, the operation will fail. To complete the assignment those issues must be updated to use issue types in the new scheme.  Issue type schemes can only be assigned to classic projects.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * <p><b>404</b> - Returned if the issue type scheme or the project is not found.
    * @param issueTypeSchemeProjectAssociation The issueTypeSchemeProjectAssociation parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object assignIssueTypeSchemeToProject(IssueTypeSchemeProjectAssociation issueTypeSchemeProjectAssociation, Map<String, Object> params) throws IOException {
        HttpResponse response = assignIssueTypeSchemeToProjectForHttpResponse(issueTypeSchemeProjectAssociation, params);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse assignIssueTypeSchemeToProjectForHttpResponse(IssueTypeSchemeProjectAssociation issueTypeSchemeProjectAssociation) throws IOException {
        // verify the required parameter 'issueTypeSchemeProjectAssociation' is set
        if (issueTypeSchemeProjectAssociation == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeSchemeProjectAssociation' when calling assignIssueTypeSchemeToProject");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescheme/project");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(issueTypeSchemeProjectAssociation);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse assignIssueTypeSchemeToProjectForHttpResponse(java.io.InputStream issueTypeSchemeProjectAssociation, String mediaType) throws IOException {
          // verify the required parameter 'issueTypeSchemeProjectAssociation' is set
              if (issueTypeSchemeProjectAssociation == null) {
              throw new IllegalArgumentException("Missing the required parameter 'issueTypeSchemeProjectAssociation' when calling assignIssueTypeSchemeToProject");
              }
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescheme/project");

              String localVarUrl = uriBuilder.build().toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = issueTypeSchemeProjectAssociation == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, issueTypeSchemeProjectAssociation);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse assignIssueTypeSchemeToProjectForHttpResponse(IssueTypeSchemeProjectAssociation issueTypeSchemeProjectAssociation, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueTypeSchemeProjectAssociation' is set
        if (issueTypeSchemeProjectAssociation == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeSchemeProjectAssociation' when calling assignIssueTypeSchemeToProject");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescheme/project");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(issueTypeSchemeProjectAssociation);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }


  /**
    * Create issue type scheme
    * Creates an issue type scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>201</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * <p><b>409</b> - Returned if the scheme name is used by another scheme.
    * @param issueTypeSchemeDetails The issueTypeSchemeDetails parameter
    * @return IssueTypeSchemeID
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public IssueTypeSchemeID createIssueTypeScheme(IssueTypeSchemeDetails issueTypeSchemeDetails) throws IOException {
        HttpResponse response = createIssueTypeSchemeForHttpResponse(issueTypeSchemeDetails);
        TypeReference<IssueTypeSchemeID> typeRef = new TypeReference<IssueTypeSchemeID>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Create issue type scheme
    * Creates an issue type scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>201</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * <p><b>409</b> - Returned if the scheme name is used by another scheme.
    * @param issueTypeSchemeDetails The issueTypeSchemeDetails parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return IssueTypeSchemeID
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public IssueTypeSchemeID createIssueTypeScheme(IssueTypeSchemeDetails issueTypeSchemeDetails, Map<String, Object> params) throws IOException {
        HttpResponse response = createIssueTypeSchemeForHttpResponse(issueTypeSchemeDetails, params);
        TypeReference<IssueTypeSchemeID> typeRef = new TypeReference<IssueTypeSchemeID>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse createIssueTypeSchemeForHttpResponse(IssueTypeSchemeDetails issueTypeSchemeDetails) throws IOException {
        // verify the required parameter 'issueTypeSchemeDetails' is set
        if (issueTypeSchemeDetails == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeSchemeDetails' when calling createIssueTypeScheme");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescheme");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(issueTypeSchemeDetails);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse createIssueTypeSchemeForHttpResponse(java.io.InputStream issueTypeSchemeDetails, String mediaType) throws IOException {
          // verify the required parameter 'issueTypeSchemeDetails' is set
              if (issueTypeSchemeDetails == null) {
              throw new IllegalArgumentException("Missing the required parameter 'issueTypeSchemeDetails' when calling createIssueTypeScheme");
              }
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescheme");

              String localVarUrl = uriBuilder.build().toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = issueTypeSchemeDetails == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, issueTypeSchemeDetails);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse createIssueTypeSchemeForHttpResponse(IssueTypeSchemeDetails issueTypeSchemeDetails, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueTypeSchemeDetails' is set
        if (issueTypeSchemeDetails == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeSchemeDetails' when calling createIssueTypeScheme");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescheme");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(issueTypeSchemeDetails);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


  /**
    * Delete issue type scheme
    * Deletes an issue type scheme.  Only issue type schemes used in classic projects can be deleted.  Any projects assigned to the scheme are reassigned to the default issue type scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the issue type scheme is deleted.
    * <p><b>400</b> - Returned if the request is to delete the default issue type scheme.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * <p><b>404</b> - Returned if the issue type scheme is not found.
    * @param issueTypeSchemeId The ID of the issue type scheme.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object deleteIssueTypeScheme(Long issueTypeSchemeId) throws IOException {
        HttpResponse response = deleteIssueTypeSchemeForHttpResponse(issueTypeSchemeId);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Delete issue type scheme
    * Deletes an issue type scheme.  Only issue type schemes used in classic projects can be deleted.  Any projects assigned to the scheme are reassigned to the default issue type scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the issue type scheme is deleted.
    * <p><b>400</b> - Returned if the request is to delete the default issue type scheme.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * <p><b>404</b> - Returned if the issue type scheme is not found.
    * @param issueTypeSchemeId The ID of the issue type scheme.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object deleteIssueTypeScheme(Long issueTypeSchemeId, Map<String, Object> params) throws IOException {
        HttpResponse response = deleteIssueTypeSchemeForHttpResponse(issueTypeSchemeId, params);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse deleteIssueTypeSchemeForHttpResponse(Long issueTypeSchemeId) throws IOException {
        // verify the required parameter 'issueTypeSchemeId' is set
        if (issueTypeSchemeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeSchemeId' when calling deleteIssueTypeScheme");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueTypeSchemeId", issueTypeSchemeId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescheme/{issueTypeSchemeId}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }

    public HttpResponse deleteIssueTypeSchemeForHttpResponse(Long issueTypeSchemeId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueTypeSchemeId' is set
        if (issueTypeSchemeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeSchemeId' when calling deleteIssueTypeScheme");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueTypeSchemeId", issueTypeSchemeId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescheme/{issueTypeSchemeId}");

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
    * Get all issue type schemes
    * Returns a [paginated](#pagination) list of issue type schemes.  Only issue type schemes used in classic projects are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * @param startAt The index of the first item to return in a page of results (page offset).
    * @param maxResults The maximum number of items to return per page.
    * @param id The list of issue type schemes IDs. To include multiple IDs, provide an ampersand-separated list. For example, &#x60;id&#x3D;10000&amp;id&#x3D;10001&#x60;.
    * @return PageBeanIssueTypeScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanIssueTypeScheme getAllIssueTypeSchemes(Long startAt, Integer maxResults, Set<Long> id) throws IOException {
        HttpResponse response = getAllIssueTypeSchemesForHttpResponse(startAt, maxResults, id);
        TypeReference<PageBeanIssueTypeScheme> typeRef = new TypeReference<PageBeanIssueTypeScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get all issue type schemes
    * Returns a [paginated](#pagination) list of issue type schemes.  Only issue type schemes used in classic projects are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PageBeanIssueTypeScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanIssueTypeScheme getAllIssueTypeSchemes(Map<String, Object> params) throws IOException {
        HttpResponse response = getAllIssueTypeSchemesForHttpResponse(params);
        TypeReference<PageBeanIssueTypeScheme> typeRef = new TypeReference<PageBeanIssueTypeScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getAllIssueTypeSchemesForHttpResponse(Long startAt, Integer maxResults, Set<Long> id) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescheme");
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

    public HttpResponse getAllIssueTypeSchemesForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescheme");

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
    * Get issue type schemes for projects
    * Returns a [paginated](#pagination) list of issue type schemes and, for each issue type scheme, a list of the projects that use it.  Only issue type schemes used in classic projects are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * @param projectId The list of project IDs. To include multiple project IDs, provide an ampersand-separated list. For example, &#x60;projectId&#x3D;10000&amp;projectId&#x3D;10001&#x60;.
    * @param startAt The index of the first item to return in a page of results (page offset).
    * @param maxResults The maximum number of items to return per page.
    * @return PageBeanIssueTypeSchemeProjects
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanIssueTypeSchemeProjects getIssueTypeSchemeForProjects(Set<Long> projectId, Long startAt, Integer maxResults) throws IOException {
        HttpResponse response = getIssueTypeSchemeForProjectsForHttpResponse(projectId, startAt, maxResults);
        TypeReference<PageBeanIssueTypeSchemeProjects> typeRef = new TypeReference<PageBeanIssueTypeSchemeProjects>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get issue type schemes for projects
    * Returns a [paginated](#pagination) list of issue type schemes and, for each issue type scheme, a list of the projects that use it.  Only issue type schemes used in classic projects are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * @param projectId The list of project IDs. To include multiple project IDs, provide an ampersand-separated list. For example, &#x60;projectId&#x3D;10000&amp;projectId&#x3D;10001&#x60;.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PageBeanIssueTypeSchemeProjects
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanIssueTypeSchemeProjects getIssueTypeSchemeForProjects(Set<Long> projectId, Map<String, Object> params) throws IOException {
        HttpResponse response = getIssueTypeSchemeForProjectsForHttpResponse(projectId, params);
        TypeReference<PageBeanIssueTypeSchemeProjects> typeRef = new TypeReference<PageBeanIssueTypeSchemeProjects>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getIssueTypeSchemeForProjectsForHttpResponse(Set<Long> projectId, Long startAt, Integer maxResults) throws IOException {
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectId' when calling getIssueTypeSchemeForProjects");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescheme/project");
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

    public HttpResponse getIssueTypeSchemeForProjectsForHttpResponse(Set<Long> projectId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectId' when calling getIssueTypeSchemeForProjects");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescheme/project");

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
    * Get issue type scheme items
    * Returns a [paginated](#pagination) list of issue type scheme items.  Only issue type scheme items used in classic projects are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * @param startAt The index of the first item to return in a page of results (page offset).
    * @param maxResults The maximum number of items to return per page.
    * @param issueTypeSchemeId The list of issue type scheme IDs. To include multiple IDs, provide an ampersand-separated list. For example, &#x60;issueTypeSchemeId&#x3D;10000&amp;issueTypeSchemeId&#x3D;10001&#x60;.
    * @return PageBeanIssueTypeSchemeMapping
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanIssueTypeSchemeMapping getIssueTypeSchemesMapping(Long startAt, Integer maxResults, Set<Long> issueTypeSchemeId) throws IOException {
        HttpResponse response = getIssueTypeSchemesMappingForHttpResponse(startAt, maxResults, issueTypeSchemeId);
        TypeReference<PageBeanIssueTypeSchemeMapping> typeRef = new TypeReference<PageBeanIssueTypeSchemeMapping>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get issue type scheme items
    * Returns a [paginated](#pagination) list of issue type scheme items.  Only issue type scheme items used in classic projects are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PageBeanIssueTypeSchemeMapping
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanIssueTypeSchemeMapping getIssueTypeSchemesMapping(Map<String, Object> params) throws IOException {
        HttpResponse response = getIssueTypeSchemesMappingForHttpResponse(params);
        TypeReference<PageBeanIssueTypeSchemeMapping> typeRef = new TypeReference<PageBeanIssueTypeSchemeMapping>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getIssueTypeSchemesMappingForHttpResponse(Long startAt, Integer maxResults, Set<Long> issueTypeSchemeId) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescheme/mapping");
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
        }        if (issueTypeSchemeId != null) {
            String key = "issueTypeSchemeId";
            Object value = issueTypeSchemeId;
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

    public HttpResponse getIssueTypeSchemesMappingForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescheme/mapping");

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
    * Remove issue type from issue type scheme
    * Removes an issue type from an issue type scheme.  This operation cannot remove:   *  any issue type used by issues.  *  any issue types from the default issue type scheme.  *  the last standard issue type from an issue type scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * <p><b>404</b> - Returned if the issue type scheme is missing or the issue type is not found in the issue type scheme.
    * @param issueTypeSchemeId The ID of the issue type scheme.
    * @param issueTypeId The ID of the issue type.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object removeIssueTypeFromIssueTypeScheme(Long issueTypeSchemeId, Long issueTypeId) throws IOException {
        HttpResponse response = removeIssueTypeFromIssueTypeSchemeForHttpResponse(issueTypeSchemeId, issueTypeId);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Remove issue type from issue type scheme
    * Removes an issue type from an issue type scheme.  This operation cannot remove:   *  any issue type used by issues.  *  any issue types from the default issue type scheme.  *  the last standard issue type from an issue type scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * <p><b>404</b> - Returned if the issue type scheme is missing or the issue type is not found in the issue type scheme.
    * @param issueTypeSchemeId The ID of the issue type scheme.
    * @param issueTypeId The ID of the issue type.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object removeIssueTypeFromIssueTypeScheme(Long issueTypeSchemeId, Long issueTypeId, Map<String, Object> params) throws IOException {
        HttpResponse response = removeIssueTypeFromIssueTypeSchemeForHttpResponse(issueTypeSchemeId, issueTypeId, params);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse removeIssueTypeFromIssueTypeSchemeForHttpResponse(Long issueTypeSchemeId, Long issueTypeId) throws IOException {
        // verify the required parameter 'issueTypeSchemeId' is set
        if (issueTypeSchemeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeSchemeId' when calling removeIssueTypeFromIssueTypeScheme");
        }// verify the required parameter 'issueTypeId' is set
        if (issueTypeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeId' when calling removeIssueTypeFromIssueTypeScheme");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueTypeSchemeId", issueTypeSchemeId);
        uriVariables.put("issueTypeId", issueTypeId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescheme/{issueTypeSchemeId}/issuetype/{issueTypeId}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }

    public HttpResponse removeIssueTypeFromIssueTypeSchemeForHttpResponse(Long issueTypeSchemeId, Long issueTypeId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueTypeSchemeId' is set
        if (issueTypeSchemeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeSchemeId' when calling removeIssueTypeFromIssueTypeScheme");
        }// verify the required parameter 'issueTypeId' is set
        if (issueTypeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeId' when calling removeIssueTypeFromIssueTypeScheme");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueTypeSchemeId", issueTypeSchemeId);
        uriVariables.put("issueTypeId", issueTypeId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescheme/{issueTypeSchemeId}/issuetype/{issueTypeId}");

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
    * Change order of issue types
    * Changes the order of issue types in an issue type scheme.  The request body parameters must meet the following requirements:   *  all of the issue types must belong to the issue type scheme.  *  either &#x60;after&#x60; or &#x60;position&#x60; must be provided.  *  the issue type in &#x60;after&#x60; must not be in the issue type list.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * <p><b>404</b> - Returned if the issue type scheme is not found.
    * @param issueTypeSchemeId The ID of the issue type scheme.
    * @param orderOfIssueTypes The orderOfIssueTypes parameter
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object reorderIssueTypesInIssueTypeScheme(Long issueTypeSchemeId, OrderOfIssueTypes orderOfIssueTypes) throws IOException {
        HttpResponse response = reorderIssueTypesInIssueTypeSchemeForHttpResponse(issueTypeSchemeId, orderOfIssueTypes);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Change order of issue types
    * Changes the order of issue types in an issue type scheme.  The request body parameters must meet the following requirements:   *  all of the issue types must belong to the issue type scheme.  *  either &#x60;after&#x60; or &#x60;position&#x60; must be provided.  *  the issue type in &#x60;after&#x60; must not be in the issue type list.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * <p><b>404</b> - Returned if the issue type scheme is not found.
    * @param issueTypeSchemeId The ID of the issue type scheme.
    * @param orderOfIssueTypes The orderOfIssueTypes parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object reorderIssueTypesInIssueTypeScheme(Long issueTypeSchemeId, OrderOfIssueTypes orderOfIssueTypes, Map<String, Object> params) throws IOException {
        HttpResponse response = reorderIssueTypesInIssueTypeSchemeForHttpResponse(issueTypeSchemeId, orderOfIssueTypes, params);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse reorderIssueTypesInIssueTypeSchemeForHttpResponse(Long issueTypeSchemeId, OrderOfIssueTypes orderOfIssueTypes) throws IOException {
        // verify the required parameter 'issueTypeSchemeId' is set
        if (issueTypeSchemeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeSchemeId' when calling reorderIssueTypesInIssueTypeScheme");
        }// verify the required parameter 'orderOfIssueTypes' is set
        if (orderOfIssueTypes == null) {
            throw new IllegalArgumentException("Missing the required parameter 'orderOfIssueTypes' when calling reorderIssueTypesInIssueTypeScheme");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueTypeSchemeId", issueTypeSchemeId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescheme/{issueTypeSchemeId}/issuetype/move");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(orderOfIssueTypes);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse reorderIssueTypesInIssueTypeSchemeForHttpResponse(Long issueTypeSchemeId, java.io.InputStream orderOfIssueTypes, String mediaType) throws IOException {
          // verify the required parameter 'issueTypeSchemeId' is set
              if (issueTypeSchemeId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'issueTypeSchemeId' when calling reorderIssueTypesInIssueTypeScheme");
              }// verify the required parameter 'orderOfIssueTypes' is set
              if (orderOfIssueTypes == null) {
              throw new IllegalArgumentException("Missing the required parameter 'orderOfIssueTypes' when calling reorderIssueTypesInIssueTypeScheme");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("issueTypeSchemeId", issueTypeSchemeId);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescheme/{issueTypeSchemeId}/issuetype/move");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = orderOfIssueTypes == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, orderOfIssueTypes);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse reorderIssueTypesInIssueTypeSchemeForHttpResponse(Long issueTypeSchemeId, OrderOfIssueTypes orderOfIssueTypes, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueTypeSchemeId' is set
        if (issueTypeSchemeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeSchemeId' when calling reorderIssueTypesInIssueTypeScheme");
        }// verify the required parameter 'orderOfIssueTypes' is set
        if (orderOfIssueTypes == null) {
            throw new IllegalArgumentException("Missing the required parameter 'orderOfIssueTypes' when calling reorderIssueTypesInIssueTypeScheme");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueTypeSchemeId", issueTypeSchemeId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescheme/{issueTypeSchemeId}/issuetype/move");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(orderOfIssueTypes);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }


  /**
    * Update issue type scheme
    * Updates an issue type scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * <p><b>404</b> - Returned if the issue type scheme is not found.
    * @param issueTypeSchemeId The ID of the issue type scheme.
    * @param issueTypeSchemeUpdateDetails The issueTypeSchemeUpdateDetails parameter
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object updateIssueTypeScheme(Long issueTypeSchemeId, IssueTypeSchemeUpdateDetails issueTypeSchemeUpdateDetails) throws IOException {
        HttpResponse response = updateIssueTypeSchemeForHttpResponse(issueTypeSchemeId, issueTypeSchemeUpdateDetails);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Update issue type scheme
    * Updates an issue type scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * <p><b>404</b> - Returned if the issue type scheme is not found.
    * @param issueTypeSchemeId The ID of the issue type scheme.
    * @param issueTypeSchemeUpdateDetails The issueTypeSchemeUpdateDetails parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object updateIssueTypeScheme(Long issueTypeSchemeId, IssueTypeSchemeUpdateDetails issueTypeSchemeUpdateDetails, Map<String, Object> params) throws IOException {
        HttpResponse response = updateIssueTypeSchemeForHttpResponse(issueTypeSchemeId, issueTypeSchemeUpdateDetails, params);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse updateIssueTypeSchemeForHttpResponse(Long issueTypeSchemeId, IssueTypeSchemeUpdateDetails issueTypeSchemeUpdateDetails) throws IOException {
        // verify the required parameter 'issueTypeSchemeId' is set
        if (issueTypeSchemeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeSchemeId' when calling updateIssueTypeScheme");
        }// verify the required parameter 'issueTypeSchemeUpdateDetails' is set
        if (issueTypeSchemeUpdateDetails == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeSchemeUpdateDetails' when calling updateIssueTypeScheme");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueTypeSchemeId", issueTypeSchemeId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescheme/{issueTypeSchemeId}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(issueTypeSchemeUpdateDetails);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse updateIssueTypeSchemeForHttpResponse(Long issueTypeSchemeId, java.io.InputStream issueTypeSchemeUpdateDetails, String mediaType) throws IOException {
          // verify the required parameter 'issueTypeSchemeId' is set
              if (issueTypeSchemeId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'issueTypeSchemeId' when calling updateIssueTypeScheme");
              }// verify the required parameter 'issueTypeSchemeUpdateDetails' is set
              if (issueTypeSchemeUpdateDetails == null) {
              throw new IllegalArgumentException("Missing the required parameter 'issueTypeSchemeUpdateDetails' when calling updateIssueTypeScheme");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("issueTypeSchemeId", issueTypeSchemeId);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescheme/{issueTypeSchemeId}");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = issueTypeSchemeUpdateDetails == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, issueTypeSchemeUpdateDetails);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse updateIssueTypeSchemeForHttpResponse(Long issueTypeSchemeId, IssueTypeSchemeUpdateDetails issueTypeSchemeUpdateDetails, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueTypeSchemeId' is set
        if (issueTypeSchemeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeSchemeId' when calling updateIssueTypeScheme");
        }// verify the required parameter 'issueTypeSchemeUpdateDetails' is set
        if (issueTypeSchemeUpdateDetails == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeSchemeUpdateDetails' when calling updateIssueTypeScheme");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueTypeSchemeId", issueTypeSchemeId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetypescheme/{issueTypeSchemeId}");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(issueTypeSchemeUpdateDetails);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }


}
