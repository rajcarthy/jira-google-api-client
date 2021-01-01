# IssueCustomFieldOptionsApi

All URIs are relative to *https://your-domain.atlassian.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createCustomFieldOption**](IssueCustomFieldOptionsApi.md#createCustomFieldOption) | **POST** /rest/api/3/field/{fieldId}/context/{contextId}/option | Create custom field options (context)
[**createCustomFieldOptions**](IssueCustomFieldOptionsApi.md#createCustomFieldOptions) | **POST** /rest/api/3/customField/{fieldId}/option | Create custom field options
[**deleteCustomFieldOption**](IssueCustomFieldOptionsApi.md#deleteCustomFieldOption) | **DELETE** /rest/api/3/field/{fieldId}/context/{contextId}/option/{optionId} | Delete custom field options (context)
[**getCustomFieldOption**](IssueCustomFieldOptionsApi.md#getCustomFieldOption) | **GET** /rest/api/3/customFieldOption/{id} | Get custom field option
[**getOptionsForContext**](IssueCustomFieldOptionsApi.md#getOptionsForContext) | **GET** /rest/api/3/field/{fieldId}/context/{contextId}/option | Get custom field options (context)
[**getOptionsForField**](IssueCustomFieldOptionsApi.md#getOptionsForField) | **GET** /rest/api/3/customField/{fieldId}/option | Get options for field
[**reorderCustomFieldOptions**](IssueCustomFieldOptionsApi.md#reorderCustomFieldOptions) | **PUT** /rest/api/3/field/{fieldId}/context/{contextId}/option/move | Reorder custom field options (context)
[**updateCustomFieldOption**](IssueCustomFieldOptionsApi.md#updateCustomFieldOption) | **PUT** /rest/api/3/field/{fieldId}/context/{contextId}/option | Update custom field options (context)
[**updateCustomFieldOptions**](IssueCustomFieldOptionsApi.md#updateCustomFieldOptions) | **PUT** /rest/api/3/customField/{fieldId}/option | Update custom field options



## createCustomFieldOption

> CustomFieldCreatedContextOptionsList createCustomFieldOption(fieldId, contextId, bulkCustomFieldOptionCreateRequest)

Create custom field options (context)

Creates options and, where the custom select field is of the type Select List (cascading), cascading options for a custom select field. The options are added to a context of the field.  This operation works for custom field options created in Jira or the operations from this resource. **To work with issue field select list options created for Connect apps use the [Issue custom field options (apps)](#api-group-issue-custom-field-options--apps-) operations.**  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.IssueCustomFieldOptionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://your-domain.atlassian.com");
        
        // Configure OAuth2 access token for authorization: OAuth2
        OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
        OAuth2.setAccessToken("YOUR ACCESS TOKEN");

        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        IssueCustomFieldOptionsApi apiInstance = new IssueCustomFieldOptionsApi(defaultClient);
        String fieldId = "fieldId_example"; // String | The ID of the custom field.
        Long contextId = 56L; // Long | The ID of the context.
        BulkCustomFieldOptionCreateRequest bulkCustomFieldOptionCreateRequest = {"options":[{"disabled":false,"value":"Scranton"},{"optionId":"10000","disabled":true,"value":"Manhattan"},{"disabled":false,"value":"The Electric City"}]}; // BulkCustomFieldOptionCreateRequest | 
        try {
            CustomFieldCreatedContextOptionsList result = apiInstance.createCustomFieldOption(fieldId, contextId, bulkCustomFieldOptionCreateRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueCustomFieldOptionsApi#createCustomFieldOption");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fieldId** | **String**| The ID of the custom field. |
 **contextId** | **Long**| The ID of the context. |
 **bulkCustomFieldOptionCreateRequest** | [**BulkCustomFieldOptionCreateRequest**](BulkCustomFieldOptionCreateRequest.md)|  |

### Return type

[**CustomFieldCreatedContextOptionsList**](CustomFieldCreatedContextOptionsList.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **400** | Returned if the request is not valid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the necessary permission. |  -  |
| **404** | Returned if the custom field is not found or the context doesn&#39;t match the custom field. |  -  |


## createCustomFieldOptions

> Object createCustomFieldOptions(fieldId, bulkCreateCustomFieldOptionRequest)

Create custom field options

Creates options and, where the custom select field is of the type *Select List (cascading)*, cascading options for a custom select field. The options are added to the global context of the field.  Note that this operation **only works for issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource**, it cannot be used with issue field select list options created by Connect apps.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.IssueCustomFieldOptionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://your-domain.atlassian.com");
        
        // Configure OAuth2 access token for authorization: OAuth2
        OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
        OAuth2.setAccessToken("YOUR ACCESS TOKEN");

        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        IssueCustomFieldOptionsApi apiInstance = new IssueCustomFieldOptionsApi(defaultClient);
        Long fieldId = 56L; // Long | The ID of the custom field. Note: This is the numeric part of the of the field ID. For example, for a field with the ID *customfield\\_10075* use *10075*.
        BulkCreateCustomFieldOptionRequest bulkCreateCustomFieldOptionRequest = {"options":[{"cascadingOptions":[],"value":"Option value"},{"cascadingOptions":["Child option"],"value":"Other option value"},{"cascadingOptions":["Sub-option","Sub-option 2"],"value":"Third option value"}]}; // BulkCreateCustomFieldOptionRequest | 
        try {
            Object result = apiInstance.createCustomFieldOptions(fieldId, bulkCreateCustomFieldOptionRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueCustomFieldOptionsApi#createCustomFieldOptions");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fieldId** | **Long**| The ID of the custom field. Note: This is the numeric part of the of the field ID. For example, for a field with the ID *customfield\\_10075* use *10075*. |
 **bulkCreateCustomFieldOptionRequest** | [**BulkCreateCustomFieldOptionRequest**](BulkCreateCustomFieldOptionRequest.md)|  |

### Return type

**Object**

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Returned if the request is successful. |  -  |
| **400** | Returned if the request is invalid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **404** | Returned if the field is not found. |  -  |


## deleteCustomFieldOption

> deleteCustomFieldOption(fieldId, contextId, optionId)

Delete custom field options (context)

Deletes a custom field option.  Options with cascading options cannot be deleted without deleting the cascading options first.  This operation works for custom field options created in Jira or the operations from this resource. **To work with issue field select list options created for Connect apps use the [Issue custom field options (apps)](#api-group-issue-custom-field-options--apps-) operations.**  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.IssueCustomFieldOptionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://your-domain.atlassian.com");
        
        // Configure OAuth2 access token for authorization: OAuth2
        OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
        OAuth2.setAccessToken("YOUR ACCESS TOKEN");

        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        IssueCustomFieldOptionsApi apiInstance = new IssueCustomFieldOptionsApi(defaultClient);
        String fieldId = "fieldId_example"; // String | The ID of the custom field.
        Long contextId = 56L; // Long | The ID of the context from which an option should be deleted.
        Long optionId = 56L; // Long | The ID of the option to delete.
        try {
            apiInstance.deleteCustomFieldOption(fieldId, contextId, optionId);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueCustomFieldOptionsApi#deleteCustomFieldOption");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fieldId** | **String**| The ID of the custom field. |
 **contextId** | **Long**| The ID of the context from which an option should be deleted. |
 **optionId** | **Long**| The ID of the option to delete. |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | Returned if the option is deleted. |  -  |
| **400** | Returned if the request is not valid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the necessary permission. |  -  |
| **404** | Returned if the field, the context, or the option is not found. |  -  |


## getCustomFieldOption

> CustomFieldOption getCustomFieldOption(id)

Get custom field option

Returns a custom field option. For example, an option in a select list.  Note that this operation **only works for issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource**, it cannot be used with issue field select list options created by Connect apps.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** The custom field option is returned as follows:   *  if the user has the *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).  *  if the user has the *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for at least one project the custom field is used in, and the field is visible in at least one layout the user has permission to view.

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.IssueCustomFieldOptionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://your-domain.atlassian.com");
        
        // Configure OAuth2 access token for authorization: OAuth2
        OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
        OAuth2.setAccessToken("YOUR ACCESS TOKEN");

        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        IssueCustomFieldOptionsApi apiInstance = new IssueCustomFieldOptionsApi(defaultClient);
        String id = "id_example"; // String | The ID of the custom field option.
        try {
            CustomFieldOption result = apiInstance.getCustomFieldOption(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueCustomFieldOptionsApi#getCustomFieldOption");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The ID of the custom field option. |

### Return type

[**CustomFieldOption**](CustomFieldOption.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **404** | Returned if:   *  the custom field option is not found.  *  the user does not have permission to view the custom field. |  -  |


## getOptionsForContext

> PageBeanCustomFieldContextOption getOptionsForContext(fieldId, contextId, optionId, onlyOptions, startAt, maxResults)

Get custom field options (context)

Returns a [paginated](#pagination) list of all custom field option for a context. Options are returned first then cascading options, in the order they display in Jira.  This operation works for custom field options created in Jira or the operations from this resource. **To work with issue field select list options created for Connect apps use the [Issue custom field options (apps)](#api-group-issue-custom-field-options--apps-) operations.**  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.IssueCustomFieldOptionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://your-domain.atlassian.com");
        
        // Configure OAuth2 access token for authorization: OAuth2
        OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
        OAuth2.setAccessToken("YOUR ACCESS TOKEN");

        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        IssueCustomFieldOptionsApi apiInstance = new IssueCustomFieldOptionsApi(defaultClient);
        String fieldId = "fieldId_example"; // String | The ID of the custom field.
        Long contextId = 56L; // Long | The ID of the context.
        Long optionId = 56L; // Long | The ID of the option.
        Boolean onlyOptions = false; // Boolean | Whether only options are returned.
        Long startAt = 0l; // Long | The index of the first item to return in a page of results (page offset).
        Integer maxResults = 100; // Integer | The maximum number of items to return per page.
        try {
            PageBeanCustomFieldContextOption result = apiInstance.getOptionsForContext(fieldId, contextId, optionId, onlyOptions, startAt, maxResults);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueCustomFieldOptionsApi#getOptionsForContext");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fieldId** | **String**| The ID of the custom field. |
 **contextId** | **Long**| The ID of the context. |
 **optionId** | **Long**| The ID of the option. | [optional]
 **onlyOptions** | **Boolean**| Whether only options are returned. | [optional] [default to false]
 **startAt** | **Long**| The index of the first item to return in a page of results (page offset). | [optional] [default to 0l]
 **maxResults** | **Integer**| The maximum number of items to return per page. | [optional] [default to 100]

### Return type

[**PageBeanCustomFieldContextOption**](PageBeanCustomFieldContextOption.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **400** | Returned if the request is not valid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the necessary permission. |  -  |
| **404** | Returned if the custom field is not found or the context doesn&#39;t match the custom field. |  -  |


## getOptionsForField

> PageBeanCustomFieldOptionDetails getOptionsForField(fieldId, startAt, maxResults)

Get options for field

Returns a [paginated](#pagination) list of options and, where the custom select field is of the type *Select List (cascading)*, cascading options for custom select fields. Cascading options are included in the item count when determining pagination. Only options from the global context are returned.  Note that this operation **only works for issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource**, it cannot be used with issue field select list options created by Connect apps.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.IssueCustomFieldOptionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://your-domain.atlassian.com");
        
        // Configure OAuth2 access token for authorization: OAuth2
        OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
        OAuth2.setAccessToken("YOUR ACCESS TOKEN");

        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        IssueCustomFieldOptionsApi apiInstance = new IssueCustomFieldOptionsApi(defaultClient);
        Long fieldId = 56L; // Long | The ID of the custom field. Note: This is the numeric part of the of the field ID. For example, for a field with the ID *customfield\\_10075* use *10075*.
        Long startAt = 0l; // Long | The index of the first item to return in a page of results (page offset).
        Integer maxResults = 1000; // Integer | The maximum number of items to return per page.
        try {
            PageBeanCustomFieldOptionDetails result = apiInstance.getOptionsForField(fieldId, startAt, maxResults);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueCustomFieldOptionsApi#getOptionsForField");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fieldId** | **Long**| The ID of the custom field. Note: This is the numeric part of the of the field ID. For example, for a field with the ID *customfield\\_10075* use *10075*. |
 **startAt** | **Long**| The index of the first item to return in a page of results (page offset). | [optional] [default to 0l]
 **maxResults** | **Integer**| The maximum number of items to return per page. | [optional] [default to 1000]

### Return type

[**PageBeanCustomFieldOptionDetails**](PageBeanCustomFieldOptionDetails.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **400** | Returned if the request is invalid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **404** | Returned if the field is not found. |  -  |


## reorderCustomFieldOptions

> Object reorderCustomFieldOptions(fieldId, contextId, orderOfCustomFieldOptions)

Reorder custom field options (context)

Changes the order of custom field options or cascading options in a context.  This operation works for custom field options created in Jira or the operations from this resource. **To work with issue field select list options created for Connect apps use the [Issue custom field options (apps)](#api-group-issue-custom-field-options--apps-) operations.**  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.IssueCustomFieldOptionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://your-domain.atlassian.com");
        
        // Configure OAuth2 access token for authorization: OAuth2
        OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
        OAuth2.setAccessToken("YOUR ACCESS TOKEN");

        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        IssueCustomFieldOptionsApi apiInstance = new IssueCustomFieldOptionsApi(defaultClient);
        String fieldId = "fieldId_example"; // String | The ID of the custom field.
        Long contextId = 56L; // Long | The ID of the context.
        OrderOfCustomFieldOptions orderOfCustomFieldOptions = {"position":"First","customFieldOptionIds":["10001","10002"]}; // OrderOfCustomFieldOptions | 
        try {
            Object result = apiInstance.reorderCustomFieldOptions(fieldId, contextId, orderOfCustomFieldOptions);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueCustomFieldOptionsApi#reorderCustomFieldOptions");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fieldId** | **String**| The ID of the custom field. |
 **contextId** | **Long**| The ID of the context. |
 **orderOfCustomFieldOptions** | [**OrderOfCustomFieldOptions**](OrderOfCustomFieldOptions.md)|  |

### Return type

**Object**

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | Returned if options are reordered. |  -  |
| **400** | Returned if the request is not valid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the necessary permission. |  -  |
| **404** | Returned if the field, the context, or one or more of the options is not found.. |  -  |


## updateCustomFieldOption

> CustomFieldUpdatedContextOptionsList updateCustomFieldOption(fieldId, contextId, bulkCustomFieldOptionUpdateRequest)

Update custom field options (context)

Updates the options of a custom field.  If any of the options are not found, no options are updated. Options where the values in the request match the current values aren&#39;t updated and aren&#39;t reported in the response.  Note that this operation **only works for issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource**, it cannot be used with issue field select list options created by Connect apps.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.IssueCustomFieldOptionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://your-domain.atlassian.com");
        
        // Configure OAuth2 access token for authorization: OAuth2
        OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
        OAuth2.setAccessToken("YOUR ACCESS TOKEN");

        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        IssueCustomFieldOptionsApi apiInstance = new IssueCustomFieldOptionsApi(defaultClient);
        String fieldId = "fieldId_example"; // String | The ID of the custom field.
        Long contextId = 56L; // Long | The ID of the context.
        BulkCustomFieldOptionUpdateRequest bulkCustomFieldOptionUpdateRequest = {"options":[{"disabled":false,"id":"10001","value":"Scranton"},{"disabled":true,"id":"10002","value":"Manhattan"},{"disabled":false,"id":"10003","value":"The Electric City"}]}; // BulkCustomFieldOptionUpdateRequest | 
        try {
            CustomFieldUpdatedContextOptionsList result = apiInstance.updateCustomFieldOption(fieldId, contextId, bulkCustomFieldOptionUpdateRequest);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueCustomFieldOptionsApi#updateCustomFieldOption");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fieldId** | **String**| The ID of the custom field. |
 **contextId** | **Long**| The ID of the context. |
 **bulkCustomFieldOptionUpdateRequest** | [**BulkCustomFieldOptionUpdateRequest**](BulkCustomFieldOptionUpdateRequest.md)|  |

### Return type

[**CustomFieldUpdatedContextOptionsList**](CustomFieldUpdatedContextOptionsList.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **400** | Returned if the request is not valid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the necessary permission. |  -  |
| **404** | Returned if the field, context, or one or more options is not found. |  -  |


## updateCustomFieldOptions

> Object updateCustomFieldOptions(fieldId, updateCustomFieldOption)

Update custom field options

Updates the options on a custom select field. Where an updated option is in use on an issue, the value on the issue is also updated. Options that are not found are ignored. A maximum of 1000 options, including sub-options of *Select List (cascading)* fields, can be updated per request. The options are updated on the global context of the field.  Note that this operation **only works for issue field select list options created in Jira or using operations from the [Issue custom field options](#api-group-Issue-custom-field-options) resource**, it cannot be used with issue field select list options created by Connect apps.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.IssueCustomFieldOptionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://your-domain.atlassian.com");
        
        // Configure OAuth2 access token for authorization: OAuth2
        OAuth OAuth2 = (OAuth) defaultClient.getAuthentication("OAuth2");
        OAuth2.setAccessToken("YOUR ACCESS TOKEN");

        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        IssueCustomFieldOptionsApi apiInstance = new IssueCustomFieldOptionsApi(defaultClient);
        Long fieldId = 56L; // Long | The ID of the custom field. Note: This is the numeric part of the of the field ID. For example, for a field with the ID *customfield\\_10075* use *10075*.
        UpdateCustomFieldOption updateCustomFieldOption = {"options":[{"newValue":"New option","value":"Option"},{"cascadingOptions":[{"newValue":"New first child option","value":"First child option"}],"newValue":"Second option","value":"Second option"},{"cascadingOptions":[{"newValue":"New second child option","value":"Second child option"},{"newValue":"New third child option","value":"Third child option"}],"newValue":"New third option value","value":"Third option value"}]}; // UpdateCustomFieldOption | 
        try {
            Object result = apiInstance.updateCustomFieldOptions(fieldId, updateCustomFieldOption);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueCustomFieldOptionsApi#updateCustomFieldOptions");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fieldId** | **Long**| The ID of the custom field. Note: This is the numeric part of the of the field ID. For example, for a field with the ID *customfield\\_10075* use *10075*. |
 **updateCustomFieldOption** | [**UpdateCustomFieldOption**](UpdateCustomFieldOption.md)|  |

### Return type

**Object**

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | Returned if the request is successful. |  -  |
| **400** | Returned if the request is invalid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **404** | Returned if the field is not found. |  -  |

