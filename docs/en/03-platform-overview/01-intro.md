---
header-id: platform-overview
---

# Services

DXP Cloud contains several built-in services that provide its functionality and help customers manage their projects. Each service can be customized to fit each project's needs.

## Available Services

**Backup Service:** Creates regular backups of the Liferay DXP database and Document Library.

**Liferay DXP Service:** Runs the Liferay DXP instance.

**Web Server Service:** Handles all traffic from users and acts as a high-performance web server.

**Database Service:** Provides a distributed relational database service that simplifies the setup, operation, and scaling of the applications.

**Search Service:** Provides the full-text search engine for the Liferay DXP application.

## Updating Service Images

Check the [services changelog](https://help.liferay.com/hc/en-us/categories/360001192512-Liferay-DXP-Cloud-Announcements) frequently to make sure the project is using the most up-to-date service images. All Liferay DXP Cloud images are hosted at [https://hub.docker.com/u/liferaycloud](https://hub.docker.com/u/liferaycloud).

After finding the latest images, update the DXP Cloud workspace's `gradle.properties`.

Several services use third-party images as a foundation (e.g., Elasticsearch, NGINX, and Jenkins). Although these images get regular updates from their maintainers, Liferay updates only the corresponding service when necessary for a feature or security. This ensures stability. To update an image's version, [open a ticket with our Support team](https://liferay-support.zendesk.com) and we will review all requests. The [services changelog](https://help.liferay.com/hc/en-us/categories/360001192512-Liferay-DXP-Cloud-Announcements) lists any related image updates.
