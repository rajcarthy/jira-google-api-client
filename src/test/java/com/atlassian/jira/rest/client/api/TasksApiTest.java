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

import com.atlassian.jira.rest.client.model.TaskProgressBeanObject;
import org.junit.Test;
import org.junit.Ignore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for TasksApi
 */
@Ignore
public class TasksApiTest {

    private final TasksApi api = new TasksApi();

    
    /**
     * Cancel task
     *
     * Cancels a task.  **[Permissions](#permissions) required:** either of:   *  *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).  *  Creator of the task.
     *
     * @throws IOException
     *          if the Api call fails
     */
    @Test
    public void cancelTaskTest() throws IOException {
        String taskId = null;
        Object response = api.cancelTask(taskId);

        // TODO: test validations
    }
    
    /**
     * Get task
     *
     * Returns the status of a [long-running asynchronous task](#async).  When a task has finished, this operation returns the JSON blob applicable to the task. See the documentation of the operation that created the task for details. Task details are not permanently retained. As of September 2019, details are retained for 14 days although this period may change without notice.  **[Permissions](#permissions) required:** either of:   *  *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).  *  Creator of the task.
     *
     * @throws IOException
     *          if the Api call fails
     */
    @Test
    public void getTaskTest() throws IOException {
        String taskId = null;
        TaskProgressBeanObject response = api.getTask(taskId);

        // TODO: test validations
    }
    
}
