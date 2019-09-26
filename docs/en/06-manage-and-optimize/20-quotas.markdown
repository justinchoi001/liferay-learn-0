# Quotas

Resource quotas are the maximum number of resources available for that DXP Cloud project. Usually, quotas are set during the initial sales process; customers can then allocate their resources according to their various needs. (For example, a production environment might be allocated more CPU cores and instances while a dev environment might have fewer cores.)

When a project reaches any of its resource quotas, it is important to note that _the production environment will not be affected_. However, there will be other *temporary* loss of some functionality depending on which resource. For example, reaching the quota for 20 custom domains means administrators cannot create a new domain, while reaching the memory quota could generate out of memory errors and a deployment might fail.

The only exception is when [auto-scaling](./03-auto-scaling.markdown) has been enabled. When auto-scaling is enabled, reaching certain thresholds are not counted against the set quota.

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

Some of the quotas are found in each service's `lcp.json` file.

To request an increase in the quota of any type of resource, open a [Help Center ticket](https://liferay-support.zendesk.com/agent//).
