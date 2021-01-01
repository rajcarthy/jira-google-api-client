package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.ApplicationRole;

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
public class ApplicationRolesApi {
    private ApiClient apiClient;

    public ApplicationRolesApi() {
        this(new ApiClient());
    }

    public ApplicationRolesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Get all application roles
    * Returns all application roles. In Jira, application roles are managed using the [Application access configuration](https://confluence.atlassian.com/x/3YxjL) page.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user is not an administrator.
    * @return List&lt;ApplicationRole&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<ApplicationRole> getAllApplicationRoles() throws IOException {
        HttpResponse response = getAllApplicationRolesForHttpResponse();
        TypeReference<List<ApplicationRole>> typeRef = new TypeReference<List<ApplicationRole>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get all application roles
    * Returns all application roles. In Jira, application roles are managed using the [Application access configuration](https://confluence.atlassian.com/x/3YxjL) page.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user is not an administrator.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return List&lt;ApplicationRole&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<ApplicationRole> getAllApplicationRoles(Map<String, Object> params) throws IOException {
        HttpResponse response = getAllApplicationRolesForHttpResponse(params);
        TypeReference<List<ApplicationRole>> typeRef = new TypeReference<List<ApplicationRole>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getAllApplicationRolesForHttpResponse() throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/applicationrole");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getAllApplicationRolesForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/applicationrole");

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
    * Get application role
    * Returns an application role.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user is not an administrator.
    * <p><b>404</b> - Returned if the role is not found.
    * @param key The key of the application role. Use the [Get all application roles](#api-rest-api-3-applicationrole-get) operation to get the key for each application role.
    * @return ApplicationRole
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ApplicationRole getApplicationRole(String key) throws IOException {
        HttpResponse response = getApplicationRoleForHttpResponse(key);
        TypeReference<ApplicationRole> typeRef = new TypeReference<ApplicationRole>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get application role
    * Returns an application role.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user is not an administrator.
    * <p><b>404</b> - Returned if the role is not found.
    * @param key The key of the application role. Use the [Get all application roles](#api-rest-api-3-applicationrole-get) operation to get the key for each application role.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return ApplicationRole
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ApplicationRole getApplicationRole(String key, Map<String, Object> params) throws IOException {
        HttpResponse response = getApplicationRoleForHttpResponse(key, params);
        TypeReference<ApplicationRole> typeRef = new TypeReference<ApplicationRole>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getApplicationRoleForHttpResponse(String key) throws IOException {
        // verify the required parameter 'key' is set
        if (key == null) {
            throw new IllegalArgumentException("Missing the required parameter 'key' when calling getApplicationRole");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("key", key);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/applicationrole/{key}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getApplicationRoleForHttpResponse(String key, Map<String, Object> params) throws IOException {
        // verify the required parameter 'key' is set
        if (key == null) {
            throw new IllegalArgumentException("Missing the required parameter 'key' when calling getApplicationRole");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("key", key);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/applicationrole/{key}");

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
