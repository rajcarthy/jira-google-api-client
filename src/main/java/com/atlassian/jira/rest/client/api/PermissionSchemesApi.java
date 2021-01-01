package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.PermissionGrant;
import com.atlassian.jira.rest.client.model.PermissionGrants;
import com.atlassian.jira.rest.client.model.PermissionScheme;
import com.atlassian.jira.rest.client.model.PermissionSchemes;

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
public class PermissionSchemesApi {
    private ApiClient apiClient;

    public PermissionSchemesApi() {
        this(new ApiClient());
    }

    public PermissionSchemesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Create permission grant
    * Creates a permission grant in a permission scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>201</b> - Returned if the scheme permission is created.
    * <p><b>400</b> - Returned if the value for expand is invalid or the same permission grant is present.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * @param schemeId The ID of the permission scheme in which to create a new permission grant.
    * @param permissionGrant The permission grant to create.
    * @param expand Use expand to include additional information in the response. This parameter accepts a comma-separated list. Note that permissions are always included when you specify any value. Expand options include:   *  &#x60;permissions&#x60; Returns all permission grants for each permission scheme.  *  &#x60;user&#x60; Returns information about the user who is granted the permission.  *  &#x60;group&#x60; Returns information about the group that is granted the permission.  *  &#x60;projectRole&#x60; Returns information about the project role granted the permission.  *  &#x60;field&#x60; Returns information about the custom field granted the permission.  *  &#x60;all&#x60; Returns all expandable information.
    * @return PermissionGrant
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PermissionGrant createPermissionGrant(Long schemeId, PermissionGrant permissionGrant, String expand) throws IOException {
        HttpResponse response = createPermissionGrantForHttpResponse(schemeId, permissionGrant, expand);
        TypeReference<PermissionGrant> typeRef = new TypeReference<PermissionGrant>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Create permission grant
    * Creates a permission grant in a permission scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>201</b> - Returned if the scheme permission is created.
    * <p><b>400</b> - Returned if the value for expand is invalid or the same permission grant is present.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * @param schemeId The ID of the permission scheme in which to create a new permission grant.
    * @param permissionGrant The permission grant to create.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PermissionGrant
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PermissionGrant createPermissionGrant(Long schemeId, PermissionGrant permissionGrant, Map<String, Object> params) throws IOException {
        HttpResponse response = createPermissionGrantForHttpResponse(schemeId, permissionGrant, params);
        TypeReference<PermissionGrant> typeRef = new TypeReference<PermissionGrant>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse createPermissionGrantForHttpResponse(Long schemeId, PermissionGrant permissionGrant, String expand) throws IOException {
        // verify the required parameter 'schemeId' is set
        if (schemeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'schemeId' when calling createPermissionGrant");
        }// verify the required parameter 'permissionGrant' is set
        if (permissionGrant == null) {
            throw new IllegalArgumentException("Missing the required parameter 'permissionGrant' when calling createPermissionGrant");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("schemeId", schemeId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/permissionscheme/{schemeId}/permission");
        if (expand != null) {
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

        HttpContent content = apiClient.new JacksonJsonHttpContent(permissionGrant);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse createPermissionGrantForHttpResponse(Long schemeId, java.io.InputStream permissionGrant, String expand, String mediaType) throws IOException {
          // verify the required parameter 'schemeId' is set
              if (schemeId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'schemeId' when calling createPermissionGrant");
              }// verify the required parameter 'permissionGrant' is set
              if (permissionGrant == null) {
              throw new IllegalArgumentException("Missing the required parameter 'permissionGrant' when calling createPermissionGrant");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("schemeId", schemeId);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/permissionscheme/{schemeId}/permission");
              if (expand != null) {
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

              HttpContent content = permissionGrant == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, permissionGrant);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse createPermissionGrantForHttpResponse(Long schemeId, PermissionGrant permissionGrant, Map<String, Object> params) throws IOException {
        // verify the required parameter 'schemeId' is set
        if (schemeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'schemeId' when calling createPermissionGrant");
        }// verify the required parameter 'permissionGrant' is set
        if (permissionGrant == null) {
            throw new IllegalArgumentException("Missing the required parameter 'permissionGrant' when calling createPermissionGrant");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("schemeId", schemeId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/permissionscheme/{schemeId}/permission");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(permissionGrant);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


  /**
    * Create permission scheme
    * Creates a new permission scheme. You can create a permission scheme with or without defining a set of permission grants.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>201</b> - Returned if the permission scheme is created.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission or the feature is not available in the Jira plan.
    * @param requestBody The permission scheme to create.
    * @param expand Use expand to include additional information in the response. This parameter accepts a comma-separated list. Note that permissions are always included when you specify any value. Expand options include:   *  &#x60;all&#x60; Returns all expandable information.  *  &#x60;field&#x60; Returns information about the custom field granted the permission.  *  &#x60;group&#x60; Returns information about the group that is granted the permission.  *  &#x60;permissions&#x60; Returns all permission grants for each permission scheme.  *  &#x60;projectRole&#x60; Returns information about the project role granted the permission.  *  &#x60;user&#x60; Returns information about the user who is granted the permission.
    * @return PermissionScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PermissionScheme createPermissionScheme(Map<String, Object> requestBody, String expand) throws IOException {
        HttpResponse response = createPermissionSchemeForHttpResponse(requestBody, expand);
        TypeReference<PermissionScheme> typeRef = new TypeReference<PermissionScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Create permission scheme
    * Creates a new permission scheme. You can create a permission scheme with or without defining a set of permission grants.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>201</b> - Returned if the permission scheme is created.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission or the feature is not available in the Jira plan.
    * @param requestBody The permission scheme to create.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PermissionScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PermissionScheme createPermissionScheme(Map<String, Object> requestBody, Map<String, Object> params) throws IOException {
        HttpResponse response = createPermissionSchemeForHttpResponse(requestBody, params);
        TypeReference<PermissionScheme> typeRef = new TypeReference<PermissionScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse createPermissionSchemeForHttpResponse(Map<String, Object> requestBody, String expand) throws IOException {
        // verify the required parameter 'requestBody' is set
        if (requestBody == null) {
            throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling createPermissionScheme");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/permissionscheme");
        if (expand != null) {
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

        HttpContent content = apiClient.new JacksonJsonHttpContent(requestBody);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse createPermissionSchemeForHttpResponse(java.io.InputStream requestBody, String expand, String mediaType) throws IOException {
          // verify the required parameter 'requestBody' is set
              if (requestBody == null) {
              throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling createPermissionScheme");
              }
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/permissionscheme");
              if (expand != null) {
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

              HttpContent content = requestBody == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, requestBody);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse createPermissionSchemeForHttpResponse(Map<String, Object> requestBody, Map<String, Object> params) throws IOException {
        // verify the required parameter 'requestBody' is set
        if (requestBody == null) {
            throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling createPermissionScheme");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/permissionscheme");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(requestBody);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


  /**
    * Delete permission scheme
    * Deletes a permission scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the permission scheme is deleted.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the permission scheme is not found.
    * @param schemeId The ID of the permission scheme being deleted.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deletePermissionScheme(Long schemeId) throws IOException {
        deletePermissionSchemeForHttpResponse(schemeId);
    }

  /**
    * Delete permission scheme
    * Deletes a permission scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the permission scheme is deleted.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the permission scheme is not found.
    * @param schemeId The ID of the permission scheme being deleted.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deletePermissionScheme(Long schemeId, Map<String, Object> params) throws IOException {
        deletePermissionSchemeForHttpResponse(schemeId, params);
    }

    public HttpResponse deletePermissionSchemeForHttpResponse(Long schemeId) throws IOException {
        // verify the required parameter 'schemeId' is set
        if (schemeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'schemeId' when calling deletePermissionScheme");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("schemeId", schemeId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/permissionscheme/{schemeId}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }

    public HttpResponse deletePermissionSchemeForHttpResponse(Long schemeId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'schemeId' is set
        if (schemeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'schemeId' when calling deletePermissionScheme");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("schemeId", schemeId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/permissionscheme/{schemeId}");

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
    * Delete permission scheme grant
    * Deletes a permission grant from a permission scheme. See [About permission schemes and grants](#about-permission-schemes) for more details.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the permission grant is deleted.
    * <p><b>400</b> - Returned if permission grant with the provided ID is not found.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * @param schemeId The ID of the permission scheme to delete the permission grant from.
    * @param permissionId The ID of the permission grant to delete.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deletePermissionSchemeEntity(Long schemeId, Long permissionId) throws IOException {
        deletePermissionSchemeEntityForHttpResponse(schemeId, permissionId);
    }

  /**
    * Delete permission scheme grant
    * Deletes a permission grant from a permission scheme. See [About permission schemes and grants](#about-permission-schemes) for more details.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the permission grant is deleted.
    * <p><b>400</b> - Returned if permission grant with the provided ID is not found.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * @param schemeId The ID of the permission scheme to delete the permission grant from.
    * @param permissionId The ID of the permission grant to delete.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deletePermissionSchemeEntity(Long schemeId, Long permissionId, Map<String, Object> params) throws IOException {
        deletePermissionSchemeEntityForHttpResponse(schemeId, permissionId, params);
    }

    public HttpResponse deletePermissionSchemeEntityForHttpResponse(Long schemeId, Long permissionId) throws IOException {
        // verify the required parameter 'schemeId' is set
        if (schemeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'schemeId' when calling deletePermissionSchemeEntity");
        }// verify the required parameter 'permissionId' is set
        if (permissionId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'permissionId' when calling deletePermissionSchemeEntity");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("schemeId", schemeId);
        uriVariables.put("permissionId", permissionId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/permissionscheme/{schemeId}/permission/{permissionId}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }

    public HttpResponse deletePermissionSchemeEntityForHttpResponse(Long schemeId, Long permissionId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'schemeId' is set
        if (schemeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'schemeId' when calling deletePermissionSchemeEntity");
        }// verify the required parameter 'permissionId' is set
        if (permissionId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'permissionId' when calling deletePermissionSchemeEntity");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("schemeId", schemeId);
        uriVariables.put("permissionId", permissionId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/permissionscheme/{schemeId}/permission/{permissionId}");

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
    * Get all permission schemes
    * Returns all permission schemes.  ### About permission schemes and grants ###  A permission scheme is a collection of permission grants. A permission grant consists of a &#x60;holder&#x60; and a &#x60;permission&#x60;.  #### Holder object ####  The &#x60;holder&#x60; object contains information about the user or group being granted the permission. For example, the *Administer projects* permission is granted to a group named *Teams in space administrators*. In this case, the type is &#x60;\&quot;type\&quot;: \&quot;group\&quot;&#x60;, and the parameter is the group name, &#x60;\&quot;parameter\&quot;: \&quot;Teams in space administrators\&quot;&#x60;. The &#x60;holder&#x60; object is defined by the following properties:   *  &#x60;type&#x60; Identifies the user or group (see the list of types below).  *  &#x60;parameter&#x60; The value of this property depends on the &#x60;type&#x60;. For example, if the &#x60;type&#x60; is a group, then you need to specify the group name.  The following &#x60;types&#x60; are available. The expected values for the &#x60;parameter&#x60; are given in parenthesis (some &#x60;types&#x60; may not have a &#x60;parameter&#x60;):   *  &#x60;anyone&#x60; Grant for anonymous users.  *  &#x60;applicationRole&#x60; Grant for users with access to the specified application (application name). See [Update product access settings](https://confluence.atlassian.com/x/3YxjL) for more information.  *  &#x60;assignee&#x60; Grant for the user currently assigned to an issue.  *  &#x60;group&#x60; Grant for the specified group (group name).  *  &#x60;groupCustomField&#x60; Grant for a user in the group selected in the specified custom field (custom field ID).  *  &#x60;projectLead&#x60; Grant for a project lead.  *  &#x60;projectRole&#x60; Grant for the specified project role (project role ID).  *  &#x60;reporter&#x60; Grant for the user who reported the issue.  *  &#x60;sd.customer.portal.only&#x60; Jira Service Desk only. Grants customers permission to access the customer portal but not Jira. See [Customizing Jira Service Desk permissions](https://confluence.atlassian.com/x/24dKLg) for more information.  *  &#x60;user&#x60; Grant for the specified user (user ID - historically this was the userkey but that is deprecated and the account ID should be used).  *  &#x60;userCustomField&#x60; Grant for a user selected in the specified custom field (custom field ID).  #### Built-in permissions ####  The [built-in Jira permissions](https://confluence.atlassian.com/x/yodKLg) are listed below. Apps can also define custom permissions. See the [project permission](https://developer.atlassian.com/cloud/jira/platform/modules/project-permission/) and [global permission](https://developer.atlassian.com/cloud/jira/platform/modules/global-permission/) module documentation for more information.  **Project permissions**   *  &#x60;ADMINISTER_PROJECTS&#x60;  *  &#x60;BROWSE_PROJECTS&#x60;  *  &#x60;MANAGE_SPRINTS_PERMISSION&#x60; (Jira Software only)  *  &#x60;SERVICEDESK_AGENT&#x60; (Jira Service Desk only)  *  &#x60;VIEW_DEV_TOOLS&#x60; (Jira Software only)  *  &#x60;VIEW_READONLY_WORKFLOW&#x60;  **Issue permissions**   *  &#x60;ASSIGNABLE_USER&#x60;  *  &#x60;ASSIGN_ISSUES&#x60;  *  &#x60;CLOSE_ISSUES&#x60;  *  &#x60;CREATE_ISSUES&#x60;  *  &#x60;DELETE_ISSUES&#x60;  *  &#x60;EDIT_ISSUES&#x60;  *  &#x60;LINK_ISSUES&#x60;  *  &#x60;MODIFY_REPORTER&#x60;  *  &#x60;MOVE_ISSUES&#x60;  *  &#x60;RESOLVE_ISSUES&#x60;  *  &#x60;SCHEDULE_ISSUES&#x60;  *  &#x60;SET_ISSUE_SECURITY&#x60;  *  &#x60;TRANSITION_ISSUES&#x60;  **Voters and watchers permissions**   *  &#x60;MANAGE_WATCHERS&#x60;  *  &#x60;VIEW_VOTERS_AND_WATCHERS&#x60;  **Comments permissions**   *  &#x60;ADD_COMMENTS&#x60;  *  &#x60;DELETE_ALL_COMMENTS&#x60;  *  &#x60;DELETE_OWN_COMMENTS&#x60;  *  &#x60;EDIT_ALL_COMMENTS&#x60;  *  &#x60;EDIT_OWN_COMMENTS&#x60;  **Attachments permissions**   *  &#x60;CREATE_ATTACHMENTS&#x60;  *  &#x60;DELETE_ALL_ATTACHMENTS&#x60;  *  &#x60;DELETE_OWN_ATTACHMENTS&#x60;  **Time tracking permissions**   *  &#x60;DELETE_ALL_WORKLOGS&#x60;  *  &#x60;DELETE_OWN_WORKLOGS&#x60;  *  &#x60;EDIT_ALL_WORKLOGS&#x60;  *  &#x60;EDIT_OWN_WORKLOGS&#x60;  *  &#x60;WORK_ON_ISSUES&#x60;  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param expand Use expand to include additional information in the response. This parameter accepts a comma-separated list. Note that permissions are included when you specify any value. Expand options include:   *  &#x60;all&#x60; Returns all expandable information.  *  &#x60;field&#x60; Returns information about the custom field granted the permission.  *  &#x60;group&#x60; Returns information about the group that is granted the permission.  *  &#x60;permissions&#x60; Returns all permission grants for each permission scheme.  *  &#x60;projectRole&#x60; Returns information about the project role granted the permission.  *  &#x60;user&#x60; Returns information about the user who is granted the permission.
    * @return PermissionSchemes
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PermissionSchemes getAllPermissionSchemes(String expand) throws IOException {
        HttpResponse response = getAllPermissionSchemesForHttpResponse(expand);
        TypeReference<PermissionSchemes> typeRef = new TypeReference<PermissionSchemes>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get all permission schemes
    * Returns all permission schemes.  ### About permission schemes and grants ###  A permission scheme is a collection of permission grants. A permission grant consists of a &#x60;holder&#x60; and a &#x60;permission&#x60;.  #### Holder object ####  The &#x60;holder&#x60; object contains information about the user or group being granted the permission. For example, the *Administer projects* permission is granted to a group named *Teams in space administrators*. In this case, the type is &#x60;\&quot;type\&quot;: \&quot;group\&quot;&#x60;, and the parameter is the group name, &#x60;\&quot;parameter\&quot;: \&quot;Teams in space administrators\&quot;&#x60;. The &#x60;holder&#x60; object is defined by the following properties:   *  &#x60;type&#x60; Identifies the user or group (see the list of types below).  *  &#x60;parameter&#x60; The value of this property depends on the &#x60;type&#x60;. For example, if the &#x60;type&#x60; is a group, then you need to specify the group name.  The following &#x60;types&#x60; are available. The expected values for the &#x60;parameter&#x60; are given in parenthesis (some &#x60;types&#x60; may not have a &#x60;parameter&#x60;):   *  &#x60;anyone&#x60; Grant for anonymous users.  *  &#x60;applicationRole&#x60; Grant for users with access to the specified application (application name). See [Update product access settings](https://confluence.atlassian.com/x/3YxjL) for more information.  *  &#x60;assignee&#x60; Grant for the user currently assigned to an issue.  *  &#x60;group&#x60; Grant for the specified group (group name).  *  &#x60;groupCustomField&#x60; Grant for a user in the group selected in the specified custom field (custom field ID).  *  &#x60;projectLead&#x60; Grant for a project lead.  *  &#x60;projectRole&#x60; Grant for the specified project role (project role ID).  *  &#x60;reporter&#x60; Grant for the user who reported the issue.  *  &#x60;sd.customer.portal.only&#x60; Jira Service Desk only. Grants customers permission to access the customer portal but not Jira. See [Customizing Jira Service Desk permissions](https://confluence.atlassian.com/x/24dKLg) for more information.  *  &#x60;user&#x60; Grant for the specified user (user ID - historically this was the userkey but that is deprecated and the account ID should be used).  *  &#x60;userCustomField&#x60; Grant for a user selected in the specified custom field (custom field ID).  #### Built-in permissions ####  The [built-in Jira permissions](https://confluence.atlassian.com/x/yodKLg) are listed below. Apps can also define custom permissions. See the [project permission](https://developer.atlassian.com/cloud/jira/platform/modules/project-permission/) and [global permission](https://developer.atlassian.com/cloud/jira/platform/modules/global-permission/) module documentation for more information.  **Project permissions**   *  &#x60;ADMINISTER_PROJECTS&#x60;  *  &#x60;BROWSE_PROJECTS&#x60;  *  &#x60;MANAGE_SPRINTS_PERMISSION&#x60; (Jira Software only)  *  &#x60;SERVICEDESK_AGENT&#x60; (Jira Service Desk only)  *  &#x60;VIEW_DEV_TOOLS&#x60; (Jira Software only)  *  &#x60;VIEW_READONLY_WORKFLOW&#x60;  **Issue permissions**   *  &#x60;ASSIGNABLE_USER&#x60;  *  &#x60;ASSIGN_ISSUES&#x60;  *  &#x60;CLOSE_ISSUES&#x60;  *  &#x60;CREATE_ISSUES&#x60;  *  &#x60;DELETE_ISSUES&#x60;  *  &#x60;EDIT_ISSUES&#x60;  *  &#x60;LINK_ISSUES&#x60;  *  &#x60;MODIFY_REPORTER&#x60;  *  &#x60;MOVE_ISSUES&#x60;  *  &#x60;RESOLVE_ISSUES&#x60;  *  &#x60;SCHEDULE_ISSUES&#x60;  *  &#x60;SET_ISSUE_SECURITY&#x60;  *  &#x60;TRANSITION_ISSUES&#x60;  **Voters and watchers permissions**   *  &#x60;MANAGE_WATCHERS&#x60;  *  &#x60;VIEW_VOTERS_AND_WATCHERS&#x60;  **Comments permissions**   *  &#x60;ADD_COMMENTS&#x60;  *  &#x60;DELETE_ALL_COMMENTS&#x60;  *  &#x60;DELETE_OWN_COMMENTS&#x60;  *  &#x60;EDIT_ALL_COMMENTS&#x60;  *  &#x60;EDIT_OWN_COMMENTS&#x60;  **Attachments permissions**   *  &#x60;CREATE_ATTACHMENTS&#x60;  *  &#x60;DELETE_ALL_ATTACHMENTS&#x60;  *  &#x60;DELETE_OWN_ATTACHMENTS&#x60;  **Time tracking permissions**   *  &#x60;DELETE_ALL_WORKLOGS&#x60;  *  &#x60;DELETE_OWN_WORKLOGS&#x60;  *  &#x60;EDIT_ALL_WORKLOGS&#x60;  *  &#x60;EDIT_OWN_WORKLOGS&#x60;  *  &#x60;WORK_ON_ISSUES&#x60;  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PermissionSchemes
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PermissionSchemes getAllPermissionSchemes(Map<String, Object> params) throws IOException {
        HttpResponse response = getAllPermissionSchemesForHttpResponse(params);
        TypeReference<PermissionSchemes> typeRef = new TypeReference<PermissionSchemes>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getAllPermissionSchemesForHttpResponse(String expand) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/permissionscheme");
        if (expand != null) {
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

    public HttpResponse getAllPermissionSchemesForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/permissionscheme");

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
    * Get permission scheme
    * Returns a permission scheme.  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the permission scheme is not found or the user does not have the necessary permission.
    * @param schemeId The ID of the permission scheme to return.
    * @param expand Use expand to include additional information in the response. This parameter accepts a comma-separated list. Note that permissions are included when you specify any value. Expand options include:   *  &#x60;all&#x60; Returns all expandable information.  *  &#x60;field&#x60; Returns information about the custom field granted the permission.  *  &#x60;group&#x60; Returns information about the group that is granted the permission.  *  &#x60;permissions&#x60; Returns all permission grants for each permission scheme.  *  &#x60;projectRole&#x60; Returns information about the project role granted the permission.  *  &#x60;user&#x60; Returns information about the user who is granted the permission.
    * @return PermissionScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PermissionScheme getPermissionScheme(Long schemeId, String expand) throws IOException {
        HttpResponse response = getPermissionSchemeForHttpResponse(schemeId, expand);
        TypeReference<PermissionScheme> typeRef = new TypeReference<PermissionScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get permission scheme
    * Returns a permission scheme.  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the permission scheme is not found or the user does not have the necessary permission.
    * @param schemeId The ID of the permission scheme to return.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PermissionScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PermissionScheme getPermissionScheme(Long schemeId, Map<String, Object> params) throws IOException {
        HttpResponse response = getPermissionSchemeForHttpResponse(schemeId, params);
        TypeReference<PermissionScheme> typeRef = new TypeReference<PermissionScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getPermissionSchemeForHttpResponse(Long schemeId, String expand) throws IOException {
        // verify the required parameter 'schemeId' is set
        if (schemeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'schemeId' when calling getPermissionScheme");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("schemeId", schemeId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/permissionscheme/{schemeId}");
        if (expand != null) {
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

    public HttpResponse getPermissionSchemeForHttpResponse(Long schemeId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'schemeId' is set
        if (schemeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'schemeId' when calling getPermissionScheme");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("schemeId", schemeId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/permissionscheme/{schemeId}");

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
    * Get permission scheme grant
    * Returns a permission grant.  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the permission scheme or permission grant is not found or the user does not have the necessary permission.
    * @param schemeId The ID of the permission scheme.
    * @param permissionId The ID of the permission grant.
    * @param expand Use expand to include additional information in the response. This parameter accepts a comma-separated list. Note that permissions are always included when you specify any value. Expand options include:   *  &#x60;all&#x60; Returns all expandable information.  *  &#x60;field&#x60; Returns information about the custom field granted the permission.  *  &#x60;group&#x60; Returns information about the group that is granted the permission.  *  &#x60;permissions&#x60; Returns all permission grants for each permission scheme.  *  &#x60;projectRole&#x60; Returns information about the project role granted the permission.  *  &#x60;user&#x60; Returns information about the user who is granted the permission.
    * @return PermissionGrant
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PermissionGrant getPermissionSchemeGrant(Long schemeId, Long permissionId, String expand) throws IOException {
        HttpResponse response = getPermissionSchemeGrantForHttpResponse(schemeId, permissionId, expand);
        TypeReference<PermissionGrant> typeRef = new TypeReference<PermissionGrant>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get permission scheme grant
    * Returns a permission grant.  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the permission scheme or permission grant is not found or the user does not have the necessary permission.
    * @param schemeId The ID of the permission scheme.
    * @param permissionId The ID of the permission grant.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PermissionGrant
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PermissionGrant getPermissionSchemeGrant(Long schemeId, Long permissionId, Map<String, Object> params) throws IOException {
        HttpResponse response = getPermissionSchemeGrantForHttpResponse(schemeId, permissionId, params);
        TypeReference<PermissionGrant> typeRef = new TypeReference<PermissionGrant>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getPermissionSchemeGrantForHttpResponse(Long schemeId, Long permissionId, String expand) throws IOException {
        // verify the required parameter 'schemeId' is set
        if (schemeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'schemeId' when calling getPermissionSchemeGrant");
        }// verify the required parameter 'permissionId' is set
        if (permissionId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'permissionId' when calling getPermissionSchemeGrant");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("schemeId", schemeId);
        uriVariables.put("permissionId", permissionId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/permissionscheme/{schemeId}/permission/{permissionId}");
        if (expand != null) {
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

    public HttpResponse getPermissionSchemeGrantForHttpResponse(Long schemeId, Long permissionId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'schemeId' is set
        if (schemeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'schemeId' when calling getPermissionSchemeGrant");
        }// verify the required parameter 'permissionId' is set
        if (permissionId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'permissionId' when calling getPermissionSchemeGrant");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("schemeId", schemeId);
        uriVariables.put("permissionId", permissionId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/permissionscheme/{schemeId}/permission/{permissionId}");

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
    * Get permission scheme grants
    * Returns all permission grants for a permission scheme.  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the permission schemes is not found or the user does not have the necessary permission.
    * @param schemeId The ID of the permission scheme.
    * @param expand Use expand to include additional information in the response. This parameter accepts a comma-separated list. Note that permissions are always included when you specify any value. Expand options include:   *  &#x60;permissions&#x60; Returns all permission grants for each permission scheme.  *  &#x60;user&#x60; Returns information about the user who is granted the permission.  *  &#x60;group&#x60; Returns information about the group that is granted the permission.  *  &#x60;projectRole&#x60; Returns information about the project role granted the permission.  *  &#x60;field&#x60; Returns information about the custom field granted the permission.  *  &#x60;all&#x60; Returns all expandable information.
    * @return PermissionGrants
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PermissionGrants getPermissionSchemeGrants(Long schemeId, String expand) throws IOException {
        HttpResponse response = getPermissionSchemeGrantsForHttpResponse(schemeId, expand);
        TypeReference<PermissionGrants> typeRef = new TypeReference<PermissionGrants>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get permission scheme grants
    * Returns all permission grants for a permission scheme.  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the permission schemes is not found or the user does not have the necessary permission.
    * @param schemeId The ID of the permission scheme.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PermissionGrants
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PermissionGrants getPermissionSchemeGrants(Long schemeId, Map<String, Object> params) throws IOException {
        HttpResponse response = getPermissionSchemeGrantsForHttpResponse(schemeId, params);
        TypeReference<PermissionGrants> typeRef = new TypeReference<PermissionGrants>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getPermissionSchemeGrantsForHttpResponse(Long schemeId, String expand) throws IOException {
        // verify the required parameter 'schemeId' is set
        if (schemeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'schemeId' when calling getPermissionSchemeGrants");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("schemeId", schemeId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/permissionscheme/{schemeId}/permission");
        if (expand != null) {
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

    public HttpResponse getPermissionSchemeGrantsForHttpResponse(Long schemeId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'schemeId' is set
        if (schemeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'schemeId' when calling getPermissionSchemeGrants");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("schemeId", schemeId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/permissionscheme/{schemeId}/permission");

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
    * Update permission scheme
    * Updates a permission scheme. Below are some important things to note when using this resource:   *  If a permissions list is present in the request, then it is set in the permission scheme, overwriting *all existing* grants.  *  If you want to update only the name and description, then do not send a permissions list in the request.  *  Sending an empty list will remove all permission grants from the permission scheme.  If you want to add or delete a permission grant instead of updating the whole list, see [Create permission grant](#api-rest-api-3-permissionscheme-schemeId-permission-post) or [Delete permission scheme entity](#api-rest-api-3-permissionscheme-schemeId-permission-permissionId-delete).  See [About permission schemes and grants](#about-permission-schemes) for more details.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the scheme is updated.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if:   *  the user does not have the necessary permission to update permission schemes.  *  the Jira instance is Jira Core Free or Jira Software Free. Permission schemes cannot be updated on free plans.
    * <p><b>404</b> - Returned if the permission scheme is not found.
    * @param schemeId The ID of the permission scheme to update.
    * @param requestBody The requestBody parameter
    * @param expand Use expand to include additional information in the response. This parameter accepts a comma-separated list. Note that permissions are always included when you specify any value. Expand options include:   *  &#x60;all&#x60; Returns all expandable information.  *  &#x60;field&#x60; Returns information about the custom field granted the permission.  *  &#x60;group&#x60; Returns information about the group that is granted the permission.  *  &#x60;permissions&#x60; Returns all permission grants for each permission scheme.  *  &#x60;projectRole&#x60; Returns information about the project role granted the permission.  *  &#x60;user&#x60; Returns information about the user who is granted the permission.
    * @return PermissionScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PermissionScheme updatePermissionScheme(Long schemeId, Map<String, Object> requestBody, String expand) throws IOException {
        HttpResponse response = updatePermissionSchemeForHttpResponse(schemeId, requestBody, expand);
        TypeReference<PermissionScheme> typeRef = new TypeReference<PermissionScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Update permission scheme
    * Updates a permission scheme. Below are some important things to note when using this resource:   *  If a permissions list is present in the request, then it is set in the permission scheme, overwriting *all existing* grants.  *  If you want to update only the name and description, then do not send a permissions list in the request.  *  Sending an empty list will remove all permission grants from the permission scheme.  If you want to add or delete a permission grant instead of updating the whole list, see [Create permission grant](#api-rest-api-3-permissionscheme-schemeId-permission-post) or [Delete permission scheme entity](#api-rest-api-3-permissionscheme-schemeId-permission-permissionId-delete).  See [About permission schemes and grants](#about-permission-schemes) for more details.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the scheme is updated.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if:   *  the user does not have the necessary permission to update permission schemes.  *  the Jira instance is Jira Core Free or Jira Software Free. Permission schemes cannot be updated on free plans.
    * <p><b>404</b> - Returned if the permission scheme is not found.
    * @param schemeId The ID of the permission scheme to update.
    * @param requestBody The requestBody parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PermissionScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PermissionScheme updatePermissionScheme(Long schemeId, Map<String, Object> requestBody, Map<String, Object> params) throws IOException {
        HttpResponse response = updatePermissionSchemeForHttpResponse(schemeId, requestBody, params);
        TypeReference<PermissionScheme> typeRef = new TypeReference<PermissionScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse updatePermissionSchemeForHttpResponse(Long schemeId, Map<String, Object> requestBody, String expand) throws IOException {
        // verify the required parameter 'schemeId' is set
        if (schemeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'schemeId' when calling updatePermissionScheme");
        }// verify the required parameter 'requestBody' is set
        if (requestBody == null) {
            throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling updatePermissionScheme");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("schemeId", schemeId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/permissionscheme/{schemeId}");
        if (expand != null) {
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

        HttpContent content = apiClient.new JacksonJsonHttpContent(requestBody);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse updatePermissionSchemeForHttpResponse(Long schemeId, java.io.InputStream requestBody, String expand, String mediaType) throws IOException {
          // verify the required parameter 'schemeId' is set
              if (schemeId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'schemeId' when calling updatePermissionScheme");
              }// verify the required parameter 'requestBody' is set
              if (requestBody == null) {
              throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling updatePermissionScheme");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("schemeId", schemeId);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/permissionscheme/{schemeId}");
              if (expand != null) {
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

              HttpContent content = requestBody == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, requestBody);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse updatePermissionSchemeForHttpResponse(Long schemeId, Map<String, Object> requestBody, Map<String, Object> params) throws IOException {
        // verify the required parameter 'schemeId' is set
        if (schemeId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'schemeId' when calling updatePermissionScheme");
        }// verify the required parameter 'requestBody' is set
        if (requestBody == null) {
            throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling updatePermissionScheme");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("schemeId", schemeId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/permissionscheme/{schemeId}");

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
