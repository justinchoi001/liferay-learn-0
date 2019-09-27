---
header-id: team-collaboration-access-control
---

# Team Collaboration & Access Control

This article documents how to manage teams members and roles for a DXP Cloud project. Administrators can invite members and assign member roles _per environment_ (dev, infra, UAT or prod). It is possible for a person to have different roles in different environments.

## Managing Team Members

To add a new member:

1. Click on _Team_ in the left tab.
1. Enter the new member's email in the *Email* field.
1. Select a role from the the *Role* dropdown menu to be assigned to the user.
1. Click *Send Invite*.

Roles determine the user's access level in the project. For more information, see [Defining Team Roles](#defining-team-roles).

![Figure 1: The Team tab](./team-collaboration-and-access-control/images/01.png)

Current and invited team members appear in the _Members_ table. To manage team members, click the _Actions_ button.

![Figure 2: Use the Actions button to manage each team member.](./team-collaboration-and-access-control/images/02.png)

## Defining Team Roles

**Admin:** Has full control over the DXP Cloud project and its members. They have exclusive permissions to:

* Enable/disable auto scaling
* Manually downscale a service
* Restore from a backup
* Change user roles
* Invite members to the project
* Remove members from the project
* Enable/disable support access
* Delete a service

**Contributor:** Can handle application management and most of the development life cycle, but can not manage team members or perform other Admin-exclusive actions. Permissions include:

* Start a backup
* Change VPN settings
* Restart a service
* Deploy a build
* Remove themselves from the project

**Guest:** Has view-only access. Guests can see what is happening in the project but can not perform actions or make any changes. They only have permission to remove themselves from the project.
