# ProjectTypesApi

All URIs are relative to *https://your-domain.atlassian.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getAccessibleProjectTypeByKey**](ProjectTypesApi.md#getAccessibleProjectTypeByKey) | **GET** /rest/api/3/project/type/{projectTypeKey}/accessible | Get accessible project type by key
[**getAllAccessibleProjectTypes**](ProjectTypesApi.md#getAllAccessibleProjectTypes) | **GET** /rest/api/3/project/type/accessible | Get licensed project types
[**getAllProjectTypes**](ProjectTypesApi.md#getAllProjectTypes) | **GET** /rest/api/3/project/type | Get all project types
[**getProjectTypeByKey**](ProjectTypesApi.md#getProjectTypeByKey) | **GET** /rest/api/3/project/type/{projectTypeKey} | Get project type by key



## getAccessibleProjectTypeByKey

> ProjectType getAccessibleProjectTypeByKey(projectTypeKey)

Get accessible project type by key

Returns a [project type](https://confluence.atlassian.com/x/Var1Nw) if it is accessible to the user.  **[Permissions](#permissions) required:** Permission to access Jira.

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.ProjectTypesApi;

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

        ProjectTypesApi apiInstance = new ProjectTypesApi(defaultClient);
        String projectTypeKey = "projectTypeKey_example"; // String | The key of the project type.
        try {
            ProjectType result = apiInstance.getAccessibleProjectTypeByKey(projectTypeKey);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectTypesApi#getAccessibleProjectTypeByKey");
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
 **projectTypeKey** | **String**| The key of the project type. | [enum: software, service_desk, business]

### Return type

[**ProjectType**](ProjectType.md)

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
| **404** | Returned if the project type is not accessible to the user. |  -  |


## getAllAccessibleProjectTypes

> List&lt;ProjectType&gt; getAllAccessibleProjectTypes()

Get licensed project types

Returns all [project types](https://confluence.atlassian.com/x/Var1Nw) with a valid license.

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.ProjectTypesApi;

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

        ProjectTypesApi apiInstance = new ProjectTypesApi(defaultClient);
        try {
            List<ProjectType> result = apiInstance.getAllAccessibleProjectTypes();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectTypesApi#getAllAccessibleProjectTypes");
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

[**List&lt;ProjectType&gt;**](ProjectType.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |


## getAllProjectTypes

> List&lt;ProjectType&gt; getAllProjectTypes()

Get all project types

Returns all [project types](https://confluence.atlassian.com/x/Var1Nw), whether or not the instance has a valid license for each type.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.ProjectTypesApi;

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

        ProjectTypesApi apiInstance = new ProjectTypesApi(defaultClient);
        try {
            List<ProjectType> result = apiInstance.getAllProjectTypes();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectTypesApi#getAllProjectTypes");
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

[**List&lt;ProjectType&gt;**](ProjectType.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **401** | Returned if the authentication credentials are incorrect. |  -  |


## getProjectTypeByKey

> ProjectType getProjectTypeByKey(projectTypeKey)

Get project type by key

Returns a [project type](https://confluence.atlassian.com/x/Var1Nw).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.ProjectTypesApi;

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

        ProjectTypesApi apiInstance = new ProjectTypesApi(defaultClient);
        String projectTypeKey = "projectTypeKey_example"; // String | The key of the project type.
        try {
            ProjectType result = apiInstance.getProjectTypeByKey(projectTypeKey);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectTypesApi#getProjectTypeByKey");
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
 **projectTypeKey** | **String**| The key of the project type. | [enum: software, service_desk, business]

### Return type

[**ProjectType**](ProjectType.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **401** | Returned if the authentication credentials are incorrect. |  -  |
| **404** | Returned if the project type is not found. |  -  |

