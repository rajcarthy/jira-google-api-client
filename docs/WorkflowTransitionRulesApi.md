# WorkflowTransitionRulesApi

All URIs are relative to *https://your-domain.atlassian.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getWorkflowTransitionRuleConfigurations**](WorkflowTransitionRulesApi.md#getWorkflowTransitionRuleConfigurations) | **GET** /rest/api/3/workflow/rule/config | Get workflow transition rule configurations
[**updateWorkflowTransitionRuleConfigurations**](WorkflowTransitionRulesApi.md#updateWorkflowTransitionRuleConfigurations) | **PUT** /rest/api/3/workflow/rule/config | Update workflow transition rule configurations



## getWorkflowTransitionRuleConfigurations

> PageBeanWorkflowTransitionRules getWorkflowTransitionRuleConfigurations(types, startAt, maxResults, keys, expand)

Get workflow transition rule configurations

Returns a [paginated](#pagination) list of workflows with transition rules. The workflows can be filtered to return only those containing workflow transition rules:   *  of one or more transition rule types, such as [workflow post functions](https://developer.atlassian.com/cloud/jira/platform/modules/workflow-post-function/).  *  matching one or more transition rule keys.  Only workflows containing transition rules created by the calling Connect app are returned. However, if a workflow is returned all transition rules that match the filters are returned for that workflow.  Due to server-side optimizations, workflows with an empty list of rules may be returned; these workflows can be ignored.  **[Permissions](#permissions) required:** Only Connect apps can use this operation.

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.WorkflowTransitionRulesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://your-domain.atlassian.com");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        WorkflowTransitionRulesApi apiInstance = new WorkflowTransitionRulesApi(defaultClient);
        Set<String> types = Arrays.asList(); // Set<String> | The types of the transition rules to return.
        Long startAt = 0l; // Long | The index of the first item to return in a page of results (page offset).
        Integer maxResults = 10; // Integer | The maximum number of items to return per page.
        Set<String> keys = Arrays.asList(); // Set<String> | The transition rule class keys, as defined in the Connect app descriptor, of the transition rules to return.
        String expand = "expand_example"; // String | Use [expand](#expansion) to include additional information in the response. This parameter accepts `transition`, which, for each rule, returns information about the transition the rule is assigned to.
        try {
            PageBeanWorkflowTransitionRules result = apiInstance.getWorkflowTransitionRuleConfigurations(types, startAt, maxResults, keys, expand);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling WorkflowTransitionRulesApi#getWorkflowTransitionRuleConfigurations");
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
 **types** | [**Set&lt;String&gt;**](String.md)| The types of the transition rules to return. | [enum: postfunction, condition, validator]
 **startAt** | **Long**| The index of the first item to return in a page of results (page offset). | [optional] [default to 0l]
 **maxResults** | **Integer**| The maximum number of items to return per page. | [optional] [default to 10]
 **keys** | [**Set&lt;String&gt;**](String.md)| The transition rule class keys, as defined in the Connect app descriptor, of the transition rules to return. | [optional]
 **expand** | **String**| Use [expand](#expansion) to include additional information in the response. This parameter accepts &#x60;transition&#x60;, which, for each rule, returns information about the transition the rule is assigned to. | [optional]

### Return type

[**PageBeanWorkflowTransitionRules**](PageBeanWorkflowTransitionRules.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **400** | Returned if the request is invalid. |  -  |
| **403** | Returned if the caller is not a Connect app. |  -  |
| **404** | Returned if the any transition rule type is not supported. |  -  |


## updateWorkflowTransitionRuleConfigurations

> WorkflowTransitionRulesUpdateErrors updateWorkflowTransitionRuleConfigurations(workflowTransitionRulesUpdate)

Update workflow transition rule configurations

Updates configuration of workflow transition rules. The following rule types are supported:   *  [post functions](https://developer.atlassian.com/cloud/jira/platform/modules/workflow-post-function/)  *  [conditions](https://developer.atlassian.com/cloud/jira/platform/modules/workflow-condition/)  *  [validators](https://developer.atlassian.com/cloud/jira/platform/modules/workflow-validator/)  Only rules created by the calling Connect app can be updated.  **[Permissions](#permissions) required:** Only Connect apps can use this operation.

### Example

```java
// Import classes:
import com.atlassian.jira.rest.client.ApiClient;
import com.atlassian.jira.rest.client.ApiException;
import com.atlassian.jira.rest.client.Configuration;
import com.atlassian.jira.rest.client.auth.*;
import com.atlassian.jira.rest.client.models.*;
import com.atlassian.jira.rest.client.api.WorkflowTransitionRulesApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://your-domain.atlassian.com");
        
        // Configure HTTP basic authorization: basicAuth
        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("YOUR USERNAME");
        basicAuth.setPassword("YOUR PASSWORD");

        WorkflowTransitionRulesApi apiInstance = new WorkflowTransitionRulesApi(defaultClient);
        WorkflowTransitionRulesUpdate workflowTransitionRulesUpdate = {"workflows":[{"postFunctions":[{"configuration":{"value":"{ \"color\": \"red\" }"},"id":"b4d6cbdc-59f5-11e9-8647-d663bd873d93"}],"validators":[{"configuration":{"value":"{ \"shape\": \"square\" }"},"id":"11e9-59f5-b4d6cbdc-8647-d663bd873d93"}],"conditions":[{"configuration":{"value":"{ \"size\": \"medium\" }"},"id":"d663bd873d93-59f5-11e9-8647-b4d6cbdc"}],"workflowId":{"draft":false,"name":"My Workflow name"}}]}; // WorkflowTransitionRulesUpdate | 
        try {
            WorkflowTransitionRulesUpdateErrors result = apiInstance.updateWorkflowTransitionRuleConfigurations(workflowTransitionRulesUpdate);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling WorkflowTransitionRulesApi#updateWorkflowTransitionRuleConfigurations");
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
 **workflowTransitionRulesUpdate** | [**WorkflowTransitionRulesUpdate**](WorkflowTransitionRulesUpdate.md)|  |

### Return type

[**WorkflowTransitionRulesUpdateErrors**](WorkflowTransitionRulesUpdateErrors.md)

### Authorization

[basicAuth](../README.md#basicAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Returned if the request is successful. |  -  |
| **400** | Returned if the request is invalid. |  -  |
| **403** | Returned if the caller is not a Connect app. |  -  |

