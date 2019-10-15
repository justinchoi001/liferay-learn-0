# Persistent File System (Volumes)

Administrators can configure the DXP Cloud service's volume depending on their application type (stateless or stateful). The volume can be either a persistent shared storage (NFS) or a persistent dedicated storage (SSD). This article documents how to configure the volume in the DXP Cloud service via the `LCP.json` file.

1. Choose the folders that contain the data to be persisted (for example `/liferay/opt/data`).
1. Navigate to the LCP.json file in the Github repository for the specific environment (for example, `[ProjectID])/lcp/liferay`).
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

## Additional Information

* [Configuring Your Github Repository](../getting-started/configuring-your-github-repository.md)
* [Configuring via LCP.json](../reference/configuration-via-lcp-json.md)
* [Sharing Volumes Between Different Services](./sharing-volumes-between-different-services.md)
