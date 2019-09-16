---
header-id: support-access
---

# Support Access

In order to resolve a customer's issues quickly, it might be necessary to allow Liferay Customer Support Engineers to access the environment directly. DXP Cloud administrators are able to enable and disable access to a specific environment. Note that by default, this feature is set to _Enabled_.

When Support Access is enabled, the support engineer is able to view the following:

* Project Console
* Logs for each service
* Control Panel Settings
* DXP Cloud Region where the services are hosted
* Team Members and their associated roles
* Members' Activities

Note that only the administrator has the ability to grant or deny support access. If granted access, Support Engineers will _not_ be able to deploy assets or perform other actions.

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
