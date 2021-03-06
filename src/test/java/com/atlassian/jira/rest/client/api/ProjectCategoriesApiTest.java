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

import com.atlassian.jira.rest.client.model.ProjectCategory;
import com.atlassian.jira.rest.client.model.UpdatedProjectCategory;
import org.junit.Test;
import org.junit.Ignore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ProjectCategoriesApi
 */
@Ignore
public class ProjectCategoriesApiTest {

    private final ProjectCategoriesApi api = new ProjectCategoriesApi();

    
    /**
     * Create project category
     *
     * Creates a project category.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     *
     * @throws IOException
     *          if the Api call fails
     */
    @Test
    public void createProjectCategoryTest() throws IOException {
        ProjectCategory projectCategory = null;
        ProjectCategory response = api.createProjectCategory(projectCategory);

        // TODO: test validations
    }
    
    /**
     * Get all project categories
     *
     * Returns all project categories.  **[Permissions](#permissions) required:** Permission to access Jira.
     *
     * @throws IOException
     *          if the Api call fails
     */
    @Test
    public void getAllProjectCategoriesTest() throws IOException {
        List<ProjectCategory> response = api.getAllProjectCategories();

        // TODO: test validations
    }
    
    /**
     * Get project category by ID
     *
     * Returns a project category.  **[Permissions](#permissions) required:** Permission to access Jira.
     *
     * @throws IOException
     *          if the Api call fails
     */
    @Test
    public void getProjectCategoryByIdTest() throws IOException {
        Long id = null;
        ProjectCategory response = api.getProjectCategoryById(id);

        // TODO: test validations
    }
    
    /**
     * Delete project category
     *
     * Deletes a project category.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     *
     * @throws IOException
     *          if the Api call fails
     */
    @Test
    public void removeProjectCategoryTest() throws IOException {
        Long id = null;
        api.removeProjectCategory(id);

        // TODO: test validations
    }
    
    /**
     * Update project category
     *
     * Updates a project category.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     *
     * @throws IOException
     *          if the Api call fails
     */
    @Test
    public void updateProjectCategoryTest() throws IOException {
        Long id = null;
        ProjectCategory projectCategory = null;
        UpdatedProjectCategory response = api.updateProjectCategory(id, projectCategory);

        // TODO: test validations
    }
    
}
