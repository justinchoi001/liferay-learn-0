# Overview of the DXP Cloud Development Workflow

This article outlines the path developers will take when deploying their changes to their instances on DXP Cloud. Although there are multiple paths for deploying to an environment, all paths begin with adding changes to the repository.

**Contents:**

* [Adding Changes to the Repository](#adding-changes-to-the-repository)
* [CI Testing](#ci-testing)
* [Deploying Services](#deploying-services)

## Adding Changes to the Repository

The Git repository is used as the basis for any custom additions to your provision of DXP Cloud, including Liferay DXP itself. The repository can be used both as a workspace for you to build modules in, as well as a place to add other files to add to the services in DXP Cloud. This allows you to use the repository as your starting point with versioning control for managing any developing with DXP Cloud. See [Configuring Your GitHub Repository](./03-configuring-your-github-repository) for more information on setting up the workspace on your local system.

Note that, depending on the environment you choose to deploy to, additions present in some folders will not apply to that environment; for example, additions in a `dev` folder (like `lcp/liferay/config/dev/`) will only be applied if the `dev` environment is chosen. Changes in a `common/` folder will always be applied to the chosen environment.

### Code Additions

The source for new code additions must be added into folders at the root of the repository: the `modules` folder for new modules, the `themes` folder for custom themes, and the `wars` folder for exploded WARs. When the build is deployed, code changes added to any of these locations will be automatically built and then added to the Liferay service.

### Compiled Additions

Compiled additions like pre-built JARs or LPKGs may be added into a `deploy` directory for the correct service. When the build is deployed to an environment, these files will be copied into the correct folder within `$LIFERAY_HOME` (depending on the type of file). For example, adding a JAR file to `lcp/liferay/deploy/common/` will cause the file to be copied to `$LIFERAY_HOME/osgi/modules/` for any environment the build is deployed to.

### Configuration Files

Configuration files (portal properties or OSGi configuration files) may be added into a `config` directory for the correct service. When the build is deployed to an environment, these files will be copied to the correct location within `$LIFERAY_HOME`. Portal properties files will be copied directly inside of `$LIFERAY_HOME`, whereas `.cfg` or `.config` files will be copied into `$LIFERAY_HOME/osgi/configs/`.

## CI Testing

By default, CI will automatically run tests for any of the following: a build directly pushed to the repository, pull requests with changes sent or merged into the repository, and a build deployed using the Command Line Interface. Any of these will automatically invoke testing these changes using the `CI` service in the `infra` environment.

Navigate to the `Builds` tab to see all builds that have been initiated. You can see from this screen whether the builds are pending, or if they have passed or failed. If the build passes CI testing, then the Cloud console will offer the option in the UI to deploy that build to any applicable environment.

## Deploying Services

There are two main ways to deploy to a Liferay instance on DXP: deploying through the Command Line Interface, or deploying a successful build from the `Builds` tab in the DXP Cloud console.

### Option 1: Deploying Through the Command Line Interface

The quickest way to deploy services from a repository locally is by using the Command Line Interface (CLI). See [Using the Command Line Interface](../10-reference/03-command-line-tool.markdown) for more information on setting up the CLI.

After logging in through CLI, simply use `lcp deploy` to deploy any additions present in the repository. The CLI will prompt you to choose one of the environments to deploy to (`dev`, `uat`, or `prd`). You must have permissions to deploy to the chosen environment for the deployment to be successful.

### Option 2: Deploying From `Builds` in DXP Cloud

Another way to deploy changes is to use a completed build in CI from the DXP Cloud console.

Committed changes to the repository will automatically start a new round of testing in CI any time a pull request is sent or merged. This allows builds to be deployed to a testing environment at any point of the review process.

# Additional Information

* [Configuring Your GitHub Repository]()
* [Environments](../05-build-and-deploy/02-environments.md)
* [Using the Command Line Interface]()
* [Walking Through the Development Life Cycle](./06-walking-through-the-development-life-cycle.md)