package lee.rpc.client.main;

import lee.rpc.client.socket.RpcImporter;
import lee.rpc.server.echo.EchoService;
import lee.rpc.server.echo.impl.EchoServiceImpl;

import java.net.InetSocketAddress;

public class RpcMain {
    public static void main(String[] args) throws Exception {
        System.out.println("客户端已启动。。。");

        RpcImporter<EchoService> importer = new RpcImporter<>();
        EchoService echo = importer.importer(EchoServiceImpl.class,
                new InetSocketAddress("localhost", 8080));
        System.out.println(echo.echo("Are you ok?"));
    }
}
