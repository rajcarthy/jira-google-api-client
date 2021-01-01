package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.Avatar;
import com.atlassian.jira.rest.client.model.IssueTypeCreateBean;
import com.atlassian.jira.rest.client.model.IssueTypeDetails;
import com.atlassian.jira.rest.client.model.IssueTypeUpdateBean;

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
public class IssueTypesApi {
    private ApiClient apiClient;

    public IssueTypesApi() {
        this(new ApiClient());
    }

    public IssueTypesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Create issue type
    * Creates an issue type and adds it to the default issue type scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>201</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid because:   *  no content is sent.  *  the issue type name exceeds 60 characters.  *  a subtask issue type is requested on an instance where subtasks are disabled.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>409</b> - Returned if the issue type name is in use.
    * @param issueTypeCreateBean The issueTypeCreateBean parameter
    * @return IssueTypeDetails
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public IssueTypeDetails createIssueType(IssueTypeCreateBean issueTypeCreateBean) throws IOException {
        HttpResponse response = createIssueTypeForHttpResponse(issueTypeCreateBean);
        TypeReference<IssueTypeDetails> typeRef = new TypeReference<IssueTypeDetails>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Create issue type
    * Creates an issue type and adds it to the default issue type scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>201</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid because:   *  no content is sent.  *  the issue type name exceeds 60 characters.  *  a subtask issue type is requested on an instance where subtasks are disabled.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>409</b> - Returned if the issue type name is in use.
    * @param issueTypeCreateBean The issueTypeCreateBean parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return IssueTypeDetails
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public IssueTypeDetails createIssueType(IssueTypeCreateBean issueTypeCreateBean, Map<String, Object> params) throws IOException {
        HttpResponse response = createIssueTypeForHttpResponse(issueTypeCreateBean, params);
        TypeReference<IssueTypeDetails> typeRef = new TypeReference<IssueTypeDetails>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse createIssueTypeForHttpResponse(IssueTypeCreateBean issueTypeCreateBean) throws IOException {
        // verify the required parameter 'issueTypeCreateBean' is set
        if (issueTypeCreateBean == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeCreateBean' when calling createIssueType");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetype");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(issueTypeCreateBean);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse createIssueTypeForHttpResponse(java.io.InputStream issueTypeCreateBean, String mediaType) throws IOException {
          // verify the required parameter 'issueTypeCreateBean' is set
              if (issueTypeCreateBean == null) {
              throw new IllegalArgumentException("Missing the required parameter 'issueTypeCreateBean' when calling createIssueType");
              }
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetype");

              String localVarUrl = uriBuilder.build().toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = issueTypeCreateBean == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, issueTypeCreateBean);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse createIssueTypeForHttpResponse(IssueTypeCreateBean issueTypeCreateBean, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issueTypeCreateBean' is set
        if (issueTypeCreateBean == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeCreateBean' when calling createIssueType");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetype");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(issueTypeCreateBean);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


  /**
    * Load issue type avatar
    * Loads an avatar for the issue type.  Specify the avatar&#39;s local file location in the body of the request. Also, include the following headers:   *  &#x60;X-Atlassian-Token: no-check&#x60; To prevent XSRF protection blocking the request, for more information see [Special Headers](#special-request-headers).  *  &#x60;Content-Type: image/image type&#x60; Valid image types are JPEG, GIF, or PNG.  For example:   &#x60;curl --request POST \\ --user email@example.com:&lt;api_token&gt; \\ --header &#39;X-Atlassian-Token: no-check&#39; \\ --header &#39;Content-Type: image/&lt; image_type&gt;&#39; \\ --data-binary \&quot;&lt;@/path/to/file/with/your/avatar&gt;\&quot; \\ --url &#39;https://your-domain.atlassian.net/rest/api/3/issuetype/{issueTypeId}&#39;This&#x60;  The avatar is cropped to a square. If no crop parameters are specified, the square originates at the top left of the image. The length of the square&#39;s sides is set to the smaller of the height or width of the image.  The cropped image is then used to create avatars of 16x16, 24x24, 32x32, and 48x48 in size.  After creating the avatar, use [ Update issue type](#api-rest-api-3-issuetype-id-put) to set it as the issue type&#39;s displayed avatar.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>201</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  an image isn&#39;t included in the request.  *  the image type is unsupported.  *  the crop parameters extend the crop area beyond the edge of the image.  *  &#x60;cropSize&#x60; is missing.  *  the issue type ID is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the issue type is not found.
    * @param id The ID of the issue type.
    * @param size The length of each side of the crop region.
    * @param body The body parameter
    * @param x The X coordinate of the top-left corner of the crop region.
    * @param y The Y coordinate of the top-left corner of the crop region.
    * @return Avatar
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Avatar createIssueTypeAvatar(String id, Integer size, Object body, Integer x, Integer y) throws IOException {
        HttpResponse response = createIssueTypeAvatarForHttpResponse(id, size, body, x, y);
        TypeReference<Avatar> typeRef = new TypeReference<Avatar>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Load issue type avatar
    * Loads an avatar for the issue type.  Specify the avatar&#39;s local file location in the body of the request. Also, include the following headers:   *  &#x60;X-Atlassian-Token: no-check&#x60; To prevent XSRF protection blocking the request, for more information see [Special Headers](#special-request-headers).  *  &#x60;Content-Type: image/image type&#x60; Valid image types are JPEG, GIF, or PNG.  For example:   &#x60;curl --request POST \\ --user email@example.com:&lt;api_token&gt; \\ --header &#39;X-Atlassian-Token: no-check&#39; \\ --header &#39;Content-Type: image/&lt; image_type&gt;&#39; \\ --data-binary \&quot;&lt;@/path/to/file/with/your/avatar&gt;\&quot; \\ --url &#39;https://your-domain.atlassian.net/rest/api/3/issuetype/{issueTypeId}&#39;This&#x60;  The avatar is cropped to a square. If no crop parameters are specified, the square originates at the top left of the image. The length of the square&#39;s sides is set to the smaller of the height or width of the image.  The cropped image is then used to create avatars of 16x16, 24x24, 32x32, and 48x48 in size.  After creating the avatar, use [ Update issue type](#api-rest-api-3-issuetype-id-put) to set it as the issue type&#39;s displayed avatar.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>201</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  an image isn&#39;t included in the request.  *  the image type is unsupported.  *  the crop parameters extend the crop area beyond the edge of the image.  *  &#x60;cropSize&#x60; is missing.  *  the issue type ID is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the issue type is not found.
    * @param id The ID of the issue type.
    * @param size The length of each side of the crop region.
    * @param body The body parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Avatar
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Avatar createIssueTypeAvatar(String id, Integer size, Object body, Map<String, Object> params) throws IOException {
        HttpResponse response = createIssueTypeAvatarForHttpResponse(id, size, body, params);
        TypeReference<Avatar> typeRef = new TypeReference<Avatar>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse createIssueTypeAvatarForHttpResponse(String id, Integer size, Object body, Integer x, Integer y) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling createIssueTypeAvatar");
        }// verify the required parameter 'size' is set
        if (size == null) {
            throw new IllegalArgumentException("Missing the required parameter 'size' when calling createIssueTypeAvatar");
        }// verify the required parameter 'body' is set
        if (body == null) {
            throw new IllegalArgumentException("Missing the required parameter 'body' when calling createIssueTypeAvatar");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetype/{id}/avatar2");
        if (x != null) {
            String key = "x";
            Object value = x;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (y != null) {
            String key = "y";
            Object value = y;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (size != null) {
            String key = "size";
            Object value = size;
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

        HttpContent content = apiClient.new JacksonJsonHttpContent(body);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse createIssueTypeAvatarForHttpResponse(String id, Integer size, java.io.InputStream body, Integer x, Integer y, String mediaType) throws IOException {
          // verify the required parameter 'id' is set
              if (id == null) {
              throw new IllegalArgumentException("Missing the required parameter 'id' when calling createIssueTypeAvatar");
              }// verify the required parameter 'size' is set
              if (size == null) {
              throw new IllegalArgumentException("Missing the required parameter 'size' when calling createIssueTypeAvatar");
              }// verify the required parameter 'body' is set
              if (body == null) {
              throw new IllegalArgumentException("Missing the required parameter 'body' when calling createIssueTypeAvatar");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("id", id);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetype/{id}/avatar2");
              if (x != null) {
                  String key = "x";
                  Object value = x;
                  if (value instanceof Collection) {
                    uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
                  } else if (value instanceof Object[]) {
                    uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
                  } else {
                    uriBuilder = uriBuilder.queryParam(key, value);
                  }
              }              if (y != null) {
                  String key = "y";
                  Object value = y;
                  if (value instanceof Collection) {
                    uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
                  } else if (value instanceof Object[]) {
                    uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
                  } else {
                    uriBuilder = uriBuilder.queryParam(key, value);
                  }
              }              if (size != null) {
                  String key = "size";
                  Object value = size;
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

              HttpContent content = body == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, body);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse createIssueTypeAvatarForHttpResponse(String id, Integer size, Object body, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling createIssueTypeAvatar");
        }// verify the required parameter 'size' is set
        if (size == null) {
            throw new IllegalArgumentException("Missing the required parameter 'size' when calling createIssueTypeAvatar");
        }// verify the required parameter 'body' is set
        if (body == null) {
            throw new IllegalArgumentException("Missing the required parameter 'body' when calling createIssueTypeAvatar");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetype/{id}/avatar2");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);
        // Add the required query param 'size' to the map of query params
        allParams.put("size", size);

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(body);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


  /**
    * Delete issue type
    * Deletes the issue type. If the issue type is in use, all uses are updated with the alternative issue type (&#x60;alternativeIssueTypeId&#x60;). A list of alternative issue types are obtained from the [Get alternative issue types](#api-rest-api-3-issuetype-id-alternatives-get) resource.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if any issues cannot be updated with the alternative issue type.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if:   *  the issue type is in use and an alternative issue type is not specified.  *  the issue type or alternative issue type is not found.
    * <p><b>409</b> - Returned if the issue type is in use and:   *  also specified as the alternative issue type.  *  is a *standard* issue type and the alternative issue type is a *subtask*.
    * @param id The ID of the issue type.
    * @param alternativeIssueTypeId The ID of the replacement issue type.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteIssueType(String id, String alternativeIssueTypeId) throws IOException {
        deleteIssueTypeForHttpResponse(id, alternativeIssueTypeId);
    }

  /**
    * Delete issue type
    * Deletes the issue type. If the issue type is in use, all uses are updated with the alternative issue type (&#x60;alternativeIssueTypeId&#x60;). A list of alternative issue types are obtained from the [Get alternative issue types](#api-rest-api-3-issuetype-id-alternatives-get) resource.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if any issues cannot be updated with the alternative issue type.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if:   *  the issue type is in use and an alternative issue type is not specified.  *  the issue type or alternative issue type is not found.
    * <p><b>409</b> - Returned if the issue type is in use and:   *  also specified as the alternative issue type.  *  is a *standard* issue type and the alternative issue type is a *subtask*.
    * @param id The ID of the issue type.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteIssueType(String id, Map<String, Object> params) throws IOException {
        deleteIssueTypeForHttpResponse(id, params);
    }

    public HttpResponse deleteIssueTypeForHttpResponse(String id, String alternativeIssueTypeId) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling deleteIssueType");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetype/{id}");
        if (alternativeIssueTypeId != null) {
            String key = "alternativeIssueTypeId";
            Object value = alternativeIssueTypeId;
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

    public HttpResponse deleteIssueTypeForHttpResponse(String id, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling deleteIssueType");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetype/{id}");

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
    * Get alternative issue types
    * Returns a list of issue types that can be used to replace the issue type. The alternative issue types are those assigned to the same workflow scheme, field configuration scheme, and screen scheme.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if:   *  the issue type is not found.  *  the user does not have the required permissions.
    * @param id The ID of the issue type.
    * @return List&lt;IssueTypeDetails&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<IssueTypeDetails> getAlternativeIssueTypes(String id) throws IOException {
        HttpResponse response = getAlternativeIssueTypesForHttpResponse(id);
        TypeReference<List<IssueTypeDetails>> typeRef = new TypeReference<List<IssueTypeDetails>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get alternative issue types
    * Returns a list of issue types that can be used to replace the issue type. The alternative issue types are those assigned to the same workflow scheme, field configuration scheme, and screen scheme.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if:   *  the issue type is not found.  *  the user does not have the required permissions.
    * @param id The ID of the issue type.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return List&lt;IssueTypeDetails&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<IssueTypeDetails> getAlternativeIssueTypes(String id, Map<String, Object> params) throws IOException {
        HttpResponse response = getAlternativeIssueTypesForHttpResponse(id, params);
        TypeReference<List<IssueTypeDetails>> typeRef = new TypeReference<List<IssueTypeDetails>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getAlternativeIssueTypesForHttpResponse(String id) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling getAlternativeIssueTypes");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetype/{id}/alternatives");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getAlternativeIssueTypesForHttpResponse(String id, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling getAlternativeIssueTypes");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetype/{id}/alternatives");

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
    * Get all issue types for user
    * Returns all issue types.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** Issue types are only returned as follows:   *  if the user has the *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg), all issue types are returned.  *  if the user has the *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for one or more projects, the issue types associated with the projects the user has permission to browse are returned.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @return List&lt;IssueTypeDetails&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<IssueTypeDetails> getIssueAllTypes() throws IOException {
        HttpResponse response = getIssueAllTypesForHttpResponse();
        TypeReference<List<IssueTypeDetails>> typeRef = new TypeReference<List<IssueTypeDetails>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get all issue types for user
    * Returns all issue types.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** Issue types are only returned as follows:   *  if the user has the *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg), all issue types are returned.  *  if the user has the *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for one or more projects, the issue types associated with the projects the user has permission to browse are returned.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return List&lt;IssueTypeDetails&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<IssueTypeDetails> getIssueAllTypes(Map<String, Object> params) throws IOException {
        HttpResponse response = getIssueAllTypesForHttpResponse(params);
        TypeReference<List<IssueTypeDetails>> typeRef = new TypeReference<List<IssueTypeDetails>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getIssueAllTypesForHttpResponse() throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetype");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getIssueAllTypesForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetype");

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
    * Get issue type
    * Returns an issue type.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) in a project the issue type is associated with or *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the issue type ID is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if:   *  the issue type is not found.  *  the user does not have the required permissions.
    * @param id The ID of the issue type.
    * @return IssueTypeDetails
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public IssueTypeDetails getIssueType(String id) throws IOException {
        HttpResponse response = getIssueTypeForHttpResponse(id);
        TypeReference<IssueTypeDetails> typeRef = new TypeReference<IssueTypeDetails>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get issue type
    * Returns an issue type.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) in a project the issue type is associated with or *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the issue type ID is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if:   *  the issue type is not found.  *  the user does not have the required permissions.
    * @param id The ID of the issue type.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return IssueTypeDetails
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public IssueTypeDetails getIssueType(String id, Map<String, Object> params) throws IOException {
        HttpResponse response = getIssueTypeForHttpResponse(id, params);
        TypeReference<IssueTypeDetails> typeRef = new TypeReference<IssueTypeDetails>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getIssueTypeForHttpResponse(String id) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling getIssueType");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetype/{id}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getIssueTypeForHttpResponse(String id, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling getIssueType");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetype/{id}");

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
    * Update issue type
    * Updates the issue type.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid because:   *  no content is sent.  *  the issue type name exceeds 60 characters.  *  the avatar is not associated with this issue type.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the issue type is not found.
    * <p><b>409</b> - Returned if the issue type name is in use.
    * @param id The ID of the issue type.
    * @param issueTypeUpdateBean The issueTypeUpdateBean parameter
    * @return IssueTypeDetails
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public IssueTypeDetails updateIssueType(String id, IssueTypeUpdateBean issueTypeUpdateBean) throws IOException {
        HttpResponse response = updateIssueTypeForHttpResponse(id, issueTypeUpdateBean);
        TypeReference<IssueTypeDetails> typeRef = new TypeReference<IssueTypeDetails>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Update issue type
    * Updates the issue type.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid because:   *  no content is sent.  *  the issue type name exceeds 60 characters.  *  the avatar is not associated with this issue type.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the issue type is not found.
    * <p><b>409</b> - Returned if the issue type name is in use.
    * @param id The ID of the issue type.
    * @param issueTypeUpdateBean The issueTypeUpdateBean parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return IssueTypeDetails
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public IssueTypeDetails updateIssueType(String id, IssueTypeUpdateBean issueTypeUpdateBean, Map<String, Object> params) throws IOException {
        HttpResponse response = updateIssueTypeForHttpResponse(id, issueTypeUpdateBean, params);
        TypeReference<IssueTypeDetails> typeRef = new TypeReference<IssueTypeDetails>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse updateIssueTypeForHttpResponse(String id, IssueTypeUpdateBean issueTypeUpdateBean) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling updateIssueType");
        }// verify the required parameter 'issueTypeUpdateBean' is set
        if (issueTypeUpdateBean == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeUpdateBean' when calling updateIssueType");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetype/{id}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(issueTypeUpdateBean);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse updateIssueTypeForHttpResponse(String id, java.io.InputStream issueTypeUpdateBean, String mediaType) throws IOException {
          // verify the required parameter 'id' is set
              if (id == null) {
              throw new IllegalArgumentException("Missing the required parameter 'id' when calling updateIssueType");
              }// verify the required parameter 'issueTypeUpdateBean' is set
              if (issueTypeUpdateBean == null) {
              throw new IllegalArgumentException("Missing the required parameter 'issueTypeUpdateBean' when calling updateIssueType");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("id", id);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetype/{id}");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = issueTypeUpdateBean == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, issueTypeUpdateBean);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse updateIssueTypeForHttpResponse(String id, IssueTypeUpdateBean issueTypeUpdateBean, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling updateIssueType");
        }// verify the required parameter 'issueTypeUpdateBean' is set
        if (issueTypeUpdateBean == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueTypeUpdateBean' when calling updateIssueType");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issuetype/{id}");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(issueTypeUpdateBean);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }


}
