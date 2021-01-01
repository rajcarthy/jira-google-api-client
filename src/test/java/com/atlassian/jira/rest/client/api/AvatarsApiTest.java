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
import com.atlassian.jira.rest.client.model.Avatars;
import com.atlassian.jira.rest.client.model.SystemAvatars;
import org.junit.Test;
import org.junit.Ignore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for AvatarsApi
 */
@Ignore
public class AvatarsApiTest {

    private final AvatarsApi api = new AvatarsApi();

    
    /**
     * Delete avatar
     *
     * Deletes an avatar from a project or issue type.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     *
     * @throws IOException
     *          if the Api call fails
     */
    @Test
    public void deleteAvatarTest() throws IOException {
        String type = null;
        String owningObjectId = null;
        Long id = null;
        api.deleteAvatar(type, owningObjectId, id);

        // TODO: test validations
    }
    
    /**
     * Get system avatars by type
     *
     * Returns a list of system avatar details by owner type, where the owner types are issue type, project, or user.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
     *
     * @throws IOException
     *          if the Api call fails
     */
    @Test
    public void getAllSystemAvatarsTest() throws IOException {
        String type = null;
        SystemAvatars response = api.getAllSystemAvatars(type);

        // TODO: test validations
    }
    
    /**
     * Get avatars
     *
     * Returns the system and custom avatars for a project or issue type.  This operation can be accessed anonymously.  **[Permissions](#permissions) required:** None.
     *
     * @throws IOException
     *          if the Api call fails
     */
    @Test
    public void getAvatarsTest() throws IOException {
        String type = null;
        String entityId = null;
        Avatars response = api.getAvatars(type, entityId);

        // TODO: test validations
    }
    
    /**
     * Load avatar
     *
     * Loads a custom avatar for a project or issue type.  Specify the avatar&#39;s local file location in the body of the request. Also, include the following headers:   *  &#x60;X-Atlassian-Token: no-check&#x60; To prevent XSRF protection blocking the request, for more information see [Special Headers](#special-request-headers).  *  &#x60;Content-Type: image/image type&#x60; Valid image types are JPEG, GIF, or PNG.  For example:   &#x60;curl --request POST &#x60;  &#x60;--user email@example.com:&lt;api_token&gt; &#x60;  &#x60;--header &#39;X-Atlassian-Token: no-check&#39; &#x60;  &#x60;--header &#39;Content-Type: image/&lt; image_type&gt;&#39; &#x60;  &#x60;--data-binary \&quot;&lt;@/path/to/file/with/your/avatar&gt;\&quot; &#x60;  &#x60;--url &#39;https://your-domain.atlassian.net/rest/api/3/universal_avatar/type/{type}/owner/{entityId}&#39;&#x60;  The avatar is cropped to a square. If no crop parameters are specified, the square originates at the top left of the image. The length of the square&#39;s sides is set to the smaller of the height or width of the image.  The cropped image is then used to create avatars of 16x16, 24x24, 32x32, and 48x48 in size.  After creating the avatar use:   *  [Update issue type](#api-rest-api-3-issuetype-id-put) to set it as the issue type&#39;s displayed avatar.  *  [Set project avatar](#api-rest-api-3-project-projectIdOrKey-avatar-put) to set it as the project&#39;s displayed avatar.  **[Permissions](#permissions) required:** *Administer Jira* [global permission](https://confluence.atlassian.com/x/x4dKLg).
     *
     * @throws IOException
     *          if the Api call fails
     */
    @Test
    public void storeAvatarTest() throws IOException {
        String type = null;
        String entityId = null;
        Integer size = null;
        Object body = null;
        Integer x = null;
        Integer y = null;
        Avatar response = api.storeAvatar(type, entityId, size, body, x, y);

        // TODO: test validations
    }
    
}
