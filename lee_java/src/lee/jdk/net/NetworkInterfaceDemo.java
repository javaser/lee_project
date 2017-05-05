package lee.jdk.net;

import java.net.*;
import java.util.Enumeration;

/**
 * @author Lee
 * @since 2017/5/5
 */
public class NetworkInterfaceDemo {

    public static void info(String[] args) {
        try {
            Enumeration<NetworkInterface> interfaceList =
                    NetworkInterface.getNetworkInterfaces();
            if (interfaceList == null) {
                System.out.println("--No interfaces found--");
            } else {
                while (interfaceList.hasMoreElements()) {
                    NetworkInterface iface = interfaceList.nextElement();
                    System.out.println("Interface " + iface.getName() + ":");
                    Enumeration<InetAddress> addrList = iface.getInetAddresses();

                    if (!addrList.hasMoreElements()) {
                        System.out.println("\t(No addresses for this interface)");
                    }
                    while (addrList.hasMoreElements()) {
                        InetAddress address = addrList.nextElement();
                        System.out.print("\tAddress "
                                + ((address instanceof Inet4Address) ? "(v4)"
                                : (address instanceof Inet6Address ? "(v6)"
                                : "(?)")));
                        System.out.println(": " + address.getHostAddress());
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }

        for (String host : args) {
            try {
                System.out.println(host + ":");
                InetAddress[] addresssList = InetAddress.getAllByName(host);
                for (InetAddress address : addresssList) {
                    System.out.println("\t" + address.getHostName()
                            + "/" + address.getHostAddress());
                }
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        info(args);
    }
}
