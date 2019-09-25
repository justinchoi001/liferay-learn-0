# Migrating from an On-Premises DXP Installation

This article will walk you through the essential steps for migrating your existing Liferay DXP instance to DXP Cloud.

The following steps are essential for migrating an existing installation of Liferay DXP:

1. [Migrate the Database and Document Library](#migrate-the-database-and-document-library)
1. [Copy Liferay DXP Configurations](#copy-liferay-dxp-configurations)
1. [Add Service Configurations](#add-service-configurations)
1. [Use a VPN to Connect External Services](#use-a-vpn-to-connect-external-services)

## Migrate the Database and Document Library

The most important part of the process in migrating to DXP Cloud is importing the database and document library. Both the database and document library must be imported at the same time to ensure that the data and the records in the database remain synchronized.

This step should be done when the database is not being updated in order to prevent losing data. This will normally require reserving a window to freeze the data for migration.

### Export a Database Dump

Begin by exporting the data to a database dump. The export from MySQL can be accomplished using the following command:

```bash
mysqldump -uroot -ppassword --databases --add-drop-database lportal | tar -czvf database.tgz
```

> The `databases` and `add-drop-database` options are necessary for backup restoration to work correctly.

Database dumps imported into DXP Cloud must be in MySQL format for the database service to use it. If necessary, a tool like [DBeaver](http://dbeaver.io) can be used to convert other types of databases to MySQL for the import.

### Zip Up the Document Library

The document library must also be zipped into a file to upload to the backup service.

Add the document library to a zip file with this command:

```bash
cd $LIFERAY_HOME/data && tar -czvf volume.tgz document_library
```

### Invoke Backup Service API

Once you have the database dump and document library both zipped and ready, invoke the backup service API to upload both of them to the backup service simultaneously.

Run this command to invoke the API and upload the zipped files:

```bash
curl -X POST /
  http://<HOST-NAME>/backup/upload /
  -H 'Content-Type: multipart/form-data' /
  -F 'database=@/my-folder/database.tgz' /
  -F 'volume=@/my-folder/volume.tgz' /
  -u user@domain.com:password
```

Once these are uploaded, the backup service can initialize a backup with the necessary data. At this point, the biggest step of the migration into DXP Cloud is complete.

## Copy Liferay DXP Configurations

Portal properties and OSGi configurations can be copied over to DXP Cloud by putting them into the appropriate folder per environment (`dev`, `uat`, or `prd`, or `common` to apply to all) inside of `lcp/liferay/config/`.

Any portal properties of the form `portal-*.properties` placed in one of the appropriate folders will be automatically copied over to the `$LIFERAY_HOME` within the Liferay service for the applicable service(s). OSGi properties (.cfg or .config files) will instead be copied over to the `osgi/configs` folder within the Liferay service.

## Add Service Configurations

Remaining configurations will primarily be handled through the services provided in DXP Cloud. It may take some planning to determine how to translate web server and search configurations, since these configurations must all now be done through the services DXP Cloud is using.

Web server configurations will be done through webserver service, using Nginx. See [Web Server Service]() for more information on adding configurations to this service; see the [official Nginx documentation](https://docs.nginx.com/) for more information on the configurations themselves.

Search configurations will be done through the search service, using Elasticsearch. See [Search Service]() for more information on adding configurations to this service; see the [official Elasticsearch documentation](https://www.elastic.co/guide/index.html) for more information on the configurations themselves.

## Use a VPN to Connect External Services

External services that do not readily map to the existing services in DXP Cloud (like SSO or LDAP integrations) may be connected using a VPN. This feature is built-in to DXP Cloud, and it will allow you to set up communication with external infrastructure. See [VPN Connection]() for more information on configuring the VPN.