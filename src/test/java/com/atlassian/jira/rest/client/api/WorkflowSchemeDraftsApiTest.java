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

import com.atlassian.jira.rest.client.model.DefaultWorkflow;
import com.atlassian.jira.rest.client.model.IssueTypeWorkflowMapping;
import com.atlassian.jira.rest.client.model.IssueTypesWorkflowMapping;
import com.atlassian.jira.rest.client.model.WorkflowScheme;
import org.junit.Test;
import org.junit.Ignore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for WorkflowSchemeDraftsApi
 */
@Ignore
public class WorkflowSchemeDraftsApiTest {

    private final WorkflowSchemeDraftsApi api = new WorkflowSchemeDraftsApi();

    
    /**
     * Create draft workflow scheme
     *
     * Create a draft workflow scheme from an active workflow scheme, by copying the active workflow scheme. Note that an active workflow scheme can only have one draft workflow scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     *
     * @throws IOException
     *          if the Api call fails
     */
    @Test
    public void createWorkflowSchemeDraftFromParentTest() throws IOException {
        Long id = null;
        WorkflowScheme response = api.createWorkflowSchemeDraftFromParent(id);

        // TODO: test validations
    }
    
    /**
     * Delete draft default workflow
     *
     * Resets the default workflow for a workflow scheme&#39;s draft. That is, the default workflow is set to Jira&#39;s system workflow (the *jira* workflow).  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     *
     * @throws IOException
     *          if the Api call fails
     */
    @Test
    public void deleteDraftDefaultWorkflowTest() throws IOException {
        Long id = null;
        WorkflowScheme response = api.deleteDraftDefaultWorkflow(id);

        // TODO: test validations
    }
    
    /**
     * Delete issue types for workflow in draft workflow scheme
     *
     * Deletes the workflow-issue type mapping for a workflow in a workflow scheme&#39;s draft.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     *
     * @throws IOException
     *          if the Api call fails
     */
    @Test
    public void deleteDraftWorkflowMappingTest() throws IOException {
        Long id = null;
        String workflowName = null;
        api.deleteDraftWorkflowMapping(id, workflowName);

        // TODO: test validations
    }
    
    /**
     * Delete draft workflow scheme
     *
     * Deletes a draft workflow scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     *
     * @throws IOException
     *          if the Api call fails
     */
    @Test
    public void deleteWorkflowSchemeDraftTest() throws IOException {
        Long id = null;
        api.deleteWorkflowSchemeDraft(id);

        // TODO: test validations
    }
    
    /**
     * Delete workflow for issue type in draft workflow scheme
     *
     * Deletes the issue type-workflow mapping for an issue type in a workflow scheme&#39;s draft.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     *
     * @throws IOException
     *          if the Api call fails
     */
    @Test
    public void deleteWorkflowSchemeDraftIssueTypeTest() throws IOException {
        Long id = null;
        String issueType = null;
        WorkflowScheme response = api.deleteWorkflowSchemeDraftIssueType(id, issueType);

        // TODO: test validations
    }
    
    /**
     * Get draft default workflow
     *
     * Returns the default workflow for a workflow scheme&#39;s draft. The default workflow is the workflow that is assigned any issue types that have not been mapped to any other workflow. The default workflow has *All Unassigned Issue Types* listed in its issue types for the workflow scheme in Jira.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     *
     * @throws IOException
     *          if the Api call fails
     */
    @Test
    public void getDraftDefaultWorkflowTest() throws IOException {
        Long id = null;
        DefaultWorkflow response = api.getDraftDefaultWorkflow(id);

        // TODO: test validations
    }
    
    /**
     * Get issue types for workflows in draft workflow scheme
     *
     * Returns the workflow-issue type mappings for a workflow scheme&#39;s draft.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     *
     * @throws IOException
     *          if the Api call fails
     */
    @Test
    public void getDraftWorkflowTest() throws IOException {
        Long id = null;
        String workflowName = null;
        IssueTypesWorkflowMapping response = api.getDraftWorkflow(id, workflowName);

        // TODO: test validations
    }
    
    /**
     * Get draft workflow scheme
     *
     * Returns the draft workflow scheme for an active workflow scheme. Draft workflow schemes allow changes to be made to the active workflow schemes: When an active workflow scheme is updated, a draft copy is created. The draft is modified, then the changes in the draft are copied back to the active workflow scheme. See [Configuring workflow schemes](https://confluence.atlassian.com/x/tohKLg) for more information.   Note that:   *  Only active workflow schemes can have draft workflow schemes.  *  An active workflow scheme can only have one draft workflow scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     *
     * @throws IOException
     *          if the Api call fails
     */
    @Test
    public void getWorkflowSchemeDraftTest() throws IOException {
        Long id = null;
        WorkflowScheme response = api.getWorkflowSchemeDraft(id);

        // TODO: test validations
    }
    
    /**
     * Get workflow for issue type in draft workflow scheme
     *
     * Returns the issue type-workflow mapping for an issue type in a workflow scheme&#39;s draft.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     *
     * @throws IOException
     *          if the Api call fails
     */
    @Test
    public void getWorkflowSchemeDraftIssueTypeTest() throws IOException {
        Long id = null;
        String issueType = null;
        IssueTypeWorkflowMapping response = api.getWorkflowSchemeDraftIssueType(id, issueType);

        // TODO: test validations
    }
    
    /**
     * Set workflow for issue type in draft workflow scheme
     *
     * Sets the workflow for an issue type in a workflow scheme&#39;s draft.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     *
     * @throws IOException
     *          if the Api call fails
     */
    @Test
    public void setWorkflowSchemeDraftIssueTypeTest() throws IOException {
        Long id = null;
        String issueType = null;
        IssueTypeWorkflowMapping issueTypeWorkflowMapping = null;
        WorkflowScheme response = api.setWorkflowSchemeDraftIssueType(id, issueType, issueTypeWorkflowMapping);

        // TODO: test validations
    }
    
    /**
     * Update draft default workflow
     *
     * Sets the default workflow for a workflow scheme&#39;s draft.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     *
     * @throws IOException
     *          if the Api call fails
     */
    @Test
    public void updateDraftDefaultWorkflowTest() throws IOException {
        Long id = null;
        DefaultWorkflow defaultWorkflow = null;
        WorkflowScheme response = api.updateDraftDefaultWorkflow(id, defaultWorkflow);

        // TODO: test validations
    }
    
    /**
     * Set issue types for workflow in workflow scheme
     *
     * Sets the issue types for a workflow in a workflow scheme&#39;s draft. The workflow can also be set as the default workflow for the draft workflow scheme. Unmapped issues types are mapped to the default workflow.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     *
     * @throws IOException
     *          if the Api call fails
     */
    @Test
    public void updateDraftWorkflowMappingTest() throws IOException {
        Long id = null;
        String workflowName = null;
        IssueTypesWorkflowMapping issueTypesWorkflowMapping = null;
        WorkflowScheme response = api.updateDraftWorkflowMapping(id, workflowName, issueTypesWorkflowMapping);

        // TODO: test validations
    }
    
    /**
     * Update draft workflow scheme
     *
     * Updates a draft workflow scheme. If a draft workflow scheme does not exist for the active workflow scheme, then a draft is created. Note that an active workflow scheme can only have one draft workflow scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     *
     * @throws IOException
     *          if the Api call fails
     */
    @Test
    public void updateWorkflowSchemeDraftTest() throws IOException {
        Long id = null;
        WorkflowScheme workflowScheme = null;
        WorkflowScheme response = api.updateWorkflowSchemeDraft(id, workflowScheme);

        // TODO: test validations
    }
    
}
