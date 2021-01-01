package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.ColumnItem;
import com.atlassian.jira.rest.client.model.ErrorCollection;
import com.atlassian.jira.rest.client.model.Filter;
import com.atlassian.jira.rest.client.model.PageBeanFilterDetails;
import java.util.Set;

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
public class FiltersApi {
    private ApiClient apiClient;

    public FiltersApi() {
        this(new ApiClient());
    }

    public FiltersApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Create filter
    * Creates a filter. The filter is shared according to the [default share scope](#api-rest-api-3-filter-post). The filter is not selected as a favorite.  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request object is invalid. For example, the &#x60;name&#x60; is not unique or the project ID is not specified for a project role share permission.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param filter The filter to create.
    * @param expand Use [expand](#expansion) to include additional information about filter in the response. This parameter accepts a comma-separated list. Expand options include:   *  &#x60;sharedUsers&#x60; Returns the users that the filter is shared with. This includes users that can browse projects that the filter is shared with. If you don&#39;t specify &#x60;sharedUsers&#x60;, then the &#x60;sharedUsers&#x60; object is returned but it doesn&#39;t list any users. The list of users returned is limited to 1000, to access additional users append &#x60;[start-index:end-index]&#x60; to the expand request. For example, to access the next 1000 users, use &#x60;?expand&#x3D;sharedUsers[1001:2000]&#x60;.  *  &#x60;subscriptions&#x60; Returns the users that are subscribed to the filter. If you don&#39;t specify &#x60;subscriptions&#x60;, the &#x60;subscriptions&#x60; object is returned but it doesn&#39;t list any subscriptions. The list of subscriptions returned is limited to 1000, to access additional subscriptions append &#x60;[start-index:end-index]&#x60; to the expand request. For example, to access the next 1000 subscriptions, use &#x60;?expand&#x3D;subscriptions[1001:2000]&#x60;.
    * @return Filter
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Filter createFilter(Filter filter, String expand) throws IOException {
        HttpResponse response = createFilterForHttpResponse(filter, expand);
        TypeReference<Filter> typeRef = new TypeReference<Filter>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Create filter
    * Creates a filter. The filter is shared according to the [default share scope](#api-rest-api-3-filter-post). The filter is not selected as a favorite.  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request object is invalid. For example, the &#x60;name&#x60; is not unique or the project ID is not specified for a project role share permission.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param filter The filter to create.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Filter
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Filter createFilter(Filter filter, Map<String, Object> params) throws IOException {
        HttpResponse response = createFilterForHttpResponse(filter, params);
        TypeReference<Filter> typeRef = new TypeReference<Filter>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse createFilterForHttpResponse(Filter filter, String expand) throws IOException {
        // verify the required parameter 'filter' is set
        if (filter == null) {
            throw new IllegalArgumentException("Missing the required parameter 'filter' when calling createFilter");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/filter");
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

        HttpContent content = apiClient.new JacksonJsonHttpContent(filter);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse createFilterForHttpResponse(java.io.InputStream filter, String expand, String mediaType) throws IOException {
          // verify the required parameter 'filter' is set
              if (filter == null) {
              throw new IllegalArgumentException("Missing the required parameter 'filter' when calling createFilter");
              }
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/filter");
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

              HttpContent content = filter == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, filter);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse createFilterForHttpResponse(Filter filter, Map<String, Object> params) throws IOException {
        // verify the required parameter 'filter' is set
        if (filter == null) {
            throw new IllegalArgumentException("Missing the required parameter 'filter' when calling createFilter");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/filter");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(filter);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


  /**
    * Remove filter as favorite
    * Removes a filter as a favorite for the user. Note that this operation only removes filters visible to the user from the user&#39;s favorites list. For example, if the user favorites a public filter that is subsequently made private (and is therefore no longer visible on their favorites list) they cannot remove it from their favorites list.  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  the filter is not found.  *  the user does not have permission to view the filter.
    * @param id The ID of the filter.
    * @param expand Use [expand](#expansion) to include additional information about filter in the response. This parameter accepts a comma-separated list. Expand options include:   *  &#x60;sharedUsers&#x60; Returns the users that the filter is shared with. This includes users that can browse projects that the filter is shared with. If you don&#39;t specify &#x60;sharedUsers&#x60;, then the &#x60;sharedUsers&#x60; object is returned but it doesn&#39;t list any users. The list of users returned is limited to 1000, to access additional users append &#x60;[start-index:end-index]&#x60; to the expand request. For example, to access the next 1000 users, use &#x60;?expand&#x3D;sharedUsers[1001:2000]&#x60;.  *  &#x60;subscriptions&#x60; Returns the users that are subscribed to the filter. If you don&#39;t specify &#x60;subscriptions&#x60;, the &#x60;subscriptions&#x60; object is returned but it doesn&#39;t list any subscriptions. The list of subscriptions returned is limited to 1000, to access additional subscriptions append &#x60;[start-index:end-index]&#x60; to the expand request. For example, to access the next 1000 subscriptions, use &#x60;?expand&#x3D;subscriptions[1001:2000]&#x60;.
    * @return Filter
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Filter deleteFavouriteForFilter(Long id, String expand) throws IOException {
        HttpResponse response = deleteFavouriteForFilterForHttpResponse(id, expand);
        TypeReference<Filter> typeRef = new TypeReference<Filter>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Remove filter as favorite
    * Removes a filter as a favorite for the user. Note that this operation only removes filters visible to the user from the user&#39;s favorites list. For example, if the user favorites a public filter that is subsequently made private (and is therefore no longer visible on their favorites list) they cannot remove it from their favorites list.  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  the filter is not found.  *  the user does not have permission to view the filter.
    * @param id The ID of the filter.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Filter
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Filter deleteFavouriteForFilter(Long id, Map<String, Object> params) throws IOException {
        HttpResponse response = deleteFavouriteForFilterForHttpResponse(id, params);
        TypeReference<Filter> typeRef = new TypeReference<Filter>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse deleteFavouriteForFilterForHttpResponse(Long id, String expand) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling deleteFavouriteForFilter");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/filter/{id}/favourite");
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
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }

    public HttpResponse deleteFavouriteForFilterForHttpResponse(Long id, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling deleteFavouriteForFilter");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/filter/{id}/favourite");

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
    * Delete filter
    * Delete a filter.  **[Permissions](#permissions) required:** Permission to access Jira, however filters can only be deleted by the creator of the filter or a user with *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the filter is not found.
    * <p><b>401</b> - Returned if the user does not have permission to delete the filter.
    * @param id The ID of the filter to delete.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteFilter(Long id) throws IOException {
        deleteFilterForHttpResponse(id);
    }

  /**
    * Delete filter
    * Delete a filter.  **[Permissions](#permissions) required:** Permission to access Jira, however filters can only be deleted by the creator of the filter or a user with *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the filter is not found.
    * <p><b>401</b> - Returned if the user does not have permission to delete the filter.
    * @param id The ID of the filter to delete.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteFilter(Long id, Map<String, Object> params) throws IOException {
        deleteFilterForHttpResponse(id, params);
    }

    public HttpResponse deleteFilterForHttpResponse(Long id) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling deleteFilter");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/filter/{id}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }

    public HttpResponse deleteFilterForHttpResponse(Long id, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling deleteFilter");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/filter/{id}");

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
    * Get columns
    * Returns the columns configured for a filter. The column configuration is used when the filter&#39;s results are viewed in *List View* with the *Columns* set to *Filter*.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None, however, column details are only returned for:   *  filters owned by the user.  *  filters shared with a group that the user is a member of.  *  filters shared with a private project that the user has *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for.  *  filters shared with a public project.  *  filters shared with the public.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the user does not have permission to view the filter.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if a column configuration is not set for the filter.
    * @param id The ID of the filter.
    * @return List&lt;ColumnItem&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<ColumnItem> getColumns(Long id) throws IOException {
        HttpResponse response = getColumnsForHttpResponse(id);
        TypeReference<List<ColumnItem>> typeRef = new TypeReference<List<ColumnItem>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get columns
    * Returns the columns configured for a filter. The column configuration is used when the filter&#39;s results are viewed in *List View* with the *Columns* set to *Filter*.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None, however, column details are only returned for:   *  filters owned by the user.  *  filters shared with a group that the user is a member of.  *  filters shared with a private project that the user has *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for.  *  filters shared with a public project.  *  filters shared with the public.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the user does not have permission to view the filter.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if a column configuration is not set for the filter.
    * @param id The ID of the filter.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return List&lt;ColumnItem&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<ColumnItem> getColumns(Long id, Map<String, Object> params) throws IOException {
        HttpResponse response = getColumnsForHttpResponse(id, params);
        TypeReference<List<ColumnItem>> typeRef = new TypeReference<List<ColumnItem>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getColumnsForHttpResponse(Long id) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling getColumns");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/filter/{id}/columns");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getColumnsForHttpResponse(Long id, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling getColumns");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/filter/{id}/columns");

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
    * Get favorite filters
    * Returns the visible favorite filters of the user.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** A favorite filter is only visible to the user where the filter is:   *  owned by the user.  *  shared with a group that the user is a member of.  *  shared with a private project that the user has *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for.  *  shared with a public project.  *  shared with the public.  For example, if the user favorites a public filter that is subsequently made private that filter is not returned by this operation.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param expand Use [expand](#expansion) to include additional information about filter in the response. This parameter accepts a comma-separated list. Expand options include:   *  &#x60;sharedUsers&#x60; Returns the users that the filter is shared with. This includes users that can browse projects that the filter is shared with. If you don&#39;t specify &#x60;sharedUsers&#x60;, then the &#x60;sharedUsers&#x60; object is returned but it doesn&#39;t list any users. The list of users returned is limited to 1000, to access additional users append &#x60;[start-index:end-index]&#x60; to the expand request. For example, to access the next 1000 users, use &#x60;?expand&#x3D;sharedUsers[1001:2000]&#x60;.  *  &#x60;subscriptions&#x60; Returns the users that are subscribed to the filter. If you don&#39;t specify &#x60;subscriptions&#x60;, the &#x60;subscriptions&#x60; object is returned but it doesn&#39;t list any subscriptions. The list of subscriptions returned is limited to 1000, to access additional subscriptions append &#x60;[start-index:end-index]&#x60; to the expand request. For example, to access the next 1000 subscriptions, use &#x60;?expand&#x3D;subscriptions[1001:2000]&#x60;.
    * @return List&lt;Filter&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<Filter> getFavouriteFilters(String expand) throws IOException {
        HttpResponse response = getFavouriteFiltersForHttpResponse(expand);
        TypeReference<List<Filter>> typeRef = new TypeReference<List<Filter>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get favorite filters
    * Returns the visible favorite filters of the user.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** A favorite filter is only visible to the user where the filter is:   *  owned by the user.  *  shared with a group that the user is a member of.  *  shared with a private project that the user has *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for.  *  shared with a public project.  *  shared with the public.  For example, if the user favorites a public filter that is subsequently made private that filter is not returned by this operation.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return List&lt;Filter&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<Filter> getFavouriteFilters(Map<String, Object> params) throws IOException {
        HttpResponse response = getFavouriteFiltersForHttpResponse(params);
        TypeReference<List<Filter>> typeRef = new TypeReference<List<Filter>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getFavouriteFiltersForHttpResponse(String expand) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/filter/favourite");
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

    public HttpResponse getFavouriteFiltersForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/filter/favourite");

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
    * Get filter
    * Returns a filter.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None, however, the filter is only returned where it is:   *  owned by the user.  *  shared with a group that the user is a member of.  *  shared with a private project that the user has *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for.  *  shared with a public project.  *  shared with the public.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the filter is not found or the user does not have permission to view it.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param id The ID of the filter to return.
    * @param expand Use [expand](#expansion) to include additional information about filter in the response. This parameter accepts a comma-separated list. Expand options include:   *  &#x60;sharedUsers&#x60; Returns the users that the filter is shared with. This includes users that can browse projects that the filter is shared with. If you don&#39;t specify &#x60;sharedUsers&#x60;, then the &#x60;sharedUsers&#x60; object is returned but it doesn&#39;t list any users. The list of users returned is limited to 1000, to access additional users append &#x60;[start-index:end-index]&#x60; to the expand request. For example, to access the next 1000 users, use &#x60;?expand&#x3D;sharedUsers[1001:2000]&#x60;.  *  &#x60;subscriptions&#x60; Returns the users that are subscribed to the filter. If you don&#39;t specify &#x60;subscriptions&#x60;, the &#x60;subscriptions&#x60; object is returned but it doesn&#39;t list any subscriptions. The list of subscriptions returned is limited to 1000, to access additional subscriptions append &#x60;[start-index:end-index]&#x60; to the expand request. For example, to access the next 1000 subscriptions, use &#x60;?expand&#x3D;subscriptions[1001:2000]&#x60;.
    * @return Filter
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Filter getFilter(Long id, String expand) throws IOException {
        HttpResponse response = getFilterForHttpResponse(id, expand);
        TypeReference<Filter> typeRef = new TypeReference<Filter>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get filter
    * Returns a filter.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None, however, the filter is only returned where it is:   *  owned by the user.  *  shared with a group that the user is a member of.  *  shared with a private project that the user has *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for.  *  shared with a public project.  *  shared with the public.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the filter is not found or the user does not have permission to view it.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param id The ID of the filter to return.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Filter
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Filter getFilter(Long id, Map<String, Object> params) throws IOException {
        HttpResponse response = getFilterForHttpResponse(id, params);
        TypeReference<Filter> typeRef = new TypeReference<Filter>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getFilterForHttpResponse(Long id, String expand) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling getFilter");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/filter/{id}");
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

    public HttpResponse getFilterForHttpResponse(Long id, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling getFilter");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/filter/{id}");

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
    * Get filters
    * Returns all filters. Deprecated, use [ Search for filters](#api-rest-api-3-filter-search-get) that supports search and pagination.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None, however, only the following filters are returned:   *  filters owned by the user.  *  filters shared with a group that the user is a member of.  *  filters shared with a private project that the user has *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for.  *  filters shared with a public project.  *  filters shared with the public.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param expand Use [expand](#expansion) to include additional information about filter in the response. This parameter accepts a comma-separated list. Expand options include:   *  &#x60;sharedUsers&#x60; Returns the users that the filter is shared with. This includes users that can browse projects that the filter is shared with. If you don&#39;t specify &#x60;sharedUsers&#x60;, then the &#x60;sharedUsers&#x60; object is returned but it doesn&#39;t list any users. The list of users returned is limited to 1000, to access additional users append &#x60;[start-index:end-index]&#x60; to the expand request. For example, to access the next 1000 users, use &#x60;?expand&#x3D;sharedUsers[1001:2000]&#x60;.  *  &#x60;subscriptions&#x60; Returns the users that are subscribed to the filter. If you don&#39;t specify &#x60;subscriptions&#x60;, the &#x60;subscriptions&#x60; object is returned but it doesn&#39;t list any subscriptions. The list of subscriptions returned is limited to 1000, to access additional subscriptions append &#x60;[start-index:end-index]&#x60; to the expand request. For example, to access the next 1000 subscriptions, use &#x60;?expand&#x3D;subscriptions[1001:2000]&#x60;.
    * @return List&lt;Filter&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<Filter> getFilters(String expand) throws IOException {
        HttpResponse response = getFiltersForHttpResponse(expand);
        TypeReference<List<Filter>> typeRef = new TypeReference<List<Filter>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get filters
    * Returns all filters. Deprecated, use [ Search for filters](#api-rest-api-3-filter-search-get) that supports search and pagination.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None, however, only the following filters are returned:   *  filters owned by the user.  *  filters shared with a group that the user is a member of.  *  filters shared with a private project that the user has *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for.  *  filters shared with a public project.  *  filters shared with the public.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return List&lt;Filter&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<Filter> getFilters(Map<String, Object> params) throws IOException {
        HttpResponse response = getFiltersForHttpResponse(params);
        TypeReference<List<Filter>> typeRef = new TypeReference<List<Filter>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getFiltersForHttpResponse(String expand) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/filter");
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

    public HttpResponse getFiltersForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/filter");

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
    * Search for filters
    * Returns a [paginated](#pagination) list of filters. Use this operation to get:   *  specific filters, by defining &#x60;id&#x60; only.  *  filters that match all of the specified attributes. For example, all filters for a user with a particular word in their name. When multiple attributes are specified only filters matching all attributes are returned.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None, however, only the following filters that match the query parameters are returned:   *  filters owned by the user.  *  filters shared with a group that the user is a member of.  *  filters shared with a private project that the user has *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for.  *  filters shared with a public project.  *  filters shared with the public.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  &#x60;owner&#x60; and &#x60;accountId&#x60; are provided.  *  &#x60;expand&#x60; includes an invalid value.  *  &#x60;orderBy&#x60; is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param filterName String used to perform a case-insensitive partial match with &#x60;name&#x60;.
    * @param accountId User account ID used to return filters with the matching &#x60;owner.accountId&#x60;. This parameter cannot be used with &#x60;owner&#x60;.
    * @param owner This parameter is deprecated because of privacy changes. Use &#x60;accountId&#x60; instead. See the [migration guide](https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/) for details. User name used to return filters with the matching &#x60;owner.name&#x60;. This parameter cannot be used with &#x60;accountId&#x60;.
    * @param groupname Group name used to returns filters that are shared with a group that matches &#x60;sharePermissions.group.groupname&#x60;.
    * @param projectId Project ID used to returns filters that are shared with a project that matches &#x60;sharePermissions.project.id&#x60;.
    * @param id The list of filter IDs. To include multiple IDs, provide an ampersand-separated list. For example, &#x60;id&#x3D;10000&amp;id&#x3D;10001&#x60;.
    * @param orderBy [Order](#ordering) the results by a field:   *  &#x60;description&#x60; Sorts by filter description. Note that this sorting works independently of whether the expand to display the description field is in use.  *  &#x60;favourite_count&#x60; Sorts by the count of how many users have this filter as a favorite.  *  &#x60;is_favourite&#x60; Sorts by whether the filter is marked as a favorite.  *  &#x60;id&#x60; Sorts by filter ID.  *  &#x60;name&#x60; Sorts by filter name.  *  &#x60;owner&#x60; Sorts by the ID of the filter owner.
    * @param startAt The index of the first item to return in a page of results (page offset).
    * @param maxResults The maximum number of items to return per page.
    * @param expand Use [expand](#expansion) to include additional information about filter in the response. This parameter accepts a comma-separated list. Expand options include:   *  &#x60;description&#x60; Returns the description of the filter.  *  &#x60;favourite&#x60; Returns an indicator of whether the user has set the filter as a favorite.  *  &#x60;favouritedCount&#x60; Returns a count of how many users have set this filter as a favorite.  *  &#x60;jql&#x60; Returns the JQL query that the filter uses.  *  &#x60;owner&#x60; Returns the owner of the filter.  *  &#x60;searchUrl&#x60; Returns a URL to perform the filter&#39;s JQL query.  *  &#x60;sharePermissions&#x60; Returns the share permissions defined for the filter.  *  &#x60;subscriptions&#x60; Returns the users that are subscribed to the filter.  *  &#x60;viewUrl&#x60; Returns a URL to view the filter.
    * @return PageBeanFilterDetails
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanFilterDetails getFiltersPaginated(String filterName, String accountId, String owner, String groupname, Long projectId, Set<Long> id, String orderBy, Long startAt, Integer maxResults, String expand) throws IOException {
        HttpResponse response = getFiltersPaginatedForHttpResponse(filterName, accountId, owner, groupname, projectId, id, orderBy, startAt, maxResults, expand);
        TypeReference<PageBeanFilterDetails> typeRef = new TypeReference<PageBeanFilterDetails>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Search for filters
    * Returns a [paginated](#pagination) list of filters. Use this operation to get:   *  specific filters, by defining &#x60;id&#x60; only.  *  filters that match all of the specified attributes. For example, all filters for a user with a particular word in their name. When multiple attributes are specified only filters matching all attributes are returned.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None, however, only the following filters that match the query parameters are returned:   *  filters owned by the user.  *  filters shared with a group that the user is a member of.  *  filters shared with a private project that the user has *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for.  *  filters shared with a public project.  *  filters shared with the public.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  &#x60;owner&#x60; and &#x60;accountId&#x60; are provided.  *  &#x60;expand&#x60; includes an invalid value.  *  &#x60;orderBy&#x60; is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PageBeanFilterDetails
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanFilterDetails getFiltersPaginated(Map<String, Object> params) throws IOException {
        HttpResponse response = getFiltersPaginatedForHttpResponse(params);
        TypeReference<PageBeanFilterDetails> typeRef = new TypeReference<PageBeanFilterDetails>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getFiltersPaginatedForHttpResponse(String filterName, String accountId, String owner, String groupname, Long projectId, Set<Long> id, String orderBy, Long startAt, Integer maxResults, String expand) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/filter/search");
        if (filterName != null) {
            String key = "filterName";
            Object value = filterName;
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
        }        if (id != null) {
            String key = "id";
            Object value = id;
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

    public HttpResponse getFiltersPaginatedForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/filter/search");

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
    * Get my filters
    * Returns the filters owned by the user. If &#x60;includeFavourites&#x60; is &#x60;true&#x60;, the user&#39;s visible favorite filters are also returned.  **[Permissions](#permissions) required:** Permission to access Jira, however, a favorite filters is only visible to the user where the filter is:   *  owned by the user.  *  shared with a group that the user is a member of.  *  shared with a private project that the user has *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for.  *  shared with a public project.  *  shared with the public.  For example, if the user favorites a public filter that is subsequently made private that filter is not returned by this operation.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param expand Use [expand](#expansion) to include additional information about filter in the response. This parameter accepts a comma-separated list. Expand options include:   *  &#x60;sharedUsers&#x60; Returns the users that the filter is shared with. This includes users that can browse projects that the filter is shared with. If you don&#39;t specify &#x60;sharedUsers&#x60;, then the &#x60;sharedUsers&#x60; object is returned but it doesn&#39;t list any users. The list of users returned is limited to 1000, to access additional users append &#x60;[start-index:end-index]&#x60; to the expand request. For example, to access the next 1000 users, use &#x60;?expand&#x3D;sharedUsers[1001:2000]&#x60;.  *  &#x60;subscriptions&#x60; Returns the users that are subscribed to the filter. If you don&#39;t specify &#x60;subscriptions&#x60;, the &#x60;subscriptions&#x60; object is returned but it doesn&#39;t list any subscriptions. The list of subscriptions returned is limited to 1000, to access additional subscriptions append &#x60;[start-index:end-index]&#x60; to the expand request. For example, to access the next 1000 subscriptions, use &#x60;?expand&#x3D;subscriptions[1001:2000]&#x60;.
    * @param includeFavourites Include the user&#39;s favorite filters in the response.
    * @return List&lt;Filter&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<Filter> getMyFilters(String expand, Boolean includeFavourites) throws IOException {
        HttpResponse response = getMyFiltersForHttpResponse(expand, includeFavourites);
        TypeReference<List<Filter>> typeRef = new TypeReference<List<Filter>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get my filters
    * Returns the filters owned by the user. If &#x60;includeFavourites&#x60; is &#x60;true&#x60;, the user&#39;s visible favorite filters are also returned.  **[Permissions](#permissions) required:** Permission to access Jira, however, a favorite filters is only visible to the user where the filter is:   *  owned by the user.  *  shared with a group that the user is a member of.  *  shared with a private project that the user has *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for.  *  shared with a public project.  *  shared with the public.  For example, if the user favorites a public filter that is subsequently made private that filter is not returned by this operation.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return List&lt;Filter&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<Filter> getMyFilters(Map<String, Object> params) throws IOException {
        HttpResponse response = getMyFiltersForHttpResponse(params);
        TypeReference<List<Filter>> typeRef = new TypeReference<List<Filter>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getMyFiltersForHttpResponse(String expand, Boolean includeFavourites) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/filter/my");
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
        }        if (includeFavourites != null) {
            String key = "includeFavourites";
            Object value = includeFavourites;
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

    public HttpResponse getMyFiltersForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/filter/my");

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
    * Reset columns
    * Reset the user&#39;s column configuration for the filter to the default.  **[Permissions](#permissions) required:** Permission to access Jira, however, columns are only reset for:   *  filters owned by the user.  *  filters shared with a group that the user is a member of.  *  filters shared with a private project that the user has *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for.  *  filters shared with a public project.  *  filters shared with the public.
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  the filter is not found.  *  the user does not have permission to view the filter.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param id The ID of the filter.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void resetColumns(Long id) throws IOException {
        resetColumnsForHttpResponse(id);
    }

  /**
    * Reset columns
    * Reset the user&#39;s column configuration for the filter to the default.  **[Permissions](#permissions) required:** Permission to access Jira, however, columns are only reset for:   *  filters owned by the user.  *  filters shared with a group that the user is a member of.  *  filters shared with a private project that the user has *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for.  *  filters shared with a public project.  *  filters shared with the public.
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  the filter is not found.  *  the user does not have permission to view the filter.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param id The ID of the filter.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void resetColumns(Long id, Map<String, Object> params) throws IOException {
        resetColumnsForHttpResponse(id, params);
    }

    public HttpResponse resetColumnsForHttpResponse(Long id) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling resetColumns");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/filter/{id}/columns");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }

    public HttpResponse resetColumnsForHttpResponse(Long id, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling resetColumns");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/filter/{id}/columns");

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
    * Set columns
    * Sets the columns for a filter. Only navigable fields can be set as columns. Use [Get fields](#api-rest-api-3-field-get) to get the list fields in Jira. A navigable field has &#x60;navigable&#x60; set to &#x60;true&#x60;.  The parameters for this resource are expressed as HTML form data. For example, in curl:  &#x60;curl -X PUT -d columns&#x3D;summary -d columns&#x3D;description https://your-domain.atlassian.net/rest/api/3/filter/10000/columns&#x60;  **[Permissions](#permissions) required:** Permission to access Jira, however, columns are only set for:   *  filters owned by the user.  *  filters shared with a group that the user is a member of.  *  filters shared with a private project that the user has *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for.  *  filters shared with a public project.  *  filters shared with the public.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  a non-navigable field is set as a column.  *  the user does not have permission to view the filter.
    * @param id The ID of the filter.
    * @param requestBody The IDs of the fields to set as columns. In the form data, specify each field as &#x60;columns&#x3D;id&#x60;, where &#x60;id&#x60; is the *id* of a field (as seen in the response for [Get fields](#api-rest-api-&lt;ver&gt;-field-get)). For example, &#x60;columns&#x3D;summary&#x60;.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object setColumns(Long id, List<String> requestBody) throws IOException {
        HttpResponse response = setColumnsForHttpResponse(id, requestBody);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Set columns
    * Sets the columns for a filter. Only navigable fields can be set as columns. Use [Get fields](#api-rest-api-3-field-get) to get the list fields in Jira. A navigable field has &#x60;navigable&#x60; set to &#x60;true&#x60;.  The parameters for this resource are expressed as HTML form data. For example, in curl:  &#x60;curl -X PUT -d columns&#x3D;summary -d columns&#x3D;description https://your-domain.atlassian.net/rest/api/3/filter/10000/columns&#x60;  **[Permissions](#permissions) required:** Permission to access Jira, however, columns are only set for:   *  filters owned by the user.  *  filters shared with a group that the user is a member of.  *  filters shared with a private project that the user has *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for.  *  filters shared with a public project.  *  filters shared with the public.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  a non-navigable field is set as a column.  *  the user does not have permission to view the filter.
    * @param id The ID of the filter.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object setColumns(List<String> requestBody, Long id, Map<String, Object> params) throws IOException {
        HttpResponse response = setColumnsForHttpResponse(requestBody, id, params);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse setColumnsForHttpResponse(Long id, List<String> requestBody) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling setColumns");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/filter/{id}/columns");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(requestBody);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse setColumnsForHttpResponse(Long id, java.io.InputStream requestBody, String mediaType) throws IOException {
          // verify the required parameter 'id' is set
              if (id == null) {
              throw new IllegalArgumentException("Missing the required parameter 'id' when calling setColumns");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("id", id);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/filter/{id}/columns");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = requestBody == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, requestBody);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse setColumnsForHttpResponse(List<String> requestBody, Long id, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling setColumns");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/filter/{id}/columns");

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


  /**
    * Add filter as favorite
    * Add a filter as a favorite for the user.  **[Permissions](#permissions) required:** Permission to access Jira, however, the user can only favorite:   *  filters owned by the user.  *  filters shared with a group that the user is a member of.  *  filters shared with a private project that the user has *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for.  *  filters shared with a public project.  *  filters shared with the public.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  the filter is not found.  *  the user does not have permission to favorite the filter.
    * @param id The ID of the filter.
    * @param expand Use [expand](#expansion) to include additional information about filter in the response. This parameter accepts a comma-separated list. Expand options include:   *  &#x60;sharedUsers&#x60; Returns the users that the filter is shared with. This includes users that can browse projects that the filter is shared with. If you don&#39;t specify &#x60;sharedUsers&#x60;, then the &#x60;sharedUsers&#x60; object is returned but it doesn&#39;t list any users. The list of users returned is limited to 1000, to access additional users append &#x60;[start-index:end-index]&#x60; to the expand request. For example, to access the next 1000 users, use &#x60;?expand&#x3D;sharedUsers[1001:2000]&#x60;.  *  &#x60;subscriptions&#x60; Returns the users that are subscribed to the filter. If you don&#39;t specify &#x60;subscriptions&#x60;, the &#x60;subscriptions&#x60; object is returned but it doesn&#39;t list any subscriptions. The list of subscriptions returned is limited to 1000, to access additional subscriptions append &#x60;[start-index:end-index]&#x60; to the expand request. For example, to access the next 1000 subscriptions, use &#x60;?expand&#x3D;subscriptions[1001:2000]&#x60;.
    * @return Filter
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Filter setFavouriteForFilter(Long id, String expand) throws IOException {
        HttpResponse response = setFavouriteForFilterForHttpResponse(id, expand);
        TypeReference<Filter> typeRef = new TypeReference<Filter>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Add filter as favorite
    * Add a filter as a favorite for the user.  **[Permissions](#permissions) required:** Permission to access Jira, however, the user can only favorite:   *  filters owned by the user.  *  filters shared with a group that the user is a member of.  *  filters shared with a private project that the user has *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for.  *  filters shared with a public project.  *  filters shared with the public.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if:   *  the filter is not found.  *  the user does not have permission to favorite the filter.
    * @param id The ID of the filter.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Filter
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Filter setFavouriteForFilter(Long id, Map<String, Object> params) throws IOException {
        HttpResponse response = setFavouriteForFilterForHttpResponse(id, params);
        TypeReference<Filter> typeRef = new TypeReference<Filter>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse setFavouriteForFilterForHttpResponse(Long id, String expand) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling setFavouriteForFilter");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/filter/{id}/favourite");
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

        HttpContent content = new EmptyContent();
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

    public HttpResponse setFavouriteForFilterForHttpResponse(Long id, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling setFavouriteForFilter");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/filter/{id}/favourite");

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


  /**
    * Update filter
    * Updates a filter. Use this operation to update a filter&#39;s name, description, JQL, or sharing.  **[Permissions](#permissions) required:** Permission to access Jira, however the user must own the filter.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request object is invalid. For example, the &#x60;name&#x60; is not unique or the project ID is not specified for a project role share permission.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param id The ID of the filter to update.
    * @param filter The filter to update.
    * @param expand Use [expand](#expansion) to include additional information about filter in the response. This parameter accepts a comma-separated list. Expand options include:   *  &#x60;sharedUsers&#x60; Returns the users that the filter is shared with. This includes users that can browse projects that the filter is shared with. If you don&#39;t specify &#x60;sharedUsers&#x60;, then the &#x60;sharedUsers&#x60; object is returned but it doesn&#39;t list any users. The list of users returned is limited to 1000, to access additional users append &#x60;[start-index:end-index]&#x60; to the expand request. For example, to access the next 1000 users, use &#x60;?expand&#x3D;sharedUsers[1001:2000]&#x60;.  *  &#x60;subscriptions&#x60; Returns the users that are subscribed to the filter. If you don&#39;t specify &#x60;subscriptions&#x60;, the &#x60;subscriptions&#x60; object is returned but it doesn&#39;t list any subscriptions. The list of subscriptions returned is limited to 1000, to access additional subscriptions append &#x60;[start-index:end-index]&#x60; to the expand request. For example, to access the next 1000 subscriptions, use &#x60;?expand&#x3D;subscriptions[1001:2000]&#x60;.
    * @return Filter
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Filter updateFilter(Long id, Filter filter, String expand) throws IOException {
        HttpResponse response = updateFilterForHttpResponse(id, filter, expand);
        TypeReference<Filter> typeRef = new TypeReference<Filter>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Update filter
    * Updates a filter. Use this operation to update a filter&#39;s name, description, JQL, or sharing.  **[Permissions](#permissions) required:** Permission to access Jira, however the user must own the filter.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request object is invalid. For example, the &#x60;name&#x60; is not unique or the project ID is not specified for a project role share permission.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param id The ID of the filter to update.
    * @param filter The filter to update.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Filter
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Filter updateFilter(Long id, Filter filter, Map<String, Object> params) throws IOException {
        HttpResponse response = updateFilterForHttpResponse(id, filter, params);
        TypeReference<Filter> typeRef = new TypeReference<Filter>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse updateFilterForHttpResponse(Long id, Filter filter, String expand) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling updateFilter");
        }// verify the required parameter 'filter' is set
        if (filter == null) {
            throw new IllegalArgumentException("Missing the required parameter 'filter' when calling updateFilter");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/filter/{id}");
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

        HttpContent content = apiClient.new JacksonJsonHttpContent(filter);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse updateFilterForHttpResponse(Long id, java.io.InputStream filter, String expand, String mediaType) throws IOException {
          // verify the required parameter 'id' is set
              if (id == null) {
              throw new IllegalArgumentException("Missing the required parameter 'id' when calling updateFilter");
              }// verify the required parameter 'filter' is set
              if (filter == null) {
              throw new IllegalArgumentException("Missing the required parameter 'filter' when calling updateFilter");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("id", id);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/filter/{id}");
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

              HttpContent content = filter == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, filter);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse updateFilterForHttpResponse(Long id, Filter filter, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling updateFilter");
        }// verify the required parameter 'filter' is set
        if (filter == null) {
            throw new IllegalArgumentException("Missing the required parameter 'filter' when calling updateFilter");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/filter/{id}");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(filter);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }


}
