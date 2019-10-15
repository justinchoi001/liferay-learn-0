# Sharing Volumes Between Different Services

Because all volumes in an _environment_ are shared, you can share content between
_services_. This article documents how to share volumes between the different services in a Liferay DXP Cloud environment via the `LCP.json` file.

To share the volumes:

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

| **Note:** To delete your service volumes, you can delete the environment that your services belong to.

## Additional Information

* [Configuring Your Github Repository](../getting-started/configuring-your-github-repository.md)
* [Configuring via LCP.json](../reference/configuration-via-lcp-json.md)
* [Persistent File System](./persistent-file-system.md)
