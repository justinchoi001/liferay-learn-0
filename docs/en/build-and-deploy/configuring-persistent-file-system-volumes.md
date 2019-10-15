# Configuring Persistent File Storage Volumes

Administrators can configure the DXP Cloud service's volume depending on their application type (stateless or stateful). The volume can be either a persistent shared storage (NFS) or a persistent dedicated storage (SSD). This article documents how to configure the volume in the DXP Cloud service via the `LCP.json` file.

1. Choose the folders that contain the data to be persisted (for example `/liferay/opt/data`).
1. Navigate to the LCP.json file in the repository for the specific environment (for example, `lcp/liferay`).
1. Add the `volumes` configuration to the `LCP.json`. This configuration must contain a key for each volume. For example, the following configuration contains a `data` key for `/liferay/opt/data`:

```json
{
    "id": "lfr",
    "memory": 6144,
    "cpu": 4,
    "volumes": {
        "data": "/liferay/opt/data"
    }
}
```

## Sharing Volumes Between Different Services

Because all volumes in an _environment_ are shared, you can share content between _services_. This article documents how to share volumes between the different services in a Liferay DXP Cloud environment via the `LCP.json` file.

To share a volume:

1. Navigate to the `LCP.json` file in the Github repository for the service (`[ProjectID]/lcp/liferay/LCP.json`).
1. Enter the following:
     * service's ID
     * location (absolute path) of the content to be shared
     * the same volume key for the different services

In this example, `service1` will share photos from `/photos`, while `service2` will share photos from `/documents/images`. This way, both (or all) services can access the files within the volume via the key and declared file paths.

```json
{
  "id": "service1",
  "volumes": {
    "photos": "/photos"
  }
}
```

This service (`service2`) shares photos from `/documents/images`:

```json
{
  "id": "service2",
  "volumes": {
    "photos": "/documents/images"
  }
}
```

The specific volumes are now shared between the services on the next deployment after the services are restarted.

> **Note:** To delete your service volumes, you can delete the environment that your services belong to.

## Additional Information

* [Configuring Your Github Repository](../getting-started/configuring-your-github-repository.md)
* [Configuring via LCP.json](../reference/configuration-via-lcp-json.md)
