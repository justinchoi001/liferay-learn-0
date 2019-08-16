# Using Liferay Commerce on a Bundle

Liferay Commerce is available as an open source bundle which is available for download from the [Liferay Commerce Community](https://commerce.liferay.dev/download) page. The bundle contains the latest version of Liferay Commerce built on Liferay Portal CE 7.1 GA4 and uses Apache Tomcat 9 as the application server.

Before obtaining the bundle, read the [Liferay Commerce Compatibility Matrix](https://web.liferay.com/documents/14/21598941/Liferay+Commerce+2.0+Compatibility+Matrix/0ed97477-f5a7-40a6-b5ab-f00d5e01b75f) for a list of supported technologies.

Verify that the following environments are supported:

1. Operating System
1. Database*
1. JDKs
1. Deskotp Browsers
1. Mobile Browsers
1. Cloud Services
1. Search Engines

Download the zipped bundle to a specified location. Once unzipped, this folder becomes the `${liferay.home}` folder. For more information about this folder, see [Liferay Home](https://help.liferay.com/hc/en-us/articles/360028712272-Liferay-Home).

Start Tomcat by navigating to `$CATALINA_HOME/bin` and executing `./startup.sh`. Alternatively, execute `./catalina.sh run`.

Verify the following in the console:

    2019-08-09 18:09:38.482 INFO  [main][BundleStartStopLogger:39] STARTED minium-theme_2.0.7 [2149]
    2019-08-09 18:10:26.501 INFO  [main][VerifyProcess:65] Verifying com.liferay.commerce.product.internal.verify.CommerceCatalogServiceVerifyProcess
    2019-08-09 18:10:26.512 INFO  [main][LoggingTimer:83] Starting com.liferay.commerce.product.internal.verify.CommerceCatalogServiceVerifyProcess#verifyMasterCommerceCatalog
    2019-08-09 18:10:26.515 INFO  [main][LoggingTimer:43] Completed com.liferay.commerce.product.internal.verify.CommerceCatalogServiceVerifyProcess#verifyMasterCommerceCatalog in 2 ms
    2019-08-09 18:10:26.515 INFO  [main][VerifyProcess:80] Completed verification process com.liferay.commerce.product.internal.verify.CommerceCatalogServiceVerifyProcess in 14 ms
    2019-08-09 18:10:26.522 INFO  [main][VerifyProcess:65] Verifying com.liferay.commerce.account.internal.verify.CommerceAccountServiceVerifyProcess
    2019-08-09 18:10:26.524 INFO  [main][LoggingTimer:83] Starting com.liferay.commerce.account.internal.verify.CommerceAccountServiceVerifyProcess#verifyAccountRoles
    2019-08-09 18:10:26.616 INFO  [main][LoggingTimer:43] Completed com.liferay.commerce.account.internal.verify.CommerceAccountServiceVerifyProcess#verifyAccountRoles in 92 ms
    2019-08-09 18:10:26.618 INFO  [main][LoggingTimer:83] Starting com.liferay.commerce.account.internal.verify.CommerceAccountServiceVerifyProcess#verifyAccountGroup
    2019-08-09 18:10:26.620 INFO  [main][LoggingTimer:43] Completed com.liferay.commerce.account.internal.verify.CommerceAccountServiceVerifyProcess#verifyAccountGroup in 2 ms
    2019-08-09 18:10:26.620 INFO  [main][VerifyProcess:80] Completed verification process com.liferay.commerce.account.internal.verify.CommerceAccountServiceVerifyProcess in 98 ms
    2019-08-09 18:10:55.764 INFO  [main][ThemeHotDeployListener:108] 1 theme for classic-theme is available for use
    2019-08-09 18:10:56.612 INFO  [main][ThemeHotDeployListener:108] 1 theme for admin-theme is available for use
    2019-08-09 18:11:04.302 INFO  [main][ThemeHotDeployListener:108] 1 theme for minium-theme is available for use

The Liferay Commerce bundle has started and is ready for use.

## Additional Information

* \*Note that bundle contains HSQL; do not use HSQL in a production environment.
* [Installing Liferay DXP on Tomcat](https://help.liferay.com/hc/en-us/articles/360017896692-Installing-Liferay-DXP-on-Tomcat)