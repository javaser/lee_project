package lee.rpc.server.socket;

import lee.rpc.server.task.ExporterTask;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class RpcExporter {
    static Executor executor = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors());
    static long count = 0;

    public static void exporter(String host, int port) throws Exception {
        ServerSocket server = new ServerSocket();
        server.bind(new InetSocketAddress(host, port));
        try {
            while (true) {
                Socket socket = server.accept();
                System.out.println("第 " + ++count + " 客户端连接");
                ExporterTask exporterTask = new ExporterTask(socket);
                executor.execute(exporterTask);
//                new Thread(exporterTask).start();
            }
        } finally {
            server.close();
        }
    }
}
