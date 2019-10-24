# Account Administrator Permissions

Users can modify the account, invite and add users to join the account, and assign roles to other account members. These permissions are the minimum. Although they can be removed, this will cause some changes in user access and abilities to make transactions on the Commerce site. However, more permissions may be _added_.

Note that a Liferay Commerce account administrator cannot create or delete an account. This permission is reserved for the store administrator.

To view the permissions:

1. Navigate to the _Control Panel_ > _Users_ > _Roles_.
1. Click the _Site Roles_ tab.
1. Click _Account Administrator_.
1. Click the _Define Permissions_ tab.

![Account Administrator Role Permissions](./account-administrator-permissions/images/01.png)

The following set of permissions pertain to the Account Administrator Role's ability to modify accounts in a B2B setting.

| Permissions | Description |
| --- | --- |
| Accounts > Commerce Account: Update | |
| Accounts > Commerce Account: View | Ability to view all accounts |
| Accounts > Commerce Account: View Members | Ability to view all members in an account |
| Accounts > Commerce Account: Manage Address | Ability to add a new billing, a shipping, or a combined address |
| Accounts > Commerce Account: Manage Members | Ability to invite a new member or an organization and modify his or her credentials |
| Accounts > Commerce Account: View Addresses | Ability to view all the addresses associated with an account |

The following set of permissions pertain to the Account Administrator Role's ability to modify orders regardless of the store type (B2B or B2C).

| Permissions | Description |
| --- | --- |
| Add Order | Ability to add an order to the Buyer's specified account (can have more than one account) |
| Approve Open Orders | Allow account administrator to approve orders if workflow has been enabled |
| Check Out Open Orders | Ability to complete the checkout process for new, incomplete orders |
| Delete Orders | Grants the ability to delete an order |
| Manage Orders | Change Order details such as mailing and billing addresses; ability to add a note to the order |
| View Open Orders | Ability to view all open orders |
| View Orders | Ability to view all orders regardless of their statuses |

New permissions can added by clicking the _Site Administration_ in the left navigation.

## Site Administration  > Commerce

Additional Commerce-specific permissions for Wish Lists and Commerce Settings are found in the following places. Granting permissions allow Buyers to perform additional functionalities or view administrative aspects of the platform.

* Wish Lists
* Settings

## Site Administration > Applications

* Accounts
* Cart
* Cart Summary
* Checkout
* Commerce Addresses
* Commerce BOM
* Commerce Categories Navigation
* Coupon Code Entry
* Dashboard Forecasts Chart
* Mini Cart
* Open Carts
* Option Facet
* Orders
* Shipments
* Specification Facet
* Wish List Contents
* Wish Lists

## Additional Information

* [Buyer Permissions](./buyer-permissions.md)
* [Sales Agent Permissions](./sales-agent-permissions.md)
* [Order Manager Permissions](./order-manager-permissions.md)
