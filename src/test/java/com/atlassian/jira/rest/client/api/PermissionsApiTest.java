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

import com.atlassian.jira.rest.client.model.BulkPermissionGrants;
import com.atlassian.jira.rest.client.model.BulkPermissionsRequestBean;
import com.atlassian.jira.rest.client.model.ErrorCollection;
import com.atlassian.jira.rest.client.model.Permissions;
import com.atlassian.jira.rest.client.model.PermissionsKeysBean;
import com.atlassian.jira.rest.client.model.PermittedProjects;
import org.junit.Test;
import org.junit.Ignore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for PermissionsApi
 */
@Ignore
public class PermissionsApiTest {

    private final PermissionsApi api = new PermissionsApi();

    
    /**
     * Get all permissions
     *
     * Returns all permissions, including:   *  global permissions.  *  project permissions.  *  global permissions added by plugins.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     *
     * @throws IOException
     *          if the Api call fails
     */
    @Test
    public void getAllPermissionsTest() throws IOException {
        Permissions response = api.getAllPermissions();

        // TODO: test validations
    }
    
    /**
     * Get bulk permissions
     *
     * Returns:   *  for a list of global permissions, the global permissions granted to a user.  *  for a list of project permissions and lists of projects and issues, for each project permission a list of the projects and issues a user can access or manipulate.  If no account ID is provided, the operation returns details for the logged in user.  Note that:   *  Invalid project and issue IDs are ignored.  *  A maximum of 1000 projects and 1000 issues can be checked.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) to check the permissions for other users, otherwise none. However, Connect apps can make a call from the app server to the product to obtain permission details for any user, without admin permission. This Connect app ability doesn&#39;t apply to calls made using AP.request() in a browser.
     *
     * @throws IOException
     *          if the Api call fails
     */
    @Test
    public void getBulkPermissionsTest() throws IOException {
        BulkPermissionsRequestBean bulkPermissionsRequestBean = null;
        BulkPermissionGrants response = api.getBulkPermissions(bulkPermissionsRequestBean);

        // TODO: test validations
    }
    
    /**
     * Get my permissions
     *
     * Returns a list of permissions indicating which permissions the user has. Details of the user&#39;s permissions can be obtained in a global, project, or issue context.  The user is reported as having a project permission:   *  in the global context, if the user has the project permission in any project.  *  for a project, where the project permission is determined using issue data, if the user meets the permission&#39;s criteria for any issue in the project. Otherwise, if the user has the project permission in the project.  *  for an issue, where a project permission is determined using issue data, if the user has the permission in the issue. Otherwise, if the user has the project permission in the project containing the issue.  This means that users may be shown as having an issue permission (such as EDIT\\_ISSUES) in the global context or a project context but may not have the permission for any or all issues. For example, if Reporters have the EDIT\\_ISSUES permission a user would be shown as having this permission in the global context or the context of a project, because any user can be a reporter. However, if they are not the user who reported the issue queried they would not have EDIT\\_ISSUES permission for that issue.  Global permissions are unaffected by context.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
     *
     * @throws IOException
     *          if the Api call fails
     */
    @Test
    public void getMyPermissionsTest() throws IOException {
        String projectKey = null;
        String projectId = null;
        String issueKey = null;
        String issueId = null;
        String permissions = null;
        String projectUuid = null;
        String projectConfigurationUuid = null;
        Permissions response = api.getMyPermissions(projectKey, projectId, issueKey, issueId, permissions, projectUuid, projectConfigurationUuid);

        // TODO: test validations
    }
    
    /**
     * Get permitted projects
     *
     * Returns all the projects where the user is granted a list of project permissions.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
     *
     * @throws IOException
     *          if the Api call fails
     */
    @Test
    public void getPermittedProjectsTest() throws IOException {
        PermissionsKeysBean permissionsKeysBean = null;
        PermittedProjects response = api.getPermittedProjects(permissionsKeysBean);

        // TODO: test validations
    }
    
}
