---
header-id: vpn-connection
---

# VPN Connection

This article documents how to use DXP Cloud's VPN feature to connect DXP Cloud to services on private networks.

## Connecting to a VPN

While logged into the DXP Cloud Management Console:

1. Navigate to an environment's *Settings* tab.
1. In the _VPN_ section, enter the following:
    * **VPN Type**: OpenVPN
    * **Server Address**: (server address)
    * **Account Name**: (administrator's email address)
    * **Password**: (administrator's password)
    * **Certificate**: (Certificate code)
    * **Forwarding IP**: (IP address)
    * **Forwarding Port**: (port number)
    * **Local Hostname**: (VPN)
    * **Local Port**: (local port number)
1. Click _Connect VPN_.

![Figure 1: You can connect to a VPN from the Settings tab.](../../images/vpn-connection.png)

To disconnect a service from a VPN after it is connected, click the *Disconnect* button.

## Port Configuration

Once connected to a VPN, there is an option to choose which ports to forward requests to.

1. On the same page, click *Add VPN Port*.
1. Enter the local hostname and port for DXP Cloud.
1. Enter the forwarding hostname and port for the VPN.
1. Click *Add Port*.

To remove a port, click *Delete* button for the corresponding port.

![Figure 2: You can also configure port forwarding.](../../images/vpn-ports.png)
