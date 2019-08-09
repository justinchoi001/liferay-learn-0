# Deploying Liferay Commerce to an Existing Liferay Installation

This article documents how to deploy Liferay Commerce to an existing Liferay DXP instance. Because Liferay Commerce is built on Liferay DXP, it is necessary to have an existing DXP 7.1 or DXP 7.2 instance running. For subscribers on Liferay DXP 7.1, it requires Fix Pack 11 or higher, or Liferay Portal 7.1 CE GA4.

To begin using Liferay Commerce:

1. Download the latest `LPKG`.
    * Enterprise subscribers can download the latest `LPKG` from [Help Center](https://customer.liferay.com/downloads?p_p_id=com_liferay_osb_customer_downloads_display_web_DownloadsDisplayPortlet&_com_liferay_osb_customer_downloads_display_web_DownloadsDisplayPortlet_productAssetCategoryId=118190997&_com_liferay_osb_customer_downloads_display_web_DownloadsDisplayPortlet_fileTypeAssetCategoryId=118191001).
    * In addition to the `LPKG` file, subscribers also need an order number that includes Liferay Commerce or an `.xml` activation key.
    * The latest open source `LPKG` is available from [Liferay Commerce Download](https://commerce.liferay.dev/download).

1. Deploy the `LPKG` to the `${Liferay.home}/deploy` folder.
1. Deploy the activation key to the `${Liferay.home}/deploy` folder (Subscribers only).
1. There is an `INFO` message in the console that states the instance needs to be restarted:

`2019-08-09 00:25:10.662 INFO  [fileinstall-/../../liferay-dxp-7.1.10.1-sp1/osgi/marketplace][LPKGArtifactInstaller:202] The portal instance needs to be restarted to complete the installation of file:/../../liferay-dxp-7.1.10.1-sp1/osgi/marketplace/Liferay%20Commerce%20-%20API.lpkg`
`2019-08-09 00:25:10.664 INFO  [fileinstall-/../..//liferay-dxp-7.1.10.1-sp1/osgi/marketplace][LPKGArtifactInstaller:202] The portal instance needs to be restarted to complete the installation of file:/C:/Users/Liferay/dwarves/bombur/liferay-dxp-7.1.10.1-sp1/osgi/marketplace/Liferay%20Commerce%20-%20Impl.lpkg`

1. Shut down the application server completely.
1. Start the application server.
1. To verify that the `LPKG` has begun installation, look for this message:

`2019-08-09 00:32:48.850 INFO  [main][BaseDeployer:877] Deploying minium-theme.war`

1. On the **first** deployment, there is a series of `VerifyProcess` commands followed by this message:

`2019-08-09 00:34:51.753 INFO  [main][ThemeHotDeployListener:108] 1 theme for minium-theme is available for use`.

The `LPKG` has been deployed and ready for use. Store administrators can begin building a storefront and populating their catalog.

## Additional Information

Note that if the application server is restarted, Liferay Commerce will not execute the `VerifyProcess` commands a second time.

* [System Requirements]()
* [Installation Overview]()
* [Installing the Commerce Bundle]()
* [Deploying to Liferay DXP Cloud]()
* [Deployment and Managing Addons]()

### Upgrades and Updates

* [Upgrading from 1.1.x]()
* [Maintenance Versions]()
* [Fixes and Updates]()
* [Migration: From Open Source to Subscription]()