---
header-id: auto-scaling
---

# Auto-scaling

Liferay DXP Cloud's auto-scaling feature automatically creates and destroys instances of the DXP service as needed to optimize performance. This feature is designed to address sudden changes such as increased server traffic, memory leaks, or other issues. By default, this feature is _disabled_ in every DXP Cloud account.

Using this feature, a service can automatically increase ("upscale") the number of DXP service instances to a maximum of 10, or decrease ("downscale") to the number specified with the `scale` property in [`LCP.json`](../10-reference/02-configuration-via-lcp-json.markdown). The `scale` property also specifies the minimum number of instances to run.

```json
  "scale": 2,
```

## Managing Auto-scaling

Follow these steps to enable or disable auto-scaling in the DXP Cloud Management Console:

1. Navigate to the Production environment
1. Click _Services_ &rarr; _(Liferay DXP service)_ &rarr; _Scale_ tab.
1. Click _Enable Auto Scaling_.
    > Alternately, click _Disable Auto Scaling_ to disable.

With auto-scaling enabled, DXP Cloud monitors the production service and scales it automatically according to predefined thresholds.

![Figure 1: Enable or disable auto-scaling from your service's Scale tab.](./auto-scaling/images/01.png)

## Auto-Scaling Based on Target Average Utilization

System administrators can specify a _target average utilization_. This value is an average of memory and CPU usage across Liferay DXP services. The value threshold must be crossed before auto-scaling is triggered.

For example, if three service instances utilize 70%, 90%, and 95% of memory, respectively, then the average memory utilization is 85%. If the target average utilization is set to 90, then no upscaling is needed; upscaling in this situation only occurs when the average memory utilization exceeds the target.

The total available memory is specified by the `memory` property in [`LCP.json`](../10-reference/02-configuration-via-lcp-json.markdown).

To specify the target average utilization in the `autoscale` property of the service's `LCP.json`, enter the following:

```json
"autoscale": {
    "cpu": 80,
    "memory": 90
}
```

Otherwise, if the `autoscale` property is not set, the target average utilization defaults to 80 for both CPU and memory utilization.

## Additional Information

For more information on how auto-scaling is charged, see the [How Is Auto Scaling Charged](https://help.liferay.com/hc/en-us/articles/360030843592-How-Auto-Scaling-is-charged-) article.
