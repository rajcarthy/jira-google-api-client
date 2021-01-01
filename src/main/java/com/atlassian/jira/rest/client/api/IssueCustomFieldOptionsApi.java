package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.BulkCreateCustomFieldOptionRequest;
import com.atlassian.jira.rest.client.model.BulkCustomFieldOptionCreateRequest;
import com.atlassian.jira.rest.client.model.BulkCustomFieldOptionUpdateRequest;
import com.atlassian.jira.rest.client.model.CustomFieldCreatedContextOptionsList;
import com.atlassian.jira.rest.client.model.CustomFieldOption;
import com.atlassian.jira.rest.client.model.CustomFieldUpdatedContextOptionsList;
import com.atlassian.jira.rest.client.model.ErrorCollection;
import com.atlassian.jira.rest.client.model.OrderOfCustomFieldOptions;
import com.atlassian.jira.rest.client.model.PageBeanCustomFieldContextOption;
import com.atlassian.jira.rest.client.model.PageBeanCustomFieldOptionDetails;
import com.atlassian.jira.rest.client.model.UpdateCustomFieldOption;

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
public class IssueCustomFieldOptionsApi {
    private ApiClient apiClient;

    public IssueCustomFieldOptionsApi() {
        this(new ApiClient());
    }

    public IssueCustomFieldOptionsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Create custom field options (context)
    * Creates options and, where the custom select field is of the type Select List (cascading), cascading options for a custom select field. The options are added to a context of the field.  This operation works for custom field options created in Jira or the operations from this resource. **To work with issue field select list options created for Connect apps use the [Issue custom field options (apps)](#api-group-issue-custom-field-options--apps-) operations.**  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the custom field is not found or the context doesn&#39;t match the custom field.
    * @param fieldId The ID of the custom field.
    * @param contextId The ID of the context.
    * @param bulkCustomFieldOptionCreateRequest The bulkCustomFieldOptionCreateRequest parameter
    * @return CustomFieldCreatedContextOptionsList
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public CustomFieldCreatedContextOptionsList createCustomFieldOption(String fieldId, Long contextId, BulkCustomFieldOptionCreateRequest bulkCustomFieldOptionCreateRequest) throws IOException {
        HttpResponse response = createCustomFieldOptionForHttpResponse(fieldId, contextId, bulkCustomFieldOptionCreateRequest);
        TypeReference<CustomFieldCreatedContextOptionsList> typeRef = new TypeReference<CustomFieldCreatedContextOptionsList>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Create custom field options (context)
    * Creates options and, where the custom select field is of the type Select List (cascading), cascading options for a custom select field. The options are added to a context of the field.  This operation works for custom field options created in Jira or the operations from this resource. **To work with issue field select list options created for Connect apps use the [Issue custom field options (apps)](#api-group-issue-custom-field-options--apps-) operations.**  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the custom field is not found or the context doesn&#39;t match the custom field.
    * @param fieldId The ID of the custom field.
    * @param contextId The ID of the context.
    * @param bulkCustomFieldOptionCreateRequest The bulkCustomFieldOptionCreateRequest parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return CustomFieldCreatedContextOptionsList
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public CustomFieldCreatedContextOptionsList createCustomFieldOption(String fieldId, Long contextId, BulkCustomFieldOptionCreateRequest bulkCustomFieldOptionCreateRequest, Map<String, Object> params) throws IOException {
        HttpResponse response = createCustomFieldOptionForHttpResponse(fieldId, contextId, bulkCustomFieldOptionCreateRequest, params);
        TypeReference<CustomFieldCreatedContextOptionsList> typeRef = new TypeReference<CustomFieldCreatedContextOptionsList>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse createCustomFieldOptionForHttpResponse(String fieldId, Long contextId, BulkCustomFieldOptionCreateRequest bulkCustomFieldOptionCreateRequest) throws IOException {
        // verify the required parameter 'fieldId' is set
        if (fieldId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldId' when calling createCustomFieldOption");
        }// verify the required parameter 'contextId' is set
        if (contextId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'contextId' when calling createCustomFieldOption");
        }// verify the required parameter 'bulkCustomFieldOptionCreateRequest' is set
        if (bulkCustomFieldOptionCreateRequest == null) {
            throw new IllegalArgumentException("Missing the required parameter 'bulkCustomFieldOptionCreateRequest' when calling createCustomFieldOption");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldId", fieldId);
        uriVariables.put("contextId", contextId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldId}/context/{contextId}/option");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(bulkCustomFieldOptionCreateRequest);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse createCustomFieldOptionForHttpResponse(String fieldId, Long contextId, java.io.InputStream bulkCustomFieldOptionCreateRequest, String mediaType) throws IOException {
          // verify the required parameter 'fieldId' is set
              if (fieldId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'fieldId' when calling createCustomFieldOption");
              }// verify the required parameter 'contextId' is set
              if (contextId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'contextId' when calling createCustomFieldOption");
              }// verify the required parameter 'bulkCustomFieldOptionCreateRequest' is set
              if (bulkCustomFieldOptionCreateRequest == null) {
              throw new IllegalArgumentException("Missing the required parameter 'bulkCustomFieldOptionCreateRequest' when calling createCustomFieldOption");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("fieldId", fieldId);
                      uriVariables.put("contextId", contextId);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldId}/context/{contextId}/option");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = bulkCustomFieldOptionCreateRequest == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, bulkCustomFieldOptionCreateRequest);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse createCustomFieldOptionForHttpResponse(String fieldId, Long contextId, BulkCustomFieldOptionCreateRequest bulkCustomFieldOptionCreateRequest, Map<String, Object> params) throws IOException {
        // verify the required parameter 'fieldId' is set
        if (fieldId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldId' when calling createCustomFieldOption");
        }// verify the required parameter 'contextId' is set
        if (contextId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'contextId' when calling createCustomFieldOption");
        }// verify the required parameter 'bulkCustomFieldOptionCreateRequest' is set
        if (bulkCustomFieldOptionCreateRequest == null) {
            throw new IllegalArgumentException("Missing the required parameter 'bulkCustomFieldOptionCreateRequest' when calling createCustomFieldOption");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldId", fieldId);
        uriVariables.put("contextId", contextId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldId}/context/{contextId}/option");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(bulkCustomFieldOptionCreateRequest);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


  /**
    * Create custom field options
    * Creates options and, where the custom select field is of the type *Select List (cascading)*, cascading options for a custom select field. The options are added to the global context of the field.  Note that this operation **only works for issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource**, it cannot be used with issue field select list options created by Connect apps.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>201</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the field is not found.
    * @param fieldId The ID of the custom field. Note: This is the numeric part of the of the field ID. For example, for a field with the ID *customfield\\_10075* use *10075*.
    * @param bulkCreateCustomFieldOptionRequest The bulkCreateCustomFieldOptionRequest parameter
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object createCustomFieldOptions(Long fieldId, BulkCreateCustomFieldOptionRequest bulkCreateCustomFieldOptionRequest) throws IOException {
        HttpResponse response = createCustomFieldOptionsForHttpResponse(fieldId, bulkCreateCustomFieldOptionRequest);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Create custom field options
    * Creates options and, where the custom select field is of the type *Select List (cascading)*, cascading options for a custom select field. The options are added to the global context of the field.  Note that this operation **only works for issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource**, it cannot be used with issue field select list options created by Connect apps.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>201</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the field is not found.
    * @param fieldId The ID of the custom field. Note: This is the numeric part of the of the field ID. For example, for a field with the ID *customfield\\_10075* use *10075*.
    * @param bulkCreateCustomFieldOptionRequest The bulkCreateCustomFieldOptionRequest parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object createCustomFieldOptions(Long fieldId, BulkCreateCustomFieldOptionRequest bulkCreateCustomFieldOptionRequest, Map<String, Object> params) throws IOException {
        HttpResponse response = createCustomFieldOptionsForHttpResponse(fieldId, bulkCreateCustomFieldOptionRequest, params);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse createCustomFieldOptionsForHttpResponse(Long fieldId, BulkCreateCustomFieldOptionRequest bulkCreateCustomFieldOptionRequest) throws IOException {
        // verify the required parameter 'fieldId' is set
        if (fieldId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldId' when calling createCustomFieldOptions");
        }// verify the required parameter 'bulkCreateCustomFieldOptionRequest' is set
        if (bulkCreateCustomFieldOptionRequest == null) {
            throw new IllegalArgumentException("Missing the required parameter 'bulkCreateCustomFieldOptionRequest' when calling createCustomFieldOptions");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldId", fieldId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/customField/{fieldId}/option");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(bulkCreateCustomFieldOptionRequest);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse createCustomFieldOptionsForHttpResponse(Long fieldId, java.io.InputStream bulkCreateCustomFieldOptionRequest, String mediaType) throws IOException {
          // verify the required parameter 'fieldId' is set
              if (fieldId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'fieldId' when calling createCustomFieldOptions");
              }// verify the required parameter 'bulkCreateCustomFieldOptionRequest' is set
              if (bulkCreateCustomFieldOptionRequest == null) {
              throw new IllegalArgumentException("Missing the required parameter 'bulkCreateCustomFieldOptionRequest' when calling createCustomFieldOptions");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("fieldId", fieldId);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/customField/{fieldId}/option");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = bulkCreateCustomFieldOptionRequest == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, bulkCreateCustomFieldOptionRequest);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse createCustomFieldOptionsForHttpResponse(Long fieldId, BulkCreateCustomFieldOptionRequest bulkCreateCustomFieldOptionRequest, Map<String, Object> params) throws IOException {
        // verify the required parameter 'fieldId' is set
        if (fieldId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldId' when calling createCustomFieldOptions");
        }// verify the required parameter 'bulkCreateCustomFieldOptionRequest' is set
        if (bulkCreateCustomFieldOptionRequest == null) {
            throw new IllegalArgumentException("Missing the required parameter 'bulkCreateCustomFieldOptionRequest' when calling createCustomFieldOptions");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldId", fieldId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/customField/{fieldId}/option");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(bulkCreateCustomFieldOptionRequest);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


  /**
    * Delete custom field options (context)
    * Deletes a custom field option.  Options with cascading options cannot be deleted without deleting the cascading options first.  This operation works for custom field options created in Jira or the operations from this resource. **To work with issue field select list options created for Connect apps use the [Issue custom field options (apps)](#api-group-issue-custom-field-options--apps-) operations.**  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the option is deleted.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the field, the context, or the option is not found.
    * @param fieldId The ID of the custom field.
    * @param contextId The ID of the context from which an option should be deleted.
    * @param optionId The ID of the option to delete.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteCustomFieldOption(String fieldId, Long contextId, Long optionId) throws IOException {
        deleteCustomFieldOptionForHttpResponse(fieldId, contextId, optionId);
    }

  /**
    * Delete custom field options (context)
    * Deletes a custom field option.  Options with cascading options cannot be deleted without deleting the cascading options first.  This operation works for custom field options created in Jira or the operations from this resource. **To work with issue field select list options created for Connect apps use the [Issue custom field options (apps)](#api-group-issue-custom-field-options--apps-) operations.**  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the option is deleted.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the field, the context, or the option is not found.
    * @param fieldId The ID of the custom field.
    * @param contextId The ID of the context from which an option should be deleted.
    * @param optionId The ID of the option to delete.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteCustomFieldOption(String fieldId, Long contextId, Long optionId, Map<String, Object> params) throws IOException {
        deleteCustomFieldOptionForHttpResponse(fieldId, contextId, optionId, params);
    }

    public HttpResponse deleteCustomFieldOptionForHttpResponse(String fieldId, Long contextId, Long optionId) throws IOException {
        // verify the required parameter 'fieldId' is set
        if (fieldId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldId' when calling deleteCustomFieldOption");
        }// verify the required parameter 'contextId' is set
        if (contextId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'contextId' when calling deleteCustomFieldOption");
        }// verify the required parameter 'optionId' is set
        if (optionId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'optionId' when calling deleteCustomFieldOption");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldId", fieldId);
        uriVariables.put("contextId", contextId);
        uriVariables.put("optionId", optionId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldId}/context/{contextId}/option/{optionId}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }

    public HttpResponse deleteCustomFieldOptionForHttpResponse(String fieldId, Long contextId, Long optionId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'fieldId' is set
        if (fieldId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldId' when calling deleteCustomFieldOption");
        }// verify the required parameter 'contextId' is set
        if (contextId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'contextId' when calling deleteCustomFieldOption");
        }// verify the required parameter 'optionId' is set
        if (optionId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'optionId' when calling deleteCustomFieldOption");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldId", fieldId);
        uriVariables.put("contextId", contextId);
        uriVariables.put("optionId", optionId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldId}/context/{contextId}/option/{optionId}");

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
    * Get custom field option
    * Returns a custom field option. For example, an option in a select list.  Note that this operation **only works for issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource**, it cannot be used with issue field select list options created by Connect apps.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** The custom field option is returned as follows:   *  if the user has the *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).  *  if the user has the *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for at least one project the custom field is used in, and the field is visible in at least one layout the user has permission to view.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if:   *  the custom field option is not found.  *  the user does not have permission to view the custom field.
    * @param id The ID of the custom field option.
    * @return CustomFieldOption
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public CustomFieldOption getCustomFieldOption(String id) throws IOException {
        HttpResponse response = getCustomFieldOptionForHttpResponse(id);
        TypeReference<CustomFieldOption> typeRef = new TypeReference<CustomFieldOption>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get custom field option
    * Returns a custom field option. For example, an option in a select list.  Note that this operation **only works for issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource**, it cannot be used with issue field select list options created by Connect apps.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** The custom field option is returned as follows:   *  if the user has the *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).  *  if the user has the *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for at least one project the custom field is used in, and the field is visible in at least one layout the user has permission to view.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if:   *  the custom field option is not found.  *  the user does not have permission to view the custom field.
    * @param id The ID of the custom field option.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return CustomFieldOption
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public CustomFieldOption getCustomFieldOption(String id, Map<String, Object> params) throws IOException {
        HttpResponse response = getCustomFieldOptionForHttpResponse(id, params);
        TypeReference<CustomFieldOption> typeRef = new TypeReference<CustomFieldOption>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getCustomFieldOptionForHttpResponse(String id) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling getCustomFieldOption");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/customFieldOption/{id}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getCustomFieldOptionForHttpResponse(String id, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling getCustomFieldOption");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/customFieldOption/{id}");

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
    * Get custom field options (context)
    * Returns a [paginated](#pagination) list of all custom field option for a context. Options are returned first then cascading options, in the order they display in Jira.  This operation works for custom field options created in Jira or the operations from this resource. **To work with issue field select list options created for Connect apps use the [Issue custom field options (apps)](#api-group-issue-custom-field-options--apps-) operations.**  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the custom field is not found or the context doesn&#39;t match the custom field.
    * @param fieldId The ID of the custom field.
    * @param contextId The ID of the context.
    * @param optionId The ID of the option.
    * @param onlyOptions Whether only options are returned.
    * @param startAt The index of the first item to return in a page of results (page offset).
    * @param maxResults The maximum number of items to return per page.
    * @return PageBeanCustomFieldContextOption
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanCustomFieldContextOption getOptionsForContext(String fieldId, Long contextId, Long optionId, Boolean onlyOptions, Long startAt, Integer maxResults) throws IOException {
        HttpResponse response = getOptionsForContextForHttpResponse(fieldId, contextId, optionId, onlyOptions, startAt, maxResults);
        TypeReference<PageBeanCustomFieldContextOption> typeRef = new TypeReference<PageBeanCustomFieldContextOption>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get custom field options (context)
    * Returns a [paginated](#pagination) list of all custom field option for a context. Options are returned first then cascading options, in the order they display in Jira.  This operation works for custom field options created in Jira or the operations from this resource. **To work with issue field select list options created for Connect apps use the [Issue custom field options (apps)](#api-group-issue-custom-field-options--apps-) operations.**  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the custom field is not found or the context doesn&#39;t match the custom field.
    * @param fieldId The ID of the custom field.
    * @param contextId The ID of the context.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PageBeanCustomFieldContextOption
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanCustomFieldContextOption getOptionsForContext(String fieldId, Long contextId, Map<String, Object> params) throws IOException {
        HttpResponse response = getOptionsForContextForHttpResponse(fieldId, contextId, params);
        TypeReference<PageBeanCustomFieldContextOption> typeRef = new TypeReference<PageBeanCustomFieldContextOption>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getOptionsForContextForHttpResponse(String fieldId, Long contextId, Long optionId, Boolean onlyOptions, Long startAt, Integer maxResults) throws IOException {
        // verify the required parameter 'fieldId' is set
        if (fieldId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldId' when calling getOptionsForContext");
        }// verify the required parameter 'contextId' is set
        if (contextId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'contextId' when calling getOptionsForContext");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldId", fieldId);
        uriVariables.put("contextId", contextId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldId}/context/{contextId}/option");
        if (optionId != null) {
            String key = "optionId";
            Object value = optionId;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (onlyOptions != null) {
            String key = "onlyOptions";
            Object value = onlyOptions;
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
        }

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getOptionsForContextForHttpResponse(String fieldId, Long contextId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'fieldId' is set
        if (fieldId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldId' when calling getOptionsForContext");
        }// verify the required parameter 'contextId' is set
        if (contextId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'contextId' when calling getOptionsForContext");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldId", fieldId);
        uriVariables.put("contextId", contextId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldId}/context/{contextId}/option");

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
    * Get options for field
    * Returns a [paginated](#pagination) list of options and, where the custom select field is of the type *Select List (cascading)*, cascading options for custom select fields. Cascading options are included in the item count when determining pagination. Only options from the global context are returned.  Note that this operation **only works for issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource**, it cannot be used with issue field select list options created by Connect apps.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the field is not found.
    * @param fieldId The ID of the custom field. Note: This is the numeric part of the of the field ID. For example, for a field with the ID *customfield\\_10075* use *10075*.
    * @param startAt The index of the first item to return in a page of results (page offset).
    * @param maxResults The maximum number of items to return per page.
    * @return PageBeanCustomFieldOptionDetails
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanCustomFieldOptionDetails getOptionsForField(Long fieldId, Long startAt, Integer maxResults) throws IOException {
        HttpResponse response = getOptionsForFieldForHttpResponse(fieldId, startAt, maxResults);
        TypeReference<PageBeanCustomFieldOptionDetails> typeRef = new TypeReference<PageBeanCustomFieldOptionDetails>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get options for field
    * Returns a [paginated](#pagination) list of options and, where the custom select field is of the type *Select List (cascading)*, cascading options for custom select fields. Cascading options are included in the item count when determining pagination. Only options from the global context are returned.  Note that this operation **only works for issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource**, it cannot be used with issue field select list options created by Connect apps.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the field is not found.
    * @param fieldId The ID of the custom field. Note: This is the numeric part of the of the field ID. For example, for a field with the ID *customfield\\_10075* use *10075*.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return PageBeanCustomFieldOptionDetails
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public PageBeanCustomFieldOptionDetails getOptionsForField(Long fieldId, Map<String, Object> params) throws IOException {
        HttpResponse response = getOptionsForFieldForHttpResponse(fieldId, params);
        TypeReference<PageBeanCustomFieldOptionDetails> typeRef = new TypeReference<PageBeanCustomFieldOptionDetails>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getOptionsForFieldForHttpResponse(Long fieldId, Long startAt, Integer maxResults) throws IOException {
        // verify the required parameter 'fieldId' is set
        if (fieldId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldId' when calling getOptionsForField");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldId", fieldId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/customField/{fieldId}/option");
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

    public HttpResponse getOptionsForFieldForHttpResponse(Long fieldId, Map<String, Object> params) throws IOException {
        // verify the required parameter 'fieldId' is set
        if (fieldId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldId' when calling getOptionsForField");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldId", fieldId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/customField/{fieldId}/option");

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
    * Reorder custom field options (context)
    * Changes the order of custom field options or cascading options in a context.  This operation works for custom field options created in Jira or the operations from this resource. **To work with issue field select list options created for Connect apps use the [Issue custom field options (apps)](#api-group-issue-custom-field-options--apps-) operations.**  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if options are reordered.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the field, the context, or one or more of the options is not found..
    * @param fieldId The ID of the custom field.
    * @param contextId The ID of the context.
    * @param orderOfCustomFieldOptions The orderOfCustomFieldOptions parameter
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object reorderCustomFieldOptions(String fieldId, Long contextId, OrderOfCustomFieldOptions orderOfCustomFieldOptions) throws IOException {
        HttpResponse response = reorderCustomFieldOptionsForHttpResponse(fieldId, contextId, orderOfCustomFieldOptions);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Reorder custom field options (context)
    * Changes the order of custom field options or cascading options in a context.  This operation works for custom field options created in Jira or the operations from this resource. **To work with issue field select list options created for Connect apps use the [Issue custom field options (apps)](#api-group-issue-custom-field-options--apps-) operations.**  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if options are reordered.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the field, the context, or one or more of the options is not found..
    * @param fieldId The ID of the custom field.
    * @param contextId The ID of the context.
    * @param orderOfCustomFieldOptions The orderOfCustomFieldOptions parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object reorderCustomFieldOptions(String fieldId, Long contextId, OrderOfCustomFieldOptions orderOfCustomFieldOptions, Map<String, Object> params) throws IOException {
        HttpResponse response = reorderCustomFieldOptionsForHttpResponse(fieldId, contextId, orderOfCustomFieldOptions, params);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse reorderCustomFieldOptionsForHttpResponse(String fieldId, Long contextId, OrderOfCustomFieldOptions orderOfCustomFieldOptions) throws IOException {
        // verify the required parameter 'fieldId' is set
        if (fieldId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldId' when calling reorderCustomFieldOptions");
        }// verify the required parameter 'contextId' is set
        if (contextId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'contextId' when calling reorderCustomFieldOptions");
        }// verify the required parameter 'orderOfCustomFieldOptions' is set
        if (orderOfCustomFieldOptions == null) {
            throw new IllegalArgumentException("Missing the required parameter 'orderOfCustomFieldOptions' when calling reorderCustomFieldOptions");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldId", fieldId);
        uriVariables.put("contextId", contextId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldId}/context/{contextId}/option/move");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(orderOfCustomFieldOptions);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse reorderCustomFieldOptionsForHttpResponse(String fieldId, Long contextId, java.io.InputStream orderOfCustomFieldOptions, String mediaType) throws IOException {
          // verify the required parameter 'fieldId' is set
              if (fieldId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'fieldId' when calling reorderCustomFieldOptions");
              }// verify the required parameter 'contextId' is set
              if (contextId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'contextId' when calling reorderCustomFieldOptions");
              }// verify the required parameter 'orderOfCustomFieldOptions' is set
              if (orderOfCustomFieldOptions == null) {
              throw new IllegalArgumentException("Missing the required parameter 'orderOfCustomFieldOptions' when calling reorderCustomFieldOptions");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("fieldId", fieldId);
                      uriVariables.put("contextId", contextId);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldId}/context/{contextId}/option/move");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = orderOfCustomFieldOptions == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, orderOfCustomFieldOptions);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse reorderCustomFieldOptionsForHttpResponse(String fieldId, Long contextId, OrderOfCustomFieldOptions orderOfCustomFieldOptions, Map<String, Object> params) throws IOException {
        // verify the required parameter 'fieldId' is set
        if (fieldId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldId' when calling reorderCustomFieldOptions");
        }// verify the required parameter 'contextId' is set
        if (contextId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'contextId' when calling reorderCustomFieldOptions");
        }// verify the required parameter 'orderOfCustomFieldOptions' is set
        if (orderOfCustomFieldOptions == null) {
            throw new IllegalArgumentException("Missing the required parameter 'orderOfCustomFieldOptions' when calling reorderCustomFieldOptions");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldId", fieldId);
        uriVariables.put("contextId", contextId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldId}/context/{contextId}/option/move");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(orderOfCustomFieldOptions);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }


  /**
    * Update custom field options (context)
    * Updates the options of a custom field.  If any of the options are not found, no options are updated. Options where the values in the request match the current values aren&#39;t updated and aren&#39;t reported in the response.  Note that this operation **only works for issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource**, it cannot be used with issue field select list options created by Connect apps.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the field, context, or one or more options is not found.
    * @param fieldId The ID of the custom field.
    * @param contextId The ID of the context.
    * @param bulkCustomFieldOptionUpdateRequest The bulkCustomFieldOptionUpdateRequest parameter
    * @return CustomFieldUpdatedContextOptionsList
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public CustomFieldUpdatedContextOptionsList updateCustomFieldOption(String fieldId, Long contextId, BulkCustomFieldOptionUpdateRequest bulkCustomFieldOptionUpdateRequest) throws IOException {
        HttpResponse response = updateCustomFieldOptionForHttpResponse(fieldId, contextId, bulkCustomFieldOptionUpdateRequest);
        TypeReference<CustomFieldUpdatedContextOptionsList> typeRef = new TypeReference<CustomFieldUpdatedContextOptionsList>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Update custom field options (context)
    * Updates the options of a custom field.  If any of the options are not found, no options are updated. Options where the values in the request match the current values aren&#39;t updated and aren&#39;t reported in the response.  Note that this operation **only works for issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource**, it cannot be used with issue field select list options created by Connect apps.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is not valid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the field, context, or one or more options is not found.
    * @param fieldId The ID of the custom field.
    * @param contextId The ID of the context.
    * @param bulkCustomFieldOptionUpdateRequest The bulkCustomFieldOptionUpdateRequest parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return CustomFieldUpdatedContextOptionsList
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public CustomFieldUpdatedContextOptionsList updateCustomFieldOption(String fieldId, Long contextId, BulkCustomFieldOptionUpdateRequest bulkCustomFieldOptionUpdateRequest, Map<String, Object> params) throws IOException {
        HttpResponse response = updateCustomFieldOptionForHttpResponse(fieldId, contextId, bulkCustomFieldOptionUpdateRequest, params);
        TypeReference<CustomFieldUpdatedContextOptionsList> typeRef = new TypeReference<CustomFieldUpdatedContextOptionsList>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse updateCustomFieldOptionForHttpResponse(String fieldId, Long contextId, BulkCustomFieldOptionUpdateRequest bulkCustomFieldOptionUpdateRequest) throws IOException {
        // verify the required parameter 'fieldId' is set
        if (fieldId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldId' when calling updateCustomFieldOption");
        }// verify the required parameter 'contextId' is set
        if (contextId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'contextId' when calling updateCustomFieldOption");
        }// verify the required parameter 'bulkCustomFieldOptionUpdateRequest' is set
        if (bulkCustomFieldOptionUpdateRequest == null) {
            throw new IllegalArgumentException("Missing the required parameter 'bulkCustomFieldOptionUpdateRequest' when calling updateCustomFieldOption");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldId", fieldId);
        uriVariables.put("contextId", contextId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldId}/context/{contextId}/option");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(bulkCustomFieldOptionUpdateRequest);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse updateCustomFieldOptionForHttpResponse(String fieldId, Long contextId, java.io.InputStream bulkCustomFieldOptionUpdateRequest, String mediaType) throws IOException {
          // verify the required parameter 'fieldId' is set
              if (fieldId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'fieldId' when calling updateCustomFieldOption");
              }// verify the required parameter 'contextId' is set
              if (contextId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'contextId' when calling updateCustomFieldOption");
              }// verify the required parameter 'bulkCustomFieldOptionUpdateRequest' is set
              if (bulkCustomFieldOptionUpdateRequest == null) {
              throw new IllegalArgumentException("Missing the required parameter 'bulkCustomFieldOptionUpdateRequest' when calling updateCustomFieldOption");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("fieldId", fieldId);
                      uriVariables.put("contextId", contextId);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldId}/context/{contextId}/option");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = bulkCustomFieldOptionUpdateRequest == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, bulkCustomFieldOptionUpdateRequest);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse updateCustomFieldOptionForHttpResponse(String fieldId, Long contextId, BulkCustomFieldOptionUpdateRequest bulkCustomFieldOptionUpdateRequest, Map<String, Object> params) throws IOException {
        // verify the required parameter 'fieldId' is set
        if (fieldId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldId' when calling updateCustomFieldOption");
        }// verify the required parameter 'contextId' is set
        if (contextId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'contextId' when calling updateCustomFieldOption");
        }// verify the required parameter 'bulkCustomFieldOptionUpdateRequest' is set
        if (bulkCustomFieldOptionUpdateRequest == null) {
            throw new IllegalArgumentException("Missing the required parameter 'bulkCustomFieldOptionUpdateRequest' when calling updateCustomFieldOption");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldId", fieldId);
        uriVariables.put("contextId", contextId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/field/{fieldId}/context/{contextId}/option");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(bulkCustomFieldOptionUpdateRequest);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }


  /**
    * Update custom field options
    * Updates the options on a custom select field. Where an updated option is in use on an issue, the value on the issue is also updated. Options that are not found are ignored. A maximum of 1000 options, including sub-options of *Select List (cascading)* fields, can be updated per request. The options are updated on the global context of the field.  Note that this operation **only works for issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource**, it cannot be used with issue field select list options created by Connect apps.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the field is not found.
    * @param fieldId The ID of the custom field. Note: This is the numeric part of the of the field ID. For example, for a field with the ID *customfield\\_10075* use *10075*.
    * @param updateCustomFieldOption The updateCustomFieldOption parameter
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object updateCustomFieldOptions(Long fieldId, UpdateCustomFieldOption updateCustomFieldOption) throws IOException {
        HttpResponse response = updateCustomFieldOptionsForHttpResponse(fieldId, updateCustomFieldOption);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Update custom field options
    * Updates the options on a custom select field. Where an updated option is in use on an issue, the value on the issue is also updated. Options that are not found are ignored. A maximum of 1000 options, including sub-options of *Select List (cascading)* fields, can be updated per request. The options are updated on the global context of the field.  Note that this operation **only works for issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource**, it cannot be used with issue field select list options created by Connect apps.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>204</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the field is not found.
    * @param fieldId The ID of the custom field. Note: This is the numeric part of the of the field ID. For example, for a field with the ID *customfield\\_10075* use *10075*.
    * @param updateCustomFieldOption The updateCustomFieldOption parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return Object
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public Object updateCustomFieldOptions(Long fieldId, UpdateCustomFieldOption updateCustomFieldOption, Map<String, Object> params) throws IOException {
        HttpResponse response = updateCustomFieldOptionsForHttpResponse(fieldId, updateCustomFieldOption, params);
        TypeReference<Object> typeRef = new TypeReference<Object>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse updateCustomFieldOptionsForHttpResponse(Long fieldId, UpdateCustomFieldOption updateCustomFieldOption) throws IOException {
        // verify the required parameter 'fieldId' is set
        if (fieldId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldId' when calling updateCustomFieldOptions");
        }// verify the required parameter 'updateCustomFieldOption' is set
        if (updateCustomFieldOption == null) {
            throw new IllegalArgumentException("Missing the required parameter 'updateCustomFieldOption' when calling updateCustomFieldOptions");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldId", fieldId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/customField/{fieldId}/option");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(updateCustomFieldOption);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse updateCustomFieldOptionsForHttpResponse(Long fieldId, java.io.InputStream updateCustomFieldOption, String mediaType) throws IOException {
          // verify the required parameter 'fieldId' is set
              if (fieldId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'fieldId' when calling updateCustomFieldOptions");
              }// verify the required parameter 'updateCustomFieldOption' is set
              if (updateCustomFieldOption == null) {
              throw new IllegalArgumentException("Missing the required parameter 'updateCustomFieldOption' when calling updateCustomFieldOptions");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("fieldId", fieldId);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/customField/{fieldId}/option");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = updateCustomFieldOption == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, updateCustomFieldOption);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse updateCustomFieldOptionsForHttpResponse(Long fieldId, UpdateCustomFieldOption updateCustomFieldOption, Map<String, Object> params) throws IOException {
        // verify the required parameter 'fieldId' is set
        if (fieldId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'fieldId' when calling updateCustomFieldOptions");
        }// verify the required parameter 'updateCustomFieldOption' is set
        if (updateCustomFieldOption == null) {
            throw new IllegalArgumentException("Missing the required parameter 'updateCustomFieldOption' when calling updateCustomFieldOptions");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("fieldId", fieldId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/customField/{fieldId}/option");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(updateCustomFieldOption);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }


}
