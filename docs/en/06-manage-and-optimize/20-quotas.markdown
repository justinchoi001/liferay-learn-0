# Quotas

Resource quotas are the maximum number of resources available for that DXP Cloud service. Usually, quotas are set during the initial sales process; it is up to the system administrators to allocate the resources accordingly. (For example, a production environment might be allocated more CPU cores and instances while a dev environment might have fewer cores.) Reaching the quota usually will result in the loss of functionality, such as the ability to deploying a build. The only exception is when [auto-scaling](./03-auto-scaling.markdown) has been enabled. When auto-scaling is enabled, reaching certain thresholds are not counted against the set quota.

To increase the quota of any type of resource, open a [Help Center ticket](https://liferay-support.zendesk.com/agent//).

The following resources have set quotas:

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
