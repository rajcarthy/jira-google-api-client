package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.IssueLink;
import com.atlassian.jira.rest.client.model.LinkIssueRequestJsonBean;

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
public class IssueLinksApi {
    private ApiClient apiClient;

    public IssueLinksApi() {
        this(new ApiClient());
    }

    public IssueLinksApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Delete issue link
    * Deletes an issue link.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  Browse project [project permission](https://confluence.atlassian.com/x/yodKLg) for all the projects containing the issues in the link.  *  *Link issues* [project permission](https://confluence.atlassian.com/x/yodKLg) for at least one of the projects containing issues in the link.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, permission to view both of the issues.
    * <p><b>200</b> - 200 response
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the issue link ID is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if:   *  issue linking is disabled.  *  the issue link is not found.  *  the user doesn&#39;t have the required permissions.
    * @param linkId The ID of the issue link.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteIssueLink(String linkId) throws IOException {
        deleteIssueLinkForHttpResponse(linkId);
    }

  /**
    * Delete issue link
    * Deletes an issue link.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  Browse project [project permission](https://confluence.atlassian.com/x/yodKLg) for all the projects containing the issues in the link.  *  *Link issues* [project permission](https://confluence.atlassian.com/x/yodKLg) for at least one of the projects containing issues in the link.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, permission to view both of the issues.
    * <p><b>200</b> - 200 response
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the issue link ID is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if:   *  issue linking is disabled.  *  the issue link is not found.  *  the user doesn&#39;t have the required permissions.
    * @param linkId The ID of the issue link.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteIssueLink(String linkId, Map<String, Object> params) throws IOException {
        deleteIssueLinkForHttpResponse(linkId, params);
    }

    public HttpResponse deleteIssueLinkForHttpResponse(String linkId) throws IOException {
        // verify the required parameter 'linkId' is set
        if (linkId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'linkId' when calling deleteIssueLink");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("linkId", linkId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issueLink/{linkId}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }

    public HttpResponse deleteIssueLinkForHttpResponse(String linkId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'linkId' is set
        if (linkId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'linkId' when calling deleteIssueLink");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("linkId", linkId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issueLink/{linkId}");

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
    * Get issue link
    * Returns an issue link.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse project* [project permission](https://confluence.atlassian.com/x/yodKLg) for all the projects containing the linked issues.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, permission to view both of the issues.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the issue link ID is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if:   *  issue linking is disabled.  *  the issue link is not found.  *  the user doesn&#39;t have the required permissions.
    * @param linkId The ID of the issue link.
    * @return IssueLink
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public IssueLink getIssueLink(String linkId) throws IOException {
        HttpResponse response = getIssueLinkForHttpResponse(linkId);
        TypeReference<IssueLink> typeRef = new TypeReference<IssueLink>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get issue link
    * Returns an issue link.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse project* [project permission](https://confluence.atlassian.com/x/yodKLg) for all the projects containing the linked issues.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, permission to view both of the issues.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the issue link ID is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if:   *  issue linking is disabled.  *  the issue link is not found.  *  the user doesn&#39;t have the required permissions.
    * @param linkId The ID of the issue link.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return IssueLink
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public IssueLink getIssueLink(String linkId, Map<String, Object> params) throws IOException {
        HttpResponse response = getIssueLinkForHttpResponse(linkId, params);
        TypeReference<IssueLink> typeRef = new TypeReference<IssueLink>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getIssueLinkForHttpResponse(String linkId) throws IOException {
        // verify the required parameter 'linkId' is set
        if (linkId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'linkId' when calling getIssueLink");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("linkId", linkId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issueLink/{linkId}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getIssueLinkForHttpResponse(String linkId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'linkId' is set
        if (linkId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'linkId' when calling getIssueLink");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("linkId", linkId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issueLink/{linkId}");

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
    * Create issue link
    * Creates a link between two issues. Use this operation to indicate a relationship between two issues and optionally add a comment to the from (outward) issue. To use this resource the site must have [Issue Linking](https://confluence.atlassian.com/x/yoXKM) enabled.  This resource returns nothing on the creation of an issue link. To obtain the ID of the issue link, use &#x60;https://your-domain.atlassian.net/rest/api/3/issue/[linked issue key]?fields&#x3D;issuelinks&#x60;.  If the link request duplicates a link, the response indicates that the issue link was created. If the request included a comment, the comment is added.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse project* [project permission](https://confluence.atlassian.com/x/yodKLg) for all the projects containing the issues to be linked,  *  *Link issues* [project permission](https://confluence.atlassian.com/x/yodKLg) on the project containing the from (outward) issue,  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  If the comment has visibility restrictions, belongs to the group or has the role visibility is restricted to.
    * <p><b>201</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the comment is not created. The response contains an error message indicating why the comment wasn&#39;t created. The issue link is also not created.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if:   *  issue linking is disabled.  *  the user cannot view one or both of the issues. For example, the user doesn&#39;t have *Browse project* project permission for a project containing one of the issues.  *  the user does not have *link issues* project permission.  *  either of the link issues are not found.  *  the issue link type is not found.
    * @param linkIssueRequestJsonBean The issue link request.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object linkIssues(LinkIssueRequestJsonBean linkIssueRequestJsonBean) throws IOException {
        HttpResponse response = linkIssuesForHttpResponse(linkIssueRequestJsonBean);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Create issue link
    * Creates a link between two issues. Use this operation to indicate a relationship between two issues and optionally add a comment to the from (outward) issue. To use this resource the site must have [Issue Linking](https://confluence.atlassian.com/x/yoXKM) enabled.  This resource returns nothing on the creation of an issue link. To obtain the ID of the issue link, use &#x60;https://your-domain.atlassian.net/rest/api/3/issue/[linked issue key]?fields&#x3D;issuelinks&#x60;.  If the link request duplicates a link, the response indicates that the issue link was created. If the request included a comment, the comment is added.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse project* [project permission](https://confluence.atlassian.com/x/yodKLg) for all the projects containing the issues to be linked,  *  *Link issues* [project permission](https://confluence.atlassian.com/x/yodKLg) on the project containing the from (outward) issue,  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  If the comment has visibility restrictions, belongs to the group or has the role visibility is restricted to.
    * <p><b>201</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the comment is not created. The response contains an error message indicating why the comment wasn&#39;t created. The issue link is also not created.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if:   *  issue linking is disabled.  *  the user cannot view one or both of the issues. For example, the user doesn&#39;t have *Browse project* project permission for a project containing one of the issues.  *  the user does not have *link issues* project permission.  *  either of the link issues are not found.  *  the issue link type is not found.
    * @param linkIssueRequestJsonBean The issue link request.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object linkIssues(LinkIssueRequestJsonBean linkIssueRequestJsonBean, Map<String, Object> params) throws IOException {
        HttpResponse response = linkIssuesForHttpResponse(linkIssueRequestJsonBean, params);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse linkIssuesForHttpResponse(LinkIssueRequestJsonBean linkIssueRequestJsonBean) throws IOException {
        // verify the required parameter 'linkIssueRequestJsonBean' is set
        if (linkIssueRequestJsonBean == null) {
            throw new IllegalArgumentException("Missing the required parameter 'linkIssueRequestJsonBean' when calling linkIssues");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issueLink");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(linkIssueRequestJsonBean);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse linkIssuesForHttpResponse(java.io.InputStream linkIssueRequestJsonBean, String mediaType) throws IOException {
          // verify the required parameter 'linkIssueRequestJsonBean' is set
              if (linkIssueRequestJsonBean == null) {
              throw new IllegalArgumentException("Missing the required parameter 'linkIssueRequestJsonBean' when calling linkIssues");
              }
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issueLink");

              String localVarUrl = uriBuilder.build().toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = linkIssueRequestJsonBean == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, linkIssueRequestJsonBean);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse linkIssuesForHttpResponse(LinkIssueRequestJsonBean linkIssueRequestJsonBean, Map<String, Object> params) throws IOException {
        // verify the required parameter 'linkIssueRequestJsonBean' is set
        if (linkIssueRequestJsonBean == null) {
            throw new IllegalArgumentException("Missing the required parameter 'linkIssueRequestJsonBean' when calling linkIssues");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issueLink");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(linkIssueRequestJsonBean);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


}
