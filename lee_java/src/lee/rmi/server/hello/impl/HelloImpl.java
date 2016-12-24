package lee.rmi.server.hello.impl;

import lee.rmi.server.hello.Hello;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author Lee
 * @since 2016/12/22
 */
public class HelloImpl extends UnicastRemoteObject implements Hello {

    public HelloImpl() throws RemoteException {
    }

    @Override
    public String sayHello(String name) throws RemoteException {
        System.out.println(name + "连接了服务器。");
        return "Hello " + name;
    }
}
