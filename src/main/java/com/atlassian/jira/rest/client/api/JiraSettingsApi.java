package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.ApplicationProperty;
import com.atlassian.jira.rest.client.model.ModelConfiguration;
import com.atlassian.jira.rest.client.model.SimpleApplicationPropertyBean;

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
public class JiraSettingsApi {
    private ApiClient apiClient;

    public JiraSettingsApi() {
        this(new ApiClient());
    }

    public JiraSettingsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Get advanced settings
    * Returns the application properties that are accessible on the *Advanced Settings* page. To navigate to the *Advanced Settings* page in Jira, choose the Jira icon &gt; **Jira settings** &gt; **System**, **General Configuration** and then click **Advanced Settings** (in the upper right).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user is not an administrator.
    * @return List&lt;ApplicationProperty&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<ApplicationProperty> getAdvancedSettings() throws IOException {
        HttpResponse response = getAdvancedSettingsForHttpResponse();
        TypeReference<List<ApplicationProperty>> typeRef = new TypeReference<List<ApplicationProperty>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get advanced settings
    * Returns the application properties that are accessible on the *Advanced Settings* page. To navigate to the *Advanced Settings* page in Jira, choose the Jira icon &gt; **Jira settings** &gt; **System**, **General Configuration** and then click **Advanced Settings** (in the upper right).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user is not an administrator.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return List&lt;ApplicationProperty&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<ApplicationProperty> getAdvancedSettings(Map<String, Object> params) throws IOException {
        HttpResponse response = getAdvancedSettingsForHttpResponse(params);
        TypeReference<List<ApplicationProperty>> typeRef = new TypeReference<List<ApplicationProperty>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getAdvancedSettingsForHttpResponse() throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/application-properties/advanced-settings");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getAdvancedSettingsForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/application-properties/advanced-settings");

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
    * Get application property
    * Returns all application properties or an application property.  If you specify a value for the &#x60;key&#x60; parameter, then an application property is returned as an object (not in an array). Otherwise, an array of all editable application properties is returned. See [Set application property](#api-rest-api-3-application-properties-id-put) for descriptions of editable properties.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the application property is not found or the user does not have permission to view it.
    * @param key The key of the application property.
    * @param permissionLevel The permission level of all items being returned in the list.
    * @param keyFilter When a &#x60;key&#x60; isn&#39;t provided, this filters the list of results by the application property &#x60;key&#x60; using a regular expression. For example, using &#x60;jira.lf.*&#x60; will return all application properties with keys that start with *jira.lf.*.
    * @return List&lt;ApplicationProperty&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<ApplicationProperty> getApplicationProperty(String key, String permissionLevel, String keyFilter) throws IOException {
        HttpResponse response = getApplicationPropertyForHttpResponse(key, permissionLevel, keyFilter);
        TypeReference<List<ApplicationProperty>> typeRef = new TypeReference<List<ApplicationProperty>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get application property
    * Returns all application properties or an application property.  If you specify a value for the &#x60;key&#x60; parameter, then an application property is returned as an object (not in an array). Otherwise, an array of all editable application properties is returned. See [Set application property](#api-rest-api-3-application-properties-id-put) for descriptions of editable properties.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>404</b> - Returned if the application property is not found or the user does not have permission to view it.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return List&lt;ApplicationProperty&gt;
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public List<ApplicationProperty> getApplicationProperty(Map<String, Object> params) throws IOException {
        HttpResponse response = getApplicationPropertyForHttpResponse(params);
        TypeReference<List<ApplicationProperty>> typeRef = new TypeReference<List<ApplicationProperty>>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getApplicationPropertyForHttpResponse(String key, String permissionLevel, String keyFilter) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/application-properties");
        if (key != null) {
            String key = "key";
            Object value = key;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (permissionLevel != null) {
            String key = "permissionLevel";
            Object value = permissionLevel;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (keyFilter != null) {
            String key = "keyFilter";
            Object value = keyFilter;
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

    public HttpResponse getApplicationPropertyForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/application-properties");

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
    * Get global settings
    * Returns the [global settings](https://confluence.atlassian.com/x/qYXKM) in Jira. These settings determine whether optional features (for example, subtasks, time tracking, and others) are enabled. If time tracking is enabled, this operation also returns the time tracking configuration.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @return ModelConfiguration
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ModelConfiguration getConfiguration() throws IOException {
        HttpResponse response = getConfigurationForHttpResponse();
        TypeReference<ModelConfiguration> typeRef = new TypeReference<ModelConfiguration>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get global settings
    * Returns the [global settings](https://confluence.atlassian.com/x/qYXKM) in Jira. These settings determine whether optional features (for example, subtasks, time tracking, and others) are enabled. If time tracking is enabled, this operation also returns the time tracking configuration.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return ModelConfiguration
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ModelConfiguration getConfiguration(Map<String, Object> params) throws IOException {
        HttpResponse response = getConfigurationForHttpResponse(params);
        TypeReference<ModelConfiguration> typeRef = new TypeReference<ModelConfiguration>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getConfigurationForHttpResponse() throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/configuration");

        String localVarUrl = uriBuilder.build().toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getConfigurationForHttpResponse(Map<String, Object> params) throws IOException {
        
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/configuration");

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
    * Set application property
    * Changes the value of an application property. For example, you can change the value of the &#x60;jira.clone.prefix&#x60; from its default value of *CLONE -* to *Clone -* if you prefer sentence case capitalization. Editable properties are described below along with their default values.  #### Advanced settings ####  The advanced settings below are also accessible in [Jira](https://confluence.atlassian.com/x/vYXKM).  | Key | Description | Default value |   | -- | -- | -- |   | &#x60;jira.clone.prefix&#x60; | The string of text prefixed to the title of a cloned issue. | &#x60;CLONE -&#x60; |   | &#x60;jira.date.picker.java.format&#x60; | The date format for the Java (server-side) generated dates. This must be the same as the &#x60;jira.date.picker.javascript.format&#x60; format setting. | &#x60;d/MMM/yy&#x60; |   | &#x60;jira.date.picker.javascript.format&#x60; | The date format for the JavaScript (client-side) generated dates. This must be the same as the &#x60;jira.date.picker.java.format&#x60; format setting. | &#x60;%e/%b/%y&#x60; |   | &#x60;jira.date.time.picker.java.format&#x60; | The date format for the Java (server-side) generated date times. This must be the same as the &#x60;jira.date.time.picker.javascript.format&#x60; format setting. | &#x60;dd/MMM/yy h:mm a&#x60; |   | &#x60;jira.date.time.picker.javascript.format&#x60; | The date format for the JavaScript (client-side) generated date times. This must be the same as the &#x60;jira.date.time.picker.java.format&#x60; format setting. | &#x60;%e/%b/%y %I:%M %p&#x60; |   | &#x60;jira.issue.actions.order&#x60; | The default order of actions (such as *Comments* or *Change history*) displayed on the issue view. | &#x60;asc&#x60; |   | &#x60;jira.table.cols.subtasks&#x60; | The columns to show while viewing subtask issues in a table. For example, a list of subtasks on an issue. | &#x60;issuetype, status, assignee, progress&#x60; |   | &#x60;jira.view.issue.links.sort.order&#x60; | The sort order of the list of issue links on the issue view. | &#x60;type, status, priority&#x60; |   | &#x60;jira.comment.collapsing.minimum.hidden&#x60; | The minimum number of comments required for comment collapsing to occur. A value of &#x60;0&#x60; disables comment collapsing. | &#x60;4&#x60; |   | &#x60;jira.newsletter.tip.delay.days&#x60; | The number of days before a prompt to sign up to the Jira Insiders newsletter is shown. A value of &#x60;-1&#x60; disables this feature. | &#x60;7&#x60; |     #### Look and feel ####  The settings listed below adjust the [look and feel](https://confluence.atlassian.com/x/VwCLLg).  | Key | Description | Default value |   | -- | -- | -- |   | &#x60;jira.lf.date.time&#x60; | The [ time format](https://docs.oracle.com/javase/6/docs/api/index.html?java/text/SimpleDateFormat.html). | &#x60;h:mm a&#x60; |   | &#x60;jira.lf.date.day&#x60; | The [ day format](https://docs.oracle.com/javase/6/docs/api/index.html?java/text/SimpleDateFormat.html). | &#x60;EEEE h:mm a&#x60; |   | &#x60;jira.lf.date.complete&#x60; | The [ date and time format](https://docs.oracle.com/javase/6/docs/api/index.html?java/text/SimpleDateFormat.html). | &#x60;dd/MMM/yy h:mm a&#x60; |   | &#x60;jira.lf.date.dmy&#x60; | The [ date format](https://docs.oracle.com/javase/6/docs/api/index.html?java/text/SimpleDateFormat.html). | &#x60;dd/MMM/yy&#x60; |   | &#x60;jira.date.time.picker.use.iso8061&#x60; | When enabled, sets Monday as the first day of the week in the date picker, as specified by the ISO8601 standard. | &#x60;false&#x60; |   | &#x60;jira.lf.logo.url&#x60; | The URL of the logo image file. | &#x60;/images/icon-jira-logo.png&#x60; |   | &#x60;jira.lf.logo.show.application.title&#x60; | Controls the visibility of the application title on the sidebar. | &#x60;false&#x60; |   | &#x60;jira.lf.favicon.url&#x60; | The URL of the favicon. | &#x60;/favicon.ico&#x60; |   | &#x60;jira.lf.favicon.hires.url&#x60; | The URL of the high-resolution favicon. | &#x60;/images/64jira.png&#x60; |   | &#x60;jira.lf.top.adg3.bgcolour&#x60; | The background color of the sidebar. | &#x60;#0747A6&#x60; |   | &#x60;jira.lf.top.adg3.textcolour&#x60; | The color of the text and logo of the sidebar. | &#x60;#DEEBFF&#x60; |   | &#x60;jira.lf.hero.button.base.bg.colour&#x60; | The background color of the hero button. | &#x60;#3b7fc4&#x60; |   | &#x60;jira.title&#x60; | The text for the application title. The application title can also be set in *General settings*. | &#x60;Jira&#x60; |   | &#x60;jira.option.globalsharing&#x60; | Whether filters and dashboards can be shared with anyone signed into Jira. | &#x60;true&#x60; |   | &#x60;xflow.product.suggestions.enabled&#x60; | Whether to expose product suggestions for other Atlassian products within Jira. | &#x60;true&#x60; |     #### Other settings ####  | Key | Description | Default value |   | -- | -- | -- |   | &#x60;jira.issuenav.criteria.autoupdate&#x60; | Whether instant updates to search criteria is active. | &#x60;true&#x60; |     *Note: Be careful when changing [application properties and advanced settings](https://confluence.atlassian.com/x/vYXKM).*  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the data type of the &#x60;value&#x60; does not match the application property&#39;s data type. For example, a string is provided instead of an integer.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have permission to edit the property.
    * <p><b>404</b> - Returned if the property is not found or the user does not have permission to view it.
    * @param id The key of the application property to update.
    * @param simpleApplicationPropertyBean The simpleApplicationPropertyBean parameter
    * @return ApplicationProperty
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ApplicationProperty setApplicationProperty(String id, SimpleApplicationPropertyBean simpleApplicationPropertyBean) throws IOException {
        HttpResponse response = setApplicationPropertyForHttpResponse(id, simpleApplicationPropertyBean);
        TypeReference<ApplicationProperty> typeRef = new TypeReference<ApplicationProperty>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Set application property
    * Changes the value of an application property. For example, you can change the value of the &#x60;jira.clone.prefix&#x60; from its default value of *CLONE -* to *Clone -* if you prefer sentence case capitalization. Editable properties are described below along with their default values.  #### Advanced settings ####  The advanced settings below are also accessible in [Jira](https://confluence.atlassian.com/x/vYXKM).  | Key | Description | Default value |   | -- | -- | -- |   | &#x60;jira.clone.prefix&#x60; | The string of text prefixed to the title of a cloned issue. | &#x60;CLONE -&#x60; |   | &#x60;jira.date.picker.java.format&#x60; | The date format for the Java (server-side) generated dates. This must be the same as the &#x60;jira.date.picker.javascript.format&#x60; format setting. | &#x60;d/MMM/yy&#x60; |   | &#x60;jira.date.picker.javascript.format&#x60; | The date format for the JavaScript (client-side) generated dates. This must be the same as the &#x60;jira.date.picker.java.format&#x60; format setting. | &#x60;%e/%b/%y&#x60; |   | &#x60;jira.date.time.picker.java.format&#x60; | The date format for the Java (server-side) generated date times. This must be the same as the &#x60;jira.date.time.picker.javascript.format&#x60; format setting. | &#x60;dd/MMM/yy h:mm a&#x60; |   | &#x60;jira.date.time.picker.javascript.format&#x60; | The date format for the JavaScript (client-side) generated date times. This must be the same as the &#x60;jira.date.time.picker.java.format&#x60; format setting. | &#x60;%e/%b/%y %I:%M %p&#x60; |   | &#x60;jira.issue.actions.order&#x60; | The default order of actions (such as *Comments* or *Change history*) displayed on the issue view. | &#x60;asc&#x60; |   | &#x60;jira.table.cols.subtasks&#x60; | The columns to show while viewing subtask issues in a table. For example, a list of subtasks on an issue. | &#x60;issuetype, status, assignee, progress&#x60; |   | &#x60;jira.view.issue.links.sort.order&#x60; | The sort order of the list of issue links on the issue view. | &#x60;type, status, priority&#x60; |   | &#x60;jira.comment.collapsing.minimum.hidden&#x60; | The minimum number of comments required for comment collapsing to occur. A value of &#x60;0&#x60; disables comment collapsing. | &#x60;4&#x60; |   | &#x60;jira.newsletter.tip.delay.days&#x60; | The number of days before a prompt to sign up to the Jira Insiders newsletter is shown. A value of &#x60;-1&#x60; disables this feature. | &#x60;7&#x60; |     #### Look and feel ####  The settings listed below adjust the [look and feel](https://confluence.atlassian.com/x/VwCLLg).  | Key | Description | Default value |   | -- | -- | -- |   | &#x60;jira.lf.date.time&#x60; | The [ time format](https://docs.oracle.com/javase/6/docs/api/index.html?java/text/SimpleDateFormat.html). | &#x60;h:mm a&#x60; |   | &#x60;jira.lf.date.day&#x60; | The [ day format](https://docs.oracle.com/javase/6/docs/api/index.html?java/text/SimpleDateFormat.html). | &#x60;EEEE h:mm a&#x60; |   | &#x60;jira.lf.date.complete&#x60; | The [ date and time format](https://docs.oracle.com/javase/6/docs/api/index.html?java/text/SimpleDateFormat.html). | &#x60;dd/MMM/yy h:mm a&#x60; |   | &#x60;jira.lf.date.dmy&#x60; | The [ date format](https://docs.oracle.com/javase/6/docs/api/index.html?java/text/SimpleDateFormat.html). | &#x60;dd/MMM/yy&#x60; |   | &#x60;jira.date.time.picker.use.iso8061&#x60; | When enabled, sets Monday as the first day of the week in the date picker, as specified by the ISO8601 standard. | &#x60;false&#x60; |   | &#x60;jira.lf.logo.url&#x60; | The URL of the logo image file. | &#x60;/images/icon-jira-logo.png&#x60; |   | &#x60;jira.lf.logo.show.application.title&#x60; | Controls the visibility of the application title on the sidebar. | &#x60;false&#x60; |   | &#x60;jira.lf.favicon.url&#x60; | The URL of the favicon. | &#x60;/favicon.ico&#x60; |   | &#x60;jira.lf.favicon.hires.url&#x60; | The URL of the high-resolution favicon. | &#x60;/images/64jira.png&#x60; |   | &#x60;jira.lf.top.adg3.bgcolour&#x60; | The background color of the sidebar. | &#x60;#0747A6&#x60; |   | &#x60;jira.lf.top.adg3.textcolour&#x60; | The color of the text and logo of the sidebar. | &#x60;#DEEBFF&#x60; |   | &#x60;jira.lf.hero.button.base.bg.colour&#x60; | The background color of the hero button. | &#x60;#3b7fc4&#x60; |   | &#x60;jira.title&#x60; | The text for the application title. The application title can also be set in *General settings*. | &#x60;Jira&#x60; |   | &#x60;jira.option.globalsharing&#x60; | Whether filters and dashboards can be shared with anyone signed into Jira. | &#x60;true&#x60; |   | &#x60;xflow.product.suggestions.enabled&#x60; | Whether to expose product suggestions for other Atlassian products within Jira. | &#x60;true&#x60; |     #### Other settings ####  | Key | Description | Default value |   | -- | -- | -- |   | &#x60;jira.issuenav.criteria.autoupdate&#x60; | Whether instant updates to search criteria is active. | &#x60;true&#x60; |     *Note: Be careful when changing [application properties and advanced settings](https://confluence.atlassian.com/x/vYXKM).*  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - Returned if the request is successful.
    * <p><b>400</b> - Returned if the data type of the &#x60;value&#x60; does not match the application property&#39;s data type. For example, a string is provided instead of an integer.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have permission to edit the property.
    * <p><b>404</b> - Returned if the property is not found or the user does not have permission to view it.
    * @param id The key of the application property to update.
    * @param simpleApplicationPropertyBean The simpleApplicationPropertyBean parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return ApplicationProperty
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public ApplicationProperty setApplicationProperty(String id, SimpleApplicationPropertyBean simpleApplicationPropertyBean, Map<String, Object> params) throws IOException {
        HttpResponse response = setApplicationPropertyForHttpResponse(id, simpleApplicationPropertyBean, params);
        TypeReference<ApplicationProperty> typeRef = new TypeReference<ApplicationProperty>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse setApplicationPropertyForHttpResponse(String id, SimpleApplicationPropertyBean simpleApplicationPropertyBean) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling setApplicationProperty");
        }// verify the required parameter 'simpleApplicationPropertyBean' is set
        if (simpleApplicationPropertyBean == null) {
            throw new IllegalArgumentException("Missing the required parameter 'simpleApplicationPropertyBean' when calling setApplicationProperty");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/application-properties/{id}");

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(simpleApplicationPropertyBean);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse setApplicationPropertyForHttpResponse(String id, java.io.InputStream simpleApplicationPropertyBean, String mediaType) throws IOException {
          // verify the required parameter 'id' is set
              if (id == null) {
              throw new IllegalArgumentException("Missing the required parameter 'id' when calling setApplicationProperty");
              }// verify the required parameter 'simpleApplicationPropertyBean' is set
              if (simpleApplicationPropertyBean == null) {
              throw new IllegalArgumentException("Missing the required parameter 'simpleApplicationPropertyBean' when calling setApplicationProperty");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("id", id);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/application-properties/{id}");

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = simpleApplicationPropertyBean == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, simpleApplicationPropertyBean);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse setApplicationPropertyForHttpResponse(String id, SimpleApplicationPropertyBean simpleApplicationPropertyBean, Map<String, Object> params) throws IOException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new IllegalArgumentException("Missing the required parameter 'id' when calling setApplicationProperty");
        }// verify the required parameter 'simpleApplicationPropertyBean' is set
        if (simpleApplicationPropertyBean == null) {
            throw new IllegalArgumentException("Missing the required parameter 'simpleApplicationPropertyBean' when calling setApplicationProperty");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/application-properties/{id}");

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

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(simpleApplicationPropertyBean);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }


}
