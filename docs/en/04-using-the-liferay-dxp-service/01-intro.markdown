---
header-id: using-the-liferay-dxp-service
---

# Liferay DXP Service

The Liferay DXP service is the heartbeat of any project. It runs the application's Liferay DXP instance and interacts with other services like the web server, Elasticsearch, and MySQL database.

![Figure 1: The Liferay DXP service is one of several services available in DXP Cloud.](../../images/services-dxp.png)

## Deployment

To install themes, portlets, or OSGi modules, place a WAR or JAR file in the `/deploy/common` folder. For example, to deploy a custom JAR file, the Liferay DXP source code directory could look like this:

    liferay
    ├── deploy
    │ └── common
    │   └── com.liferay.apio.samples.portlet-1.0.0.jar
    └── LCP.json

On the DXP Service, such files are copied to the `$LIFERAY_HOME/deploy` folder and deployed on startup.

## Licenses

It is possible to add a separate license by creating a license folder:

    liferay
    ├── license
    │ └── license.xml
    │ └── license.aatf
    └── LCP.json

XML licenses are copied to `$LIFERAY_HOME/deploy` and AATF licenses are copied to `$LIFERAY_HOME/data`.

## Hot Deploy

Using hot deploy in DXP Cloud is not recommended. If you still want to use hot deploy, you can do so via the Liferay DXP UI.

## Configurations

To launch new property or OSGI configurations, use the `config` folder as an extension point. This extension point supports `.cfg`, `.properties`, and `.config` files.

For example, to deploy a configuration for the Elasticsearch OSGi bundle, your folder structure could look like this:

    liferay
    ├── config
    │ └── com.liferay.portal.search.elasticsearch6.configuration.ElasticsearchConfiguration.config
    └── LCP.json

All files are copied to the `$LIFERAY_HOME` folder and automatically applied on startup.

## Portal Properties

There is also a set of files used to configure the environment. The portal reads these files in the following order:

`portal-all.properties`: Contains the properties that change Liferay DXP across environments.

`portal-env.properties`: Contains the properties that only affect the current environment (for example, credentials and URL endpoints for external services that differ from environment to environment).

`portal-clu.properties`: Contains the pre-configured properties for clustering Liferay DXP on DXP Cloud. See the [Clustering section](#clustering) for more information.

`portal-ext.properties`: Contains the final changes to the Liferay DXP configuration. Since most properties are configured in `portal-all.properties` and `portal-env.properties`, this file is typically empty or missing altogether. It may still be useful for testing purposes.

Note that portal properties can be defined as environment variables; see [DXP Environment Variables](https://help.liferay.com/hc/en-us/articles/360017877312-Environment-Variables).

Example:

Name                                  | Default Value | Description  |
------------------------------------- | ------------- | ------------ |
| `LCP_PROJECT_LIFERAY_CLUSTER_ENABLED` | `false`       | Whether to enable clustering and communication between nodes. |

This is then expressed as the following in the `LCP.json` file:

```properties
"env": {
    "LCP_PROJECT_LIFERAY_CLUSTER_ENABLED": "true"
  },
```

## Clustering

Clustering Liferay DXP on DXP Cloud is straightforward. Follow these steps to enable clustering:

1. Set the environment variable `LCP_PROJECT_LIFERAY_CLUSTER_ENABLED` to `true`. This instructs the image startup process to add the clustering configuration to Liferay DXP.

1. Increase the scale in `LCP.json` to the desired number of nodes.

Behind the scenes, the image startup process copies the files `portal-clu.properties` and `unicast.xml` to the Liferay Home folder. These files contain the configuration needed to run a Liferay DXP cluster on DXP Cloud.

### Verify that Clustering is Working

To check if clustering is working correctly, check the logs of the Liferay DXP instances for the `Accepted View` message from the `JGroupsReceiver` class.
Here is an example:

```shell
Aug 26 09:42:22.778 build-90 [liferay-68b8f6b48d-hdj9t] [dxp] INFO  [Incoming-2,liferay-channel-transport-0,liferay-68b8f6b48d-hdj9t-23003][JGroupsReceiver:91] Accepted view [liferay-68b8f6b48d-r8r5f-1292|8] (3) [liferay-68b8f6b48d-r8r5f-1292, liferay-68b8f6b48d-gzsg4-15389, liferay-68b8f6b48d-hdj9t-23003]
Aug 26 09:42:22.779 build-90 [liferay-68b8f6b48d-hdj9t] [dxp] INFO  [Incoming-1,liferay-channel-control,liferay-68b8f6b48d-hdj9t-17435][JGroupsReceiver:91] Accepted view [liferay-68b8f6b48d-r8r5f-29669|8] (3) [liferay-68b8f6b48d-r8r5f-29669, liferay-68b8f6b48d-gzsg4-48301, liferay-68b8f6b48d-hdj9t-17435]
```

Here is a description of these example logs:

- `Accepted view [liferay-68b8f6b48d-r8r5f-1292|8]` indicates that `liferay-68b8f6b48d-r8r5f-1292` is the master node.
- `(3) [liferay-68b8f6b48d-r8r5f-29669, liferay-68b8f6b48d-gzsg4-48301, liferay-68b8f6b48d-hdj9t-17435]` indicates that `(3)` nodes are part of the cluster as well as the IDs of the nodes. This list includes the master node in addition to the slave nodes.

### Clustering and Auto-scaling

Auto-scaling works together with the `scale` attribute in `LCP.json`. Use `scale` to set the initial number of instances. If auto-scaling is enabled, the number of instances will increase according to demand.

## Hotfixes

To apply hotfixes, add the hotfix ZIP file to the `hotfix` folder. Use the following folder structure:

    liferay
    ├── hotfix
    │ └── liferay-hotfix-2-7110.zip
    └── LCP.json

## Scripts

Scripts may be used for more extensive customizations. However, use caution when doing so. This is the most powerful way to customize Liferay DXP and can cause undesired side effects.

Any `.sh` files found in the `script` folder are run prior to starting a service. For example, to include a script that removes all log files, place it in the following directory structure:

    liferay
    ├── script
    │ └── remove-log-files.sh
    └── LCP.json
