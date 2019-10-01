---
header-id: shell-access
---

# Shell Access

This article documents how to use the shell access features in DXP Cloud. Shell access makes it simpler to see what's going on inside an application. Administrators and developers can use the shell to look for side effects not easily spotted in the logs, or call functions for data population or report generation that are meant to run only once.

| **Note:** The backup and database services do not provide shell access.

## Accessing the Shell via the Web Console

While logged into the DXP Cloud Management Console:

1. Navigate to the environment page (for example, _dev_).
1. Click *Services* in the left menu.
1. Select a service (_liferay_).
1. Click the *Shell* tab.

![Figure 1: Access the shell via DXP Cloud's web console.](./shell-access/images/01.png)

## Accessing the Shell via a Terminal

To use a terminal, the [Liferay Cloud command line tool](../10-reference/03-command-line-tool.markdown) has to be installed first.

1. Run the command `lcp shell`.
1. Select the service to access.

![Figure 2: Access the shell via the command line.](./shell-access/images/02.png)

Alternatively, run this command using the `serviceID` and `projectID`:

```shell
lcp shell -p projectID -s serviceID
```

## Shell Limitations

The shell is a great tool to troubleshoot or perform one-time actions on a service, but it is not intended for permanent changes. When a service is deployed or restarted, all files not in a persistent volume are replaced by the new build. For the shell, this means every command executed in the service is temporary and is reset, unless the changes are made within a volume.
