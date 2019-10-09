# Adding Files to Deploy to the Liferay DXP Service

<!-- consider merging this into the 'introduction to the dxp service #deployment' article -->

This article outlines the locations files may be added to in DXP Cloud, for deployment to the Liferay DXP service. All of the types of changes in this article will be included in the CI build that is triggered from GitHub. For more information on how the deployment process starts, see [Overview of the DXP Cloud Deployment Workflow](./06-overview-of-the-dxp-cloud-deployment-workflow.md).

Deploying to your Liferay DXP instance in DXP Cloud normally involves adding the files into the Liferay DXP service directory in your repository. This directory is located in `lcp/liferay/`.

With the exception of the `common/` directory, changes added to a given service's environment folder (`dev`, `uat`, `prod`) will _only_ be propagated when deploying to the corresponding environment. Changes added to the `common/` directory will _always_ be deployed, regardless of the target deployment environment. This applies to the `config`, `deploy`, `license`, and `script` directories within `lcp/liferay/`.

**Contents:**

* [Themes, Portlets, OSGi Modules](#themes-portlets-osgi-modules)
* [Hotfixes](#hotfixes)
* [Licenses](#licenses)
* [Configuration Files](#configuration-files)
* [Hot Deploy](#hot-deploy)

## Themes, Portlets, OSGi Modules

To install themes, portlets, or OSGi modules, include a WAR or JAR file in one of the folders in `/deploy` in your Liferay DXP service directory.

For example, to deploy a custom JAR file to the dev environment (using the `/dev` folder), your Liferay DXP service directory could look like this:

    liferay
    ├── deploy
    │ └── dev
    │   └── com.liferay.apio.samples.portlet-1.0.0.jar
    └── LCP.json

Behind the scenes, JAR files are copied to the `$LIFERAY_HOME/osgi/modules` folder, and WAR files are copied to the `$LIFERAY_HOME/osgi/war` folder. These will be available to the Docker image on startup.

### Deploying Source Code

The source code for new additions can also be included in a CI build. When the build starts, it will automatically compile the source code, and then treat the resulting files as though they were in the correct `deploy` folder.

A CI build will compile source code within these folders:

* The `modules` folder for new modules
* The `themes` folder for custom themes
* The `wars` folder for exploded WARs

> **Note:** source code will only be included in a deployment if it is deployed from a build in CI. 

## Hotfixes

To apply hotfixes, add the hotfix ZIP file to one of the folders in `hotfix/` within the Liferay DXP service directory. When you deploy this change, the hotfix is applied to the Liferay DXP instance.

For example, you can deploy a hotfix to your dev environment with a structure like the following:

    liferay
    ├── hotfix
    │   └── dev
    │       └── liferay-hotfix-2-7110.zip
    └── LCP.json

Note that hotfixes will each need to be re-applied each time the server starts up. For this reason, updating to the latest Fix Pack or Service pack of the Liferay DXP Docker image in your `gradle.properties` file is better than adding many hotfixes into this folder for the long term; you can update the Docker version by replacing the `liferay.workspace.lcp.liferay.image` property in this file. The `gradle.properties` file can be found at the root of the repository.

## Licenses

You can add your own license by putting it into one of the folders in `license/` within the Liferay DXP service directory.

For example, you can add licenses to your `dev` environment with a structure like this in your Liferay DXP service directory:

    liferay
    ├── license
    │ └── dev
    │   └── license.xml
    │   └── license.aatf
    └── LCP.json

Behind the scenes, XML licenses are copied to `$LIFERAY_HOME/deploy`, and AATF licenses are copied to `$LIFERAY_HOME/data`.

## Configuration Files

Configuration files are also added to Liferay DXP by adding them into one of the folders in `config/` within the Liferay DXP service directory.

See [Configuring the Liferay DXP Service](./04-configuring-the-liferay-dxp-service.md) for more information on adding configuration files.

## Hot Deploy

Hot deploy can be done via the Liferay DXP UI. To do so, navigate to the Control Panel → Apps → App Manager. Then, click the dots in the upper-right corner, and click "Upload." From this screen, you can choose a file from your local file system to deploy and install.

> **Note:** using hot deploy in DXP Cloud is _not_ recommended because any customizations deployed with this method will be lost upon a subsequent DXP service deployment.

## Additional Information

* [Configuring the Liferay DXP Service](./04-configuring-the-liferay-dxp-service.md)
* [Liferay DXP Service](./01-intro.md)
* [Overview of the DXP Cloud Deployment Workflow](./06-overview-of-the-dxp-cloud-deployment-workflow.md)
