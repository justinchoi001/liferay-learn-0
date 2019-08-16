# Implementing a Custom Product Content Renderer

This tutorial will show you how to add a custom product content renderer by implementing the `CPContentRenderer` interface.

A product content renderer provides a style of displaying product details for a specific [product type](../../../user-guide/catalog/creating-and-managing-products/product-types/introduction-to-product-types/README.md), in a variety of widgets that can display products. Liferay Commerce provides product content renderers for each out of the box product type, such as [SimpleCPContentRenderer](https://github.com/liferay/com-liferay-commerce/blob/2.0.4/commerce-product-type-simple/src/main/java/com/liferay/commerce/product/type/simple/internal/SimpleCPContentRenderer.java) for Simple products.

![Out of the box product content renderers](./images/01.png "Out of the box product content renderers")

## Overview

1. **Deploy an Example**
1. **Walk Through the Example**
1. **Additional Information**

## Deploy an Example

In this section, we will get an example product content renderer up and running on your instance of Liferay Commerce. Follow these steps:

1. Start Liferay Commerce.

    ```bash
    docker run -it -p 8080:8080 liferay/commerce:2.0.4
    ```

1. Download and unzip [Acme Commerce Product Content Renderer](./liferay-q4f7.zip).

    ```bash
    curl liferay-q4f7.zip
    ```

    ```bash
    unzip liferay-q4f7.zip
    ```

1. Go to `q4f7-impl`.

    ```bash
    cd q4f7-impl
    ```

1. Build and deploy the example.

    ```bash
    ./gradlew deploy -Ddeploy.docker.container.id=$(docker ps -lq)
    ```

    >Note: This command is the same as copying the deployed jars to /opt/liferay/osgi/modules on the Docker container.

1. Confirm the deployment in the Liferay Docker container console.

    ```bash
    STARTED com.acme.q4f7.impl_1.0.0
    ```

1. Verify that the example product content renderer was added. Open your browser to `https://localhost:8080` and navigate to any catalog with products in Liferay Commerce. Click on the product to see the Product Details widget, then click _Configuration_ for the widget.

    Under the _Custom Renderer_ section, select _Simple_. Below the _Simple Commerce Product Type Renderer Key_ dropdown, the new renderer ("Example") will be present.

![New product content renderer](./images/02.png "New product content renderer")

Congratulations, you've successfully built and deployed a new custom product content renderer that implements `CPContentRenderer`.

Next, let's dive deeper to learn more.

## Walk Through the Example

In this section, we will take a more in-depth review of the example we deployed. First, we will annotate the class for OSGi registration; second we will implement the `CPContentRenderer` interface; and third, we will implement the rendering logic and create our custom view in a JSP.

### Annotate the Class for OSGi Registration

```java
@Component(
    immediate = true,
    property = {
        "commerce.product.content.renderer.key=" + Q4F7CPContentRenderer.KEY,
        "commerce.product.content.renderer.order=" + 1,
        "commerce.product.content.renderer.type=" + SimpleCPTypeConstants.NAME
    },
    service = CPContentRenderer.class
)
public class Q4F7CPContentRenderer implements CPContentRenderer {

    public static final String KEY = "Example";
```

> It is important to provide a distinct key for our product content renderer so that Liferay Commerce can distinguish the new renderer from others in the [product content renderer registry](https://github.com/liferay/com-liferay-commerce/blob/2.0.4/commerce-product-content-web/src/main/java/com/liferay/commerce/product/content/web/internal/render/CPContentRendererRegistryImpl.java). Reusing a key that is already in use will override the existing associated renderer.
>
> The `order` property determines the ordering of renderers in the UI, from lowest to highest value. For example, the [SimpleCPContentRenderer](https://github.com/liferay/com-liferay-commerce/blob/2.0.4/commerce-product-type-simple/src/main/java/com/liferay/commerce/product/type/simple/internal/SimpleCPContentRenderer.java) has this property set to the minimum integer value, so other renderers for Simple type products will appear after it in the list.
>
> The `type` property determines what type of product this renderer can be used for. In our example, we use a Simple type, so the renderer will appear under the Simple category in the UI.

### Implement the `CPContentRenderer` Interface

The following three methods are required:

```java
public String getKey();
```

```java
public String getLabel(Locale locale);
```

```java
public void render(
        CPCatalogEntry cpCatalogEntry,
        HttpServletRequest httpServletRequest,
        HttpServletResponse httpServletResponse)
    throws Exception;
```

To better understand each of the methods above, let's look at [Q4F7CPContentRenderer.java](./liferay-q4f7.zip/q4f7-impl/src/main/java/com/acme/q4f7/internal/commerce/product/content/renderer/Q4F7CPContentRenderer.java). We will review the implementation of each required method in sequence.

1. ```java
    @Override
    public String getKey() {
        return KEY;
    }
    ```

    > This method provides a unique identifier for the product content renderer in the registry. The key can be used to fetch the renderer from the registry programmatically. Reusing a key that is already in use will override the existing associated renderer.

1. ```java
    @Override
    public String getLabel(Locale locale) {
        ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
            "content.Language", locale, getClass());

        return LanguageUtil.get(resourceBundle, "example");
    }
    ```

    > This returns a text label used to display the name of the product content renderer. `ResourceBundleUtil` is a Liferay class that provides support for multiple locales.
    >
    > Note that, for this to work correctly using `LanguageUtil`, we will need to add the language key ourselves. For more information, see [Localizing Your Application](https://help.liferay.com/hc/en-us/articles/360018168251-Localizing-Your-Application).

1. ```java
    @Override
    public void render(
            CPCatalogEntry cpCatalogEntry,
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse)
        throws Exception {
    }
    ```

    > This is where we add the code to render a customized view for our product content renderer.

### Create the Renderer

To create the product content renderer itself we will implement the `render` method and add a custom view. There are several methods for defining a view: JSP, Freemarker template, or Soy template. In our example, we will use a JSP.

```java
@Override
public void render(
        CPCatalogEntry cpCatalogEntry,
        HttpServletRequest httpServletRequest,
        HttpServletResponse httpServletResponse)
    throws Exception {

    _jspRenderer.renderJSP(
        _servletContext, httpServletRequest, httpServletResponse,
        "/view.jsp");
}
```

> We use a `JSPRenderer` to render the JSP for our product content renderer (in this case, [view.jsp](./liferay-q4f7.zip/q4f7-impl/src/main/resources/META-INF/resources/view.jsp)). We also give it a `ServletContext` to allow it to find our JSP.

To allow the `ServletContext` to find the JSP in our module, we define it using the symbolic name of our bundle:

```java
@Reference(
    target = "(osgi.web.symbolicname=com.acme.q4f7.impl)"
)
private ServletContext _servletContext;
```

> The value we have set here for `osgi.web.symbolicname` matches the value for `Bundle-SymbolicName` in [bnd.bnd](./liferay-q4f7.zip/q4f7-impl/bnd.bnd). These values must match for the `ServletContext` to look in the proper location for the JSP.
>
> Note that, for the `ServletContext` to be properly generated, we also declare a unique value for `Web-ContextPath` in our bnd.bnd file. In our example, we have that set to `/commerce-product-content-renderer`. For a reference on these values, see [bnd.bnd](./liferay-q4f7.zip/q4f7-impl/bnd.bnd).

Lastly, define the language key for our new product content renderer's label. Add the key and its value to a [Language.properties](./liferay-q4f7.zip/q4f7-impl/src/main/resources/content/Language.properties) file within our module:

```
example=Example
```

### Create the Custom View

The last step to create our product content renderer is to define the custom view. In our example, we will use a JSP for this step, [view.jsp](./liferay-q4f7.zip/q4f7-impl/src/main/resources/META-INF/resources/view.jsp).

```jsp
<%
CPContentHelper cpContentHelper = (CPContentHelper)request.getAttribute(CPContentWebKeys.CP_CONTENT_HELPER);

CPCatalogEntry cpCatalogEntry = cpContentHelper.getCPCatalogEntry(request);

CPSku cpSku = cpContentHelper.getDefaultCPSku(cpCatalogEntry);

long cpDefinitionId = cpCatalogEntry.getCPDefinitionId();
%>
```

> [CPContentHelper](https://github.com/liferay/com-liferay-commerce/blob/2.0.4/commerce-product-content-web/src/main/java/com/liferay/commerce/product/content/web/internal/util/CPContentHelperImpl.java) is a class that retrieves information about a particular product.
>
> [CPCatalogEntry](https://github.com/liferay/com-liferay-commerce/blob/2.0.4/commerce-product-api/src/main/java/com/liferay/commerce/product/catalog/CPCatalogEntry.java) represents the displayed product itself. To get more information, we also use the default SKU for the product, contained in [CPSku](https://github.com/liferay/com-liferay-commerce/blob/2.0.4/commerce-product-service/src/main/java/com/liferay/commerce/product/internal/catalog/CPSkuImpl.java).

```jsp
<h1><%= "Example Product Renderer" %></h1>

<c:if test="<%= cpSku != null %>">
    <h3><%= "SKU: " + cpSku.getSku() %></h3>

    <h3><%= "Price: " + cpSku.getPrice().toString() %></h3>

    <h3><%= "Availability: " + cpContentHelper.getAvailabilityLabel(request) %></h3>

    <h3><%= "Stock Quantity: " + cpContentHelper.getStockQuantityLabel(request) %></h3>
</c:if>

<liferay-util:dynamic-include key="com.liferay.commerce.product.content.web#/add_to_cart#" />
```

> For our example, we use basic HTML headers to display the information for the product's SKU.
>
> Note that we use Liferay Commerce's [add_to_cart_button.jsp](https://github.com/liferay/com-liferay-commerce/blob/2.0.4/commerce-cart-content-web/src/main/resources/META-INF/resources/dynamic_include/add_to_cart_button.jsp) to add this functionality to our view.

## Conclusion

Congratulations! You now know the basics for implementing the `CPContentRenderer` interface, and have added a new product content renderer to Liferay Commerce.

## Additional Information

* [Localizing Your Application](https://help.liferay.com/hc/en-us/articles/360018168251-Localizing-Your-Application)
