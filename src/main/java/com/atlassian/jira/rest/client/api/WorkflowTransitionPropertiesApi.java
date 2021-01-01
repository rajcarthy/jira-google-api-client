package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.ApiClient;

import com.atlassian.jira.rest.client.model.WorkflowTransitionProperty;

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
public class WorkflowTransitionPropertiesApi {
    private ApiClient apiClient;

    public WorkflowTransitionPropertiesApi() {
        this(new ApiClient());
    }

    public WorkflowTransitionPropertiesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

  /**
    * Create workflow transition property
    * Adds a property to a workflow transition. Transition properties are used to change the behavior of a transition. For more information, see [Transition properties](https://confluence.atlassian.com/x/zIhKLg#Advancedworkflowconfiguration-transitionproperties) and [Workflow properties](https://confluence.atlassian.com/x/JYlKLg).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - 200 response
    * <p><b>400</b> - Returned if a workflow property with the same key is present on the transition.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the workflow transition is not found.
    * @param transitionId The ID of the transition. To get the ID, view the workflow in text mode in the Jira admin settings. The ID is shown next to the transition.
    * @param key The key of the property being added, also known as the name of the property. Set this to the same value as the &#x60;key&#x60; defined in the request body.
    * @param workflowName The name of the workflow that the transition belongs to.
    * @param requestBody The requestBody parameter
    * @param workflowMode The workflow status. Set to *live* for inactive workflows or *draft* for draft workflows. Active workflows cannot be edited.
    * @return WorkflowTransitionProperty
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public WorkflowTransitionProperty createWorkflowTransitionProperty(Long transitionId, String key, String workflowName, Map<String, Object> requestBody, String workflowMode) throws IOException {
        HttpResponse response = createWorkflowTransitionPropertyForHttpResponse(transitionId, key, workflowName, requestBody, workflowMode);
        TypeReference<WorkflowTransitionProperty> typeRef = new TypeReference<WorkflowTransitionProperty>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Create workflow transition property
    * Adds a property to a workflow transition. Transition properties are used to change the behavior of a transition. For more information, see [Transition properties](https://confluence.atlassian.com/x/zIhKLg#Advancedworkflowconfiguration-transitionproperties) and [Workflow properties](https://confluence.atlassian.com/x/JYlKLg).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - 200 response
    * <p><b>400</b> - Returned if a workflow property with the same key is present on the transition.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the workflow transition is not found.
    * @param transitionId The ID of the transition. To get the ID, view the workflow in text mode in the Jira admin settings. The ID is shown next to the transition.
    * @param key The key of the property being added, also known as the name of the property. Set this to the same value as the &#x60;key&#x60; defined in the request body.
    * @param workflowName The name of the workflow that the transition belongs to.
    * @param requestBody The requestBody parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return WorkflowTransitionProperty
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public WorkflowTransitionProperty createWorkflowTransitionProperty(Long transitionId, String key, String workflowName, Map<String, Object> requestBody, Map<String, Object> params) throws IOException {
        HttpResponse response = createWorkflowTransitionPropertyForHttpResponse(transitionId, key, workflowName, requestBody, params);
        TypeReference<WorkflowTransitionProperty> typeRef = new TypeReference<WorkflowTransitionProperty>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse createWorkflowTransitionPropertyForHttpResponse(Long transitionId, String key, String workflowName, Map<String, Object> requestBody, String workflowMode) throws IOException {
        // verify the required parameter 'transitionId' is set
        if (transitionId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'transitionId' when calling createWorkflowTransitionProperty");
        }// verify the required parameter 'key' is set
        if (key == null) {
            throw new IllegalArgumentException("Missing the required parameter 'key' when calling createWorkflowTransitionProperty");
        }// verify the required parameter 'workflowName' is set
        if (workflowName == null) {
            throw new IllegalArgumentException("Missing the required parameter 'workflowName' when calling createWorkflowTransitionProperty");
        }// verify the required parameter 'requestBody' is set
        if (requestBody == null) {
            throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling createWorkflowTransitionProperty");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("transitionId", transitionId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflow/transitions/{transitionId}/properties");
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
        }        if (workflowName != null) {
            String key = "workflowName";
            Object value = workflowName;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (workflowMode != null) {
            String key = "workflowMode";
            Object value = workflowMode;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(requestBody);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }

      public HttpResponse createWorkflowTransitionPropertyForHttpResponse(Long transitionId, String key, String workflowName, java.io.InputStream requestBody, String workflowMode, String mediaType) throws IOException {
          // verify the required parameter 'transitionId' is set
              if (transitionId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'transitionId' when calling createWorkflowTransitionProperty");
              }// verify the required parameter 'key' is set
              if (key == null) {
              throw new IllegalArgumentException("Missing the required parameter 'key' when calling createWorkflowTransitionProperty");
              }// verify the required parameter 'workflowName' is set
              if (workflowName == null) {
              throw new IllegalArgumentException("Missing the required parameter 'workflowName' when calling createWorkflowTransitionProperty");
              }// verify the required parameter 'requestBody' is set
              if (requestBody == null) {
              throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling createWorkflowTransitionProperty");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("transitionId", transitionId);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflow/transitions/{transitionId}/properties");
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
              }              if (workflowName != null) {
                  String key = "workflowName";
                  Object value = workflowName;
                  if (value instanceof Collection) {
                    uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
                  } else if (value instanceof Object[]) {
                    uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
                  } else {
                    uriBuilder = uriBuilder.queryParam(key, value);
                  }
              }              if (workflowMode != null) {
                  String key = "workflowMode";
                  Object value = workflowMode;
                  if (value instanceof Collection) {
                    uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
                  } else if (value instanceof Object[]) {
                    uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
                  } else {
                    uriBuilder = uriBuilder.queryParam(key, value);
                  }
              }

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = requestBody == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, requestBody);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
      }

    public HttpResponse createWorkflowTransitionPropertyForHttpResponse(Long transitionId, String key, String workflowName, Map<String, Object> requestBody, Map<String, Object> params) throws IOException {
        // verify the required parameter 'transitionId' is set
        if (transitionId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'transitionId' when calling createWorkflowTransitionProperty");
        }// verify the required parameter 'key' is set
        if (key == null) {
            throw new IllegalArgumentException("Missing the required parameter 'key' when calling createWorkflowTransitionProperty");
        }// verify the required parameter 'workflowName' is set
        if (workflowName == null) {
            throw new IllegalArgumentException("Missing the required parameter 'workflowName' when calling createWorkflowTransitionProperty");
        }// verify the required parameter 'requestBody' is set
        if (requestBody == null) {
            throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling createWorkflowTransitionProperty");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("transitionId", transitionId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflow/transitions/{transitionId}/properties");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);
        // Add the required query param 'key' to the map of query params
        allParams.put("key", key);
        // Add the required query param 'workflowName' to the map of query params
        allParams.put("workflowName", workflowName);

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(requestBody);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.POST, genericUrl, content).execute();
    }


  /**
    * Delete workflow transition property
    * Deletes a property from a workflow transition. Transition properties are used to change the behavior of a transition. For more information, see [Transition properties](https://confluence.atlassian.com/x/zIhKLg#Advancedworkflowconfiguration-transitionproperties) and [Workflow properties](https://confluence.atlassian.com/x/JYlKLg).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - 200 response
    * <p><b>304</b> - Returned if no changes were made by the request. For example, trying to delete a property that cannot be found.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the workflow transition is not found.
    * @param transitionId The ID of the transition. To get the ID, view the workflow in text mode in the Jira admin settings. The ID is shown next to the transition.
    * @param key The name of the transition property to delete, also known as the name of the property.
    * @param workflowName The name of the workflow that the transition belongs to.
    * @param workflowMode The workflow status. Set to &#x60;live&#x60; for inactive workflows or &#x60;draft&#x60; for draft workflows. Active workflows cannot be edited.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteWorkflowTransitionProperty(Long transitionId, String key, String workflowName, String workflowMode) throws IOException {
        deleteWorkflowTransitionPropertyForHttpResponse(transitionId, key, workflowName, workflowMode);
    }

  /**
    * Delete workflow transition property
    * Deletes a property from a workflow transition. Transition properties are used to change the behavior of a transition. For more information, see [Transition properties](https://confluence.atlassian.com/x/zIhKLg#Advancedworkflowconfiguration-transitionproperties) and [Workflow properties](https://confluence.atlassian.com/x/JYlKLg).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - 200 response
    * <p><b>304</b> - Returned if no changes were made by the request. For example, trying to delete a property that cannot be found.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the workflow transition is not found.
    * @param transitionId The ID of the transition. To get the ID, view the workflow in text mode in the Jira admin settings. The ID is shown next to the transition.
    * @param key The name of the transition property to delete, also known as the name of the property.
    * @param workflowName The name of the workflow that the transition belongs to.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public void deleteWorkflowTransitionProperty(Long transitionId, String key, String workflowName, Map<String, Object> params) throws IOException {
        deleteWorkflowTransitionPropertyForHttpResponse(transitionId, key, workflowName, params);
    }

    public HttpResponse deleteWorkflowTransitionPropertyForHttpResponse(Long transitionId, String key, String workflowName, String workflowMode) throws IOException {
        // verify the required parameter 'transitionId' is set
        if (transitionId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'transitionId' when calling deleteWorkflowTransitionProperty");
        }// verify the required parameter 'key' is set
        if (key == null) {
            throw new IllegalArgumentException("Missing the required parameter 'key' when calling deleteWorkflowTransitionProperty");
        }// verify the required parameter 'workflowName' is set
        if (workflowName == null) {
            throw new IllegalArgumentException("Missing the required parameter 'workflowName' when calling deleteWorkflowTransitionProperty");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("transitionId", transitionId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflow/transitions/{transitionId}/properties");
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
        }        if (workflowName != null) {
            String key = "workflowName";
            Object value = workflowName;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (workflowMode != null) {
            String key = "workflowMode";
            Object value = workflowMode;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }

    public HttpResponse deleteWorkflowTransitionPropertyForHttpResponse(Long transitionId, String key, String workflowName, Map<String, Object> params) throws IOException {
        // verify the required parameter 'transitionId' is set
        if (transitionId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'transitionId' when calling deleteWorkflowTransitionProperty");
        }// verify the required parameter 'key' is set
        if (key == null) {
            throw new IllegalArgumentException("Missing the required parameter 'key' when calling deleteWorkflowTransitionProperty");
        }// verify the required parameter 'workflowName' is set
        if (workflowName == null) {
            throw new IllegalArgumentException("Missing the required parameter 'workflowName' when calling deleteWorkflowTransitionProperty");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("transitionId", transitionId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflow/transitions/{transitionId}/properties");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);
        // Add the required query param 'key' to the map of query params
        allParams.put("key", key);
        // Add the required query param 'workflowName' to the map of query params
        allParams.put("workflowName", workflowName);

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

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.DELETE, genericUrl, content).execute();
    }


  /**
    * Get workflow transition properties
    * Returns the properties on a workflow transition. Transition properties are used to change the behavior of a transition. For more information, see [Transition properties](https://confluence.atlassian.com/x/zIhKLg#Advancedworkflowconfiguration-transitionproperties) and [Workflow properties](https://confluence.atlassian.com/x/JYlKLg).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - 200 response
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have admin permission
    * <p><b>404</b> - Returned if the workflow transition or property is not found.
    * @param transitionId The ID of the transition. To get the ID, view the workflow in text mode in the Jira administration console. The ID is shown next to the transition.
    * @param workflowName The name of the workflow that the transition belongs to.
    * @param includeReservedKeys Some properties with keys that have the *jira.* prefix are reserved, which means they are not editable. To include these properties in the results, set this parameter to *true*.
    * @param key The key of the property being returned, also known as the name of the property. If this parameter is not specified, all properties on the transition are returned.
    * @param workflowMode The workflow status. Set to *live* for active and inactive workflows, or *draft* for draft workflows.
    * @return WorkflowTransitionProperty
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public WorkflowTransitionProperty getWorkflowTransitionProperties(Long transitionId, String workflowName, Boolean includeReservedKeys, String key, String workflowMode) throws IOException {
        HttpResponse response = getWorkflowTransitionPropertiesForHttpResponse(transitionId, workflowName, includeReservedKeys, key, workflowMode);
        TypeReference<WorkflowTransitionProperty> typeRef = new TypeReference<WorkflowTransitionProperty>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Get workflow transition properties
    * Returns the properties on a workflow transition. Transition properties are used to change the behavior of a transition. For more information, see [Transition properties](https://confluence.atlassian.com/x/zIhKLg#Advancedworkflowconfiguration-transitionproperties) and [Workflow properties](https://confluence.atlassian.com/x/JYlKLg).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - 200 response
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have admin permission
    * <p><b>404</b> - Returned if the workflow transition or property is not found.
    * @param transitionId The ID of the transition. To get the ID, view the workflow in text mode in the Jira administration console. The ID is shown next to the transition.
    * @param workflowName The name of the workflow that the transition belongs to.
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return WorkflowTransitionProperty
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public WorkflowTransitionProperty getWorkflowTransitionProperties(Long transitionId, String workflowName, Map<String, Object> params) throws IOException {
        HttpResponse response = getWorkflowTransitionPropertiesForHttpResponse(transitionId, workflowName, params);
        TypeReference<WorkflowTransitionProperty> typeRef = new TypeReference<WorkflowTransitionProperty>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse getWorkflowTransitionPropertiesForHttpResponse(Long transitionId, String workflowName, Boolean includeReservedKeys, String key, String workflowMode) throws IOException {
        // verify the required parameter 'transitionId' is set
        if (transitionId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'transitionId' when calling getWorkflowTransitionProperties");
        }// verify the required parameter 'workflowName' is set
        if (workflowName == null) {
            throw new IllegalArgumentException("Missing the required parameter 'workflowName' when calling getWorkflowTransitionProperties");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("transitionId", transitionId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflow/transitions/{transitionId}/properties");
        if (includeReservedKeys != null) {
            String key = "includeReservedKeys";
            Object value = includeReservedKeys;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (key != null) {
            String key = "key";
            Object value = key;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (workflowName != null) {
            String key = "workflowName";
            Object value = workflowName;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (workflowMode != null) {
            String key = "workflowMode";
            Object value = workflowMode;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }

    public HttpResponse getWorkflowTransitionPropertiesForHttpResponse(Long transitionId, String workflowName, Map<String, Object> params) throws IOException {
        // verify the required parameter 'transitionId' is set
        if (transitionId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'transitionId' when calling getWorkflowTransitionProperties");
        }// verify the required parameter 'workflowName' is set
        if (workflowName == null) {
            throw new IllegalArgumentException("Missing the required parameter 'workflowName' when calling getWorkflowTransitionProperties");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("transitionId", transitionId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflow/transitions/{transitionId}/properties");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);
        // Add the required query param 'workflowName' to the map of query params
        allParams.put("workflowName", workflowName);

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

        HttpContent content = null;
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.GET, genericUrl, content).execute();
    }


  /**
    * Update workflow transition property
    * Updates a workflow transition by changing the property value. Trying to update a property that does not exist results in a new property being added to the transition. Transition properties are used to change the behavior of a transition. For more information, see [Transition properties](https://confluence.atlassian.com/x/zIhKLg#Advancedworkflowconfiguration-transitionproperties) and [Workflow properties](https://confluence.atlassian.com/x/JYlKLg).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - 200 response
    * <p><b>304</b> - Returned if no changes were made by the request. For example, attempting to update a property with its current value.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the workflow transition is not found.
    * @param transitionId The ID of the transition. To get the ID, view the workflow in text mode in the Jira admin settings. The ID is shown next to the transition.
    * @param key The key of the property being updated, also known as the name of the property. Set this to the same value as the &#x60;key&#x60; defined in the request body.
    * @param workflowName The name of the workflow that the transition belongs to.
    * @param requestBody The requestBody parameter
    * @param workflowMode The workflow status. Set to &#x60;live&#x60; for inactive workflows or &#x60;draft&#x60; for draft workflows. Active workflows cannot be edited.
    * @return WorkflowTransitionProperty
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public WorkflowTransitionProperty updateWorkflowTransitionProperty(Long transitionId, String key, String workflowName, Map<String, Object> requestBody, String workflowMode) throws IOException {
        HttpResponse response = updateWorkflowTransitionPropertyForHttpResponse(transitionId, key, workflowName, requestBody, workflowMode);
        TypeReference<WorkflowTransitionProperty> typeRef = new TypeReference<WorkflowTransitionProperty>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

  /**
    * Update workflow transition property
    * Updates a workflow transition by changing the property value. Trying to update a property that does not exist results in a new property being added to the transition. Transition properties are used to change the behavior of a transition. For more information, see [Transition properties](https://confluence.atlassian.com/x/zIhKLg#Advancedworkflowconfiguration-transitionproperties) and [Workflow properties](https://confluence.atlassian.com/x/JYlKLg).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
    * <p><b>200</b> - 200 response
    * <p><b>304</b> - Returned if no changes were made by the request. For example, attempting to update a property with its current value.
    * <p><b>400</b> - Returned if the request is invalid.
    * <p><b>401</b> - Returned if the authentication credentials are incorrect or missing.
    * <p><b>403</b> - Returned if the user does not have the necessary permission.
    * <p><b>404</b> - Returned if the workflow transition is not found.
    * @param transitionId The ID of the transition. To get the ID, view the workflow in text mode in the Jira admin settings. The ID is shown next to the transition.
    * @param key The key of the property being updated, also known as the name of the property. Set this to the same value as the &#x60;key&#x60; defined in the request body.
    * @param workflowName The name of the workflow that the transition belongs to.
    * @param requestBody The requestBody parameter
    * @param params Map of query params. A collection will be interpreted as passing in multiple instances of the same query param.
    * @return WorkflowTransitionProperty
    * @throws IOException if an error occurs while attempting to invoke the API
    **/
    public WorkflowTransitionProperty updateWorkflowTransitionProperty(Long transitionId, String key, String workflowName, Map<String, Object> requestBody, Map<String, Object> params) throws IOException {
        HttpResponse response = updateWorkflowTransitionPropertyForHttpResponse(transitionId, key, workflowName, requestBody, params);
        TypeReference<WorkflowTransitionProperty> typeRef = new TypeReference<WorkflowTransitionProperty>() {};
        return apiClient.getObjectMapper().readValue(response.getContent(), typeRef);
    }

