package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.ContainerForRegisteredWebhooks;
import com.atlassian.jira.rest.client.model.ContainerForWebhookIDs;
import com.atlassian.jira.rest.client.model.ErrorCollection;
import com.atlassian.jira.rest.client.model.FailedWebhooks;
import com.atlassian.jira.rest.client.model.PageBeanWebhook;
import com.atlassian.jira.rest.client.model.WebhookRegistrationDetails;
import com.atlassian.jira.rest.client.model.WebhooksExpirationDate;

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
public class WebhooksApi {
    private ApiClient apiClient;

    public WebhooksApi() {
        this(new ApiClient());
    }

    public WebhooksApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Delete webhooks by ID
    * Removes webhooks by ID. Only webhooks registered by the calling Connect app are removed. If webhooks created by other apps are specified, they are ignored.  **[Permissions](#permissions) required:** Only [Connect apps](https://developer.atlassian.com/cloud/jira/platform/integrating-with-jira-cloud/#atlassian-connect) can use this operation.
    * <p><b>202</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the list of webhook IDs is missing.
    * <p><b>403</b> - Returned if the caller is not a Connect app.
    * @param containerForWebhookIDs The containerForWebhookIDs parameter
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteWebhookById(ContainerForWebhookIDs containerForWebhookIDs) throws IOException {
        deleteWebhookByIdForHttpResponse(containerForWebhookIDs);
    }

  /**
    * Delete webhooks by ID
    * Removes webhooks by ID. Only webhooks registered by the calling Connect app are removed. If webhooks created by other apps are specified, they are ignored.  **[Permissions](#permissions) required:** Only [Connect apps](https://developer.atlassian.com/cloud/jira/platform/integrating-with-jira-cloud/#atlassian-connect) can use this operation.
    * <p><b>202</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the list of webhook IDs is missing.
    * <p><b>403</b> - Returned if the caller is not a Connect app.
    * @param containerForWebhookIDs The containerForWebhookIDs parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteWebhookById(ContainerForWebhookIDs containerForWebhookIDs, Map<String, Object> params) throws IOException {
        deleteWebhookByIdForHttpResponse(containerForWebhookIDs, params);
    }

    public HttpResponse deleteWebhookByIdForHttpResponse(ContainerForWebhookIDs containerForWebhookIDs) throws IOException {
        // verify the required parameter 'containerForWebhookIDs' is set
        if (containerForWebhookIDs == null) {
            throw new IllegalArgumentException("Missing the required parameter 'containerForWebhookIDs' when calling deleteWebhookById");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/webhook");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }

      public HttpResponse deleteWebhookByIdForHttpResponse(java.io.InputStream containerForWebhookIDs, String mediaType) throws IOException {
          // verify the required parameter 'containerForWebhookIDs' is set
              if (containerForWebhookIDs == null) {
              throw new IllegalArgumentException("Missing the required parameter 'containerForWebhookIDs' when calling deleteWebhookById");
              }
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/webhook");

              String localVarUrl = uriBuilder.build().toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = containerForWebhookIDs == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, containerForWebhookIDs);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
      }

    public HttpResponse deleteWebhookByIdForHttpResponse(ContainerForWebhookIDs containerForWebhookIDs, Map<String, Object> params) throws IOException {
        // verify the required parameter 'containerForWebhookIDs' is set
        if (containerForWebhookIDs == null) {
            throw new IllegalArgumentException("Missing the required parameter 'containerForWebhookIDs' when calling deleteWebhookById");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/webhook");

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


  /**
    * Get dynamic webhooks for app
    * Returns a [paginated](#pagination) list of the webhooks registered by the calling app.  **[Permissions](#permissions) required:** Only [Connect apps](https://developer.atlassian.com/cloud/jira/platform/integrating-with-jira-cloud/#atlassian-connect) can use this operation.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>403</b> - Returned if the caller is not a Connect app.
    * @param startAt The index of the first item to return in a page of results (page offset).
    * @param maxResults The maximum number of items to return per page.
    * @return PageBeanWebhook
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanWebhook getDynamicWebhooksForApp(Long startAt, Integer maxResults) throws IOException {
        HttpResponse response = getDynamicWebhooksForAppForHttpResponse(startAt, maxResults);
        TypeReference<PageBeanWebhook> typeRef = new TypeReference<PageBeanWebhook>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get dynamic webhooks for app
    * Returns a [paginated](#pagination) list of the webhooks registered by the calling app.  **[Permissions](#permissions) required:** Only [Connect apps](https://developer.atlassian.com/cloud/jira/platform/integrating-with-jira-cloud/#atlassian-connect) can use this operation.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>403</b> - Returned if the caller is not a Connect app.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PageBeanWebhook
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanWebhook getDynamicWebhooksForApp(Map<String, Object> params) throws IOException {
        HttpResponse response = getDynamicWebhooksForAppForHttpResponse(params);
        TypeReference<PageBeanWebhook> typeRef = new TypeReference<PageBeanWebhook>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getDynamicWebhooksForAppForHttpResponse(Long startAt, Integer maxResults) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/webhook");
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

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getDynamicWebhooksForAppForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/webhook");

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
    * Get failed webhooks
    * Returns webhooks that have recently failed to be delivered to the requesting app after the maximum number of retries.  After 72 hours the failure may no longer be returned by this operation.  The oldest failure is returned first.  This method uses a cursor-based pagination. To request the next page use the failure time of the last webhook on the list as the &#x60;failedAfter&#x60; value or use the URL provided in &#x60;next&#x60;.  **[Permissions](#permissions) required:** Only [Connect apps](https://developer.atlassian.com/cloud/jira/platform/integrating-with-jira-cloud/#atlassian-connect) can use this operation.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - 400 response
    * <p><b>403</b> - Returned if the caller is not a Connect app.
    * @param maxResults The maximum number of webhooks to return per page. If obeying the maxResults directive would result in records with the same failure time being split across pages, the directive is ignored and all records with the same failure time included on the page.
    * @param after The time after which any webhook failure must have occurred for the record to be returned, expressed as milliseconds since the UNIX epoch.
    * @return FailedWebhooks
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public FailedWebhooks getFailedWebhooks(Integer maxResults, Long after) throws IOException {
        HttpResponse response = getFailedWebhooksForHttpResponse(maxResults, after);
        TypeReference<FailedWebhooks> typeRef = new TypeReference<FailedWebhooks>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get failed webhooks
    * Returns webhooks that have recently failed to be delivered to the requesting app after the maximum number of retries.  After 72 hours the failure may no longer be returned by this operation.  The oldest failure is returned first.  This method uses a cursor-based pagination. To request the next page use the failure time of the last webhook on the list as the &#x60;failedAfter&#x60; value or use the URL provided in &#x60;next&#x60;.  **[Permissions](#permissions) required:** Only [Connect apps](https://developer.atlassian.com/cloud/jira/platform/integrating-with-jira-cloud/#atlassian-connect) can use this operation.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - 400 response
    * <p><b>403</b> - Returned if the caller is not a Connect app.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return FailedWebhooks
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public FailedWebhooks getFailedWebhooks(Map<String, Object> params) throws IOException {
        HttpResponse response = getFailedWebhooksForHttpResponse(params);
        TypeReference<FailedWebhooks> typeRef = new TypeReference<FailedWebhooks>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getFailedWebhooksForHttpResponse(Integer maxResults, Long after) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/webhook/failed");
        if (maxResults != null) {
            String key = "maxResults";
            Object value = maxResults;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (after != null) {
            String key = "after";
            Object value = after;
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

    public HttpResponse getFailedWebhooksForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/webhook/failed");

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
    * Extend webhook life
    * Webhooks registered through the REST API expire after 30 days. Call this resource periodically to keep them alive.  Unrecognized webhook IDs (nonexistent or belonging to other apps) are ignored.  **[Permissions](#permissions) required:** Only [Connect apps](https://developer.atlassian.com/cloud/jira/platform/integrating-with-jira-cloud/#atlassian-connect) can use this operation.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>403</b> - Returned if the caller is not a Connect app.
    * @param containerForWebhookIDs The containerForWebhookIDs parameter
    * @return WebhooksExpirationDate
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public WebhooksExpirationDate refreshWebhooks(ContainerForWebhookIDs containerForWebhookIDs) throws IOException {
        HttpResponse response = refreshWebhooksForHttpResponse(containerForWebhookIDs);
        TypeReference<WebhooksExpirationDate> typeRef = new TypeReference<WebhooksExpirationDate>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Extend webhook life
    * Webhooks registered through the REST API expire after 30 days. Call this resource periodically to keep them alive.  Unrecognized webhook IDs (nonexistent or belonging to other apps) are ignored.  **[Permissions](#permissions) required:** Only [Connect apps](https://developer.atlassian.com/cloud/jira/platform/integrating-with-jira-cloud/#atlassian-connect) can use this operation.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>403</b> - Returned if the caller is not a Connect app.
    * @param containerForWebhookIDs The containerForWebhookIDs parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return WebhooksExpirationDate
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public WebhooksExpirationDate refreshWebhooks(ContainerForWebhookIDs containerForWebhookIDs, Map<String, Object> params) throws IOException {
        HttpResponse response = refreshWebhooksForHttpResponse(containerForWebhookIDs, params);
        TypeReference<WebhooksExpirationDate> typeRef = new TypeReference<WebhooksExpirationDate>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse refreshWebhooksForHttpResponse(ContainerForWebhookIDs containerForWebhookIDs) throws IOException {
        // verify the required parameter 'containerForWebhookIDs' is set
        if (containerForWebhookIDs == null) {
            throw new IllegalArgumentException("Missing the required parameter 'containerForWebhookIDs' when calling refreshWebhooks");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/webhook/refresh");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(containerForWebhookIDs);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse refreshWebhooksForHttpResponse(java.io.InputStream containerForWebhookIDs, String mediaType) throws IOException {
          // verify the required parameter 'containerForWebhookIDs' is set
              if (containerForWebhookIDs == null) {
              throw new IllegalArgumentException("Missing the required parameter 'containerForWebhookIDs' when calling refreshWebhooks");
              }
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/webhook/refresh");

              String localVarUrl = uriBuilder.build().toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = containerForWebhookIDs == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, containerForWebhookIDs);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse refreshWebhooksForHttpResponse(ContainerForWebhookIDs containerForWebhookIDs, Map<String, Object> params) throws IOException {
        // verify the required parameter 'containerForWebhookIDs' is set
        if (containerForWebhookIDs == null) {
            throw new IllegalArgumentException("Missing the required parameter 'containerForWebhookIDs' when calling refreshWebhooks");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/webhook/refresh");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(containerForWebhookIDs);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }


  /**
    * Register dynamic webhooks
    * Registers webhooks.  **[Permissions](#permissions) required:** Only [Connect apps](https://developer.atlassian.com/cloud/jira/platform/integrating-with-jira-cloud/#atlassian-connect) can use this operation.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>403</b> - Returned if the caller is not a Connect app.
    * @param webhookRegistrationDetails The webhookRegistrationDetails parameter
    * @return ContainerForRegisteredWebhooks
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ContainerForRegisteredWebhooks registerDynamicWebhooks(WebhookRegistrationDetails webhookRegistrationDetails) throws IOException {
        HttpResponse response = registerDynamicWebhooksForHttpResponse(webhookRegistrationDetails);
        TypeReference<ContainerForRegisteredWebhooks> typeRef = new TypeReference<ContainerForRegisteredWebhooks>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Register dynamic webhooks
    * Registers webhooks.  **[Permissions](#permissions) required:** Only [Connect apps](https://developer.atlassian.com/cloud/jira/platform/integrating-with-jira-cloud/#atlassian-connect) can use this operation.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>403</b> - Returned if the caller is not a Connect app.
    * @param webhookRegistrationDetails The webhookRegistrationDetails parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return ContainerForRegisteredWebhooks
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ContainerForRegisteredWebhooks registerDynamicWebhooks(WebhookRegistrationDetails webhookRegistrationDetails, Map<String, Object> params) throws IOException {
        HttpResponse response = registerDynamicWebhooksForHttpResponse(webhookRegistrationDetails, params);
        TypeReference<ContainerForRegisteredWebhooks> typeRef = new TypeReference<ContainerForRegisteredWebhooks>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse registerDynamicWebhooksForHttpResponse(WebhookRegistrationDetails webhookRegistrationDetails) throws IOException {
        // verify the required parameter 'webhookRegistrationDetails' is set
        if (webhookRegistrationDetails == null) {
            throw new IllegalArgumentException("Missing the required parameter 'webhookRegistrationDetails' when calling registerDynamicWebhooks");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/webhook");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(webhookRegistrationDetails);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse registerDynamicWebhooksForHttpResponse(java.io.InputStream webhookRegistrationDetails, String mediaType) throws IOException {
          // verify the required parameter 'webhookRegistrationDetails' is set
              if (webhookRegistrationDetails == null) {
              throw new IllegalArgumentException("Missing the required parameter 'webhookRegistrationDetails' when calling registerDynamicWebhooks");
              }
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/webhook");

              String localVarUrl = uriBuilder.build().toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = webhookRegistrationDetails == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, webhookRegistrationDetails);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse registerDynamicWebhooksForHttpResponse(WebhookRegistrationDetails webhookRegistrationDetails, Map<String, Object> params) throws IOException {
        // verify the required parameter 'webhookRegistrationDetails' is set
        if (webhookRegistrationDetails == null) {
            throw new IllegalArgumentException("Missing the required parameter 'webhookRegistrationDetails' when calling registerDynamicWebhooks");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/webhook");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(webhookRegistrationDetails);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


}
