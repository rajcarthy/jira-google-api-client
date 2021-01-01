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

import com.atlassian.jira.rest.client.model.Avatar;
import com.atlassian.jira.rest.client.model.IssueTypeCreateBean;
import com.atlassian.jira.rest.client.model.IssueTypeDetails;
import com.atlassian.jira.rest.client.model.IssueTypeUpdateBean;
import org.junit.Test;
import org.junit.Ignore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for IssueTypesApi
 */
@Ignore
public class IssueTypesApiTest {

    private final IssueTypesApi api = new IssueTypesApi();

    
    /**
     * Create issue type
     *
     * Creates an issue type and adds it to the default issue type scheme.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     *
     * @throws IOException
     *          if the Api call fails
     */
    @Test
    public void createIssueTypeTest() throws IOException {
        IssueTypeCreateBean issueTypeCreateBean = null;
        IssueTypeDetails response = api.createIssueType(issueTypeCreateBean);

        // TODO: test validations
    }
    
    /**
     * Load issue type avatar
     *
     * Loads an avatar for the issue type.  Specify the avatar&#39;s local file location in the body of the request. Also, include the following headers:   *  &#x60;X-Atlassian-Token: no-check&#x60; To prevent XSRF protection blocking the request, for more information see [Special Headers](#special-request-headers).  *  &#x60;Content-Type: image/image type&#x60; Valid image types are JPEG, GIF, or PNG.  For example:   &#x60;curl --request POST \\ --user email@example.com:&lt;api_token&gt; \\ --header &#39;X-Atlassian-Token: no-check&#39; \\ --header &#39;Content-Type: image/&lt; image_type&gt;&#39; \\ --data-binary \&quot;&lt;@/path/to/file/with/your/avatar&gt;\&quot; \\ --url &#39;https://your-domain.atlassian.net/rest/api/3/issuetype/{issueTypeId}&#39;This&#x60;  The avatar is cropped to a square. If no crop parameters are specified, the square originates at the top left of the image. The length of the square&#39;s sides is set to the smaller of the height or width of the image.  The cropped image is then used to create avatars of 16x16, 24x24, 32x32, and 48x48 in size.  After creating the avatar, use [ Update issue type](#api-rest-api-3-issuetype-id-put) to set it as the issue type&#39;s displayed avatar.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     *
     * @throws IOException
     *          if the Api call fails
     */
    @Test
    public void createIssueTypeAvatarTest() throws IOException {
        String id = null;
        Integer size = null;
        Object body = null;
        Integer x = null;
        Integer y = null;
        Avatar response = api.createIssueTypeAvatar(id, size, body, x, y);

        // TODO: test validations
    }
    
    /**
     * Delete issue type
     *
     * Deletes the issue type. If the issue type is in use, all uses are updated with the alternative issue type (&#x60;alternativeIssueTypeId&#x60;). A list of alternative issue types are obtained from the [Get alternative issue types](#api-rest-api-3-issuetype-id-alternatives-get) resource.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     *
     * @throws IOException
     *          if the Api call fails
     */
    @Test
    public void deleteIssueTypeTest() throws IOException {
        String id = null;
        String alternativeIssueTypeId = null;
        api.deleteIssueType(id, alternativeIssueTypeId);

        // TODO: test validations
    }
    
    /**
     * Get alternative issue types
     *
     * Returns a list of issue types that can be used to replace the issue type. The alternative issue types are those assigned to the same workflow scheme, field configuration scheme, and screen scheme.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
     *
     * @throws IOException
     *          if the Api call fails
     */
    @Test
    public void getAlternativeIssueTypesTest() throws IOException {
        String id = null;
        List<IssueTypeDetails> response = api.getAlternativeIssueTypes(id);

        // TODO: test validations
    }
    
    /**
     * Get all issue types for user
     *
     * Returns all issue types.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** Issue types are only returned as follows:   *  if the user has the *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg), all issue types are returned.  *  if the user has the *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for one or more projects, the issue types associated with the projects the user has permission to browse are returned.
     *
     * @throws IOException
     *          if the Api call fails
     */
    @Test
    public void getIssueAllTypesTest() throws IOException {
        List<IssueTypeDetails> response = api.getIssueAllTypes();

        // TODO: test validations
    }
    
    /**
     * Get issue type
     *
     * Returns an issue type.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) in a project the issue type is associated with or *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     *
     * @throws IOException
     *          if the Api call fails
     */
    @Test
    public void getIssueTypeTest() throws IOException {
        String id = null;
        IssueTypeDetails response = api.getIssueType(id);

        // TODO: test validations
    }
    
    /**
     * Update issue type
     *
     * Updates the issue type.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     *
     * @throws IOException
     *          if the Api call fails
     */
    @Test
    public void updateIssueTypeTest() throws IOException {
        String id = null;
        IssueTypeUpdateBean issueTypeUpdateBean = null;
        IssueTypeDetails response = api.updateIssueType(id, issueTypeUpdateBean);

        // TODO: test validations
    }
    
}
