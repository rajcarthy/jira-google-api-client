package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.IssueTypeWithStatus;
import com.atlassian.jira.rest.client.model.NotificationScheme;
import com.atlassian.jira.rest.client.model.PageBeanProject;
import com.atlassian.jira.rest.client.model.Project;
import com.atlassian.jira.rest.client.model.ProjectIdentifiers;
import com.atlassian.jira.rest.client.model.ProjectInputBean;
import com.atlassian.jira.rest.client.model.ProjectIssueTypeHierarchy;
import com.atlassian.jira.rest.client.model.TaskProgressBeanObject;

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
public class ProjectsApi {
    private ApiClient apiClient;

    public ProjectsApi() {
        this(new ApiClient());
    }

    public ProjectsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Archive project
    * Archives a project. Archived projects cannot be deleted. To delete an archived project, restore the project and then delete it. To restore a project, use the Jira UI.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permissions.
    * <p><b>404</b> - Returned if the project is not found.
    * @param projectIdOrKey The project ID or project key (case sensitive).
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object archiveProject(String projectIdOrKey) throws IOException {
        HttpResponse response = archiveProjectForHttpResponse(projectIdOrKey);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Archive project
    * Archives a project. Archived projects cannot be deleted. To delete an archived project, restore the project and then delete it. To restore a project, use the Jira UI.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permissions.
    * <p><b>404</b> - Returned if the project is not found.
    * @param projectIdOrKey The project ID or project key (case sensitive).
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object archiveProject(String projectIdOrKey, Map<String, Object> params) throws IOException {
        HttpResponse response = archiveProjectForHttpResponse(projectIdOrKey, params);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse archiveProjectForHttpResponse(String projectIdOrKey) throws IOException {
        // verify the required parameter 'projectIdOrKey' is set
        if (projectIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectIdOrKey' when calling archiveProject");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectIdOrKey", projectIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectIdOrKey}/archive");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = new EmptyContent();
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

    public HttpResponse archiveProjectForHttpResponse(String projectIdOrKey, Map<String, Object> params) throws IOException {
        // verify the required parameter 'projectIdOrKey' is set
        if (projectIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectIdOrKey' when calling archiveProject");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectIdOrKey", projectIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectIdOrKey}/archive");

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

        HttpContent content = new EmptyContent();
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


  /**
    * Create project
    * Creates a project based on a project type template, as shown in the following table:  | Project Type Key | Project Template Key |   |--|--|   | &#x60;business&#x60; | &#x60;com.atlassian.jira-core-project-templates:jira-core-simplified-content-management&#x60;, &#x60;com.atlassian.jira-core-project-templates:jira-core-simplified-document-approval&#x60;, &#x60;com.atlassian.jira-core-project-templates:jira-core-simplified-lead-tracking&#x60;, &#x60;com.atlassian.jira-core-project-templates:jira-core-simplified-process-control&#x60;, &#x60;com.atlassian.jira-core-project-templates:jira-core-simplified-procurement&#x60;, &#x60;com.atlassian.jira-core-project-templates:jira-core-simplified-project-management&#x60;, &#x60;com.atlassian.jira-core-project-templates:jira-core-simplified-recruitment&#x60;, &#x60;com.atlassian.jira-core-project-templates:jira-core-simplified-task-tracking&#x60; |   | &#x60;service_desk&#x60; | &#x60;com.atlassian.servicedesk:simplified-it-service-desk&#x60;, &#x60;com.atlassian.servicedesk:simplified-internal-service-desk&#x60;, &#x60;com.atlassian.servicedesk:simplified-external-service-desk&#x60; |   | &#x60;software&#x60; | &#x60;com.pyxis.greenhopper.jira:gh-simplified-agility-kanban&#x60;, &#x60;com.pyxis.greenhopper.jira:gh-simplified-agility-scrum&#x60;, &#x60;com.pyxis.greenhopper.jira:gh-simplified-basic&#x60;, &#x60;com.pyxis.greenhopper.jira:gh-simplified-kanban-classic&#x60;, &#x60;com.pyxis.greenhopper.jira:gh-simplified-scrum-classic&#x60; |   The project types are available according to the installed Jira features as follows:   *  Jira Core, the default, enables &#x60;business&#x60; projects.  *  Jira Service Desk enables &#x60;service_desk&#x60; projects.  *  Jira Software enables &#x60;software&#x60; projects.  To determine which features are installed, go to **Jira settings** &gt; **Apps** &gt; **Manage apps** and review the System Apps list. To add JIRA Software or JIRA Service Desk into a JIRA instance, use **Jira settings** &gt; **Apps** &gt; **Finding new apps**. For more information, see [ Managing add-ons](https://confluence.atlassian.com/x/S31NLg).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>201</b> - Returned if the project is created.
    * <p><b>400</b> - Returned if the request is not valid and the project could not be created.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have permission to create projects.
    * @param projectInputBean The JSON representation of the project being created.
    * @return ProjectIdentifiers
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ProjectIdentifiers createProject(ProjectInputBean projectInputBean) throws IOException {
        HttpResponse response = createProjectForHttpResponse(projectInputBean);
        TypeReference<ProjectIdentifiers> typeRef = new TypeReference<ProjectIdentifiers>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Create project
    * Creates a project based on a project type template, as shown in the following table:  | Project Type Key | Project Template Key |   |--|--|   | &#x60;business&#x60; | &#x60;com.atlassian.jira-core-project-templates:jira-core-simplified-content-management&#x60;, &#x60;com.atlassian.jira-core-project-templates:jira-core-simplified-document-approval&#x60;, &#x60;com.atlassian.jira-core-project-templates:jira-core-simplified-lead-tracking&#x60;, &#x60;com.atlassian.jira-core-project-templates:jira-core-simplified-process-control&#x60;, &#x60;com.atlassian.jira-core-project-templates:jira-core-simplified-procurement&#x60;, &#x60;com.atlassian.jira-core-project-templates:jira-core-simplified-project-management&#x60;, &#x60;com.atlassian.jira-core-project-templates:jira-core-simplified-recruitment&#x60;, &#x60;com.atlassian.jira-core-project-templates:jira-core-simplified-task-tracking&#x60; |   | &#x60;service_desk&#x60; | &#x60;com.atlassian.servicedesk:simplified-it-service-desk&#x60;, &#x60;com.atlassian.servicedesk:simplified-internal-service-desk&#x60;, &#x60;com.atlassian.servicedesk:simplified-external-service-desk&#x60; |   | &#x60;software&#x60; | &#x60;com.pyxis.greenhopper.jira:gh-simplified-agility-kanban&#x60;, &#x60;com.pyxis.greenhopper.jira:gh-simplified-agility-scrum&#x60;, &#x60;com.pyxis.greenhopper.jira:gh-simplified-basic&#x60;, &#x60;com.pyxis.greenhopper.jira:gh-simplified-kanban-classic&#x60;, &#x60;com.pyxis.greenhopper.jira:gh-simplified-scrum-classic&#x60; |   The project types are available according to the installed Jira features as follows:   *  Jira Core, the default, enables &#x60;business&#x60; projects.  *  Jira Service Desk enables &#x60;service_desk&#x60; projects.  *  Jira Software enables &#x60;software&#x60; projects.  To determine which features are installed, go to **Jira settings** &gt; **Apps** &gt; **Manage apps** and review the System Apps list. To add JIRA Software or JIRA Service Desk into a JIRA instance, use **Jira settings** &gt; **Apps** &gt; **Finding new apps**. For more information, see [ Managing add-ons](https://confluence.atlassian.com/x/S31NLg).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>201</b> - Returned if the project is created.
    * <p><b>400</b> - Returned if the request is not valid and the project could not be created.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have permission to create projects.
    * @param projectInputBean The JSON representation of the project being created.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return ProjectIdentifiers
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ProjectIdentifiers createProject(ProjectInputBean projectInputBean, Map<String, Object> params) throws IOException {
        HttpResponse response = createProjectForHttpResponse(projectInputBean, params);
        TypeReference<ProjectIdentifiers> typeRef = new TypeReference<ProjectIdentifiers>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse createProjectForHttpResponse(ProjectInputBean projectInputBean) throws IOException {
        // verify the required parameter 'projectInputBean' is set
        if (projectInputBean == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectInputBean' when calling createProject");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(projectInputBean);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse createProjectForHttpResponse(java.io.InputStream projectInputBean, String mediaType) throws IOException {
          // verify the required parameter 'projectInputBean' is set
              if (projectInputBean == null) {
              throw new IllegalArgumentException("Missing the required parameter 'projectInputBean' when calling createProject");
              }
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project");

              String localVarUrl = uriBuilder.build().toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = projectInputBean == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, projectInputBean);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse createProjectForHttpResponse(ProjectInputBean projectInputBean, Map<String, Object> params) throws IOException {
        // verify the required parameter 'projectInputBean' is set
        if (projectInputBean == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectInputBean' when calling createProject");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(projectInputBean);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


  /**
    * Delete project
    * Deletes a project.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the project is deleted.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the project is not found or the user does not have permission to delete it.
    * @param projectIdOrKey The project ID or project key (case sensitive).
    * @param enableUndo Whether this project is placed in the Jira recycle bin where it will be available for restoration.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteProject(String projectIdOrKey, Boolean enableUndo) throws IOException {
        deleteProjectForHttpResponse(projectIdOrKey, enableUndo);
    }

  /**
    * Delete project
    * Deletes a project.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the project is deleted.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the project is not found or the user does not have permission to delete it.
    * @param projectIdOrKey The project ID or project key (case sensitive).
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteProject(String projectIdOrKey, Map<String, Object> params) throws IOException {
        deleteProjectForHttpResponse(projectIdOrKey, params);
    }

    public HttpResponse deleteProjectForHttpResponse(String projectIdOrKey, Boolean enableUndo) throws IOException {
        // verify the required parameter 'projectIdOrKey' is set
        if (projectIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectIdOrKey' when calling deleteProject");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectIdOrKey", projectIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectIdOrKey}");
        if (enableUndo != null) {
            String key = "enableUndo";
            Object value = enableUndo;
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

    public HttpResponse deleteProjectForHttpResponse(String projectIdOrKey, Map<String, Object> params) throws IOException {
        // verify the required parameter 'projectIdOrKey' is set
        if (projectIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectIdOrKey' when calling deleteProject");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectIdOrKey", projectIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectIdOrKey}");

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
    * Delete project asynchronously
    * Deletes a project asynchronously.  This operation is:   *  transactional, that is, if part of the delete fails the project is not deleted.  *  [asynchronous](#async). Follow the &#x60;location&#x60; link in the response to determine the status of the task and use [Get task](#api-rest-api-3-task-taskId-get) to obtain subsequent updates.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>303</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the project is not found or the user does not have the necessary permission.
    * @param projectIdOrKey The project ID or project key (case sensitive).
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteProjectAsynchronously(String projectIdOrKey) throws IOException {
        deleteProjectAsynchronouslyForHttpResponse(projectIdOrKey);
    }

  /**
    * Delete project asynchronously
    * Deletes a project asynchronously.  This operation is:   *  transactional, that is, if part of the delete fails the project is not deleted.  *  [asynchronous](#async). Follow the &#x60;location&#x60; link in the response to determine the status of the task and use [Get task](#api-rest-api-3-task-taskId-get) to obtain subsequent updates.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>303</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the project is not found or the user does not have the necessary permission.
    * @param projectIdOrKey The project ID or project key (case sensitive).
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteProjectAsynchronously(String projectIdOrKey, Map<String, Object> params) throws IOException {
        deleteProjectAsynchronouslyForHttpResponse(projectIdOrKey, params);
    }

    public HttpResponse deleteProjectAsynchronouslyForHttpResponse(String projectIdOrKey) throws IOException {
        // verify the required parameter 'projectIdOrKey' is set
        if (projectIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectIdOrKey' when calling deleteProjectAsynchronously");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectIdOrKey", projectIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectIdOrKey}/delete");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = new EmptyContent();
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

    public HttpResponse deleteProjectAsynchronouslyForHttpResponse(String projectIdOrKey, Map<String, Object> params) throws IOException {
        // verify the required parameter 'projectIdOrKey' is set
        if (projectIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectIdOrKey' when calling deleteProjectAsynchronously");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectIdOrKey", projectIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectIdOrKey}/delete");

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

        HttpContent content = new EmptyContent();
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


  /**
    * Get all projects
    * Returns all projects visible to the user. Deprecated, use [ Get projects paginated](#api-rest-api-3-project-search-get) that supports search and pagination.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** Projects are returned only where the user has *Browse Projects* or *Administer projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param expand Use [expand](#expansion) to include additional information in the response. This parameter accepts a comma-separated list. Expanded options include:   *  &#x60;description&#x60; Returns the project description.  *  &#x60;issueTypes&#x60; Returns all issue types associated with the project.  *  &#x60;lead&#x60; Returns information about the project lead.  *  &#x60;projectKeys&#x60; Returns all project keys associated with the project.
    * @param recent Returns the user&#39;s most recently accessed projects. You may specify the number of results to return up to a maximum of 20. If access is anonymous, then the recently accessed projects are based on the current HTTP session.
    * @param properties A list of project properties to return for the project. This parameter accepts a comma-separated list.
    * @return List&lt;Project&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<Project> getAllProjects(String expand, Integer recent, List<String> properties) throws IOException {
        HttpResponse response = getAllProjectsForHttpResponse(expand, recent, properties);
        TypeReference<List<Project>> typeRef = new TypeReference<List<Project>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get all projects
    * Returns all projects visible to the user. Deprecated, use [ Get projects paginated](#api-rest-api-3-project-search-get) that supports search and pagination.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** Projects are returned only where the user has *Browse Projects* or *Administer projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return List&lt;Project&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<Project> getAllProjects(Map<String, Object> params) throws IOException {
        HttpResponse response = getAllProjectsForHttpResponse(params);
        TypeReference<List<Project>> typeRef = new TypeReference<List<Project>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getAllProjectsForHttpResponse(String expand, Integer recent, List<String> properties) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project");
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
        }        if (recent != null) {
            String key = "recent";
            Object value = recent;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (properties != null) {
            String key = "properties";
            Object value = properties;
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

    public HttpResponse getAllProjectsForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project");

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
    * Get all statuses for project
    * Returns the valid statuses for a project. The statuses are grouped by issue type, as each project has a set of valid issue types and each issue type has a set of valid statuses.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Browse Projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the project is not found or the user does not have permission to view it.
    * @param projectIdOrKey The project ID or project key (case sensitive).
    * @return List&lt;IssueTypeWithStatus&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<IssueTypeWithStatus> getAllStatuses(String projectIdOrKey) throws IOException {
        HttpResponse response = getAllStatusesForHttpResponse(projectIdOrKey);
        TypeReference<List<IssueTypeWithStatus>> typeRef = new TypeReference<List<IssueTypeWithStatus>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get all statuses for project
    * Returns the valid statuses for a project. The statuses are grouped by issue type, as each project has a set of valid issue types and each issue type has a set of valid statuses.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Browse Projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the project is not found or the user does not have permission to view it.
    * @param projectIdOrKey The project ID or project key (case sensitive).
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return List&lt;IssueTypeWithStatus&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<IssueTypeWithStatus> getAllStatuses(String projectIdOrKey, Map<String, Object> params) throws IOException {
        HttpResponse response = getAllStatusesForHttpResponse(projectIdOrKey, params);
        TypeReference<List<IssueTypeWithStatus>> typeRef = new TypeReference<List<IssueTypeWithStatus>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getAllStatusesForHttpResponse(String projectIdOrKey) throws IOException {
        // verify the required parameter 'projectIdOrKey' is set
        if (projectIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectIdOrKey' when calling getAllStatuses");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectIdOrKey", projectIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectIdOrKey}/statuses");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getAllStatusesForHttpResponse(String projectIdOrKey, Map<String, Object> params) throws IOException {
        // verify the required parameter 'projectIdOrKey' is set
        if (projectIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectIdOrKey' when calling getAllStatuses");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectIdOrKey", projectIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectIdOrKey}/statuses");

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
    * Get project issue type hierarchy
    * Get the issue type hierarchy for a next-gen project.  The issue type hierarchy for a project consists of:   *  *Epic* at level 1 (optional).  *  One or more issue types at level 0 such as *Story*, *Task*, or *Bug*. Where the issue type *Epic* is defined, these issue types are used to break down the content of an epic.  *  *Subtask* at level -1 (optional). This issue type enables level 0 issue types to be broken down into components. Issues based on a level -1 issue type must have a parent issue.  **[Permissions](#permissions) required:** *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the project is not found or the user does not have the necessary permission.
    * @param projectId The ID of the project.
    * @return ProjectIssueTypeHierarchy
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ProjectIssueTypeHierarchy getHierarchy(Long projectId) throws IOException {
        HttpResponse response = getHierarchyForHttpResponse(projectId);
        TypeReference<ProjectIssueTypeHierarchy> typeRef = new TypeReference<ProjectIssueTypeHierarchy>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get project issue type hierarchy
    * Get the issue type hierarchy for a next-gen project.  The issue type hierarchy for a project consists of:   *  *Epic* at level 1 (optional).  *  One or more issue types at level 0 such as *Story*, *Task*, or *Bug*. Where the issue type *Epic* is defined, these issue types are used to break down the content of an epic.  *  *Subtask* at level -1 (optional). This issue type enables level 0 issue types to be broken down into components. Issues based on a level -1 issue type must have a parent issue.  **[Permissions](#permissions) required:** *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the project is not found or the user does not have the necessary permission.
    * @param projectId The ID of the project.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return ProjectIssueTypeHierarchy
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ProjectIssueTypeHierarchy getHierarchy(Long projectId, Map<String, Object> params) throws IOException {
        HttpResponse response = getHierarchyForHttpResponse(projectId, params);
        TypeReference<ProjectIssueTypeHierarchy> typeRef = new TypeReference<ProjectIssueTypeHierarchy>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getHierarchyForHttpResponse(Long projectId) throws IOException {
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectId' when calling getHierarchy");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectId", projectId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectId}/hierarchy");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getHierarchyForHttpResponse(Long projectId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectId' when calling getHierarchy");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectId", projectId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectId}/hierarchy");

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
    * Get project notification scheme
    * Gets a [notification scheme](https://confluence.atlassian.com/x/8YdKLg) associated with the project. See the [Get notification scheme](#api-rest-api-3-notificationscheme-id-get) resource for more information about notification schemes.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) or *Administer Projects* [project permission](https://confluence.atlassian.com/x/yodKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the project is not found or the user is not an administrator.
    * @param projectKeyOrId The project ID or project key (case sensitive).
    * @param expand Use [expand](#expansion) to include additional information in the response. This parameter accepts a comma-separated list. Expand options include:   *  &#x60;all&#x60; Returns all expandable information.  *  &#x60;field&#x60; Returns information about any custom fields assigned to receive an event.  *  &#x60;group&#x60; Returns information about any groups assigned to receive an event.  *  &#x60;notificationSchemeEvents&#x60; Returns a list of event associations. This list is returned for all expandable information.  *  &#x60;projectRole&#x60; Returns information about any project roles assigned to receive an event.  *  &#x60;user&#x60; Returns information about any users assigned to receive an event.
    * @return NotificationScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public NotificationScheme getNotificationSchemeForProject(String projectKeyOrId, String expand) throws IOException {
        HttpResponse response = getNotificationSchemeForProjectForHttpResponse(projectKeyOrId, expand);
        TypeReference<NotificationScheme> typeRef = new TypeReference<NotificationScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get project notification scheme
    * Gets a [notification scheme](https://confluence.atlassian.com/x/8YdKLg) associated with the project. See the [Get notification scheme](#api-rest-api-3-notificationscheme-id-get) resource for more information about notification schemes.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) or *Administer Projects* [project permission](https://confluence.atlassian.com/x/yodKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the project is not found or the user is not an administrator.
    * @param projectKeyOrId The project ID or project key (case sensitive).
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return NotificationScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public NotificationScheme getNotificationSchemeForProject(String projectKeyOrId, Map<String, Object> params) throws IOException {
        HttpResponse response = getNotificationSchemeForProjectForHttpResponse(projectKeyOrId, params);
        TypeReference<NotificationScheme> typeRef = new TypeReference<NotificationScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getNotificationSchemeForProjectForHttpResponse(String projectKeyOrId, String expand) throws IOException {
        // verify the required parameter 'projectKeyOrId' is set
        if (projectKeyOrId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectKeyOrId' when calling getNotificationSchemeForProject");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectKeyOrId", projectKeyOrId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectKeyOrId}/notificationscheme");
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

    public HttpResponse getNotificationSchemeForProjectForHttpResponse(String projectKeyOrId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'projectKeyOrId' is set
        if (projectKeyOrId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectKeyOrId' when calling getNotificationSchemeForProject");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectKeyOrId", projectKeyOrId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectKeyOrId}/notificationscheme");

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
    * Get project
    * Returns the [project details](https://confluence.atlassian.com/x/ahLpNw) for a project.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project.
    * <p><b>200</b> - Returned if successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the project is not found or the user does not have permission to view it.
    * @param projectIdOrKey The project ID or project key (case sensitive).
    * @param expand Use [expand](#expansion) to include additional information in the response. This parameter accepts a comma-separated list. Note that the project description, issue types, and project lead are included in all responses by default. Expand options include:   *  &#x60;description&#x60; The project description.  *  &#x60;issueTypes&#x60; The issue types associated with the project.  *  &#x60;lead&#x60; The project lead.  *  &#x60;projectKeys&#x60; All project keys associated with the project.  *  &#x60;issueTypeHierarchy&#x60; The project issue type hierarchy.
    * @param properties A list of project properties to return for the project. This parameter accepts a comma-separated list.
    * @return Project
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Project getProject(String projectIdOrKey, String expand, List<String> properties) throws IOException {
        HttpResponse response = getProjectForHttpResponse(projectIdOrKey, expand, properties);
        TypeReference<Project> typeRef = new TypeReference<Project>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get project
    * Returns the [project details](https://confluence.atlassian.com/x/ahLpNw) for a project.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project.
    * <p><b>200</b> - Returned if successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the project is not found or the user does not have permission to view it.
    * @param projectIdOrKey The project ID or project key (case sensitive).
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Project
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Project getProject(String projectIdOrKey, Map<String, Object> params) throws IOException {
        HttpResponse response = getProjectForHttpResponse(projectIdOrKey, params);
        TypeReference<Project> typeRef = new TypeReference<Project>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getProjectForHttpResponse(String projectIdOrKey, String expand, List<String> properties) throws IOException {
        // verify the required parameter 'projectIdOrKey' is set
        if (projectIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectIdOrKey' when calling getProject");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectIdOrKey", projectIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectIdOrKey}");
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
        }        if (properties != null) {
            String key = "properties";
            Object value = properties;
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

    public HttpResponse getProjectForHttpResponse(String projectIdOrKey, Map<String, Object> params) throws IOException {
        // verify the required parameter 'projectIdOrKey' is set
        if (projectIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectIdOrKey' when calling getProject");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectIdOrKey", projectIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectIdOrKey}");

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
    * Restore deleted project
    * Restores a project from the Jira recycle bin.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the project is not found or the user does not have the necessary permission.
    * @param projectIdOrKey The project ID or project key (case sensitive).
    * @return Project
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Project restore(String projectIdOrKey) throws IOException {
        HttpResponse response = restoreForHttpResponse(projectIdOrKey);
        TypeReference<Project> typeRef = new TypeReference<Project>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Restore deleted project
    * Restores a project from the Jira recycle bin.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the project is not found or the user does not have the necessary permission.
    * @param projectIdOrKey The project ID or project key (case sensitive).
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Project
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Project restore(String projectIdOrKey, Map<String, Object> params) throws IOException {
        HttpResponse response = restoreForHttpResponse(projectIdOrKey, params);
        TypeReference<Project> typeRef = new TypeReference<Project>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse restoreForHttpResponse(String projectIdOrKey) throws IOException {
        // verify the required parameter 'projectIdOrKey' is set
        if (projectIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectIdOrKey' when calling restore");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectIdOrKey", projectIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectIdOrKey}/restore");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = new EmptyContent();
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

    public HttpResponse restoreForHttpResponse(String projectIdOrKey, Map<String, Object> params) throws IOException {
        // verify the required parameter 'projectIdOrKey' is set
        if (projectIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectIdOrKey' when calling restore");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectIdOrKey", projectIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectIdOrKey}/restore");

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

        HttpContent content = new EmptyContent();
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


  /**
    * Get projects paginated
    * Returns a [paginated](#pagination) list of projects visible to the user.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** Projects are returned only where the user has one of:   *  *Browse Projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project.  *  *Administer Projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project.  *  *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if no projects matching the search criteria are found.
    * @param startAt The index of the first item to return in a page of results (page offset).
    * @param maxResults The maximum number of items to return per page.
    * @param orderBy [Order](#ordering) the results by a field.   *  &#x60;category&#x60; Sorts by project category. A complete list of category IDs is found using [Get all project categories](#api-rest-api-3-projectCategory-get).  *  &#x60;issueCount&#x60; Sorts by the total number of issues in each project.  *  &#x60;key&#x60; Sorts by project key.  *  &#x60;lastIssueUpdatedTime&#x60; Sorts by the last issue update time.  *  &#x60;name&#x60; Sorts by project name.  *  &#x60;owner&#x60; Sorts by project lead.  *  &#x60;archivedDate&#x60; EXPERIMENTAL. Sorts by project archived date.  *  &#x60;deletedDate&#x60; EXPERIMENTAL. Sorts by project deleted date.
    * @param query Filter the results using a literal string. Projects with a matching &#x60;key&#x60; or &#x60;name&#x60; are returned (case insensitive).
    * @param typeKey Orders results by the [project type](https://confluence.atlassian.com/x/GwiiLQ#Jiraapplicationsoverview-Productfeaturesandprojecttypes). This parameter accepts a comma-separated list. Valid values are &#x60;business&#x60;, &#x60;service_desk&#x60;, and &#x60;software&#x60;.
    * @param categoryId The ID of the project&#39;s category. A complete list of category IDs is found using the [Get all project categories](#api-rest-api-3-projectCategory-get) operation.
    * @param searchBy The searchBy parameter
    * @param action Filter results by projects for which the user can:   *  &#x60;view&#x60; the project, meaning that they have one of the following permissions:           *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project.      *  *Administer projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project.      *  *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).  *  &#x60;browse&#x60; the project, meaning that they have the *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project.  *  &#x60;edit&#x60; the project, meaning that they have one of the following permissions:           *  *Administer projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project.      *  *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * @param expand Use [expand](#expansion) to include additional information in the response. This parameter accepts a comma-separated list. Expanded options include:   *  &#x60;description&#x60; Returns the project description.  *  &#x60;projectKeys&#x60; Returns all project keys associated with a project.  *  &#x60;lead&#x60; Returns information about the project lead.  *  &#x60;issueTypes&#x60; Returns all issue types associated with the project.  *  &#x60;url&#x60; Returns the URL associated with the project.  *  &#x60;insight&#x60; EXPERIMENTAL. Returns the insight details of total issue count and last issue update time for the project.
    * @param status EXPERIMENTAL. Filter results by project status:   *  &#x60;live&#x60; Search live projects.  *  &#x60;archived&#x60; Search archived projects.  *  &#x60;deleted&#x60; Search deleted projects, those in the recycle bin.
    * @return PageBeanProject
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanProject searchProjects(Long startAt, Integer maxResults, String orderBy, String query, String typeKey, Long categoryId, String searchBy, String action, String expand, List<String> status) throws IOException {
        HttpResponse response = searchProjectsForHttpResponse(startAt, maxResults, orderBy, query, typeKey, categoryId, searchBy, action, expand, status);
        TypeReference<PageBeanProject> typeRef = new TypeReference<PageBeanProject>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get projects paginated
    * Returns a [paginated](#pagination) list of projects visible to the user.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** Projects are returned only where the user has one of:   *  *Browse Projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project.  *  *Administer Projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project.  *  *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if no projects matching the search criteria are found.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PageBeanProject
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanProject searchProjects(Map<String, Object> params) throws IOException {
        HttpResponse response = searchProjectsForHttpResponse(params);
        TypeReference<PageBeanProject> typeRef = new TypeReference<PageBeanProject>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse searchProjectsForHttpResponse(Long startAt, Integer maxResults, String orderBy, String query, String typeKey, Long categoryId, String searchBy, String action, String expand, List<String> status) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/search");
        if (startAt != null) {
            String key = "startAt";
            Object value = startAt;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (maxResults != null) {
            String key = "maxResults";
            Object value = maxResults;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (orderBy != null) {
            String key = "orderBy";
            Object value = orderBy;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (query != null) {
            String key = "query";
            Object value = query;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (typeKey != null) {
            String key = "typeKey";
            Object value = typeKey;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (categoryId != null) {
            String key = "categoryId";
            Object value = categoryId;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (searchBy != null) {
            String key = "searchBy";
            Object value = searchBy;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (action != null) {
            String key = "action";
            Object value = action;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (expand != null) {
            String key = "expand";
            Object value = expand;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (status != null) {
            String key = "status";
            Object value = status;
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

    public HttpResponse searchProjectsForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/search");

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
    * Update project
    * Updates the [project details](https://confluence.atlassian.com/x/ahLpNw) of a project.  All parameters are optional in the body of the request.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the project is updated.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if:   *  the user does not have the necessary permission to update project details.  *  the permission scheme is being changed and the Jira instance is Jira Core Free or Jira Software Free. Permission schemes cannot be changed on free plans.
    * <p><b>404</b> - Returned if the project is not found.
    * @param projectIdOrKey The project ID or project key (case sensitive).
    * @param projectInputBean The project details to be updated.
    * @param expand Use [expand](#expansion) to include additional information in the response. This parameter accepts a comma-separated list. Note that the project description, issue types, and project lead are included in all responses by default. Expand options include:   *  &#x60;description&#x60; The project description.  *  &#x60;issueTypes&#x60; The issue types associated with the project.  *  &#x60;lead&#x60; The project lead.  *  &#x60;projectKeys&#x60; All project keys associated with the project.
    * @return Project
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Project updateProject(String projectIdOrKey, ProjectInputBean projectInputBean, String expand) throws IOException {
        HttpResponse response = updateProjectForHttpResponse(projectIdOrKey, projectInputBean, expand);
        TypeReference<Project> typeRef = new TypeReference<Project>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Update project
    * Updates the [project details](https://confluence.atlassian.com/x/ahLpNw) of a project.  All parameters are optional in the body of the request.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the project is updated.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if:   *  the user does not have the necessary permission to update project details.  *  the permission scheme is being changed and the Jira instance is Jira Core Free or Jira Software Free. Permission schemes cannot be changed on free plans.
    * <p><b>404</b> - Returned if the project is not found.
    * @param projectIdOrKey The project ID or project key (case sensitive).
    * @param projectInputBean The project details to be updated.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Project
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Project updateProject(String projectIdOrKey, ProjectInputBean projectInputBean, Map<String, Object> params) throws IOException {
        HttpResponse response = updateProjectForHttpResponse(projectIdOrKey, projectInputBean, params);
        TypeReference<Project> typeRef = new TypeReference<Project>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse updateProjectForHttpResponse(String projectIdOrKey, ProjectInputBean projectInputBean, String expand) throws IOException {
        // verify the required parameter 'projectIdOrKey' is set
        if (projectIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectIdOrKey' when calling updateProject");
        }// verify the required parameter 'projectInputBean' is set
        if (projectInputBean == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectInputBean' when calling updateProject");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectIdOrKey", projectIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectIdOrKey}");
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

        HttpContent content = apiClient.new JacksonJsonHttpContent(projectInputBean);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse updateProjectForHttpResponse(String projectIdOrKey, java.io.InputStream projectInputBean, String expand, String mediaType) throws IOException {
          // verify the required parameter 'projectIdOrKey' is set
              if (projectIdOrKey == null) {
              throw new IllegalArgumentException("Missing the required parameter 'projectIdOrKey' when calling updateProject");
              }// verify the required parameter 'projectInputBean' is set
              if (projectInputBean == null) {
              throw new IllegalArgumentException("Missing the required parameter 'projectInputBean' when calling updateProject");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("projectIdOrKey", projectIdOrKey);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectIdOrKey}");
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

              HttpContent content = projectInputBean == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, projectInputBean);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse updateProjectForHttpResponse(String projectIdOrKey, ProjectInputBean projectInputBean, Map<String, Object> params) throws IOException {
        // verify the required parameter 'projectIdOrKey' is set
        if (projectIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectIdOrKey' when calling updateProject");
        }// verify the required parameter 'projectInputBean' is set
        if (projectInputBean == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectInputBean' when calling updateProject");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectIdOrKey", projectIdOrKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectIdOrKey}");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(projectInputBean);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }


  /**
    * Update project type
    * Deprecated, this feature is no longer supported and no alternatives are available, see [Convert project to a different template or type](https://confluence.atlassian.com/x/yEKeOQ). Updates a [project type](https://confluence.atlassian.com/x/GwiiLQ). The project type can be updated for classic projects only, project type cannot be updated for next-gen projects.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the project type is updated.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the project is not found or the user does not have permission to view it.
    * @param projectIdOrKey The project ID or project key (case sensitive).
    * @param newProjectTypeKey The key of the new project type.
    * @return Project
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Project updateProjectType(String projectIdOrKey, String newProjectTypeKey) throws IOException {
        HttpResponse response = updateProjectTypeForHttpResponse(projectIdOrKey, newProjectTypeKey);
        TypeReference<Project> typeRef = new TypeReference<Project>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Update project type
    * Deprecated, this feature is no longer supported and no alternatives are available, see [Convert project to a different template or type](https://confluence.atlassian.com/x/yEKeOQ). Updates a [project type](https://confluence.atlassian.com/x/GwiiLQ). The project type can be updated for classic projects only, project type cannot be updated for next-gen projects.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the project type is updated.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the project is not found or the user does not have permission to view it.
    * @param projectIdOrKey The project ID or project key (case sensitive).
    * @param newProjectTypeKey The key of the new project type.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Project
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Project updateProjectType(String projectIdOrKey, String newProjectTypeKey, Map<String, Object> params) throws IOException {
        HttpResponse response = updateProjectTypeForHttpResponse(projectIdOrKey, newProjectTypeKey, params);
        TypeReference<Project> typeRef = new TypeReference<Project>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse updateProjectTypeForHttpResponse(String projectIdOrKey, String newProjectTypeKey) throws IOException {
        // verify the required parameter 'projectIdOrKey' is set
        if (projectIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectIdOrKey' when calling updateProjectType");
        }// verify the required parameter 'newProjectTypeKey' is set
        if (newProjectTypeKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'newProjectTypeKey' when calling updateProjectType");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectIdOrKey", projectIdOrKey);
        uriVariables.put("newProjectTypeKey", newProjectTypeKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectIdOrKey}/type/{newProjectTypeKey}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = new EmptyContent();
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

    public HttpResponse updateProjectTypeForHttpResponse(String projectIdOrKey, String newProjectTypeKey, Map<String, Object> params) throws IOException {
        // verify the required parameter 'projectIdOrKey' is set
        if (projectIdOrKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectIdOrKey' when calling updateProjectType");
        }// verify the required parameter 'newProjectTypeKey' is set
        if (newProjectTypeKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'newProjectTypeKey' when calling updateProjectType");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("projectIdOrKey", projectIdOrKey);
        uriVariables.put("newProjectTypeKey", newProjectTypeKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/project/{projectIdOrKey}/type/{newProjectTypeKey}");

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

        HttpContent content = new EmptyContent();
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }


}
