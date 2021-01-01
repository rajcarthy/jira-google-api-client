package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.Avatar;
import com.atlassian.jira.rest.client.model.Avatars;
import com.atlassian.jira.rest.client.model.SystemAvatars;

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
public class AvatarsApi {
    private ApiClient apiClient;

    public AvatarsApi() {
        this(new ApiClient());
    }

    public AvatarsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Delete avatar
    * Deletes an avatar from a project or issue type.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>403</b> - Returned if the user does not have permission to delete the avatar, the avatar is not deletable.
    * <p><b>404</b> - Returned if the avatar type, associated item ID, or avatar ID is invalid.
    * @param type The avatar type.
    * @param owningObjectId The ID of the item the avatar is associated with.
    * @param id The ID of the avatar.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteAvatar(String type, String owningObjectId, Long id) throws IOException {
        deleteAvatarForHttpResponse(type, owningObjectId, id);
    }

  /**
    * Delete avatar
    * Deletes an avatar from a project or issue type.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>403</b> - Returned if the user does not have permission to delete the avatar, the avatar is not deletable.
    * <p><b>404</b> - Returned if the avatar type, associated item ID, or avatar ID is invalid.
    * @param type The avatar type.
    * @param owningObjectId The ID of the item the avatar is associated with.
    * @param id The ID of the avatar.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteAvatar(String type, String owningObjectId, Long id, Map<String, Object> params) throws IOException {
        deleteAvatarForHttpResponse(type, owningObjectId, id, params);
    }

    public HttpResponse deleteAvatarForHttpResponse(String type, String owningObjectId, Long id) throws IOException {
        // verify the required parameter 'type' is set
        if (type == null) {
            throw new IllegalArgumentException("Missing the required parameter 'type' when calling deleteAvatar");
        }// verify the required parameter 'owningObjectId' is set
        if (owningObjectId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'owningObjectId' when calling deleteAvatar");
        }// verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling deleteAvatar");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("type", type);
        uriVariables.put("owningObjectId", owningObjectId);
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/universal_avatar/type/{type}/owner/{owningObjectId}/avatar/{id}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }

    public HttpResponse deleteAvatarForHttpResponse(String type, String owningObjectId, Long id, Map<String, Object> params) throws IOException {
        // verify the required parameter 'type' is set
        if (type == null) {
            throw new IllegalArgumentException("Missing the required parameter 'type' when calling deleteAvatar");
        }// verify the required parameter 'owningObjectId' is set
        if (owningObjectId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'owningObjectId' when calling deleteAvatar");
        }// verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling deleteAvatar");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("type", type);
        uriVariables.put("owningObjectId", owningObjectId);
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/universal_avatar/type/{type}/owner/{owningObjectId}/avatar/{id}");

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
    * Get system avatars by type
    * Returns a list of system avatar details by owner type, where the owner types are issue type, project, or user.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>500</b> - Returned if an error occurs while retrieving the list of avatars.
    * @param type The avatar type.
    * @return SystemAvatars
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public SystemAvatars getAllSystemAvatars(String type) throws IOException {
        HttpResponse response = getAllSystemAvatarsForHttpResponse(type);
        TypeReference<SystemAvatars> typeRef = new TypeReference<SystemAvatars>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get system avatars by type
    * Returns a list of system avatar details by owner type, where the owner types are issue type, project, or user.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>500</b> - Returned if an error occurs while retrieving the list of avatars.
    * @param type The avatar type.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return SystemAvatars
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public SystemAvatars getAllSystemAvatars(String type, Map<String, Object> params) throws IOException {
        HttpResponse response = getAllSystemAvatarsForHttpResponse(type, params);
        TypeReference<SystemAvatars> typeRef = new TypeReference<SystemAvatars>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getAllSystemAvatarsForHttpResponse(String type) throws IOException {
        // verify the required parameter 'type' is set
        if (type == null) {
            throw new IllegalArgumentException("Missing the required parameter 'type' when calling getAllSystemAvatars");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("type", type);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/avatar/{type}/system");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getAllSystemAvatarsForHttpResponse(String type, Map<String, Object> params) throws IOException {
        // verify the required parameter 'type' is set
        if (type == null) {
            throw new IllegalArgumentException("Missing the required parameter 'type' when calling getAllSystemAvatars");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("type", type);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/avatar/{type}/system");

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
    * Get avatars
    * Returns the system and custom avatars for a project or issue type.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the avatar type is invalid, the associated item ID is missing, or the item is not found.
    * @param type The avatar type.
    * @param entityId The ID of the item the avatar is associated with.
    * @return Avatars
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Avatars getAvatars(String type, String entityId) throws IOException {
        HttpResponse response = getAvatarsForHttpResponse(type, entityId);
        TypeReference<Avatars> typeRef = new TypeReference<Avatars>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get avatars
    * Returns the system and custom avatars for a project or issue type.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the avatar type is invalid, the associated item ID is missing, or the item is not found.
    * @param type The avatar type.
    * @param entityId The ID of the item the avatar is associated with.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Avatars
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Avatars getAvatars(String type, String entityId, Map<String, Object> params) throws IOException {
        HttpResponse response = getAvatarsForHttpResponse(type, entityId, params);
        TypeReference<Avatars> typeRef = new TypeReference<Avatars>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getAvatarsForHttpResponse(String type, String entityId) throws IOException {
        // verify the required parameter 'type' is set
        if (type == null) {
            throw new IllegalArgumentException("Missing the required parameter 'type' when calling getAvatars");
        }// verify the required parameter 'entityId' is set
        if (entityId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'entityId' when calling getAvatars");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("type", type);
        uriVariables.put("entityId", entityId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/universal_avatar/type/{type}/owner/{entityId}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getAvatarsForHttpResponse(String type, String entityId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'type' is set
        if (type == null) {
            throw new IllegalArgumentException("Missing the required parameter 'type' when calling getAvatars");
        }// verify the required parameter 'entityId' is set
        if (entityId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'entityId' when calling getAvatars");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("type", type);
        uriVariables.put("entityId", entityId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/universal_avatar/type/{type}/owner/{entityId}");

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
    * Load avatar
    * Loads a custom avatar for a project or issue type.  Specify the avatar&#39;s local file location in the body of the request. Also, include the following headers:   *  &#x60;X-Atlassian-Token: no-check&#x60; To prevent XSRF protection blocking the request, for more information see [Special Headers](#special-request-headers).  *  &#x60;Content-Type: image/image type&#x60; Valid image types are JPEG, GIF, or PNG.  For example:   &#x60;curl --request POST &#x60;  &#x60;--user email@example.com:&lt;api_token&gt; &#x60;  &#x60;--header &#39;X-Atlassian-Token: no-check&#39; &#x60;  &#x60;--header &#39;Content-Type: image/&lt; image_type&gt;&#39; &#x60;  &#x60;--data-binary \&quot;&lt;@/path/to/file/with/your/avatar&gt;\&quot; &#x60;  &#x60;--url &#39;https://your-domain.atlassian.net/rest/api/3/universal_avatar/type/{type}/owner/{entityId}&#39;&#x60;  The avatar is cropped to a square. If no crop parameters are specified, the square originates at the top left of the image. The length of the square&#39;s sides is set to the smaller of the height or width of the image.  The cropped image is then used to create avatars of 16x16, 24x24, 32x32, and 48x48 in size.  After creating the avatar use:   *  [Update issue type](#api-rest-api-3-issuetype-id-put) to set it as the issue type&#39;s displayed avatar.  *  [Set project avatar](#api-rest-api-3-project-projectIdOrKey-avatar-put) to set it as the project&#39;s displayed avatar.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>201</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  an image isn&#39;t included in the request.  *  the image type is unsupported.  *  the crop parameters extend the crop area beyond the edge of the image.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permissions.
    * <p><b>404</b> - Returned if the avatar type is invalid, the associated item ID is missing, or the item is not found.
    * @param type The avatar type.
    * @param entityId The ID of the item the avatar is associated with.
    * @param size The length of each side of the crop region.
    * @param body The body parameter
    * @param x The X coordinate of the top-left corner of the crop region.
    * @param y The Y coordinate of the top-left corner of the crop region.
    * @return Avatar
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Avatar storeAvatar(String type, String entityId, Integer size, Object body, Integer x, Integer y) throws IOException {
        HttpResponse response = storeAvatarForHttpResponse(type, entityId, size, body, x, y);
        TypeReference<Avatar> typeRef = new TypeReference<Avatar>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Load avatar
    * Loads a custom avatar for a project or issue type.  Specify the avatar&#39;s local file location in the body of the request. Also, include the following headers:   *  &#x60;X-Atlassian-Token: no-check&#x60; To prevent XSRF protection blocking the request, for more information see [Special Headers](#special-request-headers).  *  &#x60;Content-Type: image/image type&#x60; Valid image types are JPEG, GIF, or PNG.  For example:   &#x60;curl --request POST &#x60;  &#x60;--user email@example.com:&lt;api_token&gt; &#x60;  &#x60;--header &#39;X-Atlassian-Token: no-check&#39; &#x60;  &#x60;--header &#39;Content-Type: image/&lt; image_type&gt;&#39; &#x60;  &#x60;--data-binary \&quot;&lt;@/path/to/file/with/your/avatar&gt;\&quot; &#x60;  &#x60;--url &#39;https://your-domain.atlassian.net/rest/api/3/universal_avatar/type/{type}/owner/{entityId}&#39;&#x60;  The avatar is cropped to a square. If no crop parameters are specified, the square originates at the top left of the image. The length of the square&#39;s sides is set to the smaller of the height or width of the image.  The cropped image is then used to create avatars of 16x16, 24x24, 32x32, and 48x48 in size.  After creating the avatar use:   *  [Update issue type](#api-rest-api-3-issuetype-id-put) to set it as the issue type&#39;s displayed avatar.  *  [Set project avatar](#api-rest-api-3-project-projectIdOrKey-avatar-put) to set it as the project&#39;s displayed avatar.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>201</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  an image isn&#39;t included in the request.  *  the image type is unsupported.  *  the crop parameters extend the crop area beyond the edge of the image.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permissions.
    * <p><b>404</b> - Returned if the avatar type is invalid, the associated item ID is missing, or the item is not found.
    * @param type The avatar type.
    * @param entityId The ID of the item the avatar is associated with.
    * @param size The length of each side of the crop region.
    * @param body The body parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Avatar
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Avatar storeAvatar(String type, String entityId, Integer size, Object body, Map<String, Object> params) throws IOException {
        HttpResponse response = storeAvatarForHttpResponse(type, entityId, size, body, params);
        TypeReference<Avatar> typeRef = new TypeReference<Avatar>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse storeAvatarForHttpResponse(String type, String entityId, Integer size, Object body, Integer x, Integer y) throws IOException {
        // verify the required parameter 'type' is set
        if (type == null) {
            throw new IllegalArgumentException("Missing the required parameter 'type' when calling storeAvatar");
        }// verify the required parameter 'entityId' is set
        if (entityId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'entityId' when calling storeAvatar");
        }// verify the required parameter 'size' is set
        if (size == null) {
            throw new IllegalArgumentException("Missing the required parameter 'size' when calling storeAvatar");
        }// verify the required parameter 'body' is set
        if (body == null) {
            throw new IllegalArgumentException("Missing the required parameter 'body' when calling storeAvatar");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("type", type);
        uriVariables.put("entityId", entityId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/universal_avatar/type/{type}/owner/{entityId}");
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

      public HttpResponse storeAvatarForHttpResponse(String type, String entityId, Integer size, java.io.InputStream body, Integer x, Integer y, String mediaType) throws IOException {
          // verify the required parameter 'type' is set
              if (type == null) {
              throw new IllegalArgumentException("Missing the required parameter 'type' when calling storeAvatar");
              }// verify the required parameter 'entityId' is set
              if (entityId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'entityId' when calling storeAvatar");
              }// verify the required parameter 'size' is set
              if (size == null) {
              throw new IllegalArgumentException("Missing the required parameter 'size' when calling storeAvatar");
              }// verify the required parameter 'body' is set
              if (body == null) {
              throw new IllegalArgumentException("Missing the required parameter 'body' when calling storeAvatar");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("type", type);
                      uriVariables.put("entityId", entityId);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/universal_avatar/type/{type}/owner/{entityId}");
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

    public HttpResponse storeAvatarForHttpResponse(String type, String entityId, Integer size, Object body, Map<String, Object> params) throws IOException {
        // verify the required parameter 'type' is set
        if (type == null) {
            throw new IllegalArgumentException("Missing the required parameter 'type' when calling storeAvatar");
        }// verify the required parameter 'entityId' is set
        if (entityId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'entityId' when calling storeAvatar");
        }// verify the required parameter 'size' is set
        if (size == null) {
            throw new IllegalArgumentException("Missing the required parameter 'size' when calling storeAvatar");
        }// verify the required parameter 'body' is set
        if (body == null) {
            throw new IllegalArgumentException("Missing the required parameter 'body' when calling storeAvatar");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("type", type);
        uriVariables.put("entityId", entityId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/universal_avatar/type/{type}/owner/{entityId}");

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


}
