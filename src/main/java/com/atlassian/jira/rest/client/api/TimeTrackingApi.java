package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.TimeTrackingConfiguration;
import com.atlassian.jira.rest.client.model.TimeTrackingProvider;

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
public class TimeTrackingApi {
    private ApiClient apiClient;

    public TimeTrackingApi() {
        this(new ApiClient());
    }

    public TimeTrackingApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Get all time tracking providers
    * Returns all time tracking providers. By default, Jira only has one time tracking provider: *JIRA provided time tracking*. However, you can install other time tracking providers via apps from the Atlassian Marketplace. For more information on time tracking providers, see the documentation for the [ Time Tracking Provider](https://developer.atlassian.com/cloud/jira/platform/modules/time-tracking-provider/) module.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * @return List&lt;TimeTrackingProvider&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<TimeTrackingProvider> getAvailableTimeTrackingImplementations() throws IOException {
        HttpResponse response = getAvailableTimeTrackingImplementationsForHttpResponse();
        TypeReference<List<TimeTrackingProvider>> typeRef = new TypeReference<List<TimeTrackingProvider>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get all time tracking providers
    * Returns all time tracking providers. By default, Jira only has one time tracking provider: *JIRA provided time tracking*. However, you can install other time tracking providers via apps from the Atlassian Marketplace. For more information on time tracking providers, see the documentation for the [ Time Tracking Provider](https://developer.atlassian.com/cloud/jira/platform/modules/time-tracking-provider/) module.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return List&lt;TimeTrackingProvider&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<TimeTrackingProvider> getAvailableTimeTrackingImplementations(Map<String, Object> params) throws IOException {
        HttpResponse response = getAvailableTimeTrackingImplementationsForHttpResponse(params);
        TypeReference<List<TimeTrackingProvider>> typeRef = new TypeReference<List<TimeTrackingProvider>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getAvailableTimeTrackingImplementationsForHttpResponse() throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/configuration/timetracking/list");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getAvailableTimeTrackingImplementationsForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/configuration/timetracking/list");

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
    * Get selected time tracking provider
    * Returns the time tracking provider that is currently selected. Note that if time tracking is disabled, then a successful but empty response is returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful and time tracking is enabled.
    * <p><b>204</b> - Returned if the request is successful but time tracking is disabled.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * @return TimeTrackingProvider
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public TimeTrackingProvider getSelectedTimeTrackingImplementation() throws IOException {
        HttpResponse response = getSelectedTimeTrackingImplementationForHttpResponse();
        TypeReference<TimeTrackingProvider> typeRef = new TypeReference<TimeTrackingProvider>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get selected time tracking provider
    * Returns the time tracking provider that is currently selected. Note that if time tracking is disabled, then a successful but empty response is returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful and time tracking is enabled.
    * <p><b>204</b> - Returned if the request is successful but time tracking is disabled.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return TimeTrackingProvider
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public TimeTrackingProvider getSelectedTimeTrackingImplementation(Map<String, Object> params) throws IOException {
        HttpResponse response = getSelectedTimeTrackingImplementationForHttpResponse(params);
        TypeReference<TimeTrackingProvider> typeRef = new TypeReference<TimeTrackingProvider>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getSelectedTimeTrackingImplementationForHttpResponse() throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/configuration/timetracking");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getSelectedTimeTrackingImplementationForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/configuration/timetracking");

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
    * Get time tracking settings
    * Returns the time tracking settings. This includes settings such as the time format, default time unit, and others. For more information, see [Configuring time tracking](https://confluence.atlassian.com/x/qoXKM).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * @return TimeTrackingConfiguration
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public TimeTrackingConfiguration getSharedTimeTrackingConfiguration() throws IOException {
        HttpResponse response = getSharedTimeTrackingConfigurationForHttpResponse();
        TypeReference<TimeTrackingConfiguration> typeRef = new TypeReference<TimeTrackingConfiguration>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get time tracking settings
    * Returns the time tracking settings. This includes settings such as the time format, default time unit, and others. For more information, see [Configuring time tracking](https://confluence.atlassian.com/x/qoXKM).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return TimeTrackingConfiguration
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public TimeTrackingConfiguration getSharedTimeTrackingConfiguration(Map<String, Object> params) throws IOException {
        HttpResponse response = getSharedTimeTrackingConfigurationForHttpResponse(params);
        TypeReference<TimeTrackingConfiguration> typeRef = new TypeReference<TimeTrackingConfiguration>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getSharedTimeTrackingConfigurationForHttpResponse() throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/configuration/timetracking/options");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getSharedTimeTrackingConfigurationForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/configuration/timetracking/options");

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
    * Select time tracking provider
    * Selects a time tracking provider.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the time tracking provider is not found.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * @param timeTrackingProvider The timeTrackingProvider parameter
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object selectTimeTrackingImplementation(TimeTrackingProvider timeTrackingProvider) throws IOException {
        HttpResponse response = selectTimeTrackingImplementationForHttpResponse(timeTrackingProvider);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Select time tracking provider
    * Selects a time tracking provider.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the time tracking provider is not found.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * @param timeTrackingProvider The timeTrackingProvider parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object selectTimeTrackingImplementation(TimeTrackingProvider timeTrackingProvider, Map<String, Object> params) throws IOException {
        HttpResponse response = selectTimeTrackingImplementationForHttpResponse(timeTrackingProvider, params);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse selectTimeTrackingImplementationForHttpResponse(TimeTrackingProvider timeTrackingProvider) throws IOException {
        // verify the required parameter 'timeTrackingProvider' is set
        if (timeTrackingProvider == null) {
            throw new IllegalArgumentException("Missing the required parameter 'timeTrackingProvider' when calling selectTimeTrackingImplementation");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/configuration/timetracking");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(timeTrackingProvider);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse selectTimeTrackingImplementationForHttpResponse(java.io.InputStream timeTrackingProvider, String mediaType) throws IOException {
          // verify the required parameter 'timeTrackingProvider' is set
              if (timeTrackingProvider == null) {
              throw new IllegalArgumentException("Missing the required parameter 'timeTrackingProvider' when calling selectTimeTrackingImplementation");
              }
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/configuration/timetracking");

              String localVarUrl = uriBuilder.build().toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = timeTrackingProvider == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, timeTrackingProvider);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse selectTimeTrackingImplementationForHttpResponse(TimeTrackingProvider timeTrackingProvider, Map<String, Object> params) throws IOException {
        // verify the required parameter 'timeTrackingProvider' is set
        if (timeTrackingProvider == null) {
            throw new IllegalArgumentException("Missing the required parameter 'timeTrackingProvider' when calling selectTimeTrackingImplementation");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/configuration/timetracking");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(timeTrackingProvider);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }


  /**
    * Set time tracking settings
    * Sets the time tracking settings.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request object is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * @param timeTrackingConfiguration The timeTrackingConfiguration parameter
    * @return TimeTrackingConfiguration
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public TimeTrackingConfiguration setSharedTimeTrackingConfiguration(TimeTrackingConfiguration timeTrackingConfiguration) throws IOException {
        HttpResponse response = setSharedTimeTrackingConfigurationForHttpResponse(timeTrackingConfiguration);
        TypeReference<TimeTrackingConfiguration> typeRef = new TypeReference<TimeTrackingConfiguration>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Set time tracking settings
    * Sets the time tracking settings.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request object is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * @param timeTrackingConfiguration The timeTrackingConfiguration parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return TimeTrackingConfiguration
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public TimeTrackingConfiguration setSharedTimeTrackingConfiguration(TimeTrackingConfiguration timeTrackingConfiguration, Map<String, Object> params) throws IOException {
        HttpResponse response = setSharedTimeTrackingConfigurationForHttpResponse(timeTrackingConfiguration, params);
        TypeReference<TimeTrackingConfiguration> typeRef = new TypeReference<TimeTrackingConfiguration>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse setSharedTimeTrackingConfigurationForHttpResponse(TimeTrackingConfiguration timeTrackingConfiguration) throws IOException {
        // verify the required parameter 'timeTrackingConfiguration' is set
        if (timeTrackingConfiguration == null) {
            throw new IllegalArgumentException("Missing the required parameter 'timeTrackingConfiguration' when calling setSharedTimeTrackingConfiguration");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/configuration/timetracking/options");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(timeTrackingConfiguration);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse setSharedTimeTrackingConfigurationForHttpResponse(java.io.InputStream timeTrackingConfiguration, String mediaType) throws IOException {
          // verify the required parameter 'timeTrackingConfiguration' is set
              if (timeTrackingConfiguration == null) {
              throw new IllegalArgumentException("Missing the required parameter 'timeTrackingConfiguration' when calling setSharedTimeTrackingConfiguration");
              }
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/configuration/timetracking/options");

              String localVarUrl = uriBuilder.build().toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = timeTrackingConfiguration == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, timeTrackingConfiguration);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse setSharedTimeTrackingConfigurationForHttpResponse(TimeTrackingConfiguration timeTrackingConfiguration, Map<String, Object> params) throws IOException {
        // verify the required parameter 'timeTrackingConfiguration' is set
        if (timeTrackingConfiguration == null) {
            throw new IllegalArgumentException("Missing the required parameter 'timeTrackingConfiguration' when calling setSharedTimeTrackingConfiguration");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/configuration/timetracking/options");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(timeTrackingConfiguration);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }


}
