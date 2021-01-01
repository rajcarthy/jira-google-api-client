package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.BulkPermissionGrants;
import com.atlassian.jira.rest.client.model.BulkPermissionsRequestBean;
import com.atlassian.jira.rest.client.model.ErrorCollection;
import com.atlassian.jira.rest.client.model.Permissions;
import com.atlassian.jira.rest.client.model.PermissionsKeysBean;
import com.atlassian.jira.rest.client.model.PermittedProjects;

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
public class PermissionsApi {
    private ApiClient apiClient;

    public PermissionsApi() {
        this(new ApiClient());
    }

    public PermissionsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Get all permissions
    * Returns all permissions, including:   *  global permissions.  *  project permissions.  *  global permissions added by plugins.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * @return Permissions
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Permissions getAllPermissions() throws IOException {
        HttpResponse response = getAllPermissionsForHttpResponse();
        TypeReference<Permissions> typeRef = new TypeReference<Permissions>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get all permissions
    * Returns all permissions, including:   *  global permissions.  *  project permissions.  *  global permissions added by plugins.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Permissions
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Permissions getAllPermissions(Map<String, Object> params) throws IOException {
        HttpResponse response = getAllPermissionsForHttpResponse(params);
        TypeReference<Permissions> typeRef = new TypeReference<Permissions>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getAllPermissionsForHttpResponse() throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/permissions");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getAllPermissionsForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/permissions");

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
    * Get bulk permissions
    * Returns:   *  for a list of global permissions, the global permissions granted to a user.  *  for a list of project permissions and lists of projects and issues, for each project permission a list of the projects and issues a user can access or manipulate.  If no account ID is provided, the operation returns details for the logged in user.  Note that:   *  Invalid project and issue IDs are ignored.  *  A maximum of 1000 projects and 1000 issues can be checked.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) to check the permissions for other users, otherwise none. However, Connect apps can make a call from the app server to the product to obtain permission details for any user, without admin permission. This Connect app ability doesn&#39;t apply to calls made using AP.request() in a browser.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  issue or project IDs are provided without at least one project permission being provided.  *  an invalid global permission is provided in the global permissions list.  *  an invalid project permission is provided in the project permissions list.  *  more than 1000 valid project IDs or more than 1000 valid issue IDs are provided.  *  an invalid account ID is provided.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * @param bulkPermissionsRequestBean Details of the permissions to check.
    * @return BulkPermissionGrants
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public BulkPermissionGrants getBulkPermissions(BulkPermissionsRequestBean bulkPermissionsRequestBean) throws IOException {
        HttpResponse response = getBulkPermissionsForHttpResponse(bulkPermissionsRequestBean);
        TypeReference<BulkPermissionGrants> typeRef = new TypeReference<BulkPermissionGrants>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get bulk permissions
    * Returns:   *  for a list of global permissions, the global permissions granted to a user.  *  for a list of project permissions and lists of projects and issues, for each project permission a list of the projects and issues a user can access or manipulate.  If no account ID is provided, the operation returns details for the logged in user.  Note that:   *  Invalid project and issue IDs are ignored.  *  A maximum of 1000 projects and 1000 issues can be checked.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) to check the permissions for other users, otherwise none. However, Connect apps can make a call from the app server to the product to obtain permission details for any user, without admin permission. This Connect app ability doesn&#39;t apply to calls made using AP.request() in a browser.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  issue or project IDs are provided without at least one project permission being provided.  *  an invalid global permission is provided in the global permissions list.  *  an invalid project permission is provided in the project permissions list.  *  more than 1000 valid project IDs or more than 1000 valid issue IDs are provided.  *  an invalid account ID is provided.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * @param bulkPermissionsRequestBean Details of the permissions to check.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return BulkPermissionGrants
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public BulkPermissionGrants getBulkPermissions(BulkPermissionsRequestBean bulkPermissionsRequestBean, Map<String, Object> params) throws IOException {
        HttpResponse response = getBulkPermissionsForHttpResponse(bulkPermissionsRequestBean, params);
        TypeReference<BulkPermissionGrants> typeRef = new TypeReference<BulkPermissionGrants>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getBulkPermissionsForHttpResponse(BulkPermissionsRequestBean bulkPermissionsRequestBean) throws IOException {
        // verify the required parameter 'bulkPermissionsRequestBean' is set
        if (bulkPermissionsRequestBean == null) {
            throw new IllegalArgumentException("Missing the required parameter 'bulkPermissionsRequestBean' when calling getBulkPermissions");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/permissions/check");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(bulkPermissionsRequestBean);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse getBulkPermissionsForHttpResponse(java.io.InputStream bulkPermissionsRequestBean, String mediaType) throws IOException {
          // verify the required parameter 'bulkPermissionsRequestBean' is set
              if (bulkPermissionsRequestBean == null) {
              throw new IllegalArgumentException("Missing the required parameter 'bulkPermissionsRequestBean' when calling getBulkPermissions");
              }
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/permissions/check");

              String localVarUrl = uriBuilder.build().toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = bulkPermissionsRequestBean == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, bulkPermissionsRequestBean);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse getBulkPermissionsForHttpResponse(BulkPermissionsRequestBean bulkPermissionsRequestBean, Map<String, Object> params) throws IOException {
        // verify the required parameter 'bulkPermissionsRequestBean' is set
        if (bulkPermissionsRequestBean == null) {
            throw new IllegalArgumentException("Missing the required parameter 'bulkPermissionsRequestBean' when calling getBulkPermissions");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/permissions/check");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(bulkPermissionsRequestBean);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


  /**
    * Get my permissions
    * Returns a list of permissions indicating which permissions the user has. Details of the user&#39;s permissions can be obtained in a global, project, or issue context.  The user is reported as having a project permission:   *  in the global context, if the user has the project permission in any project.  *  for a project, where the project permission is determined using issue data, if the user meets the permission&#39;s criteria for any issue in the project. Otherwise, if the user has the project permission in the project.  *  for an issue, where a project permission is determined using issue data, if the user has the permission in the issue. Otherwise, if the user has the project permission in the project containing the issue.  This means that users may be shown as having an issue permission (such as EDIT\\_ISSUES) in the global context or a project context but may not have the permission for any or all issues. For example, if Reporters have the EDIT\\_ISSUES permission a user would be shown as having this permission in the global context or the context of a project, because any user can be a reporter. However, if they are not the user who reported the issue queried they would not have EDIT\\_ISSUES permission for that issue.  Global permissions are unaffected by context.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if &#x60;permissions&#x60; is empty or the permission key it contains is not found or deprecated.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the project or issue is not found or the user does not have permission to view the project or issue.
    * @param projectKey The key of project. Ignored if &#x60;projectId&#x60; is provided.
    * @param projectId The ID of project.
    * @param issueKey The key of the issue. Ignored if &#x60;issueId&#x60; is provided.
    * @param issueId The ID of the issue.
    * @param permissions A list of permission keys. (Required) This parameter accepts a comma-separated list. To get the list of available permissions, use [Get all permissions](#api-rest-api-3-permissions-get).
    * @param projectUuid The projectUuid parameter
    * @param projectConfigurationUuid The projectConfigurationUuid parameter
    * @return Permissions
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Permissions getMyPermissions(String projectKey, String projectId, String issueKey, String issueId, String permissions, String projectUuid, String projectConfigurationUuid) throws IOException {
        HttpResponse response = getMyPermissionsForHttpResponse(projectKey, projectId, issueKey, issueId, permissions, projectUuid, projectConfigurationUuid);
        TypeReference<Permissions> typeRef = new TypeReference<Permissions>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get my permissions
    * Returns a list of permissions indicating which permissions the user has. Details of the user&#39;s permissions can be obtained in a global, project, or issue context.  The user is reported as having a project permission:   *  in the global context, if the user has the project permission in any project.  *  for a project, where the project permission is determined using issue data, if the user meets the permission&#39;s criteria for any issue in the project. Otherwise, if the user has the project permission in the project.  *  for an issue, where a project permission is determined using issue data, if the user has the permission in the issue. Otherwise, if the user has the project permission in the project containing the issue.  This means that users may be shown as having an issue permission (such as EDIT\\_ISSUES) in the global context or a project context but may not have the permission for any or all issues. For example, if Reporters have the EDIT\\_ISSUES permission a user would be shown as having this permission in the global context or the context of a project, because any user can be a reporter. However, if they are not the user who reported the issue queried they would not have EDIT\\_ISSUES permission for that issue.  Global permissions are unaffected by context.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if &#x60;permissions&#x60; is empty or the permission key it contains is not found or deprecated.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the project or issue is not found or the user does not have permission to view the project or issue.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Permissions
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Permissions getMyPermissions(Map<String, Object> params) throws IOException {
        HttpResponse response = getMyPermissionsForHttpResponse(params);
        TypeReference<Permissions> typeRef = new TypeReference<Permissions>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getMyPermissionsForHttpResponse(String projectKey, String projectId, String issueKey, String issueId, String permissions, String projectUuid, String projectConfigurationUuid) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/mypermissions");
        if (projectKey != null) {
            String key = "projectKey";
            Object value = projectKey;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (projectId != null) {
            String key = "projectId";
            Object value = projectId;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (issueKey != null) {
            String key = "issueKey";
            Object value = issueKey;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (issueId != null) {
            String key = "issueId";
            Object value = issueId;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (permissions != null) {
            String key = "permissions";
            Object value = permissions;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (projectUuid != null) {
            String key = "projectUuid";
            Object value = projectUuid;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (projectConfigurationUuid != null) {
            String key = "projectConfigurationUuid";
            Object value = projectConfigurationUuid;
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

    public HttpResponse getMyPermissionsForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/mypermissions");

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
    * Get permitted projects
    * Returns all the projects where the user is granted a list of project permissions.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if a project permission is not found.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param permissionsKeysBean The permissionsKeysBean parameter
    * @return PermittedProjects
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PermittedProjects getPermittedProjects(PermissionsKeysBean permissionsKeysBean) throws IOException {
        HttpResponse response = getPermittedProjectsForHttpResponse(permissionsKeysBean);
        TypeReference<PermittedProjects> typeRef = new TypeReference<PermittedProjects>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get permitted projects
    * Returns all the projects where the user is granted a list of project permissions.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if a project permission is not found.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param permissionsKeysBean The permissionsKeysBean parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PermittedProjects
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PermittedProjects getPermittedProjects(PermissionsKeysBean permissionsKeysBean, Map<String, Object> params) throws IOException {
        HttpResponse response = getPermittedProjectsForHttpResponse(permissionsKeysBean, params);
        TypeReference<PermittedProjects> typeRef = new TypeReference<PermittedProjects>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getPermittedProjectsForHttpResponse(PermissionsKeysBean permissionsKeysBean) throws IOException {
        // verify the required parameter 'permissionsKeysBean' is set
        if (permissionsKeysBean == null) {
            throw new IllegalArgumentException("Missing the required parameter 'permissionsKeysBean' when calling getPermittedProjects");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/permissions/project");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(permissionsKeysBean);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse getPermittedProjectsForHttpResponse(java.io.InputStream permissionsKeysBean, String mediaType) throws IOException {
          // verify the required parameter 'permissionsKeysBean' is set
              if (permissionsKeysBean == null) {
              throw new IllegalArgumentException("Missing the required parameter 'permissionsKeysBean' when calling getPermittedProjects");
              }
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/permissions/project");

              String localVarUrl = uriBuilder.build().toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = permissionsKeysBean == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, permissionsKeysBean);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse getPermittedProjectsForHttpResponse(PermissionsKeysBean permissionsKeysBean, Map<String, Object> params) throws IOException {
        // verify the required parameter 'permissionsKeysBean' is set
        if (permissionsKeysBean == null) {
            throw new IllegalArgumentException("Missing the required parameter 'permissionsKeysBean' when calling getPermittedProjects");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/permissions/project");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(permissionsKeysBean);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


}
