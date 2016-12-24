package lee.rmi.server.hello;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author Lee
 * @since 2016/12/22
 */
public interface Hello extends Remote {
    public String sayHello(String name) throws RemoteException;
}
