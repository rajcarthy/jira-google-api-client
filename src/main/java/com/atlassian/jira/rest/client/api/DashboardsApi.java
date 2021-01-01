package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.Dashboard;
import com.atlassian.jira.rest.client.model.DashboardDetails;
import com.atlassian.jira.rest.client.model.EntityProperty;
import com.atlassian.jira.rest.client.model.ErrorCollection;
import com.atlassian.jira.rest.client.model.PageBeanDashboard;
import com.atlassian.jira.rest.client.model.PageOfDashboards;
import com.atlassian.jira.rest.client.model.PropertyKeys;

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
public class DashboardsApi {
    private ApiClient apiClient;

    public DashboardsApi() {
        this(new ApiClient());
    }

    public DashboardsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Copy dashboard
    * Copies a dashboard. Any values provided in the &#x60;dashboard&#x60; parameter replace those in the copied dashboard.  **[Permissions](#permissions) required:** None  The dashboard to be copied must be owned by or shared with the user.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the dashboard is not found or the dashboard is not owned by or shared with the user.
    * @param id The id parameter
    * @param dashboardDetails Dashboard details.
    * @return Dashboard
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Dashboard copyDashboard(String id, DashboardDetails dashboardDetails) throws IOException {
        HttpResponse response = copyDashboardForHttpResponse(id, dashboardDetails);
        TypeReference<Dashboard> typeRef = new TypeReference<Dashboard>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Copy dashboard
    * Copies a dashboard. Any values provided in the &#x60;dashboard&#x60; parameter replace those in the copied dashboard.  **[Permissions](#permissions) required:** None  The dashboard to be copied must be owned by or shared with the user.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the dashboard is not found or the dashboard is not owned by or shared with the user.
    * @param id The id parameter
    * @param dashboardDetails Dashboard details.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Dashboard
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Dashboard copyDashboard(String id, DashboardDetails dashboardDetails, Map<String, Object> params) throws IOException {
        HttpResponse response = copyDashboardForHttpResponse(id, dashboardDetails, params);
        TypeReference<Dashboard> typeRef = new TypeReference<Dashboard>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse copyDashboardForHttpResponse(String id, DashboardDetails dashboardDetails) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling copyDashboard");
        }// verify the required parameter 'dashboardDetails' is set
        if (dashboardDetails == null) {
            throw new IllegalArgumentException("Missing the required parameter 'dashboardDetails' when calling copyDashboard");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/dashboard/{id}/copy");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(dashboardDetails);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse copyDashboardForHttpResponse(String id, java.io.InputStream dashboardDetails, String mediaType) throws IOException {
          // verify the required parameter 'id' is set
              if (id == null) {
              throw new IllegalArgumentException("Missing the required parameter 'id' when calling copyDashboard");
              }// verify the required parameter 'dashboardDetails' is set
              if (dashboardDetails == null) {
              throw new IllegalArgumentException("Missing the required parameter 'dashboardDetails' when calling copyDashboard");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("id", id);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/dashboard/{id}/copy");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = dashboardDetails == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, dashboardDetails);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse copyDashboardForHttpResponse(String id, DashboardDetails dashboardDetails, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling copyDashboard");
        }// verify the required parameter 'dashboardDetails' is set
        if (dashboardDetails == null) {
            throw new IllegalArgumentException("Missing the required parameter 'dashboardDetails' when calling copyDashboard");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/dashboard/{id}/copy");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(dashboardDetails);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


  /**
    * Create dashboard
    * Creates a dashboard.  **[Permissions](#permissions) required:** None.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param dashboardDetails Dashboard details.
    * @return Dashboard
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Dashboard createDashboard(DashboardDetails dashboardDetails) throws IOException {
        HttpResponse response = createDashboardForHttpResponse(dashboardDetails);
        TypeReference<Dashboard> typeRef = new TypeReference<Dashboard>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Create dashboard
    * Creates a dashboard.  **[Permissions](#permissions) required:** None.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param dashboardDetails Dashboard details.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Dashboard
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Dashboard createDashboard(DashboardDetails dashboardDetails, Map<String, Object> params) throws IOException {
        HttpResponse response = createDashboardForHttpResponse(dashboardDetails, params);
        TypeReference<Dashboard> typeRef = new TypeReference<Dashboard>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse createDashboardForHttpResponse(DashboardDetails dashboardDetails) throws IOException {
        // verify the required parameter 'dashboardDetails' is set
        if (dashboardDetails == null) {
            throw new IllegalArgumentException("Missing the required parameter 'dashboardDetails' when calling createDashboard");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/dashboard");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(dashboardDetails);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse createDashboardForHttpResponse(java.io.InputStream dashboardDetails, String mediaType) throws IOException {
          // verify the required parameter 'dashboardDetails' is set
              if (dashboardDetails == null) {
              throw new IllegalArgumentException("Missing the required parameter 'dashboardDetails' when calling createDashboard");
              }
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/dashboard");

              String localVarUrl = uriBuilder.build().toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = dashboardDetails == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, dashboardDetails);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse createDashboardForHttpResponse(DashboardDetails dashboardDetails, Map<String, Object> params) throws IOException {
        // verify the required parameter 'dashboardDetails' is set
        if (dashboardDetails == null) {
            throw new IllegalArgumentException("Missing the required parameter 'dashboardDetails' when calling createDashboard");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/dashboard");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(dashboardDetails);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


  /**
    * Delete dashboard
    * Deletes a dashboard.  **[Permissions](#permissions) required:** None  The dashboard to be deleted must be owned by the user.
    * <p><b>204</b> - Returned if the dashboard is deleted.
    * <p><b>400</b> - 400 response
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param id The ID of the dashboard.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteDashboard(String id) throws IOException {
        deleteDashboardForHttpResponse(id);
    }

  /**
    * Delete dashboard
    * Deletes a dashboard.  **[Permissions](#permissions) required:** None  The dashboard to be deleted must be owned by the user.
    * <p><b>204</b> - Returned if the dashboard is deleted.
    * <p><b>400</b> - 400 response
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param id The ID of the dashboard.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteDashboard(String id, Map<String, Object> params) throws IOException {
        deleteDashboardForHttpResponse(id, params);
    }

    public HttpResponse deleteDashboardForHttpResponse(String id) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling deleteDashboard");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/dashboard/{id}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }

    public HttpResponse deleteDashboardForHttpResponse(String id, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling deleteDashboard");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/dashboard/{id}");

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
    * Delete dashboard item property
    * Deletes a dashboard item property.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** The user must be the owner of the dashboard. Note, users with the *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) are considered owners of the System dashboard.
    * <p><b>204</b> - Returned if the dashboard item property is deleted.
    * <p><b>400</b> - Returned if the dashboard or dashboard item ID is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user is not the owner of the dashboard.
    * <p><b>404</b> - Returned if the dashboard item is not found or the dashboard is not shared with the user.
    * @param dashboardId The ID of the dashboard.
    * @param itemId The ID of the dashboard item.
    * @param propertyKey The key of the dashboard item property.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteDashboardItemProperty(String dashboardId, String itemId, String propertyKey) throws IOException {
        deleteDashboardItemPropertyForHttpResponse(dashboardId, itemId, propertyKey);
    }

  /**
    * Delete dashboard item property
    * Deletes a dashboard item property.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** The user must be the owner of the dashboard. Note, users with the *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) are considered owners of the System dashboard.
    * <p><b>204</b> - Returned if the dashboard item property is deleted.
    * <p><b>400</b> - Returned if the dashboard or dashboard item ID is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user is not the owner of the dashboard.
    * <p><b>404</b> - Returned if the dashboard item is not found or the dashboard is not shared with the user.
    * @param dashboardId The ID of the dashboard.
    * @param itemId The ID of the dashboard item.
    * @param propertyKey The key of the dashboard item property.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteDashboardItemProperty(String dashboardId, String itemId, String propertyKey, Map<String, Object> params) throws IOException {
        deleteDashboardItemPropertyForHttpResponse(dashboardId, itemId, propertyKey, params);
    }

    public HttpResponse deleteDashboardItemPropertyForHttpResponse(String dashboardId, String itemId, String propertyKey) throws IOException {
        // verify the required parameter 'dashboardId' is set
        if (dashboardId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'dashboardId' when calling deleteDashboardItemProperty");
        }// verify the required parameter 'itemId' is set
        if (itemId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'itemId' when calling deleteDashboardItemProperty");
        }// verify the required parameter 'propertyKey' is set
        if (propertyKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'propertyKey' when calling deleteDashboardItemProperty");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("dashboardId", dashboardId);
        uriVariables.put("itemId", itemId);
        uriVariables.put("propertyKey", propertyKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/dashboard/{dashboardId}/items/{itemId}/properties/{propertyKey}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }

    public HttpResponse deleteDashboardItemPropertyForHttpResponse(String dashboardId, String itemId, String propertyKey, Map<String, Object> params) throws IOException {
        // verify the required parameter 'dashboardId' is set
        if (dashboardId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'dashboardId' when calling deleteDashboardItemProperty");
        }// verify the required parameter 'itemId' is set
        if (itemId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'itemId' when calling deleteDashboardItemProperty");
        }// verify the required parameter 'propertyKey' is set
        if (propertyKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'propertyKey' when calling deleteDashboardItemProperty");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("dashboardId", dashboardId);
        uriVariables.put("itemId", itemId);
        uriVariables.put("propertyKey", propertyKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/dashboard/{dashboardId}/items/{itemId}/properties/{propertyKey}");

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
    * Get all dashboards
    * Returns a list of dashboards owned by or shared with the user. The list may be filtered to include only favorite or owned dashboards.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param filter The filter applied to the list of dashboards. Valid values are:   *  &#x60;favourite&#x60; Returns dashboards the user has marked as favorite.  *  &#x60;my&#x60; Returns dashboards owned by the user.
    * @param startAt The index of the first item to return in a page of results (page offset).
    * @param maxResults The maximum number of items to return per page.
    * @return PageOfDashboards
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageOfDashboards getAllDashboards(String filter, Integer startAt, Integer maxResults) throws IOException {
        HttpResponse response = getAllDashboardsForHttpResponse(filter, startAt, maxResults);
        TypeReference<PageOfDashboards> typeRef = new TypeReference<PageOfDashboards>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get all dashboards
    * Returns a list of dashboards owned by or shared with the user. The list may be filtered to include only favorite or owned dashboards.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PageOfDashboards
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageOfDashboards getAllDashboards(Map<String, Object> params) throws IOException {
        HttpResponse response = getAllDashboardsForHttpResponse(params);
        TypeReference<PageOfDashboards> typeRef = new TypeReference<PageOfDashboards>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getAllDashboardsForHttpResponse(String filter, Integer startAt, Integer maxResults) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/dashboard");
        if (filter != null) {
            String key = "filter";
            Object value = filter;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (startAt != null) {
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
        }

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getAllDashboardsForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/dashboard");

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
    * Get dashboard
    * Returns a dashboard.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.  However, to get a dashboard, the dashboard must be shared with the user or the user must own it. Note, users with the *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) are considered owners of the System dashboard. The System dashboard is considered to be shared with all other users.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - 400 response
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the dashboard is not found or the dashboard is not owned by or shared with the user.
    * @param id The ID of the dashboard.
    * @return Dashboard
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Dashboard getDashboard(String id) throws IOException {
        HttpResponse response = getDashboardForHttpResponse(id);
        TypeReference<Dashboard> typeRef = new TypeReference<Dashboard>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get dashboard
    * Returns a dashboard.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.  However, to get a dashboard, the dashboard must be shared with the user or the user must own it. Note, users with the *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) are considered owners of the System dashboard. The System dashboard is considered to be shared with all other users.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - 400 response
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the dashboard is not found or the dashboard is not owned by or shared with the user.
    * @param id The ID of the dashboard.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Dashboard
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Dashboard getDashboard(String id, Map<String, Object> params) throws IOException {
        HttpResponse response = getDashboardForHttpResponse(id, params);
        TypeReference<Dashboard> typeRef = new TypeReference<Dashboard>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getDashboardForHttpResponse(String id) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling getDashboard");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/dashboard/{id}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getDashboardForHttpResponse(String id, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling getDashboard");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/dashboard/{id}");

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
    * Get dashboard item property
    * Returns the key and value of a dashboard item property.  A dashboard item enables an app to add user-specific information to a user dashboard. Dashboard items are exposed to users as gadgets that users can add to their dashboards. For more information on how users do this, see [Adding and customizing gadgets](https://confluence.atlassian.com/x/7AeiLQ).  When an app creates a dashboard item it registers a callback to receive the dashboard item ID. The callback fires whenever the item is rendered or, where the item is configurable, the user edits the item. The app then uses this resource to store the item&#39;s content or configuration details. For more information on working with dashboard items, see [ Building a dashboard item for a JIRA Connect add-on](https://developer.atlassian.com/server/jira/platform/guide-building-a-dashboard-item-for-a-jira-connect-add-on-33746254/) and the [Dashboard Item](https://developer.atlassian.com/cloud/jira/platform/modules/dashboard-item/) documentation.  There is no resource to set or get dashboard items.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** The user must be the owner of the dashboard or be shared the dashboard. Note, users with the *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) are considered owners of the System dashboard. The System dashboard is considered to be shared with all other users.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the dashboard, the dashboard item, or dashboard item property is not found, or the dashboard is not owned by or shared with the user.
    * @param dashboardId The ID of the dashboard.
    * @param itemId The ID of the dashboard item.
    * @param propertyKey The key of the dashboard item property.
    * @return EntityProperty
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public EntityProperty getDashboardItemProperty(String dashboardId, String itemId, String propertyKey) throws IOException {
        HttpResponse response = getDashboardItemPropertyForHttpResponse(dashboardId, itemId, propertyKey);
        TypeReference<EntityProperty> typeRef = new TypeReference<EntityProperty>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get dashboard item property
    * Returns the key and value of a dashboard item property.  A dashboard item enables an app to add user-specific information to a user dashboard. Dashboard items are exposed to users as gadgets that users can add to their dashboards. For more information on how users do this, see [Adding and customizing gadgets](https://confluence.atlassian.com/x/7AeiLQ).  When an app creates a dashboard item it registers a callback to receive the dashboard item ID. The callback fires whenever the item is rendered or, where the item is configurable, the user edits the item. The app then uses this resource to store the item&#39;s content or configuration details. For more information on working with dashboard items, see [ Building a dashboard item for a JIRA Connect add-on](https://developer.atlassian.com/server/jira/platform/guide-building-a-dashboard-item-for-a-jira-connect-add-on-33746254/) and the [Dashboard Item](https://developer.atlassian.com/cloud/jira/platform/modules/dashboard-item/) documentation.  There is no resource to set or get dashboard items.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** The user must be the owner of the dashboard or be shared the dashboard. Note, users with the *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) are considered owners of the System dashboard. The System dashboard is considered to be shared with all other users.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the dashboard, the dashboard item, or dashboard item property is not found, or the dashboard is not owned by or shared with the user.
    * @param dashboardId The ID of the dashboard.
    * @param itemId The ID of the dashboard item.
    * @param propertyKey The key of the dashboard item property.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return EntityProperty
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public EntityProperty getDashboardItemProperty(String dashboardId, String itemId, String propertyKey, Map<String, Object> params) throws IOException {
        HttpResponse response = getDashboardItemPropertyForHttpResponse(dashboardId, itemId, propertyKey, params);
        TypeReference<EntityProperty> typeRef = new TypeReference<EntityProperty>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getDashboardItemPropertyForHttpResponse(String dashboardId, String itemId, String propertyKey) throws IOException {
        // verify the required parameter 'dashboardId' is set
        if (dashboardId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'dashboardId' when calling getDashboardItemProperty");
        }// verify the required parameter 'itemId' is set
        if (itemId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'itemId' when calling getDashboardItemProperty");
        }// verify the required parameter 'propertyKey' is set
        if (propertyKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'propertyKey' when calling getDashboardItemProperty");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("dashboardId", dashboardId);
        uriVariables.put("itemId", itemId);
        uriVariables.put("propertyKey", propertyKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/dashboard/{dashboardId}/items/{itemId}/properties/{propertyKey}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getDashboardItemPropertyForHttpResponse(String dashboardId, String itemId, String propertyKey, Map<String, Object> params) throws IOException {
        // verify the required parameter 'dashboardId' is set
        if (dashboardId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'dashboardId' when calling getDashboardItemProperty");
        }// verify the required parameter 'itemId' is set
        if (itemId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'itemId' when calling getDashboardItemProperty");
        }// verify the required parameter 'propertyKey' is set
        if (propertyKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'propertyKey' when calling getDashboardItemProperty");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("dashboardId", dashboardId);
        uriVariables.put("itemId", itemId);
        uriVariables.put("propertyKey", propertyKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/dashboard/{dashboardId}/items/{itemId}/properties/{propertyKey}");

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
    * Get dashboard item property keys
    * Returns the keys of all properties for a dashboard item.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** The user must be the owner of the dashboard or be shared the dashboard. Note, users with the *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) are considered owners of the System dashboard. The System dashboard is considered to be shared with all other users.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the dashboard or dashboard item is not found, or the dashboard is not owned by or shared with the user.
    * @param dashboardId The ID of the dashboard.
    * @param itemId The ID of the dashboard item.
    * @return PropertyKeys
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PropertyKeys getDashboardItemPropertyKeys(String dashboardId, String itemId) throws IOException {
        HttpResponse response = getDashboardItemPropertyKeysForHttpResponse(dashboardId, itemId);
        TypeReference<PropertyKeys> typeRef = new TypeReference<PropertyKeys>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get dashboard item property keys
    * Returns the keys of all properties for a dashboard item.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** The user must be the owner of the dashboard or be shared the dashboard. Note, users with the *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) are considered owners of the System dashboard. The System dashboard is considered to be shared with all other users.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the dashboard or dashboard item is not found, or the dashboard is not owned by or shared with the user.
    * @param dashboardId The ID of the dashboard.
    * @param itemId The ID of the dashboard item.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PropertyKeys
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PropertyKeys getDashboardItemPropertyKeys(String dashboardId, String itemId, Map<String, Object> params) throws IOException {
        HttpResponse response = getDashboardItemPropertyKeysForHttpResponse(dashboardId, itemId, params);
        TypeReference<PropertyKeys> typeRef = new TypeReference<PropertyKeys>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getDashboardItemPropertyKeysForHttpResponse(String dashboardId, String itemId) throws IOException {
        // verify the required parameter 'dashboardId' is set
        if (dashboardId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'dashboardId' when calling getDashboardItemPropertyKeys");
        }// verify the required parameter 'itemId' is set
        if (itemId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'itemId' when calling getDashboardItemPropertyKeys");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("dashboardId", dashboardId);
        uriVariables.put("itemId", itemId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/dashboard/{dashboardId}/items/{itemId}/properties");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getDashboardItemPropertyKeysForHttpResponse(String dashboardId, String itemId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'dashboardId' is set
        if (dashboardId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'dashboardId' when calling getDashboardItemPropertyKeys");
        }// verify the required parameter 'itemId' is set
        if (itemId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'itemId' when calling getDashboardItemPropertyKeys");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("dashboardId", dashboardId);
        uriVariables.put("itemId", itemId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/dashboard/{dashboardId}/items/{itemId}/properties");

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
    * Search for dashboards
    * Returns a [paginated](#pagination) list of dashboards. This operation is similar to [Get dashboards](#api-rest-api-3-dashboard-get) except that the results can be refined to include dashboards that have specific attributes. For example, dashboards with a particular name. When multiple attributes are specified only filters matching all attributes are returned.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** The following dashboards that match the query parameters are returned:   *  Dashboards owned by the user. Not returned for anonymous users.  *  Dashboards shared with a group that the user is a member of. Not returned for anonymous users.  *  Dashboards shared with a private project that the user can browse. Not returned for anonymous users.  *  Dashboards shared with a public project.  *  Dashboards shared with the public.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  &#x60;orderBy&#x60; is invalid.  *  &#x60;expand&#x60; includes an invalid value.  *  &#x60;accountId&#x60; and &#x60;owner&#x60; are provided.
    * <p><b>401</b> - 401 response
    * @param dashboardName String used to perform a case-insensitive partial match with &#x60;name&#x60;.
    * @param accountId User account ID used to return dashboards with the matching &#x60;owner.accountId&#x60;. This parameter cannot be used with the &#x60;owner&#x60; parameter.
    * @param owner This parameter is deprecated because of privacy changes. Use &#x60;accountId&#x60; instead. See the [migration guide](https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/) for details. User name used to return dashboards with the matching &#x60;owner.name&#x60;. This parameter cannot be used with the &#x60;accountId&#x60; parameter.
    * @param groupname Group name used to returns dashboards that are shared with a group that matches &#x60;sharePermissions.group.name&#x60;.
    * @param projectId Project ID used to returns dashboards that are shared with a project that matches &#x60;sharePermissions.project.id&#x60;.
    * @param orderBy [Order](#ordering) the results by a field:   *  &#x60;description&#x60; Sorts by dashboard description. Note that this sort works independently of whether the expand to display the description field is in use.  *  &#x60;favourite_count&#x60; Sorts by dashboard popularity.  *  &#x60;id&#x60; Sorts by dashboard ID.  *  &#x60;is_favourite&#x60; Sorts by whether the dashboard is marked as a favorite.  *  &#x60;name&#x60; Sorts by dashboard name.  *  &#x60;owner&#x60; Sorts by dashboard owner name.
    * @param startAt The index of the first item to return in a page of results (page offset).
    * @param maxResults The maximum number of items to return per page.
    * @param expand Use [expand](#expansion) to include additional information about dashboard in the response. This parameter accepts a comma-separated list. Expand options include:   *  &#x60;description&#x60; Returns the description of the dashboard.  *  &#x60;owner&#x60; Returns the owner of the dashboard.  *  &#x60;viewUrl&#x60; Returns the URL that is used to view the dashboard.  *  &#x60;favourite&#x60; Returns &#x60;isFavourite&#x60;, an indicator of whether the user has set the dashboard as a favorite.  *  &#x60;favouritedCount&#x60; Returns &#x60;popularity&#x60;, a count of how many users have set this dashboard as a favorite.  *  &#x60;sharePermissions&#x60; Returns details of the share permissions defined for the dashboard.
    * @return PageBeanDashboard
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanDashboard getDashboardsPaginated(String dashboardName, String accountId, String owner, String groupname, Long projectId, String orderBy, Long startAt, Integer maxResults, String expand) throws IOException {
        HttpResponse response = getDashboardsPaginatedForHttpResponse(dashboardName, accountId, owner, groupname, projectId, orderBy, startAt, maxResults, expand);
        TypeReference<PageBeanDashboard> typeRef = new TypeReference<PageBeanDashboard>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Search for dashboards
    * Returns a [paginated](#pagination) list of dashboards. This operation is similar to [Get dashboards](#api-rest-api-3-dashboard-get) except that the results can be refined to include dashboards that have specific attributes. For example, dashboards with a particular name. When multiple attributes are specified only filters matching all attributes are returned.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** The following dashboards that match the query parameters are returned:   *  Dashboards owned by the user. Not returned for anonymous users.  *  Dashboards shared with a group that the user is a member of. Not returned for anonymous users.  *  Dashboards shared with a private project that the user can browse. Not returned for anonymous users.  *  Dashboards shared with a public project.  *  Dashboards shared with the public.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  &#x60;orderBy&#x60; is invalid.  *  &#x60;expand&#x60; includes an invalid value.  *  &#x60;accountId&#x60; and &#x60;owner&#x60; are provided.
    * <p><b>401</b> - 401 response
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PageBeanDashboard
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanDashboard getDashboardsPaginated(Map<String, Object> params) throws IOException {
        HttpResponse response = getDashboardsPaginatedForHttpResponse(params);
        TypeReference<PageBeanDashboard> typeRef = new TypeReference<PageBeanDashboard>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getDashboardsPaginatedForHttpResponse(String dashboardName, String accountId, String owner, String groupname, Long projectId, String orderBy, Long startAt, Integer maxResults, String expand) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/dashboard/search");
        if (dashboardName != null) {
            String key = "dashboardName";
            Object value = dashboardName;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (accountId != null) {
            String key = "accountId";
            Object value = accountId;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (owner != null) {
            String key = "owner";
            Object value = owner;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (groupname != null) {
            String key = "groupname";
            Object value = groupname;
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
        }        if (startAt != null) {
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
        }

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getDashboardsPaginatedForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/dashboard/search");

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
    * Set dashboard item property
    * Sets the value of a dashboard item property. Use this resource in apps to store custom data against a dashboard item.  A dashboard item enables an app to add user-specific information to a user dashboard. Dashboard items are exposed to users as gadgets that users can add to their dashboards. For more information on how users do this, see [Adding and customizing gadgets](https://confluence.atlassian.com/x/7AeiLQ).  When an app creates a dashboard item it registers a callback to receive the dashboard item ID. The callback fires whenever the item is rendered or, where the item is configurable, the user edits the item. The app then uses this resource to store the item&#39;s content or configuration details. For more information on working with dashboard items, see [ Building a dashboard item for a JIRA Connect add-on](https://developer.atlassian.com/server/jira/platform/guide-building-a-dashboard-item-for-a-jira-connect-add-on-33746254/) and the [Dashboard Item](https://developer.atlassian.com/cloud/jira/platform/modules/dashboard-item/) documentation.  There is no resource to set or get dashboard items.  The value of the request body must be a [valid](http://tools.ietf.org/html/rfc4627), non-empty JSON blob. The maximum length is 32768 characters.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** The user must be the owner of the dashboard. Note, users with the *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) are considered owners of the System dashboard.
    * <p><b>200</b> - Returned if the dashboard item property is updated.
    * <p><b>201</b> - Returned if the dashboard item property is created.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user is not the owner of the dashboard.
    * <p><b>404</b> - Returned if the dashboard item is not found or the dashboard is not shared with the user.
    * @param dashboardId The ID of the dashboard.
    * @param itemId The ID of the dashboard item.
    * @param propertyKey The key of the dashboard item property. The maximum length is 255 characters.
    * @param body The body parameter
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object setDashboardItemProperty(String dashboardId, String itemId, String propertyKey, Object body) throws IOException {
        HttpResponse response = setDashboardItemPropertyForHttpResponse(dashboardId, itemId, propertyKey, body);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Set dashboard item property
    * Sets the value of a dashboard item property. Use this resource in apps to store custom data against a dashboard item.  A dashboard item enables an app to add user-specific information to a user dashboard. Dashboard items are exposed to users as gadgets that users can add to their dashboards. For more information on how users do this, see [Adding and customizing gadgets](https://confluence.atlassian.com/x/7AeiLQ).  When an app creates a dashboard item it registers a callback to receive the dashboard item ID. The callback fires whenever the item is rendered or, where the item is configurable, the user edits the item. The app then uses this resource to store the item&#39;s content or configuration details. For more information on working with dashboard items, see [ Building a dashboard item for a JIRA Connect add-on](https://developer.atlassian.com/server/jira/platform/guide-building-a-dashboard-item-for-a-jira-connect-add-on-33746254/) and the [Dashboard Item](https://developer.atlassian.com/cloud/jira/platform/modules/dashboard-item/) documentation.  There is no resource to set or get dashboard items.  The value of the request body must be a [valid](http://tools.ietf.org/html/rfc4627), non-empty JSON blob. The maximum length is 32768 characters.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** The user must be the owner of the dashboard. Note, users with the *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) are considered owners of the System dashboard.
    * <p><b>200</b> - Returned if the dashboard item property is updated.
    * <p><b>201</b> - Returned if the dashboard item property is created.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user is not the owner of the dashboard.
    * <p><b>404</b> - Returned if the dashboard item is not found or the dashboard is not shared with the user.
    * @param dashboardId The ID of the dashboard.
    * @param itemId The ID of the dashboard item.
    * @param propertyKey The key of the dashboard item property. The maximum length is 255 characters.
    * @param body The body parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object setDashboardItemProperty(String dashboardId, String itemId, String propertyKey, Object body, Map<String, Object> params) throws IOException {
        HttpResponse response = setDashboardItemPropertyForHttpResponse(dashboardId, itemId, propertyKey, body, params);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse setDashboardItemPropertyForHttpResponse(String dashboardId, String itemId, String propertyKey, Object body) throws IOException {
        // verify the required parameter 'dashboardId' is set
        if (dashboardId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'dashboardId' when calling setDashboardItemProperty");
        }// verify the required parameter 'itemId' is set
        if (itemId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'itemId' when calling setDashboardItemProperty");
        }// verify the required parameter 'propertyKey' is set
        if (propertyKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'propertyKey' when calling setDashboardItemProperty");
        }// verify the required parameter 'body' is set
        if (body == null) {
            throw new IllegalArgumentException("Missing the required parameter 'body' when calling setDashboardItemProperty");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("dashboardId", dashboardId);
        uriVariables.put("itemId", itemId);
        uriVariables.put("propertyKey", propertyKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/dashboard/{dashboardId}/items/{itemId}/properties/{propertyKey}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(body);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse setDashboardItemPropertyForHttpResponse(String dashboardId, String itemId, String propertyKey, java.io.InputStream body, String mediaType) throws IOException {
          // verify the required parameter 'dashboardId' is set
              if (dashboardId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'dashboardId' when calling setDashboardItemProperty");
              }// verify the required parameter 'itemId' is set
              if (itemId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'itemId' when calling setDashboardItemProperty");
              }// verify the required parameter 'propertyKey' is set
              if (propertyKey == null) {
              throw new IllegalArgumentException("Missing the required parameter 'propertyKey' when calling setDashboardItemProperty");
              }// verify the required parameter 'body' is set
              if (body == null) {
              throw new IllegalArgumentException("Missing the required parameter 'body' when calling setDashboardItemProperty");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("dashboardId", dashboardId);
                      uriVariables.put("itemId", itemId);
                      uriVariables.put("propertyKey", propertyKey);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/dashboard/{dashboardId}/items/{itemId}/properties/{propertyKey}");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = body == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, body);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse setDashboardItemPropertyForHttpResponse(String dashboardId, String itemId, String propertyKey, Object body, Map<String, Object> params) throws IOException {
        // verify the required parameter 'dashboardId' is set
        if (dashboardId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'dashboardId' when calling setDashboardItemProperty");
        }// verify the required parameter 'itemId' is set
        if (itemId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'itemId' when calling setDashboardItemProperty");
        }// verify the required parameter 'propertyKey' is set
        if (propertyKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'propertyKey' when calling setDashboardItemProperty");
        }// verify the required parameter 'body' is set
        if (body == null) {
            throw new IllegalArgumentException("Missing the required parameter 'body' when calling setDashboardItemProperty");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("dashboardId", dashboardId);
        uriVariables.put("itemId", itemId);
        uriVariables.put("propertyKey", propertyKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/dashboard/{dashboardId}/items/{itemId}/properties/{propertyKey}");

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
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }


  /**
    * Update dashboard
    * Updates a dashboard, replacing all the dashboard details with those provided.  **[Permissions](#permissions) required:** None  The dashboard to be updated must be owned by the user.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the dashboard is not found or the dashboard is not owned by the user.
    * @param id The ID of the dashboard to update.
    * @param dashboardDetails Replacement dashboard details.
    * @return Dashboard
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Dashboard updateDashboard(String id, DashboardDetails dashboardDetails) throws IOException {
        HttpResponse response = updateDashboardForHttpResponse(id, dashboardDetails);
        TypeReference<Dashboard> typeRef = new TypeReference<Dashboard>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Update dashboard
    * Updates a dashboard, replacing all the dashboard details with those provided.  **[Permissions](#permissions) required:** None  The dashboard to be updated must be owned by the user.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the dashboard is not found or the dashboard is not owned by the user.
    * @param id The ID of the dashboard to update.
    * @param dashboardDetails Replacement dashboard details.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Dashboard
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Dashboard updateDashboard(String id, DashboardDetails dashboardDetails, Map<String, Object> params) throws IOException {
        HttpResponse response = updateDashboardForHttpResponse(id, dashboardDetails, params);
        TypeReference<Dashboard> typeRef = new TypeReference<Dashboard>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse updateDashboardForHttpResponse(String id, DashboardDetails dashboardDetails) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling updateDashboard");
        }// verify the required parameter 'dashboardDetails' is set
        if (dashboardDetails == null) {
            throw new IllegalArgumentException("Missing the required parameter 'dashboardDetails' when calling updateDashboard");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/dashboard/{id}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(dashboardDetails);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse updateDashboardForHttpResponse(String id, java.io.InputStream dashboardDetails, String mediaType) throws IOException {
          // verify the required parameter 'id' is set
              if (id == null) {
              throw new IllegalArgumentException("Missing the required parameter 'id' when calling updateDashboard");
              }// verify the required parameter 'dashboardDetails' is set
              if (dashboardDetails == null) {
              throw new IllegalArgumentException("Missing the required parameter 'dashboardDetails' when calling updateDashboard");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("id", id);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/dashboard/{id}");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = dashboardDetails == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, dashboardDetails);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse updateDashboardForHttpResponse(String id, DashboardDetails dashboardDetails, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling updateDashboard");
        }// verify the required parameter 'dashboardDetails' is set
        if (dashboardDetails == null) {
            throw new IllegalArgumentException("Missing the required parameter 'dashboardDetails' when calling updateDashboard");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/dashboard/{id}");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(dashboardDetails);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }


}
