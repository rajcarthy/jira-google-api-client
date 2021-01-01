package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.FieldConfigurationSchemeProjectAssociation;
import com.atlassian.jira.rest.client.model.PageBeanFieldConfiguration;
import com.atlassian.jira.rest.client.model.PageBeanFieldConfigurationIssueTypeItem;
import com.atlassian.jira.rest.client.model.PageBeanFieldConfigurationItem;
import com.atlassian.jira.rest.client.model.PageBeanFieldConfigurationScheme;
import com.atlassian.jira.rest.client.model.PageBeanFieldConfigurationSchemeProjects;
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
public class IssueFieldConfigurationsApi {
    private ApiClient apiClient;

    public IssueFieldConfigurationsApi() {
        this(new ApiClient());
    }

    public IssueFieldConfigurationsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Assign field configuration scheme to project
    * Assigns a field configuration scheme to a project. If the field configuration scheme ID is &#x60;null&#x60;, the operation assigns the default field configuration scheme.  Field configuration schemes can only be assigned to classic projects.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the project is not a classic project.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * <p><b>404</b> - Returned if the project is missing.
    * @param fieldConfigurationSchemeProjectAssociation The fieldConfigurationSchemeProjectAssociation parameter
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object assignFieldConfigurationSchemeToProject(FieldConfigurationSchemeProjectAssociation fieldConfigurationSchemeProjectAssociation) throws IOException {
        HttpResponse response = assignFieldConfigurationSchemeToProjectForHttpResponse(fieldConfigurationSchemeProjectAssociation);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Assign field configuration scheme to project
    * Assigns a field configuration scheme to a project. If the field configuration scheme ID is &#x60;null&#x60;, the operation assigns the default field configuration scheme.  Field configuration schemes can only be assigned to classic projects.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the project is not a classic project.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * <p><b>404</b> - Returned if the project is missing.
    * @param fieldConfigurationSchemeProjectAssociation The fieldConfigurationSchemeProjectAssociation parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object assignFieldConfigurationSchemeToProject(FieldConfigurationSchemeProjectAssociation fieldConfigurationSchemeProjectAssociation, Map<String, Object> params) throws IOException {
        HttpResponse response = assignFieldConfigurationSchemeToProjectForHttpResponse(fieldConfigurationSchemeProjectAssociation, params);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse assignFieldConfigurationSchemeToProjectForHttpResponse(FieldConfigurationSchemeProjectAssociation fieldConfigurationSchemeProjectAssociation) throws IOException {
        // verify the required parameter 'fieldConfigurationSchemeProjectAssociation' is set
        if (fieldConfigurationSchemeProjectAssociation == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldConfigurationSchemeProjectAssociation' when calling assignFieldConfigurationSchemeToProject");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/fieldconfigurationscheme/project");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(fieldConfigurationSchemeProjectAssociation);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse assignFieldConfigurationSchemeToProjectForHttpResponse(java.io.InputStream fieldConfigurationSchemeProjectAssociation, String mediaType) throws IOException {
          // verify the required parameter 'fieldConfigurationSchemeProjectAssociation' is set
              if (fieldConfigurationSchemeProjectAssociation == null) {
              throw new IllegalArgumentException("Missing the required parameter 'fieldConfigurationSchemeProjectAssociation' when calling assignFieldConfigurationSchemeToProject");
              }
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/fieldconfigurationscheme/project");

              String localVarUrl = uriBuilder.build().toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = fieldConfigurationSchemeProjectAssociation == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, fieldConfigurationSchemeProjectAssociation);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse assignFieldConfigurationSchemeToProjectForHttpResponse(FieldConfigurationSchemeProjectAssociation fieldConfigurationSchemeProjectAssociation, Map<String, Object> params) throws IOException {
        // verify the required parameter 'fieldConfigurationSchemeProjectAssociation' is set
        if (fieldConfigurationSchemeProjectAssociation == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldConfigurationSchemeProjectAssociation' when calling assignFieldConfigurationSchemeToProject");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/fieldconfigurationscheme/project");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(fieldConfigurationSchemeProjectAssociation);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }


  /**
    * Get all field configuration schemes
    * Returns a [paginated](#pagination) list of field configuration schemes.  Only field configuration schemes used in classic projects are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * @param startAt The index of the first item to return in a page of results (page offset).
    * @param maxResults The maximum number of items to return per page.
    * @param id The list of field configuration scheme IDs. To include multiple IDs, provide an ampersand-separated list. For example, &#x60;id&#x3D;10000&amp;id&#x3D;10001&#x60;.
    * @return PageBeanFieldConfigurationScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanFieldConfigurationScheme getAllFieldConfigurationSchemes(Long startAt, Integer maxResults, Set<Long> id) throws IOException {
        HttpResponse response = getAllFieldConfigurationSchemesForHttpResponse(startAt, maxResults, id);
        TypeReference<PageBeanFieldConfigurationScheme> typeRef = new TypeReference<PageBeanFieldConfigurationScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get all field configuration schemes
    * Returns a [paginated](#pagination) list of field configuration schemes.  Only field configuration schemes used in classic projects are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the required permissions.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PageBeanFieldConfigurationScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanFieldConfigurationScheme getAllFieldConfigurationSchemes(Map<String, Object> params) throws IOException {
        HttpResponse response = getAllFieldConfigurationSchemesForHttpResponse(params);
        TypeReference<PageBeanFieldConfigurationScheme> typeRef = new TypeReference<PageBeanFieldConfigurationScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getAllFieldConfigurationSchemesForHttpResponse(Long startAt, Integer maxResults, Set<Long> id) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/fieldconfigurationscheme");
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
        }

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getAllFieldConfigurationSchemesForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/fieldconfigurationscheme");

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
    * Get all field configurations
    * Returns a [paginated](#pagination) list of all field configurations.  Only field configurations used in classic projects are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * @param startAt The index of the first item to return in a page of results (page offset).
    * @param maxResults The maximum number of items to return per page.
    * @param id The list of field configuration IDs. To include multiple IDs, provide an ampersand-separated list. For example, &#x60;id&#x3D;10000&amp;id&#x3D;10001&#x60;.
    * @param isDefault If *true* returns the default field configuration only.
    * @return PageBeanFieldConfiguration
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanFieldConfiguration getAllFieldConfigurations(Long startAt, Integer maxResults, Set<Long> id, Boolean isDefault) throws IOException {
        HttpResponse response = getAllFieldConfigurationsForHttpResponse(startAt, maxResults, id, isDefault);
        TypeReference<PageBeanFieldConfiguration> typeRef = new TypeReference<PageBeanFieldConfiguration>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get all field configurations
    * Returns a [paginated](#pagination) list of all field configurations.  Only field configurations used in classic projects are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PageBeanFieldConfiguration
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanFieldConfiguration getAllFieldConfigurations(Map<String, Object> params) throws IOException {
        HttpResponse response = getAllFieldConfigurationsForHttpResponse(params);
        TypeReference<PageBeanFieldConfiguration> typeRef = new TypeReference<PageBeanFieldConfiguration>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getAllFieldConfigurationsForHttpResponse(Long startAt, Integer maxResults, Set<Long> id, Boolean isDefault) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/fieldconfiguration");
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
        }        if (isDefault != null) {
            String key = "isDefault";
            Object value = isDefault;
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

    public HttpResponse getAllFieldConfigurationsForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/fieldconfiguration");

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
    * Get field configuration items
    * Returns a [paginated](#pagination) list of all fields for a configuration.  Only the fields from configurations used in classic projects are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the field configuration is not found.
    * @param id The ID of the field configuration.
    * @param startAt The index of the first item to return in a page of results (page offset).
    * @param maxResults The maximum number of items to return per page.
    * @return PageBeanFieldConfigurationItem
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanFieldConfigurationItem getFieldConfigurationItems(Long id, Long startAt, Integer maxResults) throws IOException {
        HttpResponse response = getFieldConfigurationItemsForHttpResponse(id, startAt, maxResults);
        TypeReference<PageBeanFieldConfigurationItem> typeRef = new TypeReference<PageBeanFieldConfigurationItem>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get field configuration items
    * Returns a [paginated](#pagination) list of all fields for a configuration.  Only the fields from configurations used in classic projects are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the field configuration is not found.
    * @param id The ID of the field configuration.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PageBeanFieldConfigurationItem
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanFieldConfigurationItem getFieldConfigurationItems(Long id, Map<String, Object> params) throws IOException {
        HttpResponse response = getFieldConfigurationItemsForHttpResponse(id, params);
        TypeReference<PageBeanFieldConfigurationItem> typeRef = new TypeReference<PageBeanFieldConfigurationItem>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getFieldConfigurationItemsForHttpResponse(Long id, Long startAt, Integer maxResults) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling getFieldConfigurationItems");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/fieldconfiguration/{id}/fields");
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
        }

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getFieldConfigurationItemsForHttpResponse(Long id, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling getFieldConfigurationItems");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/fieldconfiguration/{id}/fields");

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
    * Get field configuration issue type items
    * Returns a [paginated](#pagination) list of field configuration issue type items.  Only items used in classic projects are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if no field configuration schemes are found.
    * @param startAt The index of the first item to return in a page of results (page offset).
    * @param maxResults The maximum number of items to return per page.
    * @param fieldConfigurationSchemeId The list of field configuration scheme IDs. To include multiple field configuration schemes separate IDs with ampersand: &#x60;fieldConfigurationSchemeId&#x3D;10000&amp;fieldConfigurationSchemeId&#x3D;10001&#x60;.
    * @return PageBeanFieldConfigurationIssueTypeItem
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanFieldConfigurationIssueTypeItem getFieldConfigurationSchemeMappings(Long startAt, Integer maxResults, Set<Long> fieldConfigurationSchemeId) throws IOException {
        HttpResponse response = getFieldConfigurationSchemeMappingsForHttpResponse(startAt, maxResults, fieldConfigurationSchemeId);
        TypeReference<PageBeanFieldConfigurationIssueTypeItem> typeRef = new TypeReference<PageBeanFieldConfigurationIssueTypeItem>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get field configuration issue type items
    * Returns a [paginated](#pagination) list of field configuration issue type items.  Only items used in classic projects are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if no field configuration schemes are found.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PageBeanFieldConfigurationIssueTypeItem
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanFieldConfigurationIssueTypeItem getFieldConfigurationSchemeMappings(Map<String, Object> params) throws IOException {
        HttpResponse response = getFieldConfigurationSchemeMappingsForHttpResponse(params);
        TypeReference<PageBeanFieldConfigurationIssueTypeItem> typeRef = new TypeReference<PageBeanFieldConfigurationIssueTypeItem>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getFieldConfigurationSchemeMappingsForHttpResponse(Long startAt, Integer maxResults, Set<Long> fieldConfigurationSchemeId) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/fieldconfigurationscheme/mapping");
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
        }        if (fieldConfigurationSchemeId != null) {
            String key = "fieldConfigurationSchemeId";
            Object value = fieldConfigurationSchemeId;
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

    public HttpResponse getFieldConfigurationSchemeMappingsForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/fieldconfigurationscheme/mapping");

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
    * Get field configuration schemes for projects
    * Returns a [paginated](#pagination) list of field configuration schemes and, for each scheme, a list of the projects that use it.  The list is sorted by field configuration scheme ID. The first item contains the list of project IDs assigned to the default field configuration scheme.  Only field configuration schemes used in classic projects are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * @param projectId The list of project IDs. To include multiple projects, separate IDs with ampersand: &#x60;projectId&#x3D;10000&amp;projectId&#x3D;10001&#x60;.
    * @param startAt The index of the first item to return in a page of results (page offset).
    * @param maxResults The maximum number of items to return per page.
    * @return PageBeanFieldConfigurationSchemeProjects
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanFieldConfigurationSchemeProjects getFieldConfigurationSchemeProjectMapping(Set<Long> projectId, Long startAt, Integer maxResults) throws IOException {
        HttpResponse response = getFieldConfigurationSchemeProjectMappingForHttpResponse(projectId, startAt, maxResults);
        TypeReference<PageBeanFieldConfigurationSchemeProjects> typeRef = new TypeReference<PageBeanFieldConfigurationSchemeProjects>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get field configuration schemes for projects
    * Returns a [paginated](#pagination) list of field configuration schemes and, for each scheme, a list of the projects that use it.  The list is sorted by field configuration scheme ID. The first item contains the list of project IDs assigned to the default field configuration scheme.  Only field configuration schemes used in classic projects are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * @param projectId The list of project IDs. To include multiple projects, separate IDs with ampersand: &#x60;projectId&#x3D;10000&amp;projectId&#x3D;10001&#x60;.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PageBeanFieldConfigurationSchemeProjects
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanFieldConfigurationSchemeProjects getFieldConfigurationSchemeProjectMapping(Set<Long> projectId, Map<String, Object> params) throws IOException {
        HttpResponse response = getFieldConfigurationSchemeProjectMappingForHttpResponse(projectId, params);
        TypeReference<PageBeanFieldConfigurationSchemeProjects> typeRef = new TypeReference<PageBeanFieldConfigurationSchemeProjects>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getFieldConfigurationSchemeProjectMappingForHttpResponse(Set<Long> projectId, Long startAt, Integer maxResults) throws IOException {
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectId' when calling getFieldConfigurationSchemeProjectMapping");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/fieldconfigurationscheme/project");
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
        }

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getFieldConfigurationSchemeProjectMappingForHttpResponse(Set<Long> projectId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'projectId' is set
        if (projectId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'projectId' when calling getFieldConfigurationSchemeProjectMapping");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/fieldconfigurationscheme/project");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);
        // Add the required query param 'projectId' to the map of query params
        allParams.put("projectId", projectId);

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


}
