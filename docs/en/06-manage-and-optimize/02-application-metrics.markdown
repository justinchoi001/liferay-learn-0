---
header-id: application-metrics
---

# Application Metrics

With DXP Cloud's built-in monitoring, administrators can track the following information about all services:

* CPU usage
* Memory usage
* Transfer data

While logged into the web console:

1. Click *Monitoring* tab.
1. Data is displayed for the past 30 days. To change the time period, click the time selector dropdown menu.

![Figure 1: You can use DXP Cloud to monitor your services.](./application-metrics/images/01.png)

## Advanced Application Metrics On Production

To conduct deeper and more advanced monitoring on the production environment, click the *Advanced* tab to access your [Dynatrace](https://www.dynatrace.com/) dashboard. There you can check things like log trails and create custom dashboards.

The following requirements have to be met first:

1. A Dynatrace account has been created.
1. The Dynatrace secret `token` and `tenant` values have been generated.
1. Dynatrace environment variables have been added to the `LCP.json` file in the DXP's production instance. Example:

```
"environments": {
  "prd": {
    "env": {
      "LCP_PROJECT_MONITOR_DYNATRACE_TENANT": "tot02934",
      "LCP_PROJECT_MONITOR_DYNATRACE_TOKEN": "dDKSowkdID8dKDkCkepW"
    }
  }
}
```

## Additional Information

* [Advanced Monitoring: APM Tools - Dynatrace](https://help.liferay.com/hc/en-us/articles/360017896452-Advanced-Monitoring-APM-Tools-Dynatrace)
