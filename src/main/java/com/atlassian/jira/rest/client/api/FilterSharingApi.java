package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.DefaultShareScope;
import com.atlassian.jira.rest.client.model.SharePermission;
import com.atlassian.jira.rest.client.model.SharePermissionInputBean;

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
public class FilterSharingApi {
    private ApiClient apiClient;

    public FilterSharingApi() {
        this(new ApiClient());
    }

    public FilterSharingApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Add share permission
    * Add a share permissions to a filter. If you add a global share permission (one for all logged-in users or the public) it will overwrite all share permissions for the filter.  Be aware that this operation uses different objects for updating share permissions compared to [Update filter](#api-rest-api-3-filter-id-put).  **[Permissions](#permissions) required:** *Share dashboards and filters* [global permission](https://confluence.atlassian.com/x/x4dKLg) and the user must own the filter.
    * <p><b>201</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  the request object is invalid. For example, it contains an invalid type, the ID does not match the type, or the project or group is not found.  *  the user does not own the filter.  *  the user does not have the required permissions.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if:   *  the filter is not found.  *  the user does not have permission to view the filter.
    * @param id The ID of the filter.
    * @param sharePermissionInputBean The sharePermissionInputBean parameter
    * @return List&lt;SharePermission&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<SharePermission> addSharePermission(Long id, SharePermissionInputBean sharePermissionInputBean) throws IOException {
        HttpResponse response = addSharePermissionForHttpResponse(id, sharePermissionInputBean);
        TypeReference<List<SharePermission>> typeRef = new TypeReference<List<SharePermission>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Add share permission
    * Add a share permissions to a filter. If you add a global share permission (one for all logged-in users or the public) it will overwrite all share permissions for the filter.  Be aware that this operation uses different objects for updating share permissions compared to [Update filter](#api-rest-api-3-filter-id-put).  **[Permissions](#permissions) required:** *Share dashboards and filters* [global permission](https://confluence.atlassian.com/x/x4dKLg) and the user must own the filter.
    * <p><b>201</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  the request object is invalid. For example, it contains an invalid type, the ID does not match the type, or the project or group is not found.  *  the user does not own the filter.  *  the user does not have the required permissions.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if:   *  the filter is not found.  *  the user does not have permission to view the filter.
    * @param id The ID of the filter.
    * @param sharePermissionInputBean The sharePermissionInputBean parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return List&lt;SharePermission&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<SharePermission> addSharePermission(Long id, SharePermissionInputBean sharePermissionInputBean, Map<String, Object> params) throws IOException {
        HttpResponse response = addSharePermissionForHttpResponse(id, sharePermissionInputBean, params);
        TypeReference<List<SharePermission>> typeRef = new TypeReference<List<SharePermission>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse addSharePermissionForHttpResponse(Long id, SharePermissionInputBean sharePermissionInputBean) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling addSharePermission");
        }// verify the required parameter 'sharePermissionInputBean' is set
        if (sharePermissionInputBean == null) {
            throw new IllegalArgumentException("Missing the required parameter 'sharePermissionInputBean' when calling addSharePermission");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/filter/{id}/permission");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(sharePermissionInputBean);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse addSharePermissionForHttpResponse(Long id, java.io.InputStream sharePermissionInputBean, String mediaType) throws IOException {
          // verify the required parameter 'id' is set
              if (id == null) {
              throw new IllegalArgumentException("Missing the required parameter 'id' when calling addSharePermission");
              }// verify the required parameter 'sharePermissionInputBean' is set
              if (sharePermissionInputBean == null) {
              throw new IllegalArgumentException("Missing the required parameter 'sharePermissionInputBean' when calling addSharePermission");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("id", id);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/filter/{id}/permission");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = sharePermissionInputBean == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, sharePermissionInputBean);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse addSharePermissionForHttpResponse(Long id, SharePermissionInputBean sharePermissionInputBean, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling addSharePermission");
        }// verify the required parameter 'sharePermissionInputBean' is set
        if (sharePermissionInputBean == null) {
            throw new IllegalArgumentException("Missing the required parameter 'sharePermissionInputBean' when calling addSharePermission");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/filter/{id}/permission");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(sharePermissionInputBean);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


  /**
    * Delete share permission
    * Deletes a share permission from a filter.  **[Permissions](#permissions) required:** Permission to access Jira and the user must own the filter.
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if:   *  the filter is not found.  *  the user does not own the filter.
    * @param id The ID of the filter.
    * @param permissionId The ID of the share permission.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteSharePermission(Long id, Long permissionId) throws IOException {
        deleteSharePermissionForHttpResponse(id, permissionId);
    }

  /**
    * Delete share permission
    * Deletes a share permission from a filter.  **[Permissions](#permissions) required:** Permission to access Jira and the user must own the filter.
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if:   *  the filter is not found.  *  the user does not own the filter.
    * @param id The ID of the filter.
    * @param permissionId The ID of the share permission.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteSharePermission(Long id, Long permissionId, Map<String, Object> params) throws IOException {
        deleteSharePermissionForHttpResponse(id, permissionId, params);
    }

    public HttpResponse deleteSharePermissionForHttpResponse(Long id, Long permissionId) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling deleteSharePermission");
        }// verify the required parameter 'permissionId' is set
        if (permissionId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'permissionId' when calling deleteSharePermission");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        uriVariables.put("permissionId", permissionId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/filter/{id}/permission/{permissionId}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }

    public HttpResponse deleteSharePermissionForHttpResponse(Long id, Long permissionId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling deleteSharePermission");
        }// verify the required parameter 'permissionId' is set
        if (permissionId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'permissionId' when calling deleteSharePermission");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        uriVariables.put("permissionId", permissionId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/filter/{id}/permission/{permissionId}");

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
    * Get default share scope
    * Returns the default sharing settings for new filters and dashboards for a user.  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @return DefaultShareScope
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public DefaultShareScope getDefaultShareScope() throws IOException {
        HttpResponse response = getDefaultShareScopeForHttpResponse();
        TypeReference<DefaultShareScope> typeRef = new TypeReference<DefaultShareScope>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get default share scope
    * Returns the default sharing settings for new filters and dashboards for a user.  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return DefaultShareScope
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public DefaultShareScope getDefaultShareScope(Map<String, Object> params) throws IOException {
        HttpResponse response = getDefaultShareScopeForHttpResponse(params);
        TypeReference<DefaultShareScope> typeRef = new TypeReference<DefaultShareScope>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getDefaultShareScopeForHttpResponse() throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/filter/defaultShareScope");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getDefaultShareScopeForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/filter/defaultShareScope");

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
    * Get share permission
    * Returns a share permission for a filter. A filter can be shared with groups, projects, all logged-in users, or the public. Sharing with all logged-in users or the public is known as a global share permission.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None, however, a share permission is only returned for:   *  filters owned by the user.  *  filters shared with a group that the user is a member of.  *  filters shared with a private project that the user has *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for.  *  filters shared with a public project.  *  filters shared with the public.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if:   *  the filter is not found.  *  the permission is not found.  *  the user does not have permission to view the filter.
    * @param id The ID of the filter.
    * @param permissionId The ID of the share permission.
    * @return SharePermission
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public SharePermission getSharePermission(Long id, Long permissionId) throws IOException {
        HttpResponse response = getSharePermissionForHttpResponse(id, permissionId);
        TypeReference<SharePermission> typeRef = new TypeReference<SharePermission>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get share permission
    * Returns a share permission for a filter. A filter can be shared with groups, projects, all logged-in users, or the public. Sharing with all logged-in users or the public is known as a global share permission.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None, however, a share permission is only returned for:   *  filters owned by the user.  *  filters shared with a group that the user is a member of.  *  filters shared with a private project that the user has *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for.  *  filters shared with a public project.  *  filters shared with the public.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if:   *  the filter is not found.  *  the permission is not found.  *  the user does not have permission to view the filter.
    * @param id The ID of the filter.
    * @param permissionId The ID of the share permission.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return SharePermission
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public SharePermission getSharePermission(Long id, Long permissionId, Map<String, Object> params) throws IOException {
        HttpResponse response = getSharePermissionForHttpResponse(id, permissionId, params);
        TypeReference<SharePermission> typeRef = new TypeReference<SharePermission>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getSharePermissionForHttpResponse(Long id, Long permissionId) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling getSharePermission");
        }// verify the required parameter 'permissionId' is set
        if (permissionId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'permissionId' when calling getSharePermission");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        uriVariables.put("permissionId", permissionId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/filter/{id}/permission/{permissionId}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getSharePermissionForHttpResponse(Long id, Long permissionId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling getSharePermission");
        }// verify the required parameter 'permissionId' is set
        if (permissionId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'permissionId' when calling getSharePermission");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        uriVariables.put("permissionId", permissionId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/filter/{id}/permission/{permissionId}");

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
    * Get share permissions
    * Returns the share permissions for a filter. A filter can be shared with groups, projects, all logged-in users, or the public. Sharing with all logged-in users or the public is known as a global share permission.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None, however, share permissions are only returned for:   *  filters owned by the user.  *  filters shared with a group that the user is a member of.  *  filters shared with a private project that the user has *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for.  *  filters shared with a public project.  *  filters shared with the public.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if:   *  the filter is not found.  *  the user does not have permission to view the filter.
    * @param id The ID of the filter.
    * @return List&lt;SharePermission&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<SharePermission> getSharePermissions(Long id) throws IOException {
        HttpResponse response = getSharePermissionsForHttpResponse(id);
        TypeReference<List<SharePermission>> typeRef = new TypeReference<List<SharePermission>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get share permissions
    * Returns the share permissions for a filter. A filter can be shared with groups, projects, all logged-in users, or the public. Sharing with all logged-in users or the public is known as a global share permission.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None, however, share permissions are only returned for:   *  filters owned by the user.  *  filters shared with a group that the user is a member of.  *  filters shared with a private project that the user has *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for.  *  filters shared with a public project.  *  filters shared with the public.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if:   *  the filter is not found.  *  the user does not have permission to view the filter.
    * @param id The ID of the filter.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return List&lt;SharePermission&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<SharePermission> getSharePermissions(Long id, Map<String, Object> params) throws IOException {
        HttpResponse response = getSharePermissionsForHttpResponse(id, params);
        TypeReference<List<SharePermission>> typeRef = new TypeReference<List<SharePermission>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getSharePermissionsForHttpResponse(Long id) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling getSharePermissions");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/filter/{id}/permission");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getSharePermissionsForHttpResponse(Long id, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling getSharePermissions");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/filter/{id}/permission");

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
    * Set default share scope
    * Sets the default sharing for new filters and dashboards for a user.  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if an invalid scope is set.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param defaultShareScope The defaultShareScope parameter
    * @return DefaultShareScope
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public DefaultShareScope setDefaultShareScope(DefaultShareScope defaultShareScope) throws IOException {
        HttpResponse response = setDefaultShareScopeForHttpResponse(defaultShareScope);
        TypeReference<DefaultShareScope> typeRef = new TypeReference<DefaultShareScope>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Set default share scope
    * Sets the default sharing for new filters and dashboards for a user.  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if an invalid scope is set.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param defaultShareScope The defaultShareScope parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return DefaultShareScope
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public DefaultShareScope setDefaultShareScope(DefaultShareScope defaultShareScope, Map<String, Object> params) throws IOException {
        HttpResponse response = setDefaultShareScopeForHttpResponse(defaultShareScope, params);
        TypeReference<DefaultShareScope> typeRef = new TypeReference<DefaultShareScope>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse setDefaultShareScopeForHttpResponse(DefaultShareScope defaultShareScope) throws IOException {
        // verify the required parameter 'defaultShareScope' is set
        if (defaultShareScope == null) {
            throw new IllegalArgumentException("Missing the required parameter 'defaultShareScope' when calling setDefaultShareScope");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/filter/defaultShareScope");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(defaultShareScope);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse setDefaultShareScopeForHttpResponse(java.io.InputStream defaultShareScope, String mediaType) throws IOException {
          // verify the required parameter 'defaultShareScope' is set
              if (defaultShareScope == null) {
              throw new IllegalArgumentException("Missing the required parameter 'defaultShareScope' when calling setDefaultShareScope");
              }
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/filter/defaultShareScope");

              String localVarUrl = uriBuilder.build().toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = defaultShareScope == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, defaultShareScope);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse setDefaultShareScopeForHttpResponse(DefaultShareScope defaultShareScope, Map<String, Object> params) throws IOException {
        // verify the required parameter 'defaultShareScope' is set
        if (defaultShareScope == null) {
            throw new IllegalArgumentException("Missing the required parameter 'defaultShareScope' when calling setDefaultShareScope");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/filter/defaultShareScope");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(defaultShareScope);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }


}
