package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.RemoteIssueLink;
import com.atlassian.jira.rest.client.model.RemoteIssueLinkIdentifies;

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
public class IssueRemoteLinksApi {
    private ApiClient apiClient;

    public IssueRemoteLinksApi() {
        this(new ApiClient());
    }

    public IssueRemoteLinksApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Create or update remote issue link
    * Creates or updates a remote issue link for an issue.  If a &#x60;globalId&#x60; is provided and a remote issue link with that global ID is found it is updated. Any fields without values in the request are set to null. Otherwise, the remote issue link is created.  This operation requires [issue linking to be active](https://confluence.atlassian.com/x/yoXKM).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* and *Link issues* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.
    * <p><b>200</b> - Returned if the remote issue link is updated.
    * <p><b>201</b> - Returned if the remote issue link is created.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have permission to link issues.
    * <p><b>404</b> - Returned if the issue is not found or the user does not have permission to view the issue.
    * @param issueIdOrKey The ID or key of the issue.
    * @param requestBody The requestBody parameter
    * @return RemoteIssueLinkIdentifies
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public RemoteIssueLinkIdentifies createOrUpdateRemoteIssueLink(String issueIdOrKey, Map<String, Object> requestBody) throws IOException {
        HttpResponse response = createOrUpdateRemoteIssueLinkForHttpResponse(issueIdOrKey, requestBody);
        TypeReference<RemoteIssueLinkIdentifies> typeRef = new TypeReference<RemoteIssueLinkIdentifies>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Create or update remote issue link
    * Creates or updates a remote issue link for an issue.  If a &#x60;globalId&#x60; is provided and a remote issue link with that global ID is found it is updated. Any fields without values in the request are set to null. Otherwise, the remote issue link is created.  This operation requires [issue linking to be active](https://confluence.atlassian.com/x/yoXKM).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* and *Link issues* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.
    * <p><b>200</b> - Returned if the remote issue link is updated.
    * <p><b>201</b> - Returned if the remote issue link is created.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have permission to link issues.
    * <p><b>404</b> - Returned if the issue is not found or the user does not have permission to view the issue.
    * @param issueIdOrKey The ID or key of the issue.
    * @param requestBody The requestBody parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return RemoteIssueLinkIdentifies
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public RemoteIssueLinkIdentifies createOrUpdateRemoteIssueLink(String issueIdOrKey, Map<String, Object> requestBody, Map<String, Object> params) throws IOException {
        HttpResponse response = createOrUpdateRemoteIssueLinkForHttpResponse(issueIdOrKey, requestBody, params);
        TypeReference<RemoteIssueLinkIdentifies> typeRef = new TypeReference<RemoteIssueLinkIdentifies>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse createOrUpdateRemoteIssueLinkForHttpResponse(String issueIdOrKey, Map<String, Object> requestBody) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling createOrUpdateRemoteIssueLink");
        }// verify the required parameter 'requestBody' is set
        if (requestBody == null) {
            throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling createOrUpdateRemoteIssueLink");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/remotelink");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(requestBody);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse createOrUpdateRemoteIssueLinkForHttpResponse(String issueIdOrKey, java.io.InputStream requestBody, String mediaType) throws IOException {
          // verify the required parameter 'issueIdOrKey' is set
              if (issueIdOrKey == null) {
              throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling createOrUpdateRemoteIssueLink");
              }// verify the required parameter 'requestBody' is set
              if (requestBody == null) {
              throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling createOrUpdateRemoteIssueLink");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("issueIdOrKey", issueIdOrKey);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/remotelink");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = requestBody == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, requestBody);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse createOrUpdateRemoteIssueLinkForHttpResponse(String issueIdOrKey, Map<String, Object> requestBody, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling createOrUpdateRemoteIssueLink");
        }// verify the required parameter 'requestBody' is set
        if (requestBody == null) {
            throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling createOrUpdateRemoteIssueLink");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/remotelink");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(requestBody);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


  /**
    * Delete remote issue link by global ID
    * Deletes the remote issue link from the issue using the link&#39;s global ID. Where the global ID includes reserved URL characters these must be escaped in the request. For example, pass &#x60;system&#x3D;http://www.mycompany.com/support&amp;id&#x3D;1&#x60; as &#x60;system%3Dhttp%3A%2F%2Fwww.mycompany.com%2Fsupport%26id%3D1&#x60;.  This operation requires [issue linking to be active](https://confluence.atlassian.com/x/yoXKM).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* and *Link issues* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is implemented, issue-level security permission to view the issue.
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if a global ID isn&#39;t provided.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have permission to link issues.
    * <p><b>404</b> - Returned if the issue or remote issue link is not found or the user does not have permission to view the issue.
    * @param issueIdOrKey The ID or key of the issue.
    * @param globalId The global ID of a remote issue link.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteRemoteIssueLinkByGlobalId(String issueIdOrKey, String globalId) throws IOException {
        deleteRemoteIssueLinkByGlobalIdForHttpResponse(issueIdOrKey, globalId);
    }

  /**
    * Delete remote issue link by global ID
    * Deletes the remote issue link from the issue using the link&#39;s global ID. Where the global ID includes reserved URL characters these must be escaped in the request. For example, pass &#x60;system&#x3D;http://www.mycompany.com/support&amp;id&#x3D;1&#x60; as &#x60;system%3Dhttp%3A%2F%2Fwww.mycompany.com%2Fsupport%26id%3D1&#x60;.  This operation requires [issue linking to be active](https://confluence.atlassian.com/x/yoXKM).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* and *Link issues* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is implemented, issue-level security permission to view the issue.
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if a global ID isn&#39;t provided.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have permission to link issues.
    * <p><b>404</b> - Returned if the issue or remote issue link is not found or the user does not have permission to view the issue.
    * @param issueIdOrKey The ID or key of the issue.
    * @param globalId The global ID of a remote issue link.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteRemoteIssueLinkByGlobalId(String issueIdOrKey, String globalId, Map<String, Object> params) throws IOException {
        deleteRemoteIssueLinkByGlobalIdForHttpResponse(issueIdOrKey, globalId, params);
    }

    public HttpResponse deleteRemoteIssueLinkByGlobalIdForHttpResponse(String issueIdOrKey, String globalId) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling deleteRemoteIssueLinkByGlobalId");
        }// verify the required parameter 'globalId' is set
        if (globalId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'globalId' when calling deleteRemoteIssueLinkByGlobalId");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/remotelink");
        if (globalId != null) {
            String key = "globalId";
            Object value = globalId;
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

    public HttpResponse deleteRemoteIssueLinkByGlobalIdForHttpResponse(String issueIdOrKey, String globalId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling deleteRemoteIssueLinkByGlobalId");
        }// verify the required parameter 'globalId' is set
        if (globalId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'globalId' when calling deleteRemoteIssueLinkByGlobalId");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/remotelink");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);
        // Add the required query param 'globalId' to the map of query params
        allParams.put("globalId", globalId);

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
    * Delete remote issue link by ID
    * Deletes a remote issue link from an issue.  This operation requires [issue linking to be active](https://confluence.atlassian.com/x/yoXKM).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects*, *Edit issues*, and *Link issues* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the link ID is invalid or the remote issue link does not belong to the issue.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have permission to link issues.
    * <p><b>404</b> - Returned if the issue or remote issue link is not found or the user does not have permission to view the issue.
    * @param issueIdOrKey The ID or key of the issue.
    * @param linkId The ID of a remote issue link.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteRemoteIssueLinkById(String issueIdOrKey, String linkId) throws IOException {
        deleteRemoteIssueLinkByIdForHttpResponse(issueIdOrKey, linkId);
    }

  /**
    * Delete remote issue link by ID
    * Deletes a remote issue link from an issue.  This operation requires [issue linking to be active](https://confluence.atlassian.com/x/yoXKM).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects*, *Edit issues*, and *Link issues* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the link ID is invalid or the remote issue link does not belong to the issue.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have permission to link issues.
    * <p><b>404</b> - Returned if the issue or remote issue link is not found or the user does not have permission to view the issue.
    * @param issueIdOrKey The ID or key of the issue.
    * @param linkId The ID of a remote issue link.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteRemoteIssueLinkById(String issueIdOrKey, String linkId, Map<String, Object> params) throws IOException {
        deleteRemoteIssueLinkByIdForHttpResponse(issueIdOrKey, linkId, params);
    }

    public HttpResponse deleteRemoteIssueLinkByIdForHttpResponse(String issueIdOrKey, String linkId) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling deleteRemoteIssueLinkById");
        }// verify the required parameter 'linkId' is set
        if (linkId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'linkId' when calling deleteRemoteIssueLinkById");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        uriVariables.put("linkId", linkId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/remotelink/{linkId}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }

    public HttpResponse deleteRemoteIssueLinkByIdForHttpResponse(String issueIdOrKey, String linkId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling deleteRemoteIssueLinkById");
        }// verify the required parameter 'linkId' is set
        if (linkId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'linkId' when calling deleteRemoteIssueLinkById");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        uriVariables.put("linkId", linkId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/remotelink/{linkId}");

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
    * Get remote issue link by ID
    * Returns a remote issue link for an issue.  This operation requires [issue linking to be active](https://confluence.atlassian.com/x/yoXKM).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the link ID is invalid or the remote issue link does not belong to the issue.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if issue linking is disabled.
    * <p><b>404</b> - Returned if the issue or remote issue link is not found or the user does not have permission to view the issue.
    * @param issueIdOrKey The ID or key of the issue.
    * @param linkId The ID of the remote issue link.
    * @return RemoteIssueLink
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public RemoteIssueLink getRemoteIssueLinkById(String issueIdOrKey, String linkId) throws IOException {
        HttpResponse response = getRemoteIssueLinkByIdForHttpResponse(issueIdOrKey, linkId);
        TypeReference<RemoteIssueLink> typeRef = new TypeReference<RemoteIssueLink>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get remote issue link by ID
    * Returns a remote issue link for an issue.  This operation requires [issue linking to be active](https://confluence.atlassian.com/x/yoXKM).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the link ID is invalid or the remote issue link does not belong to the issue.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if issue linking is disabled.
    * <p><b>404</b> - Returned if the issue or remote issue link is not found or the user does not have permission to view the issue.
    * @param issueIdOrKey The ID or key of the issue.
    * @param linkId The ID of the remote issue link.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return RemoteIssueLink
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public RemoteIssueLink getRemoteIssueLinkById(String issueIdOrKey, String linkId, Map<String, Object> params) throws IOException {
        HttpResponse response = getRemoteIssueLinkByIdForHttpResponse(issueIdOrKey, linkId, params);
        TypeReference<RemoteIssueLink> typeRef = new TypeReference<RemoteIssueLink>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getRemoteIssueLinkByIdForHttpResponse(String issueIdOrKey, String linkId) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling getRemoteIssueLinkById");
        }// verify the required parameter 'linkId' is set
        if (linkId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'linkId' when calling getRemoteIssueLinkById");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        uriVariables.put("linkId", linkId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/remotelink/{linkId}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getRemoteIssueLinkByIdForHttpResponse(String issueIdOrKey, String linkId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling getRemoteIssueLinkById");
        }// verify the required parameter 'linkId' is set
        if (linkId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'linkId' when calling getRemoteIssueLinkById");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        uriVariables.put("linkId", linkId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/remotelink/{linkId}");

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
    * Get remote issue links
    * Returns the remote issue links for an issue. When a remote issue link global ID is provided the record with that global ID is returned, otherwise all remote issue links are returned. Where a global ID includes reserved URL characters these must be escaped in the request. For example, pass &#x60;system&#x3D;http://www.mycompany.com/support&amp;id&#x3D;1&#x60; as &#x60;system%3Dhttp%3A%2F%2Fwww.mycompany.com%2Fsupport%26id%3D1&#x60;.  This operation requires [issue linking to be active](https://confluence.atlassian.com/x/yoXKM).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if issue linking is disabled.
    * <p><b>404</b> - Returned if the issue or remote issue link is not found or the user does not have permission to view the issue.
    * @param issueIdOrKey The ID or key of the issue.
    * @param globalId The global ID of the remote issue link.
    * @return RemoteIssueLink
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public RemoteIssueLink getRemoteIssueLinks(String issueIdOrKey, String globalId) throws IOException {
        HttpResponse response = getRemoteIssueLinksForHttpResponse(issueIdOrKey, globalId);
        TypeReference<RemoteIssueLink> typeRef = new TypeReference<RemoteIssueLink>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get remote issue links
    * Returns the remote issue links for an issue. When a remote issue link global ID is provided the record with that global ID is returned, otherwise all remote issue links are returned. Where a global ID includes reserved URL characters these must be escaped in the request. For example, pass &#x60;system&#x3D;http://www.mycompany.com/support&amp;id&#x3D;1&#x60; as &#x60;system%3Dhttp%3A%2F%2Fwww.mycompany.com%2Fsupport%26id%3D1&#x60;.  This operation requires [issue linking to be active](https://confluence.atlassian.com/x/yoXKM).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if issue linking is disabled.
    * <p><b>404</b> - Returned if the issue or remote issue link is not found or the user does not have permission to view the issue.
    * @param issueIdOrKey The ID or key of the issue.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return RemoteIssueLink
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public RemoteIssueLink getRemoteIssueLinks(String issueIdOrKey, Map<String, Object> params) throws IOException {
        HttpResponse response = getRemoteIssueLinksForHttpResponse(issueIdOrKey, params);
        TypeReference<RemoteIssueLink> typeRef = new TypeReference<RemoteIssueLink>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getRemoteIssueLinksForHttpResponse(String issueIdOrKey, String globalId) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling getRemoteIssueLinks");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/remotelink");
        if (globalId != null) {
            String key = "globalId";
            Object value = globalId;
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

    public HttpResponse getRemoteIssueLinksForHttpResponse(String issueIdOrKey, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling getRemoteIssueLinks");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/remotelink");

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
    * Update remote issue link by ID
    * Updates a remote issue link for an issue.  Note: Fields without values in the request are set to null.  This operation requires [issue linking to be active](https://confluence.atlassian.com/x/yoXKM).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* and *Link issues* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  the link ID is invalid.  *  the remote issue link does not belong to the issue.  *  the request body is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have permission to link issues.
    * <p><b>404</b> - Returned if the issue or remote issue link is not found or the user does not have permission to view the issue.
    * @param issueIdOrKey The ID or key of the issue.
    * @param linkId The ID of the remote issue link.
    * @param requestBody The requestBody parameter
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object updateRemoteIssueLink(String issueIdOrKey, String linkId, Map<String, Object> requestBody) throws IOException {
        HttpResponse response = updateRemoteIssueLinkForHttpResponse(issueIdOrKey, linkId, requestBody);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Update remote issue link by ID
    * Updates a remote issue link for an issue.  Note: Fields without values in the request are set to null.  This operation requires [issue linking to be active](https://confluence.atlassian.com/x/yoXKM).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* and *Link issues* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  the link ID is invalid.  *  the remote issue link does not belong to the issue.  *  the request body is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have permission to link issues.
    * <p><b>404</b> - Returned if the issue or remote issue link is not found or the user does not have permission to view the issue.
    * @param issueIdOrKey The ID or key of the issue.
    * @param linkId The ID of the remote issue link.
    * @param requestBody The requestBody parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object updateRemoteIssueLink(String issueIdOrKey, String linkId, Map<String, Object> requestBody, Map<String, Object> params) throws IOException {
        HttpResponse response = updateRemoteIssueLinkForHttpResponse(issueIdOrKey, linkId, requestBody, params);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse updateRemoteIssueLinkForHttpResponse(String issueIdOrKey, String linkId, Map<String, Object> requestBody) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling updateRemoteIssueLink");
        }// verify the required parameter 'linkId' is set
        if (linkId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'linkId' when calling updateRemoteIssueLink");
        }// verify the required parameter 'requestBody' is set
        if (requestBody == null) {
            throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling updateRemoteIssueLink");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        uriVariables.put("linkId", linkId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/remotelink/{linkId}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(requestBody);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse updateRemoteIssueLinkForHttpResponse(String issueIdOrKey, String linkId, java.io.InputStream requestBody, String mediaType) throws IOException {
          // verify the required parameter 'issueIdOrKey' is set
              if (issueIdOrKey == null) {
              throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling updateRemoteIssueLink");
              }// verify the required parameter 'linkId' is set
              if (linkId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'linkId' when calling updateRemoteIssueLink");
              }// verify the required parameter 'requestBody' is set
              if (requestBody == null) {
              throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling updateRemoteIssueLink");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("issueIdOrKey", issueIdOrKey);
                      uriVariables.put("linkId", linkId);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/remotelink/{linkId}");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = requestBody == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, requestBody);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse updateRemoteIssueLinkForHttpResponse(String issueIdOrKey, String linkId, Map<String, Object> requestBody, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueIdOrKey' is set
        if (issueIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueIdOrKey' when calling updateRemoteIssueLink");
        }// verify the required parameter 'linkId' is set
        if (linkId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'linkId' when calling updateRemoteIssueLink");
        }// verify the required parameter 'requestBody' is set
        if (requestBody == null) {
            throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling updateRemoteIssueLink");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("issueIdOrKey", issueIdOrKey);
        uriVariables.put("linkId", linkId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/{issueIdOrKey}/remotelink/{linkId}");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(requestBody);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }


}
