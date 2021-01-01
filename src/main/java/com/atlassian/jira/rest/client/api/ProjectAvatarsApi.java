package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.Avatar;
import com.atlassian.jira.rest.client.model.ProjectAvatars;

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
public class ProjectAvatarsApi {
    private ApiClient apiClient;

    public ProjectAvatarsApi() {
        this(new ApiClient());
    }

    public ProjectAvatarsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Load project avatar
    * Loads an avatar for a project.  Specify the avatar&#39;s local file location in the body of the request. Also, include the following headers:   *  &#x60;X-Atlassian-Token: no-check&#x60; To prevent XSRF protection blocking the request, for more information see [Special Headers](#special-request-headers).  *  &#x60;Content-Type: image/image type&#x60; Valid image types are JPEG, GIF, or PNG.  For example:   &#x60;curl --request POST &#x60;  &#x60;--user email@example.com:&lt;api_token&gt; &#x60;  &#x60;--header &#39;X-Atlassian-Token: no-check&#39; &#x60;  &#x60;--header &#39;Content-Type: image/&lt; image_type&gt;&#39; &#x60;  &#x60;--data-binary \&quot;&lt;@/path/to/file/with/your/avatar&gt;\&quot; &#x60;  &#x60;--url &#39;https://your-domain.atlassian.net/rest/api/3/project/{projectIdOrKey}/avatar2&#39;&#x60;  The avatar is cropped to a square. If no crop parameters are specified, the square originates at the top left of the image. The length of the square&#39;s sides is set to the smaller of the height or width of the image.  The cropped image is then used to create avatars of 16x16, 24x24, 32x32, and 48x48 in size.  After creating the avatar use [Set project avatar](#api-rest-api-3-project-projectIdOrKey-avatar-put) to set it as the project&#39;s displayed avatar.  **[Permissions](#permissions) required:** *Administer projects* [project permission](https://confluence.atlassian.com/x/yodKLg).
    * <p><b>201</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  an image isn&#39;t included in the request.  *  the image type is unsupported.  *  the crop parameters extend the crop area beyond the edge of the image.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have permission to administer the project or an anonymous call is made to the operation.
    * <p><b>404</b> - Returned if the project is not found or the user does not have permission to view the project.
    * @param projectIdOrKey The ID or (case-sensitive) key of the project.
    * @param body The body parameter
    * @param x The X coordinate of the top-left corner of the crop region.
    * @param y The Y coordinate of the top-left corner of the crop region.
    * @param size The length of each side of the crop region.
    * @return Avatar
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Avatar createProjectAvatar(String projectIdOrKey, Object body, Integer x, Integer y, Integer size) throws IOException {
        HttpResponse response = createProjectAvatarForHttpResponse(projectIdOrKey, body, x, y, size);
        TypeReference<Avatar> typeRef = new TypeReference<Avatar>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Load project avatar
    * Loads an avatar for a project.  Specify the avatar&#39;s local file location in the body of the request. Also, include the following headers:   *  &#x60;X-Atlassian-Token: no-check&#x60; To prevent XSRF protection blocking the request, for more information see [Special Headers](#special-request-headers).  *  &#x60;Content-Type: image/image type&#x60; Valid image types are JPEG, GIF, or PNG.  For example:   &#x60;curl --request POST &#x60;  &#x60;--user email@example.com:&lt;api_token&gt; &#x60;  &#x60;--header &#39;X-Atlassian-Token: no-check&#39; &#x60;  &#x60;--header &#39;Content-Type: image/&lt; image_type&gt;&#39; &#x60;  &#x60;--data-binary \&quot;&lt;@/path/to/file/with/your/avatar&gt;\&quot; &#x60;  &#x60;--url &#39;https://your-domain.atlassian.net/rest/api/3/project/{projectIdOrKey}/avatar2&#39;&#x60;  The avatar is cropped to a square. If no crop parameters are specified, the square originates at the top left of the image. The length of the square&#39;s sides is set to the smaller of the height or width of the image.  The cropped image is then used to create avatars of 16x16, 24x24, 32x32, and 48x48 in size.  After creating the avatar use [Set project avatar](#api-rest-api-3-project-projectIdOrKey-avatar-put) to set it as the project&#39;s displayed avatar.  **[Permissions](#permissions) required:** *Administer projects* [project permission](https://confluence.atlassian.com/x/yodKLg).
    * <p><b>201</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  an image isn&#39;t included in the request.  *  the image type is unsupported.  *  the crop parameters extend the crop area beyond the edge of the image.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have permission to administer the project or an anonymous call is made to the operation.
    * <p><b>404</b> - Returned if the project is not found or the user does not have permission to view the project.
    * @param projectIdOrKey The ID or (case-sensitive) key of the project.
    * @param body The body parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Avatar
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Avatar createProjectAvatar(String projectIdOrKey, Object body, Map<String, Object> params) throws IOException {
        HttpResponse response = createProjectAvatarForHttpResponse(projectIdOrKey, body, params);
        TypeReference<Avatar> typeRef = new TypeReference<Avatar>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse createProjectAvatarForHttpResponse(String projectIdOrKey, Object body, Integer x, Integer y, Integer size) throws IOException {
        // verify the required parameter 'projectIdOrKey' is set
        if (projectIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectIdOrKey' when calling createProjectAvatar");
        }// verify the required parameter 'body' is set
        if (body == null) {
            throw new IllegalArgumentException("Missing the required parameter 'body' when calling createProjectAvatar");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectIdOrKey", projectIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectIdOrKey}/avatar2");
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

      public HttpResponse createProjectAvatarForHttpResponse(String projectIdOrKey, java.io.InputStream body, Integer x, Integer y, Integer size, String mediaType) throws IOException {
          // verify the required parameter 'projectIdOrKey' is set
              if (projectIdOrKey == null) {
              throw new IllegalArgumentException("Missing the required parameter 'projectIdOrKey' when calling createProjectAvatar");
              }// verify the required parameter 'body' is set
              if (body == null) {
              throw new IllegalArgumentException("Missing the required parameter 'body' when calling createProjectAvatar");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("projectIdOrKey", projectIdOrKey);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectIdOrKey}/avatar2");
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

    public HttpResponse createProjectAvatarForHttpResponse(String projectIdOrKey, Object body, Map<String, Object> params) throws IOException {
        // verify the required parameter 'projectIdOrKey' is set
        if (projectIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectIdOrKey' when calling createProjectAvatar");
        }// verify the required parameter 'body' is set
        if (body == null) {
            throw new IllegalArgumentException("Missing the required parameter 'body' when calling createProjectAvatar");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectIdOrKey", projectIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectIdOrKey}/avatar2");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(body);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


  /**
    * Delete project avatar
    * Deletes a custom avatar from a project. Note that system avatars cannot be deleted.  **[Permissions](#permissions) required:** *Administer projects* [project permission](https://confluence.atlassian.com/x/yodKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the avatar is a system avatar or the user does not have permission to administer the project.
    * <p><b>404</b> - Returned if the project or avatar is not found or the user does not have permission to view the project.
    * @param projectIdOrKey The project ID or (case-sensitive) key.
    * @param id The ID of the avatar.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteProjectAvatar(String projectIdOrKey, Long id) throws IOException {
        deleteProjectAvatarForHttpResponse(projectIdOrKey, id);
    }

  /**
    * Delete project avatar
    * Deletes a custom avatar from a project. Note that system avatars cannot be deleted.  **[Permissions](#permissions) required:** *Administer projects* [project permission](https://confluence.atlassian.com/x/yodKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the avatar is a system avatar or the user does not have permission to administer the project.
    * <p><b>404</b> - Returned if the project or avatar is not found or the user does not have permission to view the project.
    * @param projectIdOrKey The project ID or (case-sensitive) key.
    * @param id The ID of the avatar.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteProjectAvatar(String projectIdOrKey, Long id, Map<String, Object> params) throws IOException {
        deleteProjectAvatarForHttpResponse(projectIdOrKey, id, params);
    }

    public HttpResponse deleteProjectAvatarForHttpResponse(String projectIdOrKey, Long id) throws IOException {
        // verify the required parameter 'projectIdOrKey' is set
        if (projectIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectIdOrKey' when calling deleteProjectAvatar");
        }// verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling deleteProjectAvatar");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectIdOrKey", projectIdOrKey);
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectIdOrKey}/avatar/{id}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }

    public HttpResponse deleteProjectAvatarForHttpResponse(String projectIdOrKey, Long id, Map<String, Object> params) throws IOException {
        // verify the required parameter 'projectIdOrKey' is set
        if (projectIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectIdOrKey' when calling deleteProjectAvatar");
        }// verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling deleteProjectAvatar");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectIdOrKey", projectIdOrKey);
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectIdOrKey}/avatar/{id}");

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
    * Get all project avatars
    * Returns all project avatars, grouped by system and custom avatars.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project.
    * <p><b>200</b> - Returned if request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the project is not found or the user does not have permission to view the project.
    * @param projectIdOrKey The ID or (case-sensitive) key of the project.
    * @return ProjectAvatars
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ProjectAvatars getAllProjectAvatars(String projectIdOrKey) throws IOException {
        HttpResponse response = getAllProjectAvatarsForHttpResponse(projectIdOrKey);
        TypeReference<ProjectAvatars> typeRef = new TypeReference<ProjectAvatars>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get all project avatars
    * Returns all project avatars, grouped by system and custom avatars.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project.
    * <p><b>200</b> - Returned if request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the project is not found or the user does not have permission to view the project.
    * @param projectIdOrKey The ID or (case-sensitive) key of the project.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return ProjectAvatars
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ProjectAvatars getAllProjectAvatars(String projectIdOrKey, Map<String, Object> params) throws IOException {
        HttpResponse response = getAllProjectAvatarsForHttpResponse(projectIdOrKey, params);
        TypeReference<ProjectAvatars> typeRef = new TypeReference<ProjectAvatars>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getAllProjectAvatarsForHttpResponse(String projectIdOrKey) throws IOException {
        // verify the required parameter 'projectIdOrKey' is set
        if (projectIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectIdOrKey' when calling getAllProjectAvatars");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectIdOrKey", projectIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectIdOrKey}/avatars");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getAllProjectAvatarsForHttpResponse(String projectIdOrKey, Map<String, Object> params) throws IOException {
        // verify the required parameter 'projectIdOrKey' is set
        if (projectIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectIdOrKey' when calling getAllProjectAvatars");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectIdOrKey", projectIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectIdOrKey}/avatars");

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
    * Set project avatar
    * Sets the avatar displayed for a project.  Use [Load project avatar](#api-rest-api-3-project-projectIdOrKey-avatar2-post) to store avatars against the project, before using this operation to set the displayed avatar.  **[Permissions](#permissions) required:** *Administer projects* [project permission](https://confluence.atlassian.com/x/yodKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have permission to administer the project.
    * <p><b>404</b> - Returned if the project or avatar is not found or the user does not have permission to view the project.
    * @param projectIdOrKey The ID or (case-sensitive) key of the project.
    * @param avatar The avatar parameter
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object updateProjectAvatar(String projectIdOrKey, Avatar avatar) throws IOException {
        HttpResponse response = updateProjectAvatarForHttpResponse(projectIdOrKey, avatar);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Set project avatar
    * Sets the avatar displayed for a project.  Use [Load project avatar](#api-rest-api-3-project-projectIdOrKey-avatar2-post) to store avatars against the project, before using this operation to set the displayed avatar.  **[Permissions](#permissions) required:** *Administer projects* [project permission](https://confluence.atlassian.com/x/yodKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have permission to administer the project.
    * <p><b>404</b> - Returned if the project or avatar is not found or the user does not have permission to view the project.
    * @param projectIdOrKey The ID or (case-sensitive) key of the project.
    * @param avatar The avatar parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object updateProjectAvatar(String projectIdOrKey, Avatar avatar, Map<String, Object> params) throws IOException {
        HttpResponse response = updateProjectAvatarForHttpResponse(projectIdOrKey, avatar, params);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse updateProjectAvatarForHttpResponse(String projectIdOrKey, Avatar avatar) throws IOException {
        // verify the required parameter 'projectIdOrKey' is set
        if (projectIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectIdOrKey' when calling updateProjectAvatar");
        }// verify the required parameter 'avatar' is set
        if (avatar == null) {
            throw new IllegalArgumentException("Missing the required parameter 'avatar' when calling updateProjectAvatar");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectIdOrKey", projectIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectIdOrKey}/avatar");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(avatar);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse updateProjectAvatarForHttpResponse(String projectIdOrKey, java.io.InputStream avatar, String mediaType) throws IOException {
          // verify the required parameter 'projectIdOrKey' is set
              if (projectIdOrKey == null) {
              throw new IllegalArgumentException("Missing the required parameter 'projectIdOrKey' when calling updateProjectAvatar");
              }// verify the required parameter 'avatar' is set
              if (avatar == null) {
              throw new IllegalArgumentException("Missing the required parameter 'avatar' when calling updateProjectAvatar");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("projectIdOrKey", projectIdOrKey);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectIdOrKey}/avatar");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = avatar == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, avatar);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse updateProjectAvatarForHttpResponse(String projectIdOrKey, Avatar avatar, Map<String, Object> params) throws IOException {
        // verify the required parameter 'projectIdOrKey' is set
        if (projectIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectIdOrKey' when calling updateProjectAvatar");
        }// verify the required parameter 'avatar' is set
        if (avatar == null) {
            throw new IllegalArgumentException("Missing the required parameter 'avatar' when calling updateProjectAvatar");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectIdOrKey", projectIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectIdOrKey}/avatar");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(avatar);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }


}