    public HttpResponse updateWorkflowTransitionPropertyForHttpResponse(Long transitionId, String key, String workflowName, Map<String, Object> requestBody, String workflowMode) throws IOException {
        // verify the required parameter 'transitionId' is set
        if (transitionId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'transitionId' when calling updateWorkflowTransitionProperty");
        }// verify the required parameter 'key' is set
        if (key == null) {
            throw new IllegalArgumentException("Missing the required parameter 'key' when calling updateWorkflowTransitionProperty");
        }// verify the required parameter 'workflowName' is set
        if (workflowName == null) {
            throw new IllegalArgumentException("Missing the required parameter 'workflowName' when calling updateWorkflowTransitionProperty");
        }// verify the required parameter 'requestBody' is set
        if (requestBody == null) {
            throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling updateWorkflowTransitionProperty");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("transitionId", transitionId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflow/transitions/{transitionId}/properties");
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
        }        if (workflowName != null) {
            String key = "workflowName";
            Object value = workflowName;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }        if (workflowMode != null) {
            String key = "workflowMode";
            Object value = workflowMode;
            if (value instanceof Collection) {
                uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
            } else if (value instanceof Object[]) {
                uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
            } else {
                uriBuilder = uriBuilder.queryParam(key, value);
            }
        }

        String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
        GenericUrl genericUrl = new GenericUrl(localVarUrl);

