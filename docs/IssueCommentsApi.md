# IssueCommentsApi

All URIs are relative to *https://your-domain.atlassian.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addComment**](IssueCommentsApi.md#addComment) | **POST** /rest/api/3/issue/{issueIdOrKey}/comment | Add comment
[**deleteComment**](IssueCommentsApi.md#deleteComment) | **DELETE** /rest/api/3/issue/{issueIdOrKey}/comment/{id} | Delete comment
[**getComment**](IssueCommentsApi.md#getComment) | **GET** /rest/api/3/issue/{issueIdOrKey}/comment/{id} | Get comment
[**getComments**](IssueCommentsApi.md#getComments) | **GET** /rest/api/3/issue/{issueIdOrKey}/comment | Get comments
[**getCommentsByIds**](IssueCommentsApi.md#getCommentsByIds) | **POST** /rest/api/3/comment/list | Get comments by IDs
[**updateComment**](IssueCommentsApi.md#updateComment) | **PUT** /rest/api/3/issue/{issueIdOrKey}/comment/{id} | Update comment



## addComment

> Comment addComment(issueIdOrKey, requestBody, expand)

Add comment

Adds a comment to an issue.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* and *Add comments* [ project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue containing the comment is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.IssueCommentsApi;

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

        IssueCommentsApi apiInstance = new IssueCommentsApi(defaultClient);
        String issueIdOrKey = "issueIdOrKey_example"; // String | The ID or key of the issue.
        Map<String, Object> requestBody = {"visibility":{"type":"role","value":"Administrators"},"body":{"type":"doc","version":1,"content":[{"type":"paragraph","content":[{"text":"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eget venenatis elit. Duis eu justo eget augue iaculis fermentum. Sed semper quam laoreet nisi egestas at posuere augue semper.","type":"text"}]}]}}; // Map<String, Object> | 
        String expand = "expand_example"; // String | Use [expand](#expansion) to include additional information about comments in the response. This parameter accepts `renderedBody`, which returns the comment body rendered in HTML.
        try {
            Comment result = apiInstance.addComment(issueIdOrKey, requestBody, expand);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueCommentsApi#addComment");
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
 **requestBody** | [**Map&lt;String, Object&gt;**](Object.md)|  |
 **expand** | **String**| Use [expand](#expansion) to include additional information about comments in the response. This parameter accepts &#x60;renderedBody&#x60;, which returns the comment body rendered in HTML. | [optional]

### Return type

[**Comment**](Comment.md)

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
| **401** | Returned if the authentication credentials are incorrect. |  -  |
| **404** | Returned if the issue is not found or the user does not have permission to view it. |  -  |


## deleteComment

> deleteComment(issueIdOrKey, id)

Delete comment

Deletes a comment.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue containing the comment is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  *Delete all comments*[ project permission](https://confluence.atlassian.com/x/yodKLg) to delete any comment or *Delete own comments* to delete comment created by the user,  *  If the comment has visibility restrictions, the user belongs to the group or has the role visibility is restricted to.

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.IssueCommentsApi;

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

        IssueCommentsApi apiInstance = new IssueCommentsApi(defaultClient);
        String issueIdOrKey = "issueIdOrKey_example"; // String | The ID or key of the issue.
        String id = "id_example"; // String | The ID of the comment.
        try {
            apiInstance.deleteComment(issueIdOrKey, id);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueCommentsApi#deleteComment");
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
 **id** | **String**| The ID of the comment. |

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
| **400** | Returned if the user does not have permission to delete the comment. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **404** | Returned if the issue or comment is not found or the user does not have permission to view the issue or comment. |  -  |
| **405** | Returned if an anonymous call is made to the operation. |  -  |


## getComment

> Comment getComment(issueIdOrKey, id, expand)

Get comment

Returns a comment.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project containing the comment.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  If the comment has visibility restrictions, the user belongs to the group or has the role visibility is restricted to.

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.IssueCommentsApi;

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

        IssueCommentsApi apiInstance = new IssueCommentsApi(defaultClient);
        String issueIdOrKey = "issueIdOrKey_example"; // String | The ID or key of the issue.
        String id = "id_example"; // String | The ID of the comment.
        String expand = "expand_example"; // String | Use [expand](#expansion) to include additional information about comments in the response. This parameter accepts `renderedBody`, which returns the comment body rendered in HTML.
        try {
            Comment result = apiInstance.getComment(issueIdOrKey, id, expand);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueCommentsApi#getComment");
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
 **id** | **String**| The ID of the comment. |
 **expand** | **String**| Use [expand](#expansion) to include additional information about comments in the response. This parameter accepts &#x60;renderedBody&#x60;, which returns the comment body rendered in HTML. | [optional]

### Return type

[**Comment**](Comment.md)

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
| **404** | Returned if the issue or comment is not found or the user does not have permission to view the issue or comment. |  -  |


## getComments

> PageOfComments getComments(issueIdOrKey, startAt, maxResults, orderBy, expand)

Get comments

Returns all comments for an issue.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** Comments are included in the response where the user has:   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project containing the comment.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  If the comment has visibility restrictions, belongs to the group or has the role visibility is role visibility is restricted to.

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.IssueCommentsApi;

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

        IssueCommentsApi apiInstance = new IssueCommentsApi(defaultClient);
        String issueIdOrKey = "issueIdOrKey_example"; // String | The ID or key of the issue.
        Long startAt = 0l; // Long | The index of the first item to return in a page of results (page offset).
        Integer maxResults = 50; // Integer | The maximum number of items to return per page.
        String orderBy = "orderBy_example"; // String | [Order](#ordering) the results by a field. Accepts *created* to sort comments by their created date.
        String expand = "expand_example"; // String | Use [expand](#expansion) to include additional information about comments in the response. This parameter accepts `renderedBody`, which returns the comment body rendered in HTML.
        try {
            PageOfComments result = apiInstance.getComments(issueIdOrKey, startAt, maxResults, orderBy, expand);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueCommentsApi#getComments");
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
 **maxResults** | **Integer**| The maximum number of items to return per page. | [optional] [default to 50]
 **orderBy** | **String**| [Order](#ordering) the results by a field. Accepts *created* to sort comments by their created date. | [optional] [enum: created, -created, +created]
 **expand** | **String**| Use [expand](#expansion) to include additional information about comments in the response. This parameter accepts &#x60;renderedBody&#x60;, which returns the comment body rendered in HTML. | [optional]

### Return type

[**PageOfComments**](PageOfComments.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **400** | Returned if &#x60;orderBy&#x60; is set to a value other than *created*. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **404** | Returned if the issue is not found or the user does not have permission to view it. |  -  |


## getCommentsByIds

> PageBeanComment getCommentsByIds(issueCommentListRequestBean, expand)

Get comments by IDs

Returns a [paginated](#pagination) list of just the comments for a list of comments specified by comment IDs.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** Comments are returned where the user:   *  has *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project containing the comment.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  If the comment has visibility restrictions, belongs to the group or has the role visibility is restricted to.

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.IssueCommentsApi;

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

        IssueCommentsApi apiInstance = new IssueCommentsApi(defaultClient);
        IssueCommentListRequestBean issueCommentListRequestBean = {"ids":[1,2,5,10]}; // IssueCommentListRequestBean | The list of comment IDs.
        String expand = "expand_example"; // String | Use [expand](#expansion) to include additional information about comments in the response. This parameter accepts a comma-separated list. Expand options include:   *  `renderedBody` Returns the comment body rendered in HTML.  *  `properties` Returns the comment's properties.
        try {
            PageBeanComment result = apiInstance.getCommentsByIds(issueCommentListRequestBean, expand);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueCommentsApi#getCommentsByIds");
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
 **issueCommentListRequestBean** | [**IssueCommentListRequestBean**](IssueCommentListRequestBean.md)| The list of comment IDs. |
 **expand** | **String**| Use [expand](#expansion) to include additional information about comments in the response. This parameter accepts a comma-separated list. Expand options include:   *  &#x60;renderedBody&#x60; Returns the comment body rendered in HTML.  *  &#x60;properties&#x60; Returns the comment&#39;s properties. | [optional]

### Return type

[**PageBeanComment**](PageBeanComment.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **400** | Returned if the request contains more than 1000 IDs or is empty. |  -  |


## updateComment

> Comment updateComment(issueIdOrKey, id, requestBody, expand)

Update comment

Updates a comment.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue containing the comment is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  *Edit all comments*[ project permission](https://confluence.atlassian.com/x/yodKLg) to update any comment or *Edit own comments* to update comment created by the user.  *  If the comment has visibility restrictions, the user belongs to the group or has the role visibility is restricted to.

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.IssueCommentsApi;

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

        IssueCommentsApi apiInstance = new IssueCommentsApi(defaultClient);
        String issueIdOrKey = "issueIdOrKey_example"; // String | The ID or key of the issue.
        String id = "id_example"; // String | The ID of the comment.
        Map<String, Object> requestBody = {"visibility":{"type":"role","value":"Administrators"},"body":{"type":"doc","version":1,"content":[{"type":"paragraph","content":[{"text":"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eget venenatis elit. Duis eu justo eget augue iaculis fermentum. Sed semper quam laoreet nisi egestas at posuere augue semper.","type":"text"}]}]}}; // Map<String, Object> | 
        String expand = "expand_example"; // String | Use [expand](#expansion) to include additional information about comments in the response. This parameter accepts `renderedBody`, which returns the comment body rendered in HTML.
        try {
            Comment result = apiInstance.updateComment(issueIdOrKey, id, requestBody, expand);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueCommentsApi#updateComment");
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
 **id** | **String**| The ID of the comment. |
 **requestBody** | [**Map&lt;String, Object&gt;**](Object.md)|  |
 **expand** | **String**| Use [expand](#expansion) to include additional information about comments in the response. This parameter accepts &#x60;renderedBody&#x60;, which returns the comment body rendered in HTML. | [optional]

### Return type

[**Comment**](Comment.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **400** | Returned if the user does not have permission to edit the comment or the request is invalid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing. |  -  |
| **404** | Returned if the issue or comment is not found or the user does not have permission to view the issue or comment. |  -  |

