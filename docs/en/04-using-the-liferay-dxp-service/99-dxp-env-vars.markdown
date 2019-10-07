# Environment Variables for the Liferay DXP Service

Name                                  | Default Value | Description  |
------------------------------------- | ------------- | ------------ |
`LCP_PROJECT_LIFERAY_CLUSTER_ENABLED` | `false`       | Whether to enable clustering and communication between nodes. |
`LCP_PROJECT_MONITOR_DYNATRACE_TENANT` |               | A string with eight characters. It's part of the URL (prefix) of your Dynatrace SaaS product. |
`LCP_PROJECT_MONITOR_DYNATRACE_TOKEN` |               | A string with 22 characters that you can find in your Dynatrace account at *Deploy Dynatrace* &rarr; *Start installation* &rarr; *Set up PaaS monitoring* &rarr; *Installer Download*. |
`LIFERAY_JAVA_OPTS` | | JVM options that will be appended to `CATALINA_OPTS` to override the default recommended options. |