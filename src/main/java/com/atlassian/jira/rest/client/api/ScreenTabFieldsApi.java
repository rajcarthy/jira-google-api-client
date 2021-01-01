package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.AddFieldBean;
import com.atlassian.jira.rest.client.model.MoveFieldBean;
import com.atlassian.jira.rest.client.model.ScreenableField;

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
public class ScreenTabFieldsApi {
    private ApiClient apiClient;

    public ScreenTabFieldsApi() {
        this(new ApiClient());
    }

    public ScreenTabFieldsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Add screen tab field
    * Adds a field to a screen tab.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the screen, screen tab, or field is not found.
    * @param screenId The ID of the screen.
    * @param tabId The ID of the screen tab.
    * @param addFieldBean The addFieldBean parameter
    * @return ScreenableField
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ScreenableField addScreenTabField(Long screenId, Long tabId, AddFieldBean addFieldBean) throws IOException {
        HttpResponse response = addScreenTabFieldForHttpResponse(screenId, tabId, addFieldBean);
        TypeReference<ScreenableField> typeRef = new TypeReference<ScreenableField>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Add screen tab field
    * Adds a field to a screen tab.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the screen, screen tab, or field is not found.
    * @param screenId The ID of the screen.
    * @param tabId The ID of the screen tab.
    * @param addFieldBean The addFieldBean parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return ScreenableField
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ScreenableField addScreenTabField(Long screenId, Long tabId, AddFieldBean addFieldBean, Map<String, Object> params) throws IOException {
        HttpResponse response = addScreenTabFieldForHttpResponse(screenId, tabId, addFieldBean, params);
        TypeReference<ScreenableField> typeRef = new TypeReference<ScreenableField>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse addScreenTabFieldForHttpResponse(Long screenId, Long tabId, AddFieldBean addFieldBean) throws IOException {
        // verify the required parameter 'screenId' is set
        if (screenId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'screenId' when calling addScreenTabField");
        }// verify the required parameter 'tabId' is set
        if (tabId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'tabId' when calling addScreenTabField");
        }// verify the required parameter 'addFieldBean' is set
        if (addFieldBean == null) {
            throw new IllegalArgumentException("Missing the required parameter 'addFieldBean' when calling addScreenTabField");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("screenId", screenId);
        uriVariables.put("tabId", tabId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/screens/{screenId}/tabs/{tabId}/fields");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(addFieldBean);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse addScreenTabFieldForHttpResponse(Long screenId, Long tabId, java.io.InputStream addFieldBean, String mediaType) throws IOException {
          // verify the required parameter 'screenId' is set
              if (screenId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'screenId' when calling addScreenTabField");
              }// verify the required parameter 'tabId' is set
              if (tabId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'tabId' when calling addScreenTabField");
              }// verify the required parameter 'addFieldBean' is set
              if (addFieldBean == null) {
              throw new IllegalArgumentException("Missing the required parameter 'addFieldBean' when calling addScreenTabField");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("screenId", screenId);
                      uriVariables.put("tabId", tabId);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/screens/{screenId}/tabs/{tabId}/fields");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = addFieldBean == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, addFieldBean);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse addScreenTabFieldForHttpResponse(Long screenId, Long tabId, AddFieldBean addFieldBean, Map<String, Object> params) throws IOException {
        // verify the required parameter 'screenId' is set
        if (screenId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'screenId' when calling addScreenTabField");
        }// verify the required parameter 'tabId' is set
        if (tabId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'tabId' when calling addScreenTabField");
        }// verify the required parameter 'addFieldBean' is set
        if (addFieldBean == null) {
            throw new IllegalArgumentException("Missing the required parameter 'addFieldBean' when calling addScreenTabField");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("screenId", screenId);
        uriVariables.put("tabId", tabId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/screens/{screenId}/tabs/{tabId}/fields");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(addFieldBean);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


  /**
    * Get all screen tab fields
    * Returns all fields for a screen tab.  **[Permissions](#permissions) required:**   *  *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).  *  *Administer projects* [project permission](https://confluence.atlassian.com/x/yodKLg) when the project key is specified, providing that the screen is associated with the project through a Screen Scheme and Issue Type Screen Scheme.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the screen or screen tab is not found.
    * @param screenId The ID of the screen.
    * @param tabId The ID of the screen tab.
    * @param projectKey The key of the project.
    * @return List&lt;ScreenableField&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<ScreenableField> getAllScreenTabFields(Long screenId, Long tabId, String projectKey) throws IOException {
        HttpResponse response = getAllScreenTabFieldsForHttpResponse(screenId, tabId, projectKey);
        TypeReference<List<ScreenableField>> typeRef = new TypeReference<List<ScreenableField>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get all screen tab fields
    * Returns all fields for a screen tab.  **[Permissions](#permissions) required:**   *  *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).  *  *Administer projects* [project permission](https://confluence.atlassian.com/x/yodKLg) when the project key is specified, providing that the screen is associated with the project through a Screen Scheme and Issue Type Screen Scheme.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the screen or screen tab is not found.
    * @param screenId The ID of the screen.
    * @param tabId The ID of the screen tab.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return List&lt;ScreenableField&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<ScreenableField> getAllScreenTabFields(Long screenId, Long tabId, Map<String, Object> params) throws IOException {
        HttpResponse response = getAllScreenTabFieldsForHttpResponse(screenId, tabId, params);
        TypeReference<List<ScreenableField>> typeRef = new TypeReference<List<ScreenableField>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getAllScreenTabFieldsForHttpResponse(Long screenId, Long tabId, String projectKey) throws IOException {
        // verify the required parameter 'screenId' is set
        if (screenId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'screenId' when calling getAllScreenTabFields");
        }// verify the required parameter 'tabId' is set
        if (tabId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'tabId' when calling getAllScreenTabFields");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("screenId", screenId);
        uriVariables.put("tabId", tabId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/screens/{screenId}/tabs/{tabId}/fields");
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
        }

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getAllScreenTabFieldsForHttpResponse(Long screenId, Long tabId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'screenId' is set
        if (screenId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'screenId' when calling getAllScreenTabFields");
        }// verify the required parameter 'tabId' is set
        if (tabId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'tabId' when calling getAllScreenTabFields");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("screenId", screenId);
        uriVariables.put("tabId", tabId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/screens/{screenId}/tabs/{tabId}/fields");

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
    * Move screen tab field
    * Moves a screen tab field.  If &#x60;after&#x60; and &#x60;position&#x60; are provided in the request, &#x60;position&#x60; is ignored.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the screen, screen tab, or field is not found or the field can&#39;t be moved to the requested position.
    * @param screenId The ID of the screen.
    * @param tabId The ID of the screen tab.
    * @param id The ID of the field.
    * @param moveFieldBean The moveFieldBean parameter
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object moveScreenTabField(Long screenId, Long tabId, String id, MoveFieldBean moveFieldBean) throws IOException {
        HttpResponse response = moveScreenTabFieldForHttpResponse(screenId, tabId, id, moveFieldBean);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Move screen tab field
    * Moves a screen tab field.  If &#x60;after&#x60; and &#x60;position&#x60; are provided in the request, &#x60;position&#x60; is ignored.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the screen, screen tab, or field is not found or the field can&#39;t be moved to the requested position.
    * @param screenId The ID of the screen.
    * @param tabId The ID of the screen tab.
    * @param id The ID of the field.
    * @param moveFieldBean The moveFieldBean parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object moveScreenTabField(Long screenId, Long tabId, String id, MoveFieldBean moveFieldBean, Map<String, Object> params) throws IOException {
        HttpResponse response = moveScreenTabFieldForHttpResponse(screenId, tabId, id, moveFieldBean, params);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse moveScreenTabFieldForHttpResponse(Long screenId, Long tabId, String id, MoveFieldBean moveFieldBean) throws IOException {
        // verify the required parameter 'screenId' is set
        if (screenId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'screenId' when calling moveScreenTabField");
        }// verify the required parameter 'tabId' is set
        if (tabId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'tabId' when calling moveScreenTabField");
        }// verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling moveScreenTabField");
        }// verify the required parameter 'moveFieldBean' is set
        if (moveFieldBean == null) {
            throw new IllegalArgumentException("Missing the required parameter 'moveFieldBean' when calling moveScreenTabField");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("screenId", screenId);
        uriVariables.put("tabId", tabId);
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/screens/{screenId}/tabs/{tabId}/fields/{id}/move");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(moveFieldBean);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse moveScreenTabFieldForHttpResponse(Long screenId, Long tabId, String id, java.io.InputStream moveFieldBean, String mediaType) throws IOException {
          // verify the required parameter 'screenId' is set
              if (screenId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'screenId' when calling moveScreenTabField");
              }// verify the required parameter 'tabId' is set
              if (tabId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'tabId' when calling moveScreenTabField");
              }// verify the required parameter 'id' is set
              if (id == null) {
              throw new IllegalArgumentException("Missing the required parameter 'id' when calling moveScreenTabField");
              }// verify the required parameter 'moveFieldBean' is set
              if (moveFieldBean == null) {
              throw new IllegalArgumentException("Missing the required parameter 'moveFieldBean' when calling moveScreenTabField");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("screenId", screenId);
                      uriVariables.put("tabId", tabId);
                      uriVariables.put("id", id);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/screens/{screenId}/tabs/{tabId}/fields/{id}/move");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = moveFieldBean == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, moveFieldBean);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse moveScreenTabFieldForHttpResponse(Long screenId, Long tabId, String id, MoveFieldBean moveFieldBean, Map<String, Object> params) throws IOException {
        // verify the required parameter 'screenId' is set
        if (screenId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'screenId' when calling moveScreenTabField");
        }// verify the required parameter 'tabId' is set
        if (tabId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'tabId' when calling moveScreenTabField");
        }// verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling moveScreenTabField");
        }// verify the required parameter 'moveFieldBean' is set
        if (moveFieldBean == null) {
            throw new IllegalArgumentException("Missing the required parameter 'moveFieldBean' when calling moveScreenTabField");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("screenId", screenId);
        uriVariables.put("tabId", tabId);
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/screens/{screenId}/tabs/{tabId}/fields/{id}/move");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(moveFieldBean);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


  /**
    * Remove screen tab field
    * Removes a field from a screen tab.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the screen, screen tab, or field is not found.
    * @param screenId The ID of the screen.
    * @param tabId The ID of the screen tab.
    * @param id The ID of the field.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void removeScreenTabField(Long screenId, Long tabId, String id) throws IOException {
        removeScreenTabFieldForHttpResponse(screenId, tabId, id);
    }

  /**
    * Remove screen tab field
    * Removes a field from a screen tab.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the screen, screen tab, or field is not found.
    * @param screenId The ID of the screen.
    * @param tabId The ID of the screen tab.
    * @param id The ID of the field.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void removeScreenTabField(Long screenId, Long tabId, String id, Map<String, Object> params) throws IOException {
        removeScreenTabFieldForHttpResponse(screenId, tabId, id, params);
    }

    public HttpResponse removeScreenTabFieldForHttpResponse(Long screenId, Long tabId, String id) throws IOException {
        // verify the required parameter 'screenId' is set
        if (screenId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'screenId' when calling removeScreenTabField");
        }// verify the required parameter 'tabId' is set
        if (tabId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'tabId' when calling removeScreenTabField");
        }// verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling removeScreenTabField");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("screenId", screenId);
        uriVariables.put("tabId", tabId);
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/screens/{screenId}/tabs/{tabId}/fields/{id}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }

    public HttpResponse removeScreenTabFieldForHttpResponse(Long screenId, Long tabId, String id, Map<String, Object> params) throws IOException {
        // verify the required parameter 'screenId' is set
        if (screenId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'screenId' when calling removeScreenTabField");
        }// verify the required parameter 'tabId' is set
        if (tabId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'tabId' when calling removeScreenTabField");
        }// verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling removeScreenTabField");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("screenId", screenId);
        uriVariables.put("tabId", tabId);
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/screens/{screenId}/tabs/{tabId}/fields/{id}");

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


}
