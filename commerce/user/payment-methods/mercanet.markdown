# Adding Mercanet as a Payment Method

This article details how to enable Mercanet as a payment method. Because Mercanet accepts <u>only</u> **EUR**, the store's primary currency must be EUR.

### Mercanet Guide
1. Review prerequisites.
2. Set EUR as the primary store currency.
3. Add Mercanet as a Payment Method. 

### Prerequisites 
Before configuring your store to use [Mercanet](https://documentation.mercanet.bnpparibas.net/index.php?title=Obtenir_sa_cl%C3%A9_secr%C3%A8te#), it is necessary to generate the following: 

1.  Mercanet Merchant ID
2.  Secret Key
3.  Key Version.

### Adding Mercanet  
When using Mercanet, your store must use Euros as the primary currency. To change the primary currency:

1.  Navigate to the _Control Panel → Commerce → Settings_. 
2.  Click _Currencies_.
3.  Click the _3-dot icon_ next to Euro.
4.  Click _Set as Primary_.

_Euro_ is now set as the primary currency.

![Set Primary Currency](./images/set-primary-currency.png)  

To activate Mercanet as a payment method:

1.  Navigate to _(your Commerce site) → Commerce → Settings → Payment Methods_.
2.  Click _Payment Methods_.
3.  Click _Mercanet_.
4.  Click _Configuration_.
5.  Enter the following:
    *   Your _Merchant ID_
    *   Your _Secret Key_
    *   Your _Key Version_
6.  Select _Production_ if it is a live site or _Test_ or _Simulation_ if it is a test environment.

![Mercanet settings](./images/mercanet.png)

7.  Click _Save_.
8.  Click the _3-dot icon_ next to _Mercanet_ then _Activate_.

Mercanet is now enabled for your store.

## Additional Information

*   <a href="">Currencies Administration</a>
*   <a href="">Authorize.Net</a>
*   <a href="">PayPal</a>
*   <a href="">Learn how to add other 3rd party payment systems.</a>
