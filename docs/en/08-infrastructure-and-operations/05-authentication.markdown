# Authentication

This article documents the two types of authentication requests used by Liferay DXP Cloud.

The first method is [basic authentication](https://swagger.io/docs/specification/authentication/basic-authentication/) which is a HTTP protocol in the Authorization Header encoded when the server requests authentication from a client.

The second is by a user access token. Note that token authentication is required if SSO is enabled. The token from the cookie `access_token` is retrieved and then used with the `dxpcloud-authorization` header.

Here is an example that uses token authentication with the upload API:

```bash
curl -X POST /
  http://<HOST-NAME>/backup/upload /
  -H 'Content-Type: multipart/form-data' /
  -H 'dxpcloud-authorization: Bearer <USER_TOKEN>' /
  -F 'database=@/my-folder/database.tgz' /
  -F 'volume=@/my-folder/volume.tgz'
```

> **Note**: Passing the user token in the header `dxpcloud-authorization` only works for versions `3.2.0` or greater of the backup service. Previous versions should be upgraded to at least `3.2.0`. Requests to earlier versions must use the header `Authorization: Bearer <PROJECT_MASTER_TOKEN>`. To find the project master token, run the command `env grep LCP_PROJECT_MASTER_TOKEN` in any shell on the Liferay DXP Cloud console.
