---
header-id: using-the-liferay-dxp-service
---

# Liferay DXP Service

The Liferay DXP service is the heartbeat of any project. It runs the application's Liferay DXP instance and interacts with other services like the web server, Elasticsearch, and MySQL database.

![Figure 1: The Liferay DXP service is one of several services available in DXP Cloud.](../../images/services-dxp.png)

The Liferay DXP service in DXP Cloud can be used in many of the same ways as an on-site instance of Liferay DXP. However, there are also several ways in which developers will need to take different steps when working with an instance in DXP Cloud.

**Here are some major differences when using the Liferay DXP service:**

* [Choosing a version](#choosing-a-version)
* [Deployment](#deployment)
* [Configuration](#configuration)
* [Enabling clustering](#enabling-clustering)
* [Environment variables](#environment-variables)
* [Running scripts](#running-scripts)

## Choosing a Version

The version of Liferay DXP that you are using is configured within the `gradle.properties` file at the root of your Git repository. This version includes the specific service pack and fix pack that your Liferay DXP instance will be based on.

You can check the [release notes](https://help.liferay.com/hc/en-us/categories/360001192512) for DXP Cloud to see a reference for each new release. Each new release includes Docker images that you can use for your instance.

Use the new version from the release notes to replace the `liferay.workspace.lcp.liferay.image` property. The new Docker image will be used when your instance starts up the next time you deploy the Liferay service from your repository. You can also use the Docker images for new releases to upgrade the properties for your other services.

> **Note:** if any `LCP.json` files in your repository directly reference the Docker image for a version of Liferay, then these will need to be updated as well when upgrading to a new Docker image.

## Deployment

Deploying custom additions to Liferay DXP (such as new modules, licenses, or hotfixes) involves adding these to specific locations in the Git repository, and then pushing these changes to Git. See [Overview of the Deployment Workflow](./06-overview-of-the-deployment-workflow.md) for more information on how this works, and see [Deploying to the Liferay DXP Service](./04-deploying-to-the-liferay-dxp-service.md) for more information on the types of files you can deploy.

## Configuration

Liferay DXP can still be configured through the UI, as with an on-site instance. However, using configuration files within the Liferay DXP bundle involves adding them within the Git repository and pushing the changes to Git, the same way as deploying other kinds of changes. For more information on adding these configuration files, see [Configuring the Liferay DXP Service](./04-configuring-the-liferay-dxp-service.md).

## Enabling Clustering

Clustering Liferay DXP in DXP Cloud is a very simplified process compared to doing so in Liferay DXP. Support for clustering is available out-of-the-box in DXP Cloud, although enabling it takes a couple of extra steps. See [Setting Up Clustering in DXP Cloud](./05-setting-up-clustering-in-dxp-cloud.md) for more information.

## Environment Variables

Name                                  | Default Value | Description  |
------------------------------------- | ------------- | ------------ |
`LCP_PROJECT_LIFERAY_CLUSTER_ENABLED` | `false`       | Whether to enable clustering and communication between nodes. |
`LCP_PROJECT_MONITOR_DYNATRACE_TENANT` |               | A string with eight characters. It's part of the URL (prefix) of your Dynatrace SaaS account. |
`LCP_PROJECT_MONITOR_DYNATRACE_TOKEN` |               | A string with 22 characters that you can find in your Dynatrace account at *Deploy Dynatrace* &rarr; *Start installation* &rarr; *Set up PaaS monitoring* &rarr; *Installer Download*. |
`LIFERAY_JAVA_OPTS` | | JVM options that will be appended to `CATALINA_OPTS` to override the default recommended options. |

## Scripts

Any `.sh` files found in the `script` folder are automatically run prior to starting the service. Scripts may be used for more extensive customizations. However, use caution when doing so. This is the most powerful way to customize Liferay DXP and it can cause undesired side effects.

For example, to include a script that removes all log files, place it in the following directory structure within the project's Git repository:

    lcp
    └──liferay
        ├── script
        │ └── remove-log-files.sh
        └── LCP.json
