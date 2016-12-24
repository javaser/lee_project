package lee.rmi.server;

import lee.rmi.server.hello.Hello;
import lee.rmi.server.hello.impl.HelloImpl;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * @author Lee
 * @since 2016/12/22
 */
public class ServerMain {

    public static void main(String[] args) {
        try {
            System.out.println("RMI 服务已启用，等待客户请求。。。");
            LocateRegistry.createRegistry(8888);
            Hello hello = new HelloImpl();
            Naming.bind("rmi://127.0.0.1:8888/Hello", hello);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