        HttpContent content = apiClient.new JacksonJsonHttpContent(requestBody);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }

      public HttpResponse updateWorkflowTransitionPropertyForHttpResponse(Long transitionId, String key, String workflowName, java.io.InputStream requestBody, String workflowMode, String mediaType) throws IOException {
          // verify the required parameter 'transitionId' is set
              if (transitionId == null) {
              throw new IllegalArgumentException("Missing the required parameter 'transitionId' when calling updateWorkflowTransitionProperty");
              }// verify the required parameter 'key' is set
              if (key == null) {
              throw new IllegalArgumentException("Missing the required parameter 'key' when calling updateWorkflowTransitionProperty");
              }// verify the required parameter 'workflowName' is set
              if (workflowName == null) {
              throw new IllegalArgumentException("Missing the required parameter 'workflowName' when calling updateWorkflowTransitionProperty");
              }// verify the required parameter 'requestBody' is set
              if (requestBody == null) {
              throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling updateWorkflowTransitionProperty");
              }
                  // create a map of path variables
                  final Map<String, Object> uriVariables = new HashMap<String, Object>();
                      uriVariables.put("transitionId", transitionId);
              UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflow/transitions/{transitionId}/properties");
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
              }              if (workflowName != null) {
                  String key = "workflowName";
                  Object value = workflowName;
                  if (value instanceof Collection) {
                    uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
                  } else if (value instanceof Object[]) {
                    uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
                  } else {
                    uriBuilder = uriBuilder.queryParam(key, value);
                  }
              }              if (workflowMode != null) {
                  String key = "workflowMode";
                  Object value = workflowMode;
                  if (value instanceof Collection) {
                    uriBuilder = uriBuilder.queryParam(key, ((Collection) value).toArray());
                  } else if (value instanceof Object[]) {
                    uriBuilder = uriBuilder.queryParam(key, (Object[]) value);
                  } else {
                    uriBuilder = uriBuilder.queryParam(key, value);
                  }
              }

              String localVarUrl = uriBuilder.buildFromMap(uriVariables).toString();
              GenericUrl genericUrl = new GenericUrl(localVarUrl);

              HttpContent content = requestBody == null ?
                apiClient.new JacksonJsonHttpContent(null) :
                new InputStreamContent(mediaType == null ? Json.MEDIA_TYPE : mediaType, requestBody);
              return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
      }

    public HttpResponse updateWorkflowTransitionPropertyForHttpResponse(Long transitionId, String key, String workflowName, Map<String, Object> requestBody, Map<String, Object> params) throws IOException {
        // verify the required parameter 'transitionId' is set
        if (transitionId == null) {
            throw new IllegalArgumentException("Missing the required parameter 'transitionId' when calling updateWorkflowTransitionProperty");
        }// verify the required parameter 'key' is set
        if (key == null) {
            throw new IllegalArgumentException("Missing the required parameter 'key' when calling updateWorkflowTransitionProperty");
        }// verify the required parameter 'workflowName' is set
        if (workflowName == null) {
            throw new IllegalArgumentException("Missing the required parameter 'workflowName' when calling updateWorkflowTransitionProperty");
        }// verify the required parameter 'requestBody' is set
        if (requestBody == null) {
            throw new IllegalArgumentException("Missing the required parameter 'requestBody' when calling updateWorkflowTransitionProperty");
        }
        // create a map of path variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("transitionId", transitionId);
        UriBuilder uriBuilder = UriBuilder.fromUri(apiClient.getBasePath() + "/rest/api/3/workflow/transitions/{transitionId}/properties");

        // Copy the params argument if present, to allow passing in immutable maps
        Map<String, Object> allParams = params == null ? new HashMap<String, Object>() : new HashMap<String, Object>(params);
        // Add the required query param 'key' to the map of query params
        allParams.put("key", key);
        // Add the required query param 'workflowName' to the map of query params
        allParams.put("workflowName", workflowName);

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

        HttpContent content = apiClient.new JacksonJsonHttpContent(requestBody);
        return apiClient.getHttpRequestFactory().buildRequest(HttpMethods.PUT, genericUrl, content).execute();
    }


}
