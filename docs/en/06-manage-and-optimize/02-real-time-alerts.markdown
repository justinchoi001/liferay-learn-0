---
header-id: real-time-alerts
---

# Real-Time Alerts

Liferay DXP Cloud can alert system administrators of unexpected behaviors in a project. Unexpected behaviors include (but are not limited to) auto-scaling, higher than expected consumption of memory, CPU reaching an alloted quota, or database connection issues. This article documents how to set up alerts on the console and receive email notifications.

## Managing Alert Preferences

While logged into to the Liferay Cloud Management Console:

1. Click on the profile photo at the top-right corner of the navigation bar.
1. Click _Alerts Preferences_.

   ![Real Time Alerts](./real-time-alerts/images/01.png)

1. Check the relevant boxes for status alerts notifications.
1. Click _Save Alerts Preferences_.

The Alerts preferences have now been configured. To view the alerts notifications and the information found, see the Alerts Page section below.

## Alerts Page

The _Alerts_ page contains a list of behaviors that may occur in the various environments. The number and types of alerts that are sent can be configured in the _Alerts Preference_ page.

1. To access the _Alerts_ page, click the _Alerts_ icon on the top navigation bar.

    ![Real Time Alerts](./real-time-alerts/images/02.png)

The following tables describe the top level actions available:

| Button | Description |
| --- | --- |
| Unread alerts / All alerts | Filter to display only unread statuses or all statuses |
| All environments | Filter to select alerts by environment |
| Mark All as Read | Button to mark all alerts as read |

The following table describes the information found in each column.

| Status | Description |
| --- | --- |
| Status | _Ongoing_ or _Resolved_ describe the current state of an event |
| Started at | The time an event began |
| Duration | Length of time an event lasted |
