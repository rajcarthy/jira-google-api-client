# ProjectRoleActorsApi

All URIs are relative to *https://your-domain.atlassian.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addActorUsers**](ProjectRoleActorsApi.md#addActorUsers) | **POST** /rest/api/3/project/{projectIdOrKey}/role/{id} | Add actors to project role
[**addProjectRoleActorsToRole**](ProjectRoleActorsApi.md#addProjectRoleActorsToRole) | **POST** /rest/api/3/role/{id}/actors | Add default actors to project role
[**deleteActor**](ProjectRoleActorsApi.md#deleteActor) | **DELETE** /rest/api/3/project/{projectIdOrKey}/role/{id} | Delete actors from project role
[**deleteProjectRoleActorsFromRole**](ProjectRoleActorsApi.md#deleteProjectRoleActorsFromRole) | **DELETE** /rest/api/3/role/{id}/actors | Delete default actors from project role
[**getProjectRoleActorsForRole**](ProjectRoleActorsApi.md#getProjectRoleActorsForRole) | **GET** /rest/api/3/role/{id}/actors | Get default actors for project role
[**setActors**](ProjectRoleActorsApi.md#setActors) | **PUT** /rest/api/3/project/{projectIdOrKey}/role/{id} | Set actors for project role



## addActorUsers

> ProjectRole addActorUsers(projectIdOrKey, id, actorsMap)

Add actors to project role

Adds actors to a project role for the project.  To replace all actors for the project, use [Set actors for project role](#api-rest-api-3-project-projectIdOrKey-role-id-put).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Administer Projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project or *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.ProjectRoleActorsApi;

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

        ProjectRoleActorsApi apiInstance = new ProjectRoleActorsApi(defaultClient);
        String projectIdOrKey = "projectIdOrKey_example"; // String | The project ID or project key (case sensitive).
        Long id = 56L; // Long | The ID of the project role. Use [Get all project roles](#api-rest-api-3-role-get) to get a list of project role IDs.
        ActorsMap actorsMap = {"group":["jira-developers"]}; // ActorsMap | The groups or users to associate with the project role for this project. Provide the user account ID or group name.
        try {
            ProjectRole result = apiInstance.addActorUsers(projectIdOrKey, id, actorsMap);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectRoleActorsApi#addActorUsers");
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
 **id** | **Long**| The ID of the project role. Use [Get all project roles](#api-rest-api-3-role-get) to get a list of project role IDs. |
 **actorsMap** | [**ActorsMap**](ActorsMap.md)| The groups or users to associate with the project role for this project. Provide the user account ID or group name. |

### Return type

[**ProjectRole**](ProjectRole.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. The complete list of actors for the project is returned.  For example, the cURL request above adds a group, *jira-developers*. For the response below to be returned as a result of that request, the user *Mia Krystof* would have previously been added as a &#x60;user&#x60; actor for this project. |  -  |
| **400** | Returned if the request is not valid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing or if the calling user lacks administrative permissions for the project. |  -  |
| **404** | Returned if:   *  the project is not found.  *  the user or group is not found.  *  the group or user is not active. |  -  |


## addProjectRoleActorsToRole

> ProjectRole addProjectRoleActorsToRole(id, actorInputBean)

Add default actors to project role

Adds [default actors](#api-rest-api-3-resolution-get) to a role. You may add groups or users, but you cannot add groups and users in the same request.  Changing a project role&#39;s default actors does not affect project role members for projects already created.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.ProjectRoleActorsApi;

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

        ProjectRoleActorsApi apiInstance = new ProjectRoleActorsApi(defaultClient);
        Long id = 56L; // Long | The ID of the project role. Use [Get all project roles](#api-rest-api-3-role-get) to get a list of project role IDs.
        ActorInputBean actorInputBean = {"user":["admin"]}; // ActorInputBean | 
        try {
            ProjectRole result = apiInstance.addProjectRoleActorsToRole(id, actorInputBean);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectRoleActorsApi#addProjectRoleActorsToRole");
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
 **id** | **Long**| The ID of the project role. Use [Get all project roles](#api-rest-api-3-role-get) to get a list of project role IDs. |
 **actorInputBean** | [**ActorInputBean**](ActorInputBean.md)|  |

### Return type

[**ProjectRole**](ProjectRole.md)

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
| **403** | Returned if the user does not have administrative permissions. |  -  |
| **404** | Returned if the project role is not found. |  -  |


## deleteActor

> deleteActor(projectIdOrKey, id, user, group)

Delete actors from project role

Deletes actors from a project role for the project.  To remove default actors from the project role, use [Delete default actors from project role](#api-rest-api-3-role-id-actors-delete).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Administer Projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project or *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.ProjectRoleActorsApi;

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

        ProjectRoleActorsApi apiInstance = new ProjectRoleActorsApi(defaultClient);
        String projectIdOrKey = "projectIdOrKey_example"; // String | The project ID or project key (case sensitive).
        Long id = 56L; // Long | The ID of the project role. Use [Get all project roles](#api-rest-api-3-role-get) to get a list of project role IDs.
        String user = "5b10ac8d82e05b22cc7d4ef5"; // String | The user account ID of the user to remove from the project role.
        String group = "group_example"; // String | The name of the group to remove from the project role.
        try {
            apiInstance.deleteActor(projectIdOrKey, id, user, group);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectRoleActorsApi#deleteActor");
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
 **id** | **Long**| The ID of the project role. Use [Get all project roles](#api-rest-api-3-role-get) to get a list of project role IDs. |
 **user** | **String**| The user account ID of the user to remove from the project role. | [optional]
 **group** | **String**| The name of the group to remove from the project role. | [optional]

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
| **400** | Returned if the request is not valid. |  -  |
| **404** | Returned if:   *  the project or project role is not found.  *  the calling user does not have administrative permission. |  -  |


## deleteProjectRoleActorsFromRole

> ProjectRole deleteProjectRoleActorsFromRole(id, user, group)

Delete default actors from project role

Deletes the [default actors](#api-rest-api-3-resolution-get) from a project role. You may delete a group or user, but you cannot delete a group and a user in the same request.  Changing a project role&#39;s default actors does not affect project role members for projects already created.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.ProjectRoleActorsApi;

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

        ProjectRoleActorsApi apiInstance = new ProjectRoleActorsApi(defaultClient);
        Long id = 56L; // Long | The ID of the project role. Use [Get all project roles](#api-rest-api-3-role-get) to get a list of project role IDs.
        String user = "5b10ac8d82e05b22cc7d4ef5"; // String | The user account ID of the user to remove as a default actor.
        String group = "group_example"; // String | The group name of the group to be removed as a default actor.
        try {
            ProjectRole result = apiInstance.deleteProjectRoleActorsFromRole(id, user, group);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectRoleActorsApi#deleteProjectRoleActorsFromRole");
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
 **id** | **Long**| The ID of the project role. Use [Get all project roles](#api-rest-api-3-role-get) to get a list of project role IDs. |
 **user** | **String**| The user account ID of the user to remove as a default actor. | [optional]
 **group** | **String**| The group name of the group to be removed as a default actor. | [optional]

### Return type

[**ProjectRole**](ProjectRole.md)

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
| **403** | Returned if the user does not have administrative permissions. |  -  |
| **404** | Returned if the project role is not found. |  -  |


## getProjectRoleActorsForRole

> ProjectRole getProjectRoleActorsForRole(id)

Get default actors for project role

Returns the [default actors](#api-rest-api-3-resolution-get) for the project role.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.ProjectRoleActorsApi;

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

        ProjectRoleActorsApi apiInstance = new ProjectRoleActorsApi(defaultClient);
        Long id = 56L; // Long | The ID of the project role. Use [Get all project roles](#api-rest-api-3-role-get) to get a list of project role IDs.
        try {
            ProjectRole result = apiInstance.getProjectRoleActorsForRole(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectRoleActorsApi#getProjectRoleActorsForRole");
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
 **id** | **Long**| The ID of the project role. Use [Get all project roles](#api-rest-api-3-role-get) to get a list of project role IDs. |

### Return type

[**ProjectRole**](ProjectRole.md)

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
| **403** | Returned if the user does not have administrative permissions. |  -  |
| **404** | Returned if the project role is not found. |  -  |


## setActors

> ProjectRole setActors(projectIdOrKey, id, projectRoleActorsUpdateBean)

Set actors for project role

Sets the actors for a project role for a project, replacing all existing actors.  To add actors to the project without overwriting the existing list, use [Add actors to project role](#api-rest-api-3-project-projectIdOrKey-role-id-post).  **[Permissions](#permissions) required:** *Administer Projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project or *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.ProjectRoleActorsApi;

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

        ProjectRoleActorsApi apiInstance = new ProjectRoleActorsApi(defaultClient);
        String projectIdOrKey = "projectIdOrKey_example"; // String | The project ID or project key (case sensitive).
        Long id = 56L; // Long | The ID of the project role. Use [Get all project roles](#api-rest-api-3-role-get) to get a list of project role IDs.
        ProjectRoleActorsUpdateBean projectRoleActorsUpdateBean = {"categorisedActors":{"atlassian-user-role-actor":["12345678-9abc-def1-2345-6789abcdef12"],"atlassian-group-role-actor":["jira-developers"]}}; // ProjectRoleActorsUpdateBean | The groups or users to associate with the project role for this project. Provide the user account ID or group name.
        try {
            ProjectRole result = apiInstance.setActors(projectIdOrKey, id, projectRoleActorsUpdateBean);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectRoleActorsApi#setActors");
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
 **id** | **Long**| The ID of the project role. Use [Get all project roles](#api-rest-api-3-role-get) to get a list of project role IDs. |
 **projectRoleActorsUpdateBean** | [**ProjectRoleActorsUpdateBean**](ProjectRoleActorsUpdateBean.md)| The groups or users to associate with the project role for this project. Provide the user account ID or group name. |

### Return type

[**ProjectRole**](ProjectRole.md)

### Authorization

[OAuth2](../README.md#OAuth2), [basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. The complete list of actors for the project is returned. |  -  |
| **400** | Returned if the request is not valid. |  -  |
| **401** | Returned if the authentication credentials are incorrect or missing or if the calling user lacks administrative permissions for the project. |  -  |
| **404** | Returned if:   *  the project is not found.  *  a user or group is not found.  *  a group or user is not active. |  -  |

