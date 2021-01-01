

# IssueLink

Details of a link between issues.
## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The ID of the issue link. |  [optional] [readonly]
**self** | **URI** | The URL of the issue link. |  [optional] [readonly]
**type** | [**IssueLinkType**](IssueLinkType.md) | The type of link between the issues. | 
**inwardIssue** | [**LinkedIssue**](LinkedIssue.md) | The issue the link joins to. | 
**outwardIssue** | [**LinkedIssue**](LinkedIssue.md) | The issue the link originates from. | 



