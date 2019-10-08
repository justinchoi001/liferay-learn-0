# Networking Environment Variables Reference

## Load Balancer Settings

```json
"loadBalancer": {
    "cdn": true,
    "targetPort": 3000,
    "customDomains": ["example.com"],
    "ssl": {
      "key": "...",
      "crt": "..."
    }
  }
```

| Name | Value | Description |
| --- | --- | --- |
| `cdn` | false | CDN is disabled by default; can be enabled by setting to `true` |
| `customDomain` | ["example.com", "www.example.com"] | Name of the custom domain; can list more than one |
| `targetPort` | 3000 | Port number for the load balancer |
| `key` | | SSL certificate's key  |
| `crt` | | SSL certificate's crt in Base64 format |

## Private Network Settings

```json
{
  "id": "db",
  "ports": [
    {
      "port": 3400,
      "targetPort": 7000,
      "protocol": "TCP"
    },
    {
      "port": 9000,
      "targetPort": 8000,
      "protocol": "TCP",
      "external": true
    }
  ]
}
```

| Name | Value | Description |
| --- | --- | --- |
| `port` | 3400 | The external port of the service to connect to. |
| `targetPort` | 7000 | The internal port of the service to expose |
| `protocol` | TCP | The type of connection to create (TCP and UDP are supported) |
| `external` | true | Whether your connection is available to external connections. The default value `false` restricts the connection to internal DXP Cloud connections |

## Additional Information

* [Configuration via LCP JSON](../10-reference/02-configuration-via-lcp-json.md)
* [Adding Environment Variables](../../03-platform-overview/03-adding-environment-variables.md)
