# Store Setup Overview

## Introduction

Welcome to Liferay Commerce! This article is designed to walk through the steps to create a new store: Installation, DXP Configuration, Basic Store Setup, Catalog Setup, Building a Storefront, Preparing to Manage Customer Accounts, Order Management, and External Integrations.

## Road Map

* Liferay Commerce Installation
* DXP Configuration
* Basic Store Setup
* Creating the Storefront
* Preparing to Manage Customer Accounts
* Managing Orders and Shipments
* Integrating Your Commerce Instance with External Resources

## Liferay Commerce Installation

Before installing Liferay Commerce, please carefully review the [Systems Requirements](https://web.liferay.com/documents/14/21598941/Liferay+Commerce+2.0+Compatibility+Matrix/0ed97477-f5a7-40a6-b5ab-f00d5e01b75f) and the [Installation Overview](../../../installation-and-upgrades/installation-guide/installation-overview/README.md).

There are several ways to deploy Liferay Commerce:

1. [Using a Docker Image](../../../installation-and-upgrades/quick-start-guide/README.md) (Quick Start)
1. [Using a bundle (Open Source only)](../../../installation-and-upgrades/installation-guide/using-the-liferay-commerce-tomcat-bundle/README.md)
1. [Deploying the Commerce LPKG to an existing Liferay DXP installation](../../../installation-and-upgrades/installation-guide/deploying-liferay-commerce-to-an-existing-liferay-installation/README.md)

Subscribers must have a purchase order and an activation key to begin using the Commerce Enterprise. For more information about a purchase order, [activation key](https://help.liferay.com/hc/en-us/articles/360017747011-Deployment-Instructions-for-DXP-Activation-Key-When-Using-the-xml-Key-File), or acquiring Commerce Enterprise, contact your Sales representative or open a Liferay [Help Center](https://help.liferay.com/hc/en-us) ticket.

Upgrading Liferay Commerce? See [Upgrading from Liferay Commerce 1.1.x](../../../installation-and-upgrades/upgrades-and-updates/upgrading-from-liferay-commerce-1.1.x/README.md).

## DXP Configuration

Liferay Commerce is built on the enterprise grade foundation of Liferay DXP. To configure and optimize the performance, security, and stability of your store, please review:

* [Liferay DXP 7.1 Deployment Guide](https://help.liferay.com/hc/en-us/categories/360000929111) contains information on how to deploy Liferay DXP in various environments and then connect the DXP instance to a database, search provider, and other infrastructure.

* [Liferay DXP 7.1 Admin Guide](https://help.liferay.com/hc/en-us/categories/360000929191) contains information on how to use Liferay DXP features such as Web Experience, Collaboration, Search, Forms, Workflow, Audience Targeting, User Management, and managing Marketplace Apps.

## Basic Store Setup

Once the Liferay DXP installation has been configured, the next series of steps are the creation and configuration of a Liferay Commerce Store.

> Note: Some of the following configurations will not need to be set if using a Liferay Commerce Accelerator to create the store site. See [Using the Minium Accelerator to Jump Start Your B2B Store](../../getting-started/accelerators/using-the-minium-accelerator-to-jump-start-your-b2b-store/README.md) for details.

The early phases of a setting up a store are done by the [system administrator](../introduction-to-the-admin-account/README.md). Read the [Liferay Commerce Configuration Overview](../liferay-commerce-configuration-overview/README.md) to learn more about making the initial setup and scope settings.

### Configure Global Commerce Settings

Review the following key global configurations which affect all store sites housed on a Liferay Commerce instance.

1. [Setting Locale Options](../locale-options/README.md)
1. [Adding Regions](../country-options/adding-regions/README.md)
1. [Setting up Warehouses](../../catalog/managing-inventory/warehouse-reference-guide/README.md)
1. [Creating Channels](../../catalog/creating-and-managing-products/channels/introduction-to-channels/README.md)

### Create a Store Site

Liferay Commerce is optimized for both a B2B and a B2C type of store. The store site should be set at the outset as one of the two options. To learn more about site types and setting the store, see the [Site Types](../site-management-basics/sites-and-site-types/README.md) article.

### Configure Store Site Commerce Settings

There are several key configurations that are specific to different store sites if more than one store site housed on the same Liferay Commerce instance. Read the articles in each topic below.

#### Accepting Payment

Liferay Commerce contains three third party payment systems and the use of money orders to accept payment. To learn more, read:

1. [Payments](../payments/README.md)
1. [Managing Payment Methods](../payments/managing-payment-methods/README.md)

#### Collecting applicable taxes

In order to collect the applicable taxes, Liferay Commerce has the ability to create new tax categories or to set tax rate by addresses or by a fix rate. Review the following articles to learn more.

1. [Creating Tax Categories](../../operations/taxes/creating-tax-categories/README.md)
1. [Setting Tax Rate by Address](../../operations/taxes/setting-tax-rate-by-address/README.md)
1. [Setting Tax Rate by Fixed Rate](../../operations/taxes/setting-tax-rate-by-fixed-rate/README.md)

#### Shipping Products and choosing carriers

Liferay Commerce has several options to calculate shipping rates based on various business needs and can also configured to use FedEx as a carrier.

1. [Variable Rate](../../sales/shipping/using-the-variable-rate-shipping-method/README.md)
1. [Flat Rate](../../sales/shipping/using-the-flat-rate/shipping-method/README.md)
1. [Using FedEx as a Carrier](../../sales/shipping/using-fedex-as-a-carrier-method/README.md)

## Creating the Catalog

After setting up the store, begin [creating a catalog](../../catalog/creating-a-catalog/README.md). Note that Liferay Commerce allows multiple catalogs.

### Adding Products to a Catalog

When creating a new product, there are three product types: **Simple**, **Grouped**, and **Virtual**. See the [Introduction to Product Types](../../catalog/creating-and-managing-products/product-types/introduction-to-product-types/README.md) article.

#### Adding Product Information

Enter the following information for each Product so that it can be published and searched for in the catalog:

1. Product details:
    * Name
    * The associated catalog
    * Friendly URLs
1. [Product Options](../../catalog/creating-and-managing-products/customizing-your-product-with-product-options)
    * Package Quantity
    * Package Colors
1. [Product Specifications](../../catalog/creating-and-managing-products/product-information/specifications/README.md)
1. [Product Images](../../catalog/creating-and-managing-products/product-information/product-images/README.md)
1. Product Attachments
1. [Product Relations](../../catalog/creating-and-managing-products/product-information/related-products-up-sells-and-cross-sells/README.md)
1. [Product Categorization](../../catalog/creating-and-managing-products/categories/organizing-your-catalog-with-product-categories/README.md)
1. Product Configuration
    * [Availability Estimates](../../catalog/managing-inventory/availability-estimates/README.md)
    * [Low Stock Activity](../../catalog/managing-inventory/low-stock-activity/README.md)
    * Applicable Tax Category
    * Associated Channels
    * Associated Account Groups
1. BOM / Spare Parts

#### Product Pricing

Whether a product has a single or multiple variants, each product variant has a corresponding SKU. Once SKUs have been generated, store managers can configure each SKU’s price and inventory. To set general or special prices based on certain conditions, see:

1. [Pricing](../../catalog/managing-price/introduction-to-product-pricing-methods/README.md)
1. [Price Lists](../../catalog/managing-price/price-lists/creating-a-price-list/README.md)
1. [Discounts](../../marketing/promotions/adding-discounts-by-product/README.md)
1. [Inventory](../../catalog/managing-inventory/introduction-to-managing-inventory/README.md)
1. Subscriptions (if applicable)
1. Shipping Override

## Creating the Storefront

A storefront is comprised of several different pages. Each page contains one or more widget that present vital information about the product, user activities and accounts, or business transactions. Put together, they become the storefront and help buyers from start to finish.

Here is a list of the key pages:

1. [Account Management](../../content/pages/account-management/README.md)
1. BOM / Spare Parts Finder
1. [Cart](../../content/pages/cart/README.md)
1. [Catalog](../../content/pages/catalog/README.md)
1. [Checkout](../../content/pages/checkout/README.md)
1. [Compare](../../content/pages/compare/README.md)
1. [List](../../content/pages/list/README.md)
1. [Pending Orders](../../content/pages/pending-orders/README.md)
1. [Placed Orders](../../content/pages/placed-orders/README.md)
1. [Product Details Page](../../content/pages/product-details/README.md)
1. [Search](../../content/pages/SEARCH/README.md)

See the article [Creating Pages](https://help.liferay.com/hc/en-us/articles/360018171291-Creating-Pages) to begin creating the storefront.

## Preparing to Manage Customer Accounts

Once the catalog is created, and the storefront created, prepare to manage customers and accounts.

To learn more about how to create an account then invite users to those accounts, read the following articles:

1. [Introduction to Accounts](../../customers/account-management/introduction-to-accounts/README.md)
1. [Creating a New Account](../../customers/account-management/creating-a-new-account/README.md)
1. [Inviting Users to an Account](../../customers/account-management/inviting-users-to-an-account/README.md)
1. [Adding Addresses to an Account](../../customers/account-management/adding-addresses-to-an-account/README.md)
1. [Account Roles](../../customers/account-management/account-roles/README.md)
1. [Assigning Account Roles](../../customers/account-management/assigning-account-roles/README.md)

Furthermore, Accounts can be grouped into Account Groups; this allows store managers to advertise and offer targeted discounts based on different groupings. See the [Creating a New Account Group](../../customers/account-management/creating-a-new-account-group/README.md) article.

## Managing Orders and Shipments

Once an order has been received, the order has to be tracked by transmission to an ERP and a CRM. Finally, once the requested goods are available for shipping, the store's inventory specialists need to track the shipment. See the following articles to learn Liferay Commerce tracks the life cycle of an order and the shipment processes.

* [Order Life Cycle](../../sales/order-management/order-life-cycle/README.md)
* [Creating a shipment](../../sales/order-management/managing-shipments/creating-a-shipment/README.md)
* [Cancelling a Shipment](../../sales/order-management/managing-shipments/cancelling-a-shipment/README.md)

## Integrating your Commerce Instance with External Resources

Liferay Commerce has the ability to integrate with external resources such as Saleforce, Talend, and CRMs. To learn more, see the following articles 

1. Salesforce
1. ERP
1. CRM
