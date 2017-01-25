package lee.rpc.server.main;

import lee.rpc.server.socket.RpcExporter;

public class RpcServerMain {
    public static void main(String[] args) throws Exception {
        System.out.println("服务器已启动。。。");
        RpcExporter.exporter("127.0.0.1", 8080);
    }
}
