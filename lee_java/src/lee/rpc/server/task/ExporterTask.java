package lee.rpc.server.task;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

public class ExporterTask implements Runnable {

    private Socket client = null;

    public ExporterTask(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {

        ObjectInputStream input = null;
        ObjectOutputStream output = null;
        try {
            input = new ObjectInputStream(client.getInputStream());

            // 读取 UTF-8 修改版格式的 String。
            String interfaceName = input.readUTF();
            // 返回与带有给定字符串名的类或接口相关联的 Class 对象。
            Class<?> service = Class.forName(interfaceName);

            String methodName = input.readUTF();
            // 从 ObjectInputStream 读取对象。
            Class<?>[] parameterTypes = (Class<?>[]) input.readObject();

            Object[] arguments = (Object[]) input.readObject();
            Method method = service.getMethod(methodName, parameterTypes);

            Object result = method.invoke(service.newInstance(), arguments);
            output = new ObjectOutputStream(client.getOutputStream());
            output.writeObject(result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (client != null) {
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
