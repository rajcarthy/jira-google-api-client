# IssuePropertiesApi

All URIs are relative to *https://your-domain.atlassian.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**bulkDeleteIssueProperty**](IssuePropertiesApi.md#bulkDeleteIssueProperty) | **DELETE** /rest/api/3/issue/properties/{propertyKey} | Bulk delete issue property
[**bulkSetIssueProperty**](IssuePropertiesApi.md#bulkSetIssueProperty) | **PUT** /rest/api/3/issue/properties/{propertyKey} | Bulk set issue property
[**bulkSetIssuesProperties**](IssuePropertiesApi.md#bulkSetIssuesProperties) | **POST** /rest/api/3/issue/properties | Bulk set issues properties
[**deleteIssueProperty**](IssuePropertiesApi.md#deleteIssueProperty) | **DELETE** /rest/api/3/issue/{issueIdOrKey}/properties/{propertyKey} | Delete issue property
[**getIssueProperty**](IssuePropertiesApi.md#getIssueProperty) | **GET** /rest/api/3/issue/{issueIdOrKey}/properties/{propertyKey} | Get issue property
[**getIssuePropertyKeys**](IssuePropertiesApi.md#getIssuePropertyKeys) | **GET** /rest/api/3/issue/{issueIdOrKey}/properties | Get issue property keys
[**setIssueProperty**](IssuePropertiesApi.md#setIssueProperty) | **PUT** /rest/api/3/issue/{issueIdOrKey}/properties/{propertyKey} | Set issue property



## bulkDeleteIssueProperty

> bulkDeleteIssueProperty(propertyKey, issueFilterForBulkPropertyDelete)

Bulk delete issue property

Deletes a property value from multiple issues. The issues to be updated can be specified by filter criteria.  The criteria the filter used to identify eligible issues are:   *  &#x60;entityIds&#x60; Only issues from this list are eligible.  *  &#x60;currentValue&#x60; Only issues with the property set to this value are eligible.  If both criteria is specified, they are joined with the logical *AND*: only issues that satisfy both criteria are considered eligible.  If no filter criteria are specified, all the issues visible to the user and where the user has the EDIT\\_ISSUES permission for the issue are considered eligible.  This operation is:   *  transactional, either the property is deleted from all eligible issues or, when errors occur, no properties are deleted.  *  [asynchronous](#async). Follow the &#x60;location&#x60; link in the response to determine the status of the task and use [Get task](#api-rest-api-3-task-taskId-get) to obtain subsequent updates.  **[Permissions](#permissions) required:**   *  *Browse projects* [ project permission](https://confluence.atlassian.com/x/yodKLg) for each project containing issues.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  *Edit issues* [project permission](https://confluence.atlassian.com/x/yodKLg) for each issue.

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.IssuePropertiesApi;

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

        IssuePropertiesApi apiInstance = new IssuePropertiesApi(defaultClient);
        String propertyKey = "propertyKey_example"; // String | The key of the property.
        IssueFilterForBulkPropertyDelete issueFilterForBulkPropertyDelete = {"entityIds":[10100,100010],"currentValue":"deprecated value"}; // IssueFilterForBulkPropertyDelete | 
        try {
            apiInstance.bulkDeleteIssueProperty(propertyKey, issueFilterForBulkPropertyDelete);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssuePropertiesApi#bulkDeleteIssueProperty");
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
 **propertyKey** | **String**| The key of the property. |
 **issueFilterForBulkPropertyDelete** | [**IssueFilterForBulkPropertyDelete**](IssueFilterForBulkPropertyDelete.md)|  |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **303** | Returned if the request is successful. |  -  |
| **400** | Returned if the request is invalid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |


## bulkSetIssueProperty

> bulkSetIssueProperty(propertyKey, bulkIssuePropertyUpdateRequest)

Bulk set issue property

Sets a property value on multiple issues.  The value set can be a constant or determined by a [Jira expression](https://developer.atlassian.com/cloud/jira/platform/jira-expressions/). Expressions must be computable with constant complexity when applied to a set of issues. Expressions must also comply with the [restrictions](https://developer.atlassian.com/cloud/jira/platform/jira-expressions/#restrictions) that apply to all Jira expressions.  The issues to be updated can be specified by a filter.  The filter identifies issues eligible for update using these criteria:   *  &#x60;entityIds&#x60; Only issues from this list are eligible.  *  &#x60;currentValue&#x60; Only issues with the property set to this value are eligible.  *  &#x60;hasProperty&#x60;:           *  If *true*, only issues with the property are eligible.      *  If *false*, only issues without the property are eligible.  If more than one criteria is specified, they are joined with the logical *AND*: only issues that satisfy all criteria are eligible.  If an invalid combination of criteria is provided, an error is returned. For example, specifying a &#x60;currentValue&#x60; and &#x60;hasProperty&#x60; as *false* would not match any issues (because without the property the property cannot have a value).  The filter is optional. Without the filter all the issues visible to the user and where the user has the EDIT\\_ISSUES permission for the issue are considered eligible.  This operation is:   *  transactional, either all eligible issues are updated or, when errors occur, none are updated.  *  [asynchronous](#async). Follow the &#x60;location&#x60; link in the response to determine the status of the task and use [Get task](#api-rest-api-3-task-taskId-get) to obtain subsequent updates.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for each project containing issues.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  *Edit issues* [project permission](https://confluence.atlassian.com/x/yodKLg) for each issue.

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.IssuePropertiesApi;

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

        IssuePropertiesApi apiInstance = new IssuePropertiesApi(defaultClient);
        String propertyKey = "propertyKey_example"; // String | The key of the property. The maximum length is 255 characters.
        BulkIssuePropertyUpdateRequest bulkIssuePropertyUpdateRequest = {"filter":{"hasProperty":true,"entityIds":[10100,100010],"currentValue":{"owner":"admin","weight":50}},"value":{"owner":"admin","weight":100}}; // BulkIssuePropertyUpdateRequest | 
        try {
            apiInstance.bulkSetIssueProperty(propertyKey, bulkIssuePropertyUpdateRequest);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssuePropertiesApi#bulkSetIssueProperty");
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
 **propertyKey** | **String**| The key of the property. The maximum length is 255 characters. |
 **bulkIssuePropertyUpdateRequest** | [**BulkIssuePropertyUpdateRequest**](BulkIssuePropertyUpdateRequest.md)|  |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **303** | Returned if the request is successful. |  -  |
| **400** | Returned if the request is invalid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |


## bulkSetIssuesProperties

> bulkSetIssuesProperties(issueEntityProperties)

Bulk set issues properties

Sets the values of entity properties on issues. It can set up to 10 entity properties on up to 10,000 issues.  The value of the request body must be a [valid](http://tools.ietf.org/html/rfc4627), non-empty JSON. The maximum length of single issue property value is 32768 characters. This operation can be accessed anonymously.  This operation is:   *  transactional, either all properties are updated in all eligible issues or, when errors occur, no properties are updated.  *  [asynchronous](#async). Follow the &#x60;location&#x60; link in the response to determine the status of the task and use [Get task](#api-rest-api-3-task-taskId-get) to obtain subsequent updates.  **[Permissions](#permissions) required:**   *  *Browse projects* and *Edit issues* [project permissions](https://confluence.atlassian.com/x/yodKLg) for the project containing the issue.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.IssuePropertiesApi;

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

        IssuePropertiesApi apiInstance = new IssuePropertiesApi(defaultClient);
        IssueEntityProperties issueEntityProperties = new IssueEntityProperties(); // IssueEntityProperties | Issue properties to be set or updated with values.
        try {
            apiInstance.bulkSetIssuesProperties(issueEntityProperties);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssuePropertiesApi#bulkSetIssuesProperties");
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
 **issueEntityProperties** | [**IssueEntityProperties**](IssueEntityProperties.md)| Issue properties to be set or updated with values. |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **303** | Returned if the operation is successful. |  -  |
| **400** | Return if the request is invalid or the user does not have the necessary permission. |  -  |
| **401** | Returned if the authentication credentials are incorrect. |  -  |


## deleteIssueProperty

> deleteIssueProperty(issueIdOrKey, propertyKey)

Delete issue property

Deletes an issue&#39;s property.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* and *Edit issues* [project permissions](https://confluence.atlassian.com/x/yodKLg) for the project containing the issue.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.IssuePropertiesApi;

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

        IssuePropertiesApi apiInstance = new IssuePropertiesApi(defaultClient);
        String issueIdOrKey = "issueIdOrKey_example"; // String | The key or ID of the issue.
        String propertyKey = "propertyKey_example"; // String | The key of the property.
        try {
            apiInstance.deleteIssueProperty(issueIdOrKey, propertyKey);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssuePropertiesApi#deleteIssueProperty");
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
 **issueIdOrKey** | **String**| The key or ID of the issue. |
 **propertyKey** | **String**| The key of the property. |

### Return type

null (empty response body)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | Returned if the request is successful. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **404** | Returned if the issue or property is not found, or the user does not have permission to edit the issue. |  -  |


## getIssueProperty

> EntityProperty getIssueProperty(issueIdOrKey, propertyKey)

Get issue property

Returns the key and value of an issue&#39;s property.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project containing the issue.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.IssuePropertiesApi;

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

        IssuePropertiesApi apiInstance = new IssuePropertiesApi(defaultClient);
        String issueIdOrKey = "issueIdOrKey_example"; // String | The key or ID of the issue.
        String propertyKey = "propertyKey_example"; // String | The key of the property.
        try {
            EntityProperty result = apiInstance.getIssueProperty(issueIdOrKey, propertyKey);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssuePropertiesApi#getIssueProperty");
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
 **issueIdOrKey** | **String**| The key or ID of the issue. |
 **propertyKey** | **String**| The key of the property. |

### Return type

[**EntityProperty**](EntityProperty.md)

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
| **404** | Returned if the issue or property is not found or the user does not have permission to see the issue. |  -  |


## getIssuePropertyKeys

> PropertyKeys getIssuePropertyKeys(issueIdOrKey)

Get issue property keys

Returns the URLs and keys of an issue&#39;s properties.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** Property details are only returned where the user has:   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project containing the issue.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.IssuePropertiesApi;

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

        IssuePropertiesApi apiInstance = new IssuePropertiesApi(defaultClient);
        String issueIdOrKey = "issueIdOrKey_example"; // String | The key or ID of the issue.
        try {
            PropertyKeys result = apiInstance.getIssuePropertyKeys(issueIdOrKey);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssuePropertiesApi#getIssuePropertyKeys");
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
 **issueIdOrKey** | **String**| The key or ID of the issue. |

### Return type

[**PropertyKeys**](PropertyKeys.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **404** | Returned if the issue is not found or the user does not have permissions to view the issue. |  -  |


## setIssueProperty

> Object setIssueProperty(issueIdOrKey, propertyKey, body)

Set issue property

Sets the value of an issue&#39;s property. Use this resource to store custom data against an issue.  The value of the request body must be a [valid](http://tools.ietf.org/html/rfc4627), non-empty JSON blob. The maximum length is 32768 characters.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* and *Edit issues* [project permissions](https://confluence.atlassian.com/x/yodKLg) for the project containing the issue.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.IssuePropertiesApi;

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

        IssuePropertiesApi apiInstance = new IssuePropertiesApi(defaultClient);
        String issueIdOrKey = "issueIdOrKey_example"; // String | The ID or key of the issue.
        String propertyKey = "propertyKey_example"; // String | The key of the issue property. The maximum length is 255 characters.
        Object body = null; // Object | 
        try {
            Object result = apiInstance.setIssueProperty(issueIdOrKey, propertyKey, body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssuePropertiesApi#setIssueProperty");
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
 **issueIdOrKey** | **String**| The ID or key of the issue. |
 **propertyKey** | **String**| The key of the issue property. The maximum length is 255 characters. |
 **body** | **Object**|  |

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
| **200** | Returned if the issue property is updated. |  -  |
| **201** | Returned if the issue property is created. |  -  |
| **400** | Returned if the request is invalid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have permission to edit the issue. |  -  |
| **404** | Returned if the issue is not found or the user does not have permission to view the issue. |  -  |

