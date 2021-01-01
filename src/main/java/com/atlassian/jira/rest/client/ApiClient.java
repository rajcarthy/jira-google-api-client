package com.atlassian.jira.rest.client;

import com.atlassian.jira.rest.client.api.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.openapitools.jackson.nullable.JsonNullableModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.threetenbp.ThreeTenModule;
import org.threeten.bp.*;
import com.google.api.client.googleapis.util.Utils;
import com.google.api.client.http.AbstractHttpContent;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.Json;

import java.io.IOException;
import java.io.OutputStream;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2020-12-31T17:44:39.790417-08:00[America/Los_Angeles]")
public class ApiClient {
    private final String basePath;
    private final HttpRequestFactory httpRequestFactory;
    private final ObjectMapper objectMapper;

    private static final String defaultBasePath = "https://your-domain.atlassian.com";

    // A reasonable default object mapper. Client can pass in a chosen ObjectMapper anyway, this is just for reasonable defaults.
    private static ObjectMapper createDefaultObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper()
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .setDateFormat(new RFC3339DateFormat());
        objectMapper.registerModule(new JavaTimeModule());
        ThreeTenModule module = new ThreeTenModule();
        module.addDeserializer(Instant.class, CustomInstantDeserializer.INSTANT);
        module.addDeserializer(OffsetDateTime.class, CustomInstantDeserializer.OFFSET_DATE_TIME);
        module.addDeserializer(ZonedDateTime.class, CustomInstantDeserializer.ZONED_DATE_TIME);
        objectMapper.registerModule(module);
        JsonNullableModule jnm = new JsonNullableModule();
        objectMapper.registerModule(jnm);
        return objectMapper;
    }

    public ApiClient() {
        this(null, null, null, null);
    }

    public ApiClient(
        String basePath,
        HttpTransport httpTransport,
        HttpRequestInitializer initializer,
        ObjectMapper objectMapper
    ) {
        this.basePath = basePath == null ? defaultBasePath : (
            basePath.endsWith("/") ? basePath.substring(0, basePath.length() - 1) : basePath
        );
        this.httpRequestFactory = (httpTransport == null ? Utils.getDefaultTransport() : httpTransport).createRequestFactory(initializer);
        this.objectMapper = (objectMapper == null ? createDefaultObjectMapper() : objectMapper);
    }

    public HttpRequestFactory getHttpRequestFactory() {
        return httpRequestFactory;
    }

    public String getBasePath() {
        return basePath;
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public class JacksonJsonHttpContent extends AbstractHttpContent {
        /* A POJO that can be serialized with a com.fasterxml Jackson ObjectMapper */
        private final Object data;

        public JacksonJsonHttpContent(Object data) {
            super(Json.MEDIA_TYPE);
            this.data = data;
        }

        @Override
        public void writeTo(OutputStream out) throws IOException {
            objectMapper.writeValue(out, data);
        }
    }

    // Builder pattern to get API instances for this client.
    
    public AppPropertiesApi appPropertiesApi() {
        return new AppPropertiesApi(this);
    }
    
    public ApplicationRolesApi applicationRolesApi() {
        return new ApplicationRolesApi(this);
    }
    
    public AuditRecordsApi auditRecordsApi() {
        return new AuditRecordsApi(this);
    }
    
    public AvatarsApi avatarsApi() {
        return new AvatarsApi(this);
    }
    
    public DashboardsApi dashboardsApi() {
        return new DashboardsApi(this);
    }
    
    public DynamicModulesApi dynamicModulesApi() {
        return new DynamicModulesApi(this);
    }
    
    public FilterSharingApi filterSharingApi() {
        return new FilterSharingApi(this);
    }
    
    public FiltersApi filtersApi() {
        return new FiltersApi(this);
    }
    
    public GroupAndUserPickerApi groupAndUserPickerApi() {
        return new GroupAndUserPickerApi(this);
    }
    
    public GroupsApi groupsApi() {
        return new GroupsApi(this);
    }
    
    public IssueAttachmentsApi issueAttachmentsApi() {
        return new IssueAttachmentsApi(this);
    }
    
    public IssueCommentPropertiesApi issueCommentPropertiesApi() {
        return new IssueCommentPropertiesApi(this);
    }
    
    public IssueCommentsApi issueCommentsApi() {
        return new IssueCommentsApi(this);
    }
    
    public IssueCustomFieldContextsApi issueCustomFieldContextsApi() {
        return new IssueCustomFieldContextsApi(this);
    }
    
    public IssueCustomFieldOptionsApi issueCustomFieldOptionsApi() {
        return new IssueCustomFieldOptionsApi(this);
    }
    
    public IssueCustomFieldOptionsAppsApi issueCustomFieldOptionsAppsApi() {
        return new IssueCustomFieldOptionsAppsApi(this);
    }
    
    public IssueFieldConfigurationsApi issueFieldConfigurationsApi() {
        return new IssueFieldConfigurationsApi(this);
    }
    
    public IssueFieldsApi issueFieldsApi() {
        return new IssueFieldsApi(this);
    }
    
    public IssueLinkTypesApi issueLinkTypesApi() {
        return new IssueLinkTypesApi(this);
    }
    
    public IssueLinksApi issueLinksApi() {
        return new IssueLinksApi(this);
    }
    
    public IssueNavigatorSettingsApi issueNavigatorSettingsApi() {
        return new IssueNavigatorSettingsApi(this);
    }
    
    public IssueNotificationSchemesApi issueNotificationSchemesApi() {
        return new IssueNotificationSchemesApi(this);
    }
    
    public IssuePrioritiesApi issuePrioritiesApi() {
        return new IssuePrioritiesApi(this);
    }
    
    public IssuePropertiesApi issuePropertiesApi() {
        return new IssuePropertiesApi(this);
    }
    
    public IssueRemoteLinksApi issueRemoteLinksApi() {
        return new IssueRemoteLinksApi(this);
    }
    
    public IssueResolutionsApi issueResolutionsApi() {
        return new IssueResolutionsApi(this);
    }
    
    public IssueSearchApi issueSearchApi() {
        return new IssueSearchApi(this);
    }
    
    public IssueSecurityLevelApi issueSecurityLevelApi() {
        return new IssueSecurityLevelApi(this);
    }
    
    public IssueSecuritySchemesApi issueSecuritySchemesApi() {
        return new IssueSecuritySchemesApi(this);
    }
    
    public IssueTypePropertiesApi issueTypePropertiesApi() {
        return new IssueTypePropertiesApi(this);
    }
    
    public IssueTypeSchemesApi issueTypeSchemesApi() {
        return new IssueTypeSchemesApi(this);
    }
    
    public IssueTypeScreenSchemesApi issueTypeScreenSchemesApi() {
        return new IssueTypeScreenSchemesApi(this);
    }
    
    public IssueTypesApi issueTypesApi() {
        return new IssueTypesApi(this);
    }
    
    public IssueVotesApi issueVotesApi() {
        return new IssueVotesApi(this);
    }
    
    public IssueWatchersApi issueWatchersApi() {
        return new IssueWatchersApi(this);
    }
    
    public IssueWorklogPropertiesApi issueWorklogPropertiesApi() {
        return new IssueWorklogPropertiesApi(this);
    }
    
    public IssueWorklogsApi issueWorklogsApi() {
        return new IssueWorklogsApi(this);
    }
    
    public IssuesApi issuesApi() {
        return new IssuesApi(this);
    }
    
    public JiraExpressionsApi jiraExpressionsApi() {
        return new JiraExpressionsApi(this);
    }
    
    public JiraSettingsApi jiraSettingsApi() {
        return new JiraSettingsApi(this);
    }
    
    public JqlApi jqlApi() {
        return new JqlApi(this);
    }
    
    public LabelsApi labelsApi() {
        return new LabelsApi(this);
    }
    
    public MyselfApi myselfApi() {
        return new MyselfApi(this);
    }
    
    public PermissionSchemesApi permissionSchemesApi() {
        return new PermissionSchemesApi(this);
    }
    
    public PermissionsApi permissionsApi() {
        return new PermissionsApi(this);
    }
    
    public ProjectAvatarsApi projectAvatarsApi() {
        return new ProjectAvatarsApi(this);
    }
    
    public ProjectCategoriesApi projectCategoriesApi() {
        return new ProjectCategoriesApi(this);
    }
    
    public ProjectComponentsApi projectComponentsApi() {
        return new ProjectComponentsApi(this);
    }
    
    public ProjectEmailApi projectEmailApi() {
        return new ProjectEmailApi(this);
    }
    
    public ProjectKeyAndNameValidationApi projectKeyAndNameValidationApi() {
        return new ProjectKeyAndNameValidationApi(this);
    }
    
    public ProjectPermissionSchemesApi projectPermissionSchemesApi() {
        return new ProjectPermissionSchemesApi(this);
    }
    
    public ProjectPropertiesApi projectPropertiesApi() {
        return new ProjectPropertiesApi(this);
    }
    
    public ProjectRoleActorsApi projectRoleActorsApi() {
        return new ProjectRoleActorsApi(this);
    }
    
    public ProjectRolesApi projectRolesApi() {
        return new ProjectRolesApi(this);
    }
    
    public ProjectTypesApi projectTypesApi() {
        return new ProjectTypesApi(this);
    }
    
    public ProjectVersionsApi projectVersionsApi() {
        return new ProjectVersionsApi(this);
    }
    
    public ProjectsApi projectsApi() {
        return new ProjectsApi(this);
    }
    
    public ScreenSchemesApi screenSchemesApi() {
        return new ScreenSchemesApi(this);
    }
    
    public ScreenTabFieldsApi screenTabFieldsApi() {
        return new ScreenTabFieldsApi(this);
    }
    
    public ScreenTabsApi screenTabsApi() {
        return new ScreenTabsApi(this);
    }
    
    public ScreensApi screensApi() {
        return new ScreensApi(this);
    }
    
    public ServerInfoApi serverInfoApi() {
        return new ServerInfoApi(this);
    }
    
    public TasksApi tasksApi() {
        return new TasksApi(this);
    }
    
    public TimeTrackingApi timeTrackingApi() {
        return new TimeTrackingApi(this);
    }
    
    public UserPropertiesApi userPropertiesApi() {
        return new UserPropertiesApi(this);
    }
    
    public UserSearchApi userSearchApi() {
        return new UserSearchApi(this);
    }
    
    public UsersApi usersApi() {
        return new UsersApi(this);
    }
    
    public WebhooksApi webhooksApi() {
        return new WebhooksApi(this);
    }
    
    public WorkflowSchemeDraftsApi workflowSchemeDraftsApi() {
        return new WorkflowSchemeDraftsApi(this);
    }
    
    public WorkflowSchemeProjectAssociationsApi workflowSchemeProjectAssociationsApi() {
        return new WorkflowSchemeProjectAssociationsApi(this);
    }
    
    public WorkflowSchemesApi workflowSchemesApi() {
        return new WorkflowSchemesApi(this);
    }
    
    public WorkflowStatusCategoriesApi workflowStatusCategoriesApi() {
        return new WorkflowStatusCategoriesApi(this);
    }
    
    public WorkflowStatusesApi workflowStatusesApi() {
        return new WorkflowStatusesApi(this);
    }
    
    public WorkflowTransitionPropertiesApi workflowTransitionPropertiesApi() {
        return new WorkflowTransitionPropertiesApi(this);
    }
    
    public WorkflowTransitionRulesApi workflowTransitionRulesApi() {
        return new WorkflowTransitionRulesApi(this);
    }
    
    public WorkflowsApi workflowsApi() {
        return new WorkflowsApi(this);
    }
    
}
