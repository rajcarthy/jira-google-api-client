# ScreenTabFieldsApi

All URIs are relative to *https://your-domain.atlassian.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addScreenTabField**](ScreenTabFieldsApi.md#addScreenTabField) | **POST** /rest/api/3/screens/{screenId}/tabs/{tabId}/fields | Add screen tab field
[**getAllScreenTabFields**](ScreenTabFieldsApi.md#getAllScreenTabFields) | **GET** /rest/api/3/screens/{screenId}/tabs/{tabId}/fields | Get all screen tab fields
[**moveScreenTabField**](ScreenTabFieldsApi.md#moveScreenTabField) | **POST** /rest/api/3/screens/{screenId}/tabs/{tabId}/fields/{id}/move | Move screen tab field
[**removeScreenTabField**](ScreenTabFieldsApi.md#removeScreenTabField) | **DELETE** /rest/api/3/screens/{screenId}/tabs/{tabId}/fields/{id} | Remove screen tab field



## addScreenTabField

> ScreenableField addScreenTabField(screenId, tabId, addFieldBean)

Add screen tab field

Adds a field to a screen tab.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.ScreenTabFieldsApi;

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

        ScreenTabFieldsApi apiInstance = new ScreenTabFieldsApi(defaultClient);
        Long screenId = 56L; // Long | The ID of the screen.
        Long tabId = 56L; // Long | The ID of the screen tab.
        AddFieldBean addFieldBean = {"fieldId":"summary"}; // AddFieldBean | 
        try {
            ScreenableField result = apiInstance.addScreenTabField(screenId, tabId, addFieldBean);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScreenTabFieldsApi#addScreenTabField");
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
 **screenId** | **Long**| The ID of the screen. |
 **tabId** | **Long**| The ID of the screen tab. |
 **addFieldBean** | [**AddFieldBean**](AddFieldBean.md)|  |

### Return type

[**ScreenableField**](ScreenableField.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **400** | Returned if the request is invalid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the necessary permission. |  -  |
| **404** | Returned if the screen, screen tab, or field is not found. |  -  |


## getAllScreenTabFields

> List&lt;ScreenableField&gt; getAllScreenTabFields(screenId, tabId, projectKey)

Get all screen tab fields

Returns all fields for a screen tab.  **[Permissions](#permissions) required:**   *  *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).  *  *Administer projects* [project permission](https://confluence.atlassian.com/x/yodKLg) when the project key is specified, providing that the screen is associated with the project through a Screen Scheme and Issue Type Screen Scheme.

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.ScreenTabFieldsApi;

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

        ScreenTabFieldsApi apiInstance = new ScreenTabFieldsApi(defaultClient);
        Long screenId = 56L; // Long | The ID of the screen.
        Long tabId = 56L; // Long | The ID of the screen tab.
        String projectKey = "projectKey_example"; // String | The key of the project.
        try {
            List<ScreenableField> result = apiInstance.getAllScreenTabFields(screenId, tabId, projectKey);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScreenTabFieldsApi#getAllScreenTabFields");
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
 **screenId** | **Long**| The ID of the screen. |
 **tabId** | **Long**| The ID of the screen tab. |
 **projectKey** | **String**| The key of the project. | [optional]

### Return type

[**List&lt;ScreenableField&gt;**](ScreenableField.md)

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
| **404** | Returned if the screen or screen tab is not found. |  -  |


## moveScreenTabField

> Object moveScreenTabField(screenId, tabId, id, moveFieldBean)

Move screen tab field

Moves a screen tab field.  If &#x60;after&#x60; and &#x60;position&#x60; are provided in the request, &#x60;position&#x60; is ignored.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.ScreenTabFieldsApi;

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

        ScreenTabFieldsApi apiInstance = new ScreenTabFieldsApi(defaultClient);
        Long screenId = 56L; // Long | The ID of the screen.
        Long tabId = 56L; // Long | The ID of the screen tab.
        String id = "id_example"; // String | The ID of the field.
        MoveFieldBean moveFieldBean = new MoveFieldBean(); // MoveFieldBean | 
        try {
            Object result = apiInstance.moveScreenTabField(screenId, tabId, id, moveFieldBean);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScreenTabFieldsApi#moveScreenTabField");
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
 **screenId** | **Long**| The ID of the screen. |
 **tabId** | **Long**| The ID of the screen tab. |
 **id** | **String**| The ID of the field. |
 **moveFieldBean** | [**MoveFieldBean**](MoveFieldBean.md)|  |

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
| **403** | Returned if the user does not have the necessary permission. |  -  |
| **404** | Returned if the screen, screen tab, or field is not found or the field can&#39;t be moved to the requested position. |  -  |


## removeScreenTabField

> removeScreenTabField(screenId, tabId, id)

Remove screen tab field

Removes a field from a screen tab.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.ScreenTabFieldsApi;

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

        ScreenTabFieldsApi apiInstance = new ScreenTabFieldsApi(defaultClient);
        Long screenId = 56L; // Long | The ID of the screen.
        Long tabId = 56L; // Long | The ID of the screen tab.
        String id = "id_example"; // String | The ID of the field.
        try {
            apiInstance.removeScreenTabField(screenId, tabId, id);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScreenTabFieldsApi#removeScreenTabField");
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
 **screenId** | **Long**| The ID of the screen. |
 **tabId** | **Long**| The ID of the screen tab. |
 **id** | **String**| The ID of the field. |

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
| **400** | Returned if the request is invalid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **403** | Returned if the user does not have the necessary permission. |  -  |
| **404** | Returned if the screen, screen tab, or field is not found. |  -  |

