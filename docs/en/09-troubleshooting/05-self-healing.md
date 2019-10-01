# Self-Healing

This article documents the self-healing processes in DXP Cloud. During the provisioning process, customers and the DXP Cloud Team work together to establish the configuration parameters for their project to diagnose itself and then restore the environments quickly and with minimal downtime. As part of this process, customers can specify how long a service can delay the verification process during initial startup, the amount of time before the next verification check is executed, and how many times the verification runs before it stops. An example is a clustered environment with multiple nodes that might take longer to start compared to a single instance environment. The self-healing process can be adjusted for such environments.

To verify that a service is running or to help the service recover after some degradation, DXP Cloud offers two tools used in conjunction with each other to manage applications:

* Liveness Probe: Indicates whether the service is running.
* Readiness Probe: Indicates whether the service is ready to receive requests.

For each probe, a URL request or an executable command can be used to validate the status:

## URL Request (path/port)

In the service's `LCP.json` file, enter:

```
"livenessProbe": {
  "httpGet": {
    "path": "/status",
    "port": 3000
  },
  "initialDelaySeconds": 40,
  "periodSeconds": 5,
  "successThreshold": 5
}
```

## Executable Command

Alternately, enter the following in the `LCP.json` file:

```
"readinessProbe": {
  "exec": {
    "command": ["cat", "/tmp/healthy"]
  },
  "initialDelaySeconds": 40,
  "periodSeconds": 5,
}
```

| Property Name | Description |
| --- | --- |
| `initialDelaySeconds`| Number of seconds after the container has started before the probe is initiated. |
| `periodSeconds` | How often (in seconds) to perform the probe. The default is 10; the minimum is 1. |
| `timeoutSeconds` | Number of seconds after which the probe times out. The default and minimum is 1. |
| `successThreshold` | Minimum consecutive successes for the probe to be considered successful following a failure. The default and minimum is `1`. Must be `1` for liveness. |
| `failureThreshold` | The number of times DXP Cloud repeats a failed probe before giving up. For a liveness probe, giving up means the service will restart. For a readiness probe, giving up means the probe will be marked as Failed. The default is `3`; the minimum is `1`. |

Once the *customer* has configured their `LCS.json` files and deployed them in their environments, the DXP Cloud team can use the two probes to monitor the project's liveness and readiness. Customers can always open a [Help Center](https://liferay-support.zendesk.com/agent/) ticket to address any self-healing issues.
