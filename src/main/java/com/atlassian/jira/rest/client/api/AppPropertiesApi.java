package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.EntityProperty;
import com.atlassian.jira.rest.client.model.OperationMessage;
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
public class AppPropertiesApi {
    private ApiClient apiClient;

    public AppPropertiesApi() {
        this(new ApiClient());
    }

    public AppPropertiesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Delete app property
    * Deletes an app&#39;s property.  **[Permissions](#permissions) required:** Only a Connect app whose key matches &#x60;addonKey&#x60; can make this request.
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the property key is longer than 127 characters.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the property is not found or doesn&#39;t belong to the app.
    * @param addonKey The key of the app, as defined in its descriptor.
    * @param propertyKey The key of the property.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void addonPropertiesResourceDeleteAddonPropertyDelete(String addonKey, String propertyKey) throws IOException {
        addonPropertiesResourceDeleteAddonPropertyDeleteForHttpResponse(addonKey, propertyKey);
    }

  /**
    * Delete app property
    * Deletes an app&#39;s property.  **[Permissions](#permissions) required:** Only a Connect app whose key matches &#x60;addonKey&#x60; can make this request.
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the property key is longer than 127 characters.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the property is not found or doesn&#39;t belong to the app.
    * @param addonKey The key of the app, as defined in its descriptor.
    * @param propertyKey The key of the property.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void addonPropertiesResourceDeleteAddonPropertyDelete(String addonKey, String propertyKey, Map<String, Object> params) throws IOException {
        addonPropertiesResourceDeleteAddonPropertyDeleteForHttpResponse(addonKey, propertyKey, params);
    }

    public HttpResponse addonPropertiesResourceDeleteAddonPropertyDeleteForHttpResponse(String addonKey, String propertyKey) throws IOException {
        // verify the required parameter 'addonKey' is set
        if (addonKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'addonKey' when calling addonPropertiesResourceDeleteAddonPropertyDelete");
        }// verify the required parameter 'propertyKey' is set
        if (propertyKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'propertyKey' when calling addonPropertiesResourceDeleteAddonPropertyDelete");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("addonKey", addonKey);
        uriVariables.put("propertyKey", propertyKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/atlassian-connect/1/addons/{addonKey}/properties/{propertyKey}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }

    public HttpResponse addonPropertiesResourceDeleteAddonPropertyDeleteForHttpResponse(String addonKey, String propertyKey, Map<String, Object> params) throws IOException {
        // verify the required parameter 'addonKey' is set
        if (addonKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'addonKey' when calling addonPropertiesResourceDeleteAddonPropertyDelete");
        }// verify the required parameter 'propertyKey' is set
        if (propertyKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'propertyKey' when calling addonPropertiesResourceDeleteAddonPropertyDelete");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("addonKey", addonKey);
        uriVariables.put("propertyKey", propertyKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/atlassian-connect/1/addons/{addonKey}/properties/{propertyKey}");

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
    * Get app properties
    * Gets all the properties of an app.  **[Permissions](#permissions) required:** Only a Connect app whose key matches &#x60;addonKey&#x60; can make this request.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param addonKey The key of the app, as defined in its descriptor.
    * @return PropertyKeys
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PropertyKeys addonPropertiesResourceGetAddonPropertiesGet(String addonKey) throws IOException {
        HttpResponse response = addonPropertiesResourceGetAddonPropertiesGetForHttpResponse(addonKey);
        TypeReference<PropertyKeys> typeRef = new TypeReference<PropertyKeys>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get app properties
    * Gets all the properties of an app.  **[Permissions](#permissions) required:** Only a Connect app whose key matches &#x60;addonKey&#x60; can make this request.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param addonKey The key of the app, as defined in its descriptor.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PropertyKeys
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PropertyKeys addonPropertiesResourceGetAddonPropertiesGet(String addonKey, Map<String, Object> params) throws IOException {
        HttpResponse response = addonPropertiesResourceGetAddonPropertiesGetForHttpResponse(addonKey, params);
        TypeReference<PropertyKeys> typeRef = new TypeReference<PropertyKeys>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse addonPropertiesResourceGetAddonPropertiesGetForHttpResponse(String addonKey) throws IOException {
        // verify the required parameter 'addonKey' is set
        if (addonKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'addonKey' when calling addonPropertiesResourceGetAddonPropertiesGet");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("addonKey", addonKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/atlassian-connect/1/addons/{addonKey}/properties");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse addonPropertiesResourceGetAddonPropertiesGetForHttpResponse(String addonKey, Map<String, Object> params) throws IOException {
        // verify the required parameter 'addonKey' is set
        if (addonKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'addonKey' when calling addonPropertiesResourceGetAddonPropertiesGet");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("addonKey", addonKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/atlassian-connect/1/addons/{addonKey}/properties");

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
    * Get app property
    * Returns the key and value of an app&#39;s property.  **[Permissions](#permissions) required:** Only a Connect app whose key matches &#x60;addonKey&#x60; can make this request.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the property key is longer than 127 characters.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the property is not found or doesn&#39;t belong to the app.
    * @param addonKey The key of the app, as defined in its descriptor.
    * @param propertyKey The key of the property.
    * @return EntityProperty
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public EntityProperty addonPropertiesResourceGetAddonPropertyGet(String addonKey, String propertyKey) throws IOException {
        HttpResponse response = addonPropertiesResourceGetAddonPropertyGetForHttpResponse(addonKey, propertyKey);
        TypeReference<EntityProperty> typeRef = new TypeReference<EntityProperty>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get app property
    * Returns the key and value of an app&#39;s property.  **[Permissions](#permissions) required:** Only a Connect app whose key matches &#x60;addonKey&#x60; can make this request.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the property key is longer than 127 characters.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the property is not found or doesn&#39;t belong to the app.
    * @param addonKey The key of the app, as defined in its descriptor.
    * @param propertyKey The key of the property.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return EntityProperty
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public EntityProperty addonPropertiesResourceGetAddonPropertyGet(String addonKey, String propertyKey, Map<String, Object> params) throws IOException {
        HttpResponse response = addonPropertiesResourceGetAddonPropertyGetForHttpResponse(addonKey, propertyKey, params);
        TypeReference<EntityProperty> typeRef = new TypeReference<EntityProperty>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse addonPropertiesResourceGetAddonPropertyGetForHttpResponse(String addonKey, String propertyKey) throws IOException {
        // verify the required parameter 'addonKey' is set
        if (addonKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'addonKey' when calling addonPropertiesResourceGetAddonPropertyGet");
        }// verify the required parameter 'propertyKey' is set
        if (propertyKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'propertyKey' when calling addonPropertiesResourceGetAddonPropertyGet");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("addonKey", addonKey);
        uriVariables.put("propertyKey", propertyKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/atlassian-connect/1/addons/{addonKey}/properties/{propertyKey}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse addonPropertiesResourceGetAddonPropertyGetForHttpResponse(String addonKey, String propertyKey, Map<String, Object> params) throws IOException {
        // verify the required parameter 'addonKey' is set
        if (addonKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'addonKey' when calling addonPropertiesResourceGetAddonPropertyGet");
        }// verify the required parameter 'propertyKey' is set
        if (propertyKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'propertyKey' when calling addonPropertiesResourceGetAddonPropertyGet");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("addonKey", addonKey);
        uriVariables.put("propertyKey", propertyKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/atlassian-connect/1/addons/{addonKey}/properties/{propertyKey}");

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
    * Set app property
    * Sets the value of an app&#39;s property. Use this resource to store custom data for your app.  The value of the request body must be a [valid](http://tools.ietf.org/html/rfc4627), non-empty JSON blob. The maximum length is 32768 characters.  **[Permissions](#permissions) required:** Only a Connect app whose key matches &#x60;addonKey&#x60; can make this request.
    * <p><b>200</b> - Returned if the property is updated.
    * <p><b>201</b> - Returned is the property is created.
    * <p><b>400</b> - Returned if:   * the property key is longer than 127 characters.   * the value is not valid JSON.   * the value is longer than 32768 characters.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param addonKey The key of the app, as defined in its descriptor.
    * @param propertyKey The key of the property.
    * @param body The body parameter
    * @return OperationMessage
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public OperationMessage addonPropertiesResourcePutAddonPropertyPut(String addonKey, String propertyKey, Object body) throws IOException {
        HttpResponse response = addonPropertiesResourcePutAddonPropertyPutForHttpResponse(addonKey, propertyKey, body);
        TypeReference<OperationMessage> typeRef = new TypeReference<OperationMessage>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Set app property
    * Sets the value of an app&#39;s property. Use this resource to store custom data for your app.  The value of the request body must be a [valid](http://tools.ietf.org/html/rfc4627), non-empty JSON blob. The maximum length is 32768 characters.  **[Permissions](#permissions) required:** Only a Connect app whose key matches &#x60;addonKey&#x60; can make this request.
    * <p><b>200</b> - Returned if the property is updated.
    * <p><b>201</b> - Returned is the property is created.
    * <p><b>400</b> - Returned if:   * the property key is longer than 127 characters.   * the value is not valid JSON.   * the value is longer than 32768 characters.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param addonKey The key of the app, as defined in its descriptor.
    * @param propertyKey The key of the property.
    * @param body The body parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return OperationMessage
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public OperationMessage addonPropertiesResourcePutAddonPropertyPut(String addonKey, String propertyKey, Object body, Map<String, Object> params) throws IOException {
        HttpResponse response = addonPropertiesResourcePutAddonPropertyPutForHttpResponse(addonKey, propertyKey, body, params);
        TypeReference<OperationMessage> typeRef = new TypeReference<OperationMessage>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse addonPropertiesResourcePutAddonPropertyPutForHttpResponse(String addonKey, String propertyKey, Object body) throws IOException {
        // verify the required parameter 'addonKey' is set
        if (addonKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'addonKey' when calling addonPropertiesResourcePutAddonPropertyPut");
        }// verify the required parameter 'propertyKey' is set
        if (propertyKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'propertyKey' when calling addonPropertiesResourcePutAddonPropertyPut");
        }// verify the required parameter 'body' is set
        if (body == null) {
            throw new IllegalArgumentException("Missing the required parameter 'body' when calling addonPropertiesResourcePutAddonPropertyPut");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("addonKey", addonKey);
        uriVariables.put("propertyKey", propertyKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/atlassian-connect/1/addons/{addonKey}/properties/{propertyKey}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(body);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse addonPropertiesResourcePutAddonPropertyPutForHttpResponse(String addonKey, String propertyKey, java.io.InputStream body, String mediaType) throws IOException {
          // verify the required parameter 'addonKey' is set
              if (addonKey == null) {
              throw new IllegalArgumentException("Missing the required parameter 'addonKey' when calling addonPropertiesResourcePutAddonPropertyPut");
              }// verify the required parameter 'propertyKey' is set
              if (propertyKey == null) {
              throw new IllegalArgumentException("Missing the required parameter 'propertyKey' when calling addonPropertiesResourcePutAddonPropertyPut");
              }// verify the required parameter 'body' is set
              if (body == null) {
              throw new IllegalArgumentException("Missing the required parameter 'body' when calling addonPropertiesResourcePutAddonPropertyPut");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("addonKey", addonKey);
                      uriVariables.put("propertyKey", propertyKey);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/atlassian-connect/1/addons/{addonKey}/properties/{propertyKey}");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = body == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, body);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse addonPropertiesResourcePutAddonPropertyPutForHttpResponse(String addonKey, String propertyKey, Object body, Map<String, Object> params) throws IOException {
        // verify the required parameter 'addonKey' is set
        if (addonKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'addonKey' when calling addonPropertiesResourcePutAddonPropertyPut");
        }// verify the required parameter 'propertyKey' is set
        if (propertyKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'propertyKey' when calling addonPropertiesResourcePutAddonPropertyPut");
        }// verify the required parameter 'body' is set
        if (body == null) {
            throw new IllegalArgumentException("Missing the required parameter 'body' when calling addonPropertiesResourcePutAddonPropertyPut");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("addonKey", addonKey);
        uriVariables.put("propertyKey", propertyKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/atlassian-connect/1/addons/{addonKey}/properties/{propertyKey}");

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


}
