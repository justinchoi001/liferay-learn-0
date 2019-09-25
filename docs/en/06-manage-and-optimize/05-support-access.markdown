---
header-id: support-access
---

# Support Access

Support Access is an _optional_ setting for a DXP project that allows Liferay Engineers to directly access a project to expedite project troubleshooting. DXP Cloud administrators are able to enable and disable access per environment. By default, this feature is set to _Enabled_.

When Support Access is enabled, Support Engineers are able to _read_ the following information:

* Project Console
* Logs for each service
* Control Panel Settings
* DXP Cloud Region where the services are hosted
* Team Members and their associated roles
* Members' Activities

Note that only the project administrator has the ability to configure support access. Support Access does _not_ allow Support Engineers to deploy assets or perform other _write_ actions to your project.

To manage Support Access:

1. Navigate to _Settings_.

![Contributor Access](./support-access/images/01.png)

1. Switch the toggle to _Enabled_.

_Support access_ has been enabled. Changes to the settings such as enabling or disabling support access are logged as an activity. To review the changes:

1. Navigate to _Activities_.
1. Verify the site's Support access is disabled.

    ![Disabled Support Access](./support-access/images/02.png)

1. Furthermore, an email is sent to all members in the group.

    ![Email verification](./support-access/images/03.png)
