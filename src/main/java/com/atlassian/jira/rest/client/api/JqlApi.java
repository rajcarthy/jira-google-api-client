package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.AutoCompleteSuggestions;
import com.atlassian.jira.rest.client.model.ConvertedJQLQueries;
import com.atlassian.jira.rest.client.model.ErrorCollection;
import com.atlassian.jira.rest.client.model.JQLPersonalDataMigrationRequest;
import com.atlassian.jira.rest.client.model.JQLReferenceData;
import com.atlassian.jira.rest.client.model.JqlQueriesToParse;
import com.atlassian.jira.rest.client.model.ParsedJqlQueries;

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
public class JqlApi {
    private ApiClient apiClient;

    public JqlApi() {
        this(new ApiClient());
    }

    public JqlApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Get field reference data
    * Returns reference data for JQL searches. This is a downloadable version of the documentation provided in [Advanced searching - fields reference](https://confluence.atlassian.com/x/gwORLQ) and [Advanced searching - functions reference](https://confluence.atlassian.com/x/hgORLQ), along with a list of JQL-reserved words. Use this information to assist with the programmatic creation of JQL queries or the validation of queries built in a custom query builder.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect.
    * @return JQLReferenceData
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public JQLReferenceData getAutoComplete() throws IOException {
        HttpResponse response = getAutoCompleteForHttpResponse();
        TypeReference<JQLReferenceData> typeRef = new TypeReference<JQLReferenceData>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get field reference data
    * Returns reference data for JQL searches. This is a downloadable version of the documentation provided in [Advanced searching - fields reference](https://confluence.atlassian.com/x/gwORLQ) and [Advanced searching - functions reference](https://confluence.atlassian.com/x/hgORLQ), along with a list of JQL-reserved words. Use this information to assist with the programmatic creation of JQL queries or the validation of queries built in a custom query builder.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return JQLReferenceData
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public JQLReferenceData getAutoComplete(Map<String, Object> params) throws IOException {
        HttpResponse response = getAutoCompleteForHttpResponse(params);
        TypeReference<JQLReferenceData> typeRef = new TypeReference<JQLReferenceData>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getAutoCompleteForHttpResponse() throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/jql/autocompletedata");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getAutoCompleteForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/jql/autocompletedata");

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
    * Get field auto complete suggestions
    * Returns the JQL search auto complete suggestions for a field.  Suggestions can be obtained by providing:   *  &#x60;fieldName&#x60; to get a list of all values for the field.  *  &#x60;fieldName&#x60; and &#x60;fieldValue&#x60; to get a list of values containing the text in &#x60;fieldValue&#x60;.  *  &#x60;fieldName&#x60; and &#x60;predicateName&#x60; to get a list of all predicate values for the field.  *  &#x60;fieldName&#x60;, &#x60;predicateName&#x60;, and &#x60;predicateValue&#x60; to get a list of predicate values containing the text in &#x60;predicateValue&#x60;.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if an invalid combination of parameters is passed.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect.
    * @param fieldName The name of the field.
    * @param fieldValue The partial field item name entered by the user.
    * @param predicateName The name of the [ CHANGED operator predicate](https://confluence.atlassian.com/x/hQORLQ#Advancedsearching-operatorsreference-CHANGEDCHANGED) for which the suggestions are generated. The valid predicate operators are *by*, *from*, and *to*.
    * @param predicateValue The partial predicate item name entered by the user.
    * @return AutoCompleteSuggestions
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public AutoCompleteSuggestions getFieldAutoCompleteForQueryString(String fieldName, String fieldValue, String predicateName, String predicateValue) throws IOException {
        HttpResponse response = getFieldAutoCompleteForQueryStringForHttpResponse(fieldName, fieldValue, predicateName, predicateValue);
        TypeReference<AutoCompleteSuggestions> typeRef = new TypeReference<AutoCompleteSuggestions>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get field auto complete suggestions
    * Returns the JQL search auto complete suggestions for a field.  Suggestions can be obtained by providing:   *  &#x60;fieldName&#x60; to get a list of all values for the field.  *  &#x60;fieldName&#x60; and &#x60;fieldValue&#x60; to get a list of values containing the text in &#x60;fieldValue&#x60;.  *  &#x60;fieldName&#x60; and &#x60;predicateName&#x60; to get a list of all predicate values for the field.  *  &#x60;fieldName&#x60;, &#x60;predicateName&#x60;, and &#x60;predicateValue&#x60; to get a list of predicate values containing the text in &#x60;predicateValue&#x60;.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if an invalid combination of parameters is passed.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return AutoCompleteSuggestions
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public AutoCompleteSuggestions getFieldAutoCompleteForQueryString(Map<String, Object> params) throws IOException {
        HttpResponse response = getFieldAutoCompleteForQueryStringForHttpResponse(params);
        TypeReference<AutoCompleteSuggestions> typeRef = new TypeReference<AutoCompleteSuggestions>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getFieldAutoCompleteForQueryStringForHttpResponse(String fieldName, String fieldValue, String predicateName, String predicateValue) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/jql/autocompletedata/suggestions");
        if (fieldName != null) {
            String key = "fieldName";
            Object value = fieldName;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (fieldValue != null) {
            String key = "fieldValue";
            Object value = fieldValue;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (predicateName != null) {
            String key = "predicateName";
            Object value = predicateName;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (predicateValue != null) {
            String key = "predicateValue";
            Object value = predicateValue;
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

    public HttpResponse getFieldAutoCompleteForQueryStringForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/jql/autocompletedata/suggestions");

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
    * Convert user identifiers to account IDs in JQL queries
    * Converts one or more JQL queries with user identifiers (username or user key) to equivalent JQL queries with account IDs.  You may wish to use this operation if your system stores JQL queries and you want to make them GDPR-compliant. For more information about GDPR-related changes, see the [migration guide](https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/).  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>200</b> - Returned if the request is successful. Note that the JQL queries are returned in the same order that they were passed.
    * <p><b>400</b> - Returned if at least one of the queries cannot be converted. For example, the JQL has invalid operators or invalid keywords, or the users in the query cannot be found.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param jqLPersonalDataMigrationRequest The jqLPersonalDataMigrationRequest parameter
    * @return ConvertedJQLQueries
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ConvertedJQLQueries migrateQueries(JQLPersonalDataMigrationRequest jqLPersonalDataMigrationRequest) throws IOException {
        HttpResponse response = migrateQueriesForHttpResponse(jqLPersonalDataMigrationRequest);
        TypeReference<ConvertedJQLQueries> typeRef = new TypeReference<ConvertedJQLQueries>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Convert user identifiers to account IDs in JQL queries
    * Converts one or more JQL queries with user identifiers (username or user key) to equivalent JQL queries with account IDs.  You may wish to use this operation if your system stores JQL queries and you want to make them GDPR-compliant. For more information about GDPR-related changes, see the [migration guide](https://developer.atlassian.com/cloud/jira/platform/deprecation-notice-user-privacy-api-migration-guide/).  **[Permissions](#permissions) required:** Permission to access Jira.
    * <p><b>200</b> - Returned if the request is successful. Note that the JQL queries are returned in the same order that they were passed.
    * <p><b>400</b> - Returned if at least one of the queries cannot be converted. For example, the JQL has invalid operators or invalid keywords, or the users in the query cannot be found.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param jqLPersonalDataMigrationRequest The jqLPersonalDataMigrationRequest parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return ConvertedJQLQueries
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ConvertedJQLQueries migrateQueries(JQLPersonalDataMigrationRequest jqLPersonalDataMigrationRequest, Map<String, Object> params) throws IOException {
        HttpResponse response = migrateQueriesForHttpResponse(jqLPersonalDataMigrationRequest, params);
        TypeReference<ConvertedJQLQueries> typeRef = new TypeReference<ConvertedJQLQueries>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse migrateQueriesForHttpResponse(JQLPersonalDataMigrationRequest jqLPersonalDataMigrationRequest) throws IOException {
        // verify the required parameter 'jqLPersonalDataMigrationRequest' is set
        if (jqLPersonalDataMigrationRequest == null) {
            throw new IllegalArgumentException("Missing the required parameter 'jqLPersonalDataMigrationRequest' when calling migrateQueries");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/jql/pdcleaner");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(jqLPersonalDataMigrationRequest);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse migrateQueriesForHttpResponse(java.io.InputStream jqLPersonalDataMigrationRequest, String mediaType) throws IOException {
          // verify the required parameter 'jqLPersonalDataMigrationRequest' is set
              if (jqLPersonalDataMigrationRequest == null) {
              throw new IllegalArgumentException("Missing the required parameter 'jqLPersonalDataMigrationRequest' when calling migrateQueries");
              }
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/jql/pdcleaner");

              String localVarUrl = uriBuilder.build().toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = jqLPersonalDataMigrationRequest == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, jqLPersonalDataMigrationRequest);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse migrateQueriesForHttpResponse(JQLPersonalDataMigrationRequest jqLPersonalDataMigrationRequest, Map<String, Object> params) throws IOException {
        // verify the required parameter 'jqLPersonalDataMigrationRequest' is set
        if (jqLPersonalDataMigrationRequest == null) {
            throw new IllegalArgumentException("Missing the required parameter 'jqLPersonalDataMigrationRequest' when calling migrateQueries");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/jql/pdcleaner");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(jqLPersonalDataMigrationRequest);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


  /**
    * Parse JQL query
    * Parses and validates JQL queries.  Validation is performed in context of the current user.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect.
    * @param jqlQueriesToParse The jqlQueriesToParse parameter
    * @param validation How to validate the JQL query and treat the validation results. Validation options include:   *  &#x60;strict&#x60; Returns all errors. If validation fails, the query structure is not returned.  *  &#x60;warn&#x60; Returns all errors. If validation fails but the JQL query is correctly formed, the query structure is returned.  *  &#x60;none&#x60; No validation is performed. If JQL query is correctly formed, the query structure is returned.
    * @return ParsedJqlQueries
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ParsedJqlQueries parseJqlQueries(JqlQueriesToParse jqlQueriesToParse, String validation) throws IOException {
        HttpResponse response = parseJqlQueriesForHttpResponse(jqlQueriesToParse, validation);
        TypeReference<ParsedJqlQueries> typeRef = new TypeReference<ParsedJqlQueries>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Parse JQL query
    * Parses and validates JQL queries.  Validation is performed in context of the current user.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect.
    * @param jqlQueriesToParse The jqlQueriesToParse parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return ParsedJqlQueries
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ParsedJqlQueries parseJqlQueries(JqlQueriesToParse jqlQueriesToParse, Map<String, Object> params) throws IOException {
        HttpResponse response = parseJqlQueriesForHttpResponse(jqlQueriesToParse, params);
        TypeReference<ParsedJqlQueries> typeRef = new TypeReference<ParsedJqlQueries>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse parseJqlQueriesForHttpResponse(JqlQueriesToParse jqlQueriesToParse, String validation) throws IOException {
        // verify the required parameter 'jqlQueriesToParse' is set
        if (jqlQueriesToParse == null) {
            throw new IllegalArgumentException("Missing the required parameter 'jqlQueriesToParse' when calling parseJqlQueries");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/jql/parse");
        if (validation != null) {
            String key = "validation";
            Object value = validation;
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

        HttpContent content = apiClient.new JacksonJsonHttpContent(jqlQueriesToParse);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse parseJqlQueriesForHttpResponse(java.io.InputStream jqlQueriesToParse, String validation, String mediaType) throws IOException {
          // verify the required parameter 'jqlQueriesToParse' is set
              if (jqlQueriesToParse == null) {
              throw new IllegalArgumentException("Missing the required parameter 'jqlQueriesToParse' when calling parseJqlQueries");
              }
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/jql/parse");
              if (validation != null) {
                  String key = "validation";
                  Object value = validation;
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

              HttpContent content = jqlQueriesToParse == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, jqlQueriesToParse);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse parseJqlQueriesForHttpResponse(JqlQueriesToParse jqlQueriesToParse, Map<String, Object> params) throws IOException {
        // verify the required parameter 'jqlQueriesToParse' is set
        if (jqlQueriesToParse == null) {
            throw new IllegalArgumentException("Missing the required parameter 'jqlQueriesToParse' when calling parseJqlQueries");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/jql/parse");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(jqlQueriesToParse);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


}
