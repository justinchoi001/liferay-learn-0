# Quotas

Quotas are the maximum number of resources available for a given DXP Cloud project. Administrators may configure services and environments to use resources according to project need. (For example, a production environment may be allocated additional CPU cores while a dev environment might have fewer cores.)

When a project reaches any of its resource quotas, it is important to note that _the production environment will not be affected_. However, there will be *temporary* loss of some functionality depending on which resource has reached the pre-determined quota. For example, reaching the quota for 20 custom domains means administrators will be unable to create a new domain. Reaching the memory quota could generate out of memory errors and a deployment might fail. [Real-time Alerts](../manage-and-optimize/real-time-alerts.md) can be configured to to ensure that users are notified before they reach a resource quota.

When [Auto-scaling](./auto-scaling.md) is enabled, reaching certain thresholds will not count against pre-determined quotas.

The following resources are governed by quotas:

* CPU
* Memory
* Custom Domains
* Collaborators
* Maximum Number of Cores
* Instances
* Maximum Number of Projects
* Maximum Number of Services
* Maximum Builds per Day
* CPU per Service
* Scale per Service
* Memory per Service

Resource allocations for the above can be configured in each service's `lcp.json` file. See [Configuration via LCP.json](../reference/configuration-via-lcp-json.md).

To request an increase in the quota of any type of resource, please open a [Help Center ticket](https://liferay-support.zendesk.com/agent/).
