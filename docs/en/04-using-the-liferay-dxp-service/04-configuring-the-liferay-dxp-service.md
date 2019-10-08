# Configuring the Liferay DXP Service

Configuration files for your Liferay DXP instance in DXP Cloud are placed inside of one of the `config` folders in the Liferay DXP service directory in your repository.

	lcp
	└── liferay
    	├── LCP.json
    	└── config
        	├── common
        	├── dev
        	├── local
        	├── prd
        	└── uat

With the exception of the `common/` directory, changes added to a given service's environment folder (`dev`, `uat`, `prod`) will _only_ be propagated when deploying to the corresponding environment. Changes added to the `common/` directory will _always_ be deployed, regardless of the target deployment environment. This applies to the `config`, `deploy`, `license`, and `script` directories within `lcp/liferay/`.

## Portal Properties

Portal properties are files of the form `portal-*.properties` that are used to configure your Liferay DXP environment.

In an on-site Liferay DXP instance, these files belong inside of `$LIFERAY_HOME`. When using Liferay DXP Cloud, place these files into the appropriate `config` folder(s) for them to be copied into `$LIFERAY_HOME` for the Liferay DXP instance on deployment.

These are the types of portal properties files you may use in one of the `config` folders:

* `portal-all.properties`: Contains the properties that change Liferay DXP across environments

* `portal-env.properties`: Contains the properties that only affect the current environment (for example, credentials and URL endpoints for external services that differ from environment to environment)

* `portal-clu.properties`: Contains the pre-configured properties for clustering Liferay DXP on DXP Cloud; see [Setting Up Clustering in DXP Cloud](./05-setting-up-clustering-in-dxp-cloud.md) for more information

* `portal-ext.properties`: Contains the final changes to the Liferay DXP configuration; since most properties are configured in `portal-all.properties` and `portal-env.properties`, this file is often empty or missing altogether

Note that portal properties can also be defined as environment variables. See [the environment variables reference](./01-intro.md#environment-variables) for more information.

## OSGi Configurations

OSGi configurations (`.cfg` or `.config` files) are used to configure OSGi components in Liferay DXP.

In an on-site Liferay DXP instance, these files belong in the `/osgi/configs` folder inside of `$LIFERAY_HOME`. When using Liferay DXP Cloud, place these files into the appropriate `config` folder(s) for them to be copied into `/osgi/configs` for the Liferay DXP instance on deployment.

## Additional Information

* [Adding Files to Deploy to the Liferay DXP Service](./03-adding-files-to-deploy-to-the-liferay-dxp-service.md)
* [Liferay DXP Service](./01-intro.md)
* [Enabling Clustering in DXP Cloud](./05-setting-up-clustering-in-dxp-cloud.md)
* [Documentation on DXP Portal properties link out to dxp docs]()