# IssueWorklogsApi

All URIs are relative to *https://your-domain.atlassian.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addWorklog**](IssueWorklogsApi.md#addWorklog) | **POST** /rest/api/3/issue/{issueIdOrKey}/worklog | Add worklog
[**deleteWorklog**](IssueWorklogsApi.md#deleteWorklog) | **DELETE** /rest/api/3/issue/{issueIdOrKey}/worklog/{id} | Delete worklog
[**getIdsOfWorklogsDeletedSince**](IssueWorklogsApi.md#getIdsOfWorklogsDeletedSince) | **GET** /rest/api/3/worklog/deleted | Get IDs of deleted worklogs
[**getIdsOfWorklogsModifiedSince**](IssueWorklogsApi.md#getIdsOfWorklogsModifiedSince) | **GET** /rest/api/3/worklog/updated | Get IDs of updated worklogs
[**getIssueWorklog**](IssueWorklogsApi.md#getIssueWorklog) | **GET** /rest/api/3/issue/{issueIdOrKey}/worklog | Get issue worklogs
[**getWorklog**](IssueWorklogsApi.md#getWorklog) | **GET** /rest/api/3/issue/{issueIdOrKey}/worklog/{id} | Get worklog
[**getWorklogsForIds**](IssueWorklogsApi.md#getWorklogsForIds) | **POST** /rest/api/3/worklog/list | Get worklogs
[**updateWorklog**](IssueWorklogsApi.md#updateWorklog) | **PUT** /rest/api/3/issue/{issueIdOrKey}/worklog/{id} | Update worklog



## addWorklog

> Worklog addWorklog(issueIdOrKey, requestBody, notifyUsers, adjustEstimate, newEstimate, reduceBy, expand, overrideEditableFlag)

Add worklog

Adds a worklog to an issue.  Time tracking must be enabled in Jira, otherwise this operation returns an error. For more information, see [Configuring time tracking](https://confluence.atlassian.com/x/qoXKM).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* and *Work on issues* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.IssueWorklogsApi;

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

        IssueWorklogsApi apiInstance = new IssueWorklogsApi(defaultClient);
        String issueIdOrKey = "issueIdOrKey_example"; // String | The ID or key the issue.
        Map<String, Object> requestBody = {"timeSpentSeconds":12000,"visibility":{"type":"group","value":"jira-developers"},"comment":{"type":"doc","version":1,"content":[{"type":"paragraph","content":[{"text":"I did some work here.","type":"text"}]}]},"started":"2020-12-29T01:29:17.351+0000"}; // Map<String, Object> | 
        Boolean notifyUsers = true; // Boolean | Whether users watching the issue are notified by email.
        String adjustEstimate = "auto"; // String | Defines how to update the issue's time estimate, the options are:   *  `new` Sets the estimate to a specific value, defined in `newEstimate`.  *  `leave` Leaves the estimate unchanged.  *  `manual` Reduces the estimate by amount specified in `reduceBy`.  *  `auto` Reduces the estimate by the value of `timeSpent` in the worklog.
        String newEstimate = "newEstimate_example"; // String | The value to set as the issue's remaining time estimate, as days (\\#d), hours (\\#h), or minutes (\\#m or \\#). For example, *2d*. Required when `adjustEstimate` is `new`.
        String reduceBy = "reduceBy_example"; // String | The amount to reduce the issue's remaining estimate by, as days (\\#d), hours (\\#h), or minutes (\\#m). For example, *2d*. Required when `adjustEstimate` is `manual`.
        String expand = "\"\""; // String | Use [expand](#expansion) to include additional information about work logs in the response. This parameter accepts `properties`, which returns worklog properties.
        Boolean overrideEditableFlag = false; // Boolean | Whether the worklog entry should be added to the issue even if the issue is not editable, because jira.issue.editable set to false or missing. For example, the issue is closed. Only connect app users with admin scope permission can use this flag.
        try {
            Worklog result = apiInstance.addWorklog(issueIdOrKey, requestBody, notifyUsers, adjustEstimate, newEstimate, reduceBy, expand, overrideEditableFlag);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueWorklogsApi#addWorklog");
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
 **issueIdOrKey** | **String**| The ID or key the issue. |
 **requestBody** | [**Map&lt;String, Object&gt;**](Object.md)|  |
 **notifyUsers** | **Boolean**| Whether users watching the issue are notified by email. | [optional] [default to true]
 **adjustEstimate** | **String**| Defines how to update the issue&#39;s time estimate, the options are:   *  &#x60;new&#x60; Sets the estimate to a specific value, defined in &#x60;newEstimate&#x60;.  *  &#x60;leave&#x60; Leaves the estimate unchanged.  *  &#x60;manual&#x60; Reduces the estimate by amount specified in &#x60;reduceBy&#x60;.  *  &#x60;auto&#x60; Reduces the estimate by the value of &#x60;timeSpent&#x60; in the worklog. | [optional] [default to auto] [enum: new, leave, manual, auto]
 **newEstimate** | **String**| The value to set as the issue&#39;s remaining time estimate, as days (\\#d), hours (\\#h), or minutes (\\#m or \\#). For example, *2d*. Required when &#x60;adjustEstimate&#x60; is &#x60;new&#x60;. | [optional]
 **reduceBy** | **String**| The amount to reduce the issue&#39;s remaining estimate by, as days (\\#d), hours (\\#h), or minutes (\\#m). For example, *2d*. Required when &#x60;adjustEstimate&#x60; is &#x60;manual&#x60;. | [optional]
 **expand** | **String**| Use [expand](#expansion) to include additional information about work logs in the response. This parameter accepts &#x60;properties&#x60;, which returns worklog properties. | [optional] [default to &quot;&quot;]
 **overrideEditableFlag** | **Boolean**| Whether the worklog entry should be added to the issue even if the issue is not editable, because jira.issue.editable set to false or missing. For example, the issue is closed. Only connect app users with admin scope permission can use this flag. | [optional] [default to false]

### Return type

[**Worklog**](Worklog.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Returned if the request is successful. |  -  |
| **400** | Returned if:   *  &#x60;adjustEstimate&#x60; is set to &#x60;new&#x60; but &#x60;newEstimate&#x60; is not provided or is invalid.  *  &#x60;adjustEstimate&#x60; is set to &#x60;manual&#x60; but &#x60;reduceBy&#x60; is not provided or is invalid.  *  the user does not have permission to add the worklog.  *  the request JSON is malformed. |  -  |
| **401** | Returned if the authentication credentials are incorrect. |  -  |
| **404** | Returned if the issue is not found or the user does not have permission to view it. |  -  |


## deleteWorklog

> deleteWorklog(issueIdOrKey, id, notifyUsers, adjustEstimate, newEstimate, increaseBy, overrideEditableFlag)

Delete worklog

Deletes a worklog from an issue.  Time tracking must be enabled in Jira, otherwise this operation returns an error. For more information, see [Configuring time tracking](https://confluence.atlassian.com/x/qoXKM).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  *Delete all worklogs*[ project permission](https://confluence.atlassian.com/x/yodKLg) to delete any worklog or *Delete own worklogs* to delete worklogs created by the user,  *  If the worklog has visibility restrictions, belongs to the group or has the role visibility is restricted to.

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.IssueWorklogsApi;

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

        IssueWorklogsApi apiInstance = new IssueWorklogsApi(defaultClient);
        String issueIdOrKey = "issueIdOrKey_example"; // String | The ID or key of the issue.
        String id = "id_example"; // String | The ID of the worklog.
        Boolean notifyUsers = true; // Boolean | Whether users watching the issue are notified by email.
        String adjustEstimate = "auto"; // String | Defines how to update the issue's time estimate, the options are:   *  `new` Sets the estimate to a specific value, defined in `newEstimate`.  *  `leave` Leaves the estimate unchanged.  *  `manual` Increases the estimate by amount specified in `increaseBy`.  *  `auto` Reduces the estimate by the value of `timeSpent` in the worklog.
        String newEstimate = "newEstimate_example"; // String | The value to set as the issue's remaining time estimate, as days (\\#d), hours (\\#h), or minutes (\\#m or \\#). For example, *2d*. Required when `adjustEstimate` is `new`.
        String increaseBy = "increaseBy_example"; // String | The amount to increase the issue's remaining estimate by, as days (\\#d), hours (\\#h), or minutes (\\#m or \\#). For example, *2d*. Required when `adjustEstimate` is `manual`.
        Boolean overrideEditableFlag = false; // Boolean | Whether the work log entry should be added to the issue even if the issue is not editable, because jira.issue.editable set to false or missing. For example, the issue is closed. Only connect app users with admin permissions can use this flag.
        try {
            apiInstance.deleteWorklog(issueIdOrKey, id, notifyUsers, adjustEstimate, newEstimate, increaseBy, overrideEditableFlag);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueWorklogsApi#deleteWorklog");
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
 **id** | **String**| The ID of the worklog. |
 **notifyUsers** | **Boolean**| Whether users watching the issue are notified by email. | [optional] [default to true]
 **adjustEstimate** | **String**| Defines how to update the issue&#39;s time estimate, the options are:   *  &#x60;new&#x60; Sets the estimate to a specific value, defined in &#x60;newEstimate&#x60;.  *  &#x60;leave&#x60; Leaves the estimate unchanged.  *  &#x60;manual&#x60; Increases the estimate by amount specified in &#x60;increaseBy&#x60;.  *  &#x60;auto&#x60; Reduces the estimate by the value of &#x60;timeSpent&#x60; in the worklog. | [optional] [default to auto] [enum: new, leave, manual, auto]
 **newEstimate** | **String**| The value to set as the issue&#39;s remaining time estimate, as days (\\#d), hours (\\#h), or minutes (\\#m or \\#). For example, *2d*. Required when &#x60;adjustEstimate&#x60; is &#x60;new&#x60;. | [optional]
 **increaseBy** | **String**| The amount to increase the issue&#39;s remaining estimate by, as days (\\#d), hours (\\#h), or minutes (\\#m or \\#). For example, *2d*. Required when &#x60;adjustEstimate&#x60; is &#x60;manual&#x60;. | [optional]
 **overrideEditableFlag** | **Boolean**| Whether the work log entry should be added to the issue even if the issue is not editable, because jira.issue.editable set to false or missing. For example, the issue is closed. Only connect app users with admin permissions can use this flag. | [optional] [default to false]

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
| **400** | Returned if:   *  &#x60;adjustEstimate&#x60; is set to &#x60;new&#x60; but &#x60;newEstimate&#x60; is not provided or is invalid.  *  &#x60;adjustEstimate&#x60; is set to &#x60;manual&#x60; but &#x60;reduceBy&#x60; is not provided or is invalid.  *  the user does not have permission to delete the worklog. |  -  |
| **401** | Returned if the authentication credentials are incorrect. |  -  |
| **404** | Returned if:   *  the issue is not found or user does not have permission to view the issue.  *  the worklog is not found or the user does not have permission to view it.  *  time tracking is disabled. |  -  |


## getIdsOfWorklogsDeletedSince

> ChangedWorklogs getIdsOfWorklogsDeletedSince(since)

Get IDs of deleted worklogs

Returns a list of IDs and delete timestamps for worklogs deleted after a date and time.  This resource is paginated, with a limit of 1000 worklogs per page. Each page lists worklogs from oldest to youngest. If the number of items in the date range exceeds 1000, &#x60;until&#x60; indicates the timestamp of the youngest item on the page. Also, &#x60;nextPage&#x60; provides the URL for the next page of worklogs. The &#x60;lastPage&#x60; parameter is set to true on the last page of worklogs.  This resource does not return worklogs deleted during the minute preceding the request.  **[Permissions](#permissions) required:** Permission to access Jira.

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.IssueWorklogsApi;

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

        IssueWorklogsApi apiInstance = new IssueWorklogsApi(defaultClient);
        Long since = 0l; // Long | The date and time, as a UNIX timestamp in milliseconds, after which deleted worklogs are returned.
        try {
            ChangedWorklogs result = apiInstance.getIdsOfWorklogsDeletedSince(since);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueWorklogsApi#getIdsOfWorklogsDeletedSince");
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
 **since** | **Long**| The date and time, as a UNIX timestamp in milliseconds, after which deleted worklogs are returned. | [optional] [default to 0l]

### Return type

[**ChangedWorklogs**](ChangedWorklogs.md)

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


## getIdsOfWorklogsModifiedSince

> ChangedWorklogs getIdsOfWorklogsModifiedSince(since, expand)

Get IDs of updated worklogs

Returns a list of IDs and update timestamps for worklogs updated after a date and time.  This resource is paginated, with a limit of 1000 worklogs per page. Each page lists worklogs from oldest to youngest. If the number of items in the date range exceeds 1000, &#x60;until&#x60; indicates the timestamp of the youngest item on the page. Also, &#x60;nextPage&#x60; provides the URL for the next page of worklogs. The &#x60;lastPage&#x60; parameter is set to true on the last page of worklogs.  This resource does not return worklogs updated during the minute preceding the request.  **[Permissions](#permissions) required:** Permission to access Jira, however, worklogs are only returned where either of the following is true:   *  the worklog is set as *Viewable by All Users*.  *  the user is a member of a project role or group with permission to view the worklog.

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.IssueWorklogsApi;

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

        IssueWorklogsApi apiInstance = new IssueWorklogsApi(defaultClient);
        Long since = 0l; // Long | The date and time, as a UNIX timestamp in milliseconds, after which updated worklogs are returned.
        String expand = "\"\""; // String | Use [expand](#expansion) to include additional information about worklogs in the response. This parameter accepts `properties` that returns the properties of each worklog.
        try {
            ChangedWorklogs result = apiInstance.getIdsOfWorklogsModifiedSince(since, expand);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueWorklogsApi#getIdsOfWorklogsModifiedSince");
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
 **since** | **Long**| The date and time, as a UNIX timestamp in milliseconds, after which updated worklogs are returned. | [optional] [default to 0l]
 **expand** | **String**| Use [expand](#expansion) to include additional information about worklogs in the response. This parameter accepts &#x60;properties&#x60; that returns the properties of each worklog. | [optional] [default to &quot;&quot;]

### Return type

[**ChangedWorklogs**](ChangedWorklogs.md)

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


## getIssueWorklog

> PageOfWorklogs getIssueWorklog(issueIdOrKey, startAt, maxResults, startedAfter, expand)

Get issue worklogs

Returns worklogs for an issue, starting from the oldest worklog or from the worklog started on or after a date and time.  Time tracking must be enabled in Jira, otherwise this operation returns an error. For more information, see [Configuring time tracking](https://confluence.atlassian.com/x/qoXKM).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** Workloads are only returned where the user has:   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  If the worklog has visibility restrictions, belongs to the group or has the role visibility is restricted to.

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.IssueWorklogsApi;

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

        IssueWorklogsApi apiInstance = new IssueWorklogsApi(defaultClient);
        String issueIdOrKey = "issueIdOrKey_example"; // String | The ID or key of the issue.
        Long startAt = 0l; // Long | The index of the first item to return in a page of results (page offset).
        Integer maxResults = 1048576; // Integer | The maximum number of items to return per page.
        Long startedAfter = 56L; // Long | The worklog start date and time, as a UNIX timestamp in milliseconds, after which worklogs are returned.
        String expand = "\"\""; // String | Use [expand](#expansion) to include additional information about worklogs in the response. This parameter accepts`properties`, which returns worklog properties.
        try {
            PageOfWorklogs result = apiInstance.getIssueWorklog(issueIdOrKey, startAt, maxResults, startedAfter, expand);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueWorklogsApi#getIssueWorklog");
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
 **startAt** | **Long**| The index of the first item to return in a page of results (page offset). | [optional] [default to 0l]
 **maxResults** | **Integer**| The maximum number of items to return per page. | [optional] [default to 1048576]
 **startedAfter** | **Long**| The worklog start date and time, as a UNIX timestamp in milliseconds, after which worklogs are returned. | [optional]
 **expand** | **String**| Use [expand](#expansion) to include additional information about worklogs in the response. This parameter accepts&#x60;properties&#x60;, which returns worklog properties. | [optional] [default to &quot;&quot;]

### Return type

[**PageOfWorklogs**](PageOfWorklogs.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **404** | Returned if:   *  the issue is not found or the user does not have permission to view the issue.  *  &#x60;startAt&#x60; or &#x60;maxResults&#x60; has non-numeric values.  *  time tracking is disabled. |  -  |


## getWorklog

> Worklog getWorklog(issueIdOrKey, id, expand)

Get worklog

Returns a worklog.  Time tracking must be enabled in Jira, otherwise this operation returns an error. For more information, see [Configuring time tracking](https://confluence.atlassian.com/x/qoXKM).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  If the worklog has visibility restrictions, belongs to the group or has the role visibility is restricted to.

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.IssueWorklogsApi;

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

        IssueWorklogsApi apiInstance = new IssueWorklogsApi(defaultClient);
        String issueIdOrKey = "issueIdOrKey_example"; // String | The ID or key of the issue.
        String id = "id_example"; // String | The ID of the worklog.
        String expand = "\"\""; // String | Use [expand](#expansion) to include additional information about work logs in the response. This parameter accepts  `properties`, which returns worklog properties.
        try {
            Worklog result = apiInstance.getWorklog(issueIdOrKey, id, expand);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueWorklogsApi#getWorklog");
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
 **id** | **String**| The ID of the worklog. |
 **expand** | **String**| Use [expand](#expansion) to include additional information about work logs in the response. This parameter accepts  &#x60;properties&#x60;, which returns worklog properties. | [optional] [default to &quot;&quot;]

### Return type

[**Worklog**](Worklog.md)

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
| **404** | Returned if:   *  the issue is not found or the user does not have permission to view it.  *  the worklog is not found or the user does not have permission to view it.  *  time tracking is disabled.  . |  -  |


## getWorklogsForIds

> List&lt;Worklog&gt; getWorklogsForIds(worklogIdsRequestBean, expand)

Get worklogs

Returns worklog details for a list of worklog IDs.  The returned list of worklogs is limited to 1000 items.  **[Permissions](#permissions) required:** Permission to access Jira, however, worklogs are only returned where either of the following is true:   *  the worklog is set as *Viewable by All Users*.  *  the user is a member of a project role or group with permission to view the worklog.

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.IssueWorklogsApi;

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

        IssueWorklogsApi apiInstance = new IssueWorklogsApi(defaultClient);
        WorklogIdsRequestBean worklogIdsRequestBean = {"ids":[1,2,5,10]}; // WorklogIdsRequestBean | A JSON object containing a list of worklog IDs.
        String expand = "\"\""; // String | Use [expand](#expansion) to include additional information about worklogs in the response. This parameter accepts `properties` that returns the properties of each worklog.
        try {
            List<Worklog> result = apiInstance.getWorklogsForIds(worklogIdsRequestBean, expand);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueWorklogsApi#getWorklogsForIds");
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
 **worklogIdsRequestBean** | [**WorklogIdsRequestBean**](WorklogIdsRequestBean.md)| A JSON object containing a list of worklog IDs. |
 **expand** | **String**| Use [expand](#expansion) to include additional information about worklogs in the response. This parameter accepts &#x60;properties&#x60; that returns the properties of each worklog. | [optional] [default to &quot;&quot;]

### Return type

[**List&lt;Worklog&gt;**](Worklog.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **400** | Returned if the request contains more than 1000 worklog IDs or is empty. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |


## updateWorklog

> Worklog updateWorklog(issueIdOrKey, id, requestBody, notifyUsers, adjustEstimate, newEstimate, expand, overrideEditableFlag)

Update worklog

Updates a worklog.  Time tracking must be enabled in Jira, otherwise this operation returns an error. For more information, see [Configuring time tracking](https://confluence.atlassian.com/x/qoXKM).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  *Edit all worklogs*[ project permission](https://confluence.atlassian.com/x/yodKLg) to update any worklog or *Edit own worklogs* to update worklogs created by the user.  *  If the worklog has visibility restrictions, belongs to the group or has the role visibility is restricted to.

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.IssueWorklogsApi;

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

        IssueWorklogsApi apiInstance = new IssueWorklogsApi(defaultClient);
        String issueIdOrKey = "issueIdOrKey_example"; // String | The ID or key the issue.
        String id = "id_example"; // String | The ID of the worklog.
        Map<String, Object> requestBody = {"timeSpentSeconds":12000,"visibility":{"type":"group","value":"jira-developers"},"comment":{"type":"doc","version":1,"content":[{"type":"paragraph","content":[{"text":"I did some work here.","type":"text"}]}]},"started":"2020-12-29T01:29:17.351+0000"}; // Map<String, Object> | 
        Boolean notifyUsers = true; // Boolean | Whether users watching the issue are notified by email.
        String adjustEstimate = "auto"; // String | Defines how to update the issue's time estimate, the options are:   *  `new` Sets the estimate to a specific value, defined in `newEstimate`.  *  `leave` Leaves the estimate unchanged.  *  `auto` Updates the estimate by the difference between the original and updated value of `timeSpent` or `timeSpentSeconds`.
        String newEstimate = "newEstimate_example"; // String | The value to set as the issue's remaining time estimate, as days (\\#d), hours (\\#h), or minutes (\\#m or \\#). For example, *2d*. Required when `adjustEstimate` is `new`.
        String expand = "\"\""; // String | Use [expand](#expansion) to include additional information about worklogs in the response. This parameter accepts `properties`, which returns worklog properties.
        Boolean overrideEditableFlag = false; // Boolean | Whether the worklog should be added to the issue even if the issue is not editable. For example, because the issue is closed. Only connect app users with admin permissions can use this flag.
        try {
            Worklog result = apiInstance.updateWorklog(issueIdOrKey, id, requestBody, notifyUsers, adjustEstimate, newEstimate, expand, overrideEditableFlag);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueWorklogsApi#updateWorklog");
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
 **issueIdOrKey** | **String**| The ID or key the issue. |
 **id** | **String**| The ID of the worklog. |
 **requestBody** | [**Map&lt;String, Object&gt;**](Object.md)|  |
 **notifyUsers** | **Boolean**| Whether users watching the issue are notified by email. | [optional] [default to true]
 **adjustEstimate** | **String**| Defines how to update the issue&#39;s time estimate, the options are:   *  &#x60;new&#x60; Sets the estimate to a specific value, defined in &#x60;newEstimate&#x60;.  *  &#x60;leave&#x60; Leaves the estimate unchanged.  *  &#x60;auto&#x60; Updates the estimate by the difference between the original and updated value of &#x60;timeSpent&#x60; or &#x60;timeSpentSeconds&#x60;. | [optional] [default to auto] [enum: new, leave, manual, auto]
 **newEstimate** | **String**| The value to set as the issue&#39;s remaining time estimate, as days (\\#d), hours (\\#h), or minutes (\\#m or \\#). For example, *2d*. Required when &#x60;adjustEstimate&#x60; is &#x60;new&#x60;. | [optional]
 **expand** | **String**| Use [expand](#expansion) to include additional information about worklogs in the response. This parameter accepts &#x60;properties&#x60;, which returns worklog properties. | [optional] [default to &quot;&quot;]
 **overrideEditableFlag** | **Boolean**| Whether the worklog should be added to the issue even if the issue is not editable. For example, because the issue is closed. Only connect app users with admin permissions can use this flag. | [optional] [default to false]

### Return type

[**Worklog**](Worklog.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful |  -  |
| **400** | Returned if:   *  &#x60;adjustEstimate&#x60; is set to &#x60;new&#x60; but &#x60;newEstimate&#x60; is not provided or is invalid.  *  the user does not have permission to update the worklog.  *  the request JSON is malformed. |  -  |
| **401** | Returned if the authentication credentials are incorrect. |  -  |
| **404** | Returned if:   *  the issue is not found or user does not have permission to view the issue.  *  the worklog is not found or the user does not have permission to view it.  *  time tracking is disabled. |  -  |

