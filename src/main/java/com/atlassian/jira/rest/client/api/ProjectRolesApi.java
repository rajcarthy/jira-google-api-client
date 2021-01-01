package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.CreateUpdateRoleRequestBean;
import com.atlassian.jira.rest.client.model.ProjectRole;
import java.net.URI;

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
public class ProjectRolesApi {
    private ApiClient apiClient;

    public ProjectRolesApi() {
        this(new ApiClient());
    }

    public ProjectRolesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Create project role
    * Creates a new project role with no [default actors](#api-rest-api-3-resolution-get). You can use the [Add default actors to project role](#api-rest-api-3-role-id-actors-post) operation to add default actors to the project role after creating it.  *Note that although a new project role is available to all projects upon creation, any default actors that are associated with the project role are not added to projects that existed prior to the role being created.*&lt;  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid. The &#x60;name&#x60; cannot be empty or start or end with whitespace.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have administrative permissions.
    * <p><b>409</b> - Returned if a project role with the provided name already exists.
    * @param createUpdateRoleRequestBean The createUpdateRoleRequestBean parameter
    * @return ProjectRole
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ProjectRole createProjectRole(CreateUpdateRoleRequestBean createUpdateRoleRequestBean) throws IOException {
        HttpResponse response = createProjectRoleForHttpResponse(createUpdateRoleRequestBean);
        TypeReference<ProjectRole> typeRef = new TypeReference<ProjectRole>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Create project role
    * Creates a new project role with no [default actors](#api-rest-api-3-resolution-get). You can use the [Add default actors to project role](#api-rest-api-3-role-id-actors-post) operation to add default actors to the project role after creating it.  *Note that although a new project role is available to all projects upon creation, any default actors that are associated with the project role are not added to projects that existed prior to the role being created.*&lt;  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid. The &#x60;name&#x60; cannot be empty or start or end with whitespace.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have administrative permissions.
    * <p><b>409</b> - Returned if a project role with the provided name already exists.
    * @param createUpdateRoleRequestBean The createUpdateRoleRequestBean parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return ProjectRole
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ProjectRole createProjectRole(CreateUpdateRoleRequestBean createUpdateRoleRequestBean, Map<String, Object> params) throws IOException {
        HttpResponse response = createProjectRoleForHttpResponse(createUpdateRoleRequestBean, params);
        TypeReference<ProjectRole> typeRef = new TypeReference<ProjectRole>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse createProjectRoleForHttpResponse(CreateUpdateRoleRequestBean createUpdateRoleRequestBean) throws IOException {
        // verify the required parameter 'createUpdateRoleRequestBean' is set
        if (createUpdateRoleRequestBean == null) {
            throw new IllegalArgumentException("Missing the required parameter 'createUpdateRoleRequestBean' when calling createProjectRole");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/role");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(createUpdateRoleRequestBean);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse createProjectRoleForHttpResponse(java.io.InputStream createUpdateRoleRequestBean, String mediaType) throws IOException {
          // verify the required parameter 'createUpdateRoleRequestBean' is set
              if (createUpdateRoleRequestBean == null) {
              throw new IllegalArgumentException("Missing the required parameter 'createUpdateRoleRequestBean' when calling createProjectRole");
              }
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/role");

              String localVarUrl = uriBuilder.build().toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = createUpdateRoleRequestBean == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, createUpdateRoleRequestBean);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse createProjectRoleForHttpResponse(CreateUpdateRoleRequestBean createUpdateRoleRequestBean, Map<String, Object> params) throws IOException {
        // verify the required parameter 'createUpdateRoleRequestBean' is set
        if (createUpdateRoleRequestBean == null) {
            throw new IllegalArgumentException("Missing the required parameter 'createUpdateRoleRequestBean' when calling createProjectRole");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/role");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(createUpdateRoleRequestBean);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


  /**
    * Delete project role
    * Deletes a project role. You must specify a replacement project role if you wish to delete a project role that is in use.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid or if the replacement project role is not found.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have administrative permissions.
    * <p><b>404</b> - Returned if the project role being deleted is not found.
    * <p><b>409</b> - Returned if the project role being deleted is in use and a replacement project role is not specified in the request.
    * @param id The ID of the project role to delete. Use [Get all project roles](#api-rest-api-3-role-get) to get a list of project role IDs.
    * @param swap The ID of the project role that will replace the one being deleted.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteProjectRole(Long id, Long swap) throws IOException {
        deleteProjectRoleForHttpResponse(id, swap);
    }

  /**
    * Delete project role
    * Deletes a project role. You must specify a replacement project role if you wish to delete a project role that is in use.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid or if the replacement project role is not found.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have administrative permissions.
    * <p><b>404</b> - Returned if the project role being deleted is not found.
    * <p><b>409</b> - Returned if the project role being deleted is in use and a replacement project role is not specified in the request.
    * @param id The ID of the project role to delete. Use [Get all project roles](#api-rest-api-3-role-get) to get a list of project role IDs.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteProjectRole(Long id, Map<String, Object> params) throws IOException {
        deleteProjectRoleForHttpResponse(id, params);
    }

    public HttpResponse deleteProjectRoleForHttpResponse(Long id, Long swap) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling deleteProjectRole");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/role/{id}");
        if (swap != null) {
            String key = "swap";
            Object value = swap;
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

    public HttpResponse deleteProjectRoleForHttpResponse(Long id, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling deleteProjectRole");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/role/{id}");

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
    * Fully update project role
    * Updates the project role&#39;s name and description. You must include both a name and a description in the request.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid. The &#x60;name&#x60; cannot be empty or start or end with whitespace.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have administrative permissions.
    * <p><b>404</b> - Returned if the project role is not found.
    * @param id The ID of the project role. Use [Get all project roles](#api-rest-api-3-role-get) to get a list of project role IDs.
    * @param createUpdateRoleRequestBean The createUpdateRoleRequestBean parameter
    * @return ProjectRole
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ProjectRole fullyUpdateProjectRole(Long id, CreateUpdateRoleRequestBean createUpdateRoleRequestBean) throws IOException {
        HttpResponse response = fullyUpdateProjectRoleForHttpResponse(id, createUpdateRoleRequestBean);
        TypeReference<ProjectRole> typeRef = new TypeReference<ProjectRole>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Fully update project role
    * Updates the project role&#39;s name and description. You must include both a name and a description in the request.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid. The &#x60;name&#x60; cannot be empty or start or end with whitespace.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have administrative permissions.
    * <p><b>404</b> - Returned if the project role is not found.
    * @param id The ID of the project role. Use [Get all project roles](#api-rest-api-3-role-get) to get a list of project role IDs.
    * @param createUpdateRoleRequestBean The createUpdateRoleRequestBean parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return ProjectRole
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ProjectRole fullyUpdateProjectRole(Long id, CreateUpdateRoleRequestBean createUpdateRoleRequestBean, Map<String, Object> params) throws IOException {
        HttpResponse response = fullyUpdateProjectRoleForHttpResponse(id, createUpdateRoleRequestBean, params);
        TypeReference<ProjectRole> typeRef = new TypeReference<ProjectRole>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse fullyUpdateProjectRoleForHttpResponse(Long id, CreateUpdateRoleRequestBean createUpdateRoleRequestBean) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling fullyUpdateProjectRole");
        }// verify the required parameter 'createUpdateRoleRequestBean' is set
        if (createUpdateRoleRequestBean == null) {
            throw new IllegalArgumentException("Missing the required parameter 'createUpdateRoleRequestBean' when calling fullyUpdateProjectRole");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/role/{id}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(createUpdateRoleRequestBean);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse fullyUpdateProjectRoleForHttpResponse(Long id, java.io.InputStream createUpdateRoleRequestBean, String mediaType) throws IOException {
          // verify the required parameter 'id' is set
              if (id == null) {
              throw new IllegalArgumentException("Missing the required parameter 'id' when calling fullyUpdateProjectRole");
              }// verify the required parameter 'createUpdateRoleRequestBean' is set
              if (createUpdateRoleRequestBean == null) {
              throw new IllegalArgumentException("Missing the required parameter 'createUpdateRoleRequestBean' when calling fullyUpdateProjectRole");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("id", id);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/role/{id}");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = createUpdateRoleRequestBean == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, createUpdateRoleRequestBean);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse fullyUpdateProjectRoleForHttpResponse(Long id, CreateUpdateRoleRequestBean createUpdateRoleRequestBean, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling fullyUpdateProjectRole");
        }// verify the required parameter 'createUpdateRoleRequestBean' is set
        if (createUpdateRoleRequestBean == null) {
            throw new IllegalArgumentException("Missing the required parameter 'createUpdateRoleRequestBean' when calling fullyUpdateProjectRole");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/role/{id}");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(createUpdateRoleRequestBean);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }


  /**
    * Get all project roles
    * Gets a list of all project roles, complete with project role details and default actors.  ### About project roles ###  [Project roles](https://confluence.atlassian.com/x/3odKLg) are a flexible way to to associate users and groups with projects. In Jira Cloud, the list of project roles is shared globally with all projects, but each project can have a different set of actors associated with it (unlike groups, which have the same membership throughout all Jira applications).  Project roles are used in [permission schemes](#api-rest-api-3-permissionscheme-get), [email notification schemes](#api-rest-api-3-notificationscheme-get), [issue security levels](#api-rest-api-3-issuesecurityschemes-get), [comment visibility](#api-rest-api-3-comment-list-post), and workflow conditions.  #### Members and actors ####  In the Jira REST API, a member of a project role is called an *actor*. An *actor* is a group or user associated with a project role.  Actors may be set as [default members](https://confluence.atlassian.com/x/3odKLg#Managingprojectroles-Specifying&#39;defaultmembers&#39;foraprojectrole) of the project role or set at the project level:   *  Default actors: Users and groups that are assigned to the project role for all newly created projects. The default actors can be removed at the project level later if desired.  *  Actors: Users and groups that are associated with a project role for a project, which may differ from the default actors. This enables you to assign a user to different roles in different projects.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have administrative permissions.
    * @return List&lt;ProjectRole&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<ProjectRole> getAllProjectRoles() throws IOException {
        HttpResponse response = getAllProjectRolesForHttpResponse();
        TypeReference<List<ProjectRole>> typeRef = new TypeReference<List<ProjectRole>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get all project roles
    * Gets a list of all project roles, complete with project role details and default actors.  ### About project roles ###  [Project roles](https://confluence.atlassian.com/x/3odKLg) are a flexible way to to associate users and groups with projects. In Jira Cloud, the list of project roles is shared globally with all projects, but each project can have a different set of actors associated with it (unlike groups, which have the same membership throughout all Jira applications).  Project roles are used in [permission schemes](#api-rest-api-3-permissionscheme-get), [email notification schemes](#api-rest-api-3-notificationscheme-get), [issue security levels](#api-rest-api-3-issuesecurityschemes-get), [comment visibility](#api-rest-api-3-comment-list-post), and workflow conditions.  #### Members and actors ####  In the Jira REST API, a member of a project role is called an *actor*. An *actor* is a group or user associated with a project role.  Actors may be set as [default members](https://confluence.atlassian.com/x/3odKLg#Managingprojectroles-Specifying&#39;defaultmembers&#39;foraprojectrole) of the project role or set at the project level:   *  Default actors: Users and groups that are assigned to the project role for all newly created projects. The default actors can be removed at the project level later if desired.  *  Actors: Users and groups that are associated with a project role for a project, which may differ from the default actors. This enables you to assign a user to different roles in different projects.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have administrative permissions.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return List&lt;ProjectRole&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<ProjectRole> getAllProjectRoles(Map<String, Object> params) throws IOException {
        HttpResponse response = getAllProjectRolesForHttpResponse(params);
        TypeReference<List<ProjectRole>> typeRef = new TypeReference<List<ProjectRole>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getAllProjectRolesForHttpResponse() throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/role");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getAllProjectRolesForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/role");

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
    * Get project role for project
    * Returns a project role&#39;s details and actors associated with the project. The list of actors is sorted by display name.  To check whether a user belongs to a role based on their group memberships, use [Get user](#api-rest-api-3-user-get) with the &#x60;groups&#x60; expand parameter selected. Then check whether the user keys and groups match with the actors returned for the project.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Administer Projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project or *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if:   *  the project or project role is not found.  *  the user does not have administrative permission.
    * @param projectIdOrKey The project ID or project key (case sensitive).
    * @param id The ID of the project role. Use [Get all project roles](#api-rest-api-3-role-get) to get a list of project role IDs.
    * @return ProjectRole
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ProjectRole getProjectRole(String projectIdOrKey, Long id) throws IOException {
        HttpResponse response = getProjectRoleForHttpResponse(projectIdOrKey, id);
        TypeReference<ProjectRole> typeRef = new TypeReference<ProjectRole>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get project role for project
    * Returns a project role&#39;s details and actors associated with the project. The list of actors is sorted by display name.  To check whether a user belongs to a role based on their group memberships, use [Get user](#api-rest-api-3-user-get) with the &#x60;groups&#x60; expand parameter selected. Then check whether the user keys and groups match with the actors returned for the project.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Administer Projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project or *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if:   *  the project or project role is not found.  *  the user does not have administrative permission.
    * @param projectIdOrKey The project ID or project key (case sensitive).
    * @param id The ID of the project role. Use [Get all project roles](#api-rest-api-3-role-get) to get a list of project role IDs.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return ProjectRole
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ProjectRole getProjectRole(String projectIdOrKey, Long id, Map<String, Object> params) throws IOException {
        HttpResponse response = getProjectRoleForHttpResponse(projectIdOrKey, id, params);
        TypeReference<ProjectRole> typeRef = new TypeReference<ProjectRole>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getProjectRoleForHttpResponse(String projectIdOrKey, Long id) throws IOException {
        // verify the required parameter 'projectIdOrKey' is set
        if (projectIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectIdOrKey' when calling getProjectRole");
        }// verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling getProjectRole");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectIdOrKey", projectIdOrKey);
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectIdOrKey}/role/{id}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getProjectRoleForHttpResponse(String projectIdOrKey, Long id, Map<String, Object> params) throws IOException {
        // verify the required parameter 'projectIdOrKey' is set
        if (projectIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectIdOrKey' when calling getProjectRole");
        }// verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling getProjectRole");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectIdOrKey", projectIdOrKey);
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectIdOrKey}/role/{id}");

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
    * Get project role by ID
    * Gets the project role details and the default actors associated with the role. The list of default actors is sorted by display name.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have administrative permissions.
    * <p><b>404</b> - Returned if the project role is not found.
    * @param id The ID of the project role. Use [Get all project roles](#api-rest-api-3-role-get) to get a list of project role IDs.
    * @return ProjectRole
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ProjectRole getProjectRoleById(Long id) throws IOException {
        HttpResponse response = getProjectRoleByIdForHttpResponse(id);
        TypeReference<ProjectRole> typeRef = new TypeReference<ProjectRole>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get project role by ID
    * Gets the project role details and the default actors associated with the role. The list of default actors is sorted by display name.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have administrative permissions.
    * <p><b>404</b> - Returned if the project role is not found.
    * @param id The ID of the project role. Use [Get all project roles](#api-rest-api-3-role-get) to get a list of project role IDs.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return ProjectRole
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ProjectRole getProjectRoleById(Long id, Map<String, Object> params) throws IOException {
        HttpResponse response = getProjectRoleByIdForHttpResponse(id, params);
        TypeReference<ProjectRole> typeRef = new TypeReference<ProjectRole>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getProjectRoleByIdForHttpResponse(Long id) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling getProjectRoleById");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/role/{id}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getProjectRoleByIdForHttpResponse(Long id, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling getProjectRoleById");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/role/{id}");

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
    * Get project role details
    * Returns all [project roles](https://confluence.atlassian.com/x/3odKLg) and the details for each role. Note that the list of project roles is common to all projects.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) or *Administer projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the project is not found or if the user does not have the necessary permissions for the project.
    * @param projectIdOrKey The project ID or project key (case sensitive).
    * @param currentMember Whether the roles should be filtered to include only those the user is assigned to.
    * @param excludeConnectAddons The excludeConnectAddons parameter
    * @return List&lt;ProjectRole&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<ProjectRole> getProjectRoleDetails(String projectIdOrKey, Boolean currentMember, Boolean excludeConnectAddons) throws IOException {
        HttpResponse response = getProjectRoleDetailsForHttpResponse(projectIdOrKey, currentMember, excludeConnectAddons);
        TypeReference<List<ProjectRole>> typeRef = new TypeReference<List<ProjectRole>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get project role details
    * Returns all [project roles](https://confluence.atlassian.com/x/3odKLg) and the details for each role. Note that the list of project roles is common to all projects.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) or *Administer projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the project is not found or if the user does not have the necessary permissions for the project.
    * @param projectIdOrKey The project ID or project key (case sensitive).
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return List&lt;ProjectRole&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<ProjectRole> getProjectRoleDetails(String projectIdOrKey, Map<String, Object> params) throws IOException {
        HttpResponse response = getProjectRoleDetailsForHttpResponse(projectIdOrKey, params);
        TypeReference<List<ProjectRole>> typeRef = new TypeReference<List<ProjectRole>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getProjectRoleDetailsForHttpResponse(String projectIdOrKey, Boolean currentMember, Boolean excludeConnectAddons) throws IOException {
        // verify the required parameter 'projectIdOrKey' is set
        if (projectIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectIdOrKey' when calling getProjectRoleDetails");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectIdOrKey", projectIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectIdOrKey}/roledetails");
        if (currentMember != null) {
            String key = "currentMember";
            Object value = currentMember;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (excludeConnectAddons != null) {
            String key = "excludeConnectAddons";
            Object value = excludeConnectAddons;
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

    public HttpResponse getProjectRoleDetailsForHttpResponse(String projectIdOrKey, Map<String, Object> params) throws IOException {
        // verify the required parameter 'projectIdOrKey' is set
        if (projectIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectIdOrKey' when calling getProjectRoleDetails");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectIdOrKey", projectIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectIdOrKey}/roledetails");

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
    * Get project roles for project
    * Returns a list of [project roles](https://confluence.atlassian.com/x/3odKLg) for the project returning the name and self URL for each role.  Note that all project roles are shared with all projects in Jira Cloud. See [Get all project roles](#api-rest-api-3-role-get) for more information.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Administer Projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for any project on the site or *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing or if the user lacks administrative permissions for the project.
    * <p><b>404</b> - Returned if the project is not found or or if the user does not have administrative permissions for the project.
    * @param projectIdOrKey The project ID or project key (case sensitive).
    * @return Map&lt;String, URI&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Map<String, URI> getProjectRoles(String projectIdOrKey) throws IOException {
        HttpResponse response = getProjectRolesForHttpResponse(projectIdOrKey);
        TypeReference<Map<String, URI>> typeRef = new TypeReference<Map<String, URI>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get project roles for project
    * Returns a list of [project roles](https://confluence.atlassian.com/x/3odKLg) for the project returning the name and self URL for each role.  Note that all project roles are shared with all projects in Jira Cloud. See [Get all project roles](#api-rest-api-3-role-get) for more information.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Administer Projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for any project on the site or *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing or if the user lacks administrative permissions for the project.
    * <p><b>404</b> - Returned if the project is not found or or if the user does not have administrative permissions for the project.
    * @param projectIdOrKey The project ID or project key (case sensitive).
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Map&lt;String, URI&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Map<String, URI> getProjectRoles(String projectIdOrKey, Map<String, Object> params) throws IOException {
        HttpResponse response = getProjectRolesForHttpResponse(projectIdOrKey, params);
        TypeReference<Map<String, URI>> typeRef = new TypeReference<Map<String, URI>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getProjectRolesForHttpResponse(String projectIdOrKey) throws IOException {
        // verify the required parameter 'projectIdOrKey' is set
        if (projectIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectIdOrKey' when calling getProjectRoles");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectIdOrKey", projectIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectIdOrKey}/role");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getProjectRolesForHttpResponse(String projectIdOrKey, Map<String, Object> params) throws IOException {
        // verify the required parameter 'projectIdOrKey' is set
        if (projectIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectIdOrKey' when calling getProjectRoles");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectIdOrKey", projectIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectIdOrKey}/role");

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
    * Partial update project role
    * Updates either the project role&#39;s name or its description.  You cannot update both the name and description at the same time using this operation. If you send a request with a name and a description only the name is updated.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have administrative permissions.
    * <p><b>404</b> - Returned if the project role is not found.
    * @param id The ID of the project role. Use [Get all project roles](#api-rest-api-3-role-get) to get a list of project role IDs.
    * @param createUpdateRoleRequestBean The createUpdateRoleRequestBean parameter
    * @return ProjectRole
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ProjectRole partialUpdateProjectRole(Long id, CreateUpdateRoleRequestBean createUpdateRoleRequestBean) throws IOException {
        HttpResponse response = partialUpdateProjectRoleForHttpResponse(id, createUpdateRoleRequestBean);
        TypeReference<ProjectRole> typeRef = new TypeReference<ProjectRole>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Partial update project role
    * Updates either the project role&#39;s name or its description.  You cannot update both the name and description at the same time using this operation. If you send a request with a name and a description only the name is updated.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have administrative permissions.
    * <p><b>404</b> - Returned if the project role is not found.
    * @param id The ID of the project role. Use [Get all project roles](#api-rest-api-3-role-get) to get a list of project role IDs.
    * @param createUpdateRoleRequestBean The createUpdateRoleRequestBean parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return ProjectRole
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ProjectRole partialUpdateProjectRole(Long id, CreateUpdateRoleRequestBean createUpdateRoleRequestBean, Map<String, Object> params) throws IOException {
        HttpResponse response = partialUpdateProjectRoleForHttpResponse(id, createUpdateRoleRequestBean, params);
        TypeReference<ProjectRole> typeRef = new TypeReference<ProjectRole>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse partialUpdateProjectRoleForHttpResponse(Long id, CreateUpdateRoleRequestBean createUpdateRoleRequestBean) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling partialUpdateProjectRole");
        }// verify the required parameter 'createUpdateRoleRequestBean' is set
        if (createUpdateRoleRequestBean == null) {
            throw new IllegalArgumentException("Missing the required parameter 'createUpdateRoleRequestBean' when calling partialUpdateProjectRole");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/role/{id}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(createUpdateRoleRequestBean);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse partialUpdateProjectRoleForHttpResponse(Long id, java.io.InputStream createUpdateRoleRequestBean, String mediaType) throws IOException {
          // verify the required parameter 'id' is set
              if (id == null) {
              throw new IllegalArgumentException("Missing the required parameter 'id' when calling partialUpdateProjectRole");
              }// verify the required parameter 'createUpdateRoleRequestBean' is set
              if (createUpdateRoleRequestBean == null) {
              throw new IllegalArgumentException("Missing the required parameter 'createUpdateRoleRequestBean' when calling partialUpdateProjectRole");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("id", id);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/role/{id}");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = createUpdateRoleRequestBean == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, createUpdateRoleRequestBean);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse partialUpdateProjectRoleForHttpResponse(Long id, CreateUpdateRoleRequestBean createUpdateRoleRequestBean, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling partialUpdateProjectRole");
        }// verify the required parameter 'createUpdateRoleRequestBean' is set
        if (createUpdateRoleRequestBean == null) {
            throw new IllegalArgumentException("Missing the required parameter 'createUpdateRoleRequestBean' when calling partialUpdateProjectRole");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/role/{id}");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(createUpdateRoleRequestBean);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


}
