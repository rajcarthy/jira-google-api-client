# IssueFieldsApi

All URIs are relative to *https://your-domain.atlassian.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createCustomField**](IssueFieldsApi.md#createCustomField) | **POST** /rest/api/3/field | Create custom field
[**getContextsForFieldDeprecated**](IssueFieldsApi.md#getContextsForFieldDeprecated) | **GET** /rest/api/3/field/{fieldId}/contexts | Get contexts for a field
[**getFields**](IssueFieldsApi.md#getFields) | **GET** /rest/api/3/field | Get fields
[**getFieldsPaginated**](IssueFieldsApi.md#getFieldsPaginated) | **GET** /rest/api/3/field/search | Get fields paginated



## createCustomField

> FieldDetails createCustomField(customFieldDefinitionJsonBean)

Create custom field

Creates a custom field.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.IssueFieldsApi;

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

        IssueFieldsApi apiInstance = new IssueFieldsApi(defaultClient);
        CustomFieldDefinitionJsonBean customFieldDefinitionJsonBean = {"searcherKey":"com.atlassian.jira.plugin.system.customfieldtypes:grouppickersearcher","name":"New custom field","description":"Custom field for picking groups","type":"com.atlassian.jira.plugin.system.customfieldtypes:grouppicker"}; // CustomFieldDefinitionJsonBean | Definition of the custom field to be created
        try {
            FieldDetails result = apiInstance.createCustomField(customFieldDefinitionJsonBean);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueFieldsApi#createCustomField");
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
 **customFieldDefinitionJsonBean** | [**CustomFieldDefinitionJsonBean**](CustomFieldDefinitionJsonBean.md)| Definition of the custom field to be created |

### Return type

[**FieldDetails**](FieldDetails.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Returned if the custom field is created. |  -  |
| **400** | Returned if:   *  the user does not have permission to create custom fields.  *  any of the request object properties have invalid or missing values. |  -  |


## getContextsForFieldDeprecated

> PageBeanContext getContextsForFieldDeprecated(fieldId, startAt, maxResults)

Get contexts for a field

Returns a [paginated](#pagination) list of the contexts a field is used in. Deprecated, use [ Get custom field contexts](#api-rest-api-3-field-fieldId-context-get).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.IssueFieldsApi;

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

        IssueFieldsApi apiInstance = new IssueFieldsApi(defaultClient);
        String fieldId = "fieldId_example"; // String | The ID of the field to return contexts for.
        Long startAt = 0l; // Long | The index of the first item to return in a page of results (page offset).
        Integer maxResults = 20; // Integer | The maximum number of items to return per page.
        try {
            PageBeanContext result = apiInstance.getContextsForFieldDeprecated(fieldId, startAt, maxResults);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueFieldsApi#getContextsForFieldDeprecated");
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
 **fieldId** | **String**| The ID of the field to return contexts for. |
 **startAt** | **Long**| The index of the first item to return in a page of results (page offset). | [optional] [default to 0l]
 **maxResults** | **Integer**| The maximum number of items to return per page. | [optional] [default to 20]

### Return type

[**PageBeanContext**](PageBeanContext.md)

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
| **403** | Returned if the user does not have the necessary permission. |  -  |


## getFields

> List&lt;FieldDetails&gt; getFields()

Get fields

Returns system and custom issue fields according to the following rules:   *  Fields that cannot be added to the issue navigator are always returned.  *  Fields that cannot be placed on an issue screen are always returned.  *  Fields that depend on global Jira settings are only returned if the setting is enabled. That is, timetracking fields, subtasks, votes, and watches.  *  For all other fields, this operation only returns the fields that the user has permission to view (that is, the field is used in at least one project that the user has *Browse Projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for.)  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.IssueFieldsApi;

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

        IssueFieldsApi apiInstance = new IssueFieldsApi(defaultClient);
        try {
            List<FieldDetails> result = apiInstance.getFields();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueFieldsApi#getFields");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**List&lt;FieldDetails&gt;**](FieldDetails.md)

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


## getFieldsPaginated

> PageBeanField getFieldsPaginated(startAt, maxResults, type, id, query, orderBy, expand)

Get fields paginated

Returns a [paginated](#pagination) list of fields for Classic Jira projects. The list can include:   *  all fields.  *  specific fields, by defining &#x60;id&#x60;.  *  fields that contain a string in the field name or description, by defining &#x60;query&#x60;.  *  specific fields that contain a string in the field name or description, by defining &#x60;id&#x60; and &#x60;query&#x60;.  Only custom fields can be queried, &#x60;type&#x60; must be set to &#x60;custom&#x60;.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.IssueFieldsApi;

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

        IssueFieldsApi apiInstance = new IssueFieldsApi(defaultClient);
        Long startAt = 0l; // Long | The index of the first item to return in a page of results (page offset).
        Integer maxResults = 50; // Integer | The maximum number of items to return per page.
        List<String> type = Arrays.asList(); // List<String> | The type of fields to search.
        Set<String> id = Arrays.asList(); // Set<String> | The IDs of the custom fields to return or, where `query` is specified, filter.
        String query = "query_example"; // String | String used to perform a case-insensitive partial match with field names or descriptions.
        String orderBy = "orderBy_example"; // String | [Order](#ordering) the results by a field:   *  `contextsCount` Sorts by the number of contexts related to a field.  *  `lastUsed` Sorts by the date when the value of the field last changed.  *  `name` Sorts by the field name.  *  `screensCount` Sorts by the number of screens related to a field.
        String expand = "expand_example"; // String | Use [expand](#expansion) to include additional information in the response. This parameter accepts a comma-separated list. Expand options include:   *  `key` Returns the key for each field.  *  `lastUsed` Returns the date when the value of the field last changed.  *  `screensCount` Returns the number of screens related to a field.  *  `contextsCount` Returns the number of contexts related to a field.  *  `isLocked` Returns information about whether the field is [locked](https://confluence.atlassian.com/x/ZSN7Og).
        try {
            PageBeanField result = apiInstance.getFieldsPaginated(startAt, maxResults, type, id, query, orderBy, expand);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueFieldsApi#getFieldsPaginated");
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
 **startAt** | **Long**| The index of the first item to return in a page of results (page offset). | [optional] [default to 0l]
 **maxResults** | **Integer**| The maximum number of items to return per page. | [optional] [default to 50]
 **type** | [**List&lt;String&gt;**](String.md)| The type of fields to search. | [optional] [enum: custom, system]
 **id** | [**Set&lt;String&gt;**](String.md)| The IDs of the custom fields to return or, where &#x60;query&#x60; is specified, filter. | [optional]
 **query** | **String**| String used to perform a case-insensitive partial match with field names or descriptions. | [optional]
 **orderBy** | **String**| [Order](#ordering) the results by a field:   *  &#x60;contextsCount&#x60; Sorts by the number of contexts related to a field.  *  &#x60;lastUsed&#x60; Sorts by the date when the value of the field last changed.  *  &#x60;name&#x60; Sorts by the field name.  *  &#x60;screensCount&#x60; Sorts by the number of screens related to a field. | [optional] [enum: contextsCount, -contextsCount, +contextsCount, lastUsed, -lastUsed, +lastUsed, name, -name, +name, screensCount, -screensCount, +screensCount]
 **expand** | **String**| Use [expand](#expansion) to include additional information in the response. This parameter accepts a comma-separated list. Expand options include:   *  &#x60;key&#x60; Returns the key for each field.  *  &#x60;lastUsed&#x60; Returns the date when the value of the field last changed.  *  &#x60;screensCount&#x60; Returns the number of screens related to a field.  *  &#x60;contextsCount&#x60; Returns the number of contexts related to a field.  *  &#x60;isLocked&#x60; Returns information about whether the field is [locked](https://confluence.atlassian.com/x/ZSN7Og). | [optional]

### Return type

[**PageBeanField**](PageBeanField.md)

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
| **403** | Returned if the user does not have the necessary permission. |  -  |

