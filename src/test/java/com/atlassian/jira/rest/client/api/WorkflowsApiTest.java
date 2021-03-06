/*
 * The Jira Cloud platform REST API
 * Jira Cloud platform REST API documentation
 *
 * The version of the OpenAPI document: 1001.0.0-SNAPSHOT
 * Contact: ecosystem@atlassian.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.atlassian.jira.rest.client.api;

import com.atlassian.jira.rest.client.model.DeprecatedWorkflow;
import com.atlassian.jira.rest.client.model.ErrorCollection;
import com.atlassian.jira.rest.client.model.PageBeanWorkflow;
import java.util.Set;
import org.junit.Test;
import org.junit.Ignore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for WorkflowsApi
 */
@Ignore
public class WorkflowsApiTest {

    private final WorkflowsApi api = new WorkflowsApi();

    
    /**
     * Get all workflows
     *
     * Returns all workflows in Jira or a workflow. Deprecated, use [Get workflows paginated](#api-rest-api-3-workflow-search-get).  If the &#x60;workflowName&#x60; parameter is specified, the workflow is returned as an object (not in an array). Otherwise, an array of workflow objects is returned.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     *
     * @throws IOException
     *          if the Api call fails
     */
    @Test
    public void getAllWorkflowsTest() throws IOException {
        String workflowName = null;
        List<DeprecatedWorkflow> response = api.getAllWorkflows(workflowName);

        // TODO: test validations
    }
    
    /**
     * Get workflows paginated
     *
     * Returns a [paginated](#pagination) list of published classic workflows. When workflow names are specified, details of those workflows are returned. Otherwise, all published classic workflows are returned.  This operation does not return next-gen workflows.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     *
     * @throws IOException
     *          if the Api call fails
     */
    @Test
    public void getWorkflowsPaginatedTest() throws IOException {
        Long startAt = null;
        Integer maxResults = null;
        Set<String> workflowName = null;
        String expand = null;
        PageBeanWorkflow response = api.getWorkflowsPaginated(startAt, maxResults, workflowName, expand);

        // TODO: test validations
    }
    
}
