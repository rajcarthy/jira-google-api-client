package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.IssueMatches;
import com.atlassian.jira.rest.client.model.IssuePickerSuggestions;
import com.atlassian.jira.rest.client.model.IssuesAndJQLQueries;
import com.atlassian.jira.rest.client.model.SearchRequestBean;
import com.atlassian.jira.rest.client.model.SearchResults;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.api.client.http.EmptyContent;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.InputStreamContent;
import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.json.Json;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-12-31T17:44:39.790417-08:00[America/Los_Angeles]")
public class IssueSearchApi {
    private ApiClient apiClient;

    public IssueSearchApi() {
        this(new ApiClient());
    }

    public IssueSearchApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Get issue picker suggestions
    * Returns lists of issues matching a query string. Use this resource to provide auto-completion suggestions when the user is looking for an issue using a word or string.  This operation returns two lists:   *  &#x60;History Search&#x60; which includes issues from the user&#39;s history of created, edited, or viewed issues that contain the string in the &#x60;query&#x60; parameter.  *  &#x60;Current Search&#x60; which includes issues that match the JQL expression in &#x60;currentJQL&#x60; and contain the string in the &#x60;query&#x60; parameter.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param query A string to match against text fields in the issue such as title, description, or comments.
    * @param currentJQL A JQL query defining a list of issues to search for the query term. Note that &#x60;username&#x60; and &#x60;userkey&#x60; cannot be used as search terms for this parameter, due to privacy reasons. Use &#x60;accountId&#x60; instead.
    * @param currentIssueKey The key of an issue to exclude from search results. For example, the issue the user is viewing when they perform this query.
    * @param currentProjectId The ID of a project that suggested issues must belong to.
    * @param showSubTasks Indicate whether to include subtasks in the suggestions list.
    * @param showSubTaskParent When &#x60;currentIssueKey&#x60; is a subtask, whether to include the parent issue in the suggestions if it matches the query.
    * @return IssuePickerSuggestions
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public IssuePickerSuggestions getIssuePickerResource(String query, String currentJQL, String currentIssueKey, String currentProjectId, Boolean showSubTasks, Boolean showSubTaskParent) throws IOException {
        HttpResponse response = getIssuePickerResourceForHttpResponse(query, currentJQL, currentIssueKey, currentProjectId, showSubTasks, showSubTaskParent);
        TypeReference<IssuePickerSuggestions> typeRef = new TypeReference<IssuePickerSuggestions>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get issue picker suggestions
    * Returns lists of issues matching a query string. Use this resource to provide auto-completion suggestions when the user is looking for an issue using a word or string.  This operation returns two lists:   *  &#x60;History Search&#x60; which includes issues from the user&#39;s history of created, edited, or viewed issues that contain the string in the &#x60;query&#x60; parameter.  *  &#x60;Current Search&#x60; which includes issues that match the JQL expression in &#x60;currentJQL&#x60; and contain the string in the &#x60;query&#x60; parameter.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return IssuePickerSuggestions
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public IssuePickerSuggestions getIssuePickerResource(Map<String, Object> params) throws IOException {
        HttpResponse response = getIssuePickerResourceForHttpResponse(params);
        TypeReference<IssuePickerSuggestions> typeRef = new TypeReference<IssuePickerSuggestions>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getIssuePickerResourceForHttpResponse(String query, String currentJQL, String currentIssueKey, String currentProjectId, Boolean showSubTasks, Boolean showSubTaskParent) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/picker");
        if (query != null) {
            String key = "query";
            Object value = query;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (currentJQL != null) {
            String key = "currentJQL";
            Object value = currentJQL;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (currentIssueKey != null) {
            String key = "currentIssueKey";
            Object value = currentIssueKey;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (currentProjectId != null) {
            String key = "currentProjectId";
            Object value = currentProjectId;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (showSubTasks != null) {
            String key = "showSubTasks";
            Object value = showSubTasks;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (showSubTaskParent != null) {
            String key = "showSubTaskParent";
            Object value = showSubTaskParent;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getIssuePickerResourceForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/issue/picker");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);

        for (Map.Entry<String, Object> entry: allParams.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (key != null && value != null) {
                if (value instanceof Collection) {
                    uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
                } else if (value instanceof Object[]) {
                    uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
                } else {
                    uriBuilder = uriBuilder.queryParam(key, value);
                }
            }
        }

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }


  /**
    * Check issues against JQL
    * Checks whether one or more issues would be returned by one or more JQL queries.  **[Permissions](#permissions) required:** None, however, issues are only matched against JQL queries where the user has:   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if &#x60;jqls&#x60; exceeds the maximum number of JQL queries or &#x60;issueIds&#x60; exceeds the maximum number of issue IDs.
    * @param issuesAndJQLQueries The issuesAndJQLQueries parameter
    * @return IssueMatches
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public IssueMatches matchIssues(IssuesAndJQLQueries issuesAndJQLQueries) throws IOException {
        HttpResponse response = matchIssuesForHttpResponse(issuesAndJQLQueries);
        TypeReference<IssueMatches> typeRef = new TypeReference<IssueMatches>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Check issues against JQL
    * Checks whether one or more issues would be returned by one or more JQL queries.  **[Permissions](#permissions) required:** None, however, issues are only matched against JQL queries where the user has:   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project that the issue is in.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if &#x60;jqls&#x60; exceeds the maximum number of JQL queries or &#x60;issueIds&#x60; exceeds the maximum number of issue IDs.
    * @param issuesAndJQLQueries The issuesAndJQLQueries parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return IssueMatches
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public IssueMatches matchIssues(IssuesAndJQLQueries issuesAndJQLQueries, Map<String, Object> params) throws IOException {
        HttpResponse response = matchIssuesForHttpResponse(issuesAndJQLQueries, params);
        TypeReference<IssueMatches> typeRef = new TypeReference<IssueMatches>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse matchIssuesForHttpResponse(IssuesAndJQLQueries issuesAndJQLQueries) throws IOException {
        // verify the required parameter 'issuesAndJQLQueries' is set
        if (issuesAndJQLQueries == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issuesAndJQLQueries' when calling matchIssues");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/jql/match");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(issuesAndJQLQueries);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse matchIssuesForHttpResponse(java.io.InputStream issuesAndJQLQueries, String mediaType) throws IOException {
          // verify the required parameter 'issuesAndJQLQueries' is set
              if (issuesAndJQLQueries == null) {
              throw new IllegalArgumentException("Missing the required parameter 'issuesAndJQLQueries' when calling matchIssues");
              }
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/jql/match");

              String localVarUrl = uriBuilder.build().toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = issuesAndJQLQueries == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, issuesAndJQLQueries);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse matchIssuesForHttpResponse(IssuesAndJQLQueries issuesAndJQLQueries, Map<String, Object> params) throws IOException {
        // verify the required parameter 'issuesAndJQLQueries' is set
        if (issuesAndJQLQueries == null) {
            throw new IllegalArgumentException("Missing the required parameter 'issuesAndJQLQueries' when calling matchIssues");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/jql/match");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);

        for (Map.Entry<String, Object> entry: allParams.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (key != null && value != null) {
                if (value instanceof Collection) {
                    uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
                } else if (value instanceof Object[]) {
                    uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
                } else {
                    uriBuilder = uriBuilder.queryParam(key, value);
                }
            }
        }

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(issuesAndJQLQueries);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


  /**
    * Search for issues using JQL (GET)
    * Searches for issues using [JQL](https://confluence.atlassian.com/x/egORLQ).  If the JQL query expression is too large to be encoded as a query parameter, use the [POST](#api-rest-api-3-search-post) version of this resource.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** Issues are included in the response where the user has:   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project containing the issue.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the JQL query is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param jql The [JQL](https://confluence.atlassian.com/x/egORLQ) that defines the search. Note:   *  If no JQL expression is provided, all issues are returned.  *  &#x60;username&#x60; and &#x60;userkey&#x60; cannot be used as search terms due to privacy reasons. Use &#x60;accountId&#x60; instead.  *  If a user has hidden their email address in their user profile, partial matches of the email address will not find the user. An exact match is required.
    * @param startAt The index of the first item to return in a page of results (page offset).
    * @param maxResults The maximum number of items to return per page. To manage page size, Jira may return fewer items per page where a large number of fields are requested. The greatest number of items returned per page is achieved when requesting &#x60;id&#x60; or &#x60;key&#x60; only.
    * @param validateQuery Determines how to validate the JQL query and treat the validation results. Supported values are:   *  &#x60;strict&#x60; Returns a 400 response code if any errors are found, along with a list of all errors (and warnings).  *  &#x60;warn&#x60; Returns all errors as warnings.  *  &#x60;none&#x60; No validation is performed.  *  &#x60;true&#x60; *Deprecated* A legacy synonym for &#x60;strict&#x60;.  *  &#x60;false&#x60; *Deprecated* A legacy synonym for &#x60;warn&#x60;.  Note: If the JQL is not correctly formed a 400 response code is returned, regardless of the &#x60;validateQuery&#x60; value.
    * @param fields A list of fields to return for each issue, use it to retrieve a subset of fields. This parameter accepts a comma-separated list. Expand options include:   *  &#x60;*all&#x60; Returns all fields.  *  &#x60;*navigable&#x60; Returns navigable fields.  *  Any issue field, prefixed with a minus to exclude.  Examples:   *  &#x60;summary,comment&#x60; Returns only the summary and comments fields.  *  &#x60;-description&#x60; Returns all navigable (default) fields except description.  *  &#x60;*all,-comment&#x60; Returns all fields except comments.  This parameter may be specified multiple times. For example, &#x60;fields&#x3D;field1,field2&amp;fields&#x3D;field3&#x60;.  Note: All navigable fields are returned by default. This differs from [GET issue](#api-rest-api-3-issue-issueIdOrKey-get) where the default is all fields.
    * @param expand Use [expand](#expansion) to include additional information about issues in the response. This parameter accepts a comma-separated list. Expand options include:   *  &#x60;renderedFields&#x60; Returns field values rendered in HTML format.  *  &#x60;names&#x60; Returns the display name of each field.  *  &#x60;schema&#x60; Returns the schema describing a field type.  *  &#x60;transitions&#x60; Returns all possible transitions for the issue.  *  &#x60;operations&#x60; Returns all possible operations for the issue.  *  &#x60;editmeta&#x60; Returns information about how each field can be edited.  *  &#x60;changelog&#x60; Returns a list of recent updates to an issue, sorted by date, starting from the most recent.  *  &#x60;versionedRepresentations&#x60; Instead of &#x60;fields&#x60;, returns &#x60;versionedRepresentations&#x60; a JSON array containing each version of a field&#39;s value, with the highest numbered item representing the most recent version.
    * @param properties A list of issue property keys for issue properties to include in the results. This parameter accepts a comma-separated list. Multiple properties can also be provided using an ampersand separated list. For example, &#x60;properties&#x3D;prop1,prop2&amp;properties&#x3D;prop3&#x60;. A maximum of 5 issue property keys can be specified.
    * @param fieldsByKeys Reference fields by their key (rather than ID).
    * @return SearchResults
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public SearchResults searchForIssuesUsingJql(String jql, Integer startAt, Integer maxResults, String validateQuery, List<String> fields, String expand, List<String> properties, Boolean fieldsByKeys) throws IOException {
        HttpResponse response = searchForIssuesUsingJqlForHttpResponse(jql, startAt, maxResults, validateQuery, fields, expand, properties, fieldsByKeys);
        TypeReference<SearchResults> typeRef = new TypeReference<SearchResults>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Search for issues using JQL (GET)
    * Searches for issues using [JQL](https://confluence.atlassian.com/x/egORLQ).  If the JQL query expression is too large to be encoded as a query parameter, use the [POST](#api-rest-api-3-search-post) version of this resource.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** Issues are included in the response where the user has:   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project containing the issue.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the JQL query is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return SearchResults
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public SearchResults searchForIssuesUsingJql(Map<String, Object> params) throws IOException {
        HttpResponse response = searchForIssuesUsingJqlForHttpResponse(params);
        TypeReference<SearchResults> typeRef = new TypeReference<SearchResults>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse searchForIssuesUsingJqlForHttpResponse(String jql, Integer startAt, Integer maxResults, String validateQuery, List<String> fields, String expand, List<String> properties, Boolean fieldsByKeys) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/search");
        if (jql != null) {
            String key = "jql";
            Object value = jql;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (startAt != null) {
            String key = "startAt";
            Object value = startAt;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (maxResults != null) {
            String key = "maxResults";
            Object value = maxResults;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (validateQuery != null) {
            String key = "validateQuery";
            Object value = validateQuery;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (fields != null) {
            String key = "fields";
            Object value = fields;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (expand != null) {
            String key = "expand";
            Object value = expand;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (properties != null) {
            String key = "properties";
            Object value = properties;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (fieldsByKeys != null) {
            String key = "fieldsByKeys";
            Object value = fieldsByKeys;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse searchForIssuesUsingJqlForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/search");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);

        for (Map.Entry<String, Object> entry: allParams.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (key != null && value != null) {
                if (value instanceof Collection) {
                    uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
                } else if (value instanceof Object[]) {
                    uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
                } else {
                    uriBuilder = uriBuilder.queryParam(key, value);
                }
            }
        }

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }


  /**
    * Search for issues using JQL (POST)
    * Searches for issues using [JQL](https://confluence.atlassian.com/x/egORLQ).  There is a [GET](#api-rest-api-3-search-get) version of this resource that can be used for smaller JQL query expressions.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** Issues are included in the response where the user has:   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project containing the issue.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the JQL query is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param searchRequestBean A JSON object containing the search request.
    * @return SearchResults
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public SearchResults searchForIssuesUsingJqlPost(SearchRequestBean searchRequestBean) throws IOException {
        HttpResponse response = searchForIssuesUsingJqlPostForHttpResponse(searchRequestBean);
        TypeReference<SearchResults> typeRef = new TypeReference<SearchResults>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Search for issues using JQL (POST)
    * Searches for issues using [JQL](https://confluence.atlassian.com/x/egORLQ).  There is a [GET](#api-rest-api-3-search-get) version of this resource that can be used for smaller JQL query expressions.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** Issues are included in the response where the user has:   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project containing the issue.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the JQL query is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param searchRequestBean A JSON object containing the search request.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return SearchResults
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public SearchResults searchForIssuesUsingJqlPost(SearchRequestBean searchRequestBean, Map<String, Object> params) throws IOException {
        HttpResponse response = searchForIssuesUsingJqlPostForHttpResponse(searchRequestBean, params);
        TypeReference<SearchResults> typeRef = new TypeReference<SearchResults>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse searchForIssuesUsingJqlPostForHttpResponse(SearchRequestBean searchRequestBean) throws IOException {
        // verify the required parameter 'searchRequestBean' is set
        if (searchRequestBean == null) {
            throw new IllegalArgumentException("Missing the required parameter 'searchRequestBean' when calling searchForIssuesUsingJqlPost");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/search");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(searchRequestBean);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse searchForIssuesUsingJqlPostForHttpResponse(java.io.InputStream searchRequestBean, String mediaType) throws IOException {
          // verify the required parameter 'searchRequestBean' is set
              if (searchRequestBean == null) {
              throw new IllegalArgumentException("Missing the required parameter 'searchRequestBean' when calling searchForIssuesUsingJqlPost");
              }
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/search");

              String localVarUrl = uriBuilder.build().toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = searchRequestBean == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, searchRequestBean);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse searchForIssuesUsingJqlPostForHttpResponse(SearchRequestBean searchRequestBean, Map<String, Object> params) throws IOException {
        // verify the required parameter 'searchRequestBean' is set
        if (searchRequestBean == null) {
            throw new IllegalArgumentException("Missing the required parameter 'searchRequestBean' when calling searchForIssuesUsingJqlPost");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/search");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);

        for (Map.Entry<String, Object> entry: allParams.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (key != null && value != null) {
                if (value instanceof Collection) {
                    uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
                } else if (value instanceof Object[]) {
                    uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
                } else {
                    uriBuilder = uriBuilder.queryParam(key, value);
                }
            }
        }

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(searchRequestBean);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


}
