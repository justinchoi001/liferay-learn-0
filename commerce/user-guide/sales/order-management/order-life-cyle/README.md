# Order Life Cycle

An Order stores data regarding a potential or past transaction. This article provides an overview of the order life cycle from open cart to fulfilled order.

<img src="./images/01.png" width="700px" style="border: #000000 1px solid;">

**Figure 1**. Order Life Cycle

**Step 1: Products Added to Cart**

A new order is created when a buyer places products into the cart. At this starting point, the data stored in the order includes the identity and quantity of the products, as well as the account which created it.

**Step 2: Order Placed**

After providing information - such as shipping address, payment method, plus any custom checkout steps - to the seller and viewing an order summary, the buyer places the order.

**Step 3: Order Transmitted**

When the seller advances an order from pending to transmitted, the order is sent to an external system, such as Microsoft’s Dynamics GP, Oracle’s Netsuite, or SAP.

**Step 4: Order Fulfilled**

The seller completes the remaining steps to deliver the ordered products to the buyer. Additional information can be added to the order, such as an updated order status, shipping information and estimated arrival time.

## Additional Information

**Note 1: Buyer-Side Cart Approval _(Optional Workflow)_ (Additional Step)**

If _Approval Workflow_ is enabled, the buyer submits his cart (after step 1) for internal review and approval. Once approved, the buyer can proceed to checkout.

**Note 2: Seller-Side Order Approval _(Optional Workflow)_ (Additional Step)**

If _Transmission Workflow_ is enabled, the seller reviews the pending order (after step 2) and either approves it or rejects it (sending it back to the buyer). Once the order is approved, the seller can move it towards fulfilment.

* Order Management: What are Order Workflows?
* Order Management: Enabling Order Workflows
* Order Management: Approving/Rejecting Orders in Order Workflows
* Order Management: Order Menu
* Order Management: Statuses
* Order Management: Advancing an Order to Transmitted