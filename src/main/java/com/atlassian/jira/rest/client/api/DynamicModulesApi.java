package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.ConnectModules;
import com.atlassian.jira.rest.client.model.ErrorMessage;

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
public class DynamicModulesApi {
    private ApiClient apiClient;

    public DynamicModulesApi() {
        this(new ApiClient());
    }

    public DynamicModulesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Get modules
    * Returns all modules registered dynamically by the calling app.  **[Permissions](#permissions) required:** Only Connect apps can make this request.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the call is not from a Connect app.
    * @return ConnectModules
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ConnectModules dynamicModulesResourceGetModulesGet() throws IOException {
        HttpResponse response = dynamicModulesResourceGetModulesGetForHttpResponse();
        TypeReference<ConnectModules> typeRef = new TypeReference<ConnectModules>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get modules
    * Returns all modules registered dynamically by the calling app.  **[Permissions](#permissions) required:** Only Connect apps can make this request.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the call is not from a Connect app.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return ConnectModules
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ConnectModules dynamicModulesResourceGetModulesGet(Map<String, Object> params) throws IOException {
        HttpResponse response = dynamicModulesResourceGetModulesGetForHttpResponse(params);
        TypeReference<ConnectModules> typeRef = new TypeReference<ConnectModules>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse dynamicModulesResourceGetModulesGetForHttpResponse() throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/atlassian-connect/1/app/module/dynamic");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse dynamicModulesResourceGetModulesGetForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/atlassian-connect/1/app/module/dynamic");

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
    * Register modules
    * Registers a list of modules.  **[Permissions](#permissions) required:** Only Connect apps can make this request.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if: * any of the provided modules is invalid. For example, required properties are missing. * any of the modules conflict with registered dynamic modules or modules defined in the app descriptor. For example, there are duplicate keys.  Details of the issues encountered are included in the error message.
    * <p><b>401</b> - Returned if the call is not from a Connect app.
    * @param connectModules The connectModules parameter
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void dynamicModulesResourceRegisterModulesPost(ConnectModules connectModules) throws IOException {
        dynamicModulesResourceRegisterModulesPostForHttpResponse(connectModules);
    }

  /**
    * Register modules
    * Registers a list of modules.  **[Permissions](#permissions) required:** Only Connect apps can make this request.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if: * any of the provided modules is invalid. For example, required properties are missing. * any of the modules conflict with registered dynamic modules or modules defined in the app descriptor. For example, there are duplicate keys.  Details of the issues encountered are included in the error message.
    * <p><b>401</b> - Returned if the call is not from a Connect app.
    * @param connectModules The connectModules parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void dynamicModulesResourceRegisterModulesPost(ConnectModules connectModules, Map<String, Object> params) throws IOException {
        dynamicModulesResourceRegisterModulesPostForHttpResponse(connectModules, params);
    }

    public HttpResponse dynamicModulesResourceRegisterModulesPostForHttpResponse(ConnectModules connectModules) throws IOException {
        // verify the required parameter 'connectModules' is set
        if (connectModules == null) {
            throw new IllegalArgumentException("Missing the required parameter 'connectModules' when calling dynamicModulesResourceRegisterModulesPost");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/atlassian-connect/1/app/module/dynamic");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(connectModules);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse dynamicModulesResourceRegisterModulesPostForHttpResponse(java.io.InputStream connectModules, String mediaType) throws IOException {
          // verify the required parameter 'connectModules' is set
              if (connectModules == null) {
              throw new IllegalArgumentException("Missing the required parameter 'connectModules' when calling dynamicModulesResourceRegisterModulesPost");
              }
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/atlassian-connect/1/app/module/dynamic");

              String localVarUrl = uriBuilder.build().toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = connectModules == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, connectModules);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse dynamicModulesResourceRegisterModulesPostForHttpResponse(ConnectModules connectModules, Map<String, Object> params) throws IOException {
        // verify the required parameter 'connectModules' is set
        if (connectModules == null) {
            throw new IllegalArgumentException("Missing the required parameter 'connectModules' when calling dynamicModulesResourceRegisterModulesPost");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/atlassian-connect/1/app/module/dynamic");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(connectModules);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


  /**
    * Remove modules
    * Remove all or a list of modules registered by the calling app.  **[Permissions](#permissions) required:** Only Connect apps can make this request.
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the call is not from a Connect app.
    * @param moduleKey The key of the module to remove. To include multiple module keys, provide multiple copies of this parameter. For example, &#x60;moduleKey&#x3D;dynamic-attachment-entity-property&amp;moduleKey&#x3D;dynamic-select-field&#x60;. Nonexistent keys are ignored.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void dynamicModulesResourceRemoveModulesDelete(List<String> moduleKey) throws IOException {
        dynamicModulesResourceRemoveModulesDeleteForHttpResponse(moduleKey);
    }

  /**
    * Remove modules
    * Remove all or a list of modules registered by the calling app.  **[Permissions](#permissions) required:** Only Connect apps can make this request.
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the call is not from a Connect app.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void dynamicModulesResourceRemoveModulesDelete(Map<String, Object> params) throws IOException {
        dynamicModulesResourceRemoveModulesDeleteForHttpResponse(params);
    }

    public HttpResponse dynamicModulesResourceRemoveModulesDeleteForHttpResponse(List<String> moduleKey) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/atlassian-connect/1/app/module/dynamic");
        if (moduleKey != null) {
            String key = "moduleKey";
            Object value = moduleKey;
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
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }

    public HttpResponse dynamicModulesResourceRemoveModulesDeleteForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/atlassian-connect/1/app/module/dynamic");

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
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }


}
