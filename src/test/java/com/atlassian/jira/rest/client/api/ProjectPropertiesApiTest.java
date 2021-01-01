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
 * API tests for ProjectPropertiesApi
 */
@Ignore
public class ProjectPropertiesApiTest {

    private final ProjectPropertiesApi api = new ProjectPropertiesApi();

    
    /**
     * Delete project property
     *
     * Deletes the [property](https://developer.atlassian.com/cloud/jira/platform/storing-data-without-a-database/#a-id-jira-entity-properties-a-jira-entity-properties) from a project.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) or *Administer Projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project containing the property.
     *
     * @throws IOException
     *          if the Api call fails
     */
    @Test
    public void deleteProjectPropertyTest() throws IOException {
        String projectIdOrKey = null;
        String propertyKey = null;
        api.deleteProjectProperty(projectIdOrKey, propertyKey);

        // TODO: test validations
    }
    
    /**
     * Get project property
     *
     * Returns the value of a [project property](https://developer.atlassian.com/cloud/jira/platform/storing-data-without-a-database/#a-id-jira-entity-properties-a-jira-entity-properties).  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Browse Projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project containing the property.
     *
     * @throws IOException
     *          if the Api call fails
     */
    @Test
    public void getProjectPropertyTest() throws IOException {
        String projectIdOrKey = null;
        String propertyKey = null;
        EntityProperty response = api.getProjectProperty(projectIdOrKey, propertyKey);

        // TODO: test validations
    }
    
    /**
     * Get project property keys
     *
     * Returns all [project property](https://developer.atlassian.com/cloud/jira/platform/storing-data-without-a-database/#a-id-jira-entity-properties-a-jira-entity-properties) keys for the project.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Browse Projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project.
     *
     * @throws IOException
     *          if the Api call fails
     */
    @Test
    public void getProjectPropertyKeysTest() throws IOException {
        String projectIdOrKey = null;
        PropertyKeys response = api.getProjectPropertyKeys(projectIdOrKey);

        // TODO: test validations
    }
    
    /**
     * Set project property
     *
     * Sets the value of the [project property](https://developer.atlassian.com/cloud/jira/platform/storing-data-without-a-database/#a-id-jira-entity-properties-a-jira-entity-properties). You can use project properties to store custom data against the project.  The value of the request body must be a [valid](http://tools.ietf.org/html/rfc4627), non-empty JSON blob. The maximum length is 32768 characters.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg) or *Administer Projects* [project permission](https://confluence.atlassian.com/x/yodKLg) for the project in which the property is created.
     *
     * @throws IOException
     *          if the Api call fails
     */
    @Test
    public void setProjectPropertyTest() throws IOException {
        String projectIdOrKey = null;
        String propertyKey = null;
        Object body = null;
        Object response = api.setProjectProperty(projectIdOrKey, propertyKey, body);

        // TODO: test validations
    }
    
}
