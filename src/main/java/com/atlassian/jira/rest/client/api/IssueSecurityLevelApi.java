package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.PageBeanIssueSecurityLevelMember;
import com.atlassian.jira.rest.client.model.SecurityLevel;
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
public class IssueSecurityLevelApi {
    private ApiClient apiClient;

    public IssueSecurityLevelApi() {
        this(new ApiClient());
    }

    public IssueSecurityLevelApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Get issue security level
    * Returns details of an issue security level.  Use [Get issue security scheme](#api-rest-api-3-issuesecurityschemes-id-get) to obtain the IDs of issue security levels associated with the issue security scheme.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect.
    * <p><b>404</b> - Returned if the issue security level is not found.
    * @param id The ID of the issue security level.
    * @return SecurityLevel
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public SecurityLevel getIssueSecurityLevel(String id) throws IOException {
        HttpResponse response = getIssueSecurityLevelForHttpResponse(id);
        TypeReference<SecurityLevel> typeRef = new TypeReference<SecurityLevel>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get issue security level
    * Returns details of an issue security level.  Use [Get issue security scheme](#api-rest-api-3-issuesecurityschemes-id-get) to obtain the IDs of issue security levels associated with the issue security scheme.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect.
    * <p><b>404</b> - Returned if the issue security level is not found.
    * @param id The ID of the issue security level.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return SecurityLevel
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public SecurityLevel getIssueSecurityLevel(String id, Map<String, Object> params) throws IOException {
        HttpResponse response = getIssueSecurityLevelForHttpResponse(id, params);
        TypeReference<SecurityLevel> typeRef = new TypeReference<SecurityLevel>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getIssueSecurityLevelForHttpResponse(String id) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling getIssueSecurityLevel");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/securitylevel/{id}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getIssueSecurityLevelForHttpResponse(String id, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling getIssueSecurityLevel");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/securitylevel/{id}");

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
    * Get issue security level members
    * Returns issue security level members.  Only issue security level members in context of classic projects are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if no issue security level members are found.
    * @param issueSecuritySchemeId The ID of the issue security scheme. Use the [Get issue security schemes](#api-rest-api-3-issuesecurityschemes-get) operation to get a list of issue security scheme IDs.
    * @param startAt The index of the first item to return in a page of results (page offset).
    * @param maxResults The maximum number of items to return per page.
    * @param issueSecurityLevelId The list of issue security level IDs. To include multiple issue security levels separate IDs with ampersand: &#x60;issueSecurityLevelId&#x3D;10000&amp;issueSecurityLevelId&#x3D;10001&#x60;.
    * @param expand Use expand to include additional information in the response. This parameter accepts a comma-separated list. Expand options include:   *  &#x60;all&#x60; Returns all expandable information.  *  &#x60;field&#x60; Returns information about the custom field granted the permission.  *  &#x60;group&#x60; Returns information about the group that is granted the permission.  *  &#x60;projectRole&#x60; Returns information about the project role granted the permission.  *  &#x60;user&#x60; Returns information about the user who is granted the permission.
    * @return PageBeanIssueSecurityLevelMember
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanIssueSecurityLevelMember getIssueSecurityLevelMembers(Long issueSecuritySchemeId, Long startAt, Integer maxResults, Set<Long> issueSecurityLevelId, String expand) throws IOException {
        HttpResponse response = getIssueSecurityLevelMembersForHttpResponse(issueSecuritySchemeId, startAt, maxResults, issueSecurityLevelId, expand);
        TypeReference<PageBeanIssueSecurityLevelMember> typeRef = new TypeReference<PageBeanIssueSecurityLevelMember>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get issue security level members
    * Returns issue security level members.  Only issue security level members in context of classic projects are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if no issue security level members are found.
    * @param issueSecuritySchemeId The ID of the issue security scheme. Use the [Get issue security schemes](#api-rest-api-3-issuesecurityschemes-get) operation to get a list of issue security scheme IDs.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PageBeanIssueSecurityLevelMember
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanIssueSecurityLevelMember getIssueSecurityLevelMembers(Long issueSecuritySchemeId, Map<String, Object> params) throws IOException {
        HttpResponse response = getIssueSecurityLevelMembersForHttpResponse(issueSecuritySchemeId, params);
        TypeReference<PageBeanIssueSecurityLevelMember> typeRef = new TypeReference<PageBeanIssueSecurityLevelMember>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getIssueSecurityLevelMembersForHttpResponse(Long issueSecuritySchemeId, Long startAt, Integer maxResults, Set<Long> issueSecurityLevelId, String expand) throws IOException {
        // verify the required parameter 'issueSecuritySchemeId' is set
        if (issueSecuritySchemeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueSecuritySchemeId' when calling getIssueSecurityLevelMembers");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueSecuritySchemeId", issueSecuritySchemeId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuesecurityschemes/{issueSecuritySchemeId}/members");
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
        }        if (issueSecurityLevelId != null) {
            String key = "issueSecurityLevelId";
            Object value = issueSecurityLevelId;
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

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getIssueSecurityLevelMembersForHttpResponse(Long issueSecuritySchemeId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueSecuritySchemeId' is set
        if (issueSecuritySchemeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueSecuritySchemeId' when calling getIssueSecurityLevelMembers");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueSecuritySchemeId", issueSecuritySchemeId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuesecurityschemes/{issueSecuritySchemeId}/members");

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
