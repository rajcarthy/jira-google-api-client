package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.IssueFieldOption;
import com.atlassian.jira.rest.client.model.PageBeanIssueFieldOption;
import com.atlassian.jira.rest.client.model.TaskProgressBeanRemoveOptionFromIssuesResult;

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
public class IssueCustomFieldOptionsAppsApi {
    private ApiClient apiClient;

    public IssueCustomFieldOptionsAppsApi() {
        this(new ApiClient());
    }

    public IssueCustomFieldOptionsAppsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Create issue field option
    * Creates an option for a select list issue field.  Note that this operation **only works for issue field select list options added by Connect apps**, it cannot be used with issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg). Jira permissions are not required for the app providing the field.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the option is invalid.
    * <p><b>403</b> - Returned if the request is not authenticated as a Jira administrator or the app that provided the field.
    * <p><b>404</b> - Returned if the field is not found or does not support options.
    * @param fieldKey The field key is specified in the following format: **$(app-key)\\_\\_$(field-key)**. For example, *example-add-on\\_\\_example-issue-field*. To determine the &#x60;fieldKey&#x60; value, do one of the following:   *  open the app&#39;s plugin descriptor, then **app-key** is the key at the top and **field-key** is the key in the &#x60;jiraIssueFields&#x60; module. **app-key** can also be found in the app listing in the Atlassian Universal Plugin Manager.  *  run [Get fields](#api-rest-api-3-field-get) and in the field details the value is returned in &#x60;key&#x60;. For example, &#x60;\&quot;key\&quot;: \&quot;teams-add-on__team-issue-field\&quot;&#x60;
    * @param requestBody The requestBody parameter
    * @return IssueFieldOption
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public IssueFieldOption createIssueFieldOption(String fieldKey, Map<String, Object> requestBody) throws IOException {
        HttpResponse response = createIssueFieldOptionForHttpResponse(fieldKey, requestBody);
        TypeReference<IssueFieldOption> typeRef = new TypeReference<IssueFieldOption>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Create issue field option
    * Creates an option for a select list issue field.  Note that this operation **only works for issue field select list options added by Connect apps**, it cannot be used with issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg). Jira permissions are not required for the app providing the field.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the option is invalid.
    * <p><b>403</b> - Returned if the request is not authenticated as a Jira administrator or the app that provided the field.
    * <p><b>404</b> - Returned if the field is not found or does not support options.
    * @param fieldKey The field key is specified in the following format: **$(app-key)\\_\\_$(field-key)**. For example, *example-add-on\\_\\_example-issue-field*. To determine the &#x60;fieldKey&#x60; value, do one of the following:   *  open the app&#39;s plugin descriptor, then **app-key** is the key at the top and **field-key** is the key in the &#x60;jiraIssueFields&#x60; module. **app-key** can also be found in the app listing in the Atlassian Universal Plugin Manager.  *  run [Get fields](#api-rest-api-3-field-get) and in the field details the value is returned in &#x60;key&#x60;. For example, &#x60;\&quot;key\&quot;: \&quot;teams-add-on__team-issue-field\&quot;&#x60;
    * @param requestBody The requestBody parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return IssueFieldOption
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public IssueFieldOption createIssueFieldOption(String fieldKey, Map<String, Object> requestBody, Map<String, Object> params) throws IOException {
        HttpResponse response = createIssueFieldOptionForHttpResponse(fieldKey, requestBody, params);
        TypeReference<IssueFieldOption> typeRef = new TypeReference<IssueFieldOption>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse createIssueFieldOptionForHttpResponse(String fieldKey, Map<String, Object> requestBody) throws IOException {
        // verify the required parameter 'fieldKey' is set
        if (fieldKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldKey' when calling createIssueFieldOption");
        }// verify the required parameter 'requestBody' is set
        if (requestBody == null) {
            throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling createIssueFieldOption");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldKey", fieldKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldKey}/option");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(requestBody);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse createIssueFieldOptionForHttpResponse(String fieldKey, java.io.InputStream requestBody, String mediaType) throws IOException {
          // verify the required parameter 'fieldKey' is set
              if (fieldKey == null) {
              throw new IllegalArgumentException("Missing the required parameter 'fieldKey' when calling createIssueFieldOption");
              }// verify the required parameter 'requestBody' is set
              if (requestBody == null) {
              throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling createIssueFieldOption");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("fieldKey", fieldKey);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldKey}/option");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = requestBody == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, requestBody);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse createIssueFieldOptionForHttpResponse(String fieldKey, Map<String, Object> requestBody, Map<String, Object> params) throws IOException {
        // verify the required parameter 'fieldKey' is set
        if (fieldKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldKey' when calling createIssueFieldOption");
        }// verify the required parameter 'requestBody' is set
        if (requestBody == null) {
            throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling createIssueFieldOption");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldKey", fieldKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldKey}/option");

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
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


  /**
    * Delete issue field option
    * Deletes an option from a select list issue field.  Note that this operation **only works for issue field select list options added by Connect apps**, it cannot be used with issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg). Jira permissions are not required for the app providing the field.
    * <p><b>204</b> - Returned if the field option is deleted.
    * <p><b>403</b> - Returned if the request is not authenticated as a Jira administrator or the app that provided the field.
    * <p><b>404</b> - Returned if the field or option is not found.
    * <p><b>409</b> - Returned if the option is selected for the field in any issue.
    * @param fieldKey The field key is specified in the following format: **$(app-key)\\_\\_$(field-key)**. For example, *example-add-on\\_\\_example-issue-field*. To determine the &#x60;fieldKey&#x60; value, do one of the following:   *  open the app&#39;s plugin descriptor, then **app-key** is the key at the top and **field-key** is the key in the &#x60;jiraIssueFields&#x60; module. **app-key** can also be found in the app listing in the Atlassian Universal Plugin Manager.  *  run [Get fields](#api-rest-api-3-field-get) and in the field details the value is returned in &#x60;key&#x60;. For example, &#x60;\&quot;key\&quot;: \&quot;teams-add-on__team-issue-field\&quot;&#x60;
    * @param optionId The ID of the option to be deleted.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object deleteIssueFieldOption(String fieldKey, Long optionId) throws IOException {
        HttpResponse response = deleteIssueFieldOptionForHttpResponse(fieldKey, optionId);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Delete issue field option
    * Deletes an option from a select list issue field.  Note that this operation **only works for issue field select list options added by Connect apps**, it cannot be used with issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg). Jira permissions are not required for the app providing the field.
    * <p><b>204</b> - Returned if the field option is deleted.
    * <p><b>403</b> - Returned if the request is not authenticated as a Jira administrator or the app that provided the field.
    * <p><b>404</b> - Returned if the field or option is not found.
    * <p><b>409</b> - Returned if the option is selected for the field in any issue.
    * @param fieldKey The field key is specified in the following format: **$(app-key)\\_\\_$(field-key)**. For example, *example-add-on\\_\\_example-issue-field*. To determine the &#x60;fieldKey&#x60; value, do one of the following:   *  open the app&#39;s plugin descriptor, then **app-key** is the key at the top and **field-key** is the key in the &#x60;jiraIssueFields&#x60; module. **app-key** can also be found in the app listing in the Atlassian Universal Plugin Manager.  *  run [Get fields](#api-rest-api-3-field-get) and in the field details the value is returned in &#x60;key&#x60;. For example, &#x60;\&quot;key\&quot;: \&quot;teams-add-on__team-issue-field\&quot;&#x60;
    * @param optionId The ID of the option to be deleted.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object deleteIssueFieldOption(String fieldKey, Long optionId, Map<String, Object> params) throws IOException {
        HttpResponse response = deleteIssueFieldOptionForHttpResponse(fieldKey, optionId, params);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse deleteIssueFieldOptionForHttpResponse(String fieldKey, Long optionId) throws IOException {
        // verify the required parameter 'fieldKey' is set
        if (fieldKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldKey' when calling deleteIssueFieldOption");
        }// verify the required parameter 'optionId' is set
        if (optionId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'optionId' when calling deleteIssueFieldOption");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldKey", fieldKey);
        uriVariables.put("optionId", optionId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldKey}/option/{optionId}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }

    public HttpResponse deleteIssueFieldOptionForHttpResponse(String fieldKey, Long optionId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'fieldKey' is set
        if (fieldKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldKey' when calling deleteIssueFieldOption");
        }// verify the required parameter 'optionId' is set
        if (optionId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'optionId' when calling deleteIssueFieldOption");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldKey", fieldKey);
        uriVariables.put("optionId", optionId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldKey}/option/{optionId}");

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
    * Get all issue field options
    * Returns a [paginated](#pagination) list of all the options of a select list issue field. A select list issue field is a type of [issue field](https://developer.atlassian.com/cloud/jira/platform/modules/issue-field/) that enables a user to select a value from a list of options.  Note that this operation **only works for issue field select list options added by Connect apps**, it cannot be used with issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg). Jira permissions are not required for the app providing the field.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the field is not found or does not support options.
    * <p><b>403</b> - Returned if the request is not authenticated as a Jira administrator or the app that provided the field.
    * @param fieldKey The field key is specified in the following format: **$(app-key)\\_\\_$(field-key)**. For example, *example-add-on\\_\\_example-issue-field*. To determine the &#x60;fieldKey&#x60; value, do one of the following:   *  open the app&#39;s plugin descriptor, then **app-key** is the key at the top and **field-key** is the key in the &#x60;jiraIssueFields&#x60; module. **app-key** can also be found in the app listing in the Atlassian Universal Plugin Manager.  *  run [Get fields](#api-rest-api-3-field-get) and in the field details the value is returned in &#x60;key&#x60;. For example, &#x60;\&quot;key\&quot;: \&quot;teams-add-on__team-issue-field\&quot;&#x60;
    * @param startAt The index of the first item to return in a page of results (page offset).
    * @param maxResults The maximum number of items to return per page.
    * @return PageBeanIssueFieldOption
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanIssueFieldOption getAllIssueFieldOptions(String fieldKey, Long startAt, Integer maxResults) throws IOException {
        HttpResponse response = getAllIssueFieldOptionsForHttpResponse(fieldKey, startAt, maxResults);
        TypeReference<PageBeanIssueFieldOption> typeRef = new TypeReference<PageBeanIssueFieldOption>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get all issue field options
    * Returns a [paginated](#pagination) list of all the options of a select list issue field. A select list issue field is a type of [issue field](https://developer.atlassian.com/cloud/jira/platform/modules/issue-field/) that enables a user to select a value from a list of options.  Note that this operation **only works for issue field select list options added by Connect apps**, it cannot be used with issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg). Jira permissions are not required for the app providing the field.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the field is not found or does not support options.
    * <p><b>403</b> - Returned if the request is not authenticated as a Jira administrator or the app that provided the field.
    * @param fieldKey The field key is specified in the following format: **$(app-key)\\_\\_$(field-key)**. For example, *example-add-on\\_\\_example-issue-field*. To determine the &#x60;fieldKey&#x60; value, do one of the following:   *  open the app&#39;s plugin descriptor, then **app-key** is the key at the top and **field-key** is the key in the &#x60;jiraIssueFields&#x60; module. **app-key** can also be found in the app listing in the Atlassian Universal Plugin Manager.  *  run [Get fields](#api-rest-api-3-field-get) and in the field details the value is returned in &#x60;key&#x60;. For example, &#x60;\&quot;key\&quot;: \&quot;teams-add-on__team-issue-field\&quot;&#x60;
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PageBeanIssueFieldOption
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanIssueFieldOption getAllIssueFieldOptions(String fieldKey, Map<String, Object> params) throws IOException {
        HttpResponse response = getAllIssueFieldOptionsForHttpResponse(fieldKey, params);
        TypeReference<PageBeanIssueFieldOption> typeRef = new TypeReference<PageBeanIssueFieldOption>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getAllIssueFieldOptionsForHttpResponse(String fieldKey, Long startAt, Integer maxResults) throws IOException {
        // verify the required parameter 'fieldKey' is set
        if (fieldKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldKey' when calling getAllIssueFieldOptions");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldKey", fieldKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldKey}/option");
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

    public HttpResponse getAllIssueFieldOptionsForHttpResponse(String fieldKey, Map<String, Object> params) throws IOException {
        // verify the required parameter 'fieldKey' is set
        if (fieldKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldKey' when calling getAllIssueFieldOptions");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldKey", fieldKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldKey}/option");

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
    * Get issue field option
    * Returns an option from a select list issue field.  Note that this operation **only works for issue field select list options added by Connect apps**, it cannot be used with issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg). Jira permissions are not required for the app providing the field.
    * <p><b>200</b> - Returned if the requested option is returned.
    * <p><b>400</b> - Returned if the field is not found or does not support options.
    * <p><b>403</b> - Returned if the request is not authenticated as a Jira administrator or the app that provided the field.
    * <p><b>404</b> - Returned if the option is not found.
    * @param fieldKey The field key is specified in the following format: **$(app-key)\\_\\_$(field-key)**. For example, *example-add-on\\_\\_example-issue-field*. To determine the &#x60;fieldKey&#x60; value, do one of the following:   *  open the app&#39;s plugin descriptor, then **app-key** is the key at the top and **field-key** is the key in the &#x60;jiraIssueFields&#x60; module. **app-key** can also be found in the app listing in the Atlassian Universal Plugin Manager.  *  run [Get fields](#api-rest-api-3-field-get) and in the field details the value is returned in &#x60;key&#x60;. For example, &#x60;\&quot;key\&quot;: \&quot;teams-add-on__team-issue-field\&quot;&#x60;
    * @param optionId The ID of the option to be returned.
    * @return IssueFieldOption
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public IssueFieldOption getIssueFieldOption(String fieldKey, Long optionId) throws IOException {
        HttpResponse response = getIssueFieldOptionForHttpResponse(fieldKey, optionId);
        TypeReference<IssueFieldOption> typeRef = new TypeReference<IssueFieldOption>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get issue field option
    * Returns an option from a select list issue field.  Note that this operation **only works for issue field select list options added by Connect apps**, it cannot be used with issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg). Jira permissions are not required for the app providing the field.
    * <p><b>200</b> - Returned if the requested option is returned.
    * <p><b>400</b> - Returned if the field is not found or does not support options.
    * <p><b>403</b> - Returned if the request is not authenticated as a Jira administrator or the app that provided the field.
    * <p><b>404</b> - Returned if the option is not found.
    * @param fieldKey The field key is specified in the following format: **$(app-key)\\_\\_$(field-key)**. For example, *example-add-on\\_\\_example-issue-field*. To determine the &#x60;fieldKey&#x60; value, do one of the following:   *  open the app&#39;s plugin descriptor, then **app-key** is the key at the top and **field-key** is the key in the &#x60;jiraIssueFields&#x60; module. **app-key** can also be found in the app listing in the Atlassian Universal Plugin Manager.  *  run [Get fields](#api-rest-api-3-field-get) and in the field details the value is returned in &#x60;key&#x60;. For example, &#x60;\&quot;key\&quot;: \&quot;teams-add-on__team-issue-field\&quot;&#x60;
    * @param optionId The ID of the option to be returned.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return IssueFieldOption
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public IssueFieldOption getIssueFieldOption(String fieldKey, Long optionId, Map<String, Object> params) throws IOException {
        HttpResponse response = getIssueFieldOptionForHttpResponse(fieldKey, optionId, params);
        TypeReference<IssueFieldOption> typeRef = new TypeReference<IssueFieldOption>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getIssueFieldOptionForHttpResponse(String fieldKey, Long optionId) throws IOException {
        // verify the required parameter 'fieldKey' is set
        if (fieldKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldKey' when calling getIssueFieldOption");
        }// verify the required parameter 'optionId' is set
        if (optionId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'optionId' when calling getIssueFieldOption");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldKey", fieldKey);
        uriVariables.put("optionId", optionId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldKey}/option/{optionId}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getIssueFieldOptionForHttpResponse(String fieldKey, Long optionId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'fieldKey' is set
        if (fieldKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldKey' when calling getIssueFieldOption");
        }// verify the required parameter 'optionId' is set
        if (optionId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'optionId' when calling getIssueFieldOption");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldKey", fieldKey);
        uriVariables.put("optionId", optionId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldKey}/option/{optionId}");

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
    * Get selectable issue field options
    * Returns a [paginated](#pagination) list of options for a select list issue field that can be viewed and selected by the user.  Note that this operation **only works for issue field select list options added by Connect apps**, it cannot be used with issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource.  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the field is not found or does not support options.
    * @param fieldKey The field key is specified in the following format: **$(app-key)\\_\\_$(field-key)**. For example, *example-add-on\\_\\_example-issue-field*. To determine the &#x60;fieldKey&#x60; value, do one of the following:   *  open the app&#39;s plugin descriptor, then **app-key** is the key at the top and **field-key** is the key in the &#x60;jiraIssueFields&#x60; module. **app-key** can also be found in the app listing in the Atlassian Universal Plugin Manager.  *  run [Get fields](#api-rest-api-3-field-get) and in the field details the value is returned in &#x60;key&#x60;. For example, &#x60;\&quot;key\&quot;: \&quot;teams-add-on__team-issue-field\&quot;&#x60;
    * @param startAt The index of the first item to return in a page of results (page offset).
    * @param maxResults The maximum number of items to return per page.
    * @param projectId Filters the results to options that are only available in the specified project.
    * @return PageBeanIssueFieldOption
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanIssueFieldOption getSelectableIssueFieldOptions(String fieldKey, Long startAt, Integer maxResults, Long projectId) throws IOException {
        HttpResponse response = getSelectableIssueFieldOptionsForHttpResponse(fieldKey, startAt, maxResults, projectId);
        TypeReference<PageBeanIssueFieldOption> typeRef = new TypeReference<PageBeanIssueFieldOption>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get selectable issue field options
    * Returns a [paginated](#pagination) list of options for a select list issue field that can be viewed and selected by the user.  Note that this operation **only works for issue field select list options added by Connect apps**, it cannot be used with issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource.  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the field is not found or does not support options.
    * @param fieldKey The field key is specified in the following format: **$(app-key)\\_\\_$(field-key)**. For example, *example-add-on\\_\\_example-issue-field*. To determine the &#x60;fieldKey&#x60; value, do one of the following:   *  open the app&#39;s plugin descriptor, then **app-key** is the key at the top and **field-key** is the key in the &#x60;jiraIssueFields&#x60; module. **app-key** can also be found in the app listing in the Atlassian Universal Plugin Manager.  *  run [Get fields](#api-rest-api-3-field-get) and in the field details the value is returned in &#x60;key&#x60;. For example, &#x60;\&quot;key\&quot;: \&quot;teams-add-on__team-issue-field\&quot;&#x60;
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PageBeanIssueFieldOption
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanIssueFieldOption getSelectableIssueFieldOptions(String fieldKey, Map<String, Object> params) throws IOException {
        HttpResponse response = getSelectableIssueFieldOptionsForHttpResponse(fieldKey, params);
        TypeReference<PageBeanIssueFieldOption> typeRef = new TypeReference<PageBeanIssueFieldOption>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getSelectableIssueFieldOptionsForHttpResponse(String fieldKey, Long startAt, Integer maxResults, Long projectId) throws IOException {
        // verify the required parameter 'fieldKey' is set
        if (fieldKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldKey' when calling getSelectableIssueFieldOptions");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldKey", fieldKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldKey}/option/suggestions/edit");
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

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getSelectableIssueFieldOptionsForHttpResponse(String fieldKey, Map<String, Object> params) throws IOException {
        // verify the required parameter 'fieldKey' is set
        if (fieldKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldKey' when calling getSelectableIssueFieldOptions");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldKey", fieldKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldKey}/option/suggestions/edit");

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
    * Get visible issue field options
    * Returns a [paginated](#pagination) list of options for a select list issue field that can be viewed by the user.  Note that this operation **only works for issue field select list options added by Connect apps**, it cannot be used with issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource.  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the field is not found or does not support options.
    * @param fieldKey The field key is specified in the following format: **$(app-key)\\_\\_$(field-key)**. For example, *example-add-on\\_\\_example-issue-field*. To determine the &#x60;fieldKey&#x60; value, do one of the following:   *  open the app&#39;s plugin descriptor, then **app-key** is the key at the top and **field-key** is the key in the &#x60;jiraIssueFields&#x60; module. **app-key** can also be found in the app listing in the Atlassian Universal Plugin Manager.  *  run [Get fields](#api-rest-api-3-field-get) and in the field details the value is returned in &#x60;key&#x60;. For example, &#x60;\&quot;key\&quot;: \&quot;teams-add-on__team-issue-field\&quot;&#x60;
    * @param startAt The index of the first item to return in a page of results (page offset).
    * @param maxResults The maximum number of items to return per page.
    * @param projectId Filters the results to options that are only available in the specified project.
    * @return PageBeanIssueFieldOption
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanIssueFieldOption getVisibleIssueFieldOptions(String fieldKey, Long startAt, Integer maxResults, Long projectId) throws IOException {
        HttpResponse response = getVisibleIssueFieldOptionsForHttpResponse(fieldKey, startAt, maxResults, projectId);
        TypeReference<PageBeanIssueFieldOption> typeRef = new TypeReference<PageBeanIssueFieldOption>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get visible issue field options
    * Returns a [paginated](#pagination) list of options for a select list issue field that can be viewed by the user.  Note that this operation **only works for issue field select list options added by Connect apps**, it cannot be used with issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource.  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the field is not found or does not support options.
    * @param fieldKey The field key is specified in the following format: **$(app-key)\\_\\_$(field-key)**. For example, *example-add-on\\_\\_example-issue-field*. To determine the &#x60;fieldKey&#x60; value, do one of the following:   *  open the app&#39;s plugin descriptor, then **app-key** is the key at the top and **field-key** is the key in the &#x60;jiraIssueFields&#x60; module. **app-key** can also be found in the app listing in the Atlassian Universal Plugin Manager.  *  run [Get fields](#api-rest-api-3-field-get) and in the field details the value is returned in &#x60;key&#x60;. For example, &#x60;\&quot;key\&quot;: \&quot;teams-add-on__team-issue-field\&quot;&#x60;
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PageBeanIssueFieldOption
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanIssueFieldOption getVisibleIssueFieldOptions(String fieldKey, Map<String, Object> params) throws IOException {
        HttpResponse response = getVisibleIssueFieldOptionsForHttpResponse(fieldKey, params);
        TypeReference<PageBeanIssueFieldOption> typeRef = new TypeReference<PageBeanIssueFieldOption>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getVisibleIssueFieldOptionsForHttpResponse(String fieldKey, Long startAt, Integer maxResults, Long projectId) throws IOException {
        // verify the required parameter 'fieldKey' is set
        if (fieldKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldKey' when calling getVisibleIssueFieldOptions");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldKey", fieldKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldKey}/option/suggestions/search");
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

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getVisibleIssueFieldOptionsForHttpResponse(String fieldKey, Map<String, Object> params) throws IOException {
        // verify the required parameter 'fieldKey' is set
        if (fieldKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldKey' when calling getVisibleIssueFieldOptions");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldKey", fieldKey);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldKey}/option/suggestions/search");

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
    * Replace issue field option
    * Deselects an issue-field select-list option from all issues where it is selected. A different option can be selected to replace the deselected option. The update can also be limited to a smaller set of issues by using a JQL query.  This is an [asynchronous operation](#async). The response object contains a link to the long-running task.  Note that this operation **only works for issue field select list options added by Connect apps**, it cannot be used with issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg). Jira permissions are not required for the app providing the field.
    * <p><b>303</b> - Returned if the long-running task to deselect the option is started.
    * <p><b>400</b> - Returned if the JQL query is invalid.
    * <p><b>404</b> - Returned if the field is not found or does not support options, or the options to be replaced are not found.
    * @param fieldKey The field key is specified in the following format: **$(app-key)\\_\\_$(field-key)**. For example, *example-add-on\\_\\_example-issue-field*. To determine the &#x60;fieldKey&#x60; value, do one of the following:   *  open the app&#39;s plugin descriptor, then **app-key** is the key at the top and **field-key** is the key in the &#x60;jiraIssueFields&#x60; module. **app-key** can also be found in the app listing in the Atlassian Universal Plugin Manager.  *  run [Get fields](#api-rest-api-3-field-get) and in the field details the value is returned in &#x60;key&#x60;. For example, &#x60;\&quot;key\&quot;: \&quot;teams-add-on__team-issue-field\&quot;&#x60;
    * @param optionId The ID of the option to be deselected.
    * @param replaceWith The ID of the option that will replace the currently selected option.
    * @param jql A JQL query that specifies the issues to be updated. For example, *project&#x3D;10000*.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void replaceIssueFieldOption(String fieldKey, Long optionId, Long replaceWith, String jql) throws IOException {
        replaceIssueFieldOptionForHttpResponse(fieldKey, optionId, replaceWith, jql);
    }

  /**
    * Replace issue field option
    * Deselects an issue-field select-list option from all issues where it is selected. A different option can be selected to replace the deselected option. The update can also be limited to a smaller set of issues by using a JQL query.  This is an [asynchronous operation](#async). The response object contains a link to the long-running task.  Note that this operation **only works for issue field select list options added by Connect apps**, it cannot be used with issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg). Jira permissions are not required for the app providing the field.
    * <p><b>303</b> - Returned if the long-running task to deselect the option is started.
    * <p><b>400</b> - Returned if the JQL query is invalid.
    * <p><b>404</b> - Returned if the field is not found or does not support options, or the options to be replaced are not found.
    * @param fieldKey The field key is specified in the following format: **$(app-key)\\_\\_$(field-key)**. For example, *example-add-on\\_\\_example-issue-field*. To determine the &#x60;fieldKey&#x60; value, do one of the following:   *  open the app&#39;s plugin descriptor, then **app-key** is the key at the top and **field-key** is the key in the &#x60;jiraIssueFields&#x60; module. **app-key** can also be found in the app listing in the Atlassian Universal Plugin Manager.  *  run [Get fields](#api-rest-api-3-field-get) and in the field details the value is returned in &#x60;key&#x60;. For example, &#x60;\&quot;key\&quot;: \&quot;teams-add-on__team-issue-field\&quot;&#x60;
    * @param optionId The ID of the option to be deselected.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void replaceIssueFieldOption(String fieldKey, Long optionId, Map<String, Object> params) throws IOException {
        replaceIssueFieldOptionForHttpResponse(fieldKey, optionId, params);
    }

    public HttpResponse replaceIssueFieldOptionForHttpResponse(String fieldKey, Long optionId, Long replaceWith, String jql) throws IOException {
        // verify the required parameter 'fieldKey' is set
        if (fieldKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldKey' when calling replaceIssueFieldOption");
        }// verify the required parameter 'optionId' is set
        if (optionId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'optionId' when calling replaceIssueFieldOption");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldKey", fieldKey);
        uriVariables.put("optionId", optionId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldKey}/option/{optionId}/issue");
        if (replaceWith != null) {
            String key = "replaceWith";
            Object value = replaceWith;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (jql != null) {
            String key = "jql";
            Object value = jql;
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

    public HttpResponse replaceIssueFieldOptionForHttpResponse(String fieldKey, Long optionId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'fieldKey' is set
        if (fieldKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldKey' when calling replaceIssueFieldOption");
        }// verify the required parameter 'optionId' is set
        if (optionId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'optionId' when calling replaceIssueFieldOption");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldKey", fieldKey);
        uriVariables.put("optionId", optionId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldKey}/option/{optionId}/issue");

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
    * Update issue field option
    * Updates or creates an option for a select list issue field. This operation requires that the option ID is provided when creating an option, therefore, the option ID needs to be specified as a path and body parameter. The option ID provided in the path and body must be identical.  Note that this operation **only works for issue field select list options added by Connect apps**, it cannot be used with issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg). Jira permissions are not required for the app providing the field.
    * <p><b>200</b> - Returned if the option is updated or created.
    * <p><b>400</b> - Returned if the option is invalid, or the *ID* in the request object does not match the *optionId* parameter.
    * <p><b>403</b> - Returned if the request is not authenticated as a Jira administrator or the app that provided the field.
    * <p><b>404</b> - Returned if field is not found.
    * @param fieldKey The field key is specified in the following format: **$(app-key)\\_\\_$(field-key)**. For example, *example-add-on\\_\\_example-issue-field*. To determine the &#x60;fieldKey&#x60; value, do one of the following:   *  open the app&#39;s plugin descriptor, then **app-key** is the key at the top and **field-key** is the key in the &#x60;jiraIssueFields&#x60; module. **app-key** can also be found in the app listing in the Atlassian Universal Plugin Manager.  *  run [Get fields](#api-rest-api-3-field-get) and in the field details the value is returned in &#x60;key&#x60;. For example, &#x60;\&quot;key\&quot;: \&quot;teams-add-on__team-issue-field\&quot;&#x60;
    * @param optionId The ID of the option to be updated.
    * @param issueFieldOption The issueFieldOption parameter
    * @return IssueFieldOption
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public IssueFieldOption updateIssueFieldOption(String fieldKey, Long optionId, IssueFieldOption issueFieldOption) throws IOException {
        HttpResponse response = updateIssueFieldOptionForHttpResponse(fieldKey, optionId, issueFieldOption);
        TypeReference<IssueFieldOption> typeRef = new TypeReference<IssueFieldOption>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Update issue field option
    * Updates or creates an option for a select list issue field. This operation requires that the option ID is provided when creating an option, therefore, the option ID needs to be specified as a path and body parameter. The option ID provided in the path and body must be identical.  Note that this operation **only works for issue field select list options added by Connect apps**, it cannot be used with issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg). Jira permissions are not required for the app providing the field.
    * <p><b>200</b> - Returned if the option is updated or created.
    * <p><b>400</b> - Returned if the option is invalid, or the *ID* in the request object does not match the *optionId* parameter.
    * <p><b>403</b> - Returned if the request is not authenticated as a Jira administrator or the app that provided the field.
    * <p><b>404</b> - Returned if field is not found.
    * @param fieldKey The field key is specified in the following format: **$(app-key)\\_\\_$(field-key)**. For example, *example-add-on\\_\\_example-issue-field*. To determine the &#x60;fieldKey&#x60; value, do one of the following:   *  open the app&#39;s plugin descriptor, then **app-key** is the key at the top and **field-key** is the key in the &#x60;jiraIssueFields&#x60; module. **app-key** can also be found in the app listing in the Atlassian Universal Plugin Manager.  *  run [Get fields](#api-rest-api-3-field-get) and in the field details the value is returned in &#x60;key&#x60;. For example, &#x60;\&quot;key\&quot;: \&quot;teams-add-on__team-issue-field\&quot;&#x60;
    * @param optionId The ID of the option to be updated.
    * @param issueFieldOption The issueFieldOption parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return IssueFieldOption
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public IssueFieldOption updateIssueFieldOption(String fieldKey, Long optionId, IssueFieldOption issueFieldOption, Map<String, Object> params) throws IOException {
        HttpResponse response = updateIssueFieldOptionForHttpResponse(fieldKey, optionId, issueFieldOption, params);
        TypeReference<IssueFieldOption> typeRef = new TypeReference<IssueFieldOption>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse updateIssueFieldOptionForHttpResponse(String fieldKey, Long optionId, IssueFieldOption issueFieldOption) throws IOException {
        // verify the required parameter 'fieldKey' is set
        if (fieldKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldKey' when calling updateIssueFieldOption");
        }// verify the required parameter 'optionId' is set
        if (optionId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'optionId' when calling updateIssueFieldOption");
        }// verify the required parameter 'issueFieldOption' is set
        if (issueFieldOption == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueFieldOption' when calling updateIssueFieldOption");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldKey", fieldKey);
        uriVariables.put("optionId", optionId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldKey}/option/{optionId}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(issueFieldOption);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse updateIssueFieldOptionForHttpResponse(String fieldKey, Long optionId, java.io.InputStream issueFieldOption, String mediaType) throws IOException {
          // verify the required parameter 'fieldKey' is set
              if (fieldKey == null) {
              throw new IllegalArgumentException("Missing the required parameter 'fieldKey' when calling updateIssueFieldOption");
              }// verify the required parameter 'optionId' is set
              if (optionId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'optionId' when calling updateIssueFieldOption");
              }// verify the required parameter 'issueFieldOption' is set
              if (issueFieldOption == null) {
              throw new IllegalArgumentException("Missing the required parameter 'issueFieldOption' when calling updateIssueFieldOption");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("fieldKey", fieldKey);
                      uriVariables.put("optionId", optionId);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldKey}/option/{optionId}");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = issueFieldOption == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, issueFieldOption);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse updateIssueFieldOptionForHttpResponse(String fieldKey, Long optionId, IssueFieldOption issueFieldOption, Map<String, Object> params) throws IOException {
        // verify the required parameter 'fieldKey' is set
        if (fieldKey == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldKey' when calling updateIssueFieldOption");
        }// verify the required parameter 'optionId' is set
        if (optionId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'optionId' when calling updateIssueFieldOption");
        }// verify the required parameter 'issueFieldOption' is set
        if (issueFieldOption == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issueFieldOption' when calling updateIssueFieldOption");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldKey", fieldKey);
        uriVariables.put("optionId", optionId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldKey}/option/{optionId}");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(issueFieldOption);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }


}
