# Authentication

There are two main ways authentication requests are handled in Liferay DXP Cloud: basic authentication or a user access token. Note that token authentication is required if SSO is enabled. The token from the cookie `access_token` is retrieved and then used with the `dxpcloud-authorization` header.

Here is an example that uses token authentication with the upload API:

```
curl -X POST /
  http://<HOST-NAME>/backup/upload /
  -H 'Content-Type: multipart/form-data' /
  -H 'dxpcloud-authorization: Bearer <USER_TOKEN>' /
  -F 'database=@/my-folder/database.tgz' /
  -F 'volume=@/my-folder/volume.tgz'
```

**Important Note**: Passing the user token in the header `dxpcloud-authorization` only works for versions `3.2.0` or greater of the backup service. Previous versions should be upgraded to at least `3.2.0`. Requests to earlier versions must use the header `Authorization: Bearer <PROJECT_MASTER_TOKEN>`. To find the project master token, run the command `env grep LCP_PROJECT_MASTER_TOKEN` in any shell in the Liferay DXP Cloud console.
