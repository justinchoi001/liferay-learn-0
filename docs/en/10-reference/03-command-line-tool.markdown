---
header-id: command-line-tool
---

# Command-line Tool

Liferay Cloud's command-line interface (CLI) is a tool that empowers administrators to create, manage, and scale applications.

## Installing the Liferay Cloud CLI

### \*nix Environment

Open a terminal and run this command:

```bash
curl https://cdn.liferay.cloud/cli/latest/lcp.sh -fsSL | bash
```

> If there is a permissions error, try running the same command with `sudo`.

### Windows Environment

Download the latest version of the [CLI installer](https://cdn.wedeploy.com/cli/latest/we-installer-windows-amd64.msi).

### Other systems

See the list of [available builds](https://dl.equinox.io/wedeploy/we/stable).

| **Note:** To deploy services on DXP Cloud, [Git](https://git-scm.com/) must be installed.

## Changing the CLI Remote

To access DXP Cloud services via the CLI, the CLI must be pointed to the right DXP Cloud. The remote URL for DXP Cloud is `liferay.cloud`. To list the CLI's remotes, run this command:

```shell
lcp remote
```

### Changing the default remote

1. Add a new remote if necessary:

    ```shell
    lcp remote add <remote-alias> <remote-url>
    ```

1. Run this command to set the default remote:

    ```shell
    lcp remote default <remote-alias>
    ```

Alternatively, specify the remote inline via this command:

```shell
lcp shell -p <project-id> -s <service-id> --remote <remote-alias>
```

## Showing the Service Logs

The `lcp log` command can display the DXP Cloud project's service logs. Here are some common examples.

Check the logs of an entire project:

```shell
lcp log --project <projectID>
```

View the logs of a specific service in a project:

```shell
lcp log --project <projectID> --service <serviceID>
```

Alternatively, it is possible to view a service's logs by passing the service's full URL to `lcp log`:

```shell
lcp log --url <serviceID>-<projectID>.lfr.cloud
```

## Manage Custom Domains

Use the `lcp domain` command to manage custom domains in the DXP Cloud projects. Here are some common examples.

Get the list of custom domains for a particular service:

```shell
lcp domain --project <projectID> --service <serviceID>
```

Add a custom domain to a service:

```shell
lcp domain add example.com --project <projectID> --service <serviceID>
```

Remove a custom domain from a service:

```shell
lcp domain rm example.com --project <projectID> --service <serviceID>
```

Alternatively, it is possible to run the same commands by passing the service's full URL to `lcp domain`:

```shell
lcp domain --url <serviceID>-<projectID>.lfr.cloud
```

## Manage Environment Variables

Use the `lcp env` command to manage environment variables. Here are some common examples.

Get the list of environment variables for a particular service:

```shell
lcp env --project <projectID> --service <serviceID>
```

Add an environment variable to a service:

```shell
lcp env set SOME_KEY somevalue --project <projectID> --service <serviceID>
```

Remove an environment variable from a service:

```shell
lcp env rm SOME_KEY --project <projectID> --service <serviceID>
```

Alternatively, it is possible to pass a service's full URL to `lcp env`:

```shell
lcp env --url <serviceID>-<projectID>.lfr.cloud
```

## List Projects or Services

Use the `lcp list` command to list projects and services. Here are some common examples.

See the full list of projects and services you own or collaborate on:

```shell
lcp list
```

List a project's services:

```shell
lcp list --project <projectID>
```

Check a specific service in a project:

```shell
lcp list --project <projectID> --service <serviceID>
```

Alternatively, it is possible to check a service by passing its full URL to `lcp list`:

```shell
lcp list --url <serviceID>-<projectID>.lfr.cloud
```

## Execute Commands in a Service Container

Use the CLI to run commands in a service container. For example, this runs a command in a specific service instance:

```shell
lcp exec --project <projectID> --service <serviceID> --instance <abc123> -- mkdir foo
```

It is also possible to run the command in any instance of a service:

```shell
lcp delete --project <projectID> --service <serviceID> --instance any -- mkdir foo
```

## Access a Service's Shell

To access a service container's shell, run this command:

```shell
lcp shell
```

This lists all the services in the container and lets administrators choose which one to access.

Alternatively, it is possible to access the shell of a specific service's container by adding the service's project ID and service ID to the `lcp shell` command:

```shell
lcp shell -p <projectID> -s <serviceID>
```
