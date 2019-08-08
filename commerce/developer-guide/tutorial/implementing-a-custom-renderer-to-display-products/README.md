# Implementing a Custom Product Content Renderer

This tutorial will show you how to add a custom product content renderer by implementing the `CPContentRenderer` interface.

A product content renderer provides a style of displaying product details for a specific product type, in a variety of portlets that can display products. Liferay Commerce provides several product content renderers out of the box, including at least one for each default product type, such as the [SimpleCPContentRenderer](https://github.com/liferay/com-liferay-commerce/blob/2.0.2/commerce-product-type-simple/src/main/java/com/liferay/commerce/product/type/simple/internal/SimpleCPContentRenderer.java) for simple products.

![Out of the box product content renderers](./images/01.png "Out of the box product content renderers")

## Overview

1. **Deploy an Example**
1. **Walk Through the Example**
1. **Additional Information**

## Deploy an Example

In this section, we will get an example product content renderer up and running on your instance of Liferay Commerce. Follow these steps:

1. Start Liferay Commerce.

    ```bash
    docker run -it -p 8080:8080 liferay/commerce:2.0.2
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
    STARTED com.acme.q4f7.internal.commerce.product.content.renderer_1.0.0
    ```

1. Verify that the example product content renderer was added. Open your browser to `https://localhost:8080` and navigate to any catalog with products in Liferay Commerce. Click on the product to see the product details portlet, then click _Configuration_ for the portlet.

    From the portlet configuration, under the _Custom Renderer_ section, make sure "Simple" is selected. Under the "SIMPLE COMMERCE PRODUCT TYPE RENDERER KEY" dropdown, the new renderer ("Example") will be present.

![New product content renderer](./images/02.png "New product content renderer")

Congratulations, you've successfully built and deployed a new low stock activity that implements `CPContentRenderer`.

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

> It is important to provide a distinct key for our product content renderer so that Liferay Commerce can distinguish the new renderer from others in the [product content renderer registry](https://github.com/liferay/com-liferay-commerce/blob/2.0.2/commerce-product-content-web/src/main/java/com/liferay/commerce/product/content/web/internal/render/CPContentRendererRegistryImpl.java). Reusing a key that is already in use will override the existing associated renderer.
>
> The `order` property determines where in the list of similar renderers this renderer will appear in the UI; for example, the [SimpleCPContentRenderer](https://github.com/liferay/com-liferay-commerce/blob/2.0.2/commerce-product-type-simple/src/main/java/com/liferay/commerce/product/type/simple/internal/SimpleCPContentRenderer.java) has this property set to the minimum integer value, so any other "Simple" type renderers will appear after it in the list.
>
> The `type` property decides what type of product this renderer can be used for. In our example, we use a "Simple" type, so the renderer will only appear under the Simple category in the UI.

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

1. `public String getKey();`

    ```java
    @Override
    public String getKey() {
        return KEY;
    }
    ```
    
    > This method provides a unique identifier for the product content renderer in the registry. The key can be used to fetch the renderer from the registry programmatically. Reusing a key that is already in use will override the existing associated renderer.

1. `public String getLabel(Locale locale);`

    ```java
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

1. `public void render(CPCatalogEntry cpCatalogentry, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception;`

    ```java
    @Override
    public void render(
            CPCatalogEntry cpCatalogEntry,
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse)
        throws Exception {
    }
    ```
    
    > This will be where we add the code to render a customized view for our product content renderer.

### Create the Renderer

To create the product content renderer itself, we need to implement the `render` method, and then add a custom view.

Note that there are several options to define the view, including using a JSP, Freemarker template, or Soy template. In our simple example, we will use a JSP.

`public void render(CPCatalogEntry cpCatalogentry, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception`

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

> We use a `JSPRenderer` to render the JSP for our product content renderer (in this case, [view.jsp](./liferay-q4f7.zip/q4f7-impl/src/main/resources/META-INF/resources/view.jsp)). We also give it a `ServletContext` to give a context for where to find our JSP.

For the JSP to be able to properly use the `ServletContext` to find the JSP in our module, we need to define it using the correct symbolic name of our bundle, like the following:

```java
@Reference(
    target = "(osgi.web.symbolicname=com.acme.q4f7.internal.commerce.product.content.renderer)"
)
private ServletContext _servletContext;
```

> The value we have set here for `osgi.web.symbolicname` matches the value for `Bundle-SymbolicName` in our [bnd.bnd file](./liferay-q4f7.zip/q4f7-impl/bnd.bnd). These values must match for the `ServletContext` to look in the proper location for the JSP.
>
> Note that, for the `ServletContext` to be properly generated, we also need to declare a unique value for `Web-ContextPath` in our bnd.bnd file. In our example, we have that set to `/commerce-product-content-renderer`. For a reference on these values, see [bnd.bnd](./liferay-q4f7.zip/q4f7-impl/bnd.bnd).

Lastly, define the language key for our new product content renderer's label. Add the key and its value to a [Language.properties](./liferay-q4f7.zip/q4f7-impl/src/main/resources/content/Language.properties) file within our module:

```
example=Example
```

### Create the Custom View

Defining our product content renderer's custom view is the biggest step of creating our custom renderer. In our example, we will be using a JSP, which you can see at [view.jsp](./liferay-q4f7.zip/q4f7-impl/src/main/resources/META-INF/resources/view.jsp).








While there are unlimited ways to define the view for the renderer, there are some basic elements most product content renderers should have. Let's walk through the basic features we will want for our renderer in our JSP.

```jsp
<%
CPContentHelper cpContentHelper = (CPContentHelper)request.getAttribute(CPContentWebKeys.CP_CONTENT_HELPER);

CPCatalogEntry cpCatalogEntry = cpContentHelper.getCPCatalogEntry(request);

CPSku cpSku = cpContentHelper.getDefaultCPSku(cpCatalogEntry);
%>
```

> These are some objects we can use to help us get the information for our view.
>
> [CPContentHelper](https://github.com/liferay/com-liferay-commerce/blob/2.0.2/commerce-product-content-web/src/main/java/com/liferay/commerce/product/content/web/internal/util/CPContentHelperImpl.java) is a class that can help to retrieve all kinds of information about a particular product.
>
> [CPCatalogEntry](https://github.com/liferay/com-liferay-commerce/blob/2.0.2/commerce-product-api/src/main/java/com/liferay/commerce/product/catalog/CPCatalogEntry.java) will represent the displayed product itself, and to get more information, we also use the default SKU for the product, contained in a [CPSKU](https://github.com/liferay/com-liferay-commerce/blob/2.0.2/commerce-product-service/src/main/java/com/liferay/commerce/product/internal/catalog/CPSkuImpl.java). 

```jsp
<div class="col-lg-10 col-md-9 col-xs-10 full-image">
    <c:if test="<%= Validator.isNotNull(cpCatalogEntry.getDefaultImageFileUrl()) %>">
        <img class="center-block img-responsive" id="<portlet:namespace />full-image" src="<%= cpCatalogEntry.getDefaultImageFileUrl() %>" />
    </c:if>
</div>
```

> To display the full image for the selected product, we get the URL for the image from our [CPCatalogEntry](https://github.com/liferay/com-liferay-commerce/blob/2.0.2/commerce-product-api/src/main/java/com/liferay/commerce/product/catalog/CPCatalogEntry.java), and then use it as a parameter in the `img` tag. {Placeholder: explain anything more about the image? The class? The div?}

```jsp
<h1><%= HtmlUtil.escape(cpCatalogEntry.getName()) %></h1>

    <c:choose>
        <c:when test="<%= cpSku != null %>">
            <h4 class="sku"><%= HtmlUtil.escape(cpSku.getSku()) %></h4>

            <div class="price"><liferay-commerce:price CPDefinitionId="<%= cpDefinitionId %>" CPInstanceId="<%= cpSku.getCPInstanceId() %>" /></div>

            <div class="subscription-info"><liferay-commerce:subscription-info CPInstanceId="<%= cpSku.getCPInstanceId() %>" /></div>

            <div class="availability"><%= cpContentHelper.getAvailabilityLabel(request) %></div>

            <div class="availabilityEstimate"><%= cpContentHelper.getAvailabilityEstimateLabel(request) %></div>

            <div class="stockQuantity"><%= cpContentHelper.getStockQuantityLabel(request) %></div>
        </c:when>
        <c:otherwise>
            ...
        </c:otherwise>
```

> These are some of the basic details about the displayed product that we want to include in our view; this includes the product name, and if possible, the default SKU and several more details about it. In this example, we are using pre-defined div classes to render this product information. {Placeholder: explain anything else about the divs, classes, tags, or  other implementation details?}

```jsp
{Placeholder for main implementation}
```

> We will want to have elements in place to allow a customer to select a quantity and add the product to the cart. {Placeholder: Explain these elements with a bit more detail}

Lastly, define the language key for our engine's name and description. Add the key and its value to a [Language.properties](./liferay-j6x8.zip/j6x8-impl/src/main/resources/content/Language.properties) file within our module:

```
example=Example
```

## Conclusion

Congratulations! You now know the basics for implementing the `CPContentRenderer` interface, and have added a new product content renderer to Liferay Commerce.

## Additional Information

* [Localizing Your Application](https://help.liferay.com/hc/en-us/articles/360018168251-Localizing-Your-Application)
