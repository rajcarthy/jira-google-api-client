# ProjectComponentsApi

All URIs are relative to *https://your-domain.atlassian.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createComponent**](ProjectComponentsApi.md#createComponent) | **POST** /rest/api/3/component | Create component
[**deleteComponent**](ProjectComponentsApi.md#deleteComponent) | **DELETE** /rest/api/3/component/{id} | Delete component
[**getComponent**](ProjectComponentsApi.md#getComponent) | **GET** /rest/api/3/component/{id} | Get component
[**getComponentRelatedIssues**](ProjectComponentsApi.md#getComponentRelatedIssues) | **GET** /rest/api/3/component/{id}/relatedIssueCounts | Get component issues count
[**getProjectComponents**](ProjectComponentsApi.md#getProjectComponents) | **GET** /rest/api/3/project/{projectIdOrKey}/components | Get project components
[**getProjectComponentsPaginated**](ProjectComponentsApi.md#getProjectComponentsPaginated) | **GET** /rest/api/3/project/{projectIdOrKey}/component | Get project components paginated
[**updateComponent**](ProjectComponentsApi.md#updateComponent) | **PUT** /rest/api/3/component/{id} | Update component



## createComponent

> Component createComponent(component)

Create component

Creates a component. Use components to provide containers for issues within a project.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Administer projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project in which the component is created or *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.ProjectComponentsApi;

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

        ProjectComponentsApi apiInstance = new ProjectComponentsApi(defaultClient);
        Component component = {"isAssigneeTypeValid":false,"name":"Component 1","description":"This is a Jira component","project":"HSP","assigneeType":"PROJECT_LEAD","leadAccountId":"5b10a2844c20165700ede21g"}; // Component | 
        try {
            Component result = apiInstance.createComponent(component);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectComponentsApi#createComponent");
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
 **component** | [**Component**](Component.md)|  |

### Return type

[**Component**](Component.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Returned if the request is successful. |  -  |
| **400** | Returned if:   *  the user is not found.  *  &#x60;name&#x60; is not provided.  *  &#x60;name&#x60; is over 255 characters in length.  *  &#x60;projectId&#x60; is not provided.  *  &#x60;assigneeType&#x60; is an invalid value. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have permission to manage the project containing the component or does not have permission to administer Jira. |  -  |
| **404** | Returned if the project is not found or the user does not have permission to browse the project containing the component. |  -  |


## deleteComponent

> deleteComponent(id, moveIssuesTo)

Delete component

Deletes a component.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Administer projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project containing the component or *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.ProjectComponentsApi;

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

        ProjectComponentsApi apiInstance = new ProjectComponentsApi(defaultClient);
        String id = "id_example"; // String | The ID of the component.
        String moveIssuesTo = "moveIssuesTo_example"; // String | The ID of the component to replace the deleted component. If this value is null no replacement is made.
        try {
            apiInstance.deleteComponent(id, moveIssuesTo);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectComponentsApi#deleteComponent");
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
 **id** | **String**| The ID of the component. |
 **moveIssuesTo** | **String**| The ID of the component to replace the deleted component. If this value is null no replacement is made. | [optional]

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
| **403** | Returned if the user does not have permission to manage the project containing the component or does not have permission to administer Jira. |  -  |
| **404** | Returned if:   *  the component is not found.  *  the replacement component is not found.  *  the user does not have permission to browse the project containing the component. |  -  |


## getComponent

> Component getComponent(id)

Get component

Returns a component.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for project containing the component.

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.ProjectComponentsApi;

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

        ProjectComponentsApi apiInstance = new ProjectComponentsApi(defaultClient);
        String id = "id_example"; // String | The ID of the component.
        try {
            Component result = apiInstance.getComponent(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectComponentsApi#getComponent");
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
 **id** | **String**| The ID of the component. |

### Return type

[**Component**](Component.md)

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
| **404** | Returned if the component is not found or the user does not have permission to browse the project containing the component. |  -  |


## getComponentRelatedIssues

> ComponentIssuesCount getComponentRelatedIssues(id)

Get component issues count

Returns the counts of issues assigned to the component.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.ProjectComponentsApi;

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

        ProjectComponentsApi apiInstance = new ProjectComponentsApi(defaultClient);
        String id = "id_example"; // String | The ID of the component.
        try {
            ComponentIssuesCount result = apiInstance.getComponentRelatedIssues(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectComponentsApi#getComponentRelatedIssues");
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
 **id** | **String**| The ID of the component. |

### Return type

[**ComponentIssuesCount**](ComponentIssuesCount.md)

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
| **404** | Returned if the component is not found. |  -  |


## getProjectComponents

> List&lt;Component&gt; getProjectComponents(projectIdOrKey)

Get project components

Returns all components in a project. See the [Get project components paginated](#api-rest-api-3-project-projectIdOrKey-component-get) resource if you want to get a full list of components with pagination.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Browse Projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project.

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.ProjectComponentsApi;

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

        ProjectComponentsApi apiInstance = new ProjectComponentsApi(defaultClient);
        String projectIdOrKey = "projectIdOrKey_example"; // String | The project ID or project key (case sensitive).
        try {
            List<Component> result = apiInstance.getProjectComponents(projectIdOrKey);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectComponentsApi#getProjectComponents");
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
 **projectIdOrKey** | **String**| The project ID or project key (case sensitive). |

### Return type

[**List&lt;Component&gt;**](Component.md)

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
| **404** | Returned if the project is not found or the user does not have permission to view it. |  -  |


## getProjectComponentsPaginated

> PageBeanComponentWithIssueCount getProjectComponentsPaginated(projectIdOrKey, startAt, maxResults, orderBy, query)

Get project components paginated

Returns a [paginated](#pagination) list of all components in a project. See the [Get project components](#api-rest-api-3-project-projectIdOrKey-components-get) resource if you want to get a full list of versions without pagination.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Browse Projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project.

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.ProjectComponentsApi;

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

        ProjectComponentsApi apiInstance = new ProjectComponentsApi(defaultClient);
        String projectIdOrKey = "projectIdOrKey_example"; // String | The project ID or project key (case sensitive).
        Long startAt = 0l; // Long | The index of the first item to return in a page of results (page offset).
        Integer maxResults = 50; // Integer | The maximum number of items to return per page.
        String orderBy = "orderBy_example"; // String | [Order](#ordering) the results by a field:   *  `description` Sorts by the component description.  *  `issueCount` Sorts by the count of issues associated with the component.  *  `lead` Sorts by the user key of the component's project lead.  *  `name` Sorts by component name.
        String query = "query_example"; // String | Filter the results using a literal string. Components with a matching `name` or `description` are returned (case insensitive).
        try {
            PageBeanComponentWithIssueCount result = apiInstance.getProjectComponentsPaginated(projectIdOrKey, startAt, maxResults, orderBy, query);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectComponentsApi#getProjectComponentsPaginated");
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
 **projectIdOrKey** | **String**| The project ID or project key (case sensitive). |
 **startAt** | **Long**| The index of the first item to return in a page of results (page offset). | [optional] [default to 0l]
 **maxResults** | **Integer**| The maximum number of items to return per page. | [optional] [default to 50]
 **orderBy** | **String**| [Order](#ordering) the results by a field:   *  &#x60;description&#x60; Sorts by the component description.  *  &#x60;issueCount&#x60; Sorts by the count of issues associated with the component.  *  &#x60;lead&#x60; Sorts by the user key of the component&#39;s project lead.  *  &#x60;name&#x60; Sorts by component name. | [optional] [enum: description, -description, +description, issueCount, -issueCount, +issueCount, lead, -lead, +lead, name, -name, +name]
 **query** | **String**| Filter the results using a literal string. Components with a matching &#x60;name&#x60; or &#x60;description&#x60; are returned (case insensitive). | [optional]

### Return type

[**PageBeanComponentWithIssueCount**](PageBeanComponentWithIssueCount.md)

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
| **404** | Returned if the project is not found or the user does not have permission to view it. |  -  |


## updateComponent

> Component updateComponent(id, component)

Update component

Updates a component. Any fields included in the request are overwritten. If &#x60;leadAccountId&#x60; is an empty string (\&quot;\&quot;) the component lead is removed.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Administer projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project containing the component or *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.ProjectComponentsApi;

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

        ProjectComponentsApi apiInstance = new ProjectComponentsApi(defaultClient);
        String id = "id_example"; // String | The ID of the component.
        Component component = {"isAssigneeTypeValid":false,"name":"Component 1","description":"This is a Jira component","assigneeType":"PROJECT_LEAD","leadAccountId":"5b10a2844c20165700ede21g"}; // Component | 
        try {
            Component result = apiInstance.updateComponent(id, component);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectComponentsApi#updateComponent");
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
 **id** | **String**| The ID of the component. |
 **component** | [**Component**](Component.md)|  |

### Return type

[**Component**](Component.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **400** | Returned if:   *  the user is not found.  *  &#x60;assigneeType&#x60; is an invalid value.  *  &#x60;name&#x60; is over 255 characters in length. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have permission to manage the project containing the component or does not have permission to administer Jira. |  -  |
| **404** | Returned if the component is not found or the user does not have permission to browse the project containing the component. |  -  |

