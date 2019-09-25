---
header-id: log-management
---

# Log Management

Logs are crucial for debugging. DXP Cloud environment's logs can be accessed via the web console or terminal. Log files can also be downloaded.

## Accessing Logs from the Web Console

The easiest way to access an environment's logs is via the web console. To do so, select the environment and click the *Logs* tab in the left menu. To access a specific service's logs, select the service from the *All Services* menu in the toolbar. To download the logs, click *Download Logs*.

![Figure 1: Using the web console.](../../images/logs-web-console.png)

## Accessing Logs from the Terminal

Run this command:

```shell
lcp log
```

This lists all the services and administrators and developers can choose the respective logs. To access logs from a specific environment, enter its ID or run the command with that ID:

```shell
lcp log -p myenvironmentid
```

Administrators can specify the service as part of the command:

```shell
lcp log -p myenvironmentid -s myserviceid
```
