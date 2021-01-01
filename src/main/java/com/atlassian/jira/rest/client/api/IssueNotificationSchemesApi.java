package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.NotificationScheme;
import com.atlassian.jira.rest.client.model.PageBeanNotificationScheme;

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
public class IssueNotificationSchemesApi {
    private ApiClient apiClient;

    public IssueNotificationSchemesApi() {
        this(new ApiClient());
    }

    public IssueNotificationSchemesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Get notification scheme
    * Returns a [notification scheme](https://confluence.atlassian.com/x/8YdKLg), including the list of events and the recipients who will receive notifications for those events.  **[Permissions](#permissions) required:** Permission to access Jira, however the user must have permission to administer at least one project associated with the notification scheme.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the notification scheme is not found or the user does not have permission to view it.
    * @param id The ID of the notification scheme. Use [Get notification schemes paginated](#api-rest-api-3-notificationscheme-get) to get a list of notification scheme IDs.
    * @param expand Use [expand](#expansion) to include additional information in the response. This parameter accepts a comma-separated list. Expand options include:   *  &#x60;all&#x60; Returns all expandable information.  *  &#x60;field&#x60; Returns information about any custom fields assigned to receive an event.  *  &#x60;group&#x60; Returns information about any groups assigned to receive an event.  *  &#x60;notificationSchemeEvents&#x60; Returns a list of event associations. This list is returned for all expandable information.  *  &#x60;projectRole&#x60; Returns information about any project roles assigned to receive an event.  *  &#x60;user&#x60; Returns information about any users assigned to receive an event.
    * @return NotificationScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public NotificationScheme getNotificationScheme(Long id, String expand) throws IOException {
        HttpResponse response = getNotificationSchemeForHttpResponse(id, expand);
        TypeReference<NotificationScheme> typeRef = new TypeReference<NotificationScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get notification scheme
    * Returns a [notification scheme](https://confluence.atlassian.com/x/8YdKLg), including the list of events and the recipients who will receive notifications for those events.  **[Permissions](#permissions) required:** Permission to access Jira, however the user must have permission to administer at least one project associated with the notification scheme.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the notification scheme is not found or the user does not have permission to view it.
    * @param id The ID of the notification scheme. Use [Get notification schemes paginated](#api-rest-api-3-notificationscheme-get) to get a list of notification scheme IDs.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return NotificationScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public NotificationScheme getNotificationScheme(Long id, Map<String, Object> params) throws IOException {
        HttpResponse response = getNotificationSchemeForHttpResponse(id, params);
        TypeReference<NotificationScheme> typeRef = new TypeReference<NotificationScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getNotificationSchemeForHttpResponse(Long id, String expand) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling getNotificationScheme");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/notificationscheme/{id}");
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

    public HttpResponse getNotificationSchemeForHttpResponse(Long id, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling getNotificationScheme");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/notificationscheme/{id}");

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
    * Get notification schemes paginated
    * Returns a [paginated](#pagination) list of [notification schemes](https://confluence.atlassian.com/x/8YdKLg) ordered by display name.  ### About notification schemes ###  A notification scheme is a list of events and recipients who will receive notifications for those events. The list is contained within the &#x60;notificationSchemeEvents&#x60; object and contains pairs of &#x60;events&#x60; and &#x60;notifications&#x60;:   *  &#x60;event&#x60; Identifies the type of event. The events can be [Jira system events](https://confluence.atlassian.com/x/8YdKLg#Creatinganotificationscheme-eventsEvents) or [custom events](https://confluence.atlassian.com/x/AIlKLg).  *  &#x60;notifications&#x60; Identifies the [recipients](https://confluence.atlassian.com/x/8YdKLg#Creatinganotificationscheme-recipientsRecipients) of notifications for each event. Recipients can be any of the following types:           *  &#x60;CurrentAssignee&#x60;      *  &#x60;Reporter&#x60;      *  &#x60;CurrentUser&#x60;      *  &#x60;ProjectLead&#x60;      *  &#x60;ComponentLead&#x60;      *  &#x60;User&#x60; (the &#x60;parameter&#x60; is the user key)      *  &#x60;Group&#x60; (the &#x60;parameter&#x60; is the group name)      *  &#x60;ProjectRole&#x60; (the &#x60;parameter&#x60; is the project role ID)      *  &#x60;EmailAddress&#x60;      *  &#x60;AllWatchers&#x60;      *  &#x60;UserCustomField&#x60; (the &#x60;parameter&#x60; is the ID of the custom field)      *  &#x60;GroupCustomField&#x60;(the &#x60;parameter&#x60; is the ID of the custom field)  *Note that you should allow for events without recipients to appear in responses.*  **[Permissions](#permissions) required:** Permission to access Jira, however the user must have permission to administer at least one project associated with a notification scheme for it to be returned.
    * <p><b>200</b> - Returned if the request is successful. Only returns notification schemes that the user has permission to access. An empty list is returned if the user lacks permission to access all notification schemes.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param startAt The index of the first item to return in a page of results (page offset).
    * @param maxResults The maximum number of items to return per page.
    * @param expand Use [expand](#expansion) to include additional information in the response. This parameter accepts a comma-separated list. Expand options include:   *  &#x60;all&#x60; Returns all expandable information.  *  &#x60;field&#x60; Returns information about any custom fields assigned to receive an event.  *  &#x60;group&#x60; Returns information about any groups assigned to receive an event.  *  &#x60;notificationSchemeEvents&#x60; Returns a list of event associations. This list is returned for all expandable information.  *  &#x60;projectRole&#x60; Returns information about any project roles assigned to receive an event.  *  &#x60;user&#x60; Returns information about any users assigned to receive an event.
    * @return PageBeanNotificationScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanNotificationScheme getNotificationSchemes(Long startAt, Integer maxResults, String expand) throws IOException {
        HttpResponse response = getNotificationSchemesForHttpResponse(startAt, maxResults, expand);
        TypeReference<PageBeanNotificationScheme> typeRef = new TypeReference<PageBeanNotificationScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get notification schemes paginated
    * Returns a [paginated](#pagination) list of [notification schemes](https://confluence.atlassian.com/x/8YdKLg) ordered by display name.  ### About notification schemes ###  A notification scheme is a list of events and recipients who will receive notifications for those events. The list is contained within the &#x60;notificationSchemeEvents&#x60; object and contains pairs of &#x60;events&#x60; and &#x60;notifications&#x60;:   *  &#x60;event&#x60; Identifies the type of event. The events can be [Jira system events](https://confluence.atlassian.com/x/8YdKLg#Creatinganotificationscheme-eventsEvents) or [custom events](https://confluence.atlassian.com/x/AIlKLg).  *  &#x60;notifications&#x60; Identifies the [recipients](https://confluence.atlassian.com/x/8YdKLg#Creatinganotificationscheme-recipientsRecipients) of notifications for each event. Recipients can be any of the following types:           *  &#x60;CurrentAssignee&#x60;      *  &#x60;Reporter&#x60;      *  &#x60;CurrentUser&#x60;      *  &#x60;ProjectLead&#x60;      *  &#x60;ComponentLead&#x60;      *  &#x60;User&#x60; (the &#x60;parameter&#x60; is the user key)      *  &#x60;Group&#x60; (the &#x60;parameter&#x60; is the group name)      *  &#x60;ProjectRole&#x60; (the &#x60;parameter&#x60; is the project role ID)      *  &#x60;EmailAddress&#x60;      *  &#x60;AllWatchers&#x60;      *  &#x60;UserCustomField&#x60; (the &#x60;parameter&#x60; is the ID of the custom field)      *  &#x60;GroupCustomField&#x60;(the &#x60;parameter&#x60; is the ID of the custom field)  *Note that you should allow for events without recipients to appear in responses.*  **[Permissions](#permissions) required:** Permission to access Jira, however the user must have permission to administer at least one project associated with a notification scheme for it to be returned.
    * <p><b>200</b> - Returned if the request is successful. Only returns notification schemes that the user has permission to access. An empty list is returned if the user lacks permission to access all notification schemes.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PageBeanNotificationScheme
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanNotificationScheme getNotificationSchemes(Map<String, Object> params) throws IOException {
        HttpResponse response = getNotificationSchemesForHttpResponse(params);
        TypeReference<PageBeanNotificationScheme> typeRef = new TypeReference<PageBeanNotificationScheme>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getNotificationSchemesForHttpResponse(Long startAt, Integer maxResults, String expand) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/notificationscheme");
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

    public HttpResponse getNotificationSchemesForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/notificationscheme");

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


}
