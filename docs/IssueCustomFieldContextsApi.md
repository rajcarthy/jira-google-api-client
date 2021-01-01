# IssueCustomFieldContextsApi

All URIs are relative to *https://your-domain.atlassian.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addIssueTypesToContext**](IssueCustomFieldContextsApi.md#addIssueTypesToContext) | **PUT** /rest/api/3/field/{fieldId}/context/{contextId}/issuetype | Add issue types to context
[**assignProjectsToCustomFieldContext**](IssueCustomFieldContextsApi.md#assignProjectsToCustomFieldContext) | **PUT** /rest/api/3/field/{fieldId}/context/{contextId}/project | Assign custom field context to projects
[**createCustomFieldContext**](IssueCustomFieldContextsApi.md#createCustomFieldContext) | **POST** /rest/api/3/field/{fieldId}/context | Create custom field context
[**deleteCustomFieldContext**](IssueCustomFieldContextsApi.md#deleteCustomFieldContext) | **DELETE** /rest/api/3/field/{fieldId}/context/{contextId} | Delete custom field context
[**getContextsForField**](IssueCustomFieldContextsApi.md#getContextsForField) | **GET** /rest/api/3/field/{fieldId}/context | Get custom field contexts
[**getCustomFieldContextsForProjectsAndIssueTypes**](IssueCustomFieldContextsApi.md#getCustomFieldContextsForProjectsAndIssueTypes) | **POST** /rest/api/3/field/{fieldId}/context/mapping | Get custom field contexts for projects and issue types
[**getIssueTypeMappingsForContexts**](IssueCustomFieldContextsApi.md#getIssueTypeMappingsForContexts) | **GET** /rest/api/3/field/{fieldId}/context/issueTypeMapping | Get issue types for custom field context
[**removeCustomFieldContextFromProjects**](IssueCustomFieldContextsApi.md#removeCustomFieldContextFromProjects) | **POST** /rest/api/3/field/{fieldId}/context/{contextId}/project/remove | Remove custom field context from projects
[**updateCustomFieldContext**](IssueCustomFieldContextsApi.md#updateCustomFieldContext) | **PUT** /rest/api/3/field/{fieldId}/context/{contextId} | Update custom field context



## addIssueTypesToContext

> Object addIssueTypesToContext(fieldId, contextId, issueTypeIds)

Add issue types to context

Adds issue types to a custom field context, appending the issue types to the issue types list.  A custom field context without any issue types applies to all issue types. Adding issue types to such a custom field context would result in it applying to only the listed issue types.  If any of the issue types exists in the custom field context, the operation fails and no issue types are added.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.IssueCustomFieldContextsApi;

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

        IssueCustomFieldContextsApi apiInstance = new IssueCustomFieldContextsApi(defaultClient);
        String fieldId = "fieldId_example"; // String | The ID of the custom field.
        Long contextId = 56L; // Long | The ID of the context.
        IssueTypeIds issueTypeIds = {"issueTypeIds":["10001","10005","10006"]}; // IssueTypeIds | 
        try {
            Object result = apiInstance.addIssueTypesToContext(fieldId, contextId, issueTypeIds);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueCustomFieldContextsApi#addIssueTypesToContext");
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
 **issueTypeIds** | [**IssueTypeIds**](IssueTypeIds.md)|  |

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
| **204** | Returned if operation is successful. |  -  |
| **400** | Returned if the request is not valid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the required permissions. |  -  |
| **404** | Returned if the custom field, context, or issue type is not found. |  -  |
| **409** | Returned if the issue type is a sub-task, but sub-tasks are disabled in Jira settings. |  -  |


## assignProjectsToCustomFieldContext

> Object assignProjectsToCustomFieldContext(fieldId, contextId, projectIds)

Assign custom field context to projects

Assigns a custom field context to projects.  If any project in the request is assigned to any context of the custom field, the operation fails.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.IssueCustomFieldContextsApi;

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

        IssueCustomFieldContextsApi apiInstance = new IssueCustomFieldContextsApi(defaultClient);
        String fieldId = "fieldId_example"; // String | The ID of the custom field.
        Long contextId = 56L; // Long | The ID of the context.
        ProjectIds projectIds = {"projectIds":["10001","10005","10006"]}; // ProjectIds | 
        try {
            Object result = apiInstance.assignProjectsToCustomFieldContext(fieldId, contextId, projectIds);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueCustomFieldContextsApi#assignProjectsToCustomFieldContext");
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
 **projectIds** | [**ProjectIds**](ProjectIds.md)|  |

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
| **204** | Returned if operation is successful. |  -  |
| **400** | Returned if the request is not valid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the required permissions. |  -  |
| **404** | Returned if the custom field, context, or project is not found. |  -  |


## createCustomFieldContext

> CreateCustomFieldContext createCustomFieldContext(fieldId, createCustomFieldContext)

Create custom field context

Creates a custom field context.  If &#x60;projectIds&#x60; is empty, a global context is created. A global context is one that applies to all project. If &#x60;issueTypeIds&#x60; is empty, the context applies to all issue types.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.IssueCustomFieldContextsApi;

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

        IssueCustomFieldContextsApi apiInstance = new IssueCustomFieldContextsApi(defaultClient);
        String fieldId = "fieldId_example"; // String | The ID of the custom field.
        CreateCustomFieldContext createCustomFieldContext = {"issueTypeIds":["10010"],"name":"Bug fields context","description":"A context used to define the custom field options for bugs.","projectIds":[]}; // CreateCustomFieldContext | 
        try {
            CreateCustomFieldContext result = apiInstance.createCustomFieldContext(fieldId, createCustomFieldContext);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueCustomFieldContextsApi#createCustomFieldContext");
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
 **createCustomFieldContext** | [**CreateCustomFieldContext**](CreateCustomFieldContext.md)|  |

### Return type

[**CreateCustomFieldContext**](CreateCustomFieldContext.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Returned if the custom field context is created. |  -  |
| **400** | Returned if the request is invalid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **404** | Returned if the field, project, or issue type is not found. |  -  |
| **409** | Returned if the issue type is a sub-task, but sub-tasks are disabled in Jira settings. |  -  |


## deleteCustomFieldContext

> Object deleteCustomFieldContext(fieldId, contextId)

Delete custom field context

Deletes a [ custom field context](https://confluence.atlassian.com/adminjiracloud/what-are-custom-field-contexts-991923859.html).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.IssueCustomFieldContextsApi;

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

        IssueCustomFieldContextsApi apiInstance = new IssueCustomFieldContextsApi(defaultClient);
        String fieldId = "fieldId_example"; // String | The ID of the custom field.
        Long contextId = 56L; // Long | The ID of the context.
        try {
            Object result = apiInstance.deleteCustomFieldContext(fieldId, contextId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueCustomFieldContextsApi#deleteCustomFieldContext");
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

### Return type

**Object**

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | Returned if the context is deleted. |  -  |
| **400** | Returned if the request is not valid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the required permissions. |  -  |
| **404** | Returned if the custom field or the context is not found. |  -  |


## getContextsForField

> PageBeanCustomFieldContext getContextsForField(fieldId, isAnyIssueType, isGlobalContext, contextId, startAt, maxResults)

Get custom field contexts

Returns a [paginated](#pagination) list of [ contexts](https://confluence.atlassian.com/adminjiracloud/what-are-custom-field-contexts-991923859.html) for a custom field. Contexts can be returned as follows:   *  With no other parameters set, all contexts.  *  By defining &#x60;id&#x60; only, all contexts from the list of IDs.  *  By defining &#x60;isAnyIssueType&#x60;, limit the list of contexts returned to either those that apply to all issue types (true) or those that apply to only a subset of issue types (false)  *  By defining &#x60;isGlobalContext&#x60;, limit the list of contexts return to either those that apply to all projects (global contexts) (true) or those that apply to only a subset of projects (false).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.IssueCustomFieldContextsApi;

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

        IssueCustomFieldContextsApi apiInstance = new IssueCustomFieldContextsApi(defaultClient);
        String fieldId = "fieldId_example"; // String | The ID of the custom field.
        Boolean isAnyIssueType = true; // Boolean | Whether to return contexts that apply to all issue types.
        Boolean isGlobalContext = true; // Boolean | Whether to return contexts that apply to all projects.
        Set<Long> contextId = Arrays.asList(); // Set<Long> | The list of context IDs. To include multiple contexts, separate IDs with ampersand: `contextId=10000&contextId=10001`.
        Long startAt = 0l; // Long | The index of the first item to return in a page of results (page offset).
        Integer maxResults = 50; // Integer | The maximum number of items to return per page.
        try {
            PageBeanCustomFieldContext result = apiInstance.getContextsForField(fieldId, isAnyIssueType, isGlobalContext, contextId, startAt, maxResults);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueCustomFieldContextsApi#getContextsForField");
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
 **isAnyIssueType** | **Boolean**| Whether to return contexts that apply to all issue types. | [optional]
 **isGlobalContext** | **Boolean**| Whether to return contexts that apply to all projects. | [optional]
 **contextId** | [**Set&lt;Long&gt;**](Long.md)| The list of context IDs. To include multiple contexts, separate IDs with ampersand: &#x60;contextId&#x3D;10000&amp;contextId&#x3D;10001&#x60;. | [optional]
 **startAt** | **Long**| The index of the first item to return in a page of results (page offset). | [optional] [default to 0l]
 **maxResults** | **Integer**| The maximum number of items to return per page. | [optional] [default to 50]

### Return type

[**PageBeanCustomFieldContext**](PageBeanCustomFieldContext.md)

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
| **403** | Returned if the user does not have the required permissions. |  -  |
| **404** | Returned if the custom field was not found. |  -  |


## getCustomFieldContextsForProjectsAndIssueTypes

> PageBeanContextForProjectAndIssueType getCustomFieldContextsForProjectsAndIssueTypes(fieldId, projectIssueTypeMappings, startAt, maxResults)

Get custom field contexts for projects and issue types

Returns a [paginated](#pagination) list of project and issue type mappings and, for each mapping, the ID of a [custom field context](https://confluence.atlassian.com/x/k44fOw) that applies to the project and issue type.  If there is no custom field context assigned to the project then, if present, the custom field context that applies to all projects is returned if it also applies to the issue type or all issue types. If a custom field context is not found, the returned custom field context ID is &#x60;null&#x60;.  Duplicate project and issue type mappings cannot be provided in the request.  The order of the returned values is the same as provided in the request.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.IssueCustomFieldContextsApi;

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

        IssueCustomFieldContextsApi apiInstance = new IssueCustomFieldContextsApi(defaultClient);
        String fieldId = "fieldId_example"; // String | The ID of the custom field.
        ProjectIssueTypeMappings projectIssueTypeMappings = {"mappings":[{"issueTypeId":"10000","projectId":"10000"},{"issueTypeId":"10001","projectId":"10000"},{"issueTypeId":"10002","projectId":"10001"}]}; // ProjectIssueTypeMappings | The list of project and issue type mappings.
        Long startAt = 0l; // Long | The index of the first item to return in a page of results (page offset).
        Integer maxResults = 50; // Integer | The maximum number of items to return per page.
        try {
            PageBeanContextForProjectAndIssueType result = apiInstance.getCustomFieldContextsForProjectsAndIssueTypes(fieldId, projectIssueTypeMappings, startAt, maxResults);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueCustomFieldContextsApi#getCustomFieldContextsForProjectsAndIssueTypes");
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
 **projectIssueTypeMappings** | [**ProjectIssueTypeMappings**](ProjectIssueTypeMappings.md)| The list of project and issue type mappings. |
 **startAt** | **Long**| The index of the first item to return in a page of results (page offset). | [optional] [default to 0l]
 **maxResults** | **Integer**| The maximum number of items to return per page. | [optional] [default to 50]

### Return type

[**PageBeanContextForProjectAndIssueType**](PageBeanContextForProjectAndIssueType.md)

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
| **403** | Returned if the user does not have the required permissions. |  -  |
| **404** | Returned if the custom field, project, or issue type is not found. |  -  |


## getIssueTypeMappingsForContexts

> PageBeanIssueTypeToContextMapping getIssueTypeMappingsForContexts(fieldId, contextId, startAt, maxResults)

Get issue types for custom field context

Returns a [paginated](#pagination) list of context to issue type mappings for a custom field. Mappings are returned for all contexts or a list of contexts. Mappings are ordered first by context ID and then by issue type ID.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.IssueCustomFieldContextsApi;

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

        IssueCustomFieldContextsApi apiInstance = new IssueCustomFieldContextsApi(defaultClient);
        String fieldId = "fieldId_example"; // String | The ID of the custom field.
        List<Long> contextId = Arrays.asList(); // List<Long> | The ID of the context. To include multiple contexts, provide an ampersand-separated list. For example, `contextId=10001&contextId=10002`.
        Long startAt = 0l; // Long | The index of the first item to return in a page of results (page offset).
        Integer maxResults = 50; // Integer | The maximum number of items to return per page.
        try {
            PageBeanIssueTypeToContextMapping result = apiInstance.getIssueTypeMappingsForContexts(fieldId, contextId, startAt, maxResults);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueCustomFieldContextsApi#getIssueTypeMappingsForContexts");
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
 **contextId** | [**List&lt;Long&gt;**](Long.md)| The ID of the context. To include multiple contexts, provide an ampersand-separated list. For example, &#x60;contextId&#x3D;10001&amp;contextId&#x3D;10002&#x60;. | [optional]
 **startAt** | **Long**| The index of the first item to return in a page of results (page offset). | [optional] [default to 0l]
 **maxResults** | **Integer**| The maximum number of items to return per page. | [optional] [default to 50]

### Return type

[**PageBeanIssueTypeToContextMapping**](PageBeanIssueTypeToContextMapping.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if operation is successful. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the required permissions. |  -  |


## removeCustomFieldContextFromProjects

> Object removeCustomFieldContextFromProjects(fieldId, contextId, projectIds)

Remove custom field context from projects

Removes a custom field context from projects.  A custom field context without any projects applies to all projects. Removing all projects from a custom field context would result in it applying to all projects.  If any project in the request is not assigned to the context, or the operation would result in two global contexts for the field, the operation fails.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.IssueCustomFieldContextsApi;

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

        IssueCustomFieldContextsApi apiInstance = new IssueCustomFieldContextsApi(defaultClient);
        String fieldId = "fieldId_example"; // String | The ID of the custom field.
        Long contextId = 56L; // Long | The ID of the context.
        ProjectIds projectIds = {"projectIds":["10001","10005","10006"]}; // ProjectIds | 
        try {
            Object result = apiInstance.removeCustomFieldContextFromProjects(fieldId, contextId, projectIds);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueCustomFieldContextsApi#removeCustomFieldContextFromProjects");
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
 **projectIds** | [**ProjectIds**](ProjectIds.md)|  |

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
| **204** | Returned if the custom field context is removed from the projects. |  -  |
| **400** | Returned if the request is not valid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the required permissions. |  -  |
| **404** | Returned if the custom field, context, or one or more projects are not found. |  -  |


## updateCustomFieldContext

> Object updateCustomFieldContext(fieldId, contextId, customFieldContextUpdateDetails)

Update custom field context

Updates a [ custom field context](https://confluence.atlassian.com/adminjiracloud/what-are-custom-field-contexts-991923859.html).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.IssueCustomFieldContextsApi;

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

        IssueCustomFieldContextsApi apiInstance = new IssueCustomFieldContextsApi(defaultClient);
        String fieldId = "fieldId_example"; // String | The ID of the custom field.
        Long contextId = 56L; // Long | The ID of the context.
        CustomFieldContextUpdateDetails customFieldContextUpdateDetails = {"name":"Bug fields context","description":"A context used to define the custom field options for bugs."}; // CustomFieldContextUpdateDetails | 
        try {
            Object result = apiInstance.updateCustomFieldContext(fieldId, contextId, customFieldContextUpdateDetails);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueCustomFieldContextsApi#updateCustomFieldContext");
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
 **customFieldContextUpdateDetails** | [**CustomFieldContextUpdateDetails**](CustomFieldContextUpdateDetails.md)|  |

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
| **204** | Returned if the context is updated. |  -  |
| **400** | Returned if the request is not valid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the required permissions. |  -  |
| **404** | Returned if the custom field or the context is not found. |  -  |

