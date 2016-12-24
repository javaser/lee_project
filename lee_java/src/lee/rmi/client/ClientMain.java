package lee.rmi.client;

import lee.rmi.server.hello.Hello;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * @author Lee
 * @since 2016/12/22
 */
public class ClientMain {
    public static void main(String[] args) {
        try {
            Hello hello = (Hello) Naming.lookup("rmi://127.0.0.1:8888/Hello");
            System.out.println(hello.sayHello("Tom"));
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
