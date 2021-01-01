package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.ProjectCategory;
import com.atlassian.jira.rest.client.model.UpdatedProjectCategory;

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
public class ProjectCategoriesApi {
    private ApiClient apiClient;

    public ProjectCategoriesApi() {
        this(new ApiClient());
    }

    public ProjectCategoriesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Create project category
    * Creates a project category.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>201</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  &#x60;name&#x60; is not provided or exceeds 255 characters.  *  &#x60;description&#x60; is not provided or exceeds 1000 characters.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>409</b> - Returned if the project category name is in use.
    * @param projectCategory The projectCategory parameter
    * @return ProjectCategory
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ProjectCategory createProjectCategory(ProjectCategory projectCategory) throws IOException {
        HttpResponse response = createProjectCategoryForHttpResponse(projectCategory);
        TypeReference<ProjectCategory> typeRef = new TypeReference<ProjectCategory>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Create project category
    * Creates a project category.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>201</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  &#x60;name&#x60; is not provided or exceeds 255 characters.  *  &#x60;description&#x60; is not provided or exceeds 1000 characters.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>409</b> - Returned if the project category name is in use.
    * @param projectCategory The projectCategory parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return ProjectCategory
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ProjectCategory createProjectCategory(ProjectCategory projectCategory, Map<String, Object> params) throws IOException {
        HttpResponse response = createProjectCategoryForHttpResponse(projectCategory, params);
        TypeReference<ProjectCategory> typeRef = new TypeReference<ProjectCategory>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse createProjectCategoryForHttpResponse(ProjectCategory projectCategory) throws IOException {
        // verify the required parameter 'projectCategory' is set
        if (projectCategory == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectCategory' when calling createProjectCategory");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/projectCategory");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(projectCategory);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse createProjectCategoryForHttpResponse(java.io.InputStream projectCategory, String mediaType) throws IOException {
          // verify the required parameter 'projectCategory' is set
              if (projectCategory == null) {
              throw new IllegalArgumentException("Missing the required parameter 'projectCategory' when calling createProjectCategory");
              }
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/projectCategory");

              String localVarUrl = uriBuilder.build().toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = projectCategory == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, projectCategory);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse createProjectCategoryForHttpResponse(ProjectCategory projectCategory, Map<String, Object> params) throws IOException {
        // verify the required parameter 'projectCategory' is set
        if (projectCategory == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectCategory' when calling createProjectCategory");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/projectCategory");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(projectCategory);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


  /**
    * Get all project categories
    * Returns all project categories.  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @return List&lt;ProjectCategory&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<ProjectCategory> getAllProjectCategories() throws IOException {
        HttpResponse response = getAllProjectCategoriesForHttpResponse();
        TypeReference<List<ProjectCategory>> typeRef = new TypeReference<List<ProjectCategory>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get all project categories
    * Returns all project categories.  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return List&lt;ProjectCategory&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<ProjectCategory> getAllProjectCategories(Map<String, Object> params) throws IOException {
        HttpResponse response = getAllProjectCategoriesForHttpResponse(params);
        TypeReference<List<ProjectCategory>> typeRef = new TypeReference<List<ProjectCategory>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getAllProjectCategoriesForHttpResponse() throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/projectCategory");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getAllProjectCategoriesForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/projectCategory");

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
    * Get project category by ID
    * Returns a project category.  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the project category is not found.
    * @param id The ID of the project category.
    * @return ProjectCategory
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ProjectCategory getProjectCategoryById(Long id) throws IOException {
        HttpResponse response = getProjectCategoryByIdForHttpResponse(id);
        TypeReference<ProjectCategory> typeRef = new TypeReference<ProjectCategory>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get project category by ID
    * Returns a project category.  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the project category is not found.
    * @param id The ID of the project category.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return ProjectCategory
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ProjectCategory getProjectCategoryById(Long id, Map<String, Object> params) throws IOException {
        HttpResponse response = getProjectCategoryByIdForHttpResponse(id, params);
        TypeReference<ProjectCategory> typeRef = new TypeReference<ProjectCategory>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getProjectCategoryByIdForHttpResponse(Long id) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling getProjectCategoryById");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/projectCategory/{id}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getProjectCategoryByIdForHttpResponse(Long id, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling getProjectCategoryById");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/projectCategory/{id}");

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
    * Delete project category
    * Deletes a project category.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the project category is not found.
    * @param id ID of the project category to delete.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void removeProjectCategory(Long id) throws IOException {
        removeProjectCategoryForHttpResponse(id);
    }

  /**
    * Delete project category
    * Deletes a project category.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the project category is not found.
    * @param id ID of the project category to delete.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void removeProjectCategory(Long id, Map<String, Object> params) throws IOException {
        removeProjectCategoryForHttpResponse(id, params);
    }

    public HttpResponse removeProjectCategoryForHttpResponse(Long id) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling removeProjectCategory");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/projectCategory/{id}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }

    public HttpResponse removeProjectCategoryForHttpResponse(Long id, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling removeProjectCategory");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/projectCategory/{id}");

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
    * Update project category
    * Updates a project category.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  &#x60;name&#x60; has been modified and exceeds 255 characters.  *  &#x60;description&#x60; has been modified and exceeds 1000 characters.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the project category is not found.
    * @param id The id parameter
    * @param projectCategory The projectCategory parameter
    * @return UpdatedProjectCategory
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public UpdatedProjectCategory updateProjectCategory(Long id, ProjectCategory projectCategory) throws IOException {
        HttpResponse response = updateProjectCategoryForHttpResponse(id, projectCategory);
        TypeReference<UpdatedProjectCategory> typeRef = new TypeReference<UpdatedProjectCategory>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Update project category
    * Updates a project category.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  &#x60;name&#x60; has been modified and exceeds 255 characters.  *  &#x60;description&#x60; has been modified and exceeds 1000 characters.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the project category is not found.
    * @param id The id parameter
    * @param projectCategory The projectCategory parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return UpdatedProjectCategory
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public UpdatedProjectCategory updateProjectCategory(Long id, ProjectCategory projectCategory, Map<String, Object> params) throws IOException {
        HttpResponse response = updateProjectCategoryForHttpResponse(id, projectCategory, params);
        TypeReference<UpdatedProjectCategory> typeRef = new TypeReference<UpdatedProjectCategory>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse updateProjectCategoryForHttpResponse(Long id, ProjectCategory projectCategory) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling updateProjectCategory");
        }// verify the required parameter 'projectCategory' is set
        if (projectCategory == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectCategory' when calling updateProjectCategory");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/projectCategory/{id}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(projectCategory);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse updateProjectCategoryForHttpResponse(Long id, java.io.InputStream projectCategory, String mediaType) throws IOException {
          // verify the required parameter 'id' is set
              if (id == null) {
              throw new IllegalArgumentException("Missing the required parameter 'id' when calling updateProjectCategory");
              }// verify the required parameter 'projectCategory' is set
              if (projectCategory == null) {
              throw new IllegalArgumentException("Missing the required parameter 'projectCategory' when calling updateProjectCategory");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("id", id);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/projectCategory/{id}");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = projectCategory == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, projectCategory);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse updateProjectCategoryForHttpResponse(Long id, ProjectCategory projectCategory, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling updateProjectCategory");
        }// verify the required parameter 'projectCategory' is set
        if (projectCategory == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectCategory' when calling updateProjectCategory");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/projectCategory/{id}");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(projectCategory);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }


}
