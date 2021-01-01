package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.ErrorCollection;
import com.atlassian.jira.rest.client.model.JiraExpressionEvalRequestBean;
import com.atlassian.jira.rest.client.model.JiraExpressionForAnalysis;
import com.atlassian.jira.rest.client.model.JiraExpressionResult;
import com.atlassian.jira.rest.client.model.JiraExpressionsAnalysis;

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
public class JiraExpressionsApi {
    private ApiClient apiClient;

    public JiraExpressionsApi() {
        this(new ApiClient());
    }

    public JiraExpressionsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Analyse Jira expression
    * Analyses and validates Jira expressions.  As an experimental feature, this operation can also attempt to type-check the expressions.  Learn more about Jira expressions in the [documentation](https://developer.atlassian.com/cloud/jira/platform/jira-expressions/).  **[Permissions](#permissions) required**: None.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - 400 response
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - 404 response
    * @param jiraExpressionForAnalysis The Jira expressions to analyse.
    * @param check The check to perform:   *  &#x60;syntax&#x60; Each expression&#39;s syntax is checked to ensure the expression can be parsed. Also, syntactic limits are validated. For example, the expression&#39;s length.  *  &#x60;type&#x60; EXPERIMENTAL. Each expression is type checked and the final type of the expression inferred. Any type errors that would result in the expression failure at runtime are reported. For example, accessing properties that don&#39;t exist or passing the wrong number of arguments to functions. Also performs the syntax check.  *  &#x60;complexity&#x60; EXPERIMENTAL. Determines the formulae for how many [expensive operations](https://developer.atlassian.com/cloud/jira/platform/jira-expressions/#expensive-operations) each expression may execute.
    * @return JiraExpressionsAnalysis
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public JiraExpressionsAnalysis analyseExpression(JiraExpressionForAnalysis jiraExpressionForAnalysis, String check) throws IOException {
        HttpResponse response = analyseExpressionForHttpResponse(jiraExpressionForAnalysis, check);
        TypeReference<JiraExpressionsAnalysis> typeRef = new TypeReference<JiraExpressionsAnalysis>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Analyse Jira expression
    * Analyses and validates Jira expressions.  As an experimental feature, this operation can also attempt to type-check the expressions.  Learn more about Jira expressions in the [documentation](https://developer.atlassian.com/cloud/jira/platform/jira-expressions/).  **[Permissions](#permissions) required**: None.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - 400 response
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - 404 response
    * @param jiraExpressionForAnalysis The Jira expressions to analyse.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return JiraExpressionsAnalysis
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public JiraExpressionsAnalysis analyseExpression(JiraExpressionForAnalysis jiraExpressionForAnalysis, Map<String, Object> params) throws IOException {
        HttpResponse response = analyseExpressionForHttpResponse(jiraExpressionForAnalysis, params);
        TypeReference<JiraExpressionsAnalysis> typeRef = new TypeReference<JiraExpressionsAnalysis>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse analyseExpressionForHttpResponse(JiraExpressionForAnalysis jiraExpressionForAnalysis, String check) throws IOException {
        // verify the required parameter 'jiraExpressionForAnalysis' is set
        if (jiraExpressionForAnalysis == null) {
            throw new IllegalArgumentException("Missing the required parameter 'jiraExpressionForAnalysis' when calling analyseExpression");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/expression/analyse");
        if (check != null) {
            String key = "check";
            Object value = check;
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

        HttpContent content = apiClient.new JacksonJsonHttpContent(jiraExpressionForAnalysis);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse analyseExpressionForHttpResponse(java.io.InputStream jiraExpressionForAnalysis, String check, String mediaType) throws IOException {
          // verify the required parameter 'jiraExpressionForAnalysis' is set
              if (jiraExpressionForAnalysis == null) {
              throw new IllegalArgumentException("Missing the required parameter 'jiraExpressionForAnalysis' when calling analyseExpression");
              }
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/expression/analyse");
              if (check != null) {
                  String key = "check";
                  Object value = check;
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

              HttpContent content = jiraExpressionForAnalysis == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, jiraExpressionForAnalysis);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse analyseExpressionForHttpResponse(JiraExpressionForAnalysis jiraExpressionForAnalysis, Map<String, Object> params) throws IOException {
        // verify the required parameter 'jiraExpressionForAnalysis' is set
        if (jiraExpressionForAnalysis == null) {
            throw new IllegalArgumentException("Missing the required parameter 'jiraExpressionForAnalysis' when calling analyseExpression");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/expression/analyse");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(jiraExpressionForAnalysis);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


  /**
    * Evaluate Jira expression
    * Evaluates a Jira expression and returns its value.  This resource can be used to test Jira expressions that you plan to use elsewhere, or to fetch data in a flexible way. Consult the [Jira expressions documentation](https://developer.atlassian.com/cloud/jira/platform/jira-expressions/) for more details.  #### Context variables ####  The following context variables are available to Jira expressions evaluated by this resource. Their presence depends on various factors; usually you need to manually request them in the context object sent in the payload, but some of them are added automatically under certain conditions.   *  &#x60;user&#x60; ([User](https://developer.atlassian.com/cloud/jira/platform/jira-expressions-type-reference#user)): The current user. Always available and equal to &#x60;null&#x60; if the request is anonymous.  *  &#x60;app&#x60; ([App](https://developer.atlassian.com/cloud/jira/platform/jira-expressions-type-reference#app)): The Connect app that made the request. Available only for authenticated requests made by Connect Apps (read more here: [Authentication for Connect apps](https://developer.atlassian.com/cloud/jira/platform/security-for-connect-apps/)).  *  &#x60;issue&#x60; ([Issue](https://developer.atlassian.com/cloud/jira/platform/jira-expressions-type-reference#issue)): The current issue. Available only when the issue is provided in the request context object.  *  &#x60;issues&#x60; ([List](https://developer.atlassian.com/cloud/jira/platform/jira-expressions-type-reference#list) of [Issues](https://developer.atlassian.com/cloud/jira/platform/jira-expressions-type-reference#issue)): A collection of issues matching a JQL query. Available only when JQL is provided in the request context object.  *  &#x60;project&#x60; ([Project](https://developer.atlassian.com/cloud/jira/platform/jira-expressions-type-reference#project)): The current project. Available only when the project is provided in the request context object.  *  &#x60;sprint&#x60; ([Sprint](https://developer.atlassian.com/cloud/jira/platform/jira-expressions-type-reference#sprint)): The current sprint. Available only when the sprint is provided in the request context object.  *  &#x60;board&#x60; ([Board](https://developer.atlassian.com/cloud/jira/platform/jira-expressions-type-reference#board)): The current board. Available only when the board is provided in the request context object.  *  &#x60;serviceDesk&#x60; ([ServiceDesk](https://developer.atlassian.com/cloud/jira/platform/jira-expressions-type-reference#servicedesk)): The current service desk. Available only when the service desk is provided in the request context object.  *  &#x60;customerRequest&#x60; ([CustomerRequest](https://developer.atlassian.com/cloud/jira/platform/jira-expressions-type-reference#customerrequest)): The current customer request. Available only when the customer request is provided in the request context object.  This operation can be accessed anonymously.  **[Permissions](#permissions) required**: None. However, an expression may return different results for different users depending on their permissions. For example, different users may see different comments on the same issue.   Permission to access Jira Software is required to access Jira Software context variables (&#x60;board&#x60; and &#x60;sprint&#x60;) or fields (for example, &#x60;issue.sprint&#x60;).
    * <p><b>200</b> - Returned if the evaluation results in a value. The result is a JSON primitive value, list, or object.
    * <p><b>400</b> - Returned if:   *  the request is invalid, that is:           *  invalid data is provided, such as a request including issue ID and key.      *  the expression is invalid and can not be parsed.  *  evaluation fails at runtime. This may happen for various reasons. For example, accessing a property on a null object (such as the expression &#x60;issue.id&#x60; where &#x60;issue&#x60; is &#x60;null&#x60;). In this case an error message is provided.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if any object provided in the request context is not found or the user does not have permission to view it.
    * @param jiraExpressionEvalRequestBean The Jira expression and the evaluation context.
    * @param expand Use [expand](#expansion) to include additional information in the response. This parameter accepts &#x60;meta.complexity&#x60; that returns information about the expression complexity. For example, the number of expensive operations used by the expression and how close the expression is to reaching the [complexity limit](https://developer.atlassian.com/cloud/jira/platform/jira-expressions/#restrictions). Useful when designing and debugging your expressions.
    * @return JiraExpressionResult
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public JiraExpressionResult evaluateJiraExpression(JiraExpressionEvalRequestBean jiraExpressionEvalRequestBean, String expand) throws IOException {
        HttpResponse response = evaluateJiraExpressionForHttpResponse(jiraExpressionEvalRequestBean, expand);
        TypeReference<JiraExpressionResult> typeRef = new TypeReference<JiraExpressionResult>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Evaluate Jira expression
    * Evaluates a Jira expression and returns its value.  This resource can be used to test Jira expressions that you plan to use elsewhere, or to fetch data in a flexible way. Consult the [Jira expressions documentation](https://developer.atlassian.com/cloud/jira/platform/jira-expressions/) for more details.  #### Context variables ####  The following context variables are available to Jira expressions evaluated by this resource. Their presence depends on various factors; usually you need to manually request them in the context object sent in the payload, but some of them are added automatically under certain conditions.   *  &#x60;user&#x60; ([User](https://developer.atlassian.com/cloud/jira/platform/jira-expressions-type-reference#user)): The current user. Always available and equal to &#x60;null&#x60; if the request is anonymous.  *  &#x60;app&#x60; ([App](https://developer.atlassian.com/cloud/jira/platform/jira-expressions-type-reference#app)): The Connect app that made the request. Available only for authenticated requests made by Connect Apps (read more here: [Authentication for Connect apps](https://developer.atlassian.com/cloud/jira/platform/security-for-connect-apps/)).  *  &#x60;issue&#x60; ([Issue](https://developer.atlassian.com/cloud/jira/platform/jira-expressions-type-reference#issue)): The current issue. Available only when the issue is provided in the request context object.  *  &#x60;issues&#x60; ([List](https://developer.atlassian.com/cloud/jira/platform/jira-expressions-type-reference#list) of [Issues](https://developer.atlassian.com/cloud/jira/platform/jira-expressions-type-reference#issue)): A collection of issues matching a JQL query. Available only when JQL is provided in the request context object.  *  &#x60;project&#x60; ([Project](https://developer.atlassian.com/cloud/jira/platform/jira-expressions-type-reference#project)): The current project. Available only when the project is provided in the request context object.  *  &#x60;sprint&#x60; ([Sprint](https://developer.atlassian.com/cloud/jira/platform/jira-expressions-type-reference#sprint)): The current sprint. Available only when the sprint is provided in the request context object.  *  &#x60;board&#x60; ([Board](https://developer.atlassian.com/cloud/jira/platform/jira-expressions-type-reference#board)): The current board. Available only when the board is provided in the request context object.  *  &#x60;serviceDesk&#x60; ([ServiceDesk](https://developer.atlassian.com/cloud/jira/platform/jira-expressions-type-reference#servicedesk)): The current service desk. Available only when the service desk is provided in the request context object.  *  &#x60;customerRequest&#x60; ([CustomerRequest](https://developer.atlassian.com/cloud/jira/platform/jira-expressions-type-reference#customerrequest)): The current customer request. Available only when the customer request is provided in the request context object.  This operation can be accessed anonymously.  **[Permissions](#permissions) required**: None. However, an expression may return different results for different users depending on their permissions. For example, different users may see different comments on the same issue.   Permission to access Jira Software is required to access Jira Software context variables (&#x60;board&#x60; and &#x60;sprint&#x60;) or fields (for example, &#x60;issue.sprint&#x60;).
    * <p><b>200</b> - Returned if the evaluation results in a value. The result is a JSON primitive value, list, or object.
    * <p><b>400</b> - Returned if:   *  the request is invalid, that is:           *  invalid data is provided, such as a request including issue ID and key.      *  the expression is invalid and can not be parsed.  *  evaluation fails at runtime. This may happen for various reasons. For example, accessing a property on a null object (such as the expression &#x60;issue.id&#x60; where &#x60;issue&#x60; is &#x60;null&#x60;). In this case an error message is provided.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if any object provided in the request context is not found or the user does not have permission to view it.
    * @param jiraExpressionEvalRequestBean The Jira expression and the evaluation context.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return JiraExpressionResult
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public JiraExpressionResult evaluateJiraExpression(JiraExpressionEvalRequestBean jiraExpressionEvalRequestBean, Map<String, Object> params) throws IOException {
        HttpResponse response = evaluateJiraExpressionForHttpResponse(jiraExpressionEvalRequestBean, params);
        TypeReference<JiraExpressionResult> typeRef = new TypeReference<JiraExpressionResult>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse evaluateJiraExpressionForHttpResponse(JiraExpressionEvalRequestBean jiraExpressionEvalRequestBean, String expand) throws IOException {
        // verify the required parameter 'jiraExpressionEvalRequestBean' is set
        if (jiraExpressionEvalRequestBean == null) {
            throw new IllegalArgumentException("Missing the required parameter 'jiraExpressionEvalRequestBean' when calling evaluateJiraExpression");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/expression/eval");
        if (expand != null) {
            String key = "expand";
            Object value = expand;
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

        HttpContent content = apiClient.new JacksonJsonHttpContent(jiraExpressionEvalRequestBean);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse evaluateJiraExpressionForHttpResponse(java.io.InputStream jiraExpressionEvalRequestBean, String expand, String mediaType) throws IOException {
          // verify the required parameter 'jiraExpressionEvalRequestBean' is set
              if (jiraExpressionEvalRequestBean == null) {
              throw new IllegalArgumentException("Missing the required parameter 'jiraExpressionEvalRequestBean' when calling evaluateJiraExpression");
              }
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/expression/eval");
              if (expand != null) {
                  String key = "expand";
                  Object value = expand;
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

              HttpContent content = jiraExpressionEvalRequestBean == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, jiraExpressionEvalRequestBean);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse evaluateJiraExpressionForHttpResponse(JiraExpressionEvalRequestBean jiraExpressionEvalRequestBean, Map<String, Object> params) throws IOException {
        // verify the required parameter 'jiraExpressionEvalRequestBean' is set
        if (jiraExpressionEvalRequestBean == null) {
            throw new IllegalArgumentException("Missing the required parameter 'jiraExpressionEvalRequestBean' when calling evaluateJiraExpression");
        }
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/expression/eval");

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(jiraExpressionEvalRequestBean);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


}
