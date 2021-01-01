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

import com.atlassian.jira.rest.client.model.EntityProperty;
import com.atlassian.jira.rest.client.model.PropertyKeys;
import org.junit.Test;
import org.junit.Ignore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for IssueCommentPropertiesApi
 */
@Ignore
public class IssueCommentPropertiesApiTest {

    private final IssueCommentPropertiesApi api = new IssueCommentPropertiesApi();

    
    /**
     * Delete comment property
     *
     * Deletes a comment property.  **[Permissions](#permissions) required:** either of:   *  *Edit All Comments* [project permission](https://confluence.atlassian.com/x/yodKLg) to delete a property from any comment.  *  *Edit Own Comments* [project permission](https://confluence.atlassian.com/x/yodKLg) to delete a property from a comment created by the user.  Also, when the visibility of a comment is restricted to a role or group the user must be a member of that role or group.
     *
     * @throws IOException
     *          if the Api call fails
     */
    @Test
    public void deleteCommentPropertyTest() throws IOException {
        String commentId = null;
        String propertyKey = null;
        api.deleteCommentProperty(commentId, propertyKey);

        // TODO: test validations
    }
    
    /**
     * Get comment property
     *
     * Returns the value of a comment property.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  If the comment has visibility restrictions, belongs to the group or has the role visibility is restricted to.
     *
     * @throws IOException
     *          if the Api call fails
     */
    @Test
    public void getCommentPropertyTest() throws IOException {
        String commentId = null;
        String propertyKey = null;
        EntityProperty response = api.getCommentProperty(commentId, propertyKey);

        // TODO: test validations
    }
    
    /**
     * Get comment property keys
     *
     * Returns the keys of all the properties of a comment.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:**   *  *Browse projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project.  *  If [issue-level security](https://confluence.atlassian.com/x/J4lKLg) is configured, issue-level security permission to view the issue.  *  If the comment has visibility restrictions, belongs to the group or has the role visibility is restricted to.
     *
     * @throws IOException
     *          if the Api call fails
     */
    @Test
    public void getCommentPropertyKeysTest() throws IOException {
        String commentId = null;
        PropertyKeys response = api.getCommentPropertyKeys(commentId);

        // TODO: test validations
    }
    
    /**
     * Set comment property
     *
     * Creates or updates the value of a property for a comment. Use this resource to store custom data against a comment.  The value of the request body must be a [valid](http://tools.ietf.org/html/rfc4627), non-empty JSON blob. The maximum length is 32768 characters.  **[Permissions](#permissions) required:** either of:   *  *Edit All Comments* [project permission](https://confluence.atlassian.com/x/yodKLg) to create or update the value of a property on any comment.  *  *Edit Own Comments* [project permission](https://confluence.atlassian.com/x/yodKLg) to create or update the value of a property on a comment created by the user.  Also, when the visibility of a comment is restricted to a role or group the user must be a member of that role or group.
     *
     * @throws IOException
     *          if the Api call fails
     */
    @Test
    public void setCommentPropertyTest() throws IOException {
        String commentId = null;
        String propertyKey = null;
        Object body = null;
        Object response = api.setCommentProperty(commentId, propertyKey, body);

        // TODO: test validations
    }
    
}
