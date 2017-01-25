package lee.rpc.server.echo.impl;

import lee.rpc.server.echo.EchoService;

public class EchoServiceImpl implements EchoService {

    @Override
    public String echo(String ping) {
        return ping != null ? ping + " ---> I'm OK" : "Not good";
    }
}
