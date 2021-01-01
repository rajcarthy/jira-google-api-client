# ScreenSchemesApi

All URIs are relative to *https://your-domain.atlassian.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createScreenScheme**](ScreenSchemesApi.md#createScreenScheme) | **POST** /rest/api/3/screenscheme | Create screen scheme
[**deleteScreenScheme**](ScreenSchemesApi.md#deleteScreenScheme) | **DELETE** /rest/api/3/screenscheme/{screenSchemeId} | Delete screen scheme
[**getScreenSchemes**](ScreenSchemesApi.md#getScreenSchemes) | **GET** /rest/api/3/screenscheme | Get screen schemes
[**updateScreenScheme**](ScreenSchemesApi.md#updateScreenScheme) | **PUT** /rest/api/3/screenscheme/{screenSchemeId} | Update screen scheme



## createScreenScheme

> ScreenSchemeId createScreenScheme(screenSchemeDetails)

Create screen scheme

Creates a screen scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.ScreenSchemesApi;

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

        ScreenSchemesApi apiInstance = new ScreenSchemesApi(defaultClient);
        ScreenSchemeDetails screenSchemeDetails = {"screens":{"default":10017,"view":10020,"edit":10019},"name":"Employee screen scheme","description":"Manage employee data"}; // ScreenSchemeDetails | 
        try {
            ScreenSchemeId result = apiInstance.createScreenScheme(screenSchemeDetails);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScreenSchemesApi#createScreenScheme");
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
 **screenSchemeDetails** | [**ScreenSchemeDetails**](ScreenSchemeDetails.md)|  |

### Return type

[**ScreenSchemeId**](ScreenSchemeId.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Returned if the request is successful. |  -  |
| **400** | Returned if the request is not valid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the required permissions. |  -  |
| **404** | Returned if a screen used as one of the screen types in the screen scheme is not found. |  -  |


## deleteScreenScheme

> deleteScreenScheme(screenSchemeId)

Delete screen scheme

Deletes a screen scheme. A screen scheme cannot be deleted if it is used in an issue type screen scheme.  Only screens schemes used in classic projects can be deleted.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.ScreenSchemesApi;

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

        ScreenSchemesApi apiInstance = new ScreenSchemesApi(defaultClient);
        String screenSchemeId = "screenSchemeId_example"; // String | The ID of the screen scheme.
        try {
            apiInstance.deleteScreenScheme(screenSchemeId);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScreenSchemesApi#deleteScreenScheme");
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
 **screenSchemeId** | **String**| The ID of the screen scheme. |

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
| **204** | Returned if the screen scheme is deleted. |  -  |
| **400** | Returned if the screen scheme is used in an issue type screen scheme. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the necessary permission. |  -  |
| **404** | Returned if the screen scheme is not found. |  -  |


## getScreenSchemes

> PageBeanScreenScheme getScreenSchemes(startAt, maxResults, id)

Get screen schemes

Returns a [paginated](#pagination) list of screen schemes.  Only screen schemes used in classic projects are returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.ScreenSchemesApi;

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

        ScreenSchemesApi apiInstance = new ScreenSchemesApi(defaultClient);
        Long startAt = 0l; // Long | The index of the first item to return in a page of results (page offset).
        Integer maxResults = 25; // Integer | The maximum number of items to return per page.
        Set<Long> id = Arrays.asList(); // Set<Long> | The list of screen scheme IDs. To include multiple IDs, provide an ampersand-separated list. For example, `id=10000&id=10001`.
        try {
            PageBeanScreenScheme result = apiInstance.getScreenSchemes(startAt, maxResults, id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScreenSchemesApi#getScreenSchemes");
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
 **maxResults** | **Integer**| The maximum number of items to return per page. | [optional] [default to 25]
 **id** | [**Set&lt;Long&gt;**](Long.md)| The list of screen scheme IDs. To include multiple IDs, provide an ampersand-separated list. For example, &#x60;id&#x3D;10000&amp;id&#x3D;10001&#x60;. | [optional]

### Return type

[**PageBeanScreenScheme**](PageBeanScreenScheme.md)

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


## updateScreenScheme

> Object updateScreenScheme(screenSchemeId, updateScreenSchemeDetails)

Update screen scheme

Updates a screen scheme. Only screen schemes used in classic projects can be updated.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.ScreenSchemesApi;

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

        ScreenSchemesApi apiInstance = new ScreenSchemesApi(defaultClient);
        String screenSchemeId = "screenSchemeId_example"; // String | The ID of the screen scheme.
        UpdateScreenSchemeDetails updateScreenSchemeDetails = {"screens":{"default":"10018","create":"10019"},"name":"Employee screen scheme v2"}; // UpdateScreenSchemeDetails | The screen scheme update details.
        try {
            Object result = apiInstance.updateScreenScheme(screenSchemeId, updateScreenSchemeDetails);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScreenSchemesApi#updateScreenScheme");
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
 **screenSchemeId** | **String**| The ID of the screen scheme. |
 **updateScreenSchemeDetails** | [**UpdateScreenSchemeDetails**](UpdateScreenSchemeDetails.md)| The screen scheme update details. |

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
| **400** | Returned if the request is not valid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the required permissions. |  -  |
| **404** | Returned if the screen scheme or a screen used as one of the screen types is not found. |  -  |

