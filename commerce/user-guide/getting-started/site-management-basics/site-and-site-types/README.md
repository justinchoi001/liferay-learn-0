# Site Types

Your site type should match your store's business model: B2B, B2C, or B2X.

**B2B**: A business-to-business site only recognizes business accounts, which means that a user must be explicitly associated with a business account in order to make purchases. This is recommended for B2B sellers or B2C sellers whose customers are grouped into a single buying unit, for example households.

**B2C**: A business-to-consumer site only recognizes personal accounts, which means that any authenticated user can make purchases. This is recommended for B2C sellers or B2B sellers who do not care to support multiple users on a single account.

**B2X**: A B2C-B2B site recognizes both personal and business accounts. Users can be associated with business accounts, but can also make purchases individually. This is recommended for sellers who want to support both account types on the same site.

## Changing Site Types

To set your site's type, navigate to the _Control Panel_ → _(your site)_ → _Commerce_ → __Settings_ and select the Site Type tab. Select a type from the dropdown menu and click _Save_.

<img src="./images/01.png" width="700px" style="border: #000000 1px solid;">

Changing a site's type also changes which accounts appear in its Accounts widget. If an instance contains business accounts but a site's type is set to B2C, those accounts still exist in the database but do not appear in the Accounts widget and are inaccessible to users.

It is best practice to set a site's type as soon as you create it and avoid changing it in the future.