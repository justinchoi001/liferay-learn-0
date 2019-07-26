# Implementing a Custom Low Stock Activity

This tutorial will show you how to add a custom low stock activity by implementing the `CommerceLowStockActivity` interface.

Low stock activities are actions that are automatically taken if products fall below their configured Minimum Stock Quantities. configured products fall below a certain level of stock. Liferay Commerce provides one default low stock activity, which is to unpublish the product.

![Out of the box low stock activity](./images/01.png "Out of the box low stock activity")

## Overview

1. **Deploy an Example**
1. **Walk Through the Example**
1. **Additional Information**

## Deploy an Example

In this section, we will get an example low stock activity up and running on your instance of Liferay Commerce. Follow these steps:

1. Start Liferay Commerce.

    ```bash
    docker run -it -p 8080:8080 liferay/commerce:2.0.1
    ```

1. Download and unzip the [Acme Commerce ...]() to your project directory.

    ```bash
    curl liferay-xxxx.zip
    ```

    ```bash
    unzip liferay-xxxx.zip
    ```

1. Go to `xxxx-impl`.

    ```bash
    cd xxxx-impl
    ```

1. Build and deploy the example.

    ```bash
    ./gradlew deploy -Ddeploy.docker.container.id=$(docker ps -lq)
    ```

    >Note: This command is the same as copying the deployed jars to /opt/liferay/osgi/modules on the Docker container.

1. Confirm the deployment in the Liferay Docker container console.

    ```bash
    STARTED com.acme.xxxx.internal.commerce.foo.method_1.0.0
    ```

1. Verify that the example new low stock activity was added. Open your browser to `https://localhost:8080` and navigate to _Control Panel_ → _Commerce_ → _Products_. Then, for any product, click _Edit_ within its menu. If necessary, you can add a product to do this with (see [Products](https://commerce.liferay.dev/user-guide/-/knowledge_base/user/products) for help).
   
   From there, navigate to _Configuration_. On this screen, under the _Low Stock Action_ dropdown, the new activity ("Add a warning message") will be present.

(Deployed Sample Image Placeholder)

Next, let's dive deeper to learn more.

## Walk Through the Example

In this section, we will take a more in-depth review of the example we deployed. First, we will annotate the class for OSGi registration; second we will implement the `CommerceLowStockActivity` interface; and third, we will implement the low stock activity logic.

### Annotate Your Class for OSGi Registration

```java
@Component(
    immediate = true,
    property = {
        "commerce.low.stock.activity.key=" + ExampleLowStockActivity.KEY,
        "commerce.low.stock.activity.priority:Integer=9"
    },
    service = CommerceLowStockActivity.class
)
public class ExampleLowStockActivity implements CommerceLowStockActivity {
    
    public static final String KEY = "example";
```


> It is important to provide a distinct key for your payment method so that Liferay Commerce can distinguish your new low stock activity from others in the [low stock activity registry](https://raw.githubusercontent.com/liferay/com-liferay-commerce/7.1.x/commerce-api/src/main/java/com/liferay/commerce/stock/activity/CommerceLowStockActivityRegistry.java). Reusing a key that is already in use will override the existing associated activity.

### Implement the `CommerceLowStockActivity` Interface

The following three methods are required:

```java
public void execute(CPInstance cpInstance) throws PortalException;
```

```java
public String getKey();
```

```java
public String getLabel(Locale locale);
```

To better understand each of the required methods mentioned above, let's look at [example class]. We will review the implementation of each required method in sequence.

1. `public void execute(CPInstance cpInstance) throws PortalException;`

    ```java
    @Override
    public void execute(CPInstance cpInstance) throws PortalException {
        // ...
    }
    ```
    
    > This method will be where the business logic is implemented for the custom activity.

1. `public String getKey();`

    ```java
    @Override
    public String getKey() {
        return KEY;
    }
    ```
    
    > This provides a unique identifier for the low stock activity in the registry. The key can be used to fetch the low stock activity from the registry programmatically if necessary. Reusing a key that is already in use will override the existing associated activity.

1. `public String getLabel(Locale locale);`

    ```java
    @Overridea
    public String getLabel(Locale locale) {
        return LanguageUtil.get(locale, "add-a-warning-message");
    }
    ```
    
    > This returns a text label used to describe the low stock activity. Note that, for this to work correctly using `LanguageUtil`, we will need to add the language key ourselves. For more information, see [Localizing Your Application](https://help.liferay.com/hc/en-us/articles/360018168251-Localizing-Your-Application).

### Create Your Low Stock Activity

To implement the low stock activity itself, we only need to add our business logic to the `execute()` method of our class. In our simple example, we will simply add a warning message that is added to Liferay's logs.

`public void execute(CPInstance cpInstance)`

```java
    @Override
    public void execute(CPInstance cpInstance) throws PortalException {
        if (_log.isWarnEnabled()) {
            _log.warn("Low stock for SKU: " + cpInstance.getSku());
        }
    }
```

> The `cpInstance` object contains information about the item with low stock, that we can use. In our example, we are just using it to get the SKU for the item to add to our warning message. To find more methods you can use with a `CPInstance`, see [CPInstance](https://raw.githubusercontent.com/liferay/com-liferay-commerce/7.1.x/commerce-product-api/src/main/java/com/liferay/commerce/product/model/CPInstance.java) and [CPInstanceModel](https://raw.githubusercontent.com/liferay/com-liferay-commerce/7.1.x/commerce-product-api/src/main/java/com/liferay/commerce/product/model/CPInstanceModel.java).

We will also need to add the language key for our activity's label. Add the key and its value to a `Language.properties` file within our module:

```java
add-a-warning-message=Add a Warning Message
```

## Conclusion

Congratulations! You now know the basics for implementing the `CommerceLowStockActivity` interface and have added a low stock activity to Liferay Commerce.

## Additional Information
[Localizing Your Application](https://help.liferay.com/hc/en-us/articles/360018168251-Localizing-Your-Application)
[Products](https://commerce.liferay.dev/user-guide/-/knowledge_base/user/products)