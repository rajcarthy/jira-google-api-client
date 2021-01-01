package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.IdBean;
import com.atlassian.jira.rest.client.model.PermissionScheme;
import com.atlassian.jira.rest.client.model.ProjectIssueSecurityLevels;
import com.atlassian.jira.rest.client.model.SecurityScheme;

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
public class ProjectPermissionSchemesApi {
    private ApiClient apiClient;

    public ProjectPermissionSchemesApi() {
        this(new ApiClient());
    }

    public ProjectPermissionSchemesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Assign permission scheme
    * Assigns a permission scheme with a project. See [Managing project permissions](https://confluence.atlassian.com/x/yodKLg) for more information about permission schemes.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg)
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if:   *  the user does not have the necessary permission to edit the project&#39;s configuration.  *  the Jira instance is Jira Core Free or Jira Software Free. Permission schemes cannot be assigned to projects on free plans.
    * <p><b>404</b> - Returned if the project or permission scheme is not found.
    * @param projectKeyOrId The project ID or project key (case sensitive).
    * @param idBean The idBean parameter
    * @param expand Use [expand](#expansion) to include additional information in the response. This parameter accepts a comma-separated list. Note that permissions are included when you specify any value. Expand options include:   *  &#x60;all&#x60; Returns all expandable information.  *  &#x60;field&#x60; Returns information about the custom field granted the permission.  *  &#x60;group&#x60; Returns information about the group that is granted the permission.  *  &#x60;permissions&#x60; Returns all permission grants for each permission scheme.  *  &#x60;projectRole&#x60; Returns information about the project role granted the permission.  *  &#x60;user&#x60; Returns information about the user who is granted the permission.
    * @return PermissionScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PermissionScheme assignPermissionScheme(String projectKeyOrId, IdBean idBean, String expand) throws IOException {
        HttpResponse response = assignPermissionSchemeForHttpResponse(projectKeyOrId, idBean, expand);
        TypeReference<PermissionScheme> typeRef = new TypeReference<PermissionScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Assign permission scheme
    * Assigns a permission scheme with a project. See [Managing project permissions](https://confluence.atlassian.com/x/yodKLg) for more information about permission schemes.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg)
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if:   *  the user does not have the necessary permission to edit the project&#39;s configuration.  *  the Jira instance is Jira Core Free or Jira Software Free. Permission schemes cannot be assigned to projects on free plans.
    * <p><b>404</b> - Returned if the project or permission scheme is not found.
    * @param projectKeyOrId The project ID or project key (case sensitive).
    * @param idBean The idBean parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PermissionScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PermissionScheme assignPermissionScheme(String projectKeyOrId, IdBean idBean, Map<String, Object> params) throws IOException {
        HttpResponse response = assignPermissionSchemeForHttpResponse(projectKeyOrId, idBean, params);
        TypeReference<PermissionScheme> typeRef = new TypeReference<PermissionScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse assignPermissionSchemeForHttpResponse(String projectKeyOrId, IdBean idBean, String expand) throws IOException {
        // verify the required parameter 'projectKeyOrId' is set
        if (projectKeyOrId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectKeyOrId' when calling assignPermissionScheme");
        }// verify the required parameter 'idBean' is set
        if (idBean == null) {
            throw new IllegalArgumentException("Missing the required parameter 'idBean' when calling assignPermissionScheme");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectKeyOrId", projectKeyOrId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectKeyOrId}/permissionscheme");
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

        HttpContent content = apiClient.new JacksonJsonHttpContent(idBean);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse assignPermissionSchemeForHttpResponse(String projectKeyOrId, java.io.InputStream idBean, String expand, String mediaType) throws IOException {
          // verify the required parameter 'projectKeyOrId' is set
              if (projectKeyOrId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'projectKeyOrId' when calling assignPermissionScheme");
              }// verify the required parameter 'idBean' is set
              if (idBean == null) {
              throw new IllegalArgumentException("Missing the required parameter 'idBean' when calling assignPermissionScheme");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("projectKeyOrId", projectKeyOrId);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectKeyOrId}/permissionscheme");
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

              HttpContent content = idBean == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, idBean);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse assignPermissionSchemeForHttpResponse(String projectKeyOrId, IdBean idBean, Map<String, Object> params) throws IOException {
        // verify the required parameter 'projectKeyOrId' is set
        if (projectKeyOrId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectKeyOrId' when calling assignPermissionScheme");
        }// verify the required parameter 'idBean' is set
        if (idBean == null) {
            throw new IllegalArgumentException("Missing the required parameter 'idBean' when calling assignPermissionScheme");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectKeyOrId", projectKeyOrId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectKeyOrId}/permissionscheme");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(idBean);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }


  /**
    * Get assigned permission scheme
    * Gets the [permission scheme](https://confluence.atlassian.com/x/yodKLg) associated with the project.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) or *Administer projects* [project permission](https://confluence.atlassian.com/x/yodKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have permission to view the project&#39;s configuration.
    * <p><b>404</b> - Returned if the project is not found or the user does not have permission to view the project.
    * @param projectKeyOrId The project ID or project key (case sensitive).
    * @param expand Use [expand](#expansion) to include additional information in the response. This parameter accepts a comma-separated list. Note that permissions are included when you specify any value. Expand options include:   *  &#x60;all&#x60; Returns all expandable information.  *  &#x60;field&#x60; Returns information about the custom field granted the permission.  *  &#x60;group&#x60; Returns information about the group that is granted the permission.  *  &#x60;permissions&#x60; Returns all permission grants for each permission scheme.  *  &#x60;projectRole&#x60; Returns information about the project role granted the permission.  *  &#x60;user&#x60; Returns information about the user who is granted the permission.
    * @return PermissionScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PermissionScheme getAssignedPermissionScheme(String projectKeyOrId, String expand) throws IOException {
        HttpResponse response = getAssignedPermissionSchemeForHttpResponse(projectKeyOrId, expand);
        TypeReference<PermissionScheme> typeRef = new TypeReference<PermissionScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get assigned permission scheme
    * Gets the [permission scheme](https://confluence.atlassian.com/x/yodKLg) associated with the project.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) or *Administer projects* [project permission](https://confluence.atlassian.com/x/yodKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have permission to view the project&#39;s configuration.
    * <p><b>404</b> - Returned if the project is not found or the user does not have permission to view the project.
    * @param projectKeyOrId The project ID or project key (case sensitive).
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PermissionScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PermissionScheme getAssignedPermissionScheme(String projectKeyOrId, Map<String, Object> params) throws IOException {
        HttpResponse response = getAssignedPermissionSchemeForHttpResponse(projectKeyOrId, params);
        TypeReference<PermissionScheme> typeRef = new TypeReference<PermissionScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getAssignedPermissionSchemeForHttpResponse(String projectKeyOrId, String expand) throws IOException {
        // verify the required parameter 'projectKeyOrId' is set
        if (projectKeyOrId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectKeyOrId' when calling getAssignedPermissionScheme");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectKeyOrId", projectKeyOrId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectKeyOrId}/permissionscheme");
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

    public HttpResponse getAssignedPermissionSchemeForHttpResponse(String projectKeyOrId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'projectKeyOrId' is set
        if (projectKeyOrId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectKeyOrId' when calling getAssignedPermissionScheme");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectKeyOrId", projectKeyOrId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectKeyOrId}/permissionscheme");

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
    * Get project issue security scheme
    * Returns the [issue security scheme](https://confluence.atlassian.com/x/J4lKLg) associated with the project.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) or the *Administer Projects* [project permission](https://confluence.atlassian.com/x/yodKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the project is visible to the user but the user doesn&#39;t have administrative permissions.
    * <p><b>404</b> - Returned if the project is not found or the user does not have permission to view it.
    * @param projectKeyOrId The project ID or project key (case sensitive).
    * @return SecurityScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public SecurityScheme getProjectIssueSecurityScheme(String projectKeyOrId) throws IOException {
        HttpResponse response = getProjectIssueSecuritySchemeForHttpResponse(projectKeyOrId);
        TypeReference<SecurityScheme> typeRef = new TypeReference<SecurityScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get project issue security scheme
    * Returns the [issue security scheme](https://confluence.atlassian.com/x/J4lKLg) associated with the project.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) or the *Administer Projects* [project permission](https://confluence.atlassian.com/x/yodKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the project is visible to the user but the user doesn&#39;t have administrative permissions.
    * <p><b>404</b> - Returned if the project is not found or the user does not have permission to view it.
    * @param projectKeyOrId The project ID or project key (case sensitive).
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return SecurityScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public SecurityScheme getProjectIssueSecurityScheme(String projectKeyOrId, Map<String, Object> params) throws IOException {
        HttpResponse response = getProjectIssueSecuritySchemeForHttpResponse(projectKeyOrId, params);
        TypeReference<SecurityScheme> typeRef = new TypeReference<SecurityScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getProjectIssueSecuritySchemeForHttpResponse(String projectKeyOrId) throws IOException {
        // verify the required parameter 'projectKeyOrId' is set
        if (projectKeyOrId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectKeyOrId' when calling getProjectIssueSecurityScheme");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectKeyOrId", projectKeyOrId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectKeyOrId}/issuesecuritylevelscheme");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getProjectIssueSecuritySchemeForHttpResponse(String projectKeyOrId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'projectKeyOrId' is set
        if (projectKeyOrId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectKeyOrId' when calling getProjectIssueSecurityScheme");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectKeyOrId", projectKeyOrId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectKeyOrId}/issuesecuritylevelscheme");

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
    * Get project issue security levels
    * Returns all [issue security](https://confluence.atlassian.com/x/J4lKLg) levels for the project that the user has access to.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Browse projects* [global permission](https://confluence.atlassian.com/x/x4dKLg) for the project, however, issue security levels are only returned for authenticated user with *Set Issue Security* [global permission](https://confluence.atlassian.com/x/x4dKLg) for the project.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>404</b> - Returned if the project is not found or the user does not have permission to view it.
    * @param projectKeyOrId The project ID or project key (case sensitive).
    * @return ProjectIssueSecurityLevels
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ProjectIssueSecurityLevels getSecurityLevelsForProject(String projectKeyOrId) throws IOException {
        HttpResponse response = getSecurityLevelsForProjectForHttpResponse(projectKeyOrId);
        TypeReference<ProjectIssueSecurityLevels> typeRef = new TypeReference<ProjectIssueSecurityLevels>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get project issue security levels
    * Returns all [issue security](https://confluence.atlassian.com/x/J4lKLg) levels for the project that the user has access to.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Browse projects* [global permission](https://confluence.atlassian.com/x/x4dKLg) for the project, however, issue security levels are only returned for authenticated user with *Set Issue Security* [global permission](https://confluence.atlassian.com/x/x4dKLg) for the project.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>404</b> - Returned if the project is not found or the user does not have permission to view it.
    * @param projectKeyOrId The project ID or project key (case sensitive).
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return ProjectIssueSecurityLevels
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ProjectIssueSecurityLevels getSecurityLevelsForProject(String projectKeyOrId, Map<String, Object> params) throws IOException {
        HttpResponse response = getSecurityLevelsForProjectForHttpResponse(projectKeyOrId, params);
        TypeReference<ProjectIssueSecurityLevels> typeRef = new TypeReference<ProjectIssueSecurityLevels>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getSecurityLevelsForProjectForHttpResponse(String projectKeyOrId) throws IOException {
        // verify the required parameter 'projectKeyOrId' is set
        if (projectKeyOrId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectKeyOrId' when calling getSecurityLevelsForProject");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectKeyOrId", projectKeyOrId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectKeyOrId}/securitylevel");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getSecurityLevelsForProjectForHttpResponse(String projectKeyOrId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'projectKeyOrId' is set
        if (projectKeyOrId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectKeyOrId' when calling getSecurityLevelsForProject");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectKeyOrId", projectKeyOrId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectKeyOrId}/securitylevel");

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
